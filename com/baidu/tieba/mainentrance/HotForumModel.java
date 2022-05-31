package com.baidu.tieba.mainentrance;

import android.text.TextUtils;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.ad7;
import com.repackage.b9;
import com.repackage.bd7;
import com.repackage.wa;
import java.util.List;
/* loaded from: classes3.dex */
public class HotForumModel extends BdBaseModel {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public b9 a;
    public b b;
    public List<ad7> c;
    public HotSearchInfoData d;
    public List<bd7> e;
    public String f;

    /* loaded from: classes3.dex */
    public class a extends wa {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ HotForumModel a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(HotForumModel hotForumModel, int i, int i2) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hotForumModel, Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hotForumModel;
        }

        @Override // com.repackage.wa
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                boolean z = responsedMessage instanceof HotForumSocketResponseMessage;
                if (!z && !(responsedMessage instanceof HotForumHttpResponseMessage)) {
                    this.a.b.onHotForumDataFailed(this.a.a.getString(R.string.obfuscated_res_0x7f0f0c33));
                } else if (responsedMessage.getOrginalMessage() == null || !(responsedMessage.getOrginalMessage().getExtra() instanceof HotForumNetMessage)) {
                    this.a.b.onHotForumDataFailed(this.a.a.getString(R.string.obfuscated_res_0x7f0f0c33));
                } else if (!responsedMessage.hasError() && responsedMessage.getError() == 0) {
                    if (responsedMessage instanceof HotForumHttpResponseMessage) {
                        HotForumHttpResponseMessage hotForumHttpResponseMessage = (HotForumHttpResponseMessage) responsedMessage;
                        this.a.c = hotForumHttpResponseMessage.getForumInfoList();
                        this.a.e = hotForumHttpResponseMessage.getTopicInfoList();
                        this.a.d = hotForumHttpResponseMessage.getHotSearchInfo();
                        this.a.f = hotForumHttpResponseMessage.getTopicInfoTitle();
                        this.a.b.onHotForumDataSuccess(this.a.c, this.a.e, this.a.d, this.a.f);
                    }
                    if (z) {
                        HotForumSocketResponseMessage hotForumSocketResponseMessage = (HotForumSocketResponseMessage) responsedMessage;
                        this.a.c = hotForumSocketResponseMessage.getForumInfoList();
                        this.a.e = hotForumSocketResponseMessage.getTopicInfoList();
                        this.a.d = hotForumSocketResponseMessage.getSearchInfo();
                        this.a.f = hotForumSocketResponseMessage.getTopicInfoTitle();
                        this.a.b.onHotForumDataSuccess(this.a.c, this.a.e, this.a.d, this.a.f);
                    }
                } else if (!TextUtils.isEmpty(responsedMessage.getErrorString())) {
                    this.a.b.onHotForumDataFailed(responsedMessage.getErrorString());
                } else {
                    this.a.b.onHotForumDataFailed(this.a.a.getString(R.string.obfuscated_res_0x7f0f0c33));
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void onHotForumDataFailed(String str);

        void onHotForumDataSuccess(List<ad7> list, List<bd7> list2, HotSearchInfoData hotSearchInfoData, String str);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HotForumModel(b9 b9Var, b bVar) {
        super(b9Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {b9Var, bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((b9) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = b9Var;
        this.b = bVar;
        I();
    }

    public final void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            registerListener(new a(this, CmdConfigHttp.CMD_HTTP_GET_HOTFORUM, 303116));
        }
    }

    public void J() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            sendMessage(new HotForumNetMessage());
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

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean loadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }
}
