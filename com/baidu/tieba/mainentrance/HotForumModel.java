package com.baidu.tieba.mainentrance;

import android.text.TextUtils;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.R;
import com.baidu.tieba.a9;
import com.baidu.tieba.b68;
import com.baidu.tieba.c68;
import com.baidu.tieba.za;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes5.dex */
public class HotForumModel extends BdBaseModel {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public a9 a;
    public b b;
    public List<b68> c;
    public HotSearchInfoData d;
    public List<c68> e;
    public String f;

    /* loaded from: classes5.dex */
    public interface b {
        void F(String str);

        void r(List<b68> list, List<c68> list2, HotSearchInfoData hotSearchInfoData, String str);
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

    /* loaded from: classes5.dex */
    public class a extends za {
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

        @Override // com.baidu.tieba.za
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                boolean z = responsedMessage instanceof HotForumSocketResponseMessage;
                if (!z && !(responsedMessage instanceof HotForumHttpResponseMessage)) {
                    this.a.b.F(this.a.a.getString(R.string.obfuscated_res_0x7f0f0d1f));
                } else if (responsedMessage.getOrginalMessage() != null && (responsedMessage.getOrginalMessage().getExtra() instanceof HotForumNetMessage)) {
                    if (!responsedMessage.hasError() && responsedMessage.getError() == 0) {
                        if (responsedMessage instanceof HotForumHttpResponseMessage) {
                            HotForumHttpResponseMessage hotForumHttpResponseMessage = (HotForumHttpResponseMessage) responsedMessage;
                            this.a.c = hotForumHttpResponseMessage.getForumInfoList();
                            this.a.e = hotForumHttpResponseMessage.getTopicInfoList();
                            this.a.d = hotForumHttpResponseMessage.getHotSearchInfo();
                            this.a.f = hotForumHttpResponseMessage.getTopicInfoTitle();
                            this.a.b.r(this.a.c, this.a.e, this.a.d, this.a.f);
                        }
                        if (z) {
                            HotForumSocketResponseMessage hotForumSocketResponseMessage = (HotForumSocketResponseMessage) responsedMessage;
                            this.a.c = hotForumSocketResponseMessage.getForumInfoList();
                            this.a.e = hotForumSocketResponseMessage.getTopicInfoList();
                            this.a.d = hotForumSocketResponseMessage.getSearchInfo();
                            this.a.f = hotForumSocketResponseMessage.getTopicInfoTitle();
                            this.a.b.r(this.a.c, this.a.e, this.a.d, this.a.f);
                        }
                    } else if (!TextUtils.isEmpty(responsedMessage.getErrorString())) {
                        this.a.b.F(responsedMessage.getErrorString());
                    } else {
                        this.a.b.F(this.a.a.getString(R.string.obfuscated_res_0x7f0f0d1f));
                    }
                } else {
                    this.a.b.F(this.a.a.getString(R.string.obfuscated_res_0x7f0f0d1f));
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HotForumModel(a9 a9Var, b bVar) {
        super(a9Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {a9Var, bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((a9) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = a9Var;
        this.b = bVar;
        b0();
    }

    public final void b0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            registerListener(new a(this, CmdConfigHttp.CMD_HTTP_GET_HOTFORUM, 303116));
        }
    }

    public void c0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            sendMessage(new HotForumNetMessage());
        }
    }
}
