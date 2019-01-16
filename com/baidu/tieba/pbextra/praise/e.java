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
    private c gtC;
    private PraiseListActivity gtD;
    private View gtE;
    private NavigationBar gtF;
    private View gtG;
    private NoDataView gtH;
    private View gtI;
    private TextView gtJ;
    private BdListView gtK;
    private View gtL;
    private TextView gtM;
    private TextView gtN;
    private ProgressBar gtO;
    private ProgressBar gtP;

    public e(PraiseListActivity praiseListActivity, String str) {
        super(praiseListActivity.getPageContext());
        this.gtC = null;
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
        this.gtD = praiseListActivity;
        praiseListActivity.setContentView(e.h.zan_list_activity);
        this.gtE = praiseListActivity.findViewById(e.g.zan_list_page_parent);
        this.gtF = (NavigationBar) praiseListActivity.findViewById(e.g.zan_list_page_navigationbar);
        this.gtG = praiseListActivity.findViewById(e.g.zan_list_page_frame);
        this.gtH = NoDataViewFactory.a(this.gtD.getPageContext().getContext(), this.gtE, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.h(this.gtD.getActivity(), e.C0210e.ds320)), NoDataViewFactory.d.eq(e.j.praise_list_no_data), null);
        this.gtK = (BdListView) praiseListActivity.findViewById(e.g.zan_list_page_list);
        TextView textView = new TextView(this.gtD.getActivity());
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)));
        this.gtK.addHeaderView(textView, 0);
        this.gtO = (ProgressBar) praiseListActivity.findViewById(e.g.zan_list_page_progress);
        this.gtC = new c(praiseListActivity);
        this.gtK.setAdapter((ListAdapter) this.gtC);
        this.gtK.setOnScrollListener(this.gtC);
        this.gtF.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.gtF.setTitleText("");
        this.gtI = LayoutInflater.from(praiseListActivity.getPageContext().getContext()).inflate(e.h.zan_list_head, (ViewGroup) null);
        this.gtI.setOnClickListener(praiseListActivity);
        this.gtJ = (TextView) this.gtI.findViewById(e.g.zan_list_head_text);
        this.gtJ.setText(str);
        this.gtI.setVisibility(8);
        this.gtK.addHeaderView(this.gtI);
        this.gtL = LayoutInflater.from(praiseListActivity.getPageContext().getContext()).inflate(e.h.zan_list_foot, (ViewGroup) null);
        this.gtM = (TextView) this.gtL.findViewById(e.g.zan_list_foot_text_continue);
        this.gtN = (TextView) this.gtL.findViewById(e.g.zan_list_foot_text_more);
        this.gtP = (ProgressBar) this.gtL.findViewById(e.g.zan_list_foot_progress);
        this.gtL.setVisibility(8);
        this.gtM.setOnClickListener(praiseListActivity);
        this.gtK.addFooterView(this.gtL);
        this.gtK.setOnItemClickListener(praiseListActivity);
    }

    public void aSJ() {
        if (this.gtC != null) {
            this.gtC.notifyDataSetChanged();
        }
    }

    public void lX(boolean z) {
        if (z) {
            this.gtP.setVisibility(0);
        } else {
            this.gtO.setVisibility(0);
        }
    }

    public void bpI() {
        this.gtO.setVisibility(8);
        this.gtP.setVisibility(8);
    }

    public boolean Fv() {
        return this.gtO.getVisibility() == 0 || this.gtP.getVisibility() == 0;
    }

    public void b(int i, List<a> list, int i2, int i3) {
        String format;
        String format2;
        this.gtO.setVisibility(8);
        this.gtP.setVisibility(8);
        this.gtI.setVisibility(0);
        if (i > 0) {
            switch (this.gtD.pageType) {
                case 1:
                    format2 = String.format(this.gtD.getResources().getString(e.j.graffiti_list_title_count), ao.X(i));
                    break;
                default:
                    format2 = String.format(this.gtD.getResources().getString(e.j.praise_list_title_count), ao.X(i));
                    break;
            }
            this.gtF.setTitleText(format2);
        } else {
            this.gtF.setTitleText("");
        }
        if (list == null || list.size() < 1) {
            aN(null, this.gtD.pageType);
            return;
        }
        this.gtG.setVisibility(0);
        this.gtH.setVisibility(8);
        this.gtC.ds(list);
        this.gtC.notifyDataSetChanged();
        switch (i2) {
            case 1001:
                this.gtL.setVisibility(0);
                this.gtM.setVisibility(0);
                this.gtN.setVisibility(8);
                return;
            case 1002:
                this.gtL.setVisibility(8);
                return;
            case 1003:
                this.gtL.setVisibility(0);
                al.i(this.gtL, e.f.bg_pack);
                this.gtM.setVisibility(8);
                this.gtN.setVisibility(0);
                switch (this.gtD.pageType) {
                    case 1:
                        format = String.format(this.gtD.getResources().getString(e.j.graffiti_list_title_count), ao.X(i));
                        break;
                    default:
                        format = String.format(this.gtD.getResources().getString(e.j.praise_item_more), ao.X(i));
                        break;
                }
                this.gtN.setText(format);
                return;
            default:
                this.gtL.setVisibility(8);
                return;
        }
    }

    public void aN(String str, int i) {
        this.gtO.setVisibility(8);
        this.gtP.setVisibility(8);
        this.gtG.setVisibility(8);
        this.gtH.setVisibility(0);
        if (!StringUtils.isNull(str)) {
            this.gtH.setTextOption(NoDataViewFactory.d.gC(str));
        } else if (1 == i) {
            this.gtH.setTextOption(NoDataViewFactory.d.eq(e.j.graffiti_list_no_data));
        } else {
            this.gtH.setTextOption(NoDataViewFactory.d.eq(e.j.praise_list_no_data));
        }
    }

    public void a(com.baidu.tbadk.core.c cVar, int i) {
        if (cVar != null) {
            cVar.setNightMode(i == 1);
            cVar.onModeChanged(this.gtE);
            cVar.onModeChanged(this.gtI);
            cVar.onModeChanged(this.gtL);
            this.gtF.onChangeSkinType(this.gtD.getPageContext(), i);
            al.i(this.gtL, e.f.bg_pack);
            if (this.gtH != null) {
                this.gtH.onChangeSkinType(this.gtD.getPageContext(), i);
            }
        }
    }

    public View bpJ() {
        return this.gtI;
    }

    public View bpK() {
        return this.gtM;
    }
}
