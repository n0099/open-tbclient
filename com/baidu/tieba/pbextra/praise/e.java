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
    private c lcT;
    private PraiseListActivity lcU;
    private View lcV;
    private NavigationBar lcW;
    private View lcX;
    private NoDataView lcY;
    private View lcZ;
    private TextView lda;
    private BdListView ldb;
    private View ldc;
    private TextView ldd;
    private TextView lde;
    private ProgressBar ldf;
    private ProgressBar ldg;

    public e(PraiseListActivity praiseListActivity, String str) {
        super(praiseListActivity.getPageContext());
        this.lcT = null;
        this.lcU = null;
        this.lcV = null;
        this.lcW = null;
        this.lcX = null;
        this.lcY = null;
        this.lcZ = null;
        this.lda = null;
        this.ldb = null;
        this.ldc = null;
        this.ldd = null;
        this.lde = null;
        this.ldf = null;
        this.ldg = null;
        this.lcU = praiseListActivity;
        praiseListActivity.setContentView(R.layout.zan_list_activity);
        this.lcV = praiseListActivity.findViewById(R.id.zan_list_page_parent);
        this.lcW = (NavigationBar) praiseListActivity.findViewById(R.id.zan_list_page_navigationbar);
        this.lcX = praiseListActivity.findViewById(R.id.zan_list_page_frame);
        this.lcY = NoDataViewFactory.a(this.lcU.getPageContext().getContext(), this.lcV, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.getDimens(this.lcU.getActivity(), R.dimen.ds320)), NoDataViewFactory.d.oK(R.string.praise_list_no_data), null);
        this.ldb = (BdListView) praiseListActivity.findViewById(R.id.zan_list_page_list);
        TextView textView = new TextView(this.lcU.getActivity());
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)));
        this.ldb.addHeaderView(textView, 0);
        this.ldf = (ProgressBar) praiseListActivity.findViewById(R.id.zan_list_page_progress);
        this.lcT = new c(praiseListActivity);
        this.ldb.setAdapter((ListAdapter) this.lcT);
        this.ldb.setOnScrollListener(this.lcT);
        this.lcW.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.lcW.setTitleText("");
        this.lcZ = LayoutInflater.from(praiseListActivity.getPageContext().getContext()).inflate(R.layout.zan_list_head, (ViewGroup) null);
        this.lcZ.setOnClickListener(praiseListActivity);
        this.lda = (TextView) this.lcZ.findViewById(R.id.zan_list_head_text);
        this.lda.setText(str);
        this.lcZ.setVisibility(8);
        this.ldb.addHeaderView(this.lcZ);
        this.ldc = LayoutInflater.from(praiseListActivity.getPageContext().getContext()).inflate(R.layout.zan_list_foot, (ViewGroup) null);
        this.ldd = (TextView) this.ldc.findViewById(R.id.zan_list_foot_text_continue);
        this.lde = (TextView) this.ldc.findViewById(R.id.zan_list_foot_text_more);
        this.ldg = (ProgressBar) this.ldc.findViewById(R.id.zan_list_foot_progress);
        this.ldc.setVisibility(8);
        this.ldd.setOnClickListener(praiseListActivity);
        this.ldb.addFooterView(this.ldc);
        this.ldb.setOnItemClickListener(praiseListActivity);
    }

    public void cFw() {
        if (this.lcT != null) {
            this.lcT.notifyDataSetChanged();
        }
    }

    public void uq(boolean z) {
        if (z) {
            this.ldg.setVisibility(0);
        } else {
            this.ldf.setVisibility(0);
        }
    }

    public void dgk() {
        this.ldf.setVisibility(8);
        this.ldg.setVisibility(8);
    }

    public boolean isLoading() {
        return this.ldf.getVisibility() == 0 || this.ldg.getVisibility() == 0;
    }

    public void b(int i, List<a> list, int i2, int i3) {
        String format;
        String format2;
        this.ldf.setVisibility(8);
        this.ldg.setVisibility(8);
        this.lcZ.setVisibility(0);
        if (i > 0) {
            switch (this.lcU.pageType) {
                case 1:
                    format2 = String.format(this.lcU.getResources().getString(R.string.graffiti_list_title_count), at.numFormatOverWan(i));
                    break;
                default:
                    format2 = String.format(this.lcU.getResources().getString(R.string.praise_list_title_count), at.numFormatOverWan(i));
                    break;
            }
            this.lcW.setTitleText(format2);
        } else {
            this.lcW.setTitleText("");
        }
        if (list == null || list.size() < 1) {
            bx(null, this.lcU.pageType);
            return;
        }
        this.lcX.setVisibility(0);
        this.lcY.setVisibility(8);
        this.lcT.eF(list);
        this.lcT.notifyDataSetChanged();
        switch (i2) {
            case 1001:
                this.ldc.setVisibility(0);
                this.ldd.setVisibility(0);
                this.lde.setVisibility(8);
                return;
            case 1002:
                this.ldc.setVisibility(8);
                return;
            case 1003:
                this.ldc.setVisibility(0);
                ap.setBackgroundResource(this.ldc, R.drawable.bg_pack);
                this.ldd.setVisibility(8);
                this.lde.setVisibility(0);
                switch (this.lcU.pageType) {
                    case 1:
                        format = String.format(this.lcU.getResources().getString(R.string.graffiti_list_title_count), at.numFormatOverWan(i));
                        break;
                    default:
                        format = String.format(this.lcU.getResources().getString(R.string.praise_item_more), at.numFormatOverWan(i));
                        break;
                }
                this.lde.setText(format);
                return;
            default:
                this.ldc.setVisibility(8);
                return;
        }
    }

    public void bx(String str, int i) {
        this.ldf.setVisibility(8);
        this.ldg.setVisibility(8);
        this.lcX.setVisibility(8);
        this.lcY.setVisibility(0);
        if (!StringUtils.isNull(str)) {
            this.lcY.setTextOption(NoDataViewFactory.d.AB(str));
        } else if (1 == i) {
            this.lcY.setTextOption(NoDataViewFactory.d.oK(R.string.graffiti_list_no_data));
        } else {
            this.lcY.setTextOption(NoDataViewFactory.d.oK(R.string.praise_list_no_data));
        }
    }

    public void a(com.baidu.tbadk.core.c cVar, int i) {
        if (cVar != null) {
            cVar.setNightMode(i == 1);
            cVar.onModeChanged(this.lcV);
            cVar.onModeChanged(this.lcZ);
            cVar.onModeChanged(this.ldc);
            this.lcW.onChangeSkinType(this.lcU.getPageContext(), i);
            ap.setBackgroundResource(this.ldc, R.drawable.bg_pack);
            if (this.lcY != null) {
                this.lcY.onChangeSkinType(this.lcU.getPageContext(), i);
            }
        }
    }

    public View dgl() {
        return this.lcZ;
    }

    public View dgm() {
        return this.ldd;
    }
}
