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
    private com.baidu.tieba.util.a c;
    private View.OnClickListener e;

    /* renamed from: a  reason: collision with root package name */
    private ArrayList f1227a = null;
    private View.OnClickListener d = null;
    private int f = 0;
    private boolean g = false;
    private boolean h = true;

    public bi(Context context, View.OnClickListener onClickListener) {
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
        this.f1227a = arrayList;
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
        if (this.f1227a == null) {
            return 0;
        }
        return this.f1227a.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.f1227a == null || i < 0 || i >= this.f1227a.size()) {
            return null;
        }
        return this.f1227a.get(i);
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
            a(bjVar, (com.baidu.tieba.data.an) getItem(i), getCount() - i > 1);
        }
        return view;
    }

    public View b() {
        bj bjVar = new bj(this);
        View inflate = LayoutInflater.from(this.b).inflate(R.layout.new_sub_pb_list_item, (ViewGroup) null);
        bjVar.f1228a = inflate;
        bjVar.b = (HeadImageView) inflate.findViewById(R.id.photo);
        bjVar.c = (TextView) inflate.findViewById(R.id.time);
        bjVar.d = (Button) inflate.findViewById(R.id.manage_btn);
        bjVar.e = (TbRichTextView) inflate.findViewById(R.id.richText);
        bjVar.f = inflate.findViewById(R.id.line_divider);
        bjVar.b.setOnClickListener(this.e);
        int at = TiebaApplication.f().at();
        bjVar.e.setTextSize(com.baidu.tieba.data.g.p());
        com.baidu.tieba.util.x.d(bjVar.c, at);
        if (TiebaApplication.f().at() == 1) {
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

    public void a(bj bjVar, com.baidu.tieba.data.an anVar, boolean z) {
        boolean z2;
        boolean z3;
        boolean z4;
        if (bjVar != null && anVar != null) {
            bjVar.b.setTag(null);
            if (anVar.h() != null) {
                String name = anVar.h().getName();
                String id = anVar.h().getId();
                SparseArray sparseArray = (SparseArray) bjVar.f1228a.getTag();
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                    bjVar.f1228a.setTag(sparseArray);
                }
                sparseArray.put(R.id.tag_photo_username, name);
                sparseArray.put(R.id.tag_clip_board, anVar);
                bjVar.b.setUserId(id);
                String portrait = anVar.h().getPortrait();
                com.baidu.adp.widget.a.b b = this.c.b(portrait);
                if (b != null) {
                    b.b(bjVar.b);
                } else {
                    bjVar.b.setTag(portrait);
                    bjVar.b.setImageBitmap(com.baidu.tieba.util.d.a((int) R.drawable.photo));
                }
            }
            if (z) {
                bjVar.f.setVisibility(0);
            } else {
                bjVar.f.setVisibility(8);
            }
            bjVar.e.setText(anVar.i());
            bjVar.c.setText(com.baidu.tieba.util.y.e(new Date(anVar.g())));
            String id2 = anVar.h().getId();
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
            int at = TiebaApplication.f().at();
            if (z3 && z4) {
                bjVar.d.setVisibility(0);
                if (at == 1) {
                    bjVar.d.setCompoundDrawablesWithIntrinsicBounds(R.drawable.icon_little_manage_selector_1, 0, 0, 0);
                } else {
                    bjVar.d.setCompoundDrawablesWithIntrinsicBounds(R.drawable.icon_little_manage_selector, 0, 0, 0);
                }
            } else if (z3) {
                bjVar.d.setVisibility(0);
                if (at == 1) {
                    bjVar.d.setCompoundDrawablesWithIntrinsicBounds(R.drawable.icon_little_delete_selector_1, 0, 0, 0);
                } else {
                    bjVar.d.setCompoundDrawablesWithIntrinsicBounds(R.drawable.icon_little_delete_selector, 0, 0, 0);
                }
            } else {
                bjVar.d.setVisibility(8);
            }
            SparseArray sparseArray2 = (SparseArray) bjVar.d.getTag();
            if (sparseArray2 == null) {
                sparseArray2 = new SparseArray();
                bjVar.d.setTag(sparseArray2);
            }
            if (bjVar.d.getVisibility() == 0) {
                sparseArray2.put(R.id.tag_manage_user_identity, Integer.valueOf(this.f));
            }
            if (z3) {
                sparseArray2.put(R.id.tag_del_post_is_self, Boolean.valueOf(z2));
                sparseArray2.put(R.id.tag_del_post_type, 2);
                sparseArray2.put(R.id.tag_del_post_id, anVar.d());
            } else {
                sparseArray2.put(R.id.tag_del_post_is_self, Boolean.valueOf(z2));
                sparseArray2.put(R.id.tag_del_post_type, 0);
                sparseArray2.put(R.id.tag_del_post_id, "");
            }
            if (z4) {
                sparseArray2.put(R.id.tag_forbid_user_name, anVar.h().getName());
            } else {
                sparseArray2.put(R.id.tag_forbid_user_name, "");
            }
        }
    }
}
