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
    public static final String f24708a = "PhoneContactsMananger";

    /* renamed from: b  reason: collision with root package name */
    public static PhoneContactsMananger f24709b;

    /* renamed from: c  reason: collision with root package name */
    public Context f24710c;

    /* renamed from: d  reason: collision with root package name */
    public c f24711d;

    /* renamed from: e  reason: collision with root package name */
    public d f24712e;

    /* renamed from: f  reason: collision with root package name */
    public ConcurrentHashMap<String, ContractInfo> f24713f = new ConcurrentHashMap<>();

    /* renamed from: g  reason: collision with root package name */
    public ConcurrentHashMap<String, ContractInfo> f24714g = new ConcurrentHashMap<>();

    /* renamed from: h  reason: collision with root package name */
    public ArrayList<ContractInfo> f24715h = new ArrayList<>();

    /* renamed from: i  reason: collision with root package name */
    public AtomicBoolean f24716i = new AtomicBoolean(false);
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
        if (this.f24710c == null && context != null) {
            this.f24710c = context.getApplicationContext();
        }
        return this.f24710c != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        for (String str : this.f24713f.keySet()) {
            if (!this.f24715h.contains(this.f24713f.get(str))) {
                this.f24715h.add(this.f24713f.get(str));
            }
        }
        for (String str2 : this.f24714g.keySet()) {
            if (!this.f24715h.contains(this.f24714g.get(str2))) {
                this.f24715h.add(this.f24714g.get(str2));
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
                PhoneContactsMananger.this.k = PhoneContactsMananger.this.a(com.baidu.wallet.lightapp.base.contacts.a.c(PhoneContactsMananger.this.f24710c), intValue > 0 ? 1000 < intValue ? 1000 : intValue : 350);
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
            if (PhoneContactsMananger.this.f24712e == null) {
                return;
            }
            PhoneContactsMananger.this.f24712e.a(PhoneContactsMananger.this.k, PhoneContactsMananger.this.k == null ? 0 : PhoneContactsMananger.this.k.size());
        }
    }

    public static synchronized PhoneContactsMananger a(Context context) {
        PhoneContactsMananger phoneContactsMananger;
        synchronized (PhoneContactsMananger.class) {
            if (f24709b == null) {
                f24709b = new PhoneContactsMananger(context);
            }
            phoneContactsMananger = f24709b;
        }
        return phoneContactsMananger;
    }

    public void a(int i2, boolean z) {
        List<ContactSelectModel.AllContact> list;
        if (this.f24716i.getAndSet(true) && z) {
            if (this.f24712e == null || (list = this.k) == null || ContactStatus.complited != this.j) {
                return;
            }
            if (list.size() > i2) {
                this.f24712e.a(this.k.subList(0, i2), i2);
                return;
            } else {
                this.f24712e.a(this.k, i2);
                return;
            }
        }
        this.j = ContactStatus.unload;
        new a().execute(Integer.valueOf(i2));
    }

    /* loaded from: classes5.dex */
    public class b extends AsyncTask<String, String, String> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PhoneContactsMananger f24718a;

        /* renamed from: b  reason: collision with root package name */
        public ContactStatus f24719b;

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public String doInBackground(String... strArr) {
            this.f24719b = ContactStatus.loading;
            if (this.f24718a.f24713f.size() == 0) {
                PhoneContactsMananger phoneContactsMananger = this.f24718a;
                phoneContactsMananger.f24713f = com.baidu.wallet.lightapp.base.contacts.a.a(phoneContactsMananger.f24710c);
            }
            String str = PhoneContactsMananger.f24708a;
            LogUtil.d(str, "手机里面的通讯：" + this.f24718a.f24713f.toString());
            if (this.f24718a.f24714g.size() == 0) {
                PhoneContactsMananger phoneContactsMananger2 = this.f24718a;
                phoneContactsMananger2.f24714g = com.baidu.wallet.lightapp.base.contacts.a.b(phoneContactsMananger2.f24710c);
            }
            String str2 = PhoneContactsMananger.f24708a;
            LogUtil.d(str2, "Sim里面的通讯：" + this.f24718a.f24714g.toString());
            if (this.f24718a.f24715h == null || this.f24718a.f24715h.size() == 0) {
                this.f24718a.b();
            }
            String str3 = PhoneContactsMananger.f24708a;
            LogUtil.d(str3, "本地所有的通讯录信息：" + this.f24718a.f24715h.toString());
            this.f24719b = ContactStatus.complited;
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public void onPostExecute(String str) {
            if (this.f24718a.f24711d != null) {
                this.f24718a.f24711d.a(this.f24718a.f24715h);
            }
            super.onPostExecute(str);
        }
    }

    public void a(d dVar) {
        this.f24712e = dVar;
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
