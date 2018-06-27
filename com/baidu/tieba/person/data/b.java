package com.baidu.tieba.person.data;

import tbclient.BookInfo;
/* loaded from: classes2.dex */
public class b {
    public int afc;
    public int afl;
    public String afx;
    public String eWX;
    public String fTl;
    public long fTm;
    public long updateTime;

    public void a(BookInfo bookInfo) {
        if (bookInfo != null) {
            this.afx = bookInfo.book_id;
            this.eWX = bookInfo.title;
            this.fTl = bookInfo.cover;
            this.updateTime = bookInfo.update_time.intValue();
            this.afl = bookInfo.book_type.intValue();
            this.fTm = bookInfo.forum_id.longValue();
            this.afc = bookInfo.total_chapter.intValue();
        }
    }
}
