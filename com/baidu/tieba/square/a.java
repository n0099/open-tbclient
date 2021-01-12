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
    private String nfA = "";
    private ForumSquareModel nfx;
    public b nfy;
    private c nfz;

    public a(Context context, TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.mContext = context;
        this.nfx = new ForumSquareModel(context, this);
        this.nfy = new b(context, this.mTbPageContext);
    }

    public void startLoadData() {
        this.nfz = new c(this.mContext, this, this.nfy);
        this.nfz.dJq();
        cHP();
    }

    private void cHP() {
        this.nfy.dJk();
        this.nfx.RN(this.nfA);
    }

    public void dJe() {
        this.nfy.dJe();
    }

    @Override // com.baidu.tieba.square.d
    public void d(String str, List<String> list, List<n> list2) {
        boolean z = true;
        if (this.nfx != null && this.nfy != null) {
            if (TextUtils.isEmpty(str) || str.equals(this.nfA)) {
                String dJh = this.nfy.dJh();
                if (TextUtils.isEmpty(str) || str.equals(dJh)) {
                    z = false;
                }
            }
            this.nfA = str;
            this.nfy.dJl();
            this.nfy.d(str, list, z);
            this.nfy.v(list2, this.nfx.w(list2, 300));
            r(str, list2);
        }
    }

    private void r(String str, List<n> list) {
        if (this.nfy != null && this.nfx != null) {
            if (x.isEmpty(list)) {
                this.nfy.bRO();
            } else if (x.getCount(list) < 10) {
                this.nfy.dJo();
            } else {
                this.nfy.xP(this.nfx.RO(str));
            }
        }
    }

    @Override // com.baidu.tieba.square.d
    public void a(String str, ErrorData errorData) {
        if (this.nfy != null && this.nfx != null) {
            this.nfy.dJl();
            com.baidu.tieba.square.data.c RM = this.nfx.RM(str);
            if (RM == null || (RM.hasMore && x.isEmpty(RM.getDataList()))) {
                this.nfy.bRO();
                this.nfy.dJi();
                return;
            }
            this.nfy.fS(RM.getDataList());
            r(str, RM.getDataList());
        }
    }

    @Override // com.baidu.tieba.square.d
    public void e(ErrorData errorData) {
        if (this.nfy != null) {
            this.nfy.dJj();
        }
    }

    public void bVt() {
        String className = getClassName();
        if (this.nfx != null && this.nfy != null) {
            boolean isLoading = this.nfx.isLoading();
            boolean xP = this.nfy.xP(this.nfx.RO(className));
            if (!isLoading && xP) {
                this.nfx.RN(className);
            }
        }
    }

    public void dJf() {
        if (this.nfy != null) {
            this.nfy.dJk();
        }
        if (this.nfx != null) {
            this.nfx.RN(getClassName());
        }
    }

    public void RG(String str) {
        RH(this.nfA);
        this.nfA = str;
        if (this.nfx != null && this.nfy != null) {
            com.baidu.tieba.square.data.c RM = this.nfx.RM(str);
            if (RM == null || (RM.hasMore && x.isEmpty(RM.getDataList()))) {
                this.nfy.dJm();
                r(str, null);
                this.nfx.RN(str);
                this.nfy.scrollToPositionWithOffset(0, 0);
                return;
            }
            this.nfy.dJl();
            r(str, RM.getDataList());
            this.nfy.fS(RM.getDataList());
            this.nfy.scrollToPositionWithOffset(RM.nfY, RM.fdc);
        }
    }

    public void RH(String str) {
        com.baidu.tieba.square.data.c RM;
        Pair<Integer, Integer> dJg;
        if (this.nfy != null && this.nfx != null && !TextUtils.isEmpty(str) && (RM = this.nfx.RM(str)) != null && (dJg = this.nfy.dJg()) != null) {
            RM.nfY = ((Integer) dJg.first).intValue();
            RM.fdc = ((Integer) dJg.second).intValue();
        }
    }

    public String getClassName() {
        return this.nfA;
    }

    public void W(Intent intent) {
        Uri uri;
        if (intent != null) {
            this.nfA = intent.getStringExtra(ForumSquareActivityConfig.FORUM_CLASS_NAME);
            if (TextUtils.isEmpty(this.nfA) && (uri = (Uri) intent.getParcelableExtra(IntentConfig.KEY_URI)) != null) {
                this.nfA = uri.getQueryParameter("tab_name");
            }
            this.nfy.xO(intent.getIntExtra(ForumSquareActivityConfig.SHOW_CREATE_BAR, 0) == 0);
        }
    }

    public void RI(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.nfy.RJ(str);
            RG(str);
        }
    }
}
