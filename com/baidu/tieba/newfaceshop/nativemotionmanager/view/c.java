package com.baidu.tieba.newfaceshop.nativemotionmanager.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.voice.h;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class c {
    private TextView lvG;
    private View lvH;
    private LinearLayout lvI;
    private View mHeaderView;
    private View rootView;

    public c(TbPageContext tbPageContext) {
        this.rootView = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.emotion_manage_header, (ViewGroup) null, false);
        this.lvI = (LinearLayout) this.rootView.findViewById(R.id.emotion_manage_header_content);
        this.lvI.setVisibility(8);
        this.mHeaderView = this.rootView.findViewById(R.id.emotion_manage_item_header);
        this.lvG = (TextView) this.rootView.findViewById(R.id.emotion_manage_total_title);
        this.lvH = this.rootView.findViewById(R.id.emotion_manage_edit_lable);
        this.lvH.setVisibility(8);
    }

    public View getView() {
        return this.rootView;
    }

    public void onChangeSkinType(int i) {
        if (this.mHeaderView != null) {
            ao.setBackgroundColor(this.mHeaderView, R.color.CAM_X0204, i);
        }
        if (this.lvI != null) {
            ao.setBackgroundColor(this.lvI, R.color.CAM_X0204, i);
        }
        if (this.lvG != null) {
            ao.setViewTextColor(this.lvG, R.color.CAM_X0107, i);
            ao.setBackgroundColor(this.lvG, R.color.CAM_X0204, i);
        }
        if (this.lvH != null) {
            ao.setViewTextColor(this.lvH, R.color.CAM_X0107, i);
            ao.setBackgroundColor(this.lvH, R.color.CAM_X0204, i);
        }
    }

    public void s(Integer num) {
        if (num != null) {
            if (num.intValue() == 0) {
                this.lvI.setVisibility(8);
            } else {
                this.lvG.setText(String.format(h.getString(R.string.emotion_manage_local_number), num));
                this.lvI.setVisibility(0);
            }
            if (com.baidu.tieba.newfaceshop.nativemotionmanager.a.dgQ().bKD()) {
                this.lvH.setVisibility(0);
            } else {
                this.lvH.setVisibility(8);
            }
        }
    }

    public void dgS() {
        if (com.baidu.tieba.newfaceshop.nativemotionmanager.a.dgQ().bKD()) {
            this.lvH.setVisibility(0);
        } else {
            this.lvH.setVisibility(8);
        }
    }
}
