package com.baidu.tieba.person.data;

import tbclient.BookInfo;
/* loaded from: classes16.dex */
public class b {
    public String dXK;
    public int dXm;
    public String ldA;
    public String ldB;
    public long ldC;
    public int ldD;
    public long updateTime;

    public void a(BookInfo bookInfo) {
        if (bookInfo != null) {
            this.dXK = bookInfo.book_id;
            this.ldA = bookInfo.title;
            this.ldB = bookInfo.cover;
            this.updateTime = bookInfo.update_time.intValue();
            this.dXm = bookInfo.book_type.intValue();
            this.ldC = bookInfo.forum_id.longValue();
            this.ldD = bookInfo.total_chapter.intValue();
        }
    }
}
