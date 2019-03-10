package com.baidu.tieba.person.data;

import tbclient.BookInfo;
/* loaded from: classes4.dex */
public class b {
    public int bxH;
    public String bxT;
    public String hKF;
    public String hKG;
    public long hKH;
    public int hKI;
    public long updateTime;

    public void a(BookInfo bookInfo) {
        if (bookInfo != null) {
            this.bxT = bookInfo.book_id;
            this.hKF = bookInfo.title;
            this.hKG = bookInfo.cover;
            this.updateTime = bookInfo.update_time.intValue();
            this.bxH = bookInfo.book_type.intValue();
            this.hKH = bookInfo.forum_id.longValue();
            this.hKI = bookInfo.total_chapter.intValue();
        }
    }
}
