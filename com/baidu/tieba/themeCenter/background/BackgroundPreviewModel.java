package com.baidu.tieba.themeCenter.background;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes13.dex */
public class BackgroundPreviewModel extends BdBaseModel<BackgroundPreviewModel> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public DressItemData f48441e;

    /* renamed from: f  reason: collision with root package name */
    public int f48442f;

    /* renamed from: g  reason: collision with root package name */
    public int f48443g;

    /* renamed from: h  reason: collision with root package name */
    public b f48444h;

    /* renamed from: i  reason: collision with root package name */
    public c.a.d.c.g.a f48445i;

    /* loaded from: classes13.dex */
    public class a extends c.a.d.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BackgroundPreviewModel a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(BackgroundPreviewModel backgroundPreviewModel, int i2, int i3) {
            super(i2, i3);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {backgroundPreviewModel, Integer.valueOf(i2), Integer.valueOf(i3)};
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
            this.a = backgroundPreviewModel;
        }

        @Override // c.a.d.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) || responsedMessage == null) {
                return;
            }
            boolean z = responsedMessage instanceof BackgroundGetHttpResponseMessage;
            if (z || (responsedMessage instanceof BackgroundGetSocketResponseMessage)) {
                if (responsedMessage.getError() == 0) {
                    if (z) {
                        this.a.f48441e = ((BackgroundGetHttpResponseMessage) responsedMessage).getBgItem();
                    } else if (responsedMessage instanceof BackgroundGetSocketResponseMessage) {
                        this.a.f48441e = ((BackgroundGetSocketResponseMessage) responsedMessage).getBgItem();
                    }
                }
                if (this.a.f48444h != null) {
                    if (this.a.f48441e != null) {
                        this.a.f48441e.setPropsId(this.a.f48442f);
                        this.a.f48441e.setInUse(this.a.f48443g == 1);
                    }
                    this.a.f48444h.a(responsedMessage.getError(), responsedMessage.getErrorString(), this.a.f48441e);
                }
            }
        }
    }

    /* loaded from: classes13.dex */
    public interface b {
        void a(int i2, String str, DressItemData dressItemData);
    }

    public BackgroundPreviewModel(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f48445i = new a(this, CmdConfigHttp.CMD_PERSONAL_BACKGROUND_GET, 309023);
        this.f48442f = i2;
        this.f48443g = i3;
        registerTask();
        registerListener(this.f48445i);
    }

    public void B(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
            this.f48444h = bVar;
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.f48445i);
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean loadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            BackgroundGetRequestMessage backgroundGetRequestMessage = new BackgroundGetRequestMessage();
            backgroundGetRequestMessage.setPropId(this.f48442f);
            sendMessage(backgroundGetRequestMessage);
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void registerTask() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            c.a.t0.x3.f0.a.h(309023, BackgroundGetSocketResponseMessage.class, false, false);
            c.a.t0.x3.f0.a.c(309023, CmdConfigHttp.CMD_PERSONAL_BACKGROUND_GET, TbConfig.PERSONAL_BACKGROUND_GET, BackgroundGetHttpResponseMessage.class, false, false, false, false);
        }
    }
}
