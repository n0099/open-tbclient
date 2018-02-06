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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.h;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.d;
import java.util.List;
/* loaded from: classes3.dex */
public class e extends com.baidu.adp.base.c<PraiseListActivity> {
    private View ghA;
    private NavigationBar ghB;
    private View ghC;
    private h ghD;
    private View ghE;
    private TextView ghF;
    private BdListView ghG;
    private View ghH;
    private TextView ghI;
    private TextView ghJ;
    private ProgressBar ghK;
    private ProgressBar ghL;
    private c ghy;
    private PraiseListActivity ghz;

    public e(PraiseListActivity praiseListActivity, String str) {
        super(praiseListActivity.getPageContext());
        this.ghy = null;
        this.ghz = null;
        this.ghA = null;
        this.ghB = null;
        this.ghC = null;
        this.ghD = null;
        this.ghE = null;
        this.ghF = null;
        this.ghG = null;
        this.ghH = null;
        this.ghI = null;
        this.ghJ = null;
        this.ghK = null;
        this.ghL = null;
        this.ghz = praiseListActivity;
        praiseListActivity.setContentView(d.h.zan_list_activity);
        this.ghA = praiseListActivity.findViewById(d.g.zan_list_page_parent);
        this.ghB = (NavigationBar) praiseListActivity.findViewById(d.g.zan_list_page_navigationbar);
        this.ghC = praiseListActivity.findViewById(d.g.zan_list_page_frame);
        this.ghD = NoDataViewFactory.a(this.ghz.getPageContext().getContext(), this.ghA, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.t(this.ghz.getActivity(), d.e.ds320)), NoDataViewFactory.d.gp(d.j.praise_list_no_data), null);
        this.ghG = (BdListView) praiseListActivity.findViewById(d.g.zan_list_page_list);
        TextView textView = new TextView(this.ghz.getActivity());
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)));
        this.ghG.addHeaderView(textView, 0);
        this.ghK = (ProgressBar) praiseListActivity.findViewById(d.g.zan_list_page_progress);
        this.ghy = new c(praiseListActivity);
        this.ghG.setAdapter((ListAdapter) this.ghy);
        this.ghG.setOnScrollListener(this.ghy);
        this.ghB.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.ghB.setTitleText("");
        this.ghE = LayoutInflater.from(praiseListActivity.getPageContext().getContext()).inflate(d.h.zan_list_head, (ViewGroup) null);
        this.ghE.setOnClickListener(praiseListActivity);
        this.ghF = (TextView) this.ghE.findViewById(d.g.zan_list_head_text);
        this.ghF.setText(str);
        this.ghE.setVisibility(8);
        this.ghG.addHeaderView(this.ghE);
        this.ghH = LayoutInflater.from(praiseListActivity.getPageContext().getContext()).inflate(d.h.zan_list_foot, (ViewGroup) null);
        this.ghI = (TextView) this.ghH.findViewById(d.g.zan_list_foot_text_continue);
        this.ghJ = (TextView) this.ghH.findViewById(d.g.zan_list_foot_text_more);
        this.ghL = (ProgressBar) this.ghH.findViewById(d.g.zan_list_foot_progress);
        this.ghH.setVisibility(8);
        this.ghI.setOnClickListener(praiseListActivity);
        this.ghG.addFooterView(this.ghH);
        this.ghG.setOnItemClickListener(praiseListActivity);
    }

    public void aJi() {
        if (this.ghy != null) {
            this.ghy.notifyDataSetChanged();
        }
    }

    public void lo(boolean z) {
        if (z) {
            this.ghL.setVisibility(0);
        } else {
            this.ghK.setVisibility(0);
        }
    }

    public void biu() {
        this.ghK.setVisibility(8);
        this.ghL.setVisibility(8);
    }

    public boolean El() {
        return this.ghK.getVisibility() == 0 || this.ghL.getVisibility() == 0;
    }

    public void b(int i, List<a> list, int i2, int i3) {
        String format;
        String format2;
        this.ghK.setVisibility(8);
        this.ghL.setVisibility(8);
        this.ghE.setVisibility(0);
        if (i > 0) {
            switch (this.ghz.pageType) {
                case 1:
                    format2 = String.format(this.ghz.getResources().getString(d.j.graffiti_list_title_count), am.J(i));
                    break;
                default:
                    format2 = String.format(this.ghz.getResources().getString(d.j.praise_list_title_count), am.J(i));
                    break;
            }
            this.ghB.setTitleText(format2);
        } else {
            this.ghB.setTitleText("");
        }
        if (list == null || list.size() < 1) {
            aA(null, this.ghz.pageType);
            return;
        }
        this.ghC.setVisibility(0);
        this.ghD.setVisibility(8);
        this.ghy.cZ(list);
        this.ghy.notifyDataSetChanged();
        switch (i2) {
            case 1001:
                this.ghH.setVisibility(0);
                this.ghI.setVisibility(0);
                this.ghJ.setVisibility(8);
                return;
            case 1002:
                this.ghH.setVisibility(8);
                return;
            case 1003:
                this.ghH.setVisibility(0);
                aj.s(this.ghH, d.f.bg_pack);
                this.ghI.setVisibility(8);
                this.ghJ.setVisibility(0);
                switch (this.ghz.pageType) {
                    case 1:
                        format = String.format(this.ghz.getResources().getString(d.j.graffiti_list_title_count), am.J(i));
                        break;
                    default:
                        format = String.format(this.ghz.getResources().getString(d.j.praise_item_more), am.J(i));
                        break;
                }
                this.ghJ.setText(format);
                return;
            default:
                this.ghH.setVisibility(8);
                return;
        }
    }

    public void aA(String str, int i) {
        this.ghK.setVisibility(8);
        this.ghL.setVisibility(8);
        this.ghC.setVisibility(8);
        this.ghD.setVisibility(0);
        if (!StringUtils.isNull(str)) {
            this.ghD.setTextOption(NoDataViewFactory.d.eT(str));
        } else if (1 == i) {
            this.ghD.setTextOption(NoDataViewFactory.d.gp(d.j.graffiti_list_no_data));
        } else {
            this.ghD.setTextOption(NoDataViewFactory.d.gp(d.j.praise_list_no_data));
        }
    }

    public void a(com.baidu.tbadk.core.c cVar, int i) {
        if (cVar != null) {
            cVar.aQ(i == 1);
            cVar.aM(this.ghA);
            cVar.aM(this.ghE);
            cVar.aM(this.ghH);
            this.ghB.onChangeSkinType(this.ghz.getPageContext(), i);
            aj.s(this.ghH, d.f.bg_pack);
            if (this.ghD != null) {
                this.ghD.onChangeSkinType(this.ghz.getPageContext(), i);
            }
        }
    }

    public View biv() {
        return this.ghE;
    }

    public View biw() {
        return this.ghI;
    }
}
