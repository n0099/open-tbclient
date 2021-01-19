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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.R;
import com.baidu.tieba.themeCenter.MemberRecommendView;
import com.baidu.tieba.themeCenter.background.DressItemData;
import com.baidu.tieba.themeCenter.dressCenter.e;
import java.util.List;
/* loaded from: classes8.dex */
public class c extends com.baidu.adp.base.d<AvatarPendantActivity> {
    private BdListView WT;
    private int agC;
    private NoNetworkView gxx;
    private NavigationBar mNavigationBar;
    private View mRoot;
    private d nwn;
    private MemberRecommendView nwo;
    private TextView nwp;
    private TextView nwq;
    private AvatarPendantActivity nwr;
    private TextView nws;

    /* loaded from: classes8.dex */
    public interface a {
        void b(DressItemData dressItemData);
    }

    public c(AvatarPendantActivity avatarPendantActivity) {
        super(avatarPendantActivity.getPageContext());
        this.agC = 0;
        this.nwr = avatarPendantActivity;
        avatarPendantActivity.setContentView(R.layout.avatar_pendant_activity_layout);
        this.mRoot = avatarPendantActivity.findViewById(R.id.root_view);
        this.agC = l.getDimens(avatarPendantActivity.getPageContext().getPageActivity(), R.dimen.ds320);
        this.WT = (BdListView) avatarPendantActivity.findViewById(R.id.avatar_pedant_listview);
        this.gxx = (NoNetworkView) avatarPendantActivity.findViewById(R.id.view_no_network);
        this.mNavigationBar = (NavigationBar) avatarPendantActivity.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(R.string.avatar_pendant);
        this.nwo = (MemberRecommendView) avatarPendantActivity.findViewById(R.id.avatar_pendant_theme_recommend);
        this.nwo.setFromType(8);
        this.nwo.getButton().setOnClickListener(avatarPendantActivity);
        this.nwp = new TextView(avatarPendantActivity.getActivity());
        this.nwp.setHeight(l.getDimens(avatarPendantActivity.getActivity(), R.dimen.ds104));
        this.nws = new TextView(avatarPendantActivity.getActivity());
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.getDimens(avatarPendantActivity.getActivity(), R.dimen.ds98));
        this.nwq = new TextView(avatarPendantActivity.getActivity());
        this.nwq.setHeight(l.getDimens(avatarPendantActivity.getActivity(), R.dimen.ds50));
        this.nws.setLayoutParams(layoutParams);
        this.WT.addHeaderView(this.nws, 0);
        this.WT.addFooterView(this.nwq);
        this.nwn = new d(avatarPendantActivity);
        this.WT.setAdapter((ListAdapter) this.nwn);
    }

    private boolean b(e eVar) {
        if (eVar == null || StringUtils.isNull(eVar.dPd())) {
            this.nwo.setVisibility(8);
            return false;
        }
        this.nwo.setVisibility(0);
        this.nwo.a(eVar);
        return true;
    }

    public MemberRecommendView dOP() {
        return this.nwo;
    }

    public void fV(List<com.baidu.tieba.themeCenter.avatarPendant.a> list) {
        if (list == null || list.size() <= 0) {
            this.WT.setVisibility(8);
            return;
        }
        this.WT.setVisibility(0);
        this.nwn.setData(list);
        this.nwn.notifyDataSetChanged();
    }

    public void czw() {
        this.WT.setVisibility(8);
        String string = this.nwr.getPageContext().getResources().getString(R.string.no_data_text);
        this.nwr.setNetRefreshViewTopMargin(this.agC);
        this.nwr.showNetRefreshView(this.mRoot, string, false);
    }

    public void czx() {
        this.nwr.hideNetRefreshView(this.mRoot);
        this.WT.setVisibility(0);
    }

    public void byV() {
        this.WT.setBackgroundColor(ao.getColor(R.color.CAM_X0201));
        this.nwn.notifyDataSetChanged();
        this.mNavigationBar.onChangeSkinType(this.nwr.getPageContext(), TbadkApplication.getInst().getSkinType());
        this.gxx.onChangeSkinType(this.nwr.getPageContext(), TbadkApplication.getInst().getSkinType());
        this.nwo.btV();
        ao.setBackgroundColor(this.nwp, R.color.CAM_X0204);
        ao.setBackgroundColor(this.nwq, R.color.CAM_X0201);
    }

    public View getRootView() {
        return this.mRoot;
    }

    public void a(e eVar, List<com.baidu.tieba.themeCenter.avatarPendant.a> list) {
        if ((eVar == null || StringUtils.isNull(eVar.dPd())) && (list == null || list.size() <= 0)) {
            czw();
            return;
        }
        czx();
        if (b(eVar)) {
            this.WT.removeHeaderView(this.nwp);
            this.WT.addHeaderView(this.nwp);
        } else {
            this.WT.removeHeaderView(this.nwp);
        }
        fV(list);
    }

    public void setAvatarPendantItemClickListener(a aVar) {
        this.nwn.setAvatarPendantItemClickListener(aVar);
    }

    public TextView dOQ() {
        return this.nws;
    }

    public void a(NoNetworkView.a aVar) {
        this.gxx.a(aVar);
    }
}
