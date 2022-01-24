package com.baidu.tieba.themeCenter.dressCenter;

import c.a.t0.c4.h.d;
import c.a.t0.c4.h.e;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes13.dex */
public class DressupCenterModel extends BdBaseModel<DressupCenterModel> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public List<d> f48491e;

    /* renamed from: f  reason: collision with root package name */
    public e f48492f;

    /* renamed from: g  reason: collision with root package name */
    public List<c.a.t0.c4.h.a> f48493g;

    /* renamed from: h  reason: collision with root package name */
    public b f48494h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f48495i;

    /* renamed from: j  reason: collision with root package name */
    public c.a.d.c.g.a f48496j;

    /* loaded from: classes13.dex */
    public class a extends c.a.d.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DressupCenterModel a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(DressupCenterModel dressupCenterModel, int i2, int i3) {
            super(i2, i3);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dressupCenterModel, Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dressupCenterModel;
        }

        @Override // c.a.d.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) || responsedMessage == null) {
                return;
            }
            boolean z = responsedMessage instanceof DressupCenterHttpResponseMessage;
            if (z || (responsedMessage instanceof DressupCenterSocketResponseMessage)) {
                if (responsedMessage.getError() != 0) {
                    if (this.a.f48494h != null) {
                        this.a.f48494h.a(responsedMessage.getError(), responsedMessage.getErrorString(), this.a.f48493g, this.a.f48492f, this.a.f48491e);
                        return;
                    }
                    return;
                }
                if (z) {
                    DressupCenterHttpResponseMessage dressupCenterHttpResponseMessage = (DressupCenterHttpResponseMessage) responsedMessage;
                    this.a.f48491e = dressupCenterHttpResponseMessage.getThemeList();
                    this.a.f48492f = dressupCenterHttpResponseMessage.getRecommand();
                    this.a.f48493g = dressupCenterHttpResponseMessage.getThemeCarouselList();
                } else if (responsedMessage instanceof DressupCenterSocketResponseMessage) {
                    DressupCenterSocketResponseMessage dressupCenterSocketResponseMessage = (DressupCenterSocketResponseMessage) responsedMessage;
                    this.a.f48491e = dressupCenterSocketResponseMessage.getThemeList();
                    this.a.f48492f = dressupCenterSocketResponseMessage.getRecommand();
                    this.a.f48493g = dressupCenterSocketResponseMessage.getThemeCarouselList();
                }
                if (this.a.f48494h != null) {
                    this.a.f48494h.a(responsedMessage.getError(), responsedMessage.getErrorString(), this.a.f48493g, this.a.f48492f, this.a.f48491e);
                }
            }
        }
    }

    /* loaded from: classes13.dex */
    public interface b {
        void a(int i2, String str, List<c.a.t0.c4.h.a> list, e eVar, List<d> list2);
    }

    public DressupCenterModel(DressupCenterActivity dressupCenterActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {dressupCenterActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f48496j = new a(this, CmdConfigHttp.CMD_DRESSUP_CENTER, 309001);
        this.f48495i = dressupCenterActivity.getIntent().getBooleanExtra(IntentConfig.MEMBER_BUY_SHOW, false);
        registerTask();
        registerListener(this.f48496j);
    }

    public boolean D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f48495i : invokeV.booleanValue;
    }

    public void E(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) {
            this.f48494h = bVar;
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.f48496j);
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean loadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            sendMessage(new DressupCenterRequestMessage());
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void registerTask() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            c.a.t0.x3.f0.a.h(309001, DressupCenterSocketResponseMessage.class, false, false);
            c.a.t0.x3.f0.a.c(309001, CmdConfigHttp.CMD_DRESSUP_CENTER, TbConfig.DRESSUP_CENTER_PAGE, DressupCenterHttpResponseMessage.class, false, false, false, false);
        }
    }
}
