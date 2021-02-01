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
    TextView ibW;
    TbPageContext mPageContext;
    RoundLinearLayout mrX;
    TextView mrY;
    TextView mrZ;
    TextView msa;
    TextView msb;
    TextView msc;

    public f(TbPageContext tbPageContext, View.OnClickListener onClickListener) {
        super(tbPageContext);
        this.mPageContext = tbPageContext;
        a(this.mPageContext, onClickListener);
    }

    private void a(TbPageContext tbPageContext, View.OnClickListener onClickListener) {
        this.mrX = (RoundLinearLayout) LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.person_info_more_view, (ViewGroup) null);
        this.mrX.setRadius(TbadkApplication.getInst().getResources().getDimension(R.dimen.tbds31));
        this.mrY = (TextView) this.mrX.findViewById(R.id.person_info_more_view_item_friend);
        this.mrY.setOnClickListener(onClickListener);
        this.mrZ = (TextView) this.mrX.findViewById(R.id.person_info_more_view_item_report);
        this.mrZ.setOnClickListener(onClickListener);
        this.msa = (TextView) this.mrX.findViewById(R.id.person_info_more_view_item_black);
        this.msa.setOnClickListener(onClickListener);
        this.msb = (TextView) this.mrX.findViewById(R.id.person_info_more_view_item_mute);
        this.msb.setOnClickListener(onClickListener);
        this.erH = (TextView) this.mrX.findViewById(R.id.person_info_more_view_item_cancel);
        this.erH.setOnClickListener(onClickListener);
        this.ibW = (TextView) this.mrX.findViewById(R.id.person_info_more_view_item_username);
        this.msc = (TextView) this.mrX.findViewById(R.id.person_info_item_remove_fans_view);
        this.msc.setOnClickListener(onClickListener);
    }

    public void m(boolean z, boolean z2, boolean z3) {
        if (z) {
            this.mrY.setText(R.string.remove_friend);
        } else {
            this.mrY.setText(R.string.frs_recommend_friend_item_add);
        }
        if (z2) {
            this.msa.setText(R.string.remove_block_chat);
        } else {
            this.msa.setText(R.string.block_chat_message);
        }
        if (z3) {
            this.msc.setVisibility(0);
        } else {
            this.msc.setVisibility(8);
        }
    }

    public View getView() {
        return this.mrX;
    }

    public View dwk() {
        return this.mrY;
    }

    public View dwl() {
        return this.msa;
    }

    public View dwm() {
        return this.msb;
    }

    public View dwn() {
        return this.mrZ;
    }

    public View dwo() {
        return this.msc;
    }

    public void GL(int i) {
        this.msb.setVisibility(0);
        if (i == 0) {
            this.msb.setText(this.mPageContext.getResources().getString(R.string.mute));
        } else if (i == 1) {
            this.msb.setText(this.mPageContext.getResources().getString(R.string.un_mute));
        }
    }

    public void setUserName(String str) {
        if (TextUtils.isEmpty(str)) {
            this.ibW.setVisibility(8);
            return;
        }
        this.ibW.setVisibility(0);
        this.ibW.setText(String.format(this.mPageContext.getResources().getString(R.string.more_info_username), str));
    }

    public void onChangeSkinType() {
        ap.setBackgroundResource(this.mrX, R.color.CAM_X0211);
        ap.n(this.msa, R.color.CAM_X0105);
        ap.n(this.mrY, R.color.CAM_X0105);
        ap.n(this.mrZ, R.color.CAM_X0105);
        ap.n(this.msb, R.color.CAM_X0105);
        ap.setViewTextColor(this.ibW, R.color.CAM_X0109, 1);
        ap.n(this.msc, R.color.CAM_X0105);
        ap.n(this.erH, R.color.CAM_X0107);
    }
}
