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
/* loaded from: classes21.dex */
public class HotTopicDetailActivity extends BaseActivity<HotTopicDetailActivity> implements BdListView.e, a.InterfaceC0766a {
    private long ecg;
    private long fid;
    private String firstDir;
    private com.baidu.tieba.hottopic.controller.b jvI;
    private HotTopicDetailModel kIP;
    private a.b kIQ;
    private String secondDir;
    private boolean mIsFromSchema = false;
    private long kIR = -1;
    private boolean kIS = false;
    private String eCP = null;
    private String eou = null;
    private String mFrom = "";

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        boolean z = true;
        if (ac(getIntent())) {
            this.eCP = "" + this.kIR;
            if (getIntent() != null && getIntent().getParcelableExtra(IntentConfig.KEY_URI) != null && !com.baidu.adp.base.a.lg().bq("MainTabActivity")) {
                this.mIsFromSchema = true;
            }
        } else {
            az(bundle);
        }
        if (this.mIsFromSchema) {
            setIsAddSwipeBackLayout(false);
        }
        super.onCreate(bundle);
        if ((TextUtils.isEmpty(this.eCP) || com.baidu.adp.lib.f.b.toLong(this.eCP, 0L) <= 0) && TextUtils.isEmpty(this.eou)) {
            finish();
            return;
        }
        this.kIP = new HotTopicDetailModel(getPageContext(), this);
        this.kIQ = new HotTopicDetailView(getPageContext(), this, bundle);
        this.kIP.setFrom(this.mFrom);
        fJ(this.eCP, this.eou);
        this.jvI = new com.baidu.tieba.hottopic.controller.b(this);
        setContentView(this.kIQ.getRootView());
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        Eu(1);
        if (getIntent() == null || !getIntent().getBooleanExtra(TopicDetailActivityConfig.KEY_IS_FROM_YUN_PUSH, false)) {
            z = false;
        }
        this.kIS = z;
    }

    private void az(Bundle bundle) {
        Intent intent = getIntent();
        if (intent != null) {
            this.eCP = intent.getStringExtra("topic_id");
            this.eou = intent.getStringExtra("topic_name");
            this.fid = intent.getLongExtra("topic_fid", 0L);
            this.firstDir = intent.getStringExtra("topic_first_dir");
            this.secondDir = intent.getStringExtra("topic_second_dir");
            this.mFrom = intent.getStringExtra("from");
            this.ecg = intent.getLongExtra(IntentConfig.TOPIC_TID, 0L);
        } else if (bundle != null) {
            this.eCP = bundle.getString("topic_id");
            this.eou = bundle.getString("topic_name");
            this.fid = bundle.getLong("topic_fid", 0L);
            this.firstDir = bundle.getString("topic_first_dir");
            this.secondDir = bundle.getString("topic_second_dir");
            this.mFrom = bundle.getString("from");
            this.ecg = bundle.getLong(IntentConfig.TOPIC_TID, 0L);
        }
    }

    private boolean ac(Intent intent) {
        int length;
        String substring;
        if (intent.getParcelableExtra(IntentConfig.KEY_URI) != null) {
            Uri uri = (Uri) intent.getParcelableExtra(IntentConfig.KEY_URI);
            String uri2 = uri.toString();
            if (f.p(uri)) {
                f.bcg().e(uri, new f.a() { // from class: com.baidu.tieba.newdetail.HotTopicDetailActivity.1
                    @Override // com.baidu.tbadk.BdToken.f.a
                    public void B(HashMap<String, Object> hashMap) {
                        if (hashMap != null && (hashMap.get(f.edx) instanceof String)) {
                            String str = (String) hashMap.get(f.edx);
                            if (!StringUtils.isNull(str)) {
                                HotTopicDetailActivity.this.kIR = com.baidu.adp.lib.f.b.toLong(str, -1L);
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
                    this.kIR = com.baidu.adp.lib.f.b.toLong(substring, -1L);
                }
            }
        } else {
            this.kIR = intent.getLongExtra("topic_id", -1L);
        }
        return this.kIR > 0;
    }

    @Override // com.baidu.tieba.newdetail.a.InterfaceC0766a
    public void Eu(int i) {
        boolean EB = this.kIP.EB(i);
        if (this.kIQ.cZI() == null) {
            if (EB) {
                this.kIQ.cZF();
                this.kIQ.cZH();
                return;
            }
            this.kIQ.sZ(true);
            this.kIQ.cZG();
        } else if (!EB) {
            this.kIQ.bKf();
        }
    }

    public void Ev(int i) {
        boolean EC = this.kIP.EC(i);
        if (this.kIQ.EA(i).pageData == null) {
            if (EC) {
                this.kIQ.Ex(i);
                this.kIQ.Ez(i);
                return;
            }
            this.kIQ.F(true, i);
            this.kIQ.Ey(i);
        }
    }

    public void Ew(int i) {
        d EA = this.kIQ.EA(i);
        if (EA.pageData == null) {
            Ev(i);
        } else if (EA.pageData.bgX() != 0) {
            this.kIP.a(i, EA.pageData, EA.lastId);
        }
    }

    public boolean a(i iVar, int i) {
        return this.kIP.a(iVar, i);
    }

    public boolean a(com.baidu.tieba.hottopic.data.a aVar) {
        return this.kIP.a(aVar);
    }

    public String getTopicId() {
        return this.eCP;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        Ew(this.kIQ.cZJ());
    }

    @Override // com.baidu.tieba.newdetail.a.InterfaceC0766a
    public void a(int i, e eVar) {
        if (eVar != null && eVar.sortType == -1) {
            this.kIQ.g(eVar);
            return;
        }
        this.kIQ.cZG();
        this.kIQ.bKf();
        if (i != 0 || eVar == null) {
            if (this.kIQ.cZI() == null) {
                this.kIQ.sZ(false);
                return;
            }
            return;
        }
        if (eVar.cHp() != null) {
            fJ(eVar.cHp().eCP, eVar.cHp().eou);
        }
        this.kIQ.f(eVar);
        this.kIQ.cZK();
        a(i, eVar.jwQ, true);
    }

    private void fJ(String str, String str2) {
        if ((!TextUtils.isEmpty(str) && com.baidu.adp.lib.f.b.toLong(str, 0L) > 0) || !TextUtils.isEmpty(str2)) {
            this.eCP = str;
            this.eou = str2;
            this.kIP.u(com.baidu.adp.lib.f.b.toLong(str, 0L), str2);
        }
    }

    @Override // com.baidu.tieba.newdetail.a.InterfaceC0766a
    public void a(int i, d dVar) {
        a(i, dVar, false);
    }

    @Override // com.baidu.tieba.newdetail.a.InterfaceC0766a
    public void a(int i, long j, long j2, int i2) {
        if (i == 0 && j > 0 && i2 >= 0) {
            if (i2 == 1 || i2 == 2) {
                this.kIQ.e(j, j2, i2);
            } else {
                this.kIQ.C(j, j2);
            }
        }
    }

    @Override // com.baidu.tieba.newdetail.a.InterfaceC0766a
    public void e(e eVar) {
        com.baidu.tieba.hottopic.data.f cHp;
        if (eVar != null && (cHp = eVar.cHp()) != null) {
            String str = "http://tieba.baidu.com/mo/q/newtopic/detail?topic_id=" + this.eCP;
            if (!TextUtils.isEmpty(this.eou)) {
                str = str + "&topic_name=" + URLEncoder.encode(this.eou);
            }
            this.jvI.c(cHp.eCP, cHp.eou, str, cHp.jqS, cHp.shareTitle, true);
        }
    }

    public void cZD() {
        if ("5".equals(this.mFrom)) {
            finish();
        } else {
            new HotRanklistActivityConfig(this).createNormalConfig(VideoMiddlePageActivityConfig.FROM_HOTTOPIC, "all").start();
        }
    }

    private void a(int i, d dVar, boolean z) {
        boolean z2 = false;
        int cZJ = this.kIQ.cZJ();
        if (dVar != null) {
            cZJ = dVar.sortType;
        }
        this.kIQ.Ey(cZJ);
        if (i != 0 || dVar == null || y.isEmpty(dVar.list)) {
            if (this.kIQ.EA(cZJ).pageData == null) {
                this.kIQ.F(i != 0, cZJ);
                return;
            }
            return;
        }
        a.b bVar = this.kIQ;
        if (z || this.kIQ.EA(cZJ).pageData == null) {
            z2 = true;
        }
        bVar.a(dVar, z2, cZJ);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.kIQ.onChangeSkinType();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return "a077";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.kIQ.resume();
        TiebaStatic.log(new aq("c13817").dK("uid", TbadkCoreApplication.getCurrentAccount()).dK("topic_id", this.eCP));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.kIQ.pause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.kIQ.destroy();
        cZE();
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
                    this.kIP.cZL();
                    return;
                default:
                    return;
            }
        }
    }

    private void cZE() {
        if (this.kIS) {
            MainTabActivityConfig createNormalCfg = new MainTabActivityConfig(this).createNormalCfg(2);
            createNormalCfg.setSubTabName(getString(R.string.tab_name_topic_rank));
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, createNormalCfg));
        }
    }
}
