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
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.R;
import com.baidu.tieba.hottopic.data.d;
import com.baidu.tieba.hottopic.data.e;
import com.baidu.tieba.hottopic.data.i;
import com.baidu.tieba.newdetail.a;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes7.dex */
public class HotTopicDetailActivity extends BaseActivity<HotTopicDetailActivity> implements BdListView.e, a.InterfaceC0800a {
    private long eAs;
    private long fid;
    private String firstDir;
    private com.baidu.tieba.hottopic.controller.b klb;
    private HotTopicDetailModel lpF;
    private a.b lpG;
    private String secondDir;
    private boolean mIsFromSchema = false;
    private long lpH = -1;
    private boolean lpI = false;
    private String fci = null;
    private String eNh = null;
    private String mFrom = "";

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        boolean z = true;
        if (ab(getIntent())) {
            this.fci = "" + this.lpH;
            if (getIntent() != null && getIntent().getParcelableExtra(IntentConfig.KEY_URI) != null && !com.baidu.adp.base.b.kC().bo("MainTabActivity")) {
                this.mIsFromSchema = true;
            }
        } else {
            aA(bundle);
        }
        if (this.mIsFromSchema) {
            setIsAddSwipeBackLayout(false);
        }
        super.onCreate(bundle);
        if ((TextUtils.isEmpty(this.fci) || com.baidu.adp.lib.f.b.toLong(this.fci, 0L) <= 0) && TextUtils.isEmpty(this.eNh)) {
            finish();
            return;
        }
        this.lpF = new HotTopicDetailModel(getPageContext(), this);
        this.lpG = new HotTopicDetailView(getPageContext(), this, bundle);
        this.lpF.setFrom(this.mFrom);
        fP(this.fci, this.eNh);
        this.klb = new com.baidu.tieba.hottopic.controller.b(this);
        setContentView(this.lpG.getRootView());
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        Ez(1);
        if (getIntent() == null || !getIntent().getBooleanExtra(TopicDetailActivityConfig.KEY_IS_FROM_YUN_PUSH, false)) {
            z = false;
        }
        this.lpI = z;
    }

    private void aA(Bundle bundle) {
        Intent intent = getIntent();
        if (intent != null) {
            this.fci = intent.getStringExtra("topic_id");
            this.eNh = intent.getStringExtra("topic_name");
            this.fid = intent.getLongExtra("topic_fid", 0L);
            this.firstDir = intent.getStringExtra("topic_first_dir");
            this.secondDir = intent.getStringExtra("topic_second_dir");
            this.mFrom = intent.getStringExtra("from");
            this.eAs = intent.getLongExtra(IntentConfig.TOPIC_TID, 0L);
        } else if (bundle != null) {
            this.fci = bundle.getString("topic_id");
            this.eNh = bundle.getString("topic_name");
            this.fid = bundle.getLong("topic_fid", 0L);
            this.firstDir = bundle.getString("topic_first_dir");
            this.secondDir = bundle.getString("topic_second_dir");
            this.mFrom = bundle.getString("from");
            this.eAs = bundle.getLong(IntentConfig.TOPIC_TID, 0L);
        }
    }

    private boolean ab(Intent intent) {
        int length;
        String substring;
        if (intent.getParcelableExtra(IntentConfig.KEY_URI) != null) {
            Uri uri = (Uri) intent.getParcelableExtra(IntentConfig.KEY_URI);
            String uri2 = uri.toString();
            if (f.r(uri)) {
                f.bhu().e(uri, new f.a() { // from class: com.baidu.tieba.newdetail.HotTopicDetailActivity.1
                    @Override // com.baidu.tbadk.BdToken.f.a
                    public void onCallBack(HashMap<String, Object> hashMap) {
                        if (hashMap != null && (hashMap.get(f.eBM) instanceof String)) {
                            String str = (String) hashMap.get(f.eBM);
                            if (!StringUtils.isNull(str)) {
                                HotTopicDetailActivity.this.lpH = com.baidu.adp.lib.f.b.toLong(str, -1L);
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
                    this.lpH = com.baidu.adp.lib.f.b.toLong(substring, -1L);
                }
            }
        } else {
            this.lpH = intent.getLongExtra("topic_id", -1L);
        }
        return this.lpH > 0;
    }

    @Override // com.baidu.tieba.newdetail.a.InterfaceC0800a
    public void Ez(int i) {
        boolean EG = this.lpF.EG(i);
        if (this.lpG.dfV() == null) {
            if (EG) {
                this.lpG.dfS();
                this.lpG.dfU();
                return;
            }
            this.lpG.ub(true);
            this.lpG.dfT();
        } else if (!EG) {
            this.lpG.bQX();
        }
    }

    public void EA(int i) {
        boolean EH = this.lpF.EH(i);
        if (this.lpG.EF(i).pageData == null) {
            if (EH) {
                this.lpG.EC(i);
                this.lpG.EE(i);
                return;
            }
            this.lpG.E(true, i);
            this.lpG.ED(i);
        }
    }

    public void EB(int i) {
        d EF = this.lpG.EF(i);
        if (EF.pageData == null) {
            EA(i);
        } else if (EF.pageData.bmm() != 0) {
            this.lpF.a(i, EF.pageData, EF.lastId);
        }
    }

    public boolean a(i iVar, int i) {
        return this.lpF.a(iVar, i);
    }

    public boolean a(com.baidu.tieba.hottopic.data.a aVar) {
        return this.lpF.a(aVar);
    }

    public String getTopicId() {
        return this.fci;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        EB(this.lpG.dfW());
    }

    @Override // com.baidu.tieba.newdetail.a.InterfaceC0800a
    public void a(int i, e eVar) {
        if (eVar != null && eVar.sortType == -1) {
            this.lpG.f(eVar);
            return;
        }
        this.lpG.dfT();
        this.lpG.bQX();
        if (i != 0 || eVar == null) {
            if (this.lpG.dfV() == null) {
                this.lpG.ub(false);
                return;
            }
            return;
        }
        if (eVar.cRi() != null) {
            fP(eVar.cRi().fci, eVar.cRi().eNh);
        }
        this.lpG.e(eVar);
        this.lpG.dfX();
        a(i, eVar.kmj, true);
    }

    private void fP(String str, String str2) {
        if ((!TextUtils.isEmpty(str) && com.baidu.adp.lib.f.b.toLong(str, 0L) > 0) || !TextUtils.isEmpty(str2)) {
            this.fci = str;
            this.eNh = str2;
            this.lpF.w(com.baidu.adp.lib.f.b.toLong(str, 0L), str2);
        }
    }

    @Override // com.baidu.tieba.newdetail.a.InterfaceC0800a
    public void a(int i, d dVar) {
        a(i, dVar, false);
    }

    @Override // com.baidu.tieba.newdetail.a.InterfaceC0800a
    public void a(int i, long j, long j2, int i2) {
        if (i == 0 && j > 0 && i2 >= 0) {
            if (i2 == 1 || i2 == 2) {
                this.lpG.f(j, j2, i2);
            } else {
                this.lpG.G(j, j2);
            }
        }
    }

    @Override // com.baidu.tieba.newdetail.a.InterfaceC0800a
    public void d(e eVar) {
        com.baidu.tieba.hottopic.data.f cRi;
        if (eVar != null && (cRi = eVar.cRi()) != null) {
            String str = "http://tieba.baidu.com/mo/q/newtopic/detail?topic_id=" + this.fci;
            if (!TextUtils.isEmpty(this.eNh)) {
                str = str + "&topic_name=" + URLEncoder.encode(this.eNh);
            }
            this.klb.a(cRi.fci, cRi.eNh, str, cRi.kgl, cRi.shareTitle, true);
        }
    }

    public void dfQ() {
        if ("5".equals(this.mFrom)) {
            finish();
        } else {
            new HotRanklistActivityConfig(this).createNormalConfig(VideoMiddlePageActivityConfig.FROM_HOTTOPIC, "all").start();
        }
    }

    private void a(int i, d dVar, boolean z) {
        boolean z2 = false;
        int dfW = this.lpG.dfW();
        if (dVar != null) {
            dfW = dVar.sortType;
        }
        this.lpG.ED(dfW);
        if (i != 0 || dVar == null || x.isEmpty(dVar.list)) {
            if (this.lpG.EF(dfW).pageData == null) {
                this.lpG.E(i != 0, dfW);
                return;
            }
            return;
        }
        a.b bVar = this.lpG;
        if (z || this.lpG.EF(dfW).pageData == null) {
            z2 = true;
        }
        bVar.a(dVar, z2, dfW);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.lpG.onChangeSkinType();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return "a077";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.lpG.resume();
        TiebaStatic.log(new aq("c13817").dW("uid", TbadkCoreApplication.getCurrentAccount()).dW("topic_id", this.fci));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.lpG.pause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.lpG.destroy();
        dfR();
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
                    this.lpF.dfY();
                    return;
                default:
                    return;
            }
        }
    }

    private void dfR() {
        if (this.lpI) {
            MainTabActivityConfig createNormalCfg = new MainTabActivityConfig(this).createNormalCfg(2);
            createNormalCfg.setSubTabName(getString(R.string.tab_name_topic_rank));
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, createNormalCfg));
        }
    }
}
