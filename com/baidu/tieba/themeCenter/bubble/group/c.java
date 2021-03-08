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
/* loaded from: classes8.dex */
public class c {
    private BdListView Yj;
    private View kaP;
    private NavigationBar mNavigationBar;
    private View mRoot;
    private TextView nIF;
    private MemberRecommendView nJj;
    private TextView nJk;
    private BubbleGroupActivity nKk;
    private a nKn;
    private int topMargin;

    public c(BubbleGroupActivity bubbleGroupActivity, com.baidu.tieba.themeCenter.bubble.all.a aVar) {
        this.topMargin = 0;
        this.nKk = bubbleGroupActivity;
        this.topMargin = l.getDimens(bubbleGroupActivity.getPageContext().getPageActivity(), R.dimen.ds320);
        this.mRoot = LayoutInflater.from(this.nKk.getPageContext().getPageActivity()).inflate(R.layout.bubble_group, (ViewGroup) null);
        this.nKk.setContentView(this.mRoot);
        this.kaP = this.mRoot.findViewById(R.id.body_view);
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(R.string.editor_privilege);
        this.nJj = (MemberRecommendView) this.mRoot.findViewById(R.id.view_member_recommend);
        this.nJj.setFromType(6);
        this.Yj = (BdListView) this.mRoot.findViewById(R.id.listview_group);
        this.nIF = new TextView(this.nKk.getActivity());
        this.nIF.setHeight(l.getDimens(this.nKk.getActivity(), R.dimen.ds104));
        this.nJk = (TextView) LayoutInflater.from(this.nKk.getPageContext().getPageActivity()).inflate(R.layout.look_more_view, (ViewGroup) null);
        this.nJk.setText(R.string.more_bubble);
        this.nJk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.themeCenter.bubble.group.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log("c10283");
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BubbleListActivityConfig(c.this.nKk.getActivity())));
            }
        });
        this.nKn = new a(this.nKk.getPageContext(), aVar);
        TextView textView = new TextView(this.nKk.getActivity());
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.getDimens(this.nKk.getActivity(), R.dimen.ds98)));
        this.Yj.addHeaderView(textView, 0);
        this.Yj.addFooterView(this.nJk);
        this.Yj.setAdapter((ListAdapter) this.nKn);
    }

    public void a(e eVar, List<b> list, boolean z) {
        if (list == null || list.size() <= 0) {
            cAU();
            return;
        }
        cAV();
        if (b(eVar)) {
            this.Yj.removeHeaderView(this.nIF);
            this.Yj.addHeaderView(this.nIF);
        } else {
            this.Yj.removeHeaderView(this.nIF);
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
            this.Yj.setVisibility(8);
            return;
        }
        this.Yj.setVisibility(0);
        this.nKn.setData(list);
        this.nKn.notifyDataSetChanged();
    }

    private boolean b(e eVar) {
        if (eVar == null || StringUtils.isNull(eVar.dRF())) {
            this.nJj.setVisibility(8);
            return false;
        }
        this.nJj.setVisibility(0);
        this.nJj.a(eVar);
        return true;
    }

    public void cAU() {
        this.kaP.setVisibility(8);
        ap.setBackgroundColor(this.mRoot, R.color.CAM_X0201);
        String string = this.nKk.getPageContext().getResources().getString(R.string.no_data_text);
        this.nKk.setNetRefreshViewTopMargin(this.topMargin);
        this.nKk.showNetRefreshView(this.mRoot, string, false);
    }

    public void cAV() {
        ap.setBackgroundColor(this.mRoot, R.color.CAM_X0204);
        this.nKk.hideNetRefreshView(this.mRoot);
        this.kaP.setVisibility(0);
    }

    public void cON() {
        this.kaP.setVisibility(8);
    }

    public void cOO() {
        this.kaP.setVisibility(0);
    }

    public void bzq() {
        com.baidu.tbadk.r.a.a(this.nKk.getPageContext(), this.mRoot);
        com.baidu.tbadk.r.a.a(this.nKk.getPageContext(), this.nJk);
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.nKk.getPageContext(), TbadkApplication.getInst().getSkinType());
        }
        if (this.Yj != null && this.Yj.getVisibility() == 0 && this.nKn != null) {
            this.nKn.notifyDataSetChanged();
        }
        ap.setBackgroundColor(this.nIF, R.color.CAM_X0204);
    }

    public View getRootView() {
        return this.mRoot;
    }
}
