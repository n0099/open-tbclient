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
    public static final String f24626a = "PhoneContactsMananger";

    /* renamed from: b  reason: collision with root package name */
    public static PhoneContactsMananger f24627b;

    /* renamed from: c  reason: collision with root package name */
    public Context f24628c;

    /* renamed from: d  reason: collision with root package name */
    public c f24629d;

    /* renamed from: e  reason: collision with root package name */
    public d f24630e;

    /* renamed from: f  reason: collision with root package name */
    public ConcurrentHashMap<String, ContractInfo> f24631f = new ConcurrentHashMap<>();

    /* renamed from: g  reason: collision with root package name */
    public ConcurrentHashMap<String, ContractInfo> f24632g = new ConcurrentHashMap<>();

    /* renamed from: h  reason: collision with root package name */
    public ArrayList<ContractInfo> f24633h = new ArrayList<>();

    /* renamed from: i  reason: collision with root package name */
    public AtomicBoolean f24634i = new AtomicBoolean(false);
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
        void a(List<ContactSelectModel.AllContact> list, int i2);
    }

    public PhoneContactsMananger(Context context) {
        b(context);
    }

    private boolean b(Context context) {
        if (this.f24628c == null && context != null) {
            this.f24628c = context.getApplicationContext();
        }
        return this.f24628c != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        for (String str : this.f24631f.keySet()) {
            if (!this.f24633h.contains(this.f24631f.get(str))) {
                this.f24633h.add(this.f24631f.get(str));
            }
        }
        for (String str2 : this.f24632g.keySet()) {
            if (!this.f24633h.contains(this.f24632g.get(str2))) {
                this.f24633h.add(this.f24632g.get(str2));
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
                PhoneContactsMananger.this.k = PhoneContactsMananger.this.a(com.baidu.wallet.lightapp.base.contacts.a.c(PhoneContactsMananger.this.f24628c), intValue > 0 ? 1000 < intValue ? 1000 : intValue : 350);
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
            if (PhoneContactsMananger.this.f24630e == null) {
                return;
            }
            PhoneContactsMananger.this.f24630e.a(PhoneContactsMananger.this.k, PhoneContactsMananger.this.k == null ? 0 : PhoneContactsMananger.this.k.size());
        }
    }

    public static synchronized PhoneContactsMananger a(Context context) {
        PhoneContactsMananger phoneContactsMananger;
        synchronized (PhoneContactsMananger.class) {
            if (f24627b == null) {
                f24627b = new PhoneContactsMananger(context);
            }
            phoneContactsMananger = f24627b;
        }
        return phoneContactsMananger;
    }

    public void a(int i2, boolean z) {
        List<ContactSelectModel.AllContact> list;
        if (this.f24634i.getAndSet(true) && z) {
            if (this.f24630e == null || (list = this.k) == null || ContactStatus.complited != this.j) {
                return;
            }
            if (list.size() > i2) {
                this.f24630e.a(this.k.subList(0, i2), i2);
                return;
            } else {
                this.f24630e.a(this.k, i2);
                return;
            }
        }
        this.j = ContactStatus.unload;
        new a().execute(Integer.valueOf(i2));
    }

    /* loaded from: classes5.dex */
    public class b extends AsyncTask<String, String, String> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PhoneContactsMananger f24636a;

        /* renamed from: b  reason: collision with root package name */
        public ContactStatus f24637b;

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public String doInBackground(String... strArr) {
            this.f24637b = ContactStatus.loading;
            if (this.f24636a.f24631f.size() == 0) {
                PhoneContactsMananger phoneContactsMananger = this.f24636a;
                phoneContactsMananger.f24631f = com.baidu.wallet.lightapp.base.contacts.a.a(phoneContactsMananger.f24628c);
            }
            String str = PhoneContactsMananger.f24626a;
            LogUtil.d(str, "手机里面的通讯：" + this.f24636a.f24631f.toString());
            if (this.f24636a.f24632g.size() == 0) {
                PhoneContactsMananger phoneContactsMananger2 = this.f24636a;
                phoneContactsMananger2.f24632g = com.baidu.wallet.lightapp.base.contacts.a.b(phoneContactsMananger2.f24628c);
            }
            String str2 = PhoneContactsMananger.f24626a;
            LogUtil.d(str2, "Sim里面的通讯：" + this.f24636a.f24632g.toString());
            if (this.f24636a.f24633h == null || this.f24636a.f24633h.size() == 0) {
                this.f24636a.b();
            }
            String str3 = PhoneContactsMananger.f24626a;
            LogUtil.d(str3, "本地所有的通讯录信息：" + this.f24636a.f24633h.toString());
            this.f24637b = ContactStatus.complited;
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public void onPostExecute(String str) {
            if (this.f24636a.f24629d != null) {
                this.f24636a.f24629d.a(this.f24636a.f24633h);
            }
            super.onPostExecute(str);
        }
    }

    public void a(d dVar) {
        this.f24630e = dVar;
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
    public List<ContactSelectModel.AllContact> a(List<ContractInfo> list, int i2) {
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
        int i3 = 0;
        for (Map.Entry entry : hashMap.entrySet()) {
            int i4 = i3 + 1;
            if (i2 <= i3) {
                break;
            }
            arrayList.add(entry.getValue());
            i3 = i4;
        }
        return arrayList;
    }
}
