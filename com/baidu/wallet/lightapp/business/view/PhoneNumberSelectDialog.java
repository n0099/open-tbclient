package com.baidu.wallet.lightapp.business.view;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.eventbus.EventBus;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.base.widget.BaseDialog;
import com.baidu.wallet.lightapp.business.datamodel.ContactInfo;
import com.baidu.webkit.sdk.dumper.ZeusCrashHandler;
import java.util.List;
/* loaded from: classes12.dex */
public class PhoneNumberSelectDialog extends BaseDialog {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ListView a;

    /* renamed from: b  reason: collision with root package name */
    public Context f53087b;

    /* renamed from: c  reason: collision with root package name */
    public a f53088c;

    /* renamed from: d  reason: collision with root package name */
    public List<ContactInfo.Phone> f53089d;

    /* loaded from: classes12.dex */
    public class a extends BaseAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PhoneNumberSelectDialog a;

        public a(PhoneNumberSelectDialog phoneNumberSelectDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {phoneNumberSelectDialog};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = phoneNumberSelectDialog;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (this.a.f53089d == null) {
                    return 0;
                }
                return this.a.f53089d.size();
            }
            return invokeV.intValue;
        }

        @Override // android.widget.Adapter
        public Object getItem(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) ? this.a.f53089d.get(i2) : invokeI.objValue;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) ? i2 : invokeI.longValue;
        }

        @Override // android.widget.Adapter
        public View getView(int i2, View view, ViewGroup viewGroup) {
            InterceptResult invokeILL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeILL = interceptable.invokeILL(1048579, this, i2, view, viewGroup)) == null) {
                View inflate = LayoutInflater.from(this.a.f53087b).inflate(ResUtils.layout(this.a.f53087b, "wallet_langbridge_contact_phone_item"), (ViewGroup) null);
                TextView textView = (TextView) inflate.findViewById(ResUtils.id(this.a.f53087b, "wallet_base_type"));
                textView.setText(((ContactInfo.Phone) this.a.f53089d.get(i2)).getTypeName() + ZeusCrashHandler.NAME_SEPERATOR + ((ContactInfo.Phone) this.a.f53089d.get(i2)).number);
                textView.setOnClickListener(new View.OnClickListener(this, i2) { // from class: com.baidu.wallet.lightapp.business.view.PhoneNumberSelectDialog.a.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ int a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ a f53090b;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, Integer.valueOf(i2)};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i3 = newInitContext.flag;
                            if ((i3 & 1) != 0) {
                                int i4 = i3 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f53090b = this;
                        this.a = i2;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                            EventBus eventBus = EventBus.getInstance();
                            EventBus eventBus2 = EventBus.getInstance();
                            eventBus2.getClass();
                            eventBus.post(new EventBus.Event(eventBus2, "read_contact", ((ContactInfo.Phone) this.f53090b.a.f53089d.get(this.a)).number));
                            this.f53090b.a.dismiss();
                        }
                    }
                });
                return inflate;
            }
            return (View) invokeILL.objValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PhoneNumberSelectDialog(Context context) {
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
        this.f53087b = context;
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.onBackPressed();
            dismiss();
        }
    }

    @Override // com.baidu.wallet.base.widget.BaseDialog, android.app.Dialog
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
            super.onCreate(bundle);
            View inflate = LayoutInflater.from(this.f53087b).inflate(ResUtils.layout(this.f53087b, "wallet_langbridge_contact_phone"), (ViewGroup) null);
            this.a = (ListView) inflate.findViewById(ResUtils.id(this.f53087b, "wallet_base_lv"));
            a aVar = new a(this);
            this.f53088c = aVar;
            this.a.setAdapter((ListAdapter) aVar);
            addContentView(inflate);
            getNegativeBtn().setTextColor(this.f53087b.getResources().getColor(ResUtils.color(this.f53087b, "wallet_base_mainColor")));
            showCloseBtn(false);
            setTitleText(ResUtils.string(this.f53087b, "wallet_lightapp_contact_please_select_phone"));
            hidePositiveButton();
        }
    }

    public void setPhones(List<ContactInfo.Phone> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) {
            this.f53089d = list;
        }
    }
}
