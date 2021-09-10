package com.baidu.tieba.newdetail;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.q0.a.g;
import c.a.q0.s.q.b1;
import c.a.r0.i1.b.b;
import c.a.r0.i1.c.d;
import c.a.r0.i1.c.e;
import c.a.r0.i1.c.f;
import c.a.r0.i1.c.i;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
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
/* loaded from: classes7.dex */
public class HotTopicDetailActivity extends BaseActivity<HotTopicDetailActivity> implements c.a.r0.d2.a, BdListView.p {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String SCHEME_TOPIC_DETAIL = "tbtopicdetail://";
    public static final String TOPIC_ID_PREFFIX = "topic_id=";
    public transient /* synthetic */ FieldHolder $fh;
    public long fid;
    public String firstDir;
    public b hotTopicShareModel;
    public String mFrom;
    public boolean mIsFromSchema;
    public boolean mIsFromYunPush;
    public HotTopicDetailModel mModel;
    public long mTid;
    public c.a.r0.d2.b mView;
    public String secondDir;
    public String topicId;
    public long topicIdLong;
    public String topicName;

    /* loaded from: classes7.dex */
    public class a implements g.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ HotTopicDetailActivity f54497a;

        public a(HotTopicDetailActivity hotTopicDetailActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hotTopicDetailActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f54497a = hotTopicDetailActivity;
        }

