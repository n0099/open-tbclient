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
import com.baidu.tbadk.util.g;
import com.baidu.tbadk.util.s;
import com.baidu.tbadk.util.t;
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
    private ChatMessage dDT;
    private ImageView dFA;
    private TextView dFB;
    private ImageView dFC;
    private VoiceData.VoiceModel dFD;
    private RelativeLayout dFE;
    private ImageView dFz;
    private ProgressBar mProgress;

    public ChatVoiceView(Context context) {
        super(context);
        this.dFz = null;
        this.dFB = null;
        this.dFC = null;
        this.mProgress = null;
        LayoutInflater.from(context).inflate(d.j.widget_left_voice_view, (ViewGroup) this, true);
        init();
    }

    public ChatVoiceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        boolean z;
        this.dFz = null;
        this.dFB = null;
        this.dFC = null;
        this.mProgress = null;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.n.ChatVoiceView, 0, 0);
        if (obtainStyledAttributes != null) {
            z = obtainStyledAttributes.getBoolean(d.n.ChatVoiceView_is_left, true);
            obtainStyledAttributes.recycle();
        } else {
            z = true;
        }
        if (z) {
            LayoutInflater.from(context).inflate(d.j.widget_left_voice_view, (ViewGroup) this, true);
        } else {
            LayoutInflater.from(context).inflate(d.j.widget_right_voice_view, (ViewGroup) this, true);
        }
        init();
    }

    private void init() {
        this.dFE = (RelativeLayout) findViewById(d.h.lay_bubble);
        this.dFz = (ImageView) findViewById(d.h.img_voice_status);
        this.dFA = (ImageView) findViewById(d.h.img_voice_status_anim);
        this.dFB = (TextView) findViewById(d.h.tex_voice_duration);
        this.dFC = (ImageView) findViewById(d.h.img_voice_readed);
        this.mProgress = (ProgressBar) findViewById(d.h.progress);
    }

    private void azw() {
        this.dFz.setVisibility(8);
        this.dFA.setVisibility(0);
        ((AnimationDrawable) this.dFA.getBackground()).start();
    }

    private void azx() {
        ((AnimationDrawable) this.dFA.getBackground()).stop();
        this.dFA.clearAnimation();
        this.dFz.setVisibility(0);
        this.dFA.setVisibility(8);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        try {
            azx();
        } catch (Exception e) {
        }
    }

    public void nf(int i) {
    }

    public void ng(int i) {
        if (i == 3) {
            if (this.dFz != null) {
                this.dFz.setVisibility(0);
            }
            this.mProgress.setVisibility(4);
            azw();
            VoiceMsgData x = e.x(this.dDT);
            if (x != null && x.getHas_read() != 1) {
                x.setHas_read(1);
                this.dDT.setContent("[" + OrmObject.jsonStrWithObject(x) + "]");
                if (this.dDT instanceof CommonGroupChatMessage) {
                    final CommonGroupChatMessage commonGroupChatMessage = (CommonGroupChatMessage) this.dDT;
                    final LinkedList linkedList = new LinkedList();
                    linkedList.add(new CommonMsgPojo(commonGroupChatMessage));
                    if (!commonGroupChatMessage.getGroupId().equals(String.valueOf(a.dDv))) {
                        t.b(new s<Boolean>() { // from class: com.baidu.tieba.im.widget.chatVoiceView.ChatVoiceView.1
                            /* JADX DEBUG: Method merged with bridge method */
                            /* JADX WARN: Can't rename method to resolve collision */
                            @Override // com.baidu.tbadk.util.s
                            public Boolean doInBackground() {
                                return Boolean.valueOf(c.auW().b(commonGroupChatMessage.getGroupId(), linkedList, false));
                            }
                        }, new g<Boolean>() { // from class: com.baidu.tieba.im.widget.chatVoiceView.ChatVoiceView.2
                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // com.baidu.tbadk.util.g
                            public void onReturnDataInUI(Boolean bool) {
                                ChatVoiceView.this.dFC.setVisibility(8);
                            }
                        });
                        return;
                    } else {
                        t.b(new s<Boolean>() { // from class: com.baidu.tieba.im.widget.chatVoiceView.ChatVoiceView.3
                            /* JADX DEBUG: Method merged with bridge method */
                            /* JADX WARN: Can't rename method to resolve collision */
                            @Override // com.baidu.tbadk.util.s
                            public Boolean doInBackground() {
                                return Boolean.valueOf(l.avk().a(e.q(commonGroupChatMessage), linkedList, false));
                            }
                        }, new g<Boolean>() { // from class: com.baidu.tieba.im.widget.chatVoiceView.ChatVoiceView.4
                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // com.baidu.tbadk.util.g
                            public void onReturnDataInUI(Boolean bool) {
                                ChatVoiceView.this.dFC.setVisibility(8);
                            }
                        });
                        return;
                    }
                } else if (this.dDT instanceof PersonalChatMessage) {
                    final PersonalChatMessage personalChatMessage = (PersonalChatMessage) this.dDT;
                    final LinkedList linkedList2 = new LinkedList();
                    linkedList2.add(new CommonMsgPojo(personalChatMessage));
                    t.b(new s<Boolean>() { // from class: com.baidu.tieba.im.widget.chatVoiceView.ChatVoiceView.5
                        /* JADX DEBUG: Method merged with bridge method */
                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // com.baidu.tbadk.util.s
                        public Boolean doInBackground() {
                            return Boolean.valueOf(l.avk().a(e.q(personalChatMessage), linkedList2, false));
                        }
                    }, new g<Boolean>() { // from class: com.baidu.tieba.im.widget.chatVoiceView.ChatVoiceView.6
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.tbadk.util.g
                        public void onReturnDataInUI(Boolean bool) {
                            ChatVoiceView.this.dFC.setVisibility(8);
                        }
                    });
                    return;
                } else if (this.dDT instanceof OfficialChatMessage) {
                    final OfficialChatMessage officialChatMessage = (OfficialChatMessage) this.dDT;
                    final LinkedList linkedList3 = new LinkedList();
                    linkedList3.add(new CommonMsgPojo(officialChatMessage));
                    t.b(new s<Boolean>() { // from class: com.baidu.tieba.im.widget.chatVoiceView.ChatVoiceView.7
                        /* JADX DEBUG: Method merged with bridge method */
                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // com.baidu.tbadk.util.s
                        public Boolean doInBackground() {
                            return Boolean.valueOf(k.avj().a(e.q(officialChatMessage), linkedList3, false));
                        }
                    }, new g<Boolean>() { // from class: com.baidu.tieba.im.widget.chatVoiceView.ChatVoiceView.8
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.tbadk.util.g
                        public void onReturnDataInUI(Boolean bool) {
                            ChatVoiceView.this.dFC.setVisibility(8);
                        }
                    });
                    return;
                } else {
                    return;
                }
            }
            return;
        }
        azx();
        if (i == 1) {
            if (this.dFz != null) {
                this.dFz.setVisibility(0);
            }
            this.mProgress.setVisibility(4);
        } else if (i == 2) {
            if (this.dFz != null) {
                this.dFz.setVisibility(4);
            }
            this.mProgress.setVisibility(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        VoiceManager voiceManager;
        if (this.dFD == null || (voiceManager = getVoiceManager()) == null) {
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

    private void C(ChatMessage chatMessage) {
        boolean z = true;
        if (e.u(chatMessage)) {
            z = false;
        } else {
            VoiceMsgData x = e.x(chatMessage);
            if (x != null && x.getHas_read() == 1) {
                z = false;
            }
        }
        if (z) {
            this.dFC.setVisibility(0);
        } else {
            this.dFC.setVisibility(8);
        }
    }

    public void setData(ChatMessage chatMessage) {
        VoiceManager voiceManager;
        if (chatMessage != null && chatMessage.getCacheData() != null) {
            this.dFD = chatMessage.getCacheData().getVoice_model();
            if (this.dFD == null) {
                this.dFD = new VoiceData.VoiceModel();
            }
            this.dDT = chatMessage;
            this.dFB.setText(VoiceManager.formatVoiceTime(this.dFD.duration));
            this.dFB.setContentDescription(String.format(getContext().getString(d.l.editor_record_format), VoiceManager.formatVoiceTime(this.dFD.duration)));
            setBubbleLength(this.dFD.duration);
            setTag(this.dFD);
            C(chatMessage);
            if (this.dFD.voice_status.intValue() != 1 && (voiceManager = getVoiceManager()) != null) {
                voiceManager.resetPlayView(this);
            }
            ng(this.dFD.voice_status.intValue());
        }
    }

    public void reset() {
        this.dFD = null;
        ng(1);
    }

    private void setBubbleLength(int i) {
        int i2;
        int ad = com.baidu.adp.lib.util.l.ad(getContext());
        if (i <= 10) {
            int i3 = (int) (ad * 0.1875d);
            i2 = (((((int) (ad * 0.4125d)) - i3) * (i - 1)) / 10) + i3;
        } else if (i <= 30) {
            int i4 = (int) (ad * 0.4125d);
            i2 = (((((int) (ad * 0.5375d)) - i4) * (i - 10)) / 20) + i4;
        } else {
            i2 = (int) (ad * 0.5375d);
        }
        try {
            if (this.dFE.getParent() != null && (this.dFE.getParent() instanceof RelativeLayout)) {
                this.dFE.setLayoutParams(new RelativeLayout.LayoutParams(i2, -2));
                return;
            }
            this.dFE.setLayoutParams(new LinearLayout.LayoutParams(i2, -2));
        } catch (Exception e) {
        }
    }

    public boolean isPlaying() {
        return this.dFD != null && this.dFD.voice_status.intValue() == 3;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void lT() {
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void b(VoiceData.VoiceModel voiceModel) {
        if (voiceModel != null) {
            ng(voiceModel.voice_status.intValue());
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void aS(int i) {
        nf(i);
        if (this.dFD != null) {
            this.dFD.elapse = i;
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void onShowErr(int i, String str) {
        com.baidu.adp.lib.util.l.F(getContext(), str);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceData.VoiceModel getVoiceModel() {
        return this.dFD;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceManager.b getRealView() {
        Context context = getContext();
        VoiceManager.b c = context instanceof VoiceManager.c ? ((VoiceManager.c) context).c(this.dFD) : this;
        return c == null ? this : c;
    }
}
