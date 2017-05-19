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
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tieba.im.data.VoiceMsgData;
import com.baidu.tieba.im.db.pojo.CommonMsgPojo;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.message.chat.CommonGroupChatMessage;
import com.baidu.tieba.im.message.chat.OfficialChatMessage;
import com.baidu.tieba.im.message.chat.PersonalChatMessage;
import com.baidu.tieba.w;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class ChatVoiceView extends LinearLayout implements View.OnClickListener, VoiceManager.b {
    private ChatMessage dbk;
    private ImageView dcR;
    private ImageView dcS;
    private TextView dcT;
    private ImageView dcU;
    private VoiceData.VoiceModel dcV;
    private RelativeLayout dcW;
    private ProgressBar mProgress;

    public ChatVoiceView(Context context) {
        super(context);
        this.dcR = null;
        this.dcT = null;
        this.dcU = null;
        this.mProgress = null;
        LayoutInflater.from(context).inflate(w.j.widget_left_voice_view, (ViewGroup) this, true);
        init();
    }

    public ChatVoiceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        boolean z;
        this.dcR = null;
        this.dcT = null;
        this.dcU = null;
        this.mProgress = null;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, w.n.ChatVoiceView, 0, 0);
        if (obtainStyledAttributes != null) {
            z = obtainStyledAttributes.getBoolean(0, true);
            obtainStyledAttributes.recycle();
        } else {
            z = true;
        }
        if (z) {
            LayoutInflater.from(context).inflate(w.j.widget_left_voice_view, (ViewGroup) this, true);
        } else {
            LayoutInflater.from(context).inflate(w.j.widget_right_voice_view, (ViewGroup) this, true);
        }
        init();
    }

    private void init() {
        this.dcW = (RelativeLayout) findViewById(w.h.lay_bubble);
        this.dcR = (ImageView) findViewById(w.h.img_voice_status);
        this.dcS = (ImageView) findViewById(w.h.img_voice_status_anim);
        this.dcT = (TextView) findViewById(w.h.tex_voice_duration);
        this.dcU = (ImageView) findViewById(w.h.img_voice_readed);
        this.mProgress = (ProgressBar) findViewById(w.h.progress);
    }

    private void arR() {
        this.dcR.setVisibility(8);
        this.dcS.setVisibility(0);
        ((AnimationDrawable) this.dcS.getBackground()).start();
    }

    private void arS() {
        ((AnimationDrawable) this.dcS.getBackground()).stop();
        this.dcS.clearAnimation();
        this.dcR.setVisibility(0);
        this.dcS.setVisibility(8);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        try {
            arS();
        } catch (Exception e) {
        }
    }

    public void lS(int i) {
    }

    public void lT(int i) {
        if (i == 3) {
            if (this.dcR != null) {
                this.dcR.setVisibility(0);
            }
            this.mProgress.setVisibility(4);
            arR();
            VoiceMsgData w = com.baidu.tieba.im.util.h.w(this.dbk);
            if (w != null && w.getHas_read() != 1) {
                w.setHas_read(1);
                this.dbk.setContent("[" + OrmObject.jsonStrWithObject(w) + "]");
                if (this.dbk instanceof CommonGroupChatMessage) {
                    CommonGroupChatMessage commonGroupChatMessage = (CommonGroupChatMessage) this.dbk;
                    LinkedList linkedList = new LinkedList();
                    linkedList.add(new CommonMsgPojo(commonGroupChatMessage));
                    if (!commonGroupChatMessage.getGroupId().equals(String.valueOf(com.baidu.tieba.im.sendmessage.a.daM))) {
                        com.baidu.tbadk.util.w.b(new a(this, commonGroupChatMessage, linkedList), new b(this));
                        return;
                    } else {
                        com.baidu.tbadk.util.w.b(new c(this, commonGroupChatMessage, linkedList), new d(this));
                        return;
                    }
                } else if (this.dbk instanceof PersonalChatMessage) {
                    PersonalChatMessage personalChatMessage = (PersonalChatMessage) this.dbk;
                    LinkedList linkedList2 = new LinkedList();
                    linkedList2.add(new CommonMsgPojo(personalChatMessage));
                    com.baidu.tbadk.util.w.b(new e(this, personalChatMessage, linkedList2), new f(this));
                    return;
                } else if (this.dbk instanceof OfficialChatMessage) {
                    OfficialChatMessage officialChatMessage = (OfficialChatMessage) this.dbk;
                    LinkedList linkedList3 = new LinkedList();
                    linkedList3.add(new CommonMsgPojo(officialChatMessage));
                    com.baidu.tbadk.util.w.b(new g(this, officialChatMessage, linkedList3), new h(this));
                    return;
                } else {
                    return;
                }
            }
            return;
        }
        arS();
        if (i == 1) {
            if (this.dcR != null) {
                this.dcR.setVisibility(0);
            }
            this.mProgress.setVisibility(4);
        } else if (i == 2) {
            if (this.dcR != null) {
                this.dcR.setVisibility(4);
            }
            this.mProgress.setVisibility(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        VoiceManager voiceManager;
        if (this.dcV == null || (voiceManager = getVoiceManager()) == null) {
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

    private void B(ChatMessage chatMessage) {
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
            this.dcU.setVisibility(0);
        } else {
            this.dcU.setVisibility(8);
        }
    }

    public void setData(ChatMessage chatMessage) {
        VoiceManager voiceManager;
        if (chatMessage != null && chatMessage.getCacheData() != null) {
            this.dcV = chatMessage.getCacheData().getVoice_model();
            if (this.dcV == null) {
                this.dcV = new VoiceData.VoiceModel();
            }
            this.dbk = chatMessage;
            this.dcT.setText(VoiceManager.formatVoiceTime(this.dcV.duration));
            this.dcT.setContentDescription(String.format(getContext().getString(w.l.editor_record_format), VoiceManager.formatVoiceTime(this.dcV.duration)));
            setBubbleLength(this.dcV.duration);
            setTag(this.dcV);
            B(chatMessage);
            if (this.dcV.voice_status.intValue() != 1 && (voiceManager = getVoiceManager()) != null) {
                voiceManager.resetPlayView(this);
            }
            lT(this.dcV.voice_status.intValue());
        }
    }

    public void reset() {
        this.dcV = null;
        lT(1);
    }

    private void setBubbleLength(int i) {
        int i2;
        int af = k.af(getContext());
        if (i <= 10) {
            int i3 = (int) (af * 0.1875d);
            i2 = (((((int) (af * 0.4125d)) - i3) * (i - 1)) / 10) + i3;
        } else if (i <= 30) {
            int i4 = (int) (af * 0.4125d);
            i2 = (((((int) (af * 0.5375d)) - i4) * (i - 10)) / 20) + i4;
        } else {
            i2 = (int) (af * 0.5375d);
        }
        try {
            if (this.dcW.getParent() != null && (this.dcW.getParent() instanceof RelativeLayout)) {
                this.dcW.setLayoutParams(new RelativeLayout.LayoutParams(i2, -2));
                return;
            }
            this.dcW.setLayoutParams(new LinearLayout.LayoutParams(i2, -2));
        } catch (Exception e) {
        }
    }

    public boolean isPlaying() {
        return this.dcV != null && this.dcV.voice_status.intValue() == 3;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void md() {
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void b(VoiceData.VoiceModel voiceModel) {
        if (voiceModel != null) {
            lT(voiceModel.voice_status.intValue());
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void aO(int i) {
        lS(i);
        if (this.dcV != null) {
            this.dcV.elapse = i;
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void onShowErr(int i, String str) {
        k.E(getContext(), str);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceData.VoiceModel getVoiceModel() {
        return this.dcV;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceManager.b getRealView() {
        Context context = getContext();
        VoiceManager.b c = context instanceof VoiceManager.c ? ((VoiceManager.c) context).c(this.dcV) : this;
        return c == null ? this : c;
    }
}
