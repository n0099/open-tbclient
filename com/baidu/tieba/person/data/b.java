package com.baidu.tieba.person.data;

import tbclient.BookInfo;
/* loaded from: classes16.dex */
public class b {
    public int dOd;
    public String dOr;
    public String kNI;
    public String kNJ;
    public long kNK;
    public int kNL;
    public long updateTime;

    public void a(BookInfo bookInfo) {
        if (bookInfo != null) {
            this.dOr = bookInfo.book_id;
            this.kNI = bookInfo.title;
            this.kNJ = bookInfo.cover;
            this.updateTime = bookInfo.update_time.intValue();
            this.dOd = bookInfo.book_type.intValue();
            this.kNK = bookInfo.forum_id.longValue();
            this.kNL = bookInfo.total_chapter.intValue();
        }
    }
}
