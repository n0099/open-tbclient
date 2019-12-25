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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes6.dex */
public class e extends com.baidu.adp.base.c<PraiseListActivity> {
    private c jaL;
    private PraiseListActivity jaM;
    private View jaN;
    private NavigationBar jaO;
    private View jaP;
    private NoDataView jaQ;
    private View jaR;
    private TextView jaS;
    private BdListView jaT;
    private View jaU;
    private TextView jaV;
    private TextView jaW;
    private ProgressBar jaX;
    private ProgressBar jaY;

    public e(PraiseListActivity praiseListActivity, String str) {
        super(praiseListActivity.getPageContext());
        this.jaL = null;
        this.jaM = null;
        this.jaN = null;
        this.jaO = null;
        this.jaP = null;
        this.jaQ = null;
        this.jaR = null;
        this.jaS = null;
        this.jaT = null;
        this.jaU = null;
        this.jaV = null;
        this.jaW = null;
        this.jaX = null;
        this.jaY = null;
        this.jaM = praiseListActivity;
        praiseListActivity.setContentView(R.layout.zan_list_activity);
        this.jaN = praiseListActivity.findViewById(R.id.zan_list_page_parent);
        this.jaO = (NavigationBar) praiseListActivity.findViewById(R.id.zan_list_page_navigationbar);
        this.jaP = praiseListActivity.findViewById(R.id.zan_list_page_frame);
        this.jaQ = NoDataViewFactory.a(this.jaM.getPageContext().getContext(), this.jaN, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.getDimens(this.jaM.getActivity(), R.dimen.ds320)), NoDataViewFactory.d.kQ(R.string.praise_list_no_data), null);
        this.jaT = (BdListView) praiseListActivity.findViewById(R.id.zan_list_page_list);
        TextView textView = new TextView(this.jaM.getActivity());
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)));
        this.jaT.addHeaderView(textView, 0);
        this.jaX = (ProgressBar) praiseListActivity.findViewById(R.id.zan_list_page_progress);
        this.jaL = new c(praiseListActivity);
        this.jaT.setAdapter((ListAdapter) this.jaL);
        this.jaT.setOnScrollListener(this.jaL);
        this.jaO.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.jaO.setTitleText("");
        this.jaR = LayoutInflater.from(praiseListActivity.getPageContext().getContext()).inflate(R.layout.zan_list_head, (ViewGroup) null);
        this.jaR.setOnClickListener(praiseListActivity);
        this.jaS = (TextView) this.jaR.findViewById(R.id.zan_list_head_text);
        this.jaS.setText(str);
        this.jaR.setVisibility(8);
        this.jaT.addHeaderView(this.jaR);
        this.jaU = LayoutInflater.from(praiseListActivity.getPageContext().getContext()).inflate(R.layout.zan_list_foot, (ViewGroup) null);
        this.jaV = (TextView) this.jaU.findViewById(R.id.zan_list_foot_text_continue);
        this.jaW = (TextView) this.jaU.findViewById(R.id.zan_list_foot_text_more);
        this.jaY = (ProgressBar) this.jaU.findViewById(R.id.zan_list_foot_progress);
        this.jaU.setVisibility(8);
        this.jaV.setOnClickListener(praiseListActivity);
        this.jaT.addFooterView(this.jaU);
        this.jaT.setOnItemClickListener(praiseListActivity);
    }

    public void bSG() {
        if (this.jaL != null) {
            this.jaL.notifyDataSetChanged();
        }
    }

    public void qN(boolean z) {
        if (z) {
            this.jaY.setVisibility(0);
        } else {
            this.jaX.setVisibility(0);
        }
    }

    public void csn() {
        this.jaX.setVisibility(8);
        this.jaY.setVisibility(8);
    }

    public boolean isLoading() {
        return this.jaX.getVisibility() == 0 || this.jaY.getVisibility() == 0;
    }

    public void b(int i, List<a> list, int i2, int i3) {
        String format;
        String format2;
        this.jaX.setVisibility(8);
        this.jaY.setVisibility(8);
        this.jaR.setVisibility(0);
        if (i > 0) {
            switch (this.jaM.pageType) {
                case 1:
                    format2 = String.format(this.jaM.getResources().getString(R.string.graffiti_list_title_count), aq.numFormatOverWan(i));
                    break;
                default:
                    format2 = String.format(this.jaM.getResources().getString(R.string.praise_list_title_count), aq.numFormatOverWan(i));
                    break;
            }
            this.jaO.setTitleText(format2);
        } else {
            this.jaO.setTitleText("");
        }
        if (list == null || list.size() < 1) {
            bl(null, this.jaM.pageType);
            return;
        }
        this.jaP.setVisibility(0);
        this.jaQ.setVisibility(8);
        this.jaL.dO(list);
        this.jaL.notifyDataSetChanged();
        switch (i2) {
            case 1001:
                this.jaU.setVisibility(0);
                this.jaV.setVisibility(0);
                this.jaW.setVisibility(8);
                return;
            case 1002:
                this.jaU.setVisibility(8);
                return;
            case 1003:
                this.jaU.setVisibility(0);
                am.setBackgroundResource(this.jaU, R.drawable.bg_pack);
                this.jaV.setVisibility(8);
                this.jaW.setVisibility(0);
                switch (this.jaM.pageType) {
                    case 1:
                        format = String.format(this.jaM.getResources().getString(R.string.graffiti_list_title_count), aq.numFormatOverWan(i));
                        break;
                    default:
                        format = String.format(this.jaM.getResources().getString(R.string.praise_item_more), aq.numFormatOverWan(i));
                        break;
                }
                this.jaW.setText(format);
                return;
            default:
                this.jaU.setVisibility(8);
                return;
        }
    }

    public void bl(String str, int i) {
        this.jaX.setVisibility(8);
        this.jaY.setVisibility(8);
        this.jaP.setVisibility(8);
        this.jaQ.setVisibility(0);
        if (!StringUtils.isNull(str)) {
            this.jaQ.setTextOption(NoDataViewFactory.d.tA(str));
        } else if (1 == i) {
            this.jaQ.setTextOption(NoDataViewFactory.d.kQ(R.string.graffiti_list_no_data));
        } else {
            this.jaQ.setTextOption(NoDataViewFactory.d.kQ(R.string.praise_list_no_data));
        }
    }

    public void a(com.baidu.tbadk.core.c cVar, int i) {
        if (cVar != null) {
            cVar.setNightMode(i == 1);
            cVar.onModeChanged(this.jaN);
            cVar.onModeChanged(this.jaR);
            cVar.onModeChanged(this.jaU);
            this.jaO.onChangeSkinType(this.jaM.getPageContext(), i);
            am.setBackgroundResource(this.jaU, R.drawable.bg_pack);
            if (this.jaQ != null) {
                this.jaQ.onChangeSkinType(this.jaM.getPageContext(), i);
            }
        }
    }

    public View cso() {
        return this.jaR;
    }

    public View csp() {
        return this.jaV;
    }
}
