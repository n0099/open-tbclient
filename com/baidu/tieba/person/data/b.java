package com.baidu.tieba.person.data;

import tbclient.BookInfo;
/* loaded from: classes.dex */
public class b {
    public int aKd;
    public int aKm;
    public String aKy;
    public String fic;
    public String ggi;
    public long ggj;
    public long updateTime;

    public void a(BookInfo bookInfo) {
        if (bookInfo != null) {
            this.aKy = bookInfo.book_id;
            this.fic = bookInfo.title;
            this.ggi = bookInfo.cover;
            this.updateTime = bookInfo.update_time.intValue();
            this.aKm = bookInfo.book_type.intValue();
            this.ggj = bookInfo.forum_id.longValue();
            this.aKd = bookInfo.total_chapter.intValue();
        }
    }
}
