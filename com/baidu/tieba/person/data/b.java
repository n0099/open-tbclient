package com.baidu.tieba.person.data;

import tbclient.BookInfo;
/* loaded from: classes21.dex */
public class b {
    public String eyK;
    public int eyl;
    public String lUB;
    public String lUC;
    public long lUD;
    public int lUE;
    public long updateTime;

    public void a(BookInfo bookInfo) {
        if (bookInfo != null) {
            this.eyK = bookInfo.book_id;
            this.lUB = bookInfo.title;
            this.lUC = bookInfo.cover;
            this.updateTime = bookInfo.update_time.intValue();
            this.eyl = bookInfo.book_type.intValue();
            this.lUD = bookInfo.forum_id.longValue();
            this.lUE = bookInfo.total_chapter.intValue();
        }
    }
}
