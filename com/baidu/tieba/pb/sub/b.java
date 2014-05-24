package com.baidu.tieba.pb.sub;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.style.TextAppearanceSpan;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.editortool.ab;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.data.ai;
import com.baidu.tieba.z;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class b extends BaseAdapter {
    protected Context b;
    protected ab c;
    protected View.OnClickListener e;
    protected ArrayList<ai> a = null;
    protected View.OnClickListener d = null;
    protected int f = 0;
    protected boolean g = false;
    protected boolean h = false;
    protected boolean i = false;
    private boolean j = true;

    public b(Context context, View.OnClickListener onClickListener) {
        this.b = null;
        this.c = null;
        this.e = null;
        this.b = context;
        this.c = new ab(this.b);
        this.c.f("pb");
        this.e = onClickListener;
    }

    public void a(boolean z) {
        this.j = z;
    }

    public int a(String str) {
        if (this.a == null) {
            return -1;
        }
        int size = this.a.size();
        for (int i = 0; i < size; i++) {
            if (this.a.get(i).l().equals(str)) {
                return i;
            }
        }
        return -1;
    }

    public ab a() {
        return this.c;
    }

    public void a(ArrayList<ai> arrayList) {
        this.a = arrayList;
    }

    public void a(View.OnClickListener onClickListener) {
        this.d = onClickListener;
    }

    public void a(int i, boolean z) {
        this.f = i;
        this.g = z;
    }

    public void b(boolean z) {
        this.h = false;
    }

    public void c(boolean z) {
        this.i = z;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.a == null) {
            return 0;
        }
        return this.a.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.a == null || i < 0 || i >= this.a.size()) {
            return null;
        }
        return this.a.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = b();
        }
        c cVar = (c) ((SparseArray) view.getTag()).get(com.baidu.tieba.v.tag_holder);
        if (getItem(i) != null) {
            a(cVar, (ai) getItem(i), !(!this.i && i + 1 >= getCount()), i == 0);
        }
        return view;
    }

    public View b() {
        c cVar = new c(this);
        View inflate = LayoutInflater.from(this.b).inflate(com.baidu.tieba.w.new_sub_pb_list_item, (ViewGroup) null);
        cVar.a = inflate;
        cVar.b = (LinearLayout) inflate.findViewById(com.baidu.tieba.v.sub_pb_item_columnlayout);
        cVar.c = (Button) inflate.findViewById(com.baidu.tieba.v.manage_btn);
        cVar.d = (TbRichTextView) inflate.findViewById(com.baidu.tieba.v.new_sub_pb_list_richText);
        cVar.d.setTextSize(TbConfig.getContentSizeOfLzl(this.b));
        if (TbadkApplication.m252getInst().getSkinType() == 1) {
            cVar.d.setTextColor(this.b.getResources().getColor(com.baidu.tieba.s.gray_night_3));
        } else {
            cVar.d.setTextColor(this.b.getResources().getColor(com.baidu.tieba.s.gray_day_3));
        }
        cVar.c.setOnClickListener(this.d);
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(com.baidu.tieba.v.tag_holder, cVar);
        inflate.setTag(sparseArray);
        return inflate;
    }

    public void a(c cVar, ai aiVar, boolean z, boolean z2) {
        boolean z3;
        boolean z4;
        boolean z5;
        com.baidu.tbadk.widget.richText.c cVar2;
        TextAppearanceSpan textAppearanceSpan;
        if (cVar != null && aiVar != null) {
            cVar.d.setPadding(0, 0, 0, 0);
            int skinType = TbadkApplication.m252getInst().getSkinType();
            if (aiVar.o() != null) {
                String userName = aiVar.o().getUserName();
                SparseArray sparseArray = (SparseArray) cVar.a.getTag();
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                    cVar.a.setTag(sparseArray);
                }
                sparseArray.put(com.baidu.tieba.v.tag_photo_username, userName);
                sparseArray.put(com.baidu.tieba.v.tag_clip_board, aiVar);
                sparseArray.put(com.baidu.tieba.v.tag_is_subpb, true);
            }
            if (TbadkApplication.m252getInst().getSkinType() == 1) {
                cVar.d.setLinkTextColor(this.b.getResources().getColor(com.baidu.tieba.s.common_link_text_1));
            } else {
                cVar.d.setLinkTextColor(this.b.getResources().getColor(com.baidu.tieba.s.common_link_text));
            }
            com.baidu.tbadk.widget.richText.a p = aiVar.p();
            if (p != null) {
                ArrayList<com.baidu.tbadk.widget.richText.c> a = p.a();
                if (a.size() > 0) {
                    com.baidu.tbadk.widget.richText.c cVar3 = a.get(a.size() - 1);
                    int a2 = cVar3.a();
                    String str = "";
                    if (a2 == 1) {
                        str = (a.size() <= 1 || a.get(a.size() + (-2)).a() == a2) ? "  " + be.a(aiVar.n()) : be.a(aiVar.n());
                        SpannableStringBuilder d = cVar3.d();
                        if (p.a) {
                            d.delete(d.length() - p.b, d.length());
                        }
                        d.append((CharSequence) str);
                        p.a = true;
                        p.b = str.length();
                        cVar2 = cVar3;
                    } else if (p.a) {
                        cVar2 = cVar3;
                    } else {
                        str = be.a(aiVar.n());
                        com.baidu.tbadk.widget.richText.c cVar4 = new com.baidu.tbadk.widget.richText.c(1);
                        cVar4.a((CharSequence) str);
                        p.a = true;
                        p.b = str.length();
                        a.add(cVar4);
                        cVar2 = cVar4;
                    }
                    if (skinType == 1) {
                        textAppearanceSpan = new TextAppearanceSpan(this.b, z.subtext_1);
                    } else {
                        textAppearanceSpan = new TextAppearanceSpan(this.b, z.subtext);
                    }
                    SpannableStringBuilder d2 = cVar2.d();
                    d2.setSpan(textAppearanceSpan, d2.length() - str.length(), d2.length(), 33);
                }
                cVar.d.setVoiceViewRes(com.baidu.tieba.w.voice_play_btn);
                cVar.d.setIsFromCDN(this.j);
                cVar.d.setText(aiVar.p());
            }
            String userId = aiVar.o().getUserId();
            if (this.f != 0) {
                boolean z6 = userId == null || !userId.equals(TbadkApplication.getCurrentAccount());
                if (userId == null || userId.equals("0") || userId.length() == 0) {
                    z3 = false;
                    z4 = true;
                    z5 = false;
                } else {
                    z3 = false;
                    z4 = true;
                    z5 = z6;
                }
            } else if (this.g) {
                z3 = false;
                z4 = true;
                z5 = false;
            } else if (userId == null || !userId.equals(TbadkApplication.getCurrentAccount())) {
                z3 = false;
                z4 = false;
                z5 = false;
            } else {
                z3 = true;
                z4 = true;
                z5 = false;
            }
            if (z4 && z5) {
                cVar.c.setVisibility(0);
                if (skinType == 1) {
                    cVar.c.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tieba.u.icon_floor_manage_n_1, 0, 0, 0);
                } else {
                    cVar.c.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tieba.u.icon_floor_manage_n, 0, 0, 0);
                }
            } else if (z4) {
                cVar.c.setVisibility(0);
                if (skinType == 1) {
                    cVar.c.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tieba.u.icon_floor_delete_n_1, 0, 0, 0);
                } else {
                    cVar.c.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tieba.u.icon_floor_delete_n, 0, 0, 0);
                }
            } else {
                cVar.c.setVisibility(8);
            }
            SparseArray sparseArray2 = (SparseArray) cVar.c.getTag();
            if (sparseArray2 == null) {
                sparseArray2 = new SparseArray();
                cVar.c.setTag(sparseArray2);
            }
            if (cVar.c.getVisibility() == 0) {
                sparseArray2.put(com.baidu.tieba.v.tag_manage_user_identity, Integer.valueOf(this.f));
            }
            if (z4) {
                sparseArray2.put(com.baidu.tieba.v.tag_del_post_is_self, Boolean.valueOf(z3));
                sparseArray2.put(com.baidu.tieba.v.tag_del_post_type, 2);
                sparseArray2.put(com.baidu.tieba.v.tag_del_post_id, aiVar.l());
            } else {
                sparseArray2.put(com.baidu.tieba.v.tag_del_post_is_self, Boolean.valueOf(z3));
                sparseArray2.put(com.baidu.tieba.v.tag_del_post_type, 0);
                sparseArray2.put(com.baidu.tieba.v.tag_del_post_id, "");
            }
            if (z5) {
                sparseArray2.put(com.baidu.tieba.v.tag_forbid_user_name, aiVar.o().getUserName());
            } else {
                sparseArray2.put(com.baidu.tieba.v.tag_forbid_user_name, "");
            }
        }
    }
}
