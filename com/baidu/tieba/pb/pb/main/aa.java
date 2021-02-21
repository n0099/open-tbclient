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
/* loaded from: classes2.dex */
public class aa extends com.baidu.tbadk.core.dialog.i {
    private TbPageContext<?> eUY;
    private View.OnClickListener jdG;
    private TextView lWA;
    private TextView lWB;
    private TextView lWC;
    private TextView lWD;
    private TextView lWE;
    private TextView lWF;
    private TextView lWG;
    private boolean lWH;
    private TextView lWy;
    private TextView lWz;

    public aa(TbPageContext<?> tbPageContext, View.OnClickListener onClickListener) {
        super(tbPageContext);
        this.lWH = false;
        this.eUY = tbPageContext;
        this.jdG = onClickListener;
        aqg();
    }

    public TextView dpB() {
        return this.lWy;
    }

    public TextView dpC() {
        return this.lWz;
    }

    public TextView dpD() {
        return this.lWA;
    }

    public TextView dpE() {
        return this.lWB;
    }

    public TextView dpF() {
        return this.lWC;
    }

    public TextView dpG() {
        return this.lWF;
    }

    public TextView dpH() {
        return this.lWD;
    }

    public TextView dpI() {
        return this.lWE;
    }

    public TextView dpJ() {
        return this.lWG;
    }

    private void aqg() {
        a((String) null, new String[]{this.eUY.getString(R.string.action_dislike), this.eUY.getString(R.string.no_interesting), this.eUY.getString(R.string.save_to_emotion), this.eUY.getString(R.string.save_to_local), this.eUY.getString(R.string.copy), this.eUY.getString(R.string.mark), this.eUY.getString(R.string.report_text), this.eUY.getString(R.string.delete), this.eUY.getString(R.string.mute)}, new k.c() { // from class: com.baidu.tieba.pb.pb.main.aa.1
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(com.baidu.tbadk.core.dialog.k kVar, int i, View view) {
                aa.this.dismiss();
                aa.this.jdG.onClick(view);
            }
        });
        this.lWF = dK(getItemView(1));
        this.lWy = dK(getItemView(5));
        this.lWz = dK(getItemView(8));
        this.lWA = dK(getItemView(6));
        this.lWB = dK(getItemView(7));
        this.lWC = dK(getItemView(4));
        this.lWD = dK(getItemView(2));
        this.lWE = dK(getItemView(3));
        this.lWG = dK(getItemView(0));
    }

    private TextView dK(View view) {
        return (TextView) view.findViewById(R.id.item_view);
    }

