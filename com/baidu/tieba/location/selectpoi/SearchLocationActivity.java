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
import com.repackage.ff7;
import com.repackage.gs4;
import com.repackage.if7;
import com.repackage.li;
import com.repackage.mi;
import com.repackage.wa;
import com.repackage.yk8;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class SearchLocationActivity extends NavigationBarActivity {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public AdapterView.OnItemClickListener itemListener;
    public if7 mAdapter;
    public LinearLayout mEditLayout;
    public EditText mEditSearch;
    public InputMethodManager mInputManager;
    public BdListView mListView;
    public final AbsListView.OnScrollListener mOnScrollListener;
    public TextView mSearchButton;
    public wa mSearchDataNetListener;
    public ff7 mSearchDatas;
    public ImageView searchBarIcon;

    /* loaded from: classes3.dex */
    public class a extends wa {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SearchLocationActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(SearchLocationActivity searchLocationActivity, int i, int i2) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {searchLocationActivity, Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = searchLocationActivity;
        }

        @Override // com.repackage.wa
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
                this.a.showToast(StringUtils.isNull(responsedMessage.getErrorString()) ? this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0c2d) : responsedMessage.getErrorString());
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SearchLocationActivity a;

        public b(SearchLocationActivity searchLocationActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {searchLocationActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = searchLocationActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.mEditSearch.hasFocus()) {
                mi.w(this.a.getPageContext().getPageActivity(), this.a.mEditSearch);
                this.a.closeActivity();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SearchLocationActivity a;

        public c(SearchLocationActivity searchLocationActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {searchLocationActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = searchLocationActivity;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, editable) == null) {
                if (StringUtils.isNull(this.a.getInputMsg())) {
                    this.a.mSearchButton.setEnabled(false);
                } else {
                    this.a.mSearchButton.setEnabled(true);
                }
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i, i2, i3) == null) {
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i, i2, i3) == null) {
            }
        }
    }

    /* loaded from: classes3.dex */
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = searchLocationActivity;
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            InterceptResult invokeLIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048576, this, textView, i, keyEvent)) == null) {
                if (i == 3) {
                    if (!mi.C()) {
                        this.a.showToast(R.string.obfuscated_res_0x7f0f0c65);
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

    /* loaded from: classes3.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SearchLocationActivity a;

        public e(SearchLocationActivity searchLocationActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {searchLocationActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = searchLocationActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (!mi.C()) {
                    this.a.showToast(R.string.obfuscated_res_0x7f0f0c65);
                } else if (StringUtils.isNull(this.a.getInputMsg())) {
                } else {
                    this.a.getSearchData();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f implements AbsListView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SearchLocationActivity a;

        public f(SearchLocationActivity searchLocationActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {searchLocationActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = searchLocationActivity;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(1048576, this, absListView, i, i2, i3) == null) {
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, absListView, i) == null) {
                if (i == 2 || i == 1) {
                    mi.w(this.a.getPageContext().getPageActivity(), this.a.mEditSearch);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class g implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SearchLocationActivity a;

        public g(SearchLocationActivity searchLocationActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {searchLocationActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = searchLocationActivity;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view2, Integer.valueOf(i), Long.valueOf(j)}) == null) && this.a.mAdapter != null && this.a.mAdapter.c()) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2002013));
                MessageManager messageManager = MessageManager.getInstance();
                ff7.a aVar = (ff7.a) this.a.mAdapter.getItem(i);
                messageManager.dispatchResponsedMessage(new ResponsedSelectLocation(true, aVar.a(), aVar.a(), aVar.b()));
                LocationEvent locationEvent = new LocationEvent();
                locationEvent.setType(1);
                locationEvent.eventType = 2;
                locationEvent.locName = aVar.a();
                locationEvent.locAddr = aVar.a();
                locationEvent.locSn = aVar.b();
                locationEvent.isShowLocation = true;
                this.a.getPageContext().getOrignalPage().publishEvent(locationEvent);
                this.a.finish();
            }
        }
    }

    public SearchLocationActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mSearchDataNetListener = new a(this, CmdConfigHttp.CMD_GET_SUGGESTLOCSTION_BY_NAME, 303018);
        this.mOnScrollListener = new f(this);
        this.itemListener = new g(this);
    }

    private ArrayList<ff7.a> processInvalidData(List<LocationData.NearByAddressData> list, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65543, this, list, str, str2)) == null) {
            LocationData.NearByAddressData nearByAddressData = null;
            if (list == null || list.size() <= 0) {
                return null;
            }
            ArrayList<ff7.a> arrayList = new ArrayList<>();
            for (LocationData.NearByAddressData nearByAddressData2 : list) {
                if (nearByAddressData2 != null && !TextUtils.isEmpty(nearByAddressData2.getName())) {
                    if (TextUtils.equals(nearByAddressData2.getName(), str)) {
                        nearByAddressData = nearByAddressData2;
                    } else {
                        ff7.a aVar = new ff7.a();
                        aVar.d(nearByAddressData2.getName());
                        aVar.e(nearByAddressData2.getSn());
                        arrayList.add(aVar);
                    }
                }
            }
            if (nearByAddressData != null) {
                ff7.a aVar2 = new ff7.a();
                aVar2.d(nearByAddressData.getName());
                aVar2.e(nearByAddressData.getSn());
                arrayList.add(0, aVar2);
            } else {
                ff7.a aVar3 = new ff7.a();
                aVar3.d(str);
                aVar3.e(str2);
                arrayList.add(0, aVar3);
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
                return li.charSequence2String(editText.getText(), null);
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
            this.mSearchDatas = new ff7();
            LocationData b2 = yk8.a().b();
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
            LinearLayout linearLayout = (LinearLayout) this.navigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, R.layout.obfuscated_res_0x7f0d073a, (View.OnClickListener) null);
            this.mEditLayout = linearLayout;
            this.searchBarIcon = (ImageView) linearLayout.findViewById(R.id.obfuscated_res_0x7f091c59);
            EditText editText = (EditText) this.mEditLayout.findViewById(R.id.obfuscated_res_0x7f091c7b);
            this.mEditSearch = editText;
            editText.addTextChangedListener(new c(this));
            this.mEditSearch.setOnEditorActionListener(new d(this));
            TextView textView = (TextView) this.mEditLayout.findViewById(R.id.obfuscated_res_0x7f091c7a);
            this.mSearchButton = textView;
            textView.setEnabled(false);
            this.mSearchButton.setOnClickListener(new e(this));
            this.mListView = (BdListView) findViewById(R.id.obfuscated_res_0x7f091c7e);
            if7 if7Var = new if7(this);
            this.mAdapter = if7Var;
            this.mListView.setAdapter((ListAdapter) if7Var);
            this.mListView.setOnItemClickListener(this.itemListener);
            this.mListView.setOnScrollListener(this.mOnScrollListener);
        }
    }

    @Override // com.baidu.tieba.selectpoi.NavigationBarActivity, com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            super.onChangeSkinType(i);
            gs4 d2 = gs4.d(this.mSearchButton);
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
            setContentView(R.layout.obfuscated_res_0x7f0d073b);
            initUI();
            initData();
        }
    }
}
