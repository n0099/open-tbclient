package com.baidu.tieba.person.data;

import tbclient.BookInfo;
/* loaded from: classes2.dex */
public class b {
    public int eMC;
    public String eNa;
    public String msE;
    public String msF;
    public long msG;
    public int msH;
    public long updateTime;

    public void a(BookInfo bookInfo) {
        if (bookInfo != null) {
            this.eNa = bookInfo.book_id;
            this.msE = bookInfo.title;
            this.msF = bookInfo.cover;
            this.updateTime = bookInfo.update_time.intValue();
            this.eMC = bookInfo.book_type.intValue();
            this.msG = bookInfo.forum_id.longValue();
            this.msH = bookInfo.total_chapter.intValue();
        }
    }
}
