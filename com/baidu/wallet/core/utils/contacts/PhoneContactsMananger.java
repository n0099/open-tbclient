package com.baidu.wallet.core.utils.contacts;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.utils.DxmApplicationContextImpl;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.core.utils.LogUtil;
import com.baidu.wallet.core.utils.StringUtils;
import com.baidu.wallet.core.utils.contacts.ContactSelectModel;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
@SuppressLint({"StaticFieldLeak"})
/* loaded from: classes8.dex */
public class PhoneContactsMananger {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static final String f60862a = "PhoneContactsMananger";

    /* renamed from: b  reason: collision with root package name */
    public static PhoneContactsMananger f60863b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public Context f60864c;

    /* renamed from: d  reason: collision with root package name */
    public ConcurrentHashMap<String, ContractInfo> f60865d;

    /* renamed from: e  reason: collision with root package name */
    public ConcurrentHashMap<String, ContractInfo> f60866e;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<ContractInfo> f60867f;

    /* renamed from: g  reason: collision with root package name */
    public b f60868g;

    /* renamed from: com.baidu.wallet.core.utils.contacts.PhoneContactsMananger$1  reason: invalid class name */
    /* loaded from: classes8.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f60869a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(993659702, "Lcom/baidu/wallet/core/utils/contacts/PhoneContactsMananger$1;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(993659702, "Lcom/baidu/wallet/core/utils/contacts/PhoneContactsMananger$1;");
                    return;
                }
            }
            int[] iArr = new int[ContactStatus.values().length];
            f60869a = iArr;
            try {
                iArr[ContactStatus.unload.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f60869a[ContactStatus.loading.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f60869a[ContactStatus.complited.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes8.dex */
    public static final class ContactStatus {
        public static final /* synthetic */ ContactStatus[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final ContactStatus complited;
        public static final ContactStatus loading;
        public static final ContactStatus unload;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(700996981, "Lcom/baidu/wallet/core/utils/contacts/PhoneContactsMananger$ContactStatus;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(700996981, "Lcom/baidu/wallet/core/utils/contacts/PhoneContactsMananger$ContactStatus;");
                    return;
                }
            }
            unload = new ContactStatus("unload", 0);
            loading = new ContactStatus("loading", 1);
            ContactStatus contactStatus = new ContactStatus("complited", 2);
            complited = contactStatus;
            $VALUES = new ContactStatus[]{unload, loading, contactStatus};
        }

        public ContactStatus(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static ContactStatus valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (ContactStatus) Enum.valueOf(ContactStatus.class, str) : (ContactStatus) invokeL.objValue;
        }

        public static ContactStatus[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (ContactStatus[]) $VALUES.clone() : (ContactStatus[]) invokeV.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public interface LoadAddressInfoComplitedListener {
        void onLoadContractsComplited(ArrayList<ContractInfo> arrayList);
    }

    /* loaded from: classes8.dex */
    public interface LoadAddressInfoListener {
        void onFixPhoneList(String str, List<ContractInfo> list);

        void onLoadFastPayPhoneInfo(String str, ContractInfo contractInfo);
    }

    /* loaded from: classes8.dex */
    public interface LoadAllContactListener {
        void onLoadSuccess(List<ContactSelectModel.AllContact> list, int i2);
    }

    /* loaded from: classes8.dex */
    public class a extends AsyncTask<String, String, String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PhoneContactsMananger f60870a;

        /* renamed from: b  reason: collision with root package name */
        public int f60871b;

        /* renamed from: c  reason: collision with root package name */
        public ArrayList<ContactSelectModel.AllContact> f60872c;

        /* renamed from: d  reason: collision with root package name */
        public LoadAllContactListener f60873d;

        public a(PhoneContactsMananger phoneContactsMananger) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {phoneContactsMananger};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f60870a = phoneContactsMananger;
            this.f60872c = new ArrayList<>();
        }

