package com.baidu.tieba.newdetail;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.BdToken.BdUniDispatchSchemeController;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.HotRanklistActivityConfig;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.atomData.TopicDetailActivityConfig;
import com.baidu.tbadk.core.atomData.VideoMiddlePageActivityConfig;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.a57;
import com.baidu.tieba.b57;
import com.baidu.tieba.c57;
import com.baidu.tieba.f57;
import com.baidu.tieba.hq4;
import com.baidu.tieba.oo7;
import com.baidu.tieba.pg;
import com.baidu.tieba.pi;
import com.baidu.tieba.po7;
import com.baidu.tieba.v47;
import com.baidu.tieba.x47;
import com.baidu.tieba.z8;
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
/* loaded from: classes5.dex */
public class HotTopicDetailActivity extends BaseActivity<HotTopicDetailActivity> implements oo7, BdListView.p {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public HotTopicDetailModel a;
    public po7 b;
    public v47 c;
    public boolean d;
    public long e;
    public boolean f;
    public String g;
    public String h;
    public String i;

    /* loaded from: classes5.dex */
    public class a implements BdUniDispatchSchemeController.b {
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

        @Override // com.baidu.tbadk.BdToken.BdUniDispatchSchemeController.b
        public void a(HashMap<String, Object> hashMap) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, hashMap) == null) && hashMap != null && (hashMap.get(BdUniDispatchSchemeController.PARAM_TOPIC_ID) instanceof String)) {
                String str = (String) hashMap.get(BdUniDispatchSchemeController.PARAM_TOPIC_ID);
                if (StringUtils.isNull(str)) {
                    return;
                }
                this.a.e = pg.g(str, -1L);
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

    public final void A1() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f) {
            MainTabActivityConfig createNormalCfg = new MainTabActivityConfig(this).createNormalCfg(2);
            createNormalCfg.setSubTabName(getString(R.string.obfuscated_res_0x7f0f1356));
            sendMessage(new CustomMessage(2015002, createNormalCfg));
        }
    }

    public String B1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.g : (String) invokeV.objValue;
    }

    public final void C1(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bundle) == null) {
            Intent intent = getIntent();
            if (intent != null) {
                this.g = intent.getStringExtra("topic_id");
                this.h = intent.getStringExtra(IntentConfig.TOPIC_NAME);
                intent.getLongExtra(IntentConfig.TOPIC_FID, 0L);
                intent.getStringExtra(IntentConfig.TOPIC_FIRST_DIR);
                intent.getStringExtra(IntentConfig.TOPIC_SECOND_DIR);
                this.i = intent.getStringExtra("from");
                intent.getLongExtra(IntentConfig.TOPIC_TID, 0L);
            } else if (bundle != null) {
                this.g = bundle.getString("topic_id");
                this.h = bundle.getString(IntentConfig.TOPIC_NAME);
                bundle.getLong(IntentConfig.TOPIC_FID, 0L);
                bundle.getString(IntentConfig.TOPIC_FIRST_DIR);
                bundle.getString(IntentConfig.TOPIC_SECOND_DIR);
                this.i = bundle.getString("from");
                bundle.getLong(IntentConfig.TOPIC_TID, 0L);
            }
        }
    }

    public final boolean D1(Intent intent) {
        InterceptResult invokeL;
        int i;
        String substring;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, intent)) == null) {
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
                        this.e = pg.g(substring, -1L);
                    }
                }
            } else {
                this.e = intent.getLongExtra("topic_id", -1L);
            }
            return this.e > 0;
        }
        return invokeL.booleanValue;
    }

    public void E1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if ("5".equals(this.i)) {
                finish();
            } else {
                new HotRanklistActivityConfig(this).createNormalConfig(VideoMiddlePageActivityConfig.FROM_HOTTOPIC, "all").start();
            }
        }
    }

    public final void F1(int i, a57 a57Var, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i), a57Var, Boolean.valueOf(z)}) == null) {
            int l = this.b.l();
            if (a57Var != null) {
                l = a57Var.d;
            }
            this.b.s(l);
            if (i == 0 && a57Var != null && !ListUtils.isEmpty(a57Var.e)) {
                po7 po7Var = this.b;
                if (!z && po7Var.p(l).b != null) {
                    r1 = false;
                }
                po7Var.t(a57Var, r1, l);
            } else if (this.b.p(l).b == null) {
                this.b.j(i != 0, l);
            }
        }
    }

    public void G1(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            a57 p = this.b.p(i);
            hq4 hq4Var = p.b;
            if (hq4Var == null) {
                H1(i);
            } else if (hq4Var.b() != 0) {
                this.a.B(i, p.b, p.c);
            }
        }
    }

    public void H1(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            boolean A = this.a.A(i);
            if (this.b.p(i).b == null) {
                if (A) {
                    this.b.k(i);
                    this.b.c(i);
                    return;
                }
                this.b.j(true, i);
                this.b.s(i);
            }
        }
    }

    public final boolean I1(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, str2)) == null) {
            if ((TextUtils.isEmpty(str) || pg.g(str, 0L) <= 0) && TextUtils.isEmpty(str2)) {
                return false;
            }
            this.g = str;
            this.h = str2;
            this.a.O(pg.g(str, 0L), str2);
            return true;
        }
        return invokeLL.booleanValue;
    }

    public boolean J1(x47 x47Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, x47Var)) == null) ? this.a.L(x47Var) : invokeL.booleanValue;
    }

    public boolean K1(f57 f57Var, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(1048586, this, f57Var, i)) == null) ? this.a.M(f57Var, i) : invokeLI.booleanValue;
    }

    @Override // com.baidu.tieba.oo7
    public void S(@NonNull RecomTopicList recomTopicList) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048587, this, recomTopicList) == null) && pi.A() && I1(String.valueOf(recomTopicList.topic_id), recomTopicList.topic_name)) {
            this.a.cancelLoadData();
            this.b.resetView();
            f1(1);
        }
    }

    @Override // com.baidu.tieba.oo7
    public void W0(b57 b57Var) {
        c57 e;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048588, this, b57Var) == null) || b57Var == null || (e = b57Var.e()) == null) {
            return;
        }
        String str = "https://tieba.baidu.com/mo/q/newtopic/detail?topic_id=" + this.g;
        if (!TextUtils.isEmpty(this.h)) {
            str = str + "&topic_name=" + URLEncoder.encode(this.h);
        }
        this.c.d(e.a, e.b, str, e.h, e.g, e.e, true, e.d);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            if (this.d) {
                ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
            } else {
                super.enterExitAnimation();
            }
        }
    }

    @Override // com.baidu.tieba.oo7
    public void f1(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i) == null) {
            boolean z = this.a.z(i);
            if (this.b.h() != null) {
                if (z) {
                    return;
                }
                this.b.m();
            } else if (z) {
                this.b.i();
                this.b.e();
            } else {
                this.b.f(true);
                this.b.q();
            }
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

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tieba.z95
    public String getCurrentPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? "a077" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048593, this, i, i2, intent) == null) {
            super.onActivityResult(i, i2, intent);
            if (i2 == -1) {
                if (i == 24007) {
                    this.a.I(intent);
                } else if (i == 25065) {
                    this.a.H();
                } else if (i != 110435) {
                } else {
                    this.a.K();
                }
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i) == null) {
            super.onChangeSkinType(i);
            this.b.a();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, bundle) == null) {
            boolean z = true;
            if (D1(getIntent())) {
                this.g = "" + this.e;
                if (getIntent() != null && getIntent().getParcelableExtra(IntentConfig.KEY_URI) != null && !z8.g().i("MainTabActivity")) {
                    this.d = true;
                }
            } else {
                C1(bundle);
            }
            if (this.d) {
                setIsAddSwipeBackLayout(false);
            }
            super.onCreate(bundle);
            if ((TextUtils.isEmpty(this.g) || pg.g(this.g, 0L) <= 0) && TextUtils.isEmpty(this.h)) {
                finish();
                return;
            }
            this.a = new HotTopicDetailModel(getPageContext(), this);
            this.b = new HotTopicDetailView(getPageContext(), this, bundle);
            this.a.setFrom(this.i);
            I1(this.g, this.h);
            this.c = new v47(this);
            setContentView(this.b.getRootView());
            addGlobalLayoutListener();
            adjustResizeForSoftInput();
            f1(1);
            this.f = (getIntent() == null || !getIntent().getBooleanExtra(TopicDetailActivityConfig.KEY_IS_FROM_YUN_PUSH, false)) ? false : false;
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            super.onDestroy();
            po7 po7Var = this.b;
            if (po7Var != null) {
                po7Var.destroy();
            }
            A1();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            super.onPause();
            this.b.pause();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            super.onResume();
            this.b.resume();
            TiebaStatic.log(new StatisticItem("c13817").param("uid", TbadkCoreApplication.getCurrentAccount()).param("topic_id", this.g));
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.p
    public void onScrollToBottom() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            G1(this.b.l());
        }
    }

    @Override // com.baidu.tieba.oo7
    public void p(int i, a57 a57Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048600, this, i, a57Var) == null) {
            F1(i, a57Var, false);
        }
    }

    @Override // com.baidu.tieba.oo7
    public void q0(int i, b57 b57Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048601, this, i, b57Var) == null) {
            if (b57Var != null && b57Var.p == -1) {
                this.b.d(b57Var);
                return;
            }
            this.b.q();
            this.b.m();
            if (i == 0 && b57Var != null) {
                if (b57Var.e() != null) {
                    I1(b57Var.e().a, b57Var.e().b);
                }
                if (b57Var.e() != null && b57Var.e().k) {
                    this.b.b(true);
                    return;
                }
                this.b.b(false);
                this.b.n(b57Var);
                this.b.r();
                F1(i, b57Var.k, true);
            } else if (this.b.h() == null) {
                this.b.f(false);
            }
        }
    }

    @Override // com.baidu.tieba.oo7
    public void r1(int i, long j, long j2, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048602, this, new Object[]{Integer.valueOf(i), Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i2)}) == null) || i != 0 || j <= 0 || i2 < 0) {
            return;
        }
        if (i2 != 1 && i2 != 2) {
            this.b.g(j, j2);
        } else {
            this.b.o(j, j2, i2);
        }
    }
}
