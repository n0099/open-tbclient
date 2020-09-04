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
    private long dOc;
    private long fid;
    private String firstDir;
    private com.baidu.tieba.hottopic.controller.b iYd;
    private HotTopicDetailModel kle;
    private a.b klf;
    private String secondDir;
    private boolean mIsFromSchema = false;
    private long klg = -1;
    private boolean klh = false;
    private String eon = null;
    private String eaf = null;
    private String mFrom = "";

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        boolean z = true;
        if (af(getIntent())) {
            this.eon = "" + this.klg;
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
        if ((TextUtils.isEmpty(this.eon) || com.baidu.adp.lib.f.b.toLong(this.eon, 0L) <= 0) && TextUtils.isEmpty(this.eaf)) {
            finish();
            return;
        }
        this.kle = new HotTopicDetailModel(getPageContext(), this);
        this.klf = new HotTopicDetailView(getPageContext(), this, bundle);
        this.kle.setFrom(this.mFrom);
        fp(this.eon, this.eaf);
        this.iYd = new com.baidu.tieba.hottopic.controller.b(this);
        setContentView(this.klf.getRootView());
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        Dn(1);
        if (getIntent() == null || !getIntent().getBooleanExtra(TopicDetailActivityConfig.KEY_IS_FROM_YUN_PUSH, false)) {
            z = false;
        }
        this.klh = z;
    }

    private void az(Bundle bundle) {
        Intent intent = getIntent();
        if (intent != null) {
            this.eon = intent.getStringExtra("topic_id");
            this.eaf = intent.getStringExtra("topic_name");
            this.fid = intent.getLongExtra("topic_fid", 0L);
            this.firstDir = intent.getStringExtra("topic_first_dir");
            this.secondDir = intent.getStringExtra("topic_second_dir");
            this.mFrom = intent.getStringExtra("from");
            this.dOc = intent.getLongExtra(IntentConfig.TOPIC_TID, 0L);
        } else if (bundle != null) {
            this.eon = bundle.getString("topic_id");
            this.eaf = bundle.getString("topic_name");
            this.fid = bundle.getLong("topic_fid", 0L);
            this.firstDir = bundle.getString("topic_first_dir");
            this.secondDir = bundle.getString("topic_second_dir");
            this.mFrom = bundle.getString("from");
            this.dOc = bundle.getLong(IntentConfig.TOPIC_TID, 0L);
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
                        if (hashMap != null && (hashMap.get(f.dPq) instanceof String)) {
                            String str = (String) hashMap.get(f.dPq);
                            if (!StringUtils.isNull(str)) {
                                HotTopicDetailActivity.this.klg = com.baidu.adp.lib.f.b.toLong(str, -1L);
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
                    this.klg = com.baidu.adp.lib.f.b.toLong(substring, -1L);
                }
            }
        } else {
            this.klg = intent.getLongExtra("topic_id", -1L);
        }
        return this.klg > 0;
    }

    @Override // com.baidu.tieba.newdetail.a.InterfaceC0751a
    public void Dn(int i) {
        boolean Du = this.kle.Du(i);
        if (this.klf.cSu() == null) {
            if (Du) {
                this.klf.cSr();
                this.klf.cSt();
                return;
            }
            this.klf.sk(true);
            this.klf.cSs();
        } else if (!Du) {
            this.klf.bGe();
        }
    }

    public void Do(int i) {
        boolean Dv = this.kle.Dv(i);
        if (this.klf.Dt(i).pageData == null) {
            if (Dv) {
                this.klf.Dq(i);
                this.klf.Ds(i);
                return;
            }
            this.klf.C(true, i);
            this.klf.Dr(i);
        }
    }

    public void Dp(int i) {
        d Dt = this.klf.Dt(i);
        if (Dt.pageData == null) {
            Do(i);
        } else if (Dt.pageData.bdu() != 0) {
            this.kle.a(i, Dt.pageData, Dt.lastId);
        }
    }

    public boolean a(i iVar, int i) {
        return this.kle.a(iVar, i);
    }

    public boolean a(com.baidu.tieba.hottopic.data.a aVar) {
        return this.kle.a(aVar);
    }

    public String getTopicId() {
        return this.eon;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        Dp(this.klf.cSv());
    }

    @Override // com.baidu.tieba.newdetail.a.InterfaceC0751a
    public void a(int i, e eVar) {
        if (eVar != null && eVar.sortType == -1) {
            this.klf.g(eVar);
            return;
        }
        this.klf.cSs();
        this.klf.bGe();
        if (i != 0 || eVar == null) {
            if (this.klf.cSu() == null) {
                this.klf.sk(false);
                return;
            }
            return;
        }
        if (eVar.czZ() != null) {
            fp(eVar.czZ().eon, eVar.czZ().eaf);
        }
        this.klf.f(eVar);
        this.klf.cSw();
        a(i, eVar.iZm, true);
    }

    private void fp(String str, String str2) {
        if ((!TextUtils.isEmpty(str) && com.baidu.adp.lib.f.b.toLong(str, 0L) > 0) || !TextUtils.isEmpty(str2)) {
            this.eon = str;
            this.eaf = str2;
            this.kle.t(com.baidu.adp.lib.f.b.toLong(str, 0L), str2);
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
                this.klf.d(j, j2, i2);
            } else {
                this.klf.F(j, j2);
            }
        }
    }

    @Override // com.baidu.tieba.newdetail.a.InterfaceC0751a
    public void e(e eVar) {
        com.baidu.tieba.hottopic.data.f czZ;
        if (eVar != null && (czZ = eVar.czZ()) != null) {
            String str = "http://tieba.baidu.com/mo/q/newtopic/detail?topic_id=" + this.eon;
            if (!TextUtils.isEmpty(this.eaf)) {
                str = str + "&topic_name=" + URLEncoder.encode(this.eaf);
            }
            this.iYd.b(czZ.eon, czZ.eaf, str, czZ.iTn, czZ.shareTitle, true);
        }
    }

    public void cSp() {
        if ("5".equals(this.mFrom)) {
            finish();
        } else {
            new HotRanklistActivityConfig(this).createNormalConfig(VideoMiddlePageActivityConfig.FROM_HOTTOPIC, "all").start();
        }
    }

    private void a(int i, d dVar, boolean z) {
        boolean z2 = false;
        int cSv = this.klf.cSv();
        if (dVar != null) {
            cSv = dVar.sortType;
        }
        this.klf.Dr(cSv);
        if (i != 0 || dVar == null || y.isEmpty(dVar.list)) {
            if (this.klf.Dt(cSv).pageData == null) {
                this.klf.C(i != 0, cSv);
                return;
            }
            return;
        }
        a.b bVar = this.klf;
        if (z || this.klf.Dt(cSv).pageData == null) {
            z2 = true;
        }
        bVar.a(dVar, z2, cSv);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.klf.onChangeSkinType();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return "a024";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.klf.resume();
        TiebaStatic.log(new aq("c13817").dD("uid", TbadkCoreApplication.getCurrentAccount()).dD("topic_id", this.eon));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.klf.pause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.klf.destroy();
        cSq();
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
                    this.kle.cSx();
                    return;
                default:
                    return;
            }
        }
    }

    private void cSq() {
        if (this.klh) {
            MainTabActivityConfig createNormalCfg = new MainTabActivityConfig(this).createNormalCfg(2);
            createNormalCfg.setSubTabName(getString(R.string.tab_name_topic_rank));
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, createNormalCfg));
        }
    }
}
