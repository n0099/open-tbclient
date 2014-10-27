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
    private View bzA;
    private NavigationBar bzB;
    private View bzC;
    private TextView bzD;
    private BdListView bzE;
    private View bzF;
    private TextView bzG;
    private TextView bzH;
    private ProgressBar bzI;
    private ProgressBar bzJ;
    private com.baidu.tbadk.mvc.i.c<a, com.baidu.tbadk.mvc.e.c, b> bzy;
    private PraiseListActivity bzz;

    public h(PraiseListActivity praiseListActivity) {
        super(praiseListActivity);
        this.bzy = null;
        this.bzz = null;
        this.bzA = null;
        this.bzB = null;
        this.bzC = null;
        this.bzD = null;
        this.bzE = null;
        this.bzF = null;
        this.bzG = null;
        this.bzH = null;
        this.bzI = null;
        this.bzJ = null;
        this.bzz = praiseListActivity;
        sY().addEventDelegate(this);
    }

    @Override // com.baidu.tbadk.mvc.core.c
    protected int th() {
        return w.zan_list_activity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.core.c
    public void tg() {
        this.bzA = getView().findViewById(v.zan_list_page_parent);
        this.bzB = (NavigationBar) getView().findViewById(v.zan_list_page_navigationbar);
        this.bzE = (BdListView) getView().findViewById(v.zan_list_page_list);
        this.bzI = (ProgressBar) getView().findViewById(v.zan_list_page_progress);
        this.bzy = new com.baidu.tbadk.mvc.i.c<>(this.Xf, b.class, w.zan_list_item, null);
        this.bzy.a(r.a(NoDataViewFactory.ImgType.NODATA), s.bL(y.praise_list_no_data), (q) null, (FrameLayout.LayoutParams) null);
        this.bzE.setAdapter((ListAdapter) this.bzy);
        this.bzB.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.bzB.setTitleText("");
        this.bzC = getLayoutInflater().inflate(w.zan_list_head, (ViewGroup) null);
        this.bzC.setOnClickListener(this.bzz);
        this.bzD = (TextView) this.bzC.findViewById(v.zan_list_head_text);
        this.bzE.addHeaderView(this.bzC);
        this.bzF = getLayoutInflater().inflate(w.zan_list_foot, (ViewGroup) null);
        this.bzG = (TextView) this.bzF.findViewById(v.zan_list_foot_text_continue);
        this.bzH = (TextView) this.bzF.findViewById(v.zan_list_foot_text_more);
        this.bzJ = (ProgressBar) this.bzF.findViewById(v.zan_list_foot_progress);
        sY().setViewClickListener(this.bzG, ua());
        this.bzF.setVisibility(8);
        this.bzE.addFooterView(this.bzF);
        this.bzE.setOnItemClickListener(this.bzz);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.core.c
    public void c(Bundle bundle) {
        super.c(bundle);
        this.bzD.setText(bundle.getString(com.baidu.tbadk.core.frameworkData.a.POST_DESC));
        tZ();
        em(false);
    }

    public void em(boolean z) {
        if (z) {
            this.bzJ.setVisibility(0);
        } else {
            this.bzI.setVisibility(0);
        }
    }

    public void YD() {
        this.bzI.setVisibility(8);
        this.bzJ.setVisibility(8);
    }

    @Override // com.baidu.tbadk.mvc.h.a
    protected void b(com.baidu.tbadk.mvc.b.a aVar) {
        if (aVar instanceof c) {
            c cVar = (c) aVar;
            int Yw = cVar.Yw();
            List<a> Yy = cVar.Yy();
            int Yw2 = cVar.Yw() - cVar.Yx();
            YD();
            if (Yw > 0) {
                this.bzB.setTitleText(String.format(this.bzz.getString(y.praise_list_title_count), Integer.valueOf(Yw)));
            } else {
                this.bzB.setTitleText("");
            }
            if (Yy == null || Yy.size() < 1) {
                this.bzy.r(new ArrayList());
                YE();
                return;
            }
            this.bzy.r(Yy);
            switch (cVar.getStatus()) {
                case 1001:
                    this.bzF.setVisibility(0);
                    this.bzG.setVisibility(0);
                    this.bzH.setVisibility(8);
                    return;
                case 1002:
                    this.bzF.setVisibility(8);
                    return;
                case 1003:
                    this.bzF.setVisibility(0);
                    aw.h(this.bzF, u.bg_pack);
                    this.bzG.setVisibility(8);
                    this.bzH.setVisibility(0);
                    this.bzH.setText(String.format(this.bzz.getString(y.praise_item_more), Integer.valueOf(Yw2)));
                    return;
                default:
                    this.bzF.setVisibility(8);
                    return;
            }
        }
    }

    public void YE() {
        this.bzI.setVisibility(8);
        this.bzJ.setVisibility(8);
        this.bzF.setVisibility(8);
    }

    @Override // com.baidu.tbadk.mvc.core.c, com.baidu.tbadk.e.a
    public boolean dg(int i) {
        super.dg(i);
        com.baidu.tbadk.e.b.u(this.bzA);
        com.baidu.tbadk.e.b.u(this.bzC);
        com.baidu.tbadk.e.b.u(this.bzF);
        this.bzB.onChangeSkinType(i);
        this.bzy.dg(i);
        aw.h(this.bzF, u.bg_pack);
        return true;
    }

    public View YF() {
        return this.bzC;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.core.c
    public void a(ErrorData errorData) {
        YD();
    }

    @Override // com.baidu.tbadk.mvc.h.a
    protected void uc() {
        YD();
    }

    @Override // com.baidu.tbadk.mvc.h.a
    protected void ub() {
        em(true);
    }
}
