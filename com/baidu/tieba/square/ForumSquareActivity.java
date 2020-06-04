package com.baidu.tieba.square;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import com.baidu.adp.widget.ListView.o;
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
    private ForumSquareModel leC;
    private a leD;
    private b leE;
    private String leF = "";

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        V(getIntent());
        this.leC = new ForumSquareModel(this, this);
        this.leD = new a(this);
        this.leE = new b(this, this.leD);
        this.leE.dbS();
        caa();
    }

    private void caa() {
        this.leD.dbM();
        this.leC.Mj(this.leF);
    }

    private void V(Intent intent) {
        Uri uri;
        if (intent != null) {
            this.leF = intent.getStringExtra(ForumSquareActivityConfig.FORUM_CLASS_NAME);
            if (TextUtils.isEmpty(this.leF) && (uri = (Uri) intent.getParcelableExtra(IntentConfig.KEY_URI)) != null) {
                this.leF = uri.getQueryParameter("tab_name");
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.leD != null) {
            this.leD.changeSkinType(i);
        }
    }

    @Override // com.baidu.tieba.square.c
    public void c(String str, List<String> list, List<o> list2) {
        boolean z = true;
        if (this.leC != null && this.leD != null) {
            if (TextUtils.isEmpty(str) || str.equals(this.leF)) {
                String dbJ = this.leD.dbJ();
                if (TextUtils.isEmpty(str) || str.equals(dbJ)) {
                    z = false;
                }
            }
            this.leF = str;
            this.leD.dbN();
            this.leD.b(str, list, z);
            this.leD.q(list2, this.leC.r(list2, 300));
            r(str, list2);
        }
    }

    @Override // com.baidu.tieba.square.c
    public void a(String str, ErrorData errorData) {
        if (this.leD != null && this.leC != null) {
            this.leD.dbN();
            com.baidu.tieba.square.data.c Mi = this.leC.Mi(str);
            if (Mi == null || (Mi.hasMore && v.isEmpty(Mi.getDataList()))) {
                this.leD.brO();
                this.leD.dbK();
                return;
            }
            this.leD.eA(Mi.getDataList());
            r(str, Mi.getDataList());
        }
    }

    private void r(String str, List<o> list) {
        if (this.leD != null && this.leC != null) {
            if (v.isEmpty(list)) {
                this.leD.brO();
            } else if (v.getCount(list) < 10) {
                this.leD.dbQ();
            } else {
                this.leD.uj(this.leC.Mk(str));
            }
        }
    }

    @Override // com.baidu.tieba.square.c
    public void e(ErrorData errorData) {
        if (this.leD != null) {
            this.leD.dbL();
        }
    }

    public void buX() {
        String className = getClassName();
        if (this.leC != null && this.leD != null) {
            boolean isLoading = this.leC.isLoading();
            boolean uj = this.leD.uj(this.leC.Mk(className));
            if (!isLoading && uj) {
                this.leC.Mj(className);
            }
        }
    }

    public void dbH() {
        if (this.leD != null) {
            this.leD.dbM();
        }
        if (this.leC != null) {
            this.leC.Mj(getClassName());
        }
    }

    public void Mf(String str) {
        Mg(this.leF);
        this.leF = str;
        if (this.leC != null && this.leD != null) {
            com.baidu.tieba.square.data.c Mi = this.leC.Mi(str);
            if (Mi == null || (Mi.hasMore && v.isEmpty(Mi.getDataList()))) {
                this.leD.dbO();
                r(str, null);
                this.leC.Mj(str);
                this.leD.scrollToPositionWithOffset(0, 0);
                return;
            }
            this.leD.dbN();
            r(str, Mi.getDataList());
            this.leD.eA(Mi.getDataList());
            this.leD.scrollToPositionWithOffset(Mi.lfc, Mi.dSG);
        }
    }

    public void Mg(String str) {
        com.baidu.tieba.square.data.c Mi;
        Pair<Integer, Integer> dbI;
        if (this.leD != null && this.leC != null && !TextUtils.isEmpty(str) && (Mi = this.leC.Mi(str)) != null && (dbI = this.leD.dbI()) != null) {
            Mi.lfc = ((Integer) dbI.first).intValue();
            Mi.dSG = ((Integer) dbI.second).intValue();
        }
    }

    public String getClassName() {
        return this.leF;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        an anVar = new an("c13650");
        anVar.s("uid", TbadkCoreApplication.getCurrentAccountId());
        TiebaStatic.log(anVar);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return "a073";
    }
}
