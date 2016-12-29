package com.baidu.tieba.personInfo;

import tbclient.BookInfo;
/* loaded from: classes.dex */
public class b {
    public int Qe;
    public int Qn;
    public String bookId;
    public String dOC;
    public String dxm;
    public long esJ;
    public long updateTime;

    public void a(BookInfo bookInfo) {
        if (bookInfo != null) {
            this.bookId = bookInfo.book_id;
            this.dxm = bookInfo.title;
            this.dOC = bookInfo.cover;
            this.updateTime = bookInfo.update_time.intValue();
            this.Qn = bookInfo.book_type.intValue();
            this.esJ = bookInfo.forum_id.longValue();
            this.Qe = bookInfo.total_chapter.intValue();
        }
    }
}
