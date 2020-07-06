package com.baidu.tieba.newdetail;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.searchbox.unitedscheme.SchemeCollecter;
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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.R;
import com.baidu.tieba.hottopic.data.d;
import com.baidu.tieba.hottopic.data.e;
import com.baidu.tieba.hottopic.data.i;
import com.baidu.tieba.newdetail.a;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes8.dex */
public class HotTopicDetailActivity extends BaseActivity<HotTopicDetailActivity> implements BdListView.e, a.InterfaceC0688a {
    private long dyU;
    private long fid;
    private String firstDir;
    private com.baidu.tieba.hottopic.controller.b iCT;
    private HotTopicDetailModel jNb;
    private a.b jNc;
    private String secondDir;
    private boolean mIsFromSchema = false;
    private long jNd = -1;
    private boolean jNe = false;
    private String dYw = null;
    private String dKw = null;
    private String mFrom = "";

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        boolean z = true;
        if (ac(getIntent())) {
            this.dYw = "" + this.jNd;
            if (getIntent() != null && getIntent().getParcelableExtra(IntentConfig.KEY_URI) != null && !com.baidu.adp.base.a.jC().bj("MainTabActivity")) {
                this.mIsFromSchema = true;
            }
        } else {
            az(bundle);
        }
        if (this.mIsFromSchema) {
            setIsAddSwipeBackLayout(false);
        }
        super.onCreate(bundle);
        if ((TextUtils.isEmpty(this.dYw) || com.baidu.adp.lib.f.b.toLong(this.dYw, 0L) <= 0) && TextUtils.isEmpty(this.dKw)) {
            finish();
            return;
        }
        this.jNb = new HotTopicDetailModel(getPageContext(), this);
        this.jNc = new HotTopicDetailView(getPageContext(), this, bundle);
        this.jNb.setFrom(this.mFrom);
        eV(this.dYw, this.dKw);
        this.iCT = new com.baidu.tieba.hottopic.controller.b(this);
        setContentView(this.jNc.getRootView());
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        Av(1);
        if (getIntent() == null || !getIntent().getBooleanExtra(TopicDetailActivityConfig.KEY_IS_FROM_YUN_PUSH, false)) {
            z = false;
        }
        this.jNe = z;
    }

    private void az(Bundle bundle) {
        Intent intent = getIntent();
        if (intent != null) {
            this.dYw = intent.getStringExtra("topic_id");
            this.dKw = intent.getStringExtra("topic_name");
            this.fid = intent.getLongExtra("topic_fid", 0L);
            this.firstDir = intent.getStringExtra("topic_first_dir");
            this.secondDir = intent.getStringExtra("topic_second_dir");
            this.mFrom = intent.getStringExtra("from");
            this.dyU = intent.getLongExtra(IntentConfig.TOPIC_TID, 0L);
        } else if (bundle != null) {
            this.dYw = bundle.getString("topic_id");
            this.dKw = bundle.getString("topic_name");
            this.fid = bundle.getLong("topic_fid", 0L);
            this.firstDir = bundle.getString("topic_first_dir");
            this.secondDir = bundle.getString("topic_second_dir");
            this.mFrom = bundle.getString("from");
            this.dyU = bundle.getLong(IntentConfig.TOPIC_TID, 0L);
        }
    }

    private boolean ac(Intent intent) {
        int length;
        String substring;
        if (intent.getParcelableExtra(IntentConfig.KEY_URI) != null) {
            Uri uri = (Uri) intent.getParcelableExtra(IntentConfig.KEY_URI);
            String uri2 = uri.toString();
            if (f.p(uri)) {
                f.aMH().f(uri, new f.a() { // from class: com.baidu.tieba.newdetail.HotTopicDetailActivity.1
                    @Override // com.baidu.tbadk.BdToken.f.a
                    public void C(HashMap<String, Object> hashMap) {
                        if (hashMap != null && (hashMap.get(f.dAi) instanceof String)) {
                            String str = (String) hashMap.get(f.dAi);
                            if (!StringUtils.isNull(str)) {
                                HotTopicDetailActivity.this.jNd = com.baidu.adp.lib.f.b.toLong(str, -1L);
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
                    this.jNd = com.baidu.adp.lib.f.b.toLong(substring, -1L);
                }
            }
        } else {
            this.jNd = intent.getLongExtra("topic_id", -1L);
        }
        return this.jNd > 0;
    }

    @Override // com.baidu.tieba.newdetail.a.InterfaceC0688a
    public void Av(int i) {
        boolean AC = this.jNb.AC(i);
        if (this.jNc.cDW() == null) {
            if (AC) {
                this.jNc.cDT();
                this.jNc.cDV();
                return;
            }
            this.jNc.qX(true);
            this.jNc.cDU();
        } else if (!AC) {
            this.jNc.btV();
        }
    }

    public void Aw(int i) {
        boolean AD = this.jNb.AD(i);
        if (this.jNc.AB(i).pageData == null) {
            if (AD) {
                this.jNc.Ay(i);
                this.jNc.AA(i);
                return;
            }
            this.jNc.C(true, i);
            this.jNc.Az(i);
        }
    }

    public void Ax(int i) {
        d AB = this.jNc.AB(i);
        if (AB.pageData == null) {
            Aw(i);
        } else if (AB.pageData.aRf() != 0) {
            this.jNb.a(i, AB.pageData, AB.lastId);
        }
    }

    public boolean a(i iVar, int i) {
        return this.jNb.a(iVar, i);
    }

    public boolean a(com.baidu.tieba.hottopic.data.a aVar) {
        return this.jNb.a(aVar);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        Ax(this.jNc.cDX());
    }

    @Override // com.baidu.tieba.newdetail.a.InterfaceC0688a
    public void a(int i, e eVar) {
        if (eVar != null && eVar.sortType == -1) {
            this.jNc.g(eVar);
            return;
        }
        this.jNc.cDU();
        this.jNc.btV();
        if (i != 0 || eVar == null) {
            if (this.jNc.cDW() == null) {
                this.jNc.qX(false);
                return;
            }
            return;
        }
        if (eVar.clF() != null) {
            eV(eVar.clF().dYw, eVar.clF().dKw);
        }
        this.jNc.f(eVar);
        this.jNc.cDY();
        a(i, eVar.iEc, true);
    }

    private void eV(String str, String str2) {
        if ((!TextUtils.isEmpty(str) && com.baidu.adp.lib.f.b.toLong(str, 0L) > 0) || !TextUtils.isEmpty(str2)) {
            this.dYw = str;
            this.dKw = str2;
            this.jNb.s(com.baidu.adp.lib.f.b.toLong(str, 0L), str2);
        }
    }

    @Override // com.baidu.tieba.newdetail.a.InterfaceC0688a
    public void a(int i, d dVar) {
        a(i, dVar, false);
    }

    @Override // com.baidu.tieba.newdetail.a.InterfaceC0688a
    public void a(int i, long j, long j2, int i2) {
        if (i == 0 && j > 0 && i2 >= 0) {
            if (i2 == 1 || i2 == 2) {
                this.jNc.c(j, j2, i2);
            } else {
                this.jNc.E(j, j2);
            }
        }
    }

    @Override // com.baidu.tieba.newdetail.a.InterfaceC0688a
    public void e(e eVar) {
        com.baidu.tieba.hottopic.data.f clF;
        if (eVar != null && (clF = eVar.clF()) != null) {
            String str = "http://tieba.baidu.com/mo/q/newtopic/detail?topic_id=" + this.dYw;
            if (!TextUtils.isEmpty(this.dKw)) {
                str = str + "&topic_name=" + URLEncoder.encode(this.dKw);
            }
            this.iCT.b(clF.dYw, clF.dKw, str, clF.iyd, clF.shareTitle, true);
        }
    }

    public void cDR() {
        if ("5".equals(this.mFrom)) {
            finish();
        } else {
            new HotRanklistActivityConfig(this).createNormalConfig(VideoMiddlePageActivityConfig.FROM_HOTTOPIC, SchemeCollecter.CLASSIFY_ALL).start();
        }
    }

    private void a(int i, d dVar, boolean z) {
        boolean z2 = false;
        int cDX = this.jNc.cDX();
        if (dVar != null) {
            cDX = dVar.sortType;
        }
        this.jNc.Az(cDX);
        if (i != 0 || dVar == null || w.isEmpty(dVar.list)) {
            if (this.jNc.AB(cDX).pageData == null) {
                this.jNc.C(i != 0, cDX);
                return;
            }
            return;
        }
        a.b bVar = this.jNc;
        if (z || this.jNc.AB(cDX).pageData == null) {
            z2 = true;
        }
        bVar.a(dVar, z2, cDX);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.jNc.onChangeSkinType();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return "a024";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.jNc.resume();
        TiebaStatic.log(new ao("c13817").dk("uid", TbadkCoreApplication.getCurrentAccount()).dk("topic_id", this.dYw));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.jNc.pause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.jNc.destroy();
        cDS();
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
                    this.jNb.cDZ();
                    return;
                default:
                    return;
            }
        }
    }

    private void cDS() {
        if (this.jNe) {
            MainTabActivityConfig createNormalCfg = new MainTabActivityConfig(this).createNormalCfg(2);
            createNormalCfg.setSubTabName(getString(R.string.tab_name_topic_rank));
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, createNormalCfg));
        }
    }
}
