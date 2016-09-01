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
import com.baidu.tbadk.util.u;
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
    private ProgressBar coz;
    private ChatMessage dkQ;
    private ImageView dmt;
    private ImageView dmu;
    private TextView dmv;
    private ImageView dmw;
    private VoiceData.VoiceModel dmx;
    private RelativeLayout dmy;

    public ChatVoiceView(Context context) {
        super(context);
        this.dmt = null;
        this.dmv = null;
        this.dmw = null;
        this.coz = null;
        LayoutInflater.from(context).inflate(t.h.widget_left_voice_view, (ViewGroup) this, true);
        init();
    }

    public ChatVoiceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        boolean z;
        this.dmt = null;
        this.dmv = null;
        this.dmw = null;
        this.coz = null;
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
        this.dmy = (RelativeLayout) findViewById(t.g.lay_bubble);
        this.dmt = (ImageView) findViewById(t.g.img_voice_status);
        this.dmu = (ImageView) findViewById(t.g.img_voice_status_anim);
        this.dmv = (TextView) findViewById(t.g.tex_voice_duration);
        this.dmw = (ImageView) findViewById(t.g.img_voice_readed);
        this.coz = (ProgressBar) findViewById(t.g.progress);
    }

    private void awG() {
        this.dmt.setVisibility(8);
        this.dmu.setVisibility(0);
        ((AnimationDrawable) this.dmu.getBackground()).start();
    }

    private void awH() {
        ((AnimationDrawable) this.dmu.getBackground()).stop();
        this.dmu.clearAnimation();
        this.dmt.setVisibility(0);
        this.dmu.setVisibility(8);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        try {
            awH();
        } catch (Exception e) {
        }
    }

    public void lV(int i) {
    }

    public void lW(int i) {
        if (i == 3) {
            if (this.dmt != null) {
                this.dmt.setVisibility(0);
            }
            this.coz.setVisibility(4);
            awG();
            VoiceMsgData w = com.baidu.tieba.im.util.h.w(this.dkQ);
            if (w != null && w.getHas_read() != 1) {
                w.setHas_read(1);
                this.dkQ.setContent("[" + i.jsonStrWithObject(w) + "]");
                if (this.dkQ instanceof CommonGroupChatMessage) {
                    CommonGroupChatMessage commonGroupChatMessage = (CommonGroupChatMessage) this.dkQ;
                    LinkedList linkedList = new LinkedList();
                    linkedList.add(new CommonMsgPojo(commonGroupChatMessage));
                    if (!commonGroupChatMessage.getGroupId().equals(String.valueOf(com.baidu.tieba.im.c.a.dks))) {
                        u.b(new a(this, commonGroupChatMessage, linkedList), new b(this));
                        return;
                    } else {
                        u.b(new c(this, commonGroupChatMessage, linkedList), new d(this));
                        return;
                    }
                } else if (this.dkQ instanceof PersonalChatMessage) {
                    PersonalChatMessage personalChatMessage = (PersonalChatMessage) this.dkQ;
                    LinkedList linkedList2 = new LinkedList();
                    linkedList2.add(new CommonMsgPojo(personalChatMessage));
                    u.b(new e(this, personalChatMessage, linkedList2), new f(this));
                    return;
                } else if (this.dkQ instanceof OfficialChatMessage) {
                    OfficialChatMessage officialChatMessage = (OfficialChatMessage) this.dkQ;
                    LinkedList linkedList3 = new LinkedList();
                    linkedList3.add(new CommonMsgPojo(officialChatMessage));
                    u.b(new g(this, officialChatMessage, linkedList3), new h(this));
                    return;
                } else {
                    return;
                }
            }
            return;
        }
        awH();
        if (i == 1) {
            if (this.dmt != null) {
                this.dmt.setVisibility(0);
            }
            this.coz.setVisibility(4);
        } else if (i == 2) {
            if (this.dmt != null) {
                this.dmt.setVisibility(4);
            }
            this.coz.setVisibility(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        VoiceManager voiceManager;
        if (this.dmx == null || (voiceManager = getVoiceManager()) == null) {
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
            this.dmw.setVisibility(0);
        } else {
            this.dmw.setVisibility(8);
        }
    }

    public void setData(ChatMessage chatMessage) {
        VoiceManager voiceManager;
        if (chatMessage != null && chatMessage.getCacheData() != null) {
            this.dmx = chatMessage.getCacheData().getVoice_model();
            if (this.dmx == null) {
                this.dmx = new VoiceData.VoiceModel();
            }
            this.dkQ = chatMessage;
            this.dmv.setText(VoiceManager.formatVoiceTime(this.dmx.duration));
            this.dmv.setContentDescription(String.format(getContext().getString(t.j.editor_record_format), VoiceManager.formatVoiceTime(this.dmx.duration)));
            setBubbleLength(this.dmx.duration);
            setTag(this.dmx);
            A(chatMessage);
            if (this.dmx.voice_status.intValue() != 1 && (voiceManager = getVoiceManager()) != null) {
                voiceManager.resetPlayView(this);
            }
            lW(this.dmx.voice_status.intValue());
        }
    }

    public void reset() {
        this.dmx = null;
        lW(1);
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
            if (this.dmy.getParent() != null && (this.dmy.getParent() instanceof RelativeLayout)) {
                this.dmy.setLayoutParams(new RelativeLayout.LayoutParams(i2, -2));
                return;
            }
            this.dmy.setLayoutParams(new LinearLayout.LayoutParams(i2, -2));
        } catch (Exception e) {
        }
    }

    public boolean isPlaying() {
        return this.dmx != null && this.dmx.voice_status.intValue() == 3;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void lD() {
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void b(VoiceData.VoiceModel voiceModel) {
        if (voiceModel != null) {
            lW(voiceModel.voice_status.intValue());
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void aS(int i) {
        lV(i);
        if (this.dmx != null) {
            this.dmx.elapse = i;
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void onShowErr(int i, String str) {
        k.m(getContext(), str);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceData.VoiceModel getVoiceModel() {
        return this.dmx;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceManager.b getRealView() {
        Context context = getContext();
        VoiceManager.b c = context instanceof VoiceManager.c ? ((VoiceManager.c) context).c(this.dmx) : this;
        return c == null ? this : c;
    }
}
