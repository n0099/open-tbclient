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
    private c jRk;
    private PraiseListActivity jRl;
    private View jRm;
    private NavigationBar jRn;
    private View jRo;
    private NoDataView jRp;
    private View jRq;
    private TextView jRr;
    private BdListView jRs;
    private View jRt;
    private TextView jRu;
    private TextView jRv;
    private ProgressBar jRw;
    private ProgressBar jRx;

    public e(PraiseListActivity praiseListActivity, String str) {
        super(praiseListActivity.getPageContext());
        this.jRk = null;
        this.jRl = null;
        this.jRm = null;
        this.jRn = null;
        this.jRo = null;
        this.jRp = null;
        this.jRq = null;
        this.jRr = null;
        this.jRs = null;
        this.jRt = null;
        this.jRu = null;
        this.jRv = null;
        this.jRw = null;
        this.jRx = null;
        this.jRl = praiseListActivity;
        praiseListActivity.setContentView(R.layout.zan_list_activity);
        this.jRm = praiseListActivity.findViewById(R.id.zan_list_page_parent);
        this.jRn = (NavigationBar) praiseListActivity.findViewById(R.id.zan_list_page_navigationbar);
        this.jRo = praiseListActivity.findViewById(R.id.zan_list_page_frame);
        this.jRp = NoDataViewFactory.a(this.jRl.getPageContext().getContext(), this.jRm, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.getDimens(this.jRl.getActivity(), R.dimen.ds320)), NoDataViewFactory.d.lr(R.string.praise_list_no_data), null);
        this.jRs = (BdListView) praiseListActivity.findViewById(R.id.zan_list_page_list);
        TextView textView = new TextView(this.jRl.getActivity());
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)));
        this.jRs.addHeaderView(textView, 0);
        this.jRw = (ProgressBar) praiseListActivity.findViewById(R.id.zan_list_page_progress);
        this.jRk = new c(praiseListActivity);
        this.jRs.setAdapter((ListAdapter) this.jRk);
        this.jRs.setOnScrollListener(this.jRk);
        this.jRn.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.jRn.setTitleText("");
        this.jRq = LayoutInflater.from(praiseListActivity.getPageContext().getContext()).inflate(R.layout.zan_list_head, (ViewGroup) null);
        this.jRq.setOnClickListener(praiseListActivity);
        this.jRr = (TextView) this.jRq.findViewById(R.id.zan_list_head_text);
        this.jRr.setText(str);
        this.jRq.setVisibility(8);
        this.jRs.addHeaderView(this.jRq);
        this.jRt = LayoutInflater.from(praiseListActivity.getPageContext().getContext()).inflate(R.layout.zan_list_foot, (ViewGroup) null);
        this.jRu = (TextView) this.jRt.findViewById(R.id.zan_list_foot_text_continue);
        this.jRv = (TextView) this.jRt.findViewById(R.id.zan_list_foot_text_more);
        this.jRx = (ProgressBar) this.jRt.findViewById(R.id.zan_list_foot_progress);
        this.jRt.setVisibility(8);
        this.jRu.setOnClickListener(praiseListActivity);
        this.jRs.addFooterView(this.jRt);
        this.jRs.setOnItemClickListener(praiseListActivity);
    }

    public void cgm() {
        if (this.jRk != null) {
            this.jRk.notifyDataSetChanged();
        }
    }

    public void so(boolean z) {
        if (z) {
            this.jRx.setVisibility(0);
        } else {
            this.jRw.setVisibility(0);
        }
    }

    public void cFS() {
        this.jRw.setVisibility(8);
        this.jRx.setVisibility(8);
    }

    public boolean isLoading() {
        return this.jRw.getVisibility() == 0 || this.jRx.getVisibility() == 0;
    }

    public void b(int i, List<a> list, int i2, int i3) {
        String format;
        String format2;
        this.jRw.setVisibility(8);
        this.jRx.setVisibility(8);
        this.jRq.setVisibility(0);
        if (i > 0) {
            switch (this.jRl.pageType) {
                case 1:
                    format2 = String.format(this.jRl.getResources().getString(R.string.graffiti_list_title_count), aq.numFormatOverWan(i));
                    break;
                default:
                    format2 = String.format(this.jRl.getResources().getString(R.string.praise_list_title_count), aq.numFormatOverWan(i));
                    break;
            }
            this.jRn.setTitleText(format2);
        } else {
            this.jRn.setTitleText("");
        }
        if (list == null || list.size() < 1) {
            bu(null, this.jRl.pageType);
            return;
        }
        this.jRo.setVisibility(0);
        this.jRp.setVisibility(8);
        this.jRk.dV(list);
        this.jRk.notifyDataSetChanged();
        switch (i2) {
            case 1001:
                this.jRt.setVisibility(0);
                this.jRu.setVisibility(0);
                this.jRv.setVisibility(8);
                return;
            case 1002:
                this.jRt.setVisibility(8);
                return;
            case 1003:
                this.jRt.setVisibility(0);
                am.setBackgroundResource(this.jRt, R.drawable.bg_pack);
                this.jRu.setVisibility(8);
                this.jRv.setVisibility(0);
                switch (this.jRl.pageType) {
                    case 1:
                        format = String.format(this.jRl.getResources().getString(R.string.graffiti_list_title_count), aq.numFormatOverWan(i));
                        break;
                    default:
                        format = String.format(this.jRl.getResources().getString(R.string.praise_item_more), aq.numFormatOverWan(i));
                        break;
                }
                this.jRv.setText(format);
                return;
            default:
                this.jRt.setVisibility(8);
                return;
        }
    }

    public void bu(String str, int i) {
        this.jRw.setVisibility(8);
        this.jRx.setVisibility(8);
        this.jRo.setVisibility(8);
        this.jRp.setVisibility(0);
        if (!StringUtils.isNull(str)) {
            this.jRp.setTextOption(NoDataViewFactory.d.vi(str));
        } else if (1 == i) {
            this.jRp.setTextOption(NoDataViewFactory.d.lr(R.string.graffiti_list_no_data));
        } else {
            this.jRp.setTextOption(NoDataViewFactory.d.lr(R.string.praise_list_no_data));
        }
    }

    public void a(com.baidu.tbadk.core.c cVar, int i) {
        if (cVar != null) {
            cVar.setNightMode(i == 1);
            cVar.onModeChanged(this.jRm);
            cVar.onModeChanged(this.jRq);
            cVar.onModeChanged(this.jRt);
            this.jRn.onChangeSkinType(this.jRl.getPageContext(), i);
            am.setBackgroundResource(this.jRt, R.drawable.bg_pack);
            if (this.jRp != null) {
                this.jRp.onChangeSkinType(this.jRl.getPageContext(), i);
            }
        }
    }

    public View cFT() {
        return this.jRq;
    }

    public View cFU() {
        return this.jRu;
    }
}
