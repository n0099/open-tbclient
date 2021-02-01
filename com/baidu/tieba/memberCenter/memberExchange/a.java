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
    private NoNetworkView gAh;
    private NavigationBar jyD;
    private TextView lnA;
    private TextView lnB;
    private TbImageView lnC;
    private EditText lnD;
    private TextView lnE;
    private TextView lnF;
    private TextView lnG;
    private TextView lnH;
    private TextView lnI;
    private TextView lny;
    private HeadImageView lnz;
    private View mRootView;
    private int mSkinType = 3;
    private TbPageContext pageContext;

    public a(MemberExchangeActivity memberExchangeActivity) {
        this.pageContext = memberExchangeActivity.getPageContext();
        this.context = this.pageContext.getPageActivity();
        memberExchangeActivity.setContentView(R.layout.member_exchange_layout);
        this.mRootView = memberExchangeActivity.findViewById(R.id.member_exchange_root);
        this.mRootView.setOnClickListener(memberExchangeActivity);
        this.jyD = (NavigationBar) memberExchangeActivity.findViewById(R.id.navigation_bar);
        this.jyD.setOnClickListener(memberExchangeActivity);
        this.lny = this.jyD.setCenterTextTitle(this.pageContext.getString(R.string.exchange_member));
        this.gAh = (NoNetworkView) memberExchangeActivity.findViewById(R.id.no_network_view);
        this.jyD.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.jyD.showBottomLine();
        this.lnz = (HeadImageView) memberExchangeActivity.findViewById(R.id.member_header_image);
        this.lnz.setIsRound(true);
        this.lnA = (TextView) memberExchangeActivity.findViewById(R.id.member_name);
        this.lnB = (TextView) memberExchangeActivity.findViewById(R.id.member_content);
        this.lnC = (TbImageView) memberExchangeActivity.findViewById(R.id.member_level);
        this.lnD = (EditText) memberExchangeActivity.findViewById(R.id.exchange_code);
        l.hideSoftKeyPad(this.pageContext.getPageActivity(), this.lnD);
        this.lnE = (TextView) memberExchangeActivity.findViewById(R.id.go_to_exchange);
        this.lnE.setOnClickListener(memberExchangeActivity);
        this.lnF = (TextView) memberExchangeActivity.findViewById(R.id.rule_title);
        this.lnF.setOnClickListener(null);
        this.lnG = (TextView) memberExchangeActivity.findViewById(R.id.rule_text_1);
        this.lnG.setClickable(false);
        this.lnH = (TextView) memberExchangeActivity.findViewById(R.id.rule_text_2);
        this.lnH.setClickable(false);
        this.lnI = (TextView) memberExchangeActivity.findViewById(R.id.rule_text_3);
        this.lnI.setClickable(false);
        onChangeSkinType(TbadkApplication.getInst().getSkinType());
    }

    public void l(String str, String str2, String str3, String str4, String str5) {
        this.lnz.startLoad(str, 12, false);
        this.lnA.setText(str2);
        if (!au.isEmpty(str3)) {
            this.lnC.setVisibility(0);
            this.lnC.startLoad(str3, 10, false);
        } else {
            this.lnC.setVisibility(8);
        }
        if (!au.isEmpty(str4)) {
            this.lnB.setText(this.pageContext.getString(R.string.vip_member_end_time_tips) + str4);
        } else {
            this.lnB.setText(str5);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.jyD.onChangeSkinType(this.pageContext, i);
            this.gAh.onChangeSkinType(this.pageContext, i);
            ap.setViewTextColor(this.lnA, R.color.CAM_X0105);
            ap.setViewTextColor(this.lnB, R.color.CAM_X0109);
            ap.setViewTextColor(this.lnD, R.color.CAM_X0109);
            this.lnD.setHintTextColor(ap.getColor(R.color.CAM_X0109));
            ap.setBackgroundResource(this.lnD, R.drawable.exchange_edit_text_bg);
            ap.setViewTextColor(this.lnE, R.color.CAM_X0111);
            ap.setBackgroundResource(this.lnE, R.drawable.btn_all_orange);
            ap.setViewTextColor(this.lnF, R.color.CAM_X0105);
            ap.setViewTextColor(this.lnG, R.color.CAM_X0109);
            ap.setViewTextColor(this.lnH, R.color.CAM_X0109);
            ap.setViewTextColor(this.lnI, R.color.CAM_X0109);
        }
        this.mSkinType = i;
    }

    public EditText getEditText() {
        return this.lnD;
    }
}
