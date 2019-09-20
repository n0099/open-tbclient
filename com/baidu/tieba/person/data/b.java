package com.baidu.tieba.person.data;

import tbclient.BookInfo;
/* loaded from: classes4.dex */
public class b {
    public String bGL;
    public int bGz;
    public String ilI;
    public String ilJ;
    public long ilK;
    public int ilL;
    public long updateTime;

    public void a(BookInfo bookInfo) {
        if (bookInfo != null) {
            this.bGL = bookInfo.book_id;
            this.ilI = bookInfo.title;
            this.ilJ = bookInfo.cover;
            this.updateTime = bookInfo.update_time.intValue();
            this.bGz = bookInfo.book_type.intValue();
            this.ilK = bookInfo.forum_id.longValue();
            this.ilL = bookInfo.total_chapter.intValue();
        }
    }
}
