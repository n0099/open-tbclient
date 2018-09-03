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
import com.baidu.tieba.f;
import java.util.List;
/* loaded from: classes3.dex */
public class e extends com.baidu.adp.base.c<PraiseListActivity> {
    private c fSC;
    private PraiseListActivity fSD;
    private View fSE;
    private NavigationBar fSF;
    private View fSG;
    private NoDataView fSH;
    private View fSI;
    private TextView fSJ;
    private BdListView fSK;
    private View fSL;
    private TextView fSM;
    private TextView fSN;
    private ProgressBar fSO;
    private ProgressBar fSP;

    public e(PraiseListActivity praiseListActivity, String str) {
        super(praiseListActivity.getPageContext());
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
        this.fSN = null;
        this.fSO = null;
        this.fSP = null;
        this.fSD = praiseListActivity;
        praiseListActivity.setContentView(f.h.zan_list_activity);
        this.fSE = praiseListActivity.findViewById(f.g.zan_list_page_parent);
        this.fSF = (NavigationBar) praiseListActivity.findViewById(f.g.zan_list_page_navigationbar);
        this.fSG = praiseListActivity.findViewById(f.g.zan_list_page_frame);
        this.fSH = NoDataViewFactory.a(this.fSD.getPageContext().getContext(), this.fSE, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.f(this.fSD.getActivity(), f.e.ds320)), NoDataViewFactory.d.dt(f.j.praise_list_no_data), null);
        this.fSK = (BdListView) praiseListActivity.findViewById(f.g.zan_list_page_list);
        TextView textView = new TextView(this.fSD.getActivity());
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)));
        this.fSK.addHeaderView(textView, 0);
        this.fSO = (ProgressBar) praiseListActivity.findViewById(f.g.zan_list_page_progress);
        this.fSC = new c(praiseListActivity);
        this.fSK.setAdapter((ListAdapter) this.fSC);
        this.fSK.setOnScrollListener(this.fSC);
        this.fSF.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.fSF.setTitleText("");
        this.fSI = LayoutInflater.from(praiseListActivity.getPageContext().getContext()).inflate(f.h.zan_list_head, (ViewGroup) null);
        this.fSI.setOnClickListener(praiseListActivity);
        this.fSJ = (TextView) this.fSI.findViewById(f.g.zan_list_head_text);
        this.fSJ.setText(str);
        this.fSI.setVisibility(8);
        this.fSK.addHeaderView(this.fSI);
        this.fSL = LayoutInflater.from(praiseListActivity.getPageContext().getContext()).inflate(f.h.zan_list_foot, (ViewGroup) null);
        this.fSM = (TextView) this.fSL.findViewById(f.g.zan_list_foot_text_continue);
        this.fSN = (TextView) this.fSL.findViewById(f.g.zan_list_foot_text_more);
        this.fSP = (ProgressBar) this.fSL.findViewById(f.g.zan_list_foot_progress);
        this.fSL.setVisibility(8);
        this.fSM.setOnClickListener(praiseListActivity);
        this.fSK.addFooterView(this.fSL);
        this.fSK.setOnItemClickListener(praiseListActivity);
    }

    public void aKD() {
        if (this.fSC != null) {
            this.fSC.notifyDataSetChanged();
        }
    }

    public void kT(boolean z) {
        if (z) {
            this.fSP.setVisibility(0);
        } else {
            this.fSO.setVisibility(0);
        }
    }

    public void bho() {
        this.fSO.setVisibility(8);
        this.fSP.setVisibility(8);
    }

    public boolean AB() {
        return this.fSO.getVisibility() == 0 || this.fSP.getVisibility() == 0;
    }

    public void b(int i, List<a> list, int i2, int i3) {
        String format;
        String format2;
        this.fSO.setVisibility(8);
        this.fSP.setVisibility(8);
        this.fSI.setVisibility(0);
        if (i > 0) {
            switch (this.fSD.pageType) {
                case 1:
                    format2 = String.format(this.fSD.getResources().getString(f.j.graffiti_list_title_count), ap.H(i));
                    break;
                default:
                    format2 = String.format(this.fSD.getResources().getString(f.j.praise_list_title_count), ap.H(i));
                    break;
            }
            this.fSF.setTitleText(format2);
        } else {
            this.fSF.setTitleText("");
        }
        if (list == null || list.size() < 1) {
            aC(null, this.fSD.pageType);
            return;
        }
        this.fSG.setVisibility(0);
        this.fSH.setVisibility(8);
        this.fSC.cZ(list);
        this.fSC.notifyDataSetChanged();
        switch (i2) {
            case 1001:
                this.fSL.setVisibility(0);
                this.fSM.setVisibility(0);
                this.fSN.setVisibility(8);
                return;
            case 1002:
                this.fSL.setVisibility(8);
                return;
            case 1003:
                this.fSL.setVisibility(0);
                am.i(this.fSL, f.C0146f.bg_pack);
                this.fSM.setVisibility(8);
                this.fSN.setVisibility(0);
                switch (this.fSD.pageType) {
                    case 1:
                        format = String.format(this.fSD.getResources().getString(f.j.graffiti_list_title_count), ap.H(i));
                        break;
                    default:
                        format = String.format(this.fSD.getResources().getString(f.j.praise_item_more), ap.H(i));
                        break;
                }
                this.fSN.setText(format);
                return;
            default:
                this.fSL.setVisibility(8);
                return;
        }
    }

    public void aC(String str, int i) {
        this.fSO.setVisibility(8);
        this.fSP.setVisibility(8);
        this.fSG.setVisibility(8);
        this.fSH.setVisibility(0);
        if (!StringUtils.isNull(str)) {
            this.fSH.setTextOption(NoDataViewFactory.d.fm(str));
        } else if (1 == i) {
            this.fSH.setTextOption(NoDataViewFactory.d.dt(f.j.graffiti_list_no_data));
        } else {
            this.fSH.setTextOption(NoDataViewFactory.d.dt(f.j.praise_list_no_data));
        }
    }

    public void a(com.baidu.tbadk.core.c cVar, int i) {
        if (cVar != null) {
            cVar.setNightMode(i == 1);
            cVar.onModeChanged(this.fSE);
            cVar.onModeChanged(this.fSI);
            cVar.onModeChanged(this.fSL);
            this.fSF.onChangeSkinType(this.fSD.getPageContext(), i);
            am.i(this.fSL, f.C0146f.bg_pack);
            if (this.fSH != null) {
                this.fSH.onChangeSkinType(this.fSD.getPageContext(), i);
            }
        }
    }

    public View bhp() {
        return this.fSI;
    }

    public View bhq() {
        return this.fSM;
    }
}
