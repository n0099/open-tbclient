package com.baidu.tieba.personInfo;

import tbclient.BookInfo;
/* loaded from: classes.dex */
public class b {
    public int UJ;
    public int UT;
    public String Vp;
    public String ejV;
    public String fjj;
    public long fjk;
    public long updateTime;

    public void a(BookInfo bookInfo) {
        if (bookInfo != null) {
            this.Vp = bookInfo.book_id;
            this.ejV = bookInfo.title;
            this.fjj = bookInfo.cover;
            this.updateTime = bookInfo.update_time.intValue();
            this.UT = bookInfo.book_type.intValue();
            this.fjk = bookInfo.forum_id.longValue();
            this.UJ = bookInfo.total_chapter.intValue();
        }
    }
}
