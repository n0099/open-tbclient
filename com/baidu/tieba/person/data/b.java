package com.baidu.tieba.person.data;

import tbclient.BookInfo;
/* loaded from: classes.dex */
public class b {
    public String aLK;
    public int aLp;
    public int aLy;
    public String flO;
    public String ghY;
    public long ghZ;
    public long updateTime;

    public void a(BookInfo bookInfo) {
        if (bookInfo != null) {
            this.aLK = bookInfo.book_id;
            this.flO = bookInfo.title;
            this.ghY = bookInfo.cover;
            this.updateTime = bookInfo.update_time.intValue();
            this.aLy = bookInfo.book_type.intValue();
            this.ghZ = bookInfo.forum_id.longValue();
            this.aLp = bookInfo.total_chapter.intValue();
        }
    }
}
