package com.baidu.wallet.lightapp.base.contacts;

import android.content.Context;
import android.os.AsyncTask;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.utils.DxmApplicationContextImpl;
import com.baidu.apollon.utils.LogUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.core.utils.contacts.ContactSelectModel;
import com.baidu.wallet.core.utils.contacts.ContractInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes10.dex */
public class PhoneContactsMananger {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static final String f58785a = "PhoneContactsMananger";

    /* renamed from: b  reason: collision with root package name */
    public static PhoneContactsMananger f58786b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public Context f58787c;

    /* renamed from: d  reason: collision with root package name */
    public c f58788d;

    /* renamed from: e  reason: collision with root package name */
    public d f58789e;

    /* renamed from: f  reason: collision with root package name */
    public ConcurrentHashMap<String, ContractInfo> f58790f;

    /* renamed from: g  reason: collision with root package name */
    public ConcurrentHashMap<String, ContractInfo> f58791g;

    /* renamed from: h  reason: collision with root package name */
    public ArrayList<ContractInfo> f58792h;

    /* renamed from: i  reason: collision with root package name */
    public AtomicBoolean f58793i;
    public ContactStatus j;
    public List<ContactSelectModel.AllContact> k;
    public b l;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes10.dex */
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
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1769567431, "Lcom/baidu/wallet/lightapp/base/contacts/PhoneContactsMananger$ContactStatus;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1769567431, "Lcom/baidu/wallet/lightapp/base/contacts/PhoneContactsMananger$ContactStatus;");
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

    /* loaded from: classes10.dex */
    public interface c {
        void a(ArrayList<ContractInfo> arrayList);
    }

    /* loaded from: classes10.dex */
    public interface d {
        void a(List<ContactSelectModel.AllContact> list, int i2);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(500411623, "Lcom/baidu/wallet/lightapp/base/contacts/PhoneContactsMananger;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(500411623, "Lcom/baidu/wallet/lightapp/base/contacts/PhoneContactsMananger;");
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
        this.f58790f = new ConcurrentHashMap<>();
        this.f58791g = new ConcurrentHashMap<>();
        this.f58792h = new ArrayList<>();
        this.f58793i = new AtomicBoolean(false);
        this.j = ContactStatus.unload;
        this.k = null;
        this.l = null;
        b(context);
    }

    private boolean b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, this, context)) == null) {
            if (this.f58787c == null && context != null) {
                this.f58787c = DxmApplicationContextImpl.getApplicationContext(context);
            }
            return this.f58787c != null;
        }
        return invokeL.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65549, this) == null) {
            for (String str : this.f58790f.keySet()) {
                if (!this.f58792h.contains(this.f58790f.get(str))) {
                    this.f58792h.add(this.f58790f.get(str));
                }
            }
            for (String str2 : this.f58791g.keySet()) {
                if (!this.f58792h.contains(this.f58791g.get(str2))) {
                    this.f58792h.add(this.f58791g.get(str2));
                }
            }
        }
    }

    /* loaded from: classes10.dex */
    public class a extends AsyncTask<Integer, Void, List<ContactSelectModel.AllContact>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PhoneContactsMananger f58794a;

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
            this.f58794a = phoneContactsMananger;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public List<ContactSelectModel.AllContact> doInBackground(Integer... numArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, numArr)) == null) {
                this.f58794a.j = ContactStatus.loading;
                int intValue = (numArr == null || 1 > numArr.length) ? 350 : numArr[0].intValue();
                try {
                    this.f58794a.k = this.f58794a.a(com.baidu.wallet.lightapp.base.contacts.a.c(this.f58794a.f58787c), intValue > 0 ? 1000 < intValue ? 1000 : intValue : 350);
                } catch (Throwable unused) {
                    this.f58794a.k = null;
                }
                this.f58794a.j = ContactStatus.complited;
                return this.f58794a.k;
            }
            return (List) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public void onPostExecute(List<ContactSelectModel.AllContact> list) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) || this.f58794a.f58789e == null) {
                return;
            }
            this.f58794a.f58789e.a(this.f58794a.k, this.f58794a.k == null ? 0 : this.f58794a.k.size());
        }
    }

    public static synchronized PhoneContactsMananger a(Context context) {
        InterceptResult invokeL;
        PhoneContactsMananger phoneContactsMananger;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
            synchronized (PhoneContactsMananger.class) {
                if (f58786b == null) {
                    f58786b = new PhoneContactsMananger(context);
                }
                phoneContactsMananger = f58786b;
            }
            return phoneContactsMananger;
        }
        return (PhoneContactsMananger) invokeL.objValue;
    }

    public void a(int i2, boolean z) {
        List<ContactSelectModel.AllContact> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            if (this.f58793i.getAndSet(true) && z) {
                if (this.f58789e == null || (list = this.k) == null || ContactStatus.complited != this.j) {
                    return;
                }
                if (list.size() > i2) {
                    this.f58789e.a(this.k.subList(0, i2), i2);
                    return;
                } else {
                    this.f58789e.a(this.k, i2);
                    return;
                }
            }
            this.j = ContactStatus.unload;
            new a(this).execute(Integer.valueOf(i2));
        }
    }

    /* loaded from: classes10.dex */
    public class b extends AsyncTask<String, String, String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PhoneContactsMananger f58795a;

        /* renamed from: b  reason: collision with root package name */
        public ContactStatus f58796b;

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public String doInBackground(String... strArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, strArr)) == null) {
                this.f58796b = ContactStatus.loading;
                if (this.f58795a.f58790f.size() == 0) {
                    PhoneContactsMananger phoneContactsMananger = this.f58795a;
                    phoneContactsMananger.f58790f = com.baidu.wallet.lightapp.base.contacts.a.a(phoneContactsMananger.f58787c);
                }
                String str = PhoneContactsMananger.f58785a;
                LogUtil.d(str, "手机里面的通讯：" + this.f58795a.f58790f.toString());
                if (this.f58795a.f58791g.size() == 0) {
                    PhoneContactsMananger phoneContactsMananger2 = this.f58795a;
                    phoneContactsMananger2.f58791g = com.baidu.wallet.lightapp.base.contacts.a.b(phoneContactsMananger2.f58787c);
                }
                String str2 = PhoneContactsMananger.f58785a;
                LogUtil.d(str2, "Sim里面的通讯：" + this.f58795a.f58791g.toString());
                if (this.f58795a.f58792h == null || this.f58795a.f58792h.size() == 0) {
                    this.f58795a.b();
                }
                String str3 = PhoneContactsMananger.f58785a;
                LogUtil.d(str3, "本地所有的通讯录信息：" + this.f58795a.f58792h.toString());
                this.f58796b = ContactStatus.complited;
                return null;
            }
            return (String) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public void onPostExecute(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                if (this.f58795a.f58788d != null) {
                    this.f58795a.f58788d.a(this.f58795a.f58792h);
                }
                super.onPostExecute(str);
            }
        }
    }

    public void a(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dVar) == null) {
            this.f58789e = dVar;
        }
    }

    private ContactSelectModel.AllContact a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, this, str, str2)) == null) {
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
        return (ContactSelectModel.AllContact) invokeLL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<ContactSelectModel.AllContact> a(List<ContractInfo> list, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65544, this, list, i2)) == null) {
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
        return (List) invokeLI.objValue;
    }
}
