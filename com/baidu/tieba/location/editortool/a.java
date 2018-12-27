package com.baidu.tieba.location.editortool;

import android.content.Context;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.editortools.RawLayout;
import com.baidu.tbadk.editortools.k;
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class a extends k {
    public a(Context context) {
        super(context, (String) null, 8);
        this.aZc = false;
        this.aZb = 3;
        this.aYl = new PbLocationInfoContainer(context);
        this.aZd = new int[]{20, 19};
    }

    public a(Context context, boolean z) {
        super(context, (String) null, 8);
        this.aZc = false;
        this.aZb = 3;
        this.aYl = new PbLocationInfoContainer(context);
        RawLayout.a aVar = new RawLayout.a(-2, l.h(getContext(), e.C0210e.ds48));
        aVar.leftMargin = l.h(getContext(), e.C0210e.ds32);
        aVar.rightMargin = l.h(getContext(), e.C0210e.ds32);
        aVar.bottomMargin = l.h(getContext(), e.C0210e.ds21);
        aVar.topMargin = l.h(getContext(), e.C0210e.ds21);
        ((PbLocationInfoContainer) this.aYl).setLayoutParams(aVar);
        this.aZd = new int[]{20, 19};
    }
}
