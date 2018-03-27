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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.h;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.d;
import java.util.List;
/* loaded from: classes3.dex */
public class e extends com.baidu.adp.base.c<PraiseListActivity> {
    private c ghD;
    private PraiseListActivity ghE;
    private View ghF;
    private NavigationBar ghG;
    private View ghH;
    private h ghI;
    private View ghJ;
    private TextView ghK;
    private BdListView ghL;
    private View ghM;
    private TextView ghN;
    private TextView ghO;
    private ProgressBar ghP;
    private ProgressBar ghQ;

    public e(PraiseListActivity praiseListActivity, String str) {
        super(praiseListActivity.getPageContext());
        this.ghD = null;
        this.ghE = null;
        this.ghF = null;
        this.ghG = null;
        this.ghH = null;
        this.ghI = null;
        this.ghJ = null;
        this.ghK = null;
        this.ghL = null;
        this.ghM = null;
        this.ghN = null;
        this.ghO = null;
        this.ghP = null;
        this.ghQ = null;
        this.ghE = praiseListActivity;
        praiseListActivity.setContentView(d.h.zan_list_activity);
        this.ghF = praiseListActivity.findViewById(d.g.zan_list_page_parent);
        this.ghG = (NavigationBar) praiseListActivity.findViewById(d.g.zan_list_page_navigationbar);
        this.ghH = praiseListActivity.findViewById(d.g.zan_list_page_frame);
        this.ghI = NoDataViewFactory.a(this.ghE.getPageContext().getContext(), this.ghF, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.t(this.ghE.getActivity(), d.e.ds320)), NoDataViewFactory.d.gp(d.j.praise_list_no_data), null);
        this.ghL = (BdListView) praiseListActivity.findViewById(d.g.zan_list_page_list);
        TextView textView = new TextView(this.ghE.getActivity());
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)));
        this.ghL.addHeaderView(textView, 0);
        this.ghP = (ProgressBar) praiseListActivity.findViewById(d.g.zan_list_page_progress);
        this.ghD = new c(praiseListActivity);
        this.ghL.setAdapter((ListAdapter) this.ghD);
        this.ghL.setOnScrollListener(this.ghD);
        this.ghG.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.ghG.setTitleText("");
        this.ghJ = LayoutInflater.from(praiseListActivity.getPageContext().getContext()).inflate(d.h.zan_list_head, (ViewGroup) null);
        this.ghJ.setOnClickListener(praiseListActivity);
        this.ghK = (TextView) this.ghJ.findViewById(d.g.zan_list_head_text);
        this.ghK.setText(str);
        this.ghJ.setVisibility(8);
        this.ghL.addHeaderView(this.ghJ);
        this.ghM = LayoutInflater.from(praiseListActivity.getPageContext().getContext()).inflate(d.h.zan_list_foot, (ViewGroup) null);
        this.ghN = (TextView) this.ghM.findViewById(d.g.zan_list_foot_text_continue);
        this.ghO = (TextView) this.ghM.findViewById(d.g.zan_list_foot_text_more);
        this.ghQ = (ProgressBar) this.ghM.findViewById(d.g.zan_list_foot_progress);
        this.ghM.setVisibility(8);
        this.ghN.setOnClickListener(praiseListActivity);
        this.ghL.addFooterView(this.ghM);
        this.ghL.setOnItemClickListener(praiseListActivity);
    }

    public void aJi() {
        if (this.ghD != null) {
            this.ghD.notifyDataSetChanged();
        }
    }

    public void lt(boolean z) {
        if (z) {
            this.ghQ.setVisibility(0);
        } else {
            this.ghP.setVisibility(0);
        }
    }

    public void biu() {
        this.ghP.setVisibility(8);
        this.ghQ.setVisibility(8);
    }

    public boolean El() {
        return this.ghP.getVisibility() == 0 || this.ghQ.getVisibility() == 0;
    }

    public void b(int i, List<a> list, int i2, int i3) {
        String format;
        String format2;
        this.ghP.setVisibility(8);
        this.ghQ.setVisibility(8);
        this.ghJ.setVisibility(0);
        if (i > 0) {
            switch (this.ghE.pageType) {
                case 1:
                    format2 = String.format(this.ghE.getResources().getString(d.j.graffiti_list_title_count), am.J(i));
                    break;
                default:
                    format2 = String.format(this.ghE.getResources().getString(d.j.praise_list_title_count), am.J(i));
                    break;
            }
            this.ghG.setTitleText(format2);
        } else {
            this.ghG.setTitleText("");
        }
        if (list == null || list.size() < 1) {
            aA(null, this.ghE.pageType);
            return;
        }
        this.ghH.setVisibility(0);
        this.ghI.setVisibility(8);
        this.ghD.cZ(list);
        this.ghD.notifyDataSetChanged();
        switch (i2) {
            case 1001:
                this.ghM.setVisibility(0);
                this.ghN.setVisibility(0);
                this.ghO.setVisibility(8);
                return;
            case 1002:
                this.ghM.setVisibility(8);
                return;
            case 1003:
                this.ghM.setVisibility(0);
                aj.s(this.ghM, d.f.bg_pack);
                this.ghN.setVisibility(8);
                this.ghO.setVisibility(0);
                switch (this.ghE.pageType) {
                    case 1:
                        format = String.format(this.ghE.getResources().getString(d.j.graffiti_list_title_count), am.J(i));
                        break;
                    default:
                        format = String.format(this.ghE.getResources().getString(d.j.praise_item_more), am.J(i));
                        break;
                }
                this.ghO.setText(format);
                return;
            default:
                this.ghM.setVisibility(8);
                return;
        }
    }

    public void aA(String str, int i) {
        this.ghP.setVisibility(8);
        this.ghQ.setVisibility(8);
        this.ghH.setVisibility(8);
        this.ghI.setVisibility(0);
        if (!StringUtils.isNull(str)) {
            this.ghI.setTextOption(NoDataViewFactory.d.eT(str));
        } else if (1 == i) {
            this.ghI.setTextOption(NoDataViewFactory.d.gp(d.j.graffiti_list_no_data));
        } else {
            this.ghI.setTextOption(NoDataViewFactory.d.gp(d.j.praise_list_no_data));
        }
    }

    public void a(com.baidu.tbadk.core.c cVar, int i) {
        if (cVar != null) {
            cVar.aQ(i == 1);
            cVar.aM(this.ghF);
            cVar.aM(this.ghJ);
            cVar.aM(this.ghM);
            this.ghG.onChangeSkinType(this.ghE.getPageContext(), i);
            aj.s(this.ghM, d.f.bg_pack);
            if (this.ghI != null) {
                this.ghI.onChangeSkinType(this.ghE.getPageContext(), i);
            }
        }
    }

    public View biv() {
        return this.ghJ;
    }

    public View biw() {
        return this.ghN;
    }
}
