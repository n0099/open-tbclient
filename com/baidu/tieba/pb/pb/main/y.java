package com.baidu.tieba.pb.pb.main;

import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.dialog.i;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes4.dex */
public class y extends com.baidu.tbadk.core.dialog.g {
    private View.OnClickListener eWo;
    private TextView hta;
    private TextView htb;
    private TextView htc;
    private TextView htd;
    private TextView hte;
    private TextView htf;
    private TextView htg;
    private TextView hth;
    private boolean hti;
    private TbPageContext<?> mContext;

    public y(TbPageContext<?> tbPageContext, View.OnClickListener onClickListener) {
        super(tbPageContext);
        this.hti = false;
        this.mContext = tbPageContext;
        this.eWo = onClickListener;
        zm();
    }

    public TextView bLE() {
        return this.hta;
    }

    public TextView bLF() {
        return this.htb;
    }

    public TextView bLG() {
        return this.htc;
    }

    public TextView bLH() {
        return this.htd;
    }

    public TextView bLI() {
        return this.hte;
    }

    public TextView bLJ() {
        return this.hth;
    }

    public TextView bLK() {
        return this.htf;
    }

    public TextView bLL() {
        return this.htg;
    }

    private void zm() {
        a((String) null, new String[]{this.mContext.getString(d.j.no_interesting), this.mContext.getString(d.j.save_to_emotion), this.mContext.getString(d.j.save_to_local), this.mContext.getString(d.j.copy), this.mContext.getString(d.j.mark), this.mContext.getString(d.j.report_text), this.mContext.getString(d.j.delete), this.mContext.getString(d.j.mute)}, new i.c() { // from class: com.baidu.tieba.pb.pb.main.y.1
            @Override // com.baidu.tbadk.core.dialog.i.c
            public void a(com.baidu.tbadk.core.dialog.i iVar, int i, View view) {
                y.this.dismiss();
                y.this.eWo.onClick(view);
            }
        });
        this.hth = cr(gJ(0));
        this.hta = cr(gJ(4));
        this.htb = cr(gJ(7));
        this.htc = cr(gJ(5));
        this.htd = cr(gJ(6));
        this.hte = cr(gJ(3));
        this.htf = cr(gJ(1));
        this.htg = cr(gJ(2));
    }

    private TextView cr(View view) {
        return (TextView) view.findViewById(d.g.item_view);
    }

    public void nC(boolean z) {
        this.htc.setVisibility(z ? 0 : 8);
    }

    public View getView() {
        return getRootView();
    }

