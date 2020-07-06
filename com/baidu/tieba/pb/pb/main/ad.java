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
/* loaded from: classes9.dex */
public class ad extends com.baidu.tbadk.core.dialog.i {
    private TbPageContext<?> dPv;
    private View.OnClickListener hwV;
    private TextView kjA;
    private TextView kjB;
    private TextView kjC;
    private TextView kjD;
    private TextView kjE;
    private TextView kjF;
    private TextView kjG;
    private TextView kjH;
    private boolean kjI;

    public ad(TbPageContext<?> tbPageContext, View.OnClickListener onClickListener) {
        super(tbPageContext);
        this.kjI = false;
        this.dPv = tbPageContext;
        this.hwV = onClickListener;
        aaH();
    }

    public TextView cKZ() {
        return this.kjA;
    }

    public TextView cLa() {
        return this.kjB;
    }

    public TextView cLb() {
        return this.kjC;
    }

    public TextView cLc() {
        return this.kjD;
    }

    public TextView cLd() {
        return this.kjE;
    }

    public TextView cLe() {
        return this.kjH;
    }

    public TextView cLf() {
        return this.kjF;
    }

    public TextView cLg() {
        return this.kjG;
    }

    private void aaH() {
        a((String) null, new String[]{this.dPv.getString(R.string.no_interesting), this.dPv.getString(R.string.save_to_emotion), this.dPv.getString(R.string.save_to_local), this.dPv.getString(R.string.copy), this.dPv.getString(R.string.mark), this.dPv.getString(R.string.report_text), this.dPv.getString(R.string.delete), this.dPv.getString(R.string.mute)}, new k.c() { // from class: com.baidu.tieba.pb.pb.main.ad.1
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(com.baidu.tbadk.core.dialog.k kVar, int i, View view) {
                ad.this.dismiss();
                ad.this.hwV.onClick(view);
            }
        });
        this.kjH = cI(getItemView(0));
        this.kjA = cI(getItemView(4));
        this.kjB = cI(getItemView(7));
        this.kjC = cI(getItemView(5));
        this.kjD = cI(getItemView(6));
        this.kjE = cI(getItemView(3));
        this.kjF = cI(getItemView(1));
        this.kjG = cI(getItemView(2));
    }

    private TextView cI(View view) {
        return (TextView) view.findViewById(R.id.item_view);
    }

    public void rU(boolean z) {
        this.kjC.setVisibility(z ? 0 : 8);
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
        if (sparseArray != null) {
            PostData postData = (PostData) sparseArray.get(R.id.tag_clip_board);
            SparseArray sparseArray2 = new SparseArray();
            sparseArray2.put(R.id.tag_clip_board, (PostData) sparseArray.get(R.id.tag_clip_board));
            sparseArray2.put(R.id.tag_is_subpb, false);
            cKZ().setTag(sparseArray2);
            SparseArray sparseArray3 = new SparseArray();
            sparseArray3.put(R.id.tag_clip_board, (PostData) sparseArray.get(R.id.tag_clip_board));
            cLd().setTag(sparseArray3);
            boolean booleanValue = sparseArray.get(R.id.tag_should_manage_visible) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_should_manage_visible)).booleanValue() : false;
            boolean booleanValue2 = sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue() : false;
            boolean booleanValue3 = sparseArray.get(R.id.tag_should_delete_visible) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_should_delete_visible)).booleanValue() : false;
            boolean booleanValue4 = sparseArray.get(R.id.tag_del_post_is_self) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue() : false;
            String str = null;
            if (sparseArray.get(R.id.tag_forbid_user_post_id) instanceof String) {
                str = (String) sparseArray.get(R.id.tag_forbid_user_post_id);
            }
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
                    cLc().setVisibility(0);
                } else {
                    sparseArray4.put(R.id.tag_should_delete_visible, false);
                    cLc().setVisibility(8);
                }
                cLa().setTag(sparseArray4);
                cLc().setTag(sparseArray4);
                cLa().setText(R.string.bar_manager);
                cLa().setVisibility(0);
            } else if (booleanValue3) {
                SparseArray sparseArray5 = new SparseArray();
                sparseArray5.put(R.id.tag_should_manage_visible, false);
                sparseArray5.put(R.id.tag_user_mute_visible, false);
                sparseArray5.put(R.id.tag_should_delete_visible, true);
                sparseArray5.put(R.id.tag_manage_user_identity, sparseArray.get(R.id.tag_manage_user_identity));
                sparseArray5.put(R.id.tag_del_post_is_self, Boolean.valueOf(booleanValue4));
                sparseArray5.put(R.id.tag_del_post_id, sparseArray.get(R.id.tag_del_post_id));
                sparseArray5.put(R.id.tag_del_post_type, sparseArray.get(R.id.tag_del_post_type));
                cLa().setTag(sparseArray5);
                cLc().setTag(sparseArray5);
                cLa().setText(R.string.delete);
                cLc().setVisibility(0);
                if (i == 1002 && !booleanValue4) {
                    cLc().setText(R.string.report_text);
                } else {
                    cLc().setText(R.string.delete);
                }
                cLa().setVisibility(8);
            } else {
                cLa().setVisibility(8);
                cLc().setVisibility(8);
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
                cLb().setTag(sparseArray6);
                cLb().setVisibility(0);
                cLa().setVisibility(8);
                cLb().setText(R.string.mute_option);
            } else {
                if (sparseArray.get(R.id.tag_del_post_is_self) instanceof Boolean) {
                    ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue();
                }
                String str2 = null;
                if (sparseArray.get(R.id.tag_forbid_user_post_id) instanceof String) {
                    str2 = (String) sparseArray.get(R.id.tag_forbid_user_post_id);
                }
                if (z) {
                    cLb().setVisibility(0);
                    cLb().setTag(str2);
                } else {
                    cLb().setVisibility(8);
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
                cLe().setVisibility(0);
                cLe().setTag(R.id.tag_chudian_template_id, Long.valueOf(j));
                cLe().setTag(R.id.tag_chudian_monitor_id, str3);
                cLe().setTag(R.id.tag_chudian_hide_day, Integer.valueOf(intValue));
            } else {
                cLe().setVisibility(8);
            }
            if (sparseArray.get(R.id.tag_richtext_emotion) instanceof Boolean) {
                z2 = ((Boolean) sparseArray.get(R.id.tag_richtext_emotion)).booleanValue();
                if (this.dPv.getPageActivity() instanceof NewSubPbActivity) {
                    NewSubPbActivity newSubPbActivity = (NewSubPbActivity) this.dPv.getPageActivity();
                    z2 = (!z2 || newSubPbActivity.cNV() == null || newSubPbActivity.cNV().cOu() == null || newSubPbActivity.cNV().cOu().aPS() == null || newSubPbActivity.cNV().cOu().aPS().isBjh()) ? false : true;
                }
            } else {
                z2 = false;
            }
            boolean booleanValue7 = sparseArray.get(R.id.tag_richtext_image) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_richtext_image)).booleanValue() : false;
            if (z2) {
                cLf().setVisibility(0);
            } else {
                cLf().setVisibility(8);
            }
            if (booleanValue7) {
                cLg().setVisibility(0);
            } else {
                cLg().setVisibility(8);
            }
            if (z2 || booleanValue7) {
                cLd().setVisibility(8);
            } else {
                cLd().setVisibility(0);
            }
        }
    }
}
