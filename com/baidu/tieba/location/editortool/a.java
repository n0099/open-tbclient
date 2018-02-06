package com.baidu.tieba.location.editortool;

import android.content.Context;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.editortools.p;
import com.baidu.tbadk.editortools.r;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class a extends r {
    public a(Context context) {
        super(context, (String) null, 8);
        this.bto = false;
        this.btm = 3;
        this.bsw = new c(context);
        this.btp = new int[]{20, 19};
    }

    public a(Context context, boolean z) {
        super(context, (String) null, 8);
        this.bto = false;
        this.btm = 3;
        this.bsw = new c(context);
        p.a aVar = new p.a(-2, l.t(getContext(), d.e.ds48));
        aVar.leftMargin = l.t(getContext(), d.e.ds32);
        aVar.rightMargin = l.t(getContext(), d.e.ds32);
        aVar.bottomMargin = l.t(getContext(), d.e.ds21);
        aVar.topMargin = l.t(getContext(), d.e.ds21);
        ((c) this.bsw).setLayoutParams(aVar);
        this.btp = new int[]{20, 19};
    }
}
