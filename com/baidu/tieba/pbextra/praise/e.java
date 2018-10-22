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
    private View ghA;
    private TextView ghB;
    private BdListView ghC;
    private View ghD;
    private TextView ghE;
    private TextView ghF;
    private ProgressBar ghG;
    private ProgressBar ghH;
    private c ghu;
    private PraiseListActivity ghv;
    private View ghw;
    private NavigationBar ghx;
    private View ghy;
    private NoDataView ghz;

    public e(PraiseListActivity praiseListActivity, String str) {
        super(praiseListActivity.getPageContext());
        this.ghu = null;
        this.ghv = null;
        this.ghw = null;
        this.ghx = null;
        this.ghy = null;
        this.ghz = null;
        this.ghA = null;
        this.ghB = null;
        this.ghC = null;
        this.ghD = null;
        this.ghE = null;
        this.ghF = null;
        this.ghG = null;
        this.ghH = null;
        this.ghv = praiseListActivity;
        praiseListActivity.setContentView(e.h.zan_list_activity);
        this.ghw = praiseListActivity.findViewById(e.g.zan_list_page_parent);
        this.ghx = (NavigationBar) praiseListActivity.findViewById(e.g.zan_list_page_navigationbar);
        this.ghy = praiseListActivity.findViewById(e.g.zan_list_page_frame);
        this.ghz = NoDataViewFactory.a(this.ghv.getPageContext().getContext(), this.ghw, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.h(this.ghv.getActivity(), e.C0175e.ds320)), NoDataViewFactory.d.dO(e.j.praise_list_no_data), null);
        this.ghC = (BdListView) praiseListActivity.findViewById(e.g.zan_list_page_list);
        TextView textView = new TextView(this.ghv.getActivity());
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)));
        this.ghC.addHeaderView(textView, 0);
        this.ghG = (ProgressBar) praiseListActivity.findViewById(e.g.zan_list_page_progress);
        this.ghu = new c(praiseListActivity);
        this.ghC.setAdapter((ListAdapter) this.ghu);
        this.ghC.setOnScrollListener(this.ghu);
        this.ghx.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.ghx.setTitleText("");
        this.ghA = LayoutInflater.from(praiseListActivity.getPageContext().getContext()).inflate(e.h.zan_list_head, (ViewGroup) null);
        this.ghA.setOnClickListener(praiseListActivity);
        this.ghB = (TextView) this.ghA.findViewById(e.g.zan_list_head_text);
        this.ghB.setText(str);
        this.ghA.setVisibility(8);
        this.ghC.addHeaderView(this.ghA);
        this.ghD = LayoutInflater.from(praiseListActivity.getPageContext().getContext()).inflate(e.h.zan_list_foot, (ViewGroup) null);
        this.ghE = (TextView) this.ghD.findViewById(e.g.zan_list_foot_text_continue);
        this.ghF = (TextView) this.ghD.findViewById(e.g.zan_list_foot_text_more);
        this.ghH = (ProgressBar) this.ghD.findViewById(e.g.zan_list_foot_progress);
        this.ghD.setVisibility(8);
        this.ghE.setOnClickListener(praiseListActivity);
        this.ghC.addFooterView(this.ghD);
        this.ghC.setOnItemClickListener(praiseListActivity);
    }

    public void aQh() {
        if (this.ghu != null) {
            this.ghu.notifyDataSetChanged();
        }
    }

    public void lG(boolean z) {
        if (z) {
            this.ghH.setVisibility(0);
        } else {
            this.ghG.setVisibility(0);
        }
    }

    public void bna() {
        this.ghG.setVisibility(8);
        this.ghH.setVisibility(8);
    }

    public boolean DU() {
        return this.ghG.getVisibility() == 0 || this.ghH.getVisibility() == 0;
    }

    public void b(int i, List<a> list, int i2, int i3) {
        String format;
        String format2;
        this.ghG.setVisibility(8);
        this.ghH.setVisibility(8);
        this.ghA.setVisibility(0);
        if (i > 0) {
            switch (this.ghv.pageType) {
                case 1:
                    format2 = String.format(this.ghv.getResources().getString(e.j.graffiti_list_title_count), ao.N(i));
                    break;
                default:
                    format2 = String.format(this.ghv.getResources().getString(e.j.praise_list_title_count), ao.N(i));
                    break;
            }
            this.ghx.setTitleText(format2);
        } else {
            this.ghx.setTitleText("");
        }
        if (list == null || list.size() < 1) {
            aL(null, this.ghv.pageType);
            return;
        }
        this.ghy.setVisibility(0);
        this.ghz.setVisibility(8);
        this.ghu.m20do(list);
        this.ghu.notifyDataSetChanged();
        switch (i2) {
            case 1001:
                this.ghD.setVisibility(0);
                this.ghE.setVisibility(0);
                this.ghF.setVisibility(8);
                return;
            case 1002:
                this.ghD.setVisibility(8);
                return;
            case 1003:
                this.ghD.setVisibility(0);
                al.i(this.ghD, e.f.bg_pack);
                this.ghE.setVisibility(8);
                this.ghF.setVisibility(0);
                switch (this.ghv.pageType) {
                    case 1:
                        format = String.format(this.ghv.getResources().getString(e.j.graffiti_list_title_count), ao.N(i));
                        break;
                    default:
                        format = String.format(this.ghv.getResources().getString(e.j.praise_item_more), ao.N(i));
                        break;
                }
                this.ghF.setText(format);
                return;
            default:
                this.ghD.setVisibility(8);
                return;
        }
    }

    public void aL(String str, int i) {
        this.ghG.setVisibility(8);
        this.ghH.setVisibility(8);
        this.ghy.setVisibility(8);
        this.ghz.setVisibility(0);
        if (!StringUtils.isNull(str)) {
            this.ghz.setTextOption(NoDataViewFactory.d.fU(str));
        } else if (1 == i) {
            this.ghz.setTextOption(NoDataViewFactory.d.dO(e.j.graffiti_list_no_data));
        } else {
            this.ghz.setTextOption(NoDataViewFactory.d.dO(e.j.praise_list_no_data));
        }
    }

    public void a(com.baidu.tbadk.core.c cVar, int i) {
        if (cVar != null) {
            cVar.setNightMode(i == 1);
            cVar.onModeChanged(this.ghw);
            cVar.onModeChanged(this.ghA);
            cVar.onModeChanged(this.ghD);
            this.ghx.onChangeSkinType(this.ghv.getPageContext(), i);
            al.i(this.ghD, e.f.bg_pack);
            if (this.ghz != null) {
                this.ghz.onChangeSkinType(this.ghv.getPageContext(), i);
            }
        }
    }

    public View bnb() {
        return this.ghA;
    }

    public View bnc() {
        return this.ghE;
    }
}
