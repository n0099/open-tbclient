package com.baidu.tieba.person.data;

import tbclient.BookInfo;
/* loaded from: classes4.dex */
public class b {
    public int bGa;
    public String bGm;
    public String iiH;
    public String iiI;
    public long iiJ;
    public int iiK;
    public long updateTime;

    public void a(BookInfo bookInfo) {
        if (bookInfo != null) {
            this.bGm = bookInfo.book_id;
            this.iiH = bookInfo.title;
            this.iiI = bookInfo.cover;
            this.updateTime = bookInfo.update_time.intValue();
            this.bGa = bookInfo.book_type.intValue();
            this.iiJ = bookInfo.forum_id.longValue();
            this.iiK = bookInfo.total_chapter.intValue();
        }
    }
}
