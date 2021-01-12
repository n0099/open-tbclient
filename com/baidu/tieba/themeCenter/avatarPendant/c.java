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
    private d nwm;
    private MemberRecommendView nwn;
    private TextView nwo;
    private TextView nwp;
    private AvatarPendantActivity nwq;
    private TextView nwr;

    /* loaded from: classes8.dex */
    public interface a {
        void b(DressItemData dressItemData);
    }

    public c(AvatarPendantActivity avatarPendantActivity) {
        super(avatarPendantActivity.getPageContext());
        this.agC = 0;
        this.nwq = avatarPendantActivity;
        avatarPendantActivity.setContentView(R.layout.avatar_pendant_activity_layout);
        this.mRoot = avatarPendantActivity.findViewById(R.id.root_view);
        this.agC = l.getDimens(avatarPendantActivity.getPageContext().getPageActivity(), R.dimen.ds320);
        this.WT = (BdListView) avatarPendantActivity.findViewById(R.id.avatar_pedant_listview);
        this.gxx = (NoNetworkView) avatarPendantActivity.findViewById(R.id.view_no_network);
        this.mNavigationBar = (NavigationBar) avatarPendantActivity.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(R.string.avatar_pendant);
        this.nwn = (MemberRecommendView) avatarPendantActivity.findViewById(R.id.avatar_pendant_theme_recommend);
        this.nwn.setFromType(8);
        this.nwn.getButton().setOnClickListener(avatarPendantActivity);
        this.nwo = new TextView(avatarPendantActivity.getActivity());
        this.nwo.setHeight(l.getDimens(avatarPendantActivity.getActivity(), R.dimen.ds104));
        this.nwr = new TextView(avatarPendantActivity.getActivity());
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.getDimens(avatarPendantActivity.getActivity(), R.dimen.ds98));
        this.nwp = new TextView(avatarPendantActivity.getActivity());
        this.nwp.setHeight(l.getDimens(avatarPendantActivity.getActivity(), R.dimen.ds50));
        this.nwr.setLayoutParams(layoutParams);
        this.WT.addHeaderView(this.nwr, 0);
        this.WT.addFooterView(this.nwp);
        this.nwm = new d(avatarPendantActivity);
        this.WT.setAdapter((ListAdapter) this.nwm);
    }

    private boolean b(e eVar) {
        if (eVar == null || StringUtils.isNull(eVar.dPd())) {
            this.nwn.setVisibility(8);
            return false;
        }
        this.nwn.setVisibility(0);
        this.nwn.a(eVar);
        return true;
    }

    public MemberRecommendView dOP() {
        return this.nwn;
    }

    public void fV(List<com.baidu.tieba.themeCenter.avatarPendant.a> list) {
        if (list == null || list.size() <= 0) {
            this.WT.setVisibility(8);
            return;
        }
        this.WT.setVisibility(0);
        this.nwm.setData(list);
        this.nwm.notifyDataSetChanged();
    }

    public void czw() {
        this.WT.setVisibility(8);
        String string = this.nwq.getPageContext().getResources().getString(R.string.no_data_text);
        this.nwq.setNetRefreshViewTopMargin(this.agC);
        this.nwq.showNetRefreshView(this.mRoot, string, false);
    }

    public void czx() {
        this.nwq.hideNetRefreshView(this.mRoot);
        this.WT.setVisibility(0);
    }

    public void byV() {
        this.WT.setBackgroundColor(ao.getColor(R.color.CAM_X0201));
        this.nwm.notifyDataSetChanged();
        this.mNavigationBar.onChangeSkinType(this.nwq.getPageContext(), TbadkApplication.getInst().getSkinType());
        this.gxx.onChangeSkinType(this.nwq.getPageContext(), TbadkApplication.getInst().getSkinType());
        this.nwn.btV();
        ao.setBackgroundColor(this.nwo, R.color.CAM_X0204);
        ao.setBackgroundColor(this.nwp, R.color.CAM_X0201);
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
            this.WT.removeHeaderView(this.nwo);
            this.WT.addHeaderView(this.nwo);
        } else {
            this.WT.removeHeaderView(this.nwo);
        }
        fV(list);
    }

    public void setAvatarPendantItemClickListener(a aVar) {
        this.nwm.setAvatarPendantItemClickListener(aVar);
    }

    public TextView dOQ() {
        return this.nwr;
    }

    public void a(NoNetworkView.a aVar) {
        this.gxx.a(aVar);
    }
}
