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
public class cf extends BaseAdapter {
    protected Context b;
    protected com.baidu.tieba.util.i c;
    protected View.OnClickListener e;
    protected ArrayList<com.baidu.tieba.data.aq> a = null;
    protected View.OnClickListener d = null;
    protected int f = 0;
    protected boolean g = false;
    protected boolean h = false;
    protected boolean i = false;

    public cf(Context context, View.OnClickListener onClickListener) {
        this.b = null;
        this.c = null;
        this.e = null;
        this.b = context;
        this.c = new com.baidu.tieba.util.i(this.b);
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

    public final com.baidu.tieba.util.i a() {
        return this.c;
    }

    public final void a(ArrayList<com.baidu.tieba.data.aq> arrayList) {
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
        cg cgVar = (cg) ((SparseArray) view.getTag()).get(R.id.tag_holder);
        if (getItem(i) != null) {
            a(cgVar, (com.baidu.tieba.data.aq) getItem(i), !(!this.i && i + 1 >= getCount()), i == 0);
        }
        return view;
    }

    public final View c() {
        cg cgVar = new cg(this);
        View inflate = LayoutInflater.from(this.b).inflate(R.layout.new_sub_pb_list_item, (ViewGroup) null);
        cgVar.a = inflate;
        cgVar.b = (ColumnLayout) inflate.findViewById(R.id.sub_pb_item_columnlayout);
        cgVar.c = (HeadImageView) inflate.findViewById(R.id.photo);
        cgVar.d = (TextView) inflate.findViewById(R.id.time);
        cgVar.e = (Button) inflate.findViewById(R.id.manage_btn);
        cgVar.f = (TbRichTextView) inflate.findViewById(R.id.richText);
        TbRichTextView tbRichTextView = cgVar.f;
        com.baidu.tieba.data.i.D();
        tbRichTextView.setTextSize(14.0f);
        if (TiebaApplication.g().ae() == 1) {
            cgVar.d.setTextColor(this.b.getResources().getColor(R.color.subpb_listitem_time_1));
            cgVar.f.setTextColor(this.b.getResources().getColor(R.color.gray_night_3));
        } else {
            cgVar.d.setTextColor(this.b.getResources().getColor(R.color.subpb_listitem_time));
            cgVar.f.setTextColor(this.b.getResources().getColor(R.color.gray_day_3));
        }
        cgVar.e.setOnClickListener(this.d);
        if (!this.h) {
            cgVar.c.setVisibility(8);
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(R.id.tag_holder, cgVar);
        inflate.setTag(sparseArray);
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.tieba.data.aq aqVar, cg cgVar, boolean z, boolean z2) {
        int ae = TiebaApplication.g().ae();
        if (z2 && !z) {
            int dimensionPixelSize = this.b.getResources().getDimensionPixelSize(R.dimen.default_size_22);
            int dimensionPixelSize2 = this.b.getResources().getDimensionPixelSize(R.dimen.default_gap_8);
            int dimensionPixelSize3 = this.b.getResources().getDimensionPixelSize(R.dimen.default_gap_8);
            int dimensionPixelSize4 = this.b.getResources().getDimensionPixelSize(R.dimen.default_gap_10);
            cgVar.a.setBackgroundResource(ae == 1 ? R.drawable.subpb_list_item_full_bg_1 : R.drawable.subpb_list_item_full_bg);
            cgVar.a.setPadding(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize4);
        } else if (z2) {
            int dimensionPixelSize5 = this.b.getResources().getDimensionPixelSize(R.dimen.default_size_22);
            int dimensionPixelSize6 = this.b.getResources().getDimensionPixelSize(R.dimen.default_gap_8);
            int dimensionPixelSize7 = this.b.getResources().getDimensionPixelSize(R.dimen.default_gap_8);
            int dimensionPixelSize8 = this.b.getResources().getDimensionPixelSize(R.dimen.default_gap_10);
            cgVar.a.setBackgroundResource(ae == 1 ? R.drawable.subpb_list_item_top_bg_1 : R.drawable.subpb_list_item_top_bg);
            cgVar.a.setPadding(dimensionPixelSize6, dimensionPixelSize5, dimensionPixelSize7, dimensionPixelSize8);
        } else if (z) {
            int dimensionPixelSize9 = this.b.getResources().getDimensionPixelSize(R.dimen.default_size_10);
            int dimensionPixelSize10 = this.b.getResources().getDimensionPixelSize(R.dimen.default_gap_8);
            int dimensionPixelSize11 = this.b.getResources().getDimensionPixelSize(R.dimen.default_gap_8);
            int dimensionPixelSize12 = this.b.getResources().getDimensionPixelSize(R.dimen.default_gap_10);
            cgVar.a.setBackgroundResource(ae == 1 ? R.drawable.subpb_list_item_middle_bg_1 : R.drawable.subpb_list_item_middle_bg);
            cgVar.a.setPadding(dimensionPixelSize10, dimensionPixelSize9, dimensionPixelSize11, dimensionPixelSize12);
        } else {
            int dimensionPixelSize13 = this.b.getResources().getDimensionPixelSize(R.dimen.default_size_10);
            int dimensionPixelSize14 = this.b.getResources().getDimensionPixelSize(R.dimen.default_gap_8);
            int dimensionPixelSize15 = this.b.getResources().getDimensionPixelSize(R.dimen.default_gap_8);
            int dimensionPixelSize16 = this.b.getResources().getDimensionPixelSize(R.dimen.default_gap_10);
            cgVar.a.setBackgroundResource(ae == 1 ? R.drawable.subpb_list_item_foot_bg_1 : R.drawable.subpb_list_item_foot_bg);
            cgVar.a.setPadding(dimensionPixelSize14, dimensionPixelSize13, dimensionPixelSize15, dimensionPixelSize16);
        }
        cgVar.a.invalidate();
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x00e4 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0145  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x01aa  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x01cd  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x01d6  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x01f5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a(cg cgVar, com.baidu.tieba.data.aq aqVar, boolean z, boolean z2) {
        boolean z3;
        boolean z4;
        boolean z5;
        SparseArray sparseArray;
        if (cgVar != null && aqVar != null) {
            a(aqVar, cgVar, z, z2);
            cgVar.c.setTag(null);
            int ae = TiebaApplication.g().ae();
            if (aqVar.g() != null) {
                String userName = aqVar.g().getUserName();
                String userId = aqVar.g().getUserId();
                SparseArray sparseArray2 = (SparseArray) cgVar.a.getTag();
                if (sparseArray2 == null) {
                    sparseArray2 = new SparseArray();
                    cgVar.a.setTag(sparseArray2);
                }
                sparseArray2.put(R.id.tag_photo_username, userName);
                sparseArray2.put(R.id.tag_clip_board, aqVar);
                sparseArray2.put(R.id.tag_is_subpb, true);
                cgVar.c.setUserId(userId);
                String portrait = aqVar.g().getPortrait();
                com.baidu.tieba.util.i iVar = this.c;
                com.baidu.adp.widget.ImageView.b b = com.baidu.tbadk.imageManager.e.a().b(portrait);
                if (b != null) {
                    b.a(cgVar.c);
                } else {
                    cgVar.c.setTag(portrait);
                    cgVar.c.setImageBitmap(com.baidu.tieba.util.n.a((int) R.drawable.photo));
                }
            }
            if (TiebaApplication.g().ae() == 1) {
                cgVar.f.setLinkTextColor(this.b.getResources().getColor(R.color.common_link_text_1));
            } else {
                cgVar.f.setLinkTextColor(this.b.getResources().getColor(R.color.common_link_text));
            }
            cgVar.f.setVoiceViewRes(R.layout.voice_play_btn);
            cgVar.f.setText(aqVar.h());
            cgVar.d.setText(com.baidu.tieba.util.bs.a(aqVar.f()));
            boolean z6 = false;
            boolean z7 = false;
            String userId2 = aqVar.g().getUserId();
            if (this.f != 0) {
                z6 = true;
                z7 = true;
                if (userId2 != null && userId2.equals(TiebaApplication.v())) {
                    z6 = false;
                }
                if (userId2 == null || userId2.equals(SocialConstants.FALSE) || userId2.length() == 0) {
                    z3 = true;
                    z4 = false;
                    z5 = false;
                    if (!z3 && z5) {
                        cgVar.e.setVisibility(0);
                        if (ae == 1) {
                            cgVar.e.setCompoundDrawablesWithIntrinsicBounds(R.drawable.btn_floor_manage_n_1, 0, 0, 0);
                        } else {
                            cgVar.e.setCompoundDrawablesWithIntrinsicBounds(R.drawable.btn_floor_manage_n, 0, 0, 0);
                        }
                    } else if (z3) {
                        cgVar.e.setVisibility(0);
                        if (ae == 1) {
                            cgVar.e.setCompoundDrawablesWithIntrinsicBounds(R.drawable.btn_floor_delete_n_1, 0, 0, 0);
                        } else {
                            cgVar.e.setCompoundDrawablesWithIntrinsicBounds(R.drawable.btn_floor_delete_n, 0, 0, 0);
                        }
                    } else {
                        cgVar.e.setVisibility(8);
                    }
                    sparseArray = (SparseArray) cgVar.e.getTag();
                    if (sparseArray == null) {
                        sparseArray = new SparseArray();
                        cgVar.e.setTag(sparseArray);
                    }
                    if (cgVar.e.getVisibility() == 0) {
                        sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(this.f));
                    }
                    if (z3) {
                        sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z4));
                        sparseArray.put(R.id.tag_del_post_type, 2);
                        sparseArray.put(R.id.tag_del_post_id, aqVar.d());
                    } else {
                        sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z4));
                        sparseArray.put(R.id.tag_del_post_type, 0);
                        sparseArray.put(R.id.tag_del_post_id, "");
                    }
                    if (z5) {
                        sparseArray.put(R.id.tag_forbid_user_name, aqVar.g().getUserName());
                        return;
                    } else {
                        sparseArray.put(R.id.tag_forbid_user_name, "");
                        return;
                    }
                }
                z3 = z7;
                z4 = false;
                z5 = z6;
                if (!z3) {
                }
                if (z3) {
                }
                sparseArray = (SparseArray) cgVar.e.getTag();
                if (sparseArray == null) {
                }
                if (cgVar.e.getVisibility() == 0) {
                }
                if (z3) {
                }
                if (z5) {
                }
            } else {
                if (this.g) {
                    z3 = true;
                    z4 = false;
                    z5 = false;
                } else {
                    if (userId2 != null && userId2.equals(TiebaApplication.v())) {
                        z3 = true;
                        z4 = true;
                        z5 = false;
                    }
                    z3 = z7;
                    z4 = false;
                    z5 = z6;
                }
                if (!z3) {
                }
                if (z3) {
                }
                sparseArray = (SparseArray) cgVar.e.getTag();
                if (sparseArray == null) {
                }
                if (cgVar.e.getVisibility() == 0) {
                }
                if (z3) {
                }
                if (z5) {
                }
            }
        }
    }
}
