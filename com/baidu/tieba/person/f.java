package com.baidu.tieba.person;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.dialog.RoundLinearLayout;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class f extends com.baidu.adp.base.d {
    TextView euo;
    TextView icj;
    TbPageContext mPageContext;
    RoundLinearLayout mnB;
    TextView mnC;
    TextView mnD;
    TextView mnE;
    TextView mnF;
    TextView mnG;

    public f(TbPageContext tbPageContext, View.OnClickListener onClickListener) {
        super(tbPageContext);
        this.mPageContext = tbPageContext;
        a(this.mPageContext, onClickListener);
    }

    private void a(TbPageContext tbPageContext, View.OnClickListener onClickListener) {
        this.mnB = (RoundLinearLayout) LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.person_info_more_view, (ViewGroup) null);
        this.mnB.setRadius(TbadkApplication.getInst().getResources().getDimension(R.dimen.tbds31));
        this.mnC = (TextView) this.mnB.findViewById(R.id.person_info_more_view_item_friend);
        this.mnC.setOnClickListener(onClickListener);
        this.mnD = (TextView) this.mnB.findViewById(R.id.person_info_more_view_item_report);
        this.mnD.setOnClickListener(onClickListener);
        this.mnE = (TextView) this.mnB.findViewById(R.id.person_info_more_view_item_black);
        this.mnE.setOnClickListener(onClickListener);
        this.mnF = (TextView) this.mnB.findViewById(R.id.person_info_more_view_item_mute);
        this.mnF.setOnClickListener(onClickListener);
        this.euo = (TextView) this.mnB.findViewById(R.id.person_info_more_view_item_cancel);
        this.euo.setOnClickListener(onClickListener);
        this.icj = (TextView) this.mnB.findViewById(R.id.person_info_more_view_item_username);
        this.mnG = (TextView) this.mnB.findViewById(R.id.person_info_item_remove_fans_view);
        this.mnG.setOnClickListener(onClickListener);
    }

    public void m(boolean z, boolean z2, boolean z3) {
        if (z) {
            this.mnC.setText(R.string.remove_friend);
        } else {
            this.mnC.setText(R.string.frs_recommend_friend_item_add);
        }
        if (z2) {
            this.mnE.setText(R.string.remove_block_chat);
        } else {
            this.mnE.setText(R.string.block_chat_message);
        }
        if (z3) {
            this.mnG.setVisibility(0);
        } else {
            this.mnG.setVisibility(8);
        }
    }

    public View getView() {
        return this.mnB;
    }

    public View dxS() {
        return this.mnC;
    }

    public View dxT() {
        return this.mnE;
    }

    public View dxU() {
        return this.mnF;
    }

    public View dxV() {
        return this.mnD;
    }

    public View dxW() {
        return this.mnG;
    }

    public void HZ(int i) {
        this.mnF.setVisibility(0);
        if (i == 0) {
            this.mnF.setText(this.mPageContext.getResources().getString(R.string.mute));
        } else if (i == 1) {
            this.mnF.setText(this.mPageContext.getResources().getString(R.string.un_mute));
        }
    }

    public void setUserName(String str) {
        if (TextUtils.isEmpty(str)) {
            this.icj.setVisibility(8);
            return;
        }
        this.icj.setVisibility(0);
        this.icj.setText(String.format(this.mPageContext.getResources().getString(R.string.more_info_username), str));
    }

    public void onChangeSkinType() {
        ao.setBackgroundResource(this.mnB, R.color.CAM_X0211);
        ao.n(this.mnE, R.color.CAM_X0105);
        ao.n(this.mnC, R.color.CAM_X0105);
        ao.n(this.mnD, R.color.CAM_X0105);
        ao.n(this.mnF, R.color.CAM_X0105);
        ao.setViewTextColor(this.icj, R.color.CAM_X0109, 1);
        ao.n(this.mnG, R.color.CAM_X0105);
        ao.n(this.euo, R.color.CAM_X0107);
    }
}
