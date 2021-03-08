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
/* loaded from: classes7.dex */
public class HotTopicDetailActivity extends BaseActivity<HotTopicDetailActivity> implements BdListView.e, a.InterfaceC0808a {
    private long eDZ;
    private long fid;
    private String firstDir;
    private com.baidu.tieba.hottopic.controller.b kvy;
    private HotTopicDetailModel lAa;
    private a.b lAb;
    private String secondDir;
    private boolean mIsFromSchema = false;
    private long lAc = -1;
    private boolean lAd = false;
    private String ffX = null;
    private String eQU = null;
    private String mFrom = "";

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        boolean z = true;
        if (ab(getIntent())) {
            this.ffX = "" + this.lAc;
            if (getIntent() != null && getIntent().getParcelableExtra(IntentConfig.KEY_URI) != null && !com.baidu.adp.base.b.kB().bs("MainTabActivity")) {
                this.mIsFromSchema = true;
            }
        } else {
            aA(bundle);
        }
        if (this.mIsFromSchema) {
            setIsAddSwipeBackLayout(false);
        }
        super.onCreate(bundle);
        if ((TextUtils.isEmpty(this.ffX) || com.baidu.adp.lib.f.b.toLong(this.ffX, 0L) <= 0) && TextUtils.isEmpty(this.eQU)) {
            finish();
            return;
        }
        this.lAa = new HotTopicDetailModel(getPageContext(), this);
        this.lAb = new HotTopicDetailView(getPageContext(), this, bundle);
        this.lAa.setFrom(this.mFrom);
        fP(this.ffX, this.eQU);
        this.kvy = new com.baidu.tieba.hottopic.controller.b(this);
        setContentView(this.lAb.getRootView());
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        EU(1);
        if (getIntent() == null || !getIntent().getBooleanExtra(TopicDetailActivityConfig.KEY_IS_FROM_YUN_PUSH, false)) {
            z = false;
        }
        this.lAd = z;
    }

    private void aA(Bundle bundle) {
        Intent intent = getIntent();
        if (intent != null) {
            this.ffX = intent.getStringExtra("topic_id");
            this.eQU = intent.getStringExtra("topic_name");
            this.fid = intent.getLongExtra("topic_fid", 0L);
            this.firstDir = intent.getStringExtra("topic_first_dir");
            this.secondDir = intent.getStringExtra("topic_second_dir");
            this.mFrom = intent.getStringExtra("from");
            this.eDZ = intent.getLongExtra(IntentConfig.TOPIC_TID, 0L);
        } else if (bundle != null) {
            this.ffX = bundle.getString("topic_id");
            this.eQU = bundle.getString("topic_name");
            this.fid = bundle.getLong("topic_fid", 0L);
            this.firstDir = bundle.getString("topic_first_dir");
            this.secondDir = bundle.getString("topic_second_dir");
            this.mFrom = bundle.getString("from");
            this.eDZ = bundle.getLong(IntentConfig.TOPIC_TID, 0L);
        }
    }

    private boolean ab(Intent intent) {
        int length;
        String substring;
        if (intent.getParcelableExtra(IntentConfig.KEY_URI) != null) {
            Uri uri = (Uri) intent.getParcelableExtra(IntentConfig.KEY_URI);
            String uri2 = uri.toString();
            if (f.r(uri)) {
                f.bhJ().e(uri, new f.a() { // from class: com.baidu.tieba.newdetail.HotTopicDetailActivity.1
                    @Override // com.baidu.tbadk.BdToken.f.a
                    public void onCallBack(HashMap<String, Object> hashMap) {
                        if (hashMap != null && (hashMap.get(f.eFt) instanceof String)) {
                            String str = (String) hashMap.get(f.eFt);
                            if (!StringUtils.isNull(str)) {
                                HotTopicDetailActivity.this.lAc = com.baidu.adp.lib.f.b.toLong(str, -1L);
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
                    this.lAc = com.baidu.adp.lib.f.b.toLong(substring, -1L);
                }
            }
        } else {
            this.lAc = intent.getLongExtra("topic_id", -1L);
        }
        return this.lAc > 0;
    }

    @Override // com.baidu.tieba.newdetail.a.InterfaceC0808a
    public void EU(int i) {
        boolean Fb = this.lAa.Fb(i);
        if (this.lAb.dim() == null) {
            if (Fb) {
                this.lAb.dij();
                this.lAb.dil();
                return;
            }
            this.lAb.uo(true);
            this.lAb.dik();
        } else if (!Fb) {
            this.lAb.bRO();
        }
    }

    public void EV(int i) {
        boolean Fc = this.lAa.Fc(i);
        if (this.lAb.Fa(i).pageData == null) {
            if (Fc) {
                this.lAb.EX(i);
                this.lAb.EZ(i);
                return;
            }
            this.lAb.E(true, i);
            this.lAb.EY(i);
        }
    }

    public void EW(int i) {
        d Fa = this.lAb.Fa(i);
        if (Fa.pageData == null) {
            EV(i);
        } else if (Fa.pageData.bmH() != 0) {
            this.lAa.a(i, Fa.pageData, Fa.lastId);
        }
    }

    public boolean a(i iVar, int i) {
        return this.lAa.a(iVar, i);
    }

    public boolean a(com.baidu.tieba.hottopic.data.a aVar) {
        return this.lAa.a(aVar);
    }

    public String getTopicId() {
        return this.ffX;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        EW(this.lAb.din());
    }

    @Override // com.baidu.tieba.newdetail.a.InterfaceC0808a
    public void a(int i, e eVar) {
        if (eVar != null && eVar.sortType == -1) {
            this.lAb.f(eVar);
            return;
        }
        this.lAb.dik();
        this.lAb.bRO();
        if (i != 0 || eVar == null) {
            if (this.lAb.dim() == null) {
                this.lAb.uo(false);
                return;
            }
            return;
        }
        if (eVar.cTv() != null) {
            fP(eVar.cTv().ffX, eVar.cTv().eQU);
        }
        this.lAb.e(eVar);
        this.lAb.dio();
        a(i, eVar.kwG, true);
    }

    private void fP(String str, String str2) {
        if ((!TextUtils.isEmpty(str) && com.baidu.adp.lib.f.b.toLong(str, 0L) > 0) || !TextUtils.isEmpty(str2)) {
            this.ffX = str;
            this.eQU = str2;
            this.lAa.x(com.baidu.adp.lib.f.b.toLong(str, 0L), str2);
        }
    }

    @Override // com.baidu.tieba.newdetail.a.InterfaceC0808a
    public void a(int i, d dVar) {
        a(i, dVar, false);
    }

    @Override // com.baidu.tieba.newdetail.a.InterfaceC0808a
    public void a(int i, long j, long j2, int i2) {
        if (i == 0 && j > 0 && i2 >= 0) {
            if (i2 == 1 || i2 == 2) {
                this.lAb.d(j, j2, i2);
            } else {
                this.lAb.K(j, j2);
            }
        }
    }

    @Override // com.baidu.tieba.newdetail.a.InterfaceC0808a
    public void d(e eVar) {
        com.baidu.tieba.hottopic.data.f cTv;
        if (eVar != null && (cTv = eVar.cTv()) != null) {
            String str = "http://tieba.baidu.com/mo/q/newtopic/detail?topic_id=" + this.ffX;
            if (!TextUtils.isEmpty(this.eQU)) {
                str = str + "&topic_name=" + URLEncoder.encode(this.eQU);
            }
            this.kvy.a(cTv.ffX, cTv.eQU, str, cTv.kqJ, cTv.shareTitle, true);
        }
    }

    public void dih() {
        if ("5".equals(this.mFrom)) {
            finish();
        } else {
            new HotRanklistActivityConfig(this).createNormalConfig("hottopic", "all").start();
        }
    }

    private void a(int i, d dVar, boolean z) {
        boolean z2 = false;
        int din = this.lAb.din();
        if (dVar != null) {
            din = dVar.sortType;
        }
        this.lAb.EY(din);
        if (i != 0 || dVar == null || y.isEmpty(dVar.list)) {
            if (this.lAb.Fa(din).pageData == null) {
                this.lAb.E(i != 0, din);
                return;
            }
            return;
        }
        a.b bVar = this.lAb;
        if (z || this.lAb.Fa(din).pageData == null) {
            z2 = true;
        }
        bVar.a(dVar, z2, din);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.lAb.onChangeSkinType();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return "a077";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.lAb.resume();
        TiebaStatic.log(new ar("c13817").dR("uid", TbadkCoreApplication.getCurrentAccount()).dR("topic_id", this.ffX));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.lAb.pause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.lAb.destroy();
        dii();
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
                    this.lAa.dip();
                    return;
                default:
                    return;
            }
        }
    }

    private void dii() {
        if (this.lAd) {
            MainTabActivityConfig createNormalCfg = new MainTabActivityConfig(this).createNormalCfg(2);
            createNormalCfg.setSubTabName(getString(R.string.tab_name_topic_rank));
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, createNormalCfg));
        }
    }
}
