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
        this.eLs = false;
        this.context = context;
        this.eLr = 3;
        this.eKx = new EditorInfoContainer(context, str);
        this.eLt = new int[]{9, 20, 19, 12, 13, 10, 11, 46, 49, 54, 57};
    }

    public void dgB() {
        BaseActivity baseActivity = (BaseActivity) this.context;
        e eVar = new e(baseActivity.getPageContext(), (View) this.eKx);
        eVar.eL(R.drawable.bg_tip_blue_left_less_than_right_down);
        eVar.eK(16);
        eVar.ns(true);
        eVar.setAnchor(2);
        eVar.setUseDirectOffset(true);
        eVar.vF(l.getDimens(baseActivity, R.dimen.ds32));
        eVar.vC(baseActivity.getResources().getDimensionPixelSize(R.dimen.tbds27));
        eVar.vD(baseActivity.getResources().getDimensionPixelSize(R.dimen.tbds41));
        eVar.eM((int) IMConnection.RETRY_DELAY_TIMES);
        eVar.nr(false);
        if (eVar.y(baseActivity.getString(R.string.write_location_topic_hint_title), "write_hint_tip_key", true)) {
            ((EditorInfoContainer) this.eKx).fZ(IMConnection.RETRY_DELAY_TIMES);
        }
    }

    public void setFrom(String str) {
        if (this.eKx instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.eKx).setFrom(str);
        }
    }

    public void bM(String str, int i) {
        if (this.eKx instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.eKx).bM(str, i);
        }
    }

    public void xg(boolean z) {
        if (this.eKx instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.eKx).xg(z);
        }
    }

    public void cfP() {
        if (this.eKx instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.eKx).cfP();
        }
    }

    public void dGk() {
        if (this.eKx instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.eKx).dGk();
        }
    }

    public void dGm() {
        if (this.eKx instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.eKx).hide();
        }
    }

    public void xh(boolean z) {
        if (this.eKx instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.eKx).xh(z);
        }
    }
}
