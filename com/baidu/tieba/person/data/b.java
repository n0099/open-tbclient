package com.baidu.tieba.person.data;

import tbclient.BookInfo;
/* loaded from: classes22.dex */
public class b {
    public String eAt;
    public int ezV;
    public String lUj;
    public String lUk;
    public long lUl;
    public int lUm;
    public long updateTime;

    public void a(BookInfo bookInfo) {
        if (bookInfo != null) {
            this.eAt = bookInfo.book_id;
            this.lUj = bookInfo.title;
            this.lUk = bookInfo.cover;
            this.updateTime = bookInfo.update_time.intValue();
            this.ezV = bookInfo.book_type.intValue();
            this.lUl = bookInfo.forum_id.longValue();
            this.lUm = bookInfo.total_chapter.intValue();
        }
    }
}
