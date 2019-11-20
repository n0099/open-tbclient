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
        this.cFg = false;
        this.cFf = 3;
        this.cEn = new PbLocationInfoContainer(context);
        this.cFh = new int[]{20, 19};
    }

    public a(Context context, boolean z) {
        super(context, (String) null, 8);
        this.cFg = false;
        this.cFf = 3;
        this.cEn = new PbLocationInfoContainer(context);
        RawLayout.a aVar = new RawLayout.a(-2, l.getDimens(getContext(), R.dimen.ds48));
        aVar.leftMargin = l.getDimens(getContext(), R.dimen.ds32);
        aVar.rightMargin = l.getDimens(getContext(), R.dimen.ds32);
        aVar.bottomMargin = l.getDimens(getContext(), R.dimen.ds21);
        aVar.topMargin = l.getDimens(getContext(), R.dimen.ds21);
        ((PbLocationInfoContainer) this.cEn).setLayoutParams(aVar);
        this.cFh = new int[]{20, 19};
    }
}
