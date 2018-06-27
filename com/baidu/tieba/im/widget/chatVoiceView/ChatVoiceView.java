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
import com.baidu.tbadk.util.v;
import com.baidu.tbadk.util.w;
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
    private ChatMessage exW;
    private ImageView ezA;
    private TextView ezB;
    private ImageView ezC;
    private VoiceData.VoiceModel ezD;
    private RelativeLayout ezE;
    private ImageView ezz;
    private ProgressBar mProgress;

    public ChatVoiceView(Context context) {
        super(context);
        this.ezz = null;
        this.ezB = null;
        this.ezC = null;
        this.mProgress = null;
        LayoutInflater.from(context).inflate(d.i.widget_left_voice_view, (ViewGroup) this, true);
        init();
    }

    public ChatVoiceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        boolean z;
        this.ezz = null;
        this.ezB = null;
        this.ezC = null;
        this.mProgress = null;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.m.ChatVoiceView, 0, 0);
        if (obtainStyledAttributes != null) {
            z = obtainStyledAttributes.getBoolean(d.m.ChatVoiceView_is_left, true);
            obtainStyledAttributes.recycle();
        } else {
            z = true;
        }
        if (z) {
            LayoutInflater.from(context).inflate(d.i.widget_left_voice_view, (ViewGroup) this, true);
        } else {
            LayoutInflater.from(context).inflate(d.i.widget_right_voice_view, (ViewGroup) this, true);
        }
        init();
    }

    private void init() {
        this.ezE = (RelativeLayout) findViewById(d.g.lay_bubble);
        this.ezz = (ImageView) findViewById(d.g.img_voice_status);
        this.ezA = (ImageView) findViewById(d.g.img_voice_status_anim);
        this.ezB = (TextView) findViewById(d.g.tex_voice_duration);
        this.ezC = (ImageView) findViewById(d.g.img_voice_readed);
        this.mProgress = (ProgressBar) findViewById(d.g.progress);
    }

    private void aMQ() {
        this.ezz.setVisibility(8);
        this.ezA.setVisibility(0);
        ((AnimationDrawable) this.ezA.getBackground()).start();
    }

    private void aMR() {
        ((AnimationDrawable) this.ezA.getBackground()).stop();
        this.ezA.clearAnimation();
        this.ezz.setVisibility(0);
        this.ezA.setVisibility(8);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        try {
            aMR();
        } catch (Exception e) {
        }
    }

    public void os(int i) {
    }

    public void ot(int i) {
        if (i == 3) {
            if (this.ezz != null) {
                this.ezz.setVisibility(0);
            }
            this.mProgress.setVisibility(4);
            aMQ();
            VoiceMsgData z = e.z(this.exW);
            if (z != null && z.getHas_read() != 1) {
                z.setHas_read(1);
                this.exW.setContent("[" + OrmObject.jsonStrWithObject(z) + "]");
                if (this.exW instanceof CommonGroupChatMessage) {
                    final CommonGroupChatMessage commonGroupChatMessage = (CommonGroupChatMessage) this.exW;
                    final LinkedList linkedList = new LinkedList();
                    linkedList.add(new CommonMsgPojo(commonGroupChatMessage));
                    if (!commonGroupChatMessage.getGroupId().equals(String.valueOf(a.exy))) {
                        w.b(new v<Boolean>() { // from class: com.baidu.tieba.im.widget.chatVoiceView.ChatVoiceView.1
                            /* JADX DEBUG: Method merged with bridge method */
                            /* JADX WARN: Can't rename method to resolve collision */
                            @Override // com.baidu.tbadk.util.v
                            public Boolean doInBackground() {
                                return Boolean.valueOf(c.aIy().b(commonGroupChatMessage.getGroupId(), linkedList, false));
                            }
                        }, new h<Boolean>() { // from class: com.baidu.tieba.im.widget.chatVoiceView.ChatVoiceView.2
                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // com.baidu.tbadk.util.h
                            public void onReturnDataInUI(Boolean bool) {
                                ChatVoiceView.this.ezC.setVisibility(8);
                            }
                        });
                        return;
                    } else {
                        w.b(new v<Boolean>() { // from class: com.baidu.tieba.im.widget.chatVoiceView.ChatVoiceView.3
                            /* JADX DEBUG: Method merged with bridge method */
                            /* JADX WARN: Can't rename method to resolve collision */
                            @Override // com.baidu.tbadk.util.v
                            public Boolean doInBackground() {
                                return Boolean.valueOf(m.aIQ().a(e.s(commonGroupChatMessage), linkedList, false));
                            }
                        }, new h<Boolean>() { // from class: com.baidu.tieba.im.widget.chatVoiceView.ChatVoiceView.4
                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // com.baidu.tbadk.util.h
                            public void onReturnDataInUI(Boolean bool) {
                                ChatVoiceView.this.ezC.setVisibility(8);
                            }
                        });
                        return;
                    }
                } else if (this.exW instanceof PersonalChatMessage) {
                    final PersonalChatMessage personalChatMessage = (PersonalChatMessage) this.exW;
                    final LinkedList linkedList2 = new LinkedList();
                    linkedList2.add(new CommonMsgPojo(personalChatMessage));
                    w.b(new v<Boolean>() { // from class: com.baidu.tieba.im.widget.chatVoiceView.ChatVoiceView.5
                        /* JADX DEBUG: Method merged with bridge method */
                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // com.baidu.tbadk.util.v
                        public Boolean doInBackground() {
                            return Boolean.valueOf(m.aIQ().a(e.s(personalChatMessage), linkedList2, false));
                        }
                    }, new h<Boolean>() { // from class: com.baidu.tieba.im.widget.chatVoiceView.ChatVoiceView.6
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.tbadk.util.h
                        public void onReturnDataInUI(Boolean bool) {
                            ChatVoiceView.this.ezC.setVisibility(8);
                        }
                    });
                    return;
                } else if (this.exW instanceof OfficialChatMessage) {
                    final OfficialChatMessage officialChatMessage = (OfficialChatMessage) this.exW;
                    final LinkedList linkedList3 = new LinkedList();
                    linkedList3.add(new CommonMsgPojo(officialChatMessage));
                    w.b(new v<Boolean>() { // from class: com.baidu.tieba.im.widget.chatVoiceView.ChatVoiceView.7
                        /* JADX DEBUG: Method merged with bridge method */
                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // com.baidu.tbadk.util.v
                        public Boolean doInBackground() {
                            return Boolean.valueOf(l.aIO().a(e.s(officialChatMessage), linkedList3, false));
                        }
                    }, new h<Boolean>() { // from class: com.baidu.tieba.im.widget.chatVoiceView.ChatVoiceView.8
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.tbadk.util.h
                        public void onReturnDataInUI(Boolean bool) {
                            ChatVoiceView.this.ezC.setVisibility(8);
                        }
                    });
                    return;
                } else {
                    return;
                }
            }
            return;
        }
        aMR();
        if (i == 1) {
            if (this.ezz != null) {
                this.ezz.setVisibility(0);
            }
            this.mProgress.setVisibility(4);
        } else if (i == 2) {
            if (this.ezz != null) {
                this.ezz.setVisibility(4);
            }
            this.mProgress.setVisibility(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        VoiceManager voiceManager;
        if (this.ezD == null || (voiceManager = getVoiceManager()) == null) {
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
            this.ezC.setVisibility(0);
        } else {
            this.ezC.setVisibility(8);
        }
    }

    public void setData(ChatMessage chatMessage) {
        VoiceManager voiceManager;
        if (chatMessage != null && chatMessage.getCacheData() != null) {
            this.ezD = chatMessage.getCacheData().getVoice_model();
            if (this.ezD == null) {
                this.ezD = new VoiceData.VoiceModel();
            }
            this.exW = chatMessage;
            this.ezB.setText(VoiceManager.formatVoiceTime(this.ezD.duration));
            this.ezB.setContentDescription(String.format(getContext().getString(d.k.editor_record_format), VoiceManager.formatVoiceTime(this.ezD.duration)));
            setBubbleLength(this.ezD.duration);
            setTag(this.ezD);
            E(chatMessage);
            if (this.ezD.voice_status.intValue() != 1 && (voiceManager = getVoiceManager()) != null) {
                voiceManager.resetPlayView(this);
            }
            ot(this.ezD.voice_status.intValue());
        }
    }

    public void reset() {
        this.ezD = null;
        ot(1);
    }

    private void setBubbleLength(int i) {
        int i2;
        int ah = com.baidu.adp.lib.util.l.ah(getContext());
        if (i <= 10) {
            int i3 = (int) (ah * 0.1875d);
            i2 = (((((int) (ah * 0.4125d)) - i3) * (i - 1)) / 10) + i3;
        } else if (i <= 30) {
            int i4 = (int) (ah * 0.4125d);
            i2 = (((((int) (ah * 0.5375d)) - i4) * (i - 10)) / 20) + i4;
        } else {
            i2 = (int) (ah * 0.5375d);
        }
        try {
            if (this.ezE.getParent() != null && (this.ezE.getParent() instanceof RelativeLayout)) {
                this.ezE.setLayoutParams(new RelativeLayout.LayoutParams(i2, -2));
                return;
            }
            this.ezE.setLayoutParams(new LinearLayout.LayoutParams(i2, -2));
        } catch (Exception e) {
        }
    }

    public boolean isPlaying() {
        return this.ezD != null && this.ezD.voice_status.intValue() == 3;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void oP() {
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void b(VoiceData.VoiceModel voiceModel) {
        if (voiceModel != null) {
            ot(voiceModel.voice_status.intValue());
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void aZ(int i) {
        os(i);
        if (this.ezD != null) {
            this.ezD.elapse = i;
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void onShowErr(int i, String str) {
        com.baidu.adp.lib.util.l.showLongToast(getContext(), str);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceData.VoiceModel getVoiceModel() {
        return this.ezD;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceManager.b getRealView() {
        Context context = getContext();
        VoiceManager.b c = context instanceof VoiceManager.c ? ((VoiceManager.c) context).c(this.ezD) : this;
        return c == null ? this : c;
    }
}
