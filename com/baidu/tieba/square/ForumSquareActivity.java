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
    private ForumSquareModel kKY;
    private a kKZ;
    private b kLa;
    private String kLb = "";

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        al(getIntent());
        this.kKY = new ForumSquareModel(this, this);
        this.kKZ = new a(this);
        this.kLa = new b(this, this.kKZ);
        this.kLa.cUB();
        bTx();
    }

    private void bTx() {
        this.kKZ.cUv();
        this.kKY.Kt(this.kLb);
    }

    private void al(Intent intent) {
        Uri uri;
        if (intent != null) {
            this.kLb = intent.getStringExtra(ForumSquareActivityConfig.FORUM_CLASS_NAME);
            if (TextUtils.isEmpty(this.kLb) && (uri = (Uri) intent.getParcelableExtra(IntentConfig.KEY_URI)) != null) {
                this.kLb = uri.getQueryParameter("tab_name");
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.kKZ != null) {
            this.kKZ.changeSkinType(i);
        }
    }

    @Override // com.baidu.tieba.square.c
    public void c(String str, List<String> list, List<m> list2) {
        boolean z = true;
        if (this.kKY != null && this.kKZ != null) {
            if (TextUtils.isEmpty(str) || str.equals(this.kLb)) {
                String cUs = this.kKZ.cUs();
                if (TextUtils.isEmpty(str) || str.equals(cUs)) {
                    z = false;
                }
            }
            this.kLb = str;
            this.kKZ.cUw();
            this.kKZ.b(str, list, z);
            this.kKZ.o(list2, this.kKY.p(list2, 300));
            r(str, list2);
        }
    }

    @Override // com.baidu.tieba.square.c
    public void a(String str, ErrorData errorData) {
        if (this.kKZ != null && this.kKY != null) {
            this.kKZ.cUw();
            com.baidu.tieba.square.data.c Ks = this.kKY.Ks(str);
            if (Ks == null || (Ks.hasMore && v.isEmpty(Ks.getDataList()))) {
                this.kKZ.bmq();
                this.kKZ.cUt();
                return;
            }
            this.kKZ.er(Ks.getDataList());
            r(str, Ks.getDataList());
        }
    }

    private void r(String str, List<m> list) {
        if (this.kKZ != null && this.kKY != null) {
            if (v.isEmpty(list)) {
                this.kKZ.bmq();
            } else if (v.getCount(list) < 10) {
                this.kKZ.cUz();
            } else {
                this.kKZ.tL(this.kKY.Ku(str));
            }
        }
    }

    @Override // com.baidu.tieba.square.c
    public void b(ErrorData errorData) {
        if (this.kKZ != null) {
            this.kKZ.cUu();
        }
    }

    public void bpg() {
        String className = getClassName();
        if (this.kKY != null && this.kKZ != null) {
            boolean isLoading = this.kKY.isLoading();
            boolean tL = this.kKZ.tL(this.kKY.Ku(className));
            if (!isLoading && tL) {
                this.kKY.Kt(className);
            }
        }
    }

    public void cUp() {
        if (this.kKZ != null) {
            this.kKZ.cUv();
        }
        if (this.kKY != null) {
            this.kKY.Kt(getClassName());
        }
    }

    public void Kp(String str) {
        Kq(this.kLb);
        this.kLb = str;
        if (this.kKY != null && this.kKZ != null) {
            com.baidu.tieba.square.data.c Ks = this.kKY.Ks(str);
            if (Ks == null || (Ks.hasMore && v.isEmpty(Ks.getDataList()))) {
                this.kKZ.cUx();
                r(str, null);
                this.kKY.Kt(str);
                this.kKZ.scrollToPositionWithOffset(0, 0);
                return;
            }
            this.kKZ.cUw();
            r(str, Ks.getDataList());
            this.kKZ.er(Ks.getDataList());
            this.kKZ.scrollToPositionWithOffset(Ks.kLy, Ks.dEq);
        }
    }

    public void Kq(String str) {
        com.baidu.tieba.square.data.c Ks;
        Pair<Integer, Integer> cUr;
        if (this.kKZ != null && this.kKY != null && !TextUtils.isEmpty(str) && (Ks = this.kKY.Ks(str)) != null && (cUr = this.kKZ.cUr()) != null) {
            Ks.kLy = ((Integer) cUr.first).intValue();
            Ks.dEq = ((Integer) cUr.second).intValue();
        }
    }

    public String getClassName() {
        return this.kLb;
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
