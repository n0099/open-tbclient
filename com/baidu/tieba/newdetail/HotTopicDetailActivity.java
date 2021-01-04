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
/* loaded from: classes8.dex */
public class HotTopicDetailActivity extends BaseActivity<HotTopicDetailActivity> implements BdListView.e, a.InterfaceC0798a {
    private long eFe;
    private long fid;
    private String firstDir;
    private com.baidu.tieba.hottopic.controller.b kpG;
    private HotTopicDetailModel lul;
    private a.b lum;
    private String secondDir;
    private boolean mIsFromSchema = false;
    private long lun = -1;
    private boolean luo = false;
    private String fgR = null;
    private String eRS = null;
    private String mFrom = "";

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        boolean z = true;
        if (ab(getIntent())) {
            this.fgR = "" + this.lun;
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
        if ((TextUtils.isEmpty(this.fgR) || com.baidu.adp.lib.f.b.toLong(this.fgR, 0L) <= 0) && TextUtils.isEmpty(this.eRS)) {
            finish();
            return;
        }
        this.lul = new HotTopicDetailModel(getPageContext(), this);
        this.lum = new HotTopicDetailView(getPageContext(), this, bundle);
        this.lul.setFrom(this.mFrom);
        fQ(this.fgR, this.eRS);
        this.kpG = new com.baidu.tieba.hottopic.controller.b(this);
        setContentView(this.lum.getRootView());
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        Gf(1);
        if (getIntent() == null || !getIntent().getBooleanExtra(TopicDetailActivityConfig.KEY_IS_FROM_YUN_PUSH, false)) {
            z = false;
        }
        this.luo = z;
    }

    private void aA(Bundle bundle) {
        Intent intent = getIntent();
        if (intent != null) {
            this.fgR = intent.getStringExtra("topic_id");
            this.eRS = intent.getStringExtra("topic_name");
            this.fid = intent.getLongExtra("topic_fid", 0L);
            this.firstDir = intent.getStringExtra("topic_first_dir");
            this.secondDir = intent.getStringExtra("topic_second_dir");
            this.mFrom = intent.getStringExtra("from");
            this.eFe = intent.getLongExtra(IntentConfig.TOPIC_TID, 0L);
        } else if (bundle != null) {
            this.fgR = bundle.getString("topic_id");
            this.eRS = bundle.getString("topic_name");
            this.fid = bundle.getLong("topic_fid", 0L);
            this.firstDir = bundle.getString("topic_first_dir");
            this.secondDir = bundle.getString("topic_second_dir");
            this.mFrom = bundle.getString("from");
            this.eFe = bundle.getLong(IntentConfig.TOPIC_TID, 0L);
        }
    }

