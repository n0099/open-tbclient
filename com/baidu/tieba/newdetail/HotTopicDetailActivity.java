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
/* loaded from: classes21.dex */
public class HotTopicDetailActivity extends BaseActivity<HotTopicDetailActivity> implements BdListView.e, a.InterfaceC0814a {
    private long evO;
    private long fid;
    private String firstDir;
    private com.baidu.tieba.hottopic.controller.b kcs;
    private HotTopicDetailModel lpb;
    private a.b lpc;
    private String secondDir;
    private boolean mIsFromSchema = false;
    private long lpd = -1;
    private boolean lpe = false;
    private String eXq = null;
    private String eIa = null;
    private String mFrom = "";

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        boolean z = true;
        if (ac(getIntent())) {
            this.eXq = "" + this.lpd;
            if (getIntent() != null && getIntent().getParcelableExtra(IntentConfig.KEY_URI) != null && !com.baidu.adp.base.a.lg().bt("MainTabActivity")) {
                this.mIsFromSchema = true;
            }
        } else {
            aA(bundle);
        }
        if (this.mIsFromSchema) {
            setIsAddSwipeBackLayout(false);
        }
        super.onCreate(bundle);
        if ((TextUtils.isEmpty(this.eXq) || com.baidu.adp.lib.f.b.toLong(this.eXq, 0L) <= 0) && TextUtils.isEmpty(this.eIa)) {
            finish();
            return;
        }
        this.lpb = new HotTopicDetailModel(getPageContext(), this);
        this.lpc = new HotTopicDetailView(getPageContext(), this, bundle);
        this.lpb.setFrom(this.mFrom);
        fT(this.eXq, this.eIa);
        this.kcs = new com.baidu.tieba.hottopic.controller.b(this);
        setContentView(this.lpc.getRootView());
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        Gn(1);
        if (getIntent() == null || !getIntent().getBooleanExtra(TopicDetailActivityConfig.KEY_IS_FROM_YUN_PUSH, false)) {
            z = false;
        }
        this.lpe = z;
    }

    private void aA(Bundle bundle) {
        Intent intent = getIntent();
        if (intent != null) {
            this.eXq = intent.getStringExtra("topic_id");
            this.eIa = intent.getStringExtra("topic_name");
            this.fid = intent.getLongExtra("topic_fid", 0L);
            this.firstDir = intent.getStringExtra("topic_first_dir");
            this.secondDir = intent.getStringExtra("topic_second_dir");
            this.mFrom = intent.getStringExtra("from");
            this.evO = intent.getLongExtra(IntentConfig.TOPIC_TID, 0L);
        } else if (bundle != null) {
            this.eXq = bundle.getString("topic_id");
            this.eIa = bundle.getString("topic_name");
            this.fid = bundle.getLong("topic_fid", 0L);
            this.firstDir = bundle.getString("topic_first_dir");
            this.secondDir = bundle.getString("topic_second_dir");
            this.mFrom = bundle.getString("from");
            this.evO = bundle.getLong(IntentConfig.TOPIC_TID, 0L);
        }
    }

    private boolean ac(Intent intent) {
        int length;
        String substring;
        if (intent.getParcelableExtra(IntentConfig.KEY_URI) != null) {
            Uri uri = (Uri) intent.getParcelableExtra(IntentConfig.KEY_URI);
            String uri2 = uri.toString();
            if (f.p(uri)) {
                f.biX().e(uri, new f.a() { // from class: com.baidu.tieba.newdetail.HotTopicDetailActivity.1
                    @Override // com.baidu.tbadk.BdToken.f.a
                    public void onCallBack(HashMap<String, Object> hashMap) {
                        if (hashMap != null && (hashMap.get(f.exi) instanceof String)) {
                            String str = (String) hashMap.get(f.exi);
                            if (!StringUtils.isNull(str)) {
                                HotTopicDetailActivity.this.lpd = com.baidu.adp.lib.f.b.toLong(str, -1L);
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
                    this.lpd = com.baidu.adp.lib.f.b.toLong(substring, -1L);
                }
            }
        } else {
            this.lpd = intent.getLongExtra("topic_id", -1L);
        }
        return this.lpd > 0;
    }

    @Override // com.baidu.tieba.newdetail.a.InterfaceC0814a
    public void Gn(int i) {
        boolean Gu = this.lpb.Gu(i);
        if (this.lpc.dkb() == null) {
            if (Gu) {
                this.lpc.djY();
                this.lpc.dka();
                return;
            }
            this.lpc.ue(true);
            this.lpc.djZ();
        } else if (!Gu) {
            this.lpc.bSl();
        }
    }

    public void Go(int i) {
        boolean Gv = this.lpb.Gv(i);
        if (this.lpc.Gt(i).pageData == null) {
            if (Gv) {
                this.lpc.Gq(i);
                this.lpc.Gs(i);
                return;
            }
            this.lpc.F(true, i);
            this.lpc.Gr(i);
        }
    }

    public void Gp(int i) {
        d Gt = this.lpc.Gt(i);
        if (Gt.pageData == null) {
            Go(i);
        } else if (Gt.pageData.bnF() != 0) {
            this.lpb.a(i, Gt.pageData, Gt.lastId);
        }
    }

    public boolean a(i iVar, int i) {
        return this.lpb.a(iVar, i);
    }

    public boolean a(com.baidu.tieba.hottopic.data.a aVar) {
        return this.lpb.a(aVar);
    }

    public String getTopicId() {
        return this.eXq;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        Gp(this.lpc.dkc());
    }

    @Override // com.baidu.tieba.newdetail.a.InterfaceC0814a
    public void a(int i, e eVar) {
        if (eVar != null && eVar.sortType == -1) {
            this.lpc.g(eVar);
            return;
        }
        this.lpc.djZ();
        this.lpc.bSl();
        if (i != 0 || eVar == null) {
            if (this.lpc.dkb() == null) {
                this.lpc.ue(false);
                return;
            }
            return;
        }
        if (eVar.cRS() != null) {
            fT(eVar.cRS().eXq, eVar.cRS().eIa);
        }
        this.lpc.f(eVar);
        this.lpc.dkd();
        a(i, eVar.kdA, true);
    }

    private void fT(String str, String str2) {
        if ((!TextUtils.isEmpty(str) && com.baidu.adp.lib.f.b.toLong(str, 0L) > 0) || !TextUtils.isEmpty(str2)) {
            this.eXq = str;
            this.eIa = str2;
            this.lpb.x(com.baidu.adp.lib.f.b.toLong(str, 0L), str2);
        }
    }

    @Override // com.baidu.tieba.newdetail.a.InterfaceC0814a
    public void a(int i, d dVar) {
        a(i, dVar, false);
    }

    @Override // com.baidu.tieba.newdetail.a.InterfaceC0814a
    public void a(int i, long j, long j2, int i2) {
        if (i == 0 && j > 0 && i2 >= 0) {
            if (i2 == 1 || i2 == 2) {
                this.lpc.e(j, j2, i2);
            } else {
                this.lpc.D(j, j2);
            }
        }
    }

    @Override // com.baidu.tieba.newdetail.a.InterfaceC0814a
    public void e(e eVar) {
        com.baidu.tieba.hottopic.data.f cRS;
        if (eVar != null && (cRS = eVar.cRS()) != null) {
            String str = "http://tieba.baidu.com/mo/q/newtopic/detail?topic_id=" + this.eXq;
            if (!TextUtils.isEmpty(this.eIa)) {
                str = str + "&topic_name=" + URLEncoder.encode(this.eIa);
            }
            this.kcs.a(cRS.eXq, cRS.eIa, str, cRS.jXD, cRS.shareTitle, true);
        }
    }

    public void djW() {
        if ("5".equals(this.mFrom)) {
            finish();
        } else {
            new HotRanklistActivityConfig(this).createNormalConfig(VideoMiddlePageActivityConfig.FROM_HOTTOPIC, "all").start();
        }
    }

    private void a(int i, d dVar, boolean z) {
        boolean z2 = false;
        int dkc = this.lpc.dkc();
        if (dVar != null) {
            dkc = dVar.sortType;
        }
        this.lpc.Gr(dkc);
        if (i != 0 || dVar == null || y.isEmpty(dVar.list)) {
            if (this.lpc.Gt(dkc).pageData == null) {
                this.lpc.F(i != 0, dkc);
                return;
            }
            return;
        }
        a.b bVar = this.lpc;
        if (z || this.lpc.Gt(dkc).pageData == null) {
            z2 = true;
        }
        bVar.a(dVar, z2, dkc);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.lpc.onChangeSkinType();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return "a077";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.lpc.resume();
        TiebaStatic.log(new ar("c13817").dY("uid", TbadkCoreApplication.getCurrentAccount()).dY("topic_id", this.eXq));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.lpc.pause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.lpc.destroy();
        djX();
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
                    this.lpb.dke();
                    return;
                default:
                    return;
            }
        }
    }

    private void djX() {
        if (this.lpe) {
            MainTabActivityConfig createNormalCfg = new MainTabActivityConfig(this).createNormalCfg(2);
            createNormalCfg.setSubTabName(getString(R.string.tab_name_topic_rank));
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, createNormalCfg));
        }
    }
}
