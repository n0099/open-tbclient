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
    private ProgressBar jRA;
    private ProgressBar jRB;
    private c jRo;
    private PraiseListActivity jRp;
    private View jRq;
    private NavigationBar jRr;
    private View jRs;
    private NoDataView jRt;
    private View jRu;
    private TextView jRv;
    private BdListView jRw;
    private View jRx;
    private TextView jRy;
    private TextView jRz;

    public e(PraiseListActivity praiseListActivity, String str) {
        super(praiseListActivity.getPageContext());
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
        this.jRy = null;
        this.jRz = null;
        this.jRA = null;
        this.jRB = null;
        this.jRp = praiseListActivity;
        praiseListActivity.setContentView(R.layout.zan_list_activity);
        this.jRq = praiseListActivity.findViewById(R.id.zan_list_page_parent);
        this.jRr = (NavigationBar) praiseListActivity.findViewById(R.id.zan_list_page_navigationbar);
        this.jRs = praiseListActivity.findViewById(R.id.zan_list_page_frame);
        this.jRt = NoDataViewFactory.a(this.jRp.getPageContext().getContext(), this.jRq, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.getDimens(this.jRp.getActivity(), R.dimen.ds320)), NoDataViewFactory.d.lr(R.string.praise_list_no_data), null);
        this.jRw = (BdListView) praiseListActivity.findViewById(R.id.zan_list_page_list);
        TextView textView = new TextView(this.jRp.getActivity());
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)));
        this.jRw.addHeaderView(textView, 0);
        this.jRA = (ProgressBar) praiseListActivity.findViewById(R.id.zan_list_page_progress);
        this.jRo = new c(praiseListActivity);
        this.jRw.setAdapter((ListAdapter) this.jRo);
        this.jRw.setOnScrollListener(this.jRo);
        this.jRr.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.jRr.setTitleText("");
        this.jRu = LayoutInflater.from(praiseListActivity.getPageContext().getContext()).inflate(R.layout.zan_list_head, (ViewGroup) null);
        this.jRu.setOnClickListener(praiseListActivity);
        this.jRv = (TextView) this.jRu.findViewById(R.id.zan_list_head_text);
        this.jRv.setText(str);
        this.jRu.setVisibility(8);
        this.jRw.addHeaderView(this.jRu);
        this.jRx = LayoutInflater.from(praiseListActivity.getPageContext().getContext()).inflate(R.layout.zan_list_foot, (ViewGroup) null);
        this.jRy = (TextView) this.jRx.findViewById(R.id.zan_list_foot_text_continue);
        this.jRz = (TextView) this.jRx.findViewById(R.id.zan_list_foot_text_more);
        this.jRB = (ProgressBar) this.jRx.findViewById(R.id.zan_list_foot_progress);
        this.jRx.setVisibility(8);
        this.jRy.setOnClickListener(praiseListActivity);
        this.jRw.addFooterView(this.jRx);
        this.jRw.setOnItemClickListener(praiseListActivity);
    }

    public void cgk() {
        if (this.jRo != null) {
            this.jRo.notifyDataSetChanged();
        }
    }

    public void so(boolean z) {
        if (z) {
            this.jRB.setVisibility(0);
        } else {
            this.jRA.setVisibility(0);
        }
    }

    public void cFP() {
        this.jRA.setVisibility(8);
        this.jRB.setVisibility(8);
    }

    public boolean isLoading() {
        return this.jRA.getVisibility() == 0 || this.jRB.getVisibility() == 0;
    }

    public void b(int i, List<a> list, int i2, int i3) {
        String format;
        String format2;
        this.jRA.setVisibility(8);
        this.jRB.setVisibility(8);
        this.jRu.setVisibility(0);
        if (i > 0) {
            switch (this.jRp.pageType) {
                case 1:
                    format2 = String.format(this.jRp.getResources().getString(R.string.graffiti_list_title_count), aq.numFormatOverWan(i));
                    break;
                default:
                    format2 = String.format(this.jRp.getResources().getString(R.string.praise_list_title_count), aq.numFormatOverWan(i));
                    break;
            }
            this.jRr.setTitleText(format2);
        } else {
            this.jRr.setTitleText("");
        }
        if (list == null || list.size() < 1) {
            bu(null, this.jRp.pageType);
            return;
        }
        this.jRs.setVisibility(0);
        this.jRt.setVisibility(8);
        this.jRo.dV(list);
        this.jRo.notifyDataSetChanged();
        switch (i2) {
            case 1001:
                this.jRx.setVisibility(0);
                this.jRy.setVisibility(0);
                this.jRz.setVisibility(8);
                return;
            case 1002:
                this.jRx.setVisibility(8);
                return;
            case 1003:
                this.jRx.setVisibility(0);
                am.setBackgroundResource(this.jRx, R.drawable.bg_pack);
                this.jRy.setVisibility(8);
                this.jRz.setVisibility(0);
                switch (this.jRp.pageType) {
                    case 1:
                        format = String.format(this.jRp.getResources().getString(R.string.graffiti_list_title_count), aq.numFormatOverWan(i));
                        break;
                    default:
                        format = String.format(this.jRp.getResources().getString(R.string.praise_item_more), aq.numFormatOverWan(i));
                        break;
                }
                this.jRz.setText(format);
                return;
            default:
                this.jRx.setVisibility(8);
                return;
        }
    }

    public void bu(String str, int i) {
        this.jRA.setVisibility(8);
        this.jRB.setVisibility(8);
        this.jRs.setVisibility(8);
        this.jRt.setVisibility(0);
        if (!StringUtils.isNull(str)) {
            this.jRt.setTextOption(NoDataViewFactory.d.vl(str));
        } else if (1 == i) {
            this.jRt.setTextOption(NoDataViewFactory.d.lr(R.string.graffiti_list_no_data));
        } else {
            this.jRt.setTextOption(NoDataViewFactory.d.lr(R.string.praise_list_no_data));
        }
    }

    public void a(com.baidu.tbadk.core.c cVar, int i) {
        if (cVar != null) {
            cVar.setNightMode(i == 1);
            cVar.onModeChanged(this.jRq);
            cVar.onModeChanged(this.jRu);
            cVar.onModeChanged(this.jRx);
            this.jRr.onChangeSkinType(this.jRp.getPageContext(), i);
            am.setBackgroundResource(this.jRx, R.drawable.bg_pack);
            if (this.jRt != null) {
                this.jRt.onChangeSkinType(this.jRp.getPageContext(), i);
            }
        }
    }

    public View cFQ() {
        return this.jRu;
    }

    public View cFR() {
        return this.jRy;
    }
}
