package com.baidu.tieba.themeCenter.dressCenter;

import c.a.r0.p3.h.d;
import c.a.r0.p3.h.e;
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
/* loaded from: classes7.dex */
public class DressupCenterModel extends BdBaseModel<DressupCenterModel> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public List<d> f57625e;

    /* renamed from: f  reason: collision with root package name */
    public e f57626f;

    /* renamed from: g  reason: collision with root package name */
    public List<c.a.r0.p3.h.a> f57627g;

    /* renamed from: h  reason: collision with root package name */
    public b f57628h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f57629i;

    /* renamed from: j  reason: collision with root package name */
    public c.a.e.c.g.a f57630j;

    /* loaded from: classes7.dex */
    public class a extends c.a.e.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ DressupCenterModel f57631a;

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
            this.f57631a = dressupCenterModel;
        }

        @Override // c.a.e.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) || responsedMessage == null) {
                return;
            }
            boolean z = responsedMessage instanceof DressupCenterHttpResponseMessage;
            if (z || (responsedMessage instanceof DressupCenterSocketResponseMessage)) {
                if (responsedMessage.getError() != 0) {
                    if (this.f57631a.f57628h != null) {
                        this.f57631a.f57628h.a(responsedMessage.getError(), responsedMessage.getErrorString(), this.f57631a.f57627g, this.f57631a.f57626f, this.f57631a.f57625e);
                        return;
                    }
                    return;
                }
                if (z) {
                    DressupCenterHttpResponseMessage dressupCenterHttpResponseMessage = (DressupCenterHttpResponseMessage) responsedMessage;
                    this.f57631a.f57625e = dressupCenterHttpResponseMessage.getThemeList();
                    this.f57631a.f57626f = dressupCenterHttpResponseMessage.getRecommand();
                    this.f57631a.f57627g = dressupCenterHttpResponseMessage.getThemeCarouselList();
                } else if (responsedMessage instanceof DressupCenterSocketResponseMessage) {
                    DressupCenterSocketResponseMessage dressupCenterSocketResponseMessage = (DressupCenterSocketResponseMessage) responsedMessage;
                    this.f57631a.f57625e = dressupCenterSocketResponseMessage.getThemeList();
                    this.f57631a.f57626f = dressupCenterSocketResponseMessage.getRecommand();
                    this.f57631a.f57627g = dressupCenterSocketResponseMessage.getThemeCarouselList();
                }
                if (this.f57631a.f57628h != null) {
                    this.f57631a.f57628h.a(responsedMessage.getError(), responsedMessage.getErrorString(), this.f57631a.f57627g, this.f57631a.f57626f, this.f57631a.f57625e);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public interface b {
        void a(int i2, String str, List<c.a.r0.p3.h.a> list, e eVar, List<d> list2);
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
        this.f57630j = new a(this, CmdConfigHttp.CMD_DRESSUP_CENTER, 309001);
        this.f57629i = dressupCenterActivity.getIntent().getBooleanExtra(IntentConfig.MEMBER_BUY_SHOW, false);
        registerTask();
        registerListener(this.f57630j);
    }

    public boolean D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f57629i : invokeV.booleanValue;
    }

    public void E(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) {
            this.f57628h = bVar;
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            sendMessage(new DressupCenterRequestMessage());
            return false;
        }
        return invokeV.booleanValue;
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

    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.f57630j);
        }
    }

    public final void registerTask() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            c.a.r0.j3.e0.a.h(309001, DressupCenterSocketResponseMessage.class, false, false);
            c.a.r0.j3.e0.a.c(309001, CmdConfigHttp.CMD_DRESSUP_CENTER, TbConfig.DRESSUP_CENTER_PAGE, DressupCenterHttpResponseMessage.class, false, false, false, false);
        }
    }
}
