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
    RoundLinearLayout mnA;
    TextView mnB;
    TextView mnC;
    TextView mnD;
    TextView mnE;
    TextView mnF;

    public f(TbPageContext tbPageContext, View.OnClickListener onClickListener) {
        super(tbPageContext);
        this.mPageContext = tbPageContext;
        a(this.mPageContext, onClickListener);
    }

    private void a(TbPageContext tbPageContext, View.OnClickListener onClickListener) {
        this.mnA = (RoundLinearLayout) LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.person_info_more_view, (ViewGroup) null);
        this.mnA.setRadius(TbadkApplication.getInst().getResources().getDimension(R.dimen.tbds31));
        this.mnB = (TextView) this.mnA.findViewById(R.id.person_info_more_view_item_friend);
        this.mnB.setOnClickListener(onClickListener);
        this.mnC = (TextView) this.mnA.findViewById(R.id.person_info_more_view_item_report);
        this.mnC.setOnClickListener(onClickListener);
        this.mnD = (TextView) this.mnA.findViewById(R.id.person_info_more_view_item_black);
        this.mnD.setOnClickListener(onClickListener);
        this.mnE = (TextView) this.mnA.findViewById(R.id.person_info_more_view_item_mute);
        this.mnE.setOnClickListener(onClickListener);
        this.euo = (TextView) this.mnA.findViewById(R.id.person_info_more_view_item_cancel);
        this.euo.setOnClickListener(onClickListener);
        this.icj = (TextView) this.mnA.findViewById(R.id.person_info_more_view_item_username);
        this.mnF = (TextView) this.mnA.findViewById(R.id.person_info_item_remove_fans_view);
        this.mnF.setOnClickListener(onClickListener);
    }

    public void m(boolean z, boolean z2, boolean z3) {
        if (z) {
            this.mnB.setText(R.string.remove_friend);
        } else {
            this.mnB.setText(R.string.frs_recommend_friend_item_add);
        }
        if (z2) {
            this.mnD.setText(R.string.remove_block_chat);
        } else {
            this.mnD.setText(R.string.block_chat_message);
        }
        if (z3) {
            this.mnF.setVisibility(0);
        } else {
            this.mnF.setVisibility(8);
        }
    }

    public View getView() {
        return this.mnA;
    }

    public View dxT() {
        return this.mnB;
    }

    public View dxU() {
        return this.mnD;
    }

    public View dxV() {
        return this.mnE;
    }

    public View dxW() {
        return this.mnC;
    }

    public View dxX() {
        return this.mnF;
    }

    public void HZ(int i) {
        this.mnE.setVisibility(0);
        if (i == 0) {
            this.mnE.setText(this.mPageContext.getResources().getString(R.string.mute));
        } else if (i == 1) {
            this.mnE.setText(this.mPageContext.getResources().getString(R.string.un_mute));
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
        ao.setBackgroundResource(this.mnA, R.color.CAM_X0211);
        ao.n(this.mnD, R.color.CAM_X0105);
        ao.n(this.mnB, R.color.CAM_X0105);
        ao.n(this.mnC, R.color.CAM_X0105);
        ao.n(this.mnE, R.color.CAM_X0105);
        ao.setViewTextColor(this.icj, R.color.CAM_X0109, 1);
        ao.n(this.mnF, R.color.CAM_X0105);
        ao.n(this.euo, R.color.CAM_X0107);
    }
}
