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
    private TextView lDY;
    private View lDZ;
    private LinearLayout lEa;
    private View mHeaderView;
    private View rootView;

    public c(TbPageContext tbPageContext) {
        this.rootView = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.emotion_manage_header, (ViewGroup) null, false);
        this.lEa = (LinearLayout) this.rootView.findViewById(R.id.emotion_manage_header_content);
        this.lEa.setVisibility(8);
        this.mHeaderView = this.rootView.findViewById(R.id.emotion_manage_item_header);
        this.lDY = (TextView) this.rootView.findViewById(R.id.emotion_manage_total_title);
        this.lDZ = this.rootView.findViewById(R.id.emotion_manage_edit_lable);
        this.lDZ.setVisibility(8);
    }

    public View getView() {
        return this.rootView;
    }

    public void onChangeSkinType(int i) {
        if (this.mHeaderView != null) {
            ap.setBackgroundColor(this.mHeaderView, R.color.CAM_X0204, i);
        }
        if (this.lEa != null) {
            ap.setBackgroundColor(this.lEa, R.color.CAM_X0204, i);
        }
        if (this.lDY != null) {
            ap.setViewTextColor(this.lDY, R.color.CAM_X0107, i);
            ap.setBackgroundColor(this.lDY, R.color.CAM_X0204, i);
        }
        if (this.lDZ != null) {
            ap.setViewTextColor(this.lDZ, R.color.CAM_X0107, i);
            ap.setBackgroundColor(this.lDZ, R.color.CAM_X0204, i);
        }
    }

    public void t(Integer num) {
        if (num != null) {
            if (num.intValue() == 0) {
                this.lEa.setVisibility(8);
            } else {
                this.lDY.setText(String.format(h.getString(R.string.emotion_manage_local_number), num));
                this.lEa.setVisibility(0);
            }
            if (com.baidu.tieba.newfaceshop.nativemotionmanager.a.diY().bLc()) {
                this.lDZ.setVisibility(0);
            } else {
                this.lDZ.setVisibility(8);
            }
        }
    }

    public void dja() {
        if (com.baidu.tieba.newfaceshop.nativemotionmanager.a.diY().bLc()) {
            this.lDZ.setVisibility(0);
        } else {
            this.lDZ.setVisibility(8);
        }
    }
}
