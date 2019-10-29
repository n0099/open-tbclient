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
import com.baidu.tbadk.util.j;
import com.baidu.tbadk.util.y;
import com.baidu.tbadk.util.z;
import com.baidu.tieba.R;
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
    private ChatMessage gQC;
    private ImageView gSd;
    private ImageView gSe;
    private TextView gSf;
    private ImageView gSg;
    private VoiceData.VoiceModel gSh;
    private RelativeLayout gSi;
    private ProgressBar mProgress;

    public ChatVoiceView(Context context) {
        super(context);
        this.gSd = null;
        this.gSf = null;
        this.gSg = null;
        this.mProgress = null;
        LayoutInflater.from(context).inflate(R.layout.widget_left_voice_view, (ViewGroup) this, true);
        init();
    }

    public ChatVoiceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        boolean z;
        this.gSd = null;
        this.gSf = null;
        this.gSg = null;
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
        this.gSi = (RelativeLayout) findViewById(R.id.lay_bubble);
        this.gSd = (ImageView) findViewById(R.id.img_voice_status);
        this.gSe = (ImageView) findViewById(R.id.img_voice_status_anim);
        this.gSf = (TextView) findViewById(R.id.tex_voice_duration);
        this.gSg = (ImageView) findViewById(R.id.img_voice_readed);
        this.mProgress = (ProgressBar) findViewById(R.id.progress);
    }

    private void bEA() {
        this.gSd.setVisibility(8);
        this.gSe.setVisibility(0);
        ((AnimationDrawable) this.gSe.getBackground()).start();
    }

    private void bEB() {
        ((AnimationDrawable) this.gSe.getBackground()).stop();
        this.gSe.clearAnimation();
        this.gSd.setVisibility(0);
        this.gSe.setVisibility(8);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        try {
            bEB();
        } catch (Exception e) {
        }
    }

    public void uJ(int i) {
    }

    public void uK(int i) {
        if (i == 3) {
            if (this.gSd != null) {
                this.gSd.setVisibility(0);
            }
            this.mProgress.setVisibility(4);
            bEA();
            VoiceMsgData u = e.u(this.gQC);
            if (u != null && u.getHas_read() != 1) {
                u.setHas_read(1);
                this.gQC.setContent("[" + OrmObject.jsonStrWithObject(u) + "]");
                if (this.gQC instanceof CommonGroupChatMessage) {
                    final CommonGroupChatMessage commonGroupChatMessage = (CommonGroupChatMessage) this.gQC;
                    final LinkedList linkedList = new LinkedList();
                    linkedList.add(new CommonMsgPojo(commonGroupChatMessage));
                    if (!commonGroupChatMessage.getGroupId().equals(String.valueOf(a.gQg))) {
                        z.b(new y<Boolean>() { // from class: com.baidu.tieba.im.widget.chatVoiceView.ChatVoiceView.1
                            /* JADX DEBUG: Method merged with bridge method */
                            /* JADX WARN: Can't rename method to resolve collision */
                            @Override // com.baidu.tbadk.util.y
                            public Boolean doInBackground() {
                                return Boolean.valueOf(c.bAl().b(commonGroupChatMessage.getGroupId(), linkedList, false));
                            }
                        }, new j<Boolean>() { // from class: com.baidu.tieba.im.widget.chatVoiceView.ChatVoiceView.2
                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // com.baidu.tbadk.util.j
                            public void onReturnDataInUI(Boolean bool) {
                                ChatVoiceView.this.gSg.setVisibility(8);
                            }
                        });
                        return;
                    } else {
                        z.b(new y<Boolean>() { // from class: com.baidu.tieba.im.widget.chatVoiceView.ChatVoiceView.3
                            /* JADX DEBUG: Method merged with bridge method */
                            /* JADX WARN: Can't rename method to resolve collision */
                            @Override // com.baidu.tbadk.util.y
                            public Boolean doInBackground() {
                                return Boolean.valueOf(m.bAF().a(e.n(commonGroupChatMessage), linkedList, false));
                            }
                        }, new j<Boolean>() { // from class: com.baidu.tieba.im.widget.chatVoiceView.ChatVoiceView.4
                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // com.baidu.tbadk.util.j
                            public void onReturnDataInUI(Boolean bool) {
                                ChatVoiceView.this.gSg.setVisibility(8);
                            }
                        });
                        return;
                    }
                } else if (this.gQC instanceof PersonalChatMessage) {
                    final PersonalChatMessage personalChatMessage = (PersonalChatMessage) this.gQC;
                    final LinkedList linkedList2 = new LinkedList();
                    linkedList2.add(new CommonMsgPojo(personalChatMessage));
                    z.b(new y<Boolean>() { // from class: com.baidu.tieba.im.widget.chatVoiceView.ChatVoiceView.5
                        /* JADX DEBUG: Method merged with bridge method */
                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // com.baidu.tbadk.util.y
                        public Boolean doInBackground() {
                            return Boolean.valueOf(m.bAF().a(e.n(personalChatMessage), linkedList2, false));
                        }
                    }, new j<Boolean>() { // from class: com.baidu.tieba.im.widget.chatVoiceView.ChatVoiceView.6
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.tbadk.util.j
                        public void onReturnDataInUI(Boolean bool) {
                            ChatVoiceView.this.gSg.setVisibility(8);
                        }
                    });
                    return;
                } else if (this.gQC instanceof OfficialChatMessage) {
                    final OfficialChatMessage officialChatMessage = (OfficialChatMessage) this.gQC;
                    final LinkedList linkedList3 = new LinkedList();
                    linkedList3.add(new CommonMsgPojo(officialChatMessage));
                    z.b(new y<Boolean>() { // from class: com.baidu.tieba.im.widget.chatVoiceView.ChatVoiceView.7
                        /* JADX DEBUG: Method merged with bridge method */
                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // com.baidu.tbadk.util.y
                        public Boolean doInBackground() {
                            return Boolean.valueOf(l.bAD().a(e.n(officialChatMessage), linkedList3, false));
                        }
                    }, new j<Boolean>() { // from class: com.baidu.tieba.im.widget.chatVoiceView.ChatVoiceView.8
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.tbadk.util.j
                        public void onReturnDataInUI(Boolean bool) {
                            ChatVoiceView.this.gSg.setVisibility(8);
                        }
                    });
                    return;
                } else {
                    return;
                }
            }
            return;
        }
        bEB();
        if (i == 1) {
            if (this.gSd != null) {
                this.gSd.setVisibility(0);
            }
            this.mProgress.setVisibility(4);
        } else if (i == 2) {
            if (this.gSd != null) {
                this.gSd.setVisibility(4);
            }
            this.mProgress.setVisibility(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        VoiceManager voiceManager;
        if (this.gSh == null || (voiceManager = getVoiceManager()) == null) {
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
            this.gSg.setVisibility(0);
        } else {
            this.gSg.setVisibility(8);
        }
    }

    public void setData(ChatMessage chatMessage) {
        VoiceManager voiceManager;
        if (chatMessage != null && chatMessage.getCacheData() != null) {
            this.gSh = chatMessage.getCacheData().getVoice_model();
            if (this.gSh == null) {
                this.gSh = new VoiceData.VoiceModel();
            }
            this.gQC = chatMessage;
            this.gSf.setText(VoiceManager.formatVoiceTime(this.gSh.duration));
            this.gSf.setContentDescription(String.format(getContext().getString(R.string.editor_record_format), VoiceManager.formatVoiceTime(this.gSh.duration)));
            setBubbleLength(this.gSh.duration);
            setTag(this.gSh);
            z(chatMessage);
            if (this.gSh.voice_status.intValue() != 1 && (voiceManager = getVoiceManager()) != null) {
                voiceManager.resetPlayView(this);
            }
            uK(this.gSh.voice_status.intValue());
        }
    }

    public void reset() {
        this.gSh = null;
        uK(1);
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
            if (this.gSi.getParent() != null && (this.gSi.getParent() instanceof RelativeLayout)) {
                this.gSi.setLayoutParams(new RelativeLayout.LayoutParams(i2, -2));
                return;
            }
            this.gSi.setLayoutParams(new LinearLayout.LayoutParams(i2, -2));
        } catch (Exception e) {
        }
    }

    public boolean isPlaying() {
        return this.gSh != null && this.gSh.voice_status.intValue() == 3;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void lr() {
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void b(VoiceData.VoiceModel voiceModel) {
        if (voiceModel != null) {
            uK(voiceModel.voice_status.intValue());
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void aA(int i) {
        uJ(i);
        if (this.gSh != null) {
            this.gSh.elapse = i;
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void onShowErr(int i, String str) {
        com.baidu.adp.lib.util.l.showLongToast(getContext(), str);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceData.VoiceModel getVoiceModel() {
        return this.gSh;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceManager.b getRealView() {
        Context context = getContext();
        VoiceManager.b c = context instanceof VoiceManager.c ? ((VoiceManager.c) context).c(this.gSh) : this;
        return c == null ? this : c;
    }
}
