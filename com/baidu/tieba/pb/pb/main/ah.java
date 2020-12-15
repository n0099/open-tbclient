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
/* loaded from: classes22.dex */
public class ah extends com.baidu.tbadk.core.dialog.i {
    private TbPageContext<?> eNx;
    private View.OnClickListener iQg;
    private TextView lMF;
    private TextView lMG;
    private TextView lMH;
    private TextView lMI;
    private TextView lMJ;
    private TextView lMK;
    private TextView lML;
    private TextView lMM;
    private TextView lMN;
    private boolean lMO;

    public ah(TbPageContext<?> tbPageContext, View.OnClickListener onClickListener) {
        super(tbPageContext);
        this.lMO = false;
        this.eNx = tbPageContext;
        this.iQg = onClickListener;
        ask();
    }

    public TextView drl() {
        return this.lMF;
    }

    public TextView drm() {
        return this.lMG;
    }

    public TextView drn() {
        return this.lMH;
    }

    public TextView dro() {
        return this.lMI;
    }

    public TextView drp() {
        return this.lMJ;
    }

    public TextView drq() {
        return this.lMM;
    }

    public TextView drr() {
        return this.lMK;
    }

    public TextView drs() {
        return this.lML;
    }

    public TextView drt() {
        return this.lMN;
    }

    private void ask() {
        a((String) null, new String[]{this.eNx.getString(R.string.action_dislike), this.eNx.getString(R.string.no_interesting), this.eNx.getString(R.string.save_to_emotion), this.eNx.getString(R.string.save_to_local), this.eNx.getString(R.string.copy), this.eNx.getString(R.string.mark), this.eNx.getString(R.string.report_text), this.eNx.getString(R.string.delete), this.eNx.getString(R.string.mute)}, new k.c() { // from class: com.baidu.tieba.pb.pb.main.ah.1
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(com.baidu.tbadk.core.dialog.k kVar, int i, View view) {
                ah.this.dismiss();
                ah.this.iQg.onClick(view);
            }
        });
        this.lMM = dC(getItemView(1));
        this.lMF = dC(getItemView(5));
        this.lMG = dC(getItemView(8));
        this.lMH = dC(getItemView(6));
        this.lMI = dC(getItemView(7));
        this.lMJ = dC(getItemView(4));
        this.lMK = dC(getItemView(2));
        this.lML = dC(getItemView(3));
        this.lMN = dC(getItemView(0));
    }

    private TextView dC(View view) {
        return (TextView) view.findViewById(R.id.item_view);
    }

