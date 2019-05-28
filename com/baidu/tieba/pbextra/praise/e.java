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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes4.dex */
public class e extends com.baidu.adp.base.c<PraiseListActivity> {
    private c ibC;
    private PraiseListActivity ibD;
    private View ibE;
    private NavigationBar ibF;
    private View ibG;
    private NoDataView ibH;
    private View ibI;
    private TextView ibJ;
    private BdListView ibK;
    private View ibL;
    private TextView ibM;
    private TextView ibN;
    private ProgressBar ibO;
    private ProgressBar ibP;

    public e(PraiseListActivity praiseListActivity, String str) {
        super(praiseListActivity.getPageContext());
        this.ibC = null;
        this.ibD = null;
        this.ibE = null;
        this.ibF = null;
        this.ibG = null;
        this.ibH = null;
        this.ibI = null;
        this.ibJ = null;
        this.ibK = null;
        this.ibL = null;
        this.ibM = null;
        this.ibN = null;
        this.ibO = null;
        this.ibP = null;
        this.ibD = praiseListActivity;
        praiseListActivity.setContentView(R.layout.zan_list_activity);
        this.ibE = praiseListActivity.findViewById(R.id.zan_list_page_parent);
        this.ibF = (NavigationBar) praiseListActivity.findViewById(R.id.zan_list_page_navigationbar);
        this.ibG = praiseListActivity.findViewById(R.id.zan_list_page_frame);
        this.ibH = NoDataViewFactory.a(this.ibD.getPageContext().getContext(), this.ibE, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.g(this.ibD.getActivity(), R.dimen.ds320)), NoDataViewFactory.d.iH(R.string.praise_list_no_data), null);
        this.ibK = (BdListView) praiseListActivity.findViewById(R.id.zan_list_page_list);
        TextView textView = new TextView(this.ibD.getActivity());
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)));
        this.ibK.addHeaderView(textView, 0);
        this.ibO = (ProgressBar) praiseListActivity.findViewById(R.id.zan_list_page_progress);
        this.ibC = new c(praiseListActivity);
        this.ibK.setAdapter((ListAdapter) this.ibC);
        this.ibK.setOnScrollListener(this.ibC);
        this.ibF.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.ibF.setTitleText("");
        this.ibI = LayoutInflater.from(praiseListActivity.getPageContext().getContext()).inflate(R.layout.zan_list_head, (ViewGroup) null);
        this.ibI.setOnClickListener(praiseListActivity);
        this.ibJ = (TextView) this.ibI.findViewById(R.id.zan_list_head_text);
        this.ibJ.setText(str);
        this.ibI.setVisibility(8);
        this.ibK.addHeaderView(this.ibI);
        this.ibL = LayoutInflater.from(praiseListActivity.getPageContext().getContext()).inflate(R.layout.zan_list_foot, (ViewGroup) null);
        this.ibM = (TextView) this.ibL.findViewById(R.id.zan_list_foot_text_continue);
        this.ibN = (TextView) this.ibL.findViewById(R.id.zan_list_foot_text_more);
        this.ibP = (ProgressBar) this.ibL.findViewById(R.id.zan_list_foot_progress);
        this.ibL.setVisibility(8);
        this.ibM.setOnClickListener(praiseListActivity);
        this.ibK.addFooterView(this.ibL);
        this.ibK.setOnItemClickListener(praiseListActivity);
    }

    public void bBa() {
        if (this.ibC != null) {
            this.ibC.notifyDataSetChanged();
        }
    }

    public void pj(boolean z) {
        if (z) {
            this.ibP.setVisibility(0);
        } else {
            this.ibO.setVisibility(0);
        }
    }

    public void bXY() {
        this.ibO.setVisibility(8);
        this.ibP.setVisibility(8);
    }

    public boolean pu() {
        return this.ibO.getVisibility() == 0 || this.ibP.getVisibility() == 0;
    }

    public void b(int i, List<a> list, int i2, int i3) {
        String format;
        String format2;
        this.ibO.setVisibility(8);
        this.ibP.setVisibility(8);
        this.ibI.setVisibility(0);
        if (i > 0) {
            switch (this.ibD.pageType) {
                case 1:
                    format2 = String.format(this.ibD.getResources().getString(R.string.graffiti_list_title_count), ap.aN(i));
                    break;
                default:
                    format2 = String.format(this.ibD.getResources().getString(R.string.praise_list_title_count), ap.aN(i));
                    break;
            }
            this.ibF.setTitleText(format2);
        } else {
            this.ibF.setTitleText("");
        }
        if (list == null || list.size() < 1) {
            be(null, this.ibD.pageType);
            return;
        }
        this.ibG.setVisibility(0);
        this.ibH.setVisibility(8);
        this.ibC.dL(list);
        this.ibC.notifyDataSetChanged();
        switch (i2) {
            case 1001:
                this.ibL.setVisibility(0);
                this.ibM.setVisibility(0);
                this.ibN.setVisibility(8);
                return;
            case 1002:
                this.ibL.setVisibility(8);
                return;
            case 1003:
                this.ibL.setVisibility(0);
                al.k(this.ibL, R.drawable.bg_pack);
                this.ibM.setVisibility(8);
                this.ibN.setVisibility(0);
                switch (this.ibD.pageType) {
                    case 1:
                        format = String.format(this.ibD.getResources().getString(R.string.graffiti_list_title_count), ap.aN(i));
                        break;
                    default:
                        format = String.format(this.ibD.getResources().getString(R.string.praise_item_more), ap.aN(i));
                        break;
                }
                this.ibN.setText(format);
                return;
            default:
                this.ibL.setVisibility(8);
                return;
        }
    }

    public void be(String str, int i) {
        this.ibO.setVisibility(8);
        this.ibP.setVisibility(8);
        this.ibG.setVisibility(8);
        this.ibH.setVisibility(0);
        if (!StringUtils.isNull(str)) {
            this.ibH.setTextOption(NoDataViewFactory.d.oz(str));
        } else if (1 == i) {
            this.ibH.setTextOption(NoDataViewFactory.d.iH(R.string.graffiti_list_no_data));
        } else {
            this.ibH.setTextOption(NoDataViewFactory.d.iH(R.string.praise_list_no_data));
        }
    }

    public void a(com.baidu.tbadk.core.c cVar, int i) {
        if (cVar != null) {
            cVar.setNightMode(i == 1);
            cVar.onModeChanged(this.ibE);
            cVar.onModeChanged(this.ibI);
            cVar.onModeChanged(this.ibL);
            this.ibF.onChangeSkinType(this.ibD.getPageContext(), i);
            al.k(this.ibL, R.drawable.bg_pack);
            if (this.ibH != null) {
                this.ibH.onChangeSkinType(this.ibD.getPageContext(), i);
            }
        }
    }

    public View bXZ() {
        return this.ibI;
    }

    public View bYa() {
        return this.ibM;
    }
}
