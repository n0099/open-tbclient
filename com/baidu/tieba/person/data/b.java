package com.baidu.tieba.person.data;

import tbclient.BookInfo;
/* loaded from: classes9.dex */
public class b {
    public String cOB;
    public int cOp;
    public String jhJ;
    public String jhK;
    public long jhL;
    public int jhM;
    public long updateTime;

    public void a(BookInfo bookInfo) {
        if (bookInfo != null) {
            this.cOB = bookInfo.book_id;
            this.jhJ = bookInfo.title;
            this.jhK = bookInfo.cover;
            this.updateTime = bookInfo.update_time.intValue();
            this.cOp = bookInfo.book_type.intValue();
            this.jhL = bookInfo.forum_id.longValue();
            this.jhM = bookInfo.total_chapter.intValue();
        }
    }
}
