package com.baidu.tieba.personInfo;

import tbclient.BookInfo;
/* loaded from: classes.dex */
public class b {
    public int VH;
    public int VQ;
    public String bookId;
    public String ecs;
    public String exO;
    public long fjY;
    public long updateTime;

    public void a(BookInfo bookInfo) {
        if (bookInfo != null) {
            this.bookId = bookInfo.book_id;
            this.ecs = bookInfo.title;
            this.exO = bookInfo.cover;
            this.updateTime = bookInfo.update_time.intValue();
            this.VQ = bookInfo.book_type.intValue();
            this.fjY = bookInfo.forum_id.longValue();
            this.VH = bookInfo.total_chapter.intValue();
        }
    }
}
