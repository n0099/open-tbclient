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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.d;
import com.baidu.tieba.location.data.SearchLocationActivityConfig;
import com.baidu.tieba.selectpoi.NavigationBarActivity;
import com.baidu.tieba.tbadkCore.location.ResponsedSelectLocation;
import com.baidu.tieba.tbadkCore.location.a;
/* loaded from: classes3.dex */
public class SelectLocationActivity extends NavigationBarActivity {
    private BdListView cGP;
    private ImageView eVM;
    private b eVN;
    private TextView eVO;
    private AdapterView.OnItemClickListener ehL = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.location.selectpoi.SelectLocationActivity.1
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (SelectLocationActivity.this.eVN != null) {
                MessageManager messageManager = MessageManager.getInstance();
                if (i != 0) {
                    Object item = SelectLocationActivity.this.eVN.getItem(i);
                    if (item instanceof a.C0238a) {
                        a.C0238a c0238a = (a.C0238a) item;
                        messageManager.dispatchResponsedMessage(new ResponsedSelectLocation(true, c0238a.getName(), c0238a.bwM(), c0238a.bwL()));
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
    private CustomMessageListener eVP = new CustomMessageListener(2002013) { // from class: com.baidu.tieba.location.selectpoi.SelectLocationActivity.2
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
        this.bpN.setCenterTextTitle(getPageContext().getString(d.j.select_position_title));
        this.eVM = (ImageView) this.bpN.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.widget_nb_item_search, (View.OnClickListener) null);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eVM.getLayoutParams();
        layoutParams.setMargins(0, 0, l.f(getPageContext().getPageActivity(), d.e.ds10), 0);
        this.eVM.setLayoutParams(layoutParams);
        this.eVM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.location.selectpoi.SelectLocationActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002012, new SearchLocationActivityConfig(SelectLocationActivity.this.getPageContext().getPageActivity(), 23009)));
            }
        });
        this.cGP = (BdListView) findViewById(d.g.select_position_list);
        this.eVN = new b(this);
        this.cGP.setAdapter((ListAdapter) this.eVN);
        this.cGP.setOnItemClickListener(this.ehL);
        registerListener(this.eVP);
        this.bpN.getViewGroup(NavigationBar.ControlAlign.HORIZONTAL_LEFT).removeAllViews();
        this.eVO = this.bpN.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, getString(d.j.cancel), new View.OnClickListener() { // from class: com.baidu.tieba.location.selectpoi.SelectLocationActivity.4
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
        this.eVN.notifyDataSetChanged();
        am.a(this.eVM, d.f.icon_search_bg_s, d.f.icon_search_bg);
        am.h(this.eVO, d.C0140d.navi_back_text_color);
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
