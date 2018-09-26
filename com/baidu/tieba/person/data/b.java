package com.baidu.tieba.person.data;

import tbclient.BookInfo;
/* loaded from: classes2.dex */
public class b {
    public int ahg;
    public String ahs;
    public String gaE;
    public String gaF;
    public long gaG;
    public int gaH;
    public long updateTime;

    public void a(BookInfo bookInfo) {
        if (bookInfo != null) {
            this.ahs = bookInfo.book_id;
            this.gaE = bookInfo.title;
            this.gaF = bookInfo.cover;
            this.updateTime = bookInfo.update_time.intValue();
            this.ahg = bookInfo.book_type.intValue();
            this.gaG = bookInfo.forum_id.longValue();
            this.gaH = bookInfo.total_chapter.intValue();
        }
    }
}
