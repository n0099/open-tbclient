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
    private ForumSquareModel nrK;
    public b nrL;
    private c nrM;
    private String nrN = "";

    public a(Context context, TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.mContext = context;
        this.nrK = new ForumSquareModel(context, this);
        this.nrL = new b(context, this.mTbPageContext);
    }

    public void startLoadData() {
        this.nrM = new c(this.mContext, this, this.nrL);
        this.nrM.dLR();
        cJp();
    }

    private void cJp() {
        this.nrL.dLL();
        this.nrK.Td(this.nrN);
    }

    public void dLF() {
        this.nrL.dLF();
    }

    @Override // com.baidu.tieba.square.d
    public void d(String str, List<String> list, List<n> list2) {
        boolean z = true;
        if (this.nrK != null && this.nrL != null) {
            if (TextUtils.isEmpty(str) || str.equals(this.nrN)) {
                String dLI = this.nrL.dLI();
                if (TextUtils.isEmpty(str) || str.equals(dLI)) {
                    z = false;
                }
            }
            this.nrN = str;
            this.nrL.dLM();
            this.nrL.e(str, list, z);
            this.nrL.v(list2, this.nrK.w(list2, 300));
            r(str, list2);
        }
    }

    private void r(String str, List<n> list) {
        if (this.nrL != null && this.nrK != null) {
            if (y.isEmpty(list)) {
                this.nrL.bSE();
            } else if (y.getCount(list) < 10) {
                this.nrL.dLP();
            } else {
                this.nrL.yi(this.nrK.Te(str));
            }
        }
    }

    @Override // com.baidu.tieba.square.d
    public void a(String str, ErrorData errorData) {
        if (this.nrL != null && this.nrK != null) {
            this.nrL.dLM();
            com.baidu.tieba.square.data.c Tc = this.nrK.Tc(str);
            if (Tc == null || (Tc.hasMore && y.isEmpty(Tc.getDataList()))) {
                this.nrL.bSE();
                this.nrL.dLJ();
                return;
            }
            this.nrL.fQ(Tc.getDataList());
            r(str, Tc.getDataList());
        }
    }

    @Override // com.baidu.tieba.square.d
    public void e(ErrorData errorData) {
        if (this.nrL != null) {
            this.nrL.dLK();
        }
    }

    public void bWk() {
        String className = getClassName();
        if (this.nrK != null && this.nrL != null) {
            boolean isLoading = this.nrK.isLoading();
            boolean yi = this.nrL.yi(this.nrK.Te(className));
            if (!isLoading && yi) {
                this.nrK.Td(className);
            }
        }
    }

    public void dLG() {
        if (this.nrL != null) {
            this.nrL.dLL();
        }
        if (this.nrK != null) {
            this.nrK.Td(getClassName());
        }
    }

    public void SW(String str) {
        SX(this.nrN);
        this.nrN = str;
        if (this.nrK != null && this.nrL != null) {
            com.baidu.tieba.square.data.c Tc = this.nrK.Tc(str);
            if (Tc == null || (Tc.hasMore && y.isEmpty(Tc.getDataList()))) {
                this.nrL.dLN();
                r(str, null);
                this.nrK.Td(str);
                this.nrL.scrollToPositionWithOffset(0, 0);
                return;
            }
            this.nrL.dLM();
            r(str, Tc.getDataList());
            this.nrL.fQ(Tc.getDataList());
            this.nrL.scrollToPositionWithOffset(Tc.nsl, Tc.fgQ);
        }
    }

    public void SX(String str) {
        com.baidu.tieba.square.data.c Tc;
        Pair<Integer, Integer> dLH;
        if (this.nrL != null && this.nrK != null && !TextUtils.isEmpty(str) && (Tc = this.nrK.Tc(str)) != null && (dLH = this.nrL.dLH()) != null) {
            Tc.nsl = ((Integer) dLH.first).intValue();
            Tc.fgQ = ((Integer) dLH.second).intValue();
        }
    }

    public String getClassName() {
        return this.nrN;
    }

    public void W(Intent intent) {
        Uri uri;
        if (intent != null) {
            this.nrN = intent.getStringExtra(ForumSquareActivityConfig.FORUM_CLASS_NAME);
            if (TextUtils.isEmpty(this.nrN) && (uri = (Uri) intent.getParcelableExtra(IntentConfig.KEY_URI)) != null) {
                this.nrN = uri.getQueryParameter("tab_name");
            }
            this.nrL.yh(intent.getIntExtra(ForumSquareActivityConfig.SHOW_CREATE_BAR, 0) == 0);
        }
    }

    public void SY(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.nrL.SZ(str);
            SW(str);
        }
    }
}
