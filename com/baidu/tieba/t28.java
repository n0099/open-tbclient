package com.baidu.tieba;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.live.game.interfaces.GameService;
import com.baidu.searchbox.live.interfaces.DI;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.tieba.im.message.ResponseCommitPersonalMessage;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.message.chat.PersonalChatMessage;
import com.baidu.tieba.im.util.MessageUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes6.dex */
public class t28 implements GameService {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Map<String, String> a;
    public final List<String> b;
    public yb c;

    /* loaded from: classes6.dex */
    public class a extends yq5<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        public a(t28 t28Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t28Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.baidu.tieba.yq5
        public Boolean doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                NetWork netWork = new NetWork("https://peiwan.baidu.com/peiwan/api/user/letter/ses");
                netWork.addPostData("to_uid", this.a);
                netWork.postNetData();
                return Boolean.valueOf(netWork.getNetContext().getResponse().isRequestSuccess());
            }
            return (Boolean) invokeV.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class b implements cq5<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ long b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ boolean e;
        public final /* synthetic */ String f;
        public final /* synthetic */ t28 g;

        public b(t28 t28Var, String str, long j, String str2, String str3, boolean z, String str4) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t28Var, str, Long.valueOf(j), str2, str3, Boolean.valueOf(z), str4};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.g = t28Var;
            this.a = str;
            this.b = j;
            this.c = str2;
            this.d = str3;
            this.e = z;
            this.f = str4;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.cq5
        /* renamed from: a */
        public void onReturnDataInUI(Boolean bool) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bool) == null) {
                String str = this.a;
                long j = this.b;
                String str2 = this.c;
                this.g.a.put(String.valueOf(MessageUtils.createAndSendPersonalText(str, j, str2, str2, this.d, this.e)), this.f);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c extends yb {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GameService.MsgSendListener a;
        public final /* synthetic */ t28 b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(t28 t28Var, int i, GameService.MsgSendListener msgSendListener) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t28Var, Integer.valueOf(i), msgSendListener};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = t28Var;
            this.a = msgSendListener;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        /* renamed from: a */
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, socketResponsedMessage) != null) || !(socketResponsedMessage instanceof ResponseCommitPersonalMessage)) {
                return;
            }
            ChatMessage chatMessage = (ChatMessage) ((ResponseCommitPersonalMessage) socketResponsedMessage).getOrginalMessage();
            if (chatMessage instanceof PersonalChatMessage) {
                String valueOf = String.valueOf(chatMessage.getRecordId());
                if (this.b.a.containsKey(valueOf)) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("msg_id", this.b.a.get(valueOf));
                    if (socketResponsedMessage.hasError()) {
                        this.a.onFailed(hashMap);
                    } else {
                        this.a.onSuccess(hashMap);
                    }
                }
            }
        }
    }

    public t28() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new HashMap();
        this.b = new ArrayList();
    }

    @Override // com.baidu.searchbox.live.game.interfaces.GameService
    public void clearCachedHostMsgSendAPI() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.b.clear();
            this.a.clear();
        }
    }

    @Override // com.baidu.searchbox.live.game.interfaces.GameService
    public void releaseHostMsgSendAPI() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && this.c != null) {
            MessageManager.getInstance().unRegisterListener(this.c);
        }
    }

    @Override // com.baidu.searchbox.live.game.interfaces.GameService
    public void initHostMsgSendAPI(@Nullable GameService.MsgSendListener msgSendListener) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, msgSendListener) != null) || msgSendListener == null) {
            return;
        }
        if (this.c == null) {
            this.c = new c(this, 0, msgSendListener);
        }
        MessageManager.getInstance().registerListener(205001, this.c);
    }

    @Override // com.baidu.searchbox.live.game.interfaces.GameService
    public void callHostMsgSendAPI(@Nullable Map<String, String> map) {
        long parseLong;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, map) == null) && map != null && !map.isEmpty()) {
            String str = map.get("msg_id");
            String str2 = map.get("msg_content");
            String str3 = map.get("receiver_id");
            String str4 = map.get("receiver_name");
            String str5 = map.get("receiver_avatar");
            String str6 = map.get(DI.FOLLOW_STATUS);
            try {
                if (TextUtils.isEmpty(str3)) {
                    parseLong = -1;
                } else {
                    parseLong = Long.parseLong(str3);
                }
                boolean equalsIgnoreCase = "1".equalsIgnoreCase(str6);
                if (parseLong > -1) {
                    if (!this.b.contains(str3)) {
                        this.b.add(str3);
                        cr5.b(new a(this, str3), new b(this, str2, parseLong, str4, str5, equalsIgnoreCase, str));
                        return;
                    }
                    this.a.put(String.valueOf(MessageUtils.createAndSendPersonalText(str2, parseLong, str4, str4, str5, equalsIgnoreCase)), str);
                }
            } catch (NumberFormatException unused) {
                if (BdBaseApplication.getInst().isDebugMode()) {
                    BdLog.e("NumberFormatException: parse long");
                }
            }
        }
    }
}
