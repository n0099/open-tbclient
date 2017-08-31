package com.baidu.tieba.personInfo;

import tbclient.BookInfo;
/* loaded from: classes.dex */
public class b {
    public int UJ;
    public int UT;
    public String Vp;
    public String ejb;
    public String fip;
    public long fiq;
    public long updateTime;

    public void a(BookInfo bookInfo) {
        if (bookInfo != null) {
            this.Vp = bookInfo.book_id;
            this.ejb = bookInfo.title;
            this.fip = bookInfo.cover;
            this.updateTime = bookInfo.update_time.intValue();
            this.UT = bookInfo.book_type.intValue();
            this.fiq = bookInfo.forum_id.longValue();
            this.UJ = bookInfo.total_chapter.intValue();
        }
    }
}
