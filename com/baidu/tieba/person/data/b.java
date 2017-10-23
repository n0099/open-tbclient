package com.baidu.tieba.person.data;

import tbclient.BookInfo;
/* loaded from: classes.dex */
public class b {
    public int UL;
    public int UV;
    public String Vr;
    public String eZc;
    public long eZd;
    public String efS;
    public long updateTime;

    public void a(BookInfo bookInfo) {
        if (bookInfo != null) {
            this.Vr = bookInfo.book_id;
            this.efS = bookInfo.title;
            this.eZc = bookInfo.cover;
            this.updateTime = bookInfo.update_time.intValue();
            this.UV = bookInfo.book_type.intValue();
            this.eZd = bookInfo.forum_id.longValue();
            this.UL = bookInfo.total_chapter.intValue();
        }
    }
}
