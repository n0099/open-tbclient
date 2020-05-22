package com.baidu.tieba.location.editortool;

import android.content.Context;
import com.baidu.tbadk.editortools.RawLayout;
import com.baidu.tbadk.editortools.l;
import com.baidu.tieba.R;
/* loaded from: classes10.dex */
public class a extends l {
    public a(Context context) {
        super(context, (String) null, 8);
        this.elN = false;
        this.elM = 3;
        this.ekV = new PbLocationInfoContainer(context);
        this.elO = new int[]{20, 19};
    }

    public a(Context context, boolean z) {
        super(context, (String) null, 8);
        this.elN = false;
        this.elM = 3;
        this.ekV = new PbLocationInfoContainer(context);
        RawLayout.LayoutParams layoutParams = new RawLayout.LayoutParams(-2, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds48));
        layoutParams.leftMargin = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds32);
        layoutParams.rightMargin = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds32);
        layoutParams.bottomMargin = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds21);
        layoutParams.topMargin = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds21);
        ((PbLocationInfoContainer) this.ekV).setLayoutParams(layoutParams);
        this.elO = new int[]{20, 19};
    }
}
