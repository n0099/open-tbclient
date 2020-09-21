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
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes21.dex */
public class e extends com.baidu.adp.base.c<PraiseListActivity> {
    private c llR;
    private PraiseListActivity llS;
    private View llT;
    private NavigationBar llU;
    private View llV;
    private NoDataView llW;
    private View llX;
    private TextView llY;
    private BdListView llZ;
    private View lma;
    private TextView lmb;
    private TextView lmc;
    private ProgressBar lmd;
    private ProgressBar lme;

    public e(PraiseListActivity praiseListActivity, String str) {
        super(praiseListActivity.getPageContext());
        this.llR = null;
        this.llS = null;
        this.llT = null;
        this.llU = null;
        this.llV = null;
        this.llW = null;
        this.llX = null;
        this.llY = null;
        this.llZ = null;
        this.lma = null;
        this.lmb = null;
        this.lmc = null;
        this.lmd = null;
        this.lme = null;
        this.llS = praiseListActivity;
        praiseListActivity.setContentView(R.layout.zan_list_activity);
        this.llT = praiseListActivity.findViewById(R.id.zan_list_page_parent);
        this.llU = (NavigationBar) praiseListActivity.findViewById(R.id.zan_list_page_navigationbar);
        this.llV = praiseListActivity.findViewById(R.id.zan_list_page_frame);
        this.llW = NoDataViewFactory.a(this.llS.getPageContext().getContext(), this.llT, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.getDimens(this.llS.getActivity(), R.dimen.ds320)), NoDataViewFactory.d.oW(R.string.praise_list_no_data), null);
        this.llZ = (BdListView) praiseListActivity.findViewById(R.id.zan_list_page_list);
        TextView textView = new TextView(this.llS.getActivity());
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)));
        this.llZ.addHeaderView(textView, 0);
        this.lmd = (ProgressBar) praiseListActivity.findViewById(R.id.zan_list_page_progress);
        this.llR = new c(praiseListActivity);
        this.llZ.setAdapter((ListAdapter) this.llR);
        this.llZ.setOnScrollListener(this.llR);
        this.llU.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.llU.setTitleText("");
        this.llX = LayoutInflater.from(praiseListActivity.getPageContext().getContext()).inflate(R.layout.zan_list_head, (ViewGroup) null);
        this.llX.setOnClickListener(praiseListActivity);
        this.llY = (TextView) this.llX.findViewById(R.id.zan_list_head_text);
        this.llY.setText(str);
        this.llX.setVisibility(8);
        this.llZ.addHeaderView(this.llX);
        this.lma = LayoutInflater.from(praiseListActivity.getPageContext().getContext()).inflate(R.layout.zan_list_foot, (ViewGroup) null);
        this.lmb = (TextView) this.lma.findViewById(R.id.zan_list_foot_text_continue);
        this.lmc = (TextView) this.lma.findViewById(R.id.zan_list_foot_text_more);
        this.lme = (ProgressBar) this.lma.findViewById(R.id.zan_list_foot_progress);
        this.lma.setVisibility(8);
        this.lmb.setOnClickListener(praiseListActivity);
        this.llZ.addFooterView(this.lma);
        this.llZ.setOnItemClickListener(praiseListActivity);
    }

    public void cJd() {
        if (this.llR != null) {
            this.llR.notifyDataSetChanged();
        }
    }

    public void uA(boolean z) {
        if (z) {
            this.lme.setVisibility(0);
        } else {
            this.lmd.setVisibility(0);
        }
    }

    public void djO() {
        this.lmd.setVisibility(8);
        this.lme.setVisibility(8);
    }

    public boolean isLoading() {
        return this.lmd.getVisibility() == 0 || this.lme.getVisibility() == 0;
    }

    public void b(int i, List<a> list, int i2, int i3) {
        String format;
        String format2;
        this.lmd.setVisibility(8);
        this.lme.setVisibility(8);
        this.llX.setVisibility(0);
        if (i > 0) {
            switch (this.llS.pageType) {
                case 1:
                    format2 = String.format(this.llS.getResources().getString(R.string.graffiti_list_title_count), at.numFormatOverWan(i));
                    break;
                default:
                    format2 = String.format(this.llS.getResources().getString(R.string.praise_list_title_count), at.numFormatOverWan(i));
                    break;
            }
            this.llU.setTitleText(format2);
        } else {
            this.llU.setTitleText("");
        }
        if (list == null || list.size() < 1) {
            bx(null, this.llS.pageType);
            return;
        }
        this.llV.setVisibility(0);
        this.llW.setVisibility(8);
        this.llR.eN(list);
        this.llR.notifyDataSetChanged();
        switch (i2) {
            case 1001:
                this.lma.setVisibility(0);
                this.lmb.setVisibility(0);
                this.lmc.setVisibility(8);
                return;
            case 1002:
                this.lma.setVisibility(8);
                return;
            case 1003:
                this.lma.setVisibility(0);
                ap.setBackgroundResource(this.lma, R.drawable.bg_pack);
                this.lmb.setVisibility(8);
                this.lmc.setVisibility(0);
                switch (this.llS.pageType) {
                    case 1:
                        format = String.format(this.llS.getResources().getString(R.string.graffiti_list_title_count), at.numFormatOverWan(i));
                        break;
                    default:
                        format = String.format(this.llS.getResources().getString(R.string.praise_item_more), at.numFormatOverWan(i));
                        break;
                }
                this.lmc.setText(format);
                return;
            default:
                this.lma.setVisibility(8);
                return;
        }
    }

    public void bx(String str, int i) {
        this.lmd.setVisibility(8);
        this.lme.setVisibility(8);
        this.llV.setVisibility(8);
        this.llW.setVisibility(0);
        if (!StringUtils.isNull(str)) {
            this.llW.setTextOption(NoDataViewFactory.d.AY(str));
        } else if (1 == i) {
            this.llW.setTextOption(NoDataViewFactory.d.oW(R.string.graffiti_list_no_data));
        } else {
            this.llW.setTextOption(NoDataViewFactory.d.oW(R.string.praise_list_no_data));
        }
    }

    public void a(com.baidu.tbadk.core.c cVar, int i) {
        if (cVar != null) {
            cVar.setNightMode(i == 1);
            cVar.onModeChanged(this.llT);
            cVar.onModeChanged(this.llX);
            cVar.onModeChanged(this.lma);
            this.llU.onChangeSkinType(this.llS.getPageContext(), i);
            ap.setBackgroundResource(this.lma, R.drawable.bg_pack);
            if (this.llW != null) {
                this.llW.onChangeSkinType(this.llS.getPageContext(), i);
            }
        }
    }

    public View djP() {
        return this.llX;
    }

    public View djQ() {
        return this.lmb;
    }
}
