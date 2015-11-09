package com.baidu.tieba.location.editortool;

import android.content.Context;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.editortools.w;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class b extends w {
    public b(Context context, int i) {
        super(context, TbadkCoreApplication.m411getInst().getString(i.h.editor_location), 7, i);
        this.launcherIcon = i.e.btn_pb_add_pin;
        this.toolLaunchAction = new int[]{18};
    }
}
