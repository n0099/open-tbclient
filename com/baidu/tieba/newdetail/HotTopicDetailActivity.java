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
import com.baidu.tbadk.core.util.ap;
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
/* loaded from: classes15.dex */
public class HotTopicDetailActivity extends BaseActivity<HotTopicDetailActivity> implements BdListView.e, a.InterfaceC0700a {
    private long dEQ;
    private long fid;
    private String firstDir;
    private com.baidu.tieba.hottopic.controller.b iIZ;
    private HotTopicDetailModel jVB;
    private a.b jVC;
    private String secondDir;
    private boolean mIsFromSchema = false;
    private long jVD = -1;
    private boolean jVE = false;
    private String eeI = null;
    private String dQI = null;
    private String mFrom = "";

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        boolean z = true;
        if (ad(getIntent())) {
            this.eeI = "" + this.jVD;
            if (getIntent() != null && getIntent().getParcelableExtra(IntentConfig.KEY_URI) != null && !com.baidu.adp.base.a.jC().bj("MainTabActivity")) {
                this.mIsFromSchema = true;
            }
        } else {
            aA(bundle);
        }
        if (this.mIsFromSchema) {
            setIsAddSwipeBackLayout(false);
        }
        super.onCreate(bundle);
        if ((TextUtils.isEmpty(this.eeI) || com.baidu.adp.lib.f.b.toLong(this.eeI, 0L) <= 0) && TextUtils.isEmpty(this.dQI)) {
            finish();
            return;
        }
        this.jVB = new HotTopicDetailModel(getPageContext(), this);
        this.jVC = new HotTopicDetailView(getPageContext(), this, bundle);
        this.jVB.setFrom(this.mFrom);
        eX(this.eeI, this.dQI);
        this.iIZ = new com.baidu.tieba.hottopic.controller.b(this);
        setContentView(this.jVC.getRootView());
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        AU(1);
        if (getIntent() == null || !getIntent().getBooleanExtra(TopicDetailActivityConfig.KEY_IS_FROM_YUN_PUSH, false)) {
            z = false;
        }
        this.jVE = z;
    }

    private void aA(Bundle bundle) {
        Intent intent = getIntent();
        if (intent != null) {
            this.eeI = intent.getStringExtra("topic_id");
            this.dQI = intent.getStringExtra("topic_name");
            this.fid = intent.getLongExtra("topic_fid", 0L);
            this.firstDir = intent.getStringExtra("topic_first_dir");
            this.secondDir = intent.getStringExtra("topic_second_dir");
            this.mFrom = intent.getStringExtra("from");
            this.dEQ = intent.getLongExtra(IntentConfig.TOPIC_TID, 0L);
        } else if (bundle != null) {
            this.eeI = bundle.getString("topic_id");
            this.dQI = bundle.getString("topic_name");
            this.fid = bundle.getLong("topic_fid", 0L);
            this.firstDir = bundle.getString("topic_first_dir");
            this.secondDir = bundle.getString("topic_second_dir");
            this.mFrom = bundle.getString("from");
            this.dEQ = bundle.getLong(IntentConfig.TOPIC_TID, 0L);
        }
    }

    private boolean ad(Intent intent) {
        int length;
        String substring;
        if (intent.getParcelableExtra(IntentConfig.KEY_URI) != null) {
            Uri uri = (Uri) intent.getParcelableExtra(IntentConfig.KEY_URI);
            String uri2 = uri.toString();
            if (f.p(uri)) {
                f.aQv().f(uri, new f.a() { // from class: com.baidu.tieba.newdetail.HotTopicDetailActivity.1
                    @Override // com.baidu.tbadk.BdToken.f.a
                    public void B(HashMap<String, Object> hashMap) {
                        if (hashMap != null && (hashMap.get(f.dGe) instanceof String)) {
                            String str = (String) hashMap.get(f.dGe);
                            if (!StringUtils.isNull(str)) {
                                HotTopicDetailActivity.this.jVD = com.baidu.adp.lib.f.b.toLong(str, -1L);
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
                    this.jVD = com.baidu.adp.lib.f.b.toLong(substring, -1L);
                }
            }
        } else {
            this.jVD = intent.getLongExtra("topic_id", -1L);
        }
        return this.jVD > 0;
    }

    @Override // com.baidu.tieba.newdetail.a.InterfaceC0700a
    public void AU(int i) {
        boolean Bb = this.jVB.Bb(i);
        if (this.jVC.cHE() == null) {
            if (Bb) {
                this.jVC.cHB();
                this.jVC.cHD();
                return;
            }
            this.jVC.rC(true);
            this.jVC.cHC();
        } else if (!Bb) {
            this.jVC.bxe();
        }
    }

    public void AV(int i) {
        boolean Bc = this.jVB.Bc(i);
        if (this.jVC.Ba(i).pageData == null) {
            if (Bc) {
                this.jVC.AX(i);
                this.jVC.AZ(i);
                return;
            }
            this.jVC.C(true, i);
            this.jVC.AY(i);
        }
    }

    public void AW(int i) {
        d Ba = this.jVC.Ba(i);
        if (Ba.pageData == null) {
            AV(i);
        } else if (Ba.pageData.aVb() != 0) {
            this.jVB.a(i, Ba.pageData, Ba.lastId);
        }
    }

    public boolean a(i iVar, int i) {
        return this.jVB.a(iVar, i);
    }

    public boolean a(com.baidu.tieba.hottopic.data.a aVar) {
        return this.jVB.a(aVar);
    }

    public String getTopicId() {
        return this.eeI;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        AW(this.jVC.cHF());
    }

    @Override // com.baidu.tieba.newdetail.a.InterfaceC0700a
    public void a(int i, e eVar) {
        if (eVar != null && eVar.sortType == -1) {
            this.jVC.g(eVar);
            return;
        }
        this.jVC.cHC();
        this.jVC.bxe();
        if (i != 0 || eVar == null) {
            if (this.jVC.cHE() == null) {
                this.jVC.rC(false);
                return;
            }
            return;
        }
        if (eVar.cpf() != null) {
            eX(eVar.cpf().eeI, eVar.cpf().dQI);
        }
        this.jVC.f(eVar);
        this.jVC.cHG();
        a(i, eVar.iKi, true);
    }

    private void eX(String str, String str2) {
        if ((!TextUtils.isEmpty(str) && com.baidu.adp.lib.f.b.toLong(str, 0L) > 0) || !TextUtils.isEmpty(str2)) {
            this.eeI = str;
            this.dQI = str2;
            this.jVB.u(com.baidu.adp.lib.f.b.toLong(str, 0L), str2);
        }
    }

    @Override // com.baidu.tieba.newdetail.a.InterfaceC0700a
    public void a(int i, d dVar) {
        a(i, dVar, false);
    }

    @Override // com.baidu.tieba.newdetail.a.InterfaceC0700a
    public void a(int i, long j, long j2, int i2) {
        if (i == 0 && j > 0 && i2 >= 0) {
            if (i2 == 1 || i2 == 2) {
                this.jVC.d(j, j2, i2);
            } else {
                this.jVC.F(j, j2);
            }
        }
    }

    @Override // com.baidu.tieba.newdetail.a.InterfaceC0700a
    public void e(e eVar) {
        com.baidu.tieba.hottopic.data.f cpf;
        if (eVar != null && (cpf = eVar.cpf()) != null) {
            String str = "http://tieba.baidu.com/mo/q/newtopic/detail?topic_id=" + this.eeI;
            if (!TextUtils.isEmpty(this.dQI)) {
                str = str + "&topic_name=" + URLEncoder.encode(this.dQI);
            }
            this.iIZ.b(cpf.eeI, cpf.dQI, str, cpf.iEj, cpf.shareTitle, true);
        }
    }

    public void cHz() {
        if ("5".equals(this.mFrom)) {
            finish();
        } else {
            new HotRanklistActivityConfig(this).createNormalConfig(VideoMiddlePageActivityConfig.FROM_HOTTOPIC, SchemeCollecter.CLASSIFY_ALL).start();
        }
    }

    private void a(int i, d dVar, boolean z) {
        boolean z2 = false;
        int cHF = this.jVC.cHF();
        if (dVar != null) {
            cHF = dVar.sortType;
        }
        this.jVC.AY(cHF);
        if (i != 0 || dVar == null || x.isEmpty(dVar.list)) {
            if (this.jVC.Ba(cHF).pageData == null) {
                this.jVC.C(i != 0, cHF);
                return;
            }
            return;
        }
        a.b bVar = this.jVC;
        if (z || this.jVC.Ba(cHF).pageData == null) {
            z2 = true;
        }
        bVar.a(dVar, z2, cHF);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.jVC.onChangeSkinType();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return "a024";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.jVC.resume();
        TiebaStatic.log(new ap("c13817").dn("uid", TbadkCoreApplication.getCurrentAccount()).dn("topic_id", this.eeI));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.jVC.pause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.jVC.destroy();
        cHA();
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
                    this.jVB.cHH();
                    return;
                default:
                    return;
            }
        }
    }

    private void cHA() {
        if (this.jVE) {
            MainTabActivityConfig createNormalCfg = new MainTabActivityConfig(this).createNormalCfg(2);
            createNormalCfg.setSubTabName(getString(R.string.tab_name_topic_rank));
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, createNormalCfg));
        }
    }
}
