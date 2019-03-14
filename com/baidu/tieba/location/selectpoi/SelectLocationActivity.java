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
import com.baidu.tieba.d;
import com.baidu.tieba.location.data.SearchLocationActivityConfig;
import com.baidu.tieba.selectpoi.NavigationBarActivity;
import com.baidu.tieba.tbadkCore.location.ResponsedSelectLocation;
import com.baidu.tieba.tbadkCore.location.a;
/* loaded from: classes5.dex */
public class SelectLocationActivity extends NavigationBarActivity {
    private BdListView eql;
    private ImageView gMM;
    private b gMN;
    private TextView gMO;
    private AdapterView.OnItemClickListener fYG = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.location.selectpoi.SelectLocationActivity.1
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (SelectLocationActivity.this.gMN != null) {
                MessageManager messageManager = MessageManager.getInstance();
                if (i != 0) {
                    Object item = SelectLocationActivity.this.gMN.getItem(i);
                    if (item instanceof a.C0391a) {
                        a.C0391a c0391a = (a.C0391a) item;
                        messageManager.dispatchResponsedMessage(new ResponsedSelectLocation(true, c0391a.getName(), c0391a.getAddr(), c0391a.ceY()));
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
    private CustomMessageListener gMP = new CustomMessageListener(2002013) { // from class: com.baidu.tieba.location.selectpoi.SelectLocationActivity.2
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
        setContentView(d.h.select_location_activity);
        this.cPK.setCenterTextTitle(getPageContext().getString(d.j.select_position_title));
        this.gMM = (ImageView) this.cPK.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.widget_nb_item_search, (View.OnClickListener) null);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gMM.getLayoutParams();
        layoutParams.setMargins(0, 0, l.h(getPageContext().getPageActivity(), d.e.ds10), 0);
        this.gMM.setLayoutParams(layoutParams);
        this.gMM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.location.selectpoi.SelectLocationActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002012, new SearchLocationActivityConfig(SelectLocationActivity.this.getPageContext().getPageActivity(), 23009)));
            }
        });
        this.eql = (BdListView) findViewById(d.g.select_position_list);
        this.gMN = new b(this);
        this.eql.setAdapter((ListAdapter) this.gMN);
        this.eql.setOnItemClickListener(this.fYG);
        registerListener(this.gMP);
        this.cPK.getViewGroup(NavigationBar.ControlAlign.HORIZONTAL_LEFT).removeAllViews();
        this.gMO = this.cPK.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, getString(d.j.cancel), new View.OnClickListener() { // from class: com.baidu.tieba.location.selectpoi.SelectLocationActivity.4
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
        this.gMN.notifyDataSetChanged();
        al.a(this.gMM, d.f.icon_search_bg_s, d.f.icon_search_bg);
        al.j(this.gMO, d.C0277d.navi_back_text_color);
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
