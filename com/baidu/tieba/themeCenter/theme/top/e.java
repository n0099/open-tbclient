package com.baidu.tieba.themeCenter.theme.top;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tieba.themeCenter.dressCenter.k;
import com.baidu.tieba.themeCenter.theme.top.d;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ d dhy;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(d dVar, int i, int i2) {
        super(i, i2);
        this.dhy = dVar;
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
                    this.dhy.mThemeList = topThemeListSocketResponseMessage.getThemeList();
                    this.dhy.mRecommand = topThemeListSocketResponseMessage.getRecommand();
                } else if (responsedMessage instanceof TopThemeListHttpResponseMessage) {
                    TopThemeListHttpResponseMessage topThemeListHttpResponseMessage = (TopThemeListHttpResponseMessage) responsedMessage;
                    this.dhy.mThemeList = topThemeListHttpResponseMessage.getThemeList();
                    this.dhy.mRecommand = topThemeListHttpResponseMessage.getRecommand();
                }
                aVar = this.dhy.dgE;
                if (aVar == null) {
                    return;
                }
                this.dhy.azy();
                aVar2 = this.dhy.dgE;
                int error = responsedMessage.getError();
                String errorString = responsedMessage.getErrorString();
                kVar = this.dhy.mRecommand;
                list = this.dhy.mThemeList;
                aVar2.a(error, errorString, kVar, list);
            }
        }
    }
}
