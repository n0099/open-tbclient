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
    private View jYN;
    private NavigationBar mNavigationBar;
    private View mRoot;
    private TextView nGz;
    private MemberRecommendView nHd;
    private TextView nHe;
    private BubbleGroupActivity nIe;
    private a nIh;
    private int topMargin;

    public c(BubbleGroupActivity bubbleGroupActivity, com.baidu.tieba.themeCenter.bubble.all.a aVar) {
        this.topMargin = 0;
        this.nIe = bubbleGroupActivity;
        this.topMargin = l.getDimens(bubbleGroupActivity.getPageContext().getPageActivity(), R.dimen.ds320);
        this.mRoot = LayoutInflater.from(this.nIe.getPageContext().getPageActivity()).inflate(R.layout.bubble_group, (ViewGroup) null);
        this.nIe.setContentView(this.mRoot);
        this.jYN = this.mRoot.findViewById(R.id.body_view);
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(R.string.editor_privilege);
        this.nHd = (MemberRecommendView) this.mRoot.findViewById(R.id.view_member_recommend);
        this.nHd.setFromType(6);
        this.WO = (BdListView) this.mRoot.findViewById(R.id.listview_group);
        this.nGz = new TextView(this.nIe.getActivity());
        this.nGz.setHeight(l.getDimens(this.nIe.getActivity(), R.dimen.ds104));
        this.nHe = (TextView) LayoutInflater.from(this.nIe.getPageContext().getPageActivity()).inflate(R.layout.look_more_view, (ViewGroup) null);
        this.nHe.setText(R.string.more_bubble);
        this.nHe.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.themeCenter.bubble.group.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log("c10283");
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BubbleListActivityConfig(c.this.nIe.getActivity())));
            }
        });
        this.nIh = new a(this.nIe.getPageContext(), aVar);
        TextView textView = new TextView(this.nIe.getActivity());
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.getDimens(this.nIe.getActivity(), R.dimen.ds98)));
        this.WO.addHeaderView(textView, 0);
        this.WO.addFooterView(this.nHe);
        this.WO.setAdapter((ListAdapter) this.nIh);
    }

    public void a(e eVar, List<b> list, boolean z) {
        if (list == null || list.size() <= 0) {
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
        this.nIh.setData(list);
        this.nIh.notifyDataSetChanged();
    }

    private boolean b(e eVar) {
        if (eVar == null || StringUtils.isNull(eVar.dRw())) {
            this.nHd.setVisibility(8);
            return false;
        }
        this.nHd.setVisibility(0);
        this.nHd.a(eVar);
        return true;
    }

    public void cAO() {
        this.jYN.setVisibility(8);
        ap.setBackgroundColor(this.mRoot, R.color.CAM_X0201);
        String string = this.nIe.getPageContext().getResources().getString(R.string.no_data_text);
        this.nIe.setNetRefreshViewTopMargin(this.topMargin);
        this.nIe.showNetRefreshView(this.mRoot, string, false);
    }

    public void cAP() {
        ap.setBackgroundColor(this.mRoot, R.color.CAM_X0204);
        this.nIe.hideNetRefreshView(this.mRoot);
        this.jYN.setVisibility(0);
    }

    public void cOG() {
        this.jYN.setVisibility(8);
    }

    public void cOH() {
        this.jYN.setVisibility(0);
    }

    public void bzn() {
        com.baidu.tbadk.r.a.a(this.nIe.getPageContext(), this.mRoot);
        com.baidu.tbadk.r.a.a(this.nIe.getPageContext(), this.nHe);
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.nIe.getPageContext(), TbadkApplication.getInst().getSkinType());
        }
        if (this.WO != null && this.WO.getVisibility() == 0 && this.nIh != null) {
            this.nIh.notifyDataSetChanged();
        }
        ap.setBackgroundColor(this.nGz, R.color.CAM_X0204);
    }

    public View getRootView() {
        return this.mRoot;
    }
}
