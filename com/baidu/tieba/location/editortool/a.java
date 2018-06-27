package com.baidu.tieba.location.editortool;

import android.content.Context;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.editortools.RawLayout;
import com.baidu.tbadk.editortools.k;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class a extends k {
    public a(Context context) {
        super(context, (String) null, 8);
        this.aMW = false;
        this.aMV = 3;
        this.aMf = new PbLocationInfoContainer(context);
        this.aMX = new int[]{20, 19};
    }

    public a(Context context, boolean z) {
        super(context, (String) null, 8);
        this.aMW = false;
        this.aMV = 3;
        this.aMf = new PbLocationInfoContainer(context);
        RawLayout.a aVar = new RawLayout.a(-2, l.e(getContext(), d.e.ds48));
        aVar.leftMargin = l.e(getContext(), d.e.ds32);
        aVar.rightMargin = l.e(getContext(), d.e.ds32);
        aVar.bottomMargin = l.e(getContext(), d.e.ds21);
        aVar.topMargin = l.e(getContext(), d.e.ds21);
        ((PbLocationInfoContainer) this.aMf).setLayoutParams(aVar);
        this.aMX = new int[]{20, 19};
    }
}
