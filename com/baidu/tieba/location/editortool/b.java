package com.baidu.tieba.location.editortool;

import android.content.Context;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.editortools.l;
import com.baidu.tieba.R;
/* loaded from: classes7.dex */
public class b extends l {
    public b(Context context, int i) {
        super(context, TbadkCoreApplication.getInst().getString(R.string.editor_location), 7, i);
        this.dsU = R.drawable.icon_pure_more_location40_svg;
        this.dsW = true;
        this.dtb = new int[]{18};
    }
}
