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
import com.baidu.tbadk.util.aa;
import com.baidu.tbadk.util.k;
import com.baidu.tbadk.util.z;
import com.baidu.tieba.d;
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
import com.baidu.tieba.im.util.e;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class ChatVoiceView extends LinearLayout implements View.OnClickListener, VoiceManager.b {
    private ChatMessage gsp;
    private ImageView gtR;
    private ImageView gtS;
    private TextView gtT;
    private ImageView gtU;
    private VoiceData.VoiceModel gtV;
    private RelativeLayout gtW;
    private ProgressBar mProgress;

    public ChatVoiceView(Context context) {
        super(context);
        this.gtR = null;
        this.gtT = null;
        this.gtU = null;
        this.mProgress = null;
        LayoutInflater.from(context).inflate(d.h.widget_left_voice_view, (ViewGroup) this, true);
        init();
    }

    public ChatVoiceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        boolean z;
        this.gtR = null;
        this.gtT = null;
        this.gtU = null;
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
        this.gtW = (RelativeLayout) findViewById(d.g.lay_bubble);
        this.gtR = (ImageView) findViewById(d.g.img_voice_status);
        this.gtS = (ImageView) findViewById(d.g.img_voice_status_anim);
        this.gtT = (TextView) findViewById(d.g.tex_voice_duration);
        this.gtU = (ImageView) findViewById(d.g.img_voice_readed);
        this.mProgress = (ProgressBar) findViewById(d.g.progress);
    }

    private void bwu() {
        this.gtR.setVisibility(8);
        this.gtS.setVisibility(0);
        ((AnimationDrawable) this.gtS.getBackground()).start();
    }

    private void bwv() {
        ((AnimationDrawable) this.gtS.getBackground()).stop();
        this.gtS.clearAnimation();
        this.gtR.setVisibility(0);
        this.gtS.setVisibility(8);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        try {
            bwv();
        } catch (Exception e) {
        }
    }

    public void up(int i) {
    }

    public void uq(int i) {
        if (i == 3) {
            if (this.gtR != null) {
                this.gtR.setVisibility(0);
            }
            this.mProgress.setVisibility(4);
            bwu();
            VoiceMsgData z = e.z(this.gsp);
            if (z != null && z.getHas_read() != 1) {
                z.setHas_read(1);
                this.gsp.setContent("[" + OrmObject.jsonStrWithObject(z) + "]");
                if (this.gsp instanceof CommonGroupChatMessage) {
                    final CommonGroupChatMessage commonGroupChatMessage = (CommonGroupChatMessage) this.gsp;
                    final LinkedList linkedList = new LinkedList();
                    linkedList.add(new CommonMsgPojo(commonGroupChatMessage));
                    if (!commonGroupChatMessage.getGroupId().equals(String.valueOf(a.grS))) {
                        aa.b(new z<Boolean>() { // from class: com.baidu.tieba.im.widget.chatVoiceView.ChatVoiceView.1
                            /* JADX DEBUG: Method merged with bridge method */
                            /* JADX WARN: Can't rename method to resolve collision */
                            @Override // com.baidu.tbadk.util.z
                            public Boolean doInBackground() {
                                return Boolean.valueOf(c.bse().b(commonGroupChatMessage.getGroupId(), linkedList, false));
                            }
                        }, new k<Boolean>() { // from class: com.baidu.tieba.im.widget.chatVoiceView.ChatVoiceView.2
                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // com.baidu.tbadk.util.k
                            public void onReturnDataInUI(Boolean bool) {
                                ChatVoiceView.this.gtU.setVisibility(8);
                            }
                        });
                        return;
                    } else {
                        aa.b(new z<Boolean>() { // from class: com.baidu.tieba.im.widget.chatVoiceView.ChatVoiceView.3
                            /* JADX DEBUG: Method merged with bridge method */
                            /* JADX WARN: Can't rename method to resolve collision */
                            @Override // com.baidu.tbadk.util.z
                            public Boolean doInBackground() {
                                return Boolean.valueOf(m.bsw().a(e.s(commonGroupChatMessage), linkedList, false));
                            }
                        }, new k<Boolean>() { // from class: com.baidu.tieba.im.widget.chatVoiceView.ChatVoiceView.4
                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // com.baidu.tbadk.util.k
                            public void onReturnDataInUI(Boolean bool) {
                                ChatVoiceView.this.gtU.setVisibility(8);
                            }
                        });
                        return;
                    }
                } else if (this.gsp instanceof PersonalChatMessage) {
                    final PersonalChatMessage personalChatMessage = (PersonalChatMessage) this.gsp;
                    final LinkedList linkedList2 = new LinkedList();
                    linkedList2.add(new CommonMsgPojo(personalChatMessage));
                    aa.b(new z<Boolean>() { // from class: com.baidu.tieba.im.widget.chatVoiceView.ChatVoiceView.5
                        /* JADX DEBUG: Method merged with bridge method */
                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // com.baidu.tbadk.util.z
                        public Boolean doInBackground() {
                            return Boolean.valueOf(m.bsw().a(e.s(personalChatMessage), linkedList2, false));
                        }
                    }, new k<Boolean>() { // from class: com.baidu.tieba.im.widget.chatVoiceView.ChatVoiceView.6
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.tbadk.util.k
                        public void onReturnDataInUI(Boolean bool) {
                            ChatVoiceView.this.gtU.setVisibility(8);
                        }
                    });
                    return;
                } else if (this.gsp instanceof OfficialChatMessage) {
                    final OfficialChatMessage officialChatMessage = (OfficialChatMessage) this.gsp;
                    final LinkedList linkedList3 = new LinkedList();
                    linkedList3.add(new CommonMsgPojo(officialChatMessage));
                    aa.b(new z<Boolean>() { // from class: com.baidu.tieba.im.widget.chatVoiceView.ChatVoiceView.7
                        /* JADX DEBUG: Method merged with bridge method */
                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // com.baidu.tbadk.util.z
                        public Boolean doInBackground() {
                            return Boolean.valueOf(l.bsu().a(e.s(officialChatMessage), linkedList3, false));
                        }
                    }, new k<Boolean>() { // from class: com.baidu.tieba.im.widget.chatVoiceView.ChatVoiceView.8
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.tbadk.util.k
                        public void onReturnDataInUI(Boolean bool) {
                            ChatVoiceView.this.gtU.setVisibility(8);
                        }
                    });
                    return;
                } else {
                    return;
                }
            }
            return;
        }
        bwv();
        if (i == 1) {
            if (this.gtR != null) {
                this.gtR.setVisibility(0);
            }
            this.mProgress.setVisibility(4);
        } else if (i == 2) {
            if (this.gtR != null) {
                this.gtR.setVisibility(4);
            }
            this.mProgress.setVisibility(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        VoiceManager voiceManager;
        if (this.gtV == null || (voiceManager = getVoiceManager()) == null) {
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
            this.gtU.setVisibility(0);
        } else {
            this.gtU.setVisibility(8);
        }
    }

    public void setData(ChatMessage chatMessage) {
        VoiceManager voiceManager;
        if (chatMessage != null && chatMessage.getCacheData() != null) {
            this.gtV = chatMessage.getCacheData().getVoice_model();
            if (this.gtV == null) {
                this.gtV = new VoiceData.VoiceModel();
            }
            this.gsp = chatMessage;
            this.gtT.setText(VoiceManager.formatVoiceTime(this.gtV.duration));
            this.gtT.setContentDescription(String.format(getContext().getString(d.j.editor_record_format), VoiceManager.formatVoiceTime(this.gtV.duration)));
            setBubbleLength(this.gtV.duration);
            setTag(this.gtV);
            E(chatMessage);
            if (this.gtV.voice_status.intValue() != 1 && (voiceManager = getVoiceManager()) != null) {
                voiceManager.resetPlayView(this);
            }
            uq(this.gtV.voice_status.intValue());
        }
    }

    public void reset() {
        this.gtV = null;
        uq(1);
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
            if (this.gtW.getParent() != null && (this.gtW.getParent() instanceof RelativeLayout)) {
                this.gtW.setLayoutParams(new RelativeLayout.LayoutParams(i2, -2));
                return;
            }
            this.gtW.setLayoutParams(new LinearLayout.LayoutParams(i2, -2));
        } catch (Exception e) {
        }
    }

    public boolean isPlaying() {
        return this.gtV != null && this.gtV.voice_status.intValue() == 3;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void rg() {
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void b(VoiceData.VoiceModel voiceModel) {
        if (voiceModel != null) {
            uq(voiceModel.voice_status.intValue());
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void bs(int i) {
        up(i);
        if (this.gtV != null) {
            this.gtV.elapse = i;
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void onShowErr(int i, String str) {
        com.baidu.adp.lib.util.l.S(getContext(), str);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceData.VoiceModel getVoiceModel() {
        return this.gtV;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceManager.b getRealView() {
        Context context = getContext();
        VoiceManager.b c = context instanceof VoiceManager.c ? ((VoiceManager.c) context).c(this.gtV) : this;
        return c == null ? this : c;
    }
}
