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
    private String mPA = "";
    private ForumSquareModel mPx;
    public b mPy;
    private c mPz;
    private final TbPageContext mTbPageContext;

    public a(Context context, TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.mContext = context;
        this.mPx = new ForumSquareModel(context, this);
        this.mPy = new b(context, this.mTbPageContext);
    }

    public void startLoadData() {
        this.mPz = new c(this.mContext, this, this.mPy);
        this.mPz.dIh();
        cDO();
    }

    private void cDO() {
        this.mPy.dIb();
        this.mPx.Sy(this.mPA);
    }

    public void dHV() {
        this.mPy.dHV();
    }

    @Override // com.baidu.tieba.square.d
    public void d(String str, List<String> list, List<q> list2) {
        boolean z = true;
        if (this.mPx != null && this.mPy != null) {
            if (TextUtils.isEmpty(str) || str.equals(this.mPA)) {
                String dHY = this.mPy.dHY();
                if (TextUtils.isEmpty(str) || str.equals(dHY)) {
                    z = false;
                }
            }
            this.mPA = str;
            this.mPy.dIc();
            this.mPy.c(str, list, z);
            this.mPy.v(list2, this.mPx.w(list2, 300));
            q(str, list2);
        }
    }

    private void q(String str, List<q> list) {
        if (this.mPy != null && this.mPx != null) {
            if (y.isEmpty(list)) {
                this.mPy.bPW();
            } else if (y.getCount(list) < 10) {
                this.mPy.dIf();
            } else {
                this.mPy.xj(this.mPx.Sz(str));
            }
        }
    }

    @Override // com.baidu.tieba.square.d
    public void a(String str, ErrorData errorData) {
        if (this.mPy != null && this.mPx != null) {
            this.mPy.dIc();
            com.baidu.tieba.square.data.c Sx = this.mPx.Sx(str);
            if (Sx == null || (Sx.hasMore && y.isEmpty(Sx.getDataList()))) {
                this.mPy.bPW();
                this.mPy.dHZ();
                return;
            }
            this.mPy.fF(Sx.getDataList());
            q(str, Sx.getDataList());
        }
    }

    @Override // com.baidu.tieba.square.d
    public void e(ErrorData errorData) {
        if (this.mPy != null) {
            this.mPy.dIa();
        }
    }

    public void bTB() {
        String className = getClassName();
        if (this.mPx != null && this.mPy != null) {
            boolean isLoading = this.mPx.isLoading();
            boolean xj = this.mPy.xj(this.mPx.Sz(className));
            if (!isLoading && xj) {
                this.mPx.Sy(className);
            }
        }
    }

    public void dHW() {
        if (this.mPy != null) {
            this.mPy.dIb();
        }
        if (this.mPx != null) {
            this.mPx.Sy(getClassName());
        }
    }

    public void Sr(String str) {
        Ss(this.mPA);
        this.mPA = str;
        if (this.mPx != null && this.mPy != null) {
            com.baidu.tieba.square.data.c Sx = this.mPx.Sx(str);
            if (Sx == null || (Sx.hasMore && y.isEmpty(Sx.getDataList()))) {
                this.mPy.dId();
                q(str, null);
                this.mPx.Sy(str);
                this.mPy.scrollToPositionWithOffset(0, 0);
                return;
            }
            this.mPy.dIc();
            q(str, Sx.getDataList());
            this.mPy.fF(Sx.getDataList());
            this.mPy.scrollToPositionWithOffset(Sx.mPY, Sx.scrollOffset);
        }
    }

    public void Ss(String str) {
        com.baidu.tieba.square.data.c Sx;
        Pair<Integer, Integer> dHX;
        if (this.mPy != null && this.mPx != null && !TextUtils.isEmpty(str) && (Sx = this.mPx.Sx(str)) != null && (dHX = this.mPy.dHX()) != null) {
            Sx.mPY = ((Integer) dHX.first).intValue();
            Sx.scrollOffset = ((Integer) dHX.second).intValue();
        }
    }

    public String getClassName() {
        return this.mPA;
    }

    public void V(Intent intent) {
        Uri uri;
        if (intent != null) {
            this.mPA = intent.getStringExtra(ForumSquareActivityConfig.FORUM_CLASS_NAME);
            if (TextUtils.isEmpty(this.mPA) && (uri = (Uri) intent.getParcelableExtra(IntentConfig.KEY_URI)) != null) {
                this.mPA = uri.getQueryParameter("tab_name");
            }
            this.mPy.xi(intent.getIntExtra(ForumSquareActivityConfig.SHOW_CREATE_BAR, 0) == 0);
        }
    }

    public void St(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.mPy.Su(str);
            Sr(str);
        }
    }
}
