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
    private c mni;
    private PraiseListActivity mnj;
    private View mnk;
    private NavigationBar mnl;
    private View mnm;
    private NoDataView mnn;
    private View mno;
    private TextView mnp;
    private BdListView mnq;
    private View mnr;
    private TextView mns;
    private TextView mnt;
    private ProgressBar mnu;
    private ProgressBar mnv;

    public e(PraiseListActivity praiseListActivity, String str) {
        super(praiseListActivity.getPageContext());
        this.mni = null;
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
        this.mnj = praiseListActivity;
        praiseListActivity.setContentView(R.layout.zan_list_activity);
        this.mnk = praiseListActivity.findViewById(R.id.zan_list_page_parent);
        this.mnl = (NavigationBar) praiseListActivity.findViewById(R.id.zan_list_page_navigationbar);
        this.mnm = praiseListActivity.findViewById(R.id.zan_list_page_frame);
        this.mnn = NoDataViewFactory.a(this.mnj.getPageContext().getContext(), this.mnk, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.getDimens(this.mnj.getActivity(), R.dimen.ds320)), NoDataViewFactory.d.ra(R.string.praise_list_no_data), null);
        this.mnq = (BdListView) praiseListActivity.findViewById(R.id.zan_list_page_list);
        TextView textView = new TextView(this.mnj.getActivity());
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)));
        this.mnq.addHeaderView(textView, 0);
        this.mnu = (ProgressBar) praiseListActivity.findViewById(R.id.zan_list_page_progress);
        this.mni = new c(praiseListActivity);
        this.mnq.setAdapter((ListAdapter) this.mni);
        this.mnq.setOnScrollListener(this.mni);
        this.mnl.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mnl.setTitleText("");
        this.mno = LayoutInflater.from(praiseListActivity.getPageContext().getContext()).inflate(R.layout.zan_list_head, (ViewGroup) null);
        this.mno.setOnClickListener(praiseListActivity);
        this.mnp = (TextView) this.mno.findViewById(R.id.zan_list_head_text);
        this.mnp.setText(str);
        this.mno.setVisibility(8);
        this.mnq.addHeaderView(this.mno);
        this.mnr = LayoutInflater.from(praiseListActivity.getPageContext().getContext()).inflate(R.layout.zan_list_foot, (ViewGroup) null);
        this.mns = (TextView) this.mnr.findViewById(R.id.zan_list_foot_text_continue);
        this.mnt = (TextView) this.mnr.findViewById(R.id.zan_list_foot_text_more);
        this.mnv = (ProgressBar) this.mnr.findViewById(R.id.zan_list_foot_progress);
        this.mnr.setVisibility(8);
        this.mns.setOnClickListener(praiseListActivity);
        this.mnq.addFooterView(this.mnr);
        this.mnq.setOnItemClickListener(praiseListActivity);
    }

    public void cYr() {
        if (this.mni != null) {
            this.mni.notifyDataSetChanged();
        }
    }

    public void wp(boolean z) {
        if (z) {
            this.mnv.setVisibility(0);
        } else {
            this.mnu.setVisibility(0);
        }
    }

    public void dxQ() {
        this.mnu.setVisibility(8);
        this.mnv.setVisibility(8);
    }

    public boolean isLoading() {
        return this.mnu.getVisibility() == 0 || this.mnv.getVisibility() == 0;
    }

    public void b(int i, List<a> list, int i2, int i3) {
        String format;
        String format2;
        this.mnu.setVisibility(8);
        this.mnv.setVisibility(8);
        this.mno.setVisibility(0);
        if (i > 0) {
            switch (this.mnj.pageType) {
                case 1:
                    format2 = String.format(this.mnj.getResources().getString(R.string.graffiti_list_title_count), at.numFormatOverWan(i));
                    break;
                default:
                    format2 = String.format(this.mnj.getResources().getString(R.string.praise_list_title_count), at.numFormatOverWan(i));
                    break;
            }
            this.mnl.setTitleText(format2);
        } else {
            this.mnl.setTitleText("");
        }
        if (list == null || list.size() < 1) {
            bJ(null, this.mnj.pageType);
            return;
        }
        this.mnm.setVisibility(0);
        this.mnn.setVisibility(8);
        this.mni.ft(list);
        this.mni.notifyDataSetChanged();
        switch (i2) {
            case 1001:
                this.mnr.setVisibility(0);
                this.mns.setVisibility(0);
                this.mnt.setVisibility(8);
                return;
            case 1002:
                this.mnr.setVisibility(8);
                return;
            case 1003:
                this.mnr.setVisibility(0);
                ao.setBackgroundResource(this.mnr, R.drawable.bg_pack);
                this.mns.setVisibility(8);
                this.mnt.setVisibility(0);
                switch (this.mnj.pageType) {
                    case 1:
                        format = String.format(this.mnj.getResources().getString(R.string.graffiti_list_title_count), at.numFormatOverWan(i));
                        break;
                    default:
                        format = String.format(this.mnj.getResources().getString(R.string.praise_item_more), at.numFormatOverWan(i));
                        break;
                }
                this.mnt.setText(format);
                return;
            default:
                this.mnr.setVisibility(8);
                return;
        }
    }

    public void bJ(String str, int i) {
        this.mnu.setVisibility(8);
        this.mnv.setVisibility(8);
        this.mnm.setVisibility(8);
        this.mnn.setVisibility(0);
        if (!StringUtils.isNull(str)) {
            this.mnn.setTextOption(NoDataViewFactory.d.Cv(str));
        } else if (1 == i) {
            this.mnn.setTextOption(NoDataViewFactory.d.ra(R.string.graffiti_list_no_data));
        } else {
            this.mnn.setTextOption(NoDataViewFactory.d.ra(R.string.praise_list_no_data));
        }
    }

    public void a(com.baidu.tbadk.core.c cVar, int i) {
        if (cVar != null) {
            cVar.setNightMode(i == 1);
            cVar.onModeChanged(this.mnk);
            cVar.onModeChanged(this.mno);
            cVar.onModeChanged(this.mnr);
            this.mnl.onChangeSkinType(this.mnj.getPageContext(), i);
            ao.setBackgroundResource(this.mnr, R.drawable.bg_pack);
            if (this.mnn != null) {
                this.mnn.onChangeSkinType(this.mnj.getPageContext(), i);
            }
        }
    }

    public View dxR() {
        return this.mno;
    }

    public View dxS() {
        return this.mns;
    }
}
