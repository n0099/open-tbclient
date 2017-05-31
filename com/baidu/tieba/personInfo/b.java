package com.baidu.tieba.personInfo;

import tbclient.BookInfo;
/* loaded from: classes.dex */
public class b {
    public int TQ;
    public int TZ;
    public String bookId;
    public String dHK;
    public long eKs;
    public String eaw;
    public long updateTime;

    public void a(BookInfo bookInfo) {
        if (bookInfo != null) {
            this.bookId = bookInfo.book_id;
            this.dHK = bookInfo.title;
            this.eaw = bookInfo.cover;
            this.updateTime = bookInfo.update_time.intValue();
            this.TZ = bookInfo.book_type.intValue();
            this.eKs = bookInfo.forum_id.longValue();
            this.TQ = bookInfo.total_chapter.intValue();
        }
    }
}
