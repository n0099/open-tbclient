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
        this.eZU = false;
        this.context = context;
        this.eZT = 3;
        this.eYZ = new EditorInfoContainer(context, str);
        this.eZV = new int[]{9, 20, 19, 12, 13, 10, 11, 46, 49, 54, 57};
    }

    public void dnR() {
        BaseActivity baseActivity = (BaseActivity) this.context;
        e eVar = new e(baseActivity.getPageContext(), (View) this.eYZ);
        eVar.ff(R.drawable.bg_tip_blue_left_less_than_right_down);
        eVar.fe(16);
        eVar.of(true);
        eVar.setAnchor(2);
        eVar.setUseDirectOffset(true);
        eVar.wK(l.getDimens(baseActivity, R.dimen.ds32));
        eVar.wH(baseActivity.getResources().getDimensionPixelSize(R.dimen.tbds27));
        eVar.wI(baseActivity.getResources().getDimensionPixelSize(R.dimen.tbds41));
        eVar.fg((int) IMConnection.RETRY_DELAY_TIMES);
        eVar.oe(false);
        if (eVar.y(baseActivity.getString(R.string.write_location_topic_hint_title), "write_hint_tip_key", true)) {
            ((EditorInfoContainer) this.eYZ).gH(IMConnection.RETRY_DELAY_TIMES);
        }
    }

    public void setFrom(String str) {
        if (this.eYZ instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.eYZ).setFrom(str);
        }
    }

    public void bN(String str, int i) {
        if (this.eYZ instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.eYZ).bN(str, i);
        }
    }

    public void KL(int i) {
        if (this.eYZ instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.eYZ).KL(i);
        }
    }

    public void xY(boolean z) {
        if (this.eYZ instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.eYZ).xY(z);
        }
    }

    public void cmD() {
        if (this.eYZ instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.eYZ).cmD();
        }
    }

    public void dNZ() {
        if (this.eYZ instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.eYZ).dNZ();
        }
    }

    public void dOb() {
        if (this.eYZ instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.eYZ).hide();
        }
    }

    public void xZ(boolean z) {
        if (this.eYZ instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.eYZ).xZ(z);
        }
    }
}
