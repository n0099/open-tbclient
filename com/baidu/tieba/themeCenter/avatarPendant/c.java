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
/* loaded from: classes9.dex */
public class c extends com.baidu.adp.base.d<AvatarPendantActivity> {
    private BdListView WV;
    private int aht;
    private NoNetworkView gCe;
    private NavigationBar mNavigationBar;
    private View mRoot;
    private d nAR;
    private MemberRecommendView nAS;
    private TextView nAT;
    private TextView nAU;
    private AvatarPendantActivity nAV;
    private TextView nAW;

    /* loaded from: classes9.dex */
    public interface a {
        void b(DressItemData dressItemData);
    }

    public c(AvatarPendantActivity avatarPendantActivity) {
        super(avatarPendantActivity.getPageContext());
        this.aht = 0;
        this.nAV = avatarPendantActivity;
        avatarPendantActivity.setContentView(R.layout.avatar_pendant_activity_layout);
        this.mRoot = avatarPendantActivity.findViewById(R.id.root_view);
        this.aht = l.getDimens(avatarPendantActivity.getPageContext().getPageActivity(), R.dimen.ds320);
        this.WV = (BdListView) avatarPendantActivity.findViewById(R.id.avatar_pedant_listview);
        this.gCe = (NoNetworkView) avatarPendantActivity.findViewById(R.id.view_no_network);
        this.mNavigationBar = (NavigationBar) avatarPendantActivity.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(R.string.avatar_pendant);
        this.nAS = (MemberRecommendView) avatarPendantActivity.findViewById(R.id.avatar_pendant_theme_recommend);
        this.nAS.setFromType(8);
        this.nAS.getButton().setOnClickListener(avatarPendantActivity);
        this.nAT = new TextView(avatarPendantActivity.getActivity());
        this.nAT.setHeight(l.getDimens(avatarPendantActivity.getActivity(), R.dimen.ds104));
        this.nAW = new TextView(avatarPendantActivity.getActivity());
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.getDimens(avatarPendantActivity.getActivity(), R.dimen.ds98));
        this.nAU = new TextView(avatarPendantActivity.getActivity());
        this.nAU.setHeight(l.getDimens(avatarPendantActivity.getActivity(), R.dimen.ds50));
        this.nAW.setLayoutParams(layoutParams);
        this.WV.addHeaderView(this.nAW, 0);
        this.WV.addFooterView(this.nAU);
        this.nAR = new d(avatarPendantActivity);
        this.WV.setAdapter((ListAdapter) this.nAR);
    }

    private boolean b(e eVar) {
        if (eVar == null || StringUtils.isNull(eVar.dSV())) {
            this.nAS.setVisibility(8);
            return false;
        }
        this.nAS.setVisibility(0);
        this.nAS.a(eVar);
        return true;
    }

    public MemberRecommendView dSH() {
        return this.nAS;
    }

    public void fV(List<com.baidu.tieba.themeCenter.avatarPendant.a> list) {
        if (list == null || list.size() <= 0) {
            this.WV.setVisibility(8);
            return;
        }
        this.WV.setVisibility(0);
        this.nAR.setData(list);
        this.nAR.notifyDataSetChanged();
    }

    public void cDo() {
        this.WV.setVisibility(8);
        String string = this.nAV.getPageContext().getResources().getString(R.string.no_data_text);
        this.nAV.setNetRefreshViewTopMargin(this.aht);
        this.nAV.showNetRefreshView(this.mRoot, string, false);
    }

    public void cDp() {
        this.nAV.hideNetRefreshView(this.mRoot);
        this.WV.setVisibility(0);
    }

    public void bCP() {
        this.WV.setBackgroundColor(ao.getColor(R.color.CAM_X0201));
        this.nAR.notifyDataSetChanged();
        this.mNavigationBar.onChangeSkinType(this.nAV.getPageContext(), TbadkApplication.getInst().getSkinType());
        this.gCe.onChangeSkinType(this.nAV.getPageContext(), TbadkApplication.getInst().getSkinType());
        this.nAS.bxP();
        ao.setBackgroundColor(this.nAT, R.color.CAM_X0204);
        ao.setBackgroundColor(this.nAU, R.color.CAM_X0201);
    }

    public View getRootView() {
        return this.mRoot;
    }

    public void a(e eVar, List<com.baidu.tieba.themeCenter.avatarPendant.a> list) {
        if ((eVar == null || StringUtils.isNull(eVar.dSV())) && (list == null || list.size() <= 0)) {
            cDo();
            return;
        }
        cDp();
        if (b(eVar)) {
            this.WV.removeHeaderView(this.nAT);
            this.WV.addHeaderView(this.nAT);
        } else {
            this.WV.removeHeaderView(this.nAT);
        }
        fV(list);
    }

    public void setAvatarPendantItemClickListener(a aVar) {
        this.nAR.setAvatarPendantItemClickListener(aVar);
    }

    public TextView dSI() {
        return this.nAW;
    }

    public void a(NoNetworkView.a aVar) {
        this.gCe.a(aVar);
    }
}
