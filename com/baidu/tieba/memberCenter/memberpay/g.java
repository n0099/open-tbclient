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
    private NoNetworkView gAh;
    private NavigationBar jyD;
    private TextView lny;
    private TbImageView lqo;
    private TextView lqp;
    private TextView lqq;
    private TextView lqr;
    private TextView lqs;
    private TextView lqt;
    private Context mContext;
    private TbPageContext mPageContext;
    private int mSkinType = 3;

    public g(TbPageContext tbPageContext) {
        this.mContext = tbPageContext.getPageActivity();
        this.mPageContext = tbPageContext;
        tbPageContext.getPageActivity().setContentView(R.layout.member_pay_result_layout);
        this.jyD = (NavigationBar) tbPageContext.getPageActivity().findViewById(R.id.navigation_bar);
        this.jyD.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.jyD.showBottomLine();
        this.gAh = (NoNetworkView) tbPageContext.getPageActivity().findViewById(R.id.no_network_view);
        this.jyD.onChangeSkinType(tbPageContext, TbadkApplication.getInst().getSkinType());
        this.lqo = (TbImageView) tbPageContext.getPageActivity().findViewById(R.id.success_img);
        this.lqp = (TextView) tbPageContext.getPageActivity().findViewById(R.id.success_text);
        this.lqq = (TextView) tbPageContext.getPageActivity().findViewById(R.id.pay_content);
        this.lqs = (TextView) tbPageContext.getPageActivity().findViewById(R.id.super_member);
        this.lqr = (TextView) tbPageContext.getPageActivity().findViewById(R.id.tip_content);
        this.lqt = (TextView) tbPageContext.getPageActivity().findViewById(R.id.open_card_box_view);
        this.lqt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.memberCenter.memberpay.g.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                bf.bsV().a(g.this.mPageContext, new String[]{TbConfig.URL_JUMP_TAG_CARDBOX}, true);
            }
        });
        initView();
    }

    private void initView() {
        this.lny = this.jyD.setCenterTextTitle(this.mContext.getString(R.string.card_box_nav_title));
        this.gAh.onChangeSkinType(this.mPageContext, TbadkApplication.getInst().getSkinType());
        ap.setViewTextColor(this.lny, R.color.CAM_X0105);
        ap.setImageResource(this.lqo, R.drawable.icon_send_ok);
        ap.setViewTextColor(this.lqp, R.color.CAM_X0105);
        ap.setViewTextColor(this.lqq, R.color.CAM_X0105);
        ap.setViewTextColor(this.lqs, R.color.CAM_X0305);
        ap.setViewTextColor(this.lqr, R.color.CAM_X0108);
        ap.setViewTextColor(this.lqt, R.color.CAM_X0111);
        ap.setBackgroundResource(this.lqt, R.drawable.btn_all_orange);
    }

    public void Oc(String str) {
        this.lqq.setText(String.format(this.mContext.getString(R.string.pay_member_content), str));
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.jyD.onChangeSkinType(this.mPageContext, i);
            this.gAh.onChangeSkinType(this.mPageContext, i);
            ap.setViewTextColor(this.lny, R.color.CAM_X0105);
            ap.setImageResource(this.lqo, R.drawable.icon_send_ok);
            ap.setViewTextColor(this.lqp, R.color.CAM_X0105);
            ap.setViewTextColor(this.lqq, R.color.CAM_X0105);
            ap.setViewTextColor(this.lqs, R.color.CAM_X0305);
            ap.setViewTextColor(this.lqr, R.color.CAM_X0108);
            ap.setViewTextColor(this.lqt, R.color.CAM_X0111);
            ap.setBackgroundResource(this.lqt, R.drawable.btn_all_orange);
        }
        this.mSkinType = i;
    }
}
