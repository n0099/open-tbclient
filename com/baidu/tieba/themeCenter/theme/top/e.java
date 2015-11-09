package com.baidu.tieba.themeCenter.theme.top;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tieba.themeCenter.dressCenter.k;
import com.baidu.tieba.themeCenter.theme.top.d;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ d dje;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(d dVar, int i, int i2) {
        super(i, i2);
        this.dje = dVar;
    }

    @Override // com.baidu.adp.framework.listener.a
    public void onMessage(ResponsedMessage<?> responsedMessage) {
        d.a aVar;
        d.a aVar2;
        k kVar;
        List<a> list;
        if (responsedMessage != null) {
            if ((responsedMessage instanceof TopThemeListSocketResponseMessage) || (responsedMessage instanceof TopThemeListHttpResponseMessage)) {
                if (responsedMessage instanceof TopThemeListSocketResponseMessage) {
                    TopThemeListSocketResponseMessage topThemeListSocketResponseMessage = (TopThemeListSocketResponseMessage) responsedMessage;
                    this.dje.mThemeList = topThemeListSocketResponseMessage.getThemeList();
                    this.dje.mRecommand = topThemeListSocketResponseMessage.getRecommand();
                } else if (responsedMessage instanceof TopThemeListHttpResponseMessage) {
                    TopThemeListHttpResponseMessage topThemeListHttpResponseMessage = (TopThemeListHttpResponseMessage) responsedMessage;
                    this.dje.mThemeList = topThemeListHttpResponseMessage.getThemeList();
                    this.dje.mRecommand = topThemeListHttpResponseMessage.getRecommand();
                }
                aVar = this.dje.dik;
                if (aVar == null) {
                    return;
                }
                this.dje.aAo();
                aVar2 = this.dje.dik;
                int error = responsedMessage.getError();
                String errorString = responsedMessage.getErrorString();
                kVar = this.dje.mRecommand;
                list = this.dje.mThemeList;
                aVar2.a(error, errorString, kVar, list);
            }
        }
    }
}
