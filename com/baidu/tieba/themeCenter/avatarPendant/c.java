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
    private NoNetworkView gAv;
    private NavigationBar mNavigationBar;
    private View mRoot;
    private TextView nGA;
    private AvatarPendantActivity nGB;
    private TextView nGC;
    private d nGx;
    private MemberRecommendView nGy;
    private TextView nGz;
    private int topMargin;

    /* loaded from: classes9.dex */
    public interface a {
        void b(DressItemData dressItemData);
    }

    public c(AvatarPendantActivity avatarPendantActivity) {
        super(avatarPendantActivity.getPageContext());
        this.topMargin = 0;
        this.nGB = avatarPendantActivity;
        avatarPendantActivity.setContentView(R.layout.avatar_pendant_activity_layout);
        this.mRoot = avatarPendantActivity.findViewById(R.id.root_view);
        this.topMargin = l.getDimens(avatarPendantActivity.getPageContext().getPageActivity(), R.dimen.ds320);
        this.WO = (BdListView) avatarPendantActivity.findViewById(R.id.avatar_pedant_listview);
        this.gAv = (NoNetworkView) avatarPendantActivity.findViewById(R.id.view_no_network);
        this.mNavigationBar = (NavigationBar) avatarPendantActivity.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(R.string.avatar_pendant);
        this.nGy = (MemberRecommendView) avatarPendantActivity.findViewById(R.id.avatar_pendant_theme_recommend);
        this.nGy.setFromType(8);
        this.nGy.getButton().setOnClickListener(avatarPendantActivity);
        this.nGz = new TextView(avatarPendantActivity.getActivity());
        this.nGz.setHeight(l.getDimens(avatarPendantActivity.getActivity(), R.dimen.ds104));
        this.nGC = new TextView(avatarPendantActivity.getActivity());
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.getDimens(avatarPendantActivity.getActivity(), R.dimen.ds98));
        this.nGA = new TextView(avatarPendantActivity.getActivity());
        this.nGA.setHeight(l.getDimens(avatarPendantActivity.getActivity(), R.dimen.ds50));
        this.nGC.setLayoutParams(layoutParams);
        this.WO.addHeaderView(this.nGC, 0);
        this.WO.addFooterView(this.nGA);
        this.nGx = new d(avatarPendantActivity);
        this.WO.setAdapter((ListAdapter) this.nGx);
    }

    private boolean b(e eVar) {
        if (eVar == null || StringUtils.isNull(eVar.dRw())) {
            this.nGy.setVisibility(8);
            return false;
        }
        this.nGy.setVisibility(0);
        this.nGy.a(eVar);
        return true;
    }

    public MemberRecommendView dRi() {
        return this.nGy;
    }

    public void fT(List<com.baidu.tieba.themeCenter.avatarPendant.a> list) {
        if (list == null || list.size() <= 0) {
            this.WO.setVisibility(8);
            return;
        }
        this.WO.setVisibility(0);
        this.nGx.setData(list);
        this.nGx.notifyDataSetChanged();
    }

    public void cAO() {
        this.WO.setVisibility(8);
        String string = this.nGB.getPageContext().getResources().getString(R.string.no_data_text);
        this.nGB.setNetRefreshViewTopMargin(this.topMargin);
        this.nGB.showNetRefreshView(this.mRoot, string, false);
    }

    public void cAP() {
        this.nGB.hideNetRefreshView(this.mRoot);
        this.WO.setVisibility(0);
    }

    public void bzn() {
        this.WO.setBackgroundColor(ap.getColor(R.color.CAM_X0201));
        this.nGx.notifyDataSetChanged();
        this.mNavigationBar.onChangeSkinType(this.nGB.getPageContext(), TbadkApplication.getInst().getSkinType());
        this.gAv.onChangeSkinType(this.nGB.getPageContext(), TbadkApplication.getInst().getSkinType());
        this.nGy.bup();
        ap.setBackgroundColor(this.nGz, R.color.CAM_X0204);
        ap.setBackgroundColor(this.nGA, R.color.CAM_X0201);
    }

    public View getRootView() {
        return this.mRoot;
    }

    public void a(e eVar, List<com.baidu.tieba.themeCenter.avatarPendant.a> list) {
        if ((eVar == null || StringUtils.isNull(eVar.dRw())) && (list == null || list.size() <= 0)) {
            cAO();
            return;
        }
        cAP();
        if (b(eVar)) {
            this.WO.removeHeaderView(this.nGz);
            this.WO.addHeaderView(this.nGz);
        } else {
            this.WO.removeHeaderView(this.nGz);
        }
        fT(list);
    }

    public void setAvatarPendantItemClickListener(a aVar) {
        this.nGx.setAvatarPendantItemClickListener(aVar);
    }

    public TextView dRj() {
        return this.nGC;
    }

    public void a(NoNetworkView.a aVar) {
        this.gAv.a(aVar);
    }
}
