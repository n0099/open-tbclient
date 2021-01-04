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
    private ForumSquareModel nkd;
    public b nke;
    private c nkf;
    private String nkg = "";

    public a(Context context, TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.mContext = context;
        this.nkd = new ForumSquareModel(context, this);
        this.nke = new b(context, this.mTbPageContext);
    }

    public void startLoadData() {
        this.nkf = new c(this.mContext, this, this.nke);
        this.nkf.dNh();
        cLG();
    }

    private void cLG() {
        this.nke.dNb();
        this.nkd.SW(this.nkg);
    }

    public void dMV() {
        this.nke.dMV();
    }

    @Override // com.baidu.tieba.square.d
    public void d(String str, List<String> list, List<n> list2) {
        boolean z = true;
        if (this.nkd != null && this.nke != null) {
            if (TextUtils.isEmpty(str) || str.equals(this.nkg)) {
                String dMY = this.nke.dMY();
                if (TextUtils.isEmpty(str) || str.equals(dMY)) {
                    z = false;
                }
            }
            this.nkg = str;
            this.nke.dNc();
            this.nke.d(str, list, z);
            this.nke.v(list2, this.nkd.w(list2, 300));
            r(str, list2);
        }
    }

    private void r(String str, List<n> list) {
        if (this.nke != null && this.nkd != null) {
            if (x.isEmpty(list)) {
                this.nke.bVF();
            } else if (x.getCount(list) < 10) {
                this.nke.dNf();
            } else {
                this.nke.xT(this.nkd.SX(str));
            }
        }
    }

    @Override // com.baidu.tieba.square.d
    public void a(String str, ErrorData errorData) {
        if (this.nke != null && this.nkd != null) {
            this.nke.dNc();
            com.baidu.tieba.square.data.c SV = this.nkd.SV(str);
            if (SV == null || (SV.hasMore && x.isEmpty(SV.getDataList()))) {
                this.nke.bVF();
                this.nke.dMZ();
                return;
            }
            this.nke.fS(SV.getDataList());
            r(str, SV.getDataList());
        }
    }

    @Override // com.baidu.tieba.square.d
    public void e(ErrorData errorData) {
        if (this.nke != null) {
            this.nke.dNa();
        }
    }

    public void bZk() {
        String className = getClassName();
        if (this.nkd != null && this.nke != null) {
            boolean isLoading = this.nkd.isLoading();
            boolean xT = this.nke.xT(this.nkd.SX(className));
            if (!isLoading && xT) {
                this.nkd.SW(className);
            }
        }
    }

    public void dMW() {
        if (this.nke != null) {
            this.nke.dNb();
        }
        if (this.nkd != null) {
            this.nkd.SW(getClassName());
        }
    }

    public void SP(String str) {
        SQ(this.nkg);
        this.nkg = str;
        if (this.nkd != null && this.nke != null) {
            com.baidu.tieba.square.data.c SV = this.nkd.SV(str);
            if (SV == null || (SV.hasMore && x.isEmpty(SV.getDataList()))) {
                this.nke.dNd();
                r(str, null);
                this.nkd.SW(str);
                this.nke.scrollToPositionWithOffset(0, 0);
                return;
            }
            this.nke.dNc();
            r(str, SV.getDataList());
            this.nke.fS(SV.getDataList());
            this.nke.scrollToPositionWithOffset(SV.nkE, SV.fhK);
        }
    }

    public void SQ(String str) {
        com.baidu.tieba.square.data.c SV;
        Pair<Integer, Integer> dMX;
        if (this.nke != null && this.nkd != null && !TextUtils.isEmpty(str) && (SV = this.nkd.SV(str)) != null && (dMX = this.nke.dMX()) != null) {
            SV.nkE = ((Integer) dMX.first).intValue();
            SV.fhK = ((Integer) dMX.second).intValue();
        }
    }

    public String getClassName() {
        return this.nkg;
    }

    public void W(Intent intent) {
        Uri uri;
        if (intent != null) {
            this.nkg = intent.getStringExtra(ForumSquareActivityConfig.FORUM_CLASS_NAME);
            if (TextUtils.isEmpty(this.nkg) && (uri = (Uri) intent.getParcelableExtra(IntentConfig.KEY_URI)) != null) {
                this.nkg = uri.getQueryParameter("tab_name");
            }
            this.nke.xS(intent.getIntExtra(ForumSquareActivityConfig.SHOW_CREATE_BAR, 0) == 0);
        }
    }

    public void SR(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.nke.SS(str);
            SP(str);
        }
    }
}
