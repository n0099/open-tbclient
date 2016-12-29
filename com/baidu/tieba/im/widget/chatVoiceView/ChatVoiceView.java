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
import com.baidu.tbadk.util.t;
import com.baidu.tieba.im.data.VoiceMsgData;
import com.baidu.tieba.im.db.pojo.CommonMsgPojo;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.message.chat.CommonGroupChatMessage;
import com.baidu.tieba.im.message.chat.OfficialChatMessage;
import com.baidu.tieba.im.message.chat.PersonalChatMessage;
import com.baidu.tieba.r;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class ChatVoiceView extends LinearLayout implements View.OnClickListener, VoiceManager.b {
    private ProgressBar ban;
    private ChatMessage cWR;
    private ImageView cYt;
    private ImageView cYu;
    private TextView cYv;
    private ImageView cYw;
    private VoiceData.VoiceModel cYx;
    private RelativeLayout cYy;

    public ChatVoiceView(Context context) {
        super(context);
        this.cYt = null;
        this.cYv = null;
        this.cYw = null;
        this.ban = null;
        LayoutInflater.from(context).inflate(r.h.widget_left_voice_view, (ViewGroup) this, true);
        init();
    }

    public ChatVoiceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        boolean z;
        this.cYt = null;
        this.cYv = null;
        this.cYw = null;
        this.ban = null;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, r.l.ChatVoiceView, 0, 0);
        if (obtainStyledAttributes != null) {
            z = obtainStyledAttributes.getBoolean(0, true);
            obtainStyledAttributes.recycle();
        } else {
            z = true;
        }
        if (z) {
            LayoutInflater.from(context).inflate(r.h.widget_left_voice_view, (ViewGroup) this, true);
        } else {
            LayoutInflater.from(context).inflate(r.h.widget_right_voice_view, (ViewGroup) this, true);
        }
        init();
    }

    private void init() {
        this.cYy = (RelativeLayout) findViewById(r.g.lay_bubble);
        this.cYt = (ImageView) findViewById(r.g.img_voice_status);
        this.cYu = (ImageView) findViewById(r.g.img_voice_status_anim);
        this.cYv = (TextView) findViewById(r.g.tex_voice_duration);
        this.cYw = (ImageView) findViewById(r.g.img_voice_readed);
        this.ban = (ProgressBar) findViewById(r.g.progress);
    }

    private void atB() {
        this.cYt.setVisibility(8);
        this.cYu.setVisibility(0);
        ((AnimationDrawable) this.cYu.getBackground()).start();
    }

    private void atC() {
        ((AnimationDrawable) this.cYu.getBackground()).stop();
        this.cYu.clearAnimation();
        this.cYt.setVisibility(0);
        this.cYu.setVisibility(8);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        try {
            atC();
        } catch (Exception e) {
        }
    }

    public void lv(int i) {
    }

    public void lw(int i) {
        if (i == 3) {
            if (this.cYt != null) {
                this.cYt.setVisibility(0);
            }
            this.ban.setVisibility(4);
            atB();
            VoiceMsgData u = com.baidu.tieba.im.util.h.u(this.cWR);
            if (u != null && u.getHas_read() != 1) {
                u.setHas_read(1);
                this.cWR.setContent("[" + i.jsonStrWithObject(u) + "]");
                if (this.cWR instanceof CommonGroupChatMessage) {
                    CommonGroupChatMessage commonGroupChatMessage = (CommonGroupChatMessage) this.cWR;
                    LinkedList linkedList = new LinkedList();
                    linkedList.add(new CommonMsgPojo(commonGroupChatMessage));
                    if (!commonGroupChatMessage.getGroupId().equals(String.valueOf(com.baidu.tieba.im.c.a.cWt))) {
                        t.b(new a(this, commonGroupChatMessage, linkedList), new b(this));
                        return;
                    } else {
                        t.b(new c(this, commonGroupChatMessage, linkedList), new d(this));
                        return;
                    }
                } else if (this.cWR instanceof PersonalChatMessage) {
                    PersonalChatMessage personalChatMessage = (PersonalChatMessage) this.cWR;
                    LinkedList linkedList2 = new LinkedList();
                    linkedList2.add(new CommonMsgPojo(personalChatMessage));
                    t.b(new e(this, personalChatMessage, linkedList2), new f(this));
                    return;
                } else if (this.cWR instanceof OfficialChatMessage) {
                    OfficialChatMessage officialChatMessage = (OfficialChatMessage) this.cWR;
                    LinkedList linkedList3 = new LinkedList();
                    linkedList3.add(new CommonMsgPojo(officialChatMessage));
                    t.b(new g(this, officialChatMessage, linkedList3), new h(this));
                    return;
                } else {
                    return;
                }
            }
            return;
        }
        atC();
        if (i == 1) {
            if (this.cYt != null) {
                this.cYt.setVisibility(0);
            }
            this.ban.setVisibility(4);
        } else if (i == 2) {
            if (this.cYt != null) {
                this.cYt.setVisibility(4);
            }
            this.ban.setVisibility(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        VoiceManager voiceManager;
        if (this.cYx == null || (voiceManager = getVoiceManager()) == null) {
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
        if (com.baidu.tieba.im.util.h.r(chatMessage)) {
            z = false;
        } else {
            VoiceMsgData u = com.baidu.tieba.im.util.h.u(chatMessage);
            if (u != null && u.getHas_read() == 1) {
                z = false;
            }
        }
        if (z) {
            this.cYw.setVisibility(0);
        } else {
            this.cYw.setVisibility(8);
        }
    }

    public void setData(ChatMessage chatMessage) {
        VoiceManager voiceManager;
        if (chatMessage != null && chatMessage.getCacheData() != null) {
            this.cYx = chatMessage.getCacheData().getVoice_model();
            if (this.cYx == null) {
                this.cYx = new VoiceData.VoiceModel();
            }
            this.cWR = chatMessage;
            this.cYv.setText(VoiceManager.formatVoiceTime(this.cYx.duration));
            this.cYv.setContentDescription(String.format(getContext().getString(r.j.editor_record_format), VoiceManager.formatVoiceTime(this.cYx.duration)));
            setBubbleLength(this.cYx.duration);
            setTag(this.cYx);
            z(chatMessage);
            if (this.cYx.voice_status.intValue() != 1 && (voiceManager = getVoiceManager()) != null) {
                voiceManager.resetPlayView(this);
            }
            lw(this.cYx.voice_status.intValue());
        }
    }

    public void reset() {
        this.cYx = null;
        lw(1);
    }

    private void setBubbleLength(int i) {
        int i2;
        int I = k.I(getContext());
        if (i <= 10) {
            int i3 = (int) (I * 0.1875d);
            i2 = (((((int) (I * 0.4125d)) - i3) * (i - 1)) / 10) + i3;
        } else if (i <= 30) {
            int i4 = (int) (I * 0.4125d);
            i2 = (((((int) (I * 0.5375d)) - i4) * (i - 10)) / 20) + i4;
        } else {
            i2 = (int) (I * 0.5375d);
        }
        try {
            if (this.cYy.getParent() != null && (this.cYy.getParent() instanceof RelativeLayout)) {
                this.cYy.setLayoutParams(new RelativeLayout.LayoutParams(i2, -2));
                return;
            }
            this.cYy.setLayoutParams(new LinearLayout.LayoutParams(i2, -2));
        } catch (Exception e) {
        }
    }

    public boolean isPlaying() {
        return this.cYx != null && this.cYx.voice_status.intValue() == 3;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void lG() {
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void b(VoiceData.VoiceModel voiceModel) {
        if (voiceModel != null) {
            lw(voiceModel.voice_status.intValue());
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void aT(int i) {
        lv(i);
        if (this.cYx != null) {
            this.cYx.elapse = i;
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void onShowErr(int i, String str) {
        k.m(getContext(), str);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceData.VoiceModel getVoiceModel() {
        return this.cYx;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceManager.b getRealView() {
        Context context = getContext();
        VoiceManager.b c = context instanceof VoiceManager.c ? ((VoiceManager.c) context).c(this.cYx) : this;
        return c == null ? this : c;
    }
}
