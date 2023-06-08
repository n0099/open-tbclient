package com.baidu.tieba;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.forumsearch.message.SearchPostForumHttpResponseMessage;
import com.baidu.tieba.forumsearch.message.SearchPostForumRequestMessage;
import com.baidu.tieba.forumsearch.message.SearchPostForumSocketResponseMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class nc7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public final BdUniqueId b;
    public b c;
    public jb d;

    /* loaded from: classes6.dex */
    public interface b {
        void a(boolean z, rc7 rc7Var);
    }

    /* loaded from: classes6.dex */
    public class a extends jb {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nc7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(nc7 nc7Var, int i, int i2) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nc7Var, Integer.valueOf(i), Integer.valueOf(i2)};
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
            this.a = nc7Var;
        }

        @Override // com.baidu.tieba.jb
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                rc7 rc7Var = null;
                boolean z = false;
                if (responsedMessage != null && !responsedMessage.hasError() && responsedMessage.getOrginalMessage() != null && responsedMessage.getOrginalMessage().getTag() == this.a.b) {
                    if (responsedMessage instanceof SearchPostForumHttpResponseMessage) {
                        rc7Var = ((SearchPostForumHttpResponseMessage) responsedMessage).getSearchData();
                    }
                    if (responsedMessage instanceof SearchPostForumSocketResponseMessage) {
                        rc7Var = ((SearchPostForumSocketResponseMessage) responsedMessage).getSearchData();
                    }
                    if (this.a.c != null) {
                        b bVar = this.a.c;
                        if (rc7Var != null) {
                            z = true;
                        }
                        bVar.a(z, rc7Var);
                    }
                } else if (this.a.c != null) {
                    this.a.c.a(false, null);
                }
            }
        }
    }

    public nc7(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        a aVar = new a(this, CmdConfigHttp.CMD_SEARCH_POST_FORUM, 309466);
        this.d = aVar;
        this.a = tbPageContext;
        this.b = bdUniqueId;
        aVar.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.d);
    }

    public void e(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar) == null) {
            this.c = bVar;
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            MessageManager.getInstance().removeMessage(CmdConfigHttp.CMD_SEARCH_POST_FORUM, this.b);
        }
    }

    public void d(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) != null) || StringUtils.isNull(str)) {
            return;
        }
        if (!vi.F()) {
            this.a.showToast(R.string.obfuscated_res_0x7f0f0def);
            return;
        }
        c();
        MessageManager.getInstance().removeMessage(CmdConfigHttp.CMD_SEARCH_POST_FORUM, this.b);
        SearchPostForumRequestMessage searchPostForumRequestMessage = new SearchPostForumRequestMessage();
        searchPostForumRequestMessage.setTag(this.b);
        searchPostForumRequestMessage.set_word(str);
        MessageManager.getInstance().sendMessage(searchPostForumRequestMessage);
    }
}
