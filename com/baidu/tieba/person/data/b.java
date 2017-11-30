package com.baidu.tieba.person.data;

import tbclient.BookInfo;
/* loaded from: classes.dex */
public class b {
    public int VL;
    public int VU;
    public String Wg;
    public String etv;
    public String fqN;
    public long fqO;
    public long updateTime;

    public void a(BookInfo bookInfo) {
        if (bookInfo != null) {
            this.Wg = bookInfo.book_id;
            this.etv = bookInfo.title;
            this.fqN = bookInfo.cover;
            this.updateTime = bookInfo.update_time.intValue();
            this.VU = bookInfo.book_type.intValue();
            this.fqO = bookInfo.forum_id.longValue();
            this.VL = bookInfo.total_chapter.intValue();
        }
    }
}
