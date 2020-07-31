package com.baidu.tieba.person;

import java.util.ArrayList;
import java.util.List;
import tbclient.UcCard;
import tbclient.UcCardInfo;
/* loaded from: classes.dex */
public class g {
    public String document;
    public String icon;
    public String kNx;
    public List<a> kNy;
    public String name;

    public void a(UcCard ucCard) {
        if (ucCard != null) {
            this.name = ucCard.name;
            this.icon = ucCard.icon;
            this.document = ucCard.doc;
            this.kNx = ucCard.jmp;
            this.kNy = new ArrayList();
            if (ucCard.uc_cards != null) {
                for (UcCardInfo ucCardInfo : ucCard.uc_cards) {
                    if (ucCardInfo != null) {
                        a aVar = new a();
                        aVar.a(ucCardInfo);
                        this.kNy.add(aVar);
                    }
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static class a {
        public String kNx;
        public boolean kNz;
        public String pic;
        public long timeStamp;
        public String tip;
        public String title;

        public void a(UcCardInfo ucCardInfo) {
            if (ucCardInfo != null) {
                this.title = ucCardInfo.title;
                this.pic = ucCardInfo.pic;
                this.kNx = ucCardInfo.jmp;
                this.tip = ucCardInfo.tip;
                this.timeStamp = ucCardInfo.st.intValue();
            }
        }
    }
}
