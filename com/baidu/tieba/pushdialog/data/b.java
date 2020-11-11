package com.baidu.tieba.pushdialog.data;

import android.content.Context;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import tbclient.GetLockWindowMsg.LockWindowThreadInfo;
/* loaded from: classes21.dex */
public class b {
    private TbRichText mpC;
    private int postNum;
    private long tid;
    private String title;

    public void a(Context context, LockWindowThreadInfo lockWindowThreadInfo) {
        if (lockWindowThreadInfo != null) {
            this.tid = lockWindowThreadInfo.tid.longValue();
            this.title = lockWindowThreadInfo.title;
            this.postNum = lockWindowThreadInfo.post_num.intValue();
            if (!y.isEmpty(lockWindowThreadInfo.content)) {
                this.mpC = TbRichTextView.a(context, lockWindowThreadInfo.content, true);
            }
        }
    }

    public long getTid() {
        return this.tid;
    }

    public String getTitle() {
        return this.title;
    }

    public int getPostNum() {
        return this.postNum;
    }

    public TbRichText dzi() {
        return this.mpC;
    }
}
