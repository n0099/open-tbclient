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
    private ChatMessage jjS;
    private ImageView jlu;
    private ImageView jlv;
    private TextView jlw;
    private ImageView jlx;
    private VoiceData.VoiceModel jly;
    private RelativeLayout jlz;
    private ProgressBar mProgress;

    public ChatVoiceView(Context context) {
        super(context);
        this.jlu = null;
        this.jlw = null;
        this.jlx = null;
        this.mProgress = null;
        LayoutInflater.from(context).inflate(R.layout.widget_left_voice_view, (ViewGroup) this, true);
        init();
    }

    public ChatVoiceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        boolean z;
        this.jlu = null;
        this.jlw = null;
        this.jlx = null;
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
        this.jlz = (RelativeLayout) findViewById(R.id.lay_bubble);
        this.jlu = (ImageView) findViewById(R.id.img_voice_status);
        this.jlv = (ImageView) findViewById(R.id.img_voice_status_anim);
        this.jlw = (TextView) findViewById(R.id.tex_voice_duration);
        this.jlx = (ImageView) findViewById(R.id.img_voice_readed);
        this.mProgress = (ProgressBar) findViewById(R.id.progress);
    }

    private void cxN() {
        this.jlu.setVisibility(8);
        this.jlv.setVisibility(0);
        ((AnimationDrawable) this.jlv.getBackground()).start();
    }

    private void cxO() {
        ((AnimationDrawable) this.jlv.getBackground()).stop();
        this.jlv.clearAnimation();
        this.jlu.setVisibility(0);
        this.jlv.setVisibility(8);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        try {
            cxO();
        } catch (Exception e) {
        }
    }

    public void zs(int i) {
    }

    public void zt(int i) {
        if (i == 3) {
            if (this.jlu != null) {
                this.jlu.setVisibility(0);
            }
            this.mProgress.setVisibility(4);
            cxN();
            VoiceMsgData u = e.u(this.jjS);
            if (u != null && u.getHas_read() != 1) {
                u.setHas_read(1);
                this.jjS.setContent("[" + OrmObject.jsonStrWithObject(u) + "]");
                if (this.jjS instanceof CommonGroupChatMessage) {
                    final CommonGroupChatMessage commonGroupChatMessage = (CommonGroupChatMessage) this.jjS;
                    final LinkedList linkedList = new LinkedList();
                    linkedList.add(new CommonMsgPojo(commonGroupChatMessage));
                    if (!commonGroupChatMessage.getGroupId().equals(String.valueOf(a.jjw))) {
                        ad.b(new ac<Boolean>() { // from class: com.baidu.tieba.im.widget.chatVoiceView.ChatVoiceView.1
                            /* JADX DEBUG: Method merged with bridge method */
                            /* JADX WARN: Can't rename method to resolve collision */
                            @Override // com.baidu.tbadk.util.ac
                            public Boolean doInBackground() {
                                return Boolean.valueOf(c.ctf().a(commonGroupChatMessage.getGroupId(), linkedList, false));
                            }
                        }, new l<Boolean>() { // from class: com.baidu.tieba.im.widget.chatVoiceView.ChatVoiceView.2
                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // com.baidu.tbadk.util.l
                            public void onReturnDataInUI(Boolean bool) {
                                ChatVoiceView.this.jlx.setVisibility(8);
                            }
                        });
                        return;
                    } else {
                        ad.b(new ac<Boolean>() { // from class: com.baidu.tieba.im.widget.chatVoiceView.ChatVoiceView.3
                            /* JADX DEBUG: Method merged with bridge method */
                            /* JADX WARN: Can't rename method to resolve collision */
                            @Override // com.baidu.tbadk.util.ac
                            public Boolean doInBackground() {
                                return Boolean.valueOf(m.ctz().a(e.n(commonGroupChatMessage), linkedList, false));
                            }
                        }, new l<Boolean>() { // from class: com.baidu.tieba.im.widget.chatVoiceView.ChatVoiceView.4
                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // com.baidu.tbadk.util.l
                            public void onReturnDataInUI(Boolean bool) {
                                ChatVoiceView.this.jlx.setVisibility(8);
                            }
                        });
                        return;
                    }
                } else if (this.jjS instanceof PersonalChatMessage) {
                    final PersonalChatMessage personalChatMessage = (PersonalChatMessage) this.jjS;
                    final LinkedList linkedList2 = new LinkedList();
                    linkedList2.add(new CommonMsgPojo(personalChatMessage));
                    ad.b(new ac<Boolean>() { // from class: com.baidu.tieba.im.widget.chatVoiceView.ChatVoiceView.5
                        /* JADX DEBUG: Method merged with bridge method */
                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // com.baidu.tbadk.util.ac
                        public Boolean doInBackground() {
                            return Boolean.valueOf(m.ctz().a(e.n(personalChatMessage), linkedList2, false));
                        }
                    }, new l<Boolean>() { // from class: com.baidu.tieba.im.widget.chatVoiceView.ChatVoiceView.6
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.tbadk.util.l
                        public void onReturnDataInUI(Boolean bool) {
                            ChatVoiceView.this.jlx.setVisibility(8);
                        }
                    });
                    return;
                } else if (this.jjS instanceof OfficialChatMessage) {
                    final OfficialChatMessage officialChatMessage = (OfficialChatMessage) this.jjS;
                    final LinkedList linkedList3 = new LinkedList();
                    linkedList3.add(new CommonMsgPojo(officialChatMessage));
                    ad.b(new ac<Boolean>() { // from class: com.baidu.tieba.im.widget.chatVoiceView.ChatVoiceView.7
                        /* JADX DEBUG: Method merged with bridge method */
                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // com.baidu.tbadk.util.ac
                        public Boolean doInBackground() {
                            return Boolean.valueOf(com.baidu.tieba.im.db.l.ctw().a(e.n(officialChatMessage), linkedList3, false));
                        }
                    }, new l<Boolean>() { // from class: com.baidu.tieba.im.widget.chatVoiceView.ChatVoiceView.8
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.tbadk.util.l
                        public void onReturnDataInUI(Boolean bool) {
                            ChatVoiceView.this.jlx.setVisibility(8);
                        }
                    });
                    return;
                } else {
                    return;
                }
            }
            return;
        }
        cxO();
        if (i == 1) {
            if (this.jlu != null) {
                this.jlu.setVisibility(0);
            }
            this.mProgress.setVisibility(4);
        } else if (i == 2) {
            if (this.jlu != null) {
                this.jlu.setVisibility(4);
            }
            this.mProgress.setVisibility(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        VoiceManager voiceManager;
        if (this.jly == null || (voiceManager = getVoiceManager()) == null) {
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
            this.jlx.setVisibility(0);
        } else {
            this.jlx.setVisibility(8);
        }
    }

    public void setData(ChatMessage chatMessage) {
        VoiceManager voiceManager;
        if (chatMessage != null && chatMessage.getCacheData() != null) {
            this.jly = chatMessage.getCacheData().getVoice_model();
            if (this.jly == null) {
                this.jly = new VoiceData.VoiceModel();
            }
            this.jjS = chatMessage;
            this.jlw.setText(VoiceManager.formatVoiceTime(this.jly.duration));
            this.jlw.setContentDescription(String.format(getContext().getString(R.string.editor_record_format), VoiceManager.formatVoiceTime(this.jly.duration)));
            setBubbleLength(this.jly.duration);
            setTag(this.jly);
            z(chatMessage);
            if (this.jly.voice_status.intValue() != 1 && (voiceManager = getVoiceManager()) != null) {
                voiceManager.resetPlayView(this);
            }
            zt(this.jly.voice_status.intValue());
        }
    }

    public void reset() {
        this.jly = null;
        zt(1);
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
            if (this.jlz.getParent() != null && (this.jlz.getParent() instanceof RelativeLayout)) {
                this.jlz.setLayoutParams(new RelativeLayout.LayoutParams(i2, -2));
                return;
            }
            this.jlz.setLayoutParams(new LinearLayout.LayoutParams(i2, -2));
        } catch (Exception e) {
        }
    }

    public boolean isPlaying() {
        return this.jly != null && this.jly.voice_status.intValue() == 3;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void qC() {
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void b(VoiceData.VoiceModel voiceModel) {
        if (voiceModel != null) {
            zt(voiceModel.voice_status.intValue());
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void aY(int i) {
        zs(i);
        if (this.jly != null) {
            this.jly.elapse = i;
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void onShowErr(int i, String str) {
        com.baidu.adp.lib.util.l.showLongToast(getContext(), str);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceData.VoiceModel getVoiceModel() {
        return this.jly;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceManager.b getRealView() {
        Context context = getContext();
        VoiceManager.b d = context instanceof VoiceManager.c ? ((VoiceManager.c) context).d(this.jly) : this;
        return d == null ? this : d;
    }
}
