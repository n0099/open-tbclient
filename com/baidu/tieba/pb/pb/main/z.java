package com.baidu.tieba.pb.pb.main;

import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.dialog.k;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.sub.NewSubPbActivity;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes6.dex */
public class z extends com.baidu.tbadk.core.dialog.i {
    private TbPageContext<?> cQU;
    private View.OnClickListener ggx;
    private TextView iGo;
    private TextView iGp;
    private TextView iGq;
    private TextView iGr;
    private TextView iGs;
    private TextView iGt;
    private TextView iGu;
    private TextView iGv;
    private boolean iGw;

    public z(TbPageContext<?> tbPageContext, View.OnClickListener onClickListener) {
        super(tbPageContext);
        this.iGw = false;
        this.cQU = tbPageContext;
        this.ggx = onClickListener;
        Mm();
    }

    public TextView clV() {
        return this.iGo;
    }

    public TextView clW() {
        return this.iGp;
    }

    public TextView clX() {
        return this.iGq;
    }

    public TextView clY() {
        return this.iGr;
    }

    public TextView clZ() {
        return this.iGs;
    }

    public TextView cma() {
        return this.iGv;
    }

    public TextView cmb() {
        return this.iGt;
    }

    public TextView cmc() {
        return this.iGu;
    }

    private void Mm() {
        a((String) null, new String[]{this.cQU.getString(R.string.no_interesting), this.cQU.getString(R.string.save_to_emotion), this.cQU.getString(R.string.save_to_local), this.cQU.getString(R.string.copy), this.cQU.getString(R.string.mark), this.cQU.getString(R.string.report_text), this.cQU.getString(R.string.delete), this.cQU.getString(R.string.mute)}, new k.c() { // from class: com.baidu.tieba.pb.pb.main.z.1
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(com.baidu.tbadk.core.dialog.k kVar, int i, View view) {
                z.this.dismiss();
                z.this.ggx.onClick(view);
            }
        });
        this.iGv = cv(getItemView(0));
        this.iGo = cv(getItemView(4));
        this.iGp = cv(getItemView(7));
        this.iGq = cv(getItemView(5));
        this.iGr = cv(getItemView(6));
        this.iGs = cv(getItemView(3));
        this.iGt = cv(getItemView(1));
        this.iGu = cv(getItemView(2));
    }

    private TextView cv(View view) {
        return (TextView) view.findViewById(R.id.item_view);
    }

    public void pJ(boolean z) {
        this.iGq.setVisibility(z ? 0 : 8);
    }

    public View getView() {
        return getRootView();
    }

    public View getItemView(int i) {
        if (this.mContentView == null || !(this.mContentView instanceof ViewGroup)) {
            return null;
        }
        View findViewById = this.mContentView.findViewById(R.id.content_view);
        if (findViewById == null || !(findViewById instanceof ViewGroup)) {
            return null;
        }
        int childCount = ((ViewGroup) findViewById).getChildCount();
        if (i < 0 || i > childCount - 1) {
            return null;
        }
        return ((ViewGroup) findViewById).getChildAt(i);
    }

