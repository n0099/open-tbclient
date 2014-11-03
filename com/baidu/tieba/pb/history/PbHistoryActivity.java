package com.baidu.tieba.pb.history;

import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.PbHistoryActivityConfig;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.q;
import com.baidu.tbadk.core.view.r;
import com.baidu.tbadk.core.view.s;
import com.baidu.tieba.data.ai;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
import com.baidu.tieba.y;
import java.util.List;
/* loaded from: classes.dex */
public class PbHistoryActivity extends BaseActivity {
    private final com.baidu.tbadk.mvc.model.d<ai> XG = new a(this);
    private com.baidu.tbadk.mvc.i.c<ai, com.baidu.tbadk.mvc.e.c, g> aXc;
    private RelativeLayout ahW;
    private TextView bux;
    private f buy;
    private NavigationBar mNavigationBar;
    private BdListView vl;

    static {
        TbadkApplication.m251getInst().RegisterIntent(PbHistoryActivityConfig.class, PbHistoryActivity.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.buy = new f(this);
        this.buy.a(this.XG);
        this.ahW = (RelativeLayout) com.baidu.adp.lib.g.b.ek().inflate(this, w.pb_history_activity, null);
        setContentView(this.ahW);
        this.mNavigationBar = (NavigationBar) findViewById(v.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(y.my_history);
        this.bux = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getString(y.delete_all_user_chat));
        this.bux.setOnClickListener(new b(this));
        this.bux.setVisibility(8);
        this.vl = (BdListView) findViewById(v.list);
        this.aXc = new com.baidu.tbadk.mvc.i.c<>(this, g.class, w.pb_history_list_item, null);
        this.aXc.a(r.a(NoDataViewFactory.ImgType.NODATA), s.q(y.pb_history_no_data_tip, y.pb_history_no_data_tip_2), (q) null, (FrameLayout.LayoutParams) null);
        this.vl.setAdapter((ListAdapter) this.aXc);
        this.vl.setOnItemClickListener(new e(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        Wa();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(i);
        this.aXc.dg(i);
        getLayoutMode().h(this.ahW);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Wa() {
        this.buy.tD();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ah(List<ai> list) {
        if (this.aXc != null) {
            this.aXc.r(list);
        }
        if (list == null || list.size() == 0) {
            this.bux.setVisibility(8);
        } else {
            this.bux.setVisibility(0);
        }
    }
}
