package com.baidu.tieba.person.data;

import tbclient.BookInfo;
/* loaded from: classes4.dex */
public class b {
    public int bxN;
    public String bxZ;
    public String hKm;
    public String hKn;
    public long hKo;
    public int hKp;
    public long updateTime;

    public void a(BookInfo bookInfo) {
        if (bookInfo != null) {
            this.bxZ = bookInfo.book_id;
            this.hKm = bookInfo.title;
            this.hKn = bookInfo.cover;
            this.updateTime = bookInfo.update_time.intValue();
            this.bxN = bookInfo.book_type.intValue();
            this.hKo = bookInfo.forum_id.longValue();
            this.hKp = bookInfo.total_chapter.intValue();
        }
    }
}
