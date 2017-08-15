package com.baidu.tieba.personInfo;

import tbclient.BookInfo;
/* loaded from: classes.dex */
public class b {
    public int VG;
    public int VP;
    public String bookId;
    public String ecs;
    public String exM;
    public long fjW;
    public long updateTime;

    public void a(BookInfo bookInfo) {
        if (bookInfo != null) {
            this.bookId = bookInfo.book_id;
            this.ecs = bookInfo.title;
            this.exM = bookInfo.cover;
            this.updateTime = bookInfo.update_time.intValue();
            this.VP = bookInfo.book_type.intValue();
            this.fjW = bookInfo.forum_id.longValue();
            this.VG = bookInfo.total_chapter.intValue();
        }
    }
}
