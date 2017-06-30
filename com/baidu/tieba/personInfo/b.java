package com.baidu.tieba.personInfo;

import tbclient.BookInfo;
/* loaded from: classes.dex */
public class b {
    public int TP;
    public int TY;
    public String bookId;
    public String dQh;
    public long eUq;
    public String ejr;
    public long updateTime;

    public void a(BookInfo bookInfo) {
        if (bookInfo != null) {
            this.bookId = bookInfo.book_id;
            this.dQh = bookInfo.title;
            this.ejr = bookInfo.cover;
            this.updateTime = bookInfo.update_time.intValue();
            this.TY = bookInfo.book_type.intValue();
            this.eUq = bookInfo.forum_id.longValue();
            this.TP = bookInfo.total_chapter.intValue();
        }
    }
}
