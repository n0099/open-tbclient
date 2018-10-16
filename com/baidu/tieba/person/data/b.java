package com.baidu.tieba.person.data;

import tbclient.BookInfo;
/* loaded from: classes5.dex */
public class b {
    public int amc;
    public String amo;
    public String gig;
    public String gih;
    public long gii;
    public int gij;
    public long updateTime;

    public void a(BookInfo bookInfo) {
        if (bookInfo != null) {
            this.amo = bookInfo.book_id;
            this.gig = bookInfo.title;
            this.gih = bookInfo.cover;
            this.updateTime = bookInfo.update_time.intValue();
            this.amc = bookInfo.book_type.intValue();
            this.gii = bookInfo.forum_id.longValue();
            this.gij = bookInfo.total_chapter.intValue();
        }
    }
}
