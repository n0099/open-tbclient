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
import com.baidu.tieba.d;
import java.util.List;
/* loaded from: classes4.dex */
public class e extends com.baidu.adp.base.c<PraiseListActivity> {
    private c hJN;
    private PraiseListActivity hJO;
    private View hJP;
    private NavigationBar hJQ;
    private View hJR;
    private NoDataView hJS;
    private View hJT;
    private TextView hJU;
    private BdListView hJV;
    private View hJW;
    private TextView hJX;
    private TextView hJY;
    private ProgressBar hJZ;
    private ProgressBar hKa;

    public e(PraiseListActivity praiseListActivity, String str) {
        super(praiseListActivity.getPageContext());
        this.hJN = null;
        this.hJO = null;
        this.hJP = null;
        this.hJQ = null;
        this.hJR = null;
        this.hJS = null;
        this.hJT = null;
        this.hJU = null;
        this.hJV = null;
        this.hJW = null;
        this.hJX = null;
        this.hJY = null;
        this.hJZ = null;
        this.hKa = null;
        this.hJO = praiseListActivity;
        praiseListActivity.setContentView(d.h.zan_list_activity);
        this.hJP = praiseListActivity.findViewById(d.g.zan_list_page_parent);
        this.hJQ = (NavigationBar) praiseListActivity.findViewById(d.g.zan_list_page_navigationbar);
        this.hJR = praiseListActivity.findViewById(d.g.zan_list_page_frame);
        this.hJS = NoDataViewFactory.a(this.hJO.getPageContext().getContext(), this.hJP, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.h(this.hJO.getActivity(), d.e.ds320)), NoDataViewFactory.d.hU(d.j.praise_list_no_data), null);
        this.hJV = (BdListView) praiseListActivity.findViewById(d.g.zan_list_page_list);
        TextView textView = new TextView(this.hJO.getActivity());
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)));
        this.hJV.addHeaderView(textView, 0);
        this.hJZ = (ProgressBar) praiseListActivity.findViewById(d.g.zan_list_page_progress);
        this.hJN = new c(praiseListActivity);
        this.hJV.setAdapter((ListAdapter) this.hJN);
        this.hJV.setOnScrollListener(this.hJN);
        this.hJQ.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.hJQ.setTitleText("");
        this.hJT = LayoutInflater.from(praiseListActivity.getPageContext().getContext()).inflate(d.h.zan_list_head, (ViewGroup) null);
        this.hJT.setOnClickListener(praiseListActivity);
        this.hJU = (TextView) this.hJT.findViewById(d.g.zan_list_head_text);
        this.hJU.setText(str);
        this.hJT.setVisibility(8);
        this.hJV.addHeaderView(this.hJT);
        this.hJW = LayoutInflater.from(praiseListActivity.getPageContext().getContext()).inflate(d.h.zan_list_foot, (ViewGroup) null);
        this.hJX = (TextView) this.hJW.findViewById(d.g.zan_list_foot_text_continue);
        this.hJY = (TextView) this.hJW.findViewById(d.g.zan_list_foot_text_more);
        this.hKa = (ProgressBar) this.hJW.findViewById(d.g.zan_list_foot_progress);
        this.hJW.setVisibility(8);
        this.hJX.setOnClickListener(praiseListActivity);
        this.hJV.addFooterView(this.hJW);
        this.hJV.setOnItemClickListener(praiseListActivity);
    }

    public void bto() {
        if (this.hJN != null) {
            this.hJN.notifyDataSetChanged();
        }
    }

    public void ou(boolean z) {
        if (z) {
            this.hKa.setVisibility(0);
        } else {
            this.hJZ.setVisibility(0);
        }
    }

    public void bQg() {
        this.hJZ.setVisibility(8);
        this.hKa.setVisibility(8);
    }

    public boolean qz() {
        return this.hJZ.getVisibility() == 0 || this.hKa.getVisibility() == 0;
    }

    public void b(int i, List<a> list, int i2, int i3) {
        String format;
        String format2;
        this.hJZ.setVisibility(8);
        this.hKa.setVisibility(8);
        this.hJT.setVisibility(0);
        if (i > 0) {
            switch (this.hJO.pageType) {
                case 1:
                    format2 = String.format(this.hJO.getResources().getString(d.j.graffiti_list_title_count), ap.az(i));
                    break;
                default:
                    format2 = String.format(this.hJO.getResources().getString(d.j.praise_list_title_count), ap.az(i));
                    break;
            }
            this.hJQ.setTitleText(format2);
        } else {
            this.hJQ.setTitleText("");
        }
        if (list == null || list.size() < 1) {
            bi(null, this.hJO.pageType);
            return;
        }
        this.hJR.setVisibility(0);
        this.hJS.setVisibility(8);
        this.hJN.dG(list);
        this.hJN.notifyDataSetChanged();
        switch (i2) {
            case 1001:
                this.hJW.setVisibility(0);
                this.hJX.setVisibility(0);
                this.hJY.setVisibility(8);
                return;
            case 1002:
                this.hJW.setVisibility(8);
                return;
            case 1003:
                this.hJW.setVisibility(0);
                al.k(this.hJW, d.f.bg_pack);
                this.hJX.setVisibility(8);
                this.hJY.setVisibility(0);
                switch (this.hJO.pageType) {
                    case 1:
                        format = String.format(this.hJO.getResources().getString(d.j.graffiti_list_title_count), ap.az(i));
                        break;
                    default:
                        format = String.format(this.hJO.getResources().getString(d.j.praise_item_more), ap.az(i));
                        break;
                }
                this.hJY.setText(format);
                return;
            default:
                this.hJW.setVisibility(8);
                return;
        }
    }

    public void bi(String str, int i) {
        this.hJZ.setVisibility(8);
        this.hKa.setVisibility(8);
        this.hJR.setVisibility(8);
        this.hJS.setVisibility(0);
        if (!StringUtils.isNull(str)) {
            this.hJS.setTextOption(NoDataViewFactory.d.no(str));
        } else if (1 == i) {
            this.hJS.setTextOption(NoDataViewFactory.d.hU(d.j.graffiti_list_no_data));
        } else {
            this.hJS.setTextOption(NoDataViewFactory.d.hU(d.j.praise_list_no_data));
        }
    }

    public void a(com.baidu.tbadk.core.c cVar, int i) {
        if (cVar != null) {
            cVar.setNightMode(i == 1);
            cVar.onModeChanged(this.hJP);
            cVar.onModeChanged(this.hJT);
            cVar.onModeChanged(this.hJW);
            this.hJQ.onChangeSkinType(this.hJO.getPageContext(), i);
            al.k(this.hJW, d.f.bg_pack);
            if (this.hJS != null) {
                this.hJS.onChangeSkinType(this.hJO.getPageContext(), i);
            }
        }
    }

    public View bQh() {
        return this.hJT;
    }

    public View bQi() {
        return this.hJX;
    }
}
