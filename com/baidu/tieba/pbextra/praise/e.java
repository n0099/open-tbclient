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
    private c mtX;
    private PraiseListActivity mtY;
    private View mtZ;
    private NavigationBar mua;
    private View mub;
    private NoDataView muc;
    private View mud;
    private TextView mue;
    private BdListView muf;
    private View mug;
    private TextView muh;
    private TextView mui;
    private ProgressBar muj;
    private ProgressBar muk;

    public e(PraiseListActivity praiseListActivity, String str) {
        super(praiseListActivity.getPageContext());
        this.mtX = null;
        this.mtY = null;
        this.mtZ = null;
        this.mua = null;
        this.mub = null;
        this.muc = null;
        this.mud = null;
        this.mue = null;
        this.muf = null;
        this.mug = null;
        this.muh = null;
        this.mui = null;
        this.muj = null;
        this.muk = null;
        this.mtY = praiseListActivity;
        praiseListActivity.setContentView(R.layout.zan_list_activity);
        this.mtZ = praiseListActivity.findViewById(R.id.zan_list_page_parent);
        this.mua = (NavigationBar) praiseListActivity.findViewById(R.id.zan_list_page_navigationbar);
        this.mub = praiseListActivity.findViewById(R.id.zan_list_page_frame);
        this.muc = NoDataViewFactory.a(this.mtY.getPageContext().getContext(), this.mtZ, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.getDimens(this.mtY.getActivity(), R.dimen.ds320)), NoDataViewFactory.d.pA(R.string.praise_list_no_data), null);
        this.muf = (BdListView) praiseListActivity.findViewById(R.id.zan_list_page_list);
        TextView textView = new TextView(this.mtY.getActivity());
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)));
        this.muf.addHeaderView(textView, 0);
        this.muj = (ProgressBar) praiseListActivity.findViewById(R.id.zan_list_page_progress);
        this.mtX = new c(praiseListActivity);
        this.muf.setAdapter((ListAdapter) this.mtX);
        this.muf.setOnScrollListener(this.mtX);
        this.mua.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mua.setTitleText("");
        this.mud = LayoutInflater.from(praiseListActivity.getPageContext().getContext()).inflate(R.layout.zan_list_head, (ViewGroup) null);
        this.mud.setOnClickListener(praiseListActivity);
        this.mue = (TextView) this.mud.findViewById(R.id.zan_list_head_text);
        this.mue.setText(str);
        this.mud.setVisibility(8);
        this.muf.addHeaderView(this.mud);
        this.mug = LayoutInflater.from(praiseListActivity.getPageContext().getContext()).inflate(R.layout.zan_list_foot, (ViewGroup) null);
        this.muh = (TextView) this.mug.findViewById(R.id.zan_list_foot_text_continue);
        this.mui = (TextView) this.mug.findViewById(R.id.zan_list_foot_text_more);
        this.muk = (ProgressBar) this.mug.findViewById(R.id.zan_list_foot_progress);
        this.mug.setVisibility(8);
        this.muh.setOnClickListener(praiseListActivity);
        this.muf.addFooterView(this.mug);
        this.muf.setOnItemClickListener(praiseListActivity);
    }

    public void cWL() {
        if (this.mtX != null) {
            this.mtX.notifyDataSetChanged();
        }
    }

    public void wC(boolean z) {
        if (z) {
            this.muk.setVisibility(0);
        } else {
            this.muj.setVisibility(0);
        }
    }

    public void dwx() {
        this.muj.setVisibility(8);
        this.muk.setVisibility(8);
    }

    public boolean isLoading() {
        return this.muj.getVisibility() == 0 || this.muk.getVisibility() == 0;
    }

    public void b(int i, List<a> list, int i2, int i3) {
        String format;
        String format2;
        this.muj.setVisibility(8);
        this.muk.setVisibility(8);
        this.mud.setVisibility(0);
        if (i > 0) {
            switch (this.mtY.pageType) {
                case 1:
                    format2 = String.format(this.mtY.getResources().getString(R.string.graffiti_list_title_count), au.numFormatOverWan(i));
                    break;
                default:
                    format2 = String.format(this.mtY.getResources().getString(R.string.praise_list_title_count), au.numFormatOverWan(i));
                    break;
            }
            this.mua.setTitleText(format2);
        } else {
            this.mua.setTitleText("");
        }
        if (list == null || list.size() < 1) {
            bK(null, this.mtY.pageType);
            return;
        }
        this.mub.setVisibility(0);
        this.muc.setVisibility(8);
        this.mtX.fr(list);
        this.mtX.notifyDataSetChanged();
        switch (i2) {
            case 1001:
                this.mug.setVisibility(0);
                this.muh.setVisibility(0);
                this.mui.setVisibility(8);
                return;
            case 1002:
                this.mug.setVisibility(8);
                return;
            case 1003:
                this.mug.setVisibility(0);
                ap.setBackgroundResource(this.mug, R.drawable.bg_pack);
                this.muh.setVisibility(8);
                this.mui.setVisibility(0);
                switch (this.mtY.pageType) {
                    case 1:
                        format = String.format(this.mtY.getResources().getString(R.string.graffiti_list_title_count), au.numFormatOverWan(i));
                        break;
                    default:
                        format = String.format(this.mtY.getResources().getString(R.string.praise_item_more), au.numFormatOverWan(i));
                        break;
                }
                this.mui.setText(format);
                return;
            default:
                this.mug.setVisibility(8);
                return;
        }
    }

    public void bK(String str, int i) {
        this.muj.setVisibility(8);
        this.muk.setVisibility(8);
        this.mub.setVisibility(8);
        this.muc.setVisibility(0);
        if (!StringUtils.isNull(str)) {
            this.muc.setTextOption(NoDataViewFactory.d.BI(str));
        } else if (1 == i) {
            this.muc.setTextOption(NoDataViewFactory.d.pA(R.string.graffiti_list_no_data));
        } else {
            this.muc.setTextOption(NoDataViewFactory.d.pA(R.string.praise_list_no_data));
        }
    }

    public void a(com.baidu.tbadk.core.c cVar, int i) {
        if (cVar != null) {
            cVar.setNightMode(i == 1);
            cVar.onModeChanged(this.mtZ);
            cVar.onModeChanged(this.mud);
            cVar.onModeChanged(this.mug);
            this.mua.onChangeSkinType(this.mtY.getPageContext(), i);
            ap.setBackgroundResource(this.mug, R.drawable.bg_pack);
            if (this.muc != null) {
                this.muc.onChangeSkinType(this.mtY.getPageContext(), i);
            }
        }
    }

    public View dwy() {
        return this.mud;
    }

    public View dwz() {
        return this.muh;
    }
}
