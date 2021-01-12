package com.baidu.tieba.themeCenter.card.detail;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class a {
    private NoNetworkView fJE;
    private HeadImageView fdF;
    private TextView hXC;
    private View.OnClickListener iXL;
    private int jOk;
    private View mContentView;
    private NavigationBar mNavigationBar;
    private View mRoot;
    private TextView nyA;
    private com.baidu.tieba.themeCenter.a nyC;
    private PersonalCardDetailActivity nyM;
    private TbImageView nyN;
    private TbImageView nyO;
    private TextView nyP;
    private TextView nyQ;
    private TbImageView nyR;
    private UserIconBox nyS;
    private View nyT;
    private View nyU;
    private int nyV;
    private int nyW;
    private int nyX;

    public a(PersonalCardDetailActivity personalCardDetailActivity, View.OnClickListener onClickListener) {
        this.nyV = 0;
        this.jOk = 0;
        this.nyW = 0;
        this.nyX = 0;
        this.nyM = personalCardDetailActivity;
        this.mRoot = LayoutInflater.from(this.nyM.getPageContext().getPageActivity()).inflate(R.layout.personal_card_detail_layout, (ViewGroup) null);
        this.nyM.setContentView(this.mRoot);
        this.nyM.setNetRefreshViewTopMargin(BdListViewHelper.fKs);
        this.nyV = l.getDimens(this.nyM.getPageContext().getPageActivity(), R.dimen.ds4);
        this.jOk = l.getDimens(this.nyM.getPageContext().getPageActivity(), R.dimen.ds10);
        this.nyW = l.getDimens(this.nyM.getPageContext().getPageActivity(), R.dimen.ds16);
        this.nyX = l.getDimens(this.nyM.getPageContext().getPageActivity(), R.dimen.ds30);
        this.iXL = onClickListener;
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(R.string.personal_card_detail);
        this.fJE = (NoNetworkView) this.mRoot.findViewById(R.id.view_no_network);
        this.mContentView = this.mRoot.findViewById(R.id.content_view);
        this.nyU = this.mRoot.findViewById(R.id.top_divider_view);
        this.nyN = (TbImageView) this.mRoot.findViewById(R.id.card_image_view);
        this.nyN.setDefaultBgResource(R.drawable.transparent_bg);
        this.nyN.setDefaultResource(R.drawable.transparent_bg);
        this.hXC = (TextView) this.mRoot.findViewById(R.id.user_name_text_view);
        this.fdF = (HeadImageView) this.mRoot.findViewById(R.id.user_head_view);
        this.fdF.setIsRound(true);
        this.fdF.setDrawBorder(false);
        this.nyS = (UserIconBox) this.mRoot.findViewById(R.id.card_user_icon_box);
        this.nyR = (TbImageView) this.mRoot.findViewById(R.id.user_vip_image_view);
        this.nyT = this.mRoot.findViewById(R.id.divider_view);
        this.nyA = (TextView) this.mRoot.findViewById(R.id.card_name_text_view);
        this.nyP = (TextView) this.mRoot.findViewById(R.id.card_description_text_view);
        this.nyQ = (TextView) this.mRoot.findViewById(R.id.card_use_button);
        this.nyO = (TbImageView) this.mRoot.findViewById(R.id.card_vip_image_view);
        this.nyO.setDefaultResource(R.drawable.transparent_bg);
        this.nyO.setDefaultBgResource(R.drawable.transparent_bg);
        this.nyQ.setOnClickListener(this.iXL);
    }

    public void a(int i, com.baidu.tieba.themeCenter.a aVar) {
        if (aVar == null) {
            czw();
        } else if (i == 0) {
            this.nyC = aVar;
            czx();
            dOZ();
            cZT();
            c(aVar);
        }
    }

    private void dOZ() {
        int i;
        String str;
        String str2;
        String str3;
        int i2 = 4;
        if (this.nyC != null) {
            if (!TbadkCoreApplication.isLogin()) {
                this.nyS.setVisibility(8);
                this.nyR.setVisibility(8);
                this.hXC.setPadding(this.nyW, 0, 0, 0);
                ao.setViewTextColor(this.hXC, R.color.CAM_X0308, 1);
                this.hXC.setText(R.string.default_user_name);
            } else {
                AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
                if (currentAccountInfo != null) {
                    String portrait = currentAccountInfo.getPortrait();
                    String accountNameShow = currentAccountInfo.getAccountNameShow();
                    str = currentAccountInfo.getMemberIconUrl();
                    i = currentAccountInfo.getMemberType();
                    str2 = accountNameShow;
                    str3 = portrait;
                } else {
                    i = 0;
                    str = null;
                    str2 = null;
                    str3 = null;
                }
                if (i > 0) {
                    ao.setViewTextColor(this.hXC, R.color.CAM_X0308, 1);
                } else {
                    ao.setViewTextColor(this.hXC, R.color.CAM_X0108, 1);
                }
                if (StringUtils.isNull(str)) {
                    this.nyR.setVisibility(8);
                    this.hXC.setPadding(this.nyW, 0, 0, 0);
                    this.hXC.setText(str2);
                } else {
                    this.nyR.setVisibility(0);
                    this.nyR.startLoad(str, 10, false);
                    this.hXC.setPadding(this.nyV, 0, 0, 0);
                    this.hXC.setText(str2);
                }
                this.nyS.setVisibility(0);
                int size = (currentAccountInfo == null || currentAccountInfo.getUserIcons() == null) ? 0 : currentAccountInfo.getUserIcons().size();
                if (size < 8 && size - 1 < 4) {
                    i2 = size - 1;
                }
                if (currentAccountInfo != null) {
                    this.nyS.a(currentAccountInfo.getUserIcons(), i2, this.nyX, this.nyX, this.jOk, true);
                }
                this.fdF.startLoad(str3, 12, false);
            }
            this.nyN.startLoad(this.nyC.dOD(), 10, false);
        }
    }

    private void cZT() {
        if (this.nyC != null) {
            this.nyA.setText(this.nyC.getTitle());
            this.nyP.setText(this.nyC.getDescription());
            this.nyO.startLoad(this.nyC.dOE(), 10, false);
        }
    }

    public void c(com.baidu.tieba.themeCenter.a aVar) {
        if (aVar != null) {
            this.nyC = aVar;
            if (this.nyC == null) {
                this.nyQ.setVisibility(8);
                return;
            }
            int freeUserLevel = this.nyC.getFreeUserLevel();
            this.nyQ.setVisibility(0);
            if (this.nyC.dOG() == 1) {
                ao.setViewTextColor(this.nyQ, R.color.CAM_X0105, 1);
                ao.setBackgroundResource(this.nyQ, R.drawable.gray_btn_selector);
                this.nyQ.setText(R.string.do_not_use);
            } else if (this.nyC.getDailyPrevilegeStatus() == 1) {
                ao.setViewTextColor(this.nyQ, R.color.CAM_X0105, 1);
                ao.setBackgroundResource(this.nyQ, R.drawable.gray_btn_selector);
                this.nyQ.setText(R.string.use_immediately);
            } else if (freeUserLevel == 0) {
                ao.setViewTextColor(this.nyQ, R.color.CAM_X0105, 1);
                ao.setBackgroundResource(this.nyQ, R.drawable.gray_btn_selector);
                this.nyQ.setText(R.string.use_freely);
            } else if (freeUserLevel == 100) {
                ao.setViewTextColor(this.nyQ, R.color.CAM_X0101, 1);
                ao.setBackgroundResource(this.nyQ, R.drawable.btn_all_blue);
                if (this.nyC.dOH() == 0) {
                    this.nyQ.setText(R.string.activity_free_use);
                } else {
                    this.nyQ.setText(R.string.use_immediately);
                }
            } else if (freeUserLevel == 101) {
                ao.setViewTextColor(this.nyQ, R.color.CAM_X0101, 1);
                ao.setBackgroundResource(this.nyQ, R.drawable.orange_btn_selector);
                this.nyQ.setText(R.string.become_annual_free_use);
            } else if (freeUserLevel > 1) {
                ao.setViewTextColor(this.nyQ, R.color.CAM_X0101, 1);
                ao.setBackgroundResource(this.nyQ, R.drawable.orange_btn_selector);
                this.nyQ.setText(String.format(this.nyM.getPageContext().getString(R.string.become_vip_free_use), Integer.valueOf(freeUserLevel)));
            } else {
                ao.setViewTextColor(this.nyQ, R.color.CAM_X0101, 1);
                ao.setBackgroundResource(this.nyQ, R.drawable.orange_btn_selector);
                this.nyQ.setText(R.string.become_member_free_use);
            }
        }
    }

    public void czw() {
        this.mContentView.setVisibility(8);
        this.nyN.setVisibility(8);
        this.nyT.setVisibility(8);
        this.nyU.setVisibility(8);
        this.nyA.setVisibility(8);
        this.nyP.setVisibility(8);
        this.nyO.setVisibility(8);
        this.nyQ.setVisibility(8);
        this.nyM.showNetRefreshView(this.mRoot, this.nyM.getPageContext().getResources().getString(R.string.no_data_text), true);
    }

    public void czx() {
        this.mContentView.setVisibility(0);
        this.nyU.setVisibility(0);
        this.nyN.setVisibility(0);
        this.nyT.setVisibility(0);
        this.nyA.setVisibility(0);
        this.nyP.setVisibility(0);
        this.nyO.setVisibility(0);
        this.nyQ.setVisibility(0);
        this.nyM.hideNetRefreshView(this.mRoot);
    }

    public void btV() {
        this.nyM.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.nyM.getLayoutMode().onModeChanged(this.mRoot);
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.nyM.getPageContext(), TbadkApplication.getInst().getSkinType());
        }
        if (this.fJE != null) {
            this.fJE.onChangeSkinType(this.nyM.getPageContext(), TbadkApplication.getInst().getSkinType());
        }
    }

    public View getRootView() {
        return this.mRoot;
    }

    public View dPa() {
        return this.nyQ;
    }
}