    public void vp(boolean z) {
        this.lWA.setVisibility(z ? 0 : 8);
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
            dpB().setTag(sparseArray2);
            SparseArray sparseArray3 = new SparseArray();
            sparseArray3.put(R.id.tag_clip_board, (PostData) sparseArray.get(R.id.tag_clip_board));
            dpF().setTag(sparseArray3);
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
                    dpE().setVisibility(0);
                } else {
                    sparseArray4.put(R.id.tag_should_delete_visible, false);
                    dpE().setVisibility(8);
                }
                dpC().setTag(sparseArray4);
                dpE().setTag(sparseArray4);
                dpC().setText(R.string.bar_manager);
                dpC().setVisibility(0);
            } else if (booleanValue3) {
                SparseArray sparseArray5 = new SparseArray();
                sparseArray5.put(R.id.tag_should_manage_visible, false);
                sparseArray5.put(R.id.tag_user_mute_visible, false);
                sparseArray5.put(R.id.tag_should_delete_visible, true);
                sparseArray5.put(R.id.tag_manage_user_identity, sparseArray.get(R.id.tag_manage_user_identity));
                sparseArray5.put(R.id.tag_del_post_is_self, Boolean.valueOf(booleanValue4));
                sparseArray5.put(R.id.tag_del_post_id, sparseArray.get(R.id.tag_del_post_id));
                sparseArray5.put(R.id.tag_del_post_type, sparseArray.get(R.id.tag_del_post_type));
                dpC().setTag(sparseArray5);
                dpE().setTag(sparseArray5);
                dpC().setText(R.string.delete);
                dpE().setVisibility(0);
                if (i == 1002 && !booleanValue4) {
                    dpE().setText(R.string.report_text);
                } else {
                    dpE().setText(R.string.delete);
                }
                dpC().setVisibility(8);
            } else {
                dpC().setVisibility(8);
                dpE().setVisibility(8);
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
                dpD().setTag(sparseArray6);
                dpD().setVisibility(0);
                dpC().setVisibility(8);
                dpD().setText(R.string.mute_option);
            } else {
                if (sparseArray.get(R.id.tag_del_post_is_self) instanceof Boolean) {
                    ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue();
                }
                String str2 = sparseArray.get(R.id.tag_forbid_user_post_id) instanceof String ? (String) sparseArray.get(R.id.tag_forbid_user_post_id) : null;
                if (z) {
                    dpD().setVisibility(0);
                    dpD().setTag(str2);
                } else {
                    dpD().setVisibility(8);
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
                dpG().setVisibility(0);
                dpG().setTag(R.id.tag_chudian_template_id, Long.valueOf(j));
                dpG().setTag(R.id.tag_chudian_monitor_id, str3);
                dpG().setTag(R.id.tag_chudian_hide_day, Integer.valueOf(intValue));
            } else {
                dpG().setVisibility(8);
            }
            if (sparseArray.get(R.id.tag_richtext_emotion) instanceof Boolean) {
                z3 = ((Boolean) sparseArray.get(R.id.tag_richtext_emotion)).booleanValue();
                if (this.eUY.getPageActivity() instanceof NewSubPbActivity) {
                    NewSubPbActivity newSubPbActivity = (NewSubPbActivity) this.eUY.getPageActivity();
                    z3 = (!z3 || newSubPbActivity.dsH() == null || newSubPbActivity.dsH().dtg() == null || newSubPbActivity.dsH().dtg().bln() == null || newSubPbActivity.dsH().dtg().bln().isBjh()) ? false : true;
                }
            } else {
                z3 = false;
            }
            boolean booleanValue7 = sparseArray.get(R.id.tag_richtext_image) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_richtext_image)).booleanValue() : false;
            if (z3) {
                dpH().setVisibility(0);
            } else {
                dpH().setVisibility(8);
            }
            if (booleanValue7) {
                dpI().setVisibility(0);
            } else {
                dpI().setVisibility(8);
            }
            if (z3 || booleanValue7) {
                dpF().setVisibility(8);
            } else {
                dpF().setVisibility(0);
            }
            dpJ().setVisibility(8);
            if (z2) {
                dpE().setVisibility(8);
                dpC().setVisibility(8);
                dpD().setVisibility(8);
            }
        }
    }

    public void a(SparseArray<Object> sparseArray, int i, boolean z) {
        if (sparseArray != null) {
            PostData postData = (PostData) sparseArray.get(R.id.tag_clip_board);
            if (postData.bpJ() != null) {
                String string = (postData.bpJ().hasAgree && postData.bpt() == 5) ? this.eUY.getString(R.string.action_cancel_dislike) : this.eUY.getString(R.string.action_dislike);
                SparseArray sparseArray2 = new SparseArray();
                sparseArray2.put(R.id.tag_clip_board, postData);
                dpJ().setTag(sparseArray2);
                dpJ().setVisibility(0);
                dpJ().setText(string);
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
                    dpE().setVisibility(0);
                } else {
                    sparseArray3.put(R.id.tag_should_delete_visible, false);
                    dpE().setVisibility(8);
                }
                dpC().setTag(sparseArray3);
                dpE().setTag(sparseArray3);
                dpC().setText(R.string.bar_manager);
                dpC().setVisibility(0);
            } else if (booleanValue3) {
                SparseArray sparseArray4 = new SparseArray();
                sparseArray4.put(R.id.tag_should_manage_visible, false);
                sparseArray4.put(R.id.tag_user_mute_visible, false);
                sparseArray4.put(R.id.tag_should_delete_visible, true);
                sparseArray4.put(R.id.tag_manage_user_identity, sparseArray.get(R.id.tag_manage_user_identity));
                sparseArray4.put(R.id.tag_del_post_is_self, Boolean.valueOf(booleanValue4));
                sparseArray4.put(R.id.tag_del_post_id, sparseArray.get(R.id.tag_del_post_id));
                sparseArray4.put(R.id.tag_del_post_type, sparseArray.get(R.id.tag_del_post_type));
                dpC().setTag(sparseArray4);
                dpE().setTag(sparseArray4);
                dpC().setText(R.string.delete);
                dpE().setVisibility(0);
                if (i == 1002 && !booleanValue4) {
                    dpE().setText(R.string.report_text);
                } else {
                    dpE().setText(R.string.delete);
                }
                dpC().setVisibility(8);
            } else {
                dpC().setVisibility(8);
                dpE().setVisibility(8);
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
                dpD().setTag(sparseArray5);
                dpD().setVisibility(0);
                dpC().setVisibility(8);
                dpD().setText(R.string.mute_option);
            } else {
                if (sparseArray.get(R.id.tag_del_post_is_self) instanceof Boolean) {
                    ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue();
                }
                String str2 = sparseArray.get(R.id.tag_forbid_user_post_id) instanceof String ? (String) sparseArray.get(R.id.tag_forbid_user_post_id) : null;
                if (z) {
                    dpD().setVisibility(0);
                    dpD().setTag(str2);
                } else {
                    dpD().setVisibility(8);
                }
            }
            dpG().setVisibility(8);
            dpF().setVisibility(8);
            dpH().setVisibility(8);
            dpB().setVisibility(8);
            dpI().setVisibility(8);
        }
    }
}
