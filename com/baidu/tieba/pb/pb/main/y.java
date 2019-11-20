package com.baidu.tieba.pb.pb.main;

import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.dialog.k;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes4.dex */
public class y extends com.baidu.tbadk.core.dialog.i {
    private TbPageContext<?> ceu;
    private View.OnClickListener fsb;
    private TextView hRF;
    private TextView hRG;
    private TextView hRH;
    private TextView hRI;
    private TextView hRJ;
    private TextView hRK;
    private TextView hRL;
    private TextView hRM;
    private boolean hRN;

    public y(TbPageContext<?> tbPageContext, View.OnClickListener onClickListener) {
        super(tbPageContext);
        this.hRN = false;
        this.ceu = tbPageContext;
        this.fsb = onClickListener;
        FT();
    }

    public TextView bUp() {
        return this.hRF;
    }

    public TextView bUq() {
        return this.hRG;
    }

    public TextView bUr() {
        return this.hRH;
    }

    public TextView bUs() {
        return this.hRI;
    }

    public TextView bUt() {
        return this.hRJ;
    }

    public TextView bUu() {
        return this.hRM;
    }

    public TextView bUv() {
        return this.hRK;
    }

    public TextView bUw() {
        return this.hRL;
    }

    private void FT() {
        a((String) null, new String[]{this.ceu.getString(R.string.no_interesting), this.ceu.getString(R.string.save_to_emotion), this.ceu.getString(R.string.save_to_local), this.ceu.getString(R.string.copy), this.ceu.getString(R.string.mark), this.ceu.getString(R.string.report_text), this.ceu.getString(R.string.delete), this.ceu.getString(R.string.mute)}, new k.c() { // from class: com.baidu.tieba.pb.pb.main.y.1
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(com.baidu.tbadk.core.dialog.k kVar, int i, View view) {
                y.this.dismiss();
                y.this.fsb.onClick(view);
            }
        });
        this.hRM = cz(getItemView(0));
        this.hRF = cz(getItemView(4));
        this.hRG = cz(getItemView(7));
        this.hRH = cz(getItemView(5));
        this.hRI = cz(getItemView(6));
        this.hRJ = cz(getItemView(3));
        this.hRK = cz(getItemView(1));
        this.hRL = cz(getItemView(2));
    }

    private TextView cz(View view) {
        return (TextView) view.findViewById(R.id.item_view);
    }

    public void ot(boolean z) {
        this.hRH.setVisibility(z ? 0 : 8);
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
            bUp().setTag(sparseArray2);
            SparseArray sparseArray3 = new SparseArray();
            sparseArray3.put(R.id.tag_clip_board, (PostData) sparseArray.get(R.id.tag_clip_board));
            bUt().setTag(sparseArray3);
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
                    bUs().setVisibility(0);
                } else {
                    sparseArray4.put(R.id.tag_should_delete_visible, false);
                    bUs().setVisibility(8);
                }
                bUq().setTag(sparseArray4);
                bUs().setTag(sparseArray4);
                bUq().setText(R.string.bar_manager);
                bUq().setVisibility(0);
            } else if (z9) {
                SparseArray sparseArray5 = new SparseArray();
                sparseArray5.put(R.id.tag_should_manage_visible, false);
                sparseArray5.put(R.id.tag_user_mute_visible, false);
                sparseArray5.put(R.id.tag_should_delete_visible, true);
                sparseArray5.put(R.id.tag_manage_user_identity, sparseArray.get(R.id.tag_manage_user_identity));
                sparseArray5.put(R.id.tag_del_post_is_self, Boolean.valueOf(z3));
                sparseArray5.put(R.id.tag_del_post_id, sparseArray.get(R.id.tag_del_post_id));
                sparseArray5.put(R.id.tag_del_post_type, sparseArray.get(R.id.tag_del_post_type));
                bUq().setTag(sparseArray5);
                bUs().setTag(sparseArray5);
                bUq().setText(R.string.delete);
                bUs().setVisibility(0);
                if (i == 1002 && !z3) {
                    bUs().setText(R.string.report_text);
                } else {
                    bUs().setText(R.string.delete);
                }
                bUq().setVisibility(8);
            } else {
                bUq().setVisibility(8);
                bUs().setVisibility(8);
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
                bUr().setTag(sparseArray6);
                bUr().setVisibility(0);
                bUq().setVisibility(8);
                bUr().setText(R.string.mute_option);
            } else {
                if (sparseArray.get(R.id.tag_del_post_is_self) instanceof Boolean) {
                    ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue();
                }
                String str2 = null;
                if (sparseArray.get(R.id.tag_forbid_user_post_id) instanceof String) {
                    str2 = (String) sparseArray.get(R.id.tag_forbid_user_post_id);
                }
                if (ap.m(postData)) {
                    z = false;
                }
                if (z) {
                    bUr().setVisibility(0);
                    bUr().setTag(str2);
                } else {
                    bUr().setVisibility(8);
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
                bUu().setVisibility(0);
                bUu().setTag(R.id.tag_chudian_template_id, Long.valueOf(j));
                bUu().setTag(R.id.tag_chudian_monitor_id, str3);
                bUu().setTag(R.id.tag_chudian_hide_day, Integer.valueOf(i2));
            } else {
                bUu().setVisibility(8);
            }
            if (!(sparseArray.get(R.id.tag_richtext_emotion) instanceof Boolean)) {
                z6 = false;
            } else {
                z6 = ((Boolean) sparseArray.get(R.id.tag_richtext_emotion)).booleanValue();
            }
            if (!(sparseArray.get(R.id.tag_richtext_image) instanceof Boolean)) {
                z7 = false;
            } else {
                z7 = ((Boolean) sparseArray.get(R.id.tag_richtext_image)).booleanValue();
            }
            if (z6) {
                bUv().setVisibility(0);
            } else {
                bUv().setVisibility(8);
            }
            if (z7) {
                bUw().setVisibility(0);
            } else {
                bUw().setVisibility(8);
            }
            if (z6 || z7) {
                bUt().setVisibility(8);
            } else {
                bUt().setVisibility(0);
            }
        }
    }
}
