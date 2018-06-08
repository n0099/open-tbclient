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
import com.baidu.tieba.d;
import java.util.List;
/* loaded from: classes3.dex */
public class e extends com.baidu.adp.base.c<PraiseListActivity> {
    private View fOA;
    private NoDataView fOB;
    private View fOC;
    private TextView fOD;
    private BdListView fOE;
    private View fOF;
    private TextView fOG;
    private TextView fOH;
    private ProgressBar fOI;
    private ProgressBar fOJ;
    private c fOw;
    private PraiseListActivity fOx;
    private View fOy;
    private NavigationBar fOz;

    public e(PraiseListActivity praiseListActivity, String str) {
        super(praiseListActivity.getPageContext());
        this.fOw = null;
        this.fOx = null;
        this.fOy = null;
        this.fOz = null;
        this.fOA = null;
        this.fOB = null;
        this.fOC = null;
        this.fOD = null;
        this.fOE = null;
        this.fOF = null;
        this.fOG = null;
        this.fOH = null;
        this.fOI = null;
        this.fOJ = null;
        this.fOx = praiseListActivity;
        praiseListActivity.setContentView(d.i.zan_list_activity);
        this.fOy = praiseListActivity.findViewById(d.g.zan_list_page_parent);
        this.fOz = (NavigationBar) praiseListActivity.findViewById(d.g.zan_list_page_navigationbar);
        this.fOA = praiseListActivity.findViewById(d.g.zan_list_page_frame);
        this.fOB = NoDataViewFactory.a(this.fOx.getPageContext().getContext(), this.fOy, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.e(this.fOx.getActivity(), d.e.ds320)), NoDataViewFactory.d.dr(d.k.praise_list_no_data), null);
        this.fOE = (BdListView) praiseListActivity.findViewById(d.g.zan_list_page_list);
        TextView textView = new TextView(this.fOx.getActivity());
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)));
        this.fOE.addHeaderView(textView, 0);
        this.fOI = (ProgressBar) praiseListActivity.findViewById(d.g.zan_list_page_progress);
        this.fOw = new c(praiseListActivity);
        this.fOE.setAdapter((ListAdapter) this.fOw);
        this.fOE.setOnScrollListener(this.fOw);
        this.fOz.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.fOz.setTitleText("");
        this.fOC = LayoutInflater.from(praiseListActivity.getPageContext().getContext()).inflate(d.i.zan_list_head, (ViewGroup) null);
        this.fOC.setOnClickListener(praiseListActivity);
        this.fOD = (TextView) this.fOC.findViewById(d.g.zan_list_head_text);
        this.fOD.setText(str);
        this.fOC.setVisibility(8);
        this.fOE.addHeaderView(this.fOC);
        this.fOF = LayoutInflater.from(praiseListActivity.getPageContext().getContext()).inflate(d.i.zan_list_foot, (ViewGroup) null);
        this.fOG = (TextView) this.fOF.findViewById(d.g.zan_list_foot_text_continue);
        this.fOH = (TextView) this.fOF.findViewById(d.g.zan_list_foot_text_more);
        this.fOJ = (ProgressBar) this.fOF.findViewById(d.g.zan_list_foot_progress);
        this.fOF.setVisibility(8);
        this.fOG.setOnClickListener(praiseListActivity);
        this.fOE.addFooterView(this.fOF);
        this.fOE.setOnItemClickListener(praiseListActivity);
    }

    public void aIY() {
        if (this.fOw != null) {
            this.fOw.notifyDataSetChanged();
        }
    }

    public void kX(boolean z) {
        if (z) {
            this.fOJ.setVisibility(0);
        } else {
            this.fOI.setVisibility(0);
        }
    }

    public void biu() {
        this.fOI.setVisibility(8);
        this.fOJ.setVisibility(8);
    }

    public boolean Ax() {
        return this.fOI.getVisibility() == 0 || this.fOJ.getVisibility() == 0;
    }

    public void b(int i, List<a> list, int i2, int i3) {
        String format;
        String format2;
        this.fOI.setVisibility(8);
        this.fOJ.setVisibility(8);
        this.fOC.setVisibility(0);
        if (i > 0) {
            switch (this.fOx.pageType) {
                case 1:
                    format2 = String.format(this.fOx.getResources().getString(d.k.graffiti_list_title_count), ao.E(i));
                    break;
                default:
                    format2 = String.format(this.fOx.getResources().getString(d.k.praise_list_title_count), ao.E(i));
                    break;
            }
            this.fOz.setTitleText(format2);
        } else {
            this.fOz.setTitleText("");
        }
        if (list == null || list.size() < 1) {
            aF(null, this.fOx.pageType);
            return;
        }
        this.fOA.setVisibility(0);
        this.fOB.setVisibility(8);
        this.fOw.cZ(list);
        this.fOw.notifyDataSetChanged();
        switch (i2) {
            case 1001:
                this.fOF.setVisibility(0);
                this.fOG.setVisibility(0);
                this.fOH.setVisibility(8);
                return;
            case 1002:
                this.fOF.setVisibility(8);
                return;
            case 1003:
                this.fOF.setVisibility(0);
                al.i(this.fOF, d.f.bg_pack);
                this.fOG.setVisibility(8);
                this.fOH.setVisibility(0);
                switch (this.fOx.pageType) {
                    case 1:
                        format = String.format(this.fOx.getResources().getString(d.k.graffiti_list_title_count), ao.E(i));
                        break;
                    default:
                        format = String.format(this.fOx.getResources().getString(d.k.praise_item_more), ao.E(i));
                        break;
                }
                this.fOH.setText(format);
                return;
            default:
                this.fOF.setVisibility(8);
                return;
        }
    }

    public void aF(String str, int i) {
        this.fOI.setVisibility(8);
        this.fOJ.setVisibility(8);
        this.fOA.setVisibility(8);
        this.fOB.setVisibility(0);
        if (!StringUtils.isNull(str)) {
            this.fOB.setTextOption(NoDataViewFactory.d.fk(str));
        } else if (1 == i) {
            this.fOB.setTextOption(NoDataViewFactory.d.dr(d.k.graffiti_list_no_data));
        } else {
            this.fOB.setTextOption(NoDataViewFactory.d.dr(d.k.praise_list_no_data));
        }
    }

    public void a(com.baidu.tbadk.core.c cVar, int i) {
        if (cVar != null) {
            cVar.setNightMode(i == 1);
            cVar.onModeChanged(this.fOy);
            cVar.onModeChanged(this.fOC);
            cVar.onModeChanged(this.fOF);
            this.fOz.onChangeSkinType(this.fOx.getPageContext(), i);
            al.i(this.fOF, d.f.bg_pack);
            if (this.fOB != null) {
                this.fOB.onChangeSkinType(this.fOx.getPageContext(), i);
            }
        }
    }

    public View biv() {
        return this.fOC;
    }

    public View biw() {
        return this.fOG;
    }
}
