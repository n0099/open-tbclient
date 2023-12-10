package com.baidu.tieba.immessagecenter.chatgroup.chatbox.adapter;

import android.annotation.SuppressLint;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.R;
import com.baidu.tieba.e39;
import com.baidu.tieba.gn8;
import com.baidu.tieba.i29;
import com.baidu.tieba.im.base.core.chatbox.adapter.BaseItemViewHolder;
import com.baidu.tieba.immessagecenter.chatgroup.data.ChatRoomInfo;
import com.baidu.tieba.kn8;
import com.baidu.tieba.n29;
import com.baidu.tieba.q29;
import com.baidu.tieba.wq8;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
/* loaded from: classes6.dex */
public class ChatItemViewHolder extends BaseItemViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public e39 e;
    public String f;
    public q29 g;
    public i29 h;
    public n29 i;
    public kn8 j;
    public View k;
    public final wq8.a l;
    public final CustomMessageListener m;

    /* loaded from: classes6.dex */
    public class a implements wq8.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ChatItemViewHolder a;

        public a(ChatItemViewHolder chatItemViewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {chatItemViewHolder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = chatItemViewHolder;
        }

        @Override // com.baidu.tieba.wq8.a
        public void a(@Nullable CustomResponsedMessage<?> customResponsedMessage) {
            e39 e39Var;
            ChatRoomInfo chatRoomInfo;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2921766 && (customResponsedMessage.getData() instanceof Map)) {
                Map map = (Map) customResponsedMessage.getData();
                if (!map.isEmpty() && (e39Var = this.a.e) != null && e39Var.a() != null && (chatRoomInfo = (ChatRoomInfo) map.get(Long.valueOf(this.a.e.a().getRoomId()))) != null) {
                    this.a.e.c(chatRoomInfo);
                    ChatItemViewHolder chatItemViewHolder = this.a;
                    chatItemViewHolder.i.n(chatRoomInfo, chatItemViewHolder.e.b());
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(924808790, "Lcom/baidu/tieba/immessagecenter/chatgroup/chatbox/adapter/ChatItemViewHolder;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(924808790, "Lcom/baidu/tieba/immessagecenter/chatgroup/chatbox/adapter/ChatItemViewHolder;");
                return;
            }
        }
        BdUtilHelper.getDimens(TbadkApplication.getInst(), R.dimen.tbds450);
    }

    @Override // com.baidu.tieba.im.base.core.chatbox.adapter.BaseItemViewHolder
    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.e = null;
            super.g();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatItemViewHolder(@NonNull View view2, kn8 kn8Var, String str) {
        super(view2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view2, kn8Var, str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((View) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        a aVar = new a(this);
        this.l = aVar;
        this.m = new wq8(2921766, aVar);
        this.j = kn8Var;
        this.k = view2;
        this.f = str;
        if (str.equals("message_tab")) {
            q29 k = q29.k(this.k);
            this.g = k;
            k.j();
            return;
        }
        i29 k2 = i29.k(this.k);
        this.h = k2;
        k2.j();
    }

    @Override // com.baidu.tieba.im.base.core.chatbox.adapter.BaseItemViewHolder
    public void c(@Nullable RecyclerView recyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, recyclerView) == null) {
            super.c(recyclerView);
            MessageManager.getInstance().registerListener(this.m);
        }
    }

    @Override // com.baidu.tieba.im.base.core.chatbox.adapter.BaseItemViewHolder
    public void e(@Nullable RecyclerView recyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, recyclerView) == null) {
            super.e(recyclerView);
            MessageManager.getInstance().unRegisterListener(this.m);
        }
    }

    @Override // com.baidu.tieba.im.base.core.chatbox.adapter.BaseItemViewHolder
    public void f(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            if (this.f.equals("message_tab")) {
                this.g.h(this.e);
            } else {
                this.h.h(this.e);
            }
        }
    }

    @Override // com.baidu.tieba.im.base.core.chatbox.adapter.BaseItemViewHolder
    @SuppressLint({"ResourceAsColor"})
    public void d(@NonNull gn8 gn8Var, @NonNull TbPageContext tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, gn8Var, tbPageContext, i) == null) && (gn8Var instanceof e39)) {
            this.e = (e39) gn8Var;
            if (this.f.equals("message_tab")) {
                this.i = new n29(this.a, this.e, this.g, this.f, this.j);
            } else {
                this.i = new n29(this.a, this.e, this.h, this.f, this.j);
            }
            this.i.m();
        }
    }
}
