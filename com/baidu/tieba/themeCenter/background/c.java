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
/* loaded from: classes9.dex */
public class c {
    private BdListView WV;
    private int aht;
    private View jVC;
    private NavigationBar mNavigationBar;
    private View mRoot;
    private TextView nAT;
    private BackgroundGroupActivity nBr;
    private MemberRecommendView nBx;
    private TextView nBy;
    private a nBz;

    public c(BackgroundGroupActivity backgroundGroupActivity, d dVar) {
        this.aht = 0;
        this.nBr = backgroundGroupActivity;
        this.aht = l.getDimens(backgroundGroupActivity.getPageContext().getPageActivity(), R.dimen.ds320);
        this.mRoot = LayoutInflater.from(this.nBr.getPageContext().getPageActivity()).inflate(R.layout.background_group, (ViewGroup) null);
        this.nBr.setContentView(this.mRoot);
        this.jVC = this.mRoot.findViewById(R.id.body_view);
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(R.string.personal_background);
        this.nBx = (MemberRecommendView) this.mRoot.findViewById(R.id.view_member_recommend);
        this.nBx.setFromType(4);
        this.WV = (BdListView) this.mRoot.findViewById(R.id.listview_bg_group);
        this.nAT = new TextView(this.nBr.getActivity());
        this.nAT.setHeight(l.getDimens(this.nBr.getActivity(), R.dimen.ds104));
        this.nBy = (TextView) LayoutInflater.from(this.nBr.getPageContext().getPageActivity()).inflate(R.layout.look_more_view, (ViewGroup) null);
        this.nBy.setText(R.string.more_backgrounds);
        this.nBy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.themeCenter.background.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log("c10283");
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonalBackdropListActivityConfig(c.this.nBr.getActivity())));
            }
        });
        this.nBz = new a(this.nBr.getPageContext(), dVar);
        TextView textView = new TextView(this.nBr.getActivity());
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.getDimens(this.nBr.getActivity(), R.dimen.ds98)));
        this.WV.addHeaderView(textView, 0);
        this.WV.addFooterView(this.nBy);
        this.WV.setAdapter((ListAdapter) this.nBz);
    }

    public void a(com.baidu.tieba.themeCenter.dressCenter.e eVar, List<b> list, boolean z) {
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
            this.WV.setVisibility(8);
            return;
        }
        this.WV.setVisibility(0);
        this.nBz.setData(list);
        this.nBz.notifyDataSetChanged();
    }

    private boolean b(com.baidu.tieba.themeCenter.dressCenter.e eVar) {
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
        String string = this.nBr.getPageContext().getResources().getString(R.string.no_data_text);
        this.nBr.setNetRefreshViewTopMargin(this.aht);
        this.nBr.showNetRefreshView(this.mRoot, string, false);
    }

    public void cDp() {
        ao.setBackgroundColor(this.mRoot, R.color.CAM_X0204);
        this.nBr.hideNetRefreshView(this.mRoot);
        this.jVC.setVisibility(0);
    }

    public void cQu() {
        this.jVC.setVisibility(8);
    }

    public void cQv() {
        this.jVC.setVisibility(0);
    }

    public void bCP() {
        com.baidu.tbadk.r.a.a(this.nBr.getPageContext(), this.mRoot);
        this.nBr.getLayoutMode().onModeChanged(this.nBy);
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.nBr.getPageContext(), TbadkApplication.getInst().getSkinType());
        }
        if (this.WV != null && this.WV.getVisibility() == 0 && this.nBz != null) {
            this.nBz.notifyDataSetChanged();
        }
        ao.setBackgroundColor(this.nAT, R.color.CAM_X0204);
    }

    public View getRootView() {
        return this.mRoot;
    }
}
