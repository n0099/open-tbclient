package com.baidu.tieba.newdetail;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
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
import d.b.h0.a.f;
import d.b.h0.r.q.z0;
import d.b.i0.b1.b.b;
import d.b.i0.b1.c.d;
import d.b.i0.b1.c.e;
import d.b.i0.b1.c.i;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes4.dex */
public class HotTopicDetailActivity extends BaseActivity<HotTopicDetailActivity> implements d.b.i0.w1.a, BdListView.p {
    public static final String SCHEME_TOPIC_DETAIL = "tbtopicdetail://";
    public static final String TOPIC_ID_PREFFIX = "topic_id=";
    public long fid;
    public String firstDir;
    public b hotTopicShareModel;
    public HotTopicDetailModel mModel;
    public long mTid;
    public d.b.i0.w1.b mView;
    public String secondDir;
    public boolean mIsFromSchema = false;
    public long topicIdLong = -1;
    public boolean mIsFromYunPush = false;
    public String topicId = null;
    public String topicName = null;
    public String mFrom = "";

    /* loaded from: classes4.dex */
    public class a implements f.b {
        public a() {
        }

        @Override // d.b.h0.a.f.b
        public void onCallBack(HashMap<String, Object> hashMap) {
            if (hashMap != null && (hashMap.get(f.u) instanceof String)) {
                String str = (String) hashMap.get(f.u);
                if (StringUtils.isNull(str)) {
                    return;
                }
                HotTopicDetailActivity.this.topicIdLong = d.b.b.e.m.b.f(str, -1L);
            }
        }
    }

    private void checkBackToHotRank() {
        if (this.mIsFromYunPush) {
            MainTabActivityConfig createNormalCfg = new MainTabActivityConfig(this).createNormalCfg(2);
            createNormalCfg.setSubTabName(getString(R.string.tab_name_topic_rank));
            sendMessage(new CustomMessage(2015002, createNormalCfg));
        }
    }

    private void initParamsByHotTopic(Bundle bundle) {
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

    private boolean initParamsByTopicDetail(Intent intent) {
        int i;
        String substring;
        if (intent.getParcelableExtra(IntentConfig.KEY_URI) != null) {
            Uri uri = (Uri) intent.getParcelableExtra(IntentConfig.KEY_URI);
            String uri2 = uri.toString();
            if (f.c(uri)) {
                f.b().g(uri, new a());
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
                    this.topicIdLong = d.b.b.e.m.b.f(substring, -1L);
                }
            }
        } else {
            this.topicIdLong = intent.getLongExtra("topic_id", -1L);
        }
        return this.topicIdLong > 0;
    }

    private void loadMoreCallback(int i, d dVar, boolean z) {
        int h2 = this.mView.h();
        if (dVar != null) {
            h2 = dVar.H3;
        }
        this.mView.q(h2);
        if (i == 0 && dVar != null && !ListUtils.isEmpty(dVar.I3)) {
            d.b.i0.w1.b bVar = this.mView;
            if (!z && bVar.n(h2).F3 != null) {
                r1 = false;
            }
            bVar.r(dVar, r1, h2);
        } else if (this.mView.n(h2).F3 == null) {
            this.mView.e(i != 0, h2);
        }
    }

