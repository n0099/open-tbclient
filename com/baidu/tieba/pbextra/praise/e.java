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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes9.dex */
public class e extends com.baidu.adp.base.c<PraiseListActivity> {
    private c kDZ;
    private PraiseListActivity kEa;
    private View kEb;
    private NavigationBar kEc;
    private View kEd;
    private NoDataView kEe;
    private View kEf;
    private TextView kEg;
    private BdListView kEh;
    private View kEi;
    private TextView kEj;
    private TextView kEk;
    private ProgressBar kEl;
    private ProgressBar kEm;

    public e(PraiseListActivity praiseListActivity, String str) {
        super(praiseListActivity.getPageContext());
        this.kDZ = null;
        this.kEa = null;
        this.kEb = null;
        this.kEc = null;
        this.kEd = null;
        this.kEe = null;
        this.kEf = null;
        this.kEg = null;
        this.kEh = null;
        this.kEi = null;
        this.kEj = null;
        this.kEk = null;
        this.kEl = null;
        this.kEm = null;
        this.kEa = praiseListActivity;
        praiseListActivity.setContentView(R.layout.zan_list_activity);
        this.kEb = praiseListActivity.findViewById(R.id.zan_list_page_parent);
        this.kEc = (NavigationBar) praiseListActivity.findViewById(R.id.zan_list_page_navigationbar);
        this.kEd = praiseListActivity.findViewById(R.id.zan_list_page_frame);
        this.kEe = NoDataViewFactory.a(this.kEa.getPageContext().getContext(), this.kEb, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.getDimens(this.kEa.getActivity(), R.dimen.ds320)), NoDataViewFactory.d.mm(R.string.praise_list_no_data), null);
        this.kEh = (BdListView) praiseListActivity.findViewById(R.id.zan_list_page_list);
        TextView textView = new TextView(this.kEa.getActivity());
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)));
        this.kEh.addHeaderView(textView, 0);
        this.kEl = (ProgressBar) praiseListActivity.findViewById(R.id.zan_list_page_progress);
        this.kDZ = new c(praiseListActivity);
        this.kEh.setAdapter((ListAdapter) this.kDZ);
        this.kEh.setOnScrollListener(this.kDZ);
        this.kEc.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.kEc.setTitleText("");
        this.kEf = LayoutInflater.from(praiseListActivity.getPageContext().getContext()).inflate(R.layout.zan_list_head, (ViewGroup) null);
        this.kEf.setOnClickListener(praiseListActivity);
        this.kEg = (TextView) this.kEf.findViewById(R.id.zan_list_head_text);
        this.kEg.setText(str);
        this.kEf.setVisibility(8);
        this.kEh.addHeaderView(this.kEf);
        this.kEi = LayoutInflater.from(praiseListActivity.getPageContext().getContext()).inflate(R.layout.zan_list_foot, (ViewGroup) null);
        this.kEj = (TextView) this.kEi.findViewById(R.id.zan_list_foot_text_continue);
        this.kEk = (TextView) this.kEi.findViewById(R.id.zan_list_foot_text_more);
        this.kEm = (ProgressBar) this.kEi.findViewById(R.id.zan_list_foot_progress);
        this.kEi.setVisibility(8);
        this.kEj.setOnClickListener(praiseListActivity);
        this.kEh.addFooterView(this.kEi);
        this.kEh.setOnItemClickListener(praiseListActivity);
    }

    public void cqG() {
        if (this.kDZ != null) {
            this.kDZ.notifyDataSetChanged();
        }
    }

    public void ta(boolean z) {
        if (z) {
            this.kEm.setVisibility(0);
        } else {
            this.kEl.setVisibility(0);
        }
    }

    public void cRw() {
        this.kEl.setVisibility(8);
        this.kEm.setVisibility(8);
    }

    public boolean isLoading() {
        return this.kEl.getVisibility() == 0 || this.kEm.getVisibility() == 0;
    }

    public void b(int i, List<a> list, int i2, int i3) {
        String format;
        String format2;
        this.kEl.setVisibility(8);
        this.kEm.setVisibility(8);
        this.kEf.setVisibility(0);
        if (i > 0) {
            switch (this.kEa.pageType) {
                case 1:
                    format2 = String.format(this.kEa.getResources().getString(R.string.graffiti_list_title_count), ar.numFormatOverWan(i));
                    break;
                default:
                    format2 = String.format(this.kEa.getResources().getString(R.string.praise_list_title_count), ar.numFormatOverWan(i));
                    break;
            }
            this.kEc.setTitleText(format2);
        } else {
            this.kEc.setTitleText("");
        }
        if (list == null || list.size() < 1) {
            bu(null, this.kEa.pageType);
            return;
        }
        this.kEd.setVisibility(0);
        this.kEe.setVisibility(8);
        this.kDZ.er(list);
        this.kDZ.notifyDataSetChanged();
        switch (i2) {
            case 1001:
                this.kEi.setVisibility(0);
                this.kEj.setVisibility(0);
                this.kEk.setVisibility(8);
                return;
            case 1002:
                this.kEi.setVisibility(8);
                return;
            case 1003:
                this.kEi.setVisibility(0);
                an.setBackgroundResource(this.kEi, R.drawable.bg_pack);
                this.kEj.setVisibility(8);
                this.kEk.setVisibility(0);
                switch (this.kEa.pageType) {
                    case 1:
                        format = String.format(this.kEa.getResources().getString(R.string.graffiti_list_title_count), ar.numFormatOverWan(i));
                        break;
                    default:
                        format = String.format(this.kEa.getResources().getString(R.string.praise_item_more), ar.numFormatOverWan(i));
                        break;
                }
                this.kEk.setText(format);
                return;
            default:
                this.kEi.setVisibility(8);
                return;
        }
    }

    public void bu(String str, int i) {
        this.kEl.setVisibility(8);
        this.kEm.setVisibility(8);
        this.kEd.setVisibility(8);
        this.kEe.setVisibility(0);
        if (!StringUtils.isNull(str)) {
            this.kEe.setTextOption(NoDataViewFactory.d.xi(str));
        } else if (1 == i) {
            this.kEe.setTextOption(NoDataViewFactory.d.mm(R.string.graffiti_list_no_data));
        } else {
            this.kEe.setTextOption(NoDataViewFactory.d.mm(R.string.praise_list_no_data));
        }
    }

    public void a(com.baidu.tbadk.core.c cVar, int i) {
        if (cVar != null) {
            cVar.setNightMode(i == 1);
            cVar.onModeChanged(this.kEb);
            cVar.onModeChanged(this.kEf);
            cVar.onModeChanged(this.kEi);
            this.kEc.onChangeSkinType(this.kEa.getPageContext(), i);
            an.setBackgroundResource(this.kEi, R.drawable.bg_pack);
            if (this.kEe != null) {
                this.kEe.onChangeSkinType(this.kEa.getPageContext(), i);
            }
        }
    }

    public View cRx() {
        return this.kEf;
    }

    public View cRy() {
        return this.kEj;
    }
}
