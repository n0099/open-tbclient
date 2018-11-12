package com.baidu.tieba.person.data;

import tbclient.BookInfo;
/* loaded from: classes5.dex */
public class b {
    public int amP;
    public String anb;
    public String gjD;
    public String gjE;
    public long gjF;
    public int gjG;
    public long updateTime;

    public void a(BookInfo bookInfo) {
        if (bookInfo != null) {
            this.anb = bookInfo.book_id;
            this.gjD = bookInfo.title;
            this.gjE = bookInfo.cover;
            this.updateTime = bookInfo.update_time.intValue();
            this.amP = bookInfo.book_type.intValue();
            this.gjF = bookInfo.forum_id.longValue();
            this.gjG = bookInfo.total_chapter.intValue();
        }
    }
}
