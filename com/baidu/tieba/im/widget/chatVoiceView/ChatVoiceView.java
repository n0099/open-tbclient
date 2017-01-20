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
import com.baidu.tieba.r;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class ChatVoiceView extends LinearLayout implements View.OnClickListener, VoiceManager.b {
    private ProgressBar bkd;
    private ChatMessage ded;
    private ImageView dfI;
    private ImageView dfJ;
    private TextView dfK;
    private ImageView dfL;
    private VoiceData.VoiceModel dfM;
    private RelativeLayout dfN;

    public ChatVoiceView(Context context) {
        super(context);
        this.dfI = null;
        this.dfK = null;
        this.dfL = null;
        this.bkd = null;
        LayoutInflater.from(context).inflate(r.j.widget_left_voice_view, (ViewGroup) this, true);
        init();
    }

    public ChatVoiceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        boolean z;
        this.dfI = null;
        this.dfK = null;
        this.dfL = null;
        this.bkd = null;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, r.n.ChatVoiceView, 0, 0);
        if (obtainStyledAttributes != null) {
            z = obtainStyledAttributes.getBoolean(0, true);
            obtainStyledAttributes.recycle();
        } else {
            z = true;
        }
        if (z) {
            LayoutInflater.from(context).inflate(r.j.widget_left_voice_view, (ViewGroup) this, true);
        } else {
            LayoutInflater.from(context).inflate(r.j.widget_right_voice_view, (ViewGroup) this, true);
        }
        init();
    }

    private void init() {
        this.dfN = (RelativeLayout) findViewById(r.h.lay_bubble);
        this.dfI = (ImageView) findViewById(r.h.img_voice_status);
        this.dfJ = (ImageView) findViewById(r.h.img_voice_status_anim);
        this.dfK = (TextView) findViewById(r.h.tex_voice_duration);
        this.dfL = (ImageView) findViewById(r.h.img_voice_readed);
        this.bkd = (ProgressBar) findViewById(r.h.progress);
    }

    private void auH() {
        this.dfI.setVisibility(8);
        this.dfJ.setVisibility(0);
        ((AnimationDrawable) this.dfJ.getBackground()).start();
    }

    private void auI() {
        ((AnimationDrawable) this.dfJ.getBackground()).stop();
        this.dfJ.clearAnimation();
        this.dfI.setVisibility(0);
        this.dfJ.setVisibility(8);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        try {
            auI();
        } catch (Exception e) {
        }
    }

    public void mi(int i) {
    }

    public void mj(int i) {
        if (i == 3) {
            if (this.dfI != null) {
                this.dfI.setVisibility(0);
            }
            this.bkd.setVisibility(4);
            auH();
            VoiceMsgData u = com.baidu.tieba.im.util.h.u(this.ded);
            if (u != null && u.getHas_read() != 1) {
                u.setHas_read(1);
                this.ded.setContent("[" + OrmObject.jsonStrWithObject(u) + "]");
                if (this.ded instanceof CommonGroupChatMessage) {
                    CommonGroupChatMessage commonGroupChatMessage = (CommonGroupChatMessage) this.ded;
                    LinkedList linkedList = new LinkedList();
                    linkedList.add(new CommonMsgPojo(commonGroupChatMessage));
                    if (!commonGroupChatMessage.getGroupId().equals(String.valueOf(com.baidu.tieba.im.sendmessage.a.ddF))) {
                        t.b(new a(this, commonGroupChatMessage, linkedList), new b(this));
                        return;
                    } else {
                        t.b(new c(this, commonGroupChatMessage, linkedList), new d(this));
                        return;
                    }
                } else if (this.ded instanceof PersonalChatMessage) {
                    PersonalChatMessage personalChatMessage = (PersonalChatMessage) this.ded;
                    LinkedList linkedList2 = new LinkedList();
                    linkedList2.add(new CommonMsgPojo(personalChatMessage));
                    t.b(new e(this, personalChatMessage, linkedList2), new f(this));
                    return;
                } else if (this.ded instanceof OfficialChatMessage) {
                    OfficialChatMessage officialChatMessage = (OfficialChatMessage) this.ded;
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
        auI();
        if (i == 1) {
            if (this.dfI != null) {
                this.dfI.setVisibility(0);
            }
            this.bkd.setVisibility(4);
        } else if (i == 2) {
            if (this.dfI != null) {
                this.dfI.setVisibility(4);
            }
            this.bkd.setVisibility(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        VoiceManager voiceManager;
        if (this.dfM == null || (voiceManager = getVoiceManager()) == null) {
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
            this.dfL.setVisibility(0);
        } else {
            this.dfL.setVisibility(8);
        }
    }

    public void setData(ChatMessage chatMessage) {
        VoiceManager voiceManager;
        if (chatMessage != null && chatMessage.getCacheData() != null) {
            this.dfM = chatMessage.getCacheData().getVoice_model();
            if (this.dfM == null) {
                this.dfM = new VoiceData.VoiceModel();
            }
            this.ded = chatMessage;
            this.dfK.setText(VoiceManager.formatVoiceTime(this.dfM.duration));
            this.dfK.setContentDescription(String.format(getContext().getString(r.l.editor_record_format), VoiceManager.formatVoiceTime(this.dfM.duration)));
            setBubbleLength(this.dfM.duration);
            setTag(this.dfM);
            z(chatMessage);
            if (this.dfM.voice_status.intValue() != 1 && (voiceManager = getVoiceManager()) != null) {
                voiceManager.resetPlayView(this);
            }
            mj(this.dfM.voice_status.intValue());
        }
    }

    public void reset() {
        this.dfM = null;
        mj(1);
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
            if (this.dfN.getParent() != null && (this.dfN.getParent() instanceof RelativeLayout)) {
                this.dfN.setLayoutParams(new RelativeLayout.LayoutParams(i2, -2));
                return;
            }
            this.dfN.setLayoutParams(new LinearLayout.LayoutParams(i2, -2));
        } catch (Exception e) {
        }
    }

    public boolean isPlaying() {
        return this.dfM != null && this.dfM.voice_status.intValue() == 3;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void ly() {
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void b(VoiceData.VoiceModel voiceModel) {
        if (voiceModel != null) {
            mj(voiceModel.voice_status.intValue());
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void aS(int i) {
        mi(i);
        if (this.dfM != null) {
            this.dfM.elapse = i;
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void onShowErr(int i, String str) {
        k.m(getContext(), str);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceData.VoiceModel getVoiceModel() {
        return this.dfM;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceManager.b getRealView() {
        Context context = getContext();
        VoiceManager.b c = context instanceof VoiceManager.c ? ((VoiceManager.c) context).c(this.dfM) : this;
        return c == null ? this : c;
    }
}
