package com.baidu.tieba.person.data;

import tbclient.BookInfo;
/* loaded from: classes.dex */
public class b {
    public String VJ;
    public int Ve;
    public int Vn;
    public String enA;
    public String fht;
    public long fhu;
    public long updateTime;

    public void a(BookInfo bookInfo) {
        if (bookInfo != null) {
            this.VJ = bookInfo.book_id;
            this.enA = bookInfo.title;
            this.fht = bookInfo.cover;
            this.updateTime = bookInfo.update_time.intValue();
            this.Vn = bookInfo.book_type.intValue();
            this.fhu = bookInfo.forum_id.longValue();
            this.Ve = bookInfo.total_chapter.intValue();
        }
    }
}
