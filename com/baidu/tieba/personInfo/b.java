package com.baidu.tieba.personInfo;

import java.util.ArrayList;
import java.util.List;
import tbclient.BookInfo;
import tbclient.TbBookrack;
/* loaded from: classes.dex */
public class b {
    public String booktown;
    public List<c> dMn;
    public int eAf;
    public String icon;
    public String tip;
    public String title;

    public void a(TbBookrack tbBookrack) {
        if (tbBookrack != null) {
            this.booktown = tbBookrack.booktown;
            this.eAf = tbBookrack.num.intValue();
            this.title = tbBookrack.title;
            this.icon = tbBookrack.icon;
            this.tip = tbBookrack.tip;
            this.dMn = new ArrayList();
            if (tbBookrack.book_list != null) {
                for (BookInfo bookInfo : tbBookrack.book_list) {
                    if (bookInfo != null) {
                        c cVar = new c();
                        cVar.a(bookInfo);
                        this.dMn.add(cVar);
                    }
                }
            }
        }
    }
}
