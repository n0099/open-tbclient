package com.baidu.tieba.personInfo;

import tbclient.BookInfo;
/* loaded from: classes.dex */
public class b {
    public int PQ;
    public int Qa;
    public String bookId;
    public String dLj;
    public long eGK;
    public String ecc;
    public long updateTime;

    public void a(BookInfo bookInfo) {
        if (bookInfo != null) {
            this.bookId = bookInfo.book_id;
            this.dLj = bookInfo.title;
            this.ecc = bookInfo.cover;
            this.updateTime = bookInfo.update_time.intValue();
            this.Qa = bookInfo.book_type.intValue();
            this.eGK = bookInfo.forum_id.longValue();
            this.PQ = bookInfo.total_chapter.intValue();
        }
    }
}
