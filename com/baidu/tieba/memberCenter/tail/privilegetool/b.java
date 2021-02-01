package com.baidu.tieba.memberCenter.tail.privilegetool;

import android.content.Context;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.editortools.m;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class b extends m {
    public b(Context context) {
        super(context, null, 18, 0);
        this.name = TbadkCoreApplication.getInst().getResources().getString(R.string.member);
        this.fBo = new PrivilegeDeskView(context);
        this.fCj = true;
        this.fCe = false;
        this.fCf = true;
        this.fCb = R.drawable.icon_pure_post_vip24;
        this.fCc = R.drawable.icon_pure_post_vip24_selection;
        this.fCi = 6;
        this.fCk = new int[]{1};
    }
}
