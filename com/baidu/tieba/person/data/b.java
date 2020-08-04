package com.baidu.tieba.person.data;

import tbclient.BookInfo;
/* loaded from: classes16.dex */
public class b {
    public int dOd;
    public String dOr;
    public String kNK;
    public String kNL;
    public long kNM;
    public int kNN;
    public long updateTime;

    public void a(BookInfo bookInfo) {
        if (bookInfo != null) {
            this.dOr = bookInfo.book_id;
            this.kNK = bookInfo.title;
            this.kNL = bookInfo.cover;
            this.updateTime = bookInfo.update_time.intValue();
            this.dOd = bookInfo.book_type.intValue();
            this.kNM = bookInfo.forum_id.longValue();
            this.kNN = bookInfo.total_chapter.intValue();
        }
    }
}
