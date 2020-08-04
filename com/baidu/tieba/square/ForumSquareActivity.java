package com.baidu.tieba.square;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ForumSquareActivityConfig;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.square.model.ForumSquareModel;
import java.util.List;
/* loaded from: classes16.dex */
public class ForumSquareActivity extends BaseActivity<ForumSquareActivity> implements c {
    private ForumSquareModel lFR;
    private a lFS;
    private b lFT;
    private String lFU = "";

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        W(getIntent());
        this.lFR = new ForumSquareModel(this, this);
        this.lFS = new a(this);
        this.lFT = new b(this, this.lFS);
        this.lFT.djr();
        cgO();
    }

    private void cgO() {
        this.lFS.djl();
        this.lFR.Nt(this.lFU);
    }

    private void W(Intent intent) {
        Uri uri;
        if (intent != null) {
            this.lFU = intent.getStringExtra(ForumSquareActivityConfig.FORUM_CLASS_NAME);
            if (TextUtils.isEmpty(this.lFU) && (uri = (Uri) intent.getParcelableExtra(IntentConfig.KEY_URI)) != null) {
                this.lFU = uri.getQueryParameter("tab_name");
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.lFS != null) {
            this.lFS.changeSkinType(i);
        }
    }

    @Override // com.baidu.tieba.square.c
    public void c(String str, List<String> list, List<q> list2) {
        boolean z = true;
        if (this.lFR != null && this.lFS != null) {
            if (TextUtils.isEmpty(str) || str.equals(this.lFU)) {
                String dji = this.lFS.dji();
                if (TextUtils.isEmpty(str) || str.equals(dji)) {
                    z = false;
                }
            }
            this.lFU = str;
            this.lFS.djm();
            this.lFS.b(str, list, z);
            this.lFS.p(list2, this.lFR.q(list2, 300));
            r(str, list2);
        }
    }

    @Override // com.baidu.tieba.square.c
    public void a(String str, ErrorData errorData) {
        if (this.lFS != null && this.lFR != null) {
            this.lFS.djm();
            com.baidu.tieba.square.data.c Ns = this.lFR.Ns(str);
            if (Ns == null || (Ns.hasMore && x.isEmpty(Ns.getDataList()))) {
                this.lFS.bxU();
                this.lFS.djj();
                return;
            }
            this.lFS.eU(Ns.getDataList());
            r(str, Ns.getDataList());
        }
    }

    private void r(String str, List<q> list) {
        if (this.lFS != null && this.lFR != null) {
            if (x.isEmpty(list)) {
                this.lFS.bxU();
            } else if (x.getCount(list) < 10) {
                this.lFS.djp();
            } else {
                this.lFS.vc(this.lFR.Nu(str));
            }
        }
    }

    @Override // com.baidu.tieba.square.c
    public void e(ErrorData errorData) {
        if (this.lFS != null) {
            this.lFS.djk();
        }
    }

    public void bBi() {
        String className = getClassName();
        if (this.lFR != null && this.lFS != null) {
            boolean isLoading = this.lFR.isLoading();
            boolean vc = this.lFS.vc(this.lFR.Nu(className));
            if (!isLoading && vc) {
                this.lFR.Nt(className);
            }
        }
    }

    public void djg() {
        if (this.lFS != null) {
            this.lFS.djl();
        }
        if (this.lFR != null) {
            this.lFR.Nt(getClassName());
        }
    }

    public void Np(String str) {
        Nq(this.lFU);
        this.lFU = str;
        if (this.lFR != null && this.lFS != null) {
            com.baidu.tieba.square.data.c Ns = this.lFR.Ns(str);
            if (Ns == null || (Ns.hasMore && x.isEmpty(Ns.getDataList()))) {
                this.lFS.djn();
                r(str, null);
                this.lFR.Nt(str);
                this.lFS.scrollToPositionWithOffset(0, 0);
                return;
            }
            this.lFS.djm();
            r(str, Ns.getDataList());
            this.lFS.eU(Ns.getDataList());
            this.lFS.scrollToPositionWithOffset(Ns.lGr, Ns.scrollOffset);
        }
    }

    public void Nq(String str) {
        com.baidu.tieba.square.data.c Ns;
        Pair<Integer, Integer> djh;
        if (this.lFS != null && this.lFR != null && !TextUtils.isEmpty(str) && (Ns = this.lFR.Ns(str)) != null && (djh = this.lFS.djh()) != null) {
            Ns.lGr = ((Integer) djh.first).intValue();
            Ns.scrollOffset = ((Integer) djh.second).intValue();
        }
    }

    public String getClassName() {
        return this.lFU;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        ap apVar = new ap("c13650");
        apVar.t("uid", TbadkCoreApplication.getCurrentAccountId());
        TiebaStatic.log(apVar);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return "a073";
    }
}
