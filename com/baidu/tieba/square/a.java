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
/* loaded from: classes21.dex */
public class a implements d {
    private final Context mContext;
    private final TbPageContext mTbPageContext;
    private ForumSquareModel mhn;
    public b mho;
    private c mhp;
    private String mhq = "";

    public a(Context context, TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.mContext = context;
        this.mhn = new ForumSquareModel(context, this);
        this.mho = new b(context, this.mTbPageContext);
    }

    public void startLoadData() {
        this.mhp = new c(this.mContext, this, this.mho);
        this.mhp.dyM();
        cuJ();
    }

    private void cuJ() {
        this.mho.dyG();
        this.mhn.QU(this.mhq);
    }

    public void dyA() {
        this.mho.dyA();
    }

    @Override // com.baidu.tieba.square.d
    public void d(String str, List<String> list, List<q> list2) {
        boolean z = true;
        if (this.mhn != null && this.mho != null) {
            if (TextUtils.isEmpty(str) || str.equals(this.mhq)) {
                String dyD = this.mho.dyD();
                if (TextUtils.isEmpty(str) || str.equals(dyD)) {
                    z = false;
                }
            }
            this.mhq = str;
            this.mho.dyH();
            this.mho.c(str, list, z);
            this.mho.s(list2, this.mhn.t(list2, 300));
            q(str, list2);
        }
    }

    private void q(String str, List<q> list) {
        if (this.mho != null && this.mhn != null) {
            if (y.isEmpty(list)) {
                this.mho.bIk();
            } else if (y.getCount(list) < 10) {
                this.mho.dyK();
            } else {
                this.mho.wc(this.mhn.QV(str));
            }
        }
    }

    @Override // com.baidu.tieba.square.d
    public void a(String str, ErrorData errorData) {
        if (this.mho != null && this.mhn != null) {
            this.mho.dyH();
            com.baidu.tieba.square.data.c QT = this.mhn.QT(str);
            if (QT == null || (QT.hasMore && y.isEmpty(QT.getDataList()))) {
                this.mho.bIk();
                this.mho.dyE();
                return;
            }
            this.mho.fl(QT.getDataList());
            q(str, QT.getDataList());
        }
    }

    @Override // com.baidu.tieba.square.d
    public void e(ErrorData errorData) {
        if (this.mho != null) {
            this.mho.dyF();
        }
    }

    public void bLN() {
        String className = getClassName();
        if (this.mhn != null && this.mho != null) {
            boolean isLoading = this.mhn.isLoading();
            boolean wc = this.mho.wc(this.mhn.QV(className));
            if (!isLoading && wc) {
                this.mhn.QU(className);
            }
        }
    }

    public void dyB() {
        if (this.mho != null) {
            this.mho.dyG();
        }
        if (this.mhn != null) {
            this.mhn.QU(getClassName());
        }
    }

    public void QN(String str) {
        QO(this.mhq);
        this.mhq = str;
        if (this.mhn != null && this.mho != null) {
            com.baidu.tieba.square.data.c QT = this.mhn.QT(str);
            if (QT == null || (QT.hasMore && y.isEmpty(QT.getDataList()))) {
                this.mho.dyI();
                q(str, null);
                this.mhn.QU(str);
                this.mho.scrollToPositionWithOffset(0, 0);
                return;
            }
            this.mho.dyH();
            q(str, QT.getDataList());
            this.mho.fl(QT.getDataList());
            this.mho.scrollToPositionWithOffset(QT.mhO, QT.scrollOffset);
        }
    }

    public void QO(String str) {
        com.baidu.tieba.square.data.c QT;
        Pair<Integer, Integer> dyC;
        if (this.mho != null && this.mhn != null && !TextUtils.isEmpty(str) && (QT = this.mhn.QT(str)) != null && (dyC = this.mho.dyC()) != null) {
            QT.mhO = ((Integer) dyC.first).intValue();
            QT.scrollOffset = ((Integer) dyC.second).intValue();
        }
    }

    public String getClassName() {
        return this.mhq;
    }

    public void X(Intent intent) {
        Uri uri;
        if (intent != null) {
            this.mhq = intent.getStringExtra(ForumSquareActivityConfig.FORUM_CLASS_NAME);
            if (TextUtils.isEmpty(this.mhq) && (uri = (Uri) intent.getParcelableExtra(IntentConfig.KEY_URI)) != null) {
                this.mhq = uri.getQueryParameter("tab_name");
            }
            this.mho.wb(intent.getIntExtra(ForumSquareActivityConfig.SHOW_CREATE_BAR, 0) == 0);
        }
    }

    public void QP(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.mho.QQ(str);
            QN(str);
        }
    }
}
