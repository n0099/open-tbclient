package com.baidu.tieba.person.data;

import tbclient.BookInfo;
/* loaded from: classes9.dex */
public class b {
    public int cOb;
    public String cOn;
    public String jfY;
    public String jfZ;
    public long jga;
    public int jgb;
    public long updateTime;

    public void a(BookInfo bookInfo) {
        if (bookInfo != null) {
            this.cOn = bookInfo.book_id;
            this.jfY = bookInfo.title;
            this.jfZ = bookInfo.cover;
            this.updateTime = bookInfo.update_time.intValue();
            this.cOb = bookInfo.book_type.intValue();
            this.jga = bookInfo.forum_id.longValue();
            this.jgb = bookInfo.total_chapter.intValue();
        }
    }
}
