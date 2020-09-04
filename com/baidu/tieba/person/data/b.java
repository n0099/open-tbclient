package com.baidu.tieba.person.data;

import tbclient.BookInfo;
/* loaded from: classes16.dex */
public class b {
    public String dXO;
    public int dXq;
    public String ldH;
    public String ldI;
    public long ldJ;
    public int ldK;
    public long updateTime;

    public void a(BookInfo bookInfo) {
        if (bookInfo != null) {
            this.dXO = bookInfo.book_id;
            this.ldH = bookInfo.title;
            this.ldI = bookInfo.cover;
            this.updateTime = bookInfo.update_time.intValue();
            this.dXq = bookInfo.book_type.intValue();
            this.ldJ = bookInfo.forum_id.longValue();
            this.ldK = bookInfo.total_chapter.intValue();
        }
    }
}
