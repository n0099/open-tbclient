package com.baidu.tieba.personInfo;

import tbclient.BookInfo;
/* loaded from: classes.dex */
public class b {
    public int Up;
    public int Uy;
    public String bookId;
    public String dJa;
    public long eGg;
    public String eas;
    public long updateTime;

    public void a(BookInfo bookInfo) {
        if (bookInfo != null) {
            this.bookId = bookInfo.book_id;
            this.dJa = bookInfo.title;
            this.eas = bookInfo.cover;
            this.updateTime = bookInfo.update_time.intValue();
            this.Uy = bookInfo.book_type.intValue();
            this.eGg = bookInfo.forum_id.longValue();
            this.Up = bookInfo.total_chapter.intValue();
        }
    }
}
