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
public class HotTopicDetailActivity extends BaseActivity<HotTopicDetailActivity> implements BdListView.e, a.InterfaceC0781a {
    private long ekC;
    private long fid;
    private String firstDir;
    private com.baidu.tieba.hottopic.controller.b jIh;
    private HotTopicDetailModel kVm;
    private a.b kVn;
    private String secondDir;
    private boolean mIsFromSchema = false;
    private long kVo = -1;
    private boolean kVp = false;
    private String eLl = null;
    private String ewR = null;
    private String mFrom = "";

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        boolean z = true;
        if (ac(getIntent())) {
            this.eLl = "" + this.kVo;
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
        if ((TextUtils.isEmpty(this.eLl) || com.baidu.adp.lib.f.b.toLong(this.eLl, 0L) <= 0) && TextUtils.isEmpty(this.ewR)) {
            finish();
            return;
        }
        this.kVm = new HotTopicDetailModel(getPageContext(), this);
        this.kVn = new HotTopicDetailView(getPageContext(), this, bundle);
        this.kVm.setFrom(this.mFrom);
        fO(this.eLl, this.ewR);
        this.jIh = new com.baidu.tieba.hottopic.controller.b(this);
        setContentView(this.kVn.getRootView());
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        EN(1);
        if (getIntent() == null || !getIntent().getBooleanExtra(TopicDetailActivityConfig.KEY_IS_FROM_YUN_PUSH, false)) {
            z = false;
        }
        this.kVp = z;
    }

    private void az(Bundle bundle) {
        Intent intent = getIntent();
        if (intent != null) {
            this.eLl = intent.getStringExtra("topic_id");
            this.ewR = intent.getStringExtra("topic_name");
            this.fid = intent.getLongExtra("topic_fid", 0L);
            this.firstDir = intent.getStringExtra("topic_first_dir");
            this.secondDir = intent.getStringExtra("topic_second_dir");
            this.mFrom = intent.getStringExtra("from");
            this.ekC = intent.getLongExtra(IntentConfig.TOPIC_TID, 0L);
        } else if (bundle != null) {
            this.eLl = bundle.getString("topic_id");
            this.ewR = bundle.getString("topic_name");
            this.fid = bundle.getLong("topic_fid", 0L);
            this.firstDir = bundle.getString("topic_first_dir");
            this.secondDir = bundle.getString("topic_second_dir");
            this.mFrom = bundle.getString("from");
            this.ekC = bundle.getLong(IntentConfig.TOPIC_TID, 0L);
        }
    }

