package com.baidu.tieba.personInfo;

import tbclient.BookInfo;
/* loaded from: classes.dex */
public class b {
    public int PO;
    public int PY;
    public String bookId;
    public String dNf;
    public long eIO;
    public String edX;
    public long updateTime;

    public void a(BookInfo bookInfo) {
        if (bookInfo != null) {
            this.bookId = bookInfo.book_id;
            this.dNf = bookInfo.title;
            this.edX = bookInfo.cover;
            this.updateTime = bookInfo.update_time.intValue();
            this.PY = bookInfo.book_type.intValue();
            this.eIO = bookInfo.forum_id.longValue();
            this.PO = bookInfo.total_chapter.intValue();
        }
    }
}
