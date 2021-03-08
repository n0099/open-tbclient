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
        this.fCN = new PrivilegeDeskView(context);
        this.fDI = true;
        this.fDD = false;
        this.fDE = true;
        this.fDA = R.drawable.icon_pure_post_vip24;
        this.fDB = R.drawable.icon_pure_post_vip24_selection;
        this.fDH = 6;
        this.fDJ = new int[]{1};
    }
}
