package com.baidu.tieba.memberCenter.memberpay;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class g {
    private NoNetworkView gAv;
    private NavigationBar jyR;
    private TextView lnM;
    private TbImageView lqC;
    private TextView lqD;
    private TextView lqE;
    private TextView lqF;
    private TextView lqG;
    private TextView lqH;
    private Context mContext;
    private TbPageContext mPageContext;
    private int mSkinType = 3;

    public g(TbPageContext tbPageContext) {
        this.mContext = tbPageContext.getPageActivity();
        this.mPageContext = tbPageContext;
        tbPageContext.getPageActivity().setContentView(R.layout.member_pay_result_layout);
        this.jyR = (NavigationBar) tbPageContext.getPageActivity().findViewById(R.id.navigation_bar);
        this.jyR.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.jyR.showBottomLine();
        this.gAv = (NoNetworkView) tbPageContext.getPageActivity().findViewById(R.id.no_network_view);
        this.jyR.onChangeSkinType(tbPageContext, TbadkApplication.getInst().getSkinType());
        this.lqC = (TbImageView) tbPageContext.getPageActivity().findViewById(R.id.success_img);
        this.lqD = (TextView) tbPageContext.getPageActivity().findViewById(R.id.success_text);
        this.lqE = (TextView) tbPageContext.getPageActivity().findViewById(R.id.pay_content);
        this.lqG = (TextView) tbPageContext.getPageActivity().findViewById(R.id.super_member);
        this.lqF = (TextView) tbPageContext.getPageActivity().findViewById(R.id.tip_content);
        this.lqH = (TextView) tbPageContext.getPageActivity().findViewById(R.id.open_card_box_view);
        this.lqH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.memberCenter.memberpay.g.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                bf.bsV().a(g.this.mPageContext, new String[]{TbConfig.URL_JUMP_TAG_CARDBOX}, true);
            }
        });
        initView();
    }

    private void initView() {
        this.lnM = this.jyR.setCenterTextTitle(this.mContext.getString(R.string.card_box_nav_title));
        this.gAv.onChangeSkinType(this.mPageContext, TbadkApplication.getInst().getSkinType());
        ap.setViewTextColor(this.lnM, R.color.CAM_X0105);
        ap.setImageResource(this.lqC, R.drawable.icon_send_ok);
        ap.setViewTextColor(this.lqD, R.color.CAM_X0105);
        ap.setViewTextColor(this.lqE, R.color.CAM_X0105);
        ap.setViewTextColor(this.lqG, R.color.CAM_X0305);
        ap.setViewTextColor(this.lqF, R.color.CAM_X0108);
        ap.setViewTextColor(this.lqH, R.color.CAM_X0111);
        ap.setBackgroundResource(this.lqH, R.drawable.btn_all_orange);
    }

    public void Od(String str) {
        this.lqE.setText(String.format(this.mContext.getString(R.string.pay_member_content), str));
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.jyR.onChangeSkinType(this.mPageContext, i);
            this.gAv.onChangeSkinType(this.mPageContext, i);
            ap.setViewTextColor(this.lnM, R.color.CAM_X0105);
            ap.setImageResource(this.lqC, R.drawable.icon_send_ok);
            ap.setViewTextColor(this.lqD, R.color.CAM_X0105);
            ap.setViewTextColor(this.lqE, R.color.CAM_X0105);
            ap.setViewTextColor(this.lqG, R.color.CAM_X0305);
            ap.setViewTextColor(this.lqF, R.color.CAM_X0108);
            ap.setViewTextColor(this.lqH, R.color.CAM_X0111);
            ap.setBackgroundResource(this.lqH, R.drawable.btn_all_orange);
        }
        this.mSkinType = i;
    }
}
