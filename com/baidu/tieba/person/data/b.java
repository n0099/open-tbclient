package com.baidu.tieba.person.data;

import tbclient.BookInfo;
/* loaded from: classes4.dex */
public class b {
    public int bGb;
    public String bGn;
    public String ijJ;
    public String ijK;
    public long ijL;
    public int ijM;
    public long updateTime;

    public void a(BookInfo bookInfo) {
        if (bookInfo != null) {
            this.bGn = bookInfo.book_id;
            this.ijJ = bookInfo.title;
            this.ijK = bookInfo.cover;
            this.updateTime = bookInfo.update_time.intValue();
            this.bGb = bookInfo.book_type.intValue();
            this.ijL = bookInfo.forum_id.longValue();
            this.ijM = bookInfo.total_chapter.intValue();
        }
    }
}
