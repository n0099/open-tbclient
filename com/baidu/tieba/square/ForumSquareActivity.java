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
    private ForumSquareModel lFP;
    private a lFQ;
    private b lFR;
    private String lFS = "";

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        W(getIntent());
        this.lFP = new ForumSquareModel(this, this);
        this.lFQ = new a(this);
        this.lFR = new b(this, this.lFQ);
        this.lFR.djr();
        cgO();
    }

    private void cgO() {
        this.lFQ.djl();
        this.lFP.Nt(this.lFS);
    }

    private void W(Intent intent) {
        Uri uri;
        if (intent != null) {
            this.lFS = intent.getStringExtra(ForumSquareActivityConfig.FORUM_CLASS_NAME);
            if (TextUtils.isEmpty(this.lFS) && (uri = (Uri) intent.getParcelableExtra(IntentConfig.KEY_URI)) != null) {
                this.lFS = uri.getQueryParameter("tab_name");
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.lFQ != null) {
            this.lFQ.changeSkinType(i);
        }
    }

    @Override // com.baidu.tieba.square.c
    public void c(String str, List<String> list, List<q> list2) {
        boolean z = true;
        if (this.lFP != null && this.lFQ != null) {
            if (TextUtils.isEmpty(str) || str.equals(this.lFS)) {
                String dji = this.lFQ.dji();
                if (TextUtils.isEmpty(str) || str.equals(dji)) {
                    z = false;
                }
            }
            this.lFS = str;
            this.lFQ.djm();
            this.lFQ.b(str, list, z);
            this.lFQ.p(list2, this.lFP.q(list2, 300));
            r(str, list2);
        }
    }

    @Override // com.baidu.tieba.square.c
    public void a(String str, ErrorData errorData) {
        if (this.lFQ != null && this.lFP != null) {
            this.lFQ.djm();
            com.baidu.tieba.square.data.c Ns = this.lFP.Ns(str);
            if (Ns == null || (Ns.hasMore && x.isEmpty(Ns.getDataList()))) {
                this.lFQ.bxU();
                this.lFQ.djj();
                return;
            }
            this.lFQ.eU(Ns.getDataList());
            r(str, Ns.getDataList());
        }
    }

    private void r(String str, List<q> list) {
        if (this.lFQ != null && this.lFP != null) {
            if (x.isEmpty(list)) {
                this.lFQ.bxU();
            } else if (x.getCount(list) < 10) {
                this.lFQ.djp();
            } else {
                this.lFQ.vc(this.lFP.Nu(str));
            }
        }
    }

    @Override // com.baidu.tieba.square.c
    public void e(ErrorData errorData) {
        if (this.lFQ != null) {
            this.lFQ.djk();
        }
    }

    public void bBi() {
        String className = getClassName();
        if (this.lFP != null && this.lFQ != null) {
            boolean isLoading = this.lFP.isLoading();
            boolean vc = this.lFQ.vc(this.lFP.Nu(className));
            if (!isLoading && vc) {
                this.lFP.Nt(className);
            }
        }
    }

    public void djg() {
        if (this.lFQ != null) {
            this.lFQ.djl();
        }
        if (this.lFP != null) {
            this.lFP.Nt(getClassName());
        }
    }

    public void Np(String str) {
        Nq(this.lFS);
        this.lFS = str;
        if (this.lFP != null && this.lFQ != null) {
            com.baidu.tieba.square.data.c Ns = this.lFP.Ns(str);
            if (Ns == null || (Ns.hasMore && x.isEmpty(Ns.getDataList()))) {
                this.lFQ.djn();
                r(str, null);
                this.lFP.Nt(str);
                this.lFQ.scrollToPositionWithOffset(0, 0);
                return;
            }
            this.lFQ.djm();
            r(str, Ns.getDataList());
            this.lFQ.eU(Ns.getDataList());
            this.lFQ.scrollToPositionWithOffset(Ns.lGp, Ns.scrollOffset);
        }
    }

    public void Nq(String str) {
        com.baidu.tieba.square.data.c Ns;
        Pair<Integer, Integer> djh;
        if (this.lFQ != null && this.lFP != null && !TextUtils.isEmpty(str) && (Ns = this.lFP.Ns(str)) != null && (djh = this.lFQ.djh()) != null) {
            Ns.lGp = ((Integer) djh.first).intValue();
            Ns.scrollOffset = ((Integer) djh.second).intValue();
        }
    }

    public String getClassName() {
        return this.lFS;
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
