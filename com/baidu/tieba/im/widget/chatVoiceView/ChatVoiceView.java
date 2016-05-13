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
import com.baidu.tieba.t;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class ChatVoiceView extends LinearLayout implements View.OnClickListener, VoiceManager.b {
    private ProgressBar bDI;
    private ChatMessage cqW;
    private ImageView csA;
    private TextView csB;
    private ImageView csC;
    private VoiceData.VoiceModel csD;
    private RelativeLayout csE;
    private ImageView csz;

    public ChatVoiceView(Context context) {
        super(context);
        this.csz = null;
        this.csB = null;
        this.csC = null;
        this.bDI = null;
        LayoutInflater.from(context).inflate(t.h.widget_left_voice_view, (ViewGroup) this, true);
        init();
    }

    public ChatVoiceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        boolean z;
        this.csz = null;
        this.csB = null;
        this.csC = null;
        this.bDI = null;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, t.l.ChatVoiceView, 0, 0);
        if (obtainStyledAttributes != null) {
            z = obtainStyledAttributes.getBoolean(0, true);
            obtainStyledAttributes.recycle();
        } else {
            z = true;
        }
        if (z) {
            LayoutInflater.from(context).inflate(t.h.widget_left_voice_view, (ViewGroup) this, true);
        } else {
            LayoutInflater.from(context).inflate(t.h.widget_right_voice_view, (ViewGroup) this, true);
        }
        init();
    }

    private void init() {
        this.csE = (RelativeLayout) findViewById(t.g.lay_bubble);
        this.csz = (ImageView) findViewById(t.g.img_voice_status);
        this.csA = (ImageView) findViewById(t.g.img_voice_status_anim);
        this.csB = (TextView) findViewById(t.g.tex_voice_duration);
        this.csC = (ImageView) findViewById(t.g.img_voice_readed);
        this.bDI = (ProgressBar) findViewById(t.g.progress);
    }

    private void aiT() {
        this.csz.setVisibility(8);
        this.csA.setVisibility(0);
        ((AnimationDrawable) this.csA.getBackground()).start();
    }

    private void aiU() {
        ((AnimationDrawable) this.csA.getBackground()).stop();
        this.csA.clearAnimation();
        this.csz.setVisibility(0);
        this.csA.setVisibility(8);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        try {
            aiU();
        } catch (Exception e) {
        }
    }

    public void jK(int i) {
    }

    public void jL(int i) {
        if (i == 3) {
            if (this.csz != null) {
                this.csz.setVisibility(0);
            }
            this.bDI.setVisibility(4);
            aiT();
            VoiceMsgData v = com.baidu.tieba.im.util.h.v(this.cqW);
            if (v != null && v.getHas_read() != 1) {
                v.setHas_read(1);
                this.cqW.setContent("[" + i.jsonStrWithObject(v) + "]");
                if (this.cqW instanceof CommonGroupChatMessage) {
                    CommonGroupChatMessage commonGroupChatMessage = (CommonGroupChatMessage) this.cqW;
                    LinkedList linkedList = new LinkedList();
                    linkedList.add(new CommonMsgPojo(commonGroupChatMessage));
                    if (!commonGroupChatMessage.getGroupId().equals(String.valueOf(com.baidu.tieba.im.c.a.cqy))) {
                        com.baidu.tbadk.util.t.b(new a(this, commonGroupChatMessage, linkedList), new b(this));
                        return;
                    } else {
                        com.baidu.tbadk.util.t.b(new c(this, commonGroupChatMessage, linkedList), new d(this));
                        return;
                    }
                } else if (this.cqW instanceof PersonalChatMessage) {
                    PersonalChatMessage personalChatMessage = (PersonalChatMessage) this.cqW;
                    LinkedList linkedList2 = new LinkedList();
                    linkedList2.add(new CommonMsgPojo(personalChatMessage));
                    com.baidu.tbadk.util.t.b(new e(this, personalChatMessage, linkedList2), new f(this));
                    return;
                } else if (this.cqW instanceof OfficialChatMessage) {
                    OfficialChatMessage officialChatMessage = (OfficialChatMessage) this.cqW;
                    LinkedList linkedList3 = new LinkedList();
                    linkedList3.add(new CommonMsgPojo(officialChatMessage));
                    com.baidu.tbadk.util.t.b(new g(this, officialChatMessage, linkedList3), new h(this));
                    return;
                } else {
                    return;
                }
            }
            return;
        }
        aiU();
        if (i == 1) {
            if (this.csz != null) {
                this.csz.setVisibility(0);
            }
            this.bDI.setVisibility(4);
        } else if (i == 2) {
            if (this.csz != null) {
                this.csz.setVisibility(4);
            }
            this.bDI.setVisibility(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        VoiceManager voiceManager;
        if (this.csD == null || (voiceManager = getVoiceManager()) == null) {
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
            this.csC.setVisibility(0);
        } else {
            this.csC.setVisibility(8);
        }
    }

    public void setData(ChatMessage chatMessage) {
        if (chatMessage != null && chatMessage.getCacheData() != null) {
            this.csD = chatMessage.getCacheData().getVoice_model();
            if (this.csD == null) {
                this.csD = new VoiceData.VoiceModel();
            }
            this.cqW = chatMessage;
            this.csB.setText(VoiceManager.formatVoiceTime(this.csD.duration));
            this.csB.setContentDescription(String.format(getContext().getString(t.j.editor_record_format), VoiceManager.formatVoiceTime(this.csD.duration)));
            setBubbleLength(this.csD.duration);
            setTag(this.csD);
            z(chatMessage);
            jL(this.csD.voice_status.intValue());
        }
    }

    public void reset() {
        this.csD = null;
        jL(1);
    }

    private void setBubbleLength(int i) {
        int i2;
        int B = k.B(getContext());
        if (i <= 10) {
            int i3 = (int) (B * 0.1875d);
            i2 = (((((int) (B * 0.4125d)) - i3) * (i - 1)) / 10) + i3;
        } else if (i <= 30) {
            int i4 = (int) (B * 0.4125d);
            i2 = (((((int) (B * 0.5375d)) - i4) * (i - 10)) / 20) + i4;
        } else {
            i2 = (int) (B * 0.5375d);
        }
        try {
            if (this.csE.getParent() != null && (this.csE.getParent() instanceof RelativeLayout)) {
                this.csE.setLayoutParams(new RelativeLayout.LayoutParams(i2, -2));
                return;
            }
            this.csE.setLayoutParams(new LinearLayout.LayoutParams(i2, -2));
        } catch (Exception e) {
        }
    }

    public boolean isPlaying() {
        return this.csD != null && this.csD.voice_status.intValue() == 3;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void kJ() {
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void b(VoiceData.VoiceModel voiceModel) {
        if (voiceModel != null) {
            jL(voiceModel.voice_status.intValue());
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void aB(int i) {
        jK(i);
        if (this.csD != null) {
            this.csD.elapse = i;
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void onShowErr(int i, String str) {
        k.l(getContext(), str);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceData.VoiceModel getVoiceModel() {
        return this.csD;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceManager.b getRealView() {
        Context context = getContext();
        VoiceManager.b c = context instanceof VoiceManager.c ? ((VoiceManager.c) context).c(this.csD) : this;
        return c == null ? this : c;
    }
}
