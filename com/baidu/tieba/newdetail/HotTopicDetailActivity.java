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
/* loaded from: classes8.dex */
public class HotTopicDetailActivity extends BaseActivity<HotTopicDetailActivity> implements BdListView.e, a.InterfaceC0802a {
    private long eCy;
    private long fid;
    private String firstDir;
    private com.baidu.tieba.hottopic.controller.b ktw;
    private HotTopicDetailModel lxX;
    private a.b lxY;
    private String secondDir;
    private boolean mIsFromSchema = false;
    private long lxZ = -1;
    private boolean lya = false;
    private String fey = null;
    private String ePt = null;
    private String mFrom = "";

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        boolean z = true;
        if (ab(getIntent())) {
            this.fey = "" + this.lxZ;
            if (getIntent() != null && getIntent().getParcelableExtra(IntentConfig.KEY_URI) != null && !com.baidu.adp.base.b.kB().bo("MainTabActivity")) {
                this.mIsFromSchema = true;
            }
        } else {
            aA(bundle);
        }
        if (this.mIsFromSchema) {
            setIsAddSwipeBackLayout(false);
        }
        super.onCreate(bundle);
        if ((TextUtils.isEmpty(this.fey) || com.baidu.adp.lib.f.b.toLong(this.fey, 0L) <= 0) && TextUtils.isEmpty(this.ePt)) {
            finish();
            return;
        }
        this.lxX = new HotTopicDetailModel(getPageContext(), this);
        this.lxY = new HotTopicDetailView(getPageContext(), this, bundle);
        this.lxX.setFrom(this.mFrom);
        fP(this.fey, this.ePt);
        this.ktw = new com.baidu.tieba.hottopic.controller.b(this);
        setContentView(this.lxY.getRootView());
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        ER(1);
        if (getIntent() == null || !getIntent().getBooleanExtra(TopicDetailActivityConfig.KEY_IS_FROM_YUN_PUSH, false)) {
            z = false;
        }
        this.lya = z;
    }

    private void aA(Bundle bundle) {
        Intent intent = getIntent();
        if (intent != null) {
            this.fey = intent.getStringExtra("topic_id");
            this.ePt = intent.getStringExtra("topic_name");
            this.fid = intent.getLongExtra("topic_fid", 0L);
            this.firstDir = intent.getStringExtra("topic_first_dir");
            this.secondDir = intent.getStringExtra("topic_second_dir");
            this.mFrom = intent.getStringExtra("from");
            this.eCy = intent.getLongExtra(IntentConfig.TOPIC_TID, 0L);
        } else if (bundle != null) {
            this.fey = bundle.getString("topic_id");
            this.ePt = bundle.getString("topic_name");
            this.fid = bundle.getLong("topic_fid", 0L);
            this.firstDir = bundle.getString("topic_first_dir");
            this.secondDir = bundle.getString("topic_second_dir");
            this.mFrom = bundle.getString("from");
            this.eCy = bundle.getLong(IntentConfig.TOPIC_TID, 0L);
        }
    }

    private boolean ab(Intent intent) {
        int length;
        String substring;
        if (intent.getParcelableExtra(IntentConfig.KEY_URI) != null) {
            Uri uri = (Uri) intent.getParcelableExtra(IntentConfig.KEY_URI);
            String uri2 = uri.toString();
            if (f.r(uri)) {
                f.bhH().e(uri, new f.a() { // from class: com.baidu.tieba.newdetail.HotTopicDetailActivity.1
                    @Override // com.baidu.tbadk.BdToken.f.a
                    public void onCallBack(HashMap<String, Object> hashMap) {
                        if (hashMap != null && (hashMap.get(f.eDS) instanceof String)) {
                            String str = (String) hashMap.get(f.eDS);
                            if (!StringUtils.isNull(str)) {
                                HotTopicDetailActivity.this.lxZ = com.baidu.adp.lib.f.b.toLong(str, -1L);
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
                    this.lxZ = com.baidu.adp.lib.f.b.toLong(substring, -1L);
                }
            }
        } else {
            this.lxZ = intent.getLongExtra("topic_id", -1L);
        }
        return this.lxZ > 0;
    }

    @Override // com.baidu.tieba.newdetail.a.InterfaceC0802a
    public void ER(int i) {
        boolean EY = this.lxX.EY(i);
        if (this.lxY.did() == null) {
            if (EY) {
                this.lxY.dia();
                this.lxY.dic();
                return;
            }
            this.lxY.uo(true);
            this.lxY.dib();
        } else if (!EY) {
            this.lxY.bRI();
        }
    }

    public void ES(int i) {
        boolean EZ = this.lxX.EZ(i);
        if (this.lxY.EX(i).pageData == null) {
            if (EZ) {
                this.lxY.EU(i);
                this.lxY.EW(i);
                return;
            }
            this.lxY.E(true, i);
            this.lxY.EV(i);
        }
    }

    public void ET(int i) {
        d EX = this.lxY.EX(i);
        if (EX.pageData == null) {
            ES(i);
        } else if (EX.pageData.bmF() != 0) {
            this.lxX.a(i, EX.pageData, EX.lastId);
        }
    }

    public boolean a(i iVar, int i) {
        return this.lxX.a(iVar, i);
    }

    public boolean a(com.baidu.tieba.hottopic.data.a aVar) {
        return this.lxX.a(aVar);
    }

    public String getTopicId() {
        return this.fey;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        ET(this.lxY.die());
    }

    @Override // com.baidu.tieba.newdetail.a.InterfaceC0802a
    public void a(int i, e eVar) {
        if (eVar != null && eVar.sortType == -1) {
            this.lxY.f(eVar);
            return;
        }
        this.lxY.dib();
        this.lxY.bRI();
        if (i != 0 || eVar == null) {
            if (this.lxY.did() == null) {
                this.lxY.uo(false);
                return;
            }
            return;
        }
        if (eVar.cTo() != null) {
            fP(eVar.cTo().fey, eVar.cTo().ePt);
        }
        this.lxY.e(eVar);
        this.lxY.dif();
        a(i, eVar.kuE, true);
    }

    private void fP(String str, String str2) {
        if ((!TextUtils.isEmpty(str) && com.baidu.adp.lib.f.b.toLong(str, 0L) > 0) || !TextUtils.isEmpty(str2)) {
            this.fey = str;
            this.ePt = str2;
            this.lxX.x(com.baidu.adp.lib.f.b.toLong(str, 0L), str2);
        }
    }

    @Override // com.baidu.tieba.newdetail.a.InterfaceC0802a
    public void a(int i, d dVar) {
        a(i, dVar, false);
    }

    @Override // com.baidu.tieba.newdetail.a.InterfaceC0802a
    public void a(int i, long j, long j2, int i2) {
        if (i == 0 && j > 0 && i2 >= 0) {
            if (i2 == 1 || i2 == 2) {
                this.lxY.e(j, j2, i2);
            } else {
                this.lxY.K(j, j2);
            }
        }
    }

    @Override // com.baidu.tieba.newdetail.a.InterfaceC0802a
    public void d(e eVar) {
        com.baidu.tieba.hottopic.data.f cTo;
        if (eVar != null && (cTo = eVar.cTo()) != null) {
            String str = "http://tieba.baidu.com/mo/q/newtopic/detail?topic_id=" + this.fey;
            if (!TextUtils.isEmpty(this.ePt)) {
                str = str + "&topic_name=" + URLEncoder.encode(this.ePt);
            }
            this.ktw.a(cTo.fey, cTo.ePt, str, cTo.koH, cTo.shareTitle, true);
        }
    }

    public void dhY() {
        if ("5".equals(this.mFrom)) {
            finish();
        } else {
            new HotRanklistActivityConfig(this).createNormalConfig("hottopic", "all").start();
        }
    }

    private void a(int i, d dVar, boolean z) {
        boolean z2 = false;
        int die = this.lxY.die();
        if (dVar != null) {
            die = dVar.sortType;
        }
        this.lxY.EV(die);
        if (i != 0 || dVar == null || y.isEmpty(dVar.list)) {
            if (this.lxY.EX(die).pageData == null) {
                this.lxY.E(i != 0, die);
                return;
            }
            return;
        }
        a.b bVar = this.lxY;
        if (z || this.lxY.EX(die).pageData == null) {
            z2 = true;
        }
        bVar.a(dVar, z2, die);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.lxY.onChangeSkinType();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return "a077";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.lxY.resume();
        TiebaStatic.log(new ar("c13817").dR("uid", TbadkCoreApplication.getCurrentAccount()).dR("topic_id", this.fey));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.lxY.pause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.lxY.destroy();
        dhZ();
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
                    this.lxX.dig();
                    return;
                default:
                    return;
            }
        }
    }

    private void dhZ() {
        if (this.lya) {
            MainTabActivityConfig createNormalCfg = new MainTabActivityConfig(this).createNormalCfg(2);
            createNormalCfg.setSubTabName(getString(R.string.tab_name_topic_rank));
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, createNormalCfg));
        }
    }
}
