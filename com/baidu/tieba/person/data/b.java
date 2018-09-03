package com.baidu.tieba.person.data;

import tbclient.BookInfo;
/* loaded from: classes2.dex */
public class b {
    public int aeF;
    public String aeR;
    public String fTo;
    public String fTp;
    public long fTq;
    public int fTr;
    public long updateTime;

    public void a(BookInfo bookInfo) {
        if (bookInfo != null) {
            this.aeR = bookInfo.book_id;
            this.fTo = bookInfo.title;
            this.fTp = bookInfo.cover;
            this.updateTime = bookInfo.update_time.intValue();
            this.aeF = bookInfo.book_type.intValue();
            this.fTq = bookInfo.forum_id.longValue();
            this.fTr = bookInfo.total_chapter.intValue();
        }
    }
}
