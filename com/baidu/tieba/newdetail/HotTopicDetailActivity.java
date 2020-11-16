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
import com.baidu.tbadk.core.util.ar;
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
/* loaded from: classes20.dex */
public class HotTopicDetailActivity extends BaseActivity<HotTopicDetailActivity> implements BdListView.e, a.InterfaceC0798a {
    private long eoP;
    private long fid;
    private String firstDir;
    private com.baidu.tieba.hottopic.controller.b jOP;
    private HotTopicDetailModel lbB;
    private a.b lbC;
    private String secondDir;
    private boolean mIsFromSchema = false;
    private long lbD = -1;
    private boolean lbE = false;
    private String eQb = null;
    private String eBa = null;
    private String mFrom = "";

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        boolean z = true;
        if (ac(getIntent())) {
            this.eQb = "" + this.lbD;
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
        if ((TextUtils.isEmpty(this.eQb) || com.baidu.adp.lib.f.b.toLong(this.eQb, 0L) <= 0) && TextUtils.isEmpty(this.eBa)) {
            finish();
            return;
        }
        this.lbB = new HotTopicDetailModel(getPageContext(), this);
        this.lbC = new HotTopicDetailView(getPageContext(), this, bundle);
        this.lbB.setFrom(this.mFrom);
        fO(this.eQb, this.eBa);
        this.jOP = new com.baidu.tieba.hottopic.controller.b(this);
        setContentView(this.lbC.getRootView());
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        Fy(1);
        if (getIntent() == null || !getIntent().getBooleanExtra(TopicDetailActivityConfig.KEY_IS_FROM_YUN_PUSH, false)) {
            z = false;
        }
        this.lbE = z;
    }

    private void az(Bundle bundle) {
        Intent intent = getIntent();
        if (intent != null) {
            this.eQb = intent.getStringExtra("topic_id");
            this.eBa = intent.getStringExtra("topic_name");
            this.fid = intent.getLongExtra("topic_fid", 0L);
            this.firstDir = intent.getStringExtra("topic_first_dir");
            this.secondDir = intent.getStringExtra("topic_second_dir");
            this.mFrom = intent.getStringExtra("from");
            this.eoP = intent.getLongExtra(IntentConfig.TOPIC_TID, 0L);
        } else if (bundle != null) {
            this.eQb = bundle.getString("topic_id");
            this.eBa = bundle.getString("topic_name");
            this.fid = bundle.getLong("topic_fid", 0L);
            this.firstDir = bundle.getString("topic_first_dir");
            this.secondDir = bundle.getString("topic_second_dir");
            this.mFrom = bundle.getString("from");
            this.eoP = bundle.getLong(IntentConfig.TOPIC_TID, 0L);
        }
    }

