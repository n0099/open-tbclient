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
    private ProgressBar jeA;
    private ProgressBar jeB;
    private c jeo;
    private PraiseListActivity jep;
    private View jeq;
    private NavigationBar jer;
    private View jes;
    private NoDataView jet;
    private View jeu;
    private TextView jev;
    private BdListView jew;
    private View jex;
    private TextView jey;
    private TextView jez;

    public e(PraiseListActivity praiseListActivity, String str) {
        super(praiseListActivity.getPageContext());
        this.jeo = null;
        this.jep = null;
        this.jeq = null;
        this.jer = null;
        this.jes = null;
        this.jet = null;
        this.jeu = null;
        this.jev = null;
        this.jew = null;
        this.jex = null;
        this.jey = null;
        this.jez = null;
        this.jeA = null;
        this.jeB = null;
        this.jep = praiseListActivity;
        praiseListActivity.setContentView(R.layout.zan_list_activity);
        this.jeq = praiseListActivity.findViewById(R.id.zan_list_page_parent);
        this.jer = (NavigationBar) praiseListActivity.findViewById(R.id.zan_list_page_navigationbar);
        this.jes = praiseListActivity.findViewById(R.id.zan_list_page_frame);
        this.jet = NoDataViewFactory.a(this.jep.getPageContext().getContext(), this.jeq, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.getDimens(this.jep.getActivity(), R.dimen.ds320)), NoDataViewFactory.d.kQ(R.string.praise_list_no_data), null);
        this.jew = (BdListView) praiseListActivity.findViewById(R.id.zan_list_page_list);
        TextView textView = new TextView(this.jep.getActivity());
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)));
        this.jew.addHeaderView(textView, 0);
        this.jeA = (ProgressBar) praiseListActivity.findViewById(R.id.zan_list_page_progress);
        this.jeo = new c(praiseListActivity);
        this.jew.setAdapter((ListAdapter) this.jeo);
        this.jew.setOnScrollListener(this.jeo);
        this.jer.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.jer.setTitleText("");
        this.jeu = LayoutInflater.from(praiseListActivity.getPageContext().getContext()).inflate(R.layout.zan_list_head, (ViewGroup) null);
        this.jeu.setOnClickListener(praiseListActivity);
        this.jev = (TextView) this.jeu.findViewById(R.id.zan_list_head_text);
        this.jev.setText(str);
        this.jeu.setVisibility(8);
        this.jew.addHeaderView(this.jeu);
        this.jex = LayoutInflater.from(praiseListActivity.getPageContext().getContext()).inflate(R.layout.zan_list_foot, (ViewGroup) null);
        this.jey = (TextView) this.jex.findViewById(R.id.zan_list_foot_text_continue);
        this.jez = (TextView) this.jex.findViewById(R.id.zan_list_foot_text_more);
        this.jeB = (ProgressBar) this.jex.findViewById(R.id.zan_list_foot_progress);
        this.jex.setVisibility(8);
        this.jey.setOnClickListener(praiseListActivity);
        this.jew.addFooterView(this.jex);
        this.jew.setOnItemClickListener(praiseListActivity);
    }

    public void bTP() {
        if (this.jeo != null) {
            this.jeo.notifyDataSetChanged();
        }
    }

    public void ra(boolean z) {
        if (z) {
            this.jeB.setVisibility(0);
        } else {
            this.jeA.setVisibility(0);
        }
    }

    public void ctu() {
        this.jeA.setVisibility(8);
        this.jeB.setVisibility(8);
    }

    public boolean isLoading() {
        return this.jeA.getVisibility() == 0 || this.jeB.getVisibility() == 0;
    }

    public void b(int i, List<a> list, int i2, int i3) {
        String format;
        String format2;
        this.jeA.setVisibility(8);
        this.jeB.setVisibility(8);
        this.jeu.setVisibility(0);
        if (i > 0) {
            switch (this.jep.pageType) {
                case 1:
                    format2 = String.format(this.jep.getResources().getString(R.string.graffiti_list_title_count), aq.numFormatOverWan(i));
                    break;
                default:
                    format2 = String.format(this.jep.getResources().getString(R.string.praise_list_title_count), aq.numFormatOverWan(i));
                    break;
            }
            this.jer.setTitleText(format2);
        } else {
            this.jer.setTitleText("");
        }
        if (list == null || list.size() < 1) {
            bm(null, this.jep.pageType);
            return;
        }
        this.jes.setVisibility(0);
        this.jet.setVisibility(8);
        this.jeo.dO(list);
        this.jeo.notifyDataSetChanged();
        switch (i2) {
            case 1001:
                this.jex.setVisibility(0);
                this.jey.setVisibility(0);
                this.jez.setVisibility(8);
                return;
            case 1002:
                this.jex.setVisibility(8);
                return;
            case 1003:
                this.jex.setVisibility(0);
                am.setBackgroundResource(this.jex, R.drawable.bg_pack);
                this.jey.setVisibility(8);
                this.jez.setVisibility(0);
                switch (this.jep.pageType) {
                    case 1:
                        format = String.format(this.jep.getResources().getString(R.string.graffiti_list_title_count), aq.numFormatOverWan(i));
                        break;
                    default:
                        format = String.format(this.jep.getResources().getString(R.string.praise_item_more), aq.numFormatOverWan(i));
                        break;
                }
                this.jez.setText(format);
                return;
            default:
                this.jex.setVisibility(8);
                return;
        }
    }

    public void bm(String str, int i) {
        this.jeA.setVisibility(8);
        this.jeB.setVisibility(8);
        this.jes.setVisibility(8);
        this.jet.setVisibility(0);
        if (!StringUtils.isNull(str)) {
            this.jet.setTextOption(NoDataViewFactory.d.tE(str));
        } else if (1 == i) {
            this.jet.setTextOption(NoDataViewFactory.d.kQ(R.string.graffiti_list_no_data));
        } else {
            this.jet.setTextOption(NoDataViewFactory.d.kQ(R.string.praise_list_no_data));
        }
    }

    public void a(com.baidu.tbadk.core.c cVar, int i) {
        if (cVar != null) {
            cVar.setNightMode(i == 1);
            cVar.onModeChanged(this.jeq);
            cVar.onModeChanged(this.jeu);
            cVar.onModeChanged(this.jex);
            this.jer.onChangeSkinType(this.jep.getPageContext(), i);
            am.setBackgroundResource(this.jex, R.drawable.bg_pack);
            if (this.jet != null) {
                this.jet.onChangeSkinType(this.jep.getPageContext(), i);
            }
        }
    }

    public View ctv() {
        return this.jeu;
    }

    public View ctw() {
        return this.jey;
    }
}
