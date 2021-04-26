package com.baidu.wallet.lightapp.business.presenter;

import android.app.Activity;
import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.view.View;
import com.android.internal.http.multipart.Part;
import com.baidu.apollon.eventbus.EventBus;
import com.baidu.apollon.statistics.PayStatisticsUtil;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.wallet.core.ContactManager;
import com.baidu.wallet.core.utils.StringUtils;
import com.baidu.wallet.lightapp.business.LightappBusinessClient;
import com.baidu.wallet.lightapp.business.datamodel.ContactInfo;
import com.baidu.wallet.lightapp.business.view.PhoneNumberSelectDialog;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class ContactInfoPresenter {

    /* renamed from: a  reason: collision with root package name */
    public Activity f25587a;

    /* renamed from: b  reason: collision with root package name */
    public LightappBusinessClient f25588b;

    /* renamed from: d  reason: collision with root package name */
    public String f25590d = "";

    /* renamed from: c  reason: collision with root package name */
    public int f25589c = a();

    public ContactInfoPresenter(Activity activity, LightappBusinessClient lightappBusinessClient) {
        this.f25587a = activity;
        this.f25588b = lightappBusinessClient;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        this.f25587a = null;
        this.f25588b = null;
    }

    public String b() {
        return ResUtils.getString(this.f25587a, "wallet_base_select_phone_fail");
    }

    public void onModuleEvent(EventBus.Event event) {
        if (event == null || !"read_contact".equals(event.mEventKey)) {
            return;
        }
        String str = (String) event.mEventObj;
        LightappBusinessClient lightappBusinessClient = this.f25588b;
        if (lightappBusinessClient != null) {
            String[] strArr = {StringUtils.trimAll(this.f25590d), StringUtils.trimAll(str)};
            lightappBusinessClient.onContactsSelected("", 0, strArr, "", this.f25589c + "");
            c();
        }
    }

    public int a() {
        if (this.f25587a == null) {
            return 0;
        }
        return ContactManager.getIContactsImpl().countOfContacts(this.f25587a);
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE] complete} */
    public void a(Uri uri) {
        ArrayList arrayList = new ArrayList();
        Activity activity = this.f25587a;
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
                    this.f25590d = cursor.getString(cursor.getColumnIndex("display_name"));
                    int i2 = cursor.getInt(cursor.getColumnIndex("data2"));
                    ContactInfo.Phone phone = new ContactInfo.Phone();
                    phone.number = string;
                    phone.type = i2;
                    arrayList.add(phone);
                }
                a(this.f25590d, arrayList);
                if (cursor == null) {
                    return;
                }
            } catch (Exception e2) {
                PayStatisticsUtil.onEventWithValue("read_contact_exception", a(e2));
                if (this.f25588b != null) {
                    LightappBusinessClient lightappBusinessClient = this.f25588b;
                    String b2 = b();
                    lightappBusinessClient.onContactsSelected("", 1, null, b2, this.f25589c + "");
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

    public String a(Exception exc) {
        String str = "";
        if (exc == null) {
            return "";
        }
        for (StackTraceElement stackTraceElement : exc.getStackTrace()) {
            str = str + "\tat " + stackTraceElement + Part.CRLF;
        }
        return str;
    }

    private void a(String str, List<ContactInfo.Phone> list) {
        final PhoneNumberSelectDialog phoneNumberSelectDialog = new PhoneNumberSelectDialog(this.f25587a);
        if (list != null && list.size() != 0) {
            if (list.size() == 1) {
                LightappBusinessClient lightappBusinessClient = this.f25588b;
                if (lightappBusinessClient != null) {
                    String[] strArr = {StringUtils.trimAll(str), StringUtils.trimAll(list.get(0).number)};
                    lightappBusinessClient.onContactsSelected("", 0, strArr, "", this.f25589c + "");
                }
                c();
                return;
            }
            phoneNumberSelectDialog.setPhones(list);
            EventBus.getInstance().register(this, "read_contact", 0, EventBus.ThreadMode.MainThread);
            phoneNumberSelectDialog.setNegativeBtn(new View.OnClickListener() { // from class: com.baidu.wallet.lightapp.business.presenter.ContactInfoPresenter.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    phoneNumberSelectDialog.dismiss();
                    ContactInfoPresenter.this.c();
                }
            });
            phoneNumberSelectDialog.hidePositiveButton();
            phoneNumberSelectDialog.show();
            return;
        }
        LightappBusinessClient lightappBusinessClient2 = this.f25588b;
        if (lightappBusinessClient2 != null) {
            String b2 = b();
            lightappBusinessClient2.onContactsSelected("", 1, null, b2, this.f25589c + "");
        }
        c();
    }
}
