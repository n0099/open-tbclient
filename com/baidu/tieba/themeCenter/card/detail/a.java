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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class a {
    private NoNetworkView fLP;
    private HeadImageView ffU;
    private TextView ick;
    private int jWa;
    private View.OnClickListener jdG;
    private View mContentView;
    private NavigationBar mNavigationBar;
    private View mRoot;
    private TextView nIL;
    private com.baidu.tieba.themeCenter.a nIN;
    private PersonalCardDetailActivity nIX;
    private TbImageView nIY;
    private TbImageView nIZ;
    private TextView nJa;
    private TextView nJb;
    private TbImageView nJc;
    private UserIconBox nJd;
    private View nJe;
    private View nJf;
    private int nJg;
    private int nJh;
    private int nJi;

    public a(PersonalCardDetailActivity personalCardDetailActivity, View.OnClickListener onClickListener) {
        this.nJg = 0;
        this.jWa = 0;
        this.nJh = 0;
        this.nJi = 0;
        this.nIX = personalCardDetailActivity;
        this.mRoot = LayoutInflater.from(this.nIX.getPageContext().getPageActivity()).inflate(R.layout.personal_card_detail_layout, (ViewGroup) null);
        this.nIX.setContentView(this.mRoot);
        this.nIX.setNetRefreshViewTopMargin(BdListViewHelper.fMD);
        this.nJg = l.getDimens(this.nIX.getPageContext().getPageActivity(), R.dimen.ds4);
        this.jWa = l.getDimens(this.nIX.getPageContext().getPageActivity(), R.dimen.ds10);
        this.nJh = l.getDimens(this.nIX.getPageContext().getPageActivity(), R.dimen.ds16);
        this.nJi = l.getDimens(this.nIX.getPageContext().getPageActivity(), R.dimen.ds30);
        this.jdG = onClickListener;
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(R.string.personal_card_detail);
        this.fLP = (NoNetworkView) this.mRoot.findViewById(R.id.view_no_network);
        this.mContentView = this.mRoot.findViewById(R.id.content_view);
        this.nJf = this.mRoot.findViewById(R.id.top_divider_view);
        this.nIY = (TbImageView) this.mRoot.findViewById(R.id.card_image_view);
        this.nIY.setDefaultBgResource(R.drawable.transparent_bg);
        this.nIY.setDefaultResource(R.drawable.transparent_bg);
        this.ick = (TextView) this.mRoot.findViewById(R.id.user_name_text_view);
        this.ffU = (HeadImageView) this.mRoot.findViewById(R.id.user_head_view);
        this.ffU.setIsRound(true);
        this.ffU.setDrawBorder(false);
        this.nJd = (UserIconBox) this.mRoot.findViewById(R.id.card_user_icon_box);
        this.nJc = (TbImageView) this.mRoot.findViewById(R.id.user_vip_image_view);
        this.nJe = this.mRoot.findViewById(R.id.divider_view);
        this.nIL = (TextView) this.mRoot.findViewById(R.id.card_name_text_view);
        this.nJa = (TextView) this.mRoot.findViewById(R.id.card_description_text_view);
        this.nJb = (TextView) this.mRoot.findViewById(R.id.card_use_button);
        this.nIZ = (TbImageView) this.mRoot.findViewById(R.id.card_vip_image_view);
        this.nIZ.setDefaultResource(R.drawable.transparent_bg);
        this.nIZ.setDefaultBgResource(R.drawable.transparent_bg);
        this.nJb.setOnClickListener(this.jdG);
    }

    public void a(int i, com.baidu.tieba.themeCenter.a aVar) {
        if (aVar == null) {
            cAO();
        } else if (i == 0) {
            this.nIN = aVar;
            cAP();
            dRs();
            dbY();
            c(aVar);
        }
    }

    private void dRs() {
        int i;
        String str;
        String str2;
        String str3;
        int i2 = 4;
        if (this.nIN != null) {
            if (!TbadkCoreApplication.isLogin()) {
                this.nJd.setVisibility(8);
                this.nJc.setVisibility(8);
                this.ick.setPadding(this.nJh, 0, 0, 0);
                ap.setViewTextColor(this.ick, R.color.CAM_X0308, 1);
                this.ick.setText(R.string.default_user_name);
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
                    ap.setViewTextColor(this.ick, R.color.CAM_X0308, 1);
                } else {
                    ap.setViewTextColor(this.ick, R.color.CAM_X0108, 1);
                }
                if (StringUtils.isNull(str)) {
                    this.nJc.setVisibility(8);
                    this.ick.setPadding(this.nJh, 0, 0, 0);
                    this.ick.setText(str2);
                } else {
                    this.nJc.setVisibility(0);
                    this.nJc.startLoad(str, 10, false);
                    this.ick.setPadding(this.nJg, 0, 0, 0);
                    this.ick.setText(str2);
                }
                this.nJd.setVisibility(0);
                int size = (currentAccountInfo == null || currentAccountInfo.getUserIcons() == null) ? 0 : currentAccountInfo.getUserIcons().size();
                if (size < 8 && size - 1 < 4) {
                    i2 = size - 1;
                }
                if (currentAccountInfo != null) {
                    this.nJd.a(currentAccountInfo.getUserIcons(), i2, this.nJi, this.nJi, this.jWa, true);
                }
                this.ffU.startLoad(str3, 12, false);
            }
            this.nIY.startLoad(this.nIN.dQW(), 10, false);
        }
    }

    private void dbY() {
        if (this.nIN != null) {
            this.nIL.setText(this.nIN.getTitle());
            this.nJa.setText(this.nIN.getDescription());
            this.nIZ.startLoad(this.nIN.dQX(), 10, false);
        }
    }

    public void c(com.baidu.tieba.themeCenter.a aVar) {
        if (aVar != null) {
            this.nIN = aVar;
            if (this.nIN == null) {
                this.nJb.setVisibility(8);
                return;
            }
            int freeUserLevel = this.nIN.getFreeUserLevel();
            this.nJb.setVisibility(0);
            if (this.nIN.dQZ() == 1) {
                ap.setViewTextColor(this.nJb, R.color.CAM_X0105, 1);
                ap.setBackgroundResource(this.nJb, R.drawable.gray_btn_selector);
                this.nJb.setText(R.string.do_not_use);
            } else if (this.nIN.getDailyPrevilegeStatus() == 1) {
                ap.setViewTextColor(this.nJb, R.color.CAM_X0105, 1);
                ap.setBackgroundResource(this.nJb, R.drawable.gray_btn_selector);
                this.nJb.setText(R.string.use_immediately);
            } else if (freeUserLevel == 0) {
                ap.setViewTextColor(this.nJb, R.color.CAM_X0105, 1);
                ap.setBackgroundResource(this.nJb, R.drawable.gray_btn_selector);
                this.nJb.setText(R.string.use_freely);
            } else if (freeUserLevel == 100) {
                ap.setViewTextColor(this.nJb, R.color.CAM_X0101, 1);
                ap.setBackgroundResource(this.nJb, R.drawable.btn_all_blue);
                if (this.nIN.dRa() == 0) {
                    this.nJb.setText(R.string.activity_free_use);
                } else {
                    this.nJb.setText(R.string.use_immediately);
                }
            } else if (freeUserLevel == 101) {
                ap.setViewTextColor(this.nJb, R.color.CAM_X0101, 1);
                ap.setBackgroundResource(this.nJb, R.drawable.orange_btn_selector);
                this.nJb.setText(R.string.become_annual_free_use);
            } else if (freeUserLevel > 1) {
                ap.setViewTextColor(this.nJb, R.color.CAM_X0101, 1);
                ap.setBackgroundResource(this.nJb, R.drawable.orange_btn_selector);
                this.nJb.setText(String.format(this.nIX.getPageContext().getString(R.string.become_vip_free_use), Integer.valueOf(freeUserLevel)));
            } else {
                ap.setViewTextColor(this.nJb, R.color.CAM_X0101, 1);
                ap.setBackgroundResource(this.nJb, R.drawable.orange_btn_selector);
                this.nJb.setText(R.string.become_member_free_use);
            }
        }
    }

    public void cAO() {
        this.mContentView.setVisibility(8);
        this.nIY.setVisibility(8);
        this.nJe.setVisibility(8);
        this.nJf.setVisibility(8);
        this.nIL.setVisibility(8);
        this.nJa.setVisibility(8);
        this.nIZ.setVisibility(8);
        this.nJb.setVisibility(8);
        this.nIX.showNetRefreshView(this.mRoot, this.nIX.getPageContext().getResources().getString(R.string.no_data_text), true);
    }

    public void cAP() {
        this.mContentView.setVisibility(0);
        this.nJf.setVisibility(0);
        this.nIY.setVisibility(0);
        this.nJe.setVisibility(0);
        this.nIL.setVisibility(0);
        this.nJa.setVisibility(0);
        this.nIZ.setVisibility(0);
        this.nJb.setVisibility(0);
        this.nIX.hideNetRefreshView(this.mRoot);
    }

    public void bup() {
        this.nIX.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.nIX.getLayoutMode().onModeChanged(this.mRoot);
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.nIX.getPageContext(), TbadkApplication.getInst().getSkinType());
        }
        if (this.fLP != null) {
            this.fLP.onChangeSkinType(this.nIX.getPageContext(), TbadkApplication.getInst().getSkinType());
        }
    }

    public View getRootView() {
        return this.mRoot;
    }

    public View dRt() {
        return this.nJb;
    }
}
