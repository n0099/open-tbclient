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
public class bl extends BaseAdapter {
    private Context b;
    private com.baidu.tieba.util.a c;
    private View.OnClickListener e;

    /* renamed from: a  reason: collision with root package name */
    private ArrayList f1480a = null;
    private View.OnClickListener d = null;
    private int f = 0;
    private boolean g = false;
    private boolean h = true;

    public bl(Context context, View.OnClickListener onClickListener) {
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
        this.f1480a = arrayList;
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
        if (this.f1480a == null) {
            return 0;
        }
        return this.f1480a.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.f1480a == null || i < 0 || i >= this.f1480a.size()) {
            return null;
        }
        return this.f1480a.get(i);
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
        bm bmVar = (bm) ((SparseArray) view.getTag()).get(R.id.tag_holder);
        if (getItem(i) != null) {
            a(bmVar, (com.baidu.tieba.data.aw) getItem(i), getCount() - i > 1);
        }
        return view;
    }

    public View b() {
        bm bmVar = new bm(this);
        View inflate = LayoutInflater.from(this.b).inflate(R.layout.new_sub_pb_list_item, (ViewGroup) null);
        bmVar.f1481a = inflate;
        bmVar.b = (HeadImageView) inflate.findViewById(R.id.photo);
        bmVar.c = (TextView) inflate.findViewById(R.id.time);
        bmVar.d = (Button) inflate.findViewById(R.id.manage_btn);
        bmVar.e = (TbRichTextView) inflate.findViewById(R.id.richText);
        bmVar.f = inflate.findViewById(R.id.line_divider);
        bmVar.b.setOnClickListener(this.e);
        int au = TiebaApplication.f().au();
        bmVar.e.setTextSize(com.baidu.tieba.data.g.p());
        com.baidu.tieba.util.ah.d(bmVar.c, au);
        if (TiebaApplication.f().au() == 1) {
            bmVar.e.setTextColor(this.b.getResources().getColor(R.color.gray_night_3));
            bmVar.f.setBackgroundResource(R.drawable.line_comment_1);
        } else {
            bmVar.e.setTextColor(this.b.getResources().getColor(R.color.gray_day_3));
            bmVar.f.setBackgroundResource(R.drawable.line_comment);
        }
        bmVar.d.setOnClickListener(this.d);
        if (!this.h) {
            bmVar.b.setVisibility(8);
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(R.id.tag_holder, bmVar);
        inflate.setTag(sparseArray);
        return inflate;
    }

    public void a(bm bmVar, com.baidu.tieba.data.aw awVar, boolean z) {
        boolean z2;
        boolean z3;
        boolean z4;
        if (bmVar != null && awVar != null) {
            bmVar.b.setTag(null);
            if (awVar.g() != null) {
                String name = awVar.g().getName();
                String id = awVar.g().getId();
                SparseArray sparseArray = (SparseArray) bmVar.f1481a.getTag();
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                    bmVar.f1481a.setTag(sparseArray);
                }
                sparseArray.put(R.id.tag_photo_username, name);
                sparseArray.put(R.id.tag_clip_board, awVar);
                sparseArray.put(R.id.tag_is_subpb, true);
                bmVar.b.setUserId(id);
                String portrait = awVar.g().getPortrait();
                com.baidu.adp.widget.a.b c = this.c.c(portrait);
                if (c != null) {
                    c.b(bmVar.b);
                } else {
                    bmVar.b.setTag(portrait);
                    bmVar.b.setImageBitmap(com.baidu.tieba.util.e.a((int) R.drawable.photo));
                }
            }
            if (z) {
                bmVar.f.setVisibility(0);
            } else {
                bmVar.f.setVisibility(8);
            }
            bmVar.e.setText(awVar.h());
            bmVar.c.setText(com.baidu.tieba.util.ai.e(new Date(awVar.f())));
            String id2 = awVar.g().getId();
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
            int au = TiebaApplication.f().au();
            if (z3 && z4) {
                bmVar.d.setVisibility(0);
                if (au == 1) {
                    bmVar.d.setCompoundDrawablesWithIntrinsicBounds(R.drawable.icon_little_manage_selector_1, 0, 0, 0);
                } else {
                    bmVar.d.setCompoundDrawablesWithIntrinsicBounds(R.drawable.icon_little_manage_selector, 0, 0, 0);
                }
            } else if (z3) {
                bmVar.d.setVisibility(0);
                if (au == 1) {
                    bmVar.d.setCompoundDrawablesWithIntrinsicBounds(R.drawable.icon_little_delete_selector_1, 0, 0, 0);
                } else {
                    bmVar.d.setCompoundDrawablesWithIntrinsicBounds(R.drawable.icon_little_delete_selector, 0, 0, 0);
                }
            } else {
                bmVar.d.setVisibility(8);
            }
            SparseArray sparseArray2 = (SparseArray) bmVar.d.getTag();
            if (sparseArray2 == null) {
                sparseArray2 = new SparseArray();
                bmVar.d.setTag(sparseArray2);
            }
            if (bmVar.d.getVisibility() == 0) {
                sparseArray2.put(R.id.tag_manage_user_identity, Integer.valueOf(this.f));
            }
            if (z3) {
                sparseArray2.put(R.id.tag_del_post_is_self, Boolean.valueOf(z2));
                sparseArray2.put(R.id.tag_del_post_type, 2);
                sparseArray2.put(R.id.tag_del_post_id, awVar.d());
            } else {
                sparseArray2.put(R.id.tag_del_post_is_self, Boolean.valueOf(z2));
                sparseArray2.put(R.id.tag_del_post_type, 0);
                sparseArray2.put(R.id.tag_del_post_id, "");
            }
            if (z4) {
                sparseArray2.put(R.id.tag_forbid_user_name, awVar.g().getName());
            } else {
                sparseArray2.put(R.id.tag_forbid_user_name, "");
            }
        }
    }
}
