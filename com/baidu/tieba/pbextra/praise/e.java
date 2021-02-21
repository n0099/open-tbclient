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
/* loaded from: classes2.dex */
public class e extends com.baidu.adp.base.d<PraiseListActivity> {
    private c mrU;
    private PraiseListActivity mrV;
    private View mrW;
    private NavigationBar mrX;
    private View mrY;
    private NoDataView mrZ;
    private View msa;
    private TextView msb;
    private BdListView msc;
    private View msd;
    private TextView mse;
    private TextView msf;
    private ProgressBar msh;
    private ProgressBar msi;

    public e(PraiseListActivity praiseListActivity, String str) {
        super(praiseListActivity.getPageContext());
        this.mrU = null;
        this.mrV = null;
        this.mrW = null;
        this.mrX = null;
        this.mrY = null;
        this.mrZ = null;
        this.msa = null;
        this.msb = null;
        this.msc = null;
        this.msd = null;
        this.mse = null;
        this.msf = null;
        this.msh = null;
        this.msi = null;
        this.mrV = praiseListActivity;
        praiseListActivity.setContentView(R.layout.zan_list_activity);
        this.mrW = praiseListActivity.findViewById(R.id.zan_list_page_parent);
        this.mrX = (NavigationBar) praiseListActivity.findViewById(R.id.zan_list_page_navigationbar);
        this.mrY = praiseListActivity.findViewById(R.id.zan_list_page_frame);
        this.mrZ = NoDataViewFactory.a(this.mrV.getPageContext().getContext(), this.mrW, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.getDimens(this.mrV.getActivity(), R.dimen.ds320)), NoDataViewFactory.d.pz(R.string.praise_list_no_data), null);
        this.msc = (BdListView) praiseListActivity.findViewById(R.id.zan_list_page_list);
        TextView textView = new TextView(this.mrV.getActivity());
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)));
        this.msc.addHeaderView(textView, 0);
        this.msh = (ProgressBar) praiseListActivity.findViewById(R.id.zan_list_page_progress);
        this.mrU = new c(praiseListActivity);
        this.msc.setAdapter((ListAdapter) this.mrU);
        this.msc.setOnScrollListener(this.mrU);
        this.mrX.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mrX.setTitleText("");
        this.msa = LayoutInflater.from(praiseListActivity.getPageContext().getContext()).inflate(R.layout.zan_list_head, (ViewGroup) null);
        this.msa.setOnClickListener(praiseListActivity);
        this.msb = (TextView) this.msa.findViewById(R.id.zan_list_head_text);
        this.msb.setText(str);
        this.msa.setVisibility(8);
        this.msc.addHeaderView(this.msa);
        this.msd = LayoutInflater.from(praiseListActivity.getPageContext().getContext()).inflate(R.layout.zan_list_foot, (ViewGroup) null);
        this.mse = (TextView) this.msd.findViewById(R.id.zan_list_foot_text_continue);
        this.msf = (TextView) this.msd.findViewById(R.id.zan_list_foot_text_more);
        this.msi = (ProgressBar) this.msd.findViewById(R.id.zan_list_foot_progress);
        this.msd.setVisibility(8);
        this.mse.setOnClickListener(praiseListActivity);
        this.msc.addFooterView(this.msd);
        this.msc.setOnItemClickListener(praiseListActivity);
    }

    public void cWE() {
        if (this.mrU != null) {
            this.mrU.notifyDataSetChanged();
        }
    }

    public void wC(boolean z) {
        if (z) {
            this.msi.setVisibility(0);
        } else {
            this.msh.setVisibility(0);
        }
    }

    public void dwo() {
        this.msh.setVisibility(8);
        this.msi.setVisibility(8);
    }

    public boolean isLoading() {
        return this.msh.getVisibility() == 0 || this.msi.getVisibility() == 0;
    }

    public void b(int i, List<a> list, int i2, int i3) {
        String format;
        String format2;
        this.msh.setVisibility(8);
        this.msi.setVisibility(8);
        this.msa.setVisibility(0);
        if (i > 0) {
            switch (this.mrV.pageType) {
                case 1:
                    format2 = String.format(this.mrV.getResources().getString(R.string.graffiti_list_title_count), au.numFormatOverWan(i));
                    break;
                default:
                    format2 = String.format(this.mrV.getResources().getString(R.string.praise_list_title_count), au.numFormatOverWan(i));
                    break;
            }
            this.mrX.setTitleText(format2);
        } else {
            this.mrX.setTitleText("");
        }
        if (list == null || list.size() < 1) {
            bK(null, this.mrV.pageType);
            return;
        }
        this.mrY.setVisibility(0);
        this.mrZ.setVisibility(8);
        this.mrU.fr(list);
        this.mrU.notifyDataSetChanged();
        switch (i2) {
            case 1001:
                this.msd.setVisibility(0);
                this.mse.setVisibility(0);
                this.msf.setVisibility(8);
                return;
            case 1002:
                this.msd.setVisibility(8);
                return;
            case 1003:
                this.msd.setVisibility(0);
                ap.setBackgroundResource(this.msd, R.drawable.bg_pack);
                this.mse.setVisibility(8);
                this.msf.setVisibility(0);
                switch (this.mrV.pageType) {
                    case 1:
                        format = String.format(this.mrV.getResources().getString(R.string.graffiti_list_title_count), au.numFormatOverWan(i));
                        break;
                    default:
                        format = String.format(this.mrV.getResources().getString(R.string.praise_item_more), au.numFormatOverWan(i));
                        break;
                }
                this.msf.setText(format);
                return;
            default:
                this.msd.setVisibility(8);
                return;
        }
    }

    public void bK(String str, int i) {
        this.msh.setVisibility(8);
        this.msi.setVisibility(8);
        this.mrY.setVisibility(8);
        this.mrZ.setVisibility(0);
        if (!StringUtils.isNull(str)) {
            this.mrZ.setTextOption(NoDataViewFactory.d.BB(str));
        } else if (1 == i) {
            this.mrZ.setTextOption(NoDataViewFactory.d.pz(R.string.graffiti_list_no_data));
        } else {
            this.mrZ.setTextOption(NoDataViewFactory.d.pz(R.string.praise_list_no_data));
        }
    }

    public void a(com.baidu.tbadk.core.c cVar, int i) {
        if (cVar != null) {
            cVar.setNightMode(i == 1);
            cVar.onModeChanged(this.mrW);
            cVar.onModeChanged(this.msa);
            cVar.onModeChanged(this.msd);
            this.mrX.onChangeSkinType(this.mrV.getPageContext(), i);
            ap.setBackgroundResource(this.msd, R.drawable.bg_pack);
            if (this.mrZ != null) {
                this.mrZ.onChangeSkinType(this.mrV.getPageContext(), i);
            }
        }
    }

    public View dwp() {
        return this.msa;
    }

    public View dwq() {
        return this.mse;
    }
}
