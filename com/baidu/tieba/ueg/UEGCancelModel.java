package com.baidu.tieba.ueg;

import android.text.TextUtils;
import c.a.d.f.p.l;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.BlockPopInfoData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes12.dex */
public class UEGCancelModel extends BdBaseModel {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public b f48496e;

    /* renamed from: f  reason: collision with root package name */
    public final c.a.d.c.g.a f48497f;

    /* loaded from: classes12.dex */
    public class a extends c.a.d.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ UEGCancelModel a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(UEGCancelModel uEGCancelModel, int i2, int i3) {
            super(i2, i3);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uEGCancelModel, Integer.valueOf(i2), Integer.valueOf(i3)};
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
            this.a = uEGCancelModel;
        }

        @Override // c.a.d.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            UEGCancelResponsedMessage uEGCancelResponsedMessage;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) || responsedMessage == null) {
                return;
            }
            boolean z = responsedMessage instanceof UEGCancelSocketResponseMessage;
            if ((z || (responsedMessage instanceof UEGCancelResponsedMessage)) && this.a.f48496e != null) {
                if (z) {
                    UEGCancelSocketResponseMessage uEGCancelSocketResponseMessage = (UEGCancelSocketResponseMessage) responsedMessage;
                    if (uEGCancelSocketResponseMessage != null && uEGCancelSocketResponseMessage.getError() == 0) {
                        this.a.f48496e.a(uEGCancelSocketResponseMessage.getData());
                    }
                } else if ((responsedMessage instanceof UEGCancelResponsedMessage) && (uEGCancelResponsedMessage = (UEGCancelResponsedMessage) responsedMessage) != null && uEGCancelResponsedMessage.getError() == 0) {
                    this.a.f48496e.a(uEGCancelResponsedMessage.getData());
                }
            }
        }
    }

    /* loaded from: classes12.dex */
    public interface b {
        void a(BlockPopInfoData blockPopInfoData);
    }

    public UEGCancelModel() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f48497f = new a(this, CmdConfigHttp.CMD_UEG_CANCEL, 309615);
        c.a.t0.w3.f0.a.h(309615, UEGCancelSocketResponseMessage.class, false, false);
        c.a.t0.w3.f0.a.c(309615, CmdConfigHttp.CMD_UEG_CANCEL, "c/f/forum/queryBlockAndAppealInfo", UEGCancelResponsedMessage.class, false, false, true, false);
        registerListener(this.f48497f);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean loadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.f48497f);
        }
    }

    public void x() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && l.z() && !TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
            UEGCancelRequestMessage uEGCancelRequestMessage = new UEGCancelRequestMessage();
            uEGCancelRequestMessage.setUser_id(TbadkCoreApplication.getCurrentAccount());
            MessageManager.getInstance().sendMessage(uEGCancelRequestMessage);
        }
    }

    public void y(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bVar) == null) {
            this.f48496e = bVar;
        }
    }
}
