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
/* loaded from: classes16.dex */
public class ah extends com.baidu.tbadk.core.dialog.i {
    private TbPageContext<?> efn;
    private View.OnClickListener hPY;
    private TextView kIf;
    private TextView kIg;
    private TextView kIh;
    private TextView kIi;
    private TextView kIj;
    private TextView kIk;
    private TextView kIl;
    private TextView kIm;
    private TextView kIn;
    private boolean kIo;

    public ah(TbPageContext<?> tbPageContext, View.OnClickListener onClickListener) {
        super(tbPageContext);
        this.kIo = false;
        this.efn = tbPageContext;
        this.hPY = onClickListener;
        ahV();
    }

    public TextView cZA() {
        return this.kIf;
    }

    public TextView cZB() {
        return this.kIg;
    }

    public TextView cZC() {
        return this.kIh;
    }

    public TextView cZD() {
        return this.kIi;
    }

    public TextView cZE() {
        return this.kIj;
    }

    public TextView cZF() {
        return this.kIm;
    }

    public TextView cZG() {
        return this.kIk;
    }

    public TextView cZH() {
        return this.kIl;
    }

    public TextView cZI() {
        return this.kIn;
    }

    private void ahV() {
        a((String) null, new String[]{this.efn.getString(R.string.action_dislike), this.efn.getString(R.string.no_interesting), this.efn.getString(R.string.save_to_emotion), this.efn.getString(R.string.save_to_local), this.efn.getString(R.string.copy), this.efn.getString(R.string.mark), this.efn.getString(R.string.report_text), this.efn.getString(R.string.delete), this.efn.getString(R.string.mute)}, new k.c() { // from class: com.baidu.tieba.pb.pb.main.ah.1
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(com.baidu.tbadk.core.dialog.k kVar, int i, View view) {
                ah.this.dismiss();
                ah.this.hPY.onClick(view);
            }
        });
        this.kIm = cS(getItemView(1));
        this.kIf = cS(getItemView(5));
        this.kIg = cS(getItemView(8));
        this.kIh = cS(getItemView(6));
        this.kIi = cS(getItemView(7));
        this.kIj = cS(getItemView(4));
        this.kIk = cS(getItemView(2));
        this.kIl = cS(getItemView(3));
        this.kIn = cS(getItemView(0));
    }

    private TextView cS(View view) {
        return (TextView) view.findViewById(R.id.item_view);
    }

