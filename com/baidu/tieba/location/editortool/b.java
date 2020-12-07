package com.baidu.tieba.location.editortool;

import android.content.Context;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.editortools.m;
import com.baidu.tieba.R;
/* loaded from: classes23.dex */
public class b extends m {
    public b(Context context, int i) {
        super(context, TbadkCoreApplication.getInst().getString(R.string.editor_location), 7, i);
        this.fuO = R.drawable.icon_pure_more_location40_svg;
        this.fuR = true;
        this.fuX = new int[]{18};
    }
}
