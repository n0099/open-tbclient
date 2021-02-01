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
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes2.dex */
public class e extends com.baidu.adp.base.d<PraiseListActivity> {
    private c mrF;
    private PraiseListActivity mrG;
    private View mrH;
    private NavigationBar mrI;
    private View mrJ;
    private NoDataView mrK;
    private View mrL;
    private TextView mrM;
    private BdListView mrN;
    private View mrO;
    private TextView mrP;
    private TextView mrQ;
    private ProgressBar mrR;
    private ProgressBar mrS;

    public e(PraiseListActivity praiseListActivity, String str) {
        super(praiseListActivity.getPageContext());
        this.mrF = null;
        this.mrG = null;
        this.mrH = null;
        this.mrI = null;
        this.mrJ = null;
        this.mrK = null;
        this.mrL = null;
        this.mrM = null;
        this.mrN = null;
        this.mrO = null;
        this.mrP = null;
        this.mrQ = null;
        this.mrR = null;
        this.mrS = null;
        this.mrG = praiseListActivity;
        praiseListActivity.setContentView(R.layout.zan_list_activity);
        this.mrH = praiseListActivity.findViewById(R.id.zan_list_page_parent);
        this.mrI = (NavigationBar) praiseListActivity.findViewById(R.id.zan_list_page_navigationbar);
        this.mrJ = praiseListActivity.findViewById(R.id.zan_list_page_frame);
        this.mrK = NoDataViewFactory.a(this.mrG.getPageContext().getContext(), this.mrH, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.getDimens(this.mrG.getActivity(), R.dimen.ds320)), NoDataViewFactory.d.pz(R.string.praise_list_no_data), null);
        this.mrN = (BdListView) praiseListActivity.findViewById(R.id.zan_list_page_list);
        TextView textView = new TextView(this.mrG.getActivity());
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)));
        this.mrN.addHeaderView(textView, 0);
        this.mrR = (ProgressBar) praiseListActivity.findViewById(R.id.zan_list_page_progress);
        this.mrF = new c(praiseListActivity);
        this.mrN.setAdapter((ListAdapter) this.mrF);
        this.mrN.setOnScrollListener(this.mrF);
        this.mrI.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mrI.setTitleText("");
        this.mrL = LayoutInflater.from(praiseListActivity.getPageContext().getContext()).inflate(R.layout.zan_list_head, (ViewGroup) null);
        this.mrL.setOnClickListener(praiseListActivity);
        this.mrM = (TextView) this.mrL.findViewById(R.id.zan_list_head_text);
        this.mrM.setText(str);
        this.mrL.setVisibility(8);
        this.mrN.addHeaderView(this.mrL);
        this.mrO = LayoutInflater.from(praiseListActivity.getPageContext().getContext()).inflate(R.layout.zan_list_foot, (ViewGroup) null);
        this.mrP = (TextView) this.mrO.findViewById(R.id.zan_list_foot_text_continue);
        this.mrQ = (TextView) this.mrO.findViewById(R.id.zan_list_foot_text_more);
        this.mrS = (ProgressBar) this.mrO.findViewById(R.id.zan_list_foot_progress);
        this.mrO.setVisibility(8);
        this.mrP.setOnClickListener(praiseListActivity);
        this.mrN.addFooterView(this.mrO);
        this.mrN.setOnItemClickListener(praiseListActivity);
    }

    public void cWx() {
        if (this.mrF != null) {
            this.mrF.notifyDataSetChanged();
        }
    }

    public void wC(boolean z) {
        if (z) {
            this.mrS.setVisibility(0);
        } else {
            this.mrR.setVisibility(0);
        }
    }

    public void dwh() {
        this.mrR.setVisibility(8);
        this.mrS.setVisibility(8);
    }

    public boolean isLoading() {
        return this.mrR.getVisibility() == 0 || this.mrS.getVisibility() == 0;
    }

    public void b(int i, List<a> list, int i2, int i3) {
        String format;
        String format2;
        this.mrR.setVisibility(8);
        this.mrS.setVisibility(8);
        this.mrL.setVisibility(0);
        if (i > 0) {
            switch (this.mrG.pageType) {
                case 1:
                    format2 = String.format(this.mrG.getResources().getString(R.string.graffiti_list_title_count), au.numFormatOverWan(i));
                    break;
                default:
                    format2 = String.format(this.mrG.getResources().getString(R.string.praise_list_title_count), au.numFormatOverWan(i));
                    break;
            }
            this.mrI.setTitleText(format2);
        } else {
            this.mrI.setTitleText("");
        }
        if (list == null || list.size() < 1) {
            bK(null, this.mrG.pageType);
            return;
        }
        this.mrJ.setVisibility(0);
        this.mrK.setVisibility(8);
        this.mrF.fr(list);
        this.mrF.notifyDataSetChanged();
        switch (i2) {
            case 1001:
                this.mrO.setVisibility(0);
                this.mrP.setVisibility(0);
                this.mrQ.setVisibility(8);
                return;
            case 1002:
                this.mrO.setVisibility(8);
                return;
            case 1003:
                this.mrO.setVisibility(0);
                ap.setBackgroundResource(this.mrO, R.drawable.bg_pack);
                this.mrP.setVisibility(8);
                this.mrQ.setVisibility(0);
                switch (this.mrG.pageType) {
                    case 1:
                        format = String.format(this.mrG.getResources().getString(R.string.graffiti_list_title_count), au.numFormatOverWan(i));
                        break;
                    default:
                        format = String.format(this.mrG.getResources().getString(R.string.praise_item_more), au.numFormatOverWan(i));
                        break;
                }
                this.mrQ.setText(format);
                return;
            default:
                this.mrO.setVisibility(8);
                return;
        }
    }

    public void bK(String str, int i) {
        this.mrR.setVisibility(8);
        this.mrS.setVisibility(8);
        this.mrJ.setVisibility(8);
        this.mrK.setVisibility(0);
        if (!StringUtils.isNull(str)) {
            this.mrK.setTextOption(NoDataViewFactory.d.BB(str));
        } else if (1 == i) {
            this.mrK.setTextOption(NoDataViewFactory.d.pz(R.string.graffiti_list_no_data));
        } else {
            this.mrK.setTextOption(NoDataViewFactory.d.pz(R.string.praise_list_no_data));
        }
    }

    public void a(com.baidu.tbadk.core.c cVar, int i) {
        if (cVar != null) {
            cVar.setNightMode(i == 1);
            cVar.onModeChanged(this.mrH);
            cVar.onModeChanged(this.mrL);
            cVar.onModeChanged(this.mrO);
            this.mrI.onChangeSkinType(this.mrG.getPageContext(), i);
            ap.setBackgroundResource(this.mrO, R.drawable.bg_pack);
            if (this.mrK != null) {
                this.mrK.onChangeSkinType(this.mrG.getPageContext(), i);
            }
        }
    }

    public View dwi() {
        return this.mrL;
    }

    public View dwj() {
        return this.mrP;
    }
}
