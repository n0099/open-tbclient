package com.baidu.tieba.tblauncherInterestGuide.model;

import b.a.e.a.f;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.tieba.R;
import com.baidu.tieba.tblauncherInterestGuide.data.InterestFrsData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
/* loaded from: classes9.dex */
public class NewUserGuideModel extends BdBaseModel<BaseFragmentActivity> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int LIMIT = 100;
    public static final int OFFSET = 0;

    /* renamed from: h  reason: collision with root package name */
    public static final String f55397h;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public boolean f55398e;

    /* renamed from: f  reason: collision with root package name */
    public InterestFrsData f55399f;

    /* renamed from: g  reason: collision with root package name */
    public a f55400g;

    /* loaded from: classes9.dex */
    public static class a extends BdAsyncTask<Void, Void, InterestFrsData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f55401a;

        /* renamed from: b  reason: collision with root package name */
        public int f55402b;

        /* renamed from: c  reason: collision with root package name */
        public int f55403c;

        /* renamed from: d  reason: collision with root package name */
        public WeakReference<b> f55404d;

        public a(int i2, int i3, int i4, b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i5 = newInitContext.flag;
                if ((i5 & 1) != 0) {
                    int i6 = i5 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55401a = i2;
            this.f55402b = i3;
            this.f55403c = i4;
            this.f55404d = new WeakReference<>(bVar);
            setPriority(3);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public InterestFrsData doInBackground(Void... voidArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, voidArr)) == null) {
                NetWork netWork = new NetWork(NewUserGuideModel.f55397h);
                netWork.addPostData("user_type", String.valueOf(this.f55401a));
                netWork.addPostData("offset", String.valueOf(this.f55402b));
                netWork.addPostData(Constants.EXTRA_CONFIG_LIMIT, String.valueOf(this.f55403c));
                String postNetData = netWork.postNetData();
                if (netWork.getNetContext().getResponse().isRequestSuccess()) {
                    try {
                        return (InterestFrsData) OrmObject.objectWithJsonStr(postNetData, InterestFrsData.class);
                    } catch (Exception e2) {
                        BdLog.e(e2.getMessage());
                        InterestFrsData interestFrsData = new InterestFrsData();
                        interestFrsData.setErrno(-1000);
                        interestFrsData.setErrmsg(TbadkApplication.getInst().getContext().getString(R.string.neterror));
                        return interestFrsData;
                    }
                }
                InterestFrsData interestFrsData2 = new InterestFrsData();
                interestFrsData2.setErrno(netWork.getServerErrorCode() == 0 ? -1001 : netWork.getServerErrorCode());
                interestFrsData2.setErrmsg(netWork.getErrorString());
                return interestFrsData2;
            }
            return (InterestFrsData) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(InterestFrsData interestFrsData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, interestFrsData) == null) {
                super.onPostExecute(interestFrsData);
                b bVar = this.f55404d.get();
                if (bVar != null) {
                    if (interestFrsData.getErrno() == 0) {
                        bVar.a(interestFrsData);
                    } else {
                        bVar.b(interestFrsData);
                    }
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public interface b {
        void a(InterestFrsData interestFrsData);

        void b(InterestFrsData interestFrsData);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1679700094, "Lcom/baidu/tieba/tblauncherInterestGuide/model/NewUserGuideModel;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1679700094, "Lcom/baidu/tieba/tblauncherInterestGuide/model/NewUserGuideModel;");
                return;
            }
        }
        f55397h = TbConfig.SERVER_ADDRESS + "c/s/gettaglist";
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NewUserGuideModel(BaseFragmentActivity baseFragmentActivity) {
        super(baseFragmentActivity.getPageContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseFragmentActivity};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public void A(int i2, int i3, int i4, b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), bVar}) == null) {
            a aVar = new a(i2, i3, i4, bVar);
            this.f55400g = aVar;
            aVar.execute(new Void[0]);
        }
    }

    public void B(InterestFrsData interestFrsData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, interestFrsData) == null) {
            this.f55399f = interestFrsData;
        }
    }

    public void C(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            this.f55398e = z;
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean loadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public void x() {
        a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (aVar = this.f55400g) == null) {
            return;
        }
        aVar.cancel();
    }

    public InterestFrsData y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f55399f : (InterestFrsData) invokeV.objValue;
    }

    public boolean z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f55398e : invokeV.booleanValue;
    }
}
