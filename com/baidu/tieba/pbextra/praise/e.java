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
    private PraiseListActivity hJA;
    private View hJB;
    private NavigationBar hJC;
    private View hJD;
    private NoDataView hJE;
    private View hJF;
    private TextView hJG;
    private BdListView hJH;
    private View hJI;
    private TextView hJJ;
    private TextView hJK;
    private ProgressBar hJL;
    private ProgressBar hJM;
    private c hJz;

    public e(PraiseListActivity praiseListActivity, String str) {
        super(praiseListActivity.getPageContext());
        this.hJz = null;
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
        this.hJA = praiseListActivity;
        praiseListActivity.setContentView(d.h.zan_list_activity);
        this.hJB = praiseListActivity.findViewById(d.g.zan_list_page_parent);
        this.hJC = (NavigationBar) praiseListActivity.findViewById(d.g.zan_list_page_navigationbar);
        this.hJD = praiseListActivity.findViewById(d.g.zan_list_page_frame);
        this.hJE = NoDataViewFactory.a(this.hJA.getPageContext().getContext(), this.hJB, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.h(this.hJA.getActivity(), d.e.ds320)), NoDataViewFactory.d.hT(d.j.praise_list_no_data), null);
        this.hJH = (BdListView) praiseListActivity.findViewById(d.g.zan_list_page_list);
        TextView textView = new TextView(this.hJA.getActivity());
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)));
        this.hJH.addHeaderView(textView, 0);
        this.hJL = (ProgressBar) praiseListActivity.findViewById(d.g.zan_list_page_progress);
        this.hJz = new c(praiseListActivity);
        this.hJH.setAdapter((ListAdapter) this.hJz);
        this.hJH.setOnScrollListener(this.hJz);
        this.hJC.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.hJC.setTitleText("");
        this.hJF = LayoutInflater.from(praiseListActivity.getPageContext().getContext()).inflate(d.h.zan_list_head, (ViewGroup) null);
        this.hJF.setOnClickListener(praiseListActivity);
        this.hJG = (TextView) this.hJF.findViewById(d.g.zan_list_head_text);
        this.hJG.setText(str);
        this.hJF.setVisibility(8);
        this.hJH.addHeaderView(this.hJF);
        this.hJI = LayoutInflater.from(praiseListActivity.getPageContext().getContext()).inflate(d.h.zan_list_foot, (ViewGroup) null);
        this.hJJ = (TextView) this.hJI.findViewById(d.g.zan_list_foot_text_continue);
        this.hJK = (TextView) this.hJI.findViewById(d.g.zan_list_foot_text_more);
        this.hJM = (ProgressBar) this.hJI.findViewById(d.g.zan_list_foot_progress);
        this.hJI.setVisibility(8);
        this.hJJ.setOnClickListener(praiseListActivity);
        this.hJH.addFooterView(this.hJI);
        this.hJH.setOnItemClickListener(praiseListActivity);
    }

    public void btl() {
        if (this.hJz != null) {
            this.hJz.notifyDataSetChanged();
        }
    }

    public void ou(boolean z) {
        if (z) {
            this.hJM.setVisibility(0);
        } else {
            this.hJL.setVisibility(0);
        }
    }

    public void bQc() {
        this.hJL.setVisibility(8);
        this.hJM.setVisibility(8);
    }

    public boolean qz() {
        return this.hJL.getVisibility() == 0 || this.hJM.getVisibility() == 0;
    }

    public void b(int i, List<a> list, int i2, int i3) {
        String format;
        String format2;
        this.hJL.setVisibility(8);
        this.hJM.setVisibility(8);
        this.hJF.setVisibility(0);
        if (i > 0) {
            switch (this.hJA.pageType) {
                case 1:
                    format2 = String.format(this.hJA.getResources().getString(d.j.graffiti_list_title_count), ap.az(i));
                    break;
                default:
                    format2 = String.format(this.hJA.getResources().getString(d.j.praise_list_title_count), ap.az(i));
                    break;
            }
            this.hJC.setTitleText(format2);
        } else {
            this.hJC.setTitleText("");
        }
        if (list == null || list.size() < 1) {
            bi(null, this.hJA.pageType);
            return;
        }
        this.hJD.setVisibility(0);
        this.hJE.setVisibility(8);
        this.hJz.dD(list);
        this.hJz.notifyDataSetChanged();
        switch (i2) {
            case 1001:
                this.hJI.setVisibility(0);
                this.hJJ.setVisibility(0);
                this.hJK.setVisibility(8);
                return;
            case 1002:
                this.hJI.setVisibility(8);
                return;
            case 1003:
                this.hJI.setVisibility(0);
                al.k(this.hJI, d.f.bg_pack);
                this.hJJ.setVisibility(8);
                this.hJK.setVisibility(0);
                switch (this.hJA.pageType) {
                    case 1:
                        format = String.format(this.hJA.getResources().getString(d.j.graffiti_list_title_count), ap.az(i));
                        break;
                    default:
                        format = String.format(this.hJA.getResources().getString(d.j.praise_item_more), ap.az(i));
                        break;
                }
                this.hJK.setText(format);
                return;
            default:
                this.hJI.setVisibility(8);
                return;
        }
    }

    public void bi(String str, int i) {
        this.hJL.setVisibility(8);
        this.hJM.setVisibility(8);
        this.hJD.setVisibility(8);
        this.hJE.setVisibility(0);
        if (!StringUtils.isNull(str)) {
            this.hJE.setTextOption(NoDataViewFactory.d.np(str));
        } else if (1 == i) {
            this.hJE.setTextOption(NoDataViewFactory.d.hT(d.j.graffiti_list_no_data));
        } else {
            this.hJE.setTextOption(NoDataViewFactory.d.hT(d.j.praise_list_no_data));
        }
    }

    public void a(com.baidu.tbadk.core.c cVar, int i) {
        if (cVar != null) {
            cVar.setNightMode(i == 1);
            cVar.onModeChanged(this.hJB);
            cVar.onModeChanged(this.hJF);
            cVar.onModeChanged(this.hJI);
            this.hJC.onChangeSkinType(this.hJA.getPageContext(), i);
            al.k(this.hJI, d.f.bg_pack);
            if (this.hJE != null) {
                this.hJE.onChangeSkinType(this.hJA.getPageContext(), i);
            }
        }
    }

    public View bQd() {
        return this.hJF;
    }

    public View bQe() {
        return this.hJJ;
    }
}
