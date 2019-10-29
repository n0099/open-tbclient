package com.baidu.tieba.person.data;

import java.util.ArrayList;
import java.util.List;
import tbclient.BookInfo;
import tbclient.TbBookrack;
/* loaded from: classes4.dex */
public class a {
    public String booktown;
    public String icon;
    public int ikq;
    public List<b> ikr;
    public String tip;
    public String title;

    public void a(TbBookrack tbBookrack) {
        if (tbBookrack != null) {
            this.booktown = tbBookrack.booktown;
            this.ikq = tbBookrack.num.intValue();
            this.title = tbBookrack.title;
            this.icon = tbBookrack.icon;
            this.tip = tbBookrack.tip;
            this.ikr = new ArrayList();
            if (tbBookrack.book_list != null) {
                for (BookInfo bookInfo : tbBookrack.book_list) {
                    if (bookInfo != null) {
                        b bVar = new b();
                        bVar.a(bookInfo);
                        this.ikr.add(bVar);
                    }
                }
            }
        }
    }
}
