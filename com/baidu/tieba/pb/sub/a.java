package com.baidu.tieba.pb.sub;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.style.TextAppearanceSpan;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.data.an;
import com.baidu.tieba.t;
import com.baidu.tieba.u;
import com.baidu.tieba.v;
import com.baidu.tieba.y;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class a extends BaseAdapter {
    protected Context b;
    protected View.OnClickListener d;
    protected ArrayList<an> a = null;
    protected View.OnClickListener c = null;
    protected int e = 0;
    protected boolean f = false;
    protected boolean g = false;
    protected boolean h = false;
    private boolean i = true;

    public a(Context context, View.OnClickListener onClickListener) {
        this.b = null;
        this.d = null;
        this.b = context;
        this.d = onClickListener;
    }

    public void a(boolean z) {
        this.i = z;
    }

    public int a(String str) {
        if (this.a == null) {
            return -1;
        }
        int size = this.a.size();
        for (int i = 0; i < size; i++) {
            if (this.a.get(i).d().equals(str)) {
                return i;
            }
        }
        return -1;
    }

    public void a(ArrayList<an> arrayList) {
        if (arrayList == null) {
            this.a = new ArrayList<>();
            return;
        }
        Iterator<an> it = arrayList.iterator();
        while (it.hasNext()) {
            an next = it.next();
            if (next != null && next.g() != null) {
                next.g().setPortrait(null);
            }
        }
        this.a = arrayList;
    }

    public void a(View.OnClickListener onClickListener) {
        this.c = onClickListener;
    }

    public void a(int i, boolean z) {
        this.e = i;
        this.f = z;
    }

    public void b(boolean z) {
        this.g = false;
    }

    public void c(boolean z) {
        this.h = z;
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
            view = a();
        }
        b bVar = (b) ((SparseArray) view.getTag()).get(u.tag_holder);
        if (getItem(i) != null) {
            a(bVar, (an) getItem(i), !(!this.h && i + 1 >= getCount()), i == 0);
        }
        return view;
    }

    public View a() {
        b bVar = new b(this);
        View a = com.baidu.adp.lib.e.b.a().a(this.b, v.new_sub_pb_list_item, null);
        bVar.a = a;
        bVar.b = (LinearLayout) a.findViewById(u.sub_pb_item_columnlayout);
        bVar.c = (TextView) a.findViewById(u.manage_btn);
        bVar.d = (TbRichTextView) a.findViewById(u.new_sub_pb_list_richText);
        bVar.d.setTextSize(TbConfig.getContentSizeOfLzl(this.b));
        if (TbadkApplication.m252getInst().getSkinType() == 1) {
            bVar.d.setTextColor(this.b.getResources().getColor(com.baidu.tieba.r.gray_night_3));
        } else {
            bVar.d.setTextColor(this.b.getResources().getColor(com.baidu.tieba.r.gray_day_3));
        }
        bVar.c.setOnClickListener(this.c);
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(u.tag_holder, bVar);
        a.setTag(sparseArray);
        return a;
    }

    public void a(b bVar, an anVar, boolean z, boolean z2) {
        boolean z3;
        boolean z4;
        boolean z5;
        com.baidu.tbadk.widget.richText.c cVar;
        TextAppearanceSpan textAppearanceSpan;
        if (bVar != null && anVar != null) {
            bVar.d.setPadding(0, 0, 0, 0);
            int skinType = TbadkApplication.m252getInst().getSkinType();
            if (anVar.g() != null) {
                String userName = anVar.g().getUserName();
                SparseArray sparseArray = (SparseArray) bVar.a.getTag();
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                    bVar.a.setTag(sparseArray);
                }
                sparseArray.put(u.tag_photo_username, userName);
                sparseArray.put(u.tag_clip_board, anVar);
                sparseArray.put(u.tag_is_subpb, true);
            }
            if (TbadkApplication.m252getInst().getSkinType() == 1) {
                bVar.d.setLinkTextColor(this.b.getResources().getColor(com.baidu.tieba.r.common_link_text_1));
            } else {
                bVar.d.setLinkTextColor(this.b.getResources().getColor(com.baidu.tieba.r.common_link_text));
            }
            com.baidu.tbadk.widget.richText.a h = anVar.h();
            if (h != null) {
                ArrayList<com.baidu.tbadk.widget.richText.c> a = h.a();
                if (a.size() > 0) {
                    com.baidu.tbadk.widget.richText.c cVar2 = a.get(a.size() - 1);
                    int a2 = cVar2.a();
                    String str = "";
                    if (a2 == 1) {
                        str = (a.size() <= 1 || a.get(a.size() + (-2)).a() == a2) ? "  " + ba.a(anVar.o_()) : ba.a(anVar.o_());
                        SpannableStringBuilder d = cVar2.d();
                        if (h.a) {
                            d.delete(d.length() - h.b, d.length());
                        }
                        d.append((CharSequence) str);
                        h.a = true;
                        h.b = str.length();
                        cVar = cVar2;
                    } else if (h.a) {
                        cVar = cVar2;
                    } else {
                        str = ba.a(anVar.o_());
                        com.baidu.tbadk.widget.richText.c cVar3 = new com.baidu.tbadk.widget.richText.c(1);
                        cVar3.a((CharSequence) str);
                        h.a = true;
                        h.b = str.length();
                        a.add(cVar3);
                        cVar = cVar3;
                    }
                    if (skinType == 1) {
                        textAppearanceSpan = new TextAppearanceSpan(this.b, y.subtext_1);
                    } else {
                        textAppearanceSpan = new TextAppearanceSpan(this.b, y.subtext);
                    }
                    SpannableStringBuilder d2 = cVar.d();
                    d2.setSpan(textAppearanceSpan, d2.length() - str.length(), d2.length(), 33);
                }
                bVar.d.setVoiceViewRes(v.voice_play_btn);
                bVar.d.setIsFromCDN(this.i);
                bVar.d.setText(anVar.h());
            }
            String userId = anVar.g().getUserId();
            if (this.e != 0) {
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
            } else if (this.f) {
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
                bVar.c.setVisibility(0);
                if (skinType == 1) {
                    bVar.c.setCompoundDrawablesWithIntrinsicBounds(t.icon_floor_manage_n_1, 0, 0, 0);
                } else {
                    bVar.c.setCompoundDrawablesWithIntrinsicBounds(t.icon_floor_manage_n, 0, 0, 0);
                }
            } else if (z4) {
                bVar.c.setVisibility(0);
                if (skinType == 1) {
                    bVar.c.setCompoundDrawablesWithIntrinsicBounds(t.icon_floor_delete_n_1, 0, 0, 0);
                } else {
                    bVar.c.setCompoundDrawablesWithIntrinsicBounds(t.icon_floor_delete_n, 0, 0, 0);
                }
            } else {
                bVar.c.setVisibility(8);
            }
            SparseArray sparseArray2 = (SparseArray) bVar.c.getTag();
            if (sparseArray2 == null) {
                sparseArray2 = new SparseArray();
                bVar.c.setTag(sparseArray2);
            }
            if (bVar.c.getVisibility() == 0) {
                sparseArray2.put(u.tag_manage_user_identity, Integer.valueOf(this.e));
            }
            if (z4) {
                sparseArray2.put(u.tag_del_post_is_self, Boolean.valueOf(z3));
                sparseArray2.put(u.tag_del_post_type, 2);
                sparseArray2.put(u.tag_del_post_id, anVar.d());
            } else {
                sparseArray2.put(u.tag_del_post_is_self, Boolean.valueOf(z3));
                sparseArray2.put(u.tag_del_post_type, 0);
                sparseArray2.put(u.tag_del_post_id, "");
            }
            if (z5) {
                sparseArray2.put(u.tag_forbid_user_name, anVar.g().getUserName());
            } else {
                sparseArray2.put(u.tag_forbid_user_name, "");
            }
        }
    }
}
