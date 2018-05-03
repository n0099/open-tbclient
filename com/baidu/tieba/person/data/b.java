package com.baidu.tieba.person.data;

import tbclient.BookInfo;
/* loaded from: classes2.dex */
public class b {
    public int WL;
    public int WU;
    public String Xg;
    public String eGE;
    public String fCJ;
    public long fCK;
    public long updateTime;

    public void a(BookInfo bookInfo) {
        if (bookInfo != null) {
            this.Xg = bookInfo.book_id;
            this.eGE = bookInfo.title;
            this.fCJ = bookInfo.cover;
            this.updateTime = bookInfo.update_time.intValue();
            this.WU = bookInfo.book_type.intValue();
            this.fCK = bookInfo.forum_id.longValue();
            this.WL = bookInfo.total_chapter.intValue();
        }
    }
}
