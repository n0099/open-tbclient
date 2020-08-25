package com.baidu.tieba.newdetail;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.BdToken.f;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.HotRanklistActivityConfig;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.atomData.TopicDetailActivityConfig;
import com.baidu.tbadk.core.atomData.VideoMiddlePageActivityConfig;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.R;
import com.baidu.tieba.hottopic.data.d;
import com.baidu.tieba.hottopic.data.e;
import com.baidu.tieba.hottopic.data.i;
import com.baidu.tieba.newdetail.a;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes15.dex */
public class HotTopicDetailActivity extends BaseActivity<HotTopicDetailActivity> implements BdListView.e, a.InterfaceC0751a {
    private long dNY;
    private long fid;
    private String firstDir;
    private com.baidu.tieba.hottopic.controller.b iXX;
    private HotTopicDetailModel kkX;
    private a.b kkY;
    private String secondDir;
    private boolean mIsFromSchema = false;
    private long kkZ = -1;
    private boolean kla = false;
    private String eoj = null;
    private String eab = null;
    private String mFrom = "";

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        boolean z = true;
        if (af(getIntent())) {
            this.eoj = "" + this.kkZ;
            if (getIntent() != null && getIntent().getParcelableExtra(IntentConfig.KEY_URI) != null && !com.baidu.adp.base.a.lb().bo("MainTabActivity")) {
                this.mIsFromSchema = true;
            }
        } else {
            az(bundle);
        }
        if (this.mIsFromSchema) {
            setIsAddSwipeBackLayout(false);
        }
        super.onCreate(bundle);
        if ((TextUtils.isEmpty(this.eoj) || com.baidu.adp.lib.f.b.toLong(this.eoj, 0L) <= 0) && TextUtils.isEmpty(this.eab)) {
            finish();
            return;
        }
        this.kkX = new HotTopicDetailModel(getPageContext(), this);
        this.kkY = new HotTopicDetailView(getPageContext(), this, bundle);
        this.kkX.setFrom(this.mFrom);
        fo(this.eoj, this.eab);
        this.iXX = new com.baidu.tieba.hottopic.controller.b(this);
        setContentView(this.kkY.getRootView());
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        Dn(1);
        if (getIntent() == null || !getIntent().getBooleanExtra(TopicDetailActivityConfig.KEY_IS_FROM_YUN_PUSH, false)) {
            z = false;
        }
        this.kla = z;
    }

    private void az(Bundle bundle) {
        Intent intent = getIntent();
        if (intent != null) {
            this.eoj = intent.getStringExtra("topic_id");
            this.eab = intent.getStringExtra("topic_name");
            this.fid = intent.getLongExtra("topic_fid", 0L);
            this.firstDir = intent.getStringExtra("topic_first_dir");
            this.secondDir = intent.getStringExtra("topic_second_dir");
            this.mFrom = intent.getStringExtra("from");
            this.dNY = intent.getLongExtra(IntentConfig.TOPIC_TID, 0L);
        } else if (bundle != null) {
            this.eoj = bundle.getString("topic_id");
            this.eab = bundle.getString("topic_name");
            this.fid = bundle.getLong("topic_fid", 0L);
            this.firstDir = bundle.getString("topic_first_dir");
            this.secondDir = bundle.getString("topic_second_dir");
            this.mFrom = bundle.getString("from");
            this.dNY = bundle.getLong(IntentConfig.TOPIC_TID, 0L);
        }
    }

    private boolean af(Intent intent) {
        int length;
        String substring;
        if (intent.getParcelableExtra(IntentConfig.KEY_URI) != null) {
            Uri uri = (Uri) intent.getParcelableExtra(IntentConfig.KEY_URI);
            String uri2 = uri.toString();
            if (f.p(uri)) {
                f.aYL().f(uri, new f.a() { // from class: com.baidu.tieba.newdetail.HotTopicDetailActivity.1
                    @Override // com.baidu.tbadk.BdToken.f.a
                    public void z(HashMap<String, Object> hashMap) {
                        if (hashMap != null && (hashMap.get(f.dPm) instanceof String)) {
                            String str = (String) hashMap.get(f.dPm);
                            if (!StringUtils.isNull(str)) {
                                HotTopicDetailActivity.this.kkZ = com.baidu.adp.lib.f.b.toLong(str, -1L);
                            }
                        }
                    }
                });
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
                    if (indexOf < 0 || (length = indexOf + "topic_id=".length()) > decode.length()) {
                        return false;
                    }
                    substring = decode.substring(length);
                }
                if (!StringUtils.isNull(substring)) {
                    this.kkZ = com.baidu.adp.lib.f.b.toLong(substring, -1L);
                }
            }
        } else {
            this.kkZ = intent.getLongExtra("topic_id", -1L);
        }
        return this.kkZ > 0;
    }

    @Override // com.baidu.tieba.newdetail.a.InterfaceC0751a
    public void Dn(int i) {
        boolean Du = this.kkX.Du(i);
        if (this.kkY.cSt() == null) {
            if (Du) {
                this.kkY.cSq();
                this.kkY.cSs();
                return;
            }
            this.kkY.si(true);
            this.kkY.cSr();
        } else if (!Du) {
            this.kkY.bGd();
        }
    }

    public void Do(int i) {
        boolean Dv = this.kkX.Dv(i);
        if (this.kkY.Dt(i).pageData == null) {
            if (Dv) {
                this.kkY.Dq(i);
                this.kkY.Ds(i);
                return;
            }
            this.kkY.C(true, i);
            this.kkY.Dr(i);
        }
    }

    public void Dp(int i) {
        d Dt = this.kkY.Dt(i);
        if (Dt.pageData == null) {
            Do(i);
        } else if (Dt.pageData.bdu() != 0) {
            this.kkX.a(i, Dt.pageData, Dt.lastId);
        }
    }

    public boolean a(i iVar, int i) {
        return this.kkX.a(iVar, i);
    }

    public boolean a(com.baidu.tieba.hottopic.data.a aVar) {
        return this.kkX.a(aVar);
    }

    public String getTopicId() {
        return this.eoj;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        Dp(this.kkY.cSu());
    }

    @Override // com.baidu.tieba.newdetail.a.InterfaceC0751a
    public void a(int i, e eVar) {
        if (eVar != null && eVar.sortType == -1) {
            this.kkY.g(eVar);
            return;
        }
        this.kkY.cSr();
        this.kkY.bGd();
        if (i != 0 || eVar == null) {
            if (this.kkY.cSt() == null) {
                this.kkY.si(false);
                return;
            }
            return;
        }
        if (eVar.czY() != null) {
            fo(eVar.czY().eoj, eVar.czY().eab);
        }
        this.kkY.f(eVar);
        this.kkY.cSv();
        a(i, eVar.iZg, true);
    }

    private void fo(String str, String str2) {
        if ((!TextUtils.isEmpty(str) && com.baidu.adp.lib.f.b.toLong(str, 0L) > 0) || !TextUtils.isEmpty(str2)) {
            this.eoj = str;
            this.eab = str2;
            this.kkX.t(com.baidu.adp.lib.f.b.toLong(str, 0L), str2);
        }
    }

    @Override // com.baidu.tieba.newdetail.a.InterfaceC0751a
    public void a(int i, d dVar) {
        a(i, dVar, false);
    }

    @Override // com.baidu.tieba.newdetail.a.InterfaceC0751a
    public void a(int i, long j, long j2, int i2) {
        if (i == 0 && j > 0 && i2 >= 0) {
            if (i2 == 1 || i2 == 2) {
                this.kkY.d(j, j2, i2);
            } else {
                this.kkY.F(j, j2);
            }
        }
    }

    @Override // com.baidu.tieba.newdetail.a.InterfaceC0751a
    public void e(e eVar) {
        com.baidu.tieba.hottopic.data.f czY;
        if (eVar != null && (czY = eVar.czY()) != null) {
            String str = "http://tieba.baidu.com/mo/q/newtopic/detail?topic_id=" + this.eoj;
            if (!TextUtils.isEmpty(this.eab)) {
                str = str + "&topic_name=" + URLEncoder.encode(this.eab);
            }
            this.iXX.b(czY.eoj, czY.eab, str, czY.iTh, czY.shareTitle, true);
        }
    }

    public void cSo() {
        if ("5".equals(this.mFrom)) {
            finish();
        } else {
            new HotRanklistActivityConfig(this).createNormalConfig(VideoMiddlePageActivityConfig.FROM_HOTTOPIC, "all").start();
        }
    }

    private void a(int i, d dVar, boolean z) {
        boolean z2 = false;
        int cSu = this.kkY.cSu();
        if (dVar != null) {
            cSu = dVar.sortType;
        }
        this.kkY.Dr(cSu);
        if (i != 0 || dVar == null || y.isEmpty(dVar.list)) {
            if (this.kkY.Dt(cSu).pageData == null) {
                this.kkY.C(i != 0, cSu);
                return;
            }
            return;
        }
        a.b bVar = this.kkY;
        if (z || this.kkY.Dt(cSu).pageData == null) {
            z2 = true;
        }
        bVar.a(dVar, z2, cSu);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.kkY.onChangeSkinType();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return "a024";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.kkY.resume();
        TiebaStatic.log(new aq("c13817").dD("uid", TbadkCoreApplication.getCurrentAccount()).dD("topic_id", this.eoj));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.kkY.pause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.kkY.destroy();
        cSp();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        if (this.mIsFromSchema) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(2)));
        }
        super.finish();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        if (this.mIsFromSchema) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
        } else {
            super.enterExitAnimation();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 110435:
                    this.kkX.cSw();
                    return;
                default:
                    return;
            }
        }
    }

    private void cSp() {
        if (this.kla) {
            MainTabActivityConfig createNormalCfg = new MainTabActivityConfig(this).createNormalCfg(2);
            createNormalCfg.setSubTabName(getString(R.string.tab_name_topic_rank));
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, createNormalCfg));
        }
    }
}
