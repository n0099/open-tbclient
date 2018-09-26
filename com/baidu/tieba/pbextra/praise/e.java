package com.baidu.tieba.pbextra.praise;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.e;
import java.util.List;
/* loaded from: classes3.dex */
public class e extends com.baidu.adp.base.c<PraiseListActivity> {
    private c fZS;
    private PraiseListActivity fZT;
    private View fZU;
    private NavigationBar fZV;
    private View fZW;
    private NoDataView fZX;
    private View fZY;
    private TextView fZZ;
    private BdListView gaa;
    private View gab;
    private TextView gac;
    private TextView gad;
    private ProgressBar gae;
    private ProgressBar gaf;

    public e(PraiseListActivity praiseListActivity, String str) {
        super(praiseListActivity.getPageContext());
        this.fZS = null;
        this.fZT = null;
        this.fZU = null;
        this.fZV = null;
        this.fZW = null;
        this.fZX = null;
        this.fZY = null;
        this.fZZ = null;
        this.gaa = null;
        this.gab = null;
        this.gac = null;
        this.gad = null;
        this.gae = null;
        this.gaf = null;
        this.fZT = praiseListActivity;
        praiseListActivity.setContentView(e.h.zan_list_activity);
        this.fZU = praiseListActivity.findViewById(e.g.zan_list_page_parent);
        this.fZV = (NavigationBar) praiseListActivity.findViewById(e.g.zan_list_page_navigationbar);
        this.fZW = praiseListActivity.findViewById(e.g.zan_list_page_frame);
        this.fZX = NoDataViewFactory.a(this.fZT.getPageContext().getContext(), this.fZU, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.h(this.fZT.getActivity(), e.C0141e.ds320)), NoDataViewFactory.d.dE(e.j.praise_list_no_data), null);
        this.gaa = (BdListView) praiseListActivity.findViewById(e.g.zan_list_page_list);
        TextView textView = new TextView(this.fZT.getActivity());
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)));
        this.gaa.addHeaderView(textView, 0);
        this.gae = (ProgressBar) praiseListActivity.findViewById(e.g.zan_list_page_progress);
        this.fZS = new c(praiseListActivity);
        this.gaa.setAdapter((ListAdapter) this.fZS);
        this.gaa.setOnScrollListener(this.fZS);
        this.fZV.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.fZV.setTitleText("");
        this.fZY = LayoutInflater.from(praiseListActivity.getPageContext().getContext()).inflate(e.h.zan_list_head, (ViewGroup) null);
        this.fZY.setOnClickListener(praiseListActivity);
        this.fZZ = (TextView) this.fZY.findViewById(e.g.zan_list_head_text);
        this.fZZ.setText(str);
        this.fZY.setVisibility(8);
        this.gaa.addHeaderView(this.fZY);
        this.gab = LayoutInflater.from(praiseListActivity.getPageContext().getContext()).inflate(e.h.zan_list_foot, (ViewGroup) null);
        this.gac = (TextView) this.gab.findViewById(e.g.zan_list_foot_text_continue);
        this.gad = (TextView) this.gab.findViewById(e.g.zan_list_foot_text_more);
        this.gaf = (ProgressBar) this.gab.findViewById(e.g.zan_list_foot_progress);
        this.gab.setVisibility(8);
        this.gac.setOnClickListener(praiseListActivity);
        this.gaa.addFooterView(this.gab);
        this.gaa.setOnItemClickListener(praiseListActivity);
    }

    public void aMS() {
        if (this.fZS != null) {
            this.fZS.notifyDataSetChanged();
        }
    }

    public void lp(boolean z) {
        if (z) {
            this.gaf.setVisibility(0);
        } else {
            this.gae.setVisibility(0);
        }
    }

    public void bjP() {
        this.gae.setVisibility(8);
        this.gaf.setVisibility(8);
    }

    public boolean BO() {
        return this.gae.getVisibility() == 0 || this.gaf.getVisibility() == 0;
    }

    public void b(int i, List<a> list, int i2, int i3) {
        String format;
        String format2;
        this.gae.setVisibility(8);
        this.gaf.setVisibility(8);
        this.fZY.setVisibility(0);
        if (i > 0) {
            switch (this.fZT.pageType) {
                case 1:
                    format2 = String.format(this.fZT.getResources().getString(e.j.graffiti_list_title_count), ao.L(i));
                    break;
                default:
                    format2 = String.format(this.fZT.getResources().getString(e.j.praise_list_title_count), ao.L(i));
                    break;
            }
            this.fZV.setTitleText(format2);
        } else {
            this.fZV.setTitleText("");
        }
        if (list == null || list.size() < 1) {
            aH(null, this.fZT.pageType);
            return;
        }
        this.fZW.setVisibility(0);
        this.fZX.setVisibility(8);
        this.fZS.da(list);
        this.fZS.notifyDataSetChanged();
        switch (i2) {
            case 1001:
                this.gab.setVisibility(0);
                this.gac.setVisibility(0);
                this.gad.setVisibility(8);
                return;
            case 1002:
                this.gab.setVisibility(8);
                return;
            case 1003:
                this.gab.setVisibility(0);
                al.i(this.gab, e.f.bg_pack);
                this.gac.setVisibility(8);
                this.gad.setVisibility(0);
                switch (this.fZT.pageType) {
                    case 1:
                        format = String.format(this.fZT.getResources().getString(e.j.graffiti_list_title_count), ao.L(i));
                        break;
                    default:
                        format = String.format(this.fZT.getResources().getString(e.j.praise_item_more), ao.L(i));
                        break;
                }
                this.gad.setText(format);
                return;
            default:
                this.gab.setVisibility(8);
                return;
        }
    }

    public void aH(String str, int i) {
        this.gae.setVisibility(8);
        this.gaf.setVisibility(8);
        this.fZW.setVisibility(8);
        this.fZX.setVisibility(0);
        if (!StringUtils.isNull(str)) {
            this.fZX.setTextOption(NoDataViewFactory.d.fG(str));
        } else if (1 == i) {
            this.fZX.setTextOption(NoDataViewFactory.d.dE(e.j.graffiti_list_no_data));
        } else {
            this.fZX.setTextOption(NoDataViewFactory.d.dE(e.j.praise_list_no_data));
        }
    }

    public void a(com.baidu.tbadk.core.c cVar, int i) {
        if (cVar != null) {
            cVar.setNightMode(i == 1);
            cVar.onModeChanged(this.fZU);
            cVar.onModeChanged(this.fZY);
            cVar.onModeChanged(this.gab);
            this.fZV.onChangeSkinType(this.fZT.getPageContext(), i);
            al.i(this.gab, e.f.bg_pack);
            if (this.fZX != null) {
                this.fZX.onChangeSkinType(this.fZT.getPageContext(), i);
            }
        }
    }

    public View bjQ() {
        return this.fZY;
    }

    public View bjR() {
        return this.gac;
    }
}
