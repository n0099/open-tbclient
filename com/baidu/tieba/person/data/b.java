package com.baidu.tieba.person.data;

import tbclient.BookInfo;
/* loaded from: classes2.dex */
public class b {
    public String eOB;
    public int eOd;
    public String muG;
    public String muH;
    public long muI;
    public int muJ;
    public long updateTime;

    public void a(BookInfo bookInfo) {
        if (bookInfo != null) {
            this.eOB = bookInfo.book_id;
            this.muG = bookInfo.title;
            this.muH = bookInfo.cover;
            this.updateTime = bookInfo.update_time.intValue();
            this.eOd = bookInfo.book_type.intValue();
            this.muI = bookInfo.forum_id.longValue();
            this.muJ = bookInfo.total_chapter.intValue();
        }
    }
}