        public int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f60871b : invokeV.intValue;
        }

        public void a(int i2, LoadAllContactListener loadAllContactListener) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i2, loadAllContactListener) == null) {
                this.f60871b = i2;
                this.f60873d = loadAllContactListener;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public String doInBackground(String... strArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, strArr)) == null) {
                try {
                    List<ContractInfo> allPhone = AddressUtils.getAllPhone(this.f60870a.f60864c);
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
                        this.f60872c.add((ContactSelectModel.AllContact) entry.getValue());
                    }
                    return null;
                } catch (Throwable th) {
                    LogUtil.d(PhoneContactsMananger.f60862a, th.getMessage());
                    return null;
                }
            }
            return (String) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public void onPostExecute(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
                if (this.f60873d != null) {
                    int size = this.f60872c.size();
                    int i2 = this.f60871b;
                    if (size > i2) {
                        this.f60873d.onLoadSuccess(this.f60872c.subList(0, i2), this.f60871b);
                    } else {
                        this.f60873d.onLoadSuccess(this.f60872c, i2);
                    }
                    this.f60873d = null;
                }
                super.onPostExecute(str);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b extends AsyncTask<String, String, String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PhoneContactsMananger f60874a;

        /* renamed from: b  reason: collision with root package name */
        public ContactStatus f60875b;

        /* renamed from: c  reason: collision with root package name */
        public LoadAddressInfoComplitedListener f60876c;

        public b(PhoneContactsMananger phoneContactsMananger) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {phoneContactsMananger};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f60874a = phoneContactsMananger;
            this.f60875b = ContactStatus.unload;
        }

        public void a(LoadAddressInfoComplitedListener loadAddressInfoComplitedListener) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, loadAddressInfoComplitedListener) == null) {
                this.f60876c = loadAddressInfoComplitedListener;
            }
        }

        public ContactStatus a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f60875b : (ContactStatus) invokeV.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public String doInBackground(String... strArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, strArr)) == null) {
                this.f60875b = ContactStatus.loading;
                if (this.f60874a.f60865d.size() == 0) {
                    PhoneContactsMananger phoneContactsMananger = this.f60874a;
                    phoneContactsMananger.f60865d = AddressUtils.getPhoneContracts(phoneContactsMananger.f60864c);
                }
                String str = PhoneContactsMananger.f60862a;
                LogUtil.d(str, "手机里面的通讯：" + this.f60874a.f60865d.toString());
                if (this.f60874a.f60866e.size() == 0) {
                    PhoneContactsMananger phoneContactsMananger2 = this.f60874a;
                    phoneContactsMananger2.f60866e = AddressUtils.getSimContracts(phoneContactsMananger2.f60864c);
                }
                String str2 = PhoneContactsMananger.f60862a;
                LogUtil.d(str2, "Sim里面的通讯：" + this.f60874a.f60866e.toString());
                if (this.f60874a.f60867f == null || this.f60874a.f60867f.size() == 0) {
                    this.f60874a.b();
                }
                String str3 = PhoneContactsMananger.f60862a;
                LogUtil.d(str3, "本地所有的通讯录信息：" + this.f60874a.f60867f.toString());
                this.f60875b = ContactStatus.complited;
                return null;
            }
            return (String) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public void onPostExecute(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
                if (this.f60874a.f60867f.isEmpty()) {
                    this.f60875b = ContactStatus.unload;
                }
                LoadAddressInfoComplitedListener loadAddressInfoComplitedListener = this.f60876c;
                if (loadAddressInfoComplitedListener != null) {
                    loadAddressInfoComplitedListener.onLoadContractsComplited(this.f60874a.f60867f);
                    this.f60876c = null;
                }
                super.onPostExecute(str);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-271591389, "Lcom/baidu/wallet/core/utils/contacts/PhoneContactsMananger;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-271591389, "Lcom/baidu/wallet/core/utils/contacts/PhoneContactsMananger;");
        }
    }

    public PhoneContactsMananger(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f60865d = new ConcurrentHashMap<>();
        this.f60866e = new ConcurrentHashMap<>();
        this.f60867f = new ArrayList<>();
        this.f60868g = null;
        if (context != null) {
            this.f60864c = DxmApplicationContextImpl.getApplicationContext(context);
        }
    }

    public static synchronized PhoneContactsMananger getInstance(Context context) {
        InterceptResult invokeL;
        PhoneContactsMananger phoneContactsMananger;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, context)) == null) {
            synchronized (PhoneContactsMananger.class) {
                if (f60863b == null) {
                    f60863b = new PhoneContactsMananger(context);
                }
                phoneContactsMananger = f60863b;
            }
            return phoneContactsMananger;
        }
        return (PhoneContactsMananger) invokeL.objValue;
    }

    public String getPayphoneInfo(String str) {
        InterceptResult invokeL;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            ContractInfo contractInfo = this.f60865d.get(str);
            if (contractInfo == null) {
                contractInfo = this.f60866e.get(str);
            }
            String str3 = f60862a;
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
        return (String) invokeL.objValue;
    }

    public void loadAllContacts(int i2, LoadAllContactListener loadAllContactListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, loadAllContactListener) == null) {
            a aVar = new a(this);
            aVar.a(i2, loadAllContactListener);
            aVar.execute("");
        }
    }

    public void loadFixPhoneList(String str, int i2, boolean z, LoadAddressInfoListener loadAddressInfoListener) {
        ContractInfo contractInfo;
        char[] charArray;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{str, Integer.valueOf(i2), Boolean.valueOf(z), loadAddressInfoListener}) == null) {
            if (z) {
                contractInfo = this.f60865d.get(str);
                if (contractInfo == null) {
                    contractInfo = this.f60866e.get(str);
                }
            } else {
                String formatPhoneNumber = StringUtils.formatPhoneNumber(str);
                if (TextUtils.isEmpty(formatPhoneNumber)) {
                    contractInfo = null;
                } else {
                    ContractInfo contractInfo2 = this.f60865d.get(formatPhoneNumber);
                    contractInfo = contractInfo2 == null ? this.f60866e.get(formatPhoneNumber) : contractInfo2;
                }
            }
            if (contractInfo != null) {
                String str2 = f60862a;
                LogUtil.d(str2, "该手机号：" + str + " 是通讯录里面的号码");
                if (loadAddressInfoListener != null) {
                    loadAddressInfoListener.onFixPhoneList(str, new ArrayList());
                    return;
                }
                return;
            }
            ArrayList arrayList = new ArrayList();
            char[] charArray2 = str.toCharArray();
            for (int i3 = 0; i3 < this.f60867f.size(); i3++) {
                if (this.f60867f.get(i3) != null && !TextUtils.isEmpty(this.f60867f.get(i3).getMobile())) {
                    String mobile = this.f60867f.get(i3).getMobile();
                    if (z) {
                        charArray = mobile.toCharArray();
                    } else {
                        charArray = mobile.replace(" ", "").toCharArray();
                    }
                    this.f60867f.get(i3).setErrordigit(-1);
                    int i4 = 0;
                    for (int i5 = 0; i5 < charArray.length; i5++) {
                        if (charArray2[i5] != charArray[i5] && (i4 = i4 + 1) == 1) {
                            this.f60867f.get(i3).setErrordigit(i5);
                        }
                        if (i4 > i2) {
                            break;
                        }
                    }
                    if (i4 > 0 && i4 <= i2) {
                        arrayList.add(this.f60867f.get(i3));
                    } else {
                        this.f60867f.get(i3).setErrordigit(-1);
                    }
                }
            }
            String str3 = f60862a;
            LogUtil.d(str3, "与手机号：" + str + " 是通讯录里面最多有" + i2 + "位不一样的号码是：" + arrayList.toString());
            if (loadAddressInfoListener != null) {
                loadAddressInfoListener.onFixPhoneList(str, arrayList);
            }
        }
    }

    public void loadPayphoneInfo(String str, LoadAddressInfoListener loadAddressInfoListener) {
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, loadAddressInfoListener) == null) {
            ContractInfo contractInfo = this.f60865d.get(str);
            if (contractInfo == null) {
                contractInfo = this.f60866e.get(str);
            }
            if (contractInfo == null && this.f60867f.size() == 0) {
                LogUtil.d(f60862a, "通讯录为空，视为没有权限为关闭");
                if (loadAddressInfoListener != null) {
                    loadAddressInfoListener.onLoadFastPayPhoneInfo(str, new ContractInfo());
                    return;
                }
                return;
            }
            String str3 = f60862a;
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
    }

    public void loadPhoneContacts(LoadAddressInfoComplitedListener loadAddressInfoComplitedListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, loadAddressInfoComplitedListener) == null) {
            if (this.f60868g == null || this.f60867f.isEmpty()) {
                this.f60868g = new b(this);
            }
            int i2 = AnonymousClass1.f60869a[this.f60868g.a().ordinal()];
            if (i2 != 1) {
                if (i2 == 3 && loadAddressInfoComplitedListener != null) {
                    loadAddressInfoComplitedListener.onLoadContractsComplited(this.f60867f);
                    return;
                }
                return;
            }
            try {
                this.f60868g.a(loadAddressInfoComplitedListener);
                this.f60868g.execute("");
            } catch (IllegalStateException e2) {
                LogUtil.d(PhoneContactsMananger.class.toString(), e2.toString());
            }
        }
    }

    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (this.f60868g != null) {
                this.f60868g = null;
            }
            ConcurrentHashMap<String, ContractInfo> concurrentHashMap = this.f60865d;
            if (concurrentHashMap != null) {
                concurrentHashMap.clear();
            }
            ConcurrentHashMap<String, ContractInfo> concurrentHashMap2 = this.f60866e;
            if (concurrentHashMap2 != null) {
                concurrentHashMap2.clear();
            }
            ArrayList<ContractInfo> arrayList = this.f60867f;
            if (arrayList != null) {
                arrayList.clear();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            for (String str : this.f60865d.keySet()) {
                if (!this.f60867f.contains(this.f60865d.get(str))) {
                    this.f60867f.add(this.f60865d.get(str));
                }
            }
            for (String str2 : this.f60866e.keySet()) {
                if (!this.f60867f.contains(this.f60866e.get(str2))) {
                    this.f60867f.add(this.f60866e.get(str2));
                }
            }
        }
    }
}
