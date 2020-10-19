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
    private final TbPageContext mTbPageContext;
    private ForumSquareModel mwQ;
    public b mwR;
    private c mwS;
    private String mwT = "";

    public a(Context context, TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.mContext = context;
        this.mwQ = new ForumSquareModel(context, this);
        this.mwR = new b(context, this.mTbPageContext);
    }

    public void startLoadData() {
        this.mwS = new c(this.mContext, this, this.mwR);
        this.mwS.dCx();
        cyg();
    }

    private void cyg() {
        this.mwR.dCr();
        this.mwQ.RI(this.mwT);
    }

    public void dCl() {
        this.mwR.dCl();
    }

    @Override // com.baidu.tieba.square.d
    public void d(String str, List<String> list, List<q> list2) {
        boolean z = true;
        if (this.mwQ != null && this.mwR != null) {
            if (TextUtils.isEmpty(str) || str.equals(this.mwT)) {
                String dCo = this.mwR.dCo();
                if (TextUtils.isEmpty(str) || str.equals(dCo)) {
                    z = false;
                }
            }
            this.mwT = str;
            this.mwR.dCs();
            this.mwR.c(str, list, z);
            this.mwR.u(list2, this.mwQ.v(list2, 300));
            q(str, list2);
        }
    }

    private void q(String str, List<q> list) {
        if (this.mwR != null && this.mwQ != null) {
            if (y.isEmpty(list)) {
                this.mwR.bKU();
            } else if (y.getCount(list) < 10) {
                this.mwR.dCv();
            } else {
                this.mwR.wJ(this.mwQ.RJ(str));
            }
        }
    }

    @Override // com.baidu.tieba.square.d
    public void a(String str, ErrorData errorData) {
        if (this.mwR != null && this.mwQ != null) {
            this.mwR.dCs();
            com.baidu.tieba.square.data.c RH = this.mwQ.RH(str);
            if (RH == null || (RH.hasMore && y.isEmpty(RH.getDataList()))) {
                this.mwR.bKU();
                this.mwR.dCp();
                return;
            }
            this.mwR.fo(RH.getDataList());
            q(str, RH.getDataList());
        }
    }

    @Override // com.baidu.tieba.square.d
    public void e(ErrorData errorData) {
        if (this.mwR != null) {
            this.mwR.dCq();
        }
    }

    public void bOx() {
        String className = getClassName();
        if (this.mwQ != null && this.mwR != null) {
            boolean isLoading = this.mwQ.isLoading();
            boolean wJ = this.mwR.wJ(this.mwQ.RJ(className));
            if (!isLoading && wJ) {
                this.mwQ.RI(className);
            }
        }
    }

    public void dCm() {
        if (this.mwR != null) {
            this.mwR.dCr();
        }
        if (this.mwQ != null) {
            this.mwQ.RI(getClassName());
        }
    }

    public void RB(String str) {
        RC(this.mwT);
        this.mwT = str;
        if (this.mwQ != null && this.mwR != null) {
            com.baidu.tieba.square.data.c RH = this.mwQ.RH(str);
            if (RH == null || (RH.hasMore && y.isEmpty(RH.getDataList()))) {
                this.mwR.dCt();
                q(str, null);
                this.mwQ.RI(str);
                this.mwR.scrollToPositionWithOffset(0, 0);
                return;
            }
            this.mwR.dCs();
            q(str, RH.getDataList());
            this.mwR.fo(RH.getDataList());
            this.mwR.scrollToPositionWithOffset(RH.mxr, RH.scrollOffset);
        }
    }

    public void RC(String str) {
        com.baidu.tieba.square.data.c RH;
        Pair<Integer, Integer> dCn;
        if (this.mwR != null && this.mwQ != null && !TextUtils.isEmpty(str) && (RH = this.mwQ.RH(str)) != null && (dCn = this.mwR.dCn()) != null) {
            RH.mxr = ((Integer) dCn.first).intValue();
            RH.scrollOffset = ((Integer) dCn.second).intValue();
        }
    }

    public String getClassName() {
        return this.mwT;
    }

    public void V(Intent intent) {
        Uri uri;
        if (intent != null) {
            this.mwT = intent.getStringExtra(ForumSquareActivityConfig.FORUM_CLASS_NAME);
            if (TextUtils.isEmpty(this.mwT) && (uri = (Uri) intent.getParcelableExtra(IntentConfig.KEY_URI)) != null) {
                this.mwT = uri.getQueryParameter("tab_name");
            }
            this.mwR.wI(intent.getIntExtra(ForumSquareActivityConfig.SHOW_CREATE_BAR, 0) == 0);
        }
    }

    public void RD(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.mwR.RE(str);
            RB(str);
        }
    }
}
