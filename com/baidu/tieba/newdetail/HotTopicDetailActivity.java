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
/* loaded from: classes20.dex */
public class HotTopicDetailActivity extends BaseActivity<HotTopicDetailActivity> implements BdListView.e, a.InterfaceC0748a {
    private long dQf;
    private long fid;
    private String firstDir;
    private com.baidu.tieba.hottopic.controller.b jgJ;
    private HotTopicDetailModel ktD;
    private a.b ktE;
    private String secondDir;
    private boolean mIsFromSchema = false;
    private long ktF = -1;
    private boolean ktG = false;
    private String eqD = null;
    private String ecp = null;
    private String mFrom = "";

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        boolean z = true;
        if (ae(getIntent())) {
            this.eqD = "" + this.ktF;
            if (getIntent() != null && getIntent().getParcelableExtra(IntentConfig.KEY_URI) != null && !com.baidu.adp.base.a.lf().bq("MainTabActivity")) {
                this.mIsFromSchema = true;
            }
        } else {
            az(bundle);
        }
        if (this.mIsFromSchema) {
            setIsAddSwipeBackLayout(false);
        }
        super.onCreate(bundle);
        if ((TextUtils.isEmpty(this.eqD) || com.baidu.adp.lib.f.b.toLong(this.eqD, 0L) <= 0) && TextUtils.isEmpty(this.ecp)) {
            finish();
            return;
        }
        this.ktD = new HotTopicDetailModel(getPageContext(), this);
        this.ktE = new HotTopicDetailView(getPageContext(), this, bundle);
        this.ktD.setFrom(this.mFrom);
        fC(this.eqD, this.ecp);
        this.jgJ = new com.baidu.tieba.hottopic.controller.b(this);
        setContentView(this.ktE.getRootView());
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        DO(1);
        if (getIntent() == null || !getIntent().getBooleanExtra(TopicDetailActivityConfig.KEY_IS_FROM_YUN_PUSH, false)) {
            z = false;
        }
        this.ktG = z;
    }

    private void az(Bundle bundle) {
        Intent intent = getIntent();
        if (intent != null) {
            this.eqD = intent.getStringExtra("topic_id");
            this.ecp = intent.getStringExtra("topic_name");
            this.fid = intent.getLongExtra("topic_fid", 0L);
            this.firstDir = intent.getStringExtra("topic_first_dir");
            this.secondDir = intent.getStringExtra("topic_second_dir");
            this.mFrom = intent.getStringExtra("from");
            this.dQf = intent.getLongExtra(IntentConfig.TOPIC_TID, 0L);
        } else if (bundle != null) {
            this.eqD = bundle.getString("topic_id");
            this.ecp = bundle.getString("topic_name");
            this.fid = bundle.getLong("topic_fid", 0L);
            this.firstDir = bundle.getString("topic_first_dir");
            this.secondDir = bundle.getString("topic_second_dir");
            this.mFrom = bundle.getString("from");
            this.dQf = bundle.getLong(IntentConfig.TOPIC_TID, 0L);
        }
    }

    private boolean ae(Intent intent) {
        int length;
        String substring;
        if (intent.getParcelableExtra(IntentConfig.KEY_URI) != null) {
            Uri uri = (Uri) intent.getParcelableExtra(IntentConfig.KEY_URI);
            String uri2 = uri.toString();
            if (f.p(uri)) {
                f.aZy().e(uri, new f.a() { // from class: com.baidu.tieba.newdetail.HotTopicDetailActivity.1
                    @Override // com.baidu.tbadk.BdToken.f.a
                    public void z(HashMap<String, Object> hashMap) {
                        if (hashMap != null && (hashMap.get(f.dRw) instanceof String)) {
                            String str = (String) hashMap.get(f.dRw);
                            if (!StringUtils.isNull(str)) {
                                HotTopicDetailActivity.this.ktF = com.baidu.adp.lib.f.b.toLong(str, -1L);
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
                    this.ktF = com.baidu.adp.lib.f.b.toLong(substring, -1L);
                }
            }
        } else {
            this.ktF = intent.getLongExtra("topic_id", -1L);
        }
        return this.ktF > 0;
    }

    @Override // com.baidu.tieba.newdetail.a.InterfaceC0748a
    public void DO(int i) {
        boolean DV = this.ktD.DV(i);
        if (this.ktE.cVZ() == null) {
            if (DV) {
                this.ktE.cVW();
                this.ktE.cVY();
                return;
            }
            this.ktE.ss(true);
            this.ktE.cVX();
        } else if (!DV) {
            this.ktE.bHu();
        }
    }

    public void DP(int i) {
        boolean DW = this.ktD.DW(i);
        if (this.ktE.DU(i).pageData == null) {
            if (DW) {
                this.ktE.DR(i);
                this.ktE.DT(i);
                return;
            }
            this.ktE.C(true, i);
            this.ktE.DS(i);
        }
    }

    public void DQ(int i) {
        d DU = this.ktE.DU(i);
        if (DU.pageData == null) {
            DP(i);
        } else if (DU.pageData.beo() != 0) {
            this.ktD.a(i, DU.pageData, DU.lastId);
        }
    }

    public boolean a(i iVar, int i) {
        return this.ktD.a(iVar, i);
    }

    public boolean a(com.baidu.tieba.hottopic.data.a aVar) {
        return this.ktD.a(aVar);
    }

    public String getTopicId() {
        return this.eqD;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        DQ(this.ktE.cWa());
    }

    @Override // com.baidu.tieba.newdetail.a.InterfaceC0748a
    public void a(int i, e eVar) {
        if (eVar != null && eVar.sortType == -1) {
            this.ktE.g(eVar);
            return;
        }
        this.ktE.cVX();
        this.ktE.bHu();
        if (i != 0 || eVar == null) {
            if (this.ktE.cVZ() == null) {
                this.ktE.ss(false);
                return;
            }
            return;
        }
        if (eVar.cDG() != null) {
            fC(eVar.cDG().eqD, eVar.cDG().ecp);
        }
        this.ktE.f(eVar);
        this.ktE.cWb();
        a(i, eVar.jhR, true);
    }

    private void fC(String str, String str2) {
        if ((!TextUtils.isEmpty(str) && com.baidu.adp.lib.f.b.toLong(str, 0L) > 0) || !TextUtils.isEmpty(str2)) {
            this.eqD = str;
            this.ecp = str2;
            this.ktD.t(com.baidu.adp.lib.f.b.toLong(str, 0L), str2);
        }
    }

    @Override // com.baidu.tieba.newdetail.a.InterfaceC0748a
    public void a(int i, d dVar) {
        a(i, dVar, false);
    }

    @Override // com.baidu.tieba.newdetail.a.InterfaceC0748a
    public void a(int i, long j, long j2, int i2) {
        if (i == 0 && j > 0 && i2 >= 0) {
            if (i2 == 1 || i2 == 2) {
                this.ktE.d(j, j2, i2);
            } else {
                this.ktE.C(j, j2);
            }
        }
    }

    @Override // com.baidu.tieba.newdetail.a.InterfaceC0748a
    public void e(e eVar) {
        com.baidu.tieba.hottopic.data.f cDG;
        if (eVar != null && (cDG = eVar.cDG()) != null) {
            String str = "http://tieba.baidu.com/mo/q/newtopic/detail?topic_id=" + this.eqD;
            if (!TextUtils.isEmpty(this.ecp)) {
                str = str + "&topic_name=" + URLEncoder.encode(this.ecp);
            }
            this.jgJ.b(cDG.eqD, cDG.ecp, str, cDG.jbT, cDG.shareTitle, true);
        }
    }

    public void cVU() {
        if ("5".equals(this.mFrom)) {
            finish();
        } else {
            new HotRanklistActivityConfig(this).createNormalConfig(VideoMiddlePageActivityConfig.FROM_HOTTOPIC, "all").start();
        }
    }

    private void a(int i, d dVar, boolean z) {
        boolean z2 = false;
        int cWa = this.ktE.cWa();
        if (dVar != null) {
            cWa = dVar.sortType;
        }
        this.ktE.DS(cWa);
        if (i != 0 || dVar == null || y.isEmpty(dVar.list)) {
            if (this.ktE.DU(cWa).pageData == null) {
                this.ktE.C(i != 0, cWa);
                return;
            }
            return;
        }
        a.b bVar = this.ktE;
        if (z || this.ktE.DU(cWa).pageData == null) {
            z2 = true;
        }
        bVar.a(dVar, z2, cWa);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.ktE.onChangeSkinType();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return "a077";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.ktE.resume();
        TiebaStatic.log(new aq("c13817").dF("uid", TbadkCoreApplication.getCurrentAccount()).dF("topic_id", this.eqD));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.ktE.pause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.ktE.destroy();
        cVV();
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
                    this.ktD.cWc();
                    return;
                default:
                    return;
            }
        }
    }

    private void cVV() {
        if (this.ktG) {
            MainTabActivityConfig createNormalCfg = new MainTabActivityConfig(this).createNormalCfg(2);
            createNormalCfg.setSubTabName(getString(R.string.tab_name_topic_rank));
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, createNormalCfg));
        }
    }
}
