package com.baidu.tieba.person.data;

import tbclient.BookInfo;
/* loaded from: classes4.dex */
public class b {
    public int bxM;
    public String bxY;
    public String hKl;
    public String hKm;
    public long hKn;
    public int hKo;
    public long updateTime;

    public void a(BookInfo bookInfo) {
        if (bookInfo != null) {
            this.bxY = bookInfo.book_id;
            this.hKl = bookInfo.title;
            this.hKm = bookInfo.cover;
            this.updateTime = bookInfo.update_time.intValue();
            this.bxM = bookInfo.book_type.intValue();
            this.hKn = bookInfo.forum_id.longValue();
            this.hKo = bookInfo.total_chapter.intValue();
        }
    }
}
