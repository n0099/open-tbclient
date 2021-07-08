package com.baidu.wallet.lightapp.business.presenter;

import android.app.Activity;
import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.view.View;
import com.android.internal.http.multipart.Part;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.eventbus.EventBus;
import com.baidu.apollon.statistics.PayStatisticsUtil;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.core.ContactManager;
import com.baidu.wallet.core.utils.StringUtils;
import com.baidu.wallet.lightapp.business.LightappBusinessClient;
import com.baidu.wallet.lightapp.business.datamodel.ContactInfo;
import com.baidu.wallet.lightapp.business.view.PhoneNumberSelectDialog;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class ContactInfoPresenter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Activity f25599a;

    /* renamed from: b  reason: collision with root package name */
    public LightappBusinessClient f25600b;

    /* renamed from: c  reason: collision with root package name */
    public int f25601c;

    /* renamed from: d  reason: collision with root package name */
    public String f25602d;

    public ContactInfoPresenter(Activity activity, LightappBusinessClient lightappBusinessClient) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity, lightappBusinessClient};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f25602d = "";
        this.f25599a = activity;
        this.f25600b = lightappBusinessClient;
        this.f25601c = a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            this.f25599a = null;
            this.f25600b = null;
        }
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? ResUtils.getString(this.f25599a, "wallet_base_select_phone_fail") : (String) invokeV.objValue;
    }

    public void onModuleEvent(EventBus.Event event) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, event) == null) && event != null && "read_contact".equals(event.mEventKey)) {
            String str = (String) event.mEventObj;
            LightappBusinessClient lightappBusinessClient = this.f25600b;
            if (lightappBusinessClient != null) {
                String[] strArr = {StringUtils.trimAll(this.f25602d), StringUtils.trimAll(str)};
                lightappBusinessClient.onContactsSelected("", 0, strArr, "", this.f25601c + "");
                c();
            }
        }
    }

    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.f25599a == null) {
                return 0;
            }
            return ContactManager.getIContactsImpl().countOfContacts(this.f25599a);
        }
        return invokeV.intValue;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE] complete} */
    public void a(Uri uri) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, uri) == null) {
            ArrayList arrayList = new ArrayList();
            Activity activity = this.f25599a;
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
                        this.f25602d = cursor.getString(cursor.getColumnIndex("display_name"));
                        int i2 = cursor.getInt(cursor.getColumnIndex("data2"));
                        ContactInfo.Phone phone = new ContactInfo.Phone();
                        phone.number = string;
                        phone.type = i2;
                        arrayList.add(phone);
                    }
                    a(this.f25602d, arrayList);
                    if (cursor == null) {
                        return;
                    }
                } catch (Exception e2) {
                    PayStatisticsUtil.onEventWithValue("read_contact_exception", a(e2));
                    if (this.f25600b != null) {
                        LightappBusinessClient lightappBusinessClient = this.f25600b;
                        String b2 = b();
                        lightappBusinessClient.onContactsSelected("", 1, null, b2, this.f25601c + "");
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

    public String a(Exception exc) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, exc)) == null) {
            String str = "";
            if (exc == null) {
                return "";
            }
            for (StackTraceElement stackTraceElement : exc.getStackTrace()) {
                str = str + "\tat " + stackTraceElement + Part.CRLF;
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    private void a(String str, List<ContactInfo.Phone> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, this, str, list) == null) {
            PhoneNumberSelectDialog phoneNumberSelectDialog = new PhoneNumberSelectDialog(this.f25599a);
            if (list != null && list.size() != 0) {
                if (list.size() == 1) {
                    LightappBusinessClient lightappBusinessClient = this.f25600b;
                    if (lightappBusinessClient != null) {
                        String[] strArr = {StringUtils.trimAll(str), StringUtils.trimAll(list.get(0).number)};
                        lightappBusinessClient.onContactsSelected("", 0, strArr, "", this.f25601c + "");
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
                    public final /* synthetic */ PhoneNumberSelectDialog f25603a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ ContactInfoPresenter f25604b;

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
                        this.f25604b = this;
                        this.f25603a = phoneNumberSelectDialog;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                            this.f25603a.dismiss();
                            this.f25604b.c();
                        }
                    }
                });
                phoneNumberSelectDialog.hidePositiveButton();
                phoneNumberSelectDialog.show();
                return;
            }
            LightappBusinessClient lightappBusinessClient2 = this.f25600b;
            if (lightappBusinessClient2 != null) {
                String b2 = b();
                lightappBusinessClient2.onContactsSelected("", 1, null, b2, this.f25601c + "");
            }
            c();
        }
    }
}
