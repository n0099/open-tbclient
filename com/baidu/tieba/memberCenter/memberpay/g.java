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
/* loaded from: classes8.dex */
public class g {
    private NoNetworkView gCe;
    private NavigationBar jAA;
    private TextView lpS;
    private TbImageView lsE;
    private TextView lsF;
    private TextView lsG;
    private TextView lsH;
    private TextView lsI;
    private TextView lsJ;
    private Context mContext;
    private TbPageContext mPageContext;
    private int mSkinType = 3;

    public g(TbPageContext tbPageContext) {
        this.mContext = tbPageContext.getPageActivity();
        this.mPageContext = tbPageContext;
        tbPageContext.getPageActivity().setContentView(R.layout.member_pay_result_layout);
        this.jAA = (NavigationBar) tbPageContext.getPageActivity().findViewById(R.id.navigation_bar);
        this.jAA.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.jAA.showBottomLine();
        this.gCe = (NoNetworkView) tbPageContext.getPageActivity().findViewById(R.id.no_network_view);
        this.jAA.onChangeSkinType(tbPageContext, TbadkApplication.getInst().getSkinType());
        this.lsE = (TbImageView) tbPageContext.getPageActivity().findViewById(R.id.success_img);
        this.lsF = (TextView) tbPageContext.getPageActivity().findViewById(R.id.success_text);
        this.lsG = (TextView) tbPageContext.getPageActivity().findViewById(R.id.pay_content);
        this.lsI = (TextView) tbPageContext.getPageActivity().findViewById(R.id.super_member);
        this.lsH = (TextView) tbPageContext.getPageActivity().findViewById(R.id.tip_content);
        this.lsJ = (TextView) tbPageContext.getPageActivity().findViewById(R.id.open_card_box_view);
        this.lsJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.memberCenter.memberpay.g.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                bf.bsY().a(g.this.mPageContext, new String[]{TbConfig.URL_JUMP_TAG_CARDBOX}, true);
            }
        });
        initView();
    }

    private void initView() {
        this.lpS = this.jAA.setCenterTextTitle(this.mContext.getString(R.string.card_box_nav_title));
        this.gCe.onChangeSkinType(this.mPageContext, TbadkApplication.getInst().getSkinType());
        ap.setViewTextColor(this.lpS, R.color.CAM_X0105);
        ap.setImageResource(this.lsE, R.drawable.icon_send_ok);
        ap.setViewTextColor(this.lsF, R.color.CAM_X0105);
        ap.setViewTextColor(this.lsG, R.color.CAM_X0105);
        ap.setViewTextColor(this.lsI, R.color.CAM_X0305);
        ap.setViewTextColor(this.lsH, R.color.CAM_X0108);
        ap.setViewTextColor(this.lsJ, R.color.CAM_X0111);
        ap.setBackgroundResource(this.lsJ, R.drawable.btn_all_orange);
    }

    public void Oj(String str) {
        this.lsG.setText(String.format(this.mContext.getString(R.string.pay_member_content), str));
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.jAA.onChangeSkinType(this.mPageContext, i);
            this.gCe.onChangeSkinType(this.mPageContext, i);
            ap.setViewTextColor(this.lpS, R.color.CAM_X0105);
            ap.setImageResource(this.lsE, R.drawable.icon_send_ok);
            ap.setViewTextColor(this.lsF, R.color.CAM_X0105);
            ap.setViewTextColor(this.lsG, R.color.CAM_X0105);
            ap.setViewTextColor(this.lsI, R.color.CAM_X0305);
            ap.setViewTextColor(this.lsH, R.color.CAM_X0108);
            ap.setViewTextColor(this.lsJ, R.color.CAM_X0111);
            ap.setBackgroundResource(this.lsJ, R.drawable.btn_all_orange);
        }
        this.mSkinType = i;
    }
}
