package com.baidu.tieba.personInfo;

import tbclient.BookInfo;
/* loaded from: classes.dex */
public class c {
    public int NC;
    public int Nt;
    public String bookId;
    public String dPX;
    public String dzu;
    public long eAg;
    public long updateTime;

    public void a(BookInfo bookInfo) {
        if (bookInfo != null) {
            this.bookId = bookInfo.book_id;
            this.dzu = bookInfo.title;
            this.dPX = bookInfo.cover;
            this.updateTime = bookInfo.update_time.intValue();
            this.NC = bookInfo.book_type.intValue();
            this.eAg = bookInfo.forum_id.longValue();
            this.Nt = bookInfo.total_chapter.intValue();
        }
    }
}
