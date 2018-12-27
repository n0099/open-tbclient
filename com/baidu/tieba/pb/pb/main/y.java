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
    private View.OnClickListener dIC;
    private TextView gcj;
    private TextView gck;
    private TextView gcl;
    private TextView gcm;
    private TextView gcn;
    private TextView gco;
    private TextView gcp;
    private TextView gcq;
    private boolean gcr;
    private TbPageContext<?> mContext;

    public y(TbPageContext<?> tbPageContext, View.OnClickListener onClickListener) {
        super(tbPageContext.getPageActivity());
        this.gcr = false;
        this.mContext = tbPageContext;
        this.dIC = onClickListener;
        createDialog();
    }

    public TextView bkB() {
        return this.gcj;
    }

    public TextView bkC() {
        return this.gck;
    }

    public TextView bkD() {
        return this.gcl;
    }

    public TextView bkE() {
        return this.gcm;
    }

    public TextView bkF() {
        return this.gcn;
    }

    public TextView bkG() {
        return this.gcq;
    }

    public TextView bkH() {
        return this.gco;
    }

    public TextView bkI() {
        return this.gcp;
    }

    private void createDialog() {
        a(new CharSequence[]{this.mContext.getString(e.j.no_interesting), this.mContext.getString(e.j.save_to_emotion), this.mContext.getString(e.j.save_to_local), this.mContext.getString(e.j.copy), this.mContext.getString(e.j.mark), this.mContext.getString(e.j.report_text), this.mContext.getString(e.j.delete), this.mContext.getString(e.j.mute)}, new b.InterfaceC0158b() { // from class: com.baidu.tieba.pb.pb.main.y.1
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0158b
            public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                if (bVar != null && view != null) {
                    bVar.dismiss();
                    y.this.dIC.onClick(view);
                }
            }
        });
        d(this.mContext);
        this.gcq = bD(dj(0));
        this.gcj = bD(dj(4));
        this.gck = bD(dj(7));
        this.gcl = bD(dj(5));
        this.gcm = bD(dj(6));
        this.gcn = bD(dj(3));
        this.gco = bD(dj(1));
        this.gcp = bD(dj(2));
    }

    public void showDialog() {
        BI();
    }

    private TextView bD(View view) {
        return (TextView) view.findViewById(e.g.dialog_item_btn);
    }

    private View bE(View view) {
        if (view == null) {
            return null;
        }
        return view.findViewById(e.g.line);
    }

    public void lb(boolean z) {
        this.gcl.setVisibility(z ? 0 : 8);
    }

    public View getView() {
        return getRootView();
    }

    public void refreshUI() {
        View view;
        TextView bD;
        int itemCount = getItemCount();
        ArrayList arrayList = new ArrayList();
        boolean z = true;
        for (int i = itemCount - 1; i >= 0; i--) {
            View dj = dj(i);
            if (dj != null) {
                TextView bD2 = bD(dj(i));
                View bE = bE(dj(i));
                if (bD2 != null) {
                    if (bD2.getVisibility() == 8) {
                        bE.setVisibility(8);
                    } else {
                        arrayList.add(dj);
                        if (z) {
                            bE.setVisibility(8);
                            com.baidu.tbadk.core.util.al.i(dj, e.f.dialog_single_button_bg_selector);
                            z = false;
                        } else {
                            bE.setVisibility(0);
                            com.baidu.tbadk.core.util.al.i(dj, e.f.dialog_middle_item_bg_selector);
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
            View dj2 = dj(i2);
            if (dj2 == null || (bD = bD(dj(i2))) == null || bD.getVisibility() != 0) {
                i2++;
            } else {
                com.baidu.tbadk.core.util.al.i(dj2, e.f.dialog_single_button_first_bg_selector);
                break;
            }
        }
        if (com.baidu.tbadk.core.util.v.H(arrayList) == 1 && (view = (View) arrayList.get(0)) != null) {
            com.baidu.tbadk.core.util.al.i(view, e.f.dialog_single_button_only_one_bg_selector);
        }
    }

    public void a(SparseArray<Object> sparseArray, int i, boolean z) {
        if (sparseArray != null) {
            PostData postData = (PostData) sparseArray.get(e.g.tag_clip_board);
            SparseArray sparseArray2 = new SparseArray();
            sparseArray2.put(e.g.tag_clip_board, (PostData) sparseArray.get(e.g.tag_clip_board));
            sparseArray2.put(e.g.tag_is_subpb, false);
            bkB().setTag(sparseArray2);
            SparseArray sparseArray3 = new SparseArray();
            sparseArray3.put(e.g.tag_clip_board, (PostData) sparseArray.get(e.g.tag_clip_board));
            bkF().setTag(sparseArray3);
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
                    bkE().setVisibility(0);
                } else {
                    sparseArray4.put(e.g.tag_should_delete_visible, false);
                    bkE().setVisibility(8);
                }
                bkC().setTag(sparseArray4);
                bkE().setTag(sparseArray4);
                bkC().setText(e.j.bar_manager);
                bkC().setVisibility(0);
            } else if (booleanValue3) {
                SparseArray sparseArray5 = new SparseArray();
                sparseArray5.put(e.g.tag_should_manage_visible, false);
                sparseArray5.put(e.g.tag_user_mute_visible, false);
                sparseArray5.put(e.g.tag_should_delete_visible, true);
                sparseArray5.put(e.g.tag_manage_user_identity, sparseArray.get(e.g.tag_manage_user_identity));
                sparseArray5.put(e.g.tag_del_post_is_self, Boolean.valueOf(booleanValue4));
                sparseArray5.put(e.g.tag_del_post_id, sparseArray.get(e.g.tag_del_post_id));
                sparseArray5.put(e.g.tag_del_post_type, sparseArray.get(e.g.tag_del_post_type));
                bkC().setTag(sparseArray5);
                bkE().setTag(sparseArray5);
                bkC().setText(e.j.delete);
                bkE().setVisibility(0);
                if (i == 1002 && !booleanValue4) {
                    bkE().setText(e.j.report_text);
                } else {
                    bkE().setText(e.j.delete);
                }
                bkC().setVisibility(8);
            } else {
                bkC().setVisibility(8);
                bkE().setVisibility(8);
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
                bkD().setTag(sparseArray6);
                bkD().setVisibility(0);
                bkC().setVisibility(8);
                bkD().setText(e.j.mute_option);
            } else {
                if (sparseArray.get(e.g.tag_del_post_is_self) instanceof Boolean) {
                    ((Boolean) sparseArray.get(e.g.tag_del_post_is_self)).booleanValue();
                }
                String str2 = sparseArray.get(e.g.tag_forbid_user_post_id) instanceof String ? (String) sparseArray.get(e.g.tag_forbid_user_post_id) : null;
                if (aq.k(postData)) {
                    z = false;
                }
                if (z) {
                    bkD().setVisibility(0);
                    bkD().setTag(str2);
                } else {
                    bkD().setVisibility(8);
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
                bkG().setVisibility(0);
                bkG().setTag(e.g.tag_chudian_template_id, Long.valueOf(j));
                bkG().setTag(e.g.tag_chudian_monitor_id, str3);
                bkG().setTag(e.g.tag_chudian_hide_day, Integer.valueOf(intValue));
            } else {
                bkG().setVisibility(8);
            }
            boolean booleanValue7 = sparseArray.get(e.g.tag_richtext_emotion) instanceof Boolean ? ((Boolean) sparseArray.get(e.g.tag_richtext_emotion)).booleanValue() : false;
            boolean booleanValue8 = sparseArray.get(e.g.tag_richtext_image) instanceof Boolean ? ((Boolean) sparseArray.get(e.g.tag_richtext_image)).booleanValue() : false;
            if (booleanValue7) {
                bkH().setVisibility(0);
            } else {
                bkH().setVisibility(8);
            }
            if (booleanValue8) {
                bkI().setVisibility(0);
            } else {
                bkI().setVisibility(8);
            }
            if (booleanValue7 || booleanValue8) {
                bkF().setVisibility(8);
            } else {
                bkF().setVisibility(0);
            }
        }
    }
}
