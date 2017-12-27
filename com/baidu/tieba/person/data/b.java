package com.baidu.tieba.person.data;

import tbclient.BookInfo;
/* loaded from: classes.dex */
public class b {
    public String aKA;
    public int aKf;
    public int aKo;
    public String fgD;
    public String geH;
    public long geI;
    public long updateTime;

    public void a(BookInfo bookInfo) {
        if (bookInfo != null) {
            this.aKA = bookInfo.book_id;
            this.fgD = bookInfo.title;
            this.geH = bookInfo.cover;
            this.updateTime = bookInfo.update_time.intValue();
            this.aKo = bookInfo.book_type.intValue();
            this.geI = bookInfo.forum_id.longValue();
            this.aKf = bookInfo.total_chapter.intValue();
        }
    }
}
