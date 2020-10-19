package com.baidu.tieba.person.data;

import tbclient.BookInfo;
/* loaded from: classes22.dex */
public class b {
    public int elC;
    public String ema;
    public String lBQ;
    public String lBR;
    public long lBS;
    public int lBT;
    public long updateTime;

    public void a(BookInfo bookInfo) {
        if (bookInfo != null) {
            this.ema = bookInfo.book_id;
            this.lBQ = bookInfo.title;
            this.lBR = bookInfo.cover;
            this.updateTime = bookInfo.update_time.intValue();
            this.elC = bookInfo.book_type.intValue();
            this.lBS = bookInfo.forum_id.longValue();
            this.lBT = bookInfo.total_chapter.intValue();
        }
    }
}
