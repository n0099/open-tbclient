package com.baidu.tieba.person.data;

import tbclient.BookInfo;
/* loaded from: classes2.dex */
public class b {
    public int ePb;
    public String ePz;
    public String mnS;
    public String mnT;
    public long mnU;
    public int mnV;
    public long updateTime;

    public void a(BookInfo bookInfo) {
        if (bookInfo != null) {
            this.ePz = bookInfo.book_id;
            this.mnS = bookInfo.title;
            this.mnT = bookInfo.cover;
            this.updateTime = bookInfo.update_time.intValue();
            this.ePb = bookInfo.book_type.intValue();
            this.mnU = bookInfo.forum_id.longValue();
            this.mnV = bookInfo.total_chapter.intValue();
        }
    }
}
