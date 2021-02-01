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
import com.baidu.tbadk.core.util.ap;
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
    private BdListView WO;
    private View jYz;
    private NavigationBar mNavigationBar;
    private View mRoot;
    private TextView nFZ;
    private MemberRecommendView nGD;
    private TextView nGE;
    private BubbleGroupActivity nHE;
    private a nHH;
    private int topMargin;

    public c(BubbleGroupActivity bubbleGroupActivity, com.baidu.tieba.themeCenter.bubble.all.a aVar) {
        this.topMargin = 0;
        this.nHE = bubbleGroupActivity;
        this.topMargin = l.getDimens(bubbleGroupActivity.getPageContext().getPageActivity(), R.dimen.ds320);
        this.mRoot = LayoutInflater.from(this.nHE.getPageContext().getPageActivity()).inflate(R.layout.bubble_group, (ViewGroup) null);
        this.nHE.setContentView(this.mRoot);
        this.jYz = this.mRoot.findViewById(R.id.body_view);
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(R.string.editor_privilege);
        this.nGD = (MemberRecommendView) this.mRoot.findViewById(R.id.view_member_recommend);
        this.nGD.setFromType(6);
        this.WO = (BdListView) this.mRoot.findViewById(R.id.listview_group);
        this.nFZ = new TextView(this.nHE.getActivity());
        this.nFZ.setHeight(l.getDimens(this.nHE.getActivity(), R.dimen.ds104));
        this.nGE = (TextView) LayoutInflater.from(this.nHE.getPageContext().getPageActivity()).inflate(R.layout.look_more_view, (ViewGroup) null);
        this.nGE.setText(R.string.more_bubble);
        this.nGE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.themeCenter.bubble.group.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log("c10283");
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BubbleListActivityConfig(c.this.nHE.getActivity())));
            }
        });
        this.nHH = new a(this.nHE.getPageContext(), aVar);
        TextView textView = new TextView(this.nHE.getActivity());
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.getDimens(this.nHE.getActivity(), R.dimen.ds98)));
        this.WO.addHeaderView(textView, 0);
        this.WO.addFooterView(this.nGE);
        this.WO.setAdapter((ListAdapter) this.nHH);
    }

    public void a(e eVar, List<b> list, boolean z) {
        if (list == null || list.size() <= 0) {
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
        fT(fU(list));
    }

    private List<Object> fU(List<b> list) {
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

    private void fT(List<Object> list) {
        if (list == null || list.size() <= 0) {
            this.WO.setVisibility(8);
            return;
        }
        this.WO.setVisibility(0);
        this.nHH.setData(list);
        this.nHH.notifyDataSetChanged();
    }

    private boolean b(e eVar) {
        if (eVar == null || StringUtils.isNull(eVar.dRo())) {
            this.nGD.setVisibility(8);
            return false;
        }
        this.nGD.setVisibility(0);
        this.nGD.a(eVar);
        return true;
    }

    public void cAH() {
        this.jYz.setVisibility(8);
        ap.setBackgroundColor(this.mRoot, R.color.CAM_X0201);
        String string = this.nHE.getPageContext().getResources().getString(R.string.no_data_text);
        this.nHE.setNetRefreshViewTopMargin(this.topMargin);
        this.nHE.showNetRefreshView(this.mRoot, string, false);
    }

    public void cAI() {
        ap.setBackgroundColor(this.mRoot, R.color.CAM_X0204);
        this.nHE.hideNetRefreshView(this.mRoot);
        this.jYz.setVisibility(0);
    }

    public void cOz() {
        this.jYz.setVisibility(8);
    }

    public void cOA() {
        this.jYz.setVisibility(0);
    }

    public void bzn() {
        com.baidu.tbadk.r.a.a(this.nHE.getPageContext(), this.mRoot);
        com.baidu.tbadk.r.a.a(this.nHE.getPageContext(), this.nGE);
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.nHE.getPageContext(), TbadkApplication.getInst().getSkinType());
        }
        if (this.WO != null && this.WO.getVisibility() == 0 && this.nHH != null) {
            this.nHH.notifyDataSetChanged();
        }
        ap.setBackgroundColor(this.nFZ, R.color.CAM_X0204);
    }

    public View getRootView() {
        return this.mRoot;
    }
}
