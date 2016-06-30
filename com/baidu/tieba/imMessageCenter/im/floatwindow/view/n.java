package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tieba.im.chat.AbsMsglistView;
import com.baidu.tieba.im.model.MsglistModel;
/* loaded from: classes.dex */
class n implements AbsMsglistView.a {
    final /* synthetic */ FloatingPersonalChatActivity dbp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(FloatingPersonalChatActivity floatingPersonalChatActivity) {
        this.dbp = floatingPersonalChatActivity;
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView.a
    public void d(VoiceData.VoiceModel voiceModel) {
        MsglistModel msglistModel;
        if (voiceModel != null) {
            msglistModel = this.dbp.cFR;
            msglistModel.sendMsgVoice(voiceModel.voiceId, voiceModel.duration);
        }
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView.a
    public void ajU() {
    }
}
