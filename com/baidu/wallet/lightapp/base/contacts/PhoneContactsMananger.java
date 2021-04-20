package com.baidu.wallet.lightapp.base.contacts;

import android.content.Context;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.baidu.apollon.utils.LogUtil;
import com.baidu.wallet.core.utils.contacts.ContactSelectModel;
import com.baidu.wallet.core.utils.contacts.ContractInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes5.dex */
public class PhoneContactsMananger {

    /* renamed from: a  reason: collision with root package name */
    public static final String f24582a = "PhoneContactsMananger";

    /* renamed from: b  reason: collision with root package name */
    public static PhoneContactsMananger f24583b;

    /* renamed from: c  reason: collision with root package name */
    public Context f24584c;

    /* renamed from: d  reason: collision with root package name */
    public c f24585d;

    /* renamed from: e  reason: collision with root package name */
    public d f24586e;

    /* renamed from: f  reason: collision with root package name */
    public ConcurrentHashMap<String, ContractInfo> f24587f = new ConcurrentHashMap<>();

    /* renamed from: g  reason: collision with root package name */
    public ConcurrentHashMap<String, ContractInfo> f24588g = new ConcurrentHashMap<>();

    /* renamed from: h  reason: collision with root package name */
    public ArrayList<ContractInfo> f24589h = new ArrayList<>();
    public AtomicBoolean i = new AtomicBoolean(false);
    public ContactStatus j = ContactStatus.unload;
    public List<ContactSelectModel.AllContact> k = null;
    public b l = null;

    /* loaded from: classes5.dex */
    public enum ContactStatus {
        unload,
        loading,
        complited
    }

    /* loaded from: classes5.dex */
    public interface c {
        void a(ArrayList<ContractInfo> arrayList);
    }

    /* loaded from: classes5.dex */
    public interface d {
        void a(List<ContactSelectModel.AllContact> list, int i);
    }

    public PhoneContactsMananger(Context context) {
        b(context);
    }

