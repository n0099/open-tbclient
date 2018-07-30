package com.baidu.tieba.person.data;

import tbclient.BookInfo;
/* loaded from: classes2.dex */
public class b {
    public int aeF;
    public String aeR;
    public String fTw;
    public String fTx;
    public long fTy;
    public int fTz;
    public long updateTime;

    public void a(BookInfo bookInfo) {
        if (bookInfo != null) {
            this.aeR = bookInfo.book_id;
            this.fTw = bookInfo.title;
            this.fTx = bookInfo.cover;
            this.updateTime = bookInfo.update_time.intValue();
            this.aeF = bookInfo.book_type.intValue();
            this.fTy = bookInfo.forum_id.longValue();
            this.fTz = bookInfo.total_chapter.intValue();
        }
    }
}
