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
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.util.m;
import com.baidu.tieba.i;
import com.baidu.tieba.im.data.VoiceMsgData;
import com.baidu.tieba.im.db.pojo.CommonMsgPojo;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.message.chat.CommonGroupChatMessage;
import com.baidu.tieba.im.message.chat.OfficialChatMessage;
import com.baidu.tieba.im.message.chat.PersonalChatMessage;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class ChatVoiceView extends LinearLayout implements View.OnClickListener, VoiceManager.b {
    private ChatMessage bHj;
    private ImageView bIM;
    private ImageView bIN;
    private TextView bIO;
    private ImageView bIP;
    private VoiceData.VoiceModel bIQ;
    private RelativeLayout bIR;
    private ProgressBar mProgress;

    public ChatVoiceView(Context context) {
        super(context);
        this.bIM = null;
        this.bIO = null;
        this.bIP = null;
        this.mProgress = null;
        LayoutInflater.from(context).inflate(i.g.widget_left_voice_view, (ViewGroup) this, true);
        init();
    }

    public ChatVoiceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        boolean z;
        this.bIM = null;
        this.bIO = null;
        this.bIP = null;
        this.mProgress = null;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, i.j.ChatVoiceView, 0, 0);
        if (obtainStyledAttributes != null) {
            z = obtainStyledAttributes.getBoolean(0, true);
            obtainStyledAttributes.recycle();
        } else {
            z = true;
        }
        if (z) {
            LayoutInflater.from(context).inflate(i.g.widget_left_voice_view, (ViewGroup) this, true);
        } else {
            LayoutInflater.from(context).inflate(i.g.widget_right_voice_view, (ViewGroup) this, true);
        }
        init();
    }

    private void init() {
        this.bIR = (RelativeLayout) findViewById(i.f.lay_bubble);
        this.bIM = (ImageView) findViewById(i.f.img_voice_status);
        this.bIN = (ImageView) findViewById(i.f.img_voice_status_anim);
        this.bIO = (TextView) findViewById(i.f.tex_voice_duration);
        this.bIP = (ImageView) findViewById(i.f.img_voice_readed);
        this.mProgress = (ProgressBar) findViewById(i.f.progress);
    }

    private void XC() {
        this.bIM.setVisibility(8);
        this.bIN.setVisibility(0);
        ((AnimationDrawable) this.bIN.getBackground()).start();
    }

    private void XD() {
        ((AnimationDrawable) this.bIN.getBackground()).stop();
        this.bIN.clearAnimation();
        this.bIM.setVisibility(0);
        this.bIN.setVisibility(8);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        try {
            XD();
        } catch (Exception e) {
        }
    }

    public void hD(int i) {
    }

    public void hE(int i) {
        if (i == 3) {
            if (this.bIM != null) {
                this.bIM.setVisibility(0);
            }
            this.mProgress.setVisibility(4);
            XC();
            VoiceMsgData v = com.baidu.tieba.im.util.h.v(this.bHj);
            if (v != null && v.getHas_read() != 1) {
                v.setHas_read(1);
                this.bHj.setContent("[" + com.baidu.adp.lib.a.b.a.a.i.jsonStrWithObject(v) + "]");
                if (this.bHj instanceof CommonGroupChatMessage) {
                    CommonGroupChatMessage commonGroupChatMessage = (CommonGroupChatMessage) this.bHj;
                    LinkedList linkedList = new LinkedList();
                    linkedList.add(new CommonMsgPojo(commonGroupChatMessage));
                    if (!commonGroupChatMessage.getGroupId().equals(String.valueOf(com.baidu.tieba.im.c.a.bGM))) {
                        m.b(new a(this, commonGroupChatMessage, linkedList), new b(this));
                        return;
                    } else {
                        m.b(new c(this, commonGroupChatMessage, linkedList), new d(this));
                        return;
                    }
                } else if (this.bHj instanceof PersonalChatMessage) {
                    PersonalChatMessage personalChatMessage = (PersonalChatMessage) this.bHj;
                    LinkedList linkedList2 = new LinkedList();
                    linkedList2.add(new CommonMsgPojo(personalChatMessage));
                    m.b(new e(this, personalChatMessage, linkedList2), new f(this));
                    return;
                } else if (this.bHj instanceof OfficialChatMessage) {
                    OfficialChatMessage officialChatMessage = (OfficialChatMessage) this.bHj;
                    LinkedList linkedList3 = new LinkedList();
                    linkedList3.add(new CommonMsgPojo(officialChatMessage));
                    m.b(new g(this, officialChatMessage, linkedList3), new h(this));
                    return;
                } else {
                    return;
                }
            }
            return;
        }
        XD();
        if (i == 1) {
            if (this.bIM != null) {
                this.bIM.setVisibility(0);
            }
            this.mProgress.setVisibility(4);
        } else if (i == 2) {
            if (this.bIM != null) {
                this.bIM.setVisibility(4);
            }
            this.mProgress.setVisibility(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        VoiceManager voiceManager;
        if (this.bIQ == null || (voiceManager = getVoiceManager()) == null) {
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
            this.bIP.setVisibility(0);
        } else {
            this.bIP.setVisibility(8);
        }
    }

    public void setData(ChatMessage chatMessage) {
        if (chatMessage != null && chatMessage.getCacheData() != null) {
            this.bIQ = chatMessage.getCacheData().getVoice_model();
            if (this.bIQ == null) {
                this.bIQ = new VoiceData.VoiceModel();
            }
            this.bHj = chatMessage;
            this.bIO.setText(VoiceManager.formatVoiceTime(this.bIQ.duration));
            setBubbleLength(this.bIQ.duration);
            setTag(this.bIQ);
            z(chatMessage);
            hE(this.bIQ.voice_status.intValue());
        }
    }

    public void reset() {
        this.bIQ = null;
        hE(1);
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
            if (this.bIR.getParent() != null && (this.bIR.getParent() instanceof RelativeLayout)) {
                this.bIR.setLayoutParams(new RelativeLayout.LayoutParams(i2, -2));
                return;
            }
            this.bIR.setLayoutParams(new LinearLayout.LayoutParams(i2, -2));
        } catch (Exception e) {
        }
    }

    public boolean isPlaying() {
        return this.bIQ != null && this.bIQ.voice_status.intValue() == 3;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void oD() {
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void b(VoiceData.VoiceModel voiceModel) {
        if (voiceModel != null) {
            hE(voiceModel.voice_status.intValue());
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void aI(int i) {
        hD(i);
        if (this.bIQ != null) {
            this.bIQ.elapse = i;
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void onShowErr(int i, String str) {
        k.u(getContext(), str);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceData.VoiceModel getVoiceModel() {
        return this.bIQ;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceManager.b getRealView() {
        Context context = getContext();
        VoiceManager.b realView = context instanceof VoiceManager.c ? ((VoiceManager.c) context).getRealView(this.bIQ) : this;
        return realView == null ? this : realView;
    }
}
