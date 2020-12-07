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
    private c mhX;
    private PraiseListActivity mhY;
    private View mhZ;
    private NavigationBar mia;
    private View mib;
    private NoDataView mic;
    private View mie;
    private TextView mif;
    private BdListView mig;
    private View mih;
    private TextView mii;
    private TextView mij;
    private ProgressBar mik;
    private ProgressBar mil;

    public e(PraiseListActivity praiseListActivity, String str) {
        super(praiseListActivity.getPageContext());
        this.mhX = null;
        this.mhY = null;
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
        this.mhY = praiseListActivity;
        praiseListActivity.setContentView(R.layout.zan_list_activity);
        this.mhZ = praiseListActivity.findViewById(R.id.zan_list_page_parent);
        this.mia = (NavigationBar) praiseListActivity.findViewById(R.id.zan_list_page_navigationbar);
        this.mib = praiseListActivity.findViewById(R.id.zan_list_page_frame);
        this.mic = NoDataViewFactory.a(this.mhY.getPageContext().getContext(), this.mhZ, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.getDimens(this.mhY.getActivity(), R.dimen.ds320)), NoDataViewFactory.d.qP(R.string.praise_list_no_data), null);
        this.mig = (BdListView) praiseListActivity.findViewById(R.id.zan_list_page_list);
        TextView textView = new TextView(this.mhY.getActivity());
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)));
        this.mig.addHeaderView(textView, 0);
        this.mik = (ProgressBar) praiseListActivity.findViewById(R.id.zan_list_page_progress);
        this.mhX = new c(praiseListActivity);
        this.mig.setAdapter((ListAdapter) this.mhX);
        this.mig.setOnScrollListener(this.mhX);
        this.mia.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mia.setTitleText("");
        this.mie = LayoutInflater.from(praiseListActivity.getPageContext().getContext()).inflate(R.layout.zan_list_head, (ViewGroup) null);
        this.mie.setOnClickListener(praiseListActivity);
        this.mif = (TextView) this.mie.findViewById(R.id.zan_list_head_text);
        this.mif.setText(str);
        this.mie.setVisibility(8);
        this.mig.addHeaderView(this.mie);
        this.mih = LayoutInflater.from(praiseListActivity.getPageContext().getContext()).inflate(R.layout.zan_list_foot, (ViewGroup) null);
        this.mii = (TextView) this.mih.findViewById(R.id.zan_list_foot_text_continue);
        this.mij = (TextView) this.mih.findViewById(R.id.zan_list_foot_text_more);
        this.mil = (ProgressBar) this.mih.findViewById(R.id.zan_list_foot_progress);
        this.mih.setVisibility(8);
        this.mii.setOnClickListener(praiseListActivity);
        this.mig.addFooterView(this.mih);
        this.mig.setOnItemClickListener(praiseListActivity);
    }

    public void cXm() {
        if (this.mhX != null) {
            this.mhX.notifyDataSetChanged();
        }
    }

    public void wo(boolean z) {
        if (z) {
            this.mil.setVisibility(0);
        } else {
            this.mik.setVisibility(0);
        }
    }

    public void dxZ() {
        this.mik.setVisibility(8);
        this.mil.setVisibility(8);
    }

    public boolean isLoading() {
        return this.mik.getVisibility() == 0 || this.mil.getVisibility() == 0;
    }

    public void b(int i, List<a> list, int i2, int i3) {
        String format;
        String format2;
        this.mik.setVisibility(8);
        this.mil.setVisibility(8);
        this.mie.setVisibility(0);
        if (i > 0) {
            switch (this.mhY.pageType) {
                case 1:
                    format2 = String.format(this.mhY.getResources().getString(R.string.graffiti_list_title_count), au.numFormatOverWan(i));
                    break;
                default:
                    format2 = String.format(this.mhY.getResources().getString(R.string.praise_list_title_count), au.numFormatOverWan(i));
                    break;
            }
            this.mia.setTitleText(format2);
        } else {
            this.mia.setTitleText("");
        }
        if (list == null || list.size() < 1) {
            bC(null, this.mhY.pageType);
            return;
        }
        this.mib.setVisibility(0);
        this.mic.setVisibility(8);
        this.mhX.ft(list);
        this.mhX.notifyDataSetChanged();
        switch (i2) {
            case 1001:
                this.mih.setVisibility(0);
                this.mii.setVisibility(0);
                this.mij.setVisibility(8);
                return;
            case 1002:
                this.mih.setVisibility(8);
                return;
            case 1003:
                this.mih.setVisibility(0);
                ap.setBackgroundResource(this.mih, R.drawable.bg_pack);
                this.mii.setVisibility(8);
                this.mij.setVisibility(0);
                switch (this.mhY.pageType) {
                    case 1:
                        format = String.format(this.mhY.getResources().getString(R.string.graffiti_list_title_count), au.numFormatOverWan(i));
                        break;
                    default:
                        format = String.format(this.mhY.getResources().getString(R.string.praise_item_more), au.numFormatOverWan(i));
                        break;
                }
                this.mij.setText(format);
                return;
            default:
                this.mih.setVisibility(8);
                return;
        }
    }

    public void bC(String str, int i) {
        this.mik.setVisibility(8);
        this.mil.setVisibility(8);
        this.mib.setVisibility(8);
        this.mic.setVisibility(0);
        if (!StringUtils.isNull(str)) {
            this.mic.setTextOption(NoDataViewFactory.d.Cy(str));
        } else if (1 == i) {
            this.mic.setTextOption(NoDataViewFactory.d.qP(R.string.graffiti_list_no_data));
        } else {
            this.mic.setTextOption(NoDataViewFactory.d.qP(R.string.praise_list_no_data));
        }
    }

    public void a(com.baidu.tbadk.core.c cVar, int i) {
        if (cVar != null) {
            cVar.setNightMode(i == 1);
            cVar.onModeChanged(this.mhZ);
            cVar.onModeChanged(this.mie);
            cVar.onModeChanged(this.mih);
            this.mia.onChangeSkinType(this.mhY.getPageContext(), i);
            ap.setBackgroundResource(this.mih, R.drawable.bg_pack);
            if (this.mic != null) {
                this.mic.onChangeSkinType(this.mhY.getPageContext(), i);
            }
        }
    }

    public View dya() {
        return this.mie;
    }

    public View dyb() {
        return this.mii;
    }
}
