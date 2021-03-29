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
    public static final String f24897a = "PhoneContactsMananger";

    /* renamed from: b  reason: collision with root package name */
    public static PhoneContactsMananger f24898b;

    /* renamed from: c  reason: collision with root package name */
    public Context f24899c;

    /* renamed from: d  reason: collision with root package name */
    public c f24900d;

    /* renamed from: e  reason: collision with root package name */
    public d f24901e;

    /* renamed from: f  reason: collision with root package name */
    public ConcurrentHashMap<String, ContractInfo> f24902f = new ConcurrentHashMap<>();

    /* renamed from: g  reason: collision with root package name */
    public ConcurrentHashMap<String, ContractInfo> f24903g = new ConcurrentHashMap<>();

    /* renamed from: h  reason: collision with root package name */
    public ArrayList<ContractInfo> f24904h = new ArrayList<>();
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
        if (this.f24899c == null && context != null) {
            this.f24899c = context.getApplicationContext();
        }
        return this.f24899c != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        for (String str : this.f24902f.keySet()) {
            if (!this.f24904h.contains(this.f24902f.get(str))) {
                this.f24904h.add(this.f24902f.get(str));
            }
        }
        for (String str2 : this.f24903g.keySet()) {
            if (!this.f24904h.contains(this.f24903g.get(str2))) {
                this.f24904h.add(this.f24903g.get(str2));
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
                PhoneContactsMananger.this.k = PhoneContactsMananger.this.a(com.baidu.wallet.lightapp.base.contacts.a.c(PhoneContactsMananger.this.f24899c), intValue > 0 ? 1000 < intValue ? 1000 : intValue : 350);
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
            if (PhoneContactsMananger.this.f24901e == null) {
                return;
            }
            PhoneContactsMananger.this.f24901e.a(PhoneContactsMananger.this.k, PhoneContactsMananger.this.k == null ? 0 : PhoneContactsMananger.this.k.size());
        }
    }

    public static synchronized PhoneContactsMananger a(Context context) {
        PhoneContactsMananger phoneContactsMananger;
        synchronized (PhoneContactsMananger.class) {
            if (f24898b == null) {
                f24898b = new PhoneContactsMananger(context);
            }
            phoneContactsMananger = f24898b;
        }
        return phoneContactsMananger;
    }

    public void a(int i, boolean z) {
        List<ContactSelectModel.AllContact> list;
        if (this.i.getAndSet(true) && z) {
            if (this.f24901e == null || (list = this.k) == null || ContactStatus.complited != this.j) {
                return;
            }
            if (list.size() > i) {
                this.f24901e.a(this.k.subList(0, i), i);
                return;
            } else {
                this.f24901e.a(this.k, i);
                return;
            }
        }
        this.j = ContactStatus.unload;
        new a().execute(Integer.valueOf(i));
    }

    /* loaded from: classes5.dex */
    public class b extends AsyncTask<String, String, String> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PhoneContactsMananger f24906a;

        /* renamed from: b  reason: collision with root package name */
        public ContactStatus f24907b;

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public String doInBackground(String... strArr) {
            this.f24907b = ContactStatus.loading;
            if (this.f24906a.f24902f.size() == 0) {
                PhoneContactsMananger phoneContactsMananger = this.f24906a;
                phoneContactsMananger.f24902f = com.baidu.wallet.lightapp.base.contacts.a.a(phoneContactsMananger.f24899c);
            }
            String str = PhoneContactsMananger.f24897a;
            LogUtil.d(str, "手机里面的通讯：" + this.f24906a.f24902f.toString());
            if (this.f24906a.f24903g.size() == 0) {
                PhoneContactsMananger phoneContactsMananger2 = this.f24906a;
                phoneContactsMananger2.f24903g = com.baidu.wallet.lightapp.base.contacts.a.b(phoneContactsMananger2.f24899c);
            }
            String str2 = PhoneContactsMananger.f24897a;
            LogUtil.d(str2, "Sim里面的通讯：" + this.f24906a.f24903g.toString());
            if (this.f24906a.f24904h == null || this.f24906a.f24904h.size() == 0) {
                this.f24906a.b();
            }
            String str3 = PhoneContactsMananger.f24897a;
            LogUtil.d(str3, "本地所有的通讯录信息：" + this.f24906a.f24904h.toString());
            this.f24907b = ContactStatus.complited;
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public void onPostExecute(String str) {
            if (this.f24906a.f24900d != null) {
                this.f24906a.f24900d.a(this.f24906a.f24904h);
            }
            super.onPostExecute(str);
        }
    }

    public void a(d dVar) {
        this.f24901e = dVar;
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
