package com.baidu.tieba.memberCenter.tail.tool;

import android.content.Context;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.editortools.m;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class a extends m {
    public a(Context context, int i) {
        super(context, TbadkCoreApplication.getInst().getString(R.string.tail_web_view_title), 16, i);
        this.fEu = R.drawable.icon_pure_post_vip24;
        this.fEw = R.drawable.icon_pure_post_more_tail64;
        this.fEx = false;
        this.fEy = true;
        this.fDH = new TailToolController(context);
        this.fEC = true;
        this.fEB = 6;
        this.fED = new int[]{1};
    }
}
