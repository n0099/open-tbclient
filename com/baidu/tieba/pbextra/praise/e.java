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
    private c ihV;
    private PraiseListActivity ihW;
    private View ihX;
    private NavigationBar ihY;
    private View ihZ;
    private NoDataView iia;
    private View iib;
    private TextView iic;
    private BdListView iid;
    private View iie;
    private TextView iif;
    private TextView iig;
    private ProgressBar iih;
    private ProgressBar iii;

    public e(PraiseListActivity praiseListActivity, String str) {
        super(praiseListActivity.getPageContext());
        this.ihV = null;
        this.ihW = null;
        this.ihX = null;
        this.ihY = null;
        this.ihZ = null;
        this.iia = null;
        this.iib = null;
        this.iic = null;
        this.iid = null;
        this.iie = null;
        this.iif = null;
        this.iig = null;
        this.iih = null;
        this.iii = null;
        this.ihW = praiseListActivity;
        praiseListActivity.setContentView(R.layout.zan_list_activity);
        this.ihX = praiseListActivity.findViewById(R.id.zan_list_page_parent);
        this.ihY = (NavigationBar) praiseListActivity.findViewById(R.id.zan_list_page_navigationbar);
        this.ihZ = praiseListActivity.findViewById(R.id.zan_list_page_frame);
        this.iia = NoDataViewFactory.a(this.ihW.getPageContext().getContext(), this.ihX, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.g(this.ihW.getActivity(), R.dimen.ds320)), NoDataViewFactory.d.iN(R.string.praise_list_no_data), null);
        this.iid = (BdListView) praiseListActivity.findViewById(R.id.zan_list_page_list);
        TextView textView = new TextView(this.ihW.getActivity());
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)));
        this.iid.addHeaderView(textView, 0);
        this.iih = (ProgressBar) praiseListActivity.findViewById(R.id.zan_list_page_progress);
        this.ihV = new c(praiseListActivity);
        this.iid.setAdapter((ListAdapter) this.ihV);
        this.iid.setOnScrollListener(this.ihV);
        this.ihY.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.ihY.setTitleText("");
        this.iib = LayoutInflater.from(praiseListActivity.getPageContext().getContext()).inflate(R.layout.zan_list_head, (ViewGroup) null);
        this.iib.setOnClickListener(praiseListActivity);
        this.iic = (TextView) this.iib.findViewById(R.id.zan_list_head_text);
        this.iic.setText(str);
        this.iib.setVisibility(8);
        this.iid.addHeaderView(this.iib);
        this.iie = LayoutInflater.from(praiseListActivity.getPageContext().getContext()).inflate(R.layout.zan_list_foot, (ViewGroup) null);
        this.iif = (TextView) this.iie.findViewById(R.id.zan_list_foot_text_continue);
        this.iig = (TextView) this.iie.findViewById(R.id.zan_list_foot_text_more);
        this.iii = (ProgressBar) this.iie.findViewById(R.id.zan_list_foot_progress);
        this.iie.setVisibility(8);
        this.iif.setOnClickListener(praiseListActivity);
        this.iid.addFooterView(this.iie);
        this.iid.setOnItemClickListener(praiseListActivity);
    }

    public void bDI() {
        if (this.ihV != null) {
            this.ihV.notifyDataSetChanged();
        }
    }

    public void py(boolean z) {
        if (z) {
            this.iii.setVisibility(0);
        } else {
            this.iih.setVisibility(0);
        }
    }

    public void caO() {
        this.iih.setVisibility(8);
        this.iii.setVisibility(8);
    }

    public boolean pP() {
        return this.iih.getVisibility() == 0 || this.iii.getVisibility() == 0;
    }

    public void b(int i, List<a> list, int i2, int i3) {
        String format;
        String format2;
        this.iih.setVisibility(8);
        this.iii.setVisibility(8);
        this.iib.setVisibility(0);
        if (i > 0) {
            switch (this.ihW.pageType) {
                case 1:
                    format2 = String.format(this.ihW.getResources().getString(R.string.graffiti_list_title_count), aq.aO(i));
                    break;
                default:
                    format2 = String.format(this.ihW.getResources().getString(R.string.praise_list_title_count), aq.aO(i));
                    break;
            }
            this.ihY.setTitleText(format2);
        } else {
            this.ihY.setTitleText("");
        }
        if (list == null || list.size() < 1) {
            bf(null, this.ihW.pageType);
            return;
        }
        this.ihZ.setVisibility(0);
        this.iia.setVisibility(8);
        this.ihV.dN(list);
        this.ihV.notifyDataSetChanged();
        switch (i2) {
            case 1001:
                this.iie.setVisibility(0);
                this.iif.setVisibility(0);
                this.iig.setVisibility(8);
                return;
            case 1002:
                this.iie.setVisibility(8);
                return;
            case 1003:
                this.iie.setVisibility(0);
                am.k(this.iie, R.drawable.bg_pack);
                this.iif.setVisibility(8);
                this.iig.setVisibility(0);
                switch (this.ihW.pageType) {
                    case 1:
                        format = String.format(this.ihW.getResources().getString(R.string.graffiti_list_title_count), aq.aO(i));
                        break;
                    default:
                        format = String.format(this.ihW.getResources().getString(R.string.praise_item_more), aq.aO(i));
                        break;
                }
                this.iig.setText(format);
                return;
            default:
                this.iie.setVisibility(8);
                return;
        }
    }

    public void bf(String str, int i) {
        this.iih.setVisibility(8);
        this.iii.setVisibility(8);
        this.ihZ.setVisibility(8);
        this.iia.setVisibility(0);
        if (!StringUtils.isNull(str)) {
            this.iia.setTextOption(NoDataViewFactory.d.oP(str));
        } else if (1 == i) {
            this.iia.setTextOption(NoDataViewFactory.d.iN(R.string.graffiti_list_no_data));
        } else {
            this.iia.setTextOption(NoDataViewFactory.d.iN(R.string.praise_list_no_data));
        }
    }

    public void a(com.baidu.tbadk.core.c cVar, int i) {
        if (cVar != null) {
            cVar.setNightMode(i == 1);
            cVar.onModeChanged(this.ihX);
            cVar.onModeChanged(this.iib);
            cVar.onModeChanged(this.iie);
            this.ihY.onChangeSkinType(this.ihW.getPageContext(), i);
            am.k(this.iie, R.drawable.bg_pack);
            if (this.iia != null) {
                this.iia.onChangeSkinType(this.ihW.getPageContext(), i);
            }
        }
    }

    public View caP() {
        return this.iib;
    }

    public View caQ() {
        return this.iif;
    }
}
