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
/* loaded from: classes4.dex */
public class e extends com.baidu.adp.base.c<PraiseListActivity> {
    private c ikW;
    private PraiseListActivity ikX;
    private View ikY;
    private NavigationBar ikZ;
    private View ila;
    private NoDataView ilb;
    private View ilc;
    private TextView ild;
    private BdListView ile;
    private View ilf;
    private TextView ilg;
    private TextView ilh;
    private ProgressBar ili;
    private ProgressBar ilj;

    public e(PraiseListActivity praiseListActivity, String str) {
        super(praiseListActivity.getPageContext());
        this.ikW = null;
        this.ikX = null;
        this.ikY = null;
        this.ikZ = null;
        this.ila = null;
        this.ilb = null;
        this.ilc = null;
        this.ild = null;
        this.ile = null;
        this.ilf = null;
        this.ilg = null;
        this.ilh = null;
        this.ili = null;
        this.ilj = null;
        this.ikX = praiseListActivity;
        praiseListActivity.setContentView(R.layout.zan_list_activity);
        this.ikY = praiseListActivity.findViewById(R.id.zan_list_page_parent);
        this.ikZ = (NavigationBar) praiseListActivity.findViewById(R.id.zan_list_page_navigationbar);
        this.ila = praiseListActivity.findViewById(R.id.zan_list_page_frame);
        this.ilb = NoDataViewFactory.a(this.ikX.getPageContext().getContext(), this.ikY, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.g(this.ikX.getActivity(), R.dimen.ds320)), NoDataViewFactory.d.iQ(R.string.praise_list_no_data), null);
        this.ile = (BdListView) praiseListActivity.findViewById(R.id.zan_list_page_list);
        TextView textView = new TextView(this.ikX.getActivity());
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)));
        this.ile.addHeaderView(textView, 0);
        this.ili = (ProgressBar) praiseListActivity.findViewById(R.id.zan_list_page_progress);
        this.ikW = new c(praiseListActivity);
        this.ile.setAdapter((ListAdapter) this.ikW);
        this.ile.setOnScrollListener(this.ikW);
        this.ikZ.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.ikZ.setTitleText("");
        this.ilc = LayoutInflater.from(praiseListActivity.getPageContext().getContext()).inflate(R.layout.zan_list_head, (ViewGroup) null);
        this.ilc.setOnClickListener(praiseListActivity);
        this.ild = (TextView) this.ilc.findViewById(R.id.zan_list_head_text);
        this.ild.setText(str);
        this.ilc.setVisibility(8);
        this.ile.addHeaderView(this.ilc);
        this.ilf = LayoutInflater.from(praiseListActivity.getPageContext().getContext()).inflate(R.layout.zan_list_foot, (ViewGroup) null);
        this.ilg = (TextView) this.ilf.findViewById(R.id.zan_list_foot_text_continue);
        this.ilh = (TextView) this.ilf.findViewById(R.id.zan_list_foot_text_more);
        this.ilj = (ProgressBar) this.ilf.findViewById(R.id.zan_list_foot_progress);
        this.ilf.setVisibility(8);
        this.ilg.setOnClickListener(praiseListActivity);
        this.ile.addFooterView(this.ilf);
        this.ile.setOnItemClickListener(praiseListActivity);
    }

    public void bEK() {
        if (this.ikW != null) {
            this.ikW.notifyDataSetChanged();
        }
    }

    public void pC(boolean z) {
        if (z) {
            this.ilj.setVisibility(0);
        } else {
            this.ili.setVisibility(0);
        }
    }

    public void cbU() {
        this.ili.setVisibility(8);
        this.ilj.setVisibility(8);
    }

    public boolean pQ() {
        return this.ili.getVisibility() == 0 || this.ilj.getVisibility() == 0;
    }

    public void b(int i, List<a> list, int i2, int i3) {
        String format;
        String format2;
        this.ili.setVisibility(8);
        this.ilj.setVisibility(8);
        this.ilc.setVisibility(0);
        if (i > 0) {
            switch (this.ikX.pageType) {
                case 1:
                    format2 = String.format(this.ikX.getResources().getString(R.string.graffiti_list_title_count), aq.aO(i));
                    break;
                default:
                    format2 = String.format(this.ikX.getResources().getString(R.string.praise_list_title_count), aq.aO(i));
                    break;
            }
            this.ikZ.setTitleText(format2);
        } else {
            this.ikZ.setTitleText("");
        }
        if (list == null || list.size() < 1) {
            bh(null, this.ikX.pageType);
            return;
        }
        this.ila.setVisibility(0);
        this.ilb.setVisibility(8);
        this.ikW.dM(list);
        this.ikW.notifyDataSetChanged();
        switch (i2) {
            case 1001:
                this.ilf.setVisibility(0);
                this.ilg.setVisibility(0);
                this.ilh.setVisibility(8);
                return;
            case 1002:
                this.ilf.setVisibility(8);
                return;
            case 1003:
                this.ilf.setVisibility(0);
                am.k(this.ilf, R.drawable.bg_pack);
                this.ilg.setVisibility(8);
                this.ilh.setVisibility(0);
                switch (this.ikX.pageType) {
                    case 1:
                        format = String.format(this.ikX.getResources().getString(R.string.graffiti_list_title_count), aq.aO(i));
                        break;
                    default:
                        format = String.format(this.ikX.getResources().getString(R.string.praise_item_more), aq.aO(i));
                        break;
                }
                this.ilh.setText(format);
                return;
            default:
                this.ilf.setVisibility(8);
                return;
        }
    }

    public void bh(String str, int i) {
        this.ili.setVisibility(8);
        this.ilj.setVisibility(8);
        this.ila.setVisibility(8);
        this.ilb.setVisibility(0);
        if (!StringUtils.isNull(str)) {
            this.ilb.setTextOption(NoDataViewFactory.d.oX(str));
        } else if (1 == i) {
            this.ilb.setTextOption(NoDataViewFactory.d.iQ(R.string.graffiti_list_no_data));
        } else {
            this.ilb.setTextOption(NoDataViewFactory.d.iQ(R.string.praise_list_no_data));
        }
    }

    public void a(com.baidu.tbadk.core.c cVar, int i) {
        if (cVar != null) {
            cVar.setNightMode(i == 1);
            cVar.onModeChanged(this.ikY);
            cVar.onModeChanged(this.ilc);
            cVar.onModeChanged(this.ilf);
            this.ikZ.onChangeSkinType(this.ikX.getPageContext(), i);
            am.k(this.ilf, R.drawable.bg_pack);
            if (this.ilb != null) {
                this.ilb.onChangeSkinType(this.ikX.getPageContext(), i);
            }
        }
    }

    public View cbV() {
        return this.ilc;
    }

    public View cbW() {
        return this.ilg;
    }
}
