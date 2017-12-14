package com.baidu.tieba.person.data;

import tbclient.BookInfo;
/* loaded from: classes.dex */
public class b {
    public int VF;
    public int VO;
    public String Wa;
    public String euz;
    public String frL;
    public long frM;
    public long updateTime;

    public void a(BookInfo bookInfo) {
        if (bookInfo != null) {
            this.Wa = bookInfo.book_id;
            this.euz = bookInfo.title;
            this.frL = bookInfo.cover;
            this.updateTime = bookInfo.update_time.intValue();
            this.VO = bookInfo.book_type.intValue();
            this.frM = bookInfo.forum_id.longValue();
            this.VF = bookInfo.total_chapter.intValue();
        }
    }
}
