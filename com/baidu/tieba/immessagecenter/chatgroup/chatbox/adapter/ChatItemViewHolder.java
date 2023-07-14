package com.baidu.tieba.immessagecenter.chatgroup.chatbox.adapter;

import android.annotation.SuppressLint;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.R;
import com.baidu.tieba.bj8;
import com.baidu.tieba.gj8;
import com.baidu.tieba.immessagecenter.chatgroup.data.ChatRoomInfo;
import com.baidu.tieba.jk8;
import com.baidu.tieba.nj8;
import com.baidu.tieba.rp8;
import com.baidu.tieba.sj8;
import com.baidu.tieba.vj8;
import com.baidu.tieba.yi;
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
    public jk8 e;
    public String f;
    public vj8 g;
    public nj8 h;
    public sj8 i;
    public gj8 j;
    public View k;
    public final rp8.a l;
    public final CustomMessageListener m;

    /* loaded from: classes6.dex */
    public class a implements rp8.a {
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

        @Override // com.baidu.tieba.rp8.a
        public void a(@Nullable CustomResponsedMessage<?> customResponsedMessage) {
            jk8 jk8Var;
            ChatRoomInfo chatRoomInfo;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2921766 && (customResponsedMessage.getData() instanceof Map)) {
                Map map = (Map) customResponsedMessage.getData();
                if (!map.isEmpty() && (jk8Var = this.a.e) != null && jk8Var.a() != null && (chatRoomInfo = (ChatRoomInfo) map.get(Long.valueOf(this.a.e.a().getRoomId()))) != null) {
                    this.a.e.c(chatRoomInfo);
                    ChatItemViewHolder chatItemViewHolder = this.a;
                    chatItemViewHolder.i.l(chatRoomInfo, chatItemViewHolder.e.b());
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
        yi.g(TbadkApplication.getInst(), R.dimen.tbds450);
    }

    @Override // com.baidu.tieba.immessagecenter.chatgroup.chatbox.adapter.BaseItemViewHolder
    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.e = null;
            super.h();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatItemViewHolder(@NonNull View view2, gj8 gj8Var, String str) {
        super(view2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view2, gj8Var, str};
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
        this.m = new rp8(2921766, aVar);
        this.j = gj8Var;
        this.k = view2;
        this.f = str;
        if (str.equals("msgTabFragment")) {
            vj8 k = vj8.k(this.k);
            this.g = k;
            k.j();
            return;
        }
        nj8 k2 = nj8.k(this.k);
        this.h = k2;
        k2.j();
    }

    @Override // com.baidu.tieba.immessagecenter.chatgroup.chatbox.adapter.BaseItemViewHolder
    public void d(@Nullable RecyclerView recyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, recyclerView) == null) {
            super.d(recyclerView);
            MessageManager.getInstance().registerListener(this.m);
        }
    }

    @Override // com.baidu.tieba.immessagecenter.chatgroup.chatbox.adapter.BaseItemViewHolder
    public void f(@Nullable RecyclerView recyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, recyclerView) == null) {
            super.f(recyclerView);
            MessageManager.getInstance().unRegisterListener(this.m);
        }
    }

    @Override // com.baidu.tieba.immessagecenter.chatgroup.chatbox.adapter.BaseItemViewHolder
    public void g(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            if (this.f.equals("msgTabFragment")) {
                this.g.h(this.e);
            } else {
                this.h.h(this.e);
            }
        }
    }

    @Override // com.baidu.tieba.immessagecenter.chatgroup.chatbox.adapter.BaseItemViewHolder
    @SuppressLint({"ResourceAsColor"})
    public void e(@NonNull bj8 bj8Var, @NonNull TbPageContext tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bj8Var, tbPageContext, i) == null) && (bj8Var instanceof jk8)) {
            this.e = (jk8) bj8Var;
            if (this.f.equals("msgTabFragment")) {
                this.i = new sj8(this.a, this.e, this.g, this.f, this.j);
            } else {
                this.i = new sj8(this.a, this.e, this.h, this.f, this.j);
            }
            this.i.k();
        }
    }
}
