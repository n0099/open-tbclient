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
/* loaded from: classes8.dex */
public class a {
    private Context context;
    private NoNetworkView gCe;
    private NavigationBar jAA;
    private TextView lpS;
    private HeadImageView lpT;
    private TextView lpU;
    private TextView lpV;
    private TbImageView lpW;
    private EditText lpX;
    private TextView lpY;
    private TextView lpZ;
    private TextView lqa;
    private TextView lqb;
    private TextView lqc;
    private View mRootView;
    private int mSkinType = 3;
    private TbPageContext pageContext;

    public a(MemberExchangeActivity memberExchangeActivity) {
        this.pageContext = memberExchangeActivity.getPageContext();
        this.context = this.pageContext.getPageActivity();
        memberExchangeActivity.setContentView(R.layout.member_exchange_layout);
        this.mRootView = memberExchangeActivity.findViewById(R.id.member_exchange_root);
        this.mRootView.setOnClickListener(memberExchangeActivity);
        this.jAA = (NavigationBar) memberExchangeActivity.findViewById(R.id.navigation_bar);
        this.jAA.setOnClickListener(memberExchangeActivity);
        this.lpS = this.jAA.setCenterTextTitle(this.pageContext.getString(R.string.exchange_member));
        this.gCe = (NoNetworkView) memberExchangeActivity.findViewById(R.id.no_network_view);
        this.jAA.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.jAA.showBottomLine();
        this.lpT = (HeadImageView) memberExchangeActivity.findViewById(R.id.member_header_image);
        this.lpT.setIsRound(true);
        this.lpU = (TextView) memberExchangeActivity.findViewById(R.id.member_name);
        this.lpV = (TextView) memberExchangeActivity.findViewById(R.id.member_content);
        this.lpW = (TbImageView) memberExchangeActivity.findViewById(R.id.member_level);
        this.lpX = (EditText) memberExchangeActivity.findViewById(R.id.exchange_code);
        l.hideSoftKeyPad(this.pageContext.getPageActivity(), this.lpX);
        this.lpY = (TextView) memberExchangeActivity.findViewById(R.id.go_to_exchange);
        this.lpY.setOnClickListener(memberExchangeActivity);
        this.lpZ = (TextView) memberExchangeActivity.findViewById(R.id.rule_title);
        this.lpZ.setOnClickListener(null);
        this.lqa = (TextView) memberExchangeActivity.findViewById(R.id.rule_text_1);
        this.lqa.setClickable(false);
        this.lqb = (TextView) memberExchangeActivity.findViewById(R.id.rule_text_2);
        this.lqb.setClickable(false);
        this.lqc = (TextView) memberExchangeActivity.findViewById(R.id.rule_text_3);
        this.lqc.setClickable(false);
        onChangeSkinType(TbadkApplication.getInst().getSkinType());
    }

    public void l(String str, String str2, String str3, String str4, String str5) {
        this.lpT.startLoad(str, 12, false);
        this.lpU.setText(str2);
        if (!au.isEmpty(str3)) {
            this.lpW.setVisibility(0);
            this.lpW.startLoad(str3, 10, false);
        } else {
            this.lpW.setVisibility(8);
        }
        if (!au.isEmpty(str4)) {
            this.lpV.setText(this.pageContext.getString(R.string.vip_member_end_time_tips) + str4);
        } else {
            this.lpV.setText(str5);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.jAA.onChangeSkinType(this.pageContext, i);
            this.gCe.onChangeSkinType(this.pageContext, i);
            ap.setViewTextColor(this.lpU, R.color.CAM_X0105);
            ap.setViewTextColor(this.lpV, R.color.CAM_X0109);
            ap.setViewTextColor(this.lpX, R.color.CAM_X0109);
            this.lpX.setHintTextColor(ap.getColor(R.color.CAM_X0109));
            ap.setBackgroundResource(this.lpX, R.drawable.exchange_edit_text_bg);
            ap.setViewTextColor(this.lpY, R.color.CAM_X0111);
            ap.setBackgroundResource(this.lpY, R.drawable.btn_all_orange);
            ap.setViewTextColor(this.lpZ, R.color.CAM_X0105);
            ap.setViewTextColor(this.lqa, R.color.CAM_X0109);
            ap.setViewTextColor(this.lqb, R.color.CAM_X0109);
            ap.setViewTextColor(this.lqc, R.color.CAM_X0109);
        }
        this.mSkinType = i;
    }

    public EditText getEditText() {
        return this.lpX;
    }
}
