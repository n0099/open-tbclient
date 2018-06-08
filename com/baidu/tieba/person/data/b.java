package com.baidu.tieba.person.data;

import tbclient.BookInfo;
/* loaded from: classes2.dex */
public class b {
    public int aeN;
    public int aeW;
    public String afi;
    public String eTf;
    public String fPj;
    public long fPk;
    public long updateTime;

    public void a(BookInfo bookInfo) {
        if (bookInfo != null) {
            this.afi = bookInfo.book_id;
            this.eTf = bookInfo.title;
            this.fPj = bookInfo.cover;
            this.updateTime = bookInfo.update_time.intValue();
            this.aeW = bookInfo.book_type.intValue();
            this.fPk = bookInfo.forum_id.longValue();
            this.aeN = bookInfo.total_chapter.intValue();
        }
    }
}
