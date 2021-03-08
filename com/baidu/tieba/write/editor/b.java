package com.baidu.tieba.write.editor;

import android.content.Context;
import android.view.View;
import com.baidu.adp.lib.util.l;
import com.baidu.android.imsdk.internal.IMConnection;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.editortools.m;
import com.baidu.tieba.R;
import com.baidu.tieba.c.e;
/* loaded from: classes7.dex */
public class b extends m {
    private Context context;

    public b(Context context, String str) {
        super(context, (String) null, 15);
        this.fDI = false;
        this.context = context;
        this.fDH = 3;
        this.fCN = new EditorInfoContainer(context, str);
        this.fDJ = new int[]{9, 20, 19, 12, 13, 10, 11, 46, 49, 54, 57};
    }

    public void dwQ() {
        BaseActivity baseActivity = (BaseActivity) this.context;
        e eVar = new e(baseActivity.getPageContext(), (View) this.fCN);
        eVar.eo(R.drawable.bg_tip_blue_left_less_than_right_down);
        eVar.en(16);
        eVar.pJ(true);
        eVar.xi(2);
        eVar.setUseDirectOffset(true);
        eVar.xm(l.getDimens(baseActivity, R.dimen.ds32));
        eVar.xj(baseActivity.getResources().getDimensionPixelSize(R.dimen.tbds27));
        eVar.xk(baseActivity.getResources().getDimensionPixelSize(R.dimen.tbds41));
        eVar.ep((int) IMConnection.RETRY_DELAY_TIMES);
        eVar.pI(false);
        if (eVar.C(baseActivity.getString(R.string.write_location_topic_hint_title), "write_hint_tip_key", true)) {
            ((EditorInfoContainer) this.fCN).hL(IMConnection.RETRY_DELAY_TIMES);
        }
    }

    public void setFrom(String str) {
        if (this.fCN instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.fCN).setFrom(str);
        }
    }

    public void ca(String str, int i) {
        if (this.fCN instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.fCN).ca(str, i);
        }
    }

    public void Lr(int i) {
        if (this.fCN instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.fCN).Lr(i);
        }
    }

    public void zD(boolean z) {
        if (this.fCN instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.fCN).zD(z);
        }
    }

    public void cwF() {
        if (this.fCN instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.fCN).cwF();
        }
    }

    public void dXv() {
        if (this.fCN instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.fCN).dXv();
        }
    }

    public void dXx() {
        if (this.fCN instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.fCN).hide();
        }
    }

    public void zE(boolean z) {
        if (this.fCN instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.fCN).zE(z);
        }
    }
}
