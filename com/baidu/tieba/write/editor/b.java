package com.baidu.tieba.write.editor;

import android.content.Context;
import android.view.View;
import com.baidu.adp.lib.util.l;
import com.baidu.android.imsdk.internal.IMConnection;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.editortools.m;
import com.baidu.tieba.R;
import com.baidu.tieba.c.e;
/* loaded from: classes8.dex */
public class b extends m {
    private Context context;

    public b(Context context, String str) {
        super(context, (String) null, 15);
        this.fEC = false;
        this.context = context;
        this.fEB = 3;
        this.fDH = new EditorInfoContainer(context, str);
        this.fED = new int[]{9, 20, 19, 12, 13, 10, 11, 46, 49, 54, 57};
    }

    public void dyi() {
        BaseActivity baseActivity = (BaseActivity) this.context;
        e eVar = new e(baseActivity.getPageContext(), (View) this.fDH);
        eVar.fP(R.drawable.bg_tip_blue_left_less_than_right_down);
        eVar.fO(16);
        eVar.pD(true);
        eVar.setAnchor(2);
        eVar.setUseDirectOffset(true);
        eVar.yH(l.getDimens(baseActivity, R.dimen.ds32));
        eVar.yE(baseActivity.getResources().getDimensionPixelSize(R.dimen.tbds27));
        eVar.yF(baseActivity.getResources().getDimensionPixelSize(R.dimen.tbds41));
        eVar.fQ((int) IMConnection.RETRY_DELAY_TIMES);
        eVar.pC(false);
        if (eVar.C(baseActivity.getString(R.string.write_location_topic_hint_title), "write_hint_tip_key", true)) {
            ((EditorInfoContainer) this.fDH).hG(IMConnection.RETRY_DELAY_TIMES);
        }
    }

    public void setFrom(String str) {
        if (this.fDH instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.fDH).setFrom(str);
        }
    }

    public void bZ(String str, int i) {
        if (this.fDH instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.fDH).bZ(str, i);
        }
    }

    public void My(int i) {
        if (this.fDH instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.fDH).My(i);
        }
    }

    public void zm(boolean z) {
        if (this.fDH instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.fDH).zm(z);
        }
    }

    public void cyX() {
        if (this.fDH instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.fDH).cyX();
        }
    }

    public void dYI() {
        if (this.fDH instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.fDH).dYI();
        }
    }

    public void dYK() {
        if (this.fDH instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.fDH).hide();
        }
    }

    public void zn(boolean z) {
        if (this.fDH instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.fDH).zn(z);
        }
    }
}
