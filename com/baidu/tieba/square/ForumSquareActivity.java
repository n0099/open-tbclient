package com.baidu.tieba.square;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ForumSquareActivityConfig;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.square.model.ForumSquareModel;
import java.util.List;
/* loaded from: classes9.dex */
public class ForumSquareActivity extends BaseActivity<ForumSquareActivity> implements c {
    private ForumSquareModel kLc;
    private a kLd;
    private b kLe;
    private String kLf = "";

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Y(getIntent());
        this.kLc = new ForumSquareModel(this, this);
        this.kLd = new a(this);
        this.kLe = new b(this, this.kLd);
        this.kLe.cUz();
        bTw();
    }

    private void bTw() {
        this.kLd.cUt();
        this.kLc.Kw(this.kLf);
    }

    private void Y(Intent intent) {
        Uri uri;
        if (intent != null) {
            this.kLf = intent.getStringExtra(ForumSquareActivityConfig.FORUM_CLASS_NAME);
            if (TextUtils.isEmpty(this.kLf) && (uri = (Uri) intent.getParcelableExtra(IntentConfig.KEY_URI)) != null) {
                this.kLf = uri.getQueryParameter("tab_name");
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.kLd != null) {
            this.kLd.changeSkinType(i);
        }
    }

    @Override // com.baidu.tieba.square.c
    public void c(String str, List<String> list, List<m> list2) {
        boolean z = true;
        if (this.kLc != null && this.kLd != null) {
            if (TextUtils.isEmpty(str) || str.equals(this.kLf)) {
                String cUq = this.kLd.cUq();
                if (TextUtils.isEmpty(str) || str.equals(cUq)) {
                    z = false;
                }
            }
            this.kLf = str;
            this.kLd.cUu();
            this.kLd.b(str, list, z);
            this.kLd.o(list2, this.kLc.p(list2, 300));
            r(str, list2);
        }
    }

    @Override // com.baidu.tieba.square.c
    public void a(String str, ErrorData errorData) {
        if (this.kLd != null && this.kLc != null) {
            this.kLd.cUu();
            com.baidu.tieba.square.data.c Kv = this.kLc.Kv(str);
            if (Kv == null || (Kv.hasMore && v.isEmpty(Kv.getDataList()))) {
                this.kLd.bmo();
                this.kLd.cUr();
                return;
            }
            this.kLd.er(Kv.getDataList());
            r(str, Kv.getDataList());
        }
    }

    private void r(String str, List<m> list) {
        if (this.kLd != null && this.kLc != null) {
            if (v.isEmpty(list)) {
                this.kLd.bmo();
            } else if (v.getCount(list) < 10) {
                this.kLd.cUx();
            } else {
                this.kLd.tL(this.kLc.Kx(str));
            }
        }
    }

    @Override // com.baidu.tieba.square.c
    public void b(ErrorData errorData) {
        if (this.kLd != null) {
            this.kLd.cUs();
        }
    }

    public void bpe() {
        String className = getClassName();
        if (this.kLc != null && this.kLd != null) {
            boolean isLoading = this.kLc.isLoading();
            boolean tL = this.kLd.tL(this.kLc.Kx(className));
            if (!isLoading && tL) {
                this.kLc.Kw(className);
            }
        }
    }

    public void cUn() {
        if (this.kLd != null) {
            this.kLd.cUt();
        }
        if (this.kLc != null) {
            this.kLc.Kw(getClassName());
        }
    }

    public void Ks(String str) {
        Kt(this.kLf);
        this.kLf = str;
        if (this.kLc != null && this.kLd != null) {
            com.baidu.tieba.square.data.c Kv = this.kLc.Kv(str);
            if (Kv == null || (Kv.hasMore && v.isEmpty(Kv.getDataList()))) {
                this.kLd.cUv();
                r(str, null);
                this.kLc.Kw(str);
                this.kLd.scrollToPositionWithOffset(0, 0);
                return;
            }
            this.kLd.cUu();
            r(str, Kv.getDataList());
            this.kLd.er(Kv.getDataList());
            this.kLd.scrollToPositionWithOffset(Kv.kLC, Kv.dEu);
        }
    }

    public void Kt(String str) {
        com.baidu.tieba.square.data.c Kv;
        Pair<Integer, Integer> cUp;
        if (this.kLd != null && this.kLc != null && !TextUtils.isEmpty(str) && (Kv = this.kLc.Kv(str)) != null && (cUp = this.kLd.cUp()) != null) {
            Kv.kLC = ((Integer) cUp.first).intValue();
            Kv.dEu = ((Integer) cUp.second).intValue();
        }
    }

    public String getClassName() {
        return this.kLf;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        an anVar = new an("c13650");
        anVar.t("uid", TbadkCoreApplication.getCurrentAccountId());
        TiebaStatic.log(anVar);
    }
}
