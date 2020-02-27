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
    private TextView jfA;
    private ProgressBar jfB;
    private ProgressBar jfC;
    private c jfp;
    private PraiseListActivity jfq;
    private View jfr;
    private NavigationBar jfs;
    private View jft;
    private NoDataView jfu;
    private View jfv;
    private TextView jfw;
    private BdListView jfx;
    private View jfy;
    private TextView jfz;

    public e(PraiseListActivity praiseListActivity, String str) {
        super(praiseListActivity.getPageContext());
        this.jfp = null;
        this.jfq = null;
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
        this.jfq = praiseListActivity;
        praiseListActivity.setContentView(R.layout.zan_list_activity);
        this.jfr = praiseListActivity.findViewById(R.id.zan_list_page_parent);
        this.jfs = (NavigationBar) praiseListActivity.findViewById(R.id.zan_list_page_navigationbar);
        this.jft = praiseListActivity.findViewById(R.id.zan_list_page_frame);
        this.jfu = NoDataViewFactory.a(this.jfq.getPageContext().getContext(), this.jfr, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.getDimens(this.jfq.getActivity(), R.dimen.ds320)), NoDataViewFactory.d.lh(R.string.praise_list_no_data), null);
        this.jfx = (BdListView) praiseListActivity.findViewById(R.id.zan_list_page_list);
        TextView textView = new TextView(this.jfq.getActivity());
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)));
        this.jfx.addHeaderView(textView, 0);
        this.jfB = (ProgressBar) praiseListActivity.findViewById(R.id.zan_list_page_progress);
        this.jfp = new c(praiseListActivity);
        this.jfx.setAdapter((ListAdapter) this.jfp);
        this.jfx.setOnScrollListener(this.jfp);
        this.jfs.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.jfs.setTitleText("");
        this.jfv = LayoutInflater.from(praiseListActivity.getPageContext().getContext()).inflate(R.layout.zan_list_head, (ViewGroup) null);
        this.jfv.setOnClickListener(praiseListActivity);
        this.jfw = (TextView) this.jfv.findViewById(R.id.zan_list_head_text);
        this.jfw.setText(str);
        this.jfv.setVisibility(8);
        this.jfx.addHeaderView(this.jfv);
        this.jfy = LayoutInflater.from(praiseListActivity.getPageContext().getContext()).inflate(R.layout.zan_list_foot, (ViewGroup) null);
        this.jfz = (TextView) this.jfy.findViewById(R.id.zan_list_foot_text_continue);
        this.jfA = (TextView) this.jfy.findViewById(R.id.zan_list_foot_text_more);
        this.jfC = (ProgressBar) this.jfy.findViewById(R.id.zan_list_foot_progress);
        this.jfy.setVisibility(8);
        this.jfz.setOnClickListener(praiseListActivity);
        this.jfx.addFooterView(this.jfy);
        this.jfx.setOnItemClickListener(praiseListActivity);
    }

    public void bVq() {
        if (this.jfp != null) {
            this.jfp.notifyDataSetChanged();
        }
    }

    public void re(boolean z) {
        if (z) {
            this.jfC.setVisibility(0);
        } else {
            this.jfB.setVisibility(0);
        }
    }

    public void cuP() {
        this.jfB.setVisibility(8);
        this.jfC.setVisibility(8);
    }

    public boolean isLoading() {
        return this.jfB.getVisibility() == 0 || this.jfC.getVisibility() == 0;
    }

    public void b(int i, List<a> list, int i2, int i3) {
        String format;
        String format2;
        this.jfB.setVisibility(8);
        this.jfC.setVisibility(8);
        this.jfv.setVisibility(0);
        if (i > 0) {
            switch (this.jfq.pageType) {
                case 1:
                    format2 = String.format(this.jfq.getResources().getString(R.string.graffiti_list_title_count), aq.numFormatOverWan(i));
                    break;
                default:
                    format2 = String.format(this.jfq.getResources().getString(R.string.praise_list_title_count), aq.numFormatOverWan(i));
                    break;
            }
            this.jfs.setTitleText(format2);
        } else {
            this.jfs.setTitleText("");
        }
        if (list == null || list.size() < 1) {
            bk(null, this.jfq.pageType);
            return;
        }
        this.jft.setVisibility(0);
        this.jfu.setVisibility(8);
        this.jfp.dK(list);
        this.jfp.notifyDataSetChanged();
        switch (i2) {
            case 1001:
                this.jfy.setVisibility(0);
                this.jfz.setVisibility(0);
                this.jfA.setVisibility(8);
                return;
            case 1002:
                this.jfy.setVisibility(8);
                return;
            case 1003:
                this.jfy.setVisibility(0);
                am.setBackgroundResource(this.jfy, R.drawable.bg_pack);
                this.jfz.setVisibility(8);
                this.jfA.setVisibility(0);
                switch (this.jfq.pageType) {
                    case 1:
                        format = String.format(this.jfq.getResources().getString(R.string.graffiti_list_title_count), aq.numFormatOverWan(i));
                        break;
                    default:
                        format = String.format(this.jfq.getResources().getString(R.string.praise_item_more), aq.numFormatOverWan(i));
                        break;
                }
                this.jfA.setText(format);
                return;
            default:
                this.jfy.setVisibility(8);
                return;
        }
    }

    public void bk(String str, int i) {
        this.jfB.setVisibility(8);
        this.jfC.setVisibility(8);
        this.jft.setVisibility(8);
        this.jfu.setVisibility(0);
        if (!StringUtils.isNull(str)) {
            this.jfu.setTextOption(NoDataViewFactory.d.tU(str));
        } else if (1 == i) {
            this.jfu.setTextOption(NoDataViewFactory.d.lh(R.string.graffiti_list_no_data));
        } else {
            this.jfu.setTextOption(NoDataViewFactory.d.lh(R.string.praise_list_no_data));
        }
    }

    public void a(com.baidu.tbadk.core.c cVar, int i) {
        if (cVar != null) {
            cVar.setNightMode(i == 1);
            cVar.onModeChanged(this.jfr);
            cVar.onModeChanged(this.jfv);
            cVar.onModeChanged(this.jfy);
            this.jfs.onChangeSkinType(this.jfq.getPageContext(), i);
            am.setBackgroundResource(this.jfy, R.drawable.bg_pack);
            if (this.jfu != null) {
                this.jfu.onChangeSkinType(this.jfq.getPageContext(), i);
            }
        }
    }

    public View cuQ() {
        return this.jfv;
    }

    public View cuR() {
        return this.jfz;
    }
}
