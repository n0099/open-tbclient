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
import com.baidu.tbadk.util.ae;
import com.baidu.tbadk.util.af;
import com.baidu.tbadk.util.m;
import com.baidu.tieba.R;
import com.baidu.tieba.im.data.VoiceMsgData;
import com.baidu.tieba.im.db.l;
import com.baidu.tieba.im.db.pojo.CommonMsgPojo;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.message.chat.CommonGroupChatMessage;
import com.baidu.tieba.im.message.chat.OfficialChatMessage;
import com.baidu.tieba.im.message.chat.PersonalChatMessage;
import com.baidu.tieba.im.sendmessage.a;
import com.baidu.tieba.im.util.c;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class ChatVoiceView extends LinearLayout implements View.OnClickListener, VoiceManager.b {
    private ImageView hgG;
    private ChatMessage kMj;
    private TextView kNA;
    private ImageView kNB;
    private VoiceData.VoiceModel kNC;
    private RelativeLayout kND;
    private ImageView kNz;
    private ProgressBar mProgress;

    public ChatVoiceView(Context context) {
        super(context);
        this.hgG = null;
        this.kNA = null;
        this.kNB = null;
        this.mProgress = null;
        LayoutInflater.from(context).inflate(R.layout.widget_left_voice_view, (ViewGroup) this, true);
        init();
    }

    public ChatVoiceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        boolean z;
        this.hgG = null;
        this.kNA = null;
        this.kNB = null;
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
        this.kND = (RelativeLayout) findViewById(R.id.lay_bubble);
        this.hgG = (ImageView) findViewById(R.id.img_voice_status);
        this.kNz = (ImageView) findViewById(R.id.img_voice_status_anim);
        this.kNA = (TextView) findViewById(R.id.tex_voice_duration);
        this.kNB = (ImageView) findViewById(R.id.img_voice_readed);
        this.mProgress = (ProgressBar) findViewById(R.id.progress);
    }

    private void cYl() {
        this.hgG.setVisibility(8);
        this.kNz.setVisibility(0);
        ((AnimationDrawable) this.kNz.getBackground()).start();
    }

    private void cYm() {
        ((AnimationDrawable) this.kNz.getBackground()).stop();
        this.kNz.clearAnimation();
        this.hgG.setVisibility(0);
        this.kNz.setVisibility(8);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        try {
            cYm();
        } catch (Exception e) {
        }
    }

    public void Do(int i) {
    }

    public void Dp(int i) {
        if (i == 3) {
            if (this.hgG != null) {
                this.hgG.setVisibility(0);
            }
            this.mProgress.setVisibility(4);
            cYl();
            VoiceMsgData u = c.u(this.kMj);
            if (u != null && u.getHas_read() != 1) {
                u.setHas_read(1);
                this.kMj.setContent("[" + OrmObject.jsonStrWithObject(u) + "]");
                if (this.kMj instanceof CommonGroupChatMessage) {
                    final CommonGroupChatMessage commonGroupChatMessage = (CommonGroupChatMessage) this.kMj;
                    final LinkedList linkedList = new LinkedList();
                    linkedList.add(new CommonMsgPojo(commonGroupChatMessage));
                    if (!commonGroupChatMessage.getGroupId().equals(String.valueOf(a.kLO))) {
                        af.b(new ae<Boolean>() { // from class: com.baidu.tieba.im.widget.chatVoiceView.ChatVoiceView.1
                            /* JADX DEBUG: Method merged with bridge method */
                            /* JADX WARN: Can't rename method to resolve collision */
                            @Override // com.baidu.tbadk.util.ae
                            public Boolean doInBackground() {
                                return Boolean.valueOf(com.baidu.tieba.im.db.c.cVz().d(commonGroupChatMessage.getGroupId(), linkedList, false));
                            }
                        }, new m<Boolean>() { // from class: com.baidu.tieba.im.widget.chatVoiceView.ChatVoiceView.2
                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // com.baidu.tbadk.util.m
                            public void onReturnDataInUI(Boolean bool) {
                                ChatVoiceView.this.kNB.setVisibility(8);
                            }
                        });
                        return;
                    } else {
                        af.b(new ae<Boolean>() { // from class: com.baidu.tieba.im.widget.chatVoiceView.ChatVoiceView.3
                            /* JADX DEBUG: Method merged with bridge method */
                            /* JADX WARN: Can't rename method to resolve collision */
                            @Override // com.baidu.tbadk.util.ae
                            public Boolean doInBackground() {
                                return Boolean.valueOf(com.baidu.tieba.im.db.m.cVT().a(c.n(commonGroupChatMessage), linkedList, false));
                            }
                        }, new m<Boolean>() { // from class: com.baidu.tieba.im.widget.chatVoiceView.ChatVoiceView.4
                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // com.baidu.tbadk.util.m
                            public void onReturnDataInUI(Boolean bool) {
                                ChatVoiceView.this.kNB.setVisibility(8);
                            }
                        });
                        return;
                    }
                } else if (this.kMj instanceof PersonalChatMessage) {
                    final PersonalChatMessage personalChatMessage = (PersonalChatMessage) this.kMj;
                    final LinkedList linkedList2 = new LinkedList();
                    linkedList2.add(new CommonMsgPojo(personalChatMessage));
                    af.b(new ae<Boolean>() { // from class: com.baidu.tieba.im.widget.chatVoiceView.ChatVoiceView.5
                        /* JADX DEBUG: Method merged with bridge method */
                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // com.baidu.tbadk.util.ae
                        public Boolean doInBackground() {
                            return Boolean.valueOf(com.baidu.tieba.im.db.m.cVT().a(c.n(personalChatMessage), linkedList2, false));
                        }
                    }, new m<Boolean>() { // from class: com.baidu.tieba.im.widget.chatVoiceView.ChatVoiceView.6
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.tbadk.util.m
                        public void onReturnDataInUI(Boolean bool) {
                            ChatVoiceView.this.kNB.setVisibility(8);
                        }
                    });
                    return;
                } else if (this.kMj instanceof OfficialChatMessage) {
                    final OfficialChatMessage officialChatMessage = (OfficialChatMessage) this.kMj;
                    final LinkedList linkedList3 = new LinkedList();
                    linkedList3.add(new CommonMsgPojo(officialChatMessage));
                    af.b(new ae<Boolean>() { // from class: com.baidu.tieba.im.widget.chatVoiceView.ChatVoiceView.7
                        /* JADX DEBUG: Method merged with bridge method */
                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // com.baidu.tbadk.util.ae
                        public Boolean doInBackground() {
                            return Boolean.valueOf(l.cVQ().a(c.n(officialChatMessage), linkedList3, false));
                        }
                    }, new m<Boolean>() { // from class: com.baidu.tieba.im.widget.chatVoiceView.ChatVoiceView.8
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.tbadk.util.m
                        public void onReturnDataInUI(Boolean bool) {
                            ChatVoiceView.this.kNB.setVisibility(8);
                        }
                    });
                    return;
                } else {
                    return;
                }
            }
            return;
        }
        cYm();
        if (i == 1) {
            if (this.hgG != null) {
                this.hgG.setVisibility(0);
            }
            this.mProgress.setVisibility(4);
        } else if (i == 2) {
            if (this.hgG != null) {
                this.hgG.setVisibility(4);
            }
            this.mProgress.setVisibility(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        VoiceManager voiceManager;
        if (this.kNC == null || (voiceManager = getVoiceManager()) == null) {
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
        if (c.r(chatMessage)) {
            z = false;
        } else {
            VoiceMsgData u = c.u(chatMessage);
            if (u != null && u.getHas_read() == 1) {
                z = false;
            }
        }
        if (z) {
            this.kNB.setVisibility(0);
        } else {
            this.kNB.setVisibility(8);
        }
    }

    public void setData(ChatMessage chatMessage) {
        VoiceManager voiceManager;
        if (chatMessage != null && chatMessage.getCacheData() != null) {
            this.kNC = chatMessage.getCacheData().getVoice_model();
            if (this.kNC == null) {
                this.kNC = new VoiceData.VoiceModel();
            }
            this.kMj = chatMessage;
            this.kNA.setText(VoiceManager.formatVoiceTime(this.kNC.duration));
            this.kNA.setContentDescription(String.format(getContext().getString(R.string.editor_record_format), VoiceManager.formatVoiceTime(this.kNC.duration)));
            setBubbleLength(this.kNC.duration);
            setTag(this.kNC);
            z(chatMessage);
            if (this.kNC.voice_status.intValue() != 1 && (voiceManager = getVoiceManager()) != null) {
                voiceManager.resetPlayView(this);
            }
            Dp(this.kNC.voice_status.intValue());
        }
    }

    public void reset() {
        this.kNC = null;
        Dp(1);
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
            if (this.kND.getParent() != null && (this.kND.getParent() instanceof RelativeLayout)) {
                this.kND.setLayoutParams(new RelativeLayout.LayoutParams(i2, -2));
                return;
            }
            this.kND.setLayoutParams(new LinearLayout.LayoutParams(i2, -2));
        } catch (Exception e) {
        }
    }

    public boolean isPlaying() {
        return this.kNC != null && this.kNC.voice_status.intValue() == 3;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void rH() {
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void b(VoiceData.VoiceModel voiceModel) {
        if (voiceModel != null) {
            Dp(voiceModel.voice_status.intValue());
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void bj(int i) {
        Do(i);
        if (this.kNC != null) {
            this.kNC.elapse = i;
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void onShowErr(int i, String str) {
        com.baidu.adp.lib.util.l.showLongToast(getContext(), str);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceData.VoiceModel getVoiceModel() {
        return this.kNC;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceManager.b getRealView() {
        Context context = getContext();
        VoiceManager.b d = context instanceof VoiceManager.c ? ((VoiceManager.c) context).d(this.kNC) : this;
        return d == null ? this : d;
    }
}
