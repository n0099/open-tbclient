package com.baidu.tieba.person.data;

import tbclient.BookInfo;
/* loaded from: classes4.dex */
public class b {
    public int bxH;
    public String bxT;
    public String hKE;
    public String hKF;
    public long hKG;
    public int hKH;
    public long updateTime;

    public void a(BookInfo bookInfo) {
        if (bookInfo != null) {
            this.bxT = bookInfo.book_id;
            this.hKE = bookInfo.title;
            this.hKF = bookInfo.cover;
            this.updateTime = bookInfo.update_time.intValue();
            this.bxH = bookInfo.book_type.intValue();
            this.hKG = bookInfo.forum_id.longValue();
            this.hKH = bookInfo.total_chapter.intValue();
        }
    }
}
