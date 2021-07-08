package com.baidu.tieba.imMessageCenter.mention;

import android.text.TextUtils;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.BaijiahaoData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.a.f;
/* loaded from: classes4.dex */
public class ReplyMeModel extends BdBaseModel {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext f17910e;

    /* renamed from: f  reason: collision with root package name */
    public b f17911f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.c.c.g.a f17912g;

    /* loaded from: classes4.dex */
    public class a extends d.a.c.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ReplyMeModel f17913a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(ReplyMeModel replyMeModel, int i2, int i3) {
            super(i2, i3);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {replyMeModel, Integer.valueOf(i2), Integer.valueOf(i3)};
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
            this.f17913a = replyMeModel;
        }

        /* JADX WARN: Removed duplicated region for block: B:37:0x00d0  */
        /* JADX WARN: Removed duplicated region for block: B:40:0x00e2  */
        @Override // d.a.c.c.g.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            long forumId;
            long postState;
            long quoteId;
            long repostId;
            String forumName;
            long j;
            long tid;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) || responsedMessage == null) {
                return;
            }
            boolean z = responsedMessage instanceof CheckPostResponseMessage;
            if (!z && !(responsedMessage instanceof CheckPostHttpResponseMessage)) {
                this.f17913a.f17910e.showToast(R.string.neterror);
            } else if (responsedMessage.hasError()) {
                if (!TextUtils.isEmpty(responsedMessage.getErrorString())) {
                    this.f17913a.f17910e.showToast(responsedMessage.getErrorString());
                } else {
                    this.f17913a.f17910e.showToast(R.string.neterror);
                }
            } else {
                if (z) {
                    CheckPostResponseMessage checkPostResponseMessage = (CheckPostResponseMessage) responsedMessage;
                    forumId = checkPostResponseMessage.getForumId();
                    postState = checkPostResponseMessage.getPostState();
                    quoteId = checkPostResponseMessage.getQuoteId();
                    repostId = checkPostResponseMessage.getRepostId();
                    forumName = checkPostResponseMessage.getForumName();
                    tid = (responsedMessage.getOrginalMessage() == null || !(checkPostResponseMessage.getOrginalMessage().getExtra() instanceof CheckPostRequestMessage)) ? 0L : ((CheckPostRequestMessage) checkPostResponseMessage.getOrginalMessage().getExtra()).getTid();
                } else {
                    CheckPostHttpResponseMessage checkPostHttpResponseMessage = (CheckPostHttpResponseMessage) responsedMessage;
                    forumId = checkPostHttpResponseMessage.getForumId();
                    postState = checkPostHttpResponseMessage.getPostState();
                    quoteId = checkPostHttpResponseMessage.getQuoteId();
                    repostId = checkPostHttpResponseMessage.getRepostId();
                    forumName = checkPostHttpResponseMessage.getForumName();
                    if (responsedMessage.getOrginalMessage() == null || !(checkPostHttpResponseMessage.getOrginalMessage().getExtra() instanceof CheckPostRequestMessage)) {
                        j = 0;
                        long j2 = forumId;
                        long j3 = quoteId;
                        long j4 = repostId;
                        String str = forumName;
                        if (postState != 1) {
                            if (this.f17913a.f17911f != null) {
                                this.f17913a.f17911f.a(j2, j3, j4, str, j);
                                return;
                            }
                            return;
                        } else if (postState == 0) {
                            this.f17913a.f17910e.showToast(R.string.thread_delete_tip);
                            return;
                        } else if (postState == -1) {
                            this.f17913a.f17910e.showToast(R.string.thread_shield_tip);
                            return;
                        } else {
                            return;
                        }
                    }
                    tid = ((CheckPostRequestMessage) checkPostHttpResponseMessage.getOrginalMessage().getExtra()).getTid();
                }
                j = tid;
                long j22 = forumId;
                long j32 = quoteId;
                long j42 = repostId;
                String str2 = forumName;
                if (postState != 1) {
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface b {
        void a(long j, long j2, long j3, String str, long j4);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-922618870, "Lcom/baidu/tieba/imMessageCenter/mention/ReplyMeModel;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-922618870, "Lcom/baidu/tieba/imMessageCenter/mention/ReplyMeModel;");
                return;
            }
        }
        d.a.p0.h3.d0.a.f(303010, CheckPostResponseMessage.class, false);
        d.a.p0.h3.d0.a.c(303010, CmdConfigHttp.CMD_CHECK_POST, "c/f/check/checkpost", CheckPostHttpResponseMessage.class, true, true, false, false);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReplyMeModel(TbPageContext tbPageContext) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
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
        this.f17910e = tbPageContext;
        y();
    }

    public void A(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
            this.f17911f = bVar;
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
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

    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.f17912g == null) {
            return;
        }
        MessageManager.getInstance().unRegisterListener(this.f17912g);
    }

    public void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            a aVar = new a(this, CmdConfigHttp.CMD_CHECK_POST, 303010);
            this.f17912g = aVar;
            aVar.setTag(this.f17910e.getUniqueId());
            this.f17912g.getHttpMessageListener().setSelfListener(true);
            this.f17912g.getSocketMessageListener().setSelfListener(true);
            this.f17910e.registerListener(this.f17912g);
        }
    }

    public void z(long j, int i2, String str, String str2, BaijiahaoData baijiahaoData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Long.valueOf(j), Integer.valueOf(i2), str, str2, baijiahaoData}) == null) {
            CheckPostRequestMessage checkPostRequestMessage = new CheckPostRequestMessage();
            checkPostRequestMessage.setPid(j);
            checkPostRequestMessage.setPostType(i2);
            checkPostRequestMessage.setForumName(str);
            checkPostRequestMessage.setTid(d.a.c.e.m.b.f(str2, 0L));
            checkPostRequestMessage.setTag(this.f17910e.getUniqueId());
            if (baijiahaoData != null) {
                checkPostRequestMessage.ori_ugc_type = baijiahaoData.oriUgcType;
                checkPostRequestMessage.ori_ugc_tid = baijiahaoData.oriUgcTid;
                checkPostRequestMessage.ori_ugc_nid = baijiahaoData.oriUgcNid;
                checkPostRequestMessage.ori_ugc_vid = baijiahaoData.oriUgcVid;
            }
            sendMessage(checkPostRequestMessage);
        }
    }
}
