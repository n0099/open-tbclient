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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes16.dex */
public class e extends com.baidu.adp.base.c<PraiseListActivity> {
    private c kNd;
    private PraiseListActivity kNe;
    private View kNf;
    private NavigationBar kNg;
    private View kNh;
    private NoDataView kNi;
    private View kNj;
    private TextView kNk;
    private BdListView kNl;
    private View kNm;
    private TextView kNn;
    private TextView kNo;
    private ProgressBar kNp;
    private ProgressBar kNq;

    public e(PraiseListActivity praiseListActivity, String str) {
        super(praiseListActivity.getPageContext());
        this.kNd = null;
        this.kNe = null;
        this.kNf = null;
        this.kNg = null;
        this.kNh = null;
        this.kNi = null;
        this.kNj = null;
        this.kNk = null;
        this.kNl = null;
        this.kNm = null;
        this.kNn = null;
        this.kNo = null;
        this.kNp = null;
        this.kNq = null;
        this.kNe = praiseListActivity;
        praiseListActivity.setContentView(R.layout.zan_list_activity);
        this.kNf = praiseListActivity.findViewById(R.id.zan_list_page_parent);
        this.kNg = (NavigationBar) praiseListActivity.findViewById(R.id.zan_list_page_navigationbar);
        this.kNh = praiseListActivity.findViewById(R.id.zan_list_page_frame);
        this.kNi = NoDataViewFactory.a(this.kNe.getPageContext().getContext(), this.kNf, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.getDimens(this.kNe.getActivity(), R.dimen.ds320)), NoDataViewFactory.d.mF(R.string.praise_list_no_data), null);
        this.kNl = (BdListView) praiseListActivity.findViewById(R.id.zan_list_page_list);
        TextView textView = new TextView(this.kNe.getActivity());
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)));
        this.kNl.addHeaderView(textView, 0);
        this.kNp = (ProgressBar) praiseListActivity.findViewById(R.id.zan_list_page_progress);
        this.kNd = new c(praiseListActivity);
        this.kNl.setAdapter((ListAdapter) this.kNd);
        this.kNl.setOnScrollListener(this.kNd);
        this.kNg.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.kNg.setTitleText("");
        this.kNj = LayoutInflater.from(praiseListActivity.getPageContext().getContext()).inflate(R.layout.zan_list_head, (ViewGroup) null);
        this.kNj.setOnClickListener(praiseListActivity);
        this.kNk = (TextView) this.kNj.findViewById(R.id.zan_list_head_text);
        this.kNk.setText(str);
        this.kNj.setVisibility(8);
        this.kNl.addHeaderView(this.kNj);
        this.kNm = LayoutInflater.from(praiseListActivity.getPageContext().getContext()).inflate(R.layout.zan_list_foot, (ViewGroup) null);
        this.kNn = (TextView) this.kNm.findViewById(R.id.zan_list_foot_text_continue);
        this.kNo = (TextView) this.kNm.findViewById(R.id.zan_list_foot_text_more);
        this.kNq = (ProgressBar) this.kNm.findViewById(R.id.zan_list_foot_progress);
        this.kNm.setVisibility(8);
        this.kNn.setOnClickListener(praiseListActivity);
        this.kNl.addFooterView(this.kNm);
        this.kNl.setOnItemClickListener(praiseListActivity);
    }

    public void cuF() {
        if (this.kNd != null) {
            this.kNd.notifyDataSetChanged();
        }
    }

    public void tG(boolean z) {
        if (z) {
            this.kNq.setVisibility(0);
        } else {
            this.kNp.setVisibility(0);
        }
    }

    public void cVn() {
        this.kNp.setVisibility(8);
        this.kNq.setVisibility(8);
    }

    public boolean isLoading() {
        return this.kNp.getVisibility() == 0 || this.kNq.getVisibility() == 0;
    }

    public void b(int i, List<a> list, int i2, int i3) {
        String format;
        String format2;
        this.kNp.setVisibility(8);
        this.kNq.setVisibility(8);
        this.kNj.setVisibility(0);
        if (i > 0) {
            switch (this.kNe.pageType) {
                case 1:
                    format2 = String.format(this.kNe.getResources().getString(R.string.graffiti_list_title_count), as.numFormatOverWan(i));
                    break;
                default:
                    format2 = String.format(this.kNe.getResources().getString(R.string.praise_list_title_count), as.numFormatOverWan(i));
                    break;
            }
            this.kNg.setTitleText(format2);
        } else {
            this.kNg.setTitleText("");
        }
        if (list == null || list.size() < 1) {
            bs(null, this.kNe.pageType);
            return;
        }
        this.kNh.setVisibility(0);
        this.kNi.setVisibility(8);
        this.kNd.ex(list);
        this.kNd.notifyDataSetChanged();
        switch (i2) {
            case 1001:
                this.kNm.setVisibility(0);
                this.kNn.setVisibility(0);
                this.kNo.setVisibility(8);
                return;
            case 1002:
                this.kNm.setVisibility(8);
                return;
            case 1003:
                this.kNm.setVisibility(0);
                ao.setBackgroundResource(this.kNm, R.drawable.bg_pack);
                this.kNn.setVisibility(8);
                this.kNo.setVisibility(0);
                switch (this.kNe.pageType) {
                    case 1:
                        format = String.format(this.kNe.getResources().getString(R.string.graffiti_list_title_count), as.numFormatOverWan(i));
                        break;
                    default:
                        format = String.format(this.kNe.getResources().getString(R.string.praise_item_more), as.numFormatOverWan(i));
                        break;
                }
                this.kNo.setText(format);
                return;
            default:
                this.kNm.setVisibility(8);
                return;
        }
    }

    public void bs(String str, int i) {
        this.kNp.setVisibility(8);
        this.kNq.setVisibility(8);
        this.kNh.setVisibility(8);
        this.kNi.setVisibility(0);
        if (!StringUtils.isNull(str)) {
            this.kNi.setTextOption(NoDataViewFactory.d.yn(str));
        } else if (1 == i) {
            this.kNi.setTextOption(NoDataViewFactory.d.mF(R.string.graffiti_list_no_data));
        } else {
            this.kNi.setTextOption(NoDataViewFactory.d.mF(R.string.praise_list_no_data));
        }
    }

    public void a(com.baidu.tbadk.core.c cVar, int i) {
        if (cVar != null) {
            cVar.setNightMode(i == 1);
            cVar.onModeChanged(this.kNf);
            cVar.onModeChanged(this.kNj);
            cVar.onModeChanged(this.kNm);
            this.kNg.onChangeSkinType(this.kNe.getPageContext(), i);
            ao.setBackgroundResource(this.kNm, R.drawable.bg_pack);
            if (this.kNi != null) {
                this.kNi.onChangeSkinType(this.kNe.getPageContext(), i);
            }
        }
    }

    public View cVo() {
        return this.kNj;
    }

    public View cVp() {
        return this.kNn;
    }
}
