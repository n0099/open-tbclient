package com.baidu.tieba.personInfo;

import tbclient.BookInfo;
/* loaded from: classes.dex */
public class b {
    public int UL;
    public int UV;
    public String bookId;
    public String dHP;
    public long eGs;
    public String ear;
    public long updateTime;

    public void a(BookInfo bookInfo) {
        if (bookInfo != null) {
            this.bookId = bookInfo.book_id;
            this.dHP = bookInfo.title;
            this.ear = bookInfo.cover;
            this.updateTime = bookInfo.update_time.intValue();
            this.UV = bookInfo.book_type.intValue();
            this.eGs = bookInfo.forum_id.longValue();
            this.UL = bookInfo.total_chapter.intValue();
        }
    }
}
