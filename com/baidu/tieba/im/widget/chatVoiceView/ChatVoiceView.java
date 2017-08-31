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
import com.baidu.tbadk.util.t;
import com.baidu.tbadk.util.u;
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
    private ChatMessage dGX;
    private ImageView dID;
    private ImageView dIE;
    private TextView dIF;
    private ImageView dIG;
    private VoiceData.VoiceModel dIH;
    private RelativeLayout dII;
    private ProgressBar mProgress;

    public ChatVoiceView(Context context) {
        super(context);
        this.dID = null;
        this.dIF = null;
        this.dIG = null;
        this.mProgress = null;
        LayoutInflater.from(context).inflate(d.j.widget_left_voice_view, (ViewGroup) this, true);
        init();
    }

    public ChatVoiceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        boolean z;
        this.dID = null;
        this.dIF = null;
        this.dIG = null;
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
        this.dII = (RelativeLayout) findViewById(d.h.lay_bubble);
        this.dID = (ImageView) findViewById(d.h.img_voice_status);
        this.dIE = (ImageView) findViewById(d.h.img_voice_status_anim);
        this.dIF = (TextView) findViewById(d.h.tex_voice_duration);
        this.dIG = (ImageView) findViewById(d.h.img_voice_readed);
        this.mProgress = (ProgressBar) findViewById(d.h.progress);
    }

    private void aAF() {
        this.dID.setVisibility(8);
        this.dIE.setVisibility(0);
        ((AnimationDrawable) this.dIE.getBackground()).start();
    }

    private void aAG() {
        ((AnimationDrawable) this.dIE.getBackground()).stop();
        this.dIE.clearAnimation();
        this.dID.setVisibility(0);
        this.dIE.setVisibility(8);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        try {
            aAG();
        } catch (Exception e) {
        }
    }

    public void ni(int i) {
    }

    public void nj(int i) {
        if (i == 3) {
            if (this.dID != null) {
                this.dID.setVisibility(0);
            }
            this.mProgress.setVisibility(4);
            aAF();
            VoiceMsgData x = e.x(this.dGX);
            if (x != null && x.getHas_read() != 1) {
                x.setHas_read(1);
                this.dGX.setContent("[" + OrmObject.jsonStrWithObject(x) + "]");
                if (this.dGX instanceof CommonGroupChatMessage) {
                    final CommonGroupChatMessage commonGroupChatMessage = (CommonGroupChatMessage) this.dGX;
                    final LinkedList linkedList = new LinkedList();
                    linkedList.add(new CommonMsgPojo(commonGroupChatMessage));
                    if (!commonGroupChatMessage.getGroupId().equals(String.valueOf(a.dGz))) {
                        u.b(new t<Boolean>() { // from class: com.baidu.tieba.im.widget.chatVoiceView.ChatVoiceView.1
                            /* JADX DEBUG: Method merged with bridge method */
                            /* JADX WARN: Can't rename method to resolve collision */
                            @Override // com.baidu.tbadk.util.t
                            public Boolean doInBackground() {
                                return Boolean.valueOf(c.awf().b(commonGroupChatMessage.getGroupId(), linkedList, false));
                            }
                        }, new h<Boolean>() { // from class: com.baidu.tieba.im.widget.chatVoiceView.ChatVoiceView.2
                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // com.baidu.tbadk.util.h
                            public void onReturnDataInUI(Boolean bool) {
                                ChatVoiceView.this.dIG.setVisibility(8);
                            }
                        });
                        return;
                    } else {
                        u.b(new t<Boolean>() { // from class: com.baidu.tieba.im.widget.chatVoiceView.ChatVoiceView.3
                            /* JADX DEBUG: Method merged with bridge method */
                            /* JADX WARN: Can't rename method to resolve collision */
                            @Override // com.baidu.tbadk.util.t
                            public Boolean doInBackground() {
                                return Boolean.valueOf(l.awt().a(e.q(commonGroupChatMessage), linkedList, false));
                            }
                        }, new h<Boolean>() { // from class: com.baidu.tieba.im.widget.chatVoiceView.ChatVoiceView.4
                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // com.baidu.tbadk.util.h
                            public void onReturnDataInUI(Boolean bool) {
                                ChatVoiceView.this.dIG.setVisibility(8);
                            }
                        });
                        return;
                    }
                } else if (this.dGX instanceof PersonalChatMessage) {
                    final PersonalChatMessage personalChatMessage = (PersonalChatMessage) this.dGX;
                    final LinkedList linkedList2 = new LinkedList();
                    linkedList2.add(new CommonMsgPojo(personalChatMessage));
                    u.b(new t<Boolean>() { // from class: com.baidu.tieba.im.widget.chatVoiceView.ChatVoiceView.5
                        /* JADX DEBUG: Method merged with bridge method */
                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // com.baidu.tbadk.util.t
                        public Boolean doInBackground() {
                            return Boolean.valueOf(l.awt().a(e.q(personalChatMessage), linkedList2, false));
                        }
                    }, new h<Boolean>() { // from class: com.baidu.tieba.im.widget.chatVoiceView.ChatVoiceView.6
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.tbadk.util.h
                        public void onReturnDataInUI(Boolean bool) {
                            ChatVoiceView.this.dIG.setVisibility(8);
                        }
                    });
                    return;
                } else if (this.dGX instanceof OfficialChatMessage) {
                    final OfficialChatMessage officialChatMessage = (OfficialChatMessage) this.dGX;
                    final LinkedList linkedList3 = new LinkedList();
                    linkedList3.add(new CommonMsgPojo(officialChatMessage));
                    u.b(new t<Boolean>() { // from class: com.baidu.tieba.im.widget.chatVoiceView.ChatVoiceView.7
                        /* JADX DEBUG: Method merged with bridge method */
                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // com.baidu.tbadk.util.t
                        public Boolean doInBackground() {
                            return Boolean.valueOf(k.aws().a(e.q(officialChatMessage), linkedList3, false));
                        }
                    }, new h<Boolean>() { // from class: com.baidu.tieba.im.widget.chatVoiceView.ChatVoiceView.8
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.tbadk.util.h
                        public void onReturnDataInUI(Boolean bool) {
                            ChatVoiceView.this.dIG.setVisibility(8);
                        }
                    });
                    return;
                } else {
                    return;
                }
            }
            return;
        }
        aAG();
        if (i == 1) {
            if (this.dID != null) {
                this.dID.setVisibility(0);
            }
            this.mProgress.setVisibility(4);
        } else if (i == 2) {
            if (this.dID != null) {
                this.dID.setVisibility(4);
            }
            this.mProgress.setVisibility(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        VoiceManager voiceManager;
        if (this.dIH == null || (voiceManager = getVoiceManager()) == null) {
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
            this.dIG.setVisibility(0);
        } else {
            this.dIG.setVisibility(8);
        }
    }

    public void setData(ChatMessage chatMessage) {
        VoiceManager voiceManager;
        if (chatMessage != null && chatMessage.getCacheData() != null) {
            this.dIH = chatMessage.getCacheData().getVoice_model();
            if (this.dIH == null) {
                this.dIH = new VoiceData.VoiceModel();
            }
            this.dGX = chatMessage;
            this.dIF.setText(VoiceManager.formatVoiceTime(this.dIH.duration));
            this.dIF.setContentDescription(String.format(getContext().getString(d.l.editor_record_format), VoiceManager.formatVoiceTime(this.dIH.duration)));
            setBubbleLength(this.dIH.duration);
            setTag(this.dIH);
            C(chatMessage);
            if (this.dIH.voice_status.intValue() != 1 && (voiceManager = getVoiceManager()) != null) {
                voiceManager.resetPlayView(this);
            }
            nj(this.dIH.voice_status.intValue());
        }
    }

    public void reset() {
        this.dIH = null;
        nj(1);
    }

    private void setBubbleLength(int i) {
        int i2;
        int ad = com.baidu.adp.lib.util.k.ad(getContext());
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
            if (this.dII.getParent() != null && (this.dII.getParent() instanceof RelativeLayout)) {
                this.dII.setLayoutParams(new RelativeLayout.LayoutParams(i2, -2));
                return;
            }
            this.dII.setLayoutParams(new LinearLayout.LayoutParams(i2, -2));
        } catch (Exception e) {
        }
    }

    public boolean isPlaying() {
        return this.dIH != null && this.dIH.voice_status.intValue() == 3;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void lR() {
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void b(VoiceData.VoiceModel voiceModel) {
        if (voiceModel != null) {
            nj(voiceModel.voice_status.intValue());
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void aO(int i) {
        ni(i);
        if (this.dIH != null) {
            this.dIH.elapse = i;
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void onShowErr(int i, String str) {
        com.baidu.adp.lib.util.k.F(getContext(), str);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceData.VoiceModel getVoiceModel() {
        return this.dIH;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceManager.b getRealView() {
        Context context = getContext();
        VoiceManager.b c = context instanceof VoiceManager.c ? ((VoiceManager.c) context).c(this.dIH) : this;
        return c == null ? this : c;
    }
}
