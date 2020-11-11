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
/* loaded from: classes22.dex */
public class e extends com.baidu.adp.base.c<PraiseListActivity> {
    private c lTC;
    private PraiseListActivity lTD;
    private View lTE;
    private NavigationBar lTF;
    private View lTG;
    private NoDataView lTH;
    private View lTI;
    private TextView lTJ;
    private BdListView lTK;
    private View lTL;
    private TextView lTM;
    private TextView lTN;
    private ProgressBar lTO;
    private ProgressBar lTP;

    public e(PraiseListActivity praiseListActivity, String str) {
        super(praiseListActivity.getPageContext());
        this.lTC = null;
        this.lTD = null;
        this.lTE = null;
        this.lTF = null;
        this.lTG = null;
        this.lTH = null;
        this.lTI = null;
        this.lTJ = null;
        this.lTK = null;
        this.lTL = null;
        this.lTM = null;
        this.lTN = null;
        this.lTO = null;
        this.lTP = null;
        this.lTD = praiseListActivity;
        praiseListActivity.setContentView(R.layout.zan_list_activity);
        this.lTE = praiseListActivity.findViewById(R.id.zan_list_page_parent);
        this.lTF = (NavigationBar) praiseListActivity.findViewById(R.id.zan_list_page_navigationbar);
        this.lTG = praiseListActivity.findViewById(R.id.zan_list_page_frame);
        this.lTH = NoDataViewFactory.a(this.lTD.getPageContext().getContext(), this.lTE, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.getDimens(this.lTD.getActivity(), R.dimen.ds320)), NoDataViewFactory.d.pQ(R.string.praise_list_no_data), null);
        this.lTK = (BdListView) praiseListActivity.findViewById(R.id.zan_list_page_list);
        TextView textView = new TextView(this.lTD.getActivity());
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)));
        this.lTK.addHeaderView(textView, 0);
        this.lTO = (ProgressBar) praiseListActivity.findViewById(R.id.zan_list_page_progress);
        this.lTC = new c(praiseListActivity);
        this.lTK.setAdapter((ListAdapter) this.lTC);
        this.lTK.setOnScrollListener(this.lTC);
        this.lTF.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.lTF.setTitleText("");
        this.lTI = LayoutInflater.from(praiseListActivity.getPageContext().getContext()).inflate(R.layout.zan_list_head, (ViewGroup) null);
        this.lTI.setOnClickListener(praiseListActivity);
        this.lTJ = (TextView) this.lTI.findViewById(R.id.zan_list_head_text);
        this.lTJ.setText(str);
        this.lTI.setVisibility(8);
        this.lTK.addHeaderView(this.lTI);
        this.lTL = LayoutInflater.from(praiseListActivity.getPageContext().getContext()).inflate(R.layout.zan_list_foot, (ViewGroup) null);
        this.lTM = (TextView) this.lTL.findViewById(R.id.zan_list_foot_text_continue);
        this.lTN = (TextView) this.lTL.findViewById(R.id.zan_list_foot_text_more);
        this.lTP = (ProgressBar) this.lTL.findViewById(R.id.zan_list_foot_progress);
        this.lTL.setVisibility(8);
        this.lTM.setOnClickListener(praiseListActivity);
        this.lTK.addFooterView(this.lTL);
        this.lTK.setOnItemClickListener(praiseListActivity);
    }

    public void cSu() {
        if (this.lTC != null) {
            this.lTC.notifyDataSetChanged();
        }
    }

    public void vH(boolean z) {
        if (z) {
            this.lTP.setVisibility(0);
        } else {
            this.lTO.setVisibility(0);
        }
    }

    public void dth() {
        this.lTO.setVisibility(8);
        this.lTP.setVisibility(8);
    }

    public boolean isLoading() {
        return this.lTO.getVisibility() == 0 || this.lTP.getVisibility() == 0;
    }

    public void b(int i, List<a> list, int i2, int i3) {
        String format;
        String format2;
        this.lTO.setVisibility(8);
        this.lTP.setVisibility(8);
        this.lTI.setVisibility(0);
        if (i > 0) {
            switch (this.lTD.pageType) {
                case 1:
                    format2 = String.format(this.lTD.getResources().getString(R.string.graffiti_list_title_count), at.numFormatOverWan(i));
                    break;
                default:
                    format2 = String.format(this.lTD.getResources().getString(R.string.praise_list_title_count), at.numFormatOverWan(i));
                    break;
            }
            this.lTF.setTitleText(format2);
        } else {
            this.lTF.setTitleText("");
        }
        if (list == null || list.size() < 1) {
            bB(null, this.lTD.pageType);
            return;
        }
        this.lTG.setVisibility(0);
        this.lTH.setVisibility(8);
        this.lTC.fh(list);
        this.lTC.notifyDataSetChanged();
        switch (i2) {
            case 1001:
                this.lTL.setVisibility(0);
                this.lTM.setVisibility(0);
                this.lTN.setVisibility(8);
                return;
            case 1002:
                this.lTL.setVisibility(8);
                return;
            case 1003:
                this.lTL.setVisibility(0);
                ap.setBackgroundResource(this.lTL, R.drawable.bg_pack);
                this.lTM.setVisibility(8);
                this.lTN.setVisibility(0);
                switch (this.lTD.pageType) {
                    case 1:
                        format = String.format(this.lTD.getResources().getString(R.string.graffiti_list_title_count), at.numFormatOverWan(i));
                        break;
                    default:
                        format = String.format(this.lTD.getResources().getString(R.string.praise_item_more), at.numFormatOverWan(i));
                        break;
                }
                this.lTN.setText(format);
                return;
            default:
                this.lTL.setVisibility(8);
                return;
        }
    }

    public void bB(String str, int i) {
        this.lTO.setVisibility(8);
        this.lTP.setVisibility(8);
        this.lTG.setVisibility(8);
        this.lTH.setVisibility(0);
        if (!StringUtils.isNull(str)) {
            this.lTH.setTextOption(NoDataViewFactory.d.Cr(str));
        } else if (1 == i) {
            this.lTH.setTextOption(NoDataViewFactory.d.pQ(R.string.graffiti_list_no_data));
        } else {
            this.lTH.setTextOption(NoDataViewFactory.d.pQ(R.string.praise_list_no_data));
        }
    }

    public void a(com.baidu.tbadk.core.c cVar, int i) {
        if (cVar != null) {
            cVar.setNightMode(i == 1);
            cVar.onModeChanged(this.lTE);
            cVar.onModeChanged(this.lTI);
            cVar.onModeChanged(this.lTL);
            this.lTF.onChangeSkinType(this.lTD.getPageContext(), i);
            ap.setBackgroundResource(this.lTL, R.drawable.bg_pack);
            if (this.lTH != null) {
                this.lTH.onChangeSkinType(this.lTD.getPageContext(), i);
            }
        }
    }

    public View dti() {
        return this.lTI;
    }

    public View dtj() {
        return this.lTM;
    }
}
