package com.baidu.tieba.person;

import java.util.ArrayList;
import java.util.List;
import tbclient.UcCard;
import tbclient.UcCardInfo;
/* loaded from: classes.dex */
public class g {
    public String document;
    public String fTe;
    public List<a> fTf;
    public String icon;
    public String name;

    public void a(UcCard ucCard) {
        if (ucCard != null) {
            this.name = ucCard.name;
            this.icon = ucCard.icon;
            this.document = ucCard.doc;
            this.fTe = ucCard.jmp;
            this.fTf = new ArrayList();
            if (ucCard.uc_cards != null) {
                for (UcCardInfo ucCardInfo : ucCard.uc_cards) {
                    if (ucCardInfo != null) {
                        a aVar = new a();
                        aVar.a(ucCardInfo);
                        this.fTf.add(aVar);
                    }
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static class a {
        public String fTe;
        public boolean fTg;
        public String pic;
        public long timeStamp;
        public String tip;
        public String title;

        public void a(UcCardInfo ucCardInfo) {
            if (ucCardInfo != null) {
                this.title = ucCardInfo.title;
                this.pic = ucCardInfo.pic;
                this.fTe = ucCardInfo.jmp;
                this.tip = ucCardInfo.tip;
                this.timeStamp = ucCardInfo.st.intValue();
            }
        }
    }
}
