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
    private ForumSquareModel npg;
    public b nph;
    private c npi;
    private String npj = "";

    public a(Context context, TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.mContext = context;
        this.npg = new ForumSquareModel(context, this);
        this.nph = new b(context, this.mTbPageContext);
    }

    public void startLoadData() {
        this.npi = new c(this.mContext, this, this.nph);
        this.npi.dLB();
        cJc();
    }

    private void cJc() {
        this.nph.dLv();
        this.npg.SL(this.npj);
    }

    public void dLp() {
        this.nph.dLp();
    }

    @Override // com.baidu.tieba.square.d
    public void d(String str, List<String> list, List<n> list2) {
        boolean z = true;
        if (this.npg != null && this.nph != null) {
            if (TextUtils.isEmpty(str) || str.equals(this.npj)) {
                String dLs = this.nph.dLs();
                if (TextUtils.isEmpty(str) || str.equals(dLs)) {
                    z = false;
                }
            }
            this.npj = str;
            this.nph.dLw();
            this.nph.e(str, list, z);
            this.nph.v(list2, this.npg.w(list2, 300));
            r(str, list2);
        }
    }

    private void r(String str, List<n> list) {
        if (this.nph != null && this.npg != null) {
            if (y.isEmpty(list)) {
                this.nph.bSr();
            } else if (y.getCount(list) < 10) {
                this.nph.dLz();
            } else {
                this.nph.yi(this.npg.SM(str));
            }
        }
    }

    @Override // com.baidu.tieba.square.d
    public void a(String str, ErrorData errorData) {
        if (this.nph != null && this.npg != null) {
            this.nph.dLw();
            com.baidu.tieba.square.data.c SK = this.npg.SK(str);
            if (SK == null || (SK.hasMore && y.isEmpty(SK.getDataList()))) {
                this.nph.bSr();
                this.nph.dLt();
                return;
            }
            this.nph.fQ(SK.getDataList());
            r(str, SK.getDataList());
        }
    }

    @Override // com.baidu.tieba.square.d
    public void e(ErrorData errorData) {
        if (this.nph != null) {
            this.nph.dLu();
        }
    }

    public void bVX() {
        String className = getClassName();
        if (this.npg != null && this.nph != null) {
            boolean isLoading = this.npg.isLoading();
            boolean yi = this.nph.yi(this.npg.SM(className));
            if (!isLoading && yi) {
                this.npg.SL(className);
            }
        }
    }

    public void dLq() {
        if (this.nph != null) {
            this.nph.dLv();
        }
        if (this.npg != null) {
            this.npg.SL(getClassName());
        }
    }

    public void SE(String str) {
        SF(this.npj);
        this.npj = str;
        if (this.npg != null && this.nph != null) {
            com.baidu.tieba.square.data.c SK = this.npg.SK(str);
            if (SK == null || (SK.hasMore && y.isEmpty(SK.getDataList()))) {
                this.nph.dLx();
                r(str, null);
                this.npg.SL(str);
                this.nph.scrollToPositionWithOffset(0, 0);
                return;
            }
            this.nph.dLw();
            r(str, SK.getDataList());
            this.nph.fQ(SK.getDataList());
            this.nph.scrollToPositionWithOffset(SK.npH, SK.ffr);
        }
    }

    public void SF(String str) {
        com.baidu.tieba.square.data.c SK;
        Pair<Integer, Integer> dLr;
        if (this.nph != null && this.npg != null && !TextUtils.isEmpty(str) && (SK = this.npg.SK(str)) != null && (dLr = this.nph.dLr()) != null) {
            SK.npH = ((Integer) dLr.first).intValue();
            SK.ffr = ((Integer) dLr.second).intValue();
        }
    }

    public String getClassName() {
        return this.npj;
    }

    public void W(Intent intent) {
        Uri uri;
        if (intent != null) {
            this.npj = intent.getStringExtra(ForumSquareActivityConfig.FORUM_CLASS_NAME);
            if (TextUtils.isEmpty(this.npj) && (uri = (Uri) intent.getParcelableExtra(IntentConfig.KEY_URI)) != null) {
                this.npj = uri.getQueryParameter("tab_name");
            }
            this.nph.yh(intent.getIntExtra(ForumSquareActivityConfig.SHOW_CREATE_BAR, 0) == 0);
        }
    }

    public void SG(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.nph.SH(str);
            SE(str);
        }
    }
}
