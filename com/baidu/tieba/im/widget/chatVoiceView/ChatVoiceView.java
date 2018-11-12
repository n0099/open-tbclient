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
    private ChatMessage eSd;
    private ImageView eTE;
    private ImageView eTF;
    private TextView eTG;
    private ImageView eTH;
    private VoiceData.VoiceModel eTI;
    private RelativeLayout eTJ;
    private ProgressBar mProgress;

    public ChatVoiceView(Context context) {
        super(context);
        this.eTE = null;
        this.eTG = null;
        this.eTH = null;
        this.mProgress = null;
        LayoutInflater.from(context).inflate(e.h.widget_left_voice_view, (ViewGroup) this, true);
        init();
    }

    public ChatVoiceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        boolean z;
        this.eTE = null;
        this.eTG = null;
        this.eTH = null;
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
        this.eTJ = (RelativeLayout) findViewById(e.g.lay_bubble);
        this.eTE = (ImageView) findViewById(e.g.img_voice_status);
        this.eTF = (ImageView) findViewById(e.g.img_voice_status_anim);
        this.eTG = (TextView) findViewById(e.g.tex_voice_duration);
        this.eTH = (ImageView) findViewById(e.g.img_voice_readed);
        this.mProgress = (ProgressBar) findViewById(e.g.progress);
    }

    private void aSN() {
        this.eTE.setVisibility(8);
        this.eTF.setVisibility(0);
        ((AnimationDrawable) this.eTF.getBackground()).start();
    }

    private void aSO() {
        ((AnimationDrawable) this.eTF.getBackground()).stop();
        this.eTF.clearAnimation();
        this.eTE.setVisibility(0);
        this.eTF.setVisibility(8);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        try {
            aSO();
        } catch (Exception e) {
        }
    }

    public void qb(int i) {
    }

    public void qc(int i) {
        if (i == 3) {
            if (this.eTE != null) {
                this.eTE.setVisibility(0);
            }
            this.mProgress.setVisibility(4);
            aSN();
            VoiceMsgData z = com.baidu.tieba.im.util.e.z(this.eSd);
            if (z != null && z.getHas_read() != 1) {
                z.setHas_read(1);
                this.eSd.setContent("[" + OrmObject.jsonStrWithObject(z) + "]");
                if (this.eSd instanceof CommonGroupChatMessage) {
                    final CommonGroupChatMessage commonGroupChatMessage = (CommonGroupChatMessage) this.eSd;
                    final LinkedList linkedList = new LinkedList();
                    linkedList.add(new CommonMsgPojo(commonGroupChatMessage));
                    if (!commonGroupChatMessage.getGroupId().equals(String.valueOf(a.eRF))) {
                        x.b(new w<Boolean>() { // from class: com.baidu.tieba.im.widget.chatVoiceView.ChatVoiceView.1
                            /* JADX DEBUG: Method merged with bridge method */
                            /* JADX WARN: Can't rename method to resolve collision */
                            @Override // com.baidu.tbadk.util.w
                            public Boolean doInBackground() {
                                return Boolean.valueOf(c.aOx().b(commonGroupChatMessage.getGroupId(), linkedList, false));
                            }
                        }, new h<Boolean>() { // from class: com.baidu.tieba.im.widget.chatVoiceView.ChatVoiceView.2
                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // com.baidu.tbadk.util.h
                            public void onReturnDataInUI(Boolean bool) {
                                ChatVoiceView.this.eTH.setVisibility(8);
                            }
                        });
                        return;
                    } else {
                        x.b(new w<Boolean>() { // from class: com.baidu.tieba.im.widget.chatVoiceView.ChatVoiceView.3
                            /* JADX DEBUG: Method merged with bridge method */
                            /* JADX WARN: Can't rename method to resolve collision */
                            @Override // com.baidu.tbadk.util.w
                            public Boolean doInBackground() {
                                return Boolean.valueOf(m.aOP().a(com.baidu.tieba.im.util.e.s(commonGroupChatMessage), linkedList, false));
                            }
                        }, new h<Boolean>() { // from class: com.baidu.tieba.im.widget.chatVoiceView.ChatVoiceView.4
                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // com.baidu.tbadk.util.h
                            public void onReturnDataInUI(Boolean bool) {
                                ChatVoiceView.this.eTH.setVisibility(8);
                            }
                        });
                        return;
                    }
                } else if (this.eSd instanceof PersonalChatMessage) {
                    final PersonalChatMessage personalChatMessage = (PersonalChatMessage) this.eSd;
                    final LinkedList linkedList2 = new LinkedList();
                    linkedList2.add(new CommonMsgPojo(personalChatMessage));
                    x.b(new w<Boolean>() { // from class: com.baidu.tieba.im.widget.chatVoiceView.ChatVoiceView.5
                        /* JADX DEBUG: Method merged with bridge method */
                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // com.baidu.tbadk.util.w
                        public Boolean doInBackground() {
                            return Boolean.valueOf(m.aOP().a(com.baidu.tieba.im.util.e.s(personalChatMessage), linkedList2, false));
                        }
                    }, new h<Boolean>() { // from class: com.baidu.tieba.im.widget.chatVoiceView.ChatVoiceView.6
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.tbadk.util.h
                        public void onReturnDataInUI(Boolean bool) {
                            ChatVoiceView.this.eTH.setVisibility(8);
                        }
                    });
                    return;
                } else if (this.eSd instanceof OfficialChatMessage) {
                    final OfficialChatMessage officialChatMessage = (OfficialChatMessage) this.eSd;
                    final LinkedList linkedList3 = new LinkedList();
                    linkedList3.add(new CommonMsgPojo(officialChatMessage));
                    x.b(new w<Boolean>() { // from class: com.baidu.tieba.im.widget.chatVoiceView.ChatVoiceView.7
                        /* JADX DEBUG: Method merged with bridge method */
                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // com.baidu.tbadk.util.w
                        public Boolean doInBackground() {
                            return Boolean.valueOf(l.aON().a(com.baidu.tieba.im.util.e.s(officialChatMessage), linkedList3, false));
                        }
                    }, new h<Boolean>() { // from class: com.baidu.tieba.im.widget.chatVoiceView.ChatVoiceView.8
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.tbadk.util.h
                        public void onReturnDataInUI(Boolean bool) {
                            ChatVoiceView.this.eTH.setVisibility(8);
                        }
                    });
                    return;
                } else {
                    return;
                }
            }
            return;
        }
        aSO();
        if (i == 1) {
            if (this.eTE != null) {
                this.eTE.setVisibility(0);
            }
            this.mProgress.setVisibility(4);
        } else if (i == 2) {
            if (this.eTE != null) {
                this.eTE.setVisibility(4);
            }
            this.mProgress.setVisibility(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        VoiceManager voiceManager;
        if (this.eTI == null || (voiceManager = getVoiceManager()) == null) {
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
            this.eTH.setVisibility(0);
        } else {
            this.eTH.setVisibility(8);
        }
    }

    public void setData(ChatMessage chatMessage) {
        VoiceManager voiceManager;
        if (chatMessage != null && chatMessage.getCacheData() != null) {
            this.eTI = chatMessage.getCacheData().getVoice_model();
            if (this.eTI == null) {
                this.eTI = new VoiceData.VoiceModel();
            }
            this.eSd = chatMessage;
            this.eTG.setText(VoiceManager.formatVoiceTime(this.eTI.duration));
            this.eTG.setContentDescription(String.format(getContext().getString(e.j.editor_record_format), VoiceManager.formatVoiceTime(this.eTI.duration)));
            setBubbleLength(this.eTI.duration);
            setTag(this.eTI);
            E(chatMessage);
            if (this.eTI.voice_status.intValue() != 1 && (voiceManager = getVoiceManager()) != null) {
                voiceManager.resetPlayView(this);
            }
            qc(this.eTI.voice_status.intValue());
        }
    }

    public void reset() {
        this.eTI = null;
        qc(1);
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
            if (this.eTJ.getParent() != null && (this.eTJ.getParent() instanceof RelativeLayout)) {
                this.eTJ.setLayoutParams(new RelativeLayout.LayoutParams(i2, -2));
                return;
            }
            this.eTJ.setLayoutParams(new LinearLayout.LayoutParams(i2, -2));
        } catch (Exception e) {
        }
    }

    public boolean isPlaying() {
        return this.eTI != null && this.eTI.voice_status.intValue() == 3;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void qa() {
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void b(VoiceData.VoiceModel voiceModel) {
        if (voiceModel != null) {
            qc(voiceModel.voice_status.intValue());
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void bz(int i) {
        qb(i);
        if (this.eTI != null) {
            this.eTI.elapse = i;
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void onShowErr(int i, String str) {
        com.baidu.adp.lib.util.l.S(getContext(), str);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceData.VoiceModel getVoiceModel() {
        return this.eTI;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceManager.b getRealView() {
        Context context = getContext();
        VoiceManager.b c = context instanceof VoiceManager.c ? ((VoiceManager.c) context).c(this.eTI) : this;
        return c == null ? this : c;
    }
}
