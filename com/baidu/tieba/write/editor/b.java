package com.baidu.tieba.write.editor;

import android.content.Context;
import android.view.View;
import com.baidu.adp.lib.util.l;
import com.baidu.android.imsdk.internal.IMConnection;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.editortools.m;
import com.baidu.tieba.R;
import com.baidu.tieba.c.e;
/* loaded from: classes3.dex */
public class b extends m {
    private Context context;

    public b(Context context, String str) {
        super(context, (String) null, 15);
        this.eNN = false;
        this.context = context;
        this.eNM = 3;
        this.eMS = new EditorInfoContainer(context, str);
        this.eNO = new int[]{9, 20, 19, 12, 13, 10, 11, 46, 49, 54, 57};
    }

    public void dkh() {
        BaseActivity baseActivity = (BaseActivity) this.context;
        e eVar = new e(baseActivity.getPageContext(), (View) this.eMS);
        eVar.eW(R.drawable.bg_tip_blue_left_less_than_right_down);
        eVar.eV(16);
        eVar.nA(true);
        eVar.setAnchor(2);
        eVar.setUseDirectOffset(true);
        eVar.we(l.getDimens(baseActivity, R.dimen.ds32));
        eVar.wb(baseActivity.getResources().getDimensionPixelSize(R.dimen.tbds27));
        eVar.wc(baseActivity.getResources().getDimensionPixelSize(R.dimen.tbds41));
        eVar.eX((int) IMConnection.RETRY_DELAY_TIMES);
        eVar.nz(false);
        if (eVar.y(baseActivity.getString(R.string.write_location_topic_hint_title), "write_hint_tip_key", true)) {
            ((EditorInfoContainer) this.eMS).gp(IMConnection.RETRY_DELAY_TIMES);
        }
    }

    public void setFrom(String str) {
        if (this.eMS instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.eMS).setFrom(str);
        }
    }

    public void bM(String str, int i) {
        if (this.eMS instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.eMS).bM(str, i);
        }
    }

    public void Kf(int i) {
        if (this.eMS instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.eMS).Kf(i);
        }
    }

    public void xr(boolean z) {
        if (this.eMS instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.eMS).xr(z);
        }
    }

    public void cjh() {
        if (this.eMS instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.eMS).cjh();
        }
    }

    public void dKn() {
        if (this.eMS instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.eMS).dKn();
        }
    }

    public void dKp() {
        if (this.eMS instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.eMS).hide();
        }
    }

    public void xs(boolean z) {
        if (this.eMS instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.eMS).xs(z);
        }
    }
}
