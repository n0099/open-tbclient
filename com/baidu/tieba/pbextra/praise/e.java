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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.e;
import java.util.List;
/* loaded from: classes3.dex */
public class e extends com.baidu.adp.base.c<PraiseListActivity> {
    private View gsA;
    private NavigationBar gsB;
    private View gsC;
    private NoDataView gsD;
    private View gsE;
    private TextView gsF;
    private BdListView gsG;
    private View gsH;
    private TextView gsI;
    private TextView gsJ;
    private ProgressBar gsK;
    private ProgressBar gsL;
    private c gsy;
    private PraiseListActivity gsz;

    public e(PraiseListActivity praiseListActivity, String str) {
        super(praiseListActivity.getPageContext());
        this.gsy = null;
        this.gsz = null;
        this.gsA = null;
        this.gsB = null;
        this.gsC = null;
        this.gsD = null;
        this.gsE = null;
        this.gsF = null;
        this.gsG = null;
        this.gsH = null;
        this.gsI = null;
        this.gsJ = null;
        this.gsK = null;
        this.gsL = null;
        this.gsz = praiseListActivity;
        praiseListActivity.setContentView(e.h.zan_list_activity);
        this.gsA = praiseListActivity.findViewById(e.g.zan_list_page_parent);
        this.gsB = (NavigationBar) praiseListActivity.findViewById(e.g.zan_list_page_navigationbar);
        this.gsC = praiseListActivity.findViewById(e.g.zan_list_page_frame);
        this.gsD = NoDataViewFactory.a(this.gsz.getPageContext().getContext(), this.gsA, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.h(this.gsz.getActivity(), e.C0210e.ds320)), NoDataViewFactory.d.eq(e.j.praise_list_no_data), null);
        this.gsG = (BdListView) praiseListActivity.findViewById(e.g.zan_list_page_list);
        TextView textView = new TextView(this.gsz.getActivity());
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)));
        this.gsG.addHeaderView(textView, 0);
        this.gsK = (ProgressBar) praiseListActivity.findViewById(e.g.zan_list_page_progress);
        this.gsy = new c(praiseListActivity);
        this.gsG.setAdapter((ListAdapter) this.gsy);
        this.gsG.setOnScrollListener(this.gsy);
        this.gsB.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.gsB.setTitleText("");
        this.gsE = LayoutInflater.from(praiseListActivity.getPageContext().getContext()).inflate(e.h.zan_list_head, (ViewGroup) null);
        this.gsE.setOnClickListener(praiseListActivity);
        this.gsF = (TextView) this.gsE.findViewById(e.g.zan_list_head_text);
        this.gsF.setText(str);
        this.gsE.setVisibility(8);
        this.gsG.addHeaderView(this.gsE);
        this.gsH = LayoutInflater.from(praiseListActivity.getPageContext().getContext()).inflate(e.h.zan_list_foot, (ViewGroup) null);
        this.gsI = (TextView) this.gsH.findViewById(e.g.zan_list_foot_text_continue);
        this.gsJ = (TextView) this.gsH.findViewById(e.g.zan_list_foot_text_more);
        this.gsL = (ProgressBar) this.gsH.findViewById(e.g.zan_list_foot_progress);
        this.gsH.setVisibility(8);
        this.gsI.setOnClickListener(praiseListActivity);
        this.gsG.addFooterView(this.gsH);
        this.gsG.setOnItemClickListener(praiseListActivity);
    }

    public void aSj() {
        if (this.gsy != null) {
            this.gsy.notifyDataSetChanged();
        }
    }

    public void lX(boolean z) {
        if (z) {
            this.gsL.setVisibility(0);
        } else {
            this.gsK.setVisibility(0);
        }
    }

    public void boZ() {
        this.gsK.setVisibility(8);
        this.gsL.setVisibility(8);
    }

    public boolean Fi() {
        return this.gsK.getVisibility() == 0 || this.gsL.getVisibility() == 0;
    }

    public void b(int i, List<a> list, int i2, int i3) {
        String format;
        String format2;
        this.gsK.setVisibility(8);
        this.gsL.setVisibility(8);
        this.gsE.setVisibility(0);
        if (i > 0) {
            switch (this.gsz.pageType) {
                case 1:
                    format2 = String.format(this.gsz.getResources().getString(e.j.graffiti_list_title_count), ao.X(i));
                    break;
                default:
                    format2 = String.format(this.gsz.getResources().getString(e.j.praise_list_title_count), ao.X(i));
                    break;
            }
            this.gsB.setTitleText(format2);
        } else {
            this.gsB.setTitleText("");
        }
        if (list == null || list.size() < 1) {
            aN(null, this.gsz.pageType);
            return;
        }
        this.gsC.setVisibility(0);
        this.gsD.setVisibility(8);
        this.gsy.dr(list);
        this.gsy.notifyDataSetChanged();
        switch (i2) {
            case 1001:
                this.gsH.setVisibility(0);
                this.gsI.setVisibility(0);
                this.gsJ.setVisibility(8);
                return;
            case 1002:
                this.gsH.setVisibility(8);
                return;
            case 1003:
                this.gsH.setVisibility(0);
                al.i(this.gsH, e.f.bg_pack);
                this.gsI.setVisibility(8);
                this.gsJ.setVisibility(0);
                switch (this.gsz.pageType) {
                    case 1:
                        format = String.format(this.gsz.getResources().getString(e.j.graffiti_list_title_count), ao.X(i));
                        break;
                    default:
                        format = String.format(this.gsz.getResources().getString(e.j.praise_item_more), ao.X(i));
                        break;
                }
                this.gsJ.setText(format);
                return;
            default:
                this.gsH.setVisibility(8);
                return;
        }
    }

    public void aN(String str, int i) {
        this.gsK.setVisibility(8);
        this.gsL.setVisibility(8);
        this.gsC.setVisibility(8);
        this.gsD.setVisibility(0);
        if (!StringUtils.isNull(str)) {
            this.gsD.setTextOption(NoDataViewFactory.d.go(str));
        } else if (1 == i) {
            this.gsD.setTextOption(NoDataViewFactory.d.eq(e.j.graffiti_list_no_data));
        } else {
            this.gsD.setTextOption(NoDataViewFactory.d.eq(e.j.praise_list_no_data));
        }
    }

    public void a(com.baidu.tbadk.core.c cVar, int i) {
        if (cVar != null) {
            cVar.setNightMode(i == 1);
            cVar.onModeChanged(this.gsA);
            cVar.onModeChanged(this.gsE);
            cVar.onModeChanged(this.gsH);
            this.gsB.onChangeSkinType(this.gsz.getPageContext(), i);
            al.i(this.gsH, e.f.bg_pack);
            if (this.gsD != null) {
                this.gsD.onChangeSkinType(this.gsz.getPageContext(), i);
            }
        }
    }

    public View bpa() {
        return this.gsE;
    }

    public View bpb() {
        return this.gsI;
    }
}
