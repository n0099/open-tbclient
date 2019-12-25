package com.baidu.tieba.person.data;

import tbclient.BookInfo;
/* loaded from: classes6.dex */
public class b {
    public int cJM;
    public String cJY;
    public String jbs;
    public String jbt;
    public long jbu;
    public int jbv;
    public long updateTime;

    public void a(BookInfo bookInfo) {
        if (bookInfo != null) {
            this.cJY = bookInfo.book_id;
            this.jbs = bookInfo.title;
            this.jbt = bookInfo.cover;
            this.updateTime = bookInfo.update_time.intValue();
            this.cJM = bookInfo.book_type.intValue();
            this.jbu = bookInfo.forum_id.longValue();
            this.jbv = bookInfo.total_chapter.intValue();
        }
    }
}
