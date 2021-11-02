package com.baidu.wallet.core;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.api.internal.IContacts;
import com.baidu.wallet.core.utils.contacts.ContractInfo;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes10.dex */
public final class ContactManager implements NoProguard {
    public static /* synthetic */ Interceptable $ic;
    public static IContacts sIContactsImpl;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes10.dex */
    public static class a implements IContacts, NoProguard {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.wallet.api.internal.IContacts
        public int countOfContacts(@NonNull Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) {
                return 0;
            }
            return invokeL.intValue;
        }

        @Override // com.baidu.wallet.api.internal.IContacts
        public List<ContractInfo> loadAllPhone(@NonNull Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) ? Collections.emptyList() : (List) invokeL.objValue;
        }

        @Override // com.baidu.wallet.api.internal.IContacts
        public List<String> loadPhoneContactsForChargeFragment(@NonNull Uri uri, @NonNull Context context) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, uri, context)) == null) ? Collections.emptyList() : (List) invokeLL.objValue;
        }

        @Override // com.baidu.wallet.api.internal.IContacts
        public ConcurrentHashMap<String, ContractInfo> loadPhoneContracts(@NonNull Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, context)) == null) ? new ConcurrentHashMap<>() : (ConcurrentHashMap) invokeL.objValue;
        }

        @Override // com.baidu.wallet.api.internal.IContacts
        public List<String> loadRawPhone(@NonNull Uri uri, @NonNull Context context) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, uri, context)) == null) ? Collections.emptyList() : (List) invokeLL.objValue;
        }

        @Override // com.baidu.wallet.api.internal.IContacts
        public ConcurrentHashMap<String, ContractInfo> loadSimContracts(@NonNull Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, context)) == null) ? new ConcurrentHashMap<>() : (ConcurrentHashMap) invokeL.objValue;
        }

        @Override // com.baidu.wallet.api.internal.IContacts
        public boolean pickContactsByContactsContentUri(@NonNull Activity activity, int i2) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(1048582, this, activity, i2)) == null) {
                return false;
            }
            return invokeLI.booleanValue;
        }

        @Override // com.baidu.wallet.api.internal.IContacts
        public boolean pickContactsByPhoneContentType(@NonNull Activity activity, int i2) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(1048583, this, activity, i2)) == null) {
                return false;
            }
            return invokeLI.booleanValue;
        }
    }

    public ContactManager() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static IContacts getIContactsImpl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (sIContactsImpl == null) {
                boolean z = false;
                try {
                    sIContactsImpl = (IContacts) Class.forName("com.baidu.wallet.impl.ContactsImpl").newInstance();
                } catch (Exception unused) {
                    z = true;
                }
                if (z) {
                    sIContactsImpl = new a();
                }
            }
            return sIContactsImpl;
        }
        return (IContacts) invokeV.objValue;
    }
}
