package com.baidu.tieba.im.widget.chatVoiceView;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.AnimationDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.a.b.a.a.i;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tieba.im.data.VoiceMsgData;
import com.baidu.tieba.im.db.pojo.CommonMsgPojo;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.message.chat.CommonGroupChatMessage;
import com.baidu.tieba.im.message.chat.OfficialChatMessage;
import com.baidu.tieba.im.message.chat.PersonalChatMessage;
import com.baidu.tieba.n;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class ChatVoiceView extends LinearLayout implements View.OnClickListener, VoiceManager.b {
    private ChatMessage caU;
    private ImageView ccA;
    private VoiceData.VoiceModel ccB;
    private RelativeLayout ccC;
    private ImageView ccx;
    private ImageView ccy;
    private TextView ccz;
    private ProgressBar mProgress;

    public ChatVoiceView(Context context) {
        super(context);
        this.ccx = null;
        this.ccz = null;
        this.ccA = null;
        this.mProgress = null;
        LayoutInflater.from(context).inflate(n.h.widget_left_voice_view, (ViewGroup) this, true);
        init();
    }

    public ChatVoiceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        boolean z;
        this.ccx = null;
        this.ccz = null;
        this.ccA = null;
        this.mProgress = null;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, n.l.ChatVoiceView, 0, 0);
        if (obtainStyledAttributes != null) {
            z = obtainStyledAttributes.getBoolean(0, true);
            obtainStyledAttributes.recycle();
        } else {
            z = true;
        }
        if (z) {
            LayoutInflater.from(context).inflate(n.h.widget_left_voice_view, (ViewGroup) this, true);
        } else {
            LayoutInflater.from(context).inflate(n.h.widget_right_voice_view, (ViewGroup) this, true);
        }
        init();
    }

    private void init() {
        this.ccC = (RelativeLayout) findViewById(n.g.lay_bubble);
        this.ccx = (ImageView) findViewById(n.g.img_voice_status);
        this.ccy = (ImageView) findViewById(n.g.img_voice_status_anim);
        this.ccz = (TextView) findViewById(n.g.tex_voice_duration);
        this.ccA = (ImageView) findViewById(n.g.img_voice_readed);
        this.mProgress = (ProgressBar) findViewById(n.g.progress);
    }

    private void aci() {
        this.ccx.setVisibility(8);
        this.ccy.setVisibility(0);
        ((AnimationDrawable) this.ccy.getBackground()).start();
    }

    private void acj() {
        ((AnimationDrawable) this.ccy.getBackground()).stop();
        this.ccy.clearAnimation();
        this.ccx.setVisibility(0);
        this.ccy.setVisibility(8);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        try {
            acj();
        } catch (Exception e) {
        }
    }

    public void jd(int i) {
    }

    public void je(int i) {
        if (i == 3) {
            if (this.ccx != null) {
                this.ccx.setVisibility(0);
            }
            this.mProgress.setVisibility(4);
            aci();
            VoiceMsgData v = com.baidu.tieba.im.util.h.v(this.caU);
            if (v != null && v.getHas_read() != 1) {
                v.setHas_read(1);
                this.caU.setContent("[" + i.jsonStrWithObject(v) + "]");
                if (this.caU instanceof CommonGroupChatMessage) {
                    CommonGroupChatMessage commonGroupChatMessage = (CommonGroupChatMessage) this.caU;
                    LinkedList linkedList = new LinkedList();
                    linkedList.add(new CommonMsgPojo(commonGroupChatMessage));
                    if (!commonGroupChatMessage.getGroupId().equals(String.valueOf(com.baidu.tieba.im.c.a.cax))) {
                        com.baidu.tbadk.util.n.b(new a(this, commonGroupChatMessage, linkedList), new b(this));
                        return;
                    } else {
                        com.baidu.tbadk.util.n.b(new c(this, commonGroupChatMessage, linkedList), new d(this));
                        return;
                    }
                } else if (this.caU instanceof PersonalChatMessage) {
                    PersonalChatMessage personalChatMessage = (PersonalChatMessage) this.caU;
                    LinkedList linkedList2 = new LinkedList();
                    linkedList2.add(new CommonMsgPojo(personalChatMessage));
                    com.baidu.tbadk.util.n.b(new e(this, personalChatMessage, linkedList2), new f(this));
                    return;
                } else if (this.caU instanceof OfficialChatMessage) {
                    OfficialChatMessage officialChatMessage = (OfficialChatMessage) this.caU;
                    LinkedList linkedList3 = new LinkedList();
                    linkedList3.add(new CommonMsgPojo(officialChatMessage));
                    com.baidu.tbadk.util.n.b(new g(this, officialChatMessage, linkedList3), new h(this));
                    return;
                } else {
                    return;
                }
            }
            return;
        }
        acj();
        if (i == 1) {
            if (this.ccx != null) {
                this.ccx.setVisibility(0);
            }
            this.mProgress.setVisibility(4);
        } else if (i == 2) {
            if (this.ccx != null) {
                this.ccx.setVisibility(4);
            }
            this.mProgress.setVisibility(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        VoiceManager voiceManager;
        if (this.ccB == null || (voiceManager = getVoiceManager()) == null) {
            return;
        }
        voiceManager.startPlay(this);
    }

    public VoiceManager getVoiceManager() {
        Context context = getContext();
        if (context instanceof VoiceManager.c) {
            return ((VoiceManager.c) context).getVoiceManager();
        }
        return null;
    }

    private void z(ChatMessage chatMessage) {
        boolean z = true;
        if (com.baidu.tieba.im.util.h.s(chatMessage)) {
            z = false;
        } else {
            VoiceMsgData v = com.baidu.tieba.im.util.h.v(chatMessage);
            if (v != null && v.getHas_read() == 1) {
                z = false;
            }
        }
        if (z) {
            this.ccA.setVisibility(0);
        } else {
            this.ccA.setVisibility(8);
        }
    }

    public void setData(ChatMessage chatMessage) {
        if (chatMessage != null && chatMessage.getCacheData() != null) {
            this.ccB = chatMessage.getCacheData().getVoice_model();
            if (this.ccB == null) {
                this.ccB = new VoiceData.VoiceModel();
            }
            this.caU = chatMessage;
            this.ccz.setText(VoiceManager.formatVoiceTime(this.ccB.duration));
            setBubbleLength(this.ccB.duration);
            setTag(this.ccB);
            z(chatMessage);
            je(this.ccB.voice_status.intValue());
        }
    }

    public void reset() {
        this.ccB = null;
        je(1);
    }

    private void setBubbleLength(int i) {
        int i2;
        int K = k.K(getContext());
        if (i <= 10) {
            int i3 = (int) (K * 0.1875d);
            i2 = (((((int) (K * 0.4125d)) - i3) * (i - 1)) / 10) + i3;
        } else if (i <= 30) {
            int i4 = (int) (K * 0.4125d);
            i2 = (((((int) (K * 0.5375d)) - i4) * (i - 10)) / 20) + i4;
        } else {
            i2 = (int) (K * 0.5375d);
        }
        try {
            if (this.ccC.getParent() != null && (this.ccC.getParent() instanceof RelativeLayout)) {
                this.ccC.setLayoutParams(new RelativeLayout.LayoutParams(i2, -2));
                return;
            }
            this.ccC.setLayoutParams(new LinearLayout.LayoutParams(i2, -2));
        } catch (Exception e) {
        }
    }

    public boolean isPlaying() {
        return this.ccB != null && this.ccB.voice_status.intValue() == 3;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void oi() {
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void b(VoiceData.VoiceModel voiceModel) {
        if (voiceModel != null) {
            je(voiceModel.voice_status.intValue());
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void aC(int i) {
        jd(i);
        if (this.ccB != null) {
            this.ccB.elapse = i;
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void onShowErr(int i, String str) {
        k.u(getContext(), str);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceData.VoiceModel getVoiceModel() {
        return this.ccB;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceManager.b getRealView() {
        Context context = getContext();
        VoiceManager.b realView = context instanceof VoiceManager.c ? ((VoiceManager.c) context).getRealView(this.ccB) : this;
        return realView == null ? this : realView;
    }
}
