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
import com.baidu.tbadk.util.ab;
import com.baidu.tbadk.util.ac;
import com.baidu.tbadk.util.l;
import com.baidu.tieba.R;
import com.baidu.tieba.im.data.VoiceMsgData;
import com.baidu.tieba.im.db.c;
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
    private ChatMessage hHs;
    private ImageView hIT;
    private ImageView hIU;
    private TextView hIV;
    private ImageView hIW;
    private VoiceData.VoiceModel hIX;
    private RelativeLayout hIY;
    private ProgressBar mProgress;

    public ChatVoiceView(Context context) {
        super(context);
        this.hIT = null;
        this.hIV = null;
        this.hIW = null;
        this.mProgress = null;
        LayoutInflater.from(context).inflate(R.layout.widget_left_voice_view, (ViewGroup) this, true);
        init();
    }

    public ChatVoiceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        boolean z;
        this.hIT = null;
        this.hIV = null;
        this.hIW = null;
        this.mProgress = null;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ChatVoiceView, 0, 0);
        if (obtainStyledAttributes != null) {
            z = obtainStyledAttributes.getBoolean(0, true);
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
        this.hIY = (RelativeLayout) findViewById(R.id.lay_bubble);
        this.hIT = (ImageView) findViewById(R.id.img_voice_status);
        this.hIU = (ImageView) findViewById(R.id.img_voice_status_anim);
        this.hIV = (TextView) findViewById(R.id.tex_voice_duration);
        this.hIW = (ImageView) findViewById(R.id.img_voice_readed);
        this.mProgress = (ProgressBar) findViewById(R.id.progress);
    }

    private void bWT() {
        this.hIT.setVisibility(8);
        this.hIU.setVisibility(0);
        ((AnimationDrawable) this.hIU.getBackground()).start();
    }

    private void bWU() {
        ((AnimationDrawable) this.hIU.getBackground()).stop();
        this.hIU.clearAnimation();
        this.hIT.setVisibility(0);
        this.hIU.setVisibility(8);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        try {
            bWU();
        } catch (Exception e) {
        }
    }

    public void wP(int i) {
    }

    public void wQ(int i) {
        if (i == 3) {
            if (this.hIT != null) {
                this.hIT.setVisibility(0);
            }
            this.mProgress.setVisibility(4);
            bWT();
            VoiceMsgData u = e.u(this.hHs);
            if (u != null && u.getHas_read() != 1) {
                u.setHas_read(1);
                this.hHs.setContent("[" + OrmObject.jsonStrWithObject(u) + "]");
                if (this.hHs instanceof CommonGroupChatMessage) {
                    final CommonGroupChatMessage commonGroupChatMessage = (CommonGroupChatMessage) this.hHs;
                    final LinkedList linkedList = new LinkedList();
                    linkedList.add(new CommonMsgPojo(commonGroupChatMessage));
                    if (!commonGroupChatMessage.getGroupId().equals(String.valueOf(a.hGW))) {
                        ac.b(new ab<Boolean>() { // from class: com.baidu.tieba.im.widget.chatVoiceView.ChatVoiceView.1
                            /* JADX DEBUG: Method merged with bridge method */
                            /* JADX WARN: Can't rename method to resolve collision */
                            @Override // com.baidu.tbadk.util.ab
                            public Boolean doInBackground() {
                                return Boolean.valueOf(c.bSI().a(commonGroupChatMessage.getGroupId(), linkedList, false));
                            }
                        }, new l<Boolean>() { // from class: com.baidu.tieba.im.widget.chatVoiceView.ChatVoiceView.2
                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // com.baidu.tbadk.util.l
                            public void onReturnDataInUI(Boolean bool) {
                                ChatVoiceView.this.hIW.setVisibility(8);
                            }
                        });
                        return;
                    } else {
                        ac.b(new ab<Boolean>() { // from class: com.baidu.tieba.im.widget.chatVoiceView.ChatVoiceView.3
                            /* JADX DEBUG: Method merged with bridge method */
                            /* JADX WARN: Can't rename method to resolve collision */
                            @Override // com.baidu.tbadk.util.ab
                            public Boolean doInBackground() {
                                return Boolean.valueOf(m.bTb().a(e.n(commonGroupChatMessage), linkedList, false));
                            }
                        }, new l<Boolean>() { // from class: com.baidu.tieba.im.widget.chatVoiceView.ChatVoiceView.4
                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // com.baidu.tbadk.util.l
                            public void onReturnDataInUI(Boolean bool) {
                                ChatVoiceView.this.hIW.setVisibility(8);
                            }
                        });
                        return;
                    }
                } else if (this.hHs instanceof PersonalChatMessage) {
                    final PersonalChatMessage personalChatMessage = (PersonalChatMessage) this.hHs;
                    final LinkedList linkedList2 = new LinkedList();
                    linkedList2.add(new CommonMsgPojo(personalChatMessage));
                    ac.b(new ab<Boolean>() { // from class: com.baidu.tieba.im.widget.chatVoiceView.ChatVoiceView.5
                        /* JADX DEBUG: Method merged with bridge method */
                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // com.baidu.tbadk.util.ab
                        public Boolean doInBackground() {
                            return Boolean.valueOf(m.bTb().a(e.n(personalChatMessage), linkedList2, false));
                        }
                    }, new l<Boolean>() { // from class: com.baidu.tieba.im.widget.chatVoiceView.ChatVoiceView.6
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.tbadk.util.l
                        public void onReturnDataInUI(Boolean bool) {
                            ChatVoiceView.this.hIW.setVisibility(8);
                        }
                    });
                    return;
                } else if (this.hHs instanceof OfficialChatMessage) {
                    final OfficialChatMessage officialChatMessage = (OfficialChatMessage) this.hHs;
                    final LinkedList linkedList3 = new LinkedList();
                    linkedList3.add(new CommonMsgPojo(officialChatMessage));
                    ac.b(new ab<Boolean>() { // from class: com.baidu.tieba.im.widget.chatVoiceView.ChatVoiceView.7
                        /* JADX DEBUG: Method merged with bridge method */
                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // com.baidu.tbadk.util.ab
                        public Boolean doInBackground() {
                            return Boolean.valueOf(com.baidu.tieba.im.db.l.bSZ().a(e.n(officialChatMessage), linkedList3, false));
                        }
                    }, new l<Boolean>() { // from class: com.baidu.tieba.im.widget.chatVoiceView.ChatVoiceView.8
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.tbadk.util.l
                        public void onReturnDataInUI(Boolean bool) {
                            ChatVoiceView.this.hIW.setVisibility(8);
                        }
                    });
                    return;
                } else {
                    return;
                }
            }
            return;
        }
        bWU();
        if (i == 1) {
            if (this.hIT != null) {
                this.hIT.setVisibility(0);
            }
            this.mProgress.setVisibility(4);
        } else if (i == 2) {
            if (this.hIT != null) {
                this.hIT.setVisibility(4);
            }
            this.mProgress.setVisibility(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        VoiceManager voiceManager;
        if (this.hIX == null || (voiceManager = getVoiceManager()) == null) {
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
            this.hIW.setVisibility(0);
        } else {
            this.hIW.setVisibility(8);
        }
    }

    public void setData(ChatMessage chatMessage) {
        VoiceManager voiceManager;
        if (chatMessage != null && chatMessage.getCacheData() != null) {
            this.hIX = chatMessage.getCacheData().getVoice_model();
            if (this.hIX == null) {
                this.hIX = new VoiceData.VoiceModel();
            }
            this.hHs = chatMessage;
            this.hIV.setText(VoiceManager.formatVoiceTime(this.hIX.duration));
            this.hIV.setContentDescription(String.format(getContext().getString(R.string.editor_record_format), VoiceManager.formatVoiceTime(this.hIX.duration)));
            setBubbleLength(this.hIX.duration);
            setTag(this.hIX);
            z(chatMessage);
            if (this.hIX.voice_status.intValue() != 1 && (voiceManager = getVoiceManager()) != null) {
                voiceManager.resetPlayView(this);
            }
            wQ(this.hIX.voice_status.intValue());
        }
    }

    public void reset() {
        this.hIX = null;
        wQ(1);
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
            if (this.hIY.getParent() != null && (this.hIY.getParent() instanceof RelativeLayout)) {
                this.hIY.setLayoutParams(new RelativeLayout.LayoutParams(i2, -2));
                return;
            }
            this.hIY.setLayoutParams(new LinearLayout.LayoutParams(i2, -2));
        } catch (Exception e) {
        }
    }

    public boolean isPlaying() {
        return this.hIX != null && this.hIX.voice_status.intValue() == 3;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void lI() {
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void b(VoiceData.VoiceModel voiceModel) {
        if (voiceModel != null) {
            wQ(voiceModel.voice_status.intValue());
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void aD(int i) {
        wP(i);
        if (this.hIX != null) {
            this.hIX.elapse = i;
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void onShowErr(int i, String str) {
        com.baidu.adp.lib.util.l.showLongToast(getContext(), str);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceData.VoiceModel getVoiceModel() {
        return this.hIX;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceManager.b getRealView() {
        Context context = getContext();
        VoiceManager.b c = context instanceof VoiceManager.c ? ((VoiceManager.c) context).c(this.hIX) : this;
        return c == null ? this : c;
    }
}
