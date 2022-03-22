package com.baidu.tieba.mainentrance;

import android.text.TextUtils;
import c.a.d.a.f;
import c.a.p0.g2.c;
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
import java.util.List;
/* loaded from: classes5.dex */
public class HotForumModel extends BdBaseModel {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public f a;

    /* renamed from: b  reason: collision with root package name */
    public b f34333b;

    /* renamed from: c  reason: collision with root package name */
    public List<c.a.p0.g2.b> f34334c;

    /* renamed from: d  reason: collision with root package name */
    public HotSearchInfoData f34335d;

    /* renamed from: e  reason: collision with root package name */
    public List<c> f34336e;

    /* renamed from: f  reason: collision with root package name */
    public String f34337f;

    /* loaded from: classes5.dex */
    public class a extends c.a.d.c.g.a {
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

        @Override // c.a.d.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                boolean z = responsedMessage instanceof HotForumSocketResponseMessage;
                if (!z && !(responsedMessage instanceof HotForumHttpResponseMessage)) {
                    this.a.f34333b.onHotForumDataFailed(this.a.a.getString(R.string.obfuscated_res_0x7f0f0c15));
                } else if (responsedMessage.getOrginalMessage() == null || !(responsedMessage.getOrginalMessage().getExtra() instanceof HotForumNetMessage)) {
                    this.a.f34333b.onHotForumDataFailed(this.a.a.getString(R.string.obfuscated_res_0x7f0f0c15));
                } else if (!responsedMessage.hasError() && responsedMessage.getError() == 0) {
                    if (responsedMessage instanceof HotForumHttpResponseMessage) {
                        HotForumHttpResponseMessage hotForumHttpResponseMessage = (HotForumHttpResponseMessage) responsedMessage;
                        this.a.f34334c = hotForumHttpResponseMessage.getForumInfoList();
                        this.a.f34336e = hotForumHttpResponseMessage.getTopicInfoList();
                        this.a.f34335d = hotForumHttpResponseMessage.getHotSearchInfo();
                        this.a.f34337f = hotForumHttpResponseMessage.getTopicInfoTitle();
                        this.a.f34333b.onHotForumDataSuccess(this.a.f34334c, this.a.f34336e, this.a.f34335d, this.a.f34337f);
                    }
                    if (z) {
                        HotForumSocketResponseMessage hotForumSocketResponseMessage = (HotForumSocketResponseMessage) responsedMessage;
                        this.a.f34334c = hotForumSocketResponseMessage.getForumInfoList();
                        this.a.f34336e = hotForumSocketResponseMessage.getTopicInfoList();
                        this.a.f34335d = hotForumSocketResponseMessage.getSearchInfo();
                        this.a.f34337f = hotForumSocketResponseMessage.getTopicInfoTitle();
                        this.a.f34333b.onHotForumDataSuccess(this.a.f34334c, this.a.f34336e, this.a.f34335d, this.a.f34337f);
                    }
                } else if (!TextUtils.isEmpty(responsedMessage.getErrorString())) {
                    this.a.f34333b.onHotForumDataFailed(responsedMessage.getErrorString());
                } else {
                    this.a.f34333b.onHotForumDataFailed(this.a.a.getString(R.string.obfuscated_res_0x7f0f0c15));
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface b {
        void onHotForumDataFailed(String str);

        void onHotForumDataSuccess(List<c.a.p0.g2.b> list, List<c> list2, HotSearchInfoData hotSearchInfoData, String str);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HotForumModel(f fVar, b bVar) {
        super(fVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fVar, bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = fVar;
        this.f34333b = bVar;
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
