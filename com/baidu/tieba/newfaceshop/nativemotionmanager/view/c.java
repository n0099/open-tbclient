package com.baidu.tieba.newfaceshop.nativemotionmanager.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.voice.h;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class c {
    private TextView lDK;
    private View lDL;
    private LinearLayout lDM;
    private View mHeaderView;
    private View rootView;

    public c(TbPageContext tbPageContext) {
        this.rootView = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.emotion_manage_header, (ViewGroup) null, false);
        this.lDM = (LinearLayout) this.rootView.findViewById(R.id.emotion_manage_header_content);
        this.lDM.setVisibility(8);
        this.mHeaderView = this.rootView.findViewById(R.id.emotion_manage_item_header);
        this.lDK = (TextView) this.rootView.findViewById(R.id.emotion_manage_total_title);
        this.lDL = this.rootView.findViewById(R.id.emotion_manage_edit_lable);
        this.lDL.setVisibility(8);
    }

    public View getView() {
        return this.rootView;
    }

    public void onChangeSkinType(int i) {
        if (this.mHeaderView != null) {
            ap.setBackgroundColor(this.mHeaderView, R.color.CAM_X0204, i);
        }
        if (this.lDM != null) {
            ap.setBackgroundColor(this.lDM, R.color.CAM_X0204, i);
        }
        if (this.lDK != null) {
            ap.setViewTextColor(this.lDK, R.color.CAM_X0107, i);
            ap.setBackgroundColor(this.lDK, R.color.CAM_X0204, i);
        }
        if (this.lDL != null) {
            ap.setViewTextColor(this.lDL, R.color.CAM_X0107, i);
            ap.setBackgroundColor(this.lDL, R.color.CAM_X0204, i);
        }
    }

    public void t(Integer num) {
        if (num != null) {
            if (num.intValue() == 0) {
                this.lDM.setVisibility(8);
            } else {
                this.lDK.setText(String.format(h.getString(R.string.emotion_manage_local_number), num));
                this.lDM.setVisibility(0);
            }
            if (com.baidu.tieba.newfaceshop.nativemotionmanager.a.diR().bKX()) {
                this.lDL.setVisibility(0);
            } else {
                this.lDL.setVisibility(8);
            }
        }
    }

    public void diT() {
        if (com.baidu.tieba.newfaceshop.nativemotionmanager.a.diR().bKX()) {
            this.lDL.setVisibility(0);
        } else {
            this.lDL.setVisibility(8);
        }
    }
}
