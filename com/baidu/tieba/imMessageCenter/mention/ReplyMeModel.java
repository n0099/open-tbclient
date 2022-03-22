package com.baidu.tieba.imMessageCenter.mention;

import android.text.TextUtils;
import c.a.d.a.f;
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
/* loaded from: classes5.dex */
public class ReplyMeModel extends BdBaseModel {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;

    /* renamed from: b  reason: collision with root package name */
    public b f34058b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.d.c.g.a f34059c;

    /* loaded from: classes5.dex */
    public class a extends c.a.d.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ReplyMeModel a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(ReplyMeModel replyMeModel, int i, int i2) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {replyMeModel, Integer.valueOf(i), Integer.valueOf(i2)};
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
            this.a = replyMeModel;
        }

        /* JADX WARN: Removed duplicated region for block: B:37:0x00cf  */
        /* JADX WARN: Removed duplicated region for block: B:40:0x00e1  */
        @Override // c.a.d.c.g.a
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
                this.a.a.showToast(R.string.obfuscated_res_0x7f0f0c15);
            } else if (responsedMessage.hasError()) {
                if (!TextUtils.isEmpty(responsedMessage.getErrorString())) {
                    this.a.a.showToast(responsedMessage.getErrorString());
                } else {
                    this.a.a.showToast(R.string.obfuscated_res_0x7f0f0c15);
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
                            if (this.a.f34058b != null) {
                                this.a.f34058b.a(j2, j3, j4, str, j);
                                return;
                            }
                            return;
                        } else if (postState == 0) {
                            this.a.a.showToast(R.string.obfuscated_res_0x7f0f1394);
                            return;
                        } else if (postState == -1) {
                            this.a.a.showToast(R.string.obfuscated_res_0x7f0f139f);
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

    /* loaded from: classes5.dex */
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
        c.a.p0.a4.g0.a.f(303010, CheckPostResponseMessage.class, false);
        c.a.p0.a4.g0.a.c(303010, CmdConfigHttp.CMD_CHECK_POST, "c/f/check/checkpost", CheckPostHttpResponseMessage.class, true, true, false, false);
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = tbPageContext;
        A();
    }

    public void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            a aVar = new a(this, CmdConfigHttp.CMD_CHECK_POST, 303010);
            this.f34059c = aVar;
            aVar.setTag(this.a.getUniqueId());
            this.f34059c.getHttpMessageListener().setSelfListener(true);
            this.f34059c.getSocketMessageListener().setSelfListener(true);
            this.a.registerListener(this.f34059c);
        }
    }

    public void B(long j, int i, String str, String str2, BaijiahaoData baijiahaoData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j), Integer.valueOf(i), str, str2, baijiahaoData}) == null) {
            CheckPostRequestMessage checkPostRequestMessage = new CheckPostRequestMessage();
            checkPostRequestMessage.setPid(j);
            checkPostRequestMessage.setPostType(i);
            checkPostRequestMessage.setForumName(str);
            checkPostRequestMessage.setTid(c.a.d.f.m.b.g(str2, 0L));
            checkPostRequestMessage.setTag(this.a.getUniqueId());
            if (baijiahaoData != null) {
                checkPostRequestMessage.ori_ugc_type = baijiahaoData.oriUgcType;
                checkPostRequestMessage.ori_ugc_tid = baijiahaoData.oriUgcTid;
                checkPostRequestMessage.ori_ugc_nid = baijiahaoData.oriUgcNid;
                checkPostRequestMessage.ori_ugc_vid = baijiahaoData.oriUgcVid;
            }
            sendMessage(checkPostRequestMessage);
        }
    }

    public void C(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar) == null) {
            this.f34058b = bVar;
        }
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

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean loadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || this.f34059c == null) {
            return;
        }
        MessageManager.getInstance().unRegisterListener(this.f34059c);
    }
}
