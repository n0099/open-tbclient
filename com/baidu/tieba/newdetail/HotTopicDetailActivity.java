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
public class HotTopicDetailActivity extends BaseActivity<HotTopicDetailActivity> implements BdListView.e, a.InterfaceC0796a {
    private long eqw;
    private long fid;
    private String firstDir;
    private com.baidu.tieba.hottopic.controller.b jOf;
    private HotTopicDetailModel lbj;
    private a.b lbk;
    private String secondDir;
    private boolean mIsFromSchema = false;
    private long lbl = -1;
    private boolean lbm = false;
    private String eRa = null;
    private String eCJ = null;
    private String mFrom = "";

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        boolean z = true;
        if (ac(getIntent())) {
            this.eRa = "" + this.lbl;
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
        if ((TextUtils.isEmpty(this.eRa) || com.baidu.adp.lib.f.b.toLong(this.eRa, 0L) <= 0) && TextUtils.isEmpty(this.eCJ)) {
            finish();
            return;
        }
        this.lbj = new HotTopicDetailModel(getPageContext(), this);
        this.lbk = new HotTopicDetailView(getPageContext(), this, bundle);
        this.lbj.setFrom(this.mFrom);
        fO(this.eRa, this.eCJ);
        this.jOf = new com.baidu.tieba.hottopic.controller.b(this);
        setContentView(this.lbk.getRootView());
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        Fa(1);
        if (getIntent() == null || !getIntent().getBooleanExtra(TopicDetailActivityConfig.KEY_IS_FROM_YUN_PUSH, false)) {
            z = false;
        }
        this.lbm = z;
    }

    private void az(Bundle bundle) {
        Intent intent = getIntent();
        if (intent != null) {
            this.eRa = intent.getStringExtra("topic_id");
            this.eCJ = intent.getStringExtra("topic_name");
            this.fid = intent.getLongExtra("topic_fid", 0L);
            this.firstDir = intent.getStringExtra("topic_first_dir");
            this.secondDir = intent.getStringExtra("topic_second_dir");
            this.mFrom = intent.getStringExtra("from");
            this.eqw = intent.getLongExtra(IntentConfig.TOPIC_TID, 0L);
        } else if (bundle != null) {
            this.eRa = bundle.getString("topic_id");
            this.eCJ = bundle.getString("topic_name");
            this.fid = bundle.getLong("topic_fid", 0L);
            this.firstDir = bundle.getString("topic_first_dir");
            this.secondDir = bundle.getString("topic_second_dir");
            this.mFrom = bundle.getString("from");
            this.eqw = bundle.getLong(IntentConfig.TOPIC_TID, 0L);
        }
    }

