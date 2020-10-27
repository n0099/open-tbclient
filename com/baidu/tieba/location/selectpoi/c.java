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
import com.baidu.tbadk.mutiprocess.location.LocationEvent;
import com.baidu.tieba.R;
import com.baidu.tieba.location.data.SearchLocationActivityConfig;
import com.baidu.tieba.tbadkCore.location.LocationData;
import com.baidu.tieba.tbadkCore.location.ResponsedSelectLocation;
/* loaded from: classes23.dex */
public class c implements View.OnClickListener, AdapterView.OnItemClickListener, com.baidu.tbadk.suspended.a {
    private BdListView VY;
    private ImageView fJS;
    private Intent fJV;
    private b kFM;
    private LinearLayout mContentView;
    private NavigationBar mNavigationBar;
    private TbPageContext<SelectLocationActivity> mPageContext;

    public c(TbPageContext tbPageContext, LinearLayout linearLayout, NavigationBar navigationBar) {
        this.mPageContext = tbPageContext;
        this.mContentView = linearLayout;
        this.mNavigationBar = navigationBar;
        bAw();
        Vr();
    }

    private void bAw() {
        this.mNavigationBar.setCenterTextTitle(this.mPageContext.getResources().getString(R.string.select_position_title));
        this.fJS = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.widget_nb_item_search, (View.OnClickListener) null);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fJS.getLayoutParams();
        layoutParams.setMargins(0, 0, l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds10), 0);
        this.fJS.setLayoutParams(layoutParams);
        this.fJS.setOnClickListener(this);
    }

    private void Vr() {
        LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.select_location_activity, (ViewGroup) this.mContentView, true);
        this.VY = (BdListView) this.mContentView.findViewById(R.id.select_position_list);
        this.kFM = new b(this.mPageContext);
        this.VY.setAdapter((ListAdapter) this.kFM);
        this.VY.setOnItemClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.fJS) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_SEARCH_LOCATION_PAGE, new SearchLocationActivityConfig(this.mPageContext.getPageActivity(), RequestResponseCode.REQUEST_CLOSE_SELECT_LOCATION_ACTIVITY)));
        }
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (this.kFM != null) {
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
            Object item = this.kFM.getItem(i);
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
    public boolean bAs() {
        View childAt;
        return this.VY != null && this.VY.getFirstVisiblePosition() == 0 && (childAt = this.VY.getChildAt(0)) != null && childAt.getTop() == 0;
    }

    @Override // com.baidu.tbadk.suspended.a
    public boolean bAt() {
        return true;
    }

    @Override // com.baidu.tbadk.suspended.a
    public void rE(int i) {
        SvgManager.boN().a(this.fJS, R.drawable.icon_pure_topbar_search44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        this.kFM.notifyDataSetChanged();
    }

    @Override // com.baidu.tbadk.suspended.a
    public Intent bAu() {
        return this.fJV;
    }
}
