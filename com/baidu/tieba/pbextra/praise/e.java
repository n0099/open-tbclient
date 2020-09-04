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
/* loaded from: classes16.dex */
public class e extends com.baidu.adp.base.c<PraiseListActivity> {
    private c lda;
    private PraiseListActivity ldb;
    private View ldc;
    private NavigationBar ldd;
    private View lde;
    private NoDataView ldf;
    private View ldg;
    private TextView ldh;
    private BdListView ldi;
    private View ldj;
    private TextView ldk;
    private TextView ldl;
    private ProgressBar ldm;
    private ProgressBar ldn;

    public e(PraiseListActivity praiseListActivity, String str) {
        super(praiseListActivity.getPageContext());
        this.lda = null;
        this.ldb = null;
        this.ldc = null;
        this.ldd = null;
        this.lde = null;
        this.ldf = null;
        this.ldg = null;
        this.ldh = null;
        this.ldi = null;
        this.ldj = null;
        this.ldk = null;
        this.ldl = null;
        this.ldm = null;
        this.ldn = null;
        this.ldb = praiseListActivity;
        praiseListActivity.setContentView(R.layout.zan_list_activity);
        this.ldc = praiseListActivity.findViewById(R.id.zan_list_page_parent);
        this.ldd = (NavigationBar) praiseListActivity.findViewById(R.id.zan_list_page_navigationbar);
        this.lde = praiseListActivity.findViewById(R.id.zan_list_page_frame);
        this.ldf = NoDataViewFactory.a(this.ldb.getPageContext().getContext(), this.ldc, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.getDimens(this.ldb.getActivity(), R.dimen.ds320)), NoDataViewFactory.d.oK(R.string.praise_list_no_data), null);
        this.ldi = (BdListView) praiseListActivity.findViewById(R.id.zan_list_page_list);
        TextView textView = new TextView(this.ldb.getActivity());
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)));
        this.ldi.addHeaderView(textView, 0);
        this.ldm = (ProgressBar) praiseListActivity.findViewById(R.id.zan_list_page_progress);
        this.lda = new c(praiseListActivity);
        this.ldi.setAdapter((ListAdapter) this.lda);
        this.ldi.setOnScrollListener(this.lda);
        this.ldd.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.ldd.setTitleText("");
        this.ldg = LayoutInflater.from(praiseListActivity.getPageContext().getContext()).inflate(R.layout.zan_list_head, (ViewGroup) null);
        this.ldg.setOnClickListener(praiseListActivity);
        this.ldh = (TextView) this.ldg.findViewById(R.id.zan_list_head_text);
        this.ldh.setText(str);
        this.ldg.setVisibility(8);
        this.ldi.addHeaderView(this.ldg);
        this.ldj = LayoutInflater.from(praiseListActivity.getPageContext().getContext()).inflate(R.layout.zan_list_foot, (ViewGroup) null);
        this.ldk = (TextView) this.ldj.findViewById(R.id.zan_list_foot_text_continue);
        this.ldl = (TextView) this.ldj.findViewById(R.id.zan_list_foot_text_more);
        this.ldn = (ProgressBar) this.ldj.findViewById(R.id.zan_list_foot_progress);
        this.ldj.setVisibility(8);
        this.ldk.setOnClickListener(praiseListActivity);
        this.ldi.addFooterView(this.ldj);
        this.ldi.setOnItemClickListener(praiseListActivity);
    }

    public void cFx() {
        if (this.lda != null) {
            this.lda.notifyDataSetChanged();
        }
    }

    public void us(boolean z) {
        if (z) {
            this.ldn.setVisibility(0);
        } else {
            this.ldm.setVisibility(0);
        }
    }

    public void dgl() {
        this.ldm.setVisibility(8);
        this.ldn.setVisibility(8);
    }

    public boolean isLoading() {
        return this.ldm.getVisibility() == 0 || this.ldn.getVisibility() == 0;
    }

    public void b(int i, List<a> list, int i2, int i3) {
        String format;
        String format2;
        this.ldm.setVisibility(8);
        this.ldn.setVisibility(8);
        this.ldg.setVisibility(0);
        if (i > 0) {
            switch (this.ldb.pageType) {
                case 1:
                    format2 = String.format(this.ldb.getResources().getString(R.string.graffiti_list_title_count), at.numFormatOverWan(i));
                    break;
                default:
                    format2 = String.format(this.ldb.getResources().getString(R.string.praise_list_title_count), at.numFormatOverWan(i));
                    break;
            }
            this.ldd.setTitleText(format2);
        } else {
            this.ldd.setTitleText("");
        }
        if (list == null || list.size() < 1) {
            bx(null, this.ldb.pageType);
            return;
        }
        this.lde.setVisibility(0);
        this.ldf.setVisibility(8);
        this.lda.eF(list);
        this.lda.notifyDataSetChanged();
        switch (i2) {
            case 1001:
                this.ldj.setVisibility(0);
                this.ldk.setVisibility(0);
                this.ldl.setVisibility(8);
                return;
            case 1002:
                this.ldj.setVisibility(8);
                return;
            case 1003:
                this.ldj.setVisibility(0);
                ap.setBackgroundResource(this.ldj, R.drawable.bg_pack);
                this.ldk.setVisibility(8);
                this.ldl.setVisibility(0);
                switch (this.ldb.pageType) {
                    case 1:
                        format = String.format(this.ldb.getResources().getString(R.string.graffiti_list_title_count), at.numFormatOverWan(i));
                        break;
                    default:
                        format = String.format(this.ldb.getResources().getString(R.string.praise_item_more), at.numFormatOverWan(i));
                        break;
                }
                this.ldl.setText(format);
                return;
            default:
                this.ldj.setVisibility(8);
                return;
        }
    }

    public void bx(String str, int i) {
        this.ldm.setVisibility(8);
        this.ldn.setVisibility(8);
        this.lde.setVisibility(8);
        this.ldf.setVisibility(0);
        if (!StringUtils.isNull(str)) {
            this.ldf.setTextOption(NoDataViewFactory.d.AC(str));
        } else if (1 == i) {
            this.ldf.setTextOption(NoDataViewFactory.d.oK(R.string.graffiti_list_no_data));
        } else {
            this.ldf.setTextOption(NoDataViewFactory.d.oK(R.string.praise_list_no_data));
        }
    }

    public void a(com.baidu.tbadk.core.c cVar, int i) {
        if (cVar != null) {
            cVar.setNightMode(i == 1);
            cVar.onModeChanged(this.ldc);
            cVar.onModeChanged(this.ldg);
            cVar.onModeChanged(this.ldj);
            this.ldd.onChangeSkinType(this.ldb.getPageContext(), i);
            ap.setBackgroundResource(this.ldj, R.drawable.bg_pack);
            if (this.ldf != null) {
                this.ldf.onChangeSkinType(this.ldb.getPageContext(), i);
            }
        }
    }

    public View dgm() {
        return this.ldg;
    }

    public View dgn() {
        return this.ldk;
    }
}
