package com.baidu.tieba.tbadkCore.c;

import android.content.Context;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tieba.s;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m extends ClickableSpan {
    final /* synthetic */ j coc;
    private Context mContext;
    private String mId;
    private String mName;

    public m(j jVar, Context context, String str, String str2) {
        this.coc = jVar;
        this.mName = null;
        this.mId = null;
        this.mContext = null;
        this.mName = str;
        this.mId = str2;
        this.mContext = context;
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        if (this.mContext != null) {
            textPaint.setColor(ba.getColor(s.cp_link_tip_c));
        }
        textPaint.setUnderlineText(false);
        textPaint.setFakeBoldText(false);
    }

    @Override // android.text.style.ClickableSpan
    public void onClick(View view) {
        if (this.mName != null && this.mId != null && this.mContext != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.mContext, this.mId, this.mName, null, AddFriendActivityConfig.TYPE_PB_FLOOR)));
        }
    }
}
