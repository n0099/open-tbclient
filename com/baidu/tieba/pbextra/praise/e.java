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
/* loaded from: classes9.dex */
public class e extends com.baidu.adp.base.c<PraiseListActivity> {
    private c kjh;
    private PraiseListActivity kji;
    private View kjj;
    private NavigationBar kjk;
    private View kjl;
    private NoDataView kjm;
    private View kjn;
    private TextView kjo;
    private BdListView kjp;
    private View kjq;
    private TextView kjr;
    private TextView kjs;
    private ProgressBar kjt;
    private ProgressBar kju;

    public e(PraiseListActivity praiseListActivity, String str) {
        super(praiseListActivity.getPageContext());
        this.kjh = null;
        this.kji = null;
        this.kjj = null;
        this.kjk = null;
        this.kjl = null;
        this.kjm = null;
        this.kjn = null;
        this.kjo = null;
        this.kjp = null;
        this.kjq = null;
        this.kjr = null;
        this.kjs = null;
        this.kjt = null;
        this.kju = null;
        this.kji = praiseListActivity;
        praiseListActivity.setContentView(R.layout.zan_list_activity);
        this.kjj = praiseListActivity.findViewById(R.id.zan_list_page_parent);
        this.kjk = (NavigationBar) praiseListActivity.findViewById(R.id.zan_list_page_navigationbar);
        this.kjl = praiseListActivity.findViewById(R.id.zan_list_page_frame);
        this.kjm = NoDataViewFactory.a(this.kji.getPageContext().getContext(), this.kjj, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.getDimens(this.kji.getActivity(), R.dimen.ds320)), NoDataViewFactory.d.lT(R.string.praise_list_no_data), null);
        this.kjp = (BdListView) praiseListActivity.findViewById(R.id.zan_list_page_list);
        TextView textView = new TextView(this.kji.getActivity());
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)));
        this.kjp.addHeaderView(textView, 0);
        this.kjt = (ProgressBar) praiseListActivity.findViewById(R.id.zan_list_page_progress);
        this.kjh = new c(praiseListActivity);
        this.kjp.setAdapter((ListAdapter) this.kjh);
        this.kjp.setOnScrollListener(this.kjh);
        this.kjk.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.kjk.setTitleText("");
        this.kjn = LayoutInflater.from(praiseListActivity.getPageContext().getContext()).inflate(R.layout.zan_list_head, (ViewGroup) null);
        this.kjn.setOnClickListener(praiseListActivity);
        this.kjo = (TextView) this.kjn.findViewById(R.id.zan_list_head_text);
        this.kjo.setText(str);
        this.kjn.setVisibility(8);
        this.kjp.addHeaderView(this.kjn);
        this.kjq = LayoutInflater.from(praiseListActivity.getPageContext().getContext()).inflate(R.layout.zan_list_foot, (ViewGroup) null);
        this.kjr = (TextView) this.kjq.findViewById(R.id.zan_list_foot_text_continue);
        this.kjs = (TextView) this.kjq.findViewById(R.id.zan_list_foot_text_more);
        this.kju = (ProgressBar) this.kjq.findViewById(R.id.zan_list_foot_progress);
        this.kjq.setVisibility(8);
        this.kjr.setOnClickListener(praiseListActivity);
        this.kjp.addFooterView(this.kjq);
        this.kjp.setOnItemClickListener(praiseListActivity);
    }

    public void cmI() {
        if (this.kjh != null) {
            this.kjh.notifyDataSetChanged();
        }
    }

    public void sM(boolean z) {
        if (z) {
            this.kju.setVisibility(0);
        } else {
            this.kjt.setVisibility(0);
        }
    }

    public void cMP() {
        this.kjt.setVisibility(8);
        this.kju.setVisibility(8);
    }

    public boolean isLoading() {
        return this.kjt.getVisibility() == 0 || this.kju.getVisibility() == 0;
    }

    public void b(int i, List<a> list, int i2, int i3) {
        String format;
        String format2;
        this.kjt.setVisibility(8);
        this.kju.setVisibility(8);
        this.kjn.setVisibility(0);
        if (i > 0) {
            switch (this.kji.pageType) {
                case 1:
                    format2 = String.format(this.kji.getResources().getString(R.string.graffiti_list_title_count), aq.numFormatOverWan(i));
                    break;
                default:
                    format2 = String.format(this.kji.getResources().getString(R.string.praise_list_title_count), aq.numFormatOverWan(i));
                    break;
            }
            this.kjk.setTitleText(format2);
        } else {
            this.kjk.setTitleText("");
        }
        if (list == null || list.size() < 1) {
            bv(null, this.kji.pageType);
            return;
        }
        this.kjl.setVisibility(0);
        this.kjm.setVisibility(8);
        this.kjh.eb(list);
        this.kjh.notifyDataSetChanged();
        switch (i2) {
            case 1001:
                this.kjq.setVisibility(0);
                this.kjr.setVisibility(0);
                this.kjs.setVisibility(8);
                return;
            case 1002:
                this.kjq.setVisibility(8);
                return;
            case 1003:
                this.kjq.setVisibility(0);
                am.setBackgroundResource(this.kjq, R.drawable.bg_pack);
                this.kjr.setVisibility(8);
                this.kjs.setVisibility(0);
                switch (this.kji.pageType) {
                    case 1:
                        format = String.format(this.kji.getResources().getString(R.string.graffiti_list_title_count), aq.numFormatOverWan(i));
                        break;
                    default:
                        format = String.format(this.kji.getResources().getString(R.string.praise_item_more), aq.numFormatOverWan(i));
                        break;
                }
                this.kjs.setText(format);
                return;
            default:
                this.kjq.setVisibility(8);
                return;
        }
    }

    public void bv(String str, int i) {
        this.kjt.setVisibility(8);
        this.kju.setVisibility(8);
        this.kjl.setVisibility(8);
        this.kjm.setVisibility(0);
        if (!StringUtils.isNull(str)) {
            this.kjm.setTextOption(NoDataViewFactory.d.wR(str));
        } else if (1 == i) {
            this.kjm.setTextOption(NoDataViewFactory.d.lT(R.string.graffiti_list_no_data));
        } else {
            this.kjm.setTextOption(NoDataViewFactory.d.lT(R.string.praise_list_no_data));
        }
    }

    public void a(com.baidu.tbadk.core.c cVar, int i) {
        if (cVar != null) {
            cVar.setNightMode(i == 1);
            cVar.onModeChanged(this.kjj);
            cVar.onModeChanged(this.kjn);
            cVar.onModeChanged(this.kjq);
            this.kjk.onChangeSkinType(this.kji.getPageContext(), i);
            am.setBackgroundResource(this.kjq, R.drawable.bg_pack);
            if (this.kjm != null) {
                this.kjm.onChangeSkinType(this.kji.getPageContext(), i);
            }
        }
    }

    public View cMQ() {
        return this.kjn;
    }

    public View cMR() {
        return this.kjr;
    }
}
