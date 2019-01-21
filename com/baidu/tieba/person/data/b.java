package com.baidu.tieba.person.data;

import tbclient.BookInfo;
/* loaded from: classes5.dex */
public class b {
    public int aqT;
    public String arf;
    public String gup;
    public String guq;
    public long gur;
    public int gus;
    public long updateTime;

    public void a(BookInfo bookInfo) {
        if (bookInfo != null) {
            this.arf = bookInfo.book_id;
            this.gup = bookInfo.title;
            this.guq = bookInfo.cover;
            this.updateTime = bookInfo.update_time.intValue();
            this.aqT = bookInfo.book_type.intValue();
            this.gur = bookInfo.forum_id.longValue();
            this.gus = bookInfo.total_chapter.intValue();
        }
    }
}
