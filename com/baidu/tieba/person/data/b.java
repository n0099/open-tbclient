package com.baidu.tieba.person.data;

import tbclient.BookInfo;
/* loaded from: classes9.dex */
public class b {
    public String dnK;
    public int dny;
    public String jRV;
    public String jRW;
    public long jRX;
    public int jRY;
    public long updateTime;

    public void a(BookInfo bookInfo) {
        if (bookInfo != null) {
            this.dnK = bookInfo.book_id;
            this.jRV = bookInfo.title;
            this.jRW = bookInfo.cover;
            this.updateTime = bookInfo.update_time.intValue();
            this.dny = bookInfo.book_type.intValue();
            this.jRX = bookInfo.forum_id.longValue();
            this.jRY = bookInfo.total_chapter.intValue();
        }
    }
}
