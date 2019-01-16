package com.baidu.tieba.person.data;

import tbclient.BookInfo;
/* loaded from: classes5.dex */
public class b {
    public int aqS;
    public String are;
    public String guo;
    public String gup;
    public long guq;
    public int gur;
    public long updateTime;

    public void a(BookInfo bookInfo) {
        if (bookInfo != null) {
            this.are = bookInfo.book_id;
            this.guo = bookInfo.title;
            this.gup = bookInfo.cover;
            this.updateTime = bookInfo.update_time.intValue();
            this.aqS = bookInfo.book_type.intValue();
            this.guq = bookInfo.forum_id.longValue();
            this.gur = bookInfo.total_chapter.intValue();
        }
    }
}
