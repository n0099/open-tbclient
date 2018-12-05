package com.baidu.tieba.pb.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.tbadkCore.data.PostData;
import tbclient.PbPage.GodCard;
/* loaded from: classes6.dex */
public class a extends PostData {
    public static final BdUniqueId fPJ = BdUniqueId.gen();
    private String apR;
    private String buttonText;
    private String fPK;
    private int fPL;
    private String picUrl;
    private String portrait;
    private String text;
    private String userName;

    public void a(GodCard godCard) {
        if (godCard != null) {
            this.userName = godCard.user_name;
            this.portrait = godCard.portrait;
            this.fPK = godCard.time_ex;
            this.text = godCard.text;
            this.picUrl = godCard.pic_url;
            this.buttonText = godCard.button_text;
            this.apR = godCard.button_url;
            this.fPL = godCard.show_floor.intValue();
        }
    }

    public String getUserName() {
        return this.userName;
    }

    public String getPortrait() {
        return this.portrait;
    }

    @Override // com.baidu.tieba.tbadkCore.data.PostData
    public String bgd() {
        return this.fPK;
    }

    public String getText() {
        return this.text;
    }

    public String getPicUrl() {
        return this.picUrl;
    }

    public String bge() {
        return this.buttonText;
    }

    public String bgf() {
        return this.apR;
    }

    public int bgg() {
        return this.fPL;
    }

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return fPJ;
    }
}
