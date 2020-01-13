package com.baidu.tieba.person;

import java.util.ArrayList;
import java.util.List;
import tbclient.UcCard;
import tbclient.UcCardInfo;
/* loaded from: classes.dex */
public class g {
    public String document;
    public String icon;
    public String jeK;
    public List<a> jeL;
    public String name;

    public void a(UcCard ucCard) {
        if (ucCard != null) {
            this.name = ucCard.name;
            this.icon = ucCard.icon;
            this.document = ucCard.doc;
            this.jeK = ucCard.jmp;
            this.jeL = new ArrayList();
            if (ucCard.uc_cards != null) {
                for (UcCardInfo ucCardInfo : ucCard.uc_cards) {
                    if (ucCardInfo != null) {
                        a aVar = new a();
                        aVar.a(ucCardInfo);
                        this.jeL.add(aVar);
                    }
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static class a {
        public String jeK;
        public boolean jeM;
        public String pic;
        public long timeStamp;
        public String tip;
        public String title;

        public void a(UcCardInfo ucCardInfo) {
            if (ucCardInfo != null) {
                this.title = ucCardInfo.title;
                this.pic = ucCardInfo.pic;
                this.jeK = ucCardInfo.jmp;
                this.tip = ucCardInfo.tip;
                this.timeStamp = ucCardInfo.st.intValue();
            }
        }
    }
}
