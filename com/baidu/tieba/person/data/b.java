package com.baidu.tieba.person.data;

import tbclient.BookInfo;
/* loaded from: classes2.dex */
public class b {
    public int WM;
    public int WV;
    public String Xh;
    public String eHM;
    public String fDP;
    public long fDQ;
    public long updateTime;

    public void a(BookInfo bookInfo) {
        if (bookInfo != null) {
            this.Xh = bookInfo.book_id;
            this.eHM = bookInfo.title;
            this.fDP = bookInfo.cover;
            this.updateTime = bookInfo.update_time.intValue();
            this.WV = bookInfo.book_type.intValue();
            this.fDQ = bookInfo.forum_id.longValue();
            this.WM = bookInfo.total_chapter.intValue();
        }
    }
}
