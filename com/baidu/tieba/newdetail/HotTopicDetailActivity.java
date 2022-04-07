package com.baidu.tieba.newdetail;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.an7;
import com.repackage.b47;
import com.repackage.bn7;
import com.repackage.mg;
import com.repackage.qp4;
import com.repackage.r37;
import com.repackage.t37;
import com.repackage.w37;
import com.repackage.x37;
import com.repackage.x8;
import com.repackage.y37;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes3.dex */
public class HotTopicDetailActivity extends BaseActivity<HotTopicDetailActivity> implements an7, BdListView.p {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String SCHEME_TOPIC_DETAIL = "tbtopicdetail://";
    public static final String TOPIC_ID_PREFFIX = "topic_id=";
    public transient /* synthetic */ FieldHolder $fh;
    public long fid;
    public String firstDir;
    public r37 hotTopicShareModel;
    public String mFrom;
    public boolean mIsFromSchema;
    public boolean mIsFromYunPush;
    public HotTopicDetailModel mModel;
    public long mTid;
    public bn7 mView;
    public String secondDir;
    public String topicId;
    public long topicIdLong;
    public String topicName;

    /* loaded from: classes3.dex */
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
                this.a.topicIdLong = mg.g(str, -1L);
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
            createNormalCfg.setSubTabName(getString(R.string.obfuscated_res_0x7f0f132d));
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
                        this.topicIdLong = mg.g(substring, -1L);
                    }
                }
            } else {
                this.topicIdLong = intent.getLongExtra("topic_id", -1L);
            }
            return this.topicIdLong > 0;
        }
        return invokeL.booleanValue;
    }

    private void loadMoreCallback(int i, w37 w37Var, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65541, this, new Object[]{Integer.valueOf(i), w37Var, Boolean.valueOf(z)}) == null) {
            int l = this.mView.l();
            if (w37Var != null) {
                l = w37Var.d;
            }
            this.mView.s(l);
            if (i == 0 && w37Var != null && !ListUtils.isEmpty(w37Var.e)) {
                bn7 bn7Var = this.mView;
                if (!z && bn7Var.p(l).b != null) {
                    r1 = false;
                }
                bn7Var.t(w37Var, r1, l);
            } else if (this.mView.p(l).b == null) {
                this.mView.j(i != 0, l);
            }
        }
    }

    private void resetTopicId(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65542, this, str, str2) == null) {
            if ((TextUtils.isEmpty(str) || mg.g(str, 0L) <= 0) && TextUtils.isEmpty(str2)) {
                return;
            }
            this.topicId = str;
            this.topicName = str2;
            this.mModel.N(mg.g(str, 0L), str2);
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

    @Override // com.baidu.tbadk.BaseActivity, com.repackage.v75
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
                new HotRanklistActivityConfig(this).createNormalConfig(VideoMiddlePageActivityConfig.FROM_HOTTOPIC, "all").start();
            }
        }
    }

    public void loadMoreFeedData(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            w37 p = this.mView.p(i);
            qp4 qp4Var = p.b;
            if (qp4Var == null) {
                refreshFeedData(i);
            } else if (qp4Var.b() != 0) {
                this.mModel.A(i, p.b, p.c);
            }
        }
    }

    @Override // com.repackage.an7
    public void netCallback(int i, x37 x37Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048582, this, i, x37Var) == null) {
            if (x37Var != null && x37Var.p == -1) {
                this.mView.d(x37Var);
                return;
            }
            this.mView.q();
            this.mView.m();
            if (i == 0 && x37Var != null) {
                if (x37Var.e() != null) {
                    resetTopicId(x37Var.e().a, x37Var.e().b);
                }
                if (x37Var.e() != null && x37Var.e().k) {
                    this.mView.b(true);
                    return;
                }
                this.mView.b(false);
                this.mView.n(x37Var);
                this.mView.r();
                loadMoreCallback(i, x37Var.k, true);
            } else if (this.mView.h() == null) {
                this.mView.f(false);
            }
        }
    }

    @Override // com.repackage.an7
    public void netLoadMoreCallback(int i, w37 w37Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048583, this, i, w37Var) == null) {
            loadMoreCallback(i, w37Var, false);
        }
    }

    @Override // com.repackage.an7
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
                if (getIntent() != null && getIntent().getParcelableExtra(IntentConfig.KEY_URI) != null && !x8.f().h("MainTabActivity")) {
                    this.mIsFromSchema = true;
                }
            } else {
                initParamsByHotTopic(bundle);
            }
            if (this.mIsFromSchema) {
                setIsAddSwipeBackLayout(false);
            }
            super.onCreate(bundle);
            if ((TextUtils.isEmpty(this.topicId) || mg.g(this.topicId, 0L) <= 0) && TextUtils.isEmpty(this.topicName)) {
                finish();
                return;
            }
            this.mModel = new HotTopicDetailModel(getPageContext(), this);
            this.mView = new HotTopicDetailView(getPageContext(), this, bundle);
            this.mModel.setFrom(this.mFrom);
            resetTopicId(this.topicId, this.topicName);
            this.hotTopicShareModel = new r37(this);
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
            bn7 bn7Var = this.mView;
            if (bn7Var != null) {
                bn7Var.destroy();
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
            if (this.mView.p(i).b == null) {
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

    @Override // com.repackage.an7
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

    public boolean sendBlessData(t37 t37Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, t37Var)) == null) ? this.mModel.K(t37Var) : invokeL.booleanValue;
    }

    public boolean sendPkData(b47 b47Var, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(1048595, this, b47Var, i)) == null) ? this.mModel.L(b47Var, i) : invokeLI.booleanValue;
    }

    @Override // com.repackage.an7
    public void shareTopic(x37 x37Var) {
        y37 e;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048596, this, x37Var) == null) || x37Var == null || (e = x37Var.e()) == null) {
            return;
        }
        String str = "http://tieba.baidu.com/mo/q/newtopic/detail?topic_id=" + this.topicId;
        if (!TextUtils.isEmpty(this.topicName)) {
            str = str + "&topic_name=" + URLEncoder.encode(this.topicName);
        }
        this.hotTopicShareModel.d(e.a, e.b, str, e.h, e.g, e.e, true, e.d);
    }
}
