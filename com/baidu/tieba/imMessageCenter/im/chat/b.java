package com.baidu.tieba.imMessageCenter.im.chat;

import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tieba.im.chat.AbsMsglistView;
import com.baidu.tieba.im.model.MsglistModel;
/* loaded from: classes.dex */
class b implements AbsMsglistView.a {
    final /* synthetic */ PersonalChatActivity cZd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(PersonalChatActivity personalChatActivity) {
        this.cZd = personalChatActivity;
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView.a
    public void d(VoiceData.VoiceModel voiceModel) {
        MsglistModel msglistModel;
        if (voiceModel != null) {
            msglistModel = this.cZd.cGA;
            msglistModel.sendMsgVoice(voiceModel.voiceId, voiceModel.duration);
        }
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView.a
    public void amr() {
    }
}
