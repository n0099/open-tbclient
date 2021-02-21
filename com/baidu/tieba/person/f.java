package com.baidu.tieba.person;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.dialog.RoundLinearLayout;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class f extends com.baidu.adp.base.d {
    TextView erH;
    TextView ick;
    TbPageContext mPageContext;
    RoundLinearLayout msn;
    TextView mso;
    TextView msp;
    TextView msq;
    TextView msr;
    TextView mss;

    public f(TbPageContext tbPageContext, View.OnClickListener onClickListener) {
        super(tbPageContext);
        this.mPageContext = tbPageContext;
        a(this.mPageContext, onClickListener);
    }

    private void a(TbPageContext tbPageContext, View.OnClickListener onClickListener) {
        this.msn = (RoundLinearLayout) LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.person_info_more_view, (ViewGroup) null);
        this.msn.setRadius(TbadkApplication.getInst().getResources().getDimension(R.dimen.tbds31));
        this.mso = (TextView) this.msn.findViewById(R.id.person_info_more_view_item_friend);
        this.mso.setOnClickListener(onClickListener);
        this.msp = (TextView) this.msn.findViewById(R.id.person_info_more_view_item_report);
        this.msp.setOnClickListener(onClickListener);
        this.msq = (TextView) this.msn.findViewById(R.id.person_info_more_view_item_black);
        this.msq.setOnClickListener(onClickListener);
        this.msr = (TextView) this.msn.findViewById(R.id.person_info_more_view_item_mute);
        this.msr.setOnClickListener(onClickListener);
        this.erH = (TextView) this.msn.findViewById(R.id.person_info_more_view_item_cancel);
        this.erH.setOnClickListener(onClickListener);
        this.ick = (TextView) this.msn.findViewById(R.id.person_info_more_view_item_username);
        this.mss = (TextView) this.msn.findViewById(R.id.person_info_item_remove_fans_view);
        this.mss.setOnClickListener(onClickListener);
    }

    public void m(boolean z, boolean z2, boolean z3) {
        if (z) {
            this.mso.setText(R.string.remove_friend);
        } else {
            this.mso.setText(R.string.frs_recommend_friend_item_add);
        }
        if (z2) {
            this.msq.setText(R.string.remove_block_chat);
        } else {
            this.msq.setText(R.string.block_chat_message);
        }
        if (z3) {
            this.mss.setVisibility(0);
        } else {
            this.mss.setVisibility(8);
        }
    }

    public View getView() {
        return this.msn;
    }

    public View dwr() {
        return this.mso;
    }

    public View dws() {
        return this.msq;
    }

    public View dwt() {
        return this.msr;
    }

    public View dwu() {
        return this.msp;
    }

    public View dwv() {
        return this.mss;
    }

    public void GL(int i) {
        this.msr.setVisibility(0);
        if (i == 0) {
            this.msr.setText(this.mPageContext.getResources().getString(R.string.mute));
        } else if (i == 1) {
            this.msr.setText(this.mPageContext.getResources().getString(R.string.un_mute));
        }
    }

    public void setUserName(String str) {
        if (TextUtils.isEmpty(str)) {
            this.ick.setVisibility(8);
            return;
        }
        this.ick.setVisibility(0);
        this.ick.setText(String.format(this.mPageContext.getResources().getString(R.string.more_info_username), str));
    }

    public void onChangeSkinType() {
        ap.setBackgroundResource(this.msn, R.color.CAM_X0211);
        ap.n(this.msq, R.color.CAM_X0105);
        ap.n(this.mso, R.color.CAM_X0105);
        ap.n(this.msp, R.color.CAM_X0105);
        ap.n(this.msr, R.color.CAM_X0105);
        ap.setViewTextColor(this.ick, R.color.CAM_X0109, 1);
        ap.n(this.mss, R.color.CAM_X0105);
        ap.n(this.erH, R.color.CAM_X0107);
    }
}
