package com.baidu.tieba.person.data;

import tbclient.BookInfo;
/* loaded from: classes4.dex */
public class b {
    public int bYk;
    public String bYw;
    public String iks;
    public String ikt;
    public long iku;
    public int ikv;
    public long updateTime;

    public void a(BookInfo bookInfo) {
        if (bookInfo != null) {
            this.bYw = bookInfo.book_id;
            this.iks = bookInfo.title;
            this.ikt = bookInfo.cover;
            this.updateTime = bookInfo.update_time.intValue();
            this.bYk = bookInfo.book_type.intValue();
            this.iku = bookInfo.forum_id.longValue();
            this.ikv = bookInfo.total_chapter.intValue();
        }
    }
}
