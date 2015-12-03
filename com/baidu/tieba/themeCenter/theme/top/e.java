package com.baidu.tieba.themeCenter.theme.top;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tieba.themeCenter.dressCenter.k;
import com.baidu.tieba.themeCenter.theme.top.d;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ d dHo;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(d dVar, int i, int i2) {
        super(i, i2);
        this.dHo = dVar;
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
                    this.dHo.mThemeList = topThemeListSocketResponseMessage.getThemeList();
                    this.dHo.mRecommand = topThemeListSocketResponseMessage.getRecommand();
                } else if (responsedMessage instanceof TopThemeListHttpResponseMessage) {
                    TopThemeListHttpResponseMessage topThemeListHttpResponseMessage = (TopThemeListHttpResponseMessage) responsedMessage;
                    this.dHo.mThemeList = topThemeListHttpResponseMessage.getThemeList();
                    this.dHo.mRecommand = topThemeListHttpResponseMessage.getRecommand();
                }
                aVar = this.dHo.dGt;
                if (aVar == null) {
                    return;
                }
                this.dHo.aFy();
                aVar2 = this.dHo.dGt;
                int error = responsedMessage.getError();
                String errorString = responsedMessage.getErrorString();
                kVar = this.dHo.mRecommand;
                list = this.dHo.mThemeList;
                aVar2.a(error, errorString, kVar, list);
            }
        }
    }
}
