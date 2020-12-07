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
    private ForumSquareModel nev;

    /* renamed from: new  reason: not valid java name */
    public b f5new;
    private c nex;
    private String ney = "";

    public a(Context context, TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.mContext = context;
        this.nev = new ForumSquareModel(context, this);
        this.f5new = new b(context, this.mTbPageContext);
    }

    public void startLoadData() {
        this.nex = new c(this.mContext, this, this.f5new);
        this.nex.dNo();
        cIF();
    }

    private void cIF() {
        this.f5new.dNi();
        this.nev.Tn(this.ney);
    }

    public void dNc() {
        this.f5new.dNc();
    }

    @Override // com.baidu.tieba.square.d
    public void d(String str, List<String> list, List<q> list2) {
        boolean z = true;
        if (this.nev != null && this.f5new != null) {
            if (TextUtils.isEmpty(str) || str.equals(this.ney)) {
                String dNf = this.f5new.dNf();
                if (TextUtils.isEmpty(str) || str.equals(dNf)) {
                    z = false;
                }
            }
            this.ney = str;
            this.f5new.dNj();
            this.f5new.c(str, list, z);
            this.f5new.v(list2, this.nev.w(list2, 300));
            r(str, list2);
        }
    }

    private void r(String str, List<q> list) {
        if (this.f5new != null && this.nev != null) {
            if (y.isEmpty(list)) {
                this.f5new.bTa();
            } else if (y.getCount(list) < 10) {
                this.f5new.dNm();
            } else {
                this.f5new.xR(this.nev.To(str));
            }
        }
    }

    @Override // com.baidu.tieba.square.d
    public void a(String str, ErrorData errorData) {
        if (this.f5new != null && this.nev != null) {
            this.f5new.dNj();
            com.baidu.tieba.square.data.c Tm = this.nev.Tm(str);
            if (Tm == null || (Tm.hasMore && y.isEmpty(Tm.getDataList()))) {
                this.f5new.bTa();
                this.f5new.dNg();
                return;
            }
            this.f5new.fT(Tm.getDataList());
            r(str, Tm.getDataList());
        }
    }

    @Override // com.baidu.tieba.square.d
    public void e(ErrorData errorData) {
        if (this.f5new != null) {
            this.f5new.dNh();
        }
    }

    public void bWE() {
        String className = getClassName();
        if (this.nev != null && this.f5new != null) {
            boolean isLoading = this.nev.isLoading();
            boolean xR = this.f5new.xR(this.nev.To(className));
            if (!isLoading && xR) {
                this.nev.Tn(className);
            }
        }
    }

    public void dNd() {
        if (this.f5new != null) {
            this.f5new.dNi();
        }
        if (this.nev != null) {
            this.nev.Tn(getClassName());
        }
    }

    public void Tg(String str) {
        Th(this.ney);
        this.ney = str;
        if (this.nev != null && this.f5new != null) {
            com.baidu.tieba.square.data.c Tm = this.nev.Tm(str);
            if (Tm == null || (Tm.hasMore && y.isEmpty(Tm.getDataList()))) {
                this.f5new.dNk();
                r(str, null);
                this.nev.Tn(str);
                this.f5new.scrollToPositionWithOffset(0, 0);
                return;
            }
            this.f5new.dNj();
            r(str, Tm.getDataList());
            this.f5new.fT(Tm.getDataList());
            this.f5new.scrollToPositionWithOffset(Tm.neW, Tm.eYk);
        }
    }

    public void Th(String str) {
        com.baidu.tieba.square.data.c Tm;
        Pair<Integer, Integer> dNe;
        if (this.f5new != null && this.nev != null && !TextUtils.isEmpty(str) && (Tm = this.nev.Tm(str)) != null && (dNe = this.f5new.dNe()) != null) {
            Tm.neW = ((Integer) dNe.first).intValue();
            Tm.eYk = ((Integer) dNe.second).intValue();
        }
    }

    public String getClassName() {
        return this.ney;
    }

    public void V(Intent intent) {
        Uri uri;
        if (intent != null) {
            this.ney = intent.getStringExtra(ForumSquareActivityConfig.FORUM_CLASS_NAME);
            if (TextUtils.isEmpty(this.ney) && (uri = (Uri) intent.getParcelableExtra(IntentConfig.KEY_URI)) != null) {
                this.ney = uri.getQueryParameter("tab_name");
            }
            this.f5new.xQ(intent.getIntExtra(ForumSquareActivityConfig.SHOW_CREATE_BAR, 0) == 0);
        }
    }

    public void Ti(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f5new.Tj(str);
            Tg(str);
        }
    }
}
