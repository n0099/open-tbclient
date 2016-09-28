package com.baidu.tieba.pb.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.tbadkCore.data.q;
import tbclient.PbPage.GodCard;
/* loaded from: classes.dex */
public class c extends q {
    public static final BdUniqueId elN = BdUniqueId.gen();
    private String Py;
    private String buttonText;
    private String elO;
    private int elP;
    private String picUrl;
    private String portrait;
    private String text;
    private String userName;

    public void a(GodCard godCard) {
        if (godCard != null) {
            this.userName = godCard.user_name;
            this.portrait = godCard.portrait;
            this.elO = godCard.time_ex;
            this.text = godCard.text;
            this.picUrl = godCard.pic_url;
            this.buttonText = godCard.button_text;
            this.Py = godCard.button_url;
            this.elP = godCard.show_floor.intValue();
        }
    }

    public String getUserName() {
        return this.userName;
    }

    public String getPortrait() {
        return this.portrait;
    }

    @Override // com.baidu.tieba.tbadkCore.data.q
    public String aMf() {
        return this.elO;
    }

    public String getText() {
        return this.text;
    }

    public String getPicUrl() {
        return this.picUrl;
    }

    public String aMg() {
        return this.buttonText;
    }

    public String aMh() {
        return this.Py;
    }

    public int aMi() {
        return this.elP;
    }

    @Override // com.baidu.tieba.tbadkCore.data.q, com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return elN;
    }
}
