package com.baidu.tieba.person.data;

import tbclient.BookInfo;
/* loaded from: classes9.dex */
public class b {
    public String dnG;
    public int dnu;
    public String jRR;
    public String jRS;
    public long jRT;
    public int jRU;
    public long updateTime;

    public void a(BookInfo bookInfo) {
        if (bookInfo != null) {
            this.dnG = bookInfo.book_id;
            this.jRR = bookInfo.title;
            this.jRS = bookInfo.cover;
            this.updateTime = bookInfo.update_time.intValue();
            this.dnu = bookInfo.book_type.intValue();
            this.jRT = bookInfo.forum_id.longValue();
            this.jRU = bookInfo.total_chapter.intValue();
        }
    }
}
