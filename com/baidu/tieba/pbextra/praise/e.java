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
    private c ibD;
    private PraiseListActivity ibE;
    private View ibF;
    private NavigationBar ibG;
    private View ibH;
    private NoDataView ibI;
    private View ibJ;
    private TextView ibK;
    private BdListView ibL;
    private View ibM;
    private TextView ibN;
    private TextView ibO;
    private ProgressBar ibP;
    private ProgressBar ibQ;

    public e(PraiseListActivity praiseListActivity, String str) {
        super(praiseListActivity.getPageContext());
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
        this.ibQ = null;
        this.ibE = praiseListActivity;
        praiseListActivity.setContentView(R.layout.zan_list_activity);
        this.ibF = praiseListActivity.findViewById(R.id.zan_list_page_parent);
        this.ibG = (NavigationBar) praiseListActivity.findViewById(R.id.zan_list_page_navigationbar);
        this.ibH = praiseListActivity.findViewById(R.id.zan_list_page_frame);
        this.ibI = NoDataViewFactory.a(this.ibE.getPageContext().getContext(), this.ibF, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.g(this.ibE.getActivity(), R.dimen.ds320)), NoDataViewFactory.d.iH(R.string.praise_list_no_data), null);
        this.ibL = (BdListView) praiseListActivity.findViewById(R.id.zan_list_page_list);
        TextView textView = new TextView(this.ibE.getActivity());
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)));
        this.ibL.addHeaderView(textView, 0);
        this.ibP = (ProgressBar) praiseListActivity.findViewById(R.id.zan_list_page_progress);
        this.ibD = new c(praiseListActivity);
        this.ibL.setAdapter((ListAdapter) this.ibD);
        this.ibL.setOnScrollListener(this.ibD);
        this.ibG.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.ibG.setTitleText("");
        this.ibJ = LayoutInflater.from(praiseListActivity.getPageContext().getContext()).inflate(R.layout.zan_list_head, (ViewGroup) null);
        this.ibJ.setOnClickListener(praiseListActivity);
        this.ibK = (TextView) this.ibJ.findViewById(R.id.zan_list_head_text);
        this.ibK.setText(str);
        this.ibJ.setVisibility(8);
        this.ibL.addHeaderView(this.ibJ);
        this.ibM = LayoutInflater.from(praiseListActivity.getPageContext().getContext()).inflate(R.layout.zan_list_foot, (ViewGroup) null);
        this.ibN = (TextView) this.ibM.findViewById(R.id.zan_list_foot_text_continue);
        this.ibO = (TextView) this.ibM.findViewById(R.id.zan_list_foot_text_more);
        this.ibQ = (ProgressBar) this.ibM.findViewById(R.id.zan_list_foot_progress);
        this.ibM.setVisibility(8);
        this.ibN.setOnClickListener(praiseListActivity);
        this.ibL.addFooterView(this.ibM);
        this.ibL.setOnItemClickListener(praiseListActivity);
    }

    public void bBb() {
        if (this.ibD != null) {
            this.ibD.notifyDataSetChanged();
        }
    }

    public void pk(boolean z) {
        if (z) {
            this.ibQ.setVisibility(0);
        } else {
            this.ibP.setVisibility(0);
        }
    }

    public void bXZ() {
        this.ibP.setVisibility(8);
        this.ibQ.setVisibility(8);
    }

    public boolean pu() {
        return this.ibP.getVisibility() == 0 || this.ibQ.getVisibility() == 0;
    }

    public void b(int i, List<a> list, int i2, int i3) {
        String format;
        String format2;
        this.ibP.setVisibility(8);
        this.ibQ.setVisibility(8);
        this.ibJ.setVisibility(0);
        if (i > 0) {
            switch (this.ibE.pageType) {
                case 1:
                    format2 = String.format(this.ibE.getResources().getString(R.string.graffiti_list_title_count), ap.aN(i));
                    break;
                default:
                    format2 = String.format(this.ibE.getResources().getString(R.string.praise_list_title_count), ap.aN(i));
                    break;
            }
            this.ibG.setTitleText(format2);
        } else {
            this.ibG.setTitleText("");
        }
        if (list == null || list.size() < 1) {
            be(null, this.ibE.pageType);
            return;
        }
        this.ibH.setVisibility(0);
        this.ibI.setVisibility(8);
        this.ibD.dL(list);
        this.ibD.notifyDataSetChanged();
        switch (i2) {
            case 1001:
                this.ibM.setVisibility(0);
                this.ibN.setVisibility(0);
                this.ibO.setVisibility(8);
                return;
            case 1002:
                this.ibM.setVisibility(8);
                return;
            case 1003:
                this.ibM.setVisibility(0);
                al.k(this.ibM, R.drawable.bg_pack);
                this.ibN.setVisibility(8);
                this.ibO.setVisibility(0);
                switch (this.ibE.pageType) {
                    case 1:
                        format = String.format(this.ibE.getResources().getString(R.string.graffiti_list_title_count), ap.aN(i));
                        break;
                    default:
                        format = String.format(this.ibE.getResources().getString(R.string.praise_item_more), ap.aN(i));
                        break;
                }
                this.ibO.setText(format);
                return;
            default:
                this.ibM.setVisibility(8);
                return;
        }
    }

    public void be(String str, int i) {
        this.ibP.setVisibility(8);
        this.ibQ.setVisibility(8);
        this.ibH.setVisibility(8);
        this.ibI.setVisibility(0);
        if (!StringUtils.isNull(str)) {
            this.ibI.setTextOption(NoDataViewFactory.d.oy(str));
        } else if (1 == i) {
            this.ibI.setTextOption(NoDataViewFactory.d.iH(R.string.graffiti_list_no_data));
        } else {
            this.ibI.setTextOption(NoDataViewFactory.d.iH(R.string.praise_list_no_data));
        }
    }

    public void a(com.baidu.tbadk.core.c cVar, int i) {
        if (cVar != null) {
            cVar.setNightMode(i == 1);
            cVar.onModeChanged(this.ibF);
            cVar.onModeChanged(this.ibJ);
            cVar.onModeChanged(this.ibM);
            this.ibG.onChangeSkinType(this.ibE.getPageContext(), i);
            al.k(this.ibM, R.drawable.bg_pack);
            if (this.ibI != null) {
                this.ibI.onChangeSkinType(this.ibE.getPageContext(), i);
            }
        }
    }

    public View bYa() {
        return this.ibJ;
    }

    public View bYb() {
        return this.ibN;
    }
}
