package com.baidu.tieba.personInfo;

import tbclient.BookInfo;
/* loaded from: classes.dex */
public class b {
    public int Pn;
    public int Pw;
    public String bookId;
    public String dGt;
    public String dXy;
    public long eCE;
    public long updateTime;

    public void a(BookInfo bookInfo) {
        if (bookInfo != null) {
            this.bookId = bookInfo.book_id;
            this.dGt = bookInfo.title;
            this.dXy = bookInfo.cover;
            this.updateTime = bookInfo.update_time.intValue();
            this.Pw = bookInfo.book_type.intValue();
            this.eCE = bookInfo.forum_id.longValue();
            this.Pn = bookInfo.total_chapter.intValue();
        }
    }
}
