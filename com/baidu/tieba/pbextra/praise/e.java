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
    private c fBZ;
    private PraiseListActivity fCa;
    private View fCb;
    private NavigationBar fCc;
    private View fCd;
    private NoDataView fCe;
    private View fCf;
    private TextView fCg;
    private BdListView fCh;
    private View fCi;
    private TextView fCj;
    private TextView fCk;
    private ProgressBar fCl;
    private ProgressBar fCm;

    public e(PraiseListActivity praiseListActivity, String str) {
        super(praiseListActivity.getPageContext());
        this.fBZ = null;
        this.fCa = null;
        this.fCb = null;
        this.fCc = null;
        this.fCd = null;
        this.fCe = null;
        this.fCf = null;
        this.fCg = null;
        this.fCh = null;
        this.fCi = null;
        this.fCj = null;
        this.fCk = null;
        this.fCl = null;
        this.fCm = null;
        this.fCa = praiseListActivity;
        praiseListActivity.setContentView(d.i.zan_list_activity);
        this.fCb = praiseListActivity.findViewById(d.g.zan_list_page_parent);
        this.fCc = (NavigationBar) praiseListActivity.findViewById(d.g.zan_list_page_navigationbar);
        this.fCd = praiseListActivity.findViewById(d.g.zan_list_page_frame);
        this.fCe = NoDataViewFactory.a(this.fCa.getPageContext().getContext(), this.fCb, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.e(this.fCa.getActivity(), d.e.ds320)), NoDataViewFactory.d.m16do(d.k.praise_list_no_data), null);
        this.fCh = (BdListView) praiseListActivity.findViewById(d.g.zan_list_page_list);
        TextView textView = new TextView(this.fCa.getActivity());
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)));
        this.fCh.addHeaderView(textView, 0);
        this.fCl = (ProgressBar) praiseListActivity.findViewById(d.g.zan_list_page_progress);
        this.fBZ = new c(praiseListActivity);
        this.fCh.setAdapter((ListAdapter) this.fBZ);
        this.fCh.setOnScrollListener(this.fBZ);
        this.fCc.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.fCc.setTitleText("");
        this.fCf = LayoutInflater.from(praiseListActivity.getPageContext().getContext()).inflate(d.i.zan_list_head, (ViewGroup) null);
        this.fCf.setOnClickListener(praiseListActivity);
        this.fCg = (TextView) this.fCf.findViewById(d.g.zan_list_head_text);
        this.fCg.setText(str);
        this.fCf.setVisibility(8);
        this.fCh.addHeaderView(this.fCf);
        this.fCi = LayoutInflater.from(praiseListActivity.getPageContext().getContext()).inflate(d.i.zan_list_foot, (ViewGroup) null);
        this.fCj = (TextView) this.fCi.findViewById(d.g.zan_list_foot_text_continue);
        this.fCk = (TextView) this.fCi.findViewById(d.g.zan_list_foot_text_more);
        this.fCm = (ProgressBar) this.fCi.findViewById(d.g.zan_list_foot_progress);
        this.fCi.setVisibility(8);
        this.fCj.setOnClickListener(praiseListActivity);
        this.fCh.addFooterView(this.fCi);
        this.fCh.setOnItemClickListener(praiseListActivity);
    }

    public void aEf() {
        if (this.fBZ != null) {
            this.fBZ.notifyDataSetChanged();
        }
    }

    public void kQ(boolean z) {
        if (z) {
            this.fCm.setVisibility(0);
        } else {
            this.fCl.setVisibility(0);
        }
    }

    public void bdu() {
        this.fCl.setVisibility(8);
        this.fCm.setVisibility(8);
    }

    public boolean wX() {
        return this.fCl.getVisibility() == 0 || this.fCm.getVisibility() == 0;
    }

    public void b(int i, List<a> list, int i2, int i3) {
        String format;
        String format2;
        this.fCl.setVisibility(8);
        this.fCm.setVisibility(8);
        this.fCf.setVisibility(0);
        if (i > 0) {
            switch (this.fCa.pageType) {
                case 1:
                    format2 = String.format(this.fCa.getResources().getString(d.k.graffiti_list_title_count), an.B(i));
                    break;
                default:
                    format2 = String.format(this.fCa.getResources().getString(d.k.praise_list_title_count), an.B(i));
                    break;
            }
            this.fCc.setTitleText(format2);
        } else {
            this.fCc.setTitleText("");
        }
        if (list == null || list.size() < 1) {
            aC(null, this.fCa.pageType);
            return;
        }
        this.fCd.setVisibility(0);
        this.fCe.setVisibility(8);
        this.fBZ.cR(list);
        this.fBZ.notifyDataSetChanged();
        switch (i2) {
            case 1001:
                this.fCi.setVisibility(0);
                this.fCj.setVisibility(0);
                this.fCk.setVisibility(8);
                return;
            case 1002:
                this.fCi.setVisibility(8);
                return;
            case 1003:
                this.fCi.setVisibility(0);
                ak.i(this.fCi, d.f.bg_pack);
                this.fCj.setVisibility(8);
                this.fCk.setVisibility(0);
                switch (this.fCa.pageType) {
                    case 1:
                        format = String.format(this.fCa.getResources().getString(d.k.graffiti_list_title_count), an.B(i));
                        break;
                    default:
                        format = String.format(this.fCa.getResources().getString(d.k.praise_item_more), an.B(i));
                        break;
                }
                this.fCk.setText(format);
                return;
            default:
                this.fCi.setVisibility(8);
                return;
        }
    }

    public void aC(String str, int i) {
        this.fCl.setVisibility(8);
        this.fCm.setVisibility(8);
        this.fCd.setVisibility(8);
        this.fCe.setVisibility(0);
        if (!StringUtils.isNull(str)) {
            this.fCe.setTextOption(NoDataViewFactory.d.eL(str));
        } else if (1 == i) {
            this.fCe.setTextOption(NoDataViewFactory.d.m16do(d.k.graffiti_list_no_data));
        } else {
            this.fCe.setTextOption(NoDataViewFactory.d.m16do(d.k.praise_list_no_data));
        }
    }

    public void a(com.baidu.tbadk.core.c cVar, int i) {
        if (cVar != null) {
            cVar.setNightMode(i == 1);
            cVar.u(this.fCb);
            cVar.u(this.fCf);
            cVar.u(this.fCi);
            this.fCc.onChangeSkinType(this.fCa.getPageContext(), i);
            ak.i(this.fCi, d.f.bg_pack);
            if (this.fCe != null) {
                this.fCe.onChangeSkinType(this.fCa.getPageContext(), i);
            }
        }
    }

    public View bdv() {
        return this.fCf;
    }

    public View bdw() {
        return this.fCj;
    }
}
