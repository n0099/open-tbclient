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
    private c iiX;
    private PraiseListActivity iiY;
    private View iiZ;
    private NavigationBar ija;
    private View ijb;
    private NoDataView ijc;
    private View ijd;
    private TextView ije;
    private BdListView ijf;
    private View ijg;
    private TextView ijh;
    private TextView iji;
    private ProgressBar ijj;
    private ProgressBar ijk;

    public e(PraiseListActivity praiseListActivity, String str) {
        super(praiseListActivity.getPageContext());
        this.iiX = null;
        this.iiY = null;
        this.iiZ = null;
        this.ija = null;
        this.ijb = null;
        this.ijc = null;
        this.ijd = null;
        this.ije = null;
        this.ijf = null;
        this.ijg = null;
        this.ijh = null;
        this.iji = null;
        this.ijj = null;
        this.ijk = null;
        this.iiY = praiseListActivity;
        praiseListActivity.setContentView(R.layout.zan_list_activity);
        this.iiZ = praiseListActivity.findViewById(R.id.zan_list_page_parent);
        this.ija = (NavigationBar) praiseListActivity.findViewById(R.id.zan_list_page_navigationbar);
        this.ijb = praiseListActivity.findViewById(R.id.zan_list_page_frame);
        this.ijc = NoDataViewFactory.a(this.iiY.getPageContext().getContext(), this.iiZ, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.g(this.iiY.getActivity(), R.dimen.ds320)), NoDataViewFactory.d.iN(R.string.praise_list_no_data), null);
        this.ijf = (BdListView) praiseListActivity.findViewById(R.id.zan_list_page_list);
        TextView textView = new TextView(this.iiY.getActivity());
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)));
        this.ijf.addHeaderView(textView, 0);
        this.ijj = (ProgressBar) praiseListActivity.findViewById(R.id.zan_list_page_progress);
        this.iiX = new c(praiseListActivity);
        this.ijf.setAdapter((ListAdapter) this.iiX);
        this.ijf.setOnScrollListener(this.iiX);
        this.ija.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.ija.setTitleText("");
        this.ijd = LayoutInflater.from(praiseListActivity.getPageContext().getContext()).inflate(R.layout.zan_list_head, (ViewGroup) null);
        this.ijd.setOnClickListener(praiseListActivity);
        this.ije = (TextView) this.ijd.findViewById(R.id.zan_list_head_text);
        this.ije.setText(str);
        this.ijd.setVisibility(8);
        this.ijf.addHeaderView(this.ijd);
        this.ijg = LayoutInflater.from(praiseListActivity.getPageContext().getContext()).inflate(R.layout.zan_list_foot, (ViewGroup) null);
        this.ijh = (TextView) this.ijg.findViewById(R.id.zan_list_foot_text_continue);
        this.iji = (TextView) this.ijg.findViewById(R.id.zan_list_foot_text_more);
        this.ijk = (ProgressBar) this.ijg.findViewById(R.id.zan_list_foot_progress);
        this.ijg.setVisibility(8);
        this.ijh.setOnClickListener(praiseListActivity);
        this.ijf.addFooterView(this.ijg);
        this.ijf.setOnItemClickListener(praiseListActivity);
    }

    public void bDW() {
        if (this.iiX != null) {
            this.iiX.notifyDataSetChanged();
        }
    }

    public void pz(boolean z) {
        if (z) {
            this.ijk.setVisibility(0);
        } else {
            this.ijj.setVisibility(0);
        }
    }

    public void cbg() {
        this.ijj.setVisibility(8);
        this.ijk.setVisibility(8);
    }

    public boolean pP() {
        return this.ijj.getVisibility() == 0 || this.ijk.getVisibility() == 0;
    }

    public void b(int i, List<a> list, int i2, int i3) {
        String format;
        String format2;
        this.ijj.setVisibility(8);
        this.ijk.setVisibility(8);
        this.ijd.setVisibility(0);
        if (i > 0) {
            switch (this.iiY.pageType) {
                case 1:
                    format2 = String.format(this.iiY.getResources().getString(R.string.graffiti_list_title_count), aq.aO(i));
                    break;
                default:
                    format2 = String.format(this.iiY.getResources().getString(R.string.praise_list_title_count), aq.aO(i));
                    break;
            }
            this.ija.setTitleText(format2);
        } else {
            this.ija.setTitleText("");
        }
        if (list == null || list.size() < 1) {
            bf(null, this.iiY.pageType);
            return;
        }
        this.ijb.setVisibility(0);
        this.ijc.setVisibility(8);
        this.iiX.dM(list);
        this.iiX.notifyDataSetChanged();
        switch (i2) {
            case 1001:
                this.ijg.setVisibility(0);
                this.ijh.setVisibility(0);
                this.iji.setVisibility(8);
                return;
            case 1002:
                this.ijg.setVisibility(8);
                return;
            case 1003:
                this.ijg.setVisibility(0);
                am.k(this.ijg, R.drawable.bg_pack);
                this.ijh.setVisibility(8);
                this.iji.setVisibility(0);
                switch (this.iiY.pageType) {
                    case 1:
                        format = String.format(this.iiY.getResources().getString(R.string.graffiti_list_title_count), aq.aO(i));
                        break;
                    default:
                        format = String.format(this.iiY.getResources().getString(R.string.praise_item_more), aq.aO(i));
                        break;
                }
                this.iji.setText(format);
                return;
            default:
                this.ijg.setVisibility(8);
                return;
        }
    }

    public void bf(String str, int i) {
        this.ijj.setVisibility(8);
        this.ijk.setVisibility(8);
        this.ijb.setVisibility(8);
        this.ijc.setVisibility(0);
        if (!StringUtils.isNull(str)) {
            this.ijc.setTextOption(NoDataViewFactory.d.oP(str));
        } else if (1 == i) {
            this.ijc.setTextOption(NoDataViewFactory.d.iN(R.string.graffiti_list_no_data));
        } else {
            this.ijc.setTextOption(NoDataViewFactory.d.iN(R.string.praise_list_no_data));
        }
    }

    public void a(com.baidu.tbadk.core.c cVar, int i) {
        if (cVar != null) {
            cVar.setNightMode(i == 1);
            cVar.onModeChanged(this.iiZ);
            cVar.onModeChanged(this.ijd);
            cVar.onModeChanged(this.ijg);
            this.ija.onChangeSkinType(this.iiY.getPageContext(), i);
            am.k(this.ijg, R.drawable.bg_pack);
            if (this.ijc != null) {
                this.ijc.onChangeSkinType(this.iiY.getPageContext(), i);
            }
        }
    }

    public View cbh() {
        return this.ijd;
    }

    public View cbi() {
        return this.ijh;
    }
}
