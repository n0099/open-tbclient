package com.baidu.tieba;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import androidx.annotation.NonNull;
import com.baidu.adp.TbadkCore;
import com.baidu.adp.base.BdDatabaseNewCreatedMessage;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.NetWorkChangedMessage;
import com.baidu.adp.lib.util.NetworkState;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.runtime.service.ServiceNotFoundException;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes8.dex */
public class w16 extends fg1<TbadkCore> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public class a implements TbadkCore {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: com.baidu.tieba.w16$a$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class C0511a extends CustomMessageListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ String a;
            public final /* synthetic */ HashMap b;
            public final /* synthetic */ HashMap c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0511a(a aVar, int i, String str, HashMap hashMap, HashMap hashMap2) {
                super(i);
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, Integer.valueOf(i), str, hashMap, hashMap2};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        super(((Integer) newInitContext.callArgs[0]).intValue());
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = str;
                this.b = hashMap;
                this.c = hashMap2;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                String databaseFile;
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage instanceof BdDatabaseNewCreatedMessage) && (databaseFile = ((BdDatabaseNewCreatedMessage) customResponsedMessage).getDatabaseFile()) != null && databaseFile.contains(this.a)) {
                    this.b.clear();
                    this.c.clear();
                }
            }
        }

        public a(w16 w16Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {w16Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.adp.TbadkCore
        public void createAllTablesMessage(SQLiteDatabase sQLiteDatabase) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, sQLiteDatabase) == null) {
                MessageManager.getInstance().dispatchResponsedMessageToUI(new BdDatabaseNewCreatedMessage(sQLiteDatabase));
            }
        }

        @Override // com.baidu.adp.TbadkCore
        public void dispatchNetWorkChangedMessage(NetworkState networkState) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, networkState) == null) {
                MessageManager.getInstance().dispatchResponsedMessage(new NetWorkChangedMessage(networkState));
            }
        }

        @Override // com.baidu.adp.TbadkCore
        public boolean permissionUtilCheckReadPhoneState(@NonNull Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, context)) == null) {
                return PermissionUtil.checkReadPhoneState(context);
            }
            return invokeL.booleanValue;
        }

        @Override // com.baidu.adp.TbadkCore
        public boolean isNetWorkAvailable() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return BdNetTypeUtil.isNetWorkAvailable();
            }
            return invokeV.booleanValue;
        }

        @Override // com.baidu.adp.TbadkCore
        public boolean permissionUtilIsAgreePrivacyPolicy() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return PermissionUtil.isAgreePrivacyPolicy();
            }
            return invokeV.booleanValue;
        }

        @Override // com.baidu.adp.TbadkCore
        public void statHttpsDownToHttp() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
                BdStatisticsManager.getInstance().eventStat(null, "c13429", "", 1, "obj_type", "1");
            }
        }

        @Override // com.baidu.adp.TbadkCore
        @NonNull
        public String tbConfigGetVersion() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                String version = TbConfig.getVersion();
                if (version == null) {
                    return "";
                }
                return version;
            }
            return (String) invokeV.objValue;
        }

        @Override // com.baidu.adp.TbadkCore
        public void registerDbListener(String str, HashMap hashMap, HashMap hashMap2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048581, this, str, hashMap, hashMap2) == null) {
                MessageManager.getInstance().registerListenerFromBackground(new C0511a(this, 2000998, str, hashMap, hashMap2));
            }
        }
    }

    public w16() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.fg1
    /* renamed from: a */
    public TbadkCore createService() throws ServiceNotFoundException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return new a(this);
        }
        return (TbadkCore) invokeV.objValue;
    }
}
