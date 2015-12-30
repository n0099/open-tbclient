package com.baidu.tieba.location.editortool;

import android.content.Context;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.editortools.y;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class b extends y {
    public b(Context context, int i) {
        super(context, TbadkCoreApplication.m411getInst().getString(n.j.editor_location), 7, i);
        this.launcherIcon = n.f.btn_pb_add_pin;
        this.toolLaunchAction = new int[]{18};
    }
}
