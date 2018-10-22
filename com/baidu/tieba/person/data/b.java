package com.baidu.tieba.person.data;

import tbclient.BookInfo;
/* loaded from: classes5.dex */
public class b {
    public int amc;
    public String amo;
    public String gih;
    public String gii;
    public long gij;
    public int gik;
    public long updateTime;

    public void a(BookInfo bookInfo) {
        if (bookInfo != null) {
            this.amo = bookInfo.book_id;
            this.gih = bookInfo.title;
            this.gii = bookInfo.cover;
            this.updateTime = bookInfo.update_time.intValue();
            this.amc = bookInfo.book_type.intValue();
            this.gij = bookInfo.forum_id.longValue();
            this.gik = bookInfo.total_chapter.intValue();
        }
    }
}
