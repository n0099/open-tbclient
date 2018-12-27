package com.baidu.tieba.location.selectpoi;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.k;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.e;
import com.baidu.tieba.location.data.LocationSearchHttpResponsedMessage;
import com.baidu.tieba.location.data.LocationSearchNetRequestMessage;
import com.baidu.tieba.location.data.LocationSearchResponseMessage;
import com.baidu.tieba.location.data.a;
import com.baidu.tieba.selectpoi.NavigationBarActivity;
import com.baidu.tieba.tbadkCore.location.ResponsedSelectLocation;
import com.baidu.tieba.tbadkCore.location.a;
import com.baidu.tieba.tbadkCore.location.c;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class SearchLocationActivity extends NavigationBarActivity {
    private BdListView OF;
    private EditText dud;
    private com.baidu.tieba.location.data.a fvB;
    private a fvC;
    private LinearLayout fvD;
    private TextView fvE;
    private ImageView fvF;
    private InputMethodManager mInputManager;
    private com.baidu.adp.framework.listener.a fvG = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_GET_SUGGESTLOCSTION_BY_NAME, 303018) { // from class: com.baidu.tieba.location.selectpoi.SearchLocationActivity.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage != null) {
                if ((responsedMessage instanceof LocationSearchHttpResponsedMessage) || (responsedMessage instanceof LocationSearchResponseMessage)) {
                    if (responsedMessage.hasError() || responsedMessage.getError() != 0) {
                        SearchLocationActivity.this.showToast(StringUtils.isNull(responsedMessage.getErrorString()) ? SearchLocationActivity.this.getResources().getString(e.j.neterror) : responsedMessage.getErrorString());
                        return;
                    }
                    if (responsedMessage instanceof LocationSearchHttpResponsedMessage) {
                        SearchLocationActivity.this.fvB = ((LocationSearchHttpResponsedMessage) responsedMessage).getLocationData();
                    }
                    if (responsedMessage instanceof LocationSearchResponseMessage) {
                        SearchLocationActivity.this.fvB = ((LocationSearchResponseMessage) responsedMessage).getLocationData();
                    }
                    SearchLocationActivity.this.fvC.a(SearchLocationActivity.this.fvB);
                    SearchLocationActivity.this.fvC.notifyDataSetChanged();
                }
            }
        }
    };
    private final AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.location.selectpoi.SearchLocationActivity.5
        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (i == 2 || i == 1) {
                l.b(SearchLocationActivity.this.getPageContext().getPageActivity(), SearchLocationActivity.this.dud);
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }
    };
    private AdapterView.OnItemClickListener fvH = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.location.selectpoi.SearchLocationActivity.6
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (SearchLocationActivity.this.fvC != null && SearchLocationActivity.this.fvC.baq()) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2002013));
                MessageManager messageManager = MessageManager.getInstance();
                a.C0266a c0266a = (a.C0266a) SearchLocationActivity.this.fvC.getItem(i);
                messageManager.dispatchResponsedMessage(new ResponsedSelectLocation(true, c0266a.getName(), c0266a.getName(), c0266a.getScreatString()));
                SearchLocationActivity.this.finish();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.selectpoi.NavigationBarActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(this.fvG);
        SearchLocationActivityStatic.bap();
        setContentView(e.h.search_location_layout);
        initUI();
        initData();
    }

    public void initUI() {
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
        this.bDS.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.location.selectpoi.SearchLocationActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (SearchLocationActivity.this.dud.hasFocus()) {
                    l.b(SearchLocationActivity.this.getPageContext().getPageActivity(), SearchLocationActivity.this.dud);
                    SearchLocationActivity.this.closeActivity();
                }
            }
        });
        this.fvD = (LinearLayout) this.bDS.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, e.h.search_location_edit_layout, (View.OnClickListener) null);
        this.fvF = (ImageView) this.fvD.findViewById(e.g.search_bar_icon);
        this.dud = (EditText) this.fvD.findViewById(e.g.search_location_editview);
        this.dud.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.location.selectpoi.SearchLocationActivity.3
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (StringUtils.isNull(SearchLocationActivity.this.getInputMsg())) {
                    SearchLocationActivity.this.fvE.setEnabled(false);
                } else {
                    SearchLocationActivity.this.fvE.setEnabled(true);
                }
            }
        });
        this.fvE = (TextView) this.fvD.findViewById(e.g.search_location_bt_search_s);
        this.fvE.setEnabled(false);
        this.fvE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.location.selectpoi.SearchLocationActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!l.ll()) {
                    SearchLocationActivity.this.showToast(e.j.no_network_guide);
                } else if (!StringUtils.isNull(SearchLocationActivity.this.getInputMsg())) {
                    SearchLocationActivity.this.bao();
                }
            }
        });
        this.OF = (BdListView) findViewById(e.g.search_position_list);
        this.fvC = new a(this);
        this.OF.setAdapter((ListAdapter) this.fvC);
        this.OF.setOnItemClickListener(this.fvH);
        this.OF.setOnScrollListener(this.mOnScrollListener);
    }

    public void initData() {
        this.fvB = new com.baidu.tieba.location.data.a();
        com.baidu.tieba.tbadkCore.location.a locationData = c.bEO().getLocationData();
        if (locationData != null) {
            this.fvB.aa(b(locationData.bEM(), locationData.bEL(), locationData.bEN()));
        }
        this.fvC.a(this.fvB);
        this.fvC.notifyDataSetChanged();
    }

    private ArrayList<a.C0266a> b(List<a.C0318a> list, String str, String str2) {
        if (list == null || list.size() <= 0) {
            return null;
        }
        ArrayList<a.C0266a> arrayList = new ArrayList<>();
        a.C0318a c0318a = null;
        for (a.C0318a c0318a2 : list) {
            if (c0318a2 != null && !TextUtils.isEmpty(c0318a2.getName())) {
                if (TextUtils.equals(c0318a2.getName(), str)) {
                    c0318a = c0318a2;
                } else {
                    a.C0266a c0266a = new a.C0266a();
                    c0266a.setName(c0318a2.getName());
                    c0266a.ro(c0318a2.bEN());
                    arrayList.add(c0266a);
                }
            }
        }
        if (c0318a != null) {
            a.C0266a c0266a2 = new a.C0266a();
            c0266a2.setName(c0318a.getName());
            c0266a2.ro(c0318a.bEN());
            arrayList.add(0, c0266a2);
        } else {
            a.C0266a c0266a3 = new a.C0266a();
            c0266a3.setName(str);
            c0266a3.ro(str2);
            arrayList.add(0, c0266a3);
        }
        return arrayList;
    }

    public void bao() {
        LocationSearchNetRequestMessage locationSearchNetRequestMessage = new LocationSearchNetRequestMessage();
        locationSearchNetRequestMessage.setAddrName(getInputMsg());
        sendMessage(locationSearchNetRequestMessage);
    }

    public String getInputMsg() {
        if (this.dud != null) {
            return k.a(this.dud.getText(), null);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.selectpoi.NavigationBarActivity, com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        al.i(this.fvE, e.f.s_navbar_button_bg);
        al.c(this.fvF, e.f.icon_search_ba);
        al.c(this.fvE, e.d.search_location_button_color, 3);
        if (i == 1) {
            this.dud.setTextColor(getResources().getColor(e.d.cp_cont_b_1));
            this.dud.setHintTextColor(getResources().getColor(e.d.cp_cont_e_1));
        } else {
            this.dud.setTextColor(getResources().getColor(e.d.cp_cont_b));
            this.dud.setHintTextColor(getResources().getColor(e.d.cp_cont_e));
        }
        this.fvC.notifyDataSetChanged();
    }
}
