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
    private c giR;
    private PraiseListActivity giS;
    private View giT;
    private NavigationBar giU;
    private View giV;
    private NoDataView giW;
    private View giX;
    private TextView giY;
    private BdListView giZ;
    private View gja;
    private TextView gjb;
    private TextView gjc;
    private ProgressBar gjd;
    private ProgressBar gje;

    public e(PraiseListActivity praiseListActivity, String str) {
        super(praiseListActivity.getPageContext());
        this.giR = null;
        this.giS = null;
        this.giT = null;
        this.giU = null;
        this.giV = null;
        this.giW = null;
        this.giX = null;
        this.giY = null;
        this.giZ = null;
        this.gja = null;
        this.gjb = null;
        this.gjc = null;
        this.gjd = null;
        this.gje = null;
        this.giS = praiseListActivity;
        praiseListActivity.setContentView(e.h.zan_list_activity);
        this.giT = praiseListActivity.findViewById(e.g.zan_list_page_parent);
        this.giU = (NavigationBar) praiseListActivity.findViewById(e.g.zan_list_page_navigationbar);
        this.giV = praiseListActivity.findViewById(e.g.zan_list_page_frame);
        this.giW = NoDataViewFactory.a(this.giS.getPageContext().getContext(), this.giT, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.h(this.giS.getActivity(), e.C0200e.ds320)), NoDataViewFactory.d.ec(e.j.praise_list_no_data), null);
        this.giZ = (BdListView) praiseListActivity.findViewById(e.g.zan_list_page_list);
        TextView textView = new TextView(this.giS.getActivity());
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)));
        this.giZ.addHeaderView(textView, 0);
        this.gjd = (ProgressBar) praiseListActivity.findViewById(e.g.zan_list_page_progress);
        this.giR = new c(praiseListActivity);
        this.giZ.setAdapter((ListAdapter) this.giR);
        this.giZ.setOnScrollListener(this.giR);
        this.giU.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.giU.setTitleText("");
        this.giX = LayoutInflater.from(praiseListActivity.getPageContext().getContext()).inflate(e.h.zan_list_head, (ViewGroup) null);
        this.giX.setOnClickListener(praiseListActivity);
        this.giY = (TextView) this.giX.findViewById(e.g.zan_list_head_text);
        this.giY.setText(str);
        this.giX.setVisibility(8);
        this.giZ.addHeaderView(this.giX);
        this.gja = LayoutInflater.from(praiseListActivity.getPageContext().getContext()).inflate(e.h.zan_list_foot, (ViewGroup) null);
        this.gjb = (TextView) this.gja.findViewById(e.g.zan_list_foot_text_continue);
        this.gjc = (TextView) this.gja.findViewById(e.g.zan_list_foot_text_more);
        this.gje = (ProgressBar) this.gja.findViewById(e.g.zan_list_foot_progress);
        this.gja.setVisibility(8);
        this.gjb.setOnClickListener(praiseListActivity);
        this.giZ.addFooterView(this.gja);
        this.giZ.setOnItemClickListener(praiseListActivity);
    }

    public void aPE() {
        if (this.giR != null) {
            this.giR.notifyDataSetChanged();
        }
    }

    public void lR(boolean z) {
        if (z) {
            this.gje.setVisibility(0);
        } else {
            this.gjd.setVisibility(0);
        }
    }

    public void bmv() {
        this.gjd.setVisibility(8);
        this.gje.setVisibility(8);
    }

    public boolean Ee() {
        return this.gjd.getVisibility() == 0 || this.gje.getVisibility() == 0;
    }

    public void b(int i, List<a> list, int i2, int i3) {
        String format;
        String format2;
        this.gjd.setVisibility(8);
        this.gje.setVisibility(8);
        this.giX.setVisibility(0);
        if (i > 0) {
            switch (this.giS.pageType) {
                case 1:
                    format2 = String.format(this.giS.getResources().getString(e.j.graffiti_list_title_count), ao.P(i));
                    break;
                default:
                    format2 = String.format(this.giS.getResources().getString(e.j.praise_list_title_count), ao.P(i));
                    break;
            }
            this.giU.setTitleText(format2);
        } else {
            this.giU.setTitleText("");
        }
        if (list == null || list.size() < 1) {
            aL(null, this.giS.pageType);
            return;
        }
        this.giV.setVisibility(0);
        this.giW.setVisibility(8);
        this.giR.dm(list);
        this.giR.notifyDataSetChanged();
        switch (i2) {
            case 1001:
                this.gja.setVisibility(0);
                this.gjb.setVisibility(0);
                this.gjc.setVisibility(8);
                return;
            case 1002:
                this.gja.setVisibility(8);
                return;
            case 1003:
                this.gja.setVisibility(0);
                al.i(this.gja, e.f.bg_pack);
                this.gjb.setVisibility(8);
                this.gjc.setVisibility(0);
                switch (this.giS.pageType) {
                    case 1:
                        format = String.format(this.giS.getResources().getString(e.j.graffiti_list_title_count), ao.P(i));
                        break;
                    default:
                        format = String.format(this.giS.getResources().getString(e.j.praise_item_more), ao.P(i));
                        break;
                }
                this.gjc.setText(format);
                return;
            default:
                this.gja.setVisibility(8);
                return;
        }
    }

    public void aL(String str, int i) {
        this.gjd.setVisibility(8);
        this.gje.setVisibility(8);
        this.giV.setVisibility(8);
        this.giW.setVisibility(0);
        if (!StringUtils.isNull(str)) {
            this.giW.setTextOption(NoDataViewFactory.d.fV(str));
        } else if (1 == i) {
            this.giW.setTextOption(NoDataViewFactory.d.ec(e.j.graffiti_list_no_data));
        } else {
            this.giW.setTextOption(NoDataViewFactory.d.ec(e.j.praise_list_no_data));
        }
    }

    public void a(com.baidu.tbadk.core.c cVar, int i) {
        if (cVar != null) {
            cVar.setNightMode(i == 1);
            cVar.onModeChanged(this.giT);
            cVar.onModeChanged(this.giX);
            cVar.onModeChanged(this.gja);
            this.giU.onChangeSkinType(this.giS.getPageContext(), i);
            al.i(this.gja, e.f.bg_pack);
            if (this.giW != null) {
                this.giW.onChangeSkinType(this.giS.getPageContext(), i);
            }
        }
    }

    public View bmw() {
        return this.giX;
    }

    public View bmx() {
        return this.gjb;
    }
}
