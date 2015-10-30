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
    private ChatMessage bHu;
    private ImageView bIX;
    private ImageView bIY;
    private TextView bIZ;
    private ImageView bJa;
    private VoiceData.VoiceModel bJb;
    private RelativeLayout bJc;
    private ProgressBar mProgress;

    public ChatVoiceView(Context context) {
        super(context);
        this.bIX = null;
        this.bIZ = null;
        this.bJa = null;
        this.mProgress = null;
        LayoutInflater.from(context).inflate(i.g.widget_left_voice_view, (ViewGroup) this, true);
        init();
    }

    public ChatVoiceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        boolean z;
        this.bIX = null;
        this.bIZ = null;
        this.bJa = null;
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
        this.bJc = (RelativeLayout) findViewById(i.f.lay_bubble);
        this.bIX = (ImageView) findViewById(i.f.img_voice_status);
        this.bIY = (ImageView) findViewById(i.f.img_voice_status_anim);
        this.bIZ = (TextView) findViewById(i.f.tex_voice_duration);
        this.bJa = (ImageView) findViewById(i.f.img_voice_readed);
        this.mProgress = (ProgressBar) findViewById(i.f.progress);
    }

    private void Xy() {
        this.bIX.setVisibility(8);
        this.bIY.setVisibility(0);
        ((AnimationDrawable) this.bIY.getBackground()).start();
    }

    private void Xz() {
        ((AnimationDrawable) this.bIY.getBackground()).stop();
        this.bIY.clearAnimation();
        this.bIX.setVisibility(0);
        this.bIY.setVisibility(8);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        try {
            Xz();
        } catch (Exception e) {
        }
    }

    public void hD(int i) {
    }

    public void hE(int i) {
        if (i == 3) {
            if (this.bIX != null) {
                this.bIX.setVisibility(0);
            }
            this.mProgress.setVisibility(4);
            Xy();
            VoiceMsgData v = com.baidu.tieba.im.util.h.v(this.bHu);
            if (v != null && v.getHas_read() != 1) {
                v.setHas_read(1);
                this.bHu.setContent("[" + com.baidu.adp.lib.a.b.a.a.i.jsonStrWithObject(v) + "]");
                if (this.bHu instanceof CommonGroupChatMessage) {
                    CommonGroupChatMessage commonGroupChatMessage = (CommonGroupChatMessage) this.bHu;
                    LinkedList linkedList = new LinkedList();
                    linkedList.add(new CommonMsgPojo(commonGroupChatMessage));
                    if (!commonGroupChatMessage.getGroupId().equals(String.valueOf(com.baidu.tieba.im.c.a.bGX))) {
                        m.b(new a(this, commonGroupChatMessage, linkedList), new b(this));
                        return;
                    } else {
                        m.b(new c(this, commonGroupChatMessage, linkedList), new d(this));
                        return;
                    }
                } else if (this.bHu instanceof PersonalChatMessage) {
                    PersonalChatMessage personalChatMessage = (PersonalChatMessage) this.bHu;
                    LinkedList linkedList2 = new LinkedList();
                    linkedList2.add(new CommonMsgPojo(personalChatMessage));
                    m.b(new e(this, personalChatMessage, linkedList2), new f(this));
                    return;
                } else if (this.bHu instanceof OfficialChatMessage) {
                    OfficialChatMessage officialChatMessage = (OfficialChatMessage) this.bHu;
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
        Xz();
        if (i == 1) {
            if (this.bIX != null) {
                this.bIX.setVisibility(0);
            }
            this.mProgress.setVisibility(4);
        } else if (i == 2) {
            if (this.bIX != null) {
                this.bIX.setVisibility(4);
            }
            this.mProgress.setVisibility(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        VoiceManager voiceManager;
        if (this.bJb == null || (voiceManager = getVoiceManager()) == null) {
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
            this.bJa.setVisibility(0);
        } else {
            this.bJa.setVisibility(8);
        }
    }

    public void setData(ChatMessage chatMessage) {
        if (chatMessage != null && chatMessage.getCacheData() != null) {
            this.bJb = chatMessage.getCacheData().getVoice_model();
            if (this.bJb == null) {
                this.bJb = new VoiceData.VoiceModel();
            }
            this.bHu = chatMessage;
            this.bIZ.setText(VoiceManager.formatVoiceTime(this.bJb.duration));
            setBubbleLength(this.bJb.duration);
            setTag(this.bJb);
            z(chatMessage);
            hE(this.bJb.voice_status.intValue());
        }
    }

    public void reset() {
        this.bJb = null;
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
            if (this.bJc.getParent() != null && (this.bJc.getParent() instanceof RelativeLayout)) {
                this.bJc.setLayoutParams(new RelativeLayout.LayoutParams(i2, -2));
                return;
            }
            this.bJc.setLayoutParams(new LinearLayout.LayoutParams(i2, -2));
        } catch (Exception e) {
        }
    }

    public boolean isPlaying() {
        return this.bJb != null && this.bJb.voice_status.intValue() == 3;
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
        if (this.bJb != null) {
            this.bJb.elapse = i;
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void onShowErr(int i, String str) {
        k.u(getContext(), str);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceData.VoiceModel getVoiceModel() {
        return this.bJb;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceManager.b getRealView() {
        Context context = getContext();
        VoiceManager.b realView = context instanceof VoiceManager.c ? ((VoiceManager.c) context).getRealView(this.bJb) : this;
        return realView == null ? this : realView;
    }
}
