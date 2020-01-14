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
/* loaded from: classes7.dex */
public class z extends com.baidu.tbadk.core.dialog.i {
    private TbPageContext<?> cRe;
    private View.OnClickListener gjH;
    private TextView iJS;
    private TextView iJT;
    private TextView iJU;
    private TextView iJV;
    private TextView iJW;
    private TextView iJX;
    private TextView iJY;
    private TextView iJZ;
    private boolean iKa;

    public z(TbPageContext<?> tbPageContext, View.OnClickListener onClickListener) {
        super(tbPageContext);
        this.iKa = false;
        this.cRe = tbPageContext;
        this.gjH = onClickListener;
        MI();
    }

    public TextView cnc() {
        return this.iJS;
    }

    public TextView cnd() {
        return this.iJT;
    }

    public TextView cne() {
        return this.iJU;
    }

    public TextView cnf() {
        return this.iJV;
    }

    public TextView cng() {
        return this.iJW;
    }

    public TextView cnh() {
        return this.iJZ;
    }

    public TextView cni() {
        return this.iJX;
    }

    public TextView cnj() {
        return this.iJY;
    }

    private void MI() {
        a((String) null, new String[]{this.cRe.getString(R.string.no_interesting), this.cRe.getString(R.string.save_to_emotion), this.cRe.getString(R.string.save_to_local), this.cRe.getString(R.string.copy), this.cRe.getString(R.string.mark), this.cRe.getString(R.string.report_text), this.cRe.getString(R.string.delete), this.cRe.getString(R.string.mute)}, new k.c() { // from class: com.baidu.tieba.pb.pb.main.z.1
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(com.baidu.tbadk.core.dialog.k kVar, int i, View view) {
                z.this.dismiss();
                z.this.gjH.onClick(view);
            }
        });
        this.iJZ = cA(getItemView(0));
        this.iJS = cA(getItemView(4));
        this.iJT = cA(getItemView(7));
        this.iJU = cA(getItemView(5));
        this.iJV = cA(getItemView(6));
        this.iJW = cA(getItemView(3));
        this.iJX = cA(getItemView(1));
        this.iJY = cA(getItemView(2));
    }

    private TextView cA(View view) {
        return (TextView) view.findViewById(R.id.item_view);
    }

    public void pV(boolean z) {
        this.iJU.setVisibility(z ? 0 : 8);
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
            cnc().setTag(sparseArray2);
            SparseArray sparseArray3 = new SparseArray();
            sparseArray3.put(R.id.tag_clip_board, (PostData) sparseArray.get(R.id.tag_clip_board));
            cng().setTag(sparseArray3);
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
                    cnf().setVisibility(0);
                } else {
                    sparseArray4.put(R.id.tag_should_delete_visible, false);
                    cnf().setVisibility(8);
                }
                cnd().setTag(sparseArray4);
                cnf().setTag(sparseArray4);
                cnd().setText(R.string.bar_manager);
                cnd().setVisibility(0);
            } else if (z9) {
                SparseArray sparseArray5 = new SparseArray();
                sparseArray5.put(R.id.tag_should_manage_visible, false);
                sparseArray5.put(R.id.tag_user_mute_visible, false);
                sparseArray5.put(R.id.tag_should_delete_visible, true);
                sparseArray5.put(R.id.tag_manage_user_identity, sparseArray.get(R.id.tag_manage_user_identity));
                sparseArray5.put(R.id.tag_del_post_is_self, Boolean.valueOf(z3));
                sparseArray5.put(R.id.tag_del_post_id, sparseArray.get(R.id.tag_del_post_id));
                sparseArray5.put(R.id.tag_del_post_type, sparseArray.get(R.id.tag_del_post_type));
                cnd().setTag(sparseArray5);
                cnf().setTag(sparseArray5);
                cnd().setText(R.string.delete);
                cnf().setVisibility(0);
                if (i == 1002 && !z3) {
                    cnf().setText(R.string.report_text);
                } else {
                    cnf().setText(R.string.delete);
                }
                cnd().setVisibility(8);
            } else {
                cnd().setVisibility(8);
                cnf().setVisibility(8);
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
                cne().setTag(sparseArray6);
                cne().setVisibility(0);
                cnd().setVisibility(8);
                cne().setText(R.string.mute_option);
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
                    cne().setVisibility(0);
                    cne().setTag(str2);
                } else {
                    cne().setVisibility(8);
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
                cnh().setVisibility(0);
                cnh().setTag(R.id.tag_chudian_template_id, Long.valueOf(j));
                cnh().setTag(R.id.tag_chudian_monitor_id, str3);
                cnh().setTag(R.id.tag_chudian_hide_day, Integer.valueOf(i2));
            } else {
                cnh().setVisibility(8);
            }
            if (!(sparseArray.get(R.id.tag_richtext_emotion) instanceof Boolean)) {
                z6 = false;
            } else {
                z6 = ((Boolean) sparseArray.get(R.id.tag_richtext_emotion)).booleanValue();
                if (this.cRe.getPageActivity() instanceof NewSubPbActivity) {
                    NewSubPbActivity newSubPbActivity = (NewSubPbActivity) this.cRe.getPageActivity();
                    z6 = (!z6 || newSubPbActivity.cpW() == null || newSubPbActivity.cpW().cqv() == null || newSubPbActivity.cpW().cqv().axQ() == null || newSubPbActivity.cpW().cqv().axQ().isBjh()) ? false : true;
                }
            }
            if (!(sparseArray.get(R.id.tag_richtext_image) instanceof Boolean)) {
                z7 = false;
            } else {
                z7 = ((Boolean) sparseArray.get(R.id.tag_richtext_image)).booleanValue();
            }
            if (z6) {
                cni().setVisibility(0);
            } else {
                cni().setVisibility(8);
            }
            if (z7) {
                cnj().setVisibility(0);
            } else {
                cnj().setVisibility(8);
            }
            if (z6 || z7) {
                cng().setVisibility(8);
            } else {
                cng().setVisibility(0);
            }
        }
    }
}
