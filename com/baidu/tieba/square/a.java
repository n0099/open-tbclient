package com.baidu.tieba.square;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Pair;
import com.baidu.adp.widget.ListView.n;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.ForumSquareActivityConfig;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.square.model.ForumSquareModel;
import java.util.List;
/* loaded from: classes2.dex */
public class a implements d {
    private final Context mContext;
    private final TbPageContext mTbPageContext;
    private ForumSquareModel npG;
    public b npH;
    private c npI;
    private String npJ = "";

    public a(Context context, TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.mContext = context;
        this.npG = new ForumSquareModel(context, this);
        this.npH = new b(context, this.mTbPageContext);
    }

    public void startLoadData() {
        this.npI = new c(this.mContext, this, this.npH);
        this.npI.dLJ();
        cJj();
    }

    private void cJj() {
        this.npH.dLD();
        this.npG.SX(this.npJ);
    }

    public void dLx() {
        this.npH.dLx();
    }

    @Override // com.baidu.tieba.square.d
    public void d(String str, List<String> list, List<n> list2) {
        boolean z = true;
        if (this.npG != null && this.npH != null) {
            if (TextUtils.isEmpty(str) || str.equals(this.npJ)) {
                String dLA = this.npH.dLA();
                if (TextUtils.isEmpty(str) || str.equals(dLA)) {
                    z = false;
                }
            }
            this.npJ = str;
            this.npH.dLE();
            this.npH.e(str, list, z);
            this.npH.v(list2, this.npG.w(list2, 300));
            r(str, list2);
        }
    }

    private void r(String str, List<n> list) {
        if (this.npH != null && this.npG != null) {
            if (y.isEmpty(list)) {
                this.npH.bSy();
            } else if (y.getCount(list) < 10) {
                this.npH.dLH();
            } else {
                this.npH.yi(this.npG.SY(str));
            }
        }
    }

    @Override // com.baidu.tieba.square.d
    public void a(String str, ErrorData errorData) {
        if (this.npH != null && this.npG != null) {
            this.npH.dLE();
            com.baidu.tieba.square.data.c SW = this.npG.SW(str);
            if (SW == null || (SW.hasMore && y.isEmpty(SW.getDataList()))) {
                this.npH.bSy();
                this.npH.dLB();
                return;
            }
            this.npH.fQ(SW.getDataList());
            r(str, SW.getDataList());
        }
    }

    @Override // com.baidu.tieba.square.d
    public void e(ErrorData errorData) {
        if (this.npH != null) {
            this.npH.dLC();
        }
    }

    public void bWe() {
        String className = getClassName();
        if (this.npG != null && this.npH != null) {
            boolean isLoading = this.npG.isLoading();
            boolean yi = this.npH.yi(this.npG.SY(className));
            if (!isLoading && yi) {
                this.npG.SX(className);
            }
        }
    }

    public void dLy() {
        if (this.npH != null) {
            this.npH.dLD();
        }
        if (this.npG != null) {
            this.npG.SX(getClassName());
        }
    }

    public void SQ(String str) {
        SR(this.npJ);
        this.npJ = str;
        if (this.npG != null && this.npH != null) {
            com.baidu.tieba.square.data.c SW = this.npG.SW(str);
            if (SW == null || (SW.hasMore && y.isEmpty(SW.getDataList()))) {
                this.npH.dLF();
                r(str, null);
                this.npG.SX(str);
                this.npH.scrollToPositionWithOffset(0, 0);
                return;
            }
            this.npH.dLE();
            r(str, SW.getDataList());
            this.npH.fQ(SW.getDataList());
            this.npH.scrollToPositionWithOffset(SW.nqh, SW.ffr);
        }
    }

    public void SR(String str) {
        com.baidu.tieba.square.data.c SW;
        Pair<Integer, Integer> dLz;
        if (this.npH != null && this.npG != null && !TextUtils.isEmpty(str) && (SW = this.npG.SW(str)) != null && (dLz = this.npH.dLz()) != null) {
            SW.nqh = ((Integer) dLz.first).intValue();
            SW.ffr = ((Integer) dLz.second).intValue();
        }
    }

    public String getClassName() {
        return this.npJ;
    }

    public void W(Intent intent) {
        Uri uri;
        if (intent != null) {
            this.npJ = intent.getStringExtra(ForumSquareActivityConfig.FORUM_CLASS_NAME);
            if (TextUtils.isEmpty(this.npJ) && (uri = (Uri) intent.getParcelableExtra(IntentConfig.KEY_URI)) != null) {
                this.npJ = uri.getQueryParameter("tab_name");
            }
            this.npH.yh(intent.getIntExtra(ForumSquareActivityConfig.SHOW_CREATE_BAR, 0) == 0);
        }
    }

    public void SS(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.npH.ST(str);
            SQ(str);
        }
    }
}
