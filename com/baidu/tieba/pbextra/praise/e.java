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
    private c gtD;
    private PraiseListActivity gtE;
    private View gtF;
    private NavigationBar gtG;
    private View gtH;
    private NoDataView gtI;
    private View gtJ;
    private TextView gtK;
    private BdListView gtL;
    private View gtM;
    private TextView gtN;
    private TextView gtO;
    private ProgressBar gtP;
    private ProgressBar gtQ;

    public e(PraiseListActivity praiseListActivity, String str) {
        super(praiseListActivity.getPageContext());
        this.gtD = null;
        this.gtE = null;
        this.gtF = null;
        this.gtG = null;
        this.gtH = null;
        this.gtI = null;
        this.gtJ = null;
        this.gtK = null;
        this.gtL = null;
        this.gtM = null;
        this.gtN = null;
        this.gtO = null;
        this.gtP = null;
        this.gtQ = null;
        this.gtE = praiseListActivity;
        praiseListActivity.setContentView(e.h.zan_list_activity);
        this.gtF = praiseListActivity.findViewById(e.g.zan_list_page_parent);
        this.gtG = (NavigationBar) praiseListActivity.findViewById(e.g.zan_list_page_navigationbar);
        this.gtH = praiseListActivity.findViewById(e.g.zan_list_page_frame);
        this.gtI = NoDataViewFactory.a(this.gtE.getPageContext().getContext(), this.gtF, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.h(this.gtE.getActivity(), e.C0210e.ds320)), NoDataViewFactory.d.eq(e.j.praise_list_no_data), null);
        this.gtL = (BdListView) praiseListActivity.findViewById(e.g.zan_list_page_list);
        TextView textView = new TextView(this.gtE.getActivity());
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)));
        this.gtL.addHeaderView(textView, 0);
        this.gtP = (ProgressBar) praiseListActivity.findViewById(e.g.zan_list_page_progress);
        this.gtD = new c(praiseListActivity);
        this.gtL.setAdapter((ListAdapter) this.gtD);
        this.gtL.setOnScrollListener(this.gtD);
        this.gtG.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.gtG.setTitleText("");
        this.gtJ = LayoutInflater.from(praiseListActivity.getPageContext().getContext()).inflate(e.h.zan_list_head, (ViewGroup) null);
        this.gtJ.setOnClickListener(praiseListActivity);
        this.gtK = (TextView) this.gtJ.findViewById(e.g.zan_list_head_text);
        this.gtK.setText(str);
        this.gtJ.setVisibility(8);
        this.gtL.addHeaderView(this.gtJ);
        this.gtM = LayoutInflater.from(praiseListActivity.getPageContext().getContext()).inflate(e.h.zan_list_foot, (ViewGroup) null);
        this.gtN = (TextView) this.gtM.findViewById(e.g.zan_list_foot_text_continue);
        this.gtO = (TextView) this.gtM.findViewById(e.g.zan_list_foot_text_more);
        this.gtQ = (ProgressBar) this.gtM.findViewById(e.g.zan_list_foot_progress);
        this.gtM.setVisibility(8);
        this.gtN.setOnClickListener(praiseListActivity);
        this.gtL.addFooterView(this.gtM);
        this.gtL.setOnItemClickListener(praiseListActivity);
    }

    public void aSJ() {
        if (this.gtD != null) {
            this.gtD.notifyDataSetChanged();
        }
    }

    public void lX(boolean z) {
        if (z) {
            this.gtQ.setVisibility(0);
        } else {
            this.gtP.setVisibility(0);
        }
    }

    public void bpI() {
        this.gtP.setVisibility(8);
        this.gtQ.setVisibility(8);
    }

    public boolean Fv() {
        return this.gtP.getVisibility() == 0 || this.gtQ.getVisibility() == 0;
    }

    public void b(int i, List<a> list, int i2, int i3) {
        String format;
        String format2;
        this.gtP.setVisibility(8);
        this.gtQ.setVisibility(8);
        this.gtJ.setVisibility(0);
        if (i > 0) {
            switch (this.gtE.pageType) {
                case 1:
                    format2 = String.format(this.gtE.getResources().getString(e.j.graffiti_list_title_count), ao.X(i));
                    break;
                default:
                    format2 = String.format(this.gtE.getResources().getString(e.j.praise_list_title_count), ao.X(i));
                    break;
            }
            this.gtG.setTitleText(format2);
        } else {
            this.gtG.setTitleText("");
        }
        if (list == null || list.size() < 1) {
            aN(null, this.gtE.pageType);
            return;
        }
        this.gtH.setVisibility(0);
        this.gtI.setVisibility(8);
        this.gtD.ds(list);
        this.gtD.notifyDataSetChanged();
        switch (i2) {
            case 1001:
                this.gtM.setVisibility(0);
                this.gtN.setVisibility(0);
                this.gtO.setVisibility(8);
                return;
            case 1002:
                this.gtM.setVisibility(8);
                return;
            case 1003:
                this.gtM.setVisibility(0);
                al.i(this.gtM, e.f.bg_pack);
                this.gtN.setVisibility(8);
                this.gtO.setVisibility(0);
                switch (this.gtE.pageType) {
                    case 1:
                        format = String.format(this.gtE.getResources().getString(e.j.graffiti_list_title_count), ao.X(i));
                        break;
                    default:
                        format = String.format(this.gtE.getResources().getString(e.j.praise_item_more), ao.X(i));
                        break;
                }
                this.gtO.setText(format);
                return;
            default:
                this.gtM.setVisibility(8);
                return;
        }
    }

    public void aN(String str, int i) {
        this.gtP.setVisibility(8);
        this.gtQ.setVisibility(8);
        this.gtH.setVisibility(8);
        this.gtI.setVisibility(0);
        if (!StringUtils.isNull(str)) {
            this.gtI.setTextOption(NoDataViewFactory.d.gC(str));
        } else if (1 == i) {
            this.gtI.setTextOption(NoDataViewFactory.d.eq(e.j.graffiti_list_no_data));
        } else {
            this.gtI.setTextOption(NoDataViewFactory.d.eq(e.j.praise_list_no_data));
        }
    }

    public void a(com.baidu.tbadk.core.c cVar, int i) {
        if (cVar != null) {
            cVar.setNightMode(i == 1);
            cVar.onModeChanged(this.gtF);
            cVar.onModeChanged(this.gtJ);
            cVar.onModeChanged(this.gtM);
            this.gtG.onChangeSkinType(this.gtE.getPageContext(), i);
            al.i(this.gtM, e.f.bg_pack);
            if (this.gtI != null) {
                this.gtI.onChangeSkinType(this.gtE.getPageContext(), i);
            }
        }
    }

    public View bpJ() {
        return this.gtJ;
    }

    public View bpK() {
        return this.gtN;
    }
}
