package com.baidu.tieba.person.data;

import tbclient.BookInfo;
/* loaded from: classes5.dex */
public class b {
    public String aqC;
    public int aqq;
    public String gtk;
    public String gtl;
    public long gtm;
    public int gtn;
    public long updateTime;

    public void a(BookInfo bookInfo) {
        if (bookInfo != null) {
            this.aqC = bookInfo.book_id;
            this.gtk = bookInfo.title;
            this.gtl = bookInfo.cover;
            this.updateTime = bookInfo.update_time.intValue();
            this.aqq = bookInfo.book_type.intValue();
            this.gtm = bookInfo.forum_id.longValue();
            this.gtn = bookInfo.total_chapter.intValue();
        }
    }
}
