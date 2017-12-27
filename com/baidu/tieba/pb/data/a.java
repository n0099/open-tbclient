package com.baidu.tieba.pb.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.tbadkCore.data.PostData;
import tbclient.PbPage.GodCard;
/* loaded from: classes2.dex */
public class a extends PostData {
    public static final BdUniqueId fBC = BdUniqueId.gen();
    private String aJM;
    private String buttonText;
    private String fBD;
    private int fBE;
    private String picUrl;
    private String portrait;
    private String text;
    private String userName;

    public void a(GodCard godCard) {
        if (godCard != null) {
            this.userName = godCard.user_name;
            this.portrait = godCard.portrait;
            this.fBD = godCard.time_ex;
            this.text = godCard.text;
            this.picUrl = godCard.pic_url;
            this.buttonText = godCard.button_text;
            this.aJM = godCard.button_url;
            this.fBE = godCard.show_floor.intValue();
        }
    }

    public String getUserName() {
        return this.userName;
    }

    public String getPortrait() {
        return this.portrait;
    }

    @Override // com.baidu.tieba.tbadkCore.data.PostData
    public String aYn() {
        return this.fBD;
    }

    public String getText() {
        return this.text;
    }

    public String getPicUrl() {
        return this.picUrl;
    }

    public String aYo() {
        return this.buttonText;
    }

    public String aYp() {
        return this.aJM;
    }

    public int aYq() {
        return this.fBE;
    }

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        return fBC;
    }
}
