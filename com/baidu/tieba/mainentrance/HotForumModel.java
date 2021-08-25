package com.baidu.tieba.mainentrance;

import android.text.TextUtils;
import c.a.e.a.f;
import c.a.q0.t1.c;
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
/* loaded from: classes7.dex */
public class HotForumModel extends BdBaseModel {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public f f53899e;

    /* renamed from: f  reason: collision with root package name */
    public b f53900f;

    /* renamed from: g  reason: collision with root package name */
    public List<c.a.q0.t1.b> f53901g;

    /* renamed from: h  reason: collision with root package name */
    public HotSearchInfoData f53902h;

    /* renamed from: i  reason: collision with root package name */
    public List<c> f53903i;

    /* renamed from: j  reason: collision with root package name */
    public String f53904j;

    /* loaded from: classes7.dex */
    public class a extends c.a.e.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ HotForumModel f53905a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(HotForumModel hotForumModel, int i2, int i3) {
            super(i2, i3);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hotForumModel, Integer.valueOf(i2), Integer.valueOf(i3)};
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
            this.f53905a = hotForumModel;
        }

        @Override // c.a.e.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                boolean z = responsedMessage instanceof HotForumSocketResponseMessage;
                if (!z && !(responsedMessage instanceof HotForumHttpResponseMessage)) {
                    this.f53905a.f53900f.onHotForumDataFailed(this.f53905a.f53899e.getString(R.string.neterror));
                } else if (responsedMessage.getOrginalMessage() == null || !(responsedMessage.getOrginalMessage().getExtra() instanceof HotForumNetMessage)) {
                    this.f53905a.f53900f.onHotForumDataFailed(this.f53905a.f53899e.getString(R.string.neterror));
                } else if (!responsedMessage.hasError() && responsedMessage.getError() == 0) {
                    if (responsedMessage instanceof HotForumHttpResponseMessage) {
                        HotForumHttpResponseMessage hotForumHttpResponseMessage = (HotForumHttpResponseMessage) responsedMessage;
                        this.f53905a.f53901g = hotForumHttpResponseMessage.getForumInfoList();
                        this.f53905a.f53903i = hotForumHttpResponseMessage.getTopicInfoList();
                        this.f53905a.f53902h = hotForumHttpResponseMessage.getHotSearchInfo();
                        this.f53905a.f53904j = hotForumHttpResponseMessage.getTopicInfoTitle();
                        this.f53905a.f53900f.onHotForumDataSuccess(this.f53905a.f53901g, this.f53905a.f53903i, this.f53905a.f53902h, this.f53905a.f53904j);
                    }
                    if (z) {
                        HotForumSocketResponseMessage hotForumSocketResponseMessage = (HotForumSocketResponseMessage) responsedMessage;
                        this.f53905a.f53901g = hotForumSocketResponseMessage.getForumInfoList();
                        this.f53905a.f53903i = hotForumSocketResponseMessage.getTopicInfoList();
                        this.f53905a.f53902h = hotForumSocketResponseMessage.getSearchInfo();
                        this.f53905a.f53904j = hotForumSocketResponseMessage.getTopicInfoTitle();
                        this.f53905a.f53900f.onHotForumDataSuccess(this.f53905a.f53901g, this.f53905a.f53903i, this.f53905a.f53902h, this.f53905a.f53904j);
                    }
                } else if (!TextUtils.isEmpty(responsedMessage.getErrorString())) {
                    this.f53905a.f53900f.onHotForumDataFailed(responsedMessage.getErrorString());
                } else {
                    this.f53905a.f53900f.onHotForumDataFailed(this.f53905a.f53899e.getString(R.string.neterror));
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public interface b {
        void onHotForumDataFailed(String str);

        void onHotForumDataSuccess(List<c.a.q0.t1.b> list, List<c> list2, HotSearchInfoData hotSearchInfoData, String str);
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f53899e = fVar;
        this.f53900f = bVar;
        G();
    }

    public final void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            registerListener(new a(this, CmdConfigHttp.CMD_HTTP_GET_HOTFORUM, 303116));
        }
    }

    public void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            sendMessage(new HotForumNetMessage());
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
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
}
