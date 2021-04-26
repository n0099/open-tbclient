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
    public static final String f24774a = "PhoneContactsMananger";

    /* renamed from: b  reason: collision with root package name */
    public static PhoneContactsMananger f24775b;

    /* renamed from: c  reason: collision with root package name */
    public Context f24776c;

    /* renamed from: d  reason: collision with root package name */
    public ConcurrentHashMap<String, ContractInfo> f24777d = new ConcurrentHashMap<>();

    /* renamed from: e  reason: collision with root package name */
    public ConcurrentHashMap<String, ContractInfo> f24778e = new ConcurrentHashMap<>();

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<ContractInfo> f24779f = new ArrayList<>();

    /* renamed from: g  reason: collision with root package name */
    public b f24780g = null;

    /* renamed from: com.baidu.wallet.core.utils.contacts.PhoneContactsMananger$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f24781a;

        static {
            int[] iArr = new int[ContactStatus.values().length];
            f24781a = iArr;
            try {
                iArr[ContactStatus.unload.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f24781a[ContactStatus.loading.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f24781a[ContactStatus.complited.ordinal()] = 3;
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
        public int f24783b;

        /* renamed from: c  reason: collision with root package name */
        public ArrayList<ContactSelectModel.AllContact> f24784c = new ArrayList<>();

        /* renamed from: d  reason: collision with root package name */
        public LoadAllContactListener f24785d;

        public a() {
        }

        public int a() {
            return this.f24783b;
        }

        public void a(int i2, LoadAllContactListener loadAllContactListener) {
            this.f24783b = i2;
            this.f24785d = loadAllContactListener;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public String doInBackground(String... strArr) {
            try {
                List<ContractInfo> allPhone = AddressUtils.getAllPhone(PhoneContactsMananger.this.f24776c);
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
                    this.f24784c.add((ContactSelectModel.AllContact) entry.getValue());
                }
                return null;
            } catch (Throwable th) {
                LogUtil.d(PhoneContactsMananger.f24774a, th.getMessage());
                return null;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public void onPostExecute(String str) {
            if (this.f24785d != null) {
                int size = this.f24784c.size();
                int i2 = this.f24783b;
                if (size > i2) {
                    this.f24785d.onLoadSuccess(this.f24784c.subList(0, i2), this.f24783b);
                } else {
                    this.f24785d.onLoadSuccess(this.f24784c, i2);
                }
                this.f24785d = null;
            }
            super.onPostExecute(str);
        }
    }

    /* loaded from: classes5.dex */
    public class b extends AsyncTask<String, String, String> {

        /* renamed from: b  reason: collision with root package name */
        public ContactStatus f24787b = ContactStatus.unload;

        /* renamed from: c  reason: collision with root package name */
        public LoadAddressInfoComplitedListener f24788c;

        public b() {
        }

        public void a(LoadAddressInfoComplitedListener loadAddressInfoComplitedListener) {
            this.f24788c = loadAddressInfoComplitedListener;
        }

        public ContactStatus a() {
            return this.f24787b;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public String doInBackground(String... strArr) {
            this.f24787b = ContactStatus.loading;
            if (PhoneContactsMananger.this.f24777d.size() == 0) {
                PhoneContactsMananger phoneContactsMananger = PhoneContactsMananger.this;
                phoneContactsMananger.f24777d = AddressUtils.getPhoneContracts(phoneContactsMananger.f24776c);
            }
            String str = PhoneContactsMananger.f24774a;
            LogUtil.d(str, "手机里面的通讯：" + PhoneContactsMananger.this.f24777d.toString());
            if (PhoneContactsMananger.this.f24778e.size() == 0) {
                PhoneContactsMananger phoneContactsMananger2 = PhoneContactsMananger.this;
                phoneContactsMananger2.f24778e = AddressUtils.getSimContracts(phoneContactsMananger2.f24776c);
            }
            String str2 = PhoneContactsMananger.f24774a;
            LogUtil.d(str2, "Sim里面的通讯：" + PhoneContactsMananger.this.f24778e.toString());
            if (PhoneContactsMananger.this.f24779f == null || PhoneContactsMananger.this.f24779f.size() == 0) {
                PhoneContactsMananger.this.b();
            }
            String str3 = PhoneContactsMananger.f24774a;
            LogUtil.d(str3, "本地所有的通讯录信息：" + PhoneContactsMananger.this.f24779f.toString());
            this.f24787b = ContactStatus.complited;
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public void onPostExecute(String str) {
            if (PhoneContactsMananger.this.f24779f.isEmpty()) {
                this.f24787b = ContactStatus.unload;
            }
            LoadAddressInfoComplitedListener loadAddressInfoComplitedListener = this.f24788c;
            if (loadAddressInfoComplitedListener != null) {
                loadAddressInfoComplitedListener.onLoadContractsComplited(PhoneContactsMananger.this.f24779f);
                this.f24788c = null;
            }
            super.onPostExecute(str);
        }
    }

    public PhoneContactsMananger(Context context) {
        if (context != null) {
            this.f24776c = context.getApplicationContext();
        }
    }

    public static synchronized PhoneContactsMananger getInstance(Context context) {
        PhoneContactsMananger phoneContactsMananger;
        synchronized (PhoneContactsMananger.class) {
            if (f24775b == null) {
                f24775b = new PhoneContactsMananger(context);
            }
            phoneContactsMananger = f24775b;
        }
        return phoneContactsMananger;
    }

    public String getPayphoneInfo(String str) {
        String str2;
        ContractInfo contractInfo = this.f24777d.get(str);
        if (contractInfo == null) {
            contractInfo = this.f24778e.get(str);
        }
        String str3 = f24774a;
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
            contractInfo = this.f24777d.get(str);
            if (contractInfo == null) {
                contractInfo = this.f24778e.get(str);
            }
        } else {
            String formatPhoneNumber = StringUtils.formatPhoneNumber(str);
            if (TextUtils.isEmpty(formatPhoneNumber)) {
                contractInfo = null;
            } else {
                ContractInfo contractInfo2 = this.f24777d.get(formatPhoneNumber);
                contractInfo = contractInfo2 == null ? this.f24778e.get(formatPhoneNumber) : contractInfo2;
            }
        }
        if (contractInfo != null) {
            String str2 = f24774a;
            LogUtil.d(str2, "该手机号：" + str + " 是通讯录里面的号码");
            if (loadAddressInfoListener != null) {
                loadAddressInfoListener.onFixPhoneList(str, new ArrayList<>());
                return;
            }
            return;
        }
        List<ContractInfo> arrayList = new ArrayList<>();
        char[] charArray2 = str.toCharArray();
        for (int i3 = 0; i3 < this.f24779f.size(); i3++) {
            if (this.f24779f.get(i3) != null && !TextUtils.isEmpty(this.f24779f.get(i3).getMobile())) {
                String mobile = this.f24779f.get(i3).getMobile();
                if (z) {
                    charArray = mobile.toCharArray();
                } else {
                    charArray = mobile.replace(" ", "").toCharArray();
                }
                this.f24779f.get(i3).setErrordigit(-1);
                int i4 = 0;
                for (int i5 = 0; i5 < charArray.length; i5++) {
                    if (charArray2[i5] != charArray[i5] && (i4 = i4 + 1) == 1) {
                        this.f24779f.get(i3).setErrordigit(i5);
                    }
                    if (i4 > i2) {
                        break;
                    }
                }
                if (i4 > 0 && i4 <= i2) {
                    arrayList.add(this.f24779f.get(i3));
                } else {
                    this.f24779f.get(i3).setErrordigit(-1);
                }
            }
        }
        String str3 = f24774a;
        LogUtil.d(str3, "与手机号：" + str + " 是通讯录里面最多有" + i2 + "位不一样的号码是：" + arrayList.toString());
        if (loadAddressInfoListener != null) {
            loadAddressInfoListener.onFixPhoneList(str, arrayList);
        }
    }

    public void loadPayphoneInfo(String str, LoadAddressInfoListener loadAddressInfoListener) {
        String str2;
        ContractInfo contractInfo = this.f24777d.get(str);
        if (contractInfo == null) {
            contractInfo = this.f24778e.get(str);
        }
        if (contractInfo == null && this.f24779f.size() == 0) {
            LogUtil.d(f24774a, "通讯录为空，视为没有权限为关闭");
            if (loadAddressInfoListener != null) {
                loadAddressInfoListener.onLoadFastPayPhoneInfo(str, new ContractInfo());
                return;
            }
            return;
        }
        String str3 = f24774a;
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
        if (this.f24780g == null || this.f24779f.isEmpty()) {
            this.f24780g = new b();
        }
        int i2 = AnonymousClass1.f24781a[this.f24780g.a().ordinal()];
        if (i2 != 1) {
            if (i2 == 3 && loadAddressInfoComplitedListener != null) {
                loadAddressInfoComplitedListener.onLoadContractsComplited(this.f24779f);
                return;
            }
            return;
        }
        try {
            this.f24780g.a(loadAddressInfoComplitedListener);
            this.f24780g.execute("");
        } catch (IllegalStateException e2) {
            LogUtil.d(PhoneContactsMananger.class.toString(), e2.toString());
        }
    }

    public void reset() {
        if (this.f24780g != null) {
            this.f24780g = null;
        }
        ConcurrentHashMap<String, ContractInfo> concurrentHashMap = this.f24777d;
        if (concurrentHashMap != null) {
            concurrentHashMap.clear();
        }
        ConcurrentHashMap<String, ContractInfo> concurrentHashMap2 = this.f24778e;
        if (concurrentHashMap2 != null) {
            concurrentHashMap2.clear();
        }
        ArrayList<ContractInfo> arrayList = this.f24779f;
        if (arrayList != null) {
            arrayList.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        for (String str : this.f24777d.keySet()) {
            if (!this.f24779f.contains(this.f24777d.get(str))) {
                this.f24779f.add(this.f24777d.get(str));
            }
        }
        for (String str2 : this.f24778e.keySet()) {
            if (!this.f24779f.contains(this.f24778e.get(str2))) {
                this.f24779f.add(this.f24778e.get(str2));
            }
        }
    }
}
