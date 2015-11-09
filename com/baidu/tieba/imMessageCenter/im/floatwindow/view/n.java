package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tieba.im.chat.AbsMsglistView;
import com.baidu.tieba.im.model.MsglistModel;
/* loaded from: classes.dex */
class n implements AbsMsglistView.a {
    final /* synthetic */ FloatingPersonalChatActivity bMS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(FloatingPersonalChatActivity floatingPersonalChatActivity) {
        this.bMS = floatingPersonalChatActivity;
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView.a
    public void c(VoiceData.VoiceModel voiceModel) {
        MsglistModel msglistModel;
        if (voiceModel != null) {
            msglistModel = this.bMS.mListModel;
            msglistModel.sendMsgVoice(voiceModel.voiceId, voiceModel.duration);
        }
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView.a
    public void RI() {
    }
}
