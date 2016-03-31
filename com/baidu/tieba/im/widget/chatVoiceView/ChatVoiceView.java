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
import com.baidu.adp.lib.a.b.a.a.i;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.util.q;
import com.baidu.tieba.im.data.VoiceMsgData;
import com.baidu.tieba.im.db.pojo.CommonMsgPojo;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.message.chat.CommonGroupChatMessage;
import com.baidu.tieba.im.message.chat.OfficialChatMessage;
import com.baidu.tieba.im.message.chat.PersonalChatMessage;
import com.baidu.tieba.t;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class ChatVoiceView extends LinearLayout implements View.OnClickListener, VoiceManager.b {
    private ProgressBar aQj;
    private ChatMessage cpZ;
    private ImageView crC;
    private ImageView crD;
    private TextView crE;
    private ImageView crF;
    private VoiceData.VoiceModel crG;
    private RelativeLayout crH;

    public ChatVoiceView(Context context) {
        super(context);
        this.crC = null;
        this.crE = null;
        this.crF = null;
        this.aQj = null;
        LayoutInflater.from(context).inflate(t.h.widget_left_voice_view, (ViewGroup) this, true);
        init();
    }

    public ChatVoiceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        boolean z;
        this.crC = null;
        this.crE = null;
        this.crF = null;
        this.aQj = null;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, t.l.ChatVoiceView, 0, 0);
        if (obtainStyledAttributes != null) {
            z = obtainStyledAttributes.getBoolean(0, true);
            obtainStyledAttributes.recycle();
        } else {
            z = true;
        }
        if (z) {
            LayoutInflater.from(context).inflate(t.h.widget_left_voice_view, (ViewGroup) this, true);
        } else {
            LayoutInflater.from(context).inflate(t.h.widget_right_voice_view, (ViewGroup) this, true);
        }
        init();
    }

    private void init() {
        this.crH = (RelativeLayout) findViewById(t.g.lay_bubble);
        this.crC = (ImageView) findViewById(t.g.img_voice_status);
        this.crD = (ImageView) findViewById(t.g.img_voice_status_anim);
        this.crE = (TextView) findViewById(t.g.tex_voice_duration);
        this.crF = (ImageView) findViewById(t.g.img_voice_readed);
        this.aQj = (ProgressBar) findViewById(t.g.progress);
    }

    private void aiK() {
        this.crC.setVisibility(8);
        this.crD.setVisibility(0);
        ((AnimationDrawable) this.crD.getBackground()).start();
    }

    private void aiL() {
        ((AnimationDrawable) this.crD.getBackground()).stop();
        this.crD.clearAnimation();
        this.crC.setVisibility(0);
        this.crD.setVisibility(8);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        try {
            aiL();
        } catch (Exception e) {
        }
    }

    public void kg(int i) {
    }

    public void kh(int i) {
        if (i == 3) {
            if (this.crC != null) {
                this.crC.setVisibility(0);
            }
            this.aQj.setVisibility(4);
            aiK();
            VoiceMsgData v = com.baidu.tieba.im.util.h.v(this.cpZ);
            if (v != null && v.getHas_read() != 1) {
                v.setHas_read(1);
                this.cpZ.setContent("[" + i.jsonStrWithObject(v) + "]");
                if (this.cpZ instanceof CommonGroupChatMessage) {
                    CommonGroupChatMessage commonGroupChatMessage = (CommonGroupChatMessage) this.cpZ;
                    LinkedList linkedList = new LinkedList();
                    linkedList.add(new CommonMsgPojo(commonGroupChatMessage));
                    if (!commonGroupChatMessage.getGroupId().equals(String.valueOf(com.baidu.tieba.im.c.a.cpB))) {
                        q.b(new a(this, commonGroupChatMessage, linkedList), new b(this));
                        return;
                    } else {
                        q.b(new c(this, commonGroupChatMessage, linkedList), new d(this));
                        return;
                    }
                } else if (this.cpZ instanceof PersonalChatMessage) {
                    PersonalChatMessage personalChatMessage = (PersonalChatMessage) this.cpZ;
                    LinkedList linkedList2 = new LinkedList();
                    linkedList2.add(new CommonMsgPojo(personalChatMessage));
                    q.b(new e(this, personalChatMessage, linkedList2), new f(this));
                    return;
                } else if (this.cpZ instanceof OfficialChatMessage) {
                    OfficialChatMessage officialChatMessage = (OfficialChatMessage) this.cpZ;
                    LinkedList linkedList3 = new LinkedList();
                    linkedList3.add(new CommonMsgPojo(officialChatMessage));
                    q.b(new g(this, officialChatMessage, linkedList3), new h(this));
                    return;
                } else {
                    return;
                }
            }
            return;
        }
        aiL();
        if (i == 1) {
            if (this.crC != null) {
                this.crC.setVisibility(0);
            }
            this.aQj.setVisibility(4);
        } else if (i == 2) {
            if (this.crC != null) {
                this.crC.setVisibility(4);
            }
            this.aQj.setVisibility(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        VoiceManager voiceManager;
        if (this.crG == null || (voiceManager = getVoiceManager()) == null) {
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
        if (com.baidu.tieba.im.util.h.s(chatMessage)) {
            z = false;
        } else {
            VoiceMsgData v = com.baidu.tieba.im.util.h.v(chatMessage);
            if (v != null && v.getHas_read() == 1) {
                z = false;
            }
        }
        if (z) {
            this.crF.setVisibility(0);
        } else {
            this.crF.setVisibility(8);
        }
    }

    public void setData(ChatMessage chatMessage) {
        if (chatMessage != null && chatMessage.getCacheData() != null) {
            this.crG = chatMessage.getCacheData().getVoice_model();
            if (this.crG == null) {
                this.crG = new VoiceData.VoiceModel();
            }
            this.cpZ = chatMessage;
            this.crE.setText(VoiceManager.formatVoiceTime(this.crG.duration));
            this.crH.setContentDescription(String.format(getContext().getString(t.j.editor_record_format), VoiceManager.formatVoiceTime(this.crG.duration)));
            setBubbleLength(this.crG.duration);
            setTag(this.crG);
            z(chatMessage);
            kh(this.crG.voice_status.intValue());
        }
    }

    public void reset() {
        this.crG = null;
        kh(1);
    }

    private void setBubbleLength(int i) {
        int i2;
        int B = k.B(getContext());
        if (i <= 10) {
            int i3 = (int) (B * 0.1875d);
            i2 = (((((int) (B * 0.4125d)) - i3) * (i - 1)) / 10) + i3;
        } else if (i <= 30) {
            int i4 = (int) (B * 0.4125d);
            i2 = (((((int) (B * 0.5375d)) - i4) * (i - 10)) / 20) + i4;
        } else {
            i2 = (int) (B * 0.5375d);
        }
        try {
            if (this.crH.getParent() != null && (this.crH.getParent() instanceof RelativeLayout)) {
                this.crH.setLayoutParams(new RelativeLayout.LayoutParams(i2, -2));
                return;
            }
            this.crH.setLayoutParams(new LinearLayout.LayoutParams(i2, -2));
        } catch (Exception e) {
        }
    }

    public boolean isPlaying() {
        return this.crG != null && this.crG.voice_status.intValue() == 3;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void ow() {
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void b(VoiceData.VoiceModel voiceModel) {
        if (voiceModel != null) {
            kh(voiceModel.voice_status.intValue());
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void aO(int i) {
        kg(i);
        if (this.crG != null) {
            this.crG.elapse = i;
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void onShowErr(int i, String str) {
        k.l(getContext(), str);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceData.VoiceModel getVoiceModel() {
        return this.crG;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceManager.b getRealView() {
        Context context = getContext();
        VoiceManager.b c = context instanceof VoiceManager.c ? ((VoiceManager.c) context).c(this.crG) : this;
        return c == null ? this : c;
    }
}
