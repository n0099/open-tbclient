package com.baidu.tieba.person.data;

import tbclient.BookInfo;
/* loaded from: classes.dex */
public class b {
    public int VI;
    public int VR;
    public String Wd;
    public String euD;
    public String frQ;
    public long frR;
    public long updateTime;

    public void a(BookInfo bookInfo) {
        if (bookInfo != null) {
            this.Wd = bookInfo.book_id;
            this.euD = bookInfo.title;
            this.frQ = bookInfo.cover;
            this.updateTime = bookInfo.update_time.intValue();
            this.VR = bookInfo.book_type.intValue();
            this.frR = bookInfo.forum_id.longValue();
            this.VI = bookInfo.total_chapter.intValue();
        }
    }
}
