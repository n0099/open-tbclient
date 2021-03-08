package com.baidu.tieba.memberCenter.tail.tool;

import android.content.Context;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.editortools.m;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class a extends m {
    public a(Context context, int i) {
        super(context, TbadkCoreApplication.getInst().getString(R.string.tail_web_view_title), 16, i);
        this.fDA = R.drawable.icon_pure_post_vip24;
        this.fDC = R.drawable.icon_pure_post_more_tail64;
        this.fDD = false;
        this.fDE = true;
        this.fCN = new TailToolController(context);
        this.fDI = true;
        this.fDH = 6;
        this.fDJ = new int[]{1};
    }
}
