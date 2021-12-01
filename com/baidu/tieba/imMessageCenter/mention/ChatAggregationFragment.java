package com.baidu.tieba.imMessageCenter.mention;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import c.a.r0.s1.b.e;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MentionActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
public class ChatAggregationFragment extends BaseFragment implements c.a.q0.l0.c.a, NoNetworkView.b {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int EVENT_ITEM_DISPLAY = 9488;
    public static final int EVENT_QUICK_REPLY = 9486;
    public static final int EVENT_TO_ADDFRIEND = 9485;
    public static final int EVENT_TO_DELETE_AT_ME_ITEM = 9489;
    public static final int EVENT_TO_GRAFFITILIST = 9487;
    public static final int EVENT_TO_PB = 9484;
    public static final int EVENT_TO_PERSON_CENTER = 9483;
    public static final int PAGE_TYPE_ATME = 2;
    public static final int PAGE_TYPE_CHAT = 0;
    public static final int PAGE_TYPE_REPLYME = 1;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public e f46308e;

    /* renamed from: f  reason: collision with root package name */
    public ViewEventCenter f46309f;

    /* renamed from: g  reason: collision with root package name */
    public CustomMessageListener f46310g;

    /* renamed from: h  reason: collision with root package name */
    public CustomMessageListener f46311h;

    /* loaded from: classes10.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ChatAggregationFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(ChatAggregationFragment chatAggregationFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {chatAggregationFragment, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = chatAggregationFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016) {
                if (this.a.f46308e != null) {
                    this.a.f46308e.s0(true);
                }
                MentionActivityConfig.newJumpIn = true;
                if (this.a.f46308e != null) {
                    this.a.f46308e.T();
                    this.a.f46308e.y0(TbadkCoreApplication.isLogin(), true ^ TbadkCoreApplication.isLogin());
                }
            }
        }
    }

    /* loaded from: classes10.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ChatAggregationFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(ChatAggregationFragment chatAggregationFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {chatAggregationFragment, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = chatAggregationFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2016321 && (customResponsedMessage.getData() instanceof Intent)) {
                Intent intent = (Intent) customResponsedMessage.getData();
                if (this.a.f46308e != null) {
                    this.a.f46308e.a0(intent);
                }
            }
        }
    }

    public ChatAggregationFragment() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f46310g = new a(this, 2005016);
        this.f46311h = new b(this, 2016321);
    }

    public final boolean b(Intent intent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, intent)) == null) ? (intent == null || intent.getIntExtra(MentionActivityConfig.KEY_INTENT_NOTIFICATION_ID, -1) == -1) ? false : true : invokeL.booleanValue;
    }

    public ViewEventCenter getEventCenter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.f46309f == null) {
                this.f46309f = new ViewEventCenter();
            }
            return this.f46309f;
        }
        return (ViewEventCenter) invokeV.objValue;
    }

    @Override // c.a.q0.l0.c.a
    public boolean isEventMustSelf() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048579, this, i2, i3, intent) == null) {
            super.onActivityResult(i2, i3, intent);
            if (i3 == -1 && i2 == 12011) {
                Bundle extras = intent.getExtras();
                String string = extras.getString("user_id");
                String string2 = extras.getString("user_name");
                String string3 = extras.getString("name_show");
                String string4 = extras.getString("portrait");
                if (string2 == null || string == null) {
                    return;
                }
                try {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(getActivity(), Long.parseLong(string), string2, string3, string4, 0)));
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048580, this, i2) == null) || (eVar = this.f46308e) == null) {
            return;
        }
        eVar.V(getPageContext(), i2);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048581, this, layoutInflater, viewGroup, bundle)) == null) {
            e eVar = new e(this);
            this.f46308e = eVar;
            if (bundle != null) {
                eVar.Q(bundle);
            } else {
                eVar.Q(null);
            }
            View X = this.f46308e.X();
            this.f46308e.V(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            getEventCenter().addEventDelegate(this);
            registerListener(this.f46310g);
            registerListener(this.f46311h);
            return X;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.onDestroy();
            MessageManager.getInstance().unRegisterListener(this.f46310g);
            MessageManager.getInstance().unRegisterListener(this.f46311h);
            e eVar = this.f46308e;
            if (eVar != null) {
                eVar.S();
            }
        }
    }

    @Override // c.a.q0.l0.c.a
    public boolean onEventDispatch(c.a.q0.l0.c.b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, bVar)) == null) ? bVar == null : invokeL.booleanValue;
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.b
    public void onNetworkChange(boolean z) {
        e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) || (eVar = this.f46308e) == null) {
            return;
        }
        eVar.Z(z);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.onPrimary();
            e eVar = this.f46308e;
            if (eVar != null) {
                eVar.F();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            super.onUserChanged(z);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, view, bundle) == null) {
            if (getActivity() != null && b(getActivity().getIntent())) {
                this.f46308e.a0(getActivity().getIntent());
            } else {
                this.f46308e.T();
            }
            super.onViewCreated(view, bundle);
        }
    }

    public void refreshPage() {
        e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (eVar = this.f46308e) == null) {
            return;
        }
        eVar.o0();
    }
}
