package com.baidu.tieba.person.data;

import tbclient.BookInfo;
/* loaded from: classes22.dex */
public class b {
    public String eFJ;
    public int eFl;
    public String miI;
    public String miJ;
    public long miK;
    public int miL;
    public long updateTime;

    public void a(BookInfo bookInfo) {
        if (bookInfo != null) {
            this.eFJ = bookInfo.book_id;
            this.miI = bookInfo.title;
            this.miJ = bookInfo.cover;
            this.updateTime = bookInfo.update_time.intValue();
            this.eFl = bookInfo.book_type.intValue();
            this.miK = bookInfo.forum_id.longValue();
            this.miL = bookInfo.total_chapter.intValue();
        }
    }
}
