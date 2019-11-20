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
    private c iiP;
    private PraiseListActivity iiQ;
    private View iiR;
    private NavigationBar iiS;
    private View iiT;
    private NoDataView iiU;
    private View iiV;
    private TextView iiW;
    private BdListView iiX;
    private View iiY;
    private TextView iiZ;
    private TextView ija;
    private ProgressBar ijb;
    private ProgressBar ijc;

    public e(PraiseListActivity praiseListActivity, String str) {
        super(praiseListActivity.getPageContext());
        this.iiP = null;
        this.iiQ = null;
        this.iiR = null;
        this.iiS = null;
        this.iiT = null;
        this.iiU = null;
        this.iiV = null;
        this.iiW = null;
        this.iiX = null;
        this.iiY = null;
        this.iiZ = null;
        this.ija = null;
        this.ijb = null;
        this.ijc = null;
        this.iiQ = praiseListActivity;
        praiseListActivity.setContentView(R.layout.zan_list_activity);
        this.iiR = praiseListActivity.findViewById(R.id.zan_list_page_parent);
        this.iiS = (NavigationBar) praiseListActivity.findViewById(R.id.zan_list_page_navigationbar);
        this.iiT = praiseListActivity.findViewById(R.id.zan_list_page_frame);
        this.iiU = NoDataViewFactory.a(this.iiQ.getPageContext().getContext(), this.iiR, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.getDimens(this.iiQ.getActivity(), R.dimen.ds320)), NoDataViewFactory.d.iK(R.string.praise_list_no_data), null);
        this.iiX = (BdListView) praiseListActivity.findViewById(R.id.zan_list_page_list);
        TextView textView = new TextView(this.iiQ.getActivity());
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)));
        this.iiX.addHeaderView(textView, 0);
        this.ijb = (ProgressBar) praiseListActivity.findViewById(R.id.zan_list_page_progress);
        this.iiP = new c(praiseListActivity);
        this.iiX.setAdapter((ListAdapter) this.iiP);
        this.iiX.setOnScrollListener(this.iiP);
        this.iiS.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.iiS.setTitleText("");
        this.iiV = LayoutInflater.from(praiseListActivity.getPageContext().getContext()).inflate(R.layout.zan_list_head, (ViewGroup) null);
        this.iiV.setOnClickListener(praiseListActivity);
        this.iiW = (TextView) this.iiV.findViewById(R.id.zan_list_head_text);
        this.iiW.setText(str);
        this.iiV.setVisibility(8);
        this.iiX.addHeaderView(this.iiV);
        this.iiY = LayoutInflater.from(praiseListActivity.getPageContext().getContext()).inflate(R.layout.zan_list_foot, (ViewGroup) null);
        this.iiZ = (TextView) this.iiY.findViewById(R.id.zan_list_foot_text_continue);
        this.ija = (TextView) this.iiY.findViewById(R.id.zan_list_foot_text_more);
        this.ijc = (ProgressBar) this.iiY.findViewById(R.id.zan_list_foot_progress);
        this.iiY.setVisibility(8);
        this.iiZ.setOnClickListener(praiseListActivity);
        this.iiX.addFooterView(this.iiY);
        this.iiX.setOnItemClickListener(praiseListActivity);
    }

    public void bBt() {
        if (this.iiP != null) {
            this.iiP.notifyDataSetChanged();
        }
    }

    public void pl(boolean z) {
        if (z) {
            this.ijc.setVisibility(0);
        } else {
            this.ijb.setVisibility(0);
        }
    }

    public void bYU() {
        this.ijb.setVisibility(8);
        this.ijc.setVisibility(8);
    }

    public boolean isLoading() {
        return this.ijb.getVisibility() == 0 || this.ijc.getVisibility() == 0;
    }

    public void b(int i, List<a> list, int i2, int i3) {
        String format;
        String format2;
        this.ijb.setVisibility(8);
        this.ijc.setVisibility(8);
        this.iiV.setVisibility(0);
        if (i > 0) {
            switch (this.iiQ.pageType) {
                case 1:
                    format2 = String.format(this.iiQ.getResources().getString(R.string.graffiti_list_title_count), aq.numFormatOverWan(i));
                    break;
                default:
                    format2 = String.format(this.iiQ.getResources().getString(R.string.praise_list_title_count), aq.numFormatOverWan(i));
                    break;
            }
            this.iiS.setTitleText(format2);
        } else {
            this.iiS.setTitleText("");
        }
        if (list == null || list.size() < 1) {
            bc(null, this.iiQ.pageType);
            return;
        }
        this.iiT.setVisibility(0);
        this.iiU.setVisibility(8);
        this.iiP.dZ(list);
        this.iiP.notifyDataSetChanged();
        switch (i2) {
            case 1001:
                this.iiY.setVisibility(0);
                this.iiZ.setVisibility(0);
                this.ija.setVisibility(8);
                return;
            case 1002:
                this.iiY.setVisibility(8);
                return;
            case 1003:
                this.iiY.setVisibility(0);
                am.setBackgroundResource(this.iiY, R.drawable.bg_pack);
                this.iiZ.setVisibility(8);
                this.ija.setVisibility(0);
                switch (this.iiQ.pageType) {
                    case 1:
                        format = String.format(this.iiQ.getResources().getString(R.string.graffiti_list_title_count), aq.numFormatOverWan(i));
                        break;
                    default:
                        format = String.format(this.iiQ.getResources().getString(R.string.praise_item_more), aq.numFormatOverWan(i));
                        break;
                }
                this.ija.setText(format);
                return;
            default:
                this.iiY.setVisibility(8);
                return;
        }
    }

    public void bc(String str, int i) {
        this.ijb.setVisibility(8);
        this.ijc.setVisibility(8);
        this.iiT.setVisibility(8);
        this.iiU.setVisibility(0);
        if (!StringUtils.isNull(str)) {
            this.iiU.setTextOption(NoDataViewFactory.d.ow(str));
        } else if (1 == i) {
            this.iiU.setTextOption(NoDataViewFactory.d.iK(R.string.graffiti_list_no_data));
        } else {
            this.iiU.setTextOption(NoDataViewFactory.d.iK(R.string.praise_list_no_data));
        }
    }

    public void a(com.baidu.tbadk.core.c cVar, int i) {
        if (cVar != null) {
            cVar.setNightMode(i == 1);
            cVar.onModeChanged(this.iiR);
            cVar.onModeChanged(this.iiV);
            cVar.onModeChanged(this.iiY);
            this.iiS.onChangeSkinType(this.iiQ.getPageContext(), i);
            am.setBackgroundResource(this.iiY, R.drawable.bg_pack);
            if (this.iiU != null) {
                this.iiU.onChangeSkinType(this.iiQ.getPageContext(), i);
            }
        }
    }

    public View bYV() {
        return this.iiV;
    }

    public View bYW() {
        return this.iiZ;
    }
}
