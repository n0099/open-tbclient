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
import com.baidu.tieba.u;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class ChatVoiceView extends LinearLayout implements View.OnClickListener, VoiceManager.b {
    private ChatMessage cZh;
    private ProgressBar cdm;
    private ImageView daL;
    private ImageView daM;
    private TextView daN;
    private ImageView daO;
    private VoiceData.VoiceModel daP;
    private RelativeLayout daQ;

    public ChatVoiceView(Context context) {
        super(context);
        this.daL = null;
        this.daN = null;
        this.daO = null;
        this.cdm = null;
        LayoutInflater.from(context).inflate(u.h.widget_left_voice_view, (ViewGroup) this, true);
        init();
    }

    public ChatVoiceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        boolean z;
        this.daL = null;
        this.daN = null;
        this.daO = null;
        this.cdm = null;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, u.l.ChatVoiceView, 0, 0);
        if (obtainStyledAttributes != null) {
            z = obtainStyledAttributes.getBoolean(0, true);
            obtainStyledAttributes.recycle();
        } else {
            z = true;
        }
        if (z) {
            LayoutInflater.from(context).inflate(u.h.widget_left_voice_view, (ViewGroup) this, true);
        } else {
            LayoutInflater.from(context).inflate(u.h.widget_right_voice_view, (ViewGroup) this, true);
        }
        init();
    }

    private void init() {
        this.daQ = (RelativeLayout) findViewById(u.g.lay_bubble);
        this.daL = (ImageView) findViewById(u.g.img_voice_status);
        this.daM = (ImageView) findViewById(u.g.img_voice_status_anim);
        this.daN = (TextView) findViewById(u.g.tex_voice_duration);
        this.daO = (ImageView) findViewById(u.g.img_voice_readed);
        this.cdm = (ProgressBar) findViewById(u.g.progress);
    }

    private void arS() {
        this.daL.setVisibility(8);
        this.daM.setVisibility(0);
        ((AnimationDrawable) this.daM.getBackground()).start();
    }

    private void arT() {
        ((AnimationDrawable) this.daM.getBackground()).stop();
        this.daM.clearAnimation();
        this.daL.setVisibility(0);
        this.daM.setVisibility(8);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        try {
            arT();
        } catch (Exception e) {
        }
    }

    public void ls(int i) {
    }

    public void lt(int i) {
        if (i == 3) {
            if (this.daL != null) {
                this.daL.setVisibility(0);
            }
            this.cdm.setVisibility(4);
            arS();
            VoiceMsgData w = com.baidu.tieba.im.util.h.w(this.cZh);
            if (w != null && w.getHas_read() != 1) {
                w.setHas_read(1);
                this.cZh.setContent("[" + i.jsonStrWithObject(w) + "]");
                if (this.cZh instanceof CommonGroupChatMessage) {
                    CommonGroupChatMessage commonGroupChatMessage = (CommonGroupChatMessage) this.cZh;
                    LinkedList linkedList = new LinkedList();
                    linkedList.add(new CommonMsgPojo(commonGroupChatMessage));
                    if (!commonGroupChatMessage.getGroupId().equals(String.valueOf(com.baidu.tieba.im.c.a.cYJ))) {
                        com.baidu.tbadk.util.u.b(new a(this, commonGroupChatMessage, linkedList), new b(this));
                        return;
                    } else {
                        com.baidu.tbadk.util.u.b(new c(this, commonGroupChatMessage, linkedList), new d(this));
                        return;
                    }
                } else if (this.cZh instanceof PersonalChatMessage) {
                    PersonalChatMessage personalChatMessage = (PersonalChatMessage) this.cZh;
                    LinkedList linkedList2 = new LinkedList();
                    linkedList2.add(new CommonMsgPojo(personalChatMessage));
                    com.baidu.tbadk.util.u.b(new e(this, personalChatMessage, linkedList2), new f(this));
                    return;
                } else if (this.cZh instanceof OfficialChatMessage) {
                    OfficialChatMessage officialChatMessage = (OfficialChatMessage) this.cZh;
                    LinkedList linkedList3 = new LinkedList();
                    linkedList3.add(new CommonMsgPojo(officialChatMessage));
                    com.baidu.tbadk.util.u.b(new g(this, officialChatMessage, linkedList3), new h(this));
                    return;
                } else {
                    return;
                }
            }
            return;
        }
        arT();
        if (i == 1) {
            if (this.daL != null) {
                this.daL.setVisibility(0);
            }
            this.cdm.setVisibility(4);
        } else if (i == 2) {
            if (this.daL != null) {
                this.daL.setVisibility(4);
            }
            this.cdm.setVisibility(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        VoiceManager voiceManager;
        if (this.daP == null || (voiceManager = getVoiceManager()) == null) {
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

    private void A(ChatMessage chatMessage) {
        boolean z = true;
        if (com.baidu.tieba.im.util.h.t(chatMessage)) {
            z = false;
        } else {
            VoiceMsgData w = com.baidu.tieba.im.util.h.w(chatMessage);
            if (w != null && w.getHas_read() == 1) {
                z = false;
            }
        }
        if (z) {
            this.daO.setVisibility(0);
        } else {
            this.daO.setVisibility(8);
        }
    }

    public void setData(ChatMessage chatMessage) {
        VoiceManager voiceManager;
        if (chatMessage != null && chatMessage.getCacheData() != null) {
            this.daP = chatMessage.getCacheData().getVoice_model();
            if (this.daP == null) {
                this.daP = new VoiceData.VoiceModel();
            }
            this.cZh = chatMessage;
            this.daN.setText(VoiceManager.formatVoiceTime(this.daP.duration));
            this.daN.setContentDescription(String.format(getContext().getString(u.j.editor_record_format), VoiceManager.formatVoiceTime(this.daP.duration)));
            setBubbleLength(this.daP.duration);
            setTag(this.daP);
            A(chatMessage);
            if (this.daP.voice_status.intValue() != 1 && (voiceManager = getVoiceManager()) != null) {
                voiceManager.resetPlayView(this);
            }
            lt(this.daP.voice_status.intValue());
        }
    }

    public void reset() {
        this.daP = null;
        lt(1);
    }

    private void setBubbleLength(int i) {
        int i2;
        int A = k.A(getContext());
        if (i <= 10) {
            int i3 = (int) (A * 0.1875d);
            i2 = (((((int) (A * 0.4125d)) - i3) * (i - 1)) / 10) + i3;
        } else if (i <= 30) {
            int i4 = (int) (A * 0.4125d);
            i2 = (((((int) (A * 0.5375d)) - i4) * (i - 10)) / 20) + i4;
        } else {
            i2 = (int) (A * 0.5375d);
        }
        try {
            if (this.daQ.getParent() != null && (this.daQ.getParent() instanceof RelativeLayout)) {
                this.daQ.setLayoutParams(new RelativeLayout.LayoutParams(i2, -2));
                return;
            }
            this.daQ.setLayoutParams(new LinearLayout.LayoutParams(i2, -2));
        } catch (Exception e) {
        }
    }

    public boolean isPlaying() {
        return this.daP != null && this.daP.voice_status.intValue() == 3;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void kI() {
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void b(VoiceData.VoiceModel voiceModel) {
        if (voiceModel != null) {
            lt(voiceModel.voice_status.intValue());
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void aF(int i) {
        ls(i);
        if (this.daP != null) {
            this.daP.elapse = i;
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void onShowErr(int i, String str) {
        k.m(getContext(), str);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceData.VoiceModel getVoiceModel() {
        return this.daP;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceManager.b getRealView() {
        Context context = getContext();
        VoiceManager.b c = context instanceof VoiceManager.c ? ((VoiceManager.c) context).c(this.daP) : this;
        return c == null ? this : c;
    }
}
