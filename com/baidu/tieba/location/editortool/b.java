package com.baidu.tieba.location.editortool;

import android.content.Context;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.editortools.k;
import com.baidu.tieba.f;
/* loaded from: classes3.dex */
public class b extends k {
    public b(Context context, int i) {
        super(context, TbadkCoreApplication.getInst().getString(f.j.editor_location), 7, i);
        this.aMP = f.C0146f.btn_pb_add_pin;
        this.aMU = new int[]{18};
    }
}
