package com.baidu.tieba.service;

import android.content.Intent;
import android.location.Address;
import android.os.IBinder;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseService;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.model.ReportUserInfoModel;
import com.baidu.tieba.on9;
import com.baidu.tieba.pf;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class UpdateInfoService extends BdBaseService {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public pf.c locationCallBack;
    public ReportUserInfoModel mModel;

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, intent)) == null) {
            return null;
        }
        return (IBinder) invokeL.objValue;
    }

    /* loaded from: classes7.dex */
    public class a implements ReportUserInfoModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ UpdateInfoService a;

        public a(UpdateInfoService updateInfoService) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {updateInfoService};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = updateInfoService;
        }

        @Override // com.baidu.tieba.model.ReportUserInfoModel.b
        public void onError(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i, str) == null) {
                BdLog.i("location_errorCode&errorCode=" + i + "&errorMsg" + str);
                this.a.mModel.Z(600000L);
            }
        }

        @Override // com.baidu.tieba.model.ReportUserInfoModel.b
        public void onSuccess(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
                BdLog.i("location_success");
                BdLog.e("location_success next time=" + i);
                if (i <= 0) {
                    i = 3600;
                } else if (i >= 32400) {
                    i = 32400;
                }
                this.a.mModel.Z(i * 1000);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements pf.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ UpdateInfoService a;

        public b(UpdateInfoService updateInfoService) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {updateInfoService};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = updateInfoService;
        }

        @Override // com.baidu.tieba.pf.c
        public void a(int i, String str, Address address) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeILL(1048576, this, i, str, address) == null) && i == 0 && address != null) {
                float longitude = (float) address.getLongitude();
                float latitude = (float) address.getLatitude();
                on9.e().j(String.valueOf(longitude));
                on9.e().i(String.valueOf(latitude));
                on9.e().k(System.currentTimeMillis());
                if (this.a.mModel.V() && TbadkCoreApplication.getInst().getLocationShared() && !TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
                    this.a.mModel.X(1, longitude, latitude);
                    this.a.mModel.Y();
                }
            }
        }
    }

    public UpdateInfoService() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.locationCallBack = new b(this);
    }

    private void findLocationFromLocal() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            pf.n().k(false, this.locationCallBack);
        }
    }

    private void unRegisterLocalLocation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            pf.n().s(this.locationCallBack);
        }
    }

    @Override // com.baidu.adp.base.BdBaseService, android.app.Service
    public void onCreate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.onCreate();
            ReportUserInfoModel reportUserInfoModel = new ReportUserInfoModel(null);
            this.mModel = reportUserInfoModel;
            reportUserInfoModel.W();
            this.mModel.Z(540000L);
            this.mModel.a0(new a(this));
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.onDestroy();
            unRegisterLocalLocation();
            this.mModel.unRegisterListener();
        }
    }

    @Override // android.app.Service
    public void onStart(Intent intent, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048579, this, intent, i) == null) {
            super.onStart(intent, i);
            if (this.mModel.V()) {
                findLocationFromLocal();
            }
        }
    }
}
