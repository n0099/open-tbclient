package com.baidu.tieba.memberCenter.tail.data;

import java.util.ArrayList;
import java.util.List;
import tbclient.GetTails.ColorInfo;
import tbclient.GetTails.ResData;
import tbclient.GetTails.TailInfo;
/* loaded from: classes9.dex */
public class d {
    private String los;
    private List<TailData> lor = new ArrayList();
    private List<String> lot = new ArrayList();

    public void a(ResData resData) {
        if (resData != null && resData.tailList != null) {
            for (TailInfo tailInfo : resData.tailList) {
                if (a(tailInfo)) {
                    TailData tailData = new TailData();
                    tailData.setContent(tailInfo.tailContent);
                    tailData.setFontColor(tailInfo.fontColor);
                    tailData.setFontType(tailInfo.fontKeyName);
                    tailData.setId(tailInfo.tailId.intValue());
                    tailData.setSelected(tailInfo.is_selected.intValue() == 1);
                    getTails().add(tailData);
                }
            }
            Oy(resData.default_color);
            for (ColorInfo colorInfo : resData.colorList) {
                dhF().add(colorInfo.fontColor);
            }
        }
    }

    private boolean a(TailInfo tailInfo) {
        return (tailInfo.tailId == null || tailInfo.tailId.intValue() == 0 || tailInfo.fontColor == null) ? false : true;
    }

    public List<TailData> getTails() {
        return this.lor;
    }

    public void Oy(String str) {
        this.los = str;
    }

    public List<String> dhF() {
        return this.lot;
    }
}
