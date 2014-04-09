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
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.editortool.ab;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.data.ai;
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

    public b(Context context, View.OnClickListener onClickListener) {
        this.b = null;
        this.c = null;
        this.e = null;
        this.b = context;
        this.c = new ab(this.b);
        this.c.b("pb");
        this.e = onClickListener;
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

    public final ab a() {
        return this.c;
    }

    public final void a(ArrayList<ai> arrayList) {
        this.a = arrayList;
    }

    public final void a(View.OnClickListener onClickListener) {
        this.d = onClickListener;
    }

    public final void a(int i, boolean z) {
        this.f = i;
        this.g = z;
    }

    public final void b() {
        this.h = false;
    }

    public final void a(boolean z) {
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
            view = c();
        }
        c cVar = (c) ((SparseArray) view.getTag()).get(com.baidu.tieba.a.h.tag_holder);
        if (getItem(i) != null) {
            if (!this.i) {
                getCount();
            }
            a(cVar, (ai) getItem(i));
        }
        return view;
    }

    public final View c() {
        c cVar = new c(this);
        View inflate = LayoutInflater.from(this.b).inflate(com.baidu.tieba.a.i.new_sub_pb_list_item, (ViewGroup) null);
        cVar.a = inflate;
        cVar.b = (LinearLayout) inflate.findViewById(com.baidu.tieba.a.h.sub_pb_item_columnlayout);
        cVar.c = (Button) inflate.findViewById(com.baidu.tieba.a.h.manage_btn);
        cVar.d = (TbRichTextView) inflate.findViewById(com.baidu.tieba.a.h.new_sub_pb_list_richText);
        TbRichTextView tbRichTextView = cVar.d;
        com.baidu.tbadk.core.data.n.r();
        tbRichTextView.setTextSize(14.0f);
        if (TbadkApplication.j().l() == 1) {
            cVar.d.setTextColor(this.b.getResources().getColor(com.baidu.tieba.a.e.gray_night_3));
        } else {
            cVar.d.setTextColor(this.b.getResources().getColor(com.baidu.tieba.a.e.gray_day_3));
        }
        cVar.c.setOnClickListener(this.d);
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(com.baidu.tieba.a.h.tag_holder, cVar);
        inflate.setTag(sparseArray);
        return inflate;
    }

    public final void a(c cVar, ai aiVar) {
        boolean z;
        boolean z2;
        boolean z3;
        com.baidu.tbadk.widget.richText.c cVar2;
        TextAppearanceSpan textAppearanceSpan;
        if (cVar != null && aiVar != null) {
            cVar.d.setPadding(0, 0, 0, 0);
            int l = TbadkApplication.j().l();
            if (aiVar.g() != null) {
                String userName = aiVar.g().getUserName();
                SparseArray sparseArray = (SparseArray) cVar.a.getTag();
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                    cVar.a.setTag(sparseArray);
                }
                sparseArray.put(com.baidu.tieba.a.h.tag_photo_username, userName);
                sparseArray.put(com.baidu.tieba.a.h.tag_clip_board, aiVar);
                sparseArray.put(com.baidu.tieba.a.h.tag_is_subpb, true);
            }
            if (TbadkApplication.j().l() == 1) {
                cVar.d.setLinkTextColor(this.b.getResources().getColor(com.baidu.tieba.a.e.common_link_text_1));
            } else {
                cVar.d.setLinkTextColor(this.b.getResources().getColor(com.baidu.tieba.a.e.common_link_text));
            }
            com.baidu.tbadk.widget.richText.a h = aiVar.h();
            ArrayList<com.baidu.tbadk.widget.richText.c> a = h.a();
            if (a.size() > 0) {
                com.baidu.tbadk.widget.richText.c cVar3 = a.get(a.size() - 1);
                int a2 = cVar3.a();
                String str = "";
                if (a2 == 1) {
                    str = (a.size() <= 1 || a.get(a.size() + (-2)).a() == a2) ? "  " + bc.a(aiVar.f()) : bc.a(aiVar.f());
                    SpannableStringBuilder d = cVar3.d();
                    if (h.a) {
                        d.delete(d.length() - h.b, d.length());
                    }
                    d.append((CharSequence) str);
                    h.a = true;
                    h.b = str.length();
                    cVar2 = cVar3;
                } else if (h.a) {
                    cVar2 = cVar3;
                } else {
                    str = bc.a(aiVar.f());
                    com.baidu.tbadk.widget.richText.c cVar4 = new com.baidu.tbadk.widget.richText.c(1);
                    cVar4.a((CharSequence) str);
                    h.a = true;
                    h.b = str.length();
                    a.add(cVar4);
                    cVar2 = cVar4;
                }
                if (l == 1) {
                    textAppearanceSpan = new TextAppearanceSpan(this.b, com.baidu.tieba.a.l.subtext_1);
                } else {
                    textAppearanceSpan = new TextAppearanceSpan(this.b, com.baidu.tieba.a.l.subtext);
                }
                SpannableStringBuilder d2 = cVar2.d();
                d2.setSpan(textAppearanceSpan, d2.length() - str.length(), d2.length(), 33);
            }
            cVar.d.setVoiceViewRes(com.baidu.tieba.a.i.voice_play_btn);
            cVar.d.setText(aiVar.h());
            String userId = aiVar.g().getUserId();
            if (this.f != 0) {
                boolean z4 = userId == null || !userId.equals(TbadkApplication.E());
                if (userId == null || userId.equals("0") || userId.length() == 0) {
                    z = false;
                    z2 = true;
                    z3 = false;
                } else {
                    z = false;
                    z2 = true;
                    z3 = z4;
                }
            } else if (this.g) {
                z = false;
                z2 = true;
                z3 = false;
            } else if (userId == null || !userId.equals(TbadkApplication.E())) {
                z = false;
                z2 = false;
                z3 = false;
            } else {
                z = true;
                z2 = true;
                z3 = false;
            }
            if (z2 && z3) {
                cVar.c.setVisibility(0);
                if (l == 1) {
                    cVar.c.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tieba.a.g.icon_floor_manage_n_1, 0, 0, 0);
                } else {
                    cVar.c.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tieba.a.g.icon_floor_manage_n, 0, 0, 0);
                }
            } else if (z2) {
                cVar.c.setVisibility(0);
                if (l == 1) {
                    cVar.c.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tieba.a.g.icon_floor_delete_n_1, 0, 0, 0);
                } else {
                    cVar.c.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tieba.a.g.icon_floor_delete_n, 0, 0, 0);
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
                sparseArray2.put(com.baidu.tieba.a.h.tag_manage_user_identity, Integer.valueOf(this.f));
            }
            if (z2) {
                sparseArray2.put(com.baidu.tieba.a.h.tag_del_post_is_self, Boolean.valueOf(z));
                sparseArray2.put(com.baidu.tieba.a.h.tag_del_post_type, 2);
                sparseArray2.put(com.baidu.tieba.a.h.tag_del_post_id, aiVar.d());
            } else {
                sparseArray2.put(com.baidu.tieba.a.h.tag_del_post_is_self, Boolean.valueOf(z));
                sparseArray2.put(com.baidu.tieba.a.h.tag_del_post_type, 0);
                sparseArray2.put(com.baidu.tieba.a.h.tag_del_post_id, "");
            }
            if (z3) {
                sparseArray2.put(com.baidu.tieba.a.h.tag_forbid_user_name, aiVar.g().getUserName());
            } else {
                sparseArray2.put(com.baidu.tieba.a.h.tag_forbid_user_name, "");
            }
        }
    }
}
