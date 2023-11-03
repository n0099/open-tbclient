package com.baidu.tieba.newdetail;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.base.BdActivityStack;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.BdToken.BdUniDispatchSchemeController;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.atomData.TopicDetailActivityConfig;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.ey4;
import com.baidu.tieba.nm9;
import com.baidu.tieba.oi8;
import com.baidu.tieba.om9;
import com.baidu.tieba.qi8;
import com.baidu.tieba.ti8;
import com.baidu.tieba.ui8;
import com.baidu.tieba.util.TopicListUtil;
import com.baidu.tieba.vi8;
import com.baidu.tieba.yi8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import tbclient.RecomTopicList;
/* loaded from: classes7.dex */
public class HotTopicDetailActivity extends BaseActivity<HotTopicDetailActivity> implements nm9, BdListView.p {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public HotTopicDetailModel a;
    public om9 b;
    public oi8 c;
    public boolean d;
    public long e;
    public boolean f;
    public String g;
    public String h;
    public String i;

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.pageStayDuration.IPageStayDuration
    public String getCurrentPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? "a077" : (String) invokeV.objValue;
    }

    /* loaded from: classes7.dex */
    public class a implements BdUniDispatchSchemeController.OnSchemeParsedCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ HotTopicDetailActivity a;

        public a(HotTopicDetailActivity hotTopicDetailActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hotTopicDetailActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hotTopicDetailActivity;
        }

        @Override // com.baidu.tbadk.BdToken.BdUniDispatchSchemeController.OnSchemeParsedCallback
        public void onCallBack(HashMap<String, Object> hashMap) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, hashMap) == null) && hashMap != null && (hashMap.get(BdUniDispatchSchemeController.PARAM_TOPIC_ID) instanceof String)) {
                String str = (String) hashMap.get(BdUniDispatchSchemeController.PARAM_TOPIC_ID);
                if (!StringUtils.isNull(str)) {
                    this.a.e = JavaTypesHelper.toLong(str, -1L);
                }
            }
        }
    }

    public HotTopicDetailActivity() {
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
        this.d = false;
        this.e = -1L;
        this.f = false;
        this.g = null;
        this.h = null;
        this.i = "";
    }

    public final void L0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.f) {
            MainTabActivityConfig createNormalCfg = new MainTabActivityConfig(this).createNormalCfg(2);
            createNormalCfg.setSubTabName(getString(R.string.tab_name_topic_rank));
            sendMessage(new CustomMessage(2015002, createNormalCfg));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            if (this.d) {
                sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(2)));
            }
            super.finish();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            super.onResume();
            this.b.resume();
            TiebaStatic.log(new StatisticItem("c13817").param("uid", TbadkCoreApplication.getCurrentAccount()).param("topic_id", this.g));
        }
    }

    public boolean Z0(yi8 yi8Var, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048588, this, yi8Var, i)) == null) {
            return this.a.b0(yi8Var, i);
        }
        return invokeLI.booleanValue;
    }

    @Override // com.baidu.tieba.nm9
    public void i(int i, ti8 ti8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048593, this, i, ti8Var) == null) {
            S0(i, ti8Var, false);
        }
    }

    @Override // com.baidu.tieba.nm9
    public void B0(int i, long j, long j2, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i2)}) == null) && i == 0 && j > 0 && i2 >= 0) {
            if (i2 != 1 && i2 != 2) {
                this.b.f(j, j2);
            } else {
                this.b.n(j, j2, i2);
            }
        }
    }

    @Override // com.baidu.tieba.nm9
    public void F(int i, ui8 ui8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, ui8Var) == null) {
            if (ui8Var != null && ui8Var.p == -1) {
                this.b.c(ui8Var);
                return;
            }
            this.b.p();
            this.b.l();
            if (i == 0 && ui8Var != null) {
                if (ui8Var.e() != null) {
                    V0(ui8Var.e().a, ui8Var.e().b);
                }
                if (ui8Var.e() != null && ui8Var.e().k) {
                    this.b.a(true);
                    return;
                }
                this.b.a(false);
                this.b.m(ui8Var);
                this.b.q();
                S0(i, ui8Var.k, true);
            } else if (this.b.g() == null) {
                this.b.e(false);
            }
        }
    }

    public String M0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.g;
        }
        return (String) invokeV.objValue;
    }

    public void Q0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            if ("5".equals(this.i)) {
                finish();
            } else {
                TopicListUtil.openWebTopicListPage();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            if (this.d) {
                ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
            } else {
                super.enterExitAnimation();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            super.onDestroy();
            om9 om9Var = this.b;
            if (om9Var != null) {
                om9Var.destroy();
            }
            L0();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            super.onPause();
            this.b.pause();
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.p
    public void onScrollToBottom() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            T0(this.b.k());
        }
    }

    public final void N0(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bundle) == null) {
            Intent intent = getIntent();
            if (intent != null) {
                this.g = intent.getStringExtra("topic_id");
                this.h = intent.getStringExtra("topic_name");
                intent.getLongExtra(IntentConfig.TOPIC_FID, 0L);
                intent.getStringExtra(IntentConfig.TOPIC_FIRST_DIR);
                intent.getStringExtra(IntentConfig.TOPIC_SECOND_DIR);
                this.i = intent.getStringExtra("from");
                intent.getLongExtra(IntentConfig.TOPIC_TID, 0L);
            } else if (bundle != null) {
                this.g = bundle.getString("topic_id");
                this.h = bundle.getString("topic_name");
                bundle.getLong(IntentConfig.TOPIC_FID, 0L);
                bundle.getString(IntentConfig.TOPIC_FIRST_DIR);
                bundle.getString(IntentConfig.TOPIC_SECOND_DIR);
                this.i = bundle.getString("from");
                bundle.getLong(IntentConfig.TOPIC_TID, 0L);
            }
        }
    }

    @Override // com.baidu.tieba.nm9
    public void d0(ui8 ui8Var) {
        vi8 e;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048589, this, ui8Var) != null) || ui8Var == null || (e = ui8Var.e()) == null) {
            return;
        }
        String str = TbConfig.TIEBA_ADDRESS + "mo/q/newtopic/detail?topic_id=" + this.g;
        if (!TextUtils.isEmpty(this.h)) {
            str = str + "&topic_name=" + URLEncoder.encode(this.h);
        }
        this.c.d(e.a, e.b, str, e.h, e.g, e.e, true, e.d);
    }

    public final boolean O0(Intent intent) {
        InterceptResult invokeL;
        int i;
        String substring;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, intent)) == null) {
            if (intent.getParcelableExtra(IntentConfig.KEY_URI) != null) {
                Uri uri = (Uri) intent.getParcelableExtra(IntentConfig.KEY_URI);
                String uri2 = uri.toString();
                if (BdUniDispatchSchemeController.isUniScheme(uri)) {
                    BdUniDispatchSchemeController.getInstance().parseTopicDetailScheme(uri, new a(this));
                } else if (!StringUtils.isNull(uri2) && uri2.startsWith("tbtopicdetail://")) {
                    String decode = Uri.decode(uri.getEncodedPath());
                    if (StringUtils.isNull(decode)) {
                        return false;
                    }
                    Matcher matcher = Pattern.compile(".*fr=(.*)&topic_id=([\\d]+).*").matcher(decode);
                    if (matcher.find()) {
                        substring = matcher.group(2);
                    } else {
                        int indexOf = decode.indexOf("topic_id=");
                        if (indexOf < 0 || (i = indexOf + 9) > decode.length()) {
                            return false;
                        }
                        substring = decode.substring(i);
                    }
                    if (!StringUtils.isNull(substring)) {
                        this.e = JavaTypesHelper.toLong(substring, -1L);
                    }
                }
            } else {
                this.e = intent.getLongExtra("topic_id", -1L);
            }
            if (this.e <= 0) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void S0(int i, ti8 ti8Var, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Integer.valueOf(i), ti8Var, Boolean.valueOf(z)}) == null) {
            int k = this.b.k();
            if (ti8Var != null) {
                k = ti8Var.d;
            }
            this.b.r(k);
            boolean z2 = true;
            if (i == 0 && ti8Var != null && !ListUtils.isEmpty(ti8Var.e)) {
                om9 om9Var = this.b;
                if (!z && om9Var.o(k).b != null) {
                    z2 = false;
                }
                om9Var.s(ti8Var, z2, k);
            } else if (this.b.o(k).b == null) {
                om9 om9Var2 = this.b;
                if (i == 0) {
                    z2 = false;
                }
                om9Var2.i(z2, k);
            }
        }
    }

    public void T0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            ti8 o = this.b.o(i);
            ey4 ey4Var = o.b;
            if (ey4Var == null) {
                U0(i);
            } else if (ey4Var.b() != 0) {
                this.a.Q(i, o.b, o.c);
            }
        }
    }

    public boolean W0(qi8 qi8Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, qi8Var)) == null) {
            return this.a.a0(qi8Var);
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i) == null) {
            super.onChangeSkinType(i);
            this.b.onChangeSkinType();
        }
    }

    public void U0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            boolean P = this.a.P(i);
            if (this.b.o(i).b == null) {
                if (P) {
                    this.b.j(i);
                    this.b.b(i);
                    return;
                }
                this.b.i(true, i);
                this.b.r(i);
            }
        }
    }

    @Override // com.baidu.tieba.nm9
    public void l0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i) == null) {
            boolean O = this.a.O(i);
            if (this.b.g() == null) {
                if (O) {
                    this.b.h();
                    this.b.d();
                    return;
                }
                this.b.e(true);
                this.b.p();
            } else if (!O) {
                this.b.l();
            }
        }
    }

    @Override // com.baidu.tieba.nm9
    public void s(@NonNull RecomTopicList recomTopicList) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048602, this, recomTopicList) == null) && BdNetTypeUtil.isNetworkAvailableForImmediately() && V0(String.valueOf(recomTopicList.topic_id), recomTopicList.topic_name)) {
            this.a.cancelLoadData();
            this.b.resetView();
            l0(1);
        }
    }

    public final boolean V0(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, str, str2)) == null) {
            if ((TextUtils.isEmpty(str) || JavaTypesHelper.toLong(str, 0L) <= 0) && TextUtils.isEmpty(str2)) {
                return false;
            }
            this.g = str;
            this.h = str2;
            this.a.d0(JavaTypesHelper.toLong(str, 0L), str2);
            return true;
        }
        return invokeLL.booleanValue;
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048595, this, i, i2, intent) == null) {
            super.onActivityResult(i, i2, intent);
            if (i2 == -1) {
                if (i != 24007) {
                    if (i != 25065) {
                        if (i == 110435) {
                            this.a.Z();
                            return;
                        }
                        return;
                    }
                    this.a.W();
                    return;
                }
                this.a.X(intent);
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, bundle) == null) {
            boolean z = true;
            if (O0(getIntent())) {
                this.g = "" + this.e;
                if (getIntent() != null && getIntent().getParcelableExtra(IntentConfig.KEY_URI) != null && !BdActivityStack.getInst().isActivityExist("MainTabActivity")) {
                    this.d = true;
                }
            } else {
                N0(bundle);
            }
            if (this.d) {
                setIsAddSwipeBackLayout(false);
            }
            super.onCreate(bundle);
            if ((TextUtils.isEmpty(this.g) || JavaTypesHelper.toLong(this.g, 0L) <= 0) && TextUtils.isEmpty(this.h)) {
                finish();
                return;
            }
            this.a = new HotTopicDetailModel(getPageContext(), this);
            this.b = new HotTopicDetailView(getPageContext(), this, bundle);
            this.a.setFrom(this.i);
            V0(this.g, this.h);
            this.c = new oi8(this);
            setContentView(this.b.getRootView());
            addGlobalLayoutListener();
            adjustResizeForSoftInput();
            l0(1);
            this.f = (getIntent() == null || !getIntent().getBooleanExtra(TopicDetailActivityConfig.KEY_IS_FROM_YUN_PUSH, false)) ? false : false;
        }
    }
}
