package com.baidu.tieba.personInfo;

import tbclient.BookInfo;
/* loaded from: classes.dex */
public class b {
    public int Qh;
    public int Qq;
    public String bookId;
    public String dSK;
    public long ePn;
    public String ejU;
    public long updateTime;

    public void a(BookInfo bookInfo) {
        if (bookInfo != null) {
            this.bookId = bookInfo.book_id;
            this.dSK = bookInfo.title;
            this.ejU = bookInfo.cover;
            this.updateTime = bookInfo.update_time.intValue();
            this.Qq = bookInfo.book_type.intValue();
            this.ePn = bookInfo.forum_id.longValue();
            this.Qh = bookInfo.total_chapter.intValue();
        }
    }
}
