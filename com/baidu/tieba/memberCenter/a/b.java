package com.baidu.tieba.memberCenter.a;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.editortools.m;
import com.baidu.tbadk.editortools.view.CommonTabHost;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class b extends m {
    public b(Context context) {
        super(context, context.getString(R.string.editor_privilege), 12);
        int i;
        try {
            i = R.drawable.icon_pure_post_bubble24;
        } catch (NoSuchFieldError e) {
            BdLog.e(e.getMessage());
            i = 0;
        }
        this.fDA = i;
        this.fDC = R.drawable.icon_pure_post_more_bubble64;
        this.fDD = false;
        this.fDE = true;
        this.fDI = true;
        this.fCN = new CommonTabHost(context);
        ((CommonTabHost) this.fCN).b(new a());
        this.fDH = 6;
        this.fDJ = new int[]{1};
    }
}
