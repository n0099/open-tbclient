package com.baidu.tieba.imMessageCenter.im.floatwindow;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.im.chat.notify.WindowSwitchResponse;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i extends CustomMessageListener {
    final /* synthetic */ b btt;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(b bVar) {
        super(2001257);
        this.btt = bVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        a aVar;
        if (customResponsedMessage instanceof WindowSwitchResponse) {
            WindowSwitchResponse windowSwitchResponse = (WindowSwitchResponse) customResponsedMessage;
            int switchType = windowSwitchResponse.getSwitchType();
            boolean isOpen = windowSwitchResponse.isOpen();
            switch (switchType) {
                case 0:
                case 1:
                case 3:
                    if (!isOpen) {
                        this.btt.du(true);
                        return;
                    }
                    return;
                case 2:
                    if (!isOpen) {
                        aVar = this.btt.bti;
                        if (aVar.VO()) {
                            this.btt.dt(false);
                            return;
                        }
                        return;
                    }
                    return;
                case 4:
                    if (isOpen) {
                        this.btt.dt(true);
                        return;
                    } else {
                        this.btt.du(false);
                        return;
                    }
                default:
                    return;
            }
        }
    }
}
