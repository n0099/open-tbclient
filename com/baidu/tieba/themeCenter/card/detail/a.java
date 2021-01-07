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
/* loaded from: classes9.dex */
public class a {
    private NoNetworkView fOl;
    private HeadImageView fio;
    private TextView icj;
    private int jSP;
    private View.OnClickListener jcs;
    private View mContentView;
    private NavigationBar mNavigationBar;
    private View mRoot;
    private int nDA;
    private int nDB;
    private int nDC;
    private TextView nDf;
    private com.baidu.tieba.themeCenter.a nDh;
    private PersonalCardDetailActivity nDr;
    private TbImageView nDs;
    private TbImageView nDt;
    private TextView nDu;
    private TextView nDv;
    private TbImageView nDw;
    private UserIconBox nDx;
    private View nDy;
    private View nDz;

    public a(PersonalCardDetailActivity personalCardDetailActivity, View.OnClickListener onClickListener) {
        this.nDA = 0;
        this.jSP = 0;
        this.nDB = 0;
        this.nDC = 0;
        this.nDr = personalCardDetailActivity;
        this.mRoot = LayoutInflater.from(this.nDr.getPageContext().getPageActivity()).inflate(R.layout.personal_card_detail_layout, (ViewGroup) null);
        this.nDr.setContentView(this.mRoot);
        this.nDr.setNetRefreshViewTopMargin(BdListViewHelper.fOZ);
        this.nDA = l.getDimens(this.nDr.getPageContext().getPageActivity(), R.dimen.ds4);
        this.jSP = l.getDimens(this.nDr.getPageContext().getPageActivity(), R.dimen.ds10);
        this.nDB = l.getDimens(this.nDr.getPageContext().getPageActivity(), R.dimen.ds16);
        this.nDC = l.getDimens(this.nDr.getPageContext().getPageActivity(), R.dimen.ds30);
        this.jcs = onClickListener;
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(R.string.personal_card_detail);
        this.fOl = (NoNetworkView) this.mRoot.findViewById(R.id.view_no_network);
        this.mContentView = this.mRoot.findViewById(R.id.content_view);
        this.nDz = this.mRoot.findViewById(R.id.top_divider_view);
        this.nDs = (TbImageView) this.mRoot.findViewById(R.id.card_image_view);
        this.nDs.setDefaultBgResource(R.drawable.transparent_bg);
        this.nDs.setDefaultResource(R.drawable.transparent_bg);
        this.icj = (TextView) this.mRoot.findViewById(R.id.user_name_text_view);
        this.fio = (HeadImageView) this.mRoot.findViewById(R.id.user_head_view);
        this.fio.setIsRound(true);
        this.fio.setDrawBorder(false);
        this.nDx = (UserIconBox) this.mRoot.findViewById(R.id.card_user_icon_box);
        this.nDw = (TbImageView) this.mRoot.findViewById(R.id.user_vip_image_view);
        this.nDy = this.mRoot.findViewById(R.id.divider_view);
        this.nDf = (TextView) this.mRoot.findViewById(R.id.card_name_text_view);
        this.nDu = (TextView) this.mRoot.findViewById(R.id.card_description_text_view);
        this.nDv = (TextView) this.mRoot.findViewById(R.id.card_use_button);
        this.nDt = (TbImageView) this.mRoot.findViewById(R.id.card_vip_image_view);
        this.nDt.setDefaultResource(R.drawable.transparent_bg);
        this.nDt.setDefaultBgResource(R.drawable.transparent_bg);
        this.nDv.setOnClickListener(this.jcs);
    }

    public void a(int i, com.baidu.tieba.themeCenter.a aVar) {
        if (aVar == null) {
            cDo();
        } else if (i == 0) {
            this.nDh = aVar;
            cDp();
            dSR();
            ddL();
            c(aVar);
        }
    }

