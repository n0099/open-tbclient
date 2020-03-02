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
    private View jfA;
    private TextView jfB;
    private TextView jfC;
    private ProgressBar jfD;
    private ProgressBar jfE;
    private c jfr;
    private PraiseListActivity jfs;
    private View jft;
    private NavigationBar jfu;
    private View jfv;
    private NoDataView jfw;
    private View jfx;
    private TextView jfy;
    private BdListView jfz;

    public e(PraiseListActivity praiseListActivity, String str) {
        super(praiseListActivity.getPageContext());
        this.jfr = null;
        this.jfs = null;
        this.jft = null;
        this.jfu = null;
        this.jfv = null;
        this.jfw = null;
        this.jfx = null;
        this.jfy = null;
        this.jfz = null;
        this.jfA = null;
        this.jfB = null;
        this.jfC = null;
        this.jfD = null;
        this.jfE = null;
        this.jfs = praiseListActivity;
        praiseListActivity.setContentView(R.layout.zan_list_activity);
        this.jft = praiseListActivity.findViewById(R.id.zan_list_page_parent);
        this.jfu = (NavigationBar) praiseListActivity.findViewById(R.id.zan_list_page_navigationbar);
        this.jfv = praiseListActivity.findViewById(R.id.zan_list_page_frame);
        this.jfw = NoDataViewFactory.a(this.jfs.getPageContext().getContext(), this.jft, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.getDimens(this.jfs.getActivity(), R.dimen.ds320)), NoDataViewFactory.d.lh(R.string.praise_list_no_data), null);
        this.jfz = (BdListView) praiseListActivity.findViewById(R.id.zan_list_page_list);
        TextView textView = new TextView(this.jfs.getActivity());
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)));
        this.jfz.addHeaderView(textView, 0);
        this.jfD = (ProgressBar) praiseListActivity.findViewById(R.id.zan_list_page_progress);
        this.jfr = new c(praiseListActivity);
        this.jfz.setAdapter((ListAdapter) this.jfr);
        this.jfz.setOnScrollListener(this.jfr);
        this.jfu.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.jfu.setTitleText("");
        this.jfx = LayoutInflater.from(praiseListActivity.getPageContext().getContext()).inflate(R.layout.zan_list_head, (ViewGroup) null);
        this.jfx.setOnClickListener(praiseListActivity);
        this.jfy = (TextView) this.jfx.findViewById(R.id.zan_list_head_text);
        this.jfy.setText(str);
        this.jfx.setVisibility(8);
        this.jfz.addHeaderView(this.jfx);
        this.jfA = LayoutInflater.from(praiseListActivity.getPageContext().getContext()).inflate(R.layout.zan_list_foot, (ViewGroup) null);
        this.jfB = (TextView) this.jfA.findViewById(R.id.zan_list_foot_text_continue);
        this.jfC = (TextView) this.jfA.findViewById(R.id.zan_list_foot_text_more);
        this.jfE = (ProgressBar) this.jfA.findViewById(R.id.zan_list_foot_progress);
        this.jfA.setVisibility(8);
        this.jfB.setOnClickListener(praiseListActivity);
        this.jfz.addFooterView(this.jfA);
        this.jfz.setOnItemClickListener(praiseListActivity);
    }

    public void bVs() {
        if (this.jfr != null) {
            this.jfr.notifyDataSetChanged();
        }
    }

    public void re(boolean z) {
        if (z) {
            this.jfE.setVisibility(0);
        } else {
            this.jfD.setVisibility(0);
        }
    }

    public void cuR() {
        this.jfD.setVisibility(8);
        this.jfE.setVisibility(8);
    }

    public boolean isLoading() {
        return this.jfD.getVisibility() == 0 || this.jfE.getVisibility() == 0;
    }

    public void b(int i, List<a> list, int i2, int i3) {
        String format;
        String format2;
        this.jfD.setVisibility(8);
        this.jfE.setVisibility(8);
        this.jfx.setVisibility(0);
        if (i > 0) {
            switch (this.jfs.pageType) {
                case 1:
                    format2 = String.format(this.jfs.getResources().getString(R.string.graffiti_list_title_count), aq.numFormatOverWan(i));
                    break;
                default:
                    format2 = String.format(this.jfs.getResources().getString(R.string.praise_list_title_count), aq.numFormatOverWan(i));
                    break;
            }
            this.jfu.setTitleText(format2);
        } else {
            this.jfu.setTitleText("");
        }
        if (list == null || list.size() < 1) {
            bk(null, this.jfs.pageType);
            return;
        }
        this.jfv.setVisibility(0);
        this.jfw.setVisibility(8);
        this.jfr.dK(list);
        this.jfr.notifyDataSetChanged();
        switch (i2) {
            case 1001:
                this.jfA.setVisibility(0);
                this.jfB.setVisibility(0);
                this.jfC.setVisibility(8);
                return;
            case 1002:
                this.jfA.setVisibility(8);
                return;
            case 1003:
                this.jfA.setVisibility(0);
                am.setBackgroundResource(this.jfA, R.drawable.bg_pack);
                this.jfB.setVisibility(8);
                this.jfC.setVisibility(0);
                switch (this.jfs.pageType) {
                    case 1:
                        format = String.format(this.jfs.getResources().getString(R.string.graffiti_list_title_count), aq.numFormatOverWan(i));
                        break;
                    default:
                        format = String.format(this.jfs.getResources().getString(R.string.praise_item_more), aq.numFormatOverWan(i));
                        break;
                }
                this.jfC.setText(format);
                return;
            default:
                this.jfA.setVisibility(8);
                return;
        }
    }

    public void bk(String str, int i) {
        this.jfD.setVisibility(8);
        this.jfE.setVisibility(8);
        this.jfv.setVisibility(8);
        this.jfw.setVisibility(0);
        if (!StringUtils.isNull(str)) {
            this.jfw.setTextOption(NoDataViewFactory.d.tU(str));
        } else if (1 == i) {
            this.jfw.setTextOption(NoDataViewFactory.d.lh(R.string.graffiti_list_no_data));
        } else {
            this.jfw.setTextOption(NoDataViewFactory.d.lh(R.string.praise_list_no_data));
        }
    }

    public void a(com.baidu.tbadk.core.c cVar, int i) {
        if (cVar != null) {
            cVar.setNightMode(i == 1);
            cVar.onModeChanged(this.jft);
            cVar.onModeChanged(this.jfx);
            cVar.onModeChanged(this.jfA);
            this.jfu.onChangeSkinType(this.jfs.getPageContext(), i);
            am.setBackgroundResource(this.jfA, R.drawable.bg_pack);
            if (this.jfw != null) {
                this.jfw.onChangeSkinType(this.jfs.getPageContext(), i);
            }
        }
    }

    public View cuS() {
        return this.jfx;
    }

    public View cuT() {
        return this.jfB;
    }
}