    private boolean b(Context context) {
        if (this.f24584c == null && context != null) {
            this.f24584c = context.getApplicationContext();
        }
        return this.f24584c != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        for (String str : this.f24587f.keySet()) {
            if (!this.f24589h.contains(this.f24587f.get(str))) {
                this.f24589h.add(this.f24587f.get(str));
            }
        }
        for (String str2 : this.f24588g.keySet()) {
            if (!this.f24589h.contains(this.f24588g.get(str2))) {
                this.f24589h.add(this.f24588g.get(str2));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class a extends AsyncTask<Integer, Void, List<ContactSelectModel.AllContact>> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public List<ContactSelectModel.AllContact> doInBackground(Integer... numArr) {
            PhoneContactsMananger.this.j = ContactStatus.loading;
            int intValue = (numArr == null || 1 > numArr.length) ? 350 : numArr[0].intValue();
            try {
                PhoneContactsMananger.this.k = PhoneContactsMananger.this.a(com.baidu.wallet.lightapp.base.contacts.a.c(PhoneContactsMananger.this.f24584c), intValue > 0 ? 1000 < intValue ? 1000 : intValue : 350);
            } catch (Throwable unused) {
                PhoneContactsMananger.this.k = null;
            }
            PhoneContactsMananger.this.j = ContactStatus.complited;
            return PhoneContactsMananger.this.k;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public void onPostExecute(List<ContactSelectModel.AllContact> list) {
            if (PhoneContactsMananger.this.f24586e == null) {
                return;
            }
            PhoneContactsMananger.this.f24586e.a(PhoneContactsMananger.this.k, PhoneContactsMananger.this.k == null ? 0 : PhoneContactsMananger.this.k.size());
        }
    }

    public static synchronized PhoneContactsMananger a(Context context) {
        PhoneContactsMananger phoneContactsMananger;
        synchronized (PhoneContactsMananger.class) {
            if (f24583b == null) {
                f24583b = new PhoneContactsMananger(context);
            }
            phoneContactsMananger = f24583b;
        }
        return phoneContactsMananger;
    }

    public void a(int i, boolean z) {
        List<ContactSelectModel.AllContact> list;
        if (this.i.getAndSet(true) && z) {
            if (this.f24586e == null || (list = this.k) == null || ContactStatus.complited != this.j) {
                return;
            }
            if (list.size() > i) {
                this.f24586e.a(this.k.subList(0, i), i);
                return;
            } else {
                this.f24586e.a(this.k, i);
                return;
            }
        }
        this.j = ContactStatus.unload;
        new a().execute(Integer.valueOf(i));
    }

    /* loaded from: classes5.dex */
    public class b extends AsyncTask<String, String, String> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PhoneContactsMananger f24591a;

        /* renamed from: b  reason: collision with root package name */
        public ContactStatus f24592b;

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public String doInBackground(String... strArr) {
            this.f24592b = ContactStatus.loading;
            if (this.f24591a.f24587f.size() == 0) {
                PhoneContactsMananger phoneContactsMananger = this.f24591a;
                phoneContactsMananger.f24587f = com.baidu.wallet.lightapp.base.contacts.a.a(phoneContactsMananger.f24584c);
            }
            String str = PhoneContactsMananger.f24582a;
            LogUtil.d(str, "手机里面的通讯：" + this.f24591a.f24587f.toString());
            if (this.f24591a.f24588g.size() == 0) {
                PhoneContactsMananger phoneContactsMananger2 = this.f24591a;
                phoneContactsMananger2.f24588g = com.baidu.wallet.lightapp.base.contacts.a.b(phoneContactsMananger2.f24584c);
            }
            String str2 = PhoneContactsMananger.f24582a;
            LogUtil.d(str2, "Sim里面的通讯：" + this.f24591a.f24588g.toString());
            if (this.f24591a.f24589h == null || this.f24591a.f24589h.size() == 0) {
                this.f24591a.b();
            }
            String str3 = PhoneContactsMananger.f24582a;
            LogUtil.d(str3, "本地所有的通讯录信息：" + this.f24591a.f24589h.toString());
            this.f24592b = ContactStatus.complited;
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public void onPostExecute(String str) {
            if (this.f24591a.f24585d != null) {
                this.f24591a.f24585d.a(this.f24591a.f24589h);
            }
            super.onPostExecute(str);
        }
    }

    public void a(d dVar) {
        this.f24586e = dVar;
    }

    private ContactSelectModel.AllContact a(String str, String str2) {
        if (str == null || TextUtils.isEmpty(str2)) {
            return null;
        }
        ContactSelectModel.PhoneNumberUnit phoneNumberUnit = new ContactSelectModel.PhoneNumberUnit();
        phoneNumberUnit.num = str2;
        ArrayList arrayList = new ArrayList();
        arrayList.add(phoneNumberUnit);
        ContactSelectModel.AllContact allContact = new ContactSelectModel.AllContact();
        allContact.setName(str);
        allContact.setList(arrayList);
        return allContact;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<ContactSelectModel.AllContact> a(List<ContractInfo> list, int i) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        HashMap hashMap = new HashMap();
        for (ContractInfo contractInfo : list) {
            if (contractInfo != null) {
                String name = contractInfo.getName();
                String mobile = contractInfo.getMobile();
                if (name != null) {
                    ContactSelectModel.AllContact allContact = (ContactSelectModel.AllContact) hashMap.get(name);
                    if (allContact == null) {
                        ContactSelectModel.AllContact a2 = a(name, mobile);
                        if (a2 != null) {
                            hashMap.put(name, a2);
                        }
                    } else {
                        ContactSelectModel.PhoneNumberUnit phoneNumberUnit = new ContactSelectModel.PhoneNumberUnit();
                        phoneNumberUnit.num = mobile;
                        allContact.getList().add(phoneNumberUnit);
                    }
                }
            }
        }
        if (hashMap.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        for (Map.Entry entry : hashMap.entrySet()) {
            int i3 = i2 + 1;
            if (i <= i2) {
                break;
            }
            arrayList.add(entry.getValue());
            i2 = i3;
        }
        return arrayList;
    }
}
