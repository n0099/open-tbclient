package com.baidu.tieba.location.editortool;

import android.content.Context;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.editortools.r;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class b extends r {
    public b(Context context, int i) {
        super(context, TbadkCoreApplication.getInst().getString(d.j.editor_location), 7, i);
        this.bsW = d.f.btn_pb_add_pin;
        this.btb = new int[]{18};
    }
}
