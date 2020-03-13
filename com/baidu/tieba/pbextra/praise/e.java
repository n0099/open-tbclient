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
    private c jfD;
    private PraiseListActivity jfE;
    private View jfF;
    private NavigationBar jfG;
    private View jfH;
    private NoDataView jfI;
    private View jfJ;
    private TextView jfK;
    private BdListView jfL;
    private View jfM;
    private TextView jfN;
    private TextView jfO;
    private ProgressBar jfP;
    private ProgressBar jfQ;

    public e(PraiseListActivity praiseListActivity, String str) {
        super(praiseListActivity.getPageContext());
        this.jfD = null;
        this.jfE = null;
        this.jfF = null;
        this.jfG = null;
        this.jfH = null;
        this.jfI = null;
        this.jfJ = null;
        this.jfK = null;
        this.jfL = null;
        this.jfM = null;
        this.jfN = null;
        this.jfO = null;
        this.jfP = null;
        this.jfQ = null;
        this.jfE = praiseListActivity;
        praiseListActivity.setContentView(R.layout.zan_list_activity);
        this.jfF = praiseListActivity.findViewById(R.id.zan_list_page_parent);
        this.jfG = (NavigationBar) praiseListActivity.findViewById(R.id.zan_list_page_navigationbar);
        this.jfH = praiseListActivity.findViewById(R.id.zan_list_page_frame);
        this.jfI = NoDataViewFactory.a(this.jfE.getPageContext().getContext(), this.jfF, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.getDimens(this.jfE.getActivity(), R.dimen.ds320)), NoDataViewFactory.d.lh(R.string.praise_list_no_data), null);
        this.jfL = (BdListView) praiseListActivity.findViewById(R.id.zan_list_page_list);
        TextView textView = new TextView(this.jfE.getActivity());
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)));
        this.jfL.addHeaderView(textView, 0);
        this.jfP = (ProgressBar) praiseListActivity.findViewById(R.id.zan_list_page_progress);
        this.jfD = new c(praiseListActivity);
        this.jfL.setAdapter((ListAdapter) this.jfD);
        this.jfL.setOnScrollListener(this.jfD);
        this.jfG.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.jfG.setTitleText("");
        this.jfJ = LayoutInflater.from(praiseListActivity.getPageContext().getContext()).inflate(R.layout.zan_list_head, (ViewGroup) null);
        this.jfJ.setOnClickListener(praiseListActivity);
        this.jfK = (TextView) this.jfJ.findViewById(R.id.zan_list_head_text);
        this.jfK.setText(str);
        this.jfJ.setVisibility(8);
        this.jfL.addHeaderView(this.jfJ);
        this.jfM = LayoutInflater.from(praiseListActivity.getPageContext().getContext()).inflate(R.layout.zan_list_foot, (ViewGroup) null);
        this.jfN = (TextView) this.jfM.findViewById(R.id.zan_list_foot_text_continue);
        this.jfO = (TextView) this.jfM.findViewById(R.id.zan_list_foot_text_more);
        this.jfQ = (ProgressBar) this.jfM.findViewById(R.id.zan_list_foot_progress);
        this.jfM.setVisibility(8);
        this.jfN.setOnClickListener(praiseListActivity);
        this.jfL.addFooterView(this.jfM);
        this.jfL.setOnItemClickListener(praiseListActivity);
    }

    public void bVt() {
        if (this.jfD != null) {
            this.jfD.notifyDataSetChanged();
        }
    }

    public void re(boolean z) {
        if (z) {
            this.jfQ.setVisibility(0);
        } else {
            this.jfP.setVisibility(0);
        }
    }

    public void cuS() {
        this.jfP.setVisibility(8);
        this.jfQ.setVisibility(8);
    }

    public boolean isLoading() {
        return this.jfP.getVisibility() == 0 || this.jfQ.getVisibility() == 0;
    }

    public void b(int i, List<a> list, int i2, int i3) {
        String format;
        String format2;
        this.jfP.setVisibility(8);
        this.jfQ.setVisibility(8);
        this.jfJ.setVisibility(0);
        if (i > 0) {
            switch (this.jfE.pageType) {
                case 1:
                    format2 = String.format(this.jfE.getResources().getString(R.string.graffiti_list_title_count), aq.numFormatOverWan(i));
                    break;
                default:
                    format2 = String.format(this.jfE.getResources().getString(R.string.praise_list_title_count), aq.numFormatOverWan(i));
                    break;
            }
            this.jfG.setTitleText(format2);
        } else {
            this.jfG.setTitleText("");
        }
        if (list == null || list.size() < 1) {
            bk(null, this.jfE.pageType);
            return;
        }
        this.jfH.setVisibility(0);
        this.jfI.setVisibility(8);
        this.jfD.dK(list);
        this.jfD.notifyDataSetChanged();
        switch (i2) {
            case 1001:
                this.jfM.setVisibility(0);
                this.jfN.setVisibility(0);
                this.jfO.setVisibility(8);
                return;
            case 1002:
                this.jfM.setVisibility(8);
                return;
            case 1003:
                this.jfM.setVisibility(0);
                am.setBackgroundResource(this.jfM, R.drawable.bg_pack);
                this.jfN.setVisibility(8);
                this.jfO.setVisibility(0);
                switch (this.jfE.pageType) {
                    case 1:
                        format = String.format(this.jfE.getResources().getString(R.string.graffiti_list_title_count), aq.numFormatOverWan(i));
                        break;
                    default:
                        format = String.format(this.jfE.getResources().getString(R.string.praise_item_more), aq.numFormatOverWan(i));
                        break;
                }
                this.jfO.setText(format);
                return;
            default:
                this.jfM.setVisibility(8);
                return;
        }
    }

    public void bk(String str, int i) {
        this.jfP.setVisibility(8);
        this.jfQ.setVisibility(8);
        this.jfH.setVisibility(8);
        this.jfI.setVisibility(0);
        if (!StringUtils.isNull(str)) {
            this.jfI.setTextOption(NoDataViewFactory.d.tV(str));
        } else if (1 == i) {
            this.jfI.setTextOption(NoDataViewFactory.d.lh(R.string.graffiti_list_no_data));
        } else {
            this.jfI.setTextOption(NoDataViewFactory.d.lh(R.string.praise_list_no_data));
        }
    }

    public void a(com.baidu.tbadk.core.c cVar, int i) {
        if (cVar != null) {
            cVar.setNightMode(i == 1);
            cVar.onModeChanged(this.jfF);
            cVar.onModeChanged(this.jfJ);
            cVar.onModeChanged(this.jfM);
            this.jfG.onChangeSkinType(this.jfE.getPageContext(), i);
            am.setBackgroundResource(this.jfM, R.drawable.bg_pack);
            if (this.jfI != null) {
                this.jfI.onChangeSkinType(this.jfE.getPageContext(), i);
            }
        }
    }

    public View cuT() {
        return this.jfJ;
    }

    public View cuU() {
        return this.jfN;
    }
}
