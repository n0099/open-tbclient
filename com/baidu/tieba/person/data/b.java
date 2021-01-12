package com.baidu.tieba.person.data;

import tbclient.BookInfo;
/* loaded from: classes2.dex */
public class b {
    public String eKO;
    public int eKq;
    public String mjn;
    public String mjo;
    public long mjp;
    public int mjq;
    public long updateTime;

    public void a(BookInfo bookInfo) {
        if (bookInfo != null) {
            this.eKO = bookInfo.book_id;
            this.mjn = bookInfo.title;
            this.mjo = bookInfo.cover;
            this.updateTime = bookInfo.update_time.intValue();
            this.eKq = bookInfo.book_type.intValue();
            this.mjp = bookInfo.forum_id.longValue();
            this.mjq = bookInfo.total_chapter.intValue();
        }
    }
}
