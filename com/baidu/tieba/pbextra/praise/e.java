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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.d;
import java.util.List;
/* loaded from: classes3.dex */
public class e extends com.baidu.adp.base.c<PraiseListActivity> {
    private c fDc;
    private PraiseListActivity fDd;
    private View fDe;
    private NavigationBar fDf;
    private View fDg;
    private NoDataView fDh;
    private View fDi;
    private TextView fDj;
    private BdListView fDk;
    private View fDl;
    private TextView fDm;
    private TextView fDn;
    private ProgressBar fDo;
    private ProgressBar fDp;

    public e(PraiseListActivity praiseListActivity, String str) {
        super(praiseListActivity.getPageContext());
        this.fDc = null;
        this.fDd = null;
        this.fDe = null;
        this.fDf = null;
        this.fDg = null;
        this.fDh = null;
        this.fDi = null;
        this.fDj = null;
        this.fDk = null;
        this.fDl = null;
        this.fDm = null;
        this.fDn = null;
        this.fDo = null;
        this.fDp = null;
        this.fDd = praiseListActivity;
        praiseListActivity.setContentView(d.i.zan_list_activity);
        this.fDe = praiseListActivity.findViewById(d.g.zan_list_page_parent);
        this.fDf = (NavigationBar) praiseListActivity.findViewById(d.g.zan_list_page_navigationbar);
        this.fDg = praiseListActivity.findViewById(d.g.zan_list_page_frame);
        this.fDh = NoDataViewFactory.a(this.fDd.getPageContext().getContext(), this.fDe, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.e(this.fDd.getActivity(), d.e.ds320)), NoDataViewFactory.d.dp(d.k.praise_list_no_data), null);
        this.fDk = (BdListView) praiseListActivity.findViewById(d.g.zan_list_page_list);
        TextView textView = new TextView(this.fDd.getActivity());
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)));
        this.fDk.addHeaderView(textView, 0);
        this.fDo = (ProgressBar) praiseListActivity.findViewById(d.g.zan_list_page_progress);
        this.fDc = new c(praiseListActivity);
        this.fDk.setAdapter((ListAdapter) this.fDc);
        this.fDk.setOnScrollListener(this.fDc);
        this.fDf.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.fDf.setTitleText("");
        this.fDi = LayoutInflater.from(praiseListActivity.getPageContext().getContext()).inflate(d.i.zan_list_head, (ViewGroup) null);
        this.fDi.setOnClickListener(praiseListActivity);
        this.fDj = (TextView) this.fDi.findViewById(d.g.zan_list_head_text);
        this.fDj.setText(str);
        this.fDi.setVisibility(8);
        this.fDk.addHeaderView(this.fDi);
        this.fDl = LayoutInflater.from(praiseListActivity.getPageContext().getContext()).inflate(d.i.zan_list_foot, (ViewGroup) null);
        this.fDm = (TextView) this.fDl.findViewById(d.g.zan_list_foot_text_continue);
        this.fDn = (TextView) this.fDl.findViewById(d.g.zan_list_foot_text_more);
        this.fDp = (ProgressBar) this.fDl.findViewById(d.g.zan_list_foot_progress);
        this.fDl.setVisibility(8);
        this.fDm.setOnClickListener(praiseListActivity);
        this.fDk.addFooterView(this.fDl);
        this.fDk.setOnItemClickListener(praiseListActivity);
    }

    public void aEd() {
        if (this.fDc != null) {
            this.fDc.notifyDataSetChanged();
        }
    }

    public void kR(boolean z) {
        if (z) {
            this.fDp.setVisibility(0);
        } else {
            this.fDo.setVisibility(0);
        }
    }

    public void bdu() {
        this.fDo.setVisibility(8);
        this.fDp.setVisibility(8);
    }

    public boolean wW() {
        return this.fDo.getVisibility() == 0 || this.fDp.getVisibility() == 0;
    }

    public void b(int i, List<a> list, int i2, int i3) {
        String format;
        String format2;
        this.fDo.setVisibility(8);
        this.fDp.setVisibility(8);
        this.fDi.setVisibility(0);
        if (i > 0) {
            switch (this.fDd.pageType) {
                case 1:
                    format2 = String.format(this.fDd.getResources().getString(d.k.graffiti_list_title_count), an.B(i));
                    break;
                default:
                    format2 = String.format(this.fDd.getResources().getString(d.k.praise_list_title_count), an.B(i));
                    break;
            }
            this.fDf.setTitleText(format2);
        } else {
            this.fDf.setTitleText("");
        }
        if (list == null || list.size() < 1) {
            aC(null, this.fDd.pageType);
            return;
        }
        this.fDg.setVisibility(0);
        this.fDh.setVisibility(8);
        this.fDc.cU(list);
        this.fDc.notifyDataSetChanged();
        switch (i2) {
            case 1001:
                this.fDl.setVisibility(0);
                this.fDm.setVisibility(0);
                this.fDn.setVisibility(8);
                return;
            case 1002:
                this.fDl.setVisibility(8);
                return;
            case 1003:
                this.fDl.setVisibility(0);
                ak.i(this.fDl, d.f.bg_pack);
                this.fDm.setVisibility(8);
                this.fDn.setVisibility(0);
                switch (this.fDd.pageType) {
                    case 1:
                        format = String.format(this.fDd.getResources().getString(d.k.graffiti_list_title_count), an.B(i));
                        break;
                    default:
                        format = String.format(this.fDd.getResources().getString(d.k.praise_item_more), an.B(i));
                        break;
                }
                this.fDn.setText(format);
                return;
            default:
                this.fDl.setVisibility(8);
                return;
        }
    }

    public void aC(String str, int i) {
        this.fDo.setVisibility(8);
        this.fDp.setVisibility(8);
        this.fDg.setVisibility(8);
        this.fDh.setVisibility(0);
        if (!StringUtils.isNull(str)) {
            this.fDh.setTextOption(NoDataViewFactory.d.eL(str));
        } else if (1 == i) {
            this.fDh.setTextOption(NoDataViewFactory.d.dp(d.k.graffiti_list_no_data));
        } else {
            this.fDh.setTextOption(NoDataViewFactory.d.dp(d.k.praise_list_no_data));
        }
    }

    public void a(com.baidu.tbadk.core.c cVar, int i) {
        if (cVar != null) {
            cVar.setNightMode(i == 1);
            cVar.u(this.fDe);
            cVar.u(this.fDi);
            cVar.u(this.fDl);
            this.fDf.onChangeSkinType(this.fDd.getPageContext(), i);
            ak.i(this.fDl, d.f.bg_pack);
            if (this.fDh != null) {
                this.fDh.onChangeSkinType(this.fDd.getPageContext(), i);
            }
        }
    }

    public View bdv() {
        return this.fDi;
    }

    public View bdw() {
        return this.fDm;
    }
}
