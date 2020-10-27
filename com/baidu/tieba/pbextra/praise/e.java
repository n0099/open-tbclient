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
    private c lNG;
    private PraiseListActivity lNH;
    private View lNI;
    private NavigationBar lNJ;
    private View lNK;
    private NoDataView lNL;
    private View lNM;
    private TextView lNN;
    private BdListView lNO;
    private View lNP;
    private TextView lNQ;
    private TextView lNR;
    private ProgressBar lNS;
    private ProgressBar lNT;

    public e(PraiseListActivity praiseListActivity, String str) {
        super(praiseListActivity.getPageContext());
        this.lNG = null;
        this.lNH = null;
        this.lNI = null;
        this.lNJ = null;
        this.lNK = null;
        this.lNL = null;
        this.lNM = null;
        this.lNN = null;
        this.lNO = null;
        this.lNP = null;
        this.lNQ = null;
        this.lNR = null;
        this.lNS = null;
        this.lNT = null;
        this.lNH = praiseListActivity;
        praiseListActivity.setContentView(R.layout.zan_list_activity);
        this.lNI = praiseListActivity.findViewById(R.id.zan_list_page_parent);
        this.lNJ = (NavigationBar) praiseListActivity.findViewById(R.id.zan_list_page_navigationbar);
        this.lNK = praiseListActivity.findViewById(R.id.zan_list_page_frame);
        this.lNL = NoDataViewFactory.a(this.lNH.getPageContext().getContext(), this.lNI, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.getDimens(this.lNH.getActivity(), R.dimen.ds320)), NoDataViewFactory.d.pG(R.string.praise_list_no_data), null);
        this.lNO = (BdListView) praiseListActivity.findViewById(R.id.zan_list_page_list);
        TextView textView = new TextView(this.lNH.getActivity());
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)));
        this.lNO.addHeaderView(textView, 0);
        this.lNS = (ProgressBar) praiseListActivity.findViewById(R.id.zan_list_page_progress);
        this.lNG = new c(praiseListActivity);
        this.lNO.setAdapter((ListAdapter) this.lNG);
        this.lNO.setOnScrollListener(this.lNG);
        this.lNJ.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.lNJ.setTitleText("");
        this.lNM = LayoutInflater.from(praiseListActivity.getPageContext().getContext()).inflate(R.layout.zan_list_head, (ViewGroup) null);
        this.lNM.setOnClickListener(praiseListActivity);
        this.lNN = (TextView) this.lNM.findViewById(R.id.zan_list_head_text);
        this.lNN.setText(str);
        this.lNM.setVisibility(8);
        this.lNO.addHeaderView(this.lNM);
        this.lNP = LayoutInflater.from(praiseListActivity.getPageContext().getContext()).inflate(R.layout.zan_list_foot, (ViewGroup) null);
        this.lNQ = (TextView) this.lNP.findViewById(R.id.zan_list_foot_text_continue);
        this.lNR = (TextView) this.lNP.findViewById(R.id.zan_list_foot_text_more);
        this.lNT = (ProgressBar) this.lNP.findViewById(R.id.zan_list_foot_progress);
        this.lNP.setVisibility(8);
        this.lNQ.setOnClickListener(praiseListActivity);
        this.lNO.addFooterView(this.lNP);
        this.lNO.setOnItemClickListener(praiseListActivity);
    }

    public void cPT() {
        if (this.lNG != null) {
            this.lNG.notifyDataSetChanged();
        }
    }

    public void vy(boolean z) {
        if (z) {
            this.lNT.setVisibility(0);
        } else {
            this.lNS.setVisibility(0);
        }
    }

    public void dqF() {
        this.lNS.setVisibility(8);
        this.lNT.setVisibility(8);
    }

    public boolean isLoading() {
        return this.lNS.getVisibility() == 0 || this.lNT.getVisibility() == 0;
    }

    public void b(int i, List<a> list, int i2, int i3) {
        String format;
        String format2;
        this.lNS.setVisibility(8);
        this.lNT.setVisibility(8);
        this.lNM.setVisibility(0);
        if (i > 0) {
            switch (this.lNH.pageType) {
                case 1:
                    format2 = String.format(this.lNH.getResources().getString(R.string.graffiti_list_title_count), at.numFormatOverWan(i));
                    break;
                default:
                    format2 = String.format(this.lNH.getResources().getString(R.string.praise_list_title_count), at.numFormatOverWan(i));
                    break;
            }
            this.lNJ.setTitleText(format2);
        } else {
            this.lNJ.setTitleText("");
        }
        if (list == null || list.size() < 1) {
            bz(null, this.lNH.pageType);
            return;
        }
        this.lNK.setVisibility(0);
        this.lNL.setVisibility(8);
        this.lNG.eZ(list);
        this.lNG.notifyDataSetChanged();
        switch (i2) {
            case 1001:
                this.lNP.setVisibility(0);
                this.lNQ.setVisibility(0);
                this.lNR.setVisibility(8);
                return;
            case 1002:
                this.lNP.setVisibility(8);
                return;
            case 1003:
                this.lNP.setVisibility(0);
                ap.setBackgroundResource(this.lNP, R.drawable.bg_pack);
                this.lNQ.setVisibility(8);
                this.lNR.setVisibility(0);
                switch (this.lNH.pageType) {
                    case 1:
                        format = String.format(this.lNH.getResources().getString(R.string.graffiti_list_title_count), at.numFormatOverWan(i));
                        break;
                    default:
                        format = String.format(this.lNH.getResources().getString(R.string.praise_item_more), at.numFormatOverWan(i));
                        break;
                }
                this.lNR.setText(format);
                return;
            default:
                this.lNP.setVisibility(8);
                return;
        }
    }

    public void bz(String str, int i) {
        this.lNS.setVisibility(8);
        this.lNT.setVisibility(8);
        this.lNK.setVisibility(8);
        this.lNL.setVisibility(0);
        if (!StringUtils.isNull(str)) {
            this.lNL.setTextOption(NoDataViewFactory.d.Cd(str));
        } else if (1 == i) {
            this.lNL.setTextOption(NoDataViewFactory.d.pG(R.string.graffiti_list_no_data));
        } else {
            this.lNL.setTextOption(NoDataViewFactory.d.pG(R.string.praise_list_no_data));
        }
    }

    public void a(com.baidu.tbadk.core.c cVar, int i) {
        if (cVar != null) {
            cVar.setNightMode(i == 1);
            cVar.onModeChanged(this.lNI);
            cVar.onModeChanged(this.lNM);
            cVar.onModeChanged(this.lNP);
            this.lNJ.onChangeSkinType(this.lNH.getPageContext(), i);
            ap.setBackgroundResource(this.lNP, R.drawable.bg_pack);
            if (this.lNL != null) {
                this.lNL.onChangeSkinType(this.lNH.getPageContext(), i);
            }
        }
    }

    public View dqG() {
        return this.lNM;
    }

    public View dqH() {
        return this.lNQ;
    }
}
