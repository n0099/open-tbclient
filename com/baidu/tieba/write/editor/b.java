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
        this.eLw = false;
        this.context = context;
        this.eLv = 3;
        this.eKB = new EditorInfoContainer(context, str);
        this.eLx = new int[]{9, 20, 19, 12, 13, 10, 11, 46, 49, 54, 57};
    }

    public void dgC() {
        BaseActivity baseActivity = (BaseActivity) this.context;
        e eVar = new e(baseActivity.getPageContext(), (View) this.eKB);
        eVar.eL(R.drawable.bg_tip_blue_left_less_than_right_down);
        eVar.eK(16);
        eVar.nu(true);
        eVar.setAnchor(2);
        eVar.setUseDirectOffset(true);
        eVar.vF(l.getDimens(baseActivity, R.dimen.ds32));
        eVar.vC(baseActivity.getResources().getDimensionPixelSize(R.dimen.tbds27));
        eVar.vD(baseActivity.getResources().getDimensionPixelSize(R.dimen.tbds41));
        eVar.eM((int) IMConnection.RETRY_DELAY_TIMES);
        eVar.nt(false);
        if (eVar.y(baseActivity.getString(R.string.write_location_topic_hint_title), "write_hint_tip_key", true)) {
            ((EditorInfoContainer) this.eKB).gb(IMConnection.RETRY_DELAY_TIMES);
        }
    }

    public void setFrom(String str) {
        if (this.eKB instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.eKB).setFrom(str);
        }
    }

    public void bM(String str, int i) {
        if (this.eKB instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.eKB).bM(str, i);
        }
    }

    public void xi(boolean z) {
        if (this.eKB instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.eKB).xi(z);
        }
    }

    public void cfQ() {
        if (this.eKB instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.eKB).cfQ();
        }
    }

    public void dGt() {
        if (this.eKB instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.eKB).dGt();
        }
    }

    public void dGv() {
        if (this.eKB instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.eKB).hide();
        }
    }

    public void xj(boolean z) {
        if (this.eKB instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.eKB).xj(z);
        }
    }
}
