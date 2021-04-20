package com.baidu.wallet.core.utils.contacts;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.baidu.wallet.core.utils.LogUtil;
import com.baidu.wallet.core.utils.StringUtils;
import com.baidu.wallet.core.utils.contacts.ContactSelectModel;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
@SuppressLint({"StaticFieldLeak"})
/* loaded from: classes5.dex */
public class PhoneContactsMananger {

    /* renamed from: a  reason: collision with root package name */
    public static final String f24017a = "PhoneContactsMananger";

    /* renamed from: b  reason: collision with root package name */
    public static PhoneContactsMananger f24018b;

    /* renamed from: c  reason: collision with root package name */
    public Context f24019c;

    /* renamed from: d  reason: collision with root package name */
    public ConcurrentHashMap<String, ContractInfo> f24020d = new ConcurrentHashMap<>();

    /* renamed from: e  reason: collision with root package name */
    public ConcurrentHashMap<String, ContractInfo> f24021e = new ConcurrentHashMap<>();

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<ContractInfo> f24022f = new ArrayList<>();

    /* renamed from: g  reason: collision with root package name */
    public b f24023g = null;

    /* renamed from: com.baidu.wallet.core.utils.contacts.PhoneContactsMananger$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f24024a;

        static {
            int[] iArr = new int[ContactStatus.values().length];
            f24024a = iArr;
            try {
                iArr[ContactStatus.unload.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f24024a[ContactStatus.loading.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f24024a[ContactStatus.complited.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public enum ContactStatus {
        unload,
        loading,
        complited
    }

    /* loaded from: classes5.dex */
    public interface LoadAddressInfoComplitedListener {
        void onLoadContractsComplited(ArrayList<ContractInfo> arrayList);
    }

    /* loaded from: classes5.dex */
    public interface LoadAddressInfoListener {
        void onFixPhoneList(String str, List<ContractInfo> list);

        void onLoadFastPayPhoneInfo(String str, ContractInfo contractInfo);
    }

    /* loaded from: classes5.dex */
    public interface LoadAllContactListener {
        void onLoadSuccess(List<ContactSelectModel.AllContact> list, int i);
    }

    /* loaded from: classes5.dex */
    public class a extends AsyncTask<String, String, String> {

        /* renamed from: b  reason: collision with root package name */
        public int f24026b;

        /* renamed from: c  reason: collision with root package name */
        public ArrayList<ContactSelectModel.AllContact> f24027c = new ArrayList<>();

        /* renamed from: d  reason: collision with root package name */
        public LoadAllContactListener f24028d;

        public a() {
        }

        public int a() {
            return this.f24026b;
        }

