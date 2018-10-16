package com.baidu.tieba.location.selectpoi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.e;
import com.baidu.tieba.location.data.SearchLocationActivityConfig;
import com.baidu.tieba.selectpoi.NavigationBarActivity;
import com.baidu.tieba.tbadkCore.location.ResponsedSelectLocation;
import com.baidu.tieba.tbadkCore.location.a;
/* loaded from: classes3.dex */
public class SelectLocationActivity extends NavigationBarActivity {
    private BdListView cUV;
    private ImageView fkL;
    private b fkM;
    private TextView fkN;
    private AdapterView.OnItemClickListener ewQ = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.location.selectpoi.SelectLocationActivity.1
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (SelectLocationActivity.this.fkM != null) {
                MessageManager messageManager = MessageManager.getInstance();
                if (i != 0) {
                    Object item = SelectLocationActivity.this.fkM.getItem(i);
                    if (item instanceof a.C0279a) {
                        a.C0279a c0279a = (a.C0279a) item;
                        messageManager.dispatchResponsedMessage(new ResponsedSelectLocation(true, c0279a.getName(), c0279a.bCG(), c0279a.bCF()));
                        SelectLocationActivity.this.finish();
                        return;
                    }
                    return;
                }
                messageManager.dispatchResponsedMessage(new ResponsedSelectLocation(false, null, null, null));
                SelectLocationActivity.this.finish();
            }
        }
    };
    private CustomMessageListener fkO = new CustomMessageListener(2002013) { // from class: com.baidu.tieba.location.selectpoi.SelectLocationActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                SelectLocationActivity.this.finish();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.selectpoi.NavigationBarActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(e.h.select_location_activity);
        this.bzH.setCenterTextTitle(getPageContext().getString(e.j.select_position_title));
        this.fkL = (ImageView) this.bzH.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, e.h.widget_nb_item_search, (View.OnClickListener) null);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fkL.getLayoutParams();
        layoutParams.setMargins(0, 0, l.h(getPageContext().getPageActivity(), e.C0175e.ds10), 0);
        this.fkL.setLayoutParams(layoutParams);
        this.fkL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.location.selectpoi.SelectLocationActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002012, new SearchLocationActivityConfig(SelectLocationActivity.this.getPageContext().getPageActivity(), 23009)));
            }
        });
        this.cUV = (BdListView) findViewById(e.g.select_position_list);
        this.fkM = new b(this);
        this.cUV.setAdapter((ListAdapter) this.fkM);
        this.cUV.setOnItemClickListener(this.ewQ);
        registerListener(this.fkO);
        this.bzH.getViewGroup(NavigationBar.ControlAlign.HORIZONTAL_LEFT).removeAllViews();
        this.fkN = this.bzH.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, getString(e.j.cancel), new View.OnClickListener() { // from class: com.baidu.tieba.location.selectpoi.SelectLocationActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SelectLocationActivity.this.finish();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.selectpoi.NavigationBarActivity, com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.fkM.notifyDataSetChanged();
        al.a(this.fkL, e.f.icon_search_bg_s, e.f.icon_search_bg);
        al.h(this.fkN, e.d.navi_back_text_color);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 23009:
                    finish();
                    return;
                default:
                    return;
            }
        }
    }
}
