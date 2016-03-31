package com.baidu.tieba.pb.pb.praise;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.location.BDLocationStatusCodes;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.p;
import com.baidu.tieba.t;
import java.util.List;
/* loaded from: classes.dex */
public class g extends com.baidu.adp.base.f<PraiseListActivity> {
    private c dog;
    private PraiseListActivity doh;
    private View doi;
    private NavigationBar doj;
    private View dok;
    private p dol;
    private View dom;
    private TextView don;
    private BdListView doo;
    private View dop;
    private TextView doq;
    private TextView dor;
    private ProgressBar dos;
    private ProgressBar dot;

    public g(PraiseListActivity praiseListActivity, String str) {
        super(praiseListActivity.getPageContext());
        this.dog = null;
        this.doh = null;
        this.doi = null;
        this.doj = null;
        this.dok = null;
        this.dol = null;
        this.dom = null;
        this.don = null;
        this.doo = null;
        this.dop = null;
        this.doq = null;
        this.dor = null;
        this.dos = null;
        this.dot = null;
        this.doh = praiseListActivity;
        praiseListActivity.setContentView(t.h.zan_list_activity);
        this.doi = praiseListActivity.findViewById(t.g.zan_list_page_parent);
        this.doj = (NavigationBar) praiseListActivity.findViewById(t.g.zan_list_page_navigationbar);
        this.dok = praiseListActivity.findViewById(t.g.zan_list_page_frame);
        this.dol = NoDataViewFactory.a(this.doh.getPageContext().getContext(), this.doi, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.dg(t.j.praise_list_no_data), null);
        this.doo = (BdListView) praiseListActivity.findViewById(t.g.zan_list_page_list);
        this.dos = (ProgressBar) praiseListActivity.findViewById(t.g.zan_list_page_progress);
        this.dog = new c(praiseListActivity);
        this.doo.setAdapter((ListAdapter) this.dog);
        this.doo.setOnScrollListener(this.dog);
        this.doj.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.doj.setTitleText("");
        this.dom = LayoutInflater.from(praiseListActivity.getPageContext().getContext()).inflate(t.h.zan_list_head, (ViewGroup) null);
        this.dom.setOnClickListener(praiseListActivity);
        this.don = (TextView) this.dom.findViewById(t.g.zan_list_head_text);
        this.don.setText(str);
        this.dom.setVisibility(8);
        this.doo.addHeaderView(this.dom);
        this.dop = LayoutInflater.from(praiseListActivity.getPageContext().getContext()).inflate(t.h.zan_list_foot, (ViewGroup) null);
        this.doq = (TextView) this.dop.findViewById(t.g.zan_list_foot_text_continue);
        this.dor = (TextView) this.dop.findViewById(t.g.zan_list_foot_text_more);
        this.dot = (ProgressBar) this.dop.findViewById(t.g.zan_list_foot_progress);
        this.dop.setVisibility(8);
        this.doq.setOnClickListener(praiseListActivity);
        this.doo.addFooterView(this.dop);
        this.doo.setOnItemClickListener(praiseListActivity);
    }

    public void afm() {
        if (this.dog != null) {
            this.dog.notifyDataSetChanged();
        }
    }

    public void gA(boolean z) {
        if (z) {
            this.dot.setVisibility(0);
        } else {
            this.dos.setVisibility(0);
        }
    }

    public void azG() {
        this.dos.setVisibility(8);
        this.dot.setVisibility(8);
    }

    public boolean isLoading() {
        return this.dos.getVisibility() == 0 || this.dot.getVisibility() == 0;
    }

    public void b(int i, List<a> list, int i2, int i3) {
        String format;
        String format2;
        this.dos.setVisibility(8);
        this.dot.setVisibility(8);
        this.dom.setVisibility(0);
        if (i > 0) {
            switch (this.doh.pageType) {
                case 1:
                    format2 = String.format(this.doh.getResources().getString(t.j.graffiti_list_title_count), ay.B(i));
                    break;
                default:
                    format2 = String.format(this.doh.getResources().getString(t.j.praise_list_title_count), ay.B(i));
                    break;
            }
            this.doj.setTitleText(format2);
        } else {
            this.doj.setTitleText("");
        }
        if (list == null || list.size() < 1) {
            an(null, this.doh.pageType);
            return;
        }
        this.dok.setVisibility(0);
        this.dol.setVisibility(8);
        this.dog.bJ(list);
        this.dog.notifyDataSetChanged();
        switch (i2) {
            case BDLocationStatusCodes.GEOFENCE_TOO_MANY_GEOFENCES /* 1001 */:
                this.dop.setVisibility(0);
                this.doq.setVisibility(0);
                this.dor.setVisibility(8);
                return;
            case BDLocationStatusCodes.GEOFENCE_SERVICE_NO_ALIVIABLE /* 1002 */:
                this.dop.setVisibility(8);
                return;
            case 1003:
                this.dop.setVisibility(0);
                at.k(this.dop, t.f.bg_pack);
                this.doq.setVisibility(8);
                this.dor.setVisibility(0);
                switch (this.doh.pageType) {
                    case 1:
                        format = String.format(this.doh.getResources().getString(t.j.graffiti_list_title_count), ay.B(i));
                        break;
                    default:
                        format = String.format(this.doh.getResources().getString(t.j.praise_item_more), ay.B(i));
                        break;
                }
                this.dor.setText(format);
                return;
            default:
                this.dop.setVisibility(8);
                return;
        }
    }

    public void an(String str, int i) {
        this.dos.setVisibility(8);
        this.dot.setVisibility(8);
        this.dok.setVisibility(8);
        this.dol.setVisibility(0);
        if (!StringUtils.isNull(str)) {
            this.dol.setTextOption(NoDataViewFactory.d.dS(str));
        } else if (1 == i) {
            this.dol.setTextOption(NoDataViewFactory.d.dg(t.j.graffiti_list_no_data));
        } else {
            this.dol.setTextOption(NoDataViewFactory.d.dg(t.j.praise_list_no_data));
        }
    }

    public void a(com.baidu.tbadk.core.c cVar, int i) {
        if (cVar != null) {
            cVar.ab(i == 1);
            cVar.x(this.doi);
            cVar.x(this.dom);
            cVar.x(this.dop);
            this.doj.onChangeSkinType(this.doh.getPageContext(), i);
            at.k(this.dop, t.f.bg_pack);
            if (this.dol != null) {
                this.dol.onChangeSkinType(this.doh.getPageContext(), i);
            }
        }
    }

    public View azH() {
        return this.dom;
    }

    public View azI() {
        return this.doq;
    }
}
