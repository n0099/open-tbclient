package com.baidu.tieba.person.data;

import tbclient.BookInfo;
/* loaded from: classes9.dex */
public class b {
    public String dBL;
    public int dBz;
    public String kkU;
    public String kkV;
    public long kkW;
    public int kkX;
    public long updateTime;

    public void a(BookInfo bookInfo) {
        if (bookInfo != null) {
            this.dBL = bookInfo.book_id;
            this.kkU = bookInfo.title;
            this.kkV = bookInfo.cover;
            this.updateTime = bookInfo.update_time.intValue();
            this.dBz = bookInfo.book_type.intValue();
            this.kkW = bookInfo.forum_id.longValue();
            this.kkX = bookInfo.total_chapter.intValue();
        }
    }
}
