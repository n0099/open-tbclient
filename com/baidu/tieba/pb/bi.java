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
public class bi extends BaseAdapter {
    private Context b;
    private com.baidu.tieba.d.a c;
    private View.OnClickListener e;
    private ArrayList a = null;
    private View.OnClickListener d = null;
    private int f = 0;
    private boolean g = false;
    private boolean h = true;

    public bi(Context context, View.OnClickListener onClickListener) {
        this.b = null;
        this.c = null;
        this.e = null;
        this.b = context;
        this.c = new com.baidu.tieba.d.a(this.b);
        this.e = onClickListener;
    }

    public com.baidu.tieba.d.a a() {
        return this.c;
    }

    public void a(ArrayList arrayList) {
        this.a = arrayList;
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
        bj bjVar = (bj) ((SparseArray) view.getTag()).get(R.id.tag_holder);
        if (getItem(i) != null) {
            a(bjVar, (com.baidu.tieba.a.ar) getItem(i), getCount() - i > 1);
        }
        return view;
    }

    public View b() {
        bj bjVar = new bj(this);
        View inflate = LayoutInflater.from(this.b).inflate(R.layout.new_sub_pb_list_item, (ViewGroup) null);
        bjVar.a = inflate;
        bjVar.b = (HeadImageView) inflate.findViewById(R.id.photo);
        bjVar.c = (TextView) inflate.findViewById(R.id.time);
        bjVar.d = (Button) inflate.findViewById(R.id.manage_btn);
        bjVar.e = (TbRichTextView) inflate.findViewById(R.id.richText);
        bjVar.f = inflate.findViewById(R.id.line_divider);
        bjVar.b.setOnClickListener(this.e);
        int as = TiebaApplication.e().as();
        bjVar.e.setTextSize(com.baidu.tieba.a.i.p());
        com.baidu.tieba.d.ac.d(bjVar.c, as);
        if (TiebaApplication.e().as() == 1) {
            bjVar.e.setTextColor(this.b.getResources().getColor(R.color.gray_night_3));
            bjVar.f.setBackgroundResource(R.drawable.line_comment_1);
        } else {
            bjVar.e.setTextColor(this.b.getResources().getColor(R.color.gray_day_3));
            bjVar.f.setBackgroundResource(R.drawable.line_comment);
        }
        bjVar.d.setOnClickListener(this.d);
        if (!this.h) {
            bjVar.b.setVisibility(8);
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(R.id.tag_holder, bjVar);
        inflate.setTag(sparseArray);
        return inflate;
    }

    public void a(bj bjVar, com.baidu.tieba.a.ar arVar, boolean z) {
        boolean z2;
        boolean z3;
        boolean z4;
        if (bjVar != null && arVar != null) {
            bjVar.b.setTag(null);
            if (arVar.h() != null) {
                String c = arVar.h().c();
                String a = arVar.h().a();
                SparseArray sparseArray = (SparseArray) bjVar.a.getTag();
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                    bjVar.a.setTag(sparseArray);
                }
                sparseArray.put(R.id.tag_photo_username, c);
                sparseArray.put(R.id.tag_clip_board, arVar);
                bjVar.b.setUserId(a);
                String e = arVar.h().e();
                com.baidu.adp.widget.a.b b = this.c.b(e);
                if (b != null) {
                    b.b(bjVar.b);
                } else {
                    bjVar.b.setTag(e);
                    bjVar.b.setImageBitmap(com.baidu.tieba.d.d.a((int) R.drawable.photo));
                }
            }
            if (z) {
                bjVar.f.setVisibility(0);
            } else {
                bjVar.f.setVisibility(8);
            }
            bjVar.e.setText(arVar.i());
            bjVar.c.setText(com.baidu.tieba.d.ad.e(new Date(arVar.g())));
            String a2 = arVar.h().a();
            if (this.f != 0) {
                boolean z5 = a2 == null || !a2.equals(TiebaApplication.C());
                if (a2 == null || a2.equals("0") || a2.length() == 0) {
                    z2 = false;
                    z3 = true;
                    z4 = false;
                } else {
                    z3 = true;
                    z4 = z5;
                    z2 = false;
                }
            } else if (this.g) {
                z2 = false;
                z3 = true;
                z4 = false;
            } else if (a2 == null || !a2.equals(TiebaApplication.C())) {
                z2 = false;
                z3 = false;
                z4 = false;
            } else {
                z2 = true;
                z3 = true;
                z4 = false;
            }
            int as = TiebaApplication.e().as();
            if (z3 && z4) {
                bjVar.d.setVisibility(0);
                if (as == 1) {
                    bjVar.d.setCompoundDrawablesWithIntrinsicBounds(R.drawable.icon_little_manage_selector_1, 0, 0, 0);
                } else {
                    bjVar.d.setCompoundDrawablesWithIntrinsicBounds(R.drawable.icon_little_manage_selector, 0, 0, 0);
                }
            } else if (z3) {
                bjVar.d.setVisibility(0);
                if (as == 1) {
                    bjVar.d.setCompoundDrawablesWithIntrinsicBounds(R.drawable.icon_little_delete_selector_1, 0, 0, 0);
                } else {
                    bjVar.d.setCompoundDrawablesWithIntrinsicBounds(R.drawable.icon_little_delete_selector, 0, 0, 0);
                }
            } else {
                bjVar.d.setVisibility(8);
            }
            if (bjVar.d.getVisibility() == 0) {
                bjVar.d.setTag(R.id.tag_manage_user_identity, Integer.valueOf(this.f));
            }
            if (z3) {
                bjVar.d.setTag(R.id.tag_del_post_is_self, Boolean.valueOf(z2));
                bjVar.d.setTag(R.id.tag_del_post_type, 2);
                bjVar.d.setTag(R.id.tag_del_post_id, arVar.d());
            } else {
                bjVar.d.setTag(R.id.tag_del_post_is_self, Boolean.valueOf(z2));
                bjVar.d.setTag(R.id.tag_del_post_type, 0);
                bjVar.d.setTag(R.id.tag_del_post_id, "");
            }
            if (z4) {
                bjVar.d.setTag(R.id.tag_forbid_user_name, arVar.h().c());
            } else {
                bjVar.d.setTag(R.id.tag_forbid_user_name, "");
            }
        }
    }
}
