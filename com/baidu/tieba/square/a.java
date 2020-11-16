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
    private ForumSquareModel mQq;
    public b mQr;
    private c mQs;
    private String mQt = "";
    private final TbPageContext mTbPageContext;

    public a(Context context, TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.mContext = context;
        this.mQq = new ForumSquareModel(context, this);
        this.mQr = new b(context, this.mTbPageContext);
    }

    public void startLoadData() {
        this.mQs = new c(this.mContext, this, this.mQr);
        this.mQs.dHY();
        cDs();
    }

    private void cDs() {
        this.mQr.dHS();
        this.mQq.RZ(this.mQt);
    }

    public void dHM() {
        this.mQr.dHM();
    }

    @Override // com.baidu.tieba.square.d
    public void d(String str, List<String> list, List<q> list2) {
        boolean z = true;
        if (this.mQq != null && this.mQr != null) {
            if (TextUtils.isEmpty(str) || str.equals(this.mQt)) {
                String dHP = this.mQr.dHP();
                if (TextUtils.isEmpty(str) || str.equals(dHP)) {
                    z = false;
                }
            }
            this.mQt = str;
            this.mQr.dHT();
            this.mQr.c(str, list, z);
            this.mQr.v(list2, this.mQq.w(list2, 300));
            q(str, list2);
        }
    }

    private void q(String str, List<q> list) {
        if (this.mQr != null && this.mQq != null) {
            if (y.isEmpty(list)) {
                this.mQr.bPp();
            } else if (y.getCount(list) < 10) {
                this.mQr.dHW();
            } else {
                this.mQr.xn(this.mQq.Sa(str));
            }
        }
    }

    @Override // com.baidu.tieba.square.d
    public void a(String str, ErrorData errorData) {
        if (this.mQr != null && this.mQq != null) {
            this.mQr.dHT();
            com.baidu.tieba.square.data.c RY = this.mQq.RY(str);
            if (RY == null || (RY.hasMore && y.isEmpty(RY.getDataList()))) {
                this.mQr.bPp();
                this.mQr.dHQ();
                return;
            }
            this.mQr.fF(RY.getDataList());
            q(str, RY.getDataList());
        }
    }

    @Override // com.baidu.tieba.square.d
    public void e(ErrorData errorData) {
        if (this.mQr != null) {
            this.mQr.dHR();
        }
    }

    public void bSU() {
        String className = getClassName();
        if (this.mQq != null && this.mQr != null) {
            boolean isLoading = this.mQq.isLoading();
            boolean xn = this.mQr.xn(this.mQq.Sa(className));
            if (!isLoading && xn) {
                this.mQq.RZ(className);
            }
        }
    }

    public void dHN() {
        if (this.mQr != null) {
            this.mQr.dHS();
        }
        if (this.mQq != null) {
            this.mQq.RZ(getClassName());
        }
    }

    public void RS(String str) {
        RT(this.mQt);
        this.mQt = str;
        if (this.mQq != null && this.mQr != null) {
            com.baidu.tieba.square.data.c RY = this.mQq.RY(str);
            if (RY == null || (RY.hasMore && y.isEmpty(RY.getDataList()))) {
                this.mQr.dHU();
                q(str, null);
                this.mQq.RZ(str);
                this.mQr.scrollToPositionWithOffset(0, 0);
                return;
            }
            this.mQr.dHT();
            q(str, RY.getDataList());
            this.mQr.fF(RY.getDataList());
            this.mQr.scrollToPositionWithOffset(RY.mQR, RY.scrollOffset);
        }
    }

    public void RT(String str) {
        com.baidu.tieba.square.data.c RY;
        Pair<Integer, Integer> dHO;
        if (this.mQr != null && this.mQq != null && !TextUtils.isEmpty(str) && (RY = this.mQq.RY(str)) != null && (dHO = this.mQr.dHO()) != null) {
            RY.mQR = ((Integer) dHO.first).intValue();
            RY.scrollOffset = ((Integer) dHO.second).intValue();
        }
    }

    public String getClassName() {
        return this.mQt;
    }

    public void V(Intent intent) {
        Uri uri;
        if (intent != null) {
            this.mQt = intent.getStringExtra(ForumSquareActivityConfig.FORUM_CLASS_NAME);
            if (TextUtils.isEmpty(this.mQt) && (uri = (Uri) intent.getParcelableExtra(IntentConfig.KEY_URI)) != null) {
                this.mQt = uri.getQueryParameter("tab_name");
            }
            this.mQr.xm(intent.getIntExtra(ForumSquareActivityConfig.SHOW_CREATE_BAR, 0) == 0);
        }
    }

    public void RU(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.mQr.RV(str);
            RS(str);
        }
    }
}
