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
    private String lXA = "";
    private ForumSquareModel lXx;
    public b lXy;
    private c lXz;
    private final Context mContext;
    private final TbPageContext mTbPageContext;

    public a(Context context, TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.mContext = context;
        this.lXx = new ForumSquareModel(context, this);
        this.lXy = new b(context, this.mTbPageContext);
    }

    public void startLoadData() {
        this.lXz = new c(this.mContext, this, this.lXy);
        this.lXz.duO();
        crt();
    }

    private void crt() {
        this.lXy.duI();
        this.lXx.Qu(this.lXA);
    }

    public void duC() {
        this.lXy.duC();
    }

    @Override // com.baidu.tieba.square.d
    public void d(String str, List<String> list, List<q> list2) {
        boolean z = true;
        if (this.lXx != null && this.lXy != null) {
            if (TextUtils.isEmpty(str) || str.equals(this.lXA)) {
                String duF = this.lXy.duF();
                if (TextUtils.isEmpty(str) || str.equals(duF)) {
                    z = false;
                }
            }
            this.lXA = str;
            this.lXy.duJ();
            this.lXy.c(str, list, z);
            this.lXy.s(list2, this.lXx.t(list2, 300));
            q(str, list2);
        }
    }

    private void q(String str, List<q> list) {
        if (this.lXy != null && this.lXx != null) {
            if (y.isEmpty(list)) {
                this.lXy.bGT();
            } else if (y.getCount(list) < 10) {
                this.lXy.duM();
            } else {
                this.lXy.vR(this.lXx.Qv(str));
            }
        }
    }

    @Override // com.baidu.tieba.square.d
    public void a(String str, ErrorData errorData) {
        if (this.lXy != null && this.lXx != null) {
            this.lXy.duJ();
            com.baidu.tieba.square.data.c Qt = this.lXx.Qt(str);
            if (Qt == null || (Qt.hasMore && y.isEmpty(Qt.getDataList()))) {
                this.lXy.bGT();
                this.lXy.duG();
                return;
            }
            this.lXy.fc(Qt.getDataList());
            q(str, Qt.getDataList());
        }
    }

    @Override // com.baidu.tieba.square.d
    public void e(ErrorData errorData) {
        if (this.lXy != null) {
            this.lXy.duH();
        }
    }

    public void bKC() {
        String className = getClassName();
        if (this.lXx != null && this.lXy != null) {
            boolean isLoading = this.lXx.isLoading();
            boolean vR = this.lXy.vR(this.lXx.Qv(className));
            if (!isLoading && vR) {
                this.lXx.Qu(className);
            }
        }
    }

    public void duD() {
        if (this.lXy != null) {
            this.lXy.duI();
        }
        if (this.lXx != null) {
            this.lXx.Qu(getClassName());
        }
    }

    public void Qn(String str) {
        Qo(this.lXA);
        this.lXA = str;
        if (this.lXx != null && this.lXy != null) {
            com.baidu.tieba.square.data.c Qt = this.lXx.Qt(str);
            if (Qt == null || (Qt.hasMore && y.isEmpty(Qt.getDataList()))) {
                this.lXy.duK();
                q(str, null);
                this.lXx.Qu(str);
                this.lXy.scrollToPositionWithOffset(0, 0);
                return;
            }
            this.lXy.duJ();
            q(str, Qt.getDataList());
            this.lXy.fc(Qt.getDataList());
            this.lXy.scrollToPositionWithOffset(Qt.lXX, Qt.scrollOffset);
        }
    }

    public void Qo(String str) {
        com.baidu.tieba.square.data.c Qt;
        Pair<Integer, Integer> duE;
        if (this.lXy != null && this.lXx != null && !TextUtils.isEmpty(str) && (Qt = this.lXx.Qt(str)) != null && (duE = this.lXy.duE()) != null) {
            Qt.lXX = ((Integer) duE.first).intValue();
            Qt.scrollOffset = ((Integer) duE.second).intValue();
        }
    }

    public String getClassName() {
        return this.lXA;
    }

    public void Y(Intent intent) {
        Uri uri;
        if (intent != null) {
            this.lXA = intent.getStringExtra(ForumSquareActivityConfig.FORUM_CLASS_NAME);
            if (TextUtils.isEmpty(this.lXA) && (uri = (Uri) intent.getParcelableExtra(IntentConfig.KEY_URI)) != null) {
                this.lXA = uri.getQueryParameter("tab_name");
            }
        }
    }

    public void Qp(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.lXy.Qq(str);
            Qn(str);
        }
    }
}
