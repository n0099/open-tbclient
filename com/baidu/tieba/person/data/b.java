package com.baidu.tieba.person.data;

import tbclient.BookInfo;
/* loaded from: classes2.dex */
public class b {
    public int ePb;
    public String ePz;
    public String mnR;
    public String mnS;
    public long mnT;
    public int mnU;
    public long updateTime;

    public void a(BookInfo bookInfo) {
        if (bookInfo != null) {
            this.ePz = bookInfo.book_id;
            this.mnR = bookInfo.title;
            this.mnS = bookInfo.cover;
            this.updateTime = bookInfo.update_time.intValue();
            this.ePb = bookInfo.book_type.intValue();
            this.mnT = bookInfo.forum_id.longValue();
            this.mnU = bookInfo.total_chapter.intValue();
        }
    }
}
