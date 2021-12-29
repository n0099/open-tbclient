package com.baidu.tieba.location.selectpoi;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import c.a.d.f.p.m;
import c.a.d.f.p.n;
import c.a.t0.b2.c.a;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.mutiprocess.location.LocationEvent;
import com.baidu.tieba.R;
import com.baidu.tieba.location.data.LocationSearchHttpResponsedMessage;
import com.baidu.tieba.location.data.LocationSearchNetRequestMessage;
import com.baidu.tieba.location.data.LocationSearchResponseMessage;
import com.baidu.tieba.selectpoi.NavigationBarActivity;
import com.baidu.tieba.tbadkCore.location.LocationData;
import com.baidu.tieba.tbadkCore.location.ResponsedSelectLocation;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes12.dex */
public class SearchLocationActivity extends NavigationBarActivity {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public AdapterView.OnItemClickListener itemListener;
    public c.a.t0.b2.e.a mAdapter;
    public LinearLayout mEditLayout;
    public EditText mEditSearch;
    public InputMethodManager mInputManager;
    public BdListView mListView;
    public final AbsListView.OnScrollListener mOnScrollListener;
    public TextView mSearchButton;
    public c.a.d.c.g.a mSearchDataNetListener;
    public c.a.t0.b2.c.a mSearchDatas;
    public ImageView searchBarIcon;

    /* loaded from: classes12.dex */
    public class a extends c.a.d.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SearchLocationActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(SearchLocationActivity searchLocationActivity, int i2, int i3) {
            super(i2, i3);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {searchLocationActivity, Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = searchLocationActivity;
        }

