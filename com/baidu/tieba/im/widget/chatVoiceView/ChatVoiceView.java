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
    private ChatMessage bHP;
    private ImageView bJs;
    private ImageView bJt;
    private TextView bJu;
    private ImageView bJv;
    private VoiceData.VoiceModel bJw;
    private RelativeLayout bJx;
    private ProgressBar mProgress;

    public ChatVoiceView(Context context) {
        super(context);
        this.bJs = null;
        this.bJu = null;
        this.bJv = null;
        this.mProgress = null;
        LayoutInflater.from(context).inflate(i.g.widget_left_voice_view, (ViewGroup) this, true);
        init();
    }

    public ChatVoiceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        boolean z;
        this.bJs = null;
        this.bJu = null;
        this.bJv = null;
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
        this.bJx = (RelativeLayout) findViewById(i.f.lay_bubble);
        this.bJs = (ImageView) findViewById(i.f.img_voice_status);
        this.bJt = (ImageView) findViewById(i.f.img_voice_status_anim);
        this.bJu = (TextView) findViewById(i.f.tex_voice_duration);
        this.bJv = (ImageView) findViewById(i.f.img_voice_readed);
        this.mProgress = (ProgressBar) findViewById(i.f.progress);
    }

    private void XT() {
        this.bJs.setVisibility(8);
        this.bJt.setVisibility(0);
        ((AnimationDrawable) this.bJt.getBackground()).start();
    }

    private void XU() {
        ((AnimationDrawable) this.bJt.getBackground()).stop();
        this.bJt.clearAnimation();
        this.bJs.setVisibility(0);
        this.bJt.setVisibility(8);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        try {
            XU();
        } catch (Exception e) {
        }
    }

    public void hQ(int i) {
    }

    public void hR(int i) {
        if (i == 3) {
            if (this.bJs != null) {
                this.bJs.setVisibility(0);
            }
            this.mProgress.setVisibility(4);
            XT();
            VoiceMsgData v = com.baidu.tieba.im.util.h.v(this.bHP);
            if (v != null && v.getHas_read() != 1) {
                v.setHas_read(1);
                this.bHP.setContent("[" + com.baidu.adp.lib.a.b.a.a.i.jsonStrWithObject(v) + "]");
                if (this.bHP instanceof CommonGroupChatMessage) {
                    CommonGroupChatMessage commonGroupChatMessage = (CommonGroupChatMessage) this.bHP;
                    LinkedList linkedList = new LinkedList();
                    linkedList.add(new CommonMsgPojo(commonGroupChatMessage));
                    if (!commonGroupChatMessage.getGroupId().equals(String.valueOf(com.baidu.tieba.im.c.a.bHs))) {
                        m.b(new a(this, commonGroupChatMessage, linkedList), new b(this));
                        return;
                    } else {
                        m.b(new c(this, commonGroupChatMessage, linkedList), new d(this));
                        return;
                    }
                } else if (this.bHP instanceof PersonalChatMessage) {
                    PersonalChatMessage personalChatMessage = (PersonalChatMessage) this.bHP;
                    LinkedList linkedList2 = new LinkedList();
                    linkedList2.add(new CommonMsgPojo(personalChatMessage));
                    m.b(new e(this, personalChatMessage, linkedList2), new f(this));
                    return;
                } else if (this.bHP instanceof OfficialChatMessage) {
                    OfficialChatMessage officialChatMessage = (OfficialChatMessage) this.bHP;
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
        XU();
        if (i == 1) {
            if (this.bJs != null) {
                this.bJs.setVisibility(0);
            }
            this.mProgress.setVisibility(4);
        } else if (i == 2) {
            if (this.bJs != null) {
                this.bJs.setVisibility(4);
            }
            this.mProgress.setVisibility(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        VoiceManager voiceManager;
        if (this.bJw == null || (voiceManager = getVoiceManager()) == null) {
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
            this.bJv.setVisibility(0);
        } else {
            this.bJv.setVisibility(8);
        }
    }

    public void setData(ChatMessage chatMessage) {
        if (chatMessage != null && chatMessage.getCacheData() != null) {
            this.bJw = chatMessage.getCacheData().getVoice_model();
            if (this.bJw == null) {
                this.bJw = new VoiceData.VoiceModel();
            }
            this.bHP = chatMessage;
            this.bJu.setText(VoiceManager.formatVoiceTime(this.bJw.duration));
            setBubbleLength(this.bJw.duration);
            setTag(this.bJw);
            z(chatMessage);
            hR(this.bJw.voice_status.intValue());
        }
    }

    public void reset() {
        this.bJw = null;
        hR(1);
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
            if (this.bJx.getParent() != null && (this.bJx.getParent() instanceof RelativeLayout)) {
                this.bJx.setLayoutParams(new RelativeLayout.LayoutParams(i2, -2));
                return;
            }
            this.bJx.setLayoutParams(new LinearLayout.LayoutParams(i2, -2));
        } catch (Exception e) {
        }
    }

    public boolean isPlaying() {
        return this.bJw != null && this.bJw.voice_status.intValue() == 3;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void oE() {
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void b(VoiceData.VoiceModel voiceModel) {
        if (voiceModel != null) {
            hR(voiceModel.voice_status.intValue());
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void aI(int i) {
        hQ(i);
        if (this.bJw != null) {
            this.bJw.elapse = i;
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void onShowErr(int i, String str) {
        k.u(getContext(), str);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceData.VoiceModel getVoiceModel() {
        return this.bJw;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceManager.b getRealView() {
        Context context = getContext();
        VoiceManager.b realView = context instanceof VoiceManager.c ? ((VoiceManager.c) context).getRealView(this.bJw) : this;
        return realView == null ? this : realView;
    }
}
