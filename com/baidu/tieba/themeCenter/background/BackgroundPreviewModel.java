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
/* loaded from: classes4.dex */
public class BackgroundPreviewModel extends BdBaseModel<BackgroundPreviewModel> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public DressItemData f21566e;

    /* renamed from: f  reason: collision with root package name */
    public int f21567f;

    /* renamed from: g  reason: collision with root package name */
    public int f21568g;

    /* renamed from: h  reason: collision with root package name */
    public b f21569h;

    /* renamed from: i  reason: collision with root package name */
    public d.a.d.c.g.a f21570i;

    /* loaded from: classes4.dex */
    public class a extends d.a.d.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ BackgroundPreviewModel f21571a;

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
            this.f21571a = backgroundPreviewModel;
        }

        @Override // d.a.d.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) || responsedMessage == null) {
                return;
            }
            boolean z = responsedMessage instanceof BackgroundGetHttpResponseMessage;
            if (z || (responsedMessage instanceof BackgroundGetSocketResponseMessage)) {
                if (responsedMessage.getError() == 0) {
                    if (z) {
                        this.f21571a.f21566e = ((BackgroundGetHttpResponseMessage) responsedMessage).getBgItem();
                    } else if (responsedMessage instanceof BackgroundGetSocketResponseMessage) {
                        this.f21571a.f21566e = ((BackgroundGetSocketResponseMessage) responsedMessage).getBgItem();
                    }
                }
                if (this.f21571a.f21569h != null) {
                    if (this.f21571a.f21566e != null) {
                        this.f21571a.f21566e.setPropsId(this.f21571a.f21567f);
                        this.f21571a.f21566e.setInUse(this.f21571a.f21568g == 1);
                    }
                    this.f21571a.f21569h.a(responsedMessage.getError(), responsedMessage.getErrorString(), this.f21571a.f21566e);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
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
        this.f21570i = new a(this, CmdConfigHttp.CMD_PERSONAL_BACKGROUND_GET, 309023);
        this.f21567f = i2;
        this.f21568g = i3;
        registerTask();
        registerListener(this.f21570i);
    }

    public void B(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
            this.f21569h = bVar;
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            BackgroundGetRequestMessage backgroundGetRequestMessage = new BackgroundGetRequestMessage();
            backgroundGetRequestMessage.setPropId(this.f21567f);
            sendMessage(backgroundGetRequestMessage);
            return false;
        }
        return invokeV.booleanValue;
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
            MessageManager.getInstance().unRegisterListener(this.f21570i);
        }
    }

    public final void registerTask() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            d.a.q0.h3.d0.a.h(309023, BackgroundGetSocketResponseMessage.class, false, false);
            d.a.q0.h3.d0.a.c(309023, CmdConfigHttp.CMD_PERSONAL_BACKGROUND_GET, TbConfig.PERSONAL_BACKGROUND_GET, BackgroundGetHttpResponseMessage.class, false, false, false, false);
        }
    }
}
