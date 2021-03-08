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
/* loaded from: classes8.dex */
public class a {
    private NoNetworkView fNp;
    private HeadImageView fht;
    private TextView idX;
    private int jYc;
    private View.OnClickListener jfp;
    private View mContentView;
    private NavigationBar mNavigationBar;
    private View mRoot;
    private TextView nKR;
    private com.baidu.tieba.themeCenter.a nKT;
    private PersonalCardDetailActivity nLd;
    private TbImageView nLe;
    private TbImageView nLf;
    private TextView nLg;
    private TextView nLh;
    private TbImageView nLi;
    private UserIconBox nLj;
    private View nLk;
    private View nLl;
    private int nLm;
    private int nLn;
    private int nLo;

    public a(PersonalCardDetailActivity personalCardDetailActivity, View.OnClickListener onClickListener) {
        this.nLm = 0;
        this.jYc = 0;
        this.nLn = 0;
        this.nLo = 0;
        this.nLd = personalCardDetailActivity;
        this.mRoot = LayoutInflater.from(this.nLd.getPageContext().getPageActivity()).inflate(R.layout.personal_card_detail_layout, (ViewGroup) null);
        this.nLd.setContentView(this.mRoot);
        this.nLd.setNetRefreshViewTopMargin(BdListViewHelper.fOd);
        this.nLm = l.getDimens(this.nLd.getPageContext().getPageActivity(), R.dimen.ds4);
        this.jYc = l.getDimens(this.nLd.getPageContext().getPageActivity(), R.dimen.ds10);
        this.nLn = l.getDimens(this.nLd.getPageContext().getPageActivity(), R.dimen.ds16);
        this.nLo = l.getDimens(this.nLd.getPageContext().getPageActivity(), R.dimen.ds30);
        this.jfp = onClickListener;
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(R.string.personal_card_detail);
        this.fNp = (NoNetworkView) this.mRoot.findViewById(R.id.view_no_network);
        this.mContentView = this.mRoot.findViewById(R.id.content_view);
        this.nLl = this.mRoot.findViewById(R.id.top_divider_view);
        this.nLe = (TbImageView) this.mRoot.findViewById(R.id.card_image_view);
        this.nLe.setDefaultBgResource(R.drawable.transparent_bg);
        this.nLe.setDefaultResource(R.drawable.transparent_bg);
        this.idX = (TextView) this.mRoot.findViewById(R.id.user_name_text_view);
        this.fht = (HeadImageView) this.mRoot.findViewById(R.id.user_head_view);
        this.fht.setIsRound(true);
        this.fht.setDrawBorder(false);
        this.nLj = (UserIconBox) this.mRoot.findViewById(R.id.card_user_icon_box);
        this.nLi = (TbImageView) this.mRoot.findViewById(R.id.user_vip_image_view);
        this.nLk = this.mRoot.findViewById(R.id.divider_view);
        this.nKR = (TextView) this.mRoot.findViewById(R.id.card_name_text_view);
        this.nLg = (TextView) this.mRoot.findViewById(R.id.card_description_text_view);
        this.nLh = (TextView) this.mRoot.findViewById(R.id.card_use_button);
        this.nLf = (TbImageView) this.mRoot.findViewById(R.id.card_vip_image_view);
        this.nLf.setDefaultResource(R.drawable.transparent_bg);
        this.nLf.setDefaultBgResource(R.drawable.transparent_bg);
        this.nLh.setOnClickListener(this.jfp);
    }

    public void a(int i, com.baidu.tieba.themeCenter.a aVar) {
        if (aVar == null) {
            cAU();
        } else if (i == 0) {
            this.nKT = aVar;
            cAV();
            dRB();
            dch();
            c(aVar);
        }
    }

