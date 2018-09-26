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
        this.aQl = false;
        this.aQk = 3;
        this.aPu = new PbLocationInfoContainer(context);
        this.aQm = new int[]{20, 19};
    }

    public a(Context context, boolean z) {
        super(context, (String) null, 8);
        this.aQl = false;
        this.aQk = 3;
        this.aPu = new PbLocationInfoContainer(context);
        RawLayout.a aVar = new RawLayout.a(-2, l.h(getContext(), e.C0141e.ds48));
        aVar.leftMargin = l.h(getContext(), e.C0141e.ds32);
        aVar.rightMargin = l.h(getContext(), e.C0141e.ds32);
        aVar.bottomMargin = l.h(getContext(), e.C0141e.ds21);
        aVar.topMargin = l.h(getContext(), e.C0141e.ds21);
        ((PbLocationInfoContainer) this.aPu).setLayoutParams(aVar);
        this.aQm = new int[]{20, 19};
    }
}
