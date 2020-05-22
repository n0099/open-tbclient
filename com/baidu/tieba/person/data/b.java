package com.baidu.tieba.person.data;

import tbclient.BookInfo;
/* loaded from: classes9.dex */
public class b {
    public String dBL;
    public int dBz;
    public String kjO;
    public String kjP;
    public long kjQ;
    public int kjR;
    public long updateTime;

    public void a(BookInfo bookInfo) {
        if (bookInfo != null) {
            this.dBL = bookInfo.book_id;
            this.kjO = bookInfo.title;
            this.kjP = bookInfo.cover;
            this.updateTime = bookInfo.update_time.intValue();
            this.dBz = bookInfo.book_type.intValue();
            this.kjQ = bookInfo.forum_id.longValue();
            this.kjR = bookInfo.total_chapter.intValue();
        }
    }
}
