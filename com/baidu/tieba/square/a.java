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
    private String neA = "";
    private ForumSquareModel nex;
    public b ney;
    private c nez;

    public a(Context context, TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.mContext = context;
        this.nex = new ForumSquareModel(context, this);
        this.ney = new b(context, this.mTbPageContext);
    }

    public void startLoadData() {
        this.nez = new c(this.mContext, this, this.ney);
        this.nez.dNp();
        cIG();
    }

    private void cIG() {
        this.ney.dNj();
        this.nex.Tn(this.neA);
    }

    public void dNd() {
        this.ney.dNd();
    }

    @Override // com.baidu.tieba.square.d
    public void d(String str, List<String> list, List<q> list2) {
        boolean z = true;
        if (this.nex != null && this.ney != null) {
            if (TextUtils.isEmpty(str) || str.equals(this.neA)) {
                String dNg = this.ney.dNg();
                if (TextUtils.isEmpty(str) || str.equals(dNg)) {
                    z = false;
                }
            }
            this.neA = str;
            this.ney.dNk();
            this.ney.c(str, list, z);
            this.ney.v(list2, this.nex.w(list2, 300));
            r(str, list2);
        }
    }

    private void r(String str, List<q> list) {
        if (this.ney != null && this.nex != null) {
            if (y.isEmpty(list)) {
                this.ney.bTb();
            } else if (y.getCount(list) < 10) {
                this.ney.dNn();
            } else {
                this.ney.xR(this.nex.To(str));
            }
        }
    }

    @Override // com.baidu.tieba.square.d
    public void a(String str, ErrorData errorData) {
        if (this.ney != null && this.nex != null) {
            this.ney.dNk();
            com.baidu.tieba.square.data.c Tm = this.nex.Tm(str);
            if (Tm == null || (Tm.hasMore && y.isEmpty(Tm.getDataList()))) {
                this.ney.bTb();
                this.ney.dNh();
                return;
            }
            this.ney.fT(Tm.getDataList());
            r(str, Tm.getDataList());
        }
    }

    @Override // com.baidu.tieba.square.d
    public void e(ErrorData errorData) {
        if (this.ney != null) {
            this.ney.dNi();
        }
    }

    public void bWF() {
        String className = getClassName();
        if (this.nex != null && this.ney != null) {
            boolean isLoading = this.nex.isLoading();
            boolean xR = this.ney.xR(this.nex.To(className));
            if (!isLoading && xR) {
                this.nex.Tn(className);
            }
        }
    }

    public void dNe() {
        if (this.ney != null) {
            this.ney.dNj();
        }
        if (this.nex != null) {
            this.nex.Tn(getClassName());
        }
    }

    public void Tg(String str) {
        Th(this.neA);
        this.neA = str;
        if (this.nex != null && this.ney != null) {
            com.baidu.tieba.square.data.c Tm = this.nex.Tm(str);
            if (Tm == null || (Tm.hasMore && y.isEmpty(Tm.getDataList()))) {
                this.ney.dNl();
                r(str, null);
                this.nex.Tn(str);
                this.ney.scrollToPositionWithOffset(0, 0);
                return;
            }
            this.ney.dNk();
            r(str, Tm.getDataList());
            this.ney.fT(Tm.getDataList());
            this.ney.scrollToPositionWithOffset(Tm.neY, Tm.eYk);
        }
    }

    public void Th(String str) {
        com.baidu.tieba.square.data.c Tm;
        Pair<Integer, Integer> dNf;
        if (this.ney != null && this.nex != null && !TextUtils.isEmpty(str) && (Tm = this.nex.Tm(str)) != null && (dNf = this.ney.dNf()) != null) {
            Tm.neY = ((Integer) dNf.first).intValue();
            Tm.eYk = ((Integer) dNf.second).intValue();
        }
    }

    public String getClassName() {
        return this.neA;
    }

    public void V(Intent intent) {
        Uri uri;
        if (intent != null) {
            this.neA = intent.getStringExtra(ForumSquareActivityConfig.FORUM_CLASS_NAME);
            if (TextUtils.isEmpty(this.neA) && (uri = (Uri) intent.getParcelableExtra(IntentConfig.KEY_URI)) != null) {
                this.neA = uri.getQueryParameter("tab_name");
            }
            this.ney.xQ(intent.getIntExtra(ForumSquareActivityConfig.SHOW_CREATE_BAR, 0) == 0);
        }
    }

    public void Ti(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.ney.Tj(str);
            Tg(str);
        }
    }
}