    public void a(SparseArray<Object> sparseArray, int i, boolean z) {
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        int i2;
        boolean z6;
        boolean z7;
        if (sparseArray != null) {
            PostData postData = (PostData) sparseArray.get(R.id.tag_clip_board);
            SparseArray sparseArray2 = new SparseArray();
            sparseArray2.put(R.id.tag_clip_board, (PostData) sparseArray.get(R.id.tag_clip_board));
            sparseArray2.put(R.id.tag_is_subpb, false);
            clV().setTag(sparseArray2);
            SparseArray sparseArray3 = new SparseArray();
            sparseArray3.put(R.id.tag_clip_board, (PostData) sparseArray.get(R.id.tag_clip_board));
            clZ().setTag(sparseArray3);
            boolean z8 = false;
            boolean z9 = false;
            if (!(sparseArray.get(R.id.tag_should_manage_visible) instanceof Boolean)) {
                z2 = false;
            } else {
                z2 = ((Boolean) sparseArray.get(R.id.tag_should_manage_visible)).booleanValue();
            }
            if (sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean) {
                z8 = ((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue();
            }
            if (sparseArray.get(R.id.tag_should_delete_visible) instanceof Boolean) {
                z9 = ((Boolean) sparseArray.get(R.id.tag_should_delete_visible)).booleanValue();
            }
            if (!(sparseArray.get(R.id.tag_del_post_is_self) instanceof Boolean)) {
                z3 = false;
            } else {
                z3 = ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue();
            }
            String str = null;
            if (sparseArray.get(R.id.tag_forbid_user_post_id) instanceof String) {
                str = (String) sparseArray.get(R.id.tag_forbid_user_post_id);
            }
            if (z2) {
                SparseArray sparseArray4 = new SparseArray();
                sparseArray4.put(R.id.tag_should_manage_visible, true);
                sparseArray4.put(R.id.tag_manage_user_identity, sparseArray.get(R.id.tag_manage_user_identity));
                sparseArray4.put(R.id.tag_forbid_user_name, sparseArray.get(R.id.tag_forbid_user_name));
                sparseArray4.put(R.id.tag_forbid_user_name_show, sparseArray.get(R.id.tag_forbid_user_name_show));
                sparseArray4.put(R.id.tag_forbid_user_portrait, sparseArray.get(R.id.tag_forbid_user_portrait));
                sparseArray4.put(R.id.tag_forbid_user_post_id, str);
                if (z8) {
                    sparseArray4.put(R.id.tag_user_mute_visible, true);
                    sparseArray4.put(R.id.tag_is_mem, sparseArray.get(R.id.tag_is_mem));
                    sparseArray4.put(R.id.tag_user_mute_mute_userid, sparseArray.get(R.id.tag_user_mute_mute_userid));
                    sparseArray4.put(R.id.tag_user_mute_mute_username, sparseArray.get(R.id.tag_user_mute_mute_username));
                    sparseArray4.put(R.id.tag_user_mute_mute_nameshow, sparseArray.get(R.id.tag_user_mute_mute_nameshow));
                    sparseArray4.put(R.id.tag_user_mute_post_id, sparseArray.get(R.id.tag_user_mute_post_id));
                    sparseArray4.put(R.id.tag_user_mute_thread_id, sparseArray.get(R.id.tag_user_mute_thread_id));
                } else {
                    sparseArray4.put(R.id.tag_user_mute_visible, false);
                }
                if (z9) {
                    sparseArray4.put(R.id.tag_should_delete_visible, true);
                    sparseArray4.put(R.id.tag_del_post_is_self, Boolean.valueOf(z3));
                    sparseArray4.put(R.id.tag_del_post_id, sparseArray.get(R.id.tag_del_post_id));
                    sparseArray4.put(R.id.tag_del_post_type, sparseArray.get(R.id.tag_del_post_type));
                    clY().setVisibility(0);
                } else {
                    sparseArray4.put(R.id.tag_should_delete_visible, false);
                    clY().setVisibility(8);
                }
                clW().setTag(sparseArray4);
                clY().setTag(sparseArray4);
                clW().setText(R.string.bar_manager);
                clW().setVisibility(0);
            } else if (z9) {
                SparseArray sparseArray5 = new SparseArray();
                sparseArray5.put(R.id.tag_should_manage_visible, false);
                sparseArray5.put(R.id.tag_user_mute_visible, false);
                sparseArray5.put(R.id.tag_should_delete_visible, true);
                sparseArray5.put(R.id.tag_manage_user_identity, sparseArray.get(R.id.tag_manage_user_identity));
                sparseArray5.put(R.id.tag_del_post_is_self, Boolean.valueOf(z3));
                sparseArray5.put(R.id.tag_del_post_id, sparseArray.get(R.id.tag_del_post_id));
                sparseArray5.put(R.id.tag_del_post_type, sparseArray.get(R.id.tag_del_post_type));
                clW().setTag(sparseArray5);
                clY().setTag(sparseArray5);
                clW().setText(R.string.delete);
                clY().setVisibility(0);
                if (i == 1002 && !z3) {
                    clY().setText(R.string.report_text);
                } else {
                    clY().setText(R.string.delete);
                }
                clW().setVisibility(8);
            } else {
                clW().setVisibility(8);
                clY().setVisibility(8);
            }
            if (!(sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean)) {
                z4 = false;
            } else {
                z4 = ((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue();
            }
            boolean z10 = false;
            if (sparseArray.get(R.id.tag_should_manage_visible) instanceof Boolean) {
                z10 = ((Boolean) sparseArray.get(R.id.tag_should_manage_visible)).booleanValue();
            }
            if (!z10 && z4) {
                SparseArray sparseArray6 = new SparseArray();
                sparseArray6.put(R.id.tag_user_mute_visible, true);
                sparseArray6.put(R.id.tag_is_mem, sparseArray.get(R.id.tag_is_mem));
                sparseArray6.put(R.id.tag_user_mute_mute_userid, sparseArray.get(R.id.tag_user_mute_mute_userid));
                sparseArray6.put(R.id.tag_user_mute_mute_username, sparseArray.get(R.id.tag_user_mute_mute_username));
                sparseArray6.put(R.id.tag_user_mute_mute_nameshow, sparseArray.get(R.id.tag_user_mute_mute_nameshow));
                sparseArray6.put(R.id.tag_user_mute_post_id, sparseArray.get(R.id.tag_user_mute_post_id));
                sparseArray6.put(R.id.tag_user_mute_thread_id, sparseArray.get(R.id.tag_user_mute_thread_id));
                sparseArray6.put(R.id.tag_del_post_is_self, sparseArray.get(R.id.tag_del_post_is_self));
                sparseArray6.put(R.id.tag_del_post_type, sparseArray.get(R.id.tag_del_post_type));
                sparseArray6.put(R.id.tag_del_post_id, sparseArray.get(R.id.tag_del_post_id));
                sparseArray6.put(R.id.tag_manage_user_identity, sparseArray.get(R.id.tag_manage_user_identity));
                clX().setTag(sparseArray6);
                clX().setVisibility(0);
                clW().setVisibility(8);
                clX().setText(R.string.mute_option);
            } else {
                if (sparseArray.get(R.id.tag_del_post_is_self) instanceof Boolean) {
                    ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue();
                }
                String str2 = null;
                if (sparseArray.get(R.id.tag_forbid_user_post_id) instanceof String) {
                    str2 = (String) sparseArray.get(R.id.tag_forbid_user_post_id);
                }
                if (ap.o(postData)) {
                    z = false;
                }
                if (z) {
                    clX().setVisibility(0);
                    clX().setTag(str2);
                } else {
                    clX().setVisibility(8);
                }
            }
            long j = 0;
            String str3 = "";
            if (!(sparseArray.get(R.id.tag_should_hide_chudian_visible) instanceof Boolean)) {
                z5 = false;
            } else {
                z5 = ((Boolean) sparseArray.get(R.id.tag_should_hide_chudian_visible)).booleanValue();
            }
            if (sparseArray.get(R.id.tag_chudian_template_id) instanceof Long) {
                j = ((Long) sparseArray.get(R.id.tag_chudian_template_id)).longValue();
            }
            if (sparseArray.get(R.id.tag_chudian_monitor_id) instanceof String) {
                str3 = (String) sparseArray.get(R.id.tag_chudian_monitor_id);
            }
            if (!(sparseArray.get(R.id.tag_chudian_hide_day) instanceof Integer)) {
                i2 = 0;
            } else {
                i2 = ((Integer) sparseArray.get(R.id.tag_chudian_hide_day)).intValue();
            }
            if (z5) {
                cma().setVisibility(0);
                cma().setTag(R.id.tag_chudian_template_id, Long.valueOf(j));
                cma().setTag(R.id.tag_chudian_monitor_id, str3);
                cma().setTag(R.id.tag_chudian_hide_day, Integer.valueOf(i2));
            } else {
                cma().setVisibility(8);
            }
            if (!(sparseArray.get(R.id.tag_richtext_emotion) instanceof Boolean)) {
                z6 = false;
            } else {
                z6 = ((Boolean) sparseArray.get(R.id.tag_richtext_emotion)).booleanValue();
                if (this.cQU.getPageActivity() instanceof NewSubPbActivity) {
                    NewSubPbActivity newSubPbActivity = (NewSubPbActivity) this.cQU.getPageActivity();
                    z6 = (!z6 || newSubPbActivity.coP() == null || newSubPbActivity.coP().cpn() == null || newSubPbActivity.coP().cpn().axx() == null || newSubPbActivity.coP().cpn().axx().isBjh()) ? false : true;
                }
            }
            if (!(sparseArray.get(R.id.tag_richtext_image) instanceof Boolean)) {
                z7 = false;
            } else {
                z7 = ((Boolean) sparseArray.get(R.id.tag_richtext_image)).booleanValue();
            }
            if (z6) {
                cmb().setVisibility(0);
            } else {
                cmb().setVisibility(8);
            }
            if (z7) {
                cmc().setVisibility(0);
            } else {
                cmc().setVisibility(8);
            }
            if (z6 || z7) {
                clZ().setVisibility(8);
            } else {
                clZ().setVisibility(0);
            }
        }
    }
}
