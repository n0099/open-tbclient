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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes22.dex */
public class e extends com.baidu.adp.base.c<PraiseListActivity> {
    private c lBj;
    private PraiseListActivity lBk;
    private View lBl;
    private NavigationBar lBm;
    private View lBn;
    private NoDataView lBo;
    private View lBp;
    private TextView lBq;
    private BdListView lBr;
    private View lBs;
    private TextView lBt;
    private TextView lBu;
    private ProgressBar lBv;
    private ProgressBar lBw;

    public e(PraiseListActivity praiseListActivity, String str) {
        super(praiseListActivity.getPageContext());
        this.lBj = null;
        this.lBk = null;
        this.lBl = null;
        this.lBm = null;
        this.lBn = null;
        this.lBo = null;
        this.lBp = null;
        this.lBq = null;
        this.lBr = null;
        this.lBs = null;
        this.lBt = null;
        this.lBu = null;
        this.lBv = null;
        this.lBw = null;
        this.lBk = praiseListActivity;
        praiseListActivity.setContentView(R.layout.zan_list_activity);
        this.lBl = praiseListActivity.findViewById(R.id.zan_list_page_parent);
        this.lBm = (NavigationBar) praiseListActivity.findViewById(R.id.zan_list_page_navigationbar);
        this.lBn = praiseListActivity.findViewById(R.id.zan_list_page_frame);
        this.lBo = NoDataViewFactory.a(this.lBk.getPageContext().getContext(), this.lBl, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.getDimens(this.lBk.getActivity(), R.dimen.ds320)), NoDataViewFactory.d.pv(R.string.praise_list_no_data), null);
        this.lBr = (BdListView) praiseListActivity.findViewById(R.id.zan_list_page_list);
        TextView textView = new TextView(this.lBk.getActivity());
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)));
        this.lBr.addHeaderView(textView, 0);
        this.lBv = (ProgressBar) praiseListActivity.findViewById(R.id.zan_list_page_progress);
        this.lBj = new c(praiseListActivity);
        this.lBr.setAdapter((ListAdapter) this.lBj);
        this.lBr.setOnScrollListener(this.lBj);
        this.lBm.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.lBm.setTitleText("");
        this.lBp = LayoutInflater.from(praiseListActivity.getPageContext().getContext()).inflate(R.layout.zan_list_head, (ViewGroup) null);
        this.lBp.setOnClickListener(praiseListActivity);
        this.lBq = (TextView) this.lBp.findViewById(R.id.zan_list_head_text);
        this.lBq.setText(str);
        this.lBp.setVisibility(8);
        this.lBr.addHeaderView(this.lBp);
        this.lBs = LayoutInflater.from(praiseListActivity.getPageContext().getContext()).inflate(R.layout.zan_list_foot, (ViewGroup) null);
        this.lBt = (TextView) this.lBs.findViewById(R.id.zan_list_foot_text_continue);
        this.lBu = (TextView) this.lBs.findViewById(R.id.zan_list_foot_text_more);
        this.lBw = (ProgressBar) this.lBs.findViewById(R.id.zan_list_foot_progress);
        this.lBs.setVisibility(8);
        this.lBt.setOnClickListener(praiseListActivity);
        this.lBr.addFooterView(this.lBs);
        this.lBr.setOnItemClickListener(praiseListActivity);
    }

    public void cMM() {
        if (this.lBj != null) {
            this.lBj.notifyDataSetChanged();
        }
    }

    public void vh(boolean z) {
        if (z) {
            this.lBw.setVisibility(0);
        } else {
            this.lBv.setVisibility(0);
        }
    }

    public void dny() {
        this.lBv.setVisibility(8);
        this.lBw.setVisibility(8);
    }

    public boolean isLoading() {
        return this.lBv.getVisibility() == 0 || this.lBw.getVisibility() == 0;
    }

    public void b(int i, List<a> list, int i2, int i3) {
        String format;
        String format2;
        this.lBv.setVisibility(8);
        this.lBw.setVisibility(8);
        this.lBp.setVisibility(0);
        if (i > 0) {
            switch (this.lBk.pageType) {
                case 1:
                    format2 = String.format(this.lBk.getResources().getString(R.string.graffiti_list_title_count), at.numFormatOverWan(i));
                    break;
                default:
                    format2 = String.format(this.lBk.getResources().getString(R.string.praise_list_title_count), at.numFormatOverWan(i));
                    break;
            }
            this.lBm.setTitleText(format2);
        } else {
            this.lBm.setTitleText("");
        }
        if (list == null || list.size() < 1) {
            by(null, this.lBk.pageType);
            return;
        }
        this.lBn.setVisibility(0);
        this.lBo.setVisibility(8);
        this.lBj.eQ(list);
        this.lBj.notifyDataSetChanged();
        switch (i2) {
            case 1001:
                this.lBs.setVisibility(0);
                this.lBt.setVisibility(0);
                this.lBu.setVisibility(8);
                return;
            case 1002:
                this.lBs.setVisibility(8);
                return;
            case 1003:
                this.lBs.setVisibility(0);
                ap.setBackgroundResource(this.lBs, R.drawable.bg_pack);
                this.lBt.setVisibility(8);
                this.lBu.setVisibility(0);
                switch (this.lBk.pageType) {
                    case 1:
                        format = String.format(this.lBk.getResources().getString(R.string.graffiti_list_title_count), at.numFormatOverWan(i));
                        break;
                    default:
                        format = String.format(this.lBk.getResources().getString(R.string.praise_item_more), at.numFormatOverWan(i));
                        break;
                }
                this.lBu.setText(format);
                return;
            default:
                this.lBs.setVisibility(8);
                return;
        }
    }

    public void by(String str, int i) {
        this.lBv.setVisibility(8);
        this.lBw.setVisibility(8);
        this.lBn.setVisibility(8);
        this.lBo.setVisibility(0);
        if (!StringUtils.isNull(str)) {
            this.lBo.setTextOption(NoDataViewFactory.d.BK(str));
        } else if (1 == i) {
            this.lBo.setTextOption(NoDataViewFactory.d.pv(R.string.graffiti_list_no_data));
        } else {
            this.lBo.setTextOption(NoDataViewFactory.d.pv(R.string.praise_list_no_data));
        }
    }

    public void a(com.baidu.tbadk.core.c cVar, int i) {
        if (cVar != null) {
            cVar.setNightMode(i == 1);
            cVar.onModeChanged(this.lBl);
            cVar.onModeChanged(this.lBp);
            cVar.onModeChanged(this.lBs);
            this.lBm.onChangeSkinType(this.lBk.getPageContext(), i);
            ap.setBackgroundResource(this.lBs, R.drawable.bg_pack);
            if (this.lBo != null) {
                this.lBo.onChangeSkinType(this.lBk.getPageContext(), i);
            }
        }
    }

    public View dnz() {
        return this.lBp;
    }

    public View dnA() {
        return this.lBt;
    }
}
