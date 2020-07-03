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
/* loaded from: classes10.dex */
public class c implements View.OnClickListener, AdapterView.OnItemClickListener, com.baidu.tbadk.suspended.a {
    private BdListView US;
    private Intent iIV;
    private ImageView iwg;
    private b jxw;
    private LinearLayout mContentView;
    private NavigationBar mNavigationBar;
    private TbPageContext<SelectLocationActivity> mPageContext;

    public c(TbPageContext tbPageContext, LinearLayout linearLayout, NavigationBar navigationBar) {
        this.mPageContext = tbPageContext;
        this.mContentView = linearLayout;
        this.mNavigationBar = navigationBar;
        biq();
        Px();
    }

    private void biq() {
        this.mNavigationBar.setCenterTextTitle(this.mPageContext.getResources().getString(R.string.select_position_title));
        this.iwg = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.widget_nb_item_search, (View.OnClickListener) null);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.iwg.getLayoutParams();
        layoutParams.setMargins(0, 0, l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds10), 0);
        this.iwg.setLayoutParams(layoutParams);
        this.iwg.setOnClickListener(this);
    }

    private void Px() {
        LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.select_location_activity, (ViewGroup) this.mContentView, true);
        this.US = (BdListView) this.mContentView.findViewById(R.id.select_position_list);
        this.jxw = new b(this.mPageContext);
        this.US.setAdapter((ListAdapter) this.jxw);
        this.US.setOnItemClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.iwg) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_SEARCH_LOCATION_PAGE, new SearchLocationActivityConfig(this.mPageContext.getPageActivity(), RequestResponseCode.REQUEST_CLOSE_SELECT_LOCATION_ACTIVITY)));
        }
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (this.jxw != null) {
            MessageManager messageManager = MessageManager.getInstance();
            if (i == 0) {
                messageManager.dispatchResponsedMessage(new ResponsedSelectLocation(false, null, null, null));
                this.mPageContext.getOrignalPage().finish();
                return;
            }
            Object item = this.jxw.getItem(i);
            if (item instanceof a.C0746a) {
                a.C0746a c0746a = (a.C0746a) item;
                messageManager.dispatchResponsedMessage(new ResponsedSelectLocation(true, c0746a.getName(), c0746a.getAddr(), c0746a.axE()));
                this.mPageContext.getOrignalPage().finish();
            }
        }
    }

    @Override // com.baidu.tbadk.suspended.a
    public boolean bim() {
        View childAt;
        return this.US != null && this.US.getFirstVisiblePosition() == 0 && (childAt = this.US.getChildAt(0)) != null && childAt.getTop() == 0;
    }

    @Override // com.baidu.tbadk.suspended.a
    public boolean bin() {
        return true;
    }

    @Override // com.baidu.tbadk.suspended.a
    public void ob(int i) {
        SvgManager.aWQ().a(this.iwg, R.drawable.icon_pure_topbar_search44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        this.jxw.notifyDataSetChanged();
    }

    @Override // com.baidu.tbadk.suspended.a
    public Intent bio() {
        return this.iIV;
    }
}
