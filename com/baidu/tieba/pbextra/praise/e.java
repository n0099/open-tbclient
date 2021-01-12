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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes2.dex */
public class e extends com.baidu.adp.base.d<PraiseListActivity> {
    private c miE;
    private PraiseListActivity miF;
    private View miG;
    private NavigationBar miH;
    private View miI;
    private NoDataView miJ;
    private View miK;
    private TextView miL;
    private BdListView miM;
    private View miN;
    private TextView miO;
    private TextView miP;
    private ProgressBar miQ;
    private ProgressBar miR;

    public e(PraiseListActivity praiseListActivity, String str) {
        super(praiseListActivity.getPageContext());
        this.miE = null;
        this.miF = null;
        this.miG = null;
        this.miH = null;
        this.miI = null;
        this.miJ = null;
        this.miK = null;
        this.miL = null;
        this.miM = null;
        this.miN = null;
        this.miO = null;
        this.miP = null;
        this.miQ = null;
        this.miR = null;
        this.miF = praiseListActivity;
        praiseListActivity.setContentView(R.layout.zan_list_activity);
        this.miG = praiseListActivity.findViewById(R.id.zan_list_page_parent);
        this.miH = (NavigationBar) praiseListActivity.findViewById(R.id.zan_list_page_navigationbar);
        this.miI = praiseListActivity.findViewById(R.id.zan_list_page_frame);
        this.miJ = NoDataViewFactory.a(this.miF.getPageContext().getContext(), this.miG, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.getDimens(this.miF.getActivity(), R.dimen.ds320)), NoDataViewFactory.d.pu(R.string.praise_list_no_data), null);
        this.miM = (BdListView) praiseListActivity.findViewById(R.id.zan_list_page_list);
        TextView textView = new TextView(this.miF.getActivity());
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)));
        this.miM.addHeaderView(textView, 0);
        this.miQ = (ProgressBar) praiseListActivity.findViewById(R.id.zan_list_page_progress);
        this.miE = new c(praiseListActivity);
        this.miM.setAdapter((ListAdapter) this.miE);
        this.miM.setOnScrollListener(this.miE);
        this.miH.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.miH.setTitleText("");
        this.miK = LayoutInflater.from(praiseListActivity.getPageContext().getContext()).inflate(R.layout.zan_list_head, (ViewGroup) null);
        this.miK.setOnClickListener(praiseListActivity);
        this.miL = (TextView) this.miK.findViewById(R.id.zan_list_head_text);
        this.miL.setText(str);
        this.miK.setVisibility(8);
        this.miM.addHeaderView(this.miK);
        this.miN = LayoutInflater.from(praiseListActivity.getPageContext().getContext()).inflate(R.layout.zan_list_foot, (ViewGroup) null);
        this.miO = (TextView) this.miN.findViewById(R.id.zan_list_foot_text_continue);
        this.miP = (TextView) this.miN.findViewById(R.id.zan_list_foot_text_more);
        this.miR = (ProgressBar) this.miN.findViewById(R.id.zan_list_foot_progress);
        this.miN.setVisibility(8);
        this.miO.setOnClickListener(praiseListActivity);
        this.miM.addFooterView(this.miN);
        this.miM.setOnItemClickListener(praiseListActivity);
    }

    public void cUz() {
        if (this.miE != null) {
            this.miE.notifyDataSetChanged();
        }
    }

    public void wl(boolean z) {
        if (z) {
            this.miR.setVisibility(0);
        } else {
            this.miQ.setVisibility(0);
        }
    }

    public void dtY() {
        this.miQ.setVisibility(8);
        this.miR.setVisibility(8);
    }

    public boolean isLoading() {
        return this.miQ.getVisibility() == 0 || this.miR.getVisibility() == 0;
    }

    public void b(int i, List<a> list, int i2, int i3) {
        String format;
        String format2;
        this.miQ.setVisibility(8);
        this.miR.setVisibility(8);
        this.miK.setVisibility(0);
        if (i > 0) {
            switch (this.miF.pageType) {
                case 1:
                    format2 = String.format(this.miF.getResources().getString(R.string.graffiti_list_title_count), at.numFormatOverWan(i));
                    break;
                default:
                    format2 = String.format(this.miF.getResources().getString(R.string.praise_list_title_count), at.numFormatOverWan(i));
                    break;
            }
            this.miH.setTitleText(format2);
        } else {
            this.miH.setTitleText("");
        }
        if (list == null || list.size() < 1) {
            bJ(null, this.miF.pageType);
            return;
        }
        this.miI.setVisibility(0);
        this.miJ.setVisibility(8);
        this.miE.ft(list);
        this.miE.notifyDataSetChanged();
        switch (i2) {
            case 1001:
                this.miN.setVisibility(0);
                this.miO.setVisibility(0);
                this.miP.setVisibility(8);
                return;
            case 1002:
                this.miN.setVisibility(8);
                return;
            case 1003:
                this.miN.setVisibility(0);
                ao.setBackgroundResource(this.miN, R.drawable.bg_pack);
                this.miO.setVisibility(8);
                this.miP.setVisibility(0);
                switch (this.miF.pageType) {
                    case 1:
                        format = String.format(this.miF.getResources().getString(R.string.graffiti_list_title_count), at.numFormatOverWan(i));
                        break;
                    default:
                        format = String.format(this.miF.getResources().getString(R.string.praise_item_more), at.numFormatOverWan(i));
                        break;
                }
                this.miP.setText(format);
                return;
            default:
                this.miN.setVisibility(8);
                return;
        }
    }

    public void bJ(String str, int i) {
        this.miQ.setVisibility(8);
        this.miR.setVisibility(8);
        this.miI.setVisibility(8);
        this.miJ.setVisibility(0);
        if (!StringUtils.isNull(str)) {
            this.miJ.setTextOption(NoDataViewFactory.d.Bk(str));
        } else if (1 == i) {
            this.miJ.setTextOption(NoDataViewFactory.d.pu(R.string.graffiti_list_no_data));
        } else {
            this.miJ.setTextOption(NoDataViewFactory.d.pu(R.string.praise_list_no_data));
        }
    }

    public void a(com.baidu.tbadk.core.c cVar, int i) {
        if (cVar != null) {
            cVar.setNightMode(i == 1);
            cVar.onModeChanged(this.miG);
            cVar.onModeChanged(this.miK);
            cVar.onModeChanged(this.miN);
            this.miH.onChangeSkinType(this.miF.getPageContext(), i);
            ao.setBackgroundResource(this.miN, R.drawable.bg_pack);
            if (this.miJ != null) {
                this.miJ.onChangeSkinType(this.miF.getPageContext(), i);
            }
        }
    }

    public View dtZ() {
        return this.miK;
    }

    public View dua() {
        return this.miO;
    }
}
