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
        this.fCj = false;
        this.context = context;
        this.fCi = 3;
        this.fBo = new EditorInfoContainer(context, str);
        this.fCk = new int[]{9, 20, 19, 12, 13, 10, 11, 46, 49, 54, 57};
    }

    public void dwA() {
        BaseActivity baseActivity = (BaseActivity) this.context;
        e eVar = new e(baseActivity.getPageContext(), (View) this.fBo);
        eVar.en(R.drawable.bg_tip_blue_left_less_than_right_down);
        eVar.em(16);
        eVar.pJ(true);
        eVar.xh(2);
        eVar.setUseDirectOffset(true);
        eVar.xl(l.getDimens(baseActivity, R.dimen.ds32));
        eVar.xi(baseActivity.getResources().getDimensionPixelSize(R.dimen.tbds27));
        eVar.xj(baseActivity.getResources().getDimensionPixelSize(R.dimen.tbds41));
        eVar.eo((int) IMConnection.RETRY_DELAY_TIMES);
        eVar.pI(false);
        if (eVar.C(baseActivity.getString(R.string.write_location_topic_hint_title), "write_hint_tip_key", true)) {
            ((EditorInfoContainer) this.fBo).hL(IMConnection.RETRY_DELAY_TIMES);
        }
    }

    public void setFrom(String str) {
        if (this.fBo instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.fBo).setFrom(str);
        }
    }

    public void ca(String str, int i) {
        if (this.fBo instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.fBo).ca(str, i);
        }
    }

    public void Lm(int i) {
        if (this.fBo instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.fBo).Lm(i);
        }
    }

    public void zE(boolean z) {
        if (this.fBo instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.fBo).zE(z);
        }
    }

    public void cws() {
        if (this.fBo instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.fBo).cws();
        }
    }

    public void dXf() {
        if (this.fBo instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.fBo).dXf();
        }
    }

    public void dXh() {
        if (this.fBo instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.fBo).hide();
        }
    }

    public void zF(boolean z) {
        if (this.fBo instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.fBo).zF(z);
        }
    }
}
