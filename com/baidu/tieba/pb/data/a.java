package com.baidu.tieba.pb.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.tbadkCore.data.PostData;
import tbclient.PbPage.GodCard;
/* loaded from: classes.dex */
public class a extends PostData {
    public static final BdUniqueId eDN = BdUniqueId.gen();
    private String Un;
    private String buttonText;
    private String eDO;
    private int eDP;
    private String picUrl;
    private String portrait;
    private String text;
    private String userName;

    public void a(GodCard godCard) {
        if (godCard != null) {
            this.userName = godCard.user_name;
            this.portrait = godCard.portrait;
            this.eDO = godCard.time_ex;
            this.text = godCard.text;
            this.picUrl = godCard.pic_url;
            this.buttonText = godCard.button_text;
            this.Un = godCard.button_url;
            this.eDP = godCard.show_floor.intValue();
        }
    }

    public String getUserName() {
        return this.userName;
    }

    public String getPortrait() {
        return this.portrait;
    }

    @Override // com.baidu.tieba.tbadkCore.data.PostData
    public String aOJ() {
        return this.eDO;
    }

    public String getText() {
        return this.text;
    }

    public String getPicUrl() {
        return this.picUrl;
    }

    public String aOK() {
        return this.buttonText;
    }

    public String aOL() {
        return this.Un;
    }

    public int aOM() {
        return this.eDP;
    }

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return eDN;
    }
}
