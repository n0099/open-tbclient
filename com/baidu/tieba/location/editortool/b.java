package com.baidu.tieba.location.editortool;

import android.content.Context;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.editortools.k;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class b extends k {
    public b(Context context, int i) {
        super(context, TbadkCoreApplication.getInst().getString(d.k.editor_location), 7, i);
        this.aDA = d.f.btn_pb_add_pin;
        this.aDF = new int[]{18};
    }
}
