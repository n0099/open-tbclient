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
    private ChatMessage dhj;
    private ImageView diP;
    private ImageView diQ;
    private TextView diR;
    private ImageView diS;
    private VoiceData.VoiceModel diT;
    private RelativeLayout diU;
    private ProgressBar mProgress;

    public ChatVoiceView(Context context) {
        super(context);
        this.diP = null;
        this.diR = null;
        this.diS = null;
        this.mProgress = null;
        LayoutInflater.from(context).inflate(w.j.widget_left_voice_view, (ViewGroup) this, true);
        init();
    }

    public ChatVoiceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        boolean z;
        this.diP = null;
        this.diR = null;
        this.diS = null;
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
        this.diU = (RelativeLayout) findViewById(w.h.lay_bubble);
        this.diP = (ImageView) findViewById(w.h.img_voice_status);
        this.diQ = (ImageView) findViewById(w.h.img_voice_status_anim);
        this.diR = (TextView) findViewById(w.h.tex_voice_duration);
        this.diS = (ImageView) findViewById(w.h.img_voice_readed);
        this.mProgress = (ProgressBar) findViewById(w.h.progress);
    }

    private void auW() {
        this.diP.setVisibility(8);
        this.diQ.setVisibility(0);
        ((AnimationDrawable) this.diQ.getBackground()).start();
    }

    private void auX() {
        ((AnimationDrawable) this.diQ.getBackground()).stop();
        this.diQ.clearAnimation();
        this.diP.setVisibility(0);
        this.diQ.setVisibility(8);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        try {
            auX();
        } catch (Exception e) {
        }
    }

    public void mf(int i) {
    }

    public void mg(int i) {
        if (i == 3) {
            if (this.diP != null) {
                this.diP.setVisibility(0);
            }
            this.mProgress.setVisibility(4);
            auW();
            VoiceMsgData w = com.baidu.tieba.im.util.h.w(this.dhj);
            if (w != null && w.getHas_read() != 1) {
                w.setHas_read(1);
                this.dhj.setContent("[" + OrmObject.jsonStrWithObject(w) + "]");
                if (this.dhj instanceof CommonGroupChatMessage) {
                    CommonGroupChatMessage commonGroupChatMessage = (CommonGroupChatMessage) this.dhj;
                    LinkedList linkedList = new LinkedList();
                    linkedList.add(new CommonMsgPojo(commonGroupChatMessage));
                    if (!commonGroupChatMessage.getGroupId().equals(String.valueOf(com.baidu.tieba.im.sendmessage.a.dgL))) {
                        t.b(new a(this, commonGroupChatMessage, linkedList), new b(this));
                        return;
                    } else {
                        t.b(new c(this, commonGroupChatMessage, linkedList), new d(this));
                        return;
                    }
                } else if (this.dhj instanceof PersonalChatMessage) {
                    PersonalChatMessage personalChatMessage = (PersonalChatMessage) this.dhj;
                    LinkedList linkedList2 = new LinkedList();
                    linkedList2.add(new CommonMsgPojo(personalChatMessage));
                    t.b(new e(this, personalChatMessage, linkedList2), new f(this));
                    return;
                } else if (this.dhj instanceof OfficialChatMessage) {
                    OfficialChatMessage officialChatMessage = (OfficialChatMessage) this.dhj;
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
        auX();
        if (i == 1) {
            if (this.diP != null) {
                this.diP.setVisibility(0);
            }
            this.mProgress.setVisibility(4);
        } else if (i == 2) {
            if (this.diP != null) {
                this.diP.setVisibility(4);
            }
            this.mProgress.setVisibility(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        VoiceManager voiceManager;
        if (this.diT == null || (voiceManager = getVoiceManager()) == null) {
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
            this.diS.setVisibility(0);
        } else {
            this.diS.setVisibility(8);
        }
    }

    public void setData(ChatMessage chatMessage) {
        VoiceManager voiceManager;
        if (chatMessage != null && chatMessage.getCacheData() != null) {
            this.diT = chatMessage.getCacheData().getVoice_model();
            if (this.diT == null) {
                this.diT = new VoiceData.VoiceModel();
            }
            this.dhj = chatMessage;
            this.diR.setText(VoiceManager.formatVoiceTime(this.diT.duration));
            this.diR.setContentDescription(String.format(getContext().getString(w.l.editor_record_format), VoiceManager.formatVoiceTime(this.diT.duration)));
            setBubbleLength(this.diT.duration);
            setTag(this.diT);
            B(chatMessage);
            if (this.diT.voice_status.intValue() != 1 && (voiceManager = getVoiceManager()) != null) {
                voiceManager.resetPlayView(this);
            }
            mg(this.diT.voice_status.intValue());
        }
    }

    public void reset() {
        this.diT = null;
        mg(1);
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
            if (this.diU.getParent() != null && (this.diU.getParent() instanceof RelativeLayout)) {
                this.diU.setLayoutParams(new RelativeLayout.LayoutParams(i2, -2));
                return;
            }
            this.diU.setLayoutParams(new LinearLayout.LayoutParams(i2, -2));
        } catch (Exception e) {
        }
    }

    public boolean isPlaying() {
        return this.diT != null && this.diT.voice_status.intValue() == 3;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void mw() {
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void b(VoiceData.VoiceModel voiceModel) {
        if (voiceModel != null) {
            mg(voiceModel.voice_status.intValue());
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void aR(int i) {
        mf(i);
        if (this.diT != null) {
            this.diT.elapse = i;
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void onShowErr(int i, String str) {
        k.E(getContext(), str);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceData.VoiceModel getVoiceModel() {
        return this.diT;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceManager.b getRealView() {
        Context context = getContext();
        VoiceManager.b c = context instanceof VoiceManager.c ? ((VoiceManager.c) context).c(this.diT) : this;
        return c == null ? this : c;
    }
}
