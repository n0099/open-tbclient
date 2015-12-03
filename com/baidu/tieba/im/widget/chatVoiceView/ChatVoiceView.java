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
    private ChatMessage bWV;
    private ImageView bYA;
    private VoiceData.VoiceModel bYB;
    private RelativeLayout bYC;
    private ImageView bYx;
    private ImageView bYy;
    private TextView bYz;
    private ProgressBar mProgress;

    public ChatVoiceView(Context context) {
        super(context);
        this.bYx = null;
        this.bYz = null;
        this.bYA = null;
        this.mProgress = null;
        LayoutInflater.from(context).inflate(n.g.widget_left_voice_view, (ViewGroup) this, true);
        init();
    }

    public ChatVoiceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        boolean z;
        this.bYx = null;
        this.bYz = null;
        this.bYA = null;
        this.mProgress = null;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, n.k.ChatVoiceView, 0, 0);
        if (obtainStyledAttributes != null) {
            z = obtainStyledAttributes.getBoolean(0, true);
            obtainStyledAttributes.recycle();
        } else {
            z = true;
        }
        if (z) {
            LayoutInflater.from(context).inflate(n.g.widget_left_voice_view, (ViewGroup) this, true);
        } else {
            LayoutInflater.from(context).inflate(n.g.widget_right_voice_view, (ViewGroup) this, true);
        }
        init();
    }

    private void init() {
        this.bYC = (RelativeLayout) findViewById(n.f.lay_bubble);
        this.bYx = (ImageView) findViewById(n.f.img_voice_status);
        this.bYy = (ImageView) findViewById(n.f.img_voice_status_anim);
        this.bYz = (TextView) findViewById(n.f.tex_voice_duration);
        this.bYA = (ImageView) findViewById(n.f.img_voice_readed);
        this.mProgress = (ProgressBar) findViewById(n.f.progress);
    }

    private void aaZ() {
        this.bYx.setVisibility(8);
        this.bYy.setVisibility(0);
        ((AnimationDrawable) this.bYy.getBackground()).start();
    }

    private void aba() {
        ((AnimationDrawable) this.bYy.getBackground()).stop();
        this.bYy.clearAnimation();
        this.bYx.setVisibility(0);
        this.bYy.setVisibility(8);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        try {
            aba();
        } catch (Exception e) {
        }
    }

    public void iE(int i) {
    }

    public void iF(int i) {
        if (i == 3) {
            if (this.bYx != null) {
                this.bYx.setVisibility(0);
            }
            this.mProgress.setVisibility(4);
            aaZ();
            VoiceMsgData v = com.baidu.tieba.im.util.h.v(this.bWV);
            if (v != null && v.getHas_read() != 1) {
                v.setHas_read(1);
                this.bWV.setContent("[" + i.jsonStrWithObject(v) + "]");
                if (this.bWV instanceof CommonGroupChatMessage) {
                    CommonGroupChatMessage commonGroupChatMessage = (CommonGroupChatMessage) this.bWV;
                    LinkedList linkedList = new LinkedList();
                    linkedList.add(new CommonMsgPojo(commonGroupChatMessage));
                    if (!commonGroupChatMessage.getGroupId().equals(String.valueOf(com.baidu.tieba.im.c.a.bWy))) {
                        com.baidu.tbadk.util.n.b(new a(this, commonGroupChatMessage, linkedList), new b(this));
                        return;
                    } else {
                        com.baidu.tbadk.util.n.b(new c(this, commonGroupChatMessage, linkedList), new d(this));
                        return;
                    }
                } else if (this.bWV instanceof PersonalChatMessage) {
                    PersonalChatMessage personalChatMessage = (PersonalChatMessage) this.bWV;
                    LinkedList linkedList2 = new LinkedList();
                    linkedList2.add(new CommonMsgPojo(personalChatMessage));
                    com.baidu.tbadk.util.n.b(new e(this, personalChatMessage, linkedList2), new f(this));
                    return;
                } else if (this.bWV instanceof OfficialChatMessage) {
                    OfficialChatMessage officialChatMessage = (OfficialChatMessage) this.bWV;
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
        aba();
        if (i == 1) {
            if (this.bYx != null) {
                this.bYx.setVisibility(0);
            }
            this.mProgress.setVisibility(4);
        } else if (i == 2) {
            if (this.bYx != null) {
                this.bYx.setVisibility(4);
            }
            this.mProgress.setVisibility(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        VoiceManager voiceManager;
        if (this.bYB == null || (voiceManager = getVoiceManager()) == null) {
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
            this.bYA.setVisibility(0);
        } else {
            this.bYA.setVisibility(8);
        }
    }

    public void setData(ChatMessage chatMessage) {
        if (chatMessage != null && chatMessage.getCacheData() != null) {
            this.bYB = chatMessage.getCacheData().getVoice_model();
            if (this.bYB == null) {
                this.bYB = new VoiceData.VoiceModel();
            }
            this.bWV = chatMessage;
            this.bYz.setText(VoiceManager.formatVoiceTime(this.bYB.duration));
            setBubbleLength(this.bYB.duration);
            setTag(this.bYB);
            z(chatMessage);
            iF(this.bYB.voice_status.intValue());
        }
    }

    public void reset() {
        this.bYB = null;
        iF(1);
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
            if (this.bYC.getParent() != null && (this.bYC.getParent() instanceof RelativeLayout)) {
                this.bYC.setLayoutParams(new RelativeLayout.LayoutParams(i2, -2));
                return;
            }
            this.bYC.setLayoutParams(new LinearLayout.LayoutParams(i2, -2));
        } catch (Exception e) {
        }
    }

    public boolean isPlaying() {
        return this.bYB != null && this.bYB.voice_status.intValue() == 3;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void oK() {
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void b(VoiceData.VoiceModel voiceModel) {
        if (voiceModel != null) {
            iF(voiceModel.voice_status.intValue());
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void aJ(int i) {
        iE(i);
        if (this.bYB != null) {
            this.bYB.elapse = i;
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void onShowErr(int i, String str) {
        k.u(getContext(), str);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceData.VoiceModel getVoiceModel() {
        return this.bYB;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceManager.b getRealView() {
        Context context = getContext();
        VoiceManager.b realView = context instanceof VoiceManager.c ? ((VoiceManager.c) context).getRealView(this.bYB) : this;
        return realView == null ? this : realView;
    }
}
