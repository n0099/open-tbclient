package com.baidu.tieba.location.editortool;

import android.content.Context;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.editortools.RawLayout;
import com.baidu.tbadk.editortools.m;
import com.baidu.tieba.R;
/* loaded from: classes22.dex */
public class a extends m {
    public a(Context context) {
        super(context, (String) null, 8);
        this.fns = false;
        this.fnr = 3;
        this.fmx = new PbLocationInfoContainer(context);
        this.fnt = new int[]{20, 19};
    }

    public a(Context context, boolean z) {
        super(context, (String) null, 8);
        this.fns = false;
        this.fnr = 3;
        this.fmx = new PbLocationInfoContainer(context);
        RawLayout.LayoutParams layoutParams = new RawLayout.LayoutParams(-2, l.getDimens(getContext(), R.dimen.ds48));
        layoutParams.leftMargin = l.getDimens(getContext(), R.dimen.ds32);
        layoutParams.rightMargin = l.getDimens(getContext(), R.dimen.ds32);
        layoutParams.bottomMargin = l.getDimens(getContext(), R.dimen.ds21);
        layoutParams.topMargin = l.getDimens(getContext(), R.dimen.ds21);
        ((PbLocationInfoContainer) this.fmx).setLayoutParams(layoutParams);
        this.fnt = new int[]{20, 19};
    }
}
