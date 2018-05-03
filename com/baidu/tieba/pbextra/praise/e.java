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
    private c fBW;
    private PraiseListActivity fBX;
    private View fBY;
    private NavigationBar fBZ;
    private View fCa;
    private NoDataView fCb;
    private View fCc;
    private TextView fCd;
    private BdListView fCe;
    private View fCf;
    private TextView fCg;
    private TextView fCh;
    private ProgressBar fCi;
    private ProgressBar fCj;

    public e(PraiseListActivity praiseListActivity, String str) {
        super(praiseListActivity.getPageContext());
        this.fBW = null;
        this.fBX = null;
        this.fBY = null;
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
        this.fBX = praiseListActivity;
        praiseListActivity.setContentView(d.i.zan_list_activity);
        this.fBY = praiseListActivity.findViewById(d.g.zan_list_page_parent);
        this.fBZ = (NavigationBar) praiseListActivity.findViewById(d.g.zan_list_page_navigationbar);
        this.fCa = praiseListActivity.findViewById(d.g.zan_list_page_frame);
        this.fCb = NoDataViewFactory.a(this.fBX.getPageContext().getContext(), this.fBY, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.e(this.fBX.getActivity(), d.e.ds320)), NoDataViewFactory.d.m16do(d.k.praise_list_no_data), null);
        this.fCe = (BdListView) praiseListActivity.findViewById(d.g.zan_list_page_list);
        TextView textView = new TextView(this.fBX.getActivity());
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)));
        this.fCe.addHeaderView(textView, 0);
        this.fCi = (ProgressBar) praiseListActivity.findViewById(d.g.zan_list_page_progress);
        this.fBW = new c(praiseListActivity);
        this.fCe.setAdapter((ListAdapter) this.fBW);
        this.fCe.setOnScrollListener(this.fBW);
        this.fBZ.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.fBZ.setTitleText("");
        this.fCc = LayoutInflater.from(praiseListActivity.getPageContext().getContext()).inflate(d.i.zan_list_head, (ViewGroup) null);
        this.fCc.setOnClickListener(praiseListActivity);
        this.fCd = (TextView) this.fCc.findViewById(d.g.zan_list_head_text);
        this.fCd.setText(str);
        this.fCc.setVisibility(8);
        this.fCe.addHeaderView(this.fCc);
        this.fCf = LayoutInflater.from(praiseListActivity.getPageContext().getContext()).inflate(d.i.zan_list_foot, (ViewGroup) null);
        this.fCg = (TextView) this.fCf.findViewById(d.g.zan_list_foot_text_continue);
        this.fCh = (TextView) this.fCf.findViewById(d.g.zan_list_foot_text_more);
        this.fCj = (ProgressBar) this.fCf.findViewById(d.g.zan_list_foot_progress);
        this.fCf.setVisibility(8);
        this.fCg.setOnClickListener(praiseListActivity);
        this.fCe.addFooterView(this.fCf);
        this.fCe.setOnItemClickListener(praiseListActivity);
    }

    public void aEf() {
        if (this.fBW != null) {
            this.fBW.notifyDataSetChanged();
        }
    }

    public void kQ(boolean z) {
        if (z) {
            this.fCj.setVisibility(0);
        } else {
            this.fCi.setVisibility(0);
        }
    }

    public void bdu() {
        this.fCi.setVisibility(8);
        this.fCj.setVisibility(8);
    }

    public boolean wX() {
        return this.fCi.getVisibility() == 0 || this.fCj.getVisibility() == 0;
    }

    public void b(int i, List<a> list, int i2, int i3) {
        String format;
        String format2;
        this.fCi.setVisibility(8);
        this.fCj.setVisibility(8);
        this.fCc.setVisibility(0);
        if (i > 0) {
            switch (this.fBX.pageType) {
                case 1:
                    format2 = String.format(this.fBX.getResources().getString(d.k.graffiti_list_title_count), an.B(i));
                    break;
                default:
                    format2 = String.format(this.fBX.getResources().getString(d.k.praise_list_title_count), an.B(i));
                    break;
            }
            this.fBZ.setTitleText(format2);
        } else {
            this.fBZ.setTitleText("");
        }
        if (list == null || list.size() < 1) {
            aC(null, this.fBX.pageType);
            return;
        }
        this.fCa.setVisibility(0);
        this.fCb.setVisibility(8);
        this.fBW.cR(list);
        this.fBW.notifyDataSetChanged();
        switch (i2) {
            case 1001:
                this.fCf.setVisibility(0);
                this.fCg.setVisibility(0);
                this.fCh.setVisibility(8);
                return;
            case 1002:
                this.fCf.setVisibility(8);
                return;
            case 1003:
                this.fCf.setVisibility(0);
                ak.i(this.fCf, d.f.bg_pack);
                this.fCg.setVisibility(8);
                this.fCh.setVisibility(0);
                switch (this.fBX.pageType) {
                    case 1:
                        format = String.format(this.fBX.getResources().getString(d.k.graffiti_list_title_count), an.B(i));
                        break;
                    default:
                        format = String.format(this.fBX.getResources().getString(d.k.praise_item_more), an.B(i));
                        break;
                }
                this.fCh.setText(format);
                return;
            default:
                this.fCf.setVisibility(8);
                return;
        }
    }

    public void aC(String str, int i) {
        this.fCi.setVisibility(8);
        this.fCj.setVisibility(8);
        this.fCa.setVisibility(8);
        this.fCb.setVisibility(0);
        if (!StringUtils.isNull(str)) {
            this.fCb.setTextOption(NoDataViewFactory.d.eL(str));
        } else if (1 == i) {
            this.fCb.setTextOption(NoDataViewFactory.d.m16do(d.k.graffiti_list_no_data));
        } else {
            this.fCb.setTextOption(NoDataViewFactory.d.m16do(d.k.praise_list_no_data));
        }
    }

    public void a(com.baidu.tbadk.core.c cVar, int i) {
        if (cVar != null) {
            cVar.setNightMode(i == 1);
            cVar.u(this.fBY);
            cVar.u(this.fCc);
            cVar.u(this.fCf);
            this.fBZ.onChangeSkinType(this.fBX.getPageContext(), i);
            ak.i(this.fCf, d.f.bg_pack);
            if (this.fCb != null) {
                this.fCb.onChangeSkinType(this.fBX.getPageContext(), i);
            }
        }
    }

    public View bdv() {
        return this.fCc;
    }

    public View bdw() {
        return this.fCg;
    }
}
