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
    private c kNb;
    private PraiseListActivity kNc;
    private View kNd;
    private NavigationBar kNe;
    private View kNf;
    private NoDataView kNg;
    private View kNh;
    private TextView kNi;
    private BdListView kNj;
    private View kNk;
    private TextView kNl;
    private TextView kNm;
    private ProgressBar kNn;
    private ProgressBar kNo;

    public e(PraiseListActivity praiseListActivity, String str) {
        super(praiseListActivity.getPageContext());
        this.kNb = null;
        this.kNc = null;
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
        this.kNc = praiseListActivity;
        praiseListActivity.setContentView(R.layout.zan_list_activity);
        this.kNd = praiseListActivity.findViewById(R.id.zan_list_page_parent);
        this.kNe = (NavigationBar) praiseListActivity.findViewById(R.id.zan_list_page_navigationbar);
        this.kNf = praiseListActivity.findViewById(R.id.zan_list_page_frame);
        this.kNg = NoDataViewFactory.a(this.kNc.getPageContext().getContext(), this.kNd, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.getDimens(this.kNc.getActivity(), R.dimen.ds320)), NoDataViewFactory.d.mF(R.string.praise_list_no_data), null);
        this.kNj = (BdListView) praiseListActivity.findViewById(R.id.zan_list_page_list);
        TextView textView = new TextView(this.kNc.getActivity());
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)));
        this.kNj.addHeaderView(textView, 0);
        this.kNn = (ProgressBar) praiseListActivity.findViewById(R.id.zan_list_page_progress);
        this.kNb = new c(praiseListActivity);
        this.kNj.setAdapter((ListAdapter) this.kNb);
        this.kNj.setOnScrollListener(this.kNb);
        this.kNe.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.kNe.setTitleText("");
        this.kNh = LayoutInflater.from(praiseListActivity.getPageContext().getContext()).inflate(R.layout.zan_list_head, (ViewGroup) null);
        this.kNh.setOnClickListener(praiseListActivity);
        this.kNi = (TextView) this.kNh.findViewById(R.id.zan_list_head_text);
        this.kNi.setText(str);
        this.kNh.setVisibility(8);
        this.kNj.addHeaderView(this.kNh);
        this.kNk = LayoutInflater.from(praiseListActivity.getPageContext().getContext()).inflate(R.layout.zan_list_foot, (ViewGroup) null);
        this.kNl = (TextView) this.kNk.findViewById(R.id.zan_list_foot_text_continue);
        this.kNm = (TextView) this.kNk.findViewById(R.id.zan_list_foot_text_more);
        this.kNo = (ProgressBar) this.kNk.findViewById(R.id.zan_list_foot_progress);
        this.kNk.setVisibility(8);
        this.kNl.setOnClickListener(praiseListActivity);
        this.kNj.addFooterView(this.kNk);
        this.kNj.setOnItemClickListener(praiseListActivity);
    }

    public void cuF() {
        if (this.kNb != null) {
            this.kNb.notifyDataSetChanged();
        }
    }

    public void tG(boolean z) {
        if (z) {
            this.kNo.setVisibility(0);
        } else {
            this.kNn.setVisibility(0);
        }
    }

    public void cVn() {
        this.kNn.setVisibility(8);
        this.kNo.setVisibility(8);
    }

    public boolean isLoading() {
        return this.kNn.getVisibility() == 0 || this.kNo.getVisibility() == 0;
    }

    public void b(int i, List<a> list, int i2, int i3) {
        String format;
        String format2;
        this.kNn.setVisibility(8);
        this.kNo.setVisibility(8);
        this.kNh.setVisibility(0);
        if (i > 0) {
            switch (this.kNc.pageType) {
                case 1:
                    format2 = String.format(this.kNc.getResources().getString(R.string.graffiti_list_title_count), as.numFormatOverWan(i));
                    break;
                default:
                    format2 = String.format(this.kNc.getResources().getString(R.string.praise_list_title_count), as.numFormatOverWan(i));
                    break;
            }
            this.kNe.setTitleText(format2);
        } else {
            this.kNe.setTitleText("");
        }
        if (list == null || list.size() < 1) {
            bs(null, this.kNc.pageType);
            return;
        }
        this.kNf.setVisibility(0);
        this.kNg.setVisibility(8);
        this.kNb.ex(list);
        this.kNb.notifyDataSetChanged();
        switch (i2) {
            case 1001:
                this.kNk.setVisibility(0);
                this.kNl.setVisibility(0);
                this.kNm.setVisibility(8);
                return;
            case 1002:
                this.kNk.setVisibility(8);
                return;
            case 1003:
                this.kNk.setVisibility(0);
                ao.setBackgroundResource(this.kNk, R.drawable.bg_pack);
                this.kNl.setVisibility(8);
                this.kNm.setVisibility(0);
                switch (this.kNc.pageType) {
                    case 1:
                        format = String.format(this.kNc.getResources().getString(R.string.graffiti_list_title_count), as.numFormatOverWan(i));
                        break;
                    default:
                        format = String.format(this.kNc.getResources().getString(R.string.praise_item_more), as.numFormatOverWan(i));
                        break;
                }
                this.kNm.setText(format);
                return;
            default:
                this.kNk.setVisibility(8);
                return;
        }
    }

    public void bs(String str, int i) {
        this.kNn.setVisibility(8);
        this.kNo.setVisibility(8);
        this.kNf.setVisibility(8);
        this.kNg.setVisibility(0);
        if (!StringUtils.isNull(str)) {
            this.kNg.setTextOption(NoDataViewFactory.d.yn(str));
        } else if (1 == i) {
            this.kNg.setTextOption(NoDataViewFactory.d.mF(R.string.graffiti_list_no_data));
        } else {
            this.kNg.setTextOption(NoDataViewFactory.d.mF(R.string.praise_list_no_data));
        }
    }

    public void a(com.baidu.tbadk.core.c cVar, int i) {
        if (cVar != null) {
            cVar.setNightMode(i == 1);
            cVar.onModeChanged(this.kNd);
            cVar.onModeChanged(this.kNh);
            cVar.onModeChanged(this.kNk);
            this.kNe.onChangeSkinType(this.kNc.getPageContext(), i);
            ao.setBackgroundResource(this.kNk, R.drawable.bg_pack);
            if (this.kNg != null) {
                this.kNg.onChangeSkinType(this.kNc.getPageContext(), i);
            }
        }
    }

    public View cVo() {
        return this.kNh;
    }

    public View cVp() {
        return this.kNl;
    }
}
