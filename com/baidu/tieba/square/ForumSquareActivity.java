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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.square.model.ForumSquareModel;
import java.util.List;
/* loaded from: classes9.dex */
public class ForumSquareActivity extends BaseActivity<ForumSquareActivity> implements c {
    private a lyA;
    private b lyB;
    private String lyC = "";
    private ForumSquareModel lyz;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        V(getIntent());
        this.lyz = new ForumSquareModel(this, this);
        this.lyA = new a(this);
        this.lyB = new b(this, this.lyA);
        this.lyB.dgh();
        cdo();
    }

    private void cdo() {
        this.lyA.dgb();
        this.lyz.ML(this.lyC);
    }

    private void V(Intent intent) {
        Uri uri;
        if (intent != null) {
            this.lyC = intent.getStringExtra(ForumSquareActivityConfig.FORUM_CLASS_NAME);
            if (TextUtils.isEmpty(this.lyC) && (uri = (Uri) intent.getParcelableExtra(IntentConfig.KEY_URI)) != null) {
                this.lyC = uri.getQueryParameter("tab_name");
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.lyA != null) {
            this.lyA.changeSkinType(i);
        }
    }

    @Override // com.baidu.tieba.square.c
    public void c(String str, List<String> list, List<q> list2) {
        boolean z = true;
        if (this.lyz != null && this.lyA != null) {
            if (TextUtils.isEmpty(str) || str.equals(this.lyC)) {
                String dfY = this.lyA.dfY();
                if (TextUtils.isEmpty(str) || str.equals(dfY)) {
                    z = false;
                }
            }
            this.lyC = str;
            this.lyA.dgc();
            this.lyA.b(str, list, z);
            this.lyA.r(list2, this.lyz.s(list2, 300));
            r(str, list2);
        }
    }

    @Override // com.baidu.tieba.square.c
    public void a(String str, ErrorData errorData) {
        if (this.lyA != null && this.lyz != null) {
            this.lyA.dgc();
            com.baidu.tieba.square.data.c MK = this.lyz.MK(str);
            if (MK == null || (MK.hasMore && w.isEmpty(MK.getDataList()))) {
                this.lyA.buK();
                this.lyA.dfZ();
                return;
            }
            this.lyA.eO(MK.getDataList());
            r(str, MK.getDataList());
        }
    }

    private void r(String str, List<q> list) {
        if (this.lyA != null && this.lyz != null) {
            if (w.isEmpty(list)) {
                this.lyA.buK();
            } else if (w.getCount(list) < 10) {
                this.lyA.dgf();
            } else {
                this.lyA.uy(this.lyz.MM(str));
            }
        }
    }

    @Override // com.baidu.tieba.square.c
    public void e(ErrorData errorData) {
        if (this.lyA != null) {
            this.lyA.dga();
        }
    }

    public void bxS() {
        String className = getClassName();
        if (this.lyz != null && this.lyA != null) {
            boolean isLoading = this.lyz.isLoading();
            boolean uy = this.lyA.uy(this.lyz.MM(className));
            if (!isLoading && uy) {
                this.lyz.ML(className);
            }
        }
    }

    public void dfW() {
        if (this.lyA != null) {
            this.lyA.dgb();
        }
        if (this.lyz != null) {
            this.lyz.ML(getClassName());
        }
    }

    public void MH(String str) {
        MI(this.lyC);
        this.lyC = str;
        if (this.lyz != null && this.lyA != null) {
            com.baidu.tieba.square.data.c MK = this.lyz.MK(str);
            if (MK == null || (MK.hasMore && w.isEmpty(MK.getDataList()))) {
                this.lyA.dgd();
                r(str, null);
                this.lyz.ML(str);
                this.lyA.scrollToPositionWithOffset(0, 0);
                return;
            }
            this.lyA.dgc();
            r(str, MK.getDataList());
            this.lyA.eO(MK.getDataList());
            this.lyA.scrollToPositionWithOffset(MK.lyZ, MK.dZy);
        }
    }

    public void MI(String str) {
        com.baidu.tieba.square.data.c MK;
        Pair<Integer, Integer> dfX;
        if (this.lyA != null && this.lyz != null && !TextUtils.isEmpty(str) && (MK = this.lyz.MK(str)) != null && (dfX = this.lyA.dfX()) != null) {
            MK.lyZ = ((Integer) dfX.first).intValue();
            MK.dZy = ((Integer) dfX.second).intValue();
        }
    }

    public String getClassName() {
        return this.lyC;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        ao aoVar = new ao("c13650");
        aoVar.s("uid", TbadkCoreApplication.getCurrentAccountId());
        TiebaStatic.log(aoVar);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return "a073";
    }
}
