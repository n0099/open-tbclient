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
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.square.model.ForumSquareModel;
import java.util.List;
/* loaded from: classes2.dex */
public class a implements d {
    private final Context mContext;
    private final TbPageContext mTbPageContext;
    private ForumSquareModel nkc;
    public b nkd;
    private c nke;
    private String nkf = "";

    public a(Context context, TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.mContext = context;
        this.nkc = new ForumSquareModel(context, this);
        this.nkd = new b(context, this.mTbPageContext);
    }

    public void startLoadData() {
        this.nke = new c(this.mContext, this, this.nkd);
        this.nke.dNi();
        cLH();
    }

    private void cLH() {
        this.nkd.dNc();
        this.nkc.SV(this.nkf);
    }

    public void dMW() {
        this.nkd.dMW();
    }

    @Override // com.baidu.tieba.square.d
    public void d(String str, List<String> list, List<n> list2) {
        boolean z = true;
        if (this.nkc != null && this.nkd != null) {
            if (TextUtils.isEmpty(str) || str.equals(this.nkf)) {
                String dMZ = this.nkd.dMZ();
                if (TextUtils.isEmpty(str) || str.equals(dMZ)) {
                    z = false;
                }
            }
            this.nkf = str;
            this.nkd.dNd();
            this.nkd.d(str, list, z);
            this.nkd.v(list2, this.nkc.w(list2, 300));
            r(str, list2);
        }
    }

    private void r(String str, List<n> list) {
        if (this.nkd != null && this.nkc != null) {
            if (x.isEmpty(list)) {
                this.nkd.bVG();
            } else if (x.getCount(list) < 10) {
                this.nkd.dNg();
            } else {
                this.nkd.xT(this.nkc.SW(str));
            }
        }
    }

    @Override // com.baidu.tieba.square.d
    public void a(String str, ErrorData errorData) {
        if (this.nkd != null && this.nkc != null) {
            this.nkd.dNd();
            com.baidu.tieba.square.data.c SU = this.nkc.SU(str);
            if (SU == null || (SU.hasMore && x.isEmpty(SU.getDataList()))) {
                this.nkd.bVG();
                this.nkd.dNa();
                return;
            }
            this.nkd.fS(SU.getDataList());
            r(str, SU.getDataList());
        }
    }

    @Override // com.baidu.tieba.square.d
    public void e(ErrorData errorData) {
        if (this.nkd != null) {
            this.nkd.dNb();
        }
    }

    public void bZl() {
        String className = getClassName();
        if (this.nkc != null && this.nkd != null) {
            boolean isLoading = this.nkc.isLoading();
            boolean xT = this.nkd.xT(this.nkc.SW(className));
            if (!isLoading && xT) {
                this.nkc.SV(className);
            }
        }
    }

    public void dMX() {
        if (this.nkd != null) {
            this.nkd.dNc();
        }
        if (this.nkc != null) {
            this.nkc.SV(getClassName());
        }
    }

    public void SO(String str) {
        SP(this.nkf);
        this.nkf = str;
        if (this.nkc != null && this.nkd != null) {
            com.baidu.tieba.square.data.c SU = this.nkc.SU(str);
            if (SU == null || (SU.hasMore && x.isEmpty(SU.getDataList()))) {
                this.nkd.dNe();
                r(str, null);
                this.nkc.SV(str);
                this.nkd.scrollToPositionWithOffset(0, 0);
                return;
            }
            this.nkd.dNd();
            r(str, SU.getDataList());
            this.nkd.fS(SU.getDataList());
            this.nkd.scrollToPositionWithOffset(SU.nkD, SU.fhK);
        }
    }

    public void SP(String str) {
        com.baidu.tieba.square.data.c SU;
        Pair<Integer, Integer> dMY;
        if (this.nkd != null && this.nkc != null && !TextUtils.isEmpty(str) && (SU = this.nkc.SU(str)) != null && (dMY = this.nkd.dMY()) != null) {
            SU.nkD = ((Integer) dMY.first).intValue();
            SU.fhK = ((Integer) dMY.second).intValue();
        }
    }

    public String getClassName() {
        return this.nkf;
    }

    public void W(Intent intent) {
        Uri uri;
        if (intent != null) {
            this.nkf = intent.getStringExtra(ForumSquareActivityConfig.FORUM_CLASS_NAME);
            if (TextUtils.isEmpty(this.nkf) && (uri = (Uri) intent.getParcelableExtra(IntentConfig.KEY_URI)) != null) {
                this.nkf = uri.getQueryParameter("tab_name");
            }
            this.nkd.xS(intent.getIntExtra(ForumSquareActivityConfig.SHOW_CREATE_BAR, 0) == 0);
        }
    }

    public void SQ(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.nkd.SR(str);
            SO(str);
        }
    }
}
