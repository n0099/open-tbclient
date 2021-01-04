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
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes2.dex */
public class e extends com.baidu.adp.base.d<PraiseListActivity> {
    private c mnj;
    private PraiseListActivity mnk;
    private View mnl;
    private NavigationBar mnm;
    private View mnn;
    private NoDataView mno;
    private View mnp;
    private TextView mnq;
    private BdListView mnr;
    private View mns;
    private TextView mnt;
    private TextView mnu;
    private ProgressBar mnv;
    private ProgressBar mnw;

    public e(PraiseListActivity praiseListActivity, String str) {
        super(praiseListActivity.getPageContext());
        this.mnj = null;
        this.mnk = null;
        this.mnl = null;
        this.mnm = null;
        this.mnn = null;
        this.mno = null;
        this.mnp = null;
        this.mnq = null;
        this.mnr = null;
        this.mns = null;
        this.mnt = null;
        this.mnu = null;
        this.mnv = null;
        this.mnw = null;
        this.mnk = praiseListActivity;
        praiseListActivity.setContentView(R.layout.zan_list_activity);
        this.mnl = praiseListActivity.findViewById(R.id.zan_list_page_parent);
        this.mnm = (NavigationBar) praiseListActivity.findViewById(R.id.zan_list_page_navigationbar);
        this.mnn = praiseListActivity.findViewById(R.id.zan_list_page_frame);
        this.mno = NoDataViewFactory.a(this.mnk.getPageContext().getContext(), this.mnl, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.getDimens(this.mnk.getActivity(), R.dimen.ds320)), NoDataViewFactory.d.ra(R.string.praise_list_no_data), null);
        this.mnr = (BdListView) praiseListActivity.findViewById(R.id.zan_list_page_list);
        TextView textView = new TextView(this.mnk.getActivity());
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)));
        this.mnr.addHeaderView(textView, 0);
        this.mnv = (ProgressBar) praiseListActivity.findViewById(R.id.zan_list_page_progress);
        this.mnj = new c(praiseListActivity);
        this.mnr.setAdapter((ListAdapter) this.mnj);
        this.mnr.setOnScrollListener(this.mnj);
        this.mnm.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mnm.setTitleText("");
        this.mnp = LayoutInflater.from(praiseListActivity.getPageContext().getContext()).inflate(R.layout.zan_list_head, (ViewGroup) null);
        this.mnp.setOnClickListener(praiseListActivity);
        this.mnq = (TextView) this.mnp.findViewById(R.id.zan_list_head_text);
        this.mnq.setText(str);
        this.mnp.setVisibility(8);
        this.mnr.addHeaderView(this.mnp);
        this.mns = LayoutInflater.from(praiseListActivity.getPageContext().getContext()).inflate(R.layout.zan_list_foot, (ViewGroup) null);
        this.mnt = (TextView) this.mns.findViewById(R.id.zan_list_foot_text_continue);
        this.mnu = (TextView) this.mns.findViewById(R.id.zan_list_foot_text_more);
        this.mnw = (ProgressBar) this.mns.findViewById(R.id.zan_list_foot_progress);
        this.mns.setVisibility(8);
        this.mnt.setOnClickListener(praiseListActivity);
        this.mnr.addFooterView(this.mns);
        this.mnr.setOnItemClickListener(praiseListActivity);
    }

    public void cYq() {
        if (this.mnj != null) {
            this.mnj.notifyDataSetChanged();
        }
    }

    public void wp(boolean z) {
        if (z) {
            this.mnw.setVisibility(0);
        } else {
            this.mnv.setVisibility(0);
        }
    }

    public void dxP() {
        this.mnv.setVisibility(8);
        this.mnw.setVisibility(8);
    }

    public boolean isLoading() {
        return this.mnv.getVisibility() == 0 || this.mnw.getVisibility() == 0;
    }

    public void b(int i, List<a> list, int i2, int i3) {
        String format;
        String format2;
        this.mnv.setVisibility(8);
        this.mnw.setVisibility(8);
        this.mnp.setVisibility(0);
        if (i > 0) {
            switch (this.mnk.pageType) {
                case 1:
                    format2 = String.format(this.mnk.getResources().getString(R.string.graffiti_list_title_count), at.numFormatOverWan(i));
                    break;
                default:
                    format2 = String.format(this.mnk.getResources().getString(R.string.praise_list_title_count), at.numFormatOverWan(i));
                    break;
            }
            this.mnm.setTitleText(format2);
        } else {
            this.mnm.setTitleText("");
        }
        if (list == null || list.size() < 1) {
            bJ(null, this.mnk.pageType);
            return;
        }
        this.mnn.setVisibility(0);
        this.mno.setVisibility(8);
        this.mnj.ft(list);
        this.mnj.notifyDataSetChanged();
        switch (i2) {
            case 1001:
                this.mns.setVisibility(0);
                this.mnt.setVisibility(0);
                this.mnu.setVisibility(8);
                return;
            case 1002:
                this.mns.setVisibility(8);
                return;
            case 1003:
                this.mns.setVisibility(0);
                ao.setBackgroundResource(this.mns, R.drawable.bg_pack);
                this.mnt.setVisibility(8);
                this.mnu.setVisibility(0);
                switch (this.mnk.pageType) {
                    case 1:
                        format = String.format(this.mnk.getResources().getString(R.string.graffiti_list_title_count), at.numFormatOverWan(i));
                        break;
                    default:
                        format = String.format(this.mnk.getResources().getString(R.string.praise_item_more), at.numFormatOverWan(i));
                        break;
                }
                this.mnu.setText(format);
                return;
            default:
                this.mns.setVisibility(8);
                return;
        }
    }

    public void bJ(String str, int i) {
        this.mnv.setVisibility(8);
        this.mnw.setVisibility(8);
        this.mnn.setVisibility(8);
        this.mno.setVisibility(0);
        if (!StringUtils.isNull(str)) {
            this.mno.setTextOption(NoDataViewFactory.d.Cw(str));
        } else if (1 == i) {
            this.mno.setTextOption(NoDataViewFactory.d.ra(R.string.graffiti_list_no_data));
        } else {
            this.mno.setTextOption(NoDataViewFactory.d.ra(R.string.praise_list_no_data));
        }
    }

    public void a(com.baidu.tbadk.core.c cVar, int i) {
        if (cVar != null) {
            cVar.setNightMode(i == 1);
            cVar.onModeChanged(this.mnl);
            cVar.onModeChanged(this.mnp);
            cVar.onModeChanged(this.mns);
            this.mnm.onChangeSkinType(this.mnk.getPageContext(), i);
            ao.setBackgroundResource(this.mns, R.drawable.bg_pack);
            if (this.mno != null) {
                this.mno.onChangeSkinType(this.mnk.getPageContext(), i);
            }
        }
    }

    public View dxQ() {
        return this.mnp;
    }

    public View dxR() {
        return this.mnt;
    }
}
