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
/* loaded from: classes4.dex */
public class e extends com.baidu.adp.base.c<PraiseListActivity> {
    private c ijG;
    private PraiseListActivity ijH;
    private View ijI;
    private NavigationBar ijJ;
    private View ijK;
    private NoDataView ijL;
    private View ijM;
    private TextView ijN;
    private BdListView ijO;
    private View ijP;
    private TextView ijQ;
    private TextView ijR;
    private ProgressBar ijS;
    private ProgressBar ijT;

    public e(PraiseListActivity praiseListActivity, String str) {
        super(praiseListActivity.getPageContext());
        this.ijG = null;
        this.ijH = null;
        this.ijI = null;
        this.ijJ = null;
        this.ijK = null;
        this.ijL = null;
        this.ijM = null;
        this.ijN = null;
        this.ijO = null;
        this.ijP = null;
        this.ijQ = null;
        this.ijR = null;
        this.ijS = null;
        this.ijT = null;
        this.ijH = praiseListActivity;
        praiseListActivity.setContentView(R.layout.zan_list_activity);
        this.ijI = praiseListActivity.findViewById(R.id.zan_list_page_parent);
        this.ijJ = (NavigationBar) praiseListActivity.findViewById(R.id.zan_list_page_navigationbar);
        this.ijK = praiseListActivity.findViewById(R.id.zan_list_page_frame);
        this.ijL = NoDataViewFactory.a(this.ijH.getPageContext().getContext(), this.ijI, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.getDimens(this.ijH.getActivity(), R.dimen.ds320)), NoDataViewFactory.d.iL(R.string.praise_list_no_data), null);
        this.ijO = (BdListView) praiseListActivity.findViewById(R.id.zan_list_page_list);
        TextView textView = new TextView(this.ijH.getActivity());
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)));
        this.ijO.addHeaderView(textView, 0);
        this.ijS = (ProgressBar) praiseListActivity.findViewById(R.id.zan_list_page_progress);
        this.ijG = new c(praiseListActivity);
        this.ijO.setAdapter((ListAdapter) this.ijG);
        this.ijO.setOnScrollListener(this.ijG);
        this.ijJ.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.ijJ.setTitleText("");
        this.ijM = LayoutInflater.from(praiseListActivity.getPageContext().getContext()).inflate(R.layout.zan_list_head, (ViewGroup) null);
        this.ijM.setOnClickListener(praiseListActivity);
        this.ijN = (TextView) this.ijM.findViewById(R.id.zan_list_head_text);
        this.ijN.setText(str);
        this.ijM.setVisibility(8);
        this.ijO.addHeaderView(this.ijM);
        this.ijP = LayoutInflater.from(praiseListActivity.getPageContext().getContext()).inflate(R.layout.zan_list_foot, (ViewGroup) null);
        this.ijQ = (TextView) this.ijP.findViewById(R.id.zan_list_foot_text_continue);
        this.ijR = (TextView) this.ijP.findViewById(R.id.zan_list_foot_text_more);
        this.ijT = (ProgressBar) this.ijP.findViewById(R.id.zan_list_foot_progress);
        this.ijP.setVisibility(8);
        this.ijQ.setOnClickListener(praiseListActivity);
        this.ijO.addFooterView(this.ijP);
        this.ijO.setOnItemClickListener(praiseListActivity);
    }

    public void bBv() {
        if (this.ijG != null) {
            this.ijG.notifyDataSetChanged();
        }
    }

    public void pl(boolean z) {
        if (z) {
            this.ijT.setVisibility(0);
        } else {
            this.ijS.setVisibility(0);
        }
    }

    public void bYW() {
        this.ijS.setVisibility(8);
        this.ijT.setVisibility(8);
    }

    public boolean isLoading() {
        return this.ijS.getVisibility() == 0 || this.ijT.getVisibility() == 0;
    }

    public void b(int i, List<a> list, int i2, int i3) {
        String format;
        String format2;
        this.ijS.setVisibility(8);
        this.ijT.setVisibility(8);
        this.ijM.setVisibility(0);
        if (i > 0) {
            switch (this.ijH.pageType) {
                case 1:
                    format2 = String.format(this.ijH.getResources().getString(R.string.graffiti_list_title_count), aq.numFormatOverWan(i));
                    break;
                default:
                    format2 = String.format(this.ijH.getResources().getString(R.string.praise_list_title_count), aq.numFormatOverWan(i));
                    break;
            }
            this.ijJ.setTitleText(format2);
        } else {
            this.ijJ.setTitleText("");
        }
        if (list == null || list.size() < 1) {
            bc(null, this.ijH.pageType);
            return;
        }
        this.ijK.setVisibility(0);
        this.ijL.setVisibility(8);
        this.ijG.dZ(list);
        this.ijG.notifyDataSetChanged();
        switch (i2) {
            case 1001:
                this.ijP.setVisibility(0);
                this.ijQ.setVisibility(0);
                this.ijR.setVisibility(8);
                return;
            case 1002:
                this.ijP.setVisibility(8);
                return;
            case 1003:
                this.ijP.setVisibility(0);
                am.setBackgroundResource(this.ijP, R.drawable.bg_pack);
                this.ijQ.setVisibility(8);
                this.ijR.setVisibility(0);
                switch (this.ijH.pageType) {
                    case 1:
                        format = String.format(this.ijH.getResources().getString(R.string.graffiti_list_title_count), aq.numFormatOverWan(i));
                        break;
                    default:
                        format = String.format(this.ijH.getResources().getString(R.string.praise_item_more), aq.numFormatOverWan(i));
                        break;
                }
                this.ijR.setText(format);
                return;
            default:
                this.ijP.setVisibility(8);
                return;
        }
    }

    public void bc(String str, int i) {
        this.ijS.setVisibility(8);
        this.ijT.setVisibility(8);
        this.ijK.setVisibility(8);
        this.ijL.setVisibility(0);
        if (!StringUtils.isNull(str)) {
            this.ijL.setTextOption(NoDataViewFactory.d.ow(str));
        } else if (1 == i) {
            this.ijL.setTextOption(NoDataViewFactory.d.iL(R.string.graffiti_list_no_data));
        } else {
            this.ijL.setTextOption(NoDataViewFactory.d.iL(R.string.praise_list_no_data));
        }
    }

    public void a(com.baidu.tbadk.core.c cVar, int i) {
        if (cVar != null) {
            cVar.setNightMode(i == 1);
            cVar.onModeChanged(this.ijI);
            cVar.onModeChanged(this.ijM);
            cVar.onModeChanged(this.ijP);
            this.ijJ.onChangeSkinType(this.ijH.getPageContext(), i);
            am.setBackgroundResource(this.ijP, R.drawable.bg_pack);
            if (this.ijL != null) {
                this.ijL.onChangeSkinType(this.ijH.getPageContext(), i);
            }
        }
    }

    public View bYX() {
        return this.ijM;
    }

    public View bYY() {
        return this.ijQ;
    }
}
