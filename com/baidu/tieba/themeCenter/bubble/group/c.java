package com.baidu.tieba.themeCenter.bubble.group;

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
import com.baidu.tbadk.core.atomData.BubbleListActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.tieba.themeCenter.MemberRecommendView;
import com.baidu.tieba.themeCenter.background.DressItemData;
import com.baidu.tieba.themeCenter.dressCenter.e;
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
    private MemberRecommendView nwS;
    private TextView nwT;
    private TextView nwo;
    private BubbleGroupActivity nxT;
    private a nxW;

    public c(BubbleGroupActivity bubbleGroupActivity, com.baidu.tieba.themeCenter.bubble.all.a aVar) {
        this.agC = 0;
        this.nxT = bubbleGroupActivity;
        this.agC = l.getDimens(bubbleGroupActivity.getPageContext().getPageActivity(), R.dimen.ds320);
        this.mRoot = LayoutInflater.from(this.nxT.getPageContext().getPageActivity()).inflate(R.layout.bubble_group, (ViewGroup) null);
        this.nxT.setContentView(this.mRoot);
        this.jQX = this.mRoot.findViewById(R.id.body_view);
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(R.string.editor_privilege);
        this.nwS = (MemberRecommendView) this.mRoot.findViewById(R.id.view_member_recommend);
        this.nwS.setFromType(6);
        this.WT = (BdListView) this.mRoot.findViewById(R.id.listview_group);
        this.nwo = new TextView(this.nxT.getActivity());
        this.nwo.setHeight(l.getDimens(this.nxT.getActivity(), R.dimen.ds104));
        this.nwT = (TextView) LayoutInflater.from(this.nxT.getPageContext().getPageActivity()).inflate(R.layout.look_more_view, (ViewGroup) null);
        this.nwT.setText(R.string.more_bubble);
        this.nwT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.themeCenter.bubble.group.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log("c10283");
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BubbleListActivityConfig(c.this.nxT.getActivity())));
            }
        });
        this.nxW = new a(this.nxT.getPageContext(), aVar);
        TextView textView = new TextView(this.nxT.getActivity());
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.getDimens(this.nxT.getActivity(), R.dimen.ds98)));
        this.WT.addHeaderView(textView, 0);
        this.WT.addFooterView(this.nwT);
        this.WT.setAdapter((ListAdapter) this.nxW);
    }

    public void a(e eVar, List<b> list, boolean z) {
        if (list == null || list.size() <= 0) {
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
        fV(fW(list));
    }

    private List<Object> fW(List<b> list) {
        ArrayList arrayList = new ArrayList();
        for (b bVar : list) {
            List<DressItemData> bubbleList = bVar.getBubbleList();
            int size = bubbleList.size();
            if (size != 0) {
                arrayList.add(bVar.getGroupName());
                int i = size > 4 ? 4 : size;
                for (int i2 = 0; i2 < i; i2 = i2 + 1 + 1) {
                    ArrayList arrayList2 = new ArrayList();
                    for (int i3 = 0; i3 < 2; i3++) {
                        if (i2 + i3 < i) {
                            arrayList2.add(bubbleList.get(i2 + i3));
                        }
                    }
                    arrayList.add(arrayList2);
                }
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
        this.nxW.setData(list);
        this.nxW.notifyDataSetChanged();
    }

    private boolean b(e eVar) {
        if (eVar == null || StringUtils.isNull(eVar.dPd())) {
            this.nwS.setVisibility(8);
            return false;
        }
        this.nwS.setVisibility(0);
        this.nwS.a(eVar);
        return true;
    }

    public void czw() {
        this.jQX.setVisibility(8);
        ao.setBackgroundColor(this.mRoot, R.color.CAM_X0201);
        String string = this.nxT.getPageContext().getResources().getString(R.string.no_data_text);
        this.nxT.setNetRefreshViewTopMargin(this.agC);
        this.nxT.showNetRefreshView(this.mRoot, string, false);
    }

    public void czx() {
        ao.setBackgroundColor(this.mRoot, R.color.CAM_X0204);
        this.nxT.hideNetRefreshView(this.mRoot);
        this.jQX.setVisibility(0);
    }

    public void cMC() {
        this.jQX.setVisibility(8);
    }

    public void cMD() {
        this.jQX.setVisibility(0);
    }

    public void byV() {
        com.baidu.tbadk.r.a.a(this.nxT.getPageContext(), this.mRoot);
        com.baidu.tbadk.r.a.a(this.nxT.getPageContext(), this.nwT);
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.nxT.getPageContext(), TbadkApplication.getInst().getSkinType());
        }
        if (this.WT != null && this.WT.getVisibility() == 0 && this.nxW != null) {
            this.nxW.notifyDataSetChanged();
        }
        ao.setBackgroundColor(this.nwo, R.color.CAM_X0204);
    }

    public View getRootView() {
        return this.mRoot;
    }
}
