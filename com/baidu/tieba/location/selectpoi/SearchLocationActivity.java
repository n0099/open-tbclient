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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
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
/* loaded from: classes5.dex */
public class SearchLocationActivity extends NavigationBarActivity {
    private BdListView Ni;
    private EditText fcY;
    private com.baidu.tieba.location.data.a hjX;
    private a hjY;
    private LinearLayout hjZ;
    private TextView hka;
    private ImageView hkb;
    private InputMethodManager mInputManager;
    private com.baidu.adp.framework.listener.a hkc = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_GET_SUGGESTLOCSTION_BY_NAME, 303018) { // from class: com.baidu.tieba.location.selectpoi.SearchLocationActivity.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage != null) {
                if ((responsedMessage instanceof LocationSearchHttpResponsedMessage) || (responsedMessage instanceof LocationSearchResponseMessage)) {
                    if (responsedMessage.hasError() || responsedMessage.getError() != 0) {
                        SearchLocationActivity.this.showToast(StringUtils.isNull(responsedMessage.getErrorString()) ? SearchLocationActivity.this.getResources().getString(R.string.neterror) : responsedMessage.getErrorString());
                        return;
                    }
                    if (responsedMessage instanceof LocationSearchHttpResponsedMessage) {
                        SearchLocationActivity.this.hjX = ((LocationSearchHttpResponsedMessage) responsedMessage).getLocationData();
                    }
                    if (responsedMessage instanceof LocationSearchResponseMessage) {
                        SearchLocationActivity.this.hjX = ((LocationSearchResponseMessage) responsedMessage).getLocationData();
                    }
                    SearchLocationActivity.this.hjY.a(SearchLocationActivity.this.hjX);
                    SearchLocationActivity.this.hjY.notifyDataSetChanged();
                }
            }
        }
    };
    private final AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.location.selectpoi.SearchLocationActivity.5
        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (i == 2 || i == 1) {
                l.b(SearchLocationActivity.this.getPageContext().getPageActivity(), SearchLocationActivity.this.fcY);
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }
    };
    private AdapterView.OnItemClickListener hkd = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.location.selectpoi.SearchLocationActivity.6
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (SearchLocationActivity.this.hjY != null && SearchLocationActivity.this.hjY.bLL()) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2002013));
                MessageManager messageManager = MessageManager.getInstance();
                a.C0357a c0357a = (a.C0357a) SearchLocationActivity.this.hjY.getItem(i);
                messageManager.dispatchResponsedMessage(new ResponsedSelectLocation(true, c0357a.getName(), c0357a.getName(), c0357a.getScreatString()));
                SearchLocationActivity.this.finish();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.selectpoi.NavigationBarActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(this.hkc);
        SearchLocationActivityStatic.bLK();
        setContentView(R.layout.search_location_layout);
        initUI();
        initData();
    }

    public void initUI() {
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
        this.cZw.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.location.selectpoi.SearchLocationActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (SearchLocationActivity.this.fcY.hasFocus()) {
                    l.b(SearchLocationActivity.this.getPageContext().getPageActivity(), SearchLocationActivity.this.fcY);
                    SearchLocationActivity.this.closeActivity();
                }
            }
        });
        this.hjZ = (LinearLayout) this.cZw.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, R.layout.search_location_edit_layout, (View.OnClickListener) null);
        this.hkb = (ImageView) this.hjZ.findViewById(R.id.search_bar_icon);
        this.fcY = (EditText) this.hjZ.findViewById(R.id.search_location_editview);
        this.fcY.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.location.selectpoi.SearchLocationActivity.3
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (StringUtils.isNull(SearchLocationActivity.this.getInputMsg())) {
                    SearchLocationActivity.this.hka.setEnabled(false);
                } else {
                    SearchLocationActivity.this.hka.setEnabled(true);
                }
            }
        });
        this.hka = (TextView) this.hjZ.findViewById(R.id.search_location_bt_search_s);
        this.hka.setEnabled(false);
        this.hka.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.location.selectpoi.SearchLocationActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!l.kt()) {
                    SearchLocationActivity.this.showToast(R.string.no_network_guide);
                } else if (!StringUtils.isNull(SearchLocationActivity.this.getInputMsg())) {
                    SearchLocationActivity.this.bLJ();
                }
            }
        });
        this.Ni = (BdListView) findViewById(R.id.search_position_list);
        this.hjY = new a(this);
        this.Ni.setAdapter((ListAdapter) this.hjY);
        this.Ni.setOnItemClickListener(this.hkd);
        this.Ni.setOnScrollListener(this.mOnScrollListener);
    }

    public void initData() {
        this.hjX = new com.baidu.tieba.location.data.a();
        com.baidu.tieba.tbadkCore.location.a locationData = c.cpV().getLocationData();
        if (locationData != null) {
            this.hjX.ai(b(locationData.cpU(), locationData.cpT(), locationData.getSn()));
        }
        this.hjY.a(this.hjX);
        this.hjY.notifyDataSetChanged();
    }

    private ArrayList<a.C0357a> b(List<a.C0415a> list, String str, String str2) {
        if (list == null || list.size() <= 0) {
            return null;
        }
        ArrayList<a.C0357a> arrayList = new ArrayList<>();
        a.C0415a c0415a = null;
        for (a.C0415a c0415a2 : list) {
            if (c0415a2 != null && !TextUtils.isEmpty(c0415a2.getName())) {
                if (TextUtils.equals(c0415a2.getName(), str)) {
                    c0415a = c0415a2;
                } else {
                    a.C0357a c0357a = new a.C0357a();
                    c0357a.setName(c0415a2.getName());
                    c0357a.Aj(c0415a2.getSn());
                    arrayList.add(c0357a);
                }
            }
        }
        if (c0415a != null) {
            a.C0357a c0357a2 = new a.C0357a();
            c0357a2.setName(c0415a.getName());
            c0357a2.Aj(c0415a.getSn());
            arrayList.add(0, c0357a2);
        } else {
            a.C0357a c0357a3 = new a.C0357a();
            c0357a3.setName(str);
            c0357a3.Aj(str2);
            arrayList.add(0, c0357a3);
        }
        return arrayList;
    }

    public void bLJ() {
        LocationSearchNetRequestMessage locationSearchNetRequestMessage = new LocationSearchNetRequestMessage();
        locationSearchNetRequestMessage.setAddrName(getInputMsg());
        sendMessage(locationSearchNetRequestMessage);
    }

    public String getInputMsg() {
        if (this.fcY != null) {
            return k.a(this.fcY.getText(), null);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.selectpoi.NavigationBarActivity, com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        am.k(this.hka, R.drawable.s_navbar_button_bg);
        am.c(this.hkb, (int) R.drawable.icon_search_ba);
        am.f(this.hka, R.color.search_location_button_color, 3);
        if (i == 1) {
            this.fcY.setTextColor(getResources().getColor(R.color.cp_cont_b_1));
            this.fcY.setHintTextColor(getResources().getColor(R.color.cp_cont_e_1));
        } else {
            this.fcY.setTextColor(getResources().getColor(R.color.cp_cont_b));
            this.fcY.setHintTextColor(getResources().getColor(R.color.cp_cont_e));
        }
        this.hjY.notifyDataSetChanged();
    }
}
