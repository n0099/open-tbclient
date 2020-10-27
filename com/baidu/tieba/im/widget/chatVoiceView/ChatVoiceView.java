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
import com.baidu.tbadk.util.ad;
import com.baidu.tbadk.util.ae;
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
    private ChatMessage kiW;
    private TextView kkA;
    private ImageView kkB;
    private VoiceData.VoiceModel kkC;
    private RelativeLayout kkD;
    private ImageView kky;
    private ImageView kkz;
    private ProgressBar mProgress;

    public ChatVoiceView(Context context) {
        super(context);
        this.kky = null;
        this.kkA = null;
        this.kkB = null;
        this.mProgress = null;
        LayoutInflater.from(context).inflate(R.layout.widget_left_voice_view, (ViewGroup) this, true);
        init();
    }

    public ChatVoiceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        boolean z;
        this.kky = null;
        this.kkA = null;
        this.kkB = null;
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
        this.kkD = (RelativeLayout) findViewById(R.id.lay_bubble);
        this.kky = (ImageView) findViewById(R.id.img_voice_status);
        this.kkz = (ImageView) findViewById(R.id.img_voice_status_anim);
        this.kkA = (TextView) findViewById(R.id.tex_voice_duration);
        this.kkB = (ImageView) findViewById(R.id.img_voice_readed);
        this.mProgress = (ProgressBar) findViewById(R.id.progress);
    }

    private void cTa() {
        this.kky.setVisibility(8);
        this.kkz.setVisibility(0);
        ((AnimationDrawable) this.kkz.getBackground()).start();
    }

    private void cTb() {
        ((AnimationDrawable) this.kkz.getBackground()).stop();
        this.kkz.clearAnimation();
        this.kky.setVisibility(0);
        this.kkz.setVisibility(8);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        try {
            cTb();
        } catch (Exception e) {
        }
    }

    public void Dl(int i) {
    }

    public void Dm(int i) {
        if (i == 3) {
            if (this.kky != null) {
                this.kky.setVisibility(0);
            }
            this.mProgress.setVisibility(4);
            cTa();
            VoiceMsgData u = e.u(this.kiW);
            if (u != null && u.getHas_read() != 1) {
                u.setHas_read(1);
                this.kiW.setContent("[" + OrmObject.jsonStrWithObject(u) + "]");
                if (this.kiW instanceof CommonGroupChatMessage) {
                    final CommonGroupChatMessage commonGroupChatMessage = (CommonGroupChatMessage) this.kiW;
                    final LinkedList linkedList = new LinkedList();
                    linkedList.add(new CommonMsgPojo(commonGroupChatMessage));
                    if (!commonGroupChatMessage.getGroupId().equals(String.valueOf(a.kiB))) {
                        ae.b(new ad<Boolean>() { // from class: com.baidu.tieba.im.widget.chatVoiceView.ChatVoiceView.1
                            /* JADX DEBUG: Method merged with bridge method */
                            /* JADX WARN: Can't rename method to resolve collision */
                            @Override // com.baidu.tbadk.util.ad
                            public Boolean doInBackground() {
                                return Boolean.valueOf(c.cOt().b(commonGroupChatMessage.getGroupId(), linkedList, false));
                            }
                        }, new m<Boolean>() { // from class: com.baidu.tieba.im.widget.chatVoiceView.ChatVoiceView.2
                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // com.baidu.tbadk.util.m
                            public void onReturnDataInUI(Boolean bool) {
                                ChatVoiceView.this.kkB.setVisibility(8);
                            }
                        });
                        return;
                    } else {
                        ae.b(new ad<Boolean>() { // from class: com.baidu.tieba.im.widget.chatVoiceView.ChatVoiceView.3
                            /* JADX DEBUG: Method merged with bridge method */
                            /* JADX WARN: Can't rename method to resolve collision */
                            @Override // com.baidu.tbadk.util.ad
                            public Boolean doInBackground() {
                                return Boolean.valueOf(com.baidu.tieba.im.db.m.cON().a(e.n(commonGroupChatMessage), linkedList, false));
                            }
                        }, new m<Boolean>() { // from class: com.baidu.tieba.im.widget.chatVoiceView.ChatVoiceView.4
                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // com.baidu.tbadk.util.m
                            public void onReturnDataInUI(Boolean bool) {
                                ChatVoiceView.this.kkB.setVisibility(8);
                            }
                        });
                        return;
                    }
                } else if (this.kiW instanceof PersonalChatMessage) {
                    final PersonalChatMessage personalChatMessage = (PersonalChatMessage) this.kiW;
                    final LinkedList linkedList2 = new LinkedList();
                    linkedList2.add(new CommonMsgPojo(personalChatMessage));
                    ae.b(new ad<Boolean>() { // from class: com.baidu.tieba.im.widget.chatVoiceView.ChatVoiceView.5
                        /* JADX DEBUG: Method merged with bridge method */
                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // com.baidu.tbadk.util.ad
                        public Boolean doInBackground() {
                            return Boolean.valueOf(com.baidu.tieba.im.db.m.cON().a(e.n(personalChatMessage), linkedList2, false));
                        }
                    }, new m<Boolean>() { // from class: com.baidu.tieba.im.widget.chatVoiceView.ChatVoiceView.6
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.tbadk.util.m
                        public void onReturnDataInUI(Boolean bool) {
                            ChatVoiceView.this.kkB.setVisibility(8);
                        }
                    });
                    return;
                } else if (this.kiW instanceof OfficialChatMessage) {
                    final OfficialChatMessage officialChatMessage = (OfficialChatMessage) this.kiW;
                    final LinkedList linkedList3 = new LinkedList();
                    linkedList3.add(new CommonMsgPojo(officialChatMessage));
                    ae.b(new ad<Boolean>() { // from class: com.baidu.tieba.im.widget.chatVoiceView.ChatVoiceView.7
                        /* JADX DEBUG: Method merged with bridge method */
                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // com.baidu.tbadk.util.ad
                        public Boolean doInBackground() {
                            return Boolean.valueOf(l.cOK().a(e.n(officialChatMessage), linkedList3, false));
                        }
                    }, new m<Boolean>() { // from class: com.baidu.tieba.im.widget.chatVoiceView.ChatVoiceView.8
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.tbadk.util.m
                        public void onReturnDataInUI(Boolean bool) {
                            ChatVoiceView.this.kkB.setVisibility(8);
                        }
                    });
                    return;
                } else {
                    return;
                }
            }
            return;
        }
        cTb();
        if (i == 1) {
            if (this.kky != null) {
                this.kky.setVisibility(0);
            }
            this.mProgress.setVisibility(4);
        } else if (i == 2) {
            if (this.kky != null) {
                this.kky.setVisibility(4);
            }
            this.mProgress.setVisibility(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        VoiceManager voiceManager;
        if (this.kkC == null || (voiceManager = getVoiceManager()) == null) {
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
            this.kkB.setVisibility(0);
        } else {
            this.kkB.setVisibility(8);
        }
    }

    public void setData(ChatMessage chatMessage) {
        VoiceManager voiceManager;
        if (chatMessage != null && chatMessage.getCacheData() != null) {
            this.kkC = chatMessage.getCacheData().getVoice_model();
            if (this.kkC == null) {
                this.kkC = new VoiceData.VoiceModel();
            }
            this.kiW = chatMessage;
            this.kkA.setText(VoiceManager.formatVoiceTime(this.kkC.duration));
            this.kkA.setContentDescription(String.format(getContext().getString(R.string.editor_record_format), VoiceManager.formatVoiceTime(this.kkC.duration)));
            setBubbleLength(this.kkC.duration);
            setTag(this.kkC);
            z(chatMessage);
            if (this.kkC.voice_status.intValue() != 1 && (voiceManager = getVoiceManager()) != null) {
                voiceManager.resetPlayView(this);
            }
            Dm(this.kkC.voice_status.intValue());
        }
    }

    public void reset() {
        this.kkC = null;
        Dm(1);
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
            if (this.kkD.getParent() != null && (this.kkD.getParent() instanceof RelativeLayout)) {
                this.kkD.setLayoutParams(new RelativeLayout.LayoutParams(i2, -2));
                return;
            }
            this.kkD.setLayoutParams(new LinearLayout.LayoutParams(i2, -2));
        } catch (Exception e) {
        }
    }

    public boolean isPlaying() {
        return this.kkC != null && this.kkC.voice_status.intValue() == 3;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void sg() {
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void b(VoiceData.VoiceModel voiceModel) {
        if (voiceModel != null) {
            Dm(voiceModel.voice_status.intValue());
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void bf(int i) {
        Dl(i);
        if (this.kkC != null) {
            this.kkC.elapse = i;
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void onShowErr(int i, String str) {
        com.baidu.adp.lib.util.l.showLongToast(getContext(), str);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceData.VoiceModel getVoiceModel() {
        return this.kkC;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceManager.b getRealView() {
        Context context = getContext();
        VoiceManager.b d = context instanceof VoiceManager.c ? ((VoiceManager.c) context).d(this.kkC) : this;
        return d == null ? this : d;
    }
}
