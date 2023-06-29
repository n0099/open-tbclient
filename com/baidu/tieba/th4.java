package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.location.Address;
import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.search.core.PoiInfo;
import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.mapapi.search.poi.OnGetPoiSearchResultListener;
import com.baidu.mapapi.search.poi.PoiCitySearchOption;
import com.baidu.mapapi.search.poi.PoiDetailResult;
import com.baidu.mapapi.search.poi.PoiDetailSearchResult;
import com.baidu.mapapi.search.poi.PoiIndoorResult;
import com.baidu.mapapi.search.poi.PoiResult;
import com.baidu.mapapi.search.poi.PoiSearch;
import com.baidu.swan.map.location.LocationDetailAdapter;
import com.baidu.swan.map.location.LocationFooterViewHolder;
import com.baidu.swan.map.location.LocationItemDecoration;
import com.baidu.swan.map.location.model.SelectedLocationInfo;
import com.baidu.tieba.lb2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class th4 extends ib2 implements oh4, OnGetPoiSearchResultListener, View.OnKeyListener, View.OnFocusChangeListener, TextWatcher, View.OnTouchListener, View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public EditText G0;
    public View H0;
    public TextView I0;
    public RecyclerView J0;
    public LocationDetailAdapter K0;
    public LinearLayoutManager L0;
    public List<ph4> M0;
    public PoiSearch N0;
    public InputMethodManager O0;
    public int P0;
    public int Q0;
    public String R0;
    public boolean S0;
    public boolean T0;
    public String U0;

    @Override // com.baidu.tieba.ib2
    public boolean H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.ib2
    public void W1(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2) == null) {
        }
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIII(1048582, this, charSequence, i, i2, i3) == null) {
        }
    }

    @Override // com.baidu.tieba.ib2
    public boolean e2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.ib2
    public boolean g2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.ib2, com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, motionEvent)) == null) {
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.ib2
    public void l2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
        }
    }

    @Override // com.baidu.mapapi.search.poi.OnGetPoiSearchResultListener
    public void onGetPoiDetailResult(PoiDetailResult poiDetailResult) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, poiDetailResult) == null) {
        }
    }

    @Override // com.baidu.mapapi.search.poi.OnGetPoiSearchResultListener
    public void onGetPoiDetailResult(PoiDetailSearchResult poiDetailSearchResult) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, poiDetailSearchResult) == null) {
        }
    }

    @Override // com.baidu.mapapi.search.poi.OnGetPoiSearchResultListener
    public void onGetPoiIndoorResult(PoiIndoorResult poiIndoorResult) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, poiIndoorResult) == null) {
        }
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIII(1048604, this, charSequence, i, i2, i3) == null) {
        }
    }

    /* loaded from: classes7.dex */
    public class a extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ th4 a;

        public a(th4 th4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {th4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = th4Var;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            int b3;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, recyclerView, i) == null) {
                super.onScrollStateChanged(recyclerView, i);
                if (i == 0 && (b3 = this.a.b3()) >= 0 && b3 + 1 == this.a.K0.getItemCount()) {
                    this.a.c3();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ th4 a;

        public b(th4 th4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {th4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = th4Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                th4 th4Var = this.a;
                th4Var.i3(th4Var.G0, true);
            }
        }
    }

    public th4() {
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
        this.N0 = null;
        this.P0 = 0;
        this.Q0 = 0;
        this.U0 = Address.Builder.BEI_JING;
    }

    public final void Z2() {
        Activity activity;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (activity = this.c0) != null) {
            activity.onBackPressed();
        }
    }

    public final View a3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            int b3 = b3();
            if (b3 == -1) {
                return null;
            }
            return this.L0.findViewByPosition(b3);
        }
        return (View) invokeV.objValue;
    }

    public final int b3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            LinearLayoutManager linearLayoutManager = this.L0;
            if (linearLayoutManager != null) {
                return linearLayoutManager.findLastVisibleItemPosition();
            }
            return -1;
        }
        return invokeV.intValue;
    }

    public void c3() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048583, this) != null) || this.S0) {
            return;
        }
        if (this.P0 < this.Q0) {
            l3(this.R0);
            this.S0 = true;
            return;
        }
        f3();
    }

    public final void f3() {
        View a3;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048587, this) != null) || (a3 = a3()) == null) {
            return;
        }
        RecyclerView.ViewHolder childViewHolder = this.J0.getChildViewHolder(a3);
        if (childViewHolder instanceof LocationFooterViewHolder) {
            ((LocationFooterViewHolder) childViewHolder).b(false);
        }
    }

    public final void g3() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048589, this) != null) || TextUtils.isEmpty(this.R0)) {
            return;
        }
        this.P0 = 0;
        l3(this.R0);
        i3(this.G0, false);
    }

    public void k3() {
        lb2 U;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048594, this) == null) && (U = px2.T().U()) != null) {
            lb2.b i = U.i("navigateTo");
            i.n(lb2.g, lb2.i);
            i.j(this);
            i.b();
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void z0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            super.z0();
            this.N0.destroy();
        }
    }

    public static th4 e3(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, bundle)) == null) {
            th4 th4Var = new th4();
            if (bundle != null) {
                th4Var.k1(bundle);
            }
            return th4Var;
        }
        return (th4) invokeL.objValue;
    }

    public final void h3(Intent intent) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048590, this, intent) != null) || S() == null) {
            return;
        }
        S().r0(T(), 0, intent);
    }

    public void j3(boolean z) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048593, this, z) == null) {
            View view2 = this.H0;
            if (z) {
                i = 0;
            } else {
                i = 8;
            }
            view2.setVisibility(i);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048597, this, view2) == null) && view2.getId() == R.id.obfuscated_res_0x7f090534) {
            Z2();
        }
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, editable) == null) {
            if (editable != null && editable.length() > 0) {
                this.T0 = false;
                this.P0 = 0;
                this.Q0 = 0;
                String obj = editable.toString();
                this.R0 = obj;
                l3(obj);
                return;
            }
            this.M0.clear();
            this.K0.setData(this.M0);
            this.R0 = "";
            this.P0 = 0;
            this.Q0 = 0;
            this.T0 = true;
        }
    }

    @Override // com.baidu.tieba.oh4
    public void d(ph4 ph4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, ph4Var) == null) {
            Intent intent = new Intent();
            PoiInfo poiInfo = ph4Var.a;
            if (poiInfo != null && poiInfo.location != null) {
                intent.putExtra(SelectedLocationInfo.LOCATION_KEY, new SelectedLocationInfo(poiInfo.name, poiInfo.address, poiInfo.location));
            }
            h3(intent);
            Z2();
        }
    }

    public final void l3(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, str) == null) {
            this.N0.searchInCity(new PoiCitySearchOption().cityLimit(false).scope(2).city(this.U0).keyword(str).pageCapacity(13).pageNum(this.P0));
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public final void d3(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, view2) == null) {
            this.M0 = new ArrayList(11);
            if (o() != null) {
                String string = o().getString("city");
                if (TextUtils.isEmpty(string)) {
                    string = Address.Builder.BEI_JING;
                }
                this.U0 = string;
            }
            this.G0 = (EditText) view2.findViewById(R.id.obfuscated_res_0x7f0920cb);
            this.J0 = (RecyclerView) view2.findViewById(R.id.obfuscated_res_0x7f09162c);
            this.H0 = view2.findViewById(R.id.obfuscated_res_0x7f09193f);
            this.I0 = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090534);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(px2.T().getActivity());
            this.L0 = linearLayoutManager;
            this.J0.setLayoutManager(linearLayoutManager);
            LocationDetailAdapter locationDetailAdapter = new LocationDetailAdapter(px2.T().getActivity(), this.J0, this);
            this.K0 = locationDetailAdapter;
            this.J0.setAdapter(locationDetailAdapter);
            this.J0.addItemDecoration(new LocationItemDecoration(px2.T().getActivity()));
            this.J0.setOnTouchListener(this);
            this.I0.setOnClickListener(this);
            PoiSearch newInstance = PoiSearch.newInstance();
            this.N0 = newInstance;
            newInstance.setOnGetPoiSearchResultListener(this);
            this.G0.addTextChangedListener(this);
            this.G0.setOnFocusChangeListener(this);
            this.G0.setOnKeyListener(this);
            this.G0.requestFocus();
            this.J0.addOnScrollListener(new a(this));
            this.G0.postDelayed(new b(this), 100L);
        }
    }

    public void i3(View view2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048591, this, view2, z) == null) {
            if (this.O0 == null) {
                this.O0 = (InputMethodManager) px2.T().getActivity().getApplicationContext().getSystemService("input_method");
            }
            InputMethodManager inputMethodManager = this.O0;
            if (inputMethodManager == null) {
                return;
            }
            if (z) {
                inputMethodManager.showSoftInput(view2, 0);
            } else {
                inputMethodManager.hideSoftInputFromWindow(view2.getWindowToken(), 0);
            }
        }
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048598, this, view2, z) == null) {
            i3(this.G0, z);
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view2, MotionEvent motionEvent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048605, this, view2, motionEvent)) == null) {
            i3(this.G0, false);
            return false;
        }
        return invokeLL.booleanValue;
    }

    @Override // com.baidu.mapapi.search.poi.OnGetPoiSearchResultListener
    public void onGetPoiResult(PoiResult poiResult) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, poiResult) == null) {
            boolean z = false;
            this.S0 = false;
            if (this.T0) {
                return;
            }
            if (poiResult.error == SearchResult.ERRORNO.NO_ERROR) {
                this.Q0 = poiResult.getTotalPageNum();
                if (this.P0 == 0) {
                    this.M0.clear();
                }
                this.M0.addAll(ph4.a(poiResult.getAllPoi()));
                this.K0.n(this.M0, this.R0);
                this.P0++;
            } else {
                if (this.P0 == 0) {
                    this.Q0 = 0;
                    this.M0.clear();
                    this.K0.setData(this.M0);
                }
                f3();
            }
            if (this.P0 == 0 && this.M0.size() == 0) {
                z = true;
            }
            j3(z);
            if (this.M0.size() <= 0) {
                f3();
            }
        }
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view2, int i, KeyEvent keyEvent) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048603, this, view2, i, keyEvent)) == null) {
            if (i == 66) {
                g3();
                return true;
            }
            return false;
        }
        return invokeLIL.booleanValue;
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public View y0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048606, this, layoutInflater, viewGroup, bundle)) == null) {
            jg4.a();
            SDKInitializer.setCoordType(CoordType.GCJ02);
            View inflate = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d008c, viewGroup, false);
            d3(inflate);
            if (V1()) {
                inflate = Y1(inflate);
                x1(-1);
            }
            return F1(inflate, this);
        }
        return (View) invokeLLL.objValue;
    }
}
