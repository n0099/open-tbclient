package com.baidu.tieba.livesdk.d;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.f.b;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.extrajump.interfaces.IExtraJump;
import com.baidu.live.tbadk.extrajump.interfaces.IExtraJumpBuilder;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonPolymericActivityConfig;
/* loaded from: classes10.dex */
public class a implements IExtraJumpBuilder {
    @Override // com.baidu.live.tbadk.extrajump.interfaces.IExtraJumpBuilder
    public IExtraJump build() {
        return new C0797a();
    }

    /* renamed from: com.baidu.tieba.livesdk.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    private static class C0797a implements IExtraJump {
        private C0797a() {
        }

        @Override // com.baidu.live.tbadk.extrajump.interfaces.IExtraJump
        public void jumpToPersonalCenter(Activity activity, String str) {
            if (activity != null && !StringUtils.isNull(str)) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(activity).createNormalConfig(b.toLong(str, 0L), !TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount()) && TbadkCoreApplication.getCurrentAccount().equals(str), false)));
            }
        }

        @Override // com.baidu.live.tbadk.extrajump.interfaces.IExtraJump
        public void jumpToPlayCallback(Context context, Object obj) {
        }
    }
}
