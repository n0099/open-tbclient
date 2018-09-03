package com.baidu.tieba.location.editortool;

import android.content.Context;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.editortools.RawLayout;
import com.baidu.tbadk.editortools.k;
import com.baidu.tieba.f;
/* loaded from: classes3.dex */
public class a extends k {
    public a(Context context) {
        super(context, (String) null, 8);
        this.aMT = false;
        this.aMS = 3;
        this.aMc = new PbLocationInfoContainer(context);
        this.aMU = new int[]{20, 19};
    }

    public a(Context context, boolean z) {
        super(context, (String) null, 8);
        this.aMT = false;
        this.aMS = 3;
        this.aMc = new PbLocationInfoContainer(context);
        RawLayout.a aVar = new RawLayout.a(-2, l.f(getContext(), f.e.ds48));
        aVar.leftMargin = l.f(getContext(), f.e.ds32);
        aVar.rightMargin = l.f(getContext(), f.e.ds32);
        aVar.bottomMargin = l.f(getContext(), f.e.ds21);
        aVar.topMargin = l.f(getContext(), f.e.ds21);
        ((PbLocationInfoContainer) this.aMc).setLayoutParams(aVar);
        this.aMU = new int[]{20, 19};
    }
}
