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
        this.fuW = false;
        this.context = context;
        this.fuV = 3;
        this.fub = new EditorInfoContainer(context, str);
        this.fuX = new int[]{9, 20, 19, 12, 13, 10, 11, 46, 49, 54, 57};
    }

    public void dyt() {
        BaseActivity baseActivity = (BaseActivity) this.context;
        e eVar = new e(baseActivity.getPageContext(), (View) this.fub);
        eVar.fO(R.drawable.bg_tip_blue_left_less_than_right_down);
        eVar.fN(16);
        eVar.pf(true);
        eVar.setAnchor(2);
        eVar.setUseDirectOffset(true);
        eVar.yt(l.getDimens(baseActivity, R.dimen.ds32));
        eVar.yq(baseActivity.getResources().getDimensionPixelSize(R.dimen.tbds27));
        eVar.yr(baseActivity.getResources().getDimensionPixelSize(R.dimen.tbds41));
        eVar.fP((int) IMConnection.RETRY_DELAY_TIMES);
        eVar.pe(false);
        if (eVar.A(baseActivity.getString(R.string.write_location_topic_hint_title), "write_hint_tip_key", true)) {
            ((EditorInfoContainer) this.fub).hM(IMConnection.RETRY_DELAY_TIMES);
        }
    }

    public void setFrom(String str) {
        if (this.fub instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.fub).setFrom(str);
        }
    }

    public void bS(String str, int i) {
        if (this.fub instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.fub).bS(str, i);
        }
    }

    public void ML(int i) {
        if (this.fub instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.fub).ML(i);
        }
    }

    public void zk(boolean z) {
        if (this.fub instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.fub).zk(z);
        }
    }

    public void cwe() {
        if (this.fub instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.fub).cwe();
        }
    }

    public void dZb() {
        if (this.fub instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.fub).dZb();
        }
    }

    public void dZd() {
        if (this.fub instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.fub).hide();
        }
    }

    public void zl(boolean z) {
        if (this.fub instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.fub).zl(z);
        }
    }
}