        @Override // c.a.q0.a.g.b
        public void onCallBack(HashMap<String, Object> hashMap) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, hashMap) == null) && hashMap != null && (hashMap.get(g.v) instanceof String)) {
                String str = (String) hashMap.get(g.v);
                if (StringUtils.isNull(str)) {
                    return;
                }
                this.f54497a.topicIdLong = c.a.e.e.m.b.g(str, -1L);
            }
        }
    }

    public HotTopicDetailActivity() {
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
            createNormalCfg.setSubTabName(getString(R.string.tab_name_topic_rank));
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
        int i2;
        String substring;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, intent)) == null) {
            if (intent.getParcelableExtra(IntentConfig.KEY_URI) != null) {
                Uri uri = (Uri) intent.getParcelableExtra(IntentConfig.KEY_URI);
                String uri2 = uri.toString();
                if (g.c(uri)) {
                    g.b().g(uri, new a(this));
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
                        if (indexOf < 0 || (i2 = indexOf + 9) > decode.length()) {
                            return false;
                        }
                        substring = decode.substring(i2);
                    }
                    if (!StringUtils.isNull(substring)) {
                        this.topicIdLong = c.a.e.e.m.b.g(substring, -1L);
                    }
                }
            } else {
                this.topicIdLong = intent.getLongExtra("topic_id", -1L);
            }
            return this.topicIdLong > 0;
        }
        return invokeL.booleanValue;
    }

    private void loadMoreCallback(int i2, d dVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(AdIconUtil.AD_TEXT_ID, this, new Object[]{Integer.valueOf(i2), dVar, Boolean.valueOf(z)}) == null) {
            int curFeedType = this.mView.curFeedType();
            if (dVar != null) {
                curFeedType = dVar.Z3;
            }
            this.mView.hideFeedLoading(curFeedType);
            if (i2 == 0 && dVar != null && !ListUtils.isEmpty(dVar.a4)) {
                c.a.r0.d2.b bVar = this.mView;
                if (!z && bVar.curFeedData(curFeedType).X3 != null) {
                    r1 = false;
                }
                bVar.showFeedView(dVar, r1, curFeedType);
            } else if (this.mView.curFeedData(curFeedType).X3 == null) {
                this.mView.showFeedEmpty(i2 != 0, curFeedType);
            }
        }
    }

    private void resetTopicId(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, this, str, str2) == null) {
            if ((TextUtils.isEmpty(str) || c.a.e.e.m.b.g(str, 0L) <= 0) && TextUtils.isEmpty(str2)) {
                return;
            }
            this.topicId = str;
            this.topicName = str2;
            this.mModel.H(c.a.e.e.m.b.g(str, 0L), str2);
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

    @Override // com.baidu.tbadk.BaseActivity, c.a.q0.o0.a
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

    public void loadMoreFeedData(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            d curFeedData = this.mView.curFeedData(i2);
            b1 b1Var = curFeedData.X3;
            if (b1Var == null) {
                refreshFeedData(i2);
            } else if (b1Var.b() != 0) {
                this.mModel.y(i2, curFeedData.X3, curFeedData.Y3);
            }
        }
    }

    @Override // c.a.r0.d2.a
    public void netCallback(int i2, e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048582, this, i2, eVar) == null) {
            if (eVar != null && eVar.s == -1) {
                this.mView.refreshPkAndBless(eVar);
                return;
            }
            this.mView.hideFullLoading();
            this.mView.stopPullRefresh();
            if (i2 == 0 && eVar != null) {
                if (eVar.h() != null) {
                    resetTopicId(eVar.h().f19279e, eVar.h().f19280f);
                }
                if (eVar.h() != null && eVar.h().s) {
                    this.mView.showHasDeleteEmpty(true);
                    return;
                }
                this.mView.showHasDeleteEmpty(false);
                this.mView.showHeadView(eVar);
                this.mView.initViewPage();
                loadMoreCallback(i2, eVar.k, true);
            } else if (this.mView.curHeadData() == null) {
                this.mView.showFullEmpty(false);
            }
        }
    }

    @Override // c.a.r0.d2.a
    public void netLoadMoreCallback(int i2, d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048583, this, i2, dVar) == null) {
            loadMoreCallback(i2, dVar, false);
        }
    }

    @Override // c.a.r0.d2.a
    public void netPkCallback(int i2, long j2, long j3, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2), Long.valueOf(j3), Integer.valueOf(i3)}) == null) || i2 != 0 || j2 <= 0 || i3 < 0) {
            return;
        }
        if (i3 != 1 && i3 != 2) {
            this.mView.showBlessView(j2, j3);
        } else {
            this.mView.changePkView(j2, j3, i3);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048585, this, i2, i3, intent) == null) {
            super.onActivityResult(i2, i3, intent);
            if (i3 == -1 && i2 == 110435) {
                this.mModel.E();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            super.onChangeSkinType(i2);
            this.mView.onChangeSkinType();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, bundle) == null) {
            boolean z = true;
            if (initParamsByTopicDetail(getIntent())) {
                this.topicId = "" + this.topicIdLong;
                if (getIntent() != null && getIntent().getParcelableExtra(IntentConfig.KEY_URI) != null && !c.a.e.a.b.f().i("MainTabActivity")) {
                    this.mIsFromSchema = true;
                }
            } else {
                initParamsByHotTopic(bundle);
            }
            if (this.mIsFromSchema) {
                setIsAddSwipeBackLayout(false);
            }
            super.onCreate(bundle);
            if ((TextUtils.isEmpty(this.topicId) || c.a.e.e.m.b.g(this.topicId, 0L) <= 0) && TextUtils.isEmpty(this.topicName)) {
                finish();
                return;
            }
            this.mModel = new HotTopicDetailModel(getPageContext(), this);
            this.mView = new HotTopicDetailView(getPageContext(), this, bundle);
            this.mModel.setFrom(this.mFrom);
            resetTopicId(this.topicId, this.topicName);
            this.hotTopicShareModel = new b(this);
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
            c.a.r0.d2.b bVar = this.mView;
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
            loadMoreFeedData(this.mView.curFeedType());
        }
    }

    public void refreshFeedData(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i2) == null) {
            boolean x = this.mModel.x(i2);
            if (this.mView.curFeedData(i2).X3 == null) {
                if (x) {
                    this.mView.showFeedLoading(i2);
                    this.mView.hideFeedEmpty(i2);
                    return;
                }
                this.mView.showFeedEmpty(true, i2);
                this.mView.hideFeedLoading(i2);
            }
        }
    }

    @Override // c.a.r0.d2.a
    public void refreshFullData(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i2) == null) {
            boolean w = this.mModel.w(i2);
            if (this.mView.curHeadData() != null) {
                if (w) {
                    return;
                }
                this.mView.stopPullRefresh();
            } else if (w) {
                this.mView.showFullLoading();
                this.mView.hideFullEmpty();
            } else {
                this.mView.showFullEmpty(true);
                this.mView.hideFullLoading();
            }
        }
    }

    public boolean sendBlessData(c.a.r0.i1.c.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, aVar)) == null) ? this.mModel.F(aVar) : invokeL.booleanValue;
    }

    public boolean sendPkData(i iVar, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(1048595, this, iVar, i2)) == null) ? this.mModel.G(iVar, i2) : invokeLI.booleanValue;
    }

    @Override // c.a.r0.d2.a
    public void shareTopic(e eVar) {
        f h2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048596, this, eVar) == null) || eVar == null || (h2 = eVar.h()) == null) {
            return;
        }
        String str = "http://tieba.baidu.com/mo/q/newtopic/detail?topic_id=" + this.topicId;
        if (!TextUtils.isEmpty(this.topicName)) {
            str = str + "&topic_name=" + URLEncoder.encode(this.topicName);
        }
        this.hotTopicShareModel.e(h2.f19279e, h2.f19280f, str, h2.k, h2.f19284j, true);
    }
}
