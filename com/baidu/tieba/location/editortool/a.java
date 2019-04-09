package com.baidu.tieba.location.editortool;

import android.content.Context;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.editortools.RawLayout;
import com.baidu.tbadk.editortools.k;
import com.baidu.tieba.d;
/* loaded from: classes5.dex */
public class a extends k {
    public a(Context context) {
        super(context, (String) null, 8);
        this.cjp = false;
        this.cjo = 3;
        this.cix = new PbLocationInfoContainer(context);
        this.cjq = new int[]{20, 19};
    }

    public a(Context context, boolean z) {
        super(context, (String) null, 8);
        this.cjp = false;
        this.cjo = 3;
        this.cix = new PbLocationInfoContainer(context);
        RawLayout.a aVar = new RawLayout.a(-2, l.h(getContext(), d.e.ds48));
        aVar.leftMargin = l.h(getContext(), d.e.ds32);
        aVar.rightMargin = l.h(getContext(), d.e.ds32);
        aVar.bottomMargin = l.h(getContext(), d.e.ds21);
        aVar.topMargin = l.h(getContext(), d.e.ds21);
        ((PbLocationInfoContainer) this.cix).setLayoutParams(aVar);
        this.cjq = new int[]{20, 19};
    }
}
