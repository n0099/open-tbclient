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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.d;
import java.util.List;
/* loaded from: classes4.dex */
public class e extends com.baidu.adp.base.c<PraiseListActivity> {
    private c hJA;
    private PraiseListActivity hJB;
    private View hJC;
    private NavigationBar hJD;
    private View hJE;
    private NoDataView hJF;
    private View hJG;
    private TextView hJH;
    private BdListView hJI;
    private View hJJ;
    private TextView hJK;
    private TextView hJL;
    private ProgressBar hJM;
    private ProgressBar hJN;

    public e(PraiseListActivity praiseListActivity, String str) {
        super(praiseListActivity.getPageContext());
        this.hJA = null;
        this.hJB = null;
        this.hJC = null;
        this.hJD = null;
        this.hJE = null;
        this.hJF = null;
        this.hJG = null;
        this.hJH = null;
        this.hJI = null;
        this.hJJ = null;
        this.hJK = null;
        this.hJL = null;
        this.hJM = null;
        this.hJN = null;
        this.hJB = praiseListActivity;
        praiseListActivity.setContentView(d.h.zan_list_activity);
        this.hJC = praiseListActivity.findViewById(d.g.zan_list_page_parent);
        this.hJD = (NavigationBar) praiseListActivity.findViewById(d.g.zan_list_page_navigationbar);
        this.hJE = praiseListActivity.findViewById(d.g.zan_list_page_frame);
        this.hJF = NoDataViewFactory.a(this.hJB.getPageContext().getContext(), this.hJC, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.h(this.hJB.getActivity(), d.e.ds320)), NoDataViewFactory.d.hT(d.j.praise_list_no_data), null);
        this.hJI = (BdListView) praiseListActivity.findViewById(d.g.zan_list_page_list);
        TextView textView = new TextView(this.hJB.getActivity());
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)));
        this.hJI.addHeaderView(textView, 0);
        this.hJM = (ProgressBar) praiseListActivity.findViewById(d.g.zan_list_page_progress);
        this.hJA = new c(praiseListActivity);
        this.hJI.setAdapter((ListAdapter) this.hJA);
        this.hJI.setOnScrollListener(this.hJA);
        this.hJD.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.hJD.setTitleText("");
        this.hJG = LayoutInflater.from(praiseListActivity.getPageContext().getContext()).inflate(d.h.zan_list_head, (ViewGroup) null);
        this.hJG.setOnClickListener(praiseListActivity);
        this.hJH = (TextView) this.hJG.findViewById(d.g.zan_list_head_text);
        this.hJH.setText(str);
        this.hJG.setVisibility(8);
        this.hJI.addHeaderView(this.hJG);
        this.hJJ = LayoutInflater.from(praiseListActivity.getPageContext().getContext()).inflate(d.h.zan_list_foot, (ViewGroup) null);
        this.hJK = (TextView) this.hJJ.findViewById(d.g.zan_list_foot_text_continue);
        this.hJL = (TextView) this.hJJ.findViewById(d.g.zan_list_foot_text_more);
        this.hJN = (ProgressBar) this.hJJ.findViewById(d.g.zan_list_foot_progress);
        this.hJJ.setVisibility(8);
        this.hJK.setOnClickListener(praiseListActivity);
        this.hJI.addFooterView(this.hJJ);
        this.hJI.setOnItemClickListener(praiseListActivity);
    }

    public void btl() {
        if (this.hJA != null) {
            this.hJA.notifyDataSetChanged();
        }
    }

    public void ou(boolean z) {
        if (z) {
            this.hJN.setVisibility(0);
        } else {
            this.hJM.setVisibility(0);
        }
    }

    public void bQc() {
        this.hJM.setVisibility(8);
        this.hJN.setVisibility(8);
    }

    public boolean qz() {
        return this.hJM.getVisibility() == 0 || this.hJN.getVisibility() == 0;
    }

    public void b(int i, List<a> list, int i2, int i3) {
        String format;
        String format2;
        this.hJM.setVisibility(8);
        this.hJN.setVisibility(8);
        this.hJG.setVisibility(0);
        if (i > 0) {
            switch (this.hJB.pageType) {
                case 1:
                    format2 = String.format(this.hJB.getResources().getString(d.j.graffiti_list_title_count), ap.az(i));
                    break;
                default:
                    format2 = String.format(this.hJB.getResources().getString(d.j.praise_list_title_count), ap.az(i));
                    break;
            }
            this.hJD.setTitleText(format2);
        } else {
            this.hJD.setTitleText("");
        }
        if (list == null || list.size() < 1) {
            bi(null, this.hJB.pageType);
            return;
        }
        this.hJE.setVisibility(0);
        this.hJF.setVisibility(8);
        this.hJA.dD(list);
        this.hJA.notifyDataSetChanged();
        switch (i2) {
            case 1001:
                this.hJJ.setVisibility(0);
                this.hJK.setVisibility(0);
                this.hJL.setVisibility(8);
                return;
            case 1002:
                this.hJJ.setVisibility(8);
                return;
            case 1003:
                this.hJJ.setVisibility(0);
                al.k(this.hJJ, d.f.bg_pack);
                this.hJK.setVisibility(8);
                this.hJL.setVisibility(0);
                switch (this.hJB.pageType) {
                    case 1:
                        format = String.format(this.hJB.getResources().getString(d.j.graffiti_list_title_count), ap.az(i));
                        break;
                    default:
                        format = String.format(this.hJB.getResources().getString(d.j.praise_item_more), ap.az(i));
                        break;
                }
                this.hJL.setText(format);
                return;
            default:
                this.hJJ.setVisibility(8);
                return;
        }
    }

    public void bi(String str, int i) {
        this.hJM.setVisibility(8);
        this.hJN.setVisibility(8);
        this.hJE.setVisibility(8);
        this.hJF.setVisibility(0);
        if (!StringUtils.isNull(str)) {
            this.hJF.setTextOption(NoDataViewFactory.d.np(str));
        } else if (1 == i) {
            this.hJF.setTextOption(NoDataViewFactory.d.hT(d.j.graffiti_list_no_data));
        } else {
            this.hJF.setTextOption(NoDataViewFactory.d.hT(d.j.praise_list_no_data));
        }
    }

    public void a(com.baidu.tbadk.core.c cVar, int i) {
        if (cVar != null) {
            cVar.setNightMode(i == 1);
            cVar.onModeChanged(this.hJC);
            cVar.onModeChanged(this.hJG);
            cVar.onModeChanged(this.hJJ);
            this.hJD.onChangeSkinType(this.hJB.getPageContext(), i);
            al.k(this.hJJ, d.f.bg_pack);
            if (this.hJF != null) {
                this.hJF.onChangeSkinType(this.hJB.getPageContext(), i);
            }
        }
    }

    public View bQd() {
        return this.hJG;
    }

    public View bQe() {
        return this.hJK;
    }
}
