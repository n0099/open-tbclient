package com.baidu.tieba.pb.pb.praise;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.location.BDLocationStatusCodes;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.o;
import com.baidu.tieba.t;
import java.util.List;
/* loaded from: classes.dex */
public class f extends com.baidu.adp.base.f<PraiseListActivity> {
    private c cTl;
    private PraiseListActivity cTm;
    private View cTn;
    private NavigationBar cTo;
    private View cTp;
    private o cTq;
    private View cTr;
    private TextView cTs;
    private BdListView cTt;
    private View cTu;
    private TextView cTv;
    private TextView cTw;
    private ProgressBar cTx;
    private ProgressBar cTy;

    public f(PraiseListActivity praiseListActivity, String str) {
        super(praiseListActivity.getPageContext());
        this.cTl = null;
        this.cTm = null;
        this.cTn = null;
        this.cTo = null;
        this.cTp = null;
        this.cTq = null;
        this.cTr = null;
        this.cTs = null;
        this.cTt = null;
        this.cTu = null;
        this.cTv = null;
        this.cTw = null;
        this.cTx = null;
        this.cTy = null;
        this.cTm = praiseListActivity;
        praiseListActivity.setContentView(t.h.zan_list_activity);
        this.cTn = praiseListActivity.findViewById(t.g.zan_list_page_parent);
        this.cTo = (NavigationBar) praiseListActivity.findViewById(t.g.zan_list_page_navigationbar);
        this.cTp = praiseListActivity.findViewById(t.g.zan_list_page_frame);
        this.cTq = NoDataViewFactory.a(this.cTm.getPageContext().getContext(), this.cTn, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.dd(t.j.praise_list_no_data), null);
        this.cTt = (BdListView) praiseListActivity.findViewById(t.g.zan_list_page_list);
        this.cTx = (ProgressBar) praiseListActivity.findViewById(t.g.zan_list_page_progress);
        this.cTl = new c(praiseListActivity);
        this.cTt.setAdapter((ListAdapter) this.cTl);
        this.cTt.setOnScrollListener(this.cTl);
        this.cTo.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.cTo.setTitleText("");
        this.cTr = LayoutInflater.from(praiseListActivity.getPageContext().getContext()).inflate(t.h.zan_list_head, (ViewGroup) null);
        this.cTr.setOnClickListener(praiseListActivity);
        this.cTs = (TextView) this.cTr.findViewById(t.g.zan_list_head_text);
        this.cTs.setText(str);
        this.cTt.addHeaderView(this.cTr);
        this.cTu = LayoutInflater.from(praiseListActivity.getPageContext().getContext()).inflate(t.h.zan_list_foot, (ViewGroup) null);
        this.cTv = (TextView) this.cTu.findViewById(t.g.zan_list_foot_text_continue);
        this.cTw = (TextView) this.cTu.findViewById(t.g.zan_list_foot_text_more);
        this.cTy = (ProgressBar) this.cTu.findViewById(t.g.zan_list_foot_progress);
        this.cTv.setOnClickListener(praiseListActivity);
        this.cTt.addFooterView(this.cTu);
        this.cTt.setOnItemClickListener(praiseListActivity);
    }

    public void abR() {
        if (this.cTl != null) {
            this.cTl.notifyDataSetChanged();
        }
    }

    public void fM(boolean z) {
        if (z) {
            this.cTy.setVisibility(0);
        } else {
            this.cTx.setVisibility(0);
        }
    }

    public void arV() {
        this.cTx.setVisibility(8);
        this.cTy.setVisibility(8);
    }

    public boolean isLoading() {
        return this.cTx.getVisibility() == 0 || this.cTy.getVisibility() == 0;
    }

    public void b(int i, List<a> list, int i2, int i3) {
        this.cTx.setVisibility(8);
        this.cTy.setVisibility(8);
        if (i > 0) {
            this.cTo.setTitleText(String.format(this.cTm.getResources().getString(t.j.praise_list_title_count), Integer.valueOf(i)));
        } else {
            this.cTo.setTitleText("");
        }
        if (list == null || list.size() < 1) {
            Ri();
            return;
        }
        this.cTp.setVisibility(0);
        this.cTq.setVisibility(8);
        this.cTl.bn(list);
        this.cTl.notifyDataSetChanged();
        switch (i2) {
            case BDLocationStatusCodes.GEOFENCE_TOO_MANY_GEOFENCES /* 1001 */:
                this.cTu.setVisibility(0);
                this.cTv.setVisibility(0);
                this.cTw.setVisibility(8);
                return;
            case BDLocationStatusCodes.GEOFENCE_SERVICE_NO_ALIVIABLE /* 1002 */:
                this.cTu.setVisibility(8);
                return;
            case 1003:
                this.cTu.setVisibility(0);
                TbadkCoreApplication.m411getInst().getSkinType();
                ar.k(this.cTu, t.f.bg_pack);
                this.cTv.setVisibility(8);
                this.cTw.setVisibility(0);
                this.cTw.setText(String.format(this.cTm.getResources().getString(t.j.praise_item_more), Integer.valueOf(i3)));
                return;
            default:
                this.cTu.setVisibility(8);
                return;
        }
    }

    public void Ri() {
        this.cTx.setVisibility(8);
        this.cTy.setVisibility(8);
        this.cTp.setVisibility(8);
        this.cTq.setVisibility(0);
    }

    public void a(com.baidu.tbadk.core.c cVar, int i) {
        if (cVar != null) {
            cVar.ac(i == 1);
            cVar.x(this.cTn);
            cVar.x(this.cTr);
            cVar.x(this.cTu);
            this.cTo.onChangeSkinType(this.cTm.getPageContext(), i);
            ar.k(this.cTu, t.f.bg_pack);
            if (this.cTq != null) {
                this.cTq.onChangeSkinType(this.cTm.getPageContext(), i);
            }
        }
    }

    public View arW() {
        return this.cTr;
    }

    public View arX() {
        return this.cTv;
    }
}
