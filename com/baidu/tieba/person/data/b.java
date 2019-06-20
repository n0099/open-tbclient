package com.baidu.tieba.person.data;

import tbclient.BookInfo;
/* loaded from: classes4.dex */
public class b {
    public int bEZ;
    public String bFl;
    public String icp;
    public String icq;
    public long icr;
    public int ics;
    public long updateTime;

    public void a(BookInfo bookInfo) {
        if (bookInfo != null) {
            this.bFl = bookInfo.book_id;
            this.icp = bookInfo.title;
            this.icq = bookInfo.cover;
            this.updateTime = bookInfo.update_time.intValue();
            this.bEZ = bookInfo.book_type.intValue();
            this.icr = bookInfo.forum_id.longValue();
            this.ics = bookInfo.total_chapter.intValue();
        }
    }
}
