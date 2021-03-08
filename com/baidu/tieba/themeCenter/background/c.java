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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.tieba.themeCenter.MemberRecommendView;
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
    private BackgroundGroupActivity nJd;
    private MemberRecommendView nJj;
    private TextView nJk;
    private a nJl;
    private int topMargin;

    public c(BackgroundGroupActivity backgroundGroupActivity, d dVar) {
        this.topMargin = 0;
        this.nJd = backgroundGroupActivity;
        this.topMargin = l.getDimens(backgroundGroupActivity.getPageContext().getPageActivity(), R.dimen.ds320);
        this.mRoot = LayoutInflater.from(this.nJd.getPageContext().getPageActivity()).inflate(R.layout.background_group, (ViewGroup) null);
        this.nJd.setContentView(this.mRoot);
        this.kaP = this.mRoot.findViewById(R.id.body_view);
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(R.string.personal_background);
        this.nJj = (MemberRecommendView) this.mRoot.findViewById(R.id.view_member_recommend);
        this.nJj.setFromType(4);
        this.Yj = (BdListView) this.mRoot.findViewById(R.id.listview_bg_group);
        this.nIF = new TextView(this.nJd.getActivity());
        this.nIF.setHeight(l.getDimens(this.nJd.getActivity(), R.dimen.ds104));
        this.nJk = (TextView) LayoutInflater.from(this.nJd.getPageContext().getPageActivity()).inflate(R.layout.look_more_view, (ViewGroup) null);
        this.nJk.setText(R.string.more_backgrounds);
        this.nJk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.themeCenter.background.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log("c10283");
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonalBackdropListActivityConfig(c.this.nJd.getActivity())));
            }
        });
        this.nJl = new a(this.nJd.getPageContext(), dVar);
        TextView textView = new TextView(this.nJd.getActivity());
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.getDimens(this.nJd.getActivity(), R.dimen.ds98)));
        this.Yj.addHeaderView(textView, 0);
        this.Yj.addFooterView(this.nJk);
        this.Yj.setAdapter((ListAdapter) this.nJl);
    }

    public void a(com.baidu.tieba.themeCenter.dressCenter.e eVar, List<b> list, boolean z) {
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

    private void fT(List<Object> list) {
        if (list == null || list.size() <= 0) {
            this.Yj.setVisibility(8);
            return;
        }
        this.Yj.setVisibility(0);
        this.nJl.setData(list);
        this.nJl.notifyDataSetChanged();
    }

    private boolean b(com.baidu.tieba.themeCenter.dressCenter.e eVar) {
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
        String string = this.nJd.getPageContext().getResources().getString(R.string.no_data_text);
        this.nJd.setNetRefreshViewTopMargin(this.topMargin);
        this.nJd.showNetRefreshView(this.mRoot, string, false);
    }

    public void cAV() {
        ap.setBackgroundColor(this.mRoot, R.color.CAM_X0204);
        this.nJd.hideNetRefreshView(this.mRoot);
        this.kaP.setVisibility(0);
    }

    public void cON() {
        this.kaP.setVisibility(8);
    }

    public void cOO() {
        this.kaP.setVisibility(0);
    }

    public void bzq() {
        com.baidu.tbadk.r.a.a(this.nJd.getPageContext(), this.mRoot);
        this.nJd.getLayoutMode().onModeChanged(this.nJk);
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.nJd.getPageContext(), TbadkApplication.getInst().getSkinType());
        }
        if (this.Yj != null && this.Yj.getVisibility() == 0 && this.nJl != null) {
            this.nJl.notifyDataSetChanged();
        }
        ap.setBackgroundColor(this.nIF, R.color.CAM_X0204);
    }

    public View getRootView() {
        return this.mRoot;
    }
}
