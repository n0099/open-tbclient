package com.baidu.tieba.person.data;

import tbclient.BookInfo;
/* loaded from: classes4.dex */
public class b {
    public int bxJ;
    public String bxV;
    public String hKA;
    public long hKB;
    public int hKC;
    public String hKz;
    public long updateTime;

    public void a(BookInfo bookInfo) {
        if (bookInfo != null) {
            this.bxV = bookInfo.book_id;
            this.hKz = bookInfo.title;
            this.hKA = bookInfo.cover;
            this.updateTime = bookInfo.update_time.intValue();
            this.bxJ = bookInfo.book_type.intValue();
            this.hKB = bookInfo.forum_id.longValue();
            this.hKC = bookInfo.total_chapter.intValue();
        }
    }
}
