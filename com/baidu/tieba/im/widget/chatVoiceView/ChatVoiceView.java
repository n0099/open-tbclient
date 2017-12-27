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
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.util.h;
import com.baidu.tbadk.util.u;
import com.baidu.tbadk.util.v;
import com.baidu.tieba.d;
import com.baidu.tieba.im.data.VoiceMsgData;
import com.baidu.tieba.im.db.c;
import com.baidu.tieba.im.db.k;
import com.baidu.tieba.im.db.l;
import com.baidu.tieba.im.db.pojo.CommonMsgPojo;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.message.chat.CommonGroupChatMessage;
import com.baidu.tieba.im.message.chat.OfficialChatMessage;
import com.baidu.tieba.im.message.chat.PersonalChatMessage;
import com.baidu.tieba.im.sendmessage.a;
import com.baidu.tieba.im.util.e;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class ChatVoiceView extends LinearLayout implements View.OnClickListener, VoiceManager.b {
    private ChatMessage eGR;
    private ImageView eIt;
    private ImageView eIu;
    private TextView eIv;
    private ImageView eIw;
    private VoiceData.VoiceModel eIx;
    private RelativeLayout eIy;
    private ProgressBar mProgress;

    public ChatVoiceView(Context context) {
        super(context);
        this.eIt = null;
        this.eIv = null;
        this.eIw = null;
        this.mProgress = null;
        LayoutInflater.from(context).inflate(d.h.widget_left_voice_view, (ViewGroup) this, true);
        init();
    }

    public ChatVoiceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        boolean z;
        this.eIt = null;
        this.eIv = null;
        this.eIw = null;
        this.mProgress = null;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.l.ChatVoiceView, 0, 0);
        if (obtainStyledAttributes != null) {
            z = obtainStyledAttributes.getBoolean(d.l.ChatVoiceView_is_left, true);
            obtainStyledAttributes.recycle();
        } else {
            z = true;
        }
        if (z) {
            LayoutInflater.from(context).inflate(d.h.widget_left_voice_view, (ViewGroup) this, true);
        } else {
            LayoutInflater.from(context).inflate(d.h.widget_right_voice_view, (ViewGroup) this, true);
        }
        init();
    }

    private void init() {
        this.eIy = (RelativeLayout) findViewById(d.g.lay_bubble);
        this.eIt = (ImageView) findViewById(d.g.img_voice_status);
        this.eIu = (ImageView) findViewById(d.g.img_voice_status_anim);
        this.eIv = (TextView) findViewById(d.g.tex_voice_duration);
        this.eIw = (ImageView) findViewById(d.g.img_voice_readed);
        this.mProgress = (ProgressBar) findViewById(d.g.progress);
    }

    private void aKF() {
        this.eIt.setVisibility(8);
        this.eIu.setVisibility(0);
        ((AnimationDrawable) this.eIu.getBackground()).start();
    }

    private void aKG() {
        ((AnimationDrawable) this.eIu.getBackground()).stop();
        this.eIu.clearAnimation();
        this.eIt.setVisibility(0);
        this.eIu.setVisibility(8);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        try {
            aKG();
        } catch (Exception e) {
        }
    }

    public void qK(int i) {
    }

    public void qL(int i) {
        if (i == 3) {
            if (this.eIt != null) {
                this.eIt.setVisibility(0);
            }
            this.mProgress.setVisibility(4);
            aKF();
            VoiceMsgData z = e.z(this.eGR);
            if (z != null && z.getHas_read() != 1) {
                z.setHas_read(1);
                this.eGR.setContent("[" + OrmObject.jsonStrWithObject(z) + "]");
                if (this.eGR instanceof CommonGroupChatMessage) {
                    final CommonGroupChatMessage commonGroupChatMessage = (CommonGroupChatMessage) this.eGR;
                    final LinkedList linkedList = new LinkedList();
                    linkedList.add(new CommonMsgPojo(commonGroupChatMessage));
                    if (!commonGroupChatMessage.getGroupId().equals(String.valueOf(a.eGt))) {
                        v.b(new u<Boolean>() { // from class: com.baidu.tieba.im.widget.chatVoiceView.ChatVoiceView.1
                            /* JADX DEBUG: Method merged with bridge method */
                            /* JADX WARN: Can't rename method to resolve collision */
                            @Override // com.baidu.tbadk.util.u
                            public Boolean doInBackground() {
                                return Boolean.valueOf(c.aGs().b(commonGroupChatMessage.getGroupId(), linkedList, false));
                            }
                        }, new h<Boolean>() { // from class: com.baidu.tieba.im.widget.chatVoiceView.ChatVoiceView.2
                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // com.baidu.tbadk.util.h
                            public void onReturnDataInUI(Boolean bool) {
                                ChatVoiceView.this.eIw.setVisibility(8);
                            }
                        });
                        return;
                    } else {
                        v.b(new u<Boolean>() { // from class: com.baidu.tieba.im.widget.chatVoiceView.ChatVoiceView.3
                            /* JADX DEBUG: Method merged with bridge method */
                            /* JADX WARN: Can't rename method to resolve collision */
                            @Override // com.baidu.tbadk.util.u
                            public Boolean doInBackground() {
                                return Boolean.valueOf(l.aGH().a(e.s(commonGroupChatMessage), linkedList, false));
                            }
                        }, new h<Boolean>() { // from class: com.baidu.tieba.im.widget.chatVoiceView.ChatVoiceView.4
                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // com.baidu.tbadk.util.h
                            public void onReturnDataInUI(Boolean bool) {
                                ChatVoiceView.this.eIw.setVisibility(8);
                            }
                        });
                        return;
                    }
                } else if (this.eGR instanceof PersonalChatMessage) {
                    final PersonalChatMessage personalChatMessage = (PersonalChatMessage) this.eGR;
                    final LinkedList linkedList2 = new LinkedList();
                    linkedList2.add(new CommonMsgPojo(personalChatMessage));
                    v.b(new u<Boolean>() { // from class: com.baidu.tieba.im.widget.chatVoiceView.ChatVoiceView.5
                        /* JADX DEBUG: Method merged with bridge method */
                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // com.baidu.tbadk.util.u
                        public Boolean doInBackground() {
                            return Boolean.valueOf(l.aGH().a(e.s(personalChatMessage), linkedList2, false));
                        }
                    }, new h<Boolean>() { // from class: com.baidu.tieba.im.widget.chatVoiceView.ChatVoiceView.6
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.tbadk.util.h
                        public void onReturnDataInUI(Boolean bool) {
                            ChatVoiceView.this.eIw.setVisibility(8);
                        }
                    });
                    return;
                } else if (this.eGR instanceof OfficialChatMessage) {
                    final OfficialChatMessage officialChatMessage = (OfficialChatMessage) this.eGR;
                    final LinkedList linkedList3 = new LinkedList();
                    linkedList3.add(new CommonMsgPojo(officialChatMessage));
                    v.b(new u<Boolean>() { // from class: com.baidu.tieba.im.widget.chatVoiceView.ChatVoiceView.7
                        /* JADX DEBUG: Method merged with bridge method */
                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // com.baidu.tbadk.util.u
                        public Boolean doInBackground() {
                            return Boolean.valueOf(k.aGG().a(e.s(officialChatMessage), linkedList3, false));
                        }
                    }, new h<Boolean>() { // from class: com.baidu.tieba.im.widget.chatVoiceView.ChatVoiceView.8
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.tbadk.util.h
                        public void onReturnDataInUI(Boolean bool) {
                            ChatVoiceView.this.eIw.setVisibility(8);
                        }
                    });
                    return;
                } else {
                    return;
                }
            }
            return;
        }
        aKG();
        if (i == 1) {
            if (this.eIt != null) {
                this.eIt.setVisibility(0);
            }
            this.mProgress.setVisibility(4);
        } else if (i == 2) {
            if (this.eIt != null) {
                this.eIt.setVisibility(4);
            }
            this.mProgress.setVisibility(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        VoiceManager voiceManager;
        if (this.eIx == null || (voiceManager = getVoiceManager()) == null) {
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

    private void E(ChatMessage chatMessage) {
        boolean z = true;
        if (e.w(chatMessage)) {
            z = false;
        } else {
            VoiceMsgData z2 = e.z(chatMessage);
            if (z2 != null && z2.getHas_read() == 1) {
                z = false;
            }
        }
        if (z) {
            this.eIw.setVisibility(0);
        } else {
            this.eIw.setVisibility(8);
        }
    }

    public void setData(ChatMessage chatMessage) {
        VoiceManager voiceManager;
        if (chatMessage != null && chatMessage.getCacheData() != null) {
            this.eIx = chatMessage.getCacheData().getVoice_model();
            if (this.eIx == null) {
                this.eIx = new VoiceData.VoiceModel();
            }
            this.eGR = chatMessage;
            this.eIv.setText(VoiceManager.formatVoiceTime(this.eIx.duration));
            this.eIv.setContentDescription(String.format(getContext().getString(d.j.editor_record_format), VoiceManager.formatVoiceTime(this.eIx.duration)));
            setBubbleLength(this.eIx.duration);
            setTag(this.eIx);
            E(chatMessage);
            if (this.eIx.voice_status.intValue() != 1 && (voiceManager = getVoiceManager()) != null) {
                voiceManager.resetPlayView(this);
            }
            qL(this.eIx.voice_status.intValue());
        }
    }

    public void reset() {
        this.eIx = null;
        qL(1);
    }

    private void setBubbleLength(int i) {
        int i2;
        int ao = com.baidu.adp.lib.util.l.ao(getContext());
        if (i <= 10) {
            int i3 = (int) (ao * 0.1875d);
            i2 = (((((int) (ao * 0.4125d)) - i3) * (i - 1)) / 10) + i3;
        } else if (i <= 30) {
            int i4 = (int) (ao * 0.4125d);
            i2 = (((((int) (ao * 0.5375d)) - i4) * (i - 10)) / 20) + i4;
        } else {
            i2 = (int) (ao * 0.5375d);
        }
        try {
            if (this.eIy.getParent() != null && (this.eIy.getParent() instanceof RelativeLayout)) {
                this.eIy.setLayoutParams(new RelativeLayout.LayoutParams(i2, -2));
                return;
            }
            this.eIy.setLayoutParams(new LinearLayout.LayoutParams(i2, -2));
        } catch (Exception e) {
        }
    }

    public boolean isPlaying() {
        return this.eIx != null && this.eIx.voice_status.intValue() == 3;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void tt() {
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void b(VoiceData.VoiceModel voiceModel) {
        if (voiceModel != null) {
            qL(voiceModel.voice_status.intValue());
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void dT(int i) {
        qK(i);
        if (this.eIx != null) {
            this.eIx.elapse = i;
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void onShowErr(int i, String str) {
        com.baidu.adp.lib.util.l.J(getContext(), str);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceData.VoiceModel getVoiceModel() {
        return this.eIx;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceManager.b getRealView() {
        Context context = getContext();
        VoiceManager.b c = context instanceof VoiceManager.c ? ((VoiceManager.c) context).c(this.eIx) : this;
        return c == null ? this : c;
    }
}
