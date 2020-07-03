package com.baidu.tieba.write.editor;

import android.content.Context;
import android.view.View;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.editortools.l;
import com.baidu.tieba.R;
import com.baidu.tieba.c.e;
/* loaded from: classes2.dex */
public class b extends l {
    private Context context;

    public b(Context context, String str) {
        super(context, (String) null, 15);
        this.euA = false;
        this.context = context;
        this.euz = 3;
        this.etH = new EditorInfoContainer(context, str);
        this.euB = new int[]{9, 20, 19, 12, 13, 10, 11, 46, 49, 54, 57};
    }

    public void cRN() {
        BaseActivity baseActivity = (BaseActivity) this.context;
        e eVar = new e(baseActivity.getPageContext(), (View) this.etH);
        eVar.cS(R.drawable.bg_tip_blue_left_less_than_right_down);
        eVar.cR(16);
        eVar.mk(true);
        eVar.sV(2);
        eVar.setUseDirectOffset(true);
        eVar.sZ(com.baidu.adp.lib.util.l.getDimens(baseActivity, R.dimen.ds32));
        eVar.sW(baseActivity.getResources().getDimensionPixelSize(R.dimen.tbds27));
        eVar.sX(baseActivity.getResources().getDimensionPixelSize(R.dimen.tbds41));
        eVar.cT((int) 3000);
        eVar.mj(false);
        if (eVar.z(baseActivity.getString(R.string.write_location_topic_hint_title), "write_hint_tip_key", true)) {
            ((EditorInfoContainer) this.etH).fA(3000L);
        }
    }

    public void setFrom(String str) {
        if (this.etH instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.etH).setFrom(str);
        }
    }

    public void bJ(String str, int i) {
        if (this.etH instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.etH).bJ(str, i);
        }
    }

    public void vN(boolean z) {
        if (this.etH instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.etH).vN(z);
        }
    }

    public void bSk() {
        if (this.etH instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.etH).bSk();
        }
    }

    public void drx() {
        if (this.etH instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.etH).drx();
        }
    }

    public void drz() {
        if (this.etH instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.etH).hide();
        }
    }

    public void vO(boolean z) {
        if (this.etH instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.etH).vO(z);
        }
    }
}
