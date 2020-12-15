package com.baidu.tieba.person.data;

import tbclient.BookInfo;
/* loaded from: classes22.dex */
public class b {
    public String eFJ;
    public int eFl;
    public String miK;
    public String miL;
    public long miM;
    public int miN;
    public long updateTime;

    public void a(BookInfo bookInfo) {
        if (bookInfo != null) {
            this.eFJ = bookInfo.book_id;
            this.miK = bookInfo.title;
            this.miL = bookInfo.cover;
            this.updateTime = bookInfo.update_time.intValue();
            this.eFl = bookInfo.book_type.intValue();
            this.miM = bookInfo.forum_id.longValue();
            this.miN = bookInfo.total_chapter.intValue();
        }
    }
}
