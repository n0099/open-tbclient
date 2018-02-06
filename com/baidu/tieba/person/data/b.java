package com.baidu.tieba.person.data;

import tbclient.BookInfo;
/* loaded from: classes.dex */
public class b {
    public int aLA;
    public int aLJ;
    public String aLV;
    public String fma;
    public String gik;
    public long gil;
    public long updateTime;

    public void a(BookInfo bookInfo) {
        if (bookInfo != null) {
            this.aLV = bookInfo.book_id;
            this.fma = bookInfo.title;
            this.gik = bookInfo.cover;
            this.updateTime = bookInfo.update_time.intValue();
            this.aLJ = bookInfo.book_type.intValue();
            this.gil = bookInfo.forum_id.longValue();
            this.aLA = bookInfo.total_chapter.intValue();
        }
    }
}
