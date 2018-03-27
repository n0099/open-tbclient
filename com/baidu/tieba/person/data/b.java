package com.baidu.tieba.person.data;

import tbclient.BookInfo;
/* loaded from: classes.dex */
public class b {
    public String aLL;
    public int aLq;
    public int aLz;
    public String fme;
    public String gip;
    public long giq;
    public long updateTime;

    public void a(BookInfo bookInfo) {
        if (bookInfo != null) {
            this.aLL = bookInfo.book_id;
            this.fme = bookInfo.title;
            this.gip = bookInfo.cover;
            this.updateTime = bookInfo.update_time.intValue();
            this.aLz = bookInfo.book_type.intValue();
            this.giq = bookInfo.forum_id.longValue();
            this.aLq = bookInfo.total_chapter.intValue();
        }
    }
}
