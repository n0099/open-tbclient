package com.baidu.tieba.memberCenter.a;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.editortools.m;
import com.baidu.tbadk.editortools.view.CommonTabHost;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
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
        this.fEu = i;
        this.fEw = R.drawable.icon_pure_post_more_bubble64;
        this.fEx = false;
        this.fEy = true;
        this.fEC = true;
        this.fDH = new CommonTabHost(context);
        ((CommonTabHost) this.fDH).b(new a());
        this.fEB = 6;
        this.fED = new int[]{1};
    }
}
