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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes21.dex */
public class e extends com.baidu.adp.base.c<PraiseListActivity> {
    private c lTS;
    private PraiseListActivity lTT;
    private View lTU;
    private NavigationBar lTV;
    private View lTW;
    private NoDataView lTX;
    private View lTY;
    private TextView lTZ;
    private BdListView lUa;
    private View lUb;
    private TextView lUc;
    private TextView lUd;
    private ProgressBar lUe;
    private ProgressBar lUf;

    public e(PraiseListActivity praiseListActivity, String str) {
        super(praiseListActivity.getPageContext());
        this.lTS = null;
        this.lTT = null;
        this.lTU = null;
        this.lTV = null;
        this.lTW = null;
        this.lTX = null;
        this.lTY = null;
        this.lTZ = null;
        this.lUa = null;
        this.lUb = null;
        this.lUc = null;
        this.lUd = null;
        this.lUe = null;
        this.lUf = null;
        this.lTT = praiseListActivity;
        praiseListActivity.setContentView(R.layout.zan_list_activity);
        this.lTU = praiseListActivity.findViewById(R.id.zan_list_page_parent);
        this.lTV = (NavigationBar) praiseListActivity.findViewById(R.id.zan_list_page_navigationbar);
        this.lTW = praiseListActivity.findViewById(R.id.zan_list_page_frame);
        this.lTX = NoDataViewFactory.a(this.lTT.getPageContext().getContext(), this.lTU, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.getDimens(this.lTT.getActivity(), R.dimen.ds320)), NoDataViewFactory.d.qo(R.string.praise_list_no_data), null);
        this.lUa = (BdListView) praiseListActivity.findViewById(R.id.zan_list_page_list);
        TextView textView = new TextView(this.lTT.getActivity());
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)));
        this.lUa.addHeaderView(textView, 0);
        this.lUe = (ProgressBar) praiseListActivity.findViewById(R.id.zan_list_page_progress);
        this.lTS = new c(praiseListActivity);
        this.lUa.setAdapter((ListAdapter) this.lTS);
        this.lUa.setOnScrollListener(this.lTS);
        this.lTV.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.lTV.setTitleText("");
        this.lTY = LayoutInflater.from(praiseListActivity.getPageContext().getContext()).inflate(R.layout.zan_list_head, (ViewGroup) null);
        this.lTY.setOnClickListener(praiseListActivity);
        this.lTZ = (TextView) this.lTY.findViewById(R.id.zan_list_head_text);
        this.lTZ.setText(str);
        this.lTY.setVisibility(8);
        this.lUa.addHeaderView(this.lTY);
        this.lUb = LayoutInflater.from(praiseListActivity.getPageContext().getContext()).inflate(R.layout.zan_list_foot, (ViewGroup) null);
        this.lUc = (TextView) this.lUb.findViewById(R.id.zan_list_foot_text_continue);
        this.lUd = (TextView) this.lUb.findViewById(R.id.zan_list_foot_text_more);
        this.lUf = (ProgressBar) this.lUb.findViewById(R.id.zan_list_foot_progress);
        this.lUb.setVisibility(8);
        this.lUc.setOnClickListener(praiseListActivity);
        this.lUa.addFooterView(this.lUb);
        this.lUa.setOnItemClickListener(praiseListActivity);
    }

    public void cSa() {
        if (this.lTS != null) {
            this.lTS.notifyDataSetChanged();
        }
    }

    public void vK(boolean z) {
        if (z) {
            this.lUf.setVisibility(0);
        } else {
            this.lUe.setVisibility(0);
        }
    }

    public void dsH() {
        this.lUe.setVisibility(8);
        this.lUf.setVisibility(8);
    }

    public boolean isLoading() {
        return this.lUe.getVisibility() == 0 || this.lUf.getVisibility() == 0;
    }

    public void b(int i, List<a> list, int i2, int i3) {
        String format;
        String format2;
        this.lUe.setVisibility(8);
        this.lUf.setVisibility(8);
        this.lTY.setVisibility(0);
        if (i > 0) {
            switch (this.lTT.pageType) {
                case 1:
                    format2 = String.format(this.lTT.getResources().getString(R.string.graffiti_list_title_count), au.numFormatOverWan(i));
                    break;
                default:
                    format2 = String.format(this.lTT.getResources().getString(R.string.praise_list_title_count), au.numFormatOverWan(i));
                    break;
            }
            this.lTV.setTitleText(format2);
        } else {
            this.lTV.setTitleText("");
        }
        if (list == null || list.size() < 1) {
            bA(null, this.lTT.pageType);
            return;
        }
        this.lTW.setVisibility(0);
        this.lTX.setVisibility(8);
        this.lTS.fh(list);
        this.lTS.notifyDataSetChanged();
        switch (i2) {
            case 1001:
                this.lUb.setVisibility(0);
                this.lUc.setVisibility(0);
                this.lUd.setVisibility(8);
                return;
            case 1002:
                this.lUb.setVisibility(8);
                return;
            case 1003:
                this.lUb.setVisibility(0);
                ap.setBackgroundResource(this.lUb, R.drawable.bg_pack);
                this.lUc.setVisibility(8);
                this.lUd.setVisibility(0);
                switch (this.lTT.pageType) {
                    case 1:
                        format = String.format(this.lTT.getResources().getString(R.string.graffiti_list_title_count), au.numFormatOverWan(i));
                        break;
                    default:
                        format = String.format(this.lTT.getResources().getString(R.string.praise_item_more), au.numFormatOverWan(i));
                        break;
                }
                this.lUd.setText(format);
                return;
            default:
                this.lUb.setVisibility(8);
                return;
        }
    }

    public void bA(String str, int i) {
        this.lUe.setVisibility(8);
        this.lUf.setVisibility(8);
        this.lTW.setVisibility(8);
        this.lTX.setVisibility(0);
        if (!StringUtils.isNull(str)) {
            this.lTX.setTextOption(NoDataViewFactory.d.BQ(str));
        } else if (1 == i) {
            this.lTX.setTextOption(NoDataViewFactory.d.qo(R.string.graffiti_list_no_data));
        } else {
            this.lTX.setTextOption(NoDataViewFactory.d.qo(R.string.praise_list_no_data));
        }
    }

    public void a(com.baidu.tbadk.core.c cVar, int i) {
        if (cVar != null) {
            cVar.setNightMode(i == 1);
            cVar.onModeChanged(this.lTU);
            cVar.onModeChanged(this.lTY);
            cVar.onModeChanged(this.lUb);
            this.lTV.onChangeSkinType(this.lTT.getPageContext(), i);
            ap.setBackgroundResource(this.lUb, R.drawable.bg_pack);
            if (this.lTX != null) {
                this.lTX.onChangeSkinType(this.lTT.getPageContext(), i);
            }
        }
    }

    public View dsI() {
        return this.lTY;
    }

    public View dsJ() {
        return this.lUc;
    }
}
