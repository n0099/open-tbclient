package com.baidu.tieba.themeCenter.theme.top;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tieba.themeCenter.dressCenter.k;
import com.baidu.tieba.themeCenter.theme.top.d;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ d dgY;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(d dVar, int i, int i2) {
        super(i, i2);
        this.dgY = dVar;
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
                    this.dgY.mThemeList = topThemeListSocketResponseMessage.getThemeList();
                    this.dgY.mRecommand = topThemeListSocketResponseMessage.getRecommand();
                } else if (responsedMessage instanceof TopThemeListHttpResponseMessage) {
                    TopThemeListHttpResponseMessage topThemeListHttpResponseMessage = (TopThemeListHttpResponseMessage) responsedMessage;
                    this.dgY.mThemeList = topThemeListHttpResponseMessage.getThemeList();
                    this.dgY.mRecommand = topThemeListHttpResponseMessage.getRecommand();
                }
                aVar = this.dgY.dge;
                if (aVar == null) {
                    return;
                }
                this.dgY.azs();
                aVar2 = this.dgY.dge;
                int error = responsedMessage.getError();
                String errorString = responsedMessage.getErrorString();
                kVar = this.dgY.mRecommand;
                list = this.dgY.mThemeList;
                aVar2.a(error, errorString, kVar, list);
            }
        }
    }
}
