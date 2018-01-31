package com.baidu.tieba.person.data;

import tbclient.BookInfo;
/* loaded from: classes.dex */
public class b {
    public String aKB;
    public int aKg;
    public int aKp;
    public String fiz;
    public String ggB;
    public long ggC;
    public long updateTime;

    public void a(BookInfo bookInfo) {
        if (bookInfo != null) {
            this.aKB = bookInfo.book_id;
            this.fiz = bookInfo.title;
            this.ggB = bookInfo.cover;
            this.updateTime = bookInfo.update_time.intValue();
            this.aKp = bookInfo.book_type.intValue();
            this.ggC = bookInfo.forum_id.longValue();
            this.aKg = bookInfo.total_chapter.intValue();
        }
    }
}
