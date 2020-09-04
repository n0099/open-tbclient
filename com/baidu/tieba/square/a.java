package com.baidu.tieba.square;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Pair;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.ForumSquareActivityConfig;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.square.model.ForumSquareModel;
import java.util.List;
/* loaded from: classes16.dex */
public class a implements d {
    private ForumSquareModel lXM;
    public b lXN;
    private c lXO;
    private String lXP = "";
    private final Context mContext;
    private final TbPageContext mTbPageContext;

    public a(Context context, TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.mContext = context;
        this.lXM = new ForumSquareModel(context, this);
        this.lXN = new b(context, this.mTbPageContext);
    }

    public void startLoadData() {
        this.lXO = new c(this.mContext, this, this.lXN);
        this.lXO.duT();
        cru();
    }

    private void cru() {
        this.lXN.duN();
        this.lXM.Qu(this.lXP);
    }

    public void duH() {
        this.lXN.duH();
    }

    @Override // com.baidu.tieba.square.d
    public void d(String str, List<String> list, List<q> list2) {
        boolean z = true;
        if (this.lXM != null && this.lXN != null) {
            if (TextUtils.isEmpty(str) || str.equals(this.lXP)) {
                String duK = this.lXN.duK();
                if (TextUtils.isEmpty(str) || str.equals(duK)) {
                    z = false;
                }
            }
            this.lXP = str;
            this.lXN.duO();
            this.lXN.c(str, list, z);
            this.lXN.s(list2, this.lXM.t(list2, 300));
            q(str, list2);
        }
    }

    private void q(String str, List<q> list) {
        if (this.lXN != null && this.lXM != null) {
            if (y.isEmpty(list)) {
                this.lXN.bGU();
            } else if (y.getCount(list) < 10) {
                this.lXN.duR();
            } else {
                this.lXN.vT(this.lXM.Qv(str));
            }
        }
    }

    @Override // com.baidu.tieba.square.d
    public void a(String str, ErrorData errorData) {
        if (this.lXN != null && this.lXM != null) {
            this.lXN.duO();
            com.baidu.tieba.square.data.c Qt = this.lXM.Qt(str);
            if (Qt == null || (Qt.hasMore && y.isEmpty(Qt.getDataList()))) {
                this.lXN.bGU();
                this.lXN.duL();
                return;
            }
            this.lXN.fc(Qt.getDataList());
            q(str, Qt.getDataList());
        }
    }

    @Override // com.baidu.tieba.square.d
    public void e(ErrorData errorData) {
        if (this.lXN != null) {
            this.lXN.duM();
        }
    }

    public void bKD() {
        String className = getClassName();
        if (this.lXM != null && this.lXN != null) {
            boolean isLoading = this.lXM.isLoading();
            boolean vT = this.lXN.vT(this.lXM.Qv(className));
            if (!isLoading && vT) {
                this.lXM.Qu(className);
            }
        }
    }

    public void duI() {
        if (this.lXN != null) {
            this.lXN.duN();
        }
        if (this.lXM != null) {
            this.lXM.Qu(getClassName());
        }
    }

    public void Qn(String str) {
        Qo(this.lXP);
        this.lXP = str;
        if (this.lXM != null && this.lXN != null) {
            com.baidu.tieba.square.data.c Qt = this.lXM.Qt(str);
            if (Qt == null || (Qt.hasMore && y.isEmpty(Qt.getDataList()))) {
                this.lXN.duP();
                q(str, null);
                this.lXM.Qu(str);
                this.lXN.scrollToPositionWithOffset(0, 0);
                return;
            }
            this.lXN.duO();
            q(str, Qt.getDataList());
            this.lXN.fc(Qt.getDataList());
            this.lXN.scrollToPositionWithOffset(Qt.lYm, Qt.scrollOffset);
        }
    }

    public void Qo(String str) {
        com.baidu.tieba.square.data.c Qt;
        Pair<Integer, Integer> duJ;
        if (this.lXN != null && this.lXM != null && !TextUtils.isEmpty(str) && (Qt = this.lXM.Qt(str)) != null && (duJ = this.lXN.duJ()) != null) {
            Qt.lYm = ((Integer) duJ.first).intValue();
            Qt.scrollOffset = ((Integer) duJ.second).intValue();
        }
    }

    public String getClassName() {
        return this.lXP;
    }

    public void Y(Intent intent) {
        Uri uri;
        if (intent != null) {
            this.lXP = intent.getStringExtra(ForumSquareActivityConfig.FORUM_CLASS_NAME);
            if (TextUtils.isEmpty(this.lXP) && (uri = (Uri) intent.getParcelableExtra(IntentConfig.KEY_URI)) != null) {
                this.lXP = uri.getQueryParameter("tab_name");
            }
        }
    }

    public void Qp(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.lXN.Qq(str);
            Qn(str);
        }
    }
}
