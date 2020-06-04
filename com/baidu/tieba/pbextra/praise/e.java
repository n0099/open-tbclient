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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes9.dex */
public class e extends com.baidu.adp.base.c<PraiseListActivity> {
    private ProgressBar kkA;
    private c kkn;
    private PraiseListActivity kko;
    private View kkp;
    private NavigationBar kkq;
    private View kkr;
    private NoDataView kks;
    private View kkt;
    private TextView kku;
    private BdListView kkv;
    private View kkw;
    private TextView kkx;
    private TextView kky;
    private ProgressBar kkz;

    public e(PraiseListActivity praiseListActivity, String str) {
        super(praiseListActivity.getPageContext());
        this.kkn = null;
        this.kko = null;
        this.kkp = null;
        this.kkq = null;
        this.kkr = null;
        this.kks = null;
        this.kkt = null;
        this.kku = null;
        this.kkv = null;
        this.kkw = null;
        this.kkx = null;
        this.kky = null;
        this.kkz = null;
        this.kkA = null;
        this.kko = praiseListActivity;
        praiseListActivity.setContentView(R.layout.zan_list_activity);
        this.kkp = praiseListActivity.findViewById(R.id.zan_list_page_parent);
        this.kkq = (NavigationBar) praiseListActivity.findViewById(R.id.zan_list_page_navigationbar);
        this.kkr = praiseListActivity.findViewById(R.id.zan_list_page_frame);
        this.kks = NoDataViewFactory.a(this.kko.getPageContext().getContext(), this.kkp, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.getDimens(this.kko.getActivity(), R.dimen.ds320)), NoDataViewFactory.d.lV(R.string.praise_list_no_data), null);
        this.kkv = (BdListView) praiseListActivity.findViewById(R.id.zan_list_page_list);
        TextView textView = new TextView(this.kko.getActivity());
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)));
        this.kkv.addHeaderView(textView, 0);
        this.kkz = (ProgressBar) praiseListActivity.findViewById(R.id.zan_list_page_progress);
        this.kkn = new c(praiseListActivity);
        this.kkv.setAdapter((ListAdapter) this.kkn);
        this.kkv.setOnScrollListener(this.kkn);
        this.kkq.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.kkq.setTitleText("");
        this.kkt = LayoutInflater.from(praiseListActivity.getPageContext().getContext()).inflate(R.layout.zan_list_head, (ViewGroup) null);
        this.kkt.setOnClickListener(praiseListActivity);
        this.kku = (TextView) this.kkt.findViewById(R.id.zan_list_head_text);
        this.kku.setText(str);
        this.kkt.setVisibility(8);
        this.kkv.addHeaderView(this.kkt);
        this.kkw = LayoutInflater.from(praiseListActivity.getPageContext().getContext()).inflate(R.layout.zan_list_foot, (ViewGroup) null);
        this.kkx = (TextView) this.kkw.findViewById(R.id.zan_list_foot_text_continue);
        this.kky = (TextView) this.kkw.findViewById(R.id.zan_list_foot_text_more);
        this.kkA = (ProgressBar) this.kkw.findViewById(R.id.zan_list_foot_progress);
        this.kkw.setVisibility(8);
        this.kkx.setOnClickListener(praiseListActivity);
        this.kkv.addFooterView(this.kkw);
        this.kkv.setOnItemClickListener(praiseListActivity);
    }

    public void cmR() {
        if (this.kkn != null) {
            this.kkn.notifyDataSetChanged();
        }
    }

    public void sM(boolean z) {
        if (z) {
            this.kkA.setVisibility(0);
        } else {
            this.kkz.setVisibility(0);
        }
    }

    public void cNf() {
        this.kkz.setVisibility(8);
        this.kkA.setVisibility(8);
    }

    public boolean isLoading() {
        return this.kkz.getVisibility() == 0 || this.kkA.getVisibility() == 0;
    }

    public void b(int i, List<a> list, int i2, int i3) {
        String format;
        String format2;
        this.kkz.setVisibility(8);
        this.kkA.setVisibility(8);
        this.kkt.setVisibility(0);
        if (i > 0) {
            switch (this.kko.pageType) {
                case 1:
                    format2 = String.format(this.kko.getResources().getString(R.string.graffiti_list_title_count), aq.numFormatOverWan(i));
                    break;
                default:
                    format2 = String.format(this.kko.getResources().getString(R.string.praise_list_title_count), aq.numFormatOverWan(i));
                    break;
            }
            this.kkq.setTitleText(format2);
        } else {
            this.kkq.setTitleText("");
        }
        if (list == null || list.size() < 1) {
            bv(null, this.kko.pageType);
            return;
        }
        this.kkr.setVisibility(0);
        this.kks.setVisibility(8);
        this.kkn.ed(list);
        this.kkn.notifyDataSetChanged();
        switch (i2) {
            case 1001:
                this.kkw.setVisibility(0);
                this.kkx.setVisibility(0);
                this.kky.setVisibility(8);
                return;
            case 1002:
                this.kkw.setVisibility(8);
                return;
            case 1003:
                this.kkw.setVisibility(0);
                am.setBackgroundResource(this.kkw, R.drawable.bg_pack);
                this.kkx.setVisibility(8);
                this.kky.setVisibility(0);
                switch (this.kko.pageType) {
                    case 1:
                        format = String.format(this.kko.getResources().getString(R.string.graffiti_list_title_count), aq.numFormatOverWan(i));
                        break;
                    default:
                        format = String.format(this.kko.getResources().getString(R.string.praise_item_more), aq.numFormatOverWan(i));
                        break;
                }
                this.kky.setText(format);
                return;
            default:
                this.kkw.setVisibility(8);
                return;
        }
    }

    public void bv(String str, int i) {
        this.kkz.setVisibility(8);
        this.kkA.setVisibility(8);
        this.kkr.setVisibility(8);
        this.kks.setVisibility(0);
        if (!StringUtils.isNull(str)) {
            this.kks.setTextOption(NoDataViewFactory.d.wR(str));
        } else if (1 == i) {
            this.kks.setTextOption(NoDataViewFactory.d.lV(R.string.graffiti_list_no_data));
        } else {
            this.kks.setTextOption(NoDataViewFactory.d.lV(R.string.praise_list_no_data));
        }
    }

    public void a(com.baidu.tbadk.core.c cVar, int i) {
        if (cVar != null) {
            cVar.setNightMode(i == 1);
            cVar.onModeChanged(this.kkp);
            cVar.onModeChanged(this.kkt);
            cVar.onModeChanged(this.kkw);
            this.kkq.onChangeSkinType(this.kko.getPageContext(), i);
            am.setBackgroundResource(this.kkw, R.drawable.bg_pack);
            if (this.kks != null) {
                this.kks.onChangeSkinType(this.kko.getPageContext(), i);
            }
        }
    }

    public View cNg() {
        return this.kkt;
    }

    public View cNh() {
        return this.kkx;
    }
}
