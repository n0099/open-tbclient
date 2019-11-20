package com.baidu.tieba.person.data;

import tbclient.BookInfo;
/* loaded from: classes4.dex */
public class b {
    public String bXF;
    public int bXt;
    public String ijB;
    public String ijC;
    public long ijD;
    public int ijE;
    public long updateTime;

    public void a(BookInfo bookInfo) {
        if (bookInfo != null) {
            this.bXF = bookInfo.book_id;
            this.ijB = bookInfo.title;
            this.ijC = bookInfo.cover;
            this.updateTime = bookInfo.update_time.intValue();
            this.bXt = bookInfo.book_type.intValue();
            this.ijD = bookInfo.forum_id.longValue();
            this.ijE = bookInfo.total_chapter.intValue();
        }
    }
}
