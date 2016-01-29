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
import com.baidu.tbadk.util.n;
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
    private ProgressBar aNo;
    private ChatMessage cfu;
    private ImageView cgX;
    private ImageView cgY;
    private TextView cgZ;
    private ImageView cha;
    private VoiceData.VoiceModel chb;
    private RelativeLayout chc;

    public ChatVoiceView(Context context) {
        super(context);
        this.cgX = null;
        this.cgZ = null;
        this.cha = null;
        this.aNo = null;
        LayoutInflater.from(context).inflate(t.h.widget_left_voice_view, (ViewGroup) this, true);
        init();
    }

    public ChatVoiceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        boolean z;
        this.cgX = null;
        this.cgZ = null;
        this.cha = null;
        this.aNo = null;
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
        this.chc = (RelativeLayout) findViewById(t.g.lay_bubble);
        this.cgX = (ImageView) findViewById(t.g.img_voice_status);
        this.cgY = (ImageView) findViewById(t.g.img_voice_status_anim);
        this.cgZ = (TextView) findViewById(t.g.tex_voice_duration);
        this.cha = (ImageView) findViewById(t.g.img_voice_readed);
        this.aNo = (ProgressBar) findViewById(t.g.progress);
    }

    private void afq() {
        this.cgX.setVisibility(8);
        this.cgY.setVisibility(0);
        ((AnimationDrawable) this.cgY.getBackground()).start();
    }

    private void afr() {
        ((AnimationDrawable) this.cgY.getBackground()).stop();
        this.cgY.clearAnimation();
        this.cgX.setVisibility(0);
        this.cgY.setVisibility(8);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        try {
            afr();
        } catch (Exception e) {
        }
    }

    public void jA(int i) {
    }

    public void jB(int i) {
        if (i == 3) {
            if (this.cgX != null) {
                this.cgX.setVisibility(0);
            }
            this.aNo.setVisibility(4);
            afq();
            VoiceMsgData v = com.baidu.tieba.im.util.h.v(this.cfu);
            if (v != null && v.getHas_read() != 1) {
                v.setHas_read(1);
                this.cfu.setContent("[" + i.jsonStrWithObject(v) + "]");
                if (this.cfu instanceof CommonGroupChatMessage) {
                    CommonGroupChatMessage commonGroupChatMessage = (CommonGroupChatMessage) this.cfu;
                    LinkedList linkedList = new LinkedList();
                    linkedList.add(new CommonMsgPojo(commonGroupChatMessage));
                    if (!commonGroupChatMessage.getGroupId().equals(String.valueOf(com.baidu.tieba.im.c.a.ceW))) {
                        n.b(new a(this, commonGroupChatMessage, linkedList), new b(this));
                        return;
                    } else {
                        n.b(new c(this, commonGroupChatMessage, linkedList), new d(this));
                        return;
                    }
                } else if (this.cfu instanceof PersonalChatMessage) {
                    PersonalChatMessage personalChatMessage = (PersonalChatMessage) this.cfu;
                    LinkedList linkedList2 = new LinkedList();
                    linkedList2.add(new CommonMsgPojo(personalChatMessage));
                    n.b(new e(this, personalChatMessage, linkedList2), new f(this));
                    return;
                } else if (this.cfu instanceof OfficialChatMessage) {
                    OfficialChatMessage officialChatMessage = (OfficialChatMessage) this.cfu;
                    LinkedList linkedList3 = new LinkedList();
                    linkedList3.add(new CommonMsgPojo(officialChatMessage));
                    n.b(new g(this, officialChatMessage, linkedList3), new h(this));
                    return;
                } else {
                    return;
                }
            }
            return;
        }
        afr();
        if (i == 1) {
            if (this.cgX != null) {
                this.cgX.setVisibility(0);
            }
            this.aNo.setVisibility(4);
        } else if (i == 2) {
            if (this.cgX != null) {
                this.cgX.setVisibility(4);
            }
            this.aNo.setVisibility(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        VoiceManager voiceManager;
        if (this.chb == null || (voiceManager = getVoiceManager()) == null) {
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
            this.cha.setVisibility(0);
        } else {
            this.cha.setVisibility(8);
        }
    }

    public void setData(ChatMessage chatMessage) {
        if (chatMessage != null && chatMessage.getCacheData() != null) {
            this.chb = chatMessage.getCacheData().getVoice_model();
            if (this.chb == null) {
                this.chb = new VoiceData.VoiceModel();
            }
            this.cfu = chatMessage;
            this.cgZ.setText(VoiceManager.formatVoiceTime(this.chb.duration));
            setBubbleLength(this.chb.duration);
            setTag(this.chb);
            z(chatMessage);
            jB(this.chb.voice_status.intValue());
        }
    }

    public void reset() {
        this.chb = null;
        jB(1);
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
            if (this.chc.getParent() != null && (this.chc.getParent() instanceof RelativeLayout)) {
                this.chc.setLayoutParams(new RelativeLayout.LayoutParams(i2, -2));
                return;
            }
            this.chc.setLayoutParams(new LinearLayout.LayoutParams(i2, -2));
        } catch (Exception e) {
        }
    }

    public boolean isPlaying() {
        return this.chb != null && this.chb.voice_status.intValue() == 3;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void oD() {
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void b(VoiceData.VoiceModel voiceModel) {
        if (voiceModel != null) {
            jB(voiceModel.voice_status.intValue());
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void aP(int i) {
        jA(i);
        if (this.chb != null) {
            this.chb.elapse = i;
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void onShowErr(int i, String str) {
        k.u(getContext(), str);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceData.VoiceModel getVoiceModel() {
        return this.chb;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceManager.b getRealView() {
        Context context = getContext();
        VoiceManager.b c = context instanceof VoiceManager.c ? ((VoiceManager.c) context).c(this.chb) : this;
        return c == null ? this : c;
    }
}
