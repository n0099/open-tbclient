package com.baidu.tieba.write.editor;

import android.content.Context;
import android.view.View;
import com.baidu.adp.lib.util.l;
import com.baidu.android.imsdk.internal.IMConnection;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.editortools.m;
import com.baidu.tieba.R;
import com.baidu.tieba.d.e;
/* loaded from: classes3.dex */
public class b extends m {
    private Context context;

    public b(Context context, String str) {
        super(context, (String) null, 15);
        this.fns = false;
        this.context = context;
        this.fnr = 3;
        this.fmx = new EditorInfoContainer(context, str);
        this.fnt = new int[]{9, 20, 19, 12, 13, 10, 11, 46, 49, 54, 57};
    }

    public void dta() {
        BaseActivity baseActivity = (BaseActivity) this.context;
        e eVar = new e(baseActivity.getPageContext(), (View) this.fmx);
        eVar.fq(R.drawable.bg_tip_blue_left_less_than_right_down);
        eVar.fp(16);
        eVar.oJ(true);
        eVar.setAnchor(2);
        eVar.setUseDirectOffset(true);
        eVar.xO(l.getDimens(baseActivity, R.dimen.ds32));
        eVar.xL(baseActivity.getResources().getDimensionPixelSize(R.dimen.tbds27));
        eVar.xM(baseActivity.getResources().getDimensionPixelSize(R.dimen.tbds41));
        eVar.fr((int) IMConnection.RETRY_DELAY_TIMES);
        eVar.oI(false);
        if (eVar.z(baseActivity.getString(R.string.write_location_topic_hint_title), "write_hint_tip_key", true)) {
            ((EditorInfoContainer) this.fmx).hh(IMConnection.RETRY_DELAY_TIMES);
        }
    }

    public void setFrom(String str) {
        if (this.fmx instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.fmx).setFrom(str);
        }
    }

    public void bP(String str, int i) {
        if (this.fmx instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.fmx).bP(str, i);
        }
    }

    public void LT(int i) {
        if (this.fmx instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.fmx).LT(i);
        }
    }

    public void yF(boolean z) {
        if (this.fmx instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.fmx).yF(z);
        }
    }

    public void crO() {
        if (this.fmx instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.fmx).crO();
        }
    }

    public void dTG() {
        if (this.fmx instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.fmx).dTG();
        }
    }

    public void dTI() {
        if (this.fmx instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.fmx).hide();
        }
    }

    public void yG(boolean z) {
        if (this.fmx instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.fmx).yG(z);
        }
    }
}
