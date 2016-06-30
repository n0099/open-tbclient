package com.baidu.tieba.person;

import java.util.ArrayList;
import java.util.List;
import tbclient.UcCard;
import tbclient.UcCardInfo;
/* loaded from: classes.dex */
public class bs {
    public String efv;
    public String efw;
    public List<a> efx;
    public String icon;
    public String name;

    public void a(UcCard ucCard) {
        if (ucCard != null) {
            this.name = ucCard.name;
            this.icon = ucCard.icon;
            this.efv = ucCard.doc;
            this.efw = ucCard.jmp;
            this.efx = new ArrayList();
            if (ucCard.uc_cards != null) {
                for (UcCardInfo ucCardInfo : ucCard.uc_cards) {
                    if (ucCardInfo != null) {
                        a aVar = new a();
                        aVar.a(ucCardInfo);
                        this.efx.add(aVar);
                    }
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static class a {
        public String efw;
        public boolean efy;
        public String pic;
        public String tip;
        public String title;
        public long xF;

        public void a(UcCardInfo ucCardInfo) {
            if (ucCardInfo != null) {
                this.title = ucCardInfo.title;
                this.pic = ucCardInfo.pic;
                this.efw = ucCardInfo.jmp;
                this.tip = ucCardInfo.tip;
                this.xF = ucCardInfo.st.intValue();
            }
        }
    }
}
