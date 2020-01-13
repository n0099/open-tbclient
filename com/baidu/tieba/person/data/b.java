package com.baidu.tieba.person.data;

import tbclient.BookInfo;
/* loaded from: classes7.dex */
public class b {
    public int cJX;
    public String cKj;
    public String jeV;
    public String jeW;
    public long jeX;
    public int jeY;
    public long updateTime;

    public void a(BookInfo bookInfo) {
        if (bookInfo != null) {
            this.cKj = bookInfo.book_id;
            this.jeV = bookInfo.title;
            this.jeW = bookInfo.cover;
            this.updateTime = bookInfo.update_time.intValue();
            this.cJX = bookInfo.book_type.intValue();
            this.jeX = bookInfo.forum_id.longValue();
            this.jeY = bookInfo.total_chapter.intValue();
        }
    }
}
