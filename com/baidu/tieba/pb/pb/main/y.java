package com.baidu.tieba.pb.pb.main;

import android.util.SparseArray;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.dialog.b;
import com.baidu.tieba.e;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class y extends com.baidu.tbadk.core.dialog.b {
    private View.OnClickListener dpV;
    private TextView fJA;
    private TextView fJB;
    private TextView fJC;
    private TextView fJD;
    private TextView fJE;
    private TextView fJF;
    private TextView fJG;
    private TextView fJH;
    private boolean fJI;
    private TbPageContext<?> mContext;

    public y(TbPageContext<?> tbPageContext, View.OnClickListener onClickListener) {
        super(tbPageContext.getPageActivity());
        this.fJI = false;
        this.mContext = tbPageContext;
        this.dpV = onClickListener;
        PR();
    }

    public TextView bfp() {
        return this.fJA;
    }

    public TextView bfq() {
        return this.fJB;
    }

    public TextView bfr() {
        return this.fJC;
    }

    public TextView bfs() {
        return this.fJD;
    }

    public TextView bft() {
        return this.fJE;
    }

    public TextView bfu() {
        return this.fJH;
    }

    public TextView bfv() {
        return this.fJF;
    }

    public TextView bfw() {
        return this.fJG;
    }

    private void PR() {
        a(new CharSequence[]{this.mContext.getString(e.j.no_interesting), this.mContext.getString(e.j.save_to_emotion), this.mContext.getString(e.j.save_to_local), this.mContext.getString(e.j.copy), this.mContext.getString(e.j.mark), this.mContext.getString(e.j.report_text), this.mContext.getString(e.j.delete), this.mContext.getString(e.j.mute)}, new b.InterfaceC0100b() { // from class: com.baidu.tieba.pb.pb.main.y.1
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0100b
            public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                if (bVar != null && view != null) {
                    bVar.dismiss();
                    y.this.dpV.onClick(view);
                }
            }
        });
        d(this.mContext);
        this.fJH = by(cx(0));
        this.fJA = by(cx(4));
        this.fJB = by(cx(7));
        this.fJC = by(cx(5));
        this.fJD = by(cx(6));
        this.fJE = by(cx(3));
        this.fJF = by(cx(1));
        this.fJG = by(cx(2));
    }

    public void showDialog() {
        yo();
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

    public void kt(boolean z) {
        this.fJC.setVisibility(z ? 0 : 8);
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
            View cx = cx(i);
            if (cx != null) {
                TextView by2 = by(cx(i));
                View bz = bz(cx(i));
                if (by2 != null) {
                    if (by2.getVisibility() == 8) {
                        bz.setVisibility(8);
                    } else {
                        arrayList.add(cx);
                        if (z) {
                            bz.setVisibility(8);
                            com.baidu.tbadk.core.util.al.i(cx, e.f.dialog_single_button_bg_selector);
                            z = false;
                        } else {
                            bz.setVisibility(0);
                            com.baidu.tbadk.core.util.al.i(cx, e.f.dialog_middle_item_bg_selector);
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
            View cx2 = cx(i2);
            if (cx2 == null || (by = by(cx(i2))) == null || by.getVisibility() != 0) {
                i2++;
            } else {
                com.baidu.tbadk.core.util.al.i(cx2, e.f.dialog_single_button_first_bg_selector);
                break;
            }
        }
        if (com.baidu.tbadk.core.util.v.y(arrayList) == 1 && (view = (View) arrayList.get(0)) != null) {
            com.baidu.tbadk.core.util.al.i(view, e.f.dialog_single_button_only_one_bg_selector);
        }
    }

    public void a(SparseArray<Object> sparseArray, int i, boolean z) {
        if (sparseArray != null) {
            PostData postData = (PostData) sparseArray.get(e.g.tag_clip_board);
            SparseArray sparseArray2 = new SparseArray();
            sparseArray2.put(e.g.tag_clip_board, (PostData) sparseArray.get(e.g.tag_clip_board));
            sparseArray2.put(e.g.tag_is_subpb, false);
            bfp().setTag(sparseArray2);
            SparseArray sparseArray3 = new SparseArray();
            sparseArray3.put(e.g.tag_clip_board, (PostData) sparseArray.get(e.g.tag_clip_board));
            bft().setTag(sparseArray3);
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
                    bfs().setVisibility(0);
                } else {
                    sparseArray4.put(e.g.tag_should_delete_visible, false);
                    bfs().setVisibility(8);
                }
                bfq().setTag(sparseArray4);
                bfs().setTag(sparseArray4);
                bfq().setText(e.j.bar_manager);
                bfq().setVisibility(0);
            } else if (booleanValue3) {
                SparseArray sparseArray5 = new SparseArray();
                sparseArray5.put(e.g.tag_should_manage_visible, false);
                sparseArray5.put(e.g.tag_user_mute_visible, false);
                sparseArray5.put(e.g.tag_should_delete_visible, true);
                sparseArray5.put(e.g.tag_manage_user_identity, sparseArray.get(e.g.tag_manage_user_identity));
                sparseArray5.put(e.g.tag_del_post_is_self, Boolean.valueOf(booleanValue4));
                sparseArray5.put(e.g.tag_del_post_id, sparseArray.get(e.g.tag_del_post_id));
                sparseArray5.put(e.g.tag_del_post_type, sparseArray.get(e.g.tag_del_post_type));
                bfq().setTag(sparseArray5);
                bfs().setTag(sparseArray5);
                bfq().setText(e.j.delete);
                bfs().setVisibility(0);
                if (i == 1002 && !booleanValue4) {
                    bfs().setText(e.j.report_text);
                } else {
                    bfs().setText(e.j.delete);
                }
                bfq().setVisibility(8);
            } else {
                bfq().setVisibility(8);
                bfs().setVisibility(8);
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
                bfr().setTag(sparseArray6);
                bfr().setVisibility(0);
                bfq().setVisibility(8);
                bfr().setText(e.j.mute_option);
            } else {
                if (sparseArray.get(e.g.tag_del_post_is_self) instanceof Boolean) {
                    ((Boolean) sparseArray.get(e.g.tag_del_post_is_self)).booleanValue();
                }
                String str2 = sparseArray.get(e.g.tag_forbid_user_post_id) instanceof String ? (String) sparseArray.get(e.g.tag_forbid_user_post_id) : null;
                if (aq.k(postData)) {
                    z = false;
                }
                if (z) {
                    bfr().setVisibility(0);
                    bfr().setTag(str2);
                } else {
                    bfr().setVisibility(8);
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
                bfu().setVisibility(0);
                bfu().setTag(e.g.tag_chudian_template_id, Long.valueOf(j));
                bfu().setTag(e.g.tag_chudian_monitor_id, str3);
                bfu().setTag(e.g.tag_chudian_hide_day, Integer.valueOf(intValue));
            } else {
                bfu().setVisibility(8);
            }
            boolean booleanValue7 = sparseArray.get(e.g.tag_richtext_emotion) instanceof Boolean ? ((Boolean) sparseArray.get(e.g.tag_richtext_emotion)).booleanValue() : false;
            boolean booleanValue8 = sparseArray.get(e.g.tag_richtext_image) instanceof Boolean ? ((Boolean) sparseArray.get(e.g.tag_richtext_image)).booleanValue() : false;
            if (booleanValue7) {
                bfv().setVisibility(0);
            } else {
                bfv().setVisibility(8);
            }
            if (booleanValue8) {
                bfw().setVisibility(0);
            } else {
                bfw().setVisibility(8);
            }
            if (booleanValue7 || booleanValue8) {
                bft().setVisibility(8);
            } else {
                bft().setVisibility(0);
            }
        }
    }
}
