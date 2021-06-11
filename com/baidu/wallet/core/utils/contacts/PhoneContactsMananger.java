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
    public static final String f24051a = "PhoneContactsMananger";

    /* renamed from: b  reason: collision with root package name */
    public static PhoneContactsMananger f24052b;

    /* renamed from: c  reason: collision with root package name */
    public Context f24053c;

    /* renamed from: d  reason: collision with root package name */
    public ConcurrentHashMap<String, ContractInfo> f24054d = new ConcurrentHashMap<>();

    /* renamed from: e  reason: collision with root package name */
    public ConcurrentHashMap<String, ContractInfo> f24055e = new ConcurrentHashMap<>();

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<ContractInfo> f24056f = new ArrayList<>();

    /* renamed from: g  reason: collision with root package name */
    public b f24057g = null;

    /* renamed from: com.baidu.wallet.core.utils.contacts.PhoneContactsMananger$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f24058a;

        static {
            int[] iArr = new int[ContactStatus.values().length];
            f24058a = iArr;
            try {
                iArr[ContactStatus.unload.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f24058a[ContactStatus.loading.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f24058a[ContactStatus.complited.ordinal()] = 3;
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
        void onLoadSuccess(List<ContactSelectModel.AllContact> list, int i2);
    }

    /* loaded from: classes5.dex */
    public class a extends AsyncTask<String, String, String> {

        /* renamed from: b  reason: collision with root package name */
        public int f24060b;

        /* renamed from: c  reason: collision with root package name */
        public ArrayList<ContactSelectModel.AllContact> f24061c = new ArrayList<>();

        /* renamed from: d  reason: collision with root package name */
        public LoadAllContactListener f24062d;

        public a() {
        }

        public int a() {
            return this.f24060b;
        }

        public void a(int i2, LoadAllContactListener loadAllContactListener) {
            this.f24060b = i2;
            this.f24062d = loadAllContactListener;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public String doInBackground(String... strArr) {
            try {
                List<ContractInfo> allPhone = AddressUtils.getAllPhone(PhoneContactsMananger.this.f24053c);
                ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
                for (int i2 = 0; i2 < allPhone.size(); i2++) {
                    String name = allPhone.get(i2).getName();
                    if (concurrentHashMap.containsKey(name)) {
                        ContactSelectModel.AllContact allContact = (ContactSelectModel.AllContact) concurrentHashMap.get(name);
                        if (allContact != null) {
                            ContactSelectModel.PhoneNumberUnit phoneNumberUnit = new ContactSelectModel.PhoneNumberUnit();
                            phoneNumberUnit.num = allPhone.get(i2).getMobile();
                            allContact.getList().add(phoneNumberUnit);
                            concurrentHashMap.put(name, allContact);
                        } else {
                            ContactSelectModel.AllContact allContact2 = new ContactSelectModel.AllContact();
                            allContact2.setName(name);
                            ArrayList arrayList = new ArrayList();
                            ContactSelectModel.PhoneNumberUnit phoneNumberUnit2 = new ContactSelectModel.PhoneNumberUnit();
                            phoneNumberUnit2.num = allPhone.get(i2).getMobile();
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
                        phoneNumberUnit3.num = allPhone.get(i2).getMobile();
                        arrayList2.add(phoneNumberUnit3);
                        allContact4.setList(arrayList2);
                        concurrentHashMap.put(name, allContact4);
                    }
                }
                for (Map.Entry entry : concurrentHashMap.entrySet()) {
                    this.f24061c.add((ContactSelectModel.AllContact) entry.getValue());
                }
                return null;
            } catch (Throwable th) {
                LogUtil.d(PhoneContactsMananger.f24051a, th.getMessage());
                return null;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public void onPostExecute(String str) {
            if (this.f24062d != null) {
                int size = this.f24061c.size();
                int i2 = this.f24060b;
                if (size > i2) {
                    this.f24062d.onLoadSuccess(this.f24061c.subList(0, i2), this.f24060b);
                } else {
                    this.f24062d.onLoadSuccess(this.f24061c, i2);
                }
                this.f24062d = null;
            }
            super.onPostExecute(str);
        }
    }

    /* loaded from: classes5.dex */
    public class b extends AsyncTask<String, String, String> {

        /* renamed from: b  reason: collision with root package name */
        public ContactStatus f24064b = ContactStatus.unload;

        /* renamed from: c  reason: collision with root package name */
        public LoadAddressInfoComplitedListener f24065c;

        public b() {
        }

        public void a(LoadAddressInfoComplitedListener loadAddressInfoComplitedListener) {
            this.f24065c = loadAddressInfoComplitedListener;
        }

        public ContactStatus a() {
            return this.f24064b;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public String doInBackground(String... strArr) {
            this.f24064b = ContactStatus.loading;
            if (PhoneContactsMananger.this.f24054d.size() == 0) {
                PhoneContactsMananger phoneContactsMananger = PhoneContactsMananger.this;
                phoneContactsMananger.f24054d = AddressUtils.getPhoneContracts(phoneContactsMananger.f24053c);
            }
            String str = PhoneContactsMananger.f24051a;
            LogUtil.d(str, "手机里面的通讯：" + PhoneContactsMananger.this.f24054d.toString());
            if (PhoneContactsMananger.this.f24055e.size() == 0) {
                PhoneContactsMananger phoneContactsMananger2 = PhoneContactsMananger.this;
                phoneContactsMananger2.f24055e = AddressUtils.getSimContracts(phoneContactsMananger2.f24053c);
            }
            String str2 = PhoneContactsMananger.f24051a;
            LogUtil.d(str2, "Sim里面的通讯：" + PhoneContactsMananger.this.f24055e.toString());
            if (PhoneContactsMananger.this.f24056f == null || PhoneContactsMananger.this.f24056f.size() == 0) {
                PhoneContactsMananger.this.b();
            }
            String str3 = PhoneContactsMananger.f24051a;
            LogUtil.d(str3, "本地所有的通讯录信息：" + PhoneContactsMananger.this.f24056f.toString());
            this.f24064b = ContactStatus.complited;
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public void onPostExecute(String str) {
            if (PhoneContactsMananger.this.f24056f.isEmpty()) {
                this.f24064b = ContactStatus.unload;
            }
            LoadAddressInfoComplitedListener loadAddressInfoComplitedListener = this.f24065c;
            if (loadAddressInfoComplitedListener != null) {
                loadAddressInfoComplitedListener.onLoadContractsComplited(PhoneContactsMananger.this.f24056f);
                this.f24065c = null;
            }
            super.onPostExecute(str);
        }
    }

    public PhoneContactsMananger(Context context) {
        if (context != null) {
            this.f24053c = context.getApplicationContext();
        }
    }

    public static synchronized PhoneContactsMananger getInstance(Context context) {
        PhoneContactsMananger phoneContactsMananger;
        synchronized (PhoneContactsMananger.class) {
            if (f24052b == null) {
                f24052b = new PhoneContactsMananger(context);
            }
            phoneContactsMananger = f24052b;
        }
        return phoneContactsMananger;
    }

    public String getPayphoneInfo(String str) {
        String str2;
        ContractInfo contractInfo = this.f24054d.get(str);
        if (contractInfo == null) {
            contractInfo = this.f24055e.get(str);
        }
        String str3 = f24051a;
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

    public void loadAllContacts(int i2, LoadAllContactListener loadAllContactListener) {
        a aVar = new a();
        aVar.a(i2, loadAllContactListener);
        aVar.execute("");
    }

    public void loadFixPhoneList(String str, int i2, boolean z, LoadAddressInfoListener loadAddressInfoListener) {
        ContractInfo contractInfo;
        char[] charArray;
        if (z) {
            contractInfo = this.f24054d.get(str);
            if (contractInfo == null) {
                contractInfo = this.f24055e.get(str);
            }
        } else {
            String formatPhoneNumber = StringUtils.formatPhoneNumber(str);
            if (TextUtils.isEmpty(formatPhoneNumber)) {
                contractInfo = null;
            } else {
                ContractInfo contractInfo2 = this.f24054d.get(formatPhoneNumber);
                contractInfo = contractInfo2 == null ? this.f24055e.get(formatPhoneNumber) : contractInfo2;
            }
        }
        if (contractInfo != null) {
            String str2 = f24051a;
            LogUtil.d(str2, "该手机号：" + str + " 是通讯录里面的号码");
            if (loadAddressInfoListener != null) {
                loadAddressInfoListener.onFixPhoneList(str, new ArrayList<>());
                return;
            }
            return;
        }
        List<ContractInfo> arrayList = new ArrayList<>();
        char[] charArray2 = str.toCharArray();
        for (int i3 = 0; i3 < this.f24056f.size(); i3++) {
            if (this.f24056f.get(i3) != null && !TextUtils.isEmpty(this.f24056f.get(i3).getMobile())) {
                String mobile = this.f24056f.get(i3).getMobile();
                if (z) {
                    charArray = mobile.toCharArray();
                } else {
                    charArray = mobile.replace(" ", "").toCharArray();
                }
                this.f24056f.get(i3).setErrordigit(-1);
                int i4 = 0;
                for (int i5 = 0; i5 < charArray.length; i5++) {
                    if (charArray2[i5] != charArray[i5] && (i4 = i4 + 1) == 1) {
                        this.f24056f.get(i3).setErrordigit(i5);
                    }
                    if (i4 > i2) {
                        break;
                    }
                }
                if (i4 > 0 && i4 <= i2) {
                    arrayList.add(this.f24056f.get(i3));
                } else {
                    this.f24056f.get(i3).setErrordigit(-1);
                }
            }
        }
        String str3 = f24051a;
        LogUtil.d(str3, "与手机号：" + str + " 是通讯录里面最多有" + i2 + "位不一样的号码是：" + arrayList.toString());
        if (loadAddressInfoListener != null) {
            loadAddressInfoListener.onFixPhoneList(str, arrayList);
        }
    }

    public void loadPayphoneInfo(String str, LoadAddressInfoListener loadAddressInfoListener) {
        String str2;
        ContractInfo contractInfo = this.f24054d.get(str);
        if (contractInfo == null) {
            contractInfo = this.f24055e.get(str);
        }
        if (contractInfo == null && this.f24056f.size() == 0) {
            LogUtil.d(f24051a, "通讯录为空，视为没有权限为关闭");
            if (loadAddressInfoListener != null) {
                loadAddressInfoListener.onLoadFastPayPhoneInfo(str, new ContractInfo());
                return;
            }
            return;
        }
        String str3 = f24051a;
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
        if (this.f24057g == null || this.f24056f.isEmpty()) {
            this.f24057g = new b();
        }
        int i2 = AnonymousClass1.f24058a[this.f24057g.a().ordinal()];
        if (i2 != 1) {
            if (i2 == 3 && loadAddressInfoComplitedListener != null) {
                loadAddressInfoComplitedListener.onLoadContractsComplited(this.f24056f);
                return;
            }
            return;
        }
        try {
            this.f24057g.a(loadAddressInfoComplitedListener);
            this.f24057g.execute("");
        } catch (IllegalStateException e2) {
            LogUtil.d(PhoneContactsMananger.class.toString(), e2.toString());
        }
    }

    public void reset() {
        if (this.f24057g != null) {
            this.f24057g = null;
        }
        ConcurrentHashMap<String, ContractInfo> concurrentHashMap = this.f24054d;
        if (concurrentHashMap != null) {
            concurrentHashMap.clear();
        }
        ConcurrentHashMap<String, ContractInfo> concurrentHashMap2 = this.f24055e;
        if (concurrentHashMap2 != null) {
            concurrentHashMap2.clear();
        }
        ArrayList<ContractInfo> arrayList = this.f24056f;
        if (arrayList != null) {
            arrayList.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        for (String str : this.f24054d.keySet()) {
            if (!this.f24056f.contains(this.f24054d.get(str))) {
                this.f24056f.add(this.f24054d.get(str));
            }
        }
        for (String str2 : this.f24055e.keySet()) {
            if (!this.f24056f.contains(this.f24055e.get(str2))) {
                this.f24056f.add(this.f24055e.get(str2));
            }
        }
    }
}