    private void dSR() {
        int i;
        String str;
        String str2;
        String str3;
        int i2 = 4;
        if (this.nDh != null) {
            if (!TbadkCoreApplication.isLogin()) {
                this.nDx.setVisibility(8);
                this.nDw.setVisibility(8);
                this.icj.setPadding(this.nDB, 0, 0, 0);
                ao.setViewTextColor(this.icj, R.color.CAM_X0308, 1);
                this.icj.setText(R.string.default_user_name);
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
                    ao.setViewTextColor(this.icj, R.color.CAM_X0308, 1);
                } else {
                    ao.setViewTextColor(this.icj, R.color.CAM_X0108, 1);
                }
                if (StringUtils.isNull(str)) {
                    this.nDw.setVisibility(8);
                    this.icj.setPadding(this.nDB, 0, 0, 0);
                    this.icj.setText(str2);
                } else {
                    this.nDw.setVisibility(0);
                    this.nDw.startLoad(str, 10, false);
                    this.icj.setPadding(this.nDA, 0, 0, 0);
                    this.icj.setText(str2);
                }
                this.nDx.setVisibility(0);
                int size = (currentAccountInfo == null || currentAccountInfo.getUserIcons() == null) ? 0 : currentAccountInfo.getUserIcons().size();
                if (size < 8 && size - 1 < 4) {
                    i2 = size - 1;
                }
                if (currentAccountInfo != null) {
                    this.nDx.a(currentAccountInfo.getUserIcons(), i2, this.nDC, this.nDC, this.jSP, true);
                }
                this.fio.startLoad(str3, 12, false);
            }
            this.nDs.startLoad(this.nDh.dSv(), 10, false);
        }
    }

    private void ddL() {
        if (this.nDh != null) {
            this.nDf.setText(this.nDh.getTitle());
            this.nDu.setText(this.nDh.getDescription());
            this.nDt.startLoad(this.nDh.dSw(), 10, false);
        }
    }

    public void c(com.baidu.tieba.themeCenter.a aVar) {
        if (aVar != null) {
            this.nDh = aVar;
            if (this.nDh == null) {
                this.nDv.setVisibility(8);
                return;
            }
            int freeUserLevel = this.nDh.getFreeUserLevel();
            this.nDv.setVisibility(0);
            if (this.nDh.dSy() == 1) {
                ao.setViewTextColor(this.nDv, R.color.CAM_X0105, 1);
                ao.setBackgroundResource(this.nDv, R.drawable.gray_btn_selector);
                this.nDv.setText(R.string.do_not_use);
            } else if (this.nDh.getDailyPrevilegeStatus() == 1) {
                ao.setViewTextColor(this.nDv, R.color.CAM_X0105, 1);
                ao.setBackgroundResource(this.nDv, R.drawable.gray_btn_selector);
                this.nDv.setText(R.string.use_immediately);
            } else if (freeUserLevel == 0) {
                ao.setViewTextColor(this.nDv, R.color.CAM_X0105, 1);
                ao.setBackgroundResource(this.nDv, R.drawable.gray_btn_selector);
                this.nDv.setText(R.string.use_freely);
            } else if (freeUserLevel == 100) {
                ao.setViewTextColor(this.nDv, R.color.CAM_X0101, 1);
                ao.setBackgroundResource(this.nDv, R.drawable.btn_all_blue);
                if (this.nDh.dSz() == 0) {
                    this.nDv.setText(R.string.activity_free_use);
                } else {
                    this.nDv.setText(R.string.use_immediately);
                }
            } else if (freeUserLevel == 101) {
                ao.setViewTextColor(this.nDv, R.color.CAM_X0101, 1);
                ao.setBackgroundResource(this.nDv, R.drawable.orange_btn_selector);
                this.nDv.setText(R.string.become_annual_free_use);
            } else if (freeUserLevel > 1) {
                ao.setViewTextColor(this.nDv, R.color.CAM_X0101, 1);
                ao.setBackgroundResource(this.nDv, R.drawable.orange_btn_selector);
                this.nDv.setText(String.format(this.nDr.getPageContext().getString(R.string.become_vip_free_use), Integer.valueOf(freeUserLevel)));
            } else {
                ao.setViewTextColor(this.nDv, R.color.CAM_X0101, 1);
                ao.setBackgroundResource(this.nDv, R.drawable.orange_btn_selector);
                this.nDv.setText(R.string.become_member_free_use);
            }
        }
    }

    public void cDo() {
        this.mContentView.setVisibility(8);
        this.nDs.setVisibility(8);
        this.nDy.setVisibility(8);
        this.nDz.setVisibility(8);
        this.nDf.setVisibility(8);
        this.nDu.setVisibility(8);
        this.nDt.setVisibility(8);
        this.nDv.setVisibility(8);
        this.nDr.showNetRefreshView(this.mRoot, this.nDr.getPageContext().getResources().getString(R.string.no_data_text), true);
    }

    public void cDp() {
        this.mContentView.setVisibility(0);
        this.nDz.setVisibility(0);
        this.nDs.setVisibility(0);
        this.nDy.setVisibility(0);
        this.nDf.setVisibility(0);
        this.nDu.setVisibility(0);
        this.nDt.setVisibility(0);
        this.nDv.setVisibility(0);
        this.nDr.hideNetRefreshView(this.mRoot);
    }

    public void bxP() {
        this.nDr.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.nDr.getLayoutMode().onModeChanged(this.mRoot);
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.nDr.getPageContext(), TbadkApplication.getInst().getSkinType());
        }
        if (this.fOl != null) {
            this.fOl.onChangeSkinType(this.nDr.getPageContext(), TbadkApplication.getInst().getSkinType());
        }
    }

    public View getRootView() {
        return this.mRoot;
    }

    public View dSS() {
        return this.nDv;
    }
}
