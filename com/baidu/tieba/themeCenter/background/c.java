package com.baidu.tieba.themeCenter.background;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.PersonalBackdropListActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.tieba.themeCenter.MemberRecommendView;
import java.util.ArrayList;
import java.util.List;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes8.dex */
public class c {
    private BdListView WT;
    private int agC;
    private View jQX;
    private NavigationBar mNavigationBar;
    private View mRoot;
    private BackgroundGroupActivity nwN;
    private MemberRecommendView nwT;
    private TextView nwU;
    private a nwV;
    private TextView nwp;

    public c(BackgroundGroupActivity backgroundGroupActivity, d dVar) {
        this.agC = 0;
        this.nwN = backgroundGroupActivity;
        this.agC = l.getDimens(backgroundGroupActivity.getPageContext().getPageActivity(), R.dimen.ds320);
        this.mRoot = LayoutInflater.from(this.nwN.getPageContext().getPageActivity()).inflate(R.layout.background_group, (ViewGroup) null);
        this.nwN.setContentView(this.mRoot);
        this.jQX = this.mRoot.findViewById(R.id.body_view);
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(R.string.personal_background);
        this.nwT = (MemberRecommendView) this.mRoot.findViewById(R.id.view_member_recommend);
        this.nwT.setFromType(4);
        this.WT = (BdListView) this.mRoot.findViewById(R.id.listview_bg_group);
        this.nwp = new TextView(this.nwN.getActivity());
        this.nwp.setHeight(l.getDimens(this.nwN.getActivity(), R.dimen.ds104));
        this.nwU = (TextView) LayoutInflater.from(this.nwN.getPageContext().getPageActivity()).inflate(R.layout.look_more_view, (ViewGroup) null);
        this.nwU.setText(R.string.more_backgrounds);
        this.nwU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.themeCenter.background.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log("c10283");
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonalBackdropListActivityConfig(c.this.nwN.getActivity())));
            }
        });
        this.nwV = new a(this.nwN.getPageContext(), dVar);
        TextView textView = new TextView(this.nwN.getActivity());
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.getDimens(this.nwN.getActivity(), R.dimen.ds98)));
        this.WT.addHeaderView(textView, 0);
        this.WT.addFooterView(this.nwU);
        this.WT.setAdapter((ListAdapter) this.nwV);
    }

    public void a(com.baidu.tieba.themeCenter.dressCenter.e eVar, List<b> list, boolean z) {
        if (list == null || list.size() <= 0) {
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
        fV(fW(list));
    }

    private List<Object> fW(List<b> list) {
        ArrayList arrayList = new ArrayList();
        for (b bVar : list) {
            arrayList.add(bVar.getGroupName());
            List<DressItemData> backgroundList = bVar.getBackgroundList();
            int size = backgroundList.size();
            if (size > 3) {
                size = 3;
            }
            for (int i = 0; i < size; i = i + 2 + 1) {
                ArrayList arrayList2 = new ArrayList();
                for (int i2 = 0; i2 < 3; i2++) {
                    if (i + i2 < size) {
                        arrayList2.add(backgroundList.get(i + i2));
                    }
                }
                arrayList.add(arrayList2);
            }
        }
        return arrayList;
    }

    private void fV(List<Object> list) {
        if (list == null || list.size() <= 0) {
            this.WT.setVisibility(8);
            return;
        }
        this.WT.setVisibility(0);
        this.nwV.setData(list);
        this.nwV.notifyDataSetChanged();
    }

    private boolean b(com.baidu.tieba.themeCenter.dressCenter.e eVar) {
        if (eVar == null || StringUtils.isNull(eVar.dPd())) {
            this.nwT.setVisibility(8);
            return false;
        }
        this.nwT.setVisibility(0);
        this.nwT.a(eVar);
        return true;
    }

    public void czw() {
        this.jQX.setVisibility(8);
        ao.setBackgroundColor(this.mRoot, R.color.CAM_X0201);
        String string = this.nwN.getPageContext().getResources().getString(R.string.no_data_text);
        this.nwN.setNetRefreshViewTopMargin(this.agC);
        this.nwN.showNetRefreshView(this.mRoot, string, false);
    }

    public void czx() {
        ao.setBackgroundColor(this.mRoot, R.color.CAM_X0204);
        this.nwN.hideNetRefreshView(this.mRoot);
        this.jQX.setVisibility(0);
    }

    public void cMC() {
        this.jQX.setVisibility(8);
    }

    public void cMD() {
        this.jQX.setVisibility(0);
    }

    public void byV() {
        com.baidu.tbadk.r.a.a(this.nwN.getPageContext(), this.mRoot);
        this.nwN.getLayoutMode().onModeChanged(this.nwU);
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.nwN.getPageContext(), TbadkApplication.getInst().getSkinType());
        }
        if (this.WT != null && this.WT.getVisibility() == 0 && this.nwV != null) {
            this.nwV.notifyDataSetChanged();
        }
        ao.setBackgroundColor(this.nwp, R.color.CAM_X0204);
    }

    public View getRootView() {
        return this.mRoot;
    }
}
