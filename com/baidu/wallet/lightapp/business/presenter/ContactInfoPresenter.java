package com.baidu.wallet.lightapp.business.presenter;

import android.app.Activity;
import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.eventbus.EventBus;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.core.ContactManager;
import com.baidu.wallet.core.utils.StringUtils;
import com.baidu.wallet.lightapp.business.datamodel.ContactInfo;
import com.baidu.wallet.lightapp.business.view.PhoneNumberSelectDialog;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public class ContactInfoPresenter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Activity f59980a;

    /* renamed from: b  reason: collision with root package name */
    public b f59981b;

    /* renamed from: c  reason: collision with root package name */
    public int f59982c;

    /* renamed from: d  reason: collision with root package name */
    public String f59983d;

    public ContactInfoPresenter(Activity activity, b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity, bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f59983d = "";
        this.f59980a = activity;
        this.f59981b = bVar;
        this.f59982c = a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            this.f59980a = null;
            this.f59981b = null;
        }
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? ResUtils.getString(this.f59980a, "wallet_base_select_phone_fail") : (String) invokeV.objValue;
    }

    public void onModuleEvent(EventBus.Event event) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, event) == null) && event != null && "read_contact".equals(event.mEventKey)) {
            String str = (String) event.mEventObj;
            b bVar = this.f59981b;
            if (bVar != null) {
                String[] strArr = {StringUtils.trimAll(this.f59983d), StringUtils.trimAll(str)};
                bVar.onContactsSelected("", 0, strArr, "", this.f59982c + "");
                c();
            }
        }
    }

    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.f59980a == null) {
                return 0;
            }
            return ContactManager.getIContactsImpl().countOfContacts(this.f59980a);
        }
        return invokeV.intValue;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE] complete} */
    public void a(Uri uri) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, uri) == null) {
            ArrayList arrayList = new ArrayList();
            Activity activity = this.f59980a;
            if (activity == null) {
                c();
                return;
            }
            ContentResolver contentResolver = activity.getContentResolver();
            Cursor cursor = null;
            try {
                try {
                    cursor = contentResolver.query(uri, new String[]{"data1", "display_name", "data2"}, null, null, null);
                    if (cursor != null && cursor.moveToFirst()) {
                        String string = cursor.getString(cursor.getColumnIndex("data1"));
                        this.f59983d = cursor.getString(cursor.getColumnIndex("display_name"));
                        int i2 = cursor.getInt(cursor.getColumnIndex("data2"));
                        ContactInfo.Phone phone = new ContactInfo.Phone();
                        phone.number = string;
                        phone.type = i2;
                        arrayList.add(phone);
                    }
                    a(this.f59983d, arrayList);
                    if (cursor == null) {
                        return;
                    }
                } catch (Exception unused) {
                    if (this.f59981b != null) {
                        b bVar = this.f59981b;
                        String b2 = b();
                        bVar.onContactsSelected("", 1, null, b2, this.f59982c + "");
                    }
                    c();
                    if (cursor == null) {
                        return;
                    }
                }
                cursor.close();
            } catch (Throwable th) {
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
        }
    }

    private void a(String str, List<ContactInfo.Phone> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, this, str, list) == null) {
            PhoneNumberSelectDialog phoneNumberSelectDialog = new PhoneNumberSelectDialog(this.f59980a);
            if (list != null && list.size() != 0) {
                if (list.size() == 1) {
                    b bVar = this.f59981b;
                    if (bVar != null) {
                        String[] strArr = {StringUtils.trimAll(str), StringUtils.trimAll(list.get(0).number)};
                        bVar.onContactsSelected("", 0, strArr, "", this.f59982c + "");
                    }
                    c();
                    return;
                }
                phoneNumberSelectDialog.setPhones(list);
                EventBus.getInstance().register(this, "read_contact", 0, EventBus.ThreadMode.MainThread);
                phoneNumberSelectDialog.setNegativeBtn(new View.OnClickListener(this, phoneNumberSelectDialog) { // from class: com.baidu.wallet.lightapp.business.presenter.ContactInfoPresenter.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ PhoneNumberSelectDialog f59984a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ ContactInfoPresenter f59985b;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, phoneNumberSelectDialog};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f59985b = this;
                        this.f59984a = phoneNumberSelectDialog;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                            this.f59984a.dismiss();
                            this.f59985b.c();
                        }
                    }
                });
                phoneNumberSelectDialog.hidePositiveButton();
                phoneNumberSelectDialog.show();
                return;
            }
            b bVar2 = this.f59981b;
            if (bVar2 != null) {
                String b2 = b();
                bVar2.onContactsSelected("", 1, null, b2, this.f59982c + "");
            }
            c();
        }
    }
}
