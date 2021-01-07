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
/* loaded from: classes9.dex */
public class a {
    private Context context;
    private NoNetworkView gCe;
    private NavigationBar jxD;
    private TextView lka;
    private HeadImageView lkb;
    private TextView lkc;
    private TextView lkd;
    private TbImageView lke;
    private EditText lkf;
    private TextView lkg;
    private TextView lkh;
    private TextView lki;
    private TextView lkj;
    private TextView lkk;
    private View mRootView;
    private int mSkinType = 3;
    private TbPageContext pageContext;

    public a(MemberExchangeActivity memberExchangeActivity) {
        this.pageContext = memberExchangeActivity.getPageContext();
        this.context = this.pageContext.getPageActivity();
        memberExchangeActivity.setContentView(R.layout.member_exchange_layout);
        this.mRootView = memberExchangeActivity.findViewById(R.id.member_exchange_root);
        this.mRootView.setOnClickListener(memberExchangeActivity);
        this.jxD = (NavigationBar) memberExchangeActivity.findViewById(R.id.navigation_bar);
        this.jxD.setOnClickListener(memberExchangeActivity);
        this.lka = this.jxD.setCenterTextTitle(this.pageContext.getString(R.string.exchange_member));
        this.gCe = (NoNetworkView) memberExchangeActivity.findViewById(R.id.no_network_view);
        this.jxD.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.jxD.showBottomLine();
        this.lkb = (HeadImageView) memberExchangeActivity.findViewById(R.id.member_header_image);
        this.lkb.setIsRound(true);
        this.lkc = (TextView) memberExchangeActivity.findViewById(R.id.member_name);
        this.lkd = (TextView) memberExchangeActivity.findViewById(R.id.member_content);
        this.lke = (TbImageView) memberExchangeActivity.findViewById(R.id.member_level);
        this.lkf = (EditText) memberExchangeActivity.findViewById(R.id.exchange_code);
        l.hideSoftKeyPad(this.pageContext.getPageActivity(), this.lkf);
        this.lkg = (TextView) memberExchangeActivity.findViewById(R.id.go_to_exchange);
        this.lkg.setOnClickListener(memberExchangeActivity);
        this.lkh = (TextView) memberExchangeActivity.findViewById(R.id.rule_title);
        this.lkh.setOnClickListener(null);
        this.lki = (TextView) memberExchangeActivity.findViewById(R.id.rule_text_1);
        this.lki.setClickable(false);
        this.lkj = (TextView) memberExchangeActivity.findViewById(R.id.rule_text_2);
        this.lkj.setClickable(false);
        this.lkk = (TextView) memberExchangeActivity.findViewById(R.id.rule_text_3);
        this.lkk.setClickable(false);
        onChangeSkinType(TbadkApplication.getInst().getSkinType());
    }

    public void l(String str, String str2, String str3, String str4, String str5) {
        this.lkb.startLoad(str, 12, false);
        this.lkc.setText(str2);
        if (!at.isEmpty(str3)) {
            this.lke.setVisibility(0);
            this.lke.startLoad(str3, 10, false);
        } else {
            this.lke.setVisibility(8);
        }
        if (!at.isEmpty(str4)) {
            this.lkd.setText(this.pageContext.getString(R.string.vip_member_end_time_tips) + str4);
        } else {
            this.lkd.setText(str5);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.jxD.onChangeSkinType(this.pageContext, i);
            this.gCe.onChangeSkinType(this.pageContext, i);
            ao.setViewTextColor(this.lkc, R.color.CAM_X0105);
            ao.setViewTextColor(this.lkd, R.color.CAM_X0109);
            ao.setViewTextColor(this.lkf, R.color.CAM_X0109);
            this.lkf.setHintTextColor(ao.getColor(R.color.CAM_X0109));
            ao.setBackgroundResource(this.lkf, R.drawable.exchange_edit_text_bg);
            ao.setViewTextColor(this.lkg, R.color.CAM_X0111);
            ao.setBackgroundResource(this.lkg, R.drawable.btn_all_orange);
            ao.setViewTextColor(this.lkh, R.color.CAM_X0105);
            ao.setViewTextColor(this.lki, R.color.CAM_X0109);
            ao.setViewTextColor(this.lkj, R.color.CAM_X0109);
            ao.setViewTextColor(this.lkk, R.color.CAM_X0109);
        }
        this.mSkinType = i;
    }

    public EditText getEditText() {
        return this.lkf;
    }
}
