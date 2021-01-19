package com.baidu.tieba.write.editor;

import android.content.Context;
import android.view.View;
import com.baidu.adp.lib.util.l;
import com.baidu.android.imsdk.internal.IMConnection;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.editortools.m;
import com.baidu.tieba.R;
import com.baidu.tieba.c.e;
/* loaded from: classes7.dex */
public class b extends m {
    private Context context;

    public b(Context context, String str) {
        super(context, (String) null, 15);
        this.fzU = false;
        this.context = context;
        this.fzT = 3;
        this.fyZ = new EditorInfoContainer(context, str);
        this.fzV = new int[]{9, 20, 19, 12, 13, 10, 11, 46, 49, 54, 57};
    }

    public void dur() {
        BaseActivity baseActivity = (BaseActivity) this.context;
        e eVar = new e(baseActivity.getPageContext(), (View) this.fyZ);
        eVar.ej(R.drawable.bg_tip_blue_left_less_than_right_down);
        eVar.ei(16);
        eVar.pz(true);
        eVar.wX(2);
        eVar.setUseDirectOffset(true);
        eVar.xb(l.getDimens(baseActivity, R.dimen.ds32));
        eVar.wY(baseActivity.getResources().getDimensionPixelSize(R.dimen.tbds27));
        eVar.wZ(baseActivity.getResources().getDimensionPixelSize(R.dimen.tbds41));
        eVar.ek((int) IMConnection.RETRY_DELAY_TIMES);
        eVar.py(false);
        if (eVar.C(baseActivity.getString(R.string.write_location_topic_hint_title), "write_hint_tip_key", true)) {
            ((EditorInfoContainer) this.fyZ).hG(IMConnection.RETRY_DELAY_TIMES);
        }
    }

    public void setFrom(String str) {
        if (this.fyZ instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.fyZ).setFrom(str);
        }
    }

    public void ca(String str, int i) {
        if (this.fyZ instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.fyZ).ca(str, i);
        }
    }

    public void KR(int i) {
        if (this.fyZ instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.fyZ).KR(i);
        }
    }

    public void zi(boolean z) {
        if (this.fyZ instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.fyZ).zi(z);
        }
    }

    public void cvg() {
        if (this.fyZ instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.fyZ).cvg();
        }
    }

    public void dUR() {
        if (this.fyZ instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.fyZ).dUR();
        }
    }

    public void dUT() {
        if (this.fyZ instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.fyZ).hide();
        }
    }

    public void zj(boolean z) {
        if (this.fyZ instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.fyZ).zj(z);
        }
    }
}
