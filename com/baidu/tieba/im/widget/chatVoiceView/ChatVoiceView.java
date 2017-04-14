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
import com.baidu.tbadk.util.t;
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
    private ChatMessage deS;
    private TextView dgA;
    private ImageView dgB;
    private VoiceData.VoiceModel dgC;
    private RelativeLayout dgD;
    private ImageView dgy;
    private ImageView dgz;
    private ProgressBar mProgress;

    public ChatVoiceView(Context context) {
        super(context);
        this.dgy = null;
        this.dgA = null;
        this.dgB = null;
        this.mProgress = null;
        LayoutInflater.from(context).inflate(w.j.widget_left_voice_view, (ViewGroup) this, true);
        init();
    }

    public ChatVoiceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        boolean z;
        this.dgy = null;
        this.dgA = null;
        this.dgB = null;
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
        this.dgD = (RelativeLayout) findViewById(w.h.lay_bubble);
        this.dgy = (ImageView) findViewById(w.h.img_voice_status);
        this.dgz = (ImageView) findViewById(w.h.img_voice_status_anim);
        this.dgA = (TextView) findViewById(w.h.tex_voice_duration);
        this.dgB = (ImageView) findViewById(w.h.img_voice_readed);
        this.mProgress = (ProgressBar) findViewById(w.h.progress);
    }

    private void atV() {
        this.dgy.setVisibility(8);
        this.dgz.setVisibility(0);
        ((AnimationDrawable) this.dgz.getBackground()).start();
    }

    private void atW() {
        ((AnimationDrawable) this.dgz.getBackground()).stop();
        this.dgz.clearAnimation();
        this.dgy.setVisibility(0);
        this.dgz.setVisibility(8);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        try {
            atW();
        } catch (Exception e) {
        }
    }

    public void lZ(int i) {
    }

    public void ma(int i) {
        if (i == 3) {
            if (this.dgy != null) {
                this.dgy.setVisibility(0);
            }
            this.mProgress.setVisibility(4);
            atV();
            VoiceMsgData u = com.baidu.tieba.im.util.h.u(this.deS);
            if (u != null && u.getHas_read() != 1) {
                u.setHas_read(1);
                this.deS.setContent("[" + OrmObject.jsonStrWithObject(u) + "]");
                if (this.deS instanceof CommonGroupChatMessage) {
                    CommonGroupChatMessage commonGroupChatMessage = (CommonGroupChatMessage) this.deS;
                    LinkedList linkedList = new LinkedList();
                    linkedList.add(new CommonMsgPojo(commonGroupChatMessage));
                    if (!commonGroupChatMessage.getGroupId().equals(String.valueOf(com.baidu.tieba.im.sendmessage.a.deu))) {
                        t.b(new a(this, commonGroupChatMessage, linkedList), new b(this));
                        return;
                    } else {
                        t.b(new c(this, commonGroupChatMessage, linkedList), new d(this));
                        return;
                    }
                } else if (this.deS instanceof PersonalChatMessage) {
                    PersonalChatMessage personalChatMessage = (PersonalChatMessage) this.deS;
                    LinkedList linkedList2 = new LinkedList();
                    linkedList2.add(new CommonMsgPojo(personalChatMessage));
                    t.b(new e(this, personalChatMessage, linkedList2), new f(this));
                    return;
                } else if (this.deS instanceof OfficialChatMessage) {
                    OfficialChatMessage officialChatMessage = (OfficialChatMessage) this.deS;
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
        atW();
        if (i == 1) {
            if (this.dgy != null) {
                this.dgy.setVisibility(0);
            }
            this.mProgress.setVisibility(4);
        } else if (i == 2) {
            if (this.dgy != null) {
                this.dgy.setVisibility(4);
            }
            this.mProgress.setVisibility(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        VoiceManager voiceManager;
        if (this.dgC == null || (voiceManager = getVoiceManager()) == null) {
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
            this.dgB.setVisibility(0);
        } else {
            this.dgB.setVisibility(8);
        }
    }

    public void setData(ChatMessage chatMessage) {
        VoiceManager voiceManager;
        if (chatMessage != null && chatMessage.getCacheData() != null) {
            this.dgC = chatMessage.getCacheData().getVoice_model();
            if (this.dgC == null) {
                this.dgC = new VoiceData.VoiceModel();
            }
            this.deS = chatMessage;
            this.dgA.setText(VoiceManager.formatVoiceTime(this.dgC.duration));
            this.dgA.setContentDescription(String.format(getContext().getString(w.l.editor_record_format), VoiceManager.formatVoiceTime(this.dgC.duration)));
            setBubbleLength(this.dgC.duration);
            setTag(this.dgC);
            z(chatMessage);
            if (this.dgC.voice_status.intValue() != 1 && (voiceManager = getVoiceManager()) != null) {
                voiceManager.resetPlayView(this);
            }
            ma(this.dgC.voice_status.intValue());
        }
    }

    public void reset() {
        this.dgC = null;
        ma(1);
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
            if (this.dgD.getParent() != null && (this.dgD.getParent() instanceof RelativeLayout)) {
                this.dgD.setLayoutParams(new RelativeLayout.LayoutParams(i2, -2));
                return;
            }
            this.dgD.setLayoutParams(new LinearLayout.LayoutParams(i2, -2));
        } catch (Exception e) {
        }
    }

    public boolean isPlaying() {
        return this.dgC != null && this.dgC.voice_status.intValue() == 3;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void mw() {
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void b(VoiceData.VoiceModel voiceModel) {
        if (voiceModel != null) {
            ma(voiceModel.voice_status.intValue());
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void aR(int i) {
        lZ(i);
        if (this.dgC != null) {
            this.dgC.elapse = i;
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void onShowErr(int i, String str) {
        k.E(getContext(), str);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceData.VoiceModel getVoiceModel() {
        return this.dgC;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceManager.b getRealView() {
        Context context = getContext();
        VoiceManager.b c = context instanceof VoiceManager.c ? ((VoiceManager.c) context).c(this.dgC) : this;
        return c == null ? this : c;
    }
}
