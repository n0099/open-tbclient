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
import com.baidu.tieba.im.message.ResponseCommitPersonalMessage;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.message.chat.PersonalChatMessage;
import com.baidu.tieba.im.util.MessageUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes7.dex */
public class y78 implements GameService {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Map<String, String> a;
    public bb b;

    /* loaded from: classes7.dex */
    public class a extends bb {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GameService.MsgSendListener a;
        public final /* synthetic */ y78 b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(y78 y78Var, int i, GameService.MsgSendListener msgSendListener) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {y78Var, Integer.valueOf(i), msgSendListener};
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
            this.b = y78Var;
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

    public y78() {
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
    }

    @Override // com.baidu.searchbox.live.game.interfaces.GameService
    public void clearCachedHostMsgSendAPI() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.a.clear();
        }
    }

    @Override // com.baidu.searchbox.live.game.interfaces.GameService
    public void releaseHostMsgSendAPI() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && this.b != null) {
            MessageManager.getInstance().unRegisterListener(this.b);
            this.b = null;
        }
    }

    @Override // com.baidu.searchbox.live.game.interfaces.GameService
    public void initHostMsgSendAPI(@Nullable GameService.MsgSendListener msgSendListener) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, msgSendListener) != null) || msgSendListener == null) {
            return;
        }
        if (this.b == null) {
            this.b = new a(this, 0, msgSendListener);
        }
        MessageManager.getInstance().registerListener(205001, this.b);
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
