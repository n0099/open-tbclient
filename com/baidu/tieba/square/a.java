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
/* loaded from: classes22.dex */
public class a implements d {
    private final Context mContext;
    private ForumSquareModel mJA;
    public b mJB;
    private c mJC;
    private String mJD = "";
    private final TbPageContext mTbPageContext;

    public a(Context context, TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.mContext = context;
        this.mJA = new ForumSquareModel(context, this);
        this.mJB = new b(context, this.mTbPageContext);
    }

    public void startLoadData() {
        this.mJC = new c(this.mContext, this, this.mJB);
        this.mJC.dFF();
        cBn();
    }

    private void cBn() {
        this.mJB.dFz();
        this.mJA.Sh(this.mJD);
    }

    public void dFt() {
        this.mJB.dFt();
    }

    @Override // com.baidu.tieba.square.d
    public void d(String str, List<String> list, List<q> list2) {
        boolean z = true;
        if (this.mJA != null && this.mJB != null) {
            if (TextUtils.isEmpty(str) || str.equals(this.mJD)) {
                String dFw = this.mJB.dFw();
                if (TextUtils.isEmpty(str) || str.equals(dFw)) {
                    z = false;
                }
            }
            this.mJD = str;
            this.mJB.dFA();
            this.mJB.c(str, list, z);
            this.mJB.v(list2, this.mJA.w(list2, 300));
            q(str, list2);
        }
    }

    private void q(String str, List<q> list) {
        if (this.mJB != null && this.mJA != null) {
            if (y.isEmpty(list)) {
                this.mJB.bNw();
            } else if (y.getCount(list) < 10) {
                this.mJB.dFD();
            } else {
                this.mJB.xa(this.mJA.Si(str));
            }
        }
    }

    @Override // com.baidu.tieba.square.d
    public void a(String str, ErrorData errorData) {
        if (this.mJB != null && this.mJA != null) {
            this.mJB.dFA();
            com.baidu.tieba.square.data.c Sg = this.mJA.Sg(str);
            if (Sg == null || (Sg.hasMore && y.isEmpty(Sg.getDataList()))) {
                this.mJB.bNw();
                this.mJB.dFx();
                return;
            }
            this.mJB.fx(Sg.getDataList());
            q(str, Sg.getDataList());
        }
    }

    @Override // com.baidu.tieba.square.d
    public void e(ErrorData errorData) {
        if (this.mJB != null) {
            this.mJB.dFy();
        }
    }

    public void bRc() {
        String className = getClassName();
        if (this.mJA != null && this.mJB != null) {
            boolean isLoading = this.mJA.isLoading();
            boolean xa = this.mJB.xa(this.mJA.Si(className));
            if (!isLoading && xa) {
                this.mJA.Sh(className);
            }
        }
    }

    public void dFu() {
        if (this.mJB != null) {
            this.mJB.dFz();
        }
        if (this.mJA != null) {
            this.mJA.Sh(getClassName());
        }
    }

    public void Sa(String str) {
        Sb(this.mJD);
        this.mJD = str;
        if (this.mJA != null && this.mJB != null) {
            com.baidu.tieba.square.data.c Sg = this.mJA.Sg(str);
            if (Sg == null || (Sg.hasMore && y.isEmpty(Sg.getDataList()))) {
                this.mJB.dFB();
                q(str, null);
                this.mJA.Sh(str);
                this.mJB.scrollToPositionWithOffset(0, 0);
                return;
            }
            this.mJB.dFA();
            q(str, Sg.getDataList());
            this.mJB.fx(Sg.getDataList());
            this.mJB.scrollToPositionWithOffset(Sg.mKb, Sg.scrollOffset);
        }
    }

    public void Sb(String str) {
        com.baidu.tieba.square.data.c Sg;
        Pair<Integer, Integer> dFv;
        if (this.mJB != null && this.mJA != null && !TextUtils.isEmpty(str) && (Sg = this.mJA.Sg(str)) != null && (dFv = this.mJB.dFv()) != null) {
            Sg.mKb = ((Integer) dFv.first).intValue();
            Sg.scrollOffset = ((Integer) dFv.second).intValue();
        }
    }

    public String getClassName() {
        return this.mJD;
    }

    public void V(Intent intent) {
        Uri uri;
        if (intent != null) {
            this.mJD = intent.getStringExtra(ForumSquareActivityConfig.FORUM_CLASS_NAME);
            if (TextUtils.isEmpty(this.mJD) && (uri = (Uri) intent.getParcelableExtra(IntentConfig.KEY_URI)) != null) {
                this.mJD = uri.getQueryParameter("tab_name");
            }
            this.mJB.wZ(intent.getIntExtra(ForumSquareActivityConfig.SHOW_CREATE_BAR, 0) == 0);
        }
    }

    public void Sc(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.mJB.Sd(str);
            Sa(str);
        }
    }
}
