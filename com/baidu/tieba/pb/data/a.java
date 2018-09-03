package com.baidu.tieba.pb.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.tbadkCore.data.PostData;
import tbclient.PbPage.GodCard;
/* loaded from: classes2.dex */
public class a extends PostData {
    public static final BdUniqueId fsi = BdUniqueId.gen();
    private String aeg;
    private String buttonText;
    private String fsj;
    private int fsk;
    private String picUrl;
    private String portrait;
    private String text;
    private String userName;

    public void a(GodCard godCard) {
        if (godCard != null) {
            this.userName = godCard.user_name;
            this.portrait = godCard.portrait;
            this.fsj = godCard.time_ex;
            this.text = godCard.text;
            this.picUrl = godCard.pic_url;
            this.buttonText = godCard.button_text;
            this.aeg = godCard.button_url;
            this.fsk = godCard.show_floor.intValue();
        }
    }

    public String getUserName() {
        return this.userName;
    }

    public String getPortrait() {
        return this.portrait;
    }

    @Override // com.baidu.tieba.tbadkCore.data.PostData
    public String aZb() {
        return this.fsj;
    }

    public String getText() {
        return this.text;
    }

    public String getPicUrl() {
        return this.picUrl;
    }

    public String aZc() {
        return this.buttonText;
    }

    public String aZd() {
        return this.aeg;
    }

    public int aZe() {
        return this.fsk;
    }

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return fsi;
    }
}
