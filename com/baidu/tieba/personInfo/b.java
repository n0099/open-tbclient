package com.baidu.tieba.personInfo;

import tbclient.BookInfo;
/* loaded from: classes.dex */
public class b {
    public int UJ;
    public int UT;
    public String bookId;
    public String dFz;
    public String dYb;
    public long eEc;
    public long updateTime;

    public void a(BookInfo bookInfo) {
        if (bookInfo != null) {
            this.bookId = bookInfo.book_id;
            this.dFz = bookInfo.title;
            this.dYb = bookInfo.cover;
            this.updateTime = bookInfo.update_time.intValue();
            this.UT = bookInfo.book_type.intValue();
            this.eEc = bookInfo.forum_id.longValue();
            this.UJ = bookInfo.total_chapter.intValue();
        }
    }
}
