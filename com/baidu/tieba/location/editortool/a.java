package com.baidu.tieba.location.editortool;

import android.content.Context;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.editortools.RawLayout;
import com.baidu.tbadk.editortools.k;
import com.baidu.tieba.R;
/* loaded from: classes5.dex */
public class a extends k {
    public a(Context context) {
        super(context, (String) null, 8);
        this.cFX = false;
        this.cFW = 3;
        this.cFe = new PbLocationInfoContainer(context);
        this.cFY = new int[]{20, 19};
    }

    public a(Context context, boolean z) {
        super(context, (String) null, 8);
        this.cFX = false;
        this.cFW = 3;
        this.cFe = new PbLocationInfoContainer(context);
        RawLayout.a aVar = new RawLayout.a(-2, l.getDimens(getContext(), R.dimen.ds48));
        aVar.leftMargin = l.getDimens(getContext(), R.dimen.ds32);
        aVar.rightMargin = l.getDimens(getContext(), R.dimen.ds32);
        aVar.bottomMargin = l.getDimens(getContext(), R.dimen.ds21);
        aVar.topMargin = l.getDimens(getContext(), R.dimen.ds21);
        ((PbLocationInfoContainer) this.cFe).setLayoutParams(aVar);
        this.cFY = new int[]{20, 19};
    }
}
