package com.baidu.tieba.themeCenter.avatarPendant;

import android.view.View;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.R;
import com.baidu.tieba.themeCenter.MemberRecommendView;
import com.baidu.tieba.themeCenter.background.DressItemData;
import com.baidu.tieba.themeCenter.dressCenter.e;
import java.util.List;
/* loaded from: classes8.dex */
public class c extends com.baidu.adp.base.d<AvatarPendantActivity> {
    private BdListView Yj;
    private NoNetworkView gCe;
    private NavigationBar mNavigationBar;
    private View mRoot;
    private d nID;
    private MemberRecommendView nIE;
    private TextView nIF;
    private TextView nIG;
    private AvatarPendantActivity nIH;
    private TextView nII;
    private int topMargin;

    /* loaded from: classes8.dex */
    public interface a {
        void b(DressItemData dressItemData);
    }

    public c(AvatarPendantActivity avatarPendantActivity) {
        super(avatarPendantActivity.getPageContext());
        this.topMargin = 0;
        this.nIH = avatarPendantActivity;
        avatarPendantActivity.setContentView(R.layout.avatar_pendant_activity_layout);
        this.mRoot = avatarPendantActivity.findViewById(R.id.root_view);
        this.topMargin = l.getDimens(avatarPendantActivity.getPageContext().getPageActivity(), R.dimen.ds320);
        this.Yj = (BdListView) avatarPendantActivity.findViewById(R.id.avatar_pedant_listview);
        this.gCe = (NoNetworkView) avatarPendantActivity.findViewById(R.id.view_no_network);
        this.mNavigationBar = (NavigationBar) avatarPendantActivity.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(R.string.avatar_pendant);
        this.nIE = (MemberRecommendView) avatarPendantActivity.findViewById(R.id.avatar_pendant_theme_recommend);
        this.nIE.setFromType(8);
        this.nIE.getButton().setOnClickListener(avatarPendantActivity);
        this.nIF = new TextView(avatarPendantActivity.getActivity());
        this.nIF.setHeight(l.getDimens(avatarPendantActivity.getActivity(), R.dimen.ds104));
        this.nII = new TextView(avatarPendantActivity.getActivity());
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.getDimens(avatarPendantActivity.getActivity(), R.dimen.ds98));
        this.nIG = new TextView(avatarPendantActivity.getActivity());
        this.nIG.setHeight(l.getDimens(avatarPendantActivity.getActivity(), R.dimen.ds50));
        this.nII.setLayoutParams(layoutParams);
        this.Yj.addHeaderView(this.nII, 0);
        this.Yj.addFooterView(this.nIG);
        this.nID = new d(avatarPendantActivity);
        this.Yj.setAdapter((ListAdapter) this.nID);
    }

    private boolean b(e eVar) {
        if (eVar == null || StringUtils.isNull(eVar.dRF())) {
            this.nIE.setVisibility(8);
            return false;
        }
        this.nIE.setVisibility(0);
        this.nIE.a(eVar);
        return true;
    }

    public MemberRecommendView dRr() {
        return this.nIE;
    }

    public void fT(List<com.baidu.tieba.themeCenter.avatarPendant.a> list) {
        if (list == null || list.size() <= 0) {
            this.Yj.setVisibility(8);
            return;
        }
        this.Yj.setVisibility(0);
        this.nID.setData(list);
        this.nID.notifyDataSetChanged();
    }

    public void cAU() {
        this.Yj.setVisibility(8);
        String string = this.nIH.getPageContext().getResources().getString(R.string.no_data_text);
        this.nIH.setNetRefreshViewTopMargin(this.topMargin);
        this.nIH.showNetRefreshView(this.mRoot, string, false);
    }

    public void cAV() {
        this.nIH.hideNetRefreshView(this.mRoot);
        this.Yj.setVisibility(0);
    }

    public void bzq() {
        this.Yj.setBackgroundColor(ap.getColor(R.color.CAM_X0201));
        this.nID.notifyDataSetChanged();
        this.mNavigationBar.onChangeSkinType(this.nIH.getPageContext(), TbadkApplication.getInst().getSkinType());
        this.gCe.onChangeSkinType(this.nIH.getPageContext(), TbadkApplication.getInst().getSkinType());
        this.nIE.bus();
        ap.setBackgroundColor(this.nIF, R.color.CAM_X0204);
        ap.setBackgroundColor(this.nIG, R.color.CAM_X0201);
    }

    public View getRootView() {
        return this.mRoot;
    }

    public void a(e eVar, List<com.baidu.tieba.themeCenter.avatarPendant.a> list) {
        if ((eVar == null || StringUtils.isNull(eVar.dRF())) && (list == null || list.size() <= 0)) {
            cAU();
            return;
        }
        cAV();
        if (b(eVar)) {
            this.Yj.removeHeaderView(this.nIF);
            this.Yj.addHeaderView(this.nIF);
        } else {
            this.Yj.removeHeaderView(this.nIF);
        }
        fT(list);
    }

    public void setAvatarPendantItemClickListener(a aVar) {
        this.nID.setAvatarPendantItemClickListener(aVar);
    }

    public TextView dRs() {
        return this.nII;
    }

    public void a(NoNetworkView.a aVar) {
        this.gCe.a(aVar);
    }
}
