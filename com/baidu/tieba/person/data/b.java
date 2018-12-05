package com.baidu.tieba.person.data;

import tbclient.BookInfo;
/* loaded from: classes5.dex */
public class b {
    public String aqC;
    public int aqq;
    public String gqt;
    public String gqu;
    public long gqv;
    public int gqw;
    public long updateTime;

    public void a(BookInfo bookInfo) {
        if (bookInfo != null) {
            this.aqC = bookInfo.book_id;
            this.gqt = bookInfo.title;
            this.gqu = bookInfo.cover;
            this.updateTime = bookInfo.update_time.intValue();
            this.aqq = bookInfo.book_type.intValue();
            this.gqv = bookInfo.forum_id.longValue();
            this.gqw = bookInfo.total_chapter.intValue();
        }
    }
}
