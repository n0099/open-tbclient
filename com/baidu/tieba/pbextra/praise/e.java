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
/* loaded from: classes22.dex */
public class e extends com.baidu.adp.base.c<PraiseListActivity> {
    private c mhZ;
    private PraiseListActivity mia;
    private View mib;
    private NavigationBar mic;
    private View mie;
    private NoDataView mif;
    private View mig;
    private TextView mih;
    private BdListView mii;
    private View mij;
    private TextView mik;
    private TextView mil;
    private ProgressBar mim;
    private ProgressBar mio;

    public e(PraiseListActivity praiseListActivity, String str) {
        super(praiseListActivity.getPageContext());
        this.mhZ = null;
        this.mia = null;
        this.mib = null;
        this.mic = null;
        this.mie = null;
        this.mif = null;
        this.mig = null;
        this.mih = null;
        this.mii = null;
        this.mij = null;
        this.mik = null;
        this.mil = null;
        this.mim = null;
        this.mio = null;
        this.mia = praiseListActivity;
        praiseListActivity.setContentView(R.layout.zan_list_activity);
        this.mib = praiseListActivity.findViewById(R.id.zan_list_page_parent);
        this.mic = (NavigationBar) praiseListActivity.findViewById(R.id.zan_list_page_navigationbar);
        this.mie = praiseListActivity.findViewById(R.id.zan_list_page_frame);
        this.mif = NoDataViewFactory.a(this.mia.getPageContext().getContext(), this.mib, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.getDimens(this.mia.getActivity(), R.dimen.ds320)), NoDataViewFactory.d.qP(R.string.praise_list_no_data), null);
        this.mii = (BdListView) praiseListActivity.findViewById(R.id.zan_list_page_list);
        TextView textView = new TextView(this.mia.getActivity());
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)));
        this.mii.addHeaderView(textView, 0);
        this.mim = (ProgressBar) praiseListActivity.findViewById(R.id.zan_list_page_progress);
        this.mhZ = new c(praiseListActivity);
        this.mii.setAdapter((ListAdapter) this.mhZ);
        this.mii.setOnScrollListener(this.mhZ);
        this.mic.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mic.setTitleText("");
        this.mig = LayoutInflater.from(praiseListActivity.getPageContext().getContext()).inflate(R.layout.zan_list_head, (ViewGroup) null);
        this.mig.setOnClickListener(praiseListActivity);
        this.mih = (TextView) this.mig.findViewById(R.id.zan_list_head_text);
        this.mih.setText(str);
        this.mig.setVisibility(8);
        this.mii.addHeaderView(this.mig);
        this.mij = LayoutInflater.from(praiseListActivity.getPageContext().getContext()).inflate(R.layout.zan_list_foot, (ViewGroup) null);
        this.mik = (TextView) this.mij.findViewById(R.id.zan_list_foot_text_continue);
        this.mil = (TextView) this.mij.findViewById(R.id.zan_list_foot_text_more);
        this.mio = (ProgressBar) this.mij.findViewById(R.id.zan_list_foot_progress);
        this.mij.setVisibility(8);
        this.mik.setOnClickListener(praiseListActivity);
        this.mii.addFooterView(this.mij);
        this.mii.setOnItemClickListener(praiseListActivity);
    }

    public void cXn() {
        if (this.mhZ != null) {
            this.mhZ.notifyDataSetChanged();
        }
    }

    public void wo(boolean z) {
        if (z) {
            this.mio.setVisibility(0);
        } else {
            this.mim.setVisibility(0);
        }
    }

    public void dya() {
        this.mim.setVisibility(8);
        this.mio.setVisibility(8);
    }

    public boolean isLoading() {
        return this.mim.getVisibility() == 0 || this.mio.getVisibility() == 0;
    }

    public void b(int i, List<a> list, int i2, int i3) {
        String format;
        String format2;
        this.mim.setVisibility(8);
        this.mio.setVisibility(8);
        this.mig.setVisibility(0);
        if (i > 0) {
            switch (this.mia.pageType) {
                case 1:
                    format2 = String.format(this.mia.getResources().getString(R.string.graffiti_list_title_count), au.numFormatOverWan(i));
                    break;
                default:
                    format2 = String.format(this.mia.getResources().getString(R.string.praise_list_title_count), au.numFormatOverWan(i));
                    break;
            }
            this.mic.setTitleText(format2);
        } else {
            this.mic.setTitleText("");
        }
        if (list == null || list.size() < 1) {
            bC(null, this.mia.pageType);
            return;
        }
        this.mie.setVisibility(0);
        this.mif.setVisibility(8);
        this.mhZ.ft(list);
        this.mhZ.notifyDataSetChanged();
        switch (i2) {
            case 1001:
                this.mij.setVisibility(0);
                this.mik.setVisibility(0);
                this.mil.setVisibility(8);
                return;
            case 1002:
                this.mij.setVisibility(8);
                return;
            case 1003:
                this.mij.setVisibility(0);
                ap.setBackgroundResource(this.mij, R.drawable.bg_pack);
                this.mik.setVisibility(8);
                this.mil.setVisibility(0);
                switch (this.mia.pageType) {
                    case 1:
                        format = String.format(this.mia.getResources().getString(R.string.graffiti_list_title_count), au.numFormatOverWan(i));
                        break;
                    default:
                        format = String.format(this.mia.getResources().getString(R.string.praise_item_more), au.numFormatOverWan(i));
                        break;
                }
                this.mil.setText(format);
                return;
            default:
                this.mij.setVisibility(8);
                return;
        }
    }

    public void bC(String str, int i) {
        this.mim.setVisibility(8);
        this.mio.setVisibility(8);
        this.mie.setVisibility(8);
        this.mif.setVisibility(0);
        if (!StringUtils.isNull(str)) {
            this.mif.setTextOption(NoDataViewFactory.d.Cy(str));
        } else if (1 == i) {
            this.mif.setTextOption(NoDataViewFactory.d.qP(R.string.graffiti_list_no_data));
        } else {
            this.mif.setTextOption(NoDataViewFactory.d.qP(R.string.praise_list_no_data));
        }
    }

    public void a(com.baidu.tbadk.core.c cVar, int i) {
        if (cVar != null) {
            cVar.setNightMode(i == 1);
            cVar.onModeChanged(this.mib);
            cVar.onModeChanged(this.mig);
            cVar.onModeChanged(this.mij);
            this.mic.onChangeSkinType(this.mia.getPageContext(), i);
            ap.setBackgroundResource(this.mij, R.drawable.bg_pack);
            if (this.mif != null) {
                this.mif.onChangeSkinType(this.mia.getPageContext(), i);
            }
        }
    }

    public View dyb() {
        return this.mig;
    }

    public View dyc() {
        return this.mik;
    }
}
