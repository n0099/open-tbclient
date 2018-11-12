package com.baidu.tieba.location.editortool;

import android.content.Context;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.editortools.k;
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class b extends k {
    public b(Context context, int i) {
        super(context, TbadkCoreApplication.getInst().getString(e.j.editor_location), 7, i);
        this.aVy = e.f.btn_pb_add_pin;
        this.aVD = new int[]{18};
    }
}
