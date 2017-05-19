package com.baidu.tieba.personInfo;

import tbclient.BookInfo;
/* loaded from: classes.dex */
public class b {
    public int Ud;
    public int Um;
    public String bookId;
    public String dCm;
    public String dVa;
    public long eBG;
    public long updateTime;

    public void a(BookInfo bookInfo) {
        if (bookInfo != null) {
            this.bookId = bookInfo.book_id;
            this.dCm = bookInfo.title;
            this.dVa = bookInfo.cover;
            this.updateTime = bookInfo.update_time.intValue();
            this.Um = bookInfo.book_type.intValue();
            this.eBG = bookInfo.forum_id.longValue();
            this.Ud = bookInfo.total_chapter.intValue();
        }
    }
}
