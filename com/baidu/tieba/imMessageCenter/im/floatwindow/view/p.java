package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tieba.im.model.MsglistModel;
/* loaded from: classes.dex */
class p implements com.baidu.tieba.im.chat.w {
    final /* synthetic */ FloatingPersonalChatActivity brH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(FloatingPersonalChatActivity floatingPersonalChatActivity) {
        this.brH = floatingPersonalChatActivity;
    }

    @Override // com.baidu.tieba.im.chat.w
    public void c(VoiceData.VoiceModel voiceModel) {
        MsglistModel msglistModel;
        if (voiceModel != null) {
            msglistModel = this.brH.mListModel;
            msglistModel.sendMsgVoice(voiceModel.voiceId, voiceModel.duration);
        }
    }

    @Override // com.baidu.tieba.im.chat.w
    public void Nt() {
    }
}
