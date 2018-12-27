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
    private BdListView dfD;
    private ImageView fvO;
    private b fvP;
    private TextView fvQ;
    private AdapterView.OnItemClickListener eHT = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.location.selectpoi.SelectLocationActivity.1
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (SelectLocationActivity.this.fvP != null) {
                MessageManager messageManager = MessageManager.getInstance();
                if (i != 0) {
                    Object item = SelectLocationActivity.this.fvP.getItem(i);
                    if (item instanceof a.C0318a) {
                        a.C0318a c0318a = (a.C0318a) item;
                        messageManager.dispatchResponsedMessage(new ResponsedSelectLocation(true, c0318a.getName(), c0318a.getAddr(), c0318a.bEN()));
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
    private CustomMessageListener fvR = new CustomMessageListener(2002013) { // from class: com.baidu.tieba.location.selectpoi.SelectLocationActivity.2
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
        this.bDS.setCenterTextTitle(getPageContext().getString(e.j.select_position_title));
        this.fvO = (ImageView) this.bDS.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, e.h.widget_nb_item_search, (View.OnClickListener) null);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fvO.getLayoutParams();
        layoutParams.setMargins(0, 0, l.h(getPageContext().getPageActivity(), e.C0210e.ds10), 0);
        this.fvO.setLayoutParams(layoutParams);
        this.fvO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.location.selectpoi.SelectLocationActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002012, new SearchLocationActivityConfig(SelectLocationActivity.this.getPageContext().getPageActivity(), 23009)));
            }
        });
        this.dfD = (BdListView) findViewById(e.g.select_position_list);
        this.fvP = new b(this);
        this.dfD.setAdapter((ListAdapter) this.fvP);
        this.dfD.setOnItemClickListener(this.eHT);
        registerListener(this.fvR);
        this.bDS.getViewGroup(NavigationBar.ControlAlign.HORIZONTAL_LEFT).removeAllViews();
        this.fvQ = this.bDS.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, getString(e.j.cancel), new View.OnClickListener() { // from class: com.baidu.tieba.location.selectpoi.SelectLocationActivity.4
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
        this.fvP.notifyDataSetChanged();
        al.a(this.fvO, e.f.icon_search_bg_s, e.f.icon_search_bg);
        al.h(this.fvQ, e.d.navi_back_text_color);
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
