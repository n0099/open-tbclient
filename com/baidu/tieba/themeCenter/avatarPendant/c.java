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
/* loaded from: classes9.dex */
public class c extends com.baidu.adp.base.d<AvatarPendantActivity> {
    private BdListView WO;
    private NoNetworkView gAh;
    private NavigationBar mNavigationBar;
    private View mRoot;
    private d nFX;
    private MemberRecommendView nFY;
    private TextView nFZ;
    private TextView nGa;
    private AvatarPendantActivity nGb;
    private TextView nGc;
    private int topMargin;

    /* loaded from: classes9.dex */
    public interface a {
        void b(DressItemData dressItemData);
    }

    public c(AvatarPendantActivity avatarPendantActivity) {
        super(avatarPendantActivity.getPageContext());
        this.topMargin = 0;
        this.nGb = avatarPendantActivity;
        avatarPendantActivity.setContentView(R.layout.avatar_pendant_activity_layout);
        this.mRoot = avatarPendantActivity.findViewById(R.id.root_view);
        this.topMargin = l.getDimens(avatarPendantActivity.getPageContext().getPageActivity(), R.dimen.ds320);
        this.WO = (BdListView) avatarPendantActivity.findViewById(R.id.avatar_pedant_listview);
        this.gAh = (NoNetworkView) avatarPendantActivity.findViewById(R.id.view_no_network);
        this.mNavigationBar = (NavigationBar) avatarPendantActivity.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(R.string.avatar_pendant);
        this.nFY = (MemberRecommendView) avatarPendantActivity.findViewById(R.id.avatar_pendant_theme_recommend);
        this.nFY.setFromType(8);
        this.nFY.getButton().setOnClickListener(avatarPendantActivity);
        this.nFZ = new TextView(avatarPendantActivity.getActivity());
        this.nFZ.setHeight(l.getDimens(avatarPendantActivity.getActivity(), R.dimen.ds104));
        this.nGc = new TextView(avatarPendantActivity.getActivity());
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.getDimens(avatarPendantActivity.getActivity(), R.dimen.ds98));
        this.nGa = new TextView(avatarPendantActivity.getActivity());
        this.nGa.setHeight(l.getDimens(avatarPendantActivity.getActivity(), R.dimen.ds50));
        this.nGc.setLayoutParams(layoutParams);
        this.WO.addHeaderView(this.nGc, 0);
        this.WO.addFooterView(this.nGa);
        this.nFX = new d(avatarPendantActivity);
        this.WO.setAdapter((ListAdapter) this.nFX);
    }

    private boolean b(e eVar) {
        if (eVar == null || StringUtils.isNull(eVar.dRo())) {
            this.nFY.setVisibility(8);
            return false;
        }
        this.nFY.setVisibility(0);
        this.nFY.a(eVar);
        return true;
    }

    public MemberRecommendView dRa() {
        return this.nFY;
    }

    public void fT(List<com.baidu.tieba.themeCenter.avatarPendant.a> list) {
        if (list == null || list.size() <= 0) {
            this.WO.setVisibility(8);
            return;
        }
        this.WO.setVisibility(0);
        this.nFX.setData(list);
        this.nFX.notifyDataSetChanged();
    }

    public void cAH() {
        this.WO.setVisibility(8);
        String string = this.nGb.getPageContext().getResources().getString(R.string.no_data_text);
        this.nGb.setNetRefreshViewTopMargin(this.topMargin);
        this.nGb.showNetRefreshView(this.mRoot, string, false);
    }

    public void cAI() {
        this.nGb.hideNetRefreshView(this.mRoot);
        this.WO.setVisibility(0);
    }

    public void bzn() {
        this.WO.setBackgroundColor(ap.getColor(R.color.CAM_X0201));
        this.nFX.notifyDataSetChanged();
        this.mNavigationBar.onChangeSkinType(this.nGb.getPageContext(), TbadkApplication.getInst().getSkinType());
        this.gAh.onChangeSkinType(this.nGb.getPageContext(), TbadkApplication.getInst().getSkinType());
        this.nFY.bup();
        ap.setBackgroundColor(this.nFZ, R.color.CAM_X0204);
        ap.setBackgroundColor(this.nGa, R.color.CAM_X0201);
    }

    public View getRootView() {
        return this.mRoot;
    }

    public void a(e eVar, List<com.baidu.tieba.themeCenter.avatarPendant.a> list) {
        if ((eVar == null || StringUtils.isNull(eVar.dRo())) && (list == null || list.size() <= 0)) {
            cAH();
            return;
        }
        cAI();
        if (b(eVar)) {
            this.WO.removeHeaderView(this.nFZ);
            this.WO.addHeaderView(this.nFZ);
        } else {
            this.WO.removeHeaderView(this.nFZ);
        }
        fT(list);
    }

    public void setAvatarPendantItemClickListener(a aVar) {
        this.nFX.setAvatarPendantItemClickListener(aVar);
    }

    public TextView dRb() {
        return this.nGc;
    }

    public void a(NoNetworkView.a aVar) {
        this.gAh.a(aVar);
    }
}
