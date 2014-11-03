package com.baidu.tieba.pb.praise;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.q;
import com.baidu.tbadk.core.view.r;
import com.baidu.tbadk.core.view.s;
import com.baidu.tieba.u;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
import com.baidu.tieba.y;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class h extends com.baidu.tbadk.mvc.h.a {
    private com.baidu.tbadk.mvc.i.c<a, com.baidu.tbadk.mvc.e.c, b> bzM;
    private PraiseListActivity bzN;
    private View bzO;
    private NavigationBar bzP;
    private View bzQ;
    private TextView bzR;
    private BdListView bzS;
    private View bzT;
    private TextView bzU;
    private TextView bzV;
    private ProgressBar bzW;
    private ProgressBar bzX;

    public h(PraiseListActivity praiseListActivity) {
        super(praiseListActivity);
        this.bzM = null;
        this.bzN = null;
        this.bzO = null;
        this.bzP = null;
        this.bzQ = null;
        this.bzR = null;
        this.bzS = null;
        this.bzT = null;
        this.bzU = null;
        this.bzV = null;
        this.bzW = null;
        this.bzX = null;
        this.bzN = praiseListActivity;
        ta().addEventDelegate(this);
    }

    @Override // com.baidu.tbadk.mvc.core.c
    protected int tj() {
        return w.zan_list_activity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.core.c
    public void ti() {
        this.bzO = getView().findViewById(v.zan_list_page_parent);
        this.bzP = (NavigationBar) getView().findViewById(v.zan_list_page_navigationbar);
        this.bzS = (BdListView) getView().findViewById(v.zan_list_page_list);
        this.bzW = (ProgressBar) getView().findViewById(v.zan_list_page_progress);
        this.bzM = new com.baidu.tbadk.mvc.i.c<>(this.Xj, b.class, w.zan_list_item, null);
        this.bzM.a(r.a(NoDataViewFactory.ImgType.NODATA), s.bL(y.praise_list_no_data), (q) null, (FrameLayout.LayoutParams) null);
        this.bzS.setAdapter((ListAdapter) this.bzM);
        this.bzP.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.bzP.setTitleText("");
        this.bzQ = getLayoutInflater().inflate(w.zan_list_head, (ViewGroup) null);
        this.bzQ.setOnClickListener(this.bzN);
        this.bzR = (TextView) this.bzQ.findViewById(v.zan_list_head_text);
        this.bzS.addHeaderView(this.bzQ);
        this.bzT = getLayoutInflater().inflate(w.zan_list_foot, (ViewGroup) null);
        this.bzU = (TextView) this.bzT.findViewById(v.zan_list_foot_text_continue);
        this.bzV = (TextView) this.bzT.findViewById(v.zan_list_foot_text_more);
        this.bzX = (ProgressBar) this.bzT.findViewById(v.zan_list_foot_progress);
        ta().setViewClickListener(this.bzU, uc());
        this.bzT.setVisibility(8);
        this.bzS.addFooterView(this.bzT);
        this.bzS.setOnItemClickListener(this.bzN);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.core.c
    public void c(Bundle bundle) {
        super.c(bundle);
        this.bzR.setText(bundle.getString(com.baidu.tbadk.core.frameworkData.a.POST_DESC));
        ub();
        em(false);
    }

    public void em(boolean z) {
        if (z) {
            this.bzX.setVisibility(0);
        } else {
            this.bzW.setVisibility(0);
        }
    }

    public void YG() {
        this.bzW.setVisibility(8);
        this.bzX.setVisibility(8);
    }

    @Override // com.baidu.tbadk.mvc.h.a
    protected void b(com.baidu.tbadk.mvc.b.a aVar) {
        if (aVar instanceof c) {
            c cVar = (c) aVar;
            int Yz = cVar.Yz();
            List<a> YB = cVar.YB();
            int Yz2 = cVar.Yz() - cVar.YA();
            YG();
            if (Yz > 0) {
                this.bzP.setTitleText(String.format(this.bzN.getString(y.praise_list_title_count), Integer.valueOf(Yz)));
            } else {
                this.bzP.setTitleText("");
            }
            if (YB == null || YB.size() < 1) {
                this.bzM.r(new ArrayList());
                YH();
                return;
            }
            this.bzM.r(YB);
            switch (cVar.getStatus()) {
                case 1001:
                    this.bzT.setVisibility(0);
                    this.bzU.setVisibility(0);
                    this.bzV.setVisibility(8);
                    return;
                case 1002:
                    this.bzT.setVisibility(8);
                    return;
                case 1003:
                    this.bzT.setVisibility(0);
                    aw.h(this.bzT, u.bg_pack);
                    this.bzU.setVisibility(8);
                    this.bzV.setVisibility(0);
                    this.bzV.setText(String.format(this.bzN.getString(y.praise_item_more), Integer.valueOf(Yz2)));
                    return;
                default:
                    this.bzT.setVisibility(8);
                    return;
            }
        }
    }

    public void YH() {
        this.bzW.setVisibility(8);
        this.bzX.setVisibility(8);
        this.bzT.setVisibility(8);
    }

    @Override // com.baidu.tbadk.mvc.core.c, com.baidu.tbadk.e.a
    public boolean dg(int i) {
        super.dg(i);
        com.baidu.tbadk.e.b.u(this.bzO);
        com.baidu.tbadk.e.b.u(this.bzQ);
        com.baidu.tbadk.e.b.u(this.bzT);
        this.bzP.onChangeSkinType(i);
        this.bzM.dg(i);
        aw.h(this.bzT, u.bg_pack);
        return true;
    }

    public View YI() {
        return this.bzQ;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.core.c
    public void a(ErrorData errorData) {
        YG();
    }

    @Override // com.baidu.tbadk.mvc.h.a
    protected void ue() {
        YG();
    }

    @Override // com.baidu.tbadk.mvc.h.a
    protected void ud() {
        em(true);
    }
}