    private boolean ab(Intent intent) {
        int length;
        String substring;
        if (intent.getParcelableExtra(IntentConfig.KEY_URI) != null) {
            Uri uri = (Uri) intent.getParcelableExtra(IntentConfig.KEY_URI);
            String uri2 = uri.toString();
            if (f.r(uri)) {
                f.bln().e(uri, new f.a() { // from class: com.baidu.tieba.newdetail.HotTopicDetailActivity.1
                    @Override // com.baidu.tbadk.BdToken.f.a
                    public void onCallBack(HashMap<String, Object> hashMap) {
                        if (hashMap != null && (hashMap.get(f.eGy) instanceof String)) {
                            String str = (String) hashMap.get(f.eGy);
                            if (!StringUtils.isNull(str)) {
                                HotTopicDetailActivity.this.lun = com.baidu.adp.lib.f.b.toLong(str, -1L);
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
                    this.lun = com.baidu.adp.lib.f.b.toLong(substring, -1L);
                }
            }
        } else {
            this.lun = intent.getLongExtra("topic_id", -1L);
        }
        return this.lun > 0;
    }

    @Override // com.baidu.tieba.newdetail.a.InterfaceC0798a
    public void Gf(int i) {
        boolean Gm = this.lul.Gm(i);
        if (this.lum.djM() == null) {
            if (Gm) {
                this.lum.djJ();
                this.lum.djL();
                return;
            }
            this.lum.uf(true);
            this.lum.djK();
        } else if (!Gm) {
            this.lum.bUO();
        }
    }

    public void Gg(int i) {
        boolean Gn = this.lul.Gn(i);
        if (this.lum.Gl(i).pageData == null) {
            if (Gn) {
                this.lum.Gi(i);
                this.lum.Gk(i);
                return;
            }
            this.lum.E(true, i);
            this.lum.Gj(i);
        }
    }

    public void Gh(int i) {
        d Gl = this.lum.Gl(i);
        if (Gl.pageData == null) {
            Gg(i);
        } else if (Gl.pageData.bqf() != 0) {
            this.lul.a(i, Gl.pageData, Gl.lastId);
        }
    }

    public boolean a(i iVar, int i) {
        return this.lul.a(iVar, i);
    }

    public boolean a(com.baidu.tieba.hottopic.data.a aVar) {
        return this.lul.a(aVar);
    }

    public String getTopicId() {
        return this.fgR;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        Gh(this.lum.djN());
    }

    @Override // com.baidu.tieba.newdetail.a.InterfaceC0798a
    public void a(int i, e eVar) {
        if (eVar != null && eVar.sortType == -1) {
            this.lum.f(eVar);
            return;
        }
        this.lum.djK();
        this.lum.bUO();
        if (i != 0 || eVar == null) {
            if (this.lum.djM() == null) {
                this.lum.uf(false);
                return;
            }
            return;
        }
        if (eVar.cUZ() != null) {
            fQ(eVar.cUZ().fgR, eVar.cUZ().eRS);
        }
        this.lum.e(eVar);
        this.lum.djO();
        a(i, eVar.kqO, true);
    }

    private void fQ(String str, String str2) {
        if ((!TextUtils.isEmpty(str) && com.baidu.adp.lib.f.b.toLong(str, 0L) > 0) || !TextUtils.isEmpty(str2)) {
            this.fgR = str;
            this.eRS = str2;
            this.lul.w(com.baidu.adp.lib.f.b.toLong(str, 0L), str2);
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
                this.lum.f(j, j2, i2);
            } else {
                this.lum.G(j, j2);
            }
        }
    }

    @Override // com.baidu.tieba.newdetail.a.InterfaceC0798a
    public void d(e eVar) {
        com.baidu.tieba.hottopic.data.f cUZ;
        if (eVar != null && (cUZ = eVar.cUZ()) != null) {
            String str = "http://tieba.baidu.com/mo/q/newtopic/detail?topic_id=" + this.fgR;
            if (!TextUtils.isEmpty(this.eRS)) {
                str = str + "&topic_name=" + URLEncoder.encode(this.eRS);
            }
            this.kpG.a(cUZ.fgR, cUZ.eRS, str, cUZ.kkR, cUZ.shareTitle, true);
        }
    }

    public void djH() {
        if ("5".equals(this.mFrom)) {
            finish();
        } else {
            new HotRanklistActivityConfig(this).createNormalConfig(VideoMiddlePageActivityConfig.FROM_HOTTOPIC, "all").start();
        }
    }

    private void a(int i, d dVar, boolean z) {
        boolean z2 = false;
        int djN = this.lum.djN();
        if (dVar != null) {
            djN = dVar.sortType;
        }
        this.lum.Gj(djN);
        if (i != 0 || dVar == null || x.isEmpty(dVar.list)) {
            if (this.lum.Gl(djN).pageData == null) {
                this.lum.E(i != 0, djN);
                return;
            }
            return;
        }
        a.b bVar = this.lum;
        if (z || this.lum.Gl(djN).pageData == null) {
            z2 = true;
        }
        bVar.a(dVar, z2, djN);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.lum.onChangeSkinType();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return "a077";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.lum.resume();
        TiebaStatic.log(new aq("c13817").dX("uid", TbadkCoreApplication.getCurrentAccount()).dX("topic_id", this.fgR));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.lum.pause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.lum.destroy();
        djI();
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
                    this.lul.djP();
                    return;
                default:
                    return;
            }
        }
    }

    private void djI() {
        if (this.luo) {
            MainTabActivityConfig createNormalCfg = new MainTabActivityConfig(this).createNormalCfg(2);
            createNormalCfg.setSubTabName(getString(R.string.tab_name_topic_rank));
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, createNormalCfg));
        }
    }
}
