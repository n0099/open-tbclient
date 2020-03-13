package com.baidu.tieba.person.data;

import tbclient.BookInfo;
/* loaded from: classes9.dex */
public class b {
    public int cOc;
    public String cOo;
    public String jgk;
    public String jgl;
    public long jgm;
    public int jgn;
    public long updateTime;

    public void a(BookInfo bookInfo) {
        if (bookInfo != null) {
            this.cOo = bookInfo.book_id;
            this.jgk = bookInfo.title;
            this.jgl = bookInfo.cover;
            this.updateTime = bookInfo.update_time.intValue();
            this.cOc = bookInfo.book_type.intValue();
            this.jgm = bookInfo.forum_id.longValue();
            this.jgn = bookInfo.total_chapter.intValue();
        }
    }
}
