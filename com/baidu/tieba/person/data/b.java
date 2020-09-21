package com.baidu.tieba.person.data;

import tbclient.BookInfo;
/* loaded from: classes21.dex */
public class b {
    public int dZA;
    public String dZY;
    public long lmA;
    public int lmB;
    public String lmy;
    public String lmz;
    public long updateTime;

    public void a(BookInfo bookInfo) {
        if (bookInfo != null) {
            this.dZY = bookInfo.book_id;
            this.lmy = bookInfo.title;
            this.lmz = bookInfo.cover;
            this.updateTime = bookInfo.update_time.intValue();
            this.dZA = bookInfo.book_type.intValue();
            this.lmA = bookInfo.forum_id.longValue();
            this.lmB = bookInfo.total_chapter.intValue();
        }
    }
}
