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
/* loaded from: classes7.dex */
public class e extends com.baidu.adp.base.c<PraiseListActivity> {
    private TextView jeA;
    private BdListView jeB;
    private View jeC;
    private TextView jeD;
    private TextView jeE;
    private ProgressBar jeF;
    private ProgressBar jeG;
    private c jet;
    private PraiseListActivity jeu;
    private View jev;
    private NavigationBar jew;
    private View jex;
    private NoDataView jey;
    private View jez;

    public e(PraiseListActivity praiseListActivity, String str) {
        super(praiseListActivity.getPageContext());
        this.jet = null;
        this.jeu = null;
        this.jev = null;
        this.jew = null;
        this.jex = null;
        this.jey = null;
        this.jez = null;
        this.jeA = null;
        this.jeB = null;
        this.jeC = null;
        this.jeD = null;
        this.jeE = null;
        this.jeF = null;
        this.jeG = null;
        this.jeu = praiseListActivity;
        praiseListActivity.setContentView(R.layout.zan_list_activity);
        this.jev = praiseListActivity.findViewById(R.id.zan_list_page_parent);
        this.jew = (NavigationBar) praiseListActivity.findViewById(R.id.zan_list_page_navigationbar);
        this.jex = praiseListActivity.findViewById(R.id.zan_list_page_frame);
        this.jey = NoDataViewFactory.a(this.jeu.getPageContext().getContext(), this.jev, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.getDimens(this.jeu.getActivity(), R.dimen.ds320)), NoDataViewFactory.d.kQ(R.string.praise_list_no_data), null);
        this.jeB = (BdListView) praiseListActivity.findViewById(R.id.zan_list_page_list);
        TextView textView = new TextView(this.jeu.getActivity());
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)));
        this.jeB.addHeaderView(textView, 0);
        this.jeF = (ProgressBar) praiseListActivity.findViewById(R.id.zan_list_page_progress);
        this.jet = new c(praiseListActivity);
        this.jeB.setAdapter((ListAdapter) this.jet);
        this.jeB.setOnScrollListener(this.jet);
        this.jew.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.jew.setTitleText("");
        this.jez = LayoutInflater.from(praiseListActivity.getPageContext().getContext()).inflate(R.layout.zan_list_head, (ViewGroup) null);
        this.jez.setOnClickListener(praiseListActivity);
        this.jeA = (TextView) this.jez.findViewById(R.id.zan_list_head_text);
        this.jeA.setText(str);
        this.jez.setVisibility(8);
        this.jeB.addHeaderView(this.jez);
        this.jeC = LayoutInflater.from(praiseListActivity.getPageContext().getContext()).inflate(R.layout.zan_list_foot, (ViewGroup) null);
        this.jeD = (TextView) this.jeC.findViewById(R.id.zan_list_foot_text_continue);
        this.jeE = (TextView) this.jeC.findViewById(R.id.zan_list_foot_text_more);
        this.jeG = (ProgressBar) this.jeC.findViewById(R.id.zan_list_foot_progress);
        this.jeC.setVisibility(8);
        this.jeD.setOnClickListener(praiseListActivity);
        this.jeB.addFooterView(this.jeC);
        this.jeB.setOnItemClickListener(praiseListActivity);
    }

    public void bTP() {
        if (this.jet != null) {
            this.jet.notifyDataSetChanged();
        }
    }

    public void ra(boolean z) {
        if (z) {
            this.jeG.setVisibility(0);
        } else {
            this.jeF.setVisibility(0);
        }
    }

    public void ctw() {
        this.jeF.setVisibility(8);
        this.jeG.setVisibility(8);
    }

    public boolean isLoading() {
        return this.jeF.getVisibility() == 0 || this.jeG.getVisibility() == 0;
    }

    public void b(int i, List<a> list, int i2, int i3) {
        String format;
        String format2;
        this.jeF.setVisibility(8);
        this.jeG.setVisibility(8);
        this.jez.setVisibility(0);
        if (i > 0) {
            switch (this.jeu.pageType) {
                case 1:
                    format2 = String.format(this.jeu.getResources().getString(R.string.graffiti_list_title_count), aq.numFormatOverWan(i));
                    break;
                default:
                    format2 = String.format(this.jeu.getResources().getString(R.string.praise_list_title_count), aq.numFormatOverWan(i));
                    break;
            }
            this.jew.setTitleText(format2);
        } else {
            this.jew.setTitleText("");
        }
        if (list == null || list.size() < 1) {
            bm(null, this.jeu.pageType);
            return;
        }
        this.jex.setVisibility(0);
        this.jey.setVisibility(8);
        this.jet.dO(list);
        this.jet.notifyDataSetChanged();
        switch (i2) {
            case 1001:
                this.jeC.setVisibility(0);
                this.jeD.setVisibility(0);
                this.jeE.setVisibility(8);
                return;
            case 1002:
                this.jeC.setVisibility(8);
                return;
            case 1003:
                this.jeC.setVisibility(0);
                am.setBackgroundResource(this.jeC, R.drawable.bg_pack);
                this.jeD.setVisibility(8);
                this.jeE.setVisibility(0);
                switch (this.jeu.pageType) {
                    case 1:
                        format = String.format(this.jeu.getResources().getString(R.string.graffiti_list_title_count), aq.numFormatOverWan(i));
                        break;
                    default:
                        format = String.format(this.jeu.getResources().getString(R.string.praise_item_more), aq.numFormatOverWan(i));
                        break;
                }
                this.jeE.setText(format);
                return;
            default:
                this.jeC.setVisibility(8);
                return;
        }
    }

    public void bm(String str, int i) {
        this.jeF.setVisibility(8);
        this.jeG.setVisibility(8);
        this.jex.setVisibility(8);
        this.jey.setVisibility(0);
        if (!StringUtils.isNull(str)) {
            this.jey.setTextOption(NoDataViewFactory.d.tE(str));
        } else if (1 == i) {
            this.jey.setTextOption(NoDataViewFactory.d.kQ(R.string.graffiti_list_no_data));
        } else {
            this.jey.setTextOption(NoDataViewFactory.d.kQ(R.string.praise_list_no_data));
        }
    }

    public void a(com.baidu.tbadk.core.c cVar, int i) {
        if (cVar != null) {
            cVar.setNightMode(i == 1);
            cVar.onModeChanged(this.jev);
            cVar.onModeChanged(this.jez);
            cVar.onModeChanged(this.jeC);
            this.jew.onChangeSkinType(this.jeu.getPageContext(), i);
            am.setBackgroundResource(this.jeC, R.drawable.bg_pack);
            if (this.jey != null) {
                this.jey.onChangeSkinType(this.jeu.getPageContext(), i);
            }
        }
    }

    public View ctx() {
        return this.jez;
    }

    public View cty() {
        return this.jeD;
    }
}
