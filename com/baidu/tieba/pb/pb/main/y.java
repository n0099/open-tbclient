package com.baidu.tieba.pb.pb.main;

import android.util.SparseArray;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.dialog.b;
import com.baidu.tieba.e;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class y extends com.baidu.tbadk.core.dialog.b {
    private View.OnClickListener dxX;
    private TextView fRc;
    private TextView fRd;
    private TextView fRe;
    private TextView fRf;
    private TextView fRg;
    private TextView fRh;
    private TextView fRi;
    private TextView fRj;
    private boolean fRk;
    private TbPageContext<?> mContext;

    public y(TbPageContext<?> tbPageContext, View.OnClickListener onClickListener) {
        super(tbPageContext.getPageActivity());
        this.fRk = false;
        this.mContext = tbPageContext;
        this.dxX = onClickListener;
        createDialog();
    }

    public TextView biB() {
        return this.fRc;
    }

    public TextView biC() {
        return this.fRd;
    }

    public TextView biD() {
        return this.fRe;
    }

    public TextView biE() {
        return this.fRf;
    }

    public TextView biF() {
        return this.fRg;
    }

    public TextView biG() {
        return this.fRj;
    }

    public TextView biH() {
        return this.fRh;
    }

    public TextView biI() {
        return this.fRi;
    }

    private void createDialog() {
        a(new CharSequence[]{this.mContext.getString(e.j.no_interesting), this.mContext.getString(e.j.save_to_emotion), this.mContext.getString(e.j.save_to_local), this.mContext.getString(e.j.copy), this.mContext.getString(e.j.mark), this.mContext.getString(e.j.report_text), this.mContext.getString(e.j.delete), this.mContext.getString(e.j.mute)}, new b.InterfaceC0124b() { // from class: com.baidu.tieba.pb.pb.main.y.1
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0124b
            public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                if (bVar != null && view != null) {
                    bVar.dismiss();
                    y.this.dxX.onClick(view);
                }
            }
        });
        d(this.mContext);
        this.fRj = by(cH(0));
        this.fRc = by(cH(4));
        this.fRd = by(cH(7));
        this.fRe = by(cH(5));
        this.fRf = by(cH(6));
        this.fRg = by(cH(3));
        this.fRh = by(cH(1));
        this.fRi = by(cH(2));
    }

    public void showDialog() {
        Ax();
    }

    private TextView by(View view) {
        return (TextView) view.findViewById(e.g.dialog_item_btn);
    }

    private View bz(View view) {
        if (view == null) {
            return null;
        }
        return view.findViewById(e.g.line);
    }

    public void kK(boolean z) {
        this.fRe.setVisibility(z ? 0 : 8);
    }

    public View getView() {
        return getRootView();
    }

    public void refreshUI() {
        View view;
        TextView by;
        int itemCount = getItemCount();
        ArrayList arrayList = new ArrayList();
        boolean z = true;
        for (int i = itemCount - 1; i >= 0; i--) {
            View cH = cH(i);
            if (cH != null) {
                TextView by2 = by(cH(i));
                View bz = bz(cH(i));
                if (by2 != null) {
                    if (by2.getVisibility() == 8) {
                        bz.setVisibility(8);
                    } else {
                        arrayList.add(cH);
                        if (z) {
                            bz.setVisibility(8);
                            com.baidu.tbadk.core.util.al.i(cH, e.f.dialog_single_button_bg_selector);
                            z = false;
                        } else {
                            bz.setVisibility(0);
                            com.baidu.tbadk.core.util.al.i(cH, e.f.dialog_middle_item_bg_selector);
                        }
                    }
                }
            }
        }
        int i2 = 0;
        while (true) {
            if (i2 >= itemCount) {
                break;
            }
            View cH2 = cH(i2);
            if (cH2 == null || (by = by(cH(i2))) == null || by.getVisibility() != 0) {
                i2++;
            } else {
                com.baidu.tbadk.core.util.al.i(cH2, e.f.dialog_single_button_first_bg_selector);
                break;
            }
        }
        if (com.baidu.tbadk.core.util.v.I(arrayList) == 1 && (view = (View) arrayList.get(0)) != null) {
            com.baidu.tbadk.core.util.al.i(view, e.f.dialog_single_button_only_one_bg_selector);
        }
    }

    public void a(SparseArray<Object> sparseArray, int i, boolean z) {
        if (sparseArray != null) {
            PostData postData = (PostData) sparseArray.get(e.g.tag_clip_board);
            SparseArray sparseArray2 = new SparseArray();
            sparseArray2.put(e.g.tag_clip_board, (PostData) sparseArray.get(e.g.tag_clip_board));
            sparseArray2.put(e.g.tag_is_subpb, false);
            biB().setTag(sparseArray2);
            SparseArray sparseArray3 = new SparseArray();
            sparseArray3.put(e.g.tag_clip_board, (PostData) sparseArray.get(e.g.tag_clip_board));
            biF().setTag(sparseArray3);
            boolean booleanValue = sparseArray.get(e.g.tag_should_manage_visible) instanceof Boolean ? ((Boolean) sparseArray.get(e.g.tag_should_manage_visible)).booleanValue() : false;
            boolean booleanValue2 = sparseArray.get(e.g.tag_user_mute_visible) instanceof Boolean ? ((Boolean) sparseArray.get(e.g.tag_user_mute_visible)).booleanValue() : false;
            boolean booleanValue3 = sparseArray.get(e.g.tag_should_delete_visible) instanceof Boolean ? ((Boolean) sparseArray.get(e.g.tag_should_delete_visible)).booleanValue() : false;
            boolean booleanValue4 = sparseArray.get(e.g.tag_del_post_is_self) instanceof Boolean ? ((Boolean) sparseArray.get(e.g.tag_del_post_is_self)).booleanValue() : false;
            String str = sparseArray.get(e.g.tag_forbid_user_post_id) instanceof String ? (String) sparseArray.get(e.g.tag_forbid_user_post_id) : null;
            if (booleanValue) {
                SparseArray sparseArray4 = new SparseArray();
                sparseArray4.put(e.g.tag_should_manage_visible, true);
                sparseArray4.put(e.g.tag_manage_user_identity, sparseArray.get(e.g.tag_manage_user_identity));
                sparseArray4.put(e.g.tag_forbid_user_name, sparseArray.get(e.g.tag_forbid_user_name));
                sparseArray4.put(e.g.tag_forbid_user_name_show, sparseArray.get(e.g.tag_forbid_user_name_show));
                sparseArray4.put(e.g.tag_forbid_user_portrait, sparseArray.get(e.g.tag_forbid_user_portrait));
                sparseArray4.put(e.g.tag_forbid_user_post_id, str);
                if (booleanValue2) {
                    sparseArray4.put(e.g.tag_user_mute_visible, true);
                    sparseArray4.put(e.g.tag_is_mem, sparseArray.get(e.g.tag_is_mem));
                    sparseArray4.put(e.g.tag_user_mute_mute_userid, sparseArray.get(e.g.tag_user_mute_mute_userid));
                    sparseArray4.put(e.g.tag_user_mute_mute_username, sparseArray.get(e.g.tag_user_mute_mute_username));
                    sparseArray4.put(e.g.tag_user_mute_mute_nameshow, sparseArray.get(e.g.tag_user_mute_mute_nameshow));
                    sparseArray4.put(e.g.tag_user_mute_post_id, sparseArray.get(e.g.tag_user_mute_post_id));
                    sparseArray4.put(e.g.tag_user_mute_thread_id, sparseArray.get(e.g.tag_user_mute_thread_id));
                } else {
                    sparseArray4.put(e.g.tag_user_mute_visible, false);
                }
                if (booleanValue3) {
                    sparseArray4.put(e.g.tag_should_delete_visible, true);
                    sparseArray4.put(e.g.tag_del_post_is_self, Boolean.valueOf(booleanValue4));
                    sparseArray4.put(e.g.tag_del_post_id, sparseArray.get(e.g.tag_del_post_id));
                    sparseArray4.put(e.g.tag_del_post_type, sparseArray.get(e.g.tag_del_post_type));
                    biE().setVisibility(0);
                } else {
                    sparseArray4.put(e.g.tag_should_delete_visible, false);
                    biE().setVisibility(8);
                }
                biC().setTag(sparseArray4);
                biE().setTag(sparseArray4);
                biC().setText(e.j.bar_manager);
                biC().setVisibility(0);
            } else if (booleanValue3) {
                SparseArray sparseArray5 = new SparseArray();
                sparseArray5.put(e.g.tag_should_manage_visible, false);
                sparseArray5.put(e.g.tag_user_mute_visible, false);
                sparseArray5.put(e.g.tag_should_delete_visible, true);
                sparseArray5.put(e.g.tag_manage_user_identity, sparseArray.get(e.g.tag_manage_user_identity));
                sparseArray5.put(e.g.tag_del_post_is_self, Boolean.valueOf(booleanValue4));
                sparseArray5.put(e.g.tag_del_post_id, sparseArray.get(e.g.tag_del_post_id));
                sparseArray5.put(e.g.tag_del_post_type, sparseArray.get(e.g.tag_del_post_type));
                biC().setTag(sparseArray5);
                biE().setTag(sparseArray5);
                biC().setText(e.j.delete);
                biE().setVisibility(0);
                if (i == 1002 && !booleanValue4) {
                    biE().setText(e.j.report_text);
                } else {
                    biE().setText(e.j.delete);
                }
                biC().setVisibility(8);
            } else {
                biC().setVisibility(8);
                biE().setVisibility(8);
            }
            boolean booleanValue5 = sparseArray.get(e.g.tag_user_mute_visible) instanceof Boolean ? ((Boolean) sparseArray.get(e.g.tag_user_mute_visible)).booleanValue() : false;
            if (!(sparseArray.get(e.g.tag_should_manage_visible) instanceof Boolean ? ((Boolean) sparseArray.get(e.g.tag_should_manage_visible)).booleanValue() : false) && booleanValue5) {
                SparseArray sparseArray6 = new SparseArray();
                sparseArray6.put(e.g.tag_user_mute_visible, true);
                sparseArray6.put(e.g.tag_is_mem, sparseArray.get(e.g.tag_is_mem));
                sparseArray6.put(e.g.tag_user_mute_mute_userid, sparseArray.get(e.g.tag_user_mute_mute_userid));
                sparseArray6.put(e.g.tag_user_mute_mute_username, sparseArray.get(e.g.tag_user_mute_mute_username));
                sparseArray6.put(e.g.tag_user_mute_mute_nameshow, sparseArray.get(e.g.tag_user_mute_mute_nameshow));
                sparseArray6.put(e.g.tag_user_mute_post_id, sparseArray.get(e.g.tag_user_mute_post_id));
                sparseArray6.put(e.g.tag_user_mute_thread_id, sparseArray.get(e.g.tag_user_mute_thread_id));
                sparseArray6.put(e.g.tag_del_post_is_self, sparseArray.get(e.g.tag_del_post_is_self));
                sparseArray6.put(e.g.tag_del_post_type, sparseArray.get(e.g.tag_del_post_type));
                sparseArray6.put(e.g.tag_del_post_id, sparseArray.get(e.g.tag_del_post_id));
                sparseArray6.put(e.g.tag_manage_user_identity, sparseArray.get(e.g.tag_manage_user_identity));
                biD().setTag(sparseArray6);
                biD().setVisibility(0);
                biC().setVisibility(8);
                biD().setText(e.j.mute_option);
            } else {
                if (sparseArray.get(e.g.tag_del_post_is_self) instanceof Boolean) {
                    ((Boolean) sparseArray.get(e.g.tag_del_post_is_self)).booleanValue();
                }
                String str2 = sparseArray.get(e.g.tag_forbid_user_post_id) instanceof String ? (String) sparseArray.get(e.g.tag_forbid_user_post_id) : null;
                if (aq.k(postData)) {
                    z = false;
                }
                if (z) {
                    biD().setVisibility(0);
                    biD().setTag(str2);
                } else {
                    biD().setVisibility(8);
                }
            }
            long j = 0;
            String str3 = "";
            boolean booleanValue6 = sparseArray.get(e.g.tag_should_hide_chudian_visible) instanceof Boolean ? ((Boolean) sparseArray.get(e.g.tag_should_hide_chudian_visible)).booleanValue() : false;
            if (sparseArray.get(e.g.tag_chudian_template_id) instanceof Long) {
                j = ((Long) sparseArray.get(e.g.tag_chudian_template_id)).longValue();
            }
            if (sparseArray.get(e.g.tag_chudian_monitor_id) instanceof String) {
                str3 = (String) sparseArray.get(e.g.tag_chudian_monitor_id);
            }
            int intValue = sparseArray.get(e.g.tag_chudian_hide_day) instanceof Integer ? ((Integer) sparseArray.get(e.g.tag_chudian_hide_day)).intValue() : 0;
            if (booleanValue6) {
                biG().setVisibility(0);
                biG().setTag(e.g.tag_chudian_template_id, Long.valueOf(j));
                biG().setTag(e.g.tag_chudian_monitor_id, str3);
                biG().setTag(e.g.tag_chudian_hide_day, Integer.valueOf(intValue));
            } else {
                biG().setVisibility(8);
            }
            boolean booleanValue7 = sparseArray.get(e.g.tag_richtext_emotion) instanceof Boolean ? ((Boolean) sparseArray.get(e.g.tag_richtext_emotion)).booleanValue() : false;
            boolean booleanValue8 = sparseArray.get(e.g.tag_richtext_image) instanceof Boolean ? ((Boolean) sparseArray.get(e.g.tag_richtext_image)).booleanValue() : false;
            if (booleanValue7) {
                biH().setVisibility(0);
            } else {
                biH().setVisibility(8);
            }
            if (booleanValue8) {
                biI().setVisibility(0);
            } else {
                biI().setVisibility(8);
            }
            if (booleanValue7 || booleanValue8) {
                biF().setVisibility(8);
            } else {
                biF().setVisibility(0);
            }
        }
    }
}
