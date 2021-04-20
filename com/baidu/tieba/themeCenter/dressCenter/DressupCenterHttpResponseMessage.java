package com.baidu.tieba.themeCenter.dressCenter;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import com.squareup.wire.Wire;
import d.b.i0.j3.h.a;
import d.b.i0.j3.h.d;
import d.b.i0.j3.h.e;
import java.util.ArrayList;
import java.util.List;
import tbclient.Error;
import tbclient.GetThemeList.DataRes;
import tbclient.GetThemeList.GetThemeListResIdl;
import tbclient.GetThemeList.ThemeCarousel;
import tbclient.GetThemeList.ThemeList;
/* loaded from: classes5.dex */
public class DressupCenterHttpResponseMessage extends TbHttpResponsedMessage {
    public e mRecommand;
    public List<a> mThemeCarouselList;
    public List<d> mThemeList;

    public DressupCenterHttpResponseMessage(int i) {
        super(i);
    }

    public e getRecommand() {
        return this.mRecommand;
    }

    public List<a> getThemeCarouselList() {
        return this.mThemeCarouselList;
    }

    public List<d> getThemeList() {
        return this.mThemeList;
    }

    public void setRecommand(e eVar) {
        this.mRecommand = eVar;
    }

    public void setThemeCarouselList(List<a> list) {
        this.mThemeCarouselList = list;
    }

    public void setThemeList(List<d> list) {
        this.mThemeList = list;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.message.http.TbHttpResponsedMessage, com.baidu.adp.framework.message.HttpResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        GetThemeListResIdl getThemeListResIdl = (GetThemeListResIdl) new Wire(new Class[0]).parseFrom(bArr, GetThemeListResIdl.class);
        if (getThemeListResIdl == null) {
            return;
        }
        Error error = getThemeListResIdl.error;
        if (error != null) {
            setError(error.errorno.intValue());
            setErrorString(getThemeListResIdl.error.usermsg);
        }
        DataRes dataRes = getThemeListResIdl.data;
        if (dataRes != null) {
            if (dataRes.carousel != null) {
                this.mThemeCarouselList = new ArrayList();
                for (ThemeCarousel themeCarousel : getThemeListResIdl.data.carousel) {
                    if (themeCarousel != null && (!StringUtils.isNull(themeCarousel.pic_url) || !StringUtils.isNull(themeCarousel.active_url))) {
                        a aVar = new a();
                        aVar.c(themeCarousel);
                        this.mThemeCarouselList.add(aVar);
                    }
                }
            }
            if (getThemeListResIdl.data.theme_list != null) {
                this.mThemeList = new ArrayList();
                for (ThemeList themeList : getThemeListResIdl.data.theme_list) {
                    if (themeList != null && !StringUtils.isNull(themeList.name)) {
                        d dVar = new d();
                        dVar.e(themeList);
                        this.mThemeList.add(dVar);
                    }
                }
            }
            if (getThemeListResIdl.data.recommend != null) {
                e eVar = new e();
                this.mRecommand = eVar;
                eVar.d(getThemeListResIdl.data.recommend);
            }
        }
    }
}
