package com.baidu.tieba.personInfo;

import tbclient.BookInfo;
/* loaded from: classes.dex */
public class b {
    public int VE;
    public int VN;
    public String bookId;
    public String eaw;
    public String evR;
    public long fib;
    public long updateTime;

    public void a(BookInfo bookInfo) {
        if (bookInfo != null) {
            this.bookId = bookInfo.book_id;
            this.eaw = bookInfo.title;
            this.evR = bookInfo.cover;
            this.updateTime = bookInfo.update_time.intValue();
            this.VN = bookInfo.book_type.intValue();
            this.fib = bookInfo.forum_id.longValue();
            this.VE = bookInfo.total_chapter.intValue();
        }
    }
}
