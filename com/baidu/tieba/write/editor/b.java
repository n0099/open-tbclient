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
        this.fis = false;
        this.context = context;
        this.fir = 3;
        this.fhv = new EditorInfoContainer(context, str);
        this.fit = new int[]{9, 20, 19, 12, 13, 10, 11, 46, 49, 54, 57};
    }

    public void dqY() {
        BaseActivity baseActivity = (BaseActivity) this.context;
        e eVar = new e(baseActivity.getPageContext(), (View) this.fhv);
        eVar.fh(R.drawable.bg_tip_blue_left_less_than_right_down);
        eVar.fg(16);
        eVar.ox(true);
        eVar.setAnchor(2);
        eVar.setUseDirectOffset(true);
        eVar.xd(l.getDimens(baseActivity, R.dimen.ds32));
        eVar.xa(baseActivity.getResources().getDimensionPixelSize(R.dimen.tbds27));
        eVar.xb(baseActivity.getResources().getDimensionPixelSize(R.dimen.tbds41));
        eVar.fi((int) IMConnection.RETRY_DELAY_TIMES);
        eVar.ow(false);
        if (eVar.y(baseActivity.getString(R.string.write_location_topic_hint_title), "write_hint_tip_key", true)) {
            ((EditorInfoContainer) this.fhv).gI(IMConnection.RETRY_DELAY_TIMES);
        }
    }

    public void setFrom(String str) {
        if (this.fhv instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.fhv).setFrom(str);
        }
    }

    public void bO(String str, int i) {
        if (this.fhv instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.fhv).bO(str, i);
        }
    }

    public void Ld(int i) {
        if (this.fhv instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.fhv).Ld(i);
        }
    }

    public void yp(boolean z) {
        if (this.fhv instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.fhv).yp(z);
        }
    }

    public void cpK() {
        if (this.fhv instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.fhv).cpK();
        }
    }

    public void dRh() {
        if (this.fhv instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.fhv).dRh();
        }
    }

    public void dRj() {
        if (this.fhv instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.fhv).hide();
        }
    }

    public void yq(boolean z) {
        if (this.fhv instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.fhv).yq(z);
        }
    }
}
