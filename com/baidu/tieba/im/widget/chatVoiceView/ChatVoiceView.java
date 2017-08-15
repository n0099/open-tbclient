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
    private ChatMessage dAu;
    private ImageView dBZ;
    private ImageView dCa;
    private TextView dCb;
    private ImageView dCc;
    private VoiceData.VoiceModel dCd;
    private RelativeLayout dCe;
    private ProgressBar mProgress;

    public ChatVoiceView(Context context) {
        super(context);
        this.dBZ = null;
        this.dCb = null;
        this.dCc = null;
        this.mProgress = null;
        LayoutInflater.from(context).inflate(d.j.widget_left_voice_view, (ViewGroup) this, true);
        init();
    }

    public ChatVoiceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        boolean z;
        this.dBZ = null;
        this.dCb = null;
        this.dCc = null;
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
        this.dCe = (RelativeLayout) findViewById(d.h.lay_bubble);
        this.dBZ = (ImageView) findViewById(d.h.img_voice_status);
        this.dCa = (ImageView) findViewById(d.h.img_voice_status_anim);
        this.dCb = (TextView) findViewById(d.h.tex_voice_duration);
        this.dCc = (ImageView) findViewById(d.h.img_voice_readed);
        this.mProgress = (ProgressBar) findViewById(d.h.progress);
    }

    private void ayV() {
        this.dBZ.setVisibility(8);
        this.dCa.setVisibility(0);
        ((AnimationDrawable) this.dCa.getBackground()).start();
    }

    private void ayW() {
        ((AnimationDrawable) this.dCa.getBackground()).stop();
        this.dCa.clearAnimation();
        this.dBZ.setVisibility(0);
        this.dCa.setVisibility(8);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        try {
            ayW();
        } catch (Exception e) {
        }
    }

    public void mP(int i) {
    }

    public void mQ(int i) {
        if (i == 3) {
            if (this.dBZ != null) {
                this.dBZ.setVisibility(0);
            }
            this.mProgress.setVisibility(4);
            ayV();
            VoiceMsgData x = e.x(this.dAu);
            if (x != null && x.getHas_read() != 1) {
                x.setHas_read(1);
                this.dAu.setContent("[" + OrmObject.jsonStrWithObject(x) + "]");
                if (this.dAu instanceof CommonGroupChatMessage) {
                    final CommonGroupChatMessage commonGroupChatMessage = (CommonGroupChatMessage) this.dAu;
                    final LinkedList linkedList = new LinkedList();
                    linkedList.add(new CommonMsgPojo(commonGroupChatMessage));
                    if (!commonGroupChatMessage.getGroupId().equals(String.valueOf(a.dzW))) {
                        u.b(new t<Boolean>() { // from class: com.baidu.tieba.im.widget.chatVoiceView.ChatVoiceView.1
                            /* JADX DEBUG: Method merged with bridge method */
                            /* JADX WARN: Can't rename method to resolve collision */
                            @Override // com.baidu.tbadk.util.t
                            public Boolean doInBackground() {
                                return Boolean.valueOf(c.auy().b(commonGroupChatMessage.getGroupId(), linkedList, false));
                            }
                        }, new h<Boolean>() { // from class: com.baidu.tieba.im.widget.chatVoiceView.ChatVoiceView.2
                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // com.baidu.tbadk.util.h
                            public void onReturnDataInUI(Boolean bool) {
                                ChatVoiceView.this.dCc.setVisibility(8);
                            }
                        });
                        return;
                    } else {
                        u.b(new t<Boolean>() { // from class: com.baidu.tieba.im.widget.chatVoiceView.ChatVoiceView.3
                            /* JADX DEBUG: Method merged with bridge method */
                            /* JADX WARN: Can't rename method to resolve collision */
                            @Override // com.baidu.tbadk.util.t
                            public Boolean doInBackground() {
                                return Boolean.valueOf(l.auL().a(e.q(commonGroupChatMessage), linkedList, false));
                            }
                        }, new h<Boolean>() { // from class: com.baidu.tieba.im.widget.chatVoiceView.ChatVoiceView.4
                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // com.baidu.tbadk.util.h
                            public void onReturnDataInUI(Boolean bool) {
                                ChatVoiceView.this.dCc.setVisibility(8);
                            }
                        });
                        return;
                    }
                } else if (this.dAu instanceof PersonalChatMessage) {
                    final PersonalChatMessage personalChatMessage = (PersonalChatMessage) this.dAu;
                    final LinkedList linkedList2 = new LinkedList();
                    linkedList2.add(new CommonMsgPojo(personalChatMessage));
                    u.b(new t<Boolean>() { // from class: com.baidu.tieba.im.widget.chatVoiceView.ChatVoiceView.5
                        /* JADX DEBUG: Method merged with bridge method */
                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // com.baidu.tbadk.util.t
                        public Boolean doInBackground() {
                            return Boolean.valueOf(l.auL().a(e.q(personalChatMessage), linkedList2, false));
                        }
                    }, new h<Boolean>() { // from class: com.baidu.tieba.im.widget.chatVoiceView.ChatVoiceView.6
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.tbadk.util.h
                        public void onReturnDataInUI(Boolean bool) {
                            ChatVoiceView.this.dCc.setVisibility(8);
                        }
                    });
                    return;
                } else if (this.dAu instanceof OfficialChatMessage) {
                    final OfficialChatMessage officialChatMessage = (OfficialChatMessage) this.dAu;
                    final LinkedList linkedList3 = new LinkedList();
                    linkedList3.add(new CommonMsgPojo(officialChatMessage));
                    u.b(new t<Boolean>() { // from class: com.baidu.tieba.im.widget.chatVoiceView.ChatVoiceView.7
                        /* JADX DEBUG: Method merged with bridge method */
                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // com.baidu.tbadk.util.t
                        public Boolean doInBackground() {
                            return Boolean.valueOf(k.auK().a(e.q(officialChatMessage), linkedList3, false));
                        }
                    }, new h<Boolean>() { // from class: com.baidu.tieba.im.widget.chatVoiceView.ChatVoiceView.8
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.tbadk.util.h
                        public void onReturnDataInUI(Boolean bool) {
                            ChatVoiceView.this.dCc.setVisibility(8);
                        }
                    });
                    return;
                } else {
                    return;
                }
            }
            return;
        }
        ayW();
        if (i == 1) {
            if (this.dBZ != null) {
                this.dBZ.setVisibility(0);
            }
            this.mProgress.setVisibility(4);
        } else if (i == 2) {
            if (this.dBZ != null) {
                this.dBZ.setVisibility(4);
            }
            this.mProgress.setVisibility(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        VoiceManager voiceManager;
        if (this.dCd == null || (voiceManager = getVoiceManager()) == null) {
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
            this.dCc.setVisibility(0);
        } else {
            this.dCc.setVisibility(8);
        }
    }

    public void setData(ChatMessage chatMessage) {
        VoiceManager voiceManager;
        if (chatMessage != null && chatMessage.getCacheData() != null) {
            this.dCd = chatMessage.getCacheData().getVoice_model();
            if (this.dCd == null) {
                this.dCd = new VoiceData.VoiceModel();
            }
            this.dAu = chatMessage;
            this.dCb.setText(VoiceManager.formatVoiceTime(this.dCd.duration));
            this.dCb.setContentDescription(String.format(getContext().getString(d.l.editor_record_format), VoiceManager.formatVoiceTime(this.dCd.duration)));
            setBubbleLength(this.dCd.duration);
            setTag(this.dCd);
            C(chatMessage);
            if (this.dCd.voice_status.intValue() != 1 && (voiceManager = getVoiceManager()) != null) {
                voiceManager.resetPlayView(this);
            }
            mQ(this.dCd.voice_status.intValue());
        }
    }

    public void reset() {
        this.dCd = null;
        mQ(1);
    }

    private void setBubbleLength(int i) {
        int i2;
        int ag = com.baidu.adp.lib.util.k.ag(getContext());
        if (i <= 10) {
            int i3 = (int) (ag * 0.1875d);
            i2 = (((((int) (ag * 0.4125d)) - i3) * (i - 1)) / 10) + i3;
        } else if (i <= 30) {
            int i4 = (int) (ag * 0.4125d);
            i2 = (((((int) (ag * 0.5375d)) - i4) * (i - 10)) / 20) + i4;
        } else {
            i2 = (int) (ag * 0.5375d);
        }
        try {
            if (this.dCe.getParent() != null && (this.dCe.getParent() instanceof RelativeLayout)) {
                this.dCe.setLayoutParams(new RelativeLayout.LayoutParams(i2, -2));
                return;
            }
            this.dCe.setLayoutParams(new LinearLayout.LayoutParams(i2, -2));
        } catch (Exception e) {
        }
    }

    public boolean isPlaying() {
        return this.dCd != null && this.dCd.voice_status.intValue() == 3;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void ma() {
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void b(VoiceData.VoiceModel voiceModel) {
        if (voiceModel != null) {
            mQ(voiceModel.voice_status.intValue());
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void aQ(int i) {
        mP(i);
        if (this.dCd != null) {
            this.dCd.elapse = i;
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void onShowErr(int i, String str) {
        com.baidu.adp.lib.util.k.F(getContext(), str);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceData.VoiceModel getVoiceModel() {
        return this.dCd;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceManager.b getRealView() {
        Context context = getContext();
        VoiceManager.b c = context instanceof VoiceManager.c ? ((VoiceManager.c) context).c(this.dCd) : this;
        return c == null ? this : c;
    }
}
