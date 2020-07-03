package com.baidu.tieba.person.data;

import tbclient.BookInfo;
/* loaded from: classes9.dex */
public class b {
    public int dHS;
    public String dIg;
    public String kEG;
    public String kEH;
    public long kEI;
    public int kEJ;
    public long updateTime;

    public void a(BookInfo bookInfo) {
        if (bookInfo != null) {
            this.dIg = bookInfo.book_id;
            this.kEG = bookInfo.title;
            this.kEH = bookInfo.cover;
            this.updateTime = bookInfo.update_time.intValue();
            this.dHS = bookInfo.book_type.intValue();
            this.kEI = bookInfo.forum_id.longValue();
            this.kEJ = bookInfo.total_chapter.intValue();
        }
    }
}