    private void dRB() {
        int i;
        String str;
        String str2;
        String str3;
        int i2 = 4;
        if (this.nKT != null) {
            if (!TbadkCoreApplication.isLogin()) {
                this.nLj.setVisibility(8);
                this.nLi.setVisibility(8);
                this.idX.setPadding(this.nLn, 0, 0, 0);
                ap.setViewTextColor(this.idX, R.color.CAM_X0308, 1);
                this.idX.setText(R.string.default_user_name);
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
                    ap.setViewTextColor(this.idX, R.color.CAM_X0308, 1);
                } else {
                    ap.setViewTextColor(this.idX, R.color.CAM_X0108, 1);
                }
                if (StringUtils.isNull(str)) {
                    this.nLi.setVisibility(8);
                    this.idX.setPadding(this.nLn, 0, 0, 0);
                    this.idX.setText(str2);
                } else {
                    this.nLi.setVisibility(0);
                    this.nLi.startLoad(str, 10, false);
                    this.idX.setPadding(this.nLm, 0, 0, 0);
                    this.idX.setText(str2);
                }
                this.nLj.setVisibility(0);
                int size = (currentAccountInfo == null || currentAccountInfo.getUserIcons() == null) ? 0 : currentAccountInfo.getUserIcons().size();
                if (size < 8 && size - 1 < 4) {
                    i2 = size - 1;
                }
                if (currentAccountInfo != null) {
                    this.nLj.a(currentAccountInfo.getUserIcons(), i2, this.nLo, this.nLo, this.jYc, true);
                }
                this.fht.startLoad(str3, 12, false);
            }
            this.nLe.startLoad(this.nKT.dRf(), 10, false);
        }
    }

    private void dch() {
        if (this.nKT != null) {
            this.nKR.setText(this.nKT.getTitle());
            this.nLg.setText(this.nKT.getDescription());
            this.nLf.startLoad(this.nKT.dRg(), 10, false);
        }
    }

    public void c(com.baidu.tieba.themeCenter.a aVar) {
        if (aVar != null) {
            this.nKT = aVar;
            if (this.nKT == null) {
                this.nLh.setVisibility(8);
                return;
            }
            int freeUserLevel = this.nKT.getFreeUserLevel();
            this.nLh.setVisibility(0);
            if (this.nKT.dRi() == 1) {
                ap.setViewTextColor(this.nLh, R.color.CAM_X0105, 1);
                ap.setBackgroundResource(this.nLh, R.drawable.gray_btn_selector);
                this.nLh.setText(R.string.do_not_use);
            } else if (this.nKT.getDailyPrevilegeStatus() == 1) {
                ap.setViewTextColor(this.nLh, R.color.CAM_X0105, 1);
                ap.setBackgroundResource(this.nLh, R.drawable.gray_btn_selector);
                this.nLh.setText(R.string.use_immediately);
            } else if (freeUserLevel == 0) {
                ap.setViewTextColor(this.nLh, R.color.CAM_X0105, 1);
                ap.setBackgroundResource(this.nLh, R.drawable.gray_btn_selector);
                this.nLh.setText(R.string.use_freely);
            } else if (freeUserLevel == 100) {
                ap.setViewTextColor(this.nLh, R.color.CAM_X0101, 1);
                ap.setBackgroundResource(this.nLh, R.drawable.btn_all_blue);
                if (this.nKT.dRj() == 0) {
                    this.nLh.setText(R.string.activity_free_use);
                } else {
                    this.nLh.setText(R.string.use_immediately);
                }
            } else if (freeUserLevel == 101) {
                ap.setViewTextColor(this.nLh, R.color.CAM_X0101, 1);
                ap.setBackgroundResource(this.nLh, R.drawable.orange_btn_selector);
                this.nLh.setText(R.string.become_annual_free_use);
            } else if (freeUserLevel > 1) {
                ap.setViewTextColor(this.nLh, R.color.CAM_X0101, 1);
                ap.setBackgroundResource(this.nLh, R.drawable.orange_btn_selector);
                this.nLh.setText(String.format(this.nLd.getPageContext().getString(R.string.become_vip_free_use), Integer.valueOf(freeUserLevel)));
            } else {
                ap.setViewTextColor(this.nLh, R.color.CAM_X0101, 1);
                ap.setBackgroundResource(this.nLh, R.drawable.orange_btn_selector);
                this.nLh.setText(R.string.become_member_free_use);
            }
        }
    }

    public void cAU() {
        this.mContentView.setVisibility(8);
        this.nLe.setVisibility(8);
        this.nLk.setVisibility(8);
        this.nLl.setVisibility(8);
        this.nKR.setVisibility(8);
        this.nLg.setVisibility(8);
        this.nLf.setVisibility(8);
        this.nLh.setVisibility(8);
        this.nLd.showNetRefreshView(this.mRoot, this.nLd.getPageContext().getResources().getString(R.string.no_data_text), true);
    }

    public void cAV() {
        this.mContentView.setVisibility(0);
        this.nLl.setVisibility(0);
        this.nLe.setVisibility(0);
        this.nLk.setVisibility(0);
        this.nKR.setVisibility(0);
        this.nLg.setVisibility(0);
        this.nLf.setVisibility(0);
        this.nLh.setVisibility(0);
        this.nLd.hideNetRefreshView(this.mRoot);
    }

    public void bus() {
        this.nLd.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.nLd.getLayoutMode().onModeChanged(this.mRoot);
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.nLd.getPageContext(), TbadkApplication.getInst().getSkinType());
        }
        if (this.fNp != null) {
            this.fNp.onChangeSkinType(this.nLd.getPageContext(), TbadkApplication.getInst().getSkinType());
        }
    }

    public View getRootView() {
        return this.mRoot;
    }

    public View dRC() {
        return this.nLh;
    }
}
