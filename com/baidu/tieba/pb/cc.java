package com.baidu.tieba.pb;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import com.baidu.adp.widget.ColumnLayout;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.view.HeadImageView;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class cc extends BaseAdapter {
    protected Context b;
    protected com.baidu.tieba.util.i c;
    protected View.OnClickListener e;
    protected ArrayList<com.baidu.tieba.data.as> a = null;
    protected View.OnClickListener d = null;
    protected int f = 0;
    protected boolean g = false;
    protected boolean h = false;
    protected boolean i = false;

    public cc(Context context, View.OnClickListener onClickListener) {
        this.b = null;
        this.c = null;
        this.e = null;
        this.b = context;
        this.c = new com.baidu.tieba.util.i(this.b);
        this.c.f("pb");
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

    public com.baidu.tieba.util.i a() {
        return this.c;
    }

    public void a(ArrayList<com.baidu.tieba.data.as> arrayList) {
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
        this.h = false;
    }

    public void b(boolean z) {
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
        cd cdVar = (cd) ((SparseArray) view.getTag()).get(R.id.tag_holder);
        if (getItem(i) != null) {
            a(cdVar, (com.baidu.tieba.data.as) getItem(i), !(!this.i && i + 1 >= getCount()), i == 0);
        }
        return view;
    }

    public View b() {
        cd cdVar = new cd(this);
        View inflate = LayoutInflater.from(this.b).inflate(R.layout.new_sub_pb_list_item, (ViewGroup) null);
        cdVar.a = inflate;
        cdVar.b = (ColumnLayout) inflate.findViewById(R.id.sub_pb_item_columnlayout);
        cdVar.c = (HeadImageView) inflate.findViewById(R.id.photo);
        cdVar.d = (TextView) inflate.findViewById(R.id.time);
        cdVar.e = (Button) inflate.findViewById(R.id.manage_btn);
        cdVar.f = (TbRichTextView) inflate.findViewById(R.id.richText);
        cdVar.f.setTextSize(com.baidu.tieba.data.h.t());
        if (TiebaApplication.g().an() == 1) {
            cdVar.d.setTextColor(this.b.getResources().getColor(R.color.subpb_listitem_time_1));
            cdVar.f.setTextColor(this.b.getResources().getColor(R.color.gray_night_3));
        } else {
            cdVar.d.setTextColor(this.b.getResources().getColor(R.color.subpb_listitem_time));
            cdVar.f.setTextColor(this.b.getResources().getColor(R.color.gray_day_3));
        }
        cdVar.e.setOnClickListener(this.d);
        if (!this.h) {
            cdVar.c.setVisibility(8);
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(R.id.tag_holder, cdVar);
        inflate.setTag(sparseArray);
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.tieba.data.as asVar, cd cdVar, boolean z, boolean z2) {
        int an = TiebaApplication.g().an();
        if (z2 && !z) {
            int dimensionPixelSize = this.b.getResources().getDimensionPixelSize(R.dimen.default_size_22);
            int dimensionPixelSize2 = this.b.getResources().getDimensionPixelSize(R.dimen.default_gap_8);
            int dimensionPixelSize3 = this.b.getResources().getDimensionPixelSize(R.dimen.default_gap_8);
            int dimensionPixelSize4 = this.b.getResources().getDimensionPixelSize(R.dimen.default_gap_10);
            cdVar.a.setBackgroundResource(an == 1 ? R.drawable.subpb_list_item_full_bg_1 : R.drawable.subpb_list_item_full_bg);
            cdVar.a.setPadding(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize4);
        } else if (z2) {
            int dimensionPixelSize5 = this.b.getResources().getDimensionPixelSize(R.dimen.default_size_22);
            int dimensionPixelSize6 = this.b.getResources().getDimensionPixelSize(R.dimen.default_gap_8);
            int dimensionPixelSize7 = this.b.getResources().getDimensionPixelSize(R.dimen.default_gap_8);
            int dimensionPixelSize8 = this.b.getResources().getDimensionPixelSize(R.dimen.default_gap_10);
            cdVar.a.setBackgroundResource(an == 1 ? R.drawable.subpb_list_item_top_bg_1 : R.drawable.subpb_list_item_top_bg);
            cdVar.a.setPadding(dimensionPixelSize6, dimensionPixelSize5, dimensionPixelSize7, dimensionPixelSize8);
        } else if (z) {
            int dimensionPixelSize9 = this.b.getResources().getDimensionPixelSize(R.dimen.default_size_10);
            int dimensionPixelSize10 = this.b.getResources().getDimensionPixelSize(R.dimen.default_gap_8);
            int dimensionPixelSize11 = this.b.getResources().getDimensionPixelSize(R.dimen.default_gap_8);
            int dimensionPixelSize12 = this.b.getResources().getDimensionPixelSize(R.dimen.default_gap_10);
            cdVar.a.setBackgroundResource(an == 1 ? R.drawable.subpb_list_item_middle_bg_1 : R.drawable.subpb_list_item_middle_bg);
            cdVar.a.setPadding(dimensionPixelSize10, dimensionPixelSize9, dimensionPixelSize11, dimensionPixelSize12);
        } else {
            int dimensionPixelSize13 = this.b.getResources().getDimensionPixelSize(R.dimen.default_size_10);
            int dimensionPixelSize14 = this.b.getResources().getDimensionPixelSize(R.dimen.default_gap_8);
            int dimensionPixelSize15 = this.b.getResources().getDimensionPixelSize(R.dimen.default_gap_8);
            int dimensionPixelSize16 = this.b.getResources().getDimensionPixelSize(R.dimen.default_gap_10);
            cdVar.a.setBackgroundResource(an == 1 ? R.drawable.subpb_list_item_foot_bg_1 : R.drawable.subpb_list_item_foot_bg);
            cdVar.a.setPadding(dimensionPixelSize14, dimensionPixelSize13, dimensionPixelSize15, dimensionPixelSize16);
        }
        cdVar.a.invalidate();
    }

    public void a(cd cdVar, com.baidu.tieba.data.as asVar, boolean z, boolean z2) {
        boolean z3;
        boolean z4;
        boolean z5;
        if (cdVar != null && asVar != null) {
            a(asVar, cdVar, z, z2);
            cdVar.c.setTag(null);
            int an = TiebaApplication.g().an();
            if (asVar.g() != null) {
                String name = asVar.g().getName();
                String id = asVar.g().getId();
                SparseArray sparseArray = (SparseArray) cdVar.a.getTag();
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                    cdVar.a.setTag(sparseArray);
                }
                sparseArray.put(R.id.tag_photo_username, name);
                sparseArray.put(R.id.tag_clip_board, asVar);
                sparseArray.put(R.id.tag_is_subpb, true);
                cdVar.c.setUserId(id);
                String portrait = asVar.g().getPortrait();
                com.baidu.adp.widget.ImageView.d c = this.c.c(portrait);
                if (c != null) {
                    c.a(cdVar.c);
                } else {
                    cdVar.c.setTag(portrait);
                    cdVar.c.setImageBitmap(com.baidu.tieba.util.m.a((int) R.drawable.photo));
                }
            }
            if (TiebaApplication.g().an() == 1) {
                cdVar.f.setLinkTextColor(this.b.getResources().getColor(R.color.common_link_text_1));
            } else {
                cdVar.f.setLinkTextColor(this.b.getResources().getColor(R.color.common_link_text));
            }
            cdVar.f.setVoiceViewRes(R.layout.voice_play_btn);
            cdVar.f.setText(asVar.h());
            cdVar.d.setText(com.baidu.tieba.util.bm.b(asVar.f()));
            String id2 = asVar.g().getId();
            if (this.f != 0) {
                boolean z6 = id2 == null || !id2.equals(TiebaApplication.A());
                if (id2 == null || id2.equals(SocialConstants.FALSE) || id2.length() == 0) {
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
            } else if (id2 == null || !id2.equals(TiebaApplication.A())) {
                z3 = false;
                z4 = false;
                z5 = false;
            } else {
                z3 = true;
                z4 = true;
                z5 = false;
            }
            if (z4 && z5) {
                cdVar.e.setVisibility(0);
                if (an == 1) {
                    cdVar.e.setCompoundDrawablesWithIntrinsicBounds(R.drawable.btn_floor_manage_n_1, 0, 0, 0);
                } else {
                    cdVar.e.setCompoundDrawablesWithIntrinsicBounds(R.drawable.btn_floor_manage_n, 0, 0, 0);
                }
            } else if (z4) {
                cdVar.e.setVisibility(0);
                if (an == 1) {
                    cdVar.e.setCompoundDrawablesWithIntrinsicBounds(R.drawable.btn_floor_delete_n_1, 0, 0, 0);
                } else {
                    cdVar.e.setCompoundDrawablesWithIntrinsicBounds(R.drawable.btn_floor_delete_n, 0, 0, 0);
                }
            } else {
                cdVar.e.setVisibility(8);
            }
            SparseArray sparseArray2 = (SparseArray) cdVar.e.getTag();
            if (sparseArray2 == null) {
                sparseArray2 = new SparseArray();
                cdVar.e.setTag(sparseArray2);
            }
            if (cdVar.e.getVisibility() == 0) {
                sparseArray2.put(R.id.tag_manage_user_identity, Integer.valueOf(this.f));
            }
            if (z4) {
                sparseArray2.put(R.id.tag_del_post_is_self, Boolean.valueOf(z3));
                sparseArray2.put(R.id.tag_del_post_type, 2);
                sparseArray2.put(R.id.tag_del_post_id, asVar.d());
            } else {
                sparseArray2.put(R.id.tag_del_post_is_self, Boolean.valueOf(z3));
                sparseArray2.put(R.id.tag_del_post_type, 0);
                sparseArray2.put(R.id.tag_del_post_id, "");
            }
            if (z5) {
                sparseArray2.put(R.id.tag_forbid_user_name, asVar.g().getName());
            } else {
                sparseArray2.put(R.id.tag_forbid_user_name, "");
            }
        }
    }
}