    public View gJ(int i) {
        if (this.mContentView == null || !(this.mContentView instanceof ViewGroup)) {
            return null;
        }
        View findViewById = this.mContentView.findViewById(d.g.content_view);
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
        if (sparseArray != null) {
            PostData postData = (PostData) sparseArray.get(d.g.tag_clip_board);
            SparseArray sparseArray2 = new SparseArray();
            sparseArray2.put(d.g.tag_clip_board, (PostData) sparseArray.get(d.g.tag_clip_board));
            sparseArray2.put(d.g.tag_is_subpb, false);
            bLE().setTag(sparseArray2);
            SparseArray sparseArray3 = new SparseArray();
            sparseArray3.put(d.g.tag_clip_board, (PostData) sparseArray.get(d.g.tag_clip_board));
            bLI().setTag(sparseArray3);
            boolean booleanValue = sparseArray.get(d.g.tag_should_manage_visible) instanceof Boolean ? ((Boolean) sparseArray.get(d.g.tag_should_manage_visible)).booleanValue() : false;
            boolean booleanValue2 = sparseArray.get(d.g.tag_user_mute_visible) instanceof Boolean ? ((Boolean) sparseArray.get(d.g.tag_user_mute_visible)).booleanValue() : false;
            boolean booleanValue3 = sparseArray.get(d.g.tag_should_delete_visible) instanceof Boolean ? ((Boolean) sparseArray.get(d.g.tag_should_delete_visible)).booleanValue() : false;
            boolean booleanValue4 = sparseArray.get(d.g.tag_del_post_is_self) instanceof Boolean ? ((Boolean) sparseArray.get(d.g.tag_del_post_is_self)).booleanValue() : false;
            String str = sparseArray.get(d.g.tag_forbid_user_post_id) instanceof String ? (String) sparseArray.get(d.g.tag_forbid_user_post_id) : null;
            if (booleanValue) {
                SparseArray sparseArray4 = new SparseArray();
                sparseArray4.put(d.g.tag_should_manage_visible, true);
                sparseArray4.put(d.g.tag_manage_user_identity, sparseArray.get(d.g.tag_manage_user_identity));
                sparseArray4.put(d.g.tag_forbid_user_name, sparseArray.get(d.g.tag_forbid_user_name));
                sparseArray4.put(d.g.tag_forbid_user_name_show, sparseArray.get(d.g.tag_forbid_user_name_show));
                sparseArray4.put(d.g.tag_forbid_user_portrait, sparseArray.get(d.g.tag_forbid_user_portrait));
                sparseArray4.put(d.g.tag_forbid_user_post_id, str);
                if (booleanValue2) {
                    sparseArray4.put(d.g.tag_user_mute_visible, true);
                    sparseArray4.put(d.g.tag_is_mem, sparseArray.get(d.g.tag_is_mem));
                    sparseArray4.put(d.g.tag_user_mute_mute_userid, sparseArray.get(d.g.tag_user_mute_mute_userid));
                    sparseArray4.put(d.g.tag_user_mute_mute_username, sparseArray.get(d.g.tag_user_mute_mute_username));
                    sparseArray4.put(d.g.tag_user_mute_mute_nameshow, sparseArray.get(d.g.tag_user_mute_mute_nameshow));
                    sparseArray4.put(d.g.tag_user_mute_post_id, sparseArray.get(d.g.tag_user_mute_post_id));
                    sparseArray4.put(d.g.tag_user_mute_thread_id, sparseArray.get(d.g.tag_user_mute_thread_id));
                } else {
                    sparseArray4.put(d.g.tag_user_mute_visible, false);
                }
                if (booleanValue3) {
                    sparseArray4.put(d.g.tag_should_delete_visible, true);
                    sparseArray4.put(d.g.tag_del_post_is_self, Boolean.valueOf(booleanValue4));
                    sparseArray4.put(d.g.tag_del_post_id, sparseArray.get(d.g.tag_del_post_id));
                    sparseArray4.put(d.g.tag_del_post_type, sparseArray.get(d.g.tag_del_post_type));
                    bLH().setVisibility(0);
                } else {
                    sparseArray4.put(d.g.tag_should_delete_visible, false);
                    bLH().setVisibility(8);
                }
                bLF().setTag(sparseArray4);
                bLH().setTag(sparseArray4);
                bLF().setText(d.j.bar_manager);
                bLF().setVisibility(0);
            } else if (booleanValue3) {
                SparseArray sparseArray5 = new SparseArray();
                sparseArray5.put(d.g.tag_should_manage_visible, false);
                sparseArray5.put(d.g.tag_user_mute_visible, false);
                sparseArray5.put(d.g.tag_should_delete_visible, true);
                sparseArray5.put(d.g.tag_manage_user_identity, sparseArray.get(d.g.tag_manage_user_identity));
                sparseArray5.put(d.g.tag_del_post_is_self, Boolean.valueOf(booleanValue4));
                sparseArray5.put(d.g.tag_del_post_id, sparseArray.get(d.g.tag_del_post_id));
                sparseArray5.put(d.g.tag_del_post_type, sparseArray.get(d.g.tag_del_post_type));
                bLF().setTag(sparseArray5);
                bLH().setTag(sparseArray5);
                bLF().setText(d.j.delete);
                bLH().setVisibility(0);
                if (i == 1002 && !booleanValue4) {
                    bLH().setText(d.j.report_text);
                } else {
                    bLH().setText(d.j.delete);
                }
                bLF().setVisibility(8);
            } else {
                bLF().setVisibility(8);
                bLH().setVisibility(8);
            }
            boolean booleanValue5 = sparseArray.get(d.g.tag_user_mute_visible) instanceof Boolean ? ((Boolean) sparseArray.get(d.g.tag_user_mute_visible)).booleanValue() : false;
            if (!(sparseArray.get(d.g.tag_should_manage_visible) instanceof Boolean ? ((Boolean) sparseArray.get(d.g.tag_should_manage_visible)).booleanValue() : false) && booleanValue5) {
                SparseArray sparseArray6 = new SparseArray();
                sparseArray6.put(d.g.tag_user_mute_visible, true);
                sparseArray6.put(d.g.tag_is_mem, sparseArray.get(d.g.tag_is_mem));
                sparseArray6.put(d.g.tag_user_mute_mute_userid, sparseArray.get(d.g.tag_user_mute_mute_userid));
                sparseArray6.put(d.g.tag_user_mute_mute_username, sparseArray.get(d.g.tag_user_mute_mute_username));
                sparseArray6.put(d.g.tag_user_mute_mute_nameshow, sparseArray.get(d.g.tag_user_mute_mute_nameshow));
                sparseArray6.put(d.g.tag_user_mute_post_id, sparseArray.get(d.g.tag_user_mute_post_id));
                sparseArray6.put(d.g.tag_user_mute_thread_id, sparseArray.get(d.g.tag_user_mute_thread_id));
                sparseArray6.put(d.g.tag_del_post_is_self, sparseArray.get(d.g.tag_del_post_is_self));
                sparseArray6.put(d.g.tag_del_post_type, sparseArray.get(d.g.tag_del_post_type));
                sparseArray6.put(d.g.tag_del_post_id, sparseArray.get(d.g.tag_del_post_id));
                sparseArray6.put(d.g.tag_manage_user_identity, sparseArray.get(d.g.tag_manage_user_identity));
                bLG().setTag(sparseArray6);
                bLG().setVisibility(0);
                bLF().setVisibility(8);
                bLG().setText(d.j.mute_option);
            } else {
                if (sparseArray.get(d.g.tag_del_post_is_self) instanceof Boolean) {
                    ((Boolean) sparseArray.get(d.g.tag_del_post_is_self)).booleanValue();
                }
                String str2 = sparseArray.get(d.g.tag_forbid_user_post_id) instanceof String ? (String) sparseArray.get(d.g.tag_forbid_user_post_id) : null;
                if (ap.m(postData)) {
                    z = false;
                }
                if (z) {
                    bLG().setVisibility(0);
                    bLG().setTag(str2);
                } else {
                    bLG().setVisibility(8);
                }
            }
            long j = 0;
            String str3 = "";
            boolean booleanValue6 = sparseArray.get(d.g.tag_should_hide_chudian_visible) instanceof Boolean ? ((Boolean) sparseArray.get(d.g.tag_should_hide_chudian_visible)).booleanValue() : false;
            if (sparseArray.get(d.g.tag_chudian_template_id) instanceof Long) {
                j = ((Long) sparseArray.get(d.g.tag_chudian_template_id)).longValue();
            }
            if (sparseArray.get(d.g.tag_chudian_monitor_id) instanceof String) {
                str3 = (String) sparseArray.get(d.g.tag_chudian_monitor_id);
            }
            int intValue = sparseArray.get(d.g.tag_chudian_hide_day) instanceof Integer ? ((Integer) sparseArray.get(d.g.tag_chudian_hide_day)).intValue() : 0;
            if (booleanValue6) {
                bLJ().setVisibility(0);
                bLJ().setTag(d.g.tag_chudian_template_id, Long.valueOf(j));
                bLJ().setTag(d.g.tag_chudian_monitor_id, str3);
                bLJ().setTag(d.g.tag_chudian_hide_day, Integer.valueOf(intValue));
            } else {
                bLJ().setVisibility(8);
            }
            boolean booleanValue7 = sparseArray.get(d.g.tag_richtext_emotion) instanceof Boolean ? ((Boolean) sparseArray.get(d.g.tag_richtext_emotion)).booleanValue() : false;
            boolean booleanValue8 = sparseArray.get(d.g.tag_richtext_image) instanceof Boolean ? ((Boolean) sparseArray.get(d.g.tag_richtext_image)).booleanValue() : false;
            if (booleanValue7) {
                bLK().setVisibility(0);
            } else {
                bLK().setVisibility(8);
            }
            if (booleanValue8) {
                bLL().setVisibility(0);
            } else {
                bLL().setVisibility(8);
            }
            if (booleanValue7 || booleanValue8) {
                bLI().setVisibility(8);
            } else {
                bLI().setVisibility(0);
            }
        }
    }
}
