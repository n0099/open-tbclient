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
import com.baidu.tieba.r;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class ChatVoiceView extends LinearLayout implements View.OnClickListener, VoiceManager.b {
    private ProgressBar coW;
    private ChatMessage dmn;
    private ImageView dnQ;
    private ImageView dnR;
    private TextView dnS;
    private ImageView dnT;
    private VoiceData.VoiceModel dnU;
    private RelativeLayout dnV;

    public ChatVoiceView(Context context) {
        super(context);
        this.dnQ = null;
        this.dnS = null;
        this.dnT = null;
        this.coW = null;
        LayoutInflater.from(context).inflate(r.h.widget_left_voice_view, (ViewGroup) this, true);
        init();
    }

    public ChatVoiceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        boolean z;
        this.dnQ = null;
        this.dnS = null;
        this.dnT = null;
        this.coW = null;
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
        this.dnV = (RelativeLayout) findViewById(r.g.lay_bubble);
        this.dnQ = (ImageView) findViewById(r.g.img_voice_status);
        this.dnR = (ImageView) findViewById(r.g.img_voice_status_anim);
        this.dnS = (TextView) findViewById(r.g.tex_voice_duration);
        this.dnT = (ImageView) findViewById(r.g.img_voice_readed);
        this.coW = (ProgressBar) findViewById(r.g.progress);
    }

    private void axf() {
        this.dnQ.setVisibility(8);
        this.dnR.setVisibility(0);
        ((AnimationDrawable) this.dnR.getBackground()).start();
    }

    private void axg() {
        ((AnimationDrawable) this.dnR.getBackground()).stop();
        this.dnR.clearAnimation();
        this.dnQ.setVisibility(0);
        this.dnR.setVisibility(8);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        try {
            axg();
        } catch (Exception e) {
        }
    }

    public void md(int i) {
    }

    public void me(int i) {
        if (i == 3) {
            if (this.dnQ != null) {
                this.dnQ.setVisibility(0);
            }
            this.coW.setVisibility(4);
            axf();
            VoiceMsgData w = com.baidu.tieba.im.util.h.w(this.dmn);
            if (w != null && w.getHas_read() != 1) {
                w.setHas_read(1);
                this.dmn.setContent("[" + i.jsonStrWithObject(w) + "]");
                if (this.dmn instanceof CommonGroupChatMessage) {
                    CommonGroupChatMessage commonGroupChatMessage = (CommonGroupChatMessage) this.dmn;
                    LinkedList linkedList = new LinkedList();
                    linkedList.add(new CommonMsgPojo(commonGroupChatMessage));
                    if (!commonGroupChatMessage.getGroupId().equals(String.valueOf(com.baidu.tieba.im.c.a.dlP))) {
                        u.b(new a(this, commonGroupChatMessage, linkedList), new b(this));
                        return;
                    } else {
                        u.b(new c(this, commonGroupChatMessage, linkedList), new d(this));
                        return;
                    }
                } else if (this.dmn instanceof PersonalChatMessage) {
                    PersonalChatMessage personalChatMessage = (PersonalChatMessage) this.dmn;
                    LinkedList linkedList2 = new LinkedList();
                    linkedList2.add(new CommonMsgPojo(personalChatMessage));
                    u.b(new e(this, personalChatMessage, linkedList2), new f(this));
                    return;
                } else if (this.dmn instanceof OfficialChatMessage) {
                    OfficialChatMessage officialChatMessage = (OfficialChatMessage) this.dmn;
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
        axg();
        if (i == 1) {
            if (this.dnQ != null) {
                this.dnQ.setVisibility(0);
            }
            this.coW.setVisibility(4);
        } else if (i == 2) {
            if (this.dnQ != null) {
                this.dnQ.setVisibility(4);
            }
            this.coW.setVisibility(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        VoiceManager voiceManager;
        if (this.dnU == null || (voiceManager = getVoiceManager()) == null) {
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
            this.dnT.setVisibility(0);
        } else {
            this.dnT.setVisibility(8);
        }
    }

    public void setData(ChatMessage chatMessage) {
        VoiceManager voiceManager;
        if (chatMessage != null && chatMessage.getCacheData() != null) {
            this.dnU = chatMessage.getCacheData().getVoice_model();
            if (this.dnU == null) {
                this.dnU = new VoiceData.VoiceModel();
            }
            this.dmn = chatMessage;
            this.dnS.setText(VoiceManager.formatVoiceTime(this.dnU.duration));
            this.dnS.setContentDescription(String.format(getContext().getString(r.j.editor_record_format), VoiceManager.formatVoiceTime(this.dnU.duration)));
            setBubbleLength(this.dnU.duration);
            setTag(this.dnU);
            A(chatMessage);
            if (this.dnU.voice_status.intValue() != 1 && (voiceManager = getVoiceManager()) != null) {
                voiceManager.resetPlayView(this);
            }
            me(this.dnU.voice_status.intValue());
        }
    }

    public void reset() {
        this.dnU = null;
        me(1);
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
            if (this.dnV.getParent() != null && (this.dnV.getParent() instanceof RelativeLayout)) {
                this.dnV.setLayoutParams(new RelativeLayout.LayoutParams(i2, -2));
                return;
            }
            this.dnV.setLayoutParams(new LinearLayout.LayoutParams(i2, -2));
        } catch (Exception e) {
        }
    }

    public boolean isPlaying() {
        return this.dnU != null && this.dnU.voice_status.intValue() == 3;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void lD() {
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void b(VoiceData.VoiceModel voiceModel) {
        if (voiceModel != null) {
            me(voiceModel.voice_status.intValue());
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void aS(int i) {
        md(i);
        if (this.dnU != null) {
            this.dnU.elapse = i;
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void onShowErr(int i, String str) {
        k.m(getContext(), str);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceData.VoiceModel getVoiceModel() {
        return this.dnU;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceManager.b getRealView() {
        Context context = getContext();
        VoiceManager.b c = context instanceof VoiceManager.c ? ((VoiceManager.c) context).c(this.dnU) : this;
        return c == null ? this : c;
    }
}
