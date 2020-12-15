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
import com.baidu.tbadk.util.ac;
import com.baidu.tbadk.util.ad;
import com.baidu.tbadk.util.m;
import com.baidu.tieba.R;
import com.baidu.tieba.im.data.VoiceMsgData;
import com.baidu.tieba.im.db.c;
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
    private ChatMessage kDa;
    private ImageView kEC;
    private ImageView kED;
    private TextView kEE;
    private ImageView kEF;
    private VoiceData.VoiceModel kEG;
    private RelativeLayout kEH;
    private ProgressBar mProgress;

    public ChatVoiceView(Context context) {
        super(context);
        this.kEC = null;
        this.kEE = null;
        this.kEF = null;
        this.mProgress = null;
        LayoutInflater.from(context).inflate(R.layout.widget_left_voice_view, (ViewGroup) this, true);
        init();
    }

    public ChatVoiceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        boolean z;
        this.kEC = null;
        this.kEE = null;
        this.kEF = null;
        this.mProgress = null;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ChatVoiceView, 0, 0);
        if (obtainStyledAttributes != null) {
            z = obtainStyledAttributes.getBoolean(R.styleable.ChatVoiceView_is_left, true);
            obtainStyledAttributes.recycle();
        } else {
            z = true;
        }
        if (z) {
            LayoutInflater.from(context).inflate(R.layout.widget_left_voice_view, (ViewGroup) this, true);
        } else {
            LayoutInflater.from(context).inflate(R.layout.widget_right_voice_view, (ViewGroup) this, true);
        }
        init();
    }

    private void init() {
        this.kEH = (RelativeLayout) findViewById(R.id.lay_bubble);
        this.kEC = (ImageView) findViewById(R.id.img_voice_status);
        this.kED = (ImageView) findViewById(R.id.img_voice_status_anim);
        this.kEE = (TextView) findViewById(R.id.tex_voice_duration);
        this.kEF = (ImageView) findViewById(R.id.img_voice_readed);
        this.mProgress = (ProgressBar) findViewById(R.id.progress);
    }

    private void dau() {
        this.kEC.setVisibility(8);
        this.kED.setVisibility(0);
        ((AnimationDrawable) this.kED.getBackground()).start();
    }

    private void dav() {
        ((AnimationDrawable) this.kED.getBackground()).stop();
        this.kED.clearAnimation();
        this.kEC.setVisibility(0);
        this.kED.setVisibility(8);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        try {
            dav();
        } catch (Exception e) {
        }
    }

    public void EL(int i) {
    }

    public void EM(int i) {
        if (i == 3) {
            if (this.kEC != null) {
                this.kEC.setVisibility(0);
            }
            this.mProgress.setVisibility(4);
            dau();
            VoiceMsgData u = e.u(this.kDa);
            if (u != null && u.getHas_read() != 1) {
                u.setHas_read(1);
                this.kDa.setContent("[" + OrmObject.jsonStrWithObject(u) + "]");
                if (this.kDa instanceof CommonGroupChatMessage) {
                    final CommonGroupChatMessage commonGroupChatMessage = (CommonGroupChatMessage) this.kDa;
                    final LinkedList linkedList = new LinkedList();
                    linkedList.add(new CommonMsgPojo(commonGroupChatMessage));
                    if (!commonGroupChatMessage.getGroupId().equals(String.valueOf(a.kCF))) {
                        ad.b(new ac<Boolean>() { // from class: com.baidu.tieba.im.widget.chatVoiceView.ChatVoiceView.1
                            /* JADX DEBUG: Method merged with bridge method */
                            /* JADX WARN: Can't rename method to resolve collision */
                            @Override // com.baidu.tbadk.util.ac
                            public Boolean doInBackground() {
                                return Boolean.valueOf(c.cVP().b(commonGroupChatMessage.getGroupId(), linkedList, false));
                            }
                        }, new m<Boolean>() { // from class: com.baidu.tieba.im.widget.chatVoiceView.ChatVoiceView.2
                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // com.baidu.tbadk.util.m
                            public void onReturnDataInUI(Boolean bool) {
                                ChatVoiceView.this.kEF.setVisibility(8);
                            }
                        });
                        return;
                    } else {
                        ad.b(new ac<Boolean>() { // from class: com.baidu.tieba.im.widget.chatVoiceView.ChatVoiceView.3
                            /* JADX DEBUG: Method merged with bridge method */
                            /* JADX WARN: Can't rename method to resolve collision */
                            @Override // com.baidu.tbadk.util.ac
                            public Boolean doInBackground() {
                                return Boolean.valueOf(com.baidu.tieba.im.db.m.cWj().a(e.n(commonGroupChatMessage), linkedList, false));
                            }
                        }, new m<Boolean>() { // from class: com.baidu.tieba.im.widget.chatVoiceView.ChatVoiceView.4
                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // com.baidu.tbadk.util.m
                            public void onReturnDataInUI(Boolean bool) {
                                ChatVoiceView.this.kEF.setVisibility(8);
                            }
                        });
                        return;
                    }
                } else if (this.kDa instanceof PersonalChatMessage) {
                    final PersonalChatMessage personalChatMessage = (PersonalChatMessage) this.kDa;
                    final LinkedList linkedList2 = new LinkedList();
                    linkedList2.add(new CommonMsgPojo(personalChatMessage));
                    ad.b(new ac<Boolean>() { // from class: com.baidu.tieba.im.widget.chatVoiceView.ChatVoiceView.5
                        /* JADX DEBUG: Method merged with bridge method */
                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // com.baidu.tbadk.util.ac
                        public Boolean doInBackground() {
                            return Boolean.valueOf(com.baidu.tieba.im.db.m.cWj().a(e.n(personalChatMessage), linkedList2, false));
                        }
                    }, new m<Boolean>() { // from class: com.baidu.tieba.im.widget.chatVoiceView.ChatVoiceView.6
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.tbadk.util.m
                        public void onReturnDataInUI(Boolean bool) {
                            ChatVoiceView.this.kEF.setVisibility(8);
                        }
                    });
                    return;
                } else if (this.kDa instanceof OfficialChatMessage) {
                    final OfficialChatMessage officialChatMessage = (OfficialChatMessage) this.kDa;
                    final LinkedList linkedList3 = new LinkedList();
                    linkedList3.add(new CommonMsgPojo(officialChatMessage));
                    ad.b(new ac<Boolean>() { // from class: com.baidu.tieba.im.widget.chatVoiceView.ChatVoiceView.7
                        /* JADX DEBUG: Method merged with bridge method */
                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // com.baidu.tbadk.util.ac
                        public Boolean doInBackground() {
                            return Boolean.valueOf(l.cWg().a(e.n(officialChatMessage), linkedList3, false));
                        }
                    }, new m<Boolean>() { // from class: com.baidu.tieba.im.widget.chatVoiceView.ChatVoiceView.8
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.tbadk.util.m
                        public void onReturnDataInUI(Boolean bool) {
                            ChatVoiceView.this.kEF.setVisibility(8);
                        }
                    });
                    return;
                } else {
                    return;
                }
            }
            return;
        }
        dav();
        if (i == 1) {
            if (this.kEC != null) {
                this.kEC.setVisibility(0);
            }
            this.mProgress.setVisibility(4);
        } else if (i == 2) {
            if (this.kEC != null) {
                this.kEC.setVisibility(4);
            }
            this.mProgress.setVisibility(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        VoiceManager voiceManager;
        if (this.kEG == null || (voiceManager = getVoiceManager()) == null) {
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
        if (e.r(chatMessage)) {
            z = false;
        } else {
            VoiceMsgData u = e.u(chatMessage);
            if (u != null && u.getHas_read() == 1) {
                z = false;
            }
        }
        if (z) {
            this.kEF.setVisibility(0);
        } else {
            this.kEF.setVisibility(8);
        }
    }

    public void setData(ChatMessage chatMessage) {
        VoiceManager voiceManager;
        if (chatMessage != null && chatMessage.getCacheData() != null) {
            this.kEG = chatMessage.getCacheData().getVoice_model();
            if (this.kEG == null) {
                this.kEG = new VoiceData.VoiceModel();
            }
            this.kDa = chatMessage;
            this.kEE.setText(VoiceManager.formatVoiceTime(this.kEG.duration));
            this.kEE.setContentDescription(String.format(getContext().getString(R.string.editor_record_format), VoiceManager.formatVoiceTime(this.kEG.duration)));
            setBubbleLength(this.kEG.duration);
            setTag(this.kEG);
            z(chatMessage);
            if (this.kEG.voice_status.intValue() != 1 && (voiceManager = getVoiceManager()) != null) {
                voiceManager.resetPlayView(this);
            }
            EM(this.kEG.voice_status.intValue());
        }
    }

    public void reset() {
        this.kEG = null;
        EM(1);
    }

    private void setBubbleLength(int i) {
        int i2;
        int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(getContext());
        if (i <= 10) {
            int i3 = (int) (equipmentWidth * 0.1875d);
            i2 = (((((int) (equipmentWidth * 0.4125d)) - i3) * (i - 1)) / 10) + i3;
        } else if (i <= 30) {
            int i4 = (int) (equipmentWidth * 0.4125d);
            i2 = (((((int) (equipmentWidth * 0.5375d)) - i4) * (i - 10)) / 20) + i4;
        } else {
            i2 = (int) (equipmentWidth * 0.5375d);
        }
        try {
            if (this.kEH.getParent() != null && (this.kEH.getParent() instanceof RelativeLayout)) {
                this.kEH.setLayoutParams(new RelativeLayout.LayoutParams(i2, -2));
                return;
            }
            this.kEH.setLayoutParams(new LinearLayout.LayoutParams(i2, -2));
        } catch (Exception e) {
        }
    }

    public boolean isPlaying() {
        return this.kEG != null && this.kEG.voice_status.intValue() == 3;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void si() {
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void b(VoiceData.VoiceModel voiceModel) {
        if (voiceModel != null) {
            EM(voiceModel.voice_status.intValue());
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void bj(int i) {
        EL(i);
        if (this.kEG != null) {
            this.kEG.elapse = i;
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void onShowErr(int i, String str) {
        com.baidu.adp.lib.util.l.showLongToast(getContext(), str);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceData.VoiceModel getVoiceModel() {
        return this.kEG;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceManager.b getRealView() {
        Context context = getContext();
        VoiceManager.b d = context instanceof VoiceManager.c ? ((VoiceManager.c) context).d(this.kEG) : this;
        return d == null ? this : d;
    }
}
