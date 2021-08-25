package com.baidu.wallet.base.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.utils.DisplayUtils;
import com.baidu.apollon.utils.DxmApplicationContextImpl;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.core.utils.contacts.ContractInfo;
import com.baidu.wallet.core.utils.contacts.PhoneContactsMananger;
import java.util.ArrayList;
import java.util.List;
@SuppressLint({"NewApi"})
/* loaded from: classes8.dex */
public class PhoneHistoryFixView extends LinearLayout implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public View f60368a;

    /* renamed from: b  reason: collision with root package name */
    public View f60369b;

    /* renamed from: c  reason: collision with root package name */
    public View f60370c;

    /* renamed from: d  reason: collision with root package name */
    public ListView f60371d;

    /* renamed from: e  reason: collision with root package name */
    public LinearLayout f60372e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f60373f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f60374g;

    /* renamed from: h  reason: collision with root package name */
    public a f60375h;

    /* renamed from: i  reason: collision with root package name */
    public OnPhoneHistoryFixViewClickListener f60376i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f60377j;

    /* loaded from: classes8.dex */
    public interface OnPhoneHistoryFixViewClickListener {
        void onFixViewClickClearHistory();

        void onFixViewClickListViewItemAndSetText(String str);

        void onFixViewDisplayHistoryViews(boolean z);
    }

    /* loaded from: classes8.dex */
    public class a extends BaseAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PhoneHistoryFixView f60379a;

        /* renamed from: b  reason: collision with root package name */
        public Context f60380b;

        /* renamed from: c  reason: collision with root package name */
        public final LayoutInflater f60381c;

        /* renamed from: d  reason: collision with root package name */
        public List<ContractInfo> f60382d;

        public a(PhoneHistoryFixView phoneHistoryFixView, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {phoneHistoryFixView, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f60379a = phoneHistoryFixView;
            this.f60382d = new ArrayList();
            this.f60380b = context;
            this.f60381c = LayoutInflater.from(context);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.widget.Adapter
        /* renamed from: a */
        public String getItem(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
                return null;
            }
            return (String) invokeI.objValue;
        }

        public void a(List<ContractInfo> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
                if (list == null) {
                    list = new ArrayList<>();
                }
                this.f60382d = list;
            }
        }

        @Override // android.widget.Adapter
        public int getCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f60382d.size() : invokeV.intValue;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) ? i2 : invokeI.longValue;
        }

        @Override // android.widget.Adapter
        public View getView(int i2, View view, ViewGroup viewGroup) {
            InterceptResult invokeILL;
            b bVar;
            SpannableString spannableString;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeILL = interceptable.invokeILL(1048581, this, i2, view, viewGroup)) == null) {
                if (view == null) {
                    b bVar2 = new b();
                    View inflate = this.f60381c.inflate(ResUtils.layout(this.f60380b, "wallet_base_fix_item"), (ViewGroup) null);
                    bVar2.f60384b = (TextView) inflate.findViewById(ResUtils.id(this.f60380b, "wallet_phone_fix"));
                    bVar2.f60385c = (TextView) inflate.findViewById(ResUtils.id(this.f60380b, "wallet_name_fix"));
                    inflate.setTag(bVar2);
                    bVar = bVar2;
                    view = inflate;
                } else {
                    bVar = (b) view.getTag();
                }
                if (i2 < this.f60382d.size()) {
                    if (!this.f60379a.f60377j) {
                        spannableString = new SpannableString(this.f60382d.get(i2).getMobile().replace(" ", ""));
                    } else {
                        spannableString = new SpannableString(this.f60382d.get(i2).getMobile());
                    }
                    int errordigit = this.f60382d.get(i2).getErrordigit();
                    if (errordigit != -1 && errordigit < spannableString.length()) {
                        spannableString.setSpan(new ForegroundColorSpan(ResUtils.getColor(this.f60380b, "bd_wallet_fp_fix_character")), errordigit, errordigit + 1, 34);
                    }
                    bVar.f60384b.setText(spannableString);
                    bVar.f60385c.setText(this.f60382d.get(i2).getName());
                }
                return view;
            }
            return (View) invokeILL.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PhoneHistoryFixView f60383a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f60384b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f60385c;

        public b(PhoneHistoryFixView phoneHistoryFixView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {phoneHistoryFixView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f60383a = phoneHistoryFixView;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PhoneHistoryFixView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f60377j = false;
        a();
    }

    public void displayContactInfoData(List<ContractInfo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
            this.f60373f.setVisibility(8);
            this.f60374g.setVisibility(8);
            this.f60369b.setVisibility(8);
            this.f60370c.setVisibility(8);
            this.f60368a.setVisibility(8);
            this.f60372e.setVisibility(0);
            a(list);
        }
    }

    public void displayHistoryData(ArrayList<String> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, arrayList) == null) {
            displayHistoryData(a(arrayList));
        }
    }

    public ListView getmListView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f60371d : (ListView) invokeV.objValue;
    }

    public boolean isShow() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f60372e.isShown() : invokeV.booleanValue;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, view) == null) && view == this.f60374g) {
            if (this.f60373f.getVisibility() == 0) {
                setListViewState(false, false);
                return;
            }
            OnPhoneHistoryFixViewClickListener onPhoneHistoryFixViewClickListener = this.f60376i;
            if (onPhoneHistoryFixViewClickListener != null) {
                onPhoneHistoryFixViewClickListener.onFixViewClickClearHistory();
            }
            setListViewState(false, true);
        }
    }

    public void setInputNumberHasSpace(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.f60377j = z;
        }
    }

    public void setListViewState(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            this.f60372e.setVisibility(z ? 0 : 8);
            this.f60373f.setVisibility(z2 ? 8 : 0);
            this.f60368a.setVisibility(z2 ? 8 : 0);
            OnPhoneHistoryFixViewClickListener onPhoneHistoryFixViewClickListener = this.f60376i;
            if (onPhoneHistoryFixViewClickListener != null) {
                onPhoneHistoryFixViewClickListener.onFixViewDisplayHistoryViews(z);
            }
            if (z) {
                this.f60374g.setText(z2 ? ResUtils.getString(getContext(), "wallet_fp_history_clear") : ResUtils.getString(getContext(), "wallet_fp_fix_sure"));
            }
        }
    }

    public void setOnPhoneHistoryFixViewClickListener(OnPhoneHistoryFixViewClickListener onPhoneHistoryFixViewClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, onPhoneHistoryFixViewClickListener) == null) {
            this.f60376i = onPhoneHistoryFixViewClickListener;
        }
    }

    private void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this) == null) {
            LayoutInflater.from(getContext()).inflate(ResUtils.layout(getContext(), "wallet_base_mobile_phone_history_fix"), this);
            this.f60372e = (LinearLayout) findViewById(ResUtils.id(getContext(), "wallet_mobile_fix_layout"));
            TextView textView = (TextView) findViewById(ResUtils.id(getContext(), "wallet_mobile_fix_select"));
            this.f60374g = textView;
            textView.setOnClickListener(this);
            this.f60373f = (TextView) findViewById(ResUtils.id(getContext(), "wallet_mobile_fix_msg"));
            this.f60368a = findViewById(ResUtils.id(getContext(), "wallet_mobile_fix_line1"));
            this.f60369b = findViewById(ResUtils.id(getContext(), "wallet_mobile_divide_line1"));
            this.f60370c = findViewById(ResUtils.id(getContext(), "wallet_mobile_divide_line2"));
            this.f60371d = (ListView) findViewById(ResUtils.id(getContext(), "wallet_mobile_fix_list"));
            a aVar = new a(this, getContext());
            this.f60375h = aVar;
            this.f60371d.setAdapter((ListAdapter) aVar);
            this.f60371d.setOnItemClickListener(new AdapterView.OnItemClickListener(this) { // from class: com.baidu.wallet.base.widget.PhoneHistoryFixView.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ PhoneHistoryFixView f60378a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f60378a = this;
                }

                @Override // android.widget.AdapterView.OnItemClickListener
                public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                    b bVar;
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j2)}) == null) || view == null || (bVar = (b) view.getTag()) == null) {
                        return;
                    }
                    PhoneHistoryFixView phoneHistoryFixView = this.f60378a;
                    phoneHistoryFixView.setListViewState(false, phoneHistoryFixView.f60373f.getVisibility() != 0);
                    if (this.f60378a.f60376i != null) {
                        this.f60378a.f60376i.onFixViewClickListViewItemAndSetText(bVar.f60384b.getText().toString());
                    }
                }
            });
        }
    }

    public void displayHistoryData(List<ContractInfo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) {
            this.f60374g.setVisibility(0);
            this.f60369b.setVisibility(0);
            this.f60370c.setVisibility(0);
            a(list);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PhoneHistoryFixView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f60377j = false;
        a();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PhoneHistoryFixView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f60377j = false;
        a();
    }

    private void a(List<ContractInfo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, this, list) == null) {
            this.f60371d.setLayoutParams(new LinearLayout.LayoutParams(-1, list.size() > 2 ? DisplayUtils.dip2px(getContext(), 165.0f) : DisplayUtils.dip2px(getContext(), list.size() * 55)));
            this.f60375h.a(list);
            this.f60375h.notifyDataSetChanged();
            this.f60371d.setSelection(0);
        }
    }

    private List<ContractInfo> a(ArrayList<String> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, arrayList)) != null) {
            return (List) invokeL.objValue;
        }
        if (arrayList == null || arrayList.size() == 0) {
            return null;
        }
        ArrayList arrayList2 = new ArrayList();
        int i2 = 0;
        while (true) {
            if (i2 >= (arrayList.size() <= 5 ? arrayList.size() : 5)) {
                return arrayList2;
            }
            String str = arrayList.get(i2);
            if (str.length() > 13) {
                str = str.substring(0, 13);
            }
            arrayList2.add(new ContractInfo(str, PhoneContactsMananger.getInstance(DxmApplicationContextImpl.getApplicationContext(getContext())).getPayphoneInfo(str)));
            i2++;
        }
    }
}
