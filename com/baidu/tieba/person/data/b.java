package com.baidu.tieba.person.data;

import tbclient.BookInfo;
/* loaded from: classes7.dex */
public class b {
    public int cJX;
    public String cKj;
    public String jfa;
    public String jfb;
    public long jfc;
    public int jfd;
    public long updateTime;

    public void a(BookInfo bookInfo) {
        if (bookInfo != null) {
            this.cKj = bookInfo.book_id;
            this.jfa = bookInfo.title;
            this.jfb = bookInfo.cover;
            this.updateTime = bookInfo.update_time.intValue();
            this.cJX = bookInfo.book_type.intValue();
            this.jfc = bookInfo.forum_id.longValue();
            this.jfd = bookInfo.total_chapter.intValue();
        }
    }
}