    private boolean ac(Intent intent) {
        int length;
        String substring;
        if (intent.getParcelableExtra(IntentConfig.KEY_URI) != null) {
            Uri uri = (Uri) intent.getParcelableExtra(IntentConfig.KEY_URI);
            String uri2 = uri.toString();
            if (f.p(uri)) {
                f.bfS().e(uri, new f.a() { // from class: com.baidu.tieba.newdetail.HotTopicDetailActivity.1
                    @Override // com.baidu.tbadk.BdToken.f.a
                    public void onCallBack(HashMap<String, Object> hashMap) {
                        if (hashMap != null && (hashMap.get(f.eqi) instanceof String)) {
                            String str = (String) hashMap.get(f.eqi);
                            if (!StringUtils.isNull(str)) {
                                HotTopicDetailActivity.this.lbD = com.baidu.adp.lib.f.b.toLong(str, -1L);
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
                    this.lbD = com.baidu.adp.lib.f.b.toLong(substring, -1L);
                }
            }
        } else {
            this.lbD = intent.getLongExtra("topic_id", -1L);
        }
        return this.lbD > 0;
    }

    @Override // com.baidu.tieba.newdetail.a.InterfaceC0798a
    public void Fy(int i) {
        boolean FF = this.lbB.FF(i);
        if (this.lbC.deP() == null) {
            if (FF) {
                this.lbC.deM();
                this.lbC.deO();
                return;
            }
            this.lbC.tC(true);
            this.lbC.deN();
        } else if (!FF) {
            this.lbC.bOA();
        }
    }

    public void Fz(int i) {
        boolean FG = this.lbB.FG(i);
        if (this.lbC.FE(i).pageData == null) {
            if (FG) {
                this.lbC.FB(i);
                this.lbC.FD(i);
                return;
            }
            this.lbC.F(true, i);
            this.lbC.FC(i);
        }
    }

    public void FA(int i) {
        d FE = this.lbC.FE(i);
        if (FE.pageData == null) {
            Fz(i);
        } else if (FE.pageData.bks() != 0) {
            this.lbB.a(i, FE.pageData, FE.lastId);
        }
    }

    public boolean a(i iVar, int i) {
        return this.lbB.a(iVar, i);
    }

    public boolean a(com.baidu.tieba.hottopic.data.a aVar) {
        return this.lbB.a(aVar);
    }

    public String getTopicId() {
        return this.eQb;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        FA(this.lbC.deQ());
    }

    @Override // com.baidu.tieba.newdetail.a.InterfaceC0798a
    public void a(int i, e eVar) {
        if (eVar != null && eVar.sortType == -1) {
            this.lbC.g(eVar);
            return;
        }
        this.lbC.deN();
        this.lbC.bOA();
        if (i != 0 || eVar == null) {
            if (this.lbC.deP() == null) {
                this.lbC.tC(false);
                return;
            }
            return;
        }
        if (eVar.cME() != null) {
            fO(eVar.cME().eQb, eVar.cME().eBa);
        }
        this.lbC.f(eVar);
        this.lbC.deR();
        a(i, eVar.jPX, true);
    }

    private void fO(String str, String str2) {
        if ((!TextUtils.isEmpty(str) && com.baidu.adp.lib.f.b.toLong(str, 0L) > 0) || !TextUtils.isEmpty(str2)) {
            this.eQb = str;
            this.eBa = str2;
            this.lbB.v(com.baidu.adp.lib.f.b.toLong(str, 0L), str2);
        }
    }

    @Override // com.baidu.tieba.newdetail.a.InterfaceC0798a
    public void a(int i, d dVar) {
        a(i, dVar, false);
    }

    @Override // com.baidu.tieba.newdetail.a.InterfaceC0798a
    public void a(int i, long j, long j2, int i2) {
        if (i == 0 && j > 0 && i2 >= 0) {
            if (i2 == 1 || i2 == 2) {
                this.lbC.e(j, j2, i2);
            } else {
                this.lbC.E(j, j2);
            }
        }
    }

    @Override // com.baidu.tieba.newdetail.a.InterfaceC0798a
    public void e(e eVar) {
        com.baidu.tieba.hottopic.data.f cME;
        if (eVar != null && (cME = eVar.cME()) != null) {
            String str = "http://tieba.baidu.com/mo/q/newtopic/detail?topic_id=" + this.eQb;
            if (!TextUtils.isEmpty(this.eBa)) {
                str = str + "&topic_name=" + URLEncoder.encode(this.eBa);
            }
            this.jOP.b(cME.eQb, cME.eBa, str, cME.jKa, cME.shareTitle, true);
        }
    }

    public void deK() {
        if ("5".equals(this.mFrom)) {
            finish();
        } else {
            new HotRanklistActivityConfig(this).createNormalConfig(VideoMiddlePageActivityConfig.FROM_HOTTOPIC, "all").start();
        }
    }

    private void a(int i, d dVar, boolean z) {
        boolean z2 = false;
        int deQ = this.lbC.deQ();
        if (dVar != null) {
            deQ = dVar.sortType;
        }
        this.lbC.FC(deQ);
        if (i != 0 || dVar == null || y.isEmpty(dVar.list)) {
            if (this.lbC.FE(deQ).pageData == null) {
                this.lbC.F(i != 0, deQ);
                return;
            }
            return;
        }
        a.b bVar = this.lbC;
        if (z || this.lbC.FE(deQ).pageData == null) {
            z2 = true;
        }
        bVar.a(dVar, z2, deQ);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.lbC.onChangeSkinType();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return "a077";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.lbC.resume();
        TiebaStatic.log(new ar("c13817").dR("uid", TbadkCoreApplication.getCurrentAccount()).dR("topic_id", this.eQb));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.lbC.pause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.lbC.destroy();
        deL();
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
                    this.lbB.deS();
                    return;
                default:
                    return;
            }
        }
    }

    private void deL() {
        if (this.lbE) {
            MainTabActivityConfig createNormalCfg = new MainTabActivityConfig(this).createNormalCfg(2);
            createNormalCfg.setSubTabName(getString(R.string.tab_name_topic_rank));
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, createNormalCfg));
        }
    }
}
