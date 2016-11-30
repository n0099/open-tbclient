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
    private ProgressBar cub;
    private ChatMessage drX;
    private ImageView dtA;
    private TextView dtB;
    private ImageView dtC;
    private VoiceData.VoiceModel dtD;
    private RelativeLayout dtE;
    private ImageView dtz;

    public ChatVoiceView(Context context) {
        super(context);
        this.dtz = null;
        this.dtB = null;
        this.dtC = null;
        this.cub = null;
        LayoutInflater.from(context).inflate(r.h.widget_left_voice_view, (ViewGroup) this, true);
        init();
    }

    public ChatVoiceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        boolean z;
        this.dtz = null;
        this.dtB = null;
        this.dtC = null;
        this.cub = null;
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
        this.dtE = (RelativeLayout) findViewById(r.g.lay_bubble);
        this.dtz = (ImageView) findViewById(r.g.img_voice_status);
        this.dtA = (ImageView) findViewById(r.g.img_voice_status_anim);
        this.dtB = (TextView) findViewById(r.g.tex_voice_duration);
        this.dtC = (ImageView) findViewById(r.g.img_voice_readed);
        this.cub = (ProgressBar) findViewById(r.g.progress);
    }

    private void azc() {
        this.dtz.setVisibility(8);
        this.dtA.setVisibility(0);
        ((AnimationDrawable) this.dtA.getBackground()).start();
    }

    private void azd() {
        ((AnimationDrawable) this.dtA.getBackground()).stop();
        this.dtA.clearAnimation();
        this.dtz.setVisibility(0);
        this.dtA.setVisibility(8);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        try {
            azd();
        } catch (Exception e) {
        }
    }

    public void ml(int i) {
    }

    public void mm(int i) {
        if (i == 3) {
            if (this.dtz != null) {
                this.dtz.setVisibility(0);
            }
            this.cub.setVisibility(4);
            azc();
            VoiceMsgData w = com.baidu.tieba.im.util.h.w(this.drX);
            if (w != null && w.getHas_read() != 1) {
                w.setHas_read(1);
                this.drX.setContent("[" + i.jsonStrWithObject(w) + "]");
                if (this.drX instanceof CommonGroupChatMessage) {
                    CommonGroupChatMessage commonGroupChatMessage = (CommonGroupChatMessage) this.drX;
                    LinkedList linkedList = new LinkedList();
                    linkedList.add(new CommonMsgPojo(commonGroupChatMessage));
                    if (!commonGroupChatMessage.getGroupId().equals(String.valueOf(com.baidu.tieba.im.c.a.drz))) {
                        t.b(new a(this, commonGroupChatMessage, linkedList), new b(this));
                        return;
                    } else {
                        t.b(new c(this, commonGroupChatMessage, linkedList), new d(this));
                        return;
                    }
                } else if (this.drX instanceof PersonalChatMessage) {
                    PersonalChatMessage personalChatMessage = (PersonalChatMessage) this.drX;
                    LinkedList linkedList2 = new LinkedList();
                    linkedList2.add(new CommonMsgPojo(personalChatMessage));
                    t.b(new e(this, personalChatMessage, linkedList2), new f(this));
                    return;
                } else if (this.drX instanceof OfficialChatMessage) {
                    OfficialChatMessage officialChatMessage = (OfficialChatMessage) this.drX;
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
        azd();
        if (i == 1) {
            if (this.dtz != null) {
                this.dtz.setVisibility(0);
            }
            this.cub.setVisibility(4);
        } else if (i == 2) {
            if (this.dtz != null) {
                this.dtz.setVisibility(4);
            }
            this.cub.setVisibility(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        VoiceManager voiceManager;
        if (this.dtD == null || (voiceManager = getVoiceManager()) == null) {
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
            this.dtC.setVisibility(0);
        } else {
            this.dtC.setVisibility(8);
        }
    }

    public void setData(ChatMessage chatMessage) {
        VoiceManager voiceManager;
        if (chatMessage != null && chatMessage.getCacheData() != null) {
            this.dtD = chatMessage.getCacheData().getVoice_model();
            if (this.dtD == null) {
                this.dtD = new VoiceData.VoiceModel();
            }
            this.drX = chatMessage;
            this.dtB.setText(VoiceManager.formatVoiceTime(this.dtD.duration));
            this.dtB.setContentDescription(String.format(getContext().getString(r.j.editor_record_format), VoiceManager.formatVoiceTime(this.dtD.duration)));
            setBubbleLength(this.dtD.duration);
            setTag(this.dtD);
            A(chatMessage);
            if (this.dtD.voice_status.intValue() != 1 && (voiceManager = getVoiceManager()) != null) {
                voiceManager.resetPlayView(this);
            }
            mm(this.dtD.voice_status.intValue());
        }
    }

    public void reset() {
        this.dtD = null;
        mm(1);
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
            if (this.dtE.getParent() != null && (this.dtE.getParent() instanceof RelativeLayout)) {
                this.dtE.setLayoutParams(new RelativeLayout.LayoutParams(i2, -2));
                return;
            }
            this.dtE.setLayoutParams(new LinearLayout.LayoutParams(i2, -2));
        } catch (Exception e) {
        }
    }

    public boolean isPlaying() {
        return this.dtD != null && this.dtD.voice_status.intValue() == 3;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void lG() {
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void b(VoiceData.VoiceModel voiceModel) {
        if (voiceModel != null) {
            mm(voiceModel.voice_status.intValue());
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void aS(int i) {
        ml(i);
        if (this.dtD != null) {
            this.dtD.elapse = i;
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void onShowErr(int i, String str) {
        k.m(getContext(), str);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceData.VoiceModel getVoiceModel() {
        return this.dtD;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceManager.b getRealView() {
        Context context = getContext();
        VoiceManager.b c = context instanceof VoiceManager.c ? ((VoiceManager.c) context).c(this.dtD) : this;
        return c == null ? this : c;
    }
}