        @Override // c.a.d.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) || responsedMessage == null) {
                return;
            }
            boolean z = responsedMessage instanceof LocationSearchHttpResponsedMessage;
            if (z || (responsedMessage instanceof LocationSearchResponseMessage)) {
                if (!responsedMessage.hasError() && responsedMessage.getError() == 0) {
                    if (z) {
                        this.a.mSearchDatas = ((LocationSearchHttpResponsedMessage) responsedMessage).getLocationData();
                    }
                    if (responsedMessage instanceof LocationSearchResponseMessage) {
                        this.a.mSearchDatas = ((LocationSearchResponseMessage) responsedMessage).getLocationData();
                    }
                    this.a.mAdapter.d(this.a.mSearchDatas);
                    this.a.mAdapter.notifyDataSetChanged();
                    return;
                }
                this.a.showToast(StringUtils.isNull(responsedMessage.getErrorString()) ? this.a.getResources().getString(R.string.neterror) : responsedMessage.getErrorString());
            }
        }
    }

    /* loaded from: classes12.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SearchLocationActivity f47473e;

        public b(SearchLocationActivity searchLocationActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {searchLocationActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47473e = searchLocationActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && this.f47473e.mEditSearch.hasFocus()) {
                n.w(this.f47473e.getPageContext().getPageActivity(), this.f47473e.mEditSearch);
                this.f47473e.closeActivity();
            }
        }
    }

    /* loaded from: classes12.dex */
    public class c implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SearchLocationActivity f47474e;

        public c(SearchLocationActivity searchLocationActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {searchLocationActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47474e = searchLocationActivity;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, editable) == null) {
                if (StringUtils.isNull(this.f47474e.getInputMsg())) {
                    this.f47474e.mSearchButton.setEnabled(false);
                } else {
                    this.f47474e.mSearchButton.setEnabled(true);
                }
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i2, i3, i4) == null) {
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i2, i3, i4) == null) {
            }
        }
    }

    /* loaded from: classes12.dex */
    public class d implements TextView.OnEditorActionListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SearchLocationActivity a;

        public d(SearchLocationActivity searchLocationActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {searchLocationActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = searchLocationActivity;
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
            InterceptResult invokeLIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048576, this, textView, i2, keyEvent)) == null) {
                if (i2 == 3) {
                    if (!n.C()) {
                        this.a.showToast(R.string.no_network_guide);
                        return false;
                    } else if (StringUtils.isNull(this.a.getInputMsg())) {
                        return false;
                    } else {
                        this.a.getSearchData();
                        return true;
                    }
                }
                return false;
            }
            return invokeLIL.booleanValue;
        }
    }

    /* loaded from: classes12.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SearchLocationActivity f47475e;

        public e(SearchLocationActivity searchLocationActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {searchLocationActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47475e = searchLocationActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (!n.C()) {
                    this.f47475e.showToast(R.string.no_network_guide);
                } else if (StringUtils.isNull(this.f47475e.getInputMsg())) {
                } else {
                    this.f47475e.getSearchData();
                }
            }
        }
    }

    /* loaded from: classes12.dex */
    public class f implements AbsListView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SearchLocationActivity f47476e;

        public f(SearchLocationActivity searchLocationActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {searchLocationActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47476e = searchLocationActivity;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(1048576, this, absListView, i2, i3, i4) == null) {
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, absListView, i2) == null) {
                if (i2 == 2 || i2 == 1) {
                    n.w(this.f47476e.getPageContext().getPageActivity(), this.f47476e.mEditSearch);
                }
            }
        }
    }

    /* loaded from: classes12.dex */
    public class g implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SearchLocationActivity f47477e;

        public g(SearchLocationActivity searchLocationActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {searchLocationActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47477e = searchLocationActivity;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j2)}) == null) && this.f47477e.mAdapter != null && this.f47477e.mAdapter.c()) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2002013));
                MessageManager messageManager = MessageManager.getInstance();
                a.C0963a c0963a = (a.C0963a) this.f47477e.mAdapter.getItem(i2);
                messageManager.dispatchResponsedMessage(new ResponsedSelectLocation(true, c0963a.a(), c0963a.a(), c0963a.b()));
                LocationEvent locationEvent = new LocationEvent();
                locationEvent.setType(1);
                locationEvent.eventType = 2;
                locationEvent.locName = c0963a.a();
                locationEvent.locAddr = c0963a.a();
                locationEvent.locSn = c0963a.b();
                locationEvent.isShowLocation = true;
                this.f47477e.getPageContext().getOrignalPage().publishEvent(locationEvent);
                this.f47477e.finish();
            }
        }
    }

    public SearchLocationActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mSearchDataNetListener = new a(this, CmdConfigHttp.CMD_GET_SUGGESTLOCSTION_BY_NAME, 303018);
        this.mOnScrollListener = new f(this);
        this.itemListener = new g(this);
    }

    private ArrayList<a.C0963a> processInvalidData(List<LocationData.NearByAddressData> list, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65543, this, list, str, str2)) == null) {
            LocationData.NearByAddressData nearByAddressData = null;
            if (list == null || list.size() <= 0) {
                return null;
            }
            ArrayList<a.C0963a> arrayList = new ArrayList<>();
            for (LocationData.NearByAddressData nearByAddressData2 : list) {
                if (nearByAddressData2 != null && !TextUtils.isEmpty(nearByAddressData2.getName())) {
                    if (TextUtils.equals(nearByAddressData2.getName(), str)) {
                        nearByAddressData = nearByAddressData2;
                    } else {
                        a.C0963a c0963a = new a.C0963a();
                        c0963a.d(nearByAddressData2.getName());
                        c0963a.e(nearByAddressData2.getSn());
                        arrayList.add(c0963a);
                    }
                }
            }
            if (nearByAddressData != null) {
                a.C0963a c0963a2 = new a.C0963a();
                c0963a2.d(nearByAddressData.getName());
                c0963a2.e(nearByAddressData.getSn());
                arrayList.add(0, c0963a2);
            } else {
                a.C0963a c0963a3 = new a.C0963a();
                c0963a3.d(str);
                c0963a3.e(str2);
                arrayList.add(0, c0963a3);
            }
            return arrayList;
        }
        return (ArrayList) invokeLLL.objValue;
    }

    public String getInputMsg() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            EditText editText = this.mEditSearch;
            if (editText != null) {
                return m.charSequence2String(editText.getText(), null);
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public void getSearchData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            LocationSearchNetRequestMessage locationSearchNetRequestMessage = new LocationSearchNetRequestMessage();
            locationSearchNetRequestMessage.setAddrName(getInputMsg());
            sendMessage(locationSearchNetRequestMessage);
        }
    }

    public void initData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.mSearchDatas = new c.a.t0.b2.c.a();
            LocationData b2 = c.a.t0.w3.o0.b.a().b();
            if (b2 != null) {
                this.mSearchDatas.c(processInvalidData(b2.getPoi_info(), b2.getFormatted_address(), b2.getSn()));
            }
            this.mAdapter.d(this.mSearchDatas);
            this.mAdapter.notifyDataSetChanged();
        }
    }

    public void initUI() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.mInputManager = (InputMethodManager) getSystemService("input_method");
            this.navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new b(this));
            LinearLayout linearLayout = (LinearLayout) this.navigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, R.layout.search_location_edit_layout, (View.OnClickListener) null);
            this.mEditLayout = linearLayout;
            this.searchBarIcon = (ImageView) linearLayout.findViewById(R.id.search_bar_icon);
            EditText editText = (EditText) this.mEditLayout.findViewById(R.id.search_location_editview);
            this.mEditSearch = editText;
            editText.addTextChangedListener(new c(this));
            this.mEditSearch.setOnEditorActionListener(new d(this));
            TextView textView = (TextView) this.mEditLayout.findViewById(R.id.search_location_bt_search_s);
            this.mSearchButton = textView;
            textView.setEnabled(false);
            this.mSearchButton.setOnClickListener(new e(this));
            this.mListView = (BdListView) findViewById(R.id.search_position_list);
            c.a.t0.b2.e.a aVar = new c.a.t0.b2.e.a(this);
            this.mAdapter = aVar;
            this.mListView.setAdapter((ListAdapter) aVar);
            this.mListView.setOnItemClickListener(this.itemListener);
            this.mListView.setOnScrollListener(this.mOnScrollListener);
        }
    }

    @Override // com.baidu.tieba.selectpoi.NavigationBarActivity, com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            super.onChangeSkinType(i2);
            c.a.s0.s.u.c d2 = c.a.s0.s.u.c.d(this.mSearchButton);
            d2.v(R.color.CAM_X0101);
            d2.n(R.string.J_X01);
            d2.f(R.color.CAM_X0302);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.searchBarIcon, R.drawable.icon_pure_search_import16_svg, R.color.CAM_X0109, null);
            SkinManager.setViewTextColor(this.mSearchButton, R.color.search_location_button_color, 3);
            this.mEditSearch.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
            this.mEditSearch.setHintTextColor(SkinManager.getColor(R.color.CAM_X0110));
            this.mAdapter.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.selectpoi.NavigationBarActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bundle) == null) {
            super.onCreate(bundle);
            registerListener(this.mSearchDataNetListener);
            SearchLocationActivityStatic.a();
            setContentView(R.layout.search_location_layout);
            initUI();
            initData();
        }
    }
}
