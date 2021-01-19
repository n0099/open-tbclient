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
    private TextView nyB;
    private com.baidu.tieba.themeCenter.a nyD;
    private PersonalCardDetailActivity nyN;
    private TbImageView nyO;
    private TbImageView nyP;
    private TextView nyQ;
    private TextView nyR;
    private TbImageView nyS;
    private UserIconBox nyT;
    private View nyU;
    private View nyV;
    private int nyW;
    private int nyX;
    private int nyY;

    public a(PersonalCardDetailActivity personalCardDetailActivity, View.OnClickListener onClickListener) {
        this.nyW = 0;
        this.jOk = 0;
        this.nyX = 0;
        this.nyY = 0;
        this.nyN = personalCardDetailActivity;
        this.mRoot = LayoutInflater.from(this.nyN.getPageContext().getPageActivity()).inflate(R.layout.personal_card_detail_layout, (ViewGroup) null);
        this.nyN.setContentView(this.mRoot);
        this.nyN.setNetRefreshViewTopMargin(BdListViewHelper.fKs);
        this.nyW = l.getDimens(this.nyN.getPageContext().getPageActivity(), R.dimen.ds4);
        this.jOk = l.getDimens(this.nyN.getPageContext().getPageActivity(), R.dimen.ds10);
        this.nyX = l.getDimens(this.nyN.getPageContext().getPageActivity(), R.dimen.ds16);
        this.nyY = l.getDimens(this.nyN.getPageContext().getPageActivity(), R.dimen.ds30);
        this.iXL = onClickListener;
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(R.string.personal_card_detail);
        this.fJE = (NoNetworkView) this.mRoot.findViewById(R.id.view_no_network);
        this.mContentView = this.mRoot.findViewById(R.id.content_view);
        this.nyV = this.mRoot.findViewById(R.id.top_divider_view);
        this.nyO = (TbImageView) this.mRoot.findViewById(R.id.card_image_view);
        this.nyO.setDefaultBgResource(R.drawable.transparent_bg);
        this.nyO.setDefaultResource(R.drawable.transparent_bg);
        this.hXC = (TextView) this.mRoot.findViewById(R.id.user_name_text_view);
        this.fdF = (HeadImageView) this.mRoot.findViewById(R.id.user_head_view);
        this.fdF.setIsRound(true);
        this.fdF.setDrawBorder(false);
        this.nyT = (UserIconBox) this.mRoot.findViewById(R.id.card_user_icon_box);
        this.nyS = (TbImageView) this.mRoot.findViewById(R.id.user_vip_image_view);
        this.nyU = this.mRoot.findViewById(R.id.divider_view);
        this.nyB = (TextView) this.mRoot.findViewById(R.id.card_name_text_view);
        this.nyQ = (TextView) this.mRoot.findViewById(R.id.card_description_text_view);
        this.nyR = (TextView) this.mRoot.findViewById(R.id.card_use_button);
        this.nyP = (TbImageView) this.mRoot.findViewById(R.id.card_vip_image_view);
        this.nyP.setDefaultResource(R.drawable.transparent_bg);
        this.nyP.setDefaultBgResource(R.drawable.transparent_bg);
        this.nyR.setOnClickListener(this.iXL);
    }

    public void a(int i, com.baidu.tieba.themeCenter.a aVar) {
        if (aVar == null) {
            czw();
        } else if (i == 0) {
            this.nyD = aVar;
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
        if (this.nyD != null) {
            if (!TbadkCoreApplication.isLogin()) {
                this.nyT.setVisibility(8);
                this.nyS.setVisibility(8);
                this.hXC.setPadding(this.nyX, 0, 0, 0);
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
                    this.nyS.setVisibility(8);
                    this.hXC.setPadding(this.nyX, 0, 0, 0);
                    this.hXC.setText(str2);
                } else {
                    this.nyS.setVisibility(0);
                    this.nyS.startLoad(str, 10, false);
                    this.hXC.setPadding(this.nyW, 0, 0, 0);
                    this.hXC.setText(str2);
                }
                this.nyT.setVisibility(0);
                int size = (currentAccountInfo == null || currentAccountInfo.getUserIcons() == null) ? 0 : currentAccountInfo.getUserIcons().size();
                if (size < 8 && size - 1 < 4) {
                    i2 = size - 1;
                }
                if (currentAccountInfo != null) {
                    this.nyT.a(currentAccountInfo.getUserIcons(), i2, this.nyY, this.nyY, this.jOk, true);
                }
                this.fdF.startLoad(str3, 12, false);
            }
            this.nyO.startLoad(this.nyD.dOD(), 10, false);
        }
    }

    private void cZT() {
        if (this.nyD != null) {
            this.nyB.setText(this.nyD.getTitle());
            this.nyQ.setText(this.nyD.getDescription());
            this.nyP.startLoad(this.nyD.dOE(), 10, false);
        }
    }

    public void c(com.baidu.tieba.themeCenter.a aVar) {
        if (aVar != null) {
            this.nyD = aVar;
            if (this.nyD == null) {
                this.nyR.setVisibility(8);
                return;
            }
            int freeUserLevel = this.nyD.getFreeUserLevel();
            this.nyR.setVisibility(0);
            if (this.nyD.dOG() == 1) {
                ao.setViewTextColor(this.nyR, R.color.CAM_X0105, 1);
                ao.setBackgroundResource(this.nyR, R.drawable.gray_btn_selector);
                this.nyR.setText(R.string.do_not_use);
            } else if (this.nyD.getDailyPrevilegeStatus() == 1) {
                ao.setViewTextColor(this.nyR, R.color.CAM_X0105, 1);
                ao.setBackgroundResource(this.nyR, R.drawable.gray_btn_selector);
                this.nyR.setText(R.string.use_immediately);
            } else if (freeUserLevel == 0) {
                ao.setViewTextColor(this.nyR, R.color.CAM_X0105, 1);
                ao.setBackgroundResource(this.nyR, R.drawable.gray_btn_selector);
                this.nyR.setText(R.string.use_freely);
            } else if (freeUserLevel == 100) {
                ao.setViewTextColor(this.nyR, R.color.CAM_X0101, 1);
                ao.setBackgroundResource(this.nyR, R.drawable.btn_all_blue);
                if (this.nyD.dOH() == 0) {
                    this.nyR.setText(R.string.activity_free_use);
                } else {
                    this.nyR.setText(R.string.use_immediately);
                }
            } else if (freeUserLevel == 101) {
                ao.setViewTextColor(this.nyR, R.color.CAM_X0101, 1);
                ao.setBackgroundResource(this.nyR, R.drawable.orange_btn_selector);
                this.nyR.setText(R.string.become_annual_free_use);
            } else if (freeUserLevel > 1) {
                ao.setViewTextColor(this.nyR, R.color.CAM_X0101, 1);
                ao.setBackgroundResource(this.nyR, R.drawable.orange_btn_selector);
                this.nyR.setText(String.format(this.nyN.getPageContext().getString(R.string.become_vip_free_use), Integer.valueOf(freeUserLevel)));
            } else {
                ao.setViewTextColor(this.nyR, R.color.CAM_X0101, 1);
                ao.setBackgroundResource(this.nyR, R.drawable.orange_btn_selector);
                this.nyR.setText(R.string.become_member_free_use);
            }
        }
    }

    public void czw() {
        this.mContentView.setVisibility(8);
        this.nyO.setVisibility(8);
        this.nyU.setVisibility(8);
        this.nyV.setVisibility(8);
        this.nyB.setVisibility(8);
        this.nyQ.setVisibility(8);
        this.nyP.setVisibility(8);
        this.nyR.setVisibility(8);
        this.nyN.showNetRefreshView(this.mRoot, this.nyN.getPageContext().getResources().getString(R.string.no_data_text), true);
    }

    public void czx() {
        this.mContentView.setVisibility(0);
        this.nyV.setVisibility(0);
        this.nyO.setVisibility(0);
        this.nyU.setVisibility(0);
        this.nyB.setVisibility(0);
        this.nyQ.setVisibility(0);
        this.nyP.setVisibility(0);
        this.nyR.setVisibility(0);
        this.nyN.hideNetRefreshView(this.mRoot);
    }

    public void btV() {
        this.nyN.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.nyN.getLayoutMode().onModeChanged(this.mRoot);
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.nyN.getPageContext(), TbadkApplication.getInst().getSkinType());
        }
        if (this.fJE != null) {
            this.fJE.onChangeSkinType(this.nyN.getPageContext(), TbadkApplication.getInst().getSkinType());
        }
    }

    public View getRootView() {
        return this.mRoot;
    }

    public View dPa() {
        return this.nyR;
    }
}
