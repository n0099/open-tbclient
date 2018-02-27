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
    private ProgressBar ghA;
    private c ghn;
    private PraiseListActivity gho;
    private View ghp;
    private NavigationBar ghq;
    private View ghr;
    private h ghs;
    private View ght;
    private TextView ghu;
    private BdListView ghv;
    private View ghw;
    private TextView ghx;
    private TextView ghy;
    private ProgressBar ghz;

    public e(PraiseListActivity praiseListActivity, String str) {
        super(praiseListActivity.getPageContext());
        this.ghn = null;
        this.gho = null;
        this.ghp = null;
        this.ghq = null;
        this.ghr = null;
        this.ghs = null;
        this.ght = null;
        this.ghu = null;
        this.ghv = null;
        this.ghw = null;
        this.ghx = null;
        this.ghy = null;
        this.ghz = null;
        this.ghA = null;
        this.gho = praiseListActivity;
        praiseListActivity.setContentView(d.h.zan_list_activity);
        this.ghp = praiseListActivity.findViewById(d.g.zan_list_page_parent);
        this.ghq = (NavigationBar) praiseListActivity.findViewById(d.g.zan_list_page_navigationbar);
        this.ghr = praiseListActivity.findViewById(d.g.zan_list_page_frame);
        this.ghs = NoDataViewFactory.a(this.gho.getPageContext().getContext(), this.ghp, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.t(this.gho.getActivity(), d.e.ds320)), NoDataViewFactory.d.gp(d.j.praise_list_no_data), null);
        this.ghv = (BdListView) praiseListActivity.findViewById(d.g.zan_list_page_list);
        TextView textView = new TextView(this.gho.getActivity());
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)));
        this.ghv.addHeaderView(textView, 0);
        this.ghz = (ProgressBar) praiseListActivity.findViewById(d.g.zan_list_page_progress);
        this.ghn = new c(praiseListActivity);
        this.ghv.setAdapter((ListAdapter) this.ghn);
        this.ghv.setOnScrollListener(this.ghn);
        this.ghq.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.ghq.setTitleText("");
        this.ght = LayoutInflater.from(praiseListActivity.getPageContext().getContext()).inflate(d.h.zan_list_head, (ViewGroup) null);
        this.ght.setOnClickListener(praiseListActivity);
        this.ghu = (TextView) this.ght.findViewById(d.g.zan_list_head_text);
        this.ghu.setText(str);
        this.ght.setVisibility(8);
        this.ghv.addHeaderView(this.ght);
        this.ghw = LayoutInflater.from(praiseListActivity.getPageContext().getContext()).inflate(d.h.zan_list_foot, (ViewGroup) null);
        this.ghx = (TextView) this.ghw.findViewById(d.g.zan_list_foot_text_continue);
        this.ghy = (TextView) this.ghw.findViewById(d.g.zan_list_foot_text_more);
        this.ghA = (ProgressBar) this.ghw.findViewById(d.g.zan_list_foot_progress);
        this.ghw.setVisibility(8);
        this.ghx.setOnClickListener(praiseListActivity);
        this.ghv.addFooterView(this.ghw);
        this.ghv.setOnItemClickListener(praiseListActivity);
    }

    public void aJh() {
        if (this.ghn != null) {
            this.ghn.notifyDataSetChanged();
        }
    }

    public void lo(boolean z) {
        if (z) {
            this.ghA.setVisibility(0);
        } else {
            this.ghz.setVisibility(0);
        }
    }

    public void bit() {
        this.ghz.setVisibility(8);
        this.ghA.setVisibility(8);
    }

    public boolean Ek() {
        return this.ghz.getVisibility() == 0 || this.ghA.getVisibility() == 0;
    }

    public void b(int i, List<a> list, int i2, int i3) {
        String format;
        String format2;
        this.ghz.setVisibility(8);
        this.ghA.setVisibility(8);
        this.ght.setVisibility(0);
        if (i > 0) {
            switch (this.gho.pageType) {
                case 1:
                    format2 = String.format(this.gho.getResources().getString(d.j.graffiti_list_title_count), am.J(i));
                    break;
                default:
                    format2 = String.format(this.gho.getResources().getString(d.j.praise_list_title_count), am.J(i));
                    break;
            }
            this.ghq.setTitleText(format2);
        } else {
            this.ghq.setTitleText("");
        }
        if (list == null || list.size() < 1) {
            aA(null, this.gho.pageType);
            return;
        }
        this.ghr.setVisibility(0);
        this.ghs.setVisibility(8);
        this.ghn.cZ(list);
        this.ghn.notifyDataSetChanged();
        switch (i2) {
            case 1001:
                this.ghw.setVisibility(0);
                this.ghx.setVisibility(0);
                this.ghy.setVisibility(8);
                return;
            case 1002:
                this.ghw.setVisibility(8);
                return;
            case 1003:
                this.ghw.setVisibility(0);
                aj.s(this.ghw, d.f.bg_pack);
                this.ghx.setVisibility(8);
                this.ghy.setVisibility(0);
                switch (this.gho.pageType) {
                    case 1:
                        format = String.format(this.gho.getResources().getString(d.j.graffiti_list_title_count), am.J(i));
                        break;
                    default:
                        format = String.format(this.gho.getResources().getString(d.j.praise_item_more), am.J(i));
                        break;
                }
                this.ghy.setText(format);
                return;
            default:
                this.ghw.setVisibility(8);
                return;
        }
    }

    public void aA(String str, int i) {
        this.ghz.setVisibility(8);
        this.ghA.setVisibility(8);
        this.ghr.setVisibility(8);
        this.ghs.setVisibility(0);
        if (!StringUtils.isNull(str)) {
            this.ghs.setTextOption(NoDataViewFactory.d.eT(str));
        } else if (1 == i) {
            this.ghs.setTextOption(NoDataViewFactory.d.gp(d.j.graffiti_list_no_data));
        } else {
            this.ghs.setTextOption(NoDataViewFactory.d.gp(d.j.praise_list_no_data));
        }
    }

    public void a(com.baidu.tbadk.core.c cVar, int i) {
        if (cVar != null) {
            cVar.aQ(i == 1);
            cVar.aM(this.ghp);
            cVar.aM(this.ght);
            cVar.aM(this.ghw);
            this.ghq.onChangeSkinType(this.gho.getPageContext(), i);
            aj.s(this.ghw, d.f.bg_pack);
            if (this.ghs != null) {
                this.ghs.onChangeSkinType(this.gho.getPageContext(), i);
            }
        }
    }

    public View biu() {
        return this.ght;
    }

    public View biv() {
        return this.ghx;
    }
}
