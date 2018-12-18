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
    private c gpH;
    private PraiseListActivity gpI;
    private View gpJ;
    private NavigationBar gpK;
    private View gpL;
    private NoDataView gpM;
    private View gpN;
    private TextView gpO;
    private BdListView gpP;
    private View gpQ;
    private TextView gpR;
    private TextView gpS;
    private ProgressBar gpT;
    private ProgressBar gpU;

    public e(PraiseListActivity praiseListActivity, String str) {
        super(praiseListActivity.getPageContext());
        this.gpH = null;
        this.gpI = null;
        this.gpJ = null;
        this.gpK = null;
        this.gpL = null;
        this.gpM = null;
        this.gpN = null;
        this.gpO = null;
        this.gpP = null;
        this.gpQ = null;
        this.gpR = null;
        this.gpS = null;
        this.gpT = null;
        this.gpU = null;
        this.gpI = praiseListActivity;
        praiseListActivity.setContentView(e.h.zan_list_activity);
        this.gpJ = praiseListActivity.findViewById(e.g.zan_list_page_parent);
        this.gpK = (NavigationBar) praiseListActivity.findViewById(e.g.zan_list_page_navigationbar);
        this.gpL = praiseListActivity.findViewById(e.g.zan_list_page_frame);
        this.gpM = NoDataViewFactory.a(this.gpI.getPageContext().getContext(), this.gpJ, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.h(this.gpI.getActivity(), e.C0210e.ds320)), NoDataViewFactory.d.eq(e.j.praise_list_no_data), null);
        this.gpP = (BdListView) praiseListActivity.findViewById(e.g.zan_list_page_list);
        TextView textView = new TextView(this.gpI.getActivity());
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)));
        this.gpP.addHeaderView(textView, 0);
        this.gpT = (ProgressBar) praiseListActivity.findViewById(e.g.zan_list_page_progress);
        this.gpH = new c(praiseListActivity);
        this.gpP.setAdapter((ListAdapter) this.gpH);
        this.gpP.setOnScrollListener(this.gpH);
        this.gpK.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.gpK.setTitleText("");
        this.gpN = LayoutInflater.from(praiseListActivity.getPageContext().getContext()).inflate(e.h.zan_list_head, (ViewGroup) null);
        this.gpN.setOnClickListener(praiseListActivity);
        this.gpO = (TextView) this.gpN.findViewById(e.g.zan_list_head_text);
        this.gpO.setText(str);
        this.gpN.setVisibility(8);
        this.gpP.addHeaderView(this.gpN);
        this.gpQ = LayoutInflater.from(praiseListActivity.getPageContext().getContext()).inflate(e.h.zan_list_foot, (ViewGroup) null);
        this.gpR = (TextView) this.gpQ.findViewById(e.g.zan_list_foot_text_continue);
        this.gpS = (TextView) this.gpQ.findViewById(e.g.zan_list_foot_text_more);
        this.gpU = (ProgressBar) this.gpQ.findViewById(e.g.zan_list_foot_progress);
        this.gpQ.setVisibility(8);
        this.gpR.setOnClickListener(praiseListActivity);
        this.gpP.addFooterView(this.gpQ);
        this.gpP.setOnItemClickListener(praiseListActivity);
    }

    public void aRv() {
        if (this.gpH != null) {
            this.gpH.notifyDataSetChanged();
        }
    }

    public void lU(boolean z) {
        if (z) {
            this.gpU.setVisibility(0);
        } else {
            this.gpT.setVisibility(0);
        }
    }

    public void bon() {
        this.gpT.setVisibility(8);
        this.gpU.setVisibility(8);
    }

    public boolean Fi() {
        return this.gpT.getVisibility() == 0 || this.gpU.getVisibility() == 0;
    }

    public void b(int i, List<a> list, int i2, int i3) {
        String format;
        String format2;
        this.gpT.setVisibility(8);
        this.gpU.setVisibility(8);
        this.gpN.setVisibility(0);
        if (i > 0) {
            switch (this.gpI.pageType) {
                case 1:
                    format2 = String.format(this.gpI.getResources().getString(e.j.graffiti_list_title_count), ao.W(i));
                    break;
                default:
                    format2 = String.format(this.gpI.getResources().getString(e.j.praise_list_title_count), ao.W(i));
                    break;
            }
            this.gpK.setTitleText(format2);
        } else {
            this.gpK.setTitleText("");
        }
        if (list == null || list.size() < 1) {
            aM(null, this.gpI.pageType);
            return;
        }
        this.gpL.setVisibility(0);
        this.gpM.setVisibility(8);
        this.gpH.dq(list);
        this.gpH.notifyDataSetChanged();
        switch (i2) {
            case 1001:
                this.gpQ.setVisibility(0);
                this.gpR.setVisibility(0);
                this.gpS.setVisibility(8);
                return;
            case 1002:
                this.gpQ.setVisibility(8);
                return;
            case 1003:
                this.gpQ.setVisibility(0);
                al.i(this.gpQ, e.f.bg_pack);
                this.gpR.setVisibility(8);
                this.gpS.setVisibility(0);
                switch (this.gpI.pageType) {
                    case 1:
                        format = String.format(this.gpI.getResources().getString(e.j.graffiti_list_title_count), ao.W(i));
                        break;
                    default:
                        format = String.format(this.gpI.getResources().getString(e.j.praise_item_more), ao.W(i));
                        break;
                }
                this.gpS.setText(format);
                return;
            default:
                this.gpQ.setVisibility(8);
                return;
        }
    }

    public void aM(String str, int i) {
        this.gpT.setVisibility(8);
        this.gpU.setVisibility(8);
        this.gpL.setVisibility(8);
        this.gpM.setVisibility(0);
        if (!StringUtils.isNull(str)) {
            this.gpM.setTextOption(NoDataViewFactory.d.gn(str));
        } else if (1 == i) {
            this.gpM.setTextOption(NoDataViewFactory.d.eq(e.j.graffiti_list_no_data));
        } else {
            this.gpM.setTextOption(NoDataViewFactory.d.eq(e.j.praise_list_no_data));
        }
    }

    public void a(com.baidu.tbadk.core.c cVar, int i) {
        if (cVar != null) {
            cVar.setNightMode(i == 1);
            cVar.onModeChanged(this.gpJ);
            cVar.onModeChanged(this.gpN);
            cVar.onModeChanged(this.gpQ);
            this.gpK.onChangeSkinType(this.gpI.getPageContext(), i);
            al.i(this.gpQ, e.f.bg_pack);
            if (this.gpM != null) {
                this.gpM.onChangeSkinType(this.gpI.getPageContext(), i);
            }
        }
    }

    public View boo() {
        return this.gpN;
    }

    public View bop() {
        return this.gpR;
    }
}
