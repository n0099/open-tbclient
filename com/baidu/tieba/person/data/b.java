package com.baidu.tieba.person.data;

import tbclient.BookInfo;
/* loaded from: classes2.dex */
public class b {
    public int eMC;
    public String eNa;
    public String msp;
    public String msq;
    public long msr;
    public int mss;
    public long updateTime;

    public void a(BookInfo bookInfo) {
        if (bookInfo != null) {
            this.eNa = bookInfo.book_id;
            this.msp = bookInfo.title;
            this.msq = bookInfo.cover;
            this.updateTime = bookInfo.update_time.intValue();
            this.eMC = bookInfo.book_type.intValue();
            this.msr = bookInfo.forum_id.longValue();
            this.mss = bookInfo.total_chapter.intValue();
        }
    }
}
