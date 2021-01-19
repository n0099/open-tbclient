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
/* loaded from: classes8.dex */
public class g {
    private NoNetworkView gxx;
    private NavigationBar jsX;
    private TextView lfv;
    private TbImageView lih;
    private TextView lii;
    private TextView lij;
    private TextView lik;
    private TextView lil;
    private TextView lim;
    private Context mContext;
    private TbPageContext mPageContext;
    private int mSkinType = 3;

    public g(TbPageContext tbPageContext) {
        this.mContext = tbPageContext.getPageActivity();
        this.mPageContext = tbPageContext;
        tbPageContext.getPageActivity().setContentView(R.layout.member_pay_result_layout);
        this.jsX = (NavigationBar) tbPageContext.getPageActivity().findViewById(R.id.navigation_bar);
        this.jsX.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.jsX.showBottomLine();
        this.gxx = (NoNetworkView) tbPageContext.getPageActivity().findViewById(R.id.no_network_view);
        this.jsX.onChangeSkinType(tbPageContext, TbadkApplication.getInst().getSkinType());
        this.lih = (TbImageView) tbPageContext.getPageActivity().findViewById(R.id.success_img);
        this.lii = (TextView) tbPageContext.getPageActivity().findViewById(R.id.success_text);
        this.lij = (TextView) tbPageContext.getPageActivity().findViewById(R.id.pay_content);
        this.lil = (TextView) tbPageContext.getPageActivity().findViewById(R.id.super_member);
        this.lik = (TextView) tbPageContext.getPageActivity().findViewById(R.id.tip_content);
        this.lim = (TextView) tbPageContext.getPageActivity().findViewById(R.id.open_card_box_view);
        this.lim.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.memberCenter.memberpay.g.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                be.bsB().a(g.this.mPageContext, new String[]{TbConfig.URL_JUMP_TAG_CARDBOX}, true);
            }
        });
        initView();
    }

    private void initView() {
        this.lfv = this.jsX.setCenterTextTitle(this.mContext.getString(R.string.card_box_nav_title));
        this.gxx.onChangeSkinType(this.mPageContext, TbadkApplication.getInst().getSkinType());
        ao.setViewTextColor(this.lfv, R.color.CAM_X0105);
        ao.setImageResource(this.lih, R.drawable.icon_send_ok);
        ao.setViewTextColor(this.lii, R.color.CAM_X0105);
        ao.setViewTextColor(this.lij, R.color.CAM_X0105);
        ao.setViewTextColor(this.lil, R.color.CAM_X0305);
        ao.setViewTextColor(this.lik, R.color.CAM_X0108);
        ao.setViewTextColor(this.lim, R.color.CAM_X0111);
        ao.setBackgroundResource(this.lim, R.drawable.btn_all_orange);
    }

    public void No(String str) {
        this.lij.setText(String.format(this.mContext.getString(R.string.pay_member_content), str));
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.jsX.onChangeSkinType(this.mPageContext, i);
            this.gxx.onChangeSkinType(this.mPageContext, i);
            ao.setViewTextColor(this.lfv, R.color.CAM_X0105);
            ao.setImageResource(this.lih, R.drawable.icon_send_ok);
            ao.setViewTextColor(this.lii, R.color.CAM_X0105);
            ao.setViewTextColor(this.lij, R.color.CAM_X0105);
            ao.setViewTextColor(this.lil, R.color.CAM_X0305);
            ao.setViewTextColor(this.lik, R.color.CAM_X0108);
            ao.setViewTextColor(this.lim, R.color.CAM_X0111);
            ao.setBackgroundResource(this.lim, R.drawable.btn_all_orange);
        }
        this.mSkinType = i;
    }
}
