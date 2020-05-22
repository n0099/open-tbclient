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
    private ForumSquareModel lds;
    private a ldt;
    private b ldu;
    private String ldv = "";

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        V(getIntent());
        this.lds = new ForumSquareModel(this, this);
        this.ldt = new a(this);
        this.ldu = new b(this, this.ldt);
        this.ldu.dbD();
        bZS();
    }

    private void bZS() {
        this.ldt.dbx();
        this.lds.Mi(this.ldv);
    }

    private void V(Intent intent) {
        Uri uri;
        if (intent != null) {
            this.ldv = intent.getStringExtra(ForumSquareActivityConfig.FORUM_CLASS_NAME);
            if (TextUtils.isEmpty(this.ldv) && (uri = (Uri) intent.getParcelableExtra(IntentConfig.KEY_URI)) != null) {
                this.ldv = uri.getQueryParameter("tab_name");
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.ldt != null) {
            this.ldt.changeSkinType(i);
        }
    }

    @Override // com.baidu.tieba.square.c
    public void c(String str, List<String> list, List<o> list2) {
        boolean z = true;
        if (this.lds != null && this.ldt != null) {
            if (TextUtils.isEmpty(str) || str.equals(this.ldv)) {
                String dbu = this.ldt.dbu();
                if (TextUtils.isEmpty(str) || str.equals(dbu)) {
                    z = false;
                }
            }
            this.ldv = str;
            this.ldt.dby();
            this.ldt.b(str, list, z);
            this.ldt.q(list2, this.lds.r(list2, 300));
            r(str, list2);
        }
    }

    @Override // com.baidu.tieba.square.c
    public void a(String str, ErrorData errorData) {
        if (this.ldt != null && this.lds != null) {
            this.ldt.dby();
            com.baidu.tieba.square.data.c Mh = this.lds.Mh(str);
            if (Mh == null || (Mh.hasMore && v.isEmpty(Mh.getDataList()))) {
                this.ldt.brM();
                this.ldt.dbv();
                return;
            }
            this.ldt.ey(Mh.getDataList());
            r(str, Mh.getDataList());
        }
    }

    private void r(String str, List<o> list) {
        if (this.ldt != null && this.lds != null) {
            if (v.isEmpty(list)) {
                this.ldt.brM();
            } else if (v.getCount(list) < 10) {
                this.ldt.dbB();
            } else {
                this.ldt.uj(this.lds.Mj(str));
            }
        }
    }

    @Override // com.baidu.tieba.square.c
    public void b(ErrorData errorData) {
        if (this.ldt != null) {
            this.ldt.dbw();
        }
    }

    public void buV() {
        String className = getClassName();
        if (this.lds != null && this.ldt != null) {
            boolean isLoading = this.lds.isLoading();
            boolean uj = this.ldt.uj(this.lds.Mj(className));
            if (!isLoading && uj) {
                this.lds.Mi(className);
            }
        }
    }

    public void dbr() {
        if (this.ldt != null) {
            this.ldt.dbx();
        }
        if (this.lds != null) {
            this.lds.Mi(getClassName());
        }
    }

    public void Me(String str) {
        Mf(this.ldv);
        this.ldv = str;
        if (this.lds != null && this.ldt != null) {
            com.baidu.tieba.square.data.c Mh = this.lds.Mh(str);
            if (Mh == null || (Mh.hasMore && v.isEmpty(Mh.getDataList()))) {
                this.ldt.dbz();
                r(str, null);
                this.lds.Mi(str);
                this.ldt.scrollToPositionWithOffset(0, 0);
                return;
            }
            this.ldt.dby();
            r(str, Mh.getDataList());
            this.ldt.ey(Mh.getDataList());
            this.ldt.scrollToPositionWithOffset(Mh.ldS, Mh.dSG);
        }
    }

    public void Mf(String str) {
        com.baidu.tieba.square.data.c Mh;
        Pair<Integer, Integer> dbt;
        if (this.ldt != null && this.lds != null && !TextUtils.isEmpty(str) && (Mh = this.lds.Mh(str)) != null && (dbt = this.ldt.dbt()) != null) {
            Mh.ldS = ((Integer) dbt.first).intValue();
            Mh.dSG = ((Integer) dbt.second).intValue();
        }
    }

    public String getClassName() {
        return this.ldv;
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
