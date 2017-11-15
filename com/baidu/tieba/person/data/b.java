package com.baidu.tieba.person.data;

import tbclient.BookInfo;
/* loaded from: classes.dex */
public class b {
    public String VJ;
    public int Ve;
    public int Vn;
    public String enE;
    public String fhP;
    public long fhQ;
    public long updateTime;

    public void a(BookInfo bookInfo) {
        if (bookInfo != null) {
            this.VJ = bookInfo.book_id;
            this.enE = bookInfo.title;
            this.fhP = bookInfo.cover;
            this.updateTime = bookInfo.update_time.intValue();
            this.Vn = bookInfo.book_type.intValue();
            this.fhQ = bookInfo.forum_id.longValue();
            this.Ve = bookInfo.total_chapter.intValue();
        }
    }
}
