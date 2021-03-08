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
/* loaded from: classes8.dex */
public class c {
    private TextView lGa;
    private View lGb;
    private LinearLayout lGc;
    private View mHeaderView;
    private View rootView;

    public c(TbPageContext tbPageContext) {
        this.rootView = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.emotion_manage_header, (ViewGroup) null, false);
        this.lGc = (LinearLayout) this.rootView.findViewById(R.id.emotion_manage_header_content);
        this.lGc.setVisibility(8);
        this.mHeaderView = this.rootView.findViewById(R.id.emotion_manage_item_header);
        this.lGa = (TextView) this.rootView.findViewById(R.id.emotion_manage_total_title);
        this.lGb = this.rootView.findViewById(R.id.emotion_manage_edit_lable);
        this.lGb.setVisibility(8);
    }

    public View getView() {
        return this.rootView;
    }

    public void onChangeSkinType(int i) {
        if (this.mHeaderView != null) {
            ap.setBackgroundColor(this.mHeaderView, R.color.CAM_X0204, i);
        }
        if (this.lGc != null) {
            ap.setBackgroundColor(this.lGc, R.color.CAM_X0204, i);
        }
        if (this.lGa != null) {
            ap.setViewTextColor(this.lGa, R.color.CAM_X0107, i);
            ap.setBackgroundColor(this.lGa, R.color.CAM_X0204, i);
        }
        if (this.lGb != null) {
            ap.setViewTextColor(this.lGb, R.color.CAM_X0107, i);
            ap.setBackgroundColor(this.lGb, R.color.CAM_X0204, i);
        }
    }

    public void t(Integer num) {
        if (num != null) {
            if (num.intValue() == 0) {
                this.lGc.setVisibility(8);
            } else {
                this.lGa.setText(String.format(h.getString(R.string.emotion_manage_local_number), num));
                this.lGc.setVisibility(0);
            }
            if (com.baidu.tieba.newfaceshop.nativemotionmanager.a.djh().bLg()) {
                this.lGb.setVisibility(0);
            } else {
                this.lGb.setVisibility(8);
            }
        }
    }

    public void djj() {
        if (com.baidu.tieba.newfaceshop.nativemotionmanager.a.djh().bLg()) {
            this.lGb.setVisibility(0);
        } else {
            this.lGb.setVisibility(8);
        }
    }
}
