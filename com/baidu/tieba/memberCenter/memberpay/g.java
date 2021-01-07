package com.baidu.tieba.memberCenter.memberpay;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class g {
    private NoNetworkView gCe;
    private NavigationBar jxD;
    private TextView lka;
    private TbImageView lmM;
    private TextView lmN;
    private TextView lmO;
    private TextView lmP;
    private TextView lmQ;
    private TextView lmR;
    private Context mContext;
    private TbPageContext mPageContext;
    private int mSkinType = 3;

    public g(TbPageContext tbPageContext) {
        this.mContext = tbPageContext.getPageActivity();
        this.mPageContext = tbPageContext;
        tbPageContext.getPageActivity().setContentView(R.layout.member_pay_result_layout);
        this.jxD = (NavigationBar) tbPageContext.getPageActivity().findViewById(R.id.navigation_bar);
        this.jxD.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.jxD.showBottomLine();
        this.gCe = (NoNetworkView) tbPageContext.getPageActivity().findViewById(R.id.no_network_view);
        this.jxD.onChangeSkinType(tbPageContext, TbadkApplication.getInst().getSkinType());
        this.lmM = (TbImageView) tbPageContext.getPageActivity().findViewById(R.id.success_img);
        this.lmN = (TextView) tbPageContext.getPageActivity().findViewById(R.id.success_text);
        this.lmO = (TextView) tbPageContext.getPageActivity().findViewById(R.id.pay_content);
        this.lmQ = (TextView) tbPageContext.getPageActivity().findViewById(R.id.super_member);
        this.lmP = (TextView) tbPageContext.getPageActivity().findViewById(R.id.tip_content);
        this.lmR = (TextView) tbPageContext.getPageActivity().findViewById(R.id.open_card_box_view);
        this.lmR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.memberCenter.memberpay.g.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                be.bwv().a(g.this.mPageContext, new String[]{TbConfig.URL_JUMP_TAG_CARDBOX}, true);
            }
        });
        initView();
    }

    private void initView() {
        this.lka = this.jxD.setCenterTextTitle(this.mContext.getString(R.string.card_box_nav_title));
        this.gCe.onChangeSkinType(this.mPageContext, TbadkApplication.getInst().getSkinType());
        ao.setViewTextColor(this.lka, R.color.CAM_X0105);
        ao.setImageResource(this.lmM, R.drawable.icon_send_ok);
        ao.setViewTextColor(this.lmN, R.color.CAM_X0105);
        ao.setViewTextColor(this.lmO, R.color.CAM_X0105);
        ao.setViewTextColor(this.lmQ, R.color.CAM_X0305);
        ao.setViewTextColor(this.lmP, R.color.CAM_X0108);
        ao.setViewTextColor(this.lmR, R.color.CAM_X0111);
        ao.setBackgroundResource(this.lmR, R.drawable.btn_all_orange);
    }

    public void Ov(String str) {
        this.lmO.setText(String.format(this.mContext.getString(R.string.pay_member_content), str));
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.jxD.onChangeSkinType(this.mPageContext, i);
            this.gCe.onChangeSkinType(this.mPageContext, i);
            ao.setViewTextColor(this.lka, R.color.CAM_X0105);
            ao.setImageResource(this.lmM, R.drawable.icon_send_ok);
            ao.setViewTextColor(this.lmN, R.color.CAM_X0105);
            ao.setViewTextColor(this.lmO, R.color.CAM_X0105);
            ao.setViewTextColor(this.lmQ, R.color.CAM_X0305);
            ao.setViewTextColor(this.lmP, R.color.CAM_X0108);
            ao.setViewTextColor(this.lmR, R.color.CAM_X0111);
            ao.setBackgroundResource(this.lmR, R.drawable.btn_all_orange);
        }
        this.mSkinType = i;
    }
}
