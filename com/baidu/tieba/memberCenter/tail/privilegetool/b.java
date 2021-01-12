package com.baidu.tieba.memberCenter.tail.privilegetool;

import android.content.Context;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.editortools.m;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class b extends m {
    public b(Context context) {
        super(context, null, 18, 0);
        this.name = TbadkCoreApplication.getInst().getResources().getString(R.string.member);
        this.fyZ = new PrivilegeDeskView(context);
        this.fzU = true;
        this.fzP = false;
        this.fzQ = true;
        this.fzM = R.drawable.icon_pure_post_vip24;
        this.fzN = R.drawable.icon_pure_post_vip24_selection;
        this.fzT = 6;
        this.fzV = new int[]{1};
    }
}
