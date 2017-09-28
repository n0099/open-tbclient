package com.baidu.tieba.person.data;

import tbclient.BookInfo;
/* loaded from: classes.dex */
public class b {
    public int UY;
    public String VD;
    public int Vh;
    public String eZq;
    public long eZr;
    public String egg;
    public long updateTime;

    public void a(BookInfo bookInfo) {
        if (bookInfo != null) {
            this.VD = bookInfo.book_id;
            this.egg = bookInfo.title;
            this.eZq = bookInfo.cover;
            this.updateTime = bookInfo.update_time.intValue();
            this.Vh = bookInfo.book_type.intValue();
            this.eZr = bookInfo.forum_id.longValue();
            this.UY = bookInfo.total_chapter.intValue();
        }
    }
}
