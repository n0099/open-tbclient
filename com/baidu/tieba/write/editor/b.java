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
        this.fok = false;
        this.context = context;
        this.foj = 3;
        this.fnp = new EditorInfoContainer(context, str);
        this.fol = new int[]{9, 20, 19, 12, 13, 10, 11, 46, 49, 54, 57};
    }

    public void dtA() {
        BaseActivity baseActivity = (BaseActivity) this.context;
        e eVar = new e(baseActivity.getPageContext(), (View) this.fnp);
        eVar.fu(R.drawable.bg_tip_blue_left_less_than_right_down);
        eVar.ft(16);
        eVar.oG(true);
        eVar.setAnchor(2);
        eVar.setUseDirectOffset(true);
        eVar.xq(l.getDimens(baseActivity, R.dimen.ds32));
        eVar.xn(baseActivity.getResources().getDimensionPixelSize(R.dimen.tbds27));
        eVar.xo(baseActivity.getResources().getDimensionPixelSize(R.dimen.tbds41));
        eVar.fv((int) IMConnection.RETRY_DELAY_TIMES);
        eVar.oF(false);
        if (eVar.z(baseActivity.getString(R.string.write_location_topic_hint_title), "write_hint_tip_key", true)) {
            ((EditorInfoContainer) this.fnp).he(IMConnection.RETRY_DELAY_TIMES);
        }
    }

    public void setFrom(String str) {
        if (this.fnp instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.fnp).setFrom(str);
        }
    }

    public void bQ(String str, int i) {
        if (this.fnp instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.fnp).bQ(str, i);
        }
    }

    public void Lq(int i) {
        if (this.fnp instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.fnp).Lq(i);
        }
    }

    public void yy(boolean z) {
        if (this.fnp instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.fnp).yy(z);
        }
    }

    public void csl() {
        if (this.fnp instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.fnp).csl();
        }
    }

    public void dTH() {
        if (this.fnp instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.fnp).dTH();
        }
    }

    public void dTJ() {
        if (this.fnp instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.fnp).hide();
        }
    }

    public void yz(boolean z) {
        if (this.fnp instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.fnp).yz(z);
        }
    }
}
