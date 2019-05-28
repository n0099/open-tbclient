package com.baidu.tieba.person.data;

import tbclient.BookInfo;
/* loaded from: classes4.dex */
public class b {
    public int bEY;
    public String bFk;
    public String ico;
    public String icp;
    public long icq;
    public int icr;
    public long updateTime;

    public void a(BookInfo bookInfo) {
        if (bookInfo != null) {
            this.bFk = bookInfo.book_id;
            this.ico = bookInfo.title;
            this.icp = bookInfo.cover;
            this.updateTime = bookInfo.update_time.intValue();
            this.bEY = bookInfo.book_type.intValue();
            this.icq = bookInfo.forum_id.longValue();
            this.icr = bookInfo.total_chapter.intValue();
        }
    }
}