    private boolean ac(Intent intent) {
        int length;
        String substring;
        if (intent.getParcelableExtra(IntentConfig.KEY_URI) != null) {
            Uri uri = (Uri) intent.getParcelableExtra(IntentConfig.KEY_URI);
            String uri2 = uri.toString();
            if (f.p(uri)) {
                f.bdZ().e(uri, new f.a() { // from class: com.baidu.tieba.newdetail.HotTopicDetailActivity.1
                    @Override // com.baidu.tbadk.BdToken.f.a
                    public void B(HashMap<String, Object> hashMap) {
                        if (hashMap != null && (hashMap.get(f.elT) instanceof String)) {
                            String str = (String) hashMap.get(f.elT);
                            if (!StringUtils.isNull(str)) {
                                HotTopicDetailActivity.this.kVo = com.baidu.adp.lib.f.b.toLong(str, -1L);
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
                    this.kVo = com.baidu.adp.lib.f.b.toLong(substring, -1L);
                }
            }
        } else {
            this.kVo = intent.getLongExtra("topic_id", -1L);
        }
        return this.kVo > 0;
    }

    @Override // com.baidu.tieba.newdetail.a.InterfaceC0781a
    public void EN(int i) {
        boolean EU = this.kVm.EU(i);
        if (this.kVn.dcQ() == null) {
            if (EU) {
                this.kVn.dcN();
                this.kVn.dcP();
                return;
            }
            this.kVn.tq(true);
            this.kVn.dcO();
        } else if (!EU) {
            this.kVn.bMH();
        }
    }

    public void EO(int i) {
        boolean EV = this.kVm.EV(i);
        if (this.kVn.ET(i).pageData == null) {
            if (EV) {
                this.kVn.EQ(i);
                this.kVn.ES(i);
                return;
            }
            this.kVn.F(true, i);
            this.kVn.ER(i);
        }
    }

    public void EP(int i) {
        d ET = this.kVn.ET(i);
        if (ET.pageData == null) {
            EO(i);
        } else if (ET.pageData.biQ() != 0) {
            this.kVm.a(i, ET.pageData, ET.lastId);
        }
    }

    public boolean a(i iVar, int i) {
        return this.kVm.a(iVar, i);
    }

    public boolean a(com.baidu.tieba.hottopic.data.a aVar) {
        return this.kVm.a(aVar);
    }

    public String getTopicId() {
        return this.eLl;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        EP(this.kVn.dcR());
    }

    @Override // com.baidu.tieba.newdetail.a.InterfaceC0781a
    public void a(int i, e eVar) {
        if (eVar != null && eVar.sortType == -1) {
            this.kVn.g(eVar);
            return;
        }
        this.kVn.dcO();
        this.kVn.bMH();
        if (i != 0 || eVar == null) {
            if (this.kVn.dcQ() == null) {
                this.kVn.tq(false);
                return;
            }
            return;
        }
        if (eVar.cKw() != null) {
            fO(eVar.cKw().eLl, eVar.cKw().ewR);
        }
        this.kVn.f(eVar);
        this.kVn.dcS();
        a(i, eVar.jJp, true);
    }

    private void fO(String str, String str2) {
        if ((!TextUtils.isEmpty(str) && com.baidu.adp.lib.f.b.toLong(str, 0L) > 0) || !TextUtils.isEmpty(str2)) {
            this.eLl = str;
            this.ewR = str2;
            this.kVm.u(com.baidu.adp.lib.f.b.toLong(str, 0L), str2);
        }
    }

    @Override // com.baidu.tieba.newdetail.a.InterfaceC0781a
    public void a(int i, d dVar) {
        a(i, dVar, false);
    }

    @Override // com.baidu.tieba.newdetail.a.InterfaceC0781a
    public void a(int i, long j, long j2, int i2) {
        if (i == 0 && j > 0 && i2 >= 0) {
            if (i2 == 1 || i2 == 2) {
                this.kVn.e(j, j2, i2);
            } else {
                this.kVn.D(j, j2);
            }
        }
    }

    @Override // com.baidu.tieba.newdetail.a.InterfaceC0781a
    public void e(e eVar) {
        com.baidu.tieba.hottopic.data.f cKw;
        if (eVar != null && (cKw = eVar.cKw()) != null) {
            String str = "http://tieba.baidu.com/mo/q/newtopic/detail?topic_id=" + this.eLl;
            if (!TextUtils.isEmpty(this.ewR)) {
                str = str + "&topic_name=" + URLEncoder.encode(this.ewR);
            }
            this.jIh.b(cKw.eLl, cKw.ewR, str, cKw.jDs, cKw.shareTitle, true);
        }
    }

    public void dcL() {
        if ("5".equals(this.mFrom)) {
            finish();
        } else {
            new HotRanklistActivityConfig(this).createNormalConfig(VideoMiddlePageActivityConfig.FROM_HOTTOPIC, "all").start();
        }
    }

    private void a(int i, d dVar, boolean z) {
        boolean z2 = false;
        int dcR = this.kVn.dcR();
        if (dVar != null) {
            dcR = dVar.sortType;
        }
        this.kVn.ER(dcR);
        if (i != 0 || dVar == null || y.isEmpty(dVar.list)) {
            if (this.kVn.ET(dcR).pageData == null) {
                this.kVn.F(i != 0, dcR);
                return;
            }
            return;
        }
        a.b bVar = this.kVn;
        if (z || this.kVn.ET(dcR).pageData == null) {
            z2 = true;
        }
        bVar.a(dVar, z2, dcR);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.kVn.onChangeSkinType();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return "a077";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.kVn.resume();
        TiebaStatic.log(new aq("c13817").dR("uid", TbadkCoreApplication.getCurrentAccount()).dR("topic_id", this.eLl));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.kVn.pause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.kVn.destroy();
        dcM();
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
                    this.kVm.dcT();
                    return;
                default:
                    return;
            }
        }
    }

    private void dcM() {
        if (this.kVp) {
            MainTabActivityConfig createNormalCfg = new MainTabActivityConfig(this).createNormalCfg(2);
            createNormalCfg.setSubTabName(getString(R.string.tab_name_topic_rank));
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, createNormalCfg));
        }
    }
}
