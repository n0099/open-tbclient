package com.baidu.tieba.myCollection;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.NotificationHelper;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.ej4;
import com.repackage.om4;
import com.repackage.q55;
import com.repackage.wl7;
import com.repackage.xl7;
import com.repackage.yl7;
import java.util.Map;
/* loaded from: classes3.dex */
public class CollectTabActivity extends BaseFragmentActivity {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public wl7 a;
    public CustomMessageListener b;

    /* loaded from: classes3.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CollectTabActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(CollectTabActivity collectTabActivity, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {collectTabActivity, Integer.valueOf(i)};
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
            this.a = collectTabActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage.getData() instanceof Bundle)) {
                Bundle bundle = (Bundle) customResponsedMessage.getData();
                boolean z = bundle.getBoolean("is_enable_edit", true);
                int i = bundle.getInt("fragment_type", -1);
                if (i == -1 || i != this.a.a.f()) {
                    return;
                }
                this.a.a.k(z);
            }
        }
    }

    public CollectTabActivity() {
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
        this.b = new a(this, 2022209);
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.repackage.v85
    public String getCurrentPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "a081" : (String) invokeV.objValue;
    }

    public final void o0(Intent intent) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, intent) == null) || intent == null) {
            return;
        }
        String dataString = intent.getDataString();
        if (StringUtils.isNull(dataString) || !dataString.startsWith("tbmycollection://")) {
            return;
        }
        String decode = Uri.decode(intent.getData().getEncodedPath());
        if (decode.startsWith("//")) {
            decode = decode.substring(2);
        }
        Map<String, String> paramPair = UrlManager.getParamPair(decode);
        if (paramPair != null) {
            StatisticItem param = new StatisticItem(TbadkCoreStatisticKey.KEY_SCHEME_JUMP_CALL_NATIVE).param("obj_locate", paramPair.get("obj_locate")).param("obj_type", 1).param("obj_source", paramPair.get("obj_source")).param(TiebaStatic.Params.OBJ_PARAM2, paramPair.get(TiebaStatic.Params.OBJ_PARAM2)).param(TiebaStatic.Params.OBJ_TO, 4).param("obj_name", TbadkCoreApplication.getInst().getStartType()).param(TiebaStatic.Params.OBJ_PARAM3, 1);
            ej4.b(param, paramPair);
            TiebaStatic.log(param);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(Constants.METHOD_SEND_USER_MSG, this, i, i2, intent) == null) {
            super.onActivityResult(i, i2, intent);
            Fragment e = this.a.e();
            if (e != null) {
                e.onActivityResult(i, i2, intent);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            super.changeSkinType(i);
            this.a.j(i);
        }
    }

    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, view2) == null) && view2 == this.a.d()) {
            boolean z = !this.a.i();
            if (z) {
                yl7.a("c14067");
            }
            this.a.b(z);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bundle) == null) {
            super.onCreate(bundle);
            setContentView(R.layout.obfuscated_res_0x7f0d01df);
            this.a = new wl7(this);
            registerListener(this.b);
            p0();
            o0(getIntent());
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, intent) == null) {
            super.onNewIntent(intent);
            o0(intent);
            setIntent(intent);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.onPause();
            xl7.b().f(false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            super.onResume();
            yl7.a("c14061");
            xl7.b().f(true);
            xl7.b().e(false);
            NotificationHelper.cancelNotification(getPageContext().getPageActivity(), 28);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, bundle) == null) {
            try {
                super.onSaveInstanceState(bundle);
            } catch (Exception unused) {
            }
            if (bundle != null) {
                bundle.remove(FragmentActivity.FRAGMENTS_TAG);
            }
        }
    }

    public void p0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            om4 om4Var = new om4(getPageContext().getPageActivity());
            ThreadDelegateStatic threadDelegateStatic = new ThreadDelegateStatic();
            om4Var.a(threadDelegateStatic);
            if (om4Var.getContext() != null) {
                q55 b = threadDelegateStatic.b();
                if (b == null) {
                    return;
                }
                b.a.setArguments(new Bundle());
            }
            this.a.h(om4Var.b());
        }
    }
}
