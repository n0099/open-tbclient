package com.baidu.tieba.memberCenter.memberExchange;

import android.content.Context;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class a {
    private Context context;
    private NoNetworkView gxx;
    private NavigationBar jsX;
    private EditText lfA;
    private TextView lfB;
    private TextView lfC;
    private TextView lfD;
    private TextView lfE;
    private TextView lfF;
    private TextView lfv;
    private HeadImageView lfw;
    private TextView lfx;
    private TextView lfy;
    private TbImageView lfz;
    private View mRootView;
    private int mSkinType = 3;
    private TbPageContext pageContext;

    public a(MemberExchangeActivity memberExchangeActivity) {
        this.pageContext = memberExchangeActivity.getPageContext();
        this.context = this.pageContext.getPageActivity();
        memberExchangeActivity.setContentView(R.layout.member_exchange_layout);
        this.mRootView = memberExchangeActivity.findViewById(R.id.member_exchange_root);
        this.mRootView.setOnClickListener(memberExchangeActivity);
        this.jsX = (NavigationBar) memberExchangeActivity.findViewById(R.id.navigation_bar);
        this.jsX.setOnClickListener(memberExchangeActivity);
        this.lfv = this.jsX.setCenterTextTitle(this.pageContext.getString(R.string.exchange_member));
        this.gxx = (NoNetworkView) memberExchangeActivity.findViewById(R.id.no_network_view);
        this.jsX.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.jsX.showBottomLine();
        this.lfw = (HeadImageView) memberExchangeActivity.findViewById(R.id.member_header_image);
        this.lfw.setIsRound(true);
        this.lfx = (TextView) memberExchangeActivity.findViewById(R.id.member_name);
        this.lfy = (TextView) memberExchangeActivity.findViewById(R.id.member_content);
        this.lfz = (TbImageView) memberExchangeActivity.findViewById(R.id.member_level);
        this.lfA = (EditText) memberExchangeActivity.findViewById(R.id.exchange_code);
        l.hideSoftKeyPad(this.pageContext.getPageActivity(), this.lfA);
        this.lfB = (TextView) memberExchangeActivity.findViewById(R.id.go_to_exchange);
        this.lfB.setOnClickListener(memberExchangeActivity);
        this.lfC = (TextView) memberExchangeActivity.findViewById(R.id.rule_title);
        this.lfC.setOnClickListener(null);
        this.lfD = (TextView) memberExchangeActivity.findViewById(R.id.rule_text_1);
        this.lfD.setClickable(false);
        this.lfE = (TextView) memberExchangeActivity.findViewById(R.id.rule_text_2);
        this.lfE.setClickable(false);
        this.lfF = (TextView) memberExchangeActivity.findViewById(R.id.rule_text_3);
        this.lfF.setClickable(false);
        onChangeSkinType(TbadkApplication.getInst().getSkinType());
    }

    public void l(String str, String str2, String str3, String str4, String str5) {
        this.lfw.startLoad(str, 12, false);
        this.lfx.setText(str2);
        if (!at.isEmpty(str3)) {
            this.lfz.setVisibility(0);
            this.lfz.startLoad(str3, 10, false);
        } else {
            this.lfz.setVisibility(8);
        }
        if (!at.isEmpty(str4)) {
            this.lfy.setText(this.pageContext.getString(R.string.vip_member_end_time_tips) + str4);
        } else {
            this.lfy.setText(str5);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.jsX.onChangeSkinType(this.pageContext, i);
            this.gxx.onChangeSkinType(this.pageContext, i);
            ao.setViewTextColor(this.lfx, R.color.CAM_X0105);
            ao.setViewTextColor(this.lfy, R.color.CAM_X0109);
            ao.setViewTextColor(this.lfA, R.color.CAM_X0109);
            this.lfA.setHintTextColor(ao.getColor(R.color.CAM_X0109));
            ao.setBackgroundResource(this.lfA, R.drawable.exchange_edit_text_bg);
            ao.setViewTextColor(this.lfB, R.color.CAM_X0111);
            ao.setBackgroundResource(this.lfB, R.drawable.btn_all_orange);
            ao.setViewTextColor(this.lfC, R.color.CAM_X0105);
            ao.setViewTextColor(this.lfD, R.color.CAM_X0109);
            ao.setViewTextColor(this.lfE, R.color.CAM_X0109);
            ao.setViewTextColor(this.lfF, R.color.CAM_X0109);
        }
        this.mSkinType = i;
    }

    public EditText getEditText() {
        return this.lfA;
    }
}
