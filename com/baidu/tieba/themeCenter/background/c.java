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
/* loaded from: classes9.dex */
public class c {
    private BdListView WO;
    private View jYN;
    private NavigationBar mNavigationBar;
    private View mRoot;
    private BackgroundGroupActivity nGX;
    private TextView nGz;
    private MemberRecommendView nHd;
    private TextView nHe;
    private a nHf;
    private int topMargin;

    public c(BackgroundGroupActivity backgroundGroupActivity, d dVar) {
        this.topMargin = 0;
        this.nGX = backgroundGroupActivity;
        this.topMargin = l.getDimens(backgroundGroupActivity.getPageContext().getPageActivity(), R.dimen.ds320);
        this.mRoot = LayoutInflater.from(this.nGX.getPageContext().getPageActivity()).inflate(R.layout.background_group, (ViewGroup) null);
        this.nGX.setContentView(this.mRoot);
        this.jYN = this.mRoot.findViewById(R.id.body_view);
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(R.string.personal_background);
        this.nHd = (MemberRecommendView) this.mRoot.findViewById(R.id.view_member_recommend);
        this.nHd.setFromType(4);
        this.WO = (BdListView) this.mRoot.findViewById(R.id.listview_bg_group);
        this.nGz = new TextView(this.nGX.getActivity());
        this.nGz.setHeight(l.getDimens(this.nGX.getActivity(), R.dimen.ds104));
        this.nHe = (TextView) LayoutInflater.from(this.nGX.getPageContext().getPageActivity()).inflate(R.layout.look_more_view, (ViewGroup) null);
        this.nHe.setText(R.string.more_backgrounds);
        this.nHe.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.themeCenter.background.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log("c10283");
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonalBackdropListActivityConfig(c.this.nGX.getActivity())));
            }
        });
        this.nHf = new a(this.nGX.getPageContext(), dVar);
        TextView textView = new TextView(this.nGX.getActivity());
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.getDimens(this.nGX.getActivity(), R.dimen.ds98)));
        this.WO.addHeaderView(textView, 0);
        this.WO.addFooterView(this.nHe);
        this.WO.setAdapter((ListAdapter) this.nHf);
    }

    public void a(com.baidu.tieba.themeCenter.dressCenter.e eVar, List<b> list, boolean z) {
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
            this.WO.setVisibility(8);
            return;
        }
        this.WO.setVisibility(0);
        this.nHf.setData(list);
        this.nHf.notifyDataSetChanged();
    }

    private boolean b(com.baidu.tieba.themeCenter.dressCenter.e eVar) {
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
        String string = this.nGX.getPageContext().getResources().getString(R.string.no_data_text);
        this.nGX.setNetRefreshViewTopMargin(this.topMargin);
        this.nGX.showNetRefreshView(this.mRoot, string, false);
    }

    public void cAP() {
        ap.setBackgroundColor(this.mRoot, R.color.CAM_X0204);
        this.nGX.hideNetRefreshView(this.mRoot);
        this.jYN.setVisibility(0);
    }

    public void cOG() {
        this.jYN.setVisibility(8);
    }

    public void cOH() {
        this.jYN.setVisibility(0);
    }

    public void bzn() {
        com.baidu.tbadk.r.a.a(this.nGX.getPageContext(), this.mRoot);
        this.nGX.getLayoutMode().onModeChanged(this.nHe);
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.nGX.getPageContext(), TbadkApplication.getInst().getSkinType());
        }
        if (this.WO != null && this.WO.getVisibility() == 0 && this.nHf != null) {
            this.nHf.notifyDataSetChanged();
        }
        ap.setBackgroundColor(this.nGz, R.color.CAM_X0204);
    }

    public View getRootView() {
        return this.mRoot;
    }
}
