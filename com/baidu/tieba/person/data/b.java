package com.baidu.tieba.person.data;

import tbclient.BookInfo;
/* loaded from: classes22.dex */
public class b {
    public String euA;
    public int euc;
    public String lOn;
    public String lOo;
    public long lOp;
    public int lOq;
    public long updateTime;

    public void a(BookInfo bookInfo) {
        if (bookInfo != null) {
            this.euA = bookInfo.book_id;
            this.lOn = bookInfo.title;
            this.lOo = bookInfo.cover;
            this.updateTime = bookInfo.update_time.intValue();
            this.euc = bookInfo.book_type.intValue();
            this.lOp = bookInfo.forum_id.longValue();
            this.lOq = bookInfo.total_chapter.intValue();
        }
    }
}