    public void vd(boolean z) {
        this.lMH.setVisibility(z ? 0 : 8);
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

    public void a(SparseArray<Object> sparseArray, int i, boolean z, boolean z2) {
        boolean z3;
        if (sparseArray != null) {
            PostData postData = (PostData) sparseArray.get(R.id.tag_clip_board);
            SparseArray sparseArray2 = new SparseArray();
            sparseArray2.put(R.id.tag_clip_board, (PostData) sparseArray.get(R.id.tag_clip_board));
            sparseArray2.put(R.id.tag_is_subpb, false);
            drl().setTag(sparseArray2);
            SparseArray sparseArray3 = new SparseArray();
            sparseArray3.put(R.id.tag_clip_board, (PostData) sparseArray.get(R.id.tag_clip_board));
            drp().setTag(sparseArray3);
            boolean booleanValue = sparseArray.get(R.id.tag_should_manage_visible) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_should_manage_visible)).booleanValue() : false;
            boolean booleanValue2 = sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue() : false;
            boolean booleanValue3 = sparseArray.get(R.id.tag_should_delete_visible) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_should_delete_visible)).booleanValue() : false;
            boolean booleanValue4 = sparseArray.get(R.id.tag_del_post_is_self) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue() : false;
            String str = sparseArray.get(R.id.tag_forbid_user_post_id) instanceof String ? (String) sparseArray.get(R.id.tag_forbid_user_post_id) : null;
            if (booleanValue) {
                SparseArray sparseArray4 = new SparseArray();
                sparseArray4.put(R.id.tag_should_manage_visible, true);
                sparseArray4.put(R.id.tag_manage_user_identity, sparseArray.get(R.id.tag_manage_user_identity));
                sparseArray4.put(R.id.tag_forbid_user_name, sparseArray.get(R.id.tag_forbid_user_name));
                sparseArray4.put(R.id.tag_forbid_user_name_show, sparseArray.get(R.id.tag_forbid_user_name_show));
                sparseArray4.put(R.id.tag_forbid_user_portrait, sparseArray.get(R.id.tag_forbid_user_portrait));
                sparseArray4.put(R.id.tag_forbid_user_post_id, str);
                if (booleanValue2) {
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
                if (booleanValue3) {
                    sparseArray4.put(R.id.tag_should_delete_visible, true);
                    sparseArray4.put(R.id.tag_del_post_is_self, Boolean.valueOf(booleanValue4));
                    sparseArray4.put(R.id.tag_del_post_id, sparseArray.get(R.id.tag_del_post_id));
                    sparseArray4.put(R.id.tag_del_post_type, sparseArray.get(R.id.tag_del_post_type));
                    dro().setVisibility(0);
                } else {
                    sparseArray4.put(R.id.tag_should_delete_visible, false);
                    dro().setVisibility(8);
                }
                drm().setTag(sparseArray4);
                dro().setTag(sparseArray4);
                drm().setText(R.string.bar_manager);
                drm().setVisibility(0);
            } else if (booleanValue3) {
                SparseArray sparseArray5 = new SparseArray();
                sparseArray5.put(R.id.tag_should_manage_visible, false);
                sparseArray5.put(R.id.tag_user_mute_visible, false);
                sparseArray5.put(R.id.tag_should_delete_visible, true);
                sparseArray5.put(R.id.tag_manage_user_identity, sparseArray.get(R.id.tag_manage_user_identity));
                sparseArray5.put(R.id.tag_del_post_is_self, Boolean.valueOf(booleanValue4));
                sparseArray5.put(R.id.tag_del_post_id, sparseArray.get(R.id.tag_del_post_id));
                sparseArray5.put(R.id.tag_del_post_type, sparseArray.get(R.id.tag_del_post_type));
                drm().setTag(sparseArray5);
                dro().setTag(sparseArray5);
                drm().setText(R.string.delete);
                dro().setVisibility(0);
                if (i == 1002 && !booleanValue4) {
                    dro().setText(R.string.report_text);
                } else {
                    dro().setText(R.string.delete);
                }
                drm().setVisibility(8);
            } else {
                drm().setVisibility(8);
                dro().setVisibility(8);
            }
            boolean booleanValue5 = sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue() : false;
            if (!(sparseArray.get(R.id.tag_should_manage_visible) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_should_manage_visible)).booleanValue() : false) && booleanValue5) {
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
                drn().setTag(sparseArray6);
                drn().setVisibility(0);
                drm().setVisibility(8);
                drn().setText(R.string.mute_option);
            } else {
                if (sparseArray.get(R.id.tag_del_post_is_self) instanceof Boolean) {
                    ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue();
                }
                String str2 = sparseArray.get(R.id.tag_forbid_user_post_id) instanceof String ? (String) sparseArray.get(R.id.tag_forbid_user_post_id) : null;
                if (z) {
                    drn().setVisibility(0);
                    drn().setTag(str2);
                } else {
                    drn().setVisibility(8);
                }
            }
            long j = 0;
            String str3 = "";
            boolean booleanValue6 = sparseArray.get(R.id.tag_should_hide_chudian_visible) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_should_hide_chudian_visible)).booleanValue() : false;
            if (sparseArray.get(R.id.tag_chudian_template_id) instanceof Long) {
                j = ((Long) sparseArray.get(R.id.tag_chudian_template_id)).longValue();
            }
            if (sparseArray.get(R.id.tag_chudian_monitor_id) instanceof String) {
                str3 = (String) sparseArray.get(R.id.tag_chudian_monitor_id);
            }
            int intValue = sparseArray.get(R.id.tag_chudian_hide_day) instanceof Integer ? ((Integer) sparseArray.get(R.id.tag_chudian_hide_day)).intValue() : 0;
            if (booleanValue6) {
                drq().setVisibility(0);
                drq().setTag(R.id.tag_chudian_template_id, Long.valueOf(j));
                drq().setTag(R.id.tag_chudian_monitor_id, str3);
                drq().setTag(R.id.tag_chudian_hide_day, Integer.valueOf(intValue));
            } else {
                drq().setVisibility(8);
            }
            if (sparseArray.get(R.id.tag_richtext_emotion) instanceof Boolean) {
                z3 = ((Boolean) sparseArray.get(R.id.tag_richtext_emotion)).booleanValue();
                if (this.eNx.getPageActivity() instanceof NewSubPbActivity) {
                    NewSubPbActivity newSubPbActivity = (NewSubPbActivity) this.eNx.getPageActivity();
                    z3 = (!z3 || newSubPbActivity.duo() == null || newSubPbActivity.duo().duN() == null || newSubPbActivity.duo().duN().bmn() == null || newSubPbActivity.duo().duN().bmn().isBjh()) ? false : true;
                }
            } else {
                z3 = false;
            }
            boolean booleanValue7 = sparseArray.get(R.id.tag_richtext_image) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_richtext_image)).booleanValue() : false;
            if (z3) {
                drr().setVisibility(0);
            } else {
                drr().setVisibility(8);
            }
            if (booleanValue7) {
                drs().setVisibility(0);
            } else {
                drs().setVisibility(8);
            }
            if (z3 || booleanValue7) {
                drp().setVisibility(8);
            } else {
                drp().setVisibility(0);
            }
            drt().setVisibility(8);
            if (z2) {
                dro().setVisibility(8);
                drm().setVisibility(8);
                drn().setVisibility(8);
            }
        }
    }

    public void a(SparseArray<Object> sparseArray, int i, boolean z) {
        if (sparseArray != null) {
            PostData postData = (PostData) sparseArray.get(R.id.tag_clip_board);
            if (postData.bqI() != null) {
                String string = (postData.bqI().hasAgree && postData.bqs() == 5) ? this.eNx.getString(R.string.action_cancel_dislike) : this.eNx.getString(R.string.action_dislike);
                SparseArray sparseArray2 = new SparseArray();
                sparseArray2.put(R.id.tag_clip_board, postData);
                drt().setTag(sparseArray2);
                drt().setVisibility(0);
                drt().setText(string);
            }
            boolean booleanValue = sparseArray.get(R.id.tag_should_manage_visible) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_should_manage_visible)).booleanValue() : false;
            boolean booleanValue2 = sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue() : false;
            boolean booleanValue3 = sparseArray.get(R.id.tag_should_delete_visible) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_should_delete_visible)).booleanValue() : false;
            boolean booleanValue4 = sparseArray.get(R.id.tag_del_post_is_self) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue() : false;
            String str = sparseArray.get(R.id.tag_forbid_user_post_id) instanceof String ? (String) sparseArray.get(R.id.tag_forbid_user_post_id) : null;
            if (booleanValue) {
                SparseArray sparseArray3 = new SparseArray();
                sparseArray3.put(R.id.tag_should_manage_visible, true);
                sparseArray3.put(R.id.tag_manage_user_identity, sparseArray.get(R.id.tag_manage_user_identity));
                sparseArray3.put(R.id.tag_forbid_user_name, sparseArray.get(R.id.tag_forbid_user_name));
                sparseArray3.put(R.id.tag_forbid_user_name_show, sparseArray.get(R.id.tag_forbid_user_name_show));
                sparseArray3.put(R.id.tag_forbid_user_portrait, sparseArray.get(R.id.tag_forbid_user_portrait));
                sparseArray3.put(R.id.tag_forbid_user_post_id, str);
                if (booleanValue2) {
                    sparseArray3.put(R.id.tag_user_mute_visible, true);
                    sparseArray3.put(R.id.tag_is_mem, sparseArray.get(R.id.tag_is_mem));
                    sparseArray3.put(R.id.tag_user_mute_mute_userid, sparseArray.get(R.id.tag_user_mute_mute_userid));
                    sparseArray3.put(R.id.tag_user_mute_mute_username, sparseArray.get(R.id.tag_user_mute_mute_username));
                    sparseArray3.put(R.id.tag_user_mute_mute_nameshow, sparseArray.get(R.id.tag_user_mute_mute_nameshow));
                    sparseArray3.put(R.id.tag_user_mute_post_id, sparseArray.get(R.id.tag_user_mute_post_id));
                    sparseArray3.put(R.id.tag_user_mute_thread_id, sparseArray.get(R.id.tag_user_mute_thread_id));
                } else {
                    sparseArray3.put(R.id.tag_user_mute_visible, false);
                }
                if (booleanValue3) {
                    sparseArray3.put(R.id.tag_should_delete_visible, true);
                    sparseArray3.put(R.id.tag_del_post_is_self, Boolean.valueOf(booleanValue4));
                    sparseArray3.put(R.id.tag_del_post_id, sparseArray.get(R.id.tag_del_post_id));
                    sparseArray3.put(R.id.tag_del_post_type, sparseArray.get(R.id.tag_del_post_type));
                    dro().setVisibility(0);
                } else {
                    sparseArray3.put(R.id.tag_should_delete_visible, false);
                    dro().setVisibility(8);
                }
                drm().setTag(sparseArray3);
                dro().setTag(sparseArray3);
                drm().setText(R.string.bar_manager);
                drm().setVisibility(0);
            } else if (booleanValue3) {
                SparseArray sparseArray4 = new SparseArray();
                sparseArray4.put(R.id.tag_should_manage_visible, false);
                sparseArray4.put(R.id.tag_user_mute_visible, false);
                sparseArray4.put(R.id.tag_should_delete_visible, true);
                sparseArray4.put(R.id.tag_manage_user_identity, sparseArray.get(R.id.tag_manage_user_identity));
                sparseArray4.put(R.id.tag_del_post_is_self, Boolean.valueOf(booleanValue4));
                sparseArray4.put(R.id.tag_del_post_id, sparseArray.get(R.id.tag_del_post_id));
                sparseArray4.put(R.id.tag_del_post_type, sparseArray.get(R.id.tag_del_post_type));
                drm().setTag(sparseArray4);
                dro().setTag(sparseArray4);
                drm().setText(R.string.delete);
                dro().setVisibility(0);
                if (i == 1002 && !booleanValue4) {
                    dro().setText(R.string.report_text);
                } else {
                    dro().setText(R.string.delete);
                }
                drm().setVisibility(8);
            } else {
                drm().setVisibility(8);
                dro().setVisibility(8);
            }
            boolean booleanValue5 = sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue() : false;
            if (!(sparseArray.get(R.id.tag_should_manage_visible) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_should_manage_visible)).booleanValue() : false) && booleanValue5) {
                SparseArray sparseArray5 = new SparseArray();
                sparseArray5.put(R.id.tag_user_mute_visible, true);
                sparseArray5.put(R.id.tag_is_mem, sparseArray.get(R.id.tag_is_mem));
                sparseArray5.put(R.id.tag_user_mute_mute_userid, sparseArray.get(R.id.tag_user_mute_mute_userid));
                sparseArray5.put(R.id.tag_user_mute_mute_username, sparseArray.get(R.id.tag_user_mute_mute_username));
                sparseArray5.put(R.id.tag_user_mute_mute_nameshow, sparseArray.get(R.id.tag_user_mute_mute_nameshow));
                sparseArray5.put(R.id.tag_user_mute_post_id, sparseArray.get(R.id.tag_user_mute_post_id));
                sparseArray5.put(R.id.tag_user_mute_thread_id, sparseArray.get(R.id.tag_user_mute_thread_id));
                sparseArray5.put(R.id.tag_del_post_is_self, sparseArray.get(R.id.tag_del_post_is_self));
                sparseArray5.put(R.id.tag_del_post_type, sparseArray.get(R.id.tag_del_post_type));
                sparseArray5.put(R.id.tag_del_post_id, sparseArray.get(R.id.tag_del_post_id));
                sparseArray5.put(R.id.tag_manage_user_identity, sparseArray.get(R.id.tag_manage_user_identity));
                drn().setTag(sparseArray5);
                drn().setVisibility(0);
                drm().setVisibility(8);
                drn().setText(R.string.mute_option);
            } else {
                if (sparseArray.get(R.id.tag_del_post_is_self) instanceof Boolean) {
                    ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue();
                }
                String str2 = sparseArray.get(R.id.tag_forbid_user_post_id) instanceof String ? (String) sparseArray.get(R.id.tag_forbid_user_post_id) : null;
                if (z) {
                    drn().setVisibility(0);
                    drn().setTag(str2);
                } else {
                    drn().setVisibility(8);
                }
            }
            drq().setVisibility(8);
            drp().setVisibility(8);
            drr().setVisibility(8);
            drl().setVisibility(8);
            drs().setVisibility(8);
        }
    }
}