        public void a(int i, LoadAllContactListener loadAllContactListener) {
            this.f24026b = i;
            this.f24028d = loadAllContactListener;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public String doInBackground(String... strArr) {
            try {
                List<ContractInfo> allPhone = AddressUtils.getAllPhone(PhoneContactsMananger.this.f24019c);
                ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
                for (int i = 0; i < allPhone.size(); i++) {
                    String name = allPhone.get(i).getName();
                    if (concurrentHashMap.containsKey(name)) {
                        ContactSelectModel.AllContact allContact = (ContactSelectModel.AllContact) concurrentHashMap.get(name);
                        if (allContact != null) {
                            ContactSelectModel.PhoneNumberUnit phoneNumberUnit = new ContactSelectModel.PhoneNumberUnit();
                            phoneNumberUnit.num = allPhone.get(i).getMobile();
                            allContact.getList().add(phoneNumberUnit);
                            concurrentHashMap.put(name, allContact);
                        } else {
                            ContactSelectModel.AllContact allContact2 = new ContactSelectModel.AllContact();
                            allContact2.setName(name);
                            ArrayList arrayList = new ArrayList();
                            ContactSelectModel.PhoneNumberUnit phoneNumberUnit2 = new ContactSelectModel.PhoneNumberUnit();
                            phoneNumberUnit2.num = allPhone.get(i).getMobile();
                            arrayList.add(phoneNumberUnit2);
                            allContact2.setList(arrayList);
                            concurrentHashMap.put(name, allContact2);
                        }
                    } else {
                        ContactSelectModel.AllContact allContact3 = (ContactSelectModel.AllContact) concurrentHashMap.get(name);
                        ContactSelectModel.AllContact allContact4 = new ContactSelectModel.AllContact();
                        allContact4.setName(name);
                        ArrayList arrayList2 = new ArrayList();
                        ContactSelectModel.PhoneNumberUnit phoneNumberUnit3 = new ContactSelectModel.PhoneNumberUnit();
                        phoneNumberUnit3.num = allPhone.get(i).getMobile();
                        arrayList2.add(phoneNumberUnit3);
                        allContact4.setList(arrayList2);
                        concurrentHashMap.put(name, allContact4);
                    }
                }
                for (Map.Entry entry : concurrentHashMap.entrySet()) {
                    this.f24027c.add((ContactSelectModel.AllContact) entry.getValue());
                }
                return null;
            } catch (Throwable th) {
                LogUtil.d(PhoneContactsMananger.f24017a, th.getMessage());
                return null;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public void onPostExecute(String str) {
            if (this.f24028d != null) {
                int size = this.f24027c.size();
                int i = this.f24026b;
                if (size > i) {
                    this.f24028d.onLoadSuccess(this.f24027c.subList(0, i), this.f24026b);
                } else {
                    this.f24028d.onLoadSuccess(this.f24027c, i);
                }
                this.f24028d = null;
            }
            super.onPostExecute(str);
        }
    }

    /* loaded from: classes5.dex */
    public class b extends AsyncTask<String, String, String> {

        /* renamed from: b  reason: collision with root package name */
        public ContactStatus f24030b = ContactStatus.unload;

        /* renamed from: c  reason: collision with root package name */
        public LoadAddressInfoComplitedListener f24031c;

        public b() {
        }

        public void a(LoadAddressInfoComplitedListener loadAddressInfoComplitedListener) {
            this.f24031c = loadAddressInfoComplitedListener;
        }

        public ContactStatus a() {
            return this.f24030b;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public String doInBackground(String... strArr) {
            this.f24030b = ContactStatus.loading;
            if (PhoneContactsMananger.this.f24020d.size() == 0) {
                PhoneContactsMananger phoneContactsMananger = PhoneContactsMananger.this;
                phoneContactsMananger.f24020d = AddressUtils.getPhoneContracts(phoneContactsMananger.f24019c);
            }
            String str = PhoneContactsMananger.f24017a;
            LogUtil.d(str, "手机里面的通讯：" + PhoneContactsMananger.this.f24020d.toString());
            if (PhoneContactsMananger.this.f24021e.size() == 0) {
                PhoneContactsMananger phoneContactsMananger2 = PhoneContactsMananger.this;
                phoneContactsMananger2.f24021e = AddressUtils.getSimContracts(phoneContactsMananger2.f24019c);
            }
            String str2 = PhoneContactsMananger.f24017a;
            LogUtil.d(str2, "Sim里面的通讯：" + PhoneContactsMananger.this.f24021e.toString());
            if (PhoneContactsMananger.this.f24022f == null || PhoneContactsMananger.this.f24022f.size() == 0) {
                PhoneContactsMananger.this.b();
            }
            String str3 = PhoneContactsMananger.f24017a;
            LogUtil.d(str3, "本地所有的通讯录信息：" + PhoneContactsMananger.this.f24022f.toString());
            this.f24030b = ContactStatus.complited;
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public void onPostExecute(String str) {
            if (PhoneContactsMananger.this.f24022f.isEmpty()) {
                this.f24030b = ContactStatus.unload;
            }
            LoadAddressInfoComplitedListener loadAddressInfoComplitedListener = this.f24031c;
            if (loadAddressInfoComplitedListener != null) {
                loadAddressInfoComplitedListener.onLoadContractsComplited(PhoneContactsMananger.this.f24022f);
                this.f24031c = null;
            }
            super.onPostExecute(str);
        }
    }

    public PhoneContactsMananger(Context context) {
        if (context != null) {
            this.f24019c = context.getApplicationContext();
        }
    }

    public static synchronized PhoneContactsMananger getInstance(Context context) {
        PhoneContactsMananger phoneContactsMananger;
        synchronized (PhoneContactsMananger.class) {
            if (f24018b == null) {
                f24018b = new PhoneContactsMananger(context);
            }
            phoneContactsMananger = f24018b;
        }
        return phoneContactsMananger;
    }

    public String getPayphoneInfo(String str) {
        String str2;
        ContractInfo contractInfo = this.f24020d.get(str);
        if (contractInfo == null) {
            contractInfo = this.f24021e.get(str);
        }
        String str3 = f24017a;
        StringBuilder sb = new StringBuilder();
        sb.append("手机号：");
        sb.append(str);
        sb.append(" ");
        if (contractInfo != null) {
            str2 = "关联到的信息是" + contractInfo.toString();
        } else {
            str2 = "该手机号没有关联通讯录";
        }
        sb.append(str2);
        LogUtil.d(str3, sb.toString());
        return contractInfo != null ? contractInfo.getName() : "";
    }

    public void loadAllContacts(int i, LoadAllContactListener loadAllContactListener) {
        a aVar = new a();
        aVar.a(i, loadAllContactListener);
        aVar.execute("");
    }

    public void loadFixPhoneList(String str, int i, boolean z, LoadAddressInfoListener loadAddressInfoListener) {
        ContractInfo contractInfo;
        char[] charArray;
        if (z) {
            contractInfo = this.f24020d.get(str);
            if (contractInfo == null) {
                contractInfo = this.f24021e.get(str);
            }
        } else {
            String formatPhoneNumber = StringUtils.formatPhoneNumber(str);
            if (TextUtils.isEmpty(formatPhoneNumber)) {
                contractInfo = null;
            } else {
                ContractInfo contractInfo2 = this.f24020d.get(formatPhoneNumber);
                contractInfo = contractInfo2 == null ? this.f24021e.get(formatPhoneNumber) : contractInfo2;
            }
        }
        if (contractInfo != null) {
            String str2 = f24017a;
            LogUtil.d(str2, "该手机号：" + str + " 是通讯录里面的号码");
            if (loadAddressInfoListener != null) {
                loadAddressInfoListener.onFixPhoneList(str, new ArrayList<>());
                return;
            }
            return;
        }
        List<ContractInfo> arrayList = new ArrayList<>();
        char[] charArray2 = str.toCharArray();
        for (int i2 = 0; i2 < this.f24022f.size(); i2++) {
            if (this.f24022f.get(i2) != null && !TextUtils.isEmpty(this.f24022f.get(i2).getMobile())) {
                String mobile = this.f24022f.get(i2).getMobile();
                if (z) {
                    charArray = mobile.toCharArray();
                } else {
                    charArray = mobile.replace(" ", "").toCharArray();
                }
                this.f24022f.get(i2).setErrordigit(-1);
                int i3 = 0;
                for (int i4 = 0; i4 < charArray.length; i4++) {
                    if (charArray2[i4] != charArray[i4] && (i3 = i3 + 1) == 1) {
                        this.f24022f.get(i2).setErrordigit(i4);
                    }
                    if (i3 > i) {
                        break;
                    }
                }
                if (i3 > 0 && i3 <= i) {
                    arrayList.add(this.f24022f.get(i2));
                } else {
                    this.f24022f.get(i2).setErrordigit(-1);
                }
            }
        }
        String str3 = f24017a;
        LogUtil.d(str3, "与手机号：" + str + " 是通讯录里面最多有" + i + "位不一样的号码是：" + arrayList.toString());
        if (loadAddressInfoListener != null) {
            loadAddressInfoListener.onFixPhoneList(str, arrayList);
        }
    }

    public void loadPayphoneInfo(String str, LoadAddressInfoListener loadAddressInfoListener) {
        String str2;
        ContractInfo contractInfo = this.f24020d.get(str);
        if (contractInfo == null) {
            contractInfo = this.f24021e.get(str);
        }
        if (contractInfo == null && this.f24022f.size() == 0) {
            LogUtil.d(f24017a, "通讯录为空，视为没有权限为关闭");
            if (loadAddressInfoListener != null) {
                loadAddressInfoListener.onLoadFastPayPhoneInfo(str, new ContractInfo());
                return;
            }
            return;
        }
        String str3 = f24017a;
        StringBuilder sb = new StringBuilder();
        sb.append("手机号：");
        sb.append(str);
        sb.append(" ");
        if (contractInfo != null) {
            str2 = "关联到的信息是" + contractInfo.toString();
        } else {
            str2 = "该手机号没有关联通讯录";
        }
        sb.append(str2);
        LogUtil.d(str3, sb.toString());
        if (loadAddressInfoListener != null) {
            loadAddressInfoListener.onLoadFastPayPhoneInfo(str, contractInfo);
        }
    }

    public void loadPhoneContacts(LoadAddressInfoComplitedListener loadAddressInfoComplitedListener) {
        if (this.f24023g == null || this.f24022f.isEmpty()) {
            this.f24023g = new b();
        }
        int i = AnonymousClass1.f24024a[this.f24023g.a().ordinal()];
        if (i != 1) {
            if (i == 3 && loadAddressInfoComplitedListener != null) {
                loadAddressInfoComplitedListener.onLoadContractsComplited(this.f24022f);
                return;
            }
            return;
        }
        try {
            this.f24023g.a(loadAddressInfoComplitedListener);
            this.f24023g.execute("");
        } catch (IllegalStateException e2) {
            LogUtil.d(PhoneContactsMananger.class.toString(), e2.toString());
        }
    }

    public void reset() {
        if (this.f24023g != null) {
            this.f24023g = null;
        }
        ConcurrentHashMap<String, ContractInfo> concurrentHashMap = this.f24020d;
        if (concurrentHashMap != null) {
            concurrentHashMap.clear();
        }
        ConcurrentHashMap<String, ContractInfo> concurrentHashMap2 = this.f24021e;
        if (concurrentHashMap2 != null) {
            concurrentHashMap2.clear();
        }
        ArrayList<ContractInfo> arrayList = this.f24022f;
        if (arrayList != null) {
            arrayList.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        for (String str : this.f24020d.keySet()) {
            if (!this.f24022f.contains(this.f24020d.get(str))) {
                this.f24022f.add(this.f24020d.get(str));
            }
        }
        for (String str2 : this.f24021e.keySet()) {
            if (!this.f24022f.contains(this.f24021e.get(str2))) {
                this.f24022f.add(this.f24021e.get(str2));
            }
        }
    }
}
