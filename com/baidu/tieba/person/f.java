package com.baidu.tieba.person;

import java.util.ArrayList;
import java.util.List;
import tbclient.UcCard;
import tbclient.UcCardInfo;
/* loaded from: classes.dex */
public class f {
    public String ezs;
    public String ezt;
    public List<a> ezu;
    public String icon;
    public String name;

    public void a(UcCard ucCard) {
        if (ucCard != null) {
            this.name = ucCard.name;
            this.icon = ucCard.icon;
            this.ezs = ucCard.doc;
            this.ezt = ucCard.jmp;
            this.ezu = new ArrayList();
            if (ucCard.uc_cards != null) {
                for (UcCardInfo ucCardInfo : ucCard.uc_cards) {
                    if (ucCardInfo != null) {
                        a aVar = new a();
                        aVar.a(ucCardInfo);
                        this.ezu.add(aVar);
                    }
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static class a {
        public long GX;
        public String ezt;
        public boolean ezv;
        public String pic;
        public String tip;
        public String title;

        public void a(UcCardInfo ucCardInfo) {
            if (ucCardInfo != null) {
                this.title = ucCardInfo.title;
                this.pic = ucCardInfo.pic;
                this.ezt = ucCardInfo.jmp;
                this.tip = ucCardInfo.tip;
                this.GX = ucCardInfo.st.intValue();
            }
        }
    }
}
