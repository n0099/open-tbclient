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
/* loaded from: classes9.dex */
public class c {
    private TextView lAm;
    private View lAn;
    private LinearLayout lAo;
    private View mHeaderView;
    private View rootView;

    public c(TbPageContext tbPageContext) {
        this.rootView = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.emotion_manage_header, (ViewGroup) null, false);
        this.lAo = (LinearLayout) this.rootView.findViewById(R.id.emotion_manage_header_content);
        this.lAo.setVisibility(8);
        this.mHeaderView = this.rootView.findViewById(R.id.emotion_manage_item_header);
        this.lAm = (TextView) this.rootView.findViewById(R.id.emotion_manage_total_title);
        this.lAn = this.rootView.findViewById(R.id.emotion_manage_edit_lable);
        this.lAn.setVisibility(8);
    }

    public View getView() {
        return this.rootView;
    }

    public void onChangeSkinType(int i) {
        if (this.mHeaderView != null) {
            ao.setBackgroundColor(this.mHeaderView, R.color.CAM_X0204, i);
        }
        if (this.lAo != null) {
            ao.setBackgroundColor(this.lAo, R.color.CAM_X0204, i);
        }
        if (this.lAm != null) {
            ao.setViewTextColor(this.lAm, R.color.CAM_X0107, i);
            ao.setBackgroundColor(this.lAm, R.color.CAM_X0204, i);
        }
        if (this.lAn != null) {
            ao.setViewTextColor(this.lAn, R.color.CAM_X0107, i);
            ao.setBackgroundColor(this.lAn, R.color.CAM_X0204, i);
        }
    }

    public void s(Integer num) {
        if (num != null) {
            if (num.intValue() == 0) {
                this.lAo.setVisibility(8);
            } else {
                this.lAm.setText(String.format(h.getString(R.string.emotion_manage_local_number), num));
                this.lAo.setVisibility(0);
            }
            if (com.baidu.tieba.newfaceshop.nativemotionmanager.a.dkI().bOv()) {
                this.lAn.setVisibility(0);
            } else {
                this.lAn.setVisibility(8);
            }
        }
    }

    public void dkK() {
        if (com.baidu.tieba.newfaceshop.nativemotionmanager.a.dkI().bOv()) {
            this.lAn.setVisibility(0);
        } else {
            this.lAn.setVisibility(8);
        }
    }
}
