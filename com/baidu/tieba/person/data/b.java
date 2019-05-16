package com.baidu.tieba.person.data;

import tbclient.BookInfo;
/* loaded from: classes4.dex */
public class b {
    public int bEY;
    public String bFk;
    public String icl;
    public String icm;
    public long icn;
    public int ico;
    public long updateTime;

    public void a(BookInfo bookInfo) {
        if (bookInfo != null) {
            this.bFk = bookInfo.book_id;
            this.icl = bookInfo.title;
            this.icm = bookInfo.cover;
            this.updateTime = bookInfo.update_time.intValue();
            this.bEY = bookInfo.book_type.intValue();
            this.icn = bookInfo.forum_id.longValue();
            this.ico = bookInfo.total_chapter.intValue();
        }
    }
}
