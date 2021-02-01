package com.baidu.tieba.memberCenter.tail.data;

import java.util.ArrayList;
import java.util.List;
import tbclient.GetTails.ColorInfo;
import tbclient.GetTails.ResData;
import tbclient.GetTails.TailInfo;
/* loaded from: classes9.dex */
public class d {
    private String lrP;
    private List<TailData> lrO = new ArrayList();
    private List<String> lrQ = new ArrayList();

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
            Of(resData.default_color);
            for (ColorInfo colorInfo : resData.colorList) {
                dfN().add(colorInfo.fontColor);
            }
        }
    }

    private boolean a(TailInfo tailInfo) {
        return (tailInfo.tailId == null || tailInfo.tailId.intValue() == 0 || tailInfo.fontColor == null) ? false : true;
    }

    public List<TailData> getTails() {
        return this.lrO;
    }

    public void Of(String str) {
        this.lrP = str;
    }

    public List<String> dfN() {
        return this.lrQ;
    }
}