    private boolean ac(Intent intent) {
        int length;
        String substring;
        if (intent.getParcelableExtra(IntentConfig.KEY_URI) != null) {
            Uri uri = (Uri) intent.getParcelableExtra(IntentConfig.KEY_URI);
            String uri2 = uri.toString();
            if (f.p(uri)) {
                f.bgz().e(uri, new f.a() { // from class: com.baidu.tieba.newdetail.HotTopicDetailActivity.1
                    @Override // com.baidu.tbadk.BdToken.f.a
                    public void B(HashMap<String, Object> hashMap) {
                        if (hashMap != null && (hashMap.get(f.erO) instanceof String)) {
                            String str = (String) hashMap.get(f.erO);
                            if (!StringUtils.isNull(str)) {
                                HotTopicDetailActivity.this.lbl = com.baidu.adp.lib.f.b.toLong(str, -1L);
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
                    this.lbl = com.baidu.adp.lib.f.b.toLong(substring, -1L);
                }
            }
        } else {
            this.lbl = intent.getLongExtra("topic_id", -1L);
        }
        return this.lbl > 0;
    }

    @Override // com.baidu.tieba.newdetail.a.InterfaceC0796a
    public void Fa(int i) {
        boolean Fh = this.lbj.Fh(i);
        if (this.lbk.dfs() == null) {
            if (Fh) {
                this.lbk.dfp();
                this.lbk.dfr();
                return;
            }
            this.lbk.tz(true);
            this.lbk.dfq();
        } else if (!Fh) {
            this.lbk.bPh();
        }
    }

    public void Fb(int i) {
        boolean Fi = this.lbj.Fi(i);
        if (this.lbk.Fg(i).pageData == null) {
            if (Fi) {
                this.lbk.Fd(i);
                this.lbk.Ff(i);
                return;
            }
            this.lbk.F(true, i);
            this.lbk.Fe(i);
        }
    }

    public void Fc(int i) {
        d Fg = this.lbk.Fg(i);
        if (Fg.pageData == null) {
            Fb(i);
        } else if (Fg.pageData.blq() != 0) {
            this.lbj.a(i, Fg.pageData, Fg.lastId);
        }
    }

    public boolean a(i iVar, int i) {
        return this.lbj.a(iVar, i);
    }

    public boolean a(com.baidu.tieba.hottopic.data.a aVar) {
        return this.lbj.a(aVar);
    }

    public String getTopicId() {
        return this.eRa;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        Fc(this.lbk.dft());
    }

    @Override // com.baidu.tieba.newdetail.a.InterfaceC0796a
    public void a(int i, e eVar) {
        if (eVar != null && eVar.sortType == -1) {
            this.lbk.g(eVar);
            return;
        }
        this.lbk.dfq();
        this.lbk.bPh();
        if (i != 0 || eVar == null) {
            if (this.lbk.dfs() == null) {
                this.lbk.tz(false);
                return;
            }
            return;
        }
        if (eVar.cMX() != null) {
            fO(eVar.cMX().eRa, eVar.cMX().eCJ);
        }
        this.lbk.f(eVar);
        this.lbk.dfu();
        a(i, eVar.jPn, true);
    }

    private void fO(String str, String str2) {
        if ((!TextUtils.isEmpty(str) && com.baidu.adp.lib.f.b.toLong(str, 0L) > 0) || !TextUtils.isEmpty(str2)) {
            this.eRa = str;
            this.eCJ = str2;
            this.lbj.v(com.baidu.adp.lib.f.b.toLong(str, 0L), str2);
        }
    }

    @Override // com.baidu.tieba.newdetail.a.InterfaceC0796a
    public void a(int i, d dVar) {
        a(i, dVar, false);
    }

    @Override // com.baidu.tieba.newdetail.a.InterfaceC0796a
    public void a(int i, long j, long j2, int i2) {
        if (i == 0 && j > 0 && i2 >= 0) {
            if (i2 == 1 || i2 == 2) {
                this.lbk.e(j, j2, i2);
            } else {
                this.lbk.E(j, j2);
            }
        }
    }

    @Override // com.baidu.tieba.newdetail.a.InterfaceC0796a
    public void e(e eVar) {
        com.baidu.tieba.hottopic.data.f cMX;
        if (eVar != null && (cMX = eVar.cMX()) != null) {
            String str = "http://tieba.baidu.com/mo/q/newtopic/detail?topic_id=" + this.eRa;
            if (!TextUtils.isEmpty(this.eCJ)) {
                str = str + "&topic_name=" + URLEncoder.encode(this.eCJ);
            }
            this.jOf.b(cMX.eRa, cMX.eCJ, str, cMX.jJp, cMX.shareTitle, true);
        }
    }

    public void dfn() {
        if ("5".equals(this.mFrom)) {
            finish();
        } else {
            new HotRanklistActivityConfig(this).createNormalConfig(VideoMiddlePageActivityConfig.FROM_HOTTOPIC, "all").start();
        }
    }

    private void a(int i, d dVar, boolean z) {
        boolean z2 = false;
        int dft = this.lbk.dft();
        if (dVar != null) {
            dft = dVar.sortType;
        }
        this.lbk.Fe(dft);
        if (i != 0 || dVar == null || y.isEmpty(dVar.list)) {
            if (this.lbk.Fg(dft).pageData == null) {
                this.lbk.F(i != 0, dft);
                return;
            }
            return;
        }
        a.b bVar = this.lbk;
        if (z || this.lbk.Fg(dft).pageData == null) {
            z2 = true;
        }
        bVar.a(dVar, z2, dft);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.lbk.onChangeSkinType();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return "a077";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.lbk.resume();
        TiebaStatic.log(new aq("c13817").dR("uid", TbadkCoreApplication.getCurrentAccount()).dR("topic_id", this.eRa));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.lbk.pause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.lbk.destroy();
        dfo();
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
                    this.lbj.dfv();
                    return;
                default:
                    return;
            }
        }
    }

    private void dfo() {
        if (this.lbm) {
            MainTabActivityConfig createNormalCfg = new MainTabActivityConfig(this).createNormalCfg(2);
            createNormalCfg.setSubTabName(getString(R.string.tab_name_topic_rank));
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, createNormalCfg));
        }
    }
}
