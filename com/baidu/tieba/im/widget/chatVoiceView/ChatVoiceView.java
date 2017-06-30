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
import com.baidu.tbadk.util.x;
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
    private ChatMessage doD;
    private ImageView dqj;
    private ImageView dqk;
    private TextView dql;
    private ImageView dqm;
    private VoiceData.VoiceModel dqn;
    private RelativeLayout dqo;
    private ProgressBar mProgress;

    public ChatVoiceView(Context context) {
        super(context);
        this.dqj = null;
        this.dql = null;
        this.dqm = null;
        this.mProgress = null;
        LayoutInflater.from(context).inflate(w.j.widget_left_voice_view, (ViewGroup) this, true);
        init();
    }

    public ChatVoiceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        boolean z;
        this.dqj = null;
        this.dql = null;
        this.dqm = null;
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
        this.dqo = (RelativeLayout) findViewById(w.h.lay_bubble);
        this.dqj = (ImageView) findViewById(w.h.img_voice_status);
        this.dqk = (ImageView) findViewById(w.h.img_voice_status_anim);
        this.dql = (TextView) findViewById(w.h.tex_voice_duration);
        this.dqm = (ImageView) findViewById(w.h.img_voice_readed);
        this.mProgress = (ProgressBar) findViewById(w.h.progress);
    }

    private void awA() {
        this.dqj.setVisibility(8);
        this.dqk.setVisibility(0);
        ((AnimationDrawable) this.dqk.getBackground()).start();
    }

    private void awB() {
        ((AnimationDrawable) this.dqk.getBackground()).stop();
        this.dqk.clearAnimation();
        this.dqj.setVisibility(0);
        this.dqk.setVisibility(8);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        try {
            awB();
        } catch (Exception e) {
        }
    }

    public void mx(int i) {
    }

    public void my(int i) {
        if (i == 3) {
            if (this.dqj != null) {
                this.dqj.setVisibility(0);
            }
            this.mProgress.setVisibility(4);
            awA();
            VoiceMsgData w = com.baidu.tieba.im.util.h.w(this.doD);
            if (w != null && w.getHas_read() != 1) {
                w.setHas_read(1);
                this.doD.setContent("[" + OrmObject.jsonStrWithObject(w) + "]");
                if (this.doD instanceof CommonGroupChatMessage) {
                    CommonGroupChatMessage commonGroupChatMessage = (CommonGroupChatMessage) this.doD;
                    LinkedList linkedList = new LinkedList();
                    linkedList.add(new CommonMsgPojo(commonGroupChatMessage));
                    if (!commonGroupChatMessage.getGroupId().equals(String.valueOf(com.baidu.tieba.im.sendmessage.a.dof))) {
                        x.b(new a(this, commonGroupChatMessage, linkedList), new b(this));
                        return;
                    } else {
                        x.b(new c(this, commonGroupChatMessage, linkedList), new d(this));
                        return;
                    }
                } else if (this.doD instanceof PersonalChatMessage) {
                    PersonalChatMessage personalChatMessage = (PersonalChatMessage) this.doD;
                    LinkedList linkedList2 = new LinkedList();
                    linkedList2.add(new CommonMsgPojo(personalChatMessage));
                    x.b(new e(this, personalChatMessage, linkedList2), new f(this));
                    return;
                } else if (this.doD instanceof OfficialChatMessage) {
                    OfficialChatMessage officialChatMessage = (OfficialChatMessage) this.doD;
                    LinkedList linkedList3 = new LinkedList();
                    linkedList3.add(new CommonMsgPojo(officialChatMessage));
                    x.b(new g(this, officialChatMessage, linkedList3), new h(this));
                    return;
                } else {
                    return;
                }
            }
            return;
        }
        awB();
        if (i == 1) {
            if (this.dqj != null) {
                this.dqj.setVisibility(0);
            }
            this.mProgress.setVisibility(4);
        } else if (i == 2) {
            if (this.dqj != null) {
                this.dqj.setVisibility(4);
            }
            this.mProgress.setVisibility(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        VoiceManager voiceManager;
        if (this.dqn == null || (voiceManager = getVoiceManager()) == null) {
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
            this.dqm.setVisibility(0);
        } else {
            this.dqm.setVisibility(8);
        }
    }

    public void setData(ChatMessage chatMessage) {
        VoiceManager voiceManager;
        if (chatMessage != null && chatMessage.getCacheData() != null) {
            this.dqn = chatMessage.getCacheData().getVoice_model();
            if (this.dqn == null) {
                this.dqn = new VoiceData.VoiceModel();
            }
            this.doD = chatMessage;
            this.dql.setText(VoiceManager.formatVoiceTime(this.dqn.duration));
            this.dql.setContentDescription(String.format(getContext().getString(w.l.editor_record_format), VoiceManager.formatVoiceTime(this.dqn.duration)));
            setBubbleLength(this.dqn.duration);
            setTag(this.dqn);
            B(chatMessage);
            if (this.dqn.voice_status.intValue() != 1 && (voiceManager = getVoiceManager()) != null) {
                voiceManager.resetPlayView(this);
            }
            my(this.dqn.voice_status.intValue());
        }
    }

    public void reset() {
        this.dqn = null;
        my(1);
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
            if (this.dqo.getParent() != null && (this.dqo.getParent() instanceof RelativeLayout)) {
                this.dqo.setLayoutParams(new RelativeLayout.LayoutParams(i2, -2));
                return;
            }
            this.dqo.setLayoutParams(new LinearLayout.LayoutParams(i2, -2));
        } catch (Exception e) {
        }
    }

    public boolean isPlaying() {
        return this.dqn != null && this.dqn.voice_status.intValue() == 3;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void lT() {
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void b(VoiceData.VoiceModel voiceModel) {
        if (voiceModel != null) {
            my(voiceModel.voice_status.intValue());
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void aP(int i) {
        mx(i);
        if (this.dqn != null) {
            this.dqn.elapse = i;
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void onShowErr(int i, String str) {
        k.F(getContext(), str);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceData.VoiceModel getVoiceModel() {
        return this.dqn;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceManager.b getRealView() {
        Context context = getContext();
        VoiceManager.b c = context instanceof VoiceManager.c ? ((VoiceManager.c) context).c(this.dqn) : this;
        return c == null ? this : c;
    }
}
