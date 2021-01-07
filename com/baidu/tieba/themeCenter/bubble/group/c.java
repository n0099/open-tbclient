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
/* loaded from: classes9.dex */
public class c {
    private BdListView WV;
    private int aht;
    private View jVC;
    private NavigationBar mNavigationBar;
    private View mRoot;
    private TextView nAT;
    private MemberRecommendView nBx;
    private TextView nBy;
    private a nCB;
    private BubbleGroupActivity nCy;

    public c(BubbleGroupActivity bubbleGroupActivity, com.baidu.tieba.themeCenter.bubble.all.a aVar) {
        this.aht = 0;
        this.nCy = bubbleGroupActivity;
        this.aht = l.getDimens(bubbleGroupActivity.getPageContext().getPageActivity(), R.dimen.ds320);
        this.mRoot = LayoutInflater.from(this.nCy.getPageContext().getPageActivity()).inflate(R.layout.bubble_group, (ViewGroup) null);
        this.nCy.setContentView(this.mRoot);
        this.jVC = this.mRoot.findViewById(R.id.body_view);
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(R.string.editor_privilege);
        this.nBx = (MemberRecommendView) this.mRoot.findViewById(R.id.view_member_recommend);
        this.nBx.setFromType(6);
        this.WV = (BdListView) this.mRoot.findViewById(R.id.listview_group);
        this.nAT = new TextView(this.nCy.getActivity());
        this.nAT.setHeight(l.getDimens(this.nCy.getActivity(), R.dimen.ds104));
        this.nBy = (TextView) LayoutInflater.from(this.nCy.getPageContext().getPageActivity()).inflate(R.layout.look_more_view, (ViewGroup) null);
        this.nBy.setText(R.string.more_bubble);
        this.nBy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.themeCenter.bubble.group.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log("c10283");
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BubbleListActivityConfig(c.this.nCy.getActivity())));
            }
        });
        this.nCB = new a(this.nCy.getPageContext(), aVar);
        TextView textView = new TextView(this.nCy.getActivity());
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.getDimens(this.nCy.getActivity(), R.dimen.ds98)));
        this.WV.addHeaderView(textView, 0);
        this.WV.addFooterView(this.nBy);
        this.WV.setAdapter((ListAdapter) this.nCB);
    }

    public void a(e eVar, List<b> list, boolean z) {
        if (list == null || list.size() <= 0) {
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
            this.WV.setVisibility(8);
            return;
        }
        this.WV.setVisibility(0);
        this.nCB.setData(list);
        this.nCB.notifyDataSetChanged();
    }

    private boolean b(e eVar) {
        if (eVar == null || StringUtils.isNull(eVar.dSV())) {
            this.nBx.setVisibility(8);
            return false;
        }
        this.nBx.setVisibility(0);
        this.nBx.a(eVar);
        return true;
    }

    public void cDo() {
        this.jVC.setVisibility(8);
        ao.setBackgroundColor(this.mRoot, R.color.CAM_X0201);
        String string = this.nCy.getPageContext().getResources().getString(R.string.no_data_text);
        this.nCy.setNetRefreshViewTopMargin(this.aht);
        this.nCy.showNetRefreshView(this.mRoot, string, false);
    }

    public void cDp() {
        ao.setBackgroundColor(this.mRoot, R.color.CAM_X0204);
        this.nCy.hideNetRefreshView(this.mRoot);
        this.jVC.setVisibility(0);
    }

    public void cQu() {
        this.jVC.setVisibility(8);
    }

    public void cQv() {
        this.jVC.setVisibility(0);
    }

    public void bCP() {
        com.baidu.tbadk.r.a.a(this.nCy.getPageContext(), this.mRoot);
        com.baidu.tbadk.r.a.a(this.nCy.getPageContext(), this.nBy);
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.nCy.getPageContext(), TbadkApplication.getInst().getSkinType());
        }
        if (this.WV != null && this.WV.getVisibility() == 0 && this.nCB != null) {
            this.nCB.notifyDataSetChanged();
        }
        ao.setBackgroundColor(this.nAT, R.color.CAM_X0204);
    }

    public View getRootView() {
        return this.mRoot;
    }
}
