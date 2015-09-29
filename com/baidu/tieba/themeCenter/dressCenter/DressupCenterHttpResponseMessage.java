package com.baidu.tieba.themeCenter.dressCenter;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import com.squareup.wire.Wire;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetThemeList.GetThemeListResIdl;
import tbclient.GetThemeList.ThemeCarousel;
import tbclient.GetThemeList.ThemeList;
/* loaded from: classes.dex */
public class DressupCenterHttpResponseMessage extends TbHttpResponsedMessage {
    private k mRecommand;
    private List<b> mThemeCarouselList;
    private List<j> mThemeList;

    public DressupCenterHttpResponseMessage(int i) {
        super(i);
    }

    @Override // com.baidu.tbadk.message.http.TbHttpResponsedMessage
    public void decodeInBackGround(int i, byte[] bArr) {
        GetThemeListResIdl getThemeListResIdl = (GetThemeListResIdl) new Wire(new Class[0]).parseFrom(bArr, GetThemeListResIdl.class);
        if (getThemeListResIdl != null) {
            if (getThemeListResIdl.error != null) {
                setError(getThemeListResIdl.error.errorno.intValue());
                setErrorString(getThemeListResIdl.error.usermsg);
            }
            if (getThemeListResIdl.data != null) {
                if (getThemeListResIdl.data.carousel != null) {
                    this.mThemeCarouselList = new ArrayList();
                    for (ThemeCarousel themeCarousel : getThemeListResIdl.data.carousel) {
                        if (themeCarousel != null && (!StringUtils.isNull(themeCarousel.pic_url) || !StringUtils.isNull(themeCarousel.active_url))) {
                            b bVar = new b();
                            bVar.a(themeCarousel);
                            this.mThemeCarouselList.add(bVar);
                        }
                    }
                }
                if (getThemeListResIdl.data.theme_list != null) {
                    this.mThemeList = new ArrayList();
                    for (ThemeList themeList : getThemeListResIdl.data.theme_list) {
                        if (themeList != null && !StringUtils.isNull(themeList.name)) {
                            j jVar = new j();
                            jVar.a(themeList);
                            this.mThemeList.add(jVar);
                        }
                    }
                }
                if (getThemeListResIdl.data.recommend != null) {
                    this.mRecommand = new k();
                    this.mRecommand.a(getThemeListResIdl.data.recommend);
                }
            }
        }
    }

    public List<j> getThemeList() {
        return this.mThemeList;
    }

    public void setThemeList(List<j> list) {
        this.mThemeList = list;
    }

    public List<b> getThemeCarouselList() {
        return this.mThemeCarouselList;
    }

    public void setThemeCarouselList(List<b> list) {
        this.mThemeCarouselList = list;
    }

    public k getRecommand() {
        return this.mRecommand;
    }

    public void setRecommand(k kVar) {
        this.mRecommand = kVar;
    }
}
