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
    private TextView ghA;
    private BdListView ghB;
    private View ghC;
    private TextView ghD;
    private TextView ghE;
    private ProgressBar ghF;
    private ProgressBar ghG;
    private c ght;
    private PraiseListActivity ghu;
    private View ghv;
    private NavigationBar ghw;
    private View ghx;
    private NoDataView ghy;
    private View ghz;

    public e(PraiseListActivity praiseListActivity, String str) {
        super(praiseListActivity.getPageContext());
        this.ght = null;
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
        this.ghu = praiseListActivity;
        praiseListActivity.setContentView(e.h.zan_list_activity);
        this.ghv = praiseListActivity.findViewById(e.g.zan_list_page_parent);
        this.ghw = (NavigationBar) praiseListActivity.findViewById(e.g.zan_list_page_navigationbar);
        this.ghx = praiseListActivity.findViewById(e.g.zan_list_page_frame);
        this.ghy = NoDataViewFactory.a(this.ghu.getPageContext().getContext(), this.ghv, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.h(this.ghu.getActivity(), e.C0175e.ds320)), NoDataViewFactory.d.dO(e.j.praise_list_no_data), null);
        this.ghB = (BdListView) praiseListActivity.findViewById(e.g.zan_list_page_list);
        TextView textView = new TextView(this.ghu.getActivity());
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)));
        this.ghB.addHeaderView(textView, 0);
        this.ghF = (ProgressBar) praiseListActivity.findViewById(e.g.zan_list_page_progress);
        this.ght = new c(praiseListActivity);
        this.ghB.setAdapter((ListAdapter) this.ght);
        this.ghB.setOnScrollListener(this.ght);
        this.ghw.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.ghw.setTitleText("");
        this.ghz = LayoutInflater.from(praiseListActivity.getPageContext().getContext()).inflate(e.h.zan_list_head, (ViewGroup) null);
        this.ghz.setOnClickListener(praiseListActivity);
        this.ghA = (TextView) this.ghz.findViewById(e.g.zan_list_head_text);
        this.ghA.setText(str);
        this.ghz.setVisibility(8);
        this.ghB.addHeaderView(this.ghz);
        this.ghC = LayoutInflater.from(praiseListActivity.getPageContext().getContext()).inflate(e.h.zan_list_foot, (ViewGroup) null);
        this.ghD = (TextView) this.ghC.findViewById(e.g.zan_list_foot_text_continue);
        this.ghE = (TextView) this.ghC.findViewById(e.g.zan_list_foot_text_more);
        this.ghG = (ProgressBar) this.ghC.findViewById(e.g.zan_list_foot_progress);
        this.ghC.setVisibility(8);
        this.ghD.setOnClickListener(praiseListActivity);
        this.ghB.addFooterView(this.ghC);
        this.ghB.setOnItemClickListener(praiseListActivity);
    }

    public void aQh() {
        if (this.ght != null) {
            this.ght.notifyDataSetChanged();
        }
    }

    public void lG(boolean z) {
        if (z) {
            this.ghG.setVisibility(0);
        } else {
            this.ghF.setVisibility(0);
        }
    }

    public void bna() {
        this.ghF.setVisibility(8);
        this.ghG.setVisibility(8);
    }

    public boolean DU() {
        return this.ghF.getVisibility() == 0 || this.ghG.getVisibility() == 0;
    }

    public void b(int i, List<a> list, int i2, int i3) {
        String format;
        String format2;
        this.ghF.setVisibility(8);
        this.ghG.setVisibility(8);
        this.ghz.setVisibility(0);
        if (i > 0) {
            switch (this.ghu.pageType) {
                case 1:
                    format2 = String.format(this.ghu.getResources().getString(e.j.graffiti_list_title_count), ao.N(i));
                    break;
                default:
                    format2 = String.format(this.ghu.getResources().getString(e.j.praise_list_title_count), ao.N(i));
                    break;
            }
            this.ghw.setTitleText(format2);
        } else {
            this.ghw.setTitleText("");
        }
        if (list == null || list.size() < 1) {
            aL(null, this.ghu.pageType);
            return;
        }
        this.ghx.setVisibility(0);
        this.ghy.setVisibility(8);
        this.ght.m20do(list);
        this.ght.notifyDataSetChanged();
        switch (i2) {
            case 1001:
                this.ghC.setVisibility(0);
                this.ghD.setVisibility(0);
                this.ghE.setVisibility(8);
                return;
            case 1002:
                this.ghC.setVisibility(8);
                return;
            case 1003:
                this.ghC.setVisibility(0);
                al.i(this.ghC, e.f.bg_pack);
                this.ghD.setVisibility(8);
                this.ghE.setVisibility(0);
                switch (this.ghu.pageType) {
                    case 1:
                        format = String.format(this.ghu.getResources().getString(e.j.graffiti_list_title_count), ao.N(i));
                        break;
                    default:
                        format = String.format(this.ghu.getResources().getString(e.j.praise_item_more), ao.N(i));
                        break;
                }
                this.ghE.setText(format);
                return;
            default:
                this.ghC.setVisibility(8);
                return;
        }
    }

    public void aL(String str, int i) {
        this.ghF.setVisibility(8);
        this.ghG.setVisibility(8);
        this.ghx.setVisibility(8);
        this.ghy.setVisibility(0);
        if (!StringUtils.isNull(str)) {
            this.ghy.setTextOption(NoDataViewFactory.d.fU(str));
        } else if (1 == i) {
            this.ghy.setTextOption(NoDataViewFactory.d.dO(e.j.graffiti_list_no_data));
        } else {
            this.ghy.setTextOption(NoDataViewFactory.d.dO(e.j.praise_list_no_data));
        }
    }

    public void a(com.baidu.tbadk.core.c cVar, int i) {
        if (cVar != null) {
            cVar.setNightMode(i == 1);
            cVar.onModeChanged(this.ghv);
            cVar.onModeChanged(this.ghz);
            cVar.onModeChanged(this.ghC);
            this.ghw.onChangeSkinType(this.ghu.getPageContext(), i);
            al.i(this.ghC, e.f.bg_pack);
            if (this.ghy != null) {
                this.ghy.onChangeSkinType(this.ghu.getPageContext(), i);
            }
        }
    }

    public View bnb() {
        return this.ghz;
    }

    public View bnc() {
        return this.ghD;
    }
}
