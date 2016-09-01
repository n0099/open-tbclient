package com.baidu.tieba.personInfo;

import java.util.ArrayList;
import java.util.List;
import tbclient.BookInfo;
import tbclient.TbBookrack;
/* loaded from: classes.dex */
public class a {
    public String booktown;
    public List<b> dYs;
    public int eGJ;
    public String icon;
    public String tip;
    public String title;

    public void a(TbBookrack tbBookrack) {
        if (tbBookrack != null) {
            this.booktown = tbBookrack.booktown;
            this.eGJ = tbBookrack.num.intValue();
            this.title = tbBookrack.title;
            this.icon = tbBookrack.icon;
            this.tip = tbBookrack.tip;
            this.dYs = new ArrayList();
            if (tbBookrack.book_list != null) {
                for (BookInfo bookInfo : tbBookrack.book_list) {
                    if (bookInfo != null) {
                        b bVar = new b();
                        bVar.a(bookInfo);
                        this.dYs.add(bVar);
                    }
                }
            }
        }
    }
}
