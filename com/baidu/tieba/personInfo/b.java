package com.baidu.tieba.personInfo;

import tbclient.BookInfo;
/* loaded from: classes.dex */
public class b {
    public int Uf;
    public int Uo;
    public String bookId;
    public String dZf;
    public String euA;
    public long fgP;
    public long updateTime;

    public void a(BookInfo bookInfo) {
        if (bookInfo != null) {
            this.bookId = bookInfo.book_id;
            this.dZf = bookInfo.title;
            this.euA = bookInfo.cover;
            this.updateTime = bookInfo.update_time.intValue();
            this.Uo = bookInfo.book_type.intValue();
            this.fgP = bookInfo.forum_id.longValue();
            this.Uf = bookInfo.total_chapter.intValue();
        }
    }
}
