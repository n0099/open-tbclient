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
import com.baidu.tbadk.util.w;
import com.baidu.tbadk.util.x;
import com.baidu.tieba.e;
import com.baidu.tieba.im.data.VoiceMsgData;
import com.baidu.tieba.im.db.c;
import com.baidu.tieba.im.db.l;
import com.baidu.tieba.im.db.m;
import com.baidu.tieba.im.db.pojo.CommonMsgPojo;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.message.chat.CommonGroupChatMessage;
import com.baidu.tieba.im.message.chat.OfficialChatMessage;
import com.baidu.tieba.im.message.chat.PersonalChatMessage;
import com.baidu.tieba.im.sendmessage.a;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class ChatVoiceView extends LinearLayout implements View.OnClickListener, VoiceManager.b {
    private ChatMessage eJb;
    private ImageView eKC;
    private ImageView eKD;
    private TextView eKE;
    private ImageView eKF;
    private VoiceData.VoiceModel eKG;
    private RelativeLayout eKH;
    private ProgressBar mProgress;

    public ChatVoiceView(Context context) {
        super(context);
        this.eKC = null;
        this.eKE = null;
        this.eKF = null;
        this.mProgress = null;
        LayoutInflater.from(context).inflate(e.h.widget_left_voice_view, (ViewGroup) this, true);
        init();
    }

    public ChatVoiceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        boolean z;
        this.eKC = null;
        this.eKE = null;
        this.eKF = null;
        this.mProgress = null;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, e.l.ChatVoiceView, 0, 0);
        if (obtainStyledAttributes != null) {
            z = obtainStyledAttributes.getBoolean(e.l.ChatVoiceView_is_left, true);
            obtainStyledAttributes.recycle();
        } else {
            z = true;
        }
        if (z) {
            LayoutInflater.from(context).inflate(e.h.widget_left_voice_view, (ViewGroup) this, true);
        } else {
            LayoutInflater.from(context).inflate(e.h.widget_right_voice_view, (ViewGroup) this, true);
        }
        init();
    }

    private void init() {
        this.eKH = (RelativeLayout) findViewById(e.g.lay_bubble);
        this.eKC = (ImageView) findViewById(e.g.img_voice_status);
        this.eKD = (ImageView) findViewById(e.g.img_voice_status_anim);
        this.eKE = (TextView) findViewById(e.g.tex_voice_duration);
        this.eKF = (ImageView) findViewById(e.g.img_voice_readed);
        this.mProgress = (ProgressBar) findViewById(e.g.progress);
    }

    private void aQc() {
        this.eKC.setVisibility(8);
        this.eKD.setVisibility(0);
        ((AnimationDrawable) this.eKD.getBackground()).start();
    }

    private void aQd() {
        ((AnimationDrawable) this.eKD.getBackground()).stop();
        this.eKD.clearAnimation();
        this.eKC.setVisibility(0);
        this.eKD.setVisibility(8);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        try {
            aQd();
        } catch (Exception e) {
        }
    }

    public void pk(int i) {
    }

    public void pl(int i) {
        if (i == 3) {
            if (this.eKC != null) {
                this.eKC.setVisibility(0);
            }
            this.mProgress.setVisibility(4);
            aQc();
            VoiceMsgData z = com.baidu.tieba.im.util.e.z(this.eJb);
            if (z != null && z.getHas_read() != 1) {
                z.setHas_read(1);
                this.eJb.setContent("[" + OrmObject.jsonStrWithObject(z) + "]");
                if (this.eJb instanceof CommonGroupChatMessage) {
                    final CommonGroupChatMessage commonGroupChatMessage = (CommonGroupChatMessage) this.eJb;
                    final LinkedList linkedList = new LinkedList();
                    linkedList.add(new CommonMsgPojo(commonGroupChatMessage));
                    if (!commonGroupChatMessage.getGroupId().equals(String.valueOf(a.eID))) {
                        x.b(new w<Boolean>() { // from class: com.baidu.tieba.im.widget.chatVoiceView.ChatVoiceView.1
                            /* JADX DEBUG: Method merged with bridge method */
                            /* JADX WARN: Can't rename method to resolve collision */
                            @Override // com.baidu.tbadk.util.w
                            public Boolean doInBackground() {
                                return Boolean.valueOf(c.aLL().a(commonGroupChatMessage.getGroupId(), linkedList, false));
                            }
                        }, new h<Boolean>() { // from class: com.baidu.tieba.im.widget.chatVoiceView.ChatVoiceView.2
                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // com.baidu.tbadk.util.h
                            public void onReturnDataInUI(Boolean bool) {
                                ChatVoiceView.this.eKF.setVisibility(8);
                            }
                        });
                        return;
                    } else {
                        x.b(new w<Boolean>() { // from class: com.baidu.tieba.im.widget.chatVoiceView.ChatVoiceView.3
                            /* JADX DEBUG: Method merged with bridge method */
                            /* JADX WARN: Can't rename method to resolve collision */
                            @Override // com.baidu.tbadk.util.w
                            public Boolean doInBackground() {
                                return Boolean.valueOf(m.aMd().a(com.baidu.tieba.im.util.e.s(commonGroupChatMessage), linkedList, false));
                            }
                        }, new h<Boolean>() { // from class: com.baidu.tieba.im.widget.chatVoiceView.ChatVoiceView.4
                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // com.baidu.tbadk.util.h
                            public void onReturnDataInUI(Boolean bool) {
                                ChatVoiceView.this.eKF.setVisibility(8);
                            }
                        });
                        return;
                    }
                } else if (this.eJb instanceof PersonalChatMessage) {
                    final PersonalChatMessage personalChatMessage = (PersonalChatMessage) this.eJb;
                    final LinkedList linkedList2 = new LinkedList();
                    linkedList2.add(new CommonMsgPojo(personalChatMessage));
                    x.b(new w<Boolean>() { // from class: com.baidu.tieba.im.widget.chatVoiceView.ChatVoiceView.5
                        /* JADX DEBUG: Method merged with bridge method */
                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // com.baidu.tbadk.util.w
                        public Boolean doInBackground() {
                            return Boolean.valueOf(m.aMd().a(com.baidu.tieba.im.util.e.s(personalChatMessage), linkedList2, false));
                        }
                    }, new h<Boolean>() { // from class: com.baidu.tieba.im.widget.chatVoiceView.ChatVoiceView.6
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.tbadk.util.h
                        public void onReturnDataInUI(Boolean bool) {
                            ChatVoiceView.this.eKF.setVisibility(8);
                        }
                    });
                    return;
                } else if (this.eJb instanceof OfficialChatMessage) {
                    final OfficialChatMessage officialChatMessage = (OfficialChatMessage) this.eJb;
                    final LinkedList linkedList3 = new LinkedList();
                    linkedList3.add(new CommonMsgPojo(officialChatMessage));
                    x.b(new w<Boolean>() { // from class: com.baidu.tieba.im.widget.chatVoiceView.ChatVoiceView.7
                        /* JADX DEBUG: Method merged with bridge method */
                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // com.baidu.tbadk.util.w
                        public Boolean doInBackground() {
                            return Boolean.valueOf(l.aMb().a(com.baidu.tieba.im.util.e.s(officialChatMessage), linkedList3, false));
                        }
                    }, new h<Boolean>() { // from class: com.baidu.tieba.im.widget.chatVoiceView.ChatVoiceView.8
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.tbadk.util.h
                        public void onReturnDataInUI(Boolean bool) {
                            ChatVoiceView.this.eKF.setVisibility(8);
                        }
                    });
                    return;
                } else {
                    return;
                }
            }
            return;
        }
        aQd();
        if (i == 1) {
            if (this.eKC != null) {
                this.eKC.setVisibility(0);
            }
            this.mProgress.setVisibility(4);
        } else if (i == 2) {
            if (this.eKC != null) {
                this.eKC.setVisibility(4);
            }
            this.mProgress.setVisibility(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        VoiceManager voiceManager;
        if (this.eKG == null || (voiceManager = getVoiceManager()) == null) {
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
        if (com.baidu.tieba.im.util.e.w(chatMessage)) {
            z = false;
        } else {
            VoiceMsgData z2 = com.baidu.tieba.im.util.e.z(chatMessage);
            if (z2 != null && z2.getHas_read() == 1) {
                z = false;
            }
        }
        if (z) {
            this.eKF.setVisibility(0);
        } else {
            this.eKF.setVisibility(8);
        }
    }

    public void setData(ChatMessage chatMessage) {
        VoiceManager voiceManager;
        if (chatMessage != null && chatMessage.getCacheData() != null) {
            this.eKG = chatMessage.getCacheData().getVoice_model();
            if (this.eKG == null) {
                this.eKG = new VoiceData.VoiceModel();
            }
            this.eJb = chatMessage;
            this.eKE.setText(VoiceManager.formatVoiceTime(this.eKG.duration));
            this.eKE.setContentDescription(String.format(getContext().getString(e.j.editor_record_format), VoiceManager.formatVoiceTime(this.eKG.duration)));
            setBubbleLength(this.eKG.duration);
            setTag(this.eKG);
            E(chatMessage);
            if (this.eKG.voice_status.intValue() != 1 && (voiceManager = getVoiceManager()) != null) {
                voiceManager.resetPlayView(this);
            }
            pl(this.eKG.voice_status.intValue());
        }
    }

    public void reset() {
        this.eKG = null;
        pl(1);
    }

    private void setBubbleLength(int i) {
        int i2;
        int aO = com.baidu.adp.lib.util.l.aO(getContext());
        if (i <= 10) {
            int i3 = (int) (aO * 0.1875d);
            i2 = (((((int) (aO * 0.4125d)) - i3) * (i - 1)) / 10) + i3;
        } else if (i <= 30) {
            int i4 = (int) (aO * 0.4125d);
            i2 = (((((int) (aO * 0.5375d)) - i4) * (i - 10)) / 20) + i4;
        } else {
            i2 = (int) (aO * 0.5375d);
        }
        try {
            if (this.eKH.getParent() != null && (this.eKH.getParent() instanceof RelativeLayout)) {
                this.eKH.setLayoutParams(new RelativeLayout.LayoutParams(i2, -2));
                return;
            }
            this.eKH.setLayoutParams(new LinearLayout.LayoutParams(i2, -2));
        } catch (Exception e) {
        }
    }

    public boolean isPlaying() {
        return this.eKG != null && this.eKG.voice_status.intValue() == 3;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void pV() {
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void b(VoiceData.VoiceModel voiceModel) {
        if (voiceModel != null) {
            pl(voiceModel.voice_status.intValue());
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void bk(int i) {
        pk(i);
        if (this.eKG != null) {
            this.eKG.elapse = i;
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void onShowErr(int i, String str) {
        com.baidu.adp.lib.util.l.S(getContext(), str);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceData.VoiceModel getVoiceModel() {
        return this.eKG;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceManager.b getRealView() {
        Context context = getContext();
        VoiceManager.b c = context instanceof VoiceManager.c ? ((VoiceManager.c) context).c(this.eKG) : this;
        return c == null ? this : c;
    }
}