    public void ti(boolean z) {
        this.kIh.setVisibility(z ? 0 : 8);
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
            cZA().setTag(sparseArray2);
            SparseArray sparseArray3 = new SparseArray();
            sparseArray3.put(R.id.tag_clip_board, (PostData) sparseArray.get(R.id.tag_clip_board));
            cZE().setTag(sparseArray3);
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
                    cZD().setVisibility(0);
                } else {
                    sparseArray4.put(R.id.tag_should_delete_visible, false);
                    cZD().setVisibility(8);
                }
                cZB().setTag(sparseArray4);
                cZD().setTag(sparseArray4);
                cZB().setText(R.string.bar_manager);
                cZB().setVisibility(0);
            } else if (booleanValue3) {
                SparseArray sparseArray5 = new SparseArray();
                sparseArray5.put(R.id.tag_should_manage_visible, false);
                sparseArray5.put(R.id.tag_user_mute_visible, false);
                sparseArray5.put(R.id.tag_should_delete_visible, true);
                sparseArray5.put(R.id.tag_manage_user_identity, sparseArray.get(R.id.tag_manage_user_identity));
                sparseArray5.put(R.id.tag_del_post_is_self, Boolean.valueOf(booleanValue4));
                sparseArray5.put(R.id.tag_del_post_id, sparseArray.get(R.id.tag_del_post_id));
                sparseArray5.put(R.id.tag_del_post_type, sparseArray.get(R.id.tag_del_post_type));
                cZB().setTag(sparseArray5);
                cZD().setTag(sparseArray5);
                cZB().setText(R.string.delete);
                cZD().setVisibility(0);
                if (i == 1002 && !booleanValue4) {
                    cZD().setText(R.string.report_text);
                } else {
                    cZD().setText(R.string.delete);
                }
                cZB().setVisibility(8);
            } else {
                cZB().setVisibility(8);
                cZD().setVisibility(8);
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
                cZC().setTag(sparseArray6);
                cZC().setVisibility(0);
                cZB().setVisibility(8);
                cZC().setText(R.string.mute_option);
            } else {
                if (sparseArray.get(R.id.tag_del_post_is_self) instanceof Boolean) {
                    ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue();
                }
                String str2 = sparseArray.get(R.id.tag_forbid_user_post_id) instanceof String ? (String) sparseArray.get(R.id.tag_forbid_user_post_id) : null;
                if (z) {
                    cZC().setVisibility(0);
                    cZC().setTag(str2);
                } else {
                    cZC().setVisibility(8);
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
                cZF().setVisibility(0);
                cZF().setTag(R.id.tag_chudian_template_id, Long.valueOf(j));
                cZF().setTag(R.id.tag_chudian_monitor_id, str3);
                cZF().setTag(R.id.tag_chudian_hide_day, Integer.valueOf(intValue));
            } else {
                cZF().setVisibility(8);
            }
            if (sparseArray.get(R.id.tag_richtext_emotion) instanceof Boolean) {
                z3 = ((Boolean) sparseArray.get(R.id.tag_richtext_emotion)).booleanValue();
                if (this.efn.getPageActivity() instanceof NewSubPbActivity) {
                    NewSubPbActivity newSubPbActivity = (NewSubPbActivity) this.efn.getPageActivity();
                    z3 = (!z3 || newSubPbActivity.dcy() == null || newSubPbActivity.dcy().dcX() == null || newSubPbActivity.dcy().dcX().bce() == null || newSubPbActivity.dcy().dcX().bce().isBjh()) ? false : true;
                }
            } else {
                z3 = false;
            }
            boolean booleanValue7 = sparseArray.get(R.id.tag_richtext_image) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_richtext_image)).booleanValue() : false;
            if (z3) {
                cZG().setVisibility(0);
            } else {
                cZG().setVisibility(8);
            }
            if (booleanValue7) {
                cZH().setVisibility(0);
            } else {
                cZH().setVisibility(8);
            }
            if (z3 || booleanValue7) {
                cZE().setVisibility(8);
            } else {
                cZE().setVisibility(0);
            }
            cZI().setVisibility(8);
            if (z2) {
                cZD().setVisibility(8);
                cZB().setVisibility(8);
                cZC().setVisibility(8);
            }
        }
    }

    public void a(SparseArray<Object> sparseArray, int i, boolean z) {
        if (sparseArray != null) {
            PostData postData = (PostData) sparseArray.get(R.id.tag_clip_board);
            if (postData.bgv() != null) {
                String string = (postData.bgv().hasAgree && postData.bgf() == 5) ? this.efn.getString(R.string.action_cancel_dislike) : this.efn.getString(R.string.action_dislike);
                SparseArray sparseArray2 = new SparseArray();
                sparseArray2.put(R.id.tag_clip_board, postData);
                cZI().setTag(sparseArray2);
                cZI().setVisibility(0);
                cZI().setText(string);
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
                    cZD().setVisibility(0);
                } else {
                    sparseArray3.put(R.id.tag_should_delete_visible, false);
                    cZD().setVisibility(8);
                }
                cZB().setTag(sparseArray3);
                cZD().setTag(sparseArray3);
                cZB().setText(R.string.bar_manager);
                cZB().setVisibility(0);
            } else if (booleanValue3) {
                SparseArray sparseArray4 = new SparseArray();
                sparseArray4.put(R.id.tag_should_manage_visible, false);
                sparseArray4.put(R.id.tag_user_mute_visible, false);
                sparseArray4.put(R.id.tag_should_delete_visible, true);
                sparseArray4.put(R.id.tag_manage_user_identity, sparseArray.get(R.id.tag_manage_user_identity));
                sparseArray4.put(R.id.tag_del_post_is_self, Boolean.valueOf(booleanValue4));
                sparseArray4.put(R.id.tag_del_post_id, sparseArray.get(R.id.tag_del_post_id));
                sparseArray4.put(R.id.tag_del_post_type, sparseArray.get(R.id.tag_del_post_type));
                cZB().setTag(sparseArray4);
                cZD().setTag(sparseArray4);
                cZB().setText(R.string.delete);
                cZD().setVisibility(0);
                if (i == 1002 && !booleanValue4) {
                    cZD().setText(R.string.report_text);
                } else {
                    cZD().setText(R.string.delete);
                }
                cZB().setVisibility(8);
            } else {
                cZB().setVisibility(8);
                cZD().setVisibility(8);
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
                cZC().setTag(sparseArray5);
                cZC().setVisibility(0);
                cZB().setVisibility(8);
                cZC().setText(R.string.mute_option);
            } else {
                if (sparseArray.get(R.id.tag_del_post_is_self) instanceof Boolean) {
                    ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue();
                }
                String str2 = sparseArray.get(R.id.tag_forbid_user_post_id) instanceof String ? (String) sparseArray.get(R.id.tag_forbid_user_post_id) : null;
                if (z) {
                    cZC().setVisibility(0);
                    cZC().setTag(str2);
                } else {
                    cZC().setVisibility(8);
                }
            }
            cZF().setVisibility(8);
            cZE().setVisibility(8);
            cZG().setVisibility(8);
            cZA().setVisibility(8);
            cZH().setVisibility(8);
        }
    }
}
