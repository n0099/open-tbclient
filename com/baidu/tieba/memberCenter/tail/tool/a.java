package com.baidu.tieba.memberCenter.tail.tool;

import android.content.Context;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.editortools.m;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class a extends m {
    public a(Context context, int i) {
        super(context, TbadkCoreApplication.getInst().getString(R.string.tail_web_view_title), 16, i);
        this.fzM = R.drawable.icon_pure_post_vip24;
        this.fzO = R.drawable.icon_pure_post_more_tail64;
        this.fzP = false;
        this.fzQ = true;
        this.fyZ = new TailToolController(context);
        this.fzU = true;
        this.fzT = 6;
        this.fzV = new int[]{1};
    }
}
