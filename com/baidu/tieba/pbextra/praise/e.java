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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.d;
import java.util.List;
/* loaded from: classes3.dex */
public class e extends com.baidu.adp.base.c<PraiseListActivity> {
    private c fSK;
    private PraiseListActivity fSL;
    private View fSM;
    private NavigationBar fSN;
    private View fSO;
    private NoDataView fSP;
    private View fSQ;
    private TextView fSR;
    private BdListView fSS;
    private View fST;
    private TextView fSU;
    private TextView fSV;
    private ProgressBar fSW;
    private ProgressBar fSX;

    public e(PraiseListActivity praiseListActivity, String str) {
        super(praiseListActivity.getPageContext());
        this.fSK = null;
        this.fSL = null;
        this.fSM = null;
        this.fSN = null;
        this.fSO = null;
        this.fSP = null;
        this.fSQ = null;
        this.fSR = null;
        this.fSS = null;
        this.fST = null;
        this.fSU = null;
        this.fSV = null;
        this.fSW = null;
        this.fSX = null;
        this.fSL = praiseListActivity;
        praiseListActivity.setContentView(d.h.zan_list_activity);
        this.fSM = praiseListActivity.findViewById(d.g.zan_list_page_parent);
        this.fSN = (NavigationBar) praiseListActivity.findViewById(d.g.zan_list_page_navigationbar);
        this.fSO = praiseListActivity.findViewById(d.g.zan_list_page_frame);
        this.fSP = NoDataViewFactory.a(this.fSL.getPageContext().getContext(), this.fSM, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.f(this.fSL.getActivity(), d.e.ds320)), NoDataViewFactory.d.du(d.j.praise_list_no_data), null);
        this.fSS = (BdListView) praiseListActivity.findViewById(d.g.zan_list_page_list);
        TextView textView = new TextView(this.fSL.getActivity());
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)));
        this.fSS.addHeaderView(textView, 0);
        this.fSW = (ProgressBar) praiseListActivity.findViewById(d.g.zan_list_page_progress);
        this.fSK = new c(praiseListActivity);
        this.fSS.setAdapter((ListAdapter) this.fSK);
        this.fSS.setOnScrollListener(this.fSK);
        this.fSN.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.fSN.setTitleText("");
        this.fSQ = LayoutInflater.from(praiseListActivity.getPageContext().getContext()).inflate(d.h.zan_list_head, (ViewGroup) null);
        this.fSQ.setOnClickListener(praiseListActivity);
        this.fSR = (TextView) this.fSQ.findViewById(d.g.zan_list_head_text);
        this.fSR.setText(str);
        this.fSQ.setVisibility(8);
        this.fSS.addHeaderView(this.fSQ);
        this.fST = LayoutInflater.from(praiseListActivity.getPageContext().getContext()).inflate(d.h.zan_list_foot, (ViewGroup) null);
        this.fSU = (TextView) this.fST.findViewById(d.g.zan_list_foot_text_continue);
        this.fSV = (TextView) this.fST.findViewById(d.g.zan_list_foot_text_more);
        this.fSX = (ProgressBar) this.fST.findViewById(d.g.zan_list_foot_progress);
        this.fST.setVisibility(8);
        this.fSU.setOnClickListener(praiseListActivity);
        this.fSS.addFooterView(this.fST);
        this.fSS.setOnItemClickListener(praiseListActivity);
    }

    public void aKG() {
        if (this.fSK != null) {
            this.fSK.notifyDataSetChanged();
        }
    }

    public void kT(boolean z) {
        if (z) {
            this.fSX.setVisibility(0);
        } else {
            this.fSW.setVisibility(0);
        }
    }

    public void bht() {
        this.fSW.setVisibility(8);
        this.fSX.setVisibility(8);
    }

    public boolean AE() {
        return this.fSW.getVisibility() == 0 || this.fSX.getVisibility() == 0;
    }

    public void b(int i, List<a> list, int i2, int i3) {
        String format;
        String format2;
        this.fSW.setVisibility(8);
        this.fSX.setVisibility(8);
        this.fSQ.setVisibility(0);
        if (i > 0) {
            switch (this.fSL.pageType) {
                case 1:
                    format2 = String.format(this.fSL.getResources().getString(d.j.graffiti_list_title_count), ap.H(i));
                    break;
                default:
                    format2 = String.format(this.fSL.getResources().getString(d.j.praise_list_title_count), ap.H(i));
                    break;
            }
            this.fSN.setTitleText(format2);
        } else {
            this.fSN.setTitleText("");
        }
        if (list == null || list.size() < 1) {
            aC(null, this.fSL.pageType);
            return;
        }
        this.fSO.setVisibility(0);
        this.fSP.setVisibility(8);
        this.fSK.cZ(list);
        this.fSK.notifyDataSetChanged();
        switch (i2) {
            case 1001:
                this.fST.setVisibility(0);
                this.fSU.setVisibility(0);
                this.fSV.setVisibility(8);
                return;
            case 1002:
                this.fST.setVisibility(8);
                return;
            case 1003:
                this.fST.setVisibility(0);
                am.i(this.fST, d.f.bg_pack);
                this.fSU.setVisibility(8);
                this.fSV.setVisibility(0);
                switch (this.fSL.pageType) {
                    case 1:
                        format = String.format(this.fSL.getResources().getString(d.j.graffiti_list_title_count), ap.H(i));
                        break;
                    default:
                        format = String.format(this.fSL.getResources().getString(d.j.praise_item_more), ap.H(i));
                        break;
                }
                this.fSV.setText(format);
                return;
            default:
                this.fST.setVisibility(8);
                return;
        }
    }

    public void aC(String str, int i) {
        this.fSW.setVisibility(8);
        this.fSX.setVisibility(8);
        this.fSO.setVisibility(8);
        this.fSP.setVisibility(0);
        if (!StringUtils.isNull(str)) {
            this.fSP.setTextOption(NoDataViewFactory.d.fm(str));
        } else if (1 == i) {
            this.fSP.setTextOption(NoDataViewFactory.d.du(d.j.graffiti_list_no_data));
        } else {
            this.fSP.setTextOption(NoDataViewFactory.d.du(d.j.praise_list_no_data));
        }
    }

    public void a(com.baidu.tbadk.core.c cVar, int i) {
        if (cVar != null) {
            cVar.setNightMode(i == 1);
            cVar.onModeChanged(this.fSM);
            cVar.onModeChanged(this.fSQ);
            cVar.onModeChanged(this.fST);
            this.fSN.onChangeSkinType(this.fSL.getPageContext(), i);
            am.i(this.fST, d.f.bg_pack);
            if (this.fSP != null) {
                this.fSP.onChangeSkinType(this.fSL.getPageContext(), i);
            }
        }
    }

    public View bhu() {
        return this.fSQ;
    }

    public View bhv() {
        return this.fSU;
    }
}
