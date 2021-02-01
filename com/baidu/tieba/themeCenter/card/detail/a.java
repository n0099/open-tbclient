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
    private TextView ibW;
    private int jVM;
    private View.OnClickListener jds;
    private View mContentView;
    private NavigationBar mNavigationBar;
    private View mRoot;
    private TextView nIA;
    private TextView nIB;
    private TbImageView nIC;
    private UserIconBox nID;
    private View nIE;
    private View nIF;
    private int nIG;
    private int nIH;
    private int nII;
    private TextView nIl;
    private com.baidu.tieba.themeCenter.a nIn;
    private PersonalCardDetailActivity nIx;
    private TbImageView nIy;
    private TbImageView nIz;

    public a(PersonalCardDetailActivity personalCardDetailActivity, View.OnClickListener onClickListener) {
        this.nIG = 0;
        this.jVM = 0;
        this.nIH = 0;
        this.nII = 0;
        this.nIx = personalCardDetailActivity;
        this.mRoot = LayoutInflater.from(this.nIx.getPageContext().getPageActivity()).inflate(R.layout.personal_card_detail_layout, (ViewGroup) null);
        this.nIx.setContentView(this.mRoot);
        this.nIx.setNetRefreshViewTopMargin(BdListViewHelper.fMD);
        this.nIG = l.getDimens(this.nIx.getPageContext().getPageActivity(), R.dimen.ds4);
        this.jVM = l.getDimens(this.nIx.getPageContext().getPageActivity(), R.dimen.ds10);
        this.nIH = l.getDimens(this.nIx.getPageContext().getPageActivity(), R.dimen.ds16);
        this.nII = l.getDimens(this.nIx.getPageContext().getPageActivity(), R.dimen.ds30);
        this.jds = onClickListener;
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(R.string.personal_card_detail);
        this.fLP = (NoNetworkView) this.mRoot.findViewById(R.id.view_no_network);
        this.mContentView = this.mRoot.findViewById(R.id.content_view);
        this.nIF = this.mRoot.findViewById(R.id.top_divider_view);
        this.nIy = (TbImageView) this.mRoot.findViewById(R.id.card_image_view);
        this.nIy.setDefaultBgResource(R.drawable.transparent_bg);
        this.nIy.setDefaultResource(R.drawable.transparent_bg);
        this.ibW = (TextView) this.mRoot.findViewById(R.id.user_name_text_view);
        this.ffU = (HeadImageView) this.mRoot.findViewById(R.id.user_head_view);
        this.ffU.setIsRound(true);
        this.ffU.setDrawBorder(false);
        this.nID = (UserIconBox) this.mRoot.findViewById(R.id.card_user_icon_box);
        this.nIC = (TbImageView) this.mRoot.findViewById(R.id.user_vip_image_view);
        this.nIE = this.mRoot.findViewById(R.id.divider_view);
        this.nIl = (TextView) this.mRoot.findViewById(R.id.card_name_text_view);
        this.nIA = (TextView) this.mRoot.findViewById(R.id.card_description_text_view);
        this.nIB = (TextView) this.mRoot.findViewById(R.id.card_use_button);
        this.nIz = (TbImageView) this.mRoot.findViewById(R.id.card_vip_image_view);
        this.nIz.setDefaultResource(R.drawable.transparent_bg);
        this.nIz.setDefaultBgResource(R.drawable.transparent_bg);
        this.nIB.setOnClickListener(this.jds);
    }

    public void a(int i, com.baidu.tieba.themeCenter.a aVar) {
        if (aVar == null) {
            cAH();
        } else if (i == 0) {
            this.nIn = aVar;
            cAI();
            dRk();
            dbR();
            c(aVar);
        }
    }

    private void dRk() {
        int i;
        String str;
        String str2;
        String str3;
        int i2 = 4;
        if (this.nIn != null) {
            if (!TbadkCoreApplication.isLogin()) {
                this.nID.setVisibility(8);
                this.nIC.setVisibility(8);
                this.ibW.setPadding(this.nIH, 0, 0, 0);
                ap.setViewTextColor(this.ibW, R.color.CAM_X0308, 1);
                this.ibW.setText(R.string.default_user_name);
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
                    ap.setViewTextColor(this.ibW, R.color.CAM_X0308, 1);
                } else {
                    ap.setViewTextColor(this.ibW, R.color.CAM_X0108, 1);
                }
                if (StringUtils.isNull(str)) {
                    this.nIC.setVisibility(8);
                    this.ibW.setPadding(this.nIH, 0, 0, 0);
                    this.ibW.setText(str2);
                } else {
                    this.nIC.setVisibility(0);
                    this.nIC.startLoad(str, 10, false);
                    this.ibW.setPadding(this.nIG, 0, 0, 0);
                    this.ibW.setText(str2);
                }
                this.nID.setVisibility(0);
                int size = (currentAccountInfo == null || currentAccountInfo.getUserIcons() == null) ? 0 : currentAccountInfo.getUserIcons().size();
                if (size < 8 && size - 1 < 4) {
                    i2 = size - 1;
                }
                if (currentAccountInfo != null) {
                    this.nID.a(currentAccountInfo.getUserIcons(), i2, this.nII, this.nII, this.jVM, true);
                }
                this.ffU.startLoad(str3, 12, false);
            }
            this.nIy.startLoad(this.nIn.dQO(), 10, false);
        }
    }

    private void dbR() {
        if (this.nIn != null) {
            this.nIl.setText(this.nIn.getTitle());
            this.nIA.setText(this.nIn.getDescription());
            this.nIz.startLoad(this.nIn.dQP(), 10, false);
        }
    }

    public void c(com.baidu.tieba.themeCenter.a aVar) {
        if (aVar != null) {
            this.nIn = aVar;
            if (this.nIn == null) {
                this.nIB.setVisibility(8);
                return;
            }
            int freeUserLevel = this.nIn.getFreeUserLevel();
            this.nIB.setVisibility(0);
            if (this.nIn.dQR() == 1) {
                ap.setViewTextColor(this.nIB, R.color.CAM_X0105, 1);
                ap.setBackgroundResource(this.nIB, R.drawable.gray_btn_selector);
                this.nIB.setText(R.string.do_not_use);
            } else if (this.nIn.getDailyPrevilegeStatus() == 1) {
                ap.setViewTextColor(this.nIB, R.color.CAM_X0105, 1);
                ap.setBackgroundResource(this.nIB, R.drawable.gray_btn_selector);
                this.nIB.setText(R.string.use_immediately);
            } else if (freeUserLevel == 0) {
                ap.setViewTextColor(this.nIB, R.color.CAM_X0105, 1);
                ap.setBackgroundResource(this.nIB, R.drawable.gray_btn_selector);
                this.nIB.setText(R.string.use_freely);
            } else if (freeUserLevel == 100) {
                ap.setViewTextColor(this.nIB, R.color.CAM_X0101, 1);
                ap.setBackgroundResource(this.nIB, R.drawable.btn_all_blue);
                if (this.nIn.dQS() == 0) {
                    this.nIB.setText(R.string.activity_free_use);
                } else {
                    this.nIB.setText(R.string.use_immediately);
                }
            } else if (freeUserLevel == 101) {
                ap.setViewTextColor(this.nIB, R.color.CAM_X0101, 1);
                ap.setBackgroundResource(this.nIB, R.drawable.orange_btn_selector);
                this.nIB.setText(R.string.become_annual_free_use);
            } else if (freeUserLevel > 1) {
                ap.setViewTextColor(this.nIB, R.color.CAM_X0101, 1);
                ap.setBackgroundResource(this.nIB, R.drawable.orange_btn_selector);
                this.nIB.setText(String.format(this.nIx.getPageContext().getString(R.string.become_vip_free_use), Integer.valueOf(freeUserLevel)));
            } else {
                ap.setViewTextColor(this.nIB, R.color.CAM_X0101, 1);
                ap.setBackgroundResource(this.nIB, R.drawable.orange_btn_selector);
                this.nIB.setText(R.string.become_member_free_use);
            }
        }
    }

    public void cAH() {
        this.mContentView.setVisibility(8);
        this.nIy.setVisibility(8);
        this.nIE.setVisibility(8);
        this.nIF.setVisibility(8);
        this.nIl.setVisibility(8);
        this.nIA.setVisibility(8);
        this.nIz.setVisibility(8);
        this.nIB.setVisibility(8);
        this.nIx.showNetRefreshView(this.mRoot, this.nIx.getPageContext().getResources().getString(R.string.no_data_text), true);
    }

    public void cAI() {
        this.mContentView.setVisibility(0);
        this.nIF.setVisibility(0);
        this.nIy.setVisibility(0);
        this.nIE.setVisibility(0);
        this.nIl.setVisibility(0);
        this.nIA.setVisibility(0);
        this.nIz.setVisibility(0);
        this.nIB.setVisibility(0);
        this.nIx.hideNetRefreshView(this.mRoot);
    }

    public void bup() {
        this.nIx.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.nIx.getLayoutMode().onModeChanged(this.mRoot);
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.nIx.getPageContext(), TbadkApplication.getInst().getSkinType());
        }
        if (this.fLP != null) {
            this.fLP.onChangeSkinType(this.nIx.getPageContext(), TbadkApplication.getInst().getSkinType());
        }
    }

    public View getRootView() {
        return this.mRoot;
    }

    public View dRl() {
        return this.nIB;
    }
}
