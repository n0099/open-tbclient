package com.baidu.tieba.immessagecenter.im.chat;

import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.atomData.GamePersonalChatActivityConfig;
import com.baidu.tbadk.core.dialog.TBAlertBuilder;
import com.baidu.tbadk.core.dialog.TBAlertConfig;
import com.baidu.tieba.R;
import com.baidu.tieba.mn7;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes4.dex */
public class GamePersonalChatActivity extends PersonalChatActivity {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a0;
    public List<String> b0;
    public CustomMessageListener c0;
    public CustomMessageListener d0;

    @Override // com.baidu.tieba.immessagecenter.im.chat.PersonalChatActivity, com.baidu.tieba.im.chat.MsglistActivity
    public boolean S1(mn7 mn7Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, mn7Var)) == null) {
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.immessagecenter.im.chat.PersonalChatActivity, com.baidu.tieba.im.chat.MsglistActivity
    public boolean U1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    public boolean V1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    /* loaded from: classes4.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GamePersonalChatActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(GamePersonalChatActivity gamePersonalChatActivity, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gamePersonalChatActivity, Integer.valueOf(i)};
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
            this.a = gamePersonalChatActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null) {
                return;
            }
            if (((Integer) ((HashMap) customResponsedMessage.getData()).get("show_dialog")).intValue() == 1) {
                this.a.r3();
            } else {
                this.a.finish();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GamePersonalChatActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(GamePersonalChatActivity gamePersonalChatActivity, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gamePersonalChatActivity, Integer.valueOf(i)};
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
            this.a = gamePersonalChatActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2921718) {
                Object data = customResponsedMessage.getData();
                if (data instanceof HashMap) {
                    HashMap hashMap = (HashMap) data;
                    String str = (String) hashMap.get("key");
                    if ("add".equalsIgnoreCase((String) hashMap.get("action"))) {
                        this.a.b0.add(str);
                    } else {
                        this.a.b0.remove(str);
                    }
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GamePersonalChatActivity a;

        public c(GamePersonalChatActivity gamePersonalChatActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gamePersonalChatActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gamePersonalChatActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921716));
                this.a.finish();
            }
        }
    }

    public GamePersonalChatActivity() {
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
        this.b0 = new ArrayList();
        this.c0 = new a(this, 2921715);
        this.d0 = new b(this, 2921718);
    }

    @Override // com.baidu.tieba.immessagecenter.im.chat.PersonalChatActivity, com.baidu.tieba.im.chat.MsglistActivity
    public boolean T1(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bundle)) == null) {
            registerListener(this.c0);
            registerListener(this.d0);
            return super.T1(bundle);
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.immessagecenter.im.chat.PersonalChatActivity, com.baidu.tieba.im.chat.MsglistActivity, com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bundle) == null) {
            this.u = true;
            this.J = false;
            super.onCreate(bundle);
        }
    }

    public void q3(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            this.a0 = str;
        }
    }

    @Override // com.baidu.tieba.immessagecenter.im.chat.PersonalChatActivity
    public void S2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.b = new GamePersonalChatView(this, this.c.getIsAcceptNotify(), GamePersonalChatActivityConfig.getIntentParam(getIntent()));
        }
    }

    @Override // com.baidu.tieba.immessagecenter.im.chat.PersonalChatActivity, com.baidu.tieba.im.chat.MsglistActivity
    public void W1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.W1();
            if (!TextUtils.isEmpty(this.a0)) {
                this.c.sendTextMessage(this.a0);
                this.a0 = null;
            }
        }
    }

    @Override // com.baidu.tieba.immessagecenter.im.chat.PersonalChatActivity
    public boolean Z2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return !Build.MODEL.equals("YAL-AL10");
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.immessagecenter.im.chat.PersonalChatActivity, com.baidu.tieba.im.chat.CommonPersonalChatActivity, com.baidu.tieba.im.chat.MsglistActivity, com.baidu.tbadk.core.BaseFragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            r3();
        }
    }

    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048585, this, i, keyEvent)) == null) {
            if (i == 4 && (this.b.getVisibility() || !this.b0.isEmpty())) {
                p3();
                return true;
            }
            return super.onKeyDown(i, keyEvent);
        }
        return invokeIL.booleanValue;
    }

    public final void p3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            if (!this.b0.isEmpty()) {
                HashMap hashMap = new HashMap();
                List<String> list = this.b0;
                hashMap.put("key", list.get(list.size() - 1));
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921719, hashMap));
            } else if (this.b.getVisibility()) {
                r3();
            }
        }
    }

    public final void r3() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048588, this) != null) || !this.b0.isEmpty()) {
            return;
        }
        TBAlertBuilder tBAlertBuilder = new TBAlertBuilder(getPageContext().getPageActivity());
        tBAlertBuilder.w(R.string.game_back_tip);
        tBAlertBuilder.m(R.string.cancel_game_match);
        tBAlertBuilder.o(true);
        tBAlertBuilder.u(new TBAlertConfig.a((int) R.string.obfuscated_res_0x7f0f051b, TBAlertConfig.OperateBtnStyle.SECONDARY), new TBAlertConfig.a((int) R.string.obfuscated_res_0x7f0f105a, TBAlertConfig.OperateBtnStyle.MAIN, new c(this)));
        tBAlertBuilder.i();
        tBAlertBuilder.j(false);
        tBAlertBuilder.z();
    }
}
