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
        this.csL = false;
        this.csK = 3;
        this.crT = new PbLocationInfoContainer(context);
        this.csM = new int[]{20, 19};
    }

    public a(Context context, boolean z) {
        super(context, (String) null, 8);
        this.csL = false;
        this.csK = 3;
        this.crT = new PbLocationInfoContainer(context);
        RawLayout.a aVar = new RawLayout.a(-2, l.g(getContext(), R.dimen.ds48));
        aVar.leftMargin = l.g(getContext(), R.dimen.ds32);
        aVar.rightMargin = l.g(getContext(), R.dimen.ds32);
        aVar.bottomMargin = l.g(getContext(), R.dimen.ds21);
        aVar.topMargin = l.g(getContext(), R.dimen.ds21);
        ((PbLocationInfoContainer) this.crT).setLayoutParams(aVar);
        this.csM = new int[]{20, 19};
    }
}
