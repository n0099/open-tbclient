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
    private PraiseListActivity fSA;
    private View fSB;
    private NavigationBar fSC;
    private View fSD;
    private NoDataView fSE;
    private View fSF;
    private TextView fSG;
    private BdListView fSH;
    private View fSI;
    private TextView fSJ;
    private TextView fSK;
    private ProgressBar fSL;
    private ProgressBar fSM;
    private c fSz;

    public e(PraiseListActivity praiseListActivity, String str) {
        super(praiseListActivity.getPageContext());
        this.fSz = null;
        this.fSA = null;
        this.fSB = null;
        this.fSC = null;
        this.fSD = null;
        this.fSE = null;
        this.fSF = null;
        this.fSG = null;
        this.fSH = null;
        this.fSI = null;
        this.fSJ = null;
        this.fSK = null;
        this.fSL = null;
        this.fSM = null;
        this.fSA = praiseListActivity;
        praiseListActivity.setContentView(d.i.zan_list_activity);
        this.fSB = praiseListActivity.findViewById(d.g.zan_list_page_parent);
        this.fSC = (NavigationBar) praiseListActivity.findViewById(d.g.zan_list_page_navigationbar);
        this.fSD = praiseListActivity.findViewById(d.g.zan_list_page_frame);
        this.fSE = NoDataViewFactory.a(this.fSA.getPageContext().getContext(), this.fSB, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.e(this.fSA.getActivity(), d.e.ds320)), NoDataViewFactory.d.ds(d.k.praise_list_no_data), null);
        this.fSH = (BdListView) praiseListActivity.findViewById(d.g.zan_list_page_list);
        TextView textView = new TextView(this.fSA.getActivity());
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)));
        this.fSH.addHeaderView(textView, 0);
        this.fSL = (ProgressBar) praiseListActivity.findViewById(d.g.zan_list_page_progress);
        this.fSz = new c(praiseListActivity);
        this.fSH.setAdapter((ListAdapter) this.fSz);
        this.fSH.setOnScrollListener(this.fSz);
        this.fSC.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.fSC.setTitleText("");
        this.fSF = LayoutInflater.from(praiseListActivity.getPageContext().getContext()).inflate(d.i.zan_list_head, (ViewGroup) null);
        this.fSF.setOnClickListener(praiseListActivity);
        this.fSG = (TextView) this.fSF.findViewById(d.g.zan_list_head_text);
        this.fSG.setText(str);
        this.fSF.setVisibility(8);
        this.fSH.addHeaderView(this.fSF);
        this.fSI = LayoutInflater.from(praiseListActivity.getPageContext().getContext()).inflate(d.i.zan_list_foot, (ViewGroup) null);
        this.fSJ = (TextView) this.fSI.findViewById(d.g.zan_list_foot_text_continue);
        this.fSK = (TextView) this.fSI.findViewById(d.g.zan_list_foot_text_more);
        this.fSM = (ProgressBar) this.fSI.findViewById(d.g.zan_list_foot_progress);
        this.fSI.setVisibility(8);
        this.fSJ.setOnClickListener(praiseListActivity);
        this.fSH.addFooterView(this.fSI);
        this.fSH.setOnItemClickListener(praiseListActivity);
    }

    public void aJF() {
        if (this.fSz != null) {
            this.fSz.notifyDataSetChanged();
        }
    }

    public void lh(boolean z) {
        if (z) {
            this.fSM.setVisibility(0);
        } else {
            this.fSL.setVisibility(0);
        }
    }

    public void bja() {
        this.fSL.setVisibility(8);
        this.fSM.setVisibility(8);
    }

    public boolean AO() {
        return this.fSL.getVisibility() == 0 || this.fSM.getVisibility() == 0;
    }

    public void b(int i, List<a> list, int i2, int i3) {
        String format;
        String format2;
        this.fSL.setVisibility(8);
        this.fSM.setVisibility(8);
        this.fSF.setVisibility(0);
        if (i > 0) {
            switch (this.fSA.pageType) {
                case 1:
                    format2 = String.format(this.fSA.getResources().getString(d.k.graffiti_list_title_count), ap.F(i));
                    break;
                default:
                    format2 = String.format(this.fSA.getResources().getString(d.k.praise_list_title_count), ap.F(i));
                    break;
            }
            this.fSC.setTitleText(format2);
        } else {
            this.fSC.setTitleText("");
        }
        if (list == null || list.size() < 1) {
            aG(null, this.fSA.pageType);
            return;
        }
        this.fSD.setVisibility(0);
        this.fSE.setVisibility(8);
        this.fSz.dd(list);
        this.fSz.notifyDataSetChanged();
        switch (i2) {
            case 1001:
                this.fSI.setVisibility(0);
                this.fSJ.setVisibility(0);
                this.fSK.setVisibility(8);
                return;
            case 1002:
                this.fSI.setVisibility(8);
                return;
            case 1003:
                this.fSI.setVisibility(0);
                am.i(this.fSI, d.f.bg_pack);
                this.fSJ.setVisibility(8);
                this.fSK.setVisibility(0);
                switch (this.fSA.pageType) {
                    case 1:
                        format = String.format(this.fSA.getResources().getString(d.k.graffiti_list_title_count), ap.F(i));
                        break;
                    default:
                        format = String.format(this.fSA.getResources().getString(d.k.praise_item_more), ap.F(i));
                        break;
                }
                this.fSK.setText(format);
                return;
            default:
                this.fSI.setVisibility(8);
                return;
        }
    }

    public void aG(String str, int i) {
        this.fSL.setVisibility(8);
        this.fSM.setVisibility(8);
        this.fSD.setVisibility(8);
        this.fSE.setVisibility(0);
        if (!StringUtils.isNull(str)) {
            this.fSE.setTextOption(NoDataViewFactory.d.fo(str));
        } else if (1 == i) {
            this.fSE.setTextOption(NoDataViewFactory.d.ds(d.k.graffiti_list_no_data));
        } else {
            this.fSE.setTextOption(NoDataViewFactory.d.ds(d.k.praise_list_no_data));
        }
    }

    public void a(com.baidu.tbadk.core.c cVar, int i) {
        if (cVar != null) {
            cVar.setNightMode(i == 1);
            cVar.onModeChanged(this.fSB);
            cVar.onModeChanged(this.fSF);
            cVar.onModeChanged(this.fSI);
            this.fSC.onChangeSkinType(this.fSA.getPageContext(), i);
            am.i(this.fSI, d.f.bg_pack);
            if (this.fSE != null) {
                this.fSE.onChangeSkinType(this.fSA.getPageContext(), i);
            }
        }
    }

    public View bjb() {
        return this.fSF;
    }

    public View bjc() {
        return this.fSJ;
    }
}
