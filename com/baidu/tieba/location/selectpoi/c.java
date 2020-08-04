package com.baidu.tieba.location.selectpoi;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.tieba.location.data.SearchLocationActivityConfig;
import com.baidu.tieba.tbadkCore.location.ResponsedSelectLocation;
import com.baidu.tieba.tbadkCore.location.a;
/* loaded from: classes17.dex */
public class c implements View.OnClickListener, AdapterView.OnItemClickListener, com.baidu.tbadk.suspended.a {
    private BdListView UL;
    private ImageView iCm;
    private Intent iPc;
    private b jGc;
    private LinearLayout mContentView;
    private NavigationBar mNavigationBar;
    private TbPageContext<SelectLocationActivity> mPageContext;

    public c(TbPageContext tbPageContext, LinearLayout linearLayout, NavigationBar navigationBar) {
        this.mPageContext = tbPageContext;
        this.mContentView = linearLayout;
        this.mNavigationBar = navigationBar;
        bmb();
        PM();
    }

    private void bmb() {
        this.mNavigationBar.setCenterTextTitle(this.mPageContext.getResources().getString(R.string.select_position_title));
        this.iCm = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.widget_nb_item_search, (View.OnClickListener) null);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.iCm.getLayoutParams();
        layoutParams.setMargins(0, 0, l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds10), 0);
        this.iCm.setLayoutParams(layoutParams);
        this.iCm.setOnClickListener(this);
    }

    private void PM() {
        LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.select_location_activity, (ViewGroup) this.mContentView, true);
        this.UL = (BdListView) this.mContentView.findViewById(R.id.select_position_list);
        this.jGc = new b(this.mPageContext);
        this.UL.setAdapter((ListAdapter) this.jGc);
        this.UL.setOnItemClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.iCm) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_SEARCH_LOCATION_PAGE, new SearchLocationActivityConfig(this.mPageContext.getPageActivity(), RequestResponseCode.REQUEST_CLOSE_SELECT_LOCATION_ACTIVITY)));
        }
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (this.jGc != null) {
            MessageManager messageManager = MessageManager.getInstance();
            if (i == 0) {
                messageManager.dispatchResponsedMessage(new ResponsedSelectLocation(false, null, null, null));
                this.mPageContext.getOrignalPage().finish();
                return;
            }
            Object item = this.jGc.getItem(i);
            if (item instanceof a.C0756a) {
                a.C0756a c0756a = (a.C0756a) item;
                messageManager.dispatchResponsedMessage(new ResponsedSelectLocation(true, c0756a.getName(), c0756a.getAddr(), c0756a.aAC()));
                this.mPageContext.getOrignalPage().finish();
            }
        }
    }

    @Override // com.baidu.tbadk.suspended.a
    public boolean blX() {
        View childAt;
        return this.UL != null && this.UL.getFirstVisiblePosition() == 0 && (childAt = this.UL.getChildAt(0)) != null && childAt.getTop() == 0;
    }

    @Override // com.baidu.tbadk.suspended.a
    public boolean blY() {
        return true;
    }

    @Override // com.baidu.tbadk.suspended.a
    public void ot(int i) {
        SvgManager.baR().a(this.iCm, R.drawable.icon_pure_topbar_search44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        this.jGc.notifyDataSetChanged();
    }

    @Override // com.baidu.tbadk.suspended.a
    public Intent blZ() {
        return this.iPc;
    }
}
