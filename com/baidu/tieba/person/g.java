package com.baidu.tieba.person;

import java.util.ArrayList;
import java.util.List;
import tbclient.UcCard;
import tbclient.UcCardInfo;
/* loaded from: classes.dex */
public class g {
    public String document;
    public String ghV;
    public List<a> ghW;
    public String icon;
    public String name;

    public void a(UcCard ucCard) {
        if (ucCard != null) {
            this.name = ucCard.name;
            this.icon = ucCard.icon;
            this.document = ucCard.doc;
            this.ghV = ucCard.jmp;
            this.ghW = new ArrayList();
            if (ucCard.uc_cards != null) {
                for (UcCardInfo ucCardInfo : ucCard.uc_cards) {
                    if (ucCardInfo != null) {
                        a aVar = new a();
                        aVar.a(ucCardInfo);
                        this.ghW.add(aVar);
                    }
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static class a {
        public String ghV;
        public boolean ghX;
        public String pic;
        public long timeStamp;
        public String tip;
        public String title;

        public void a(UcCardInfo ucCardInfo) {
            if (ucCardInfo != null) {
                this.title = ucCardInfo.title;
                this.pic = ucCardInfo.pic;
                this.ghV = ucCardInfo.jmp;
                this.tip = ucCardInfo.tip;
                this.timeStamp = ucCardInfo.st.intValue();
            }
        }
    }
}
