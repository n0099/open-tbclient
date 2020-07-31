package com.baidu.tieba.write.editor;

import android.content.Context;
import android.view.View;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.editortools.l;
import com.baidu.tieba.R;
import com.baidu.tieba.c.e;
/* loaded from: classes3.dex */
public class b extends l {
    private Context context;

    public b(Context context, String str) {
        super(context, (String) null, 15);
        this.eAT = false;
        this.context = context;
        this.eAS = 3;
        this.ezZ = new EditorInfoContainer(context, str);
        this.eAU = new int[]{9, 20, 19, 12, 13, 10, 11, 46, 49, 54, 57};
    }

    public void cVE() {
        BaseActivity baseActivity = (BaseActivity) this.context;
        e eVar = new e(baseActivity.getPageContext(), (View) this.ezZ);
        eVar.cS(R.drawable.bg_tip_blue_left_less_than_right_down);
        eVar.cR(16);
        eVar.mP(true);
        eVar.tn(2);
        eVar.setUseDirectOffset(true);
        eVar.tr(com.baidu.adp.lib.util.l.getDimens(baseActivity, R.dimen.ds32));
        eVar.to(baseActivity.getResources().getDimensionPixelSize(R.dimen.tbds27));
        eVar.tp(baseActivity.getResources().getDimensionPixelSize(R.dimen.tbds41));
        eVar.cT((int) 3000);
        eVar.mO(false);
        if (eVar.z(baseActivity.getString(R.string.write_location_topic_hint_title), "write_hint_tip_key", true)) {
            ((EditorInfoContainer) this.ezZ).fN(3000L);
        }
    }

    public void setFrom(String str) {
        if (this.ezZ instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.ezZ).setFrom(str);
        }
    }

    public void bH(String str, int i) {
        if (this.ezZ instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.ezZ).bH(str, i);
        }
    }

    public void wr(boolean z) {
        if (this.ezZ instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.ezZ).wr(z);
        }
    }

    public void bVC() {
        if (this.ezZ instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.ezZ).bVC();
        }
    }

    public void duN() {
        if (this.ezZ instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.ezZ).duN();
        }
    }

    public void duP() {
        if (this.ezZ instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.ezZ).hide();
        }
    }

    public void ws(boolean z) {
        if (this.ezZ instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.ezZ).ws(z);
        }
    }
}
