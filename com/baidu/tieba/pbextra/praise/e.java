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
    private c jhc;
    private PraiseListActivity jhd;
    private View jhe;
    private NavigationBar jhf;
    private View jhg;
    private NoDataView jhh;
    private View jhi;
    private TextView jhj;
    private BdListView jhk;
    private View jhl;
    private TextView jhm;
    private TextView jhn;
    private ProgressBar jho;
    private ProgressBar jhp;

    public e(PraiseListActivity praiseListActivity, String str) {
        super(praiseListActivity.getPageContext());
        this.jhc = null;
        this.jhd = null;
        this.jhe = null;
        this.jhf = null;
        this.jhg = null;
        this.jhh = null;
        this.jhi = null;
        this.jhj = null;
        this.jhk = null;
        this.jhl = null;
        this.jhm = null;
        this.jhn = null;
        this.jho = null;
        this.jhp = null;
        this.jhd = praiseListActivity;
        praiseListActivity.setContentView(R.layout.zan_list_activity);
        this.jhe = praiseListActivity.findViewById(R.id.zan_list_page_parent);
        this.jhf = (NavigationBar) praiseListActivity.findViewById(R.id.zan_list_page_navigationbar);
        this.jhg = praiseListActivity.findViewById(R.id.zan_list_page_frame);
        this.jhh = NoDataViewFactory.a(this.jhd.getPageContext().getContext(), this.jhe, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.getDimens(this.jhd.getActivity(), R.dimen.ds320)), NoDataViewFactory.d.lh(R.string.praise_list_no_data), null);
        this.jhk = (BdListView) praiseListActivity.findViewById(R.id.zan_list_page_list);
        TextView textView = new TextView(this.jhd.getActivity());
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)));
        this.jhk.addHeaderView(textView, 0);
        this.jho = (ProgressBar) praiseListActivity.findViewById(R.id.zan_list_page_progress);
        this.jhc = new c(praiseListActivity);
        this.jhk.setAdapter((ListAdapter) this.jhc);
        this.jhk.setOnScrollListener(this.jhc);
        this.jhf.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.jhf.setTitleText("");
        this.jhi = LayoutInflater.from(praiseListActivity.getPageContext().getContext()).inflate(R.layout.zan_list_head, (ViewGroup) null);
        this.jhi.setOnClickListener(praiseListActivity);
        this.jhj = (TextView) this.jhi.findViewById(R.id.zan_list_head_text);
        this.jhj.setText(str);
        this.jhi.setVisibility(8);
        this.jhk.addHeaderView(this.jhi);
        this.jhl = LayoutInflater.from(praiseListActivity.getPageContext().getContext()).inflate(R.layout.zan_list_foot, (ViewGroup) null);
        this.jhm = (TextView) this.jhl.findViewById(R.id.zan_list_foot_text_continue);
        this.jhn = (TextView) this.jhl.findViewById(R.id.zan_list_foot_text_more);
        this.jhp = (ProgressBar) this.jhl.findViewById(R.id.zan_list_foot_progress);
        this.jhl.setVisibility(8);
        this.jhm.setOnClickListener(praiseListActivity);
        this.jhk.addFooterView(this.jhl);
        this.jhk.setOnItemClickListener(praiseListActivity);
    }

    public void bVL() {
        if (this.jhc != null) {
            this.jhc.notifyDataSetChanged();
        }
    }

    public void rk(boolean z) {
        if (z) {
            this.jhp.setVisibility(0);
        } else {
            this.jho.setVisibility(0);
        }
    }

    public void cvl() {
        this.jho.setVisibility(8);
        this.jhp.setVisibility(8);
    }

    public boolean isLoading() {
        return this.jho.getVisibility() == 0 || this.jhp.getVisibility() == 0;
    }

    public void b(int i, List<a> list, int i2, int i3) {
        String format;
        String format2;
        this.jho.setVisibility(8);
        this.jhp.setVisibility(8);
        this.jhi.setVisibility(0);
        if (i > 0) {
            switch (this.jhd.pageType) {
                case 1:
                    format2 = String.format(this.jhd.getResources().getString(R.string.graffiti_list_title_count), aq.numFormatOverWan(i));
                    break;
                default:
                    format2 = String.format(this.jhd.getResources().getString(R.string.praise_list_title_count), aq.numFormatOverWan(i));
                    break;
            }
            this.jhf.setTitleText(format2);
        } else {
            this.jhf.setTitleText("");
        }
        if (list == null || list.size() < 1) {
            bk(null, this.jhd.pageType);
            return;
        }
        this.jhg.setVisibility(0);
        this.jhh.setVisibility(8);
        this.jhc.dK(list);
        this.jhc.notifyDataSetChanged();
        switch (i2) {
            case 1001:
                this.jhl.setVisibility(0);
                this.jhm.setVisibility(0);
                this.jhn.setVisibility(8);
                return;
            case 1002:
                this.jhl.setVisibility(8);
                return;
            case 1003:
                this.jhl.setVisibility(0);
                am.setBackgroundResource(this.jhl, R.drawable.bg_pack);
                this.jhm.setVisibility(8);
                this.jhn.setVisibility(0);
                switch (this.jhd.pageType) {
                    case 1:
                        format = String.format(this.jhd.getResources().getString(R.string.graffiti_list_title_count), aq.numFormatOverWan(i));
                        break;
                    default:
                        format = String.format(this.jhd.getResources().getString(R.string.praise_item_more), aq.numFormatOverWan(i));
                        break;
                }
                this.jhn.setText(format);
                return;
            default:
                this.jhl.setVisibility(8);
                return;
        }
    }

    public void bk(String str, int i) {
        this.jho.setVisibility(8);
        this.jhp.setVisibility(8);
        this.jhg.setVisibility(8);
        this.jhh.setVisibility(0);
        if (!StringUtils.isNull(str)) {
            this.jhh.setTextOption(NoDataViewFactory.d.tU(str));
        } else if (1 == i) {
            this.jhh.setTextOption(NoDataViewFactory.d.lh(R.string.graffiti_list_no_data));
        } else {
            this.jhh.setTextOption(NoDataViewFactory.d.lh(R.string.praise_list_no_data));
        }
    }

    public void a(com.baidu.tbadk.core.c cVar, int i) {
        if (cVar != null) {
            cVar.setNightMode(i == 1);
            cVar.onModeChanged(this.jhe);
            cVar.onModeChanged(this.jhi);
            cVar.onModeChanged(this.jhl);
            this.jhf.onChangeSkinType(this.jhd.getPageContext(), i);
            am.setBackgroundResource(this.jhl, R.drawable.bg_pack);
            if (this.jhh != null) {
                this.jhh.onChangeSkinType(this.jhd.getPageContext(), i);
            }
        }
    }

    public View cvm() {
        return this.jhi;
    }

    public View cvn() {
        return this.jhm;
    }
}
