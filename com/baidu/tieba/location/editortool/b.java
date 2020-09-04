package com.baidu.tieba.location.editortool;

import android.content.Context;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.editortools.m;
import com.baidu.tieba.R;
/* loaded from: classes17.dex */
public class b extends m {
    public b(Context context, int i) {
        super(context, TbadkCoreApplication.getInst().getString(R.string.editor_location), 7, i);
        this.eLo = R.drawable.icon_pure_more_location40_svg;
        this.eLr = true;
        this.eLx = new int[]{18};
    }
}
