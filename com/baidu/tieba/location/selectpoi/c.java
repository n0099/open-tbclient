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
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.mutiprocess.location.LocationEvent;
import com.baidu.tieba.R;
import com.baidu.tieba.location.data.SearchLocationActivityConfig;
import com.baidu.tieba.tbadkCore.location.LocationData;
import com.baidu.tieba.tbadkCore.location.ResponsedSelectLocation;
/* loaded from: classes23.dex */
public class c implements View.OnClickListener, AdapterView.OnItemClickListener, com.baidu.tbadk.suspended.a {
    private BdListView WX;
    private ImageView fXC;
    private Intent fXF;
    private b kZq;
    private LinearLayout mContentView;
    private NavigationBar mNavigationBar;
    private TbPageContext<SelectLocationActivity> mPageContext;

    public c(TbPageContext tbPageContext, LinearLayout linearLayout, NavigationBar navigationBar) {
        this.mPageContext = tbPageContext;
        this.mContentView = linearLayout;
        this.mNavigationBar = navigationBar;
        bFP();
        ZG();
    }

    private void bFP() {
        this.mNavigationBar.setCenterTextTitle(this.mPageContext.getResources().getString(R.string.select_position_title));
        this.fXC = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.widget_nb_item_search, (View.OnClickListener) null);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fXC.getLayoutParams();
        layoutParams.setMargins(0, 0, l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds10), 0);
        this.fXC.setLayoutParams(layoutParams);
        this.fXC.setImageDrawable(WebPManager.a(R.drawable.icon_pure_topbar_search40, ap.getColor(R.color.CAM_X0105), WebPManager.ResourceStateType.NORMAL_PRESS));
        this.fXC.setOnClickListener(this);
    }

    private void ZG() {
        LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.select_location_activity, (ViewGroup) this.mContentView, true);
        this.WX = (BdListView) this.mContentView.findViewById(R.id.select_position_list);
        this.kZq = new b(this.mPageContext);
        this.WX.setAdapter((ListAdapter) this.kZq);
        this.WX.setOnItemClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.fXC) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_SEARCH_LOCATION_PAGE, new SearchLocationActivityConfig(this.mPageContext.getPageActivity(), RequestResponseCode.REQUEST_CLOSE_SELECT_LOCATION_ACTIVITY)));
        }
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (this.kZq != null) {
            MessageManager messageManager = MessageManager.getInstance();
            LocationEvent locationEvent = new LocationEvent();
            locationEvent.setType(1);
            locationEvent.eventType = 2;
            if (i == 0) {
                messageManager.dispatchResponsedMessage(new ResponsedSelectLocation(false, null, null, null));
                locationEvent.isShowLocation = false;
                this.mPageContext.getOrignalPage().publishEvent(locationEvent);
                this.mPageContext.getOrignalPage().finish();
                return;
            }
            Object item = this.kZq.getItem(i);
            if (item instanceof LocationData.NearByAddressData) {
                LocationData.NearByAddressData nearByAddressData = (LocationData.NearByAddressData) item;
                messageManager.dispatchResponsedMessage(new ResponsedSelectLocation(true, nearByAddressData.getName(), nearByAddressData.getAddr(), nearByAddressData.getSn()));
                locationEvent.locName = nearByAddressData.getName();
                locationEvent.locAddr = nearByAddressData.getAddr();
                locationEvent.locSn = nearByAddressData.getSn();
                locationEvent.isShowLocation = true;
                this.mPageContext.getOrignalPage().publishEvent(locationEvent);
                this.mPageContext.getOrignalPage().finish();
            }
        }
    }

    @Override // com.baidu.tbadk.suspended.a
    public boolean bFL() {
        View childAt;
        return this.WX != null && this.WX.getFirstVisiblePosition() == 0 && (childAt = this.WX.getChildAt(0)) != null && childAt.getTop() == 0;
    }

    @Override // com.baidu.tbadk.suspended.a
    public boolean bFM() {
        return true;
    }

    @Override // com.baidu.tbadk.suspended.a
    public void sN(int i) {
        this.fXC.setImageDrawable(WebPManager.a(R.drawable.icon_pure_topbar_search40, ap.getColor(R.color.CAM_X0105), WebPManager.ResourceStateType.NORMAL_PRESS));
        this.kZq.notifyDataSetChanged();
    }

    @Override // com.baidu.tbadk.suspended.a
    public Intent bFN() {
        return this.fXF;
    }
}
