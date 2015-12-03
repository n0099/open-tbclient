package com.baidu.tieba.location.editortool;

import android.content.Context;
import com.baidu.tbadk.editortools.y;
/* loaded from: classes.dex */
public class a extends y {
    public a(Context context) {
        super(context, (String) null, 8);
        this.toolNeedAction = false;
        this.toolPosition = 3;
        this.toolView = new c(context);
        this.toolLaunchAction = new int[]{20, 19};
    }
}
