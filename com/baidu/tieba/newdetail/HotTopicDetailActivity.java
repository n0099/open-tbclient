package com.baidu.tieba.newdetail;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.o0.r.r.z0;
import c.a.p0.q2.b;
import c.a.p0.s1.b.d;
import c.a.p0.s1.b.e;
import c.a.p0.s1.b.f;
import c.a.p0.s1.b.i;
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
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes5.dex */
public class HotTopicDetailActivity extends BaseActivity<HotTopicDetailActivity> implements c.a.p0.q2.a, BdListView.p {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String SCHEME_TOPIC_DETAIL = "tbtopicdetail://";
    public static final String TOPIC_ID_PREFFIX = "topic_id=";
    public transient /* synthetic */ FieldHolder $fh;
    public long fid;
    public String firstDir;
    public c.a.p0.s1.a.a hotTopicShareModel;
    public String mFrom;
    public boolean mIsFromSchema;
    public boolean mIsFromYunPush;
    public HotTopicDetailModel mModel;
    public long mTid;
    public b mView;
    public String secondDir;
    public String topicId;
    public long topicIdLong;
    public String topicName;

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
                this.a.topicIdLong = c.a.d.f.m.b.g(str, -1L);
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
        this.mIsFromSchema = false;
        this.topicIdLong = -1L;
        this.mIsFromYunPush = false;
        this.topicId = null;
        this.topicName = null;
        this.mFrom = "";
    }

    private void checkBackToHotRank() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65538, this) == null) && this.mIsFromYunPush) {
            MainTabActivityConfig createNormalCfg = new MainTabActivityConfig(this).createNormalCfg(2);
            createNormalCfg.setSubTabName(getString(R.string.obfuscated_res_0x7f0f1325));
            sendMessage(new CustomMessage(2015002, createNormalCfg));
        }
    }

    private void initParamsByHotTopic(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, bundle) == null) {
            Intent intent = getIntent();
            if (intent != null) {
                this.topicId = intent.getStringExtra("topic_id");
                this.topicName = intent.getStringExtra(IntentConfig.TOPIC_NAME);
                this.fid = intent.getLongExtra(IntentConfig.TOPIC_FID, 0L);
                this.firstDir = intent.getStringExtra(IntentConfig.TOPIC_FIRST_DIR);
                this.secondDir = intent.getStringExtra(IntentConfig.TOPIC_SECOND_DIR);
                this.mFrom = intent.getStringExtra("from");
                this.mTid = intent.getLongExtra(IntentConfig.TOPIC_TID, 0L);
            } else if (bundle != null) {
                this.topicId = bundle.getString("topic_id");
                this.topicName = bundle.getString(IntentConfig.TOPIC_NAME);
                this.fid = bundle.getLong(IntentConfig.TOPIC_FID, 0L);
                this.firstDir = bundle.getString(IntentConfig.TOPIC_FIRST_DIR);
                this.secondDir = bundle.getString(IntentConfig.TOPIC_SECOND_DIR);
                this.mFrom = bundle.getString("from");
                this.mTid = bundle.getLong(IntentConfig.TOPIC_TID, 0L);
            }
        }
    }

    private boolean initParamsByTopicDetail(Intent intent) {
        InterceptResult invokeL;
        int i;
        String substring;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, intent)) == null) {
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
                        this.topicIdLong = c.a.d.f.m.b.g(substring, -1L);
                    }
                }
            } else {
                this.topicIdLong = intent.getLongExtra("topic_id", -1L);
            }
            return this.topicIdLong > 0;
        }
        return invokeL.booleanValue;
    }

    private void loadMoreCallback(int i, d dVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65541, this, new Object[]{Integer.valueOf(i), dVar, Boolean.valueOf(z)}) == null) {
            int l = this.mView.l();
            if (dVar != null) {
                l = dVar.f18147d;
            }
            this.mView.s(l);
            if (i == 0 && dVar != null && !ListUtils.isEmpty(dVar.f18148e)) {
                b bVar = this.mView;
                if (!z && bVar.p(l).f18145b != null) {
                    r1 = false;
                }
                bVar.t(dVar, r1, l);
            } else if (this.mView.p(l).f18145b == null) {
                this.mView.j(i != 0, l);
            }
        }
    }

    private void resetTopicId(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65542, this, str, str2) == null) {
            if ((TextUtils.isEmpty(str) || c.a.d.f.m.b.g(str, 0L) <= 0) && TextUtils.isEmpty(str2)) {
                return;
            }
            this.topicId = str;
            this.topicName = str2;
            this.mModel.N(c.a.d.f.m.b.g(str, 0L), str2);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (this.mIsFromSchema) {
                ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
            } else {
                super.enterExitAnimation();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (this.mIsFromSchema) {
                sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(2)));
            }
            super.finish();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, c.a.o0.p0.a
    public String getCurrentPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "a077" : (String) invokeV.objValue;
    }

    public String getTopicId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.topicId : (String) invokeV.objValue;
    }

    public void jumpToRankList() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if ("5".equals(this.mFrom)) {
                finish();
            } else {
                new HotRanklistActivityConfig(this).createNormalConfig("hottopic", "all").start();
            }
        }
    }

    public void loadMoreFeedData(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            d p = this.mView.p(i);
            z0 z0Var = p.f18145b;
            if (z0Var == null) {
                refreshFeedData(i);
            } else if (z0Var.b() != 0) {
                this.mModel.A(i, p.f18145b, p.f18146c);
            }
        }
    }

    @Override // c.a.p0.q2.a
    public void netCallback(int i, e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048582, this, i, eVar) == null) {
            if (eVar != null && eVar.p == -1) {
                this.mView.d(eVar);
                return;
            }
            this.mView.q();
            this.mView.m();
            if (i == 0 && eVar != null) {
                if (eVar.e() != null) {
                    resetTopicId(eVar.e().a, eVar.e().f18157b);
                }
                if (eVar.e() != null && eVar.e().k) {
                    this.mView.b(true);
                    return;
                }
                this.mView.b(false);
                this.mView.n(eVar);
                this.mView.r();
                loadMoreCallback(i, eVar.k, true);
            } else if (this.mView.h() == null) {
                this.mView.f(false);
            }
        }
    }

    @Override // c.a.p0.q2.a
    public void netLoadMoreCallback(int i, d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048583, this, i, dVar) == null) {
            loadMoreCallback(i, dVar, false);
        }
    }

    @Override // c.a.p0.q2.a
    public void netPkCallback(int i, long j, long j2, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Integer.valueOf(i), Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i2)}) == null) || i != 0 || j <= 0 || i2 < 0) {
            return;
        }
        if (i2 != 1 && i2 != 2) {
            this.mView.g(j, j2);
        } else {
            this.mView.o(j, j2, i2);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048585, this, i, i2, intent) == null) {
            super.onActivityResult(i, i2, intent);
            if (i2 == -1) {
                if (i == 24007) {
                    this.mModel.H(intent);
                } else if (i == 25065) {
                    this.mModel.G();
                } else if (i != 110435) {
                } else {
                    this.mModel.J();
                }
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
            super.onChangeSkinType(i);
            this.mView.a();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, bundle) == null) {
            boolean z = true;
            if (initParamsByTopicDetail(getIntent())) {
                this.topicId = "" + this.topicIdLong;
                if (getIntent() != null && getIntent().getParcelableExtra(IntentConfig.KEY_URI) != null && !c.a.d.a.b.g().i("MainTabActivity")) {
                    this.mIsFromSchema = true;
                }
            } else {
                initParamsByHotTopic(bundle);
            }
            if (this.mIsFromSchema) {
                setIsAddSwipeBackLayout(false);
            }
            super.onCreate(bundle);
            if ((TextUtils.isEmpty(this.topicId) || c.a.d.f.m.b.g(this.topicId, 0L) <= 0) && TextUtils.isEmpty(this.topicName)) {
                finish();
                return;
            }
            this.mModel = new HotTopicDetailModel(getPageContext(), this);
            this.mView = new HotTopicDetailView(getPageContext(), this, bundle);
            this.mModel.setFrom(this.mFrom);
            resetTopicId(this.topicId, this.topicName);
            this.hotTopicShareModel = new c.a.p0.s1.a.a(this);
            setContentView(this.mView.getRootView());
            addGlobalLayoutListener();
            adjustResizeForSoftInput();
            refreshFullData(1);
            this.mIsFromYunPush = (getIntent() == null || !getIntent().getBooleanExtra(TopicDetailActivityConfig.KEY_IS_FROM_YUN_PUSH, false)) ? false : false;
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            super.onDestroy();
            b bVar = this.mView;
            if (bVar != null) {
                bVar.destroy();
            }
            checkBackToHotRank();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            super.onPause();
            this.mView.pause();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            super.onResume();
            this.mView.resume();
            TiebaStatic.log(new StatisticItem("c13817").param("uid", TbadkCoreApplication.getCurrentAccount()).param("topic_id", this.topicId));
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.p
    public void onScrollToBottom() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            loadMoreFeedData(this.mView.l());
        }
    }

    public void refreshFeedData(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i) == null) {
            boolean z = this.mModel.z(i);
            if (this.mView.p(i).f18145b == null) {
                if (z) {
                    this.mView.k(i);
                    this.mView.c(i);
                    return;
                }
                this.mView.j(true, i);
                this.mView.s(i);
            }
        }
    }

    @Override // c.a.p0.q2.a
    public void refreshFullData(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i) == null) {
            boolean y = this.mModel.y(i);
            if (this.mView.h() != null) {
                if (y) {
                    return;
                }
                this.mView.m();
            } else if (y) {
                this.mView.i();
                this.mView.e();
            } else {
                this.mView.f(true);
                this.mView.q();
            }
        }
    }

    public boolean sendBlessData(c.a.p0.s1.b.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, aVar)) == null) ? this.mModel.K(aVar) : invokeL.booleanValue;
    }

    public boolean sendPkData(i iVar, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(1048595, this, iVar, i)) == null) ? this.mModel.L(iVar, i) : invokeLI.booleanValue;
    }

    @Override // c.a.p0.q2.a
    public void shareTopic(e eVar) {
        f e2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048596, this, eVar) == null) || eVar == null || (e2 = eVar.e()) == null) {
            return;
        }
        String str = "http://tieba.baidu.com/mo/q/newtopic/detail?topic_id=" + this.topicId;
        if (!TextUtils.isEmpty(this.topicName)) {
            str = str + "&topic_name=" + URLEncoder.encode(this.topicName);
        }
        this.hotTopicShareModel.d(e2.a, e2.f18157b, str, e2.f18163h, e2.f18162g, e2.f18160e, true, e2.f18159d);
    }
}
