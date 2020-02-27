package com.baidu.tieba.person.data;

import tbclient.BookInfo;
/* loaded from: classes9.dex */
public class b {
    public int cOa;
    public String cOm;
    public String jfW;
    public String jfX;
    public long jfY;
    public int jfZ;
    public long updateTime;

    public void a(BookInfo bookInfo) {
        if (bookInfo != null) {
            this.cOm = bookInfo.book_id;
            this.jfW = bookInfo.title;
            this.jfX = bookInfo.cover;
            this.updateTime = bookInfo.update_time.intValue();
            this.cOa = bookInfo.book_type.intValue();
            this.jfY = bookInfo.forum_id.longValue();
            this.jfZ = bookInfo.total_chapter.intValue();
        }
    }
}