    private void resetTopicId(String str, String str2) {
        if ((TextUtils.isEmpty(str) || d.b.b.e.m.b.f(str, 0L) <= 0) && TextUtils.isEmpty(str2)) {
            return;
        }
        this.topicId = str;
        this.topicName = str2;
        this.mModel.D(d.b.b.e.m.b.f(str, 0L), str2);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        if (this.mIsFromSchema) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
        } else {
            super.enterExitAnimation();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        if (this.mIsFromSchema) {
            sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(2)));
        }
        super.finish();
    }

    @Override // com.baidu.tbadk.BaseActivity, d.b.h0.k0.a
    public String getCurrentPageKey() {
        return "a077";
    }

    public String getTopicId() {
        return this.topicId;
    }

    public void jumpToRankList() {
        if ("5".equals(this.mFrom)) {
            finish();
        } else {
            new HotRanklistActivityConfig(this).createNormalConfig("hottopic", "all").start();
        }
    }

    public void loadMoreFeedData(int i) {
        d n = this.mView.n(i);
        z0 z0Var = n.F3;
        if (z0Var == null) {
            refreshFeedData(i);
        } else if (z0Var.b() != 0) {
            this.mModel.u(i, n.F3, n.G3);
        }
    }

    @Override // d.b.i0.w1.a
    public void netCallback(int i, e eVar) {
        if (eVar != null && eVar.s == -1) {
            this.mView.g(eVar);
            return;
        }
        this.mView.o();
        this.mView.k();
        if (i == 0 && eVar != null) {
            if (eVar.h() != null) {
                resetTopicId(eVar.h().f52110e, eVar.h().f52111f);
            }
            this.mView.l(eVar);
            this.mView.p();
            loadMoreCallback(i, eVar.k, true);
        } else if (this.mView.b() == null) {
            this.mView.j(false);
        }
    }

    @Override // d.b.i0.w1.a
    public void netLoadMoreCallback(int i, d dVar) {
        loadMoreCallback(i, dVar, false);
    }

    @Override // d.b.i0.w1.a
    public void netPkCallback(int i, long j, long j2, int i2) {
        if (i != 0 || j <= 0 || i2 < 0) {
            return;
        }
        if (i2 != 1 && i2 != 2) {
            this.mView.s(j, j2);
        } else {
            this.mView.m(j, j2, i2);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1 && i == 110435) {
            this.mModel.A();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mView.a();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        boolean z = true;
        if (initParamsByTopicDetail(getIntent())) {
            this.topicId = "" + this.topicIdLong;
            if (getIntent() != null && getIntent().getParcelableExtra(IntentConfig.KEY_URI) != null && !d.b.b.a.b.f().h("MainTabActivity")) {
                this.mIsFromSchema = true;
            }
        } else {
            initParamsByHotTopic(bundle);
        }
        if (this.mIsFromSchema) {
            setIsAddSwipeBackLayout(false);
        }
        super.onCreate(bundle);
        if ((TextUtils.isEmpty(this.topicId) || d.b.b.e.m.b.f(this.topicId, 0L) <= 0) && TextUtils.isEmpty(this.topicName)) {
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

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.mView.destroy();
        checkBackToHotRank();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.mView.pause();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.mView.resume();
        TiebaStatic.log(new StatisticItem("c13817").param("uid", TbadkCoreApplication.getCurrentAccount()).param("topic_id", this.topicId));
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.p
    public void onScrollToBottom() {
        loadMoreFeedData(this.mView.h());
    }

    public void refreshFeedData(int i) {
        boolean t = this.mModel.t(i);
        if (this.mView.n(i).F3 == null) {
            if (t) {
                this.mView.f(i);
                this.mView.d(i);
                return;
            }
            this.mView.e(true, i);
            this.mView.q(i);
        }
    }

    @Override // d.b.i0.w1.a
    public void refreshFullData(int i) {
        boolean s = this.mModel.s(i);
        if (this.mView.b() != null) {
            if (s) {
                return;
            }
            this.mView.k();
        } else if (s) {
            this.mView.c();
            this.mView.i();
        } else {
            this.mView.j(true);
            this.mView.o();
        }
    }

    public boolean sendBlessData(d.b.i0.b1.c.a aVar) {
        return this.mModel.B(aVar);
    }

    public boolean sendPkData(i iVar, int i) {
        return this.mModel.C(iVar, i);
    }

    @Override // d.b.i0.w1.a
    public void shareTopic(e eVar) {
        d.b.i0.b1.c.f h2;
        if (eVar == null || (h2 = eVar.h()) == null) {
            return;
        }
        String str = "http://tieba.baidu.com/mo/q/newtopic/detail?topic_id=" + this.topicId;
        if (!TextUtils.isEmpty(this.topicName)) {
            str = str + "&topic_name=" + URLEncoder.encode(this.topicName);
        }
        this.hotTopicShareModel.e(h2.f52110e, h2.f52111f, str, h2.k, h2.j, true);
    }
}
