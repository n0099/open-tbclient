package com.baidu.tieba.person.data;

import java.util.ArrayList;
import java.util.List;
import tbclient.BookInfo;
import tbclient.TbBookrack;
/* loaded from: classes9.dex */
public class a {
    public String booktown;
    public String icon;
    public int jgi;
    public List<b> jgj;
    public String tip;
    public String title;

    public void a(TbBookrack tbBookrack) {
        if (tbBookrack != null) {
            this.booktown = tbBookrack.booktown;
            this.jgi = tbBookrack.num.intValue();
            this.title = tbBookrack.title;
            this.icon = tbBookrack.icon;
            this.tip = tbBookrack.tip;
            this.jgj = new ArrayList();
            if (tbBookrack.book_list != null) {
                for (BookInfo bookInfo : tbBookrack.book_list) {
                    if (bookInfo != null) {
                        b bVar = new b();
                        bVar.a(bookInfo);
                        this.jgj.add(bVar);
                    }
                }
            }
        }
    }
}
