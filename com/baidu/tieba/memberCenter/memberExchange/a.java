package com.baidu.tieba.memberCenter.memberExchange;

import android.content.Context;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class a {
    private Context context;
    private NoNetworkView gAv;
    private NavigationBar jyR;
    private TextView lnM;
    private HeadImageView lnN;
    private TextView lnO;
    private TextView lnP;
    private TbImageView lnQ;
    private EditText lnR;
    private TextView lnS;
    private TextView lnT;
    private TextView lnU;
    private TextView lnV;
    private TextView lnW;
    private View mRootView;
    private int mSkinType = 3;
    private TbPageContext pageContext;

    public a(MemberExchangeActivity memberExchangeActivity) {
        this.pageContext = memberExchangeActivity.getPageContext();
        this.context = this.pageContext.getPageActivity();
        memberExchangeActivity.setContentView(R.layout.member_exchange_layout);
        this.mRootView = memberExchangeActivity.findViewById(R.id.member_exchange_root);
        this.mRootView.setOnClickListener(memberExchangeActivity);
        this.jyR = (NavigationBar) memberExchangeActivity.findViewById(R.id.navigation_bar);
        this.jyR.setOnClickListener(memberExchangeActivity);
        this.lnM = this.jyR.setCenterTextTitle(this.pageContext.getString(R.string.exchange_member));
        this.gAv = (NoNetworkView) memberExchangeActivity.findViewById(R.id.no_network_view);
        this.jyR.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.jyR.showBottomLine();
        this.lnN = (HeadImageView) memberExchangeActivity.findViewById(R.id.member_header_image);
        this.lnN.setIsRound(true);
        this.lnO = (TextView) memberExchangeActivity.findViewById(R.id.member_name);
        this.lnP = (TextView) memberExchangeActivity.findViewById(R.id.member_content);
        this.lnQ = (TbImageView) memberExchangeActivity.findViewById(R.id.member_level);
        this.lnR = (EditText) memberExchangeActivity.findViewById(R.id.exchange_code);
        l.hideSoftKeyPad(this.pageContext.getPageActivity(), this.lnR);
        this.lnS = (TextView) memberExchangeActivity.findViewById(R.id.go_to_exchange);
        this.lnS.setOnClickListener(memberExchangeActivity);
        this.lnT = (TextView) memberExchangeActivity.findViewById(R.id.rule_title);
        this.lnT.setOnClickListener(null);
        this.lnU = (TextView) memberExchangeActivity.findViewById(R.id.rule_text_1);
        this.lnU.setClickable(false);
        this.lnV = (TextView) memberExchangeActivity.findViewById(R.id.rule_text_2);
        this.lnV.setClickable(false);
        this.lnW = (TextView) memberExchangeActivity.findViewById(R.id.rule_text_3);
        this.lnW.setClickable(false);
        onChangeSkinType(TbadkApplication.getInst().getSkinType());
    }

    public void l(String str, String str2, String str3, String str4, String str5) {
        this.lnN.startLoad(str, 12, false);
        this.lnO.setText(str2);
        if (!au.isEmpty(str3)) {
            this.lnQ.setVisibility(0);
            this.lnQ.startLoad(str3, 10, false);
        } else {
            this.lnQ.setVisibility(8);
        }
        if (!au.isEmpty(str4)) {
            this.lnP.setText(this.pageContext.getString(R.string.vip_member_end_time_tips) + str4);
        } else {
            this.lnP.setText(str5);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.jyR.onChangeSkinType(this.pageContext, i);
            this.gAv.onChangeSkinType(this.pageContext, i);
            ap.setViewTextColor(this.lnO, R.color.CAM_X0105);
            ap.setViewTextColor(this.lnP, R.color.CAM_X0109);
            ap.setViewTextColor(this.lnR, R.color.CAM_X0109);
            this.lnR.setHintTextColor(ap.getColor(R.color.CAM_X0109));
            ap.setBackgroundResource(this.lnR, R.drawable.exchange_edit_text_bg);
            ap.setViewTextColor(this.lnS, R.color.CAM_X0111);
            ap.setBackgroundResource(this.lnS, R.drawable.btn_all_orange);
            ap.setViewTextColor(this.lnT, R.color.CAM_X0105);
            ap.setViewTextColor(this.lnU, R.color.CAM_X0109);
            ap.setViewTextColor(this.lnV, R.color.CAM_X0109);
            ap.setViewTextColor(this.lnW, R.color.CAM_X0109);
        }
        this.mSkinType = i;
    }

    public EditText getEditText() {
        return this.lnR;
    }
}
