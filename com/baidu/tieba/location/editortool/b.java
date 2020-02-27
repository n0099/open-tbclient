package com.baidu.tieba.location.editortool;

import android.content.Context;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.editortools.l;
import com.baidu.tieba.R;
/* loaded from: classes10.dex */
public class b extends l {
    public b(Context context, int i) {
        super(context, TbadkCoreApplication.getInst().getString(R.string.editor_location), 7, i);
        this.dxl = R.drawable.icon_pure_more_location40_svg;
        this.dxn = true;
        this.dxs = new int[]{18};
    }
}
