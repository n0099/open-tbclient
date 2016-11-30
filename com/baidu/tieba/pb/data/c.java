package com.baidu.tieba.pb.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.tbadkCore.data.q;
import tbclient.PbPage.GodCard;
/* loaded from: classes.dex */
public class c extends q {
    public static final BdUniqueId erK = BdUniqueId.gen();
    private String PT;
    private String buttonText;
    private String erL;
    private int erM;
    private String picUrl;
    private String portrait;
    private String text;
    private String userName;

    public void a(GodCard godCard) {
        if (godCard != null) {
            this.userName = godCard.user_name;
            this.portrait = godCard.portrait;
            this.erL = godCard.time_ex;
            this.text = godCard.text;
            this.picUrl = godCard.pic_url;
            this.buttonText = godCard.button_text;
            this.PT = godCard.button_url;
            this.erM = godCard.show_floor.intValue();
        }
    }

    public String getUserName() {
        return this.userName;
    }

    public String getPortrait() {
        return this.portrait;
    }

    @Override // com.baidu.tieba.tbadkCore.data.q
    public String aNY() {
        return this.erL;
    }

    public String getText() {
        return this.text;
    }

    public String getPicUrl() {
        return this.picUrl;
    }

    public String aNZ() {
        return this.buttonText;
    }

    public String aOa() {
        return this.PT;
    }

    public int aOb() {
        return this.erM;
    }

    @Override // com.baidu.tieba.tbadkCore.data.q, com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return erK;
    }
}
