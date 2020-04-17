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
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.core.util.SvgManager;
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
/* loaded from: classes10.dex */
public class SearchLocationActivity extends NavigationBarActivity {
    private BdListView TX;
    private EditText gLa;
    private com.baidu.tieba.location.data.a iQc;
    private a iQd;
    private LinearLayout iQe;
    private TextView iQf;
    private ImageView iQg;
    private InputMethodManager mInputManager;
    private com.baidu.adp.framework.listener.a iQh = new com.baidu.adp.framework.listener.a(1003002, CmdConfigSocket.CMD_GET_SUGGESTLOCSTION_BY_NAME) { // from class: com.baidu.tieba.location.selectpoi.SearchLocationActivity.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage != null) {
                if ((responsedMessage instanceof LocationSearchHttpResponsedMessage) || (responsedMessage instanceof LocationSearchResponseMessage)) {
                    if (responsedMessage.hasError() || responsedMessage.getError() != 0) {
                        SearchLocationActivity.this.showToast(StringUtils.isNull(responsedMessage.getErrorString()) ? SearchLocationActivity.this.getResources().getString(R.string.neterror) : responsedMessage.getErrorString());
                        return;
                    }
                    if (responsedMessage instanceof LocationSearchHttpResponsedMessage) {
                        SearchLocationActivity.this.iQc = ((LocationSearchHttpResponsedMessage) responsedMessage).getLocationData();
                    }
                    if (responsedMessage instanceof LocationSearchResponseMessage) {
                        SearchLocationActivity.this.iQc = ((LocationSearchResponseMessage) responsedMessage).getLocationData();
                    }
                    SearchLocationActivity.this.iQd.a(SearchLocationActivity.this.iQc);
                    SearchLocationActivity.this.iQd.notifyDataSetChanged();
                }
            }
        }
    };
    private final AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.location.selectpoi.SearchLocationActivity.5
        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (i == 2 || i == 1) {
                l.hideSoftKeyPad(SearchLocationActivity.this.getPageContext().getPageActivity(), SearchLocationActivity.this.gLa);
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }
    };
    private AdapterView.OnItemClickListener iQi = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.location.selectpoi.SearchLocationActivity.6
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (SearchLocationActivity.this.iQd != null && SearchLocationActivity.this.iQd.coQ()) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CLOSE_SELECT_LOCATION_ACTIVITY));
                MessageManager messageManager = MessageManager.getInstance();
                a.C0593a c0593a = (a.C0593a) SearchLocationActivity.this.iQd.getItem(i);
                messageManager.dispatchResponsedMessage(new ResponsedSelectLocation(true, c0593a.getName(), c0593a.getName(), c0593a.getScreatString()));
                SearchLocationActivity.this.finish();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.selectpoi.NavigationBarActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(this.iQh);
        SearchLocationActivityStatic.coP();
        setContentView(R.layout.search_location_layout);
        initUI();
        initData();
    }

    public void initUI() {
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
        this.eCi.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.location.selectpoi.SearchLocationActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (SearchLocationActivity.this.gLa.hasFocus()) {
                    l.hideSoftKeyPad(SearchLocationActivity.this.getPageContext().getPageActivity(), SearchLocationActivity.this.gLa);
                    SearchLocationActivity.this.closeActivity();
                }
            }
        });
        this.iQe = (LinearLayout) this.eCi.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, R.layout.search_location_edit_layout, (View.OnClickListener) null);
        this.iQg = (ImageView) this.iQe.findViewById(R.id.search_bar_icon);
        this.gLa = (EditText) this.iQe.findViewById(R.id.search_location_editview);
        this.gLa.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.location.selectpoi.SearchLocationActivity.3
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (StringUtils.isNull(SearchLocationActivity.this.getInputMsg())) {
                    SearchLocationActivity.this.iQf.setEnabled(false);
                } else {
                    SearchLocationActivity.this.iQf.setEnabled(true);
                }
            }
        });
        this.iQf = (TextView) this.iQe.findViewById(R.id.search_location_bt_search_s);
        this.iQf.setEnabled(false);
        this.iQf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.location.selectpoi.SearchLocationActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!l.isNetOk()) {
                    SearchLocationActivity.this.showToast(R.string.no_network_guide);
                } else if (!StringUtils.isNull(SearchLocationActivity.this.getInputMsg())) {
                    SearchLocationActivity.this.coO();
                }
            }
        });
        this.TX = (BdListView) findViewById(R.id.search_position_list);
        this.iQd = new a(this);
        this.TX.setAdapter((ListAdapter) this.iQd);
        this.TX.setOnItemClickListener(this.iQi);
        this.TX.setOnScrollListener(this.mOnScrollListener);
    }

    public void initData() {
        this.iQc = new com.baidu.tieba.location.data.a();
        com.baidu.tieba.tbadkCore.location.a locationData = c.cWX().getLocationData();
        if (locationData != null) {
            this.iQc.az(b(locationData.cWW(), locationData.cWV(), locationData.getSn()));
        }
        this.iQd.a(this.iQc);
        this.iQd.notifyDataSetChanged();
    }

    private ArrayList<a.C0593a> b(List<a.C0655a> list, String str, String str2) {
        if (list == null || list.size() <= 0) {
            return null;
        }
        ArrayList<a.C0593a> arrayList = new ArrayList<>();
        a.C0655a c0655a = null;
        for (a.C0655a c0655a2 : list) {
            if (c0655a2 != null && !TextUtils.isEmpty(c0655a2.getName())) {
                if (TextUtils.equals(c0655a2.getName(), str)) {
                    c0655a = c0655a2;
                } else {
                    a.C0593a c0593a = new a.C0593a();
                    c0593a.setName(c0655a2.getName());
                    c0593a.FT(c0655a2.getSn());
                    arrayList.add(c0593a);
                }
            }
        }
        if (c0655a != null) {
            a.C0593a c0593a2 = new a.C0593a();
            c0593a2.setName(c0655a.getName());
            c0593a2.FT(c0655a.getSn());
            arrayList.add(0, c0593a2);
        } else {
            a.C0593a c0593a3 = new a.C0593a();
            c0593a3.setName(str);
            c0593a3.FT(str2);
            arrayList.add(0, c0593a3);
        }
        return arrayList;
    }

    public void coO() {
        LocationSearchNetRequestMessage locationSearchNetRequestMessage = new LocationSearchNetRequestMessage();
        locationSearchNetRequestMessage.setAddrName(getInputMsg());
        sendMessage(locationSearchNetRequestMessage);
    }

    public String getInputMsg() {
        if (this.gLa != null) {
            return k.charSequence2String(this.gLa.getText(), null);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.selectpoi.NavigationBarActivity, com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        am.setBackgroundResource(this.iQf, R.drawable.s_navbar_button_bg);
        SvgManager.aOU().a(this.iQg, R.drawable.icon_pure_search_import16_svg, R.color.cp_cont_d, (SvgManager.SvgResourceStateType) null);
        am.setViewTextColor(this.iQf, R.color.search_location_button_color, 3);
        this.gLa.setTextColor(am.getColor(R.color.cp_cont_b));
        this.gLa.setHintTextColor(am.getColor(R.color.cp_cont_e));
        this.iQd.notifyDataSetChanged();
    }
}
