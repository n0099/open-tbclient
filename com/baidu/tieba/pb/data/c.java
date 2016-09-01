package com.baidu.tieba.pb.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.tbadkCore.data.q;
import tbclient.PbPage.GodCard;
/* loaded from: classes.dex */
public class c extends q {
    public static final BdUniqueId ejP = BdUniqueId.gen();
    private String HT;
    private String Pz;
    private String ejQ;
    private int ejR;
    private String picUrl;
    private String portrait;
    private String text;
    private String userName;

    public void a(GodCard godCard) {
        if (godCard != null) {
            this.userName = godCard.user_name;
            this.portrait = godCard.portrait;
            this.ejQ = godCard.time_ex;
            this.text = godCard.text;
            this.picUrl = godCard.pic_url;
            this.HT = godCard.button_text;
            this.Pz = godCard.button_url;
            this.ejR = godCard.show_floor.intValue();
        }
    }

    public String getUserName() {
        return this.userName;
    }

    public String getPortrait() {
        return this.portrait;
    }

    @Override // com.baidu.tieba.tbadkCore.data.q
    public String aLD() {
        return this.ejQ;
    }

    public String getText() {
        return this.text;
    }

    public String getPicUrl() {
        return this.picUrl;
    }

    public String aLE() {
        return this.HT;
    }

    public String aLF() {
        return this.Pz;
    }

    public int aLG() {
        return this.ejR;
    }

    @Override // com.baidu.tieba.tbadkCore.data.q, com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return ejP;
    }
}
