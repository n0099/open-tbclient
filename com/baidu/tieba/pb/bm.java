package com.baidu.tieba.pb;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.view.HeadImageView;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
import java.util.Date;
/* loaded from: classes.dex */
public class bm extends BaseAdapter {
    private Context b;
    private com.baidu.tieba.util.a c;
    private View.OnClickListener e;

    /* renamed from: a  reason: collision with root package name */
    private ArrayList f1516a = null;
    private View.OnClickListener d = null;
    private int f = 0;
    private boolean g = false;
    private boolean h = true;

    public bm(Context context, View.OnClickListener onClickListener) {
        this.b = null;
        this.c = null;
        this.e = null;
        this.b = context;
        this.c = new com.baidu.tieba.util.a(this.b);
        this.e = onClickListener;
    }

    public com.baidu.tieba.util.a a() {
        return this.c;
    }

    public void a(ArrayList arrayList) {
        this.f1516a = arrayList;
    }

    public void a(View.OnClickListener onClickListener) {
        this.d = onClickListener;
    }

    public void a(int i, boolean z) {
        this.f = i;
        this.g = z;
    }

    public void a(boolean z) {
        this.h = z;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.f1516a == null) {
            return 0;
        }
        return this.f1516a.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.f1516a == null || i < 0 || i >= this.f1516a.size()) {
            return null;
        }
        return this.f1516a.get(i);
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
        bn bnVar = (bn) ((SparseArray) view.getTag()).get(R.id.tag_holder);
        if (getItem(i) != null) {
            a(bnVar, (com.baidu.tieba.data.as) getItem(i), getCount() - i > 1);
        }
        return view;
    }

    public View b() {
        bn bnVar = new bn(this);
        View inflate = LayoutInflater.from(this.b).inflate(R.layout.new_sub_pb_list_item, (ViewGroup) null);
        bnVar.f1517a = inflate;
        bnVar.b = (HeadImageView) inflate.findViewById(R.id.photo);
        bnVar.c = (TextView) inflate.findViewById(R.id.time);
        bnVar.d = (Button) inflate.findViewById(R.id.manage_btn);
        bnVar.e = (TbRichTextView) inflate.findViewById(R.id.richText);
        bnVar.f = inflate.findViewById(R.id.line_divider);
        bnVar.b.setOnClickListener(this.e);
        int an = TiebaApplication.g().an();
        bnVar.e.setTextSize(com.baidu.tieba.data.g.q());
        com.baidu.tieba.util.ao.d(bnVar.c, an);
        if (TiebaApplication.g().an() == 1) {
            bnVar.e.setTextColor(this.b.getResources().getColor(R.color.gray_night_3));
            bnVar.f.setBackgroundResource(R.drawable.line_comment_1);
        } else {
            bnVar.e.setTextColor(this.b.getResources().getColor(R.color.gray_day_3));
            bnVar.f.setBackgroundResource(R.drawable.line_comment);
        }
        bnVar.d.setOnClickListener(this.d);
        if (!this.h) {
            bnVar.b.setVisibility(8);
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(R.id.tag_holder, bnVar);
        inflate.setTag(sparseArray);
        return inflate;
    }

    public void a(bn bnVar, com.baidu.tieba.data.as asVar, boolean z) {
        boolean z2;
        boolean z3;
        boolean z4;
        if (bnVar != null && asVar != null) {
            bnVar.b.setTag(null);
            if (asVar.g() != null) {
                String name = asVar.g().getName();
                String id = asVar.g().getId();
                SparseArray sparseArray = (SparseArray) bnVar.f1517a.getTag();
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                    bnVar.f1517a.setTag(sparseArray);
                }
                sparseArray.put(R.id.tag_photo_username, name);
                sparseArray.put(R.id.tag_clip_board, asVar);
                sparseArray.put(R.id.tag_is_subpb, true);
                bnVar.b.setUserId(id);
                String portrait = asVar.g().getPortrait();
                com.baidu.adp.widget.a.b c = this.c.c(portrait);
                if (c != null) {
                    c.a(bnVar.b);
                } else {
                    bnVar.b.setTag(portrait);
                    bnVar.b.setImageBitmap(com.baidu.tieba.util.e.a((int) R.drawable.photo));
                }
            }
            if (z) {
                bnVar.f.setVisibility(0);
            } else {
                bnVar.f.setVisibility(8);
            }
            bnVar.e.setText(asVar.h());
            bnVar.c.setText(com.baidu.tieba.util.ap.g(new Date(asVar.f())));
            String id2 = asVar.g().getId();
            if (this.f != 0) {
                boolean z5 = id2 == null || !id2.equals(TiebaApplication.E());
                if (id2 == null || id2.equals("0") || id2.length() == 0) {
                    z2 = false;
                    z3 = true;
                    z4 = false;
                } else {
                    z2 = false;
                    z3 = true;
                    z4 = z5;
                }
            } else if (this.g) {
                z2 = false;
                z3 = true;
                z4 = false;
            } else if (id2 == null || !id2.equals(TiebaApplication.E())) {
                z2 = false;
                z3 = false;
                z4 = false;
            } else {
                z2 = true;
                z3 = true;
                z4 = false;
            }
            int an = TiebaApplication.g().an();
            if (z3 && z4) {
                bnVar.d.setVisibility(0);
                if (an == 1) {
                    bnVar.d.setCompoundDrawablesWithIntrinsicBounds(R.drawable.icon_little_manage_selector_1, 0, 0, 0);
                } else {
                    bnVar.d.setCompoundDrawablesWithIntrinsicBounds(R.drawable.icon_little_manage_selector, 0, 0, 0);
                }
            } else if (z3) {
                bnVar.d.setVisibility(0);
                if (an == 1) {
                    bnVar.d.setCompoundDrawablesWithIntrinsicBounds(R.drawable.icon_little_delete_selector_1, 0, 0, 0);
                } else {
                    bnVar.d.setCompoundDrawablesWithIntrinsicBounds(R.drawable.icon_little_delete_selector, 0, 0, 0);
                }
            } else {
                bnVar.d.setVisibility(8);
            }
            SparseArray sparseArray2 = (SparseArray) bnVar.d.getTag();
            if (sparseArray2 == null) {
                sparseArray2 = new SparseArray();
                bnVar.d.setTag(sparseArray2);
            }
            if (bnVar.d.getVisibility() == 0) {
                sparseArray2.put(R.id.tag_manage_user_identity, Integer.valueOf(this.f));
            }
            if (z3) {
                sparseArray2.put(R.id.tag_del_post_is_self, Boolean.valueOf(z2));
                sparseArray2.put(R.id.tag_del_post_type, 2);
                sparseArray2.put(R.id.tag_del_post_id, asVar.d());
            } else {
                sparseArray2.put(R.id.tag_del_post_is_self, Boolean.valueOf(z2));
                sparseArray2.put(R.id.tag_del_post_type, 0);
                sparseArray2.put(R.id.tag_del_post_id, "");
            }
            if (z4) {
                sparseArray2.put(R.id.tag_forbid_user_name, asVar.g().getName());
            } else {
                sparseArray2.put(R.id.tag_forbid_user_name, "");
            }
        }
    }
}
