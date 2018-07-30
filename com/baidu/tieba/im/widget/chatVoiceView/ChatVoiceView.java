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
import com.baidu.tbadk.util.g;
import com.baidu.tbadk.util.u;
import com.baidu.tbadk.util.v;
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
    private ChatMessage eBO;
    private ImageView eDq;
    private ImageView eDr;
    private TextView eDs;
    private ImageView eDt;
    private VoiceData.VoiceModel eDu;
    private RelativeLayout eDv;
    private ProgressBar mProgress;

    public ChatVoiceView(Context context) {
        super(context);
        this.eDq = null;
        this.eDs = null;
        this.eDt = null;
        this.mProgress = null;
        LayoutInflater.from(context).inflate(d.h.widget_left_voice_view, (ViewGroup) this, true);
        init();
    }

    public ChatVoiceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        boolean z;
        this.eDq = null;
        this.eDs = null;
        this.eDt = null;
        this.mProgress = null;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.l.ChatVoiceView, 0, 0);
        if (obtainStyledAttributes != null) {
            z = obtainStyledAttributes.getBoolean(d.l.ChatVoiceView_is_left, true);
            obtainStyledAttributes.recycle();
        } else {
            z = true;
        }
        if (z) {
            LayoutInflater.from(context).inflate(d.h.widget_left_voice_view, (ViewGroup) this, true);
        } else {
            LayoutInflater.from(context).inflate(d.h.widget_right_voice_view, (ViewGroup) this, true);
        }
        init();
    }

    private void init() {
        this.eDv = (RelativeLayout) findViewById(d.g.lay_bubble);
        this.eDq = (ImageView) findViewById(d.g.img_voice_status);
        this.eDr = (ImageView) findViewById(d.g.img_voice_status_anim);
        this.eDs = (TextView) findViewById(d.g.tex_voice_duration);
        this.eDt = (ImageView) findViewById(d.g.img_voice_readed);
        this.mProgress = (ProgressBar) findViewById(d.g.progress);
    }

    private void aNQ() {
        this.eDq.setVisibility(8);
        this.eDr.setVisibility(0);
        ((AnimationDrawable) this.eDr.getBackground()).start();
    }

    private void aNR() {
        ((AnimationDrawable) this.eDr.getBackground()).stop();
        this.eDr.clearAnimation();
        this.eDq.setVisibility(0);
        this.eDr.setVisibility(8);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        try {
            aNR();
        } catch (Exception e) {
        }
    }

    public void oG(int i) {
    }

    public void oH(int i) {
        if (i == 3) {
            if (this.eDq != null) {
                this.eDq.setVisibility(0);
            }
            this.mProgress.setVisibility(4);
            aNQ();
            VoiceMsgData z = e.z(this.eBO);
            if (z != null && z.getHas_read() != 1) {
                z.setHas_read(1);
                this.eBO.setContent("[" + OrmObject.jsonStrWithObject(z) + "]");
                if (this.eBO instanceof CommonGroupChatMessage) {
                    final CommonGroupChatMessage commonGroupChatMessage = (CommonGroupChatMessage) this.eBO;
                    final LinkedList linkedList = new LinkedList();
                    linkedList.add(new CommonMsgPojo(commonGroupChatMessage));
                    if (!commonGroupChatMessage.getGroupId().equals(String.valueOf(a.eBq))) {
                        v.b(new u<Boolean>() { // from class: com.baidu.tieba.im.widget.chatVoiceView.ChatVoiceView.1
                            /* JADX DEBUG: Method merged with bridge method */
                            /* JADX WARN: Can't rename method to resolve collision */
                            @Override // com.baidu.tbadk.util.u
                            public Boolean doInBackground() {
                                return Boolean.valueOf(c.aJz().a(commonGroupChatMessage.getGroupId(), linkedList, false));
                            }
                        }, new g<Boolean>() { // from class: com.baidu.tieba.im.widget.chatVoiceView.ChatVoiceView.2
                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // com.baidu.tbadk.util.g
                            public void onReturnDataInUI(Boolean bool) {
                                ChatVoiceView.this.eDt.setVisibility(8);
                            }
                        });
                        return;
                    } else {
                        v.b(new u<Boolean>() { // from class: com.baidu.tieba.im.widget.chatVoiceView.ChatVoiceView.3
                            /* JADX DEBUG: Method merged with bridge method */
                            /* JADX WARN: Can't rename method to resolve collision */
                            @Override // com.baidu.tbadk.util.u
                            public Boolean doInBackground() {
                                return Boolean.valueOf(m.aJR().a(e.s(commonGroupChatMessage), linkedList, false));
                            }
                        }, new g<Boolean>() { // from class: com.baidu.tieba.im.widget.chatVoiceView.ChatVoiceView.4
                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // com.baidu.tbadk.util.g
                            public void onReturnDataInUI(Boolean bool) {
                                ChatVoiceView.this.eDt.setVisibility(8);
                            }
                        });
                        return;
                    }
                } else if (this.eBO instanceof PersonalChatMessage) {
                    final PersonalChatMessage personalChatMessage = (PersonalChatMessage) this.eBO;
                    final LinkedList linkedList2 = new LinkedList();
                    linkedList2.add(new CommonMsgPojo(personalChatMessage));
                    v.b(new u<Boolean>() { // from class: com.baidu.tieba.im.widget.chatVoiceView.ChatVoiceView.5
                        /* JADX DEBUG: Method merged with bridge method */
                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // com.baidu.tbadk.util.u
                        public Boolean doInBackground() {
                            return Boolean.valueOf(m.aJR().a(e.s(personalChatMessage), linkedList2, false));
                        }
                    }, new g<Boolean>() { // from class: com.baidu.tieba.im.widget.chatVoiceView.ChatVoiceView.6
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.tbadk.util.g
                        public void onReturnDataInUI(Boolean bool) {
                            ChatVoiceView.this.eDt.setVisibility(8);
                        }
                    });
                    return;
                } else if (this.eBO instanceof OfficialChatMessage) {
                    final OfficialChatMessage officialChatMessage = (OfficialChatMessage) this.eBO;
                    final LinkedList linkedList3 = new LinkedList();
                    linkedList3.add(new CommonMsgPojo(officialChatMessage));
                    v.b(new u<Boolean>() { // from class: com.baidu.tieba.im.widget.chatVoiceView.ChatVoiceView.7
                        /* JADX DEBUG: Method merged with bridge method */
                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // com.baidu.tbadk.util.u
                        public Boolean doInBackground() {
                            return Boolean.valueOf(l.aJP().a(e.s(officialChatMessage), linkedList3, false));
                        }
                    }, new g<Boolean>() { // from class: com.baidu.tieba.im.widget.chatVoiceView.ChatVoiceView.8
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.tbadk.util.g
                        public void onReturnDataInUI(Boolean bool) {
                            ChatVoiceView.this.eDt.setVisibility(8);
                        }
                    });
                    return;
                } else {
                    return;
                }
            }
            return;
        }
        aNR();
        if (i == 1) {
            if (this.eDq != null) {
                this.eDq.setVisibility(0);
            }
            this.mProgress.setVisibility(4);
        } else if (i == 2) {
            if (this.eDq != null) {
                this.eDq.setVisibility(4);
            }
            this.mProgress.setVisibility(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        VoiceManager voiceManager;
        if (this.eDu == null || (voiceManager = getVoiceManager()) == null) {
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
            this.eDt.setVisibility(0);
        } else {
            this.eDt.setVisibility(8);
        }
    }

    public void setData(ChatMessage chatMessage) {
        VoiceManager voiceManager;
        if (chatMessage != null && chatMessage.getCacheData() != null) {
            this.eDu = chatMessage.getCacheData().getVoice_model();
            if (this.eDu == null) {
                this.eDu = new VoiceData.VoiceModel();
            }
            this.eBO = chatMessage;
            this.eDs.setText(VoiceManager.formatVoiceTime(this.eDu.duration));
            this.eDs.setContentDescription(String.format(getContext().getString(d.j.editor_record_format), VoiceManager.formatVoiceTime(this.eDu.duration)));
            setBubbleLength(this.eDu.duration);
            setTag(this.eDu);
            E(chatMessage);
            if (this.eDu.voice_status.intValue() != 1 && (voiceManager = getVoiceManager()) != null) {
                voiceManager.resetPlayView(this);
            }
            oH(this.eDu.voice_status.intValue());
        }
    }

    public void reset() {
        this.eDu = null;
        oH(1);
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
            if (this.eDv.getParent() != null && (this.eDv.getParent() instanceof RelativeLayout)) {
                this.eDv.setLayoutParams(new RelativeLayout.LayoutParams(i2, -2));
                return;
            }
            this.eDv.setLayoutParams(new LinearLayout.LayoutParams(i2, -2));
        } catch (Exception e) {
        }
    }

    public boolean isPlaying() {
        return this.eDu != null && this.eDu.voice_status.intValue() == 3;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void oS() {
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void b(VoiceData.VoiceModel voiceModel) {
        if (voiceModel != null) {
            oH(voiceModel.voice_status.intValue());
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void ba(int i) {
        oG(i);
        if (this.eDu != null) {
            this.eDu.elapse = i;
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void onShowErr(int i, String str) {
        com.baidu.adp.lib.util.l.F(getContext(), str);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceData.VoiceModel getVoiceModel() {
        return this.eDu;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceManager.b getRealView() {
        Context context = getContext();
        VoiceManager.b c = context instanceof VoiceManager.c ? ((VoiceManager.c) context).c(this.eDu) : this;
        return c == null ? this : c;
    }
}
