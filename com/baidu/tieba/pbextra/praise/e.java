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
    private PraiseListActivity ibA;
    private View ibB;
    private NavigationBar ibC;
    private View ibD;
    private NoDataView ibE;
    private View ibF;
    private TextView ibG;
    private BdListView ibH;
    private View ibI;
    private TextView ibJ;
    private TextView ibK;
    private ProgressBar ibL;
    private ProgressBar ibM;
    private c ibz;

    public e(PraiseListActivity praiseListActivity, String str) {
        super(praiseListActivity.getPageContext());
        this.ibz = null;
        this.ibA = null;
        this.ibB = null;
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
        this.ibA = praiseListActivity;
        praiseListActivity.setContentView(R.layout.zan_list_activity);
        this.ibB = praiseListActivity.findViewById(R.id.zan_list_page_parent);
        this.ibC = (NavigationBar) praiseListActivity.findViewById(R.id.zan_list_page_navigationbar);
        this.ibD = praiseListActivity.findViewById(R.id.zan_list_page_frame);
        this.ibE = NoDataViewFactory.a(this.ibA.getPageContext().getContext(), this.ibB, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.g(this.ibA.getActivity(), R.dimen.ds320)), NoDataViewFactory.d.iH(R.string.praise_list_no_data), null);
        this.ibH = (BdListView) praiseListActivity.findViewById(R.id.zan_list_page_list);
        TextView textView = new TextView(this.ibA.getActivity());
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)));
        this.ibH.addHeaderView(textView, 0);
        this.ibL = (ProgressBar) praiseListActivity.findViewById(R.id.zan_list_page_progress);
        this.ibz = new c(praiseListActivity);
        this.ibH.setAdapter((ListAdapter) this.ibz);
        this.ibH.setOnScrollListener(this.ibz);
        this.ibC.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.ibC.setTitleText("");
        this.ibF = LayoutInflater.from(praiseListActivity.getPageContext().getContext()).inflate(R.layout.zan_list_head, (ViewGroup) null);
        this.ibF.setOnClickListener(praiseListActivity);
        this.ibG = (TextView) this.ibF.findViewById(R.id.zan_list_head_text);
        this.ibG.setText(str);
        this.ibF.setVisibility(8);
        this.ibH.addHeaderView(this.ibF);
        this.ibI = LayoutInflater.from(praiseListActivity.getPageContext().getContext()).inflate(R.layout.zan_list_foot, (ViewGroup) null);
        this.ibJ = (TextView) this.ibI.findViewById(R.id.zan_list_foot_text_continue);
        this.ibK = (TextView) this.ibI.findViewById(R.id.zan_list_foot_text_more);
        this.ibM = (ProgressBar) this.ibI.findViewById(R.id.zan_list_foot_progress);
        this.ibI.setVisibility(8);
        this.ibJ.setOnClickListener(praiseListActivity);
        this.ibH.addFooterView(this.ibI);
        this.ibH.setOnItemClickListener(praiseListActivity);
    }

    public void bAX() {
        if (this.ibz != null) {
            this.ibz.notifyDataSetChanged();
        }
    }

    public void pj(boolean z) {
        if (z) {
            this.ibM.setVisibility(0);
        } else {
            this.ibL.setVisibility(0);
        }
    }

    public void bXV() {
        this.ibL.setVisibility(8);
        this.ibM.setVisibility(8);
    }

    public boolean pu() {
        return this.ibL.getVisibility() == 0 || this.ibM.getVisibility() == 0;
    }

    public void b(int i, List<a> list, int i2, int i3) {
        String format;
        String format2;
        this.ibL.setVisibility(8);
        this.ibM.setVisibility(8);
        this.ibF.setVisibility(0);
        if (i > 0) {
            switch (this.ibA.pageType) {
                case 1:
                    format2 = String.format(this.ibA.getResources().getString(R.string.graffiti_list_title_count), ap.aN(i));
                    break;
                default:
                    format2 = String.format(this.ibA.getResources().getString(R.string.praise_list_title_count), ap.aN(i));
                    break;
            }
            this.ibC.setTitleText(format2);
        } else {
            this.ibC.setTitleText("");
        }
        if (list == null || list.size() < 1) {
            be(null, this.ibA.pageType);
            return;
        }
        this.ibD.setVisibility(0);
        this.ibE.setVisibility(8);
        this.ibz.dL(list);
        this.ibz.notifyDataSetChanged();
        switch (i2) {
            case 1001:
                this.ibI.setVisibility(0);
                this.ibJ.setVisibility(0);
                this.ibK.setVisibility(8);
                return;
            case 1002:
                this.ibI.setVisibility(8);
                return;
            case 1003:
                this.ibI.setVisibility(0);
                al.k(this.ibI, R.drawable.bg_pack);
                this.ibJ.setVisibility(8);
                this.ibK.setVisibility(0);
                switch (this.ibA.pageType) {
                    case 1:
                        format = String.format(this.ibA.getResources().getString(R.string.graffiti_list_title_count), ap.aN(i));
                        break;
                    default:
                        format = String.format(this.ibA.getResources().getString(R.string.praise_item_more), ap.aN(i));
                        break;
                }
                this.ibK.setText(format);
                return;
            default:
                this.ibI.setVisibility(8);
                return;
        }
    }

    public void be(String str, int i) {
        this.ibL.setVisibility(8);
        this.ibM.setVisibility(8);
        this.ibD.setVisibility(8);
        this.ibE.setVisibility(0);
        if (!StringUtils.isNull(str)) {
            this.ibE.setTextOption(NoDataViewFactory.d.oz(str));
        } else if (1 == i) {
            this.ibE.setTextOption(NoDataViewFactory.d.iH(R.string.graffiti_list_no_data));
        } else {
            this.ibE.setTextOption(NoDataViewFactory.d.iH(R.string.praise_list_no_data));
        }
    }

    public void a(com.baidu.tbadk.core.c cVar, int i) {
        if (cVar != null) {
            cVar.setNightMode(i == 1);
            cVar.onModeChanged(this.ibB);
            cVar.onModeChanged(this.ibF);
            cVar.onModeChanged(this.ibI);
            this.ibC.onChangeSkinType(this.ibA.getPageContext(), i);
            al.k(this.ibI, R.drawable.bg_pack);
            if (this.ibE != null) {
                this.ibE.onChangeSkinType(this.ibA.getPageContext(), i);
            }
        }
    }

    public View bXW() {
        return this.ibF;
    }

    public View bXX() {
        return this.ibJ;
    }
}
