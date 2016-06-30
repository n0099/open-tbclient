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
import com.baidu.tbadk.util.t;
import com.baidu.tieba.im.data.VoiceMsgData;
import com.baidu.tieba.im.db.pojo.CommonMsgPojo;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.message.chat.CommonGroupChatMessage;
import com.baidu.tieba.im.message.chat.OfficialChatMessage;
import com.baidu.tieba.im.message.chat.PersonalChatMessage;
import com.baidu.tieba.u;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class ChatVoiceView extends LinearLayout implements View.OnClickListener, VoiceManager.b {
    private ChatMessage cWm;
    private ImageView cXO;
    private ImageView cXP;
    private TextView cXQ;
    private ImageView cXR;
    private VoiceData.VoiceModel cXS;
    private RelativeLayout cXT;
    private ProgressBar cbl;

    public ChatVoiceView(Context context) {
        super(context);
        this.cXO = null;
        this.cXQ = null;
        this.cXR = null;
        this.cbl = null;
        LayoutInflater.from(context).inflate(u.h.widget_left_voice_view, (ViewGroup) this, true);
        init();
    }

    public ChatVoiceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        boolean z;
        this.cXO = null;
        this.cXQ = null;
        this.cXR = null;
        this.cbl = null;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, u.l.ChatVoiceView, 0, 0);
        if (obtainStyledAttributes != null) {
            z = obtainStyledAttributes.getBoolean(0, true);
            obtainStyledAttributes.recycle();
        } else {
            z = true;
        }
        if (z) {
            LayoutInflater.from(context).inflate(u.h.widget_left_voice_view, (ViewGroup) this, true);
        } else {
            LayoutInflater.from(context).inflate(u.h.widget_right_voice_view, (ViewGroup) this, true);
        }
        init();
    }

    private void init() {
        this.cXT = (RelativeLayout) findViewById(u.g.lay_bubble);
        this.cXO = (ImageView) findViewById(u.g.img_voice_status);
        this.cXP = (ImageView) findViewById(u.g.img_voice_status_anim);
        this.cXQ = (TextView) findViewById(u.g.tex_voice_duration);
        this.cXR = (ImageView) findViewById(u.g.img_voice_readed);
        this.cbl = (ProgressBar) findViewById(u.g.progress);
    }

    private void arg() {
        this.cXO.setVisibility(8);
        this.cXP.setVisibility(0);
        ((AnimationDrawable) this.cXP.getBackground()).start();
    }

    private void arh() {
        ((AnimationDrawable) this.cXP.getBackground()).stop();
        this.cXP.clearAnimation();
        this.cXO.setVisibility(0);
        this.cXP.setVisibility(8);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        try {
            arh();
        } catch (Exception e) {
        }
    }

    public void lm(int i) {
    }

    public void ln(int i) {
        if (i == 3) {
            if (this.cXO != null) {
                this.cXO.setVisibility(0);
            }
            this.cbl.setVisibility(4);
            arg();
            VoiceMsgData w = com.baidu.tieba.im.util.h.w(this.cWm);
            if (w != null && w.getHas_read() != 1) {
                w.setHas_read(1);
                this.cWm.setContent("[" + i.jsonStrWithObject(w) + "]");
                if (this.cWm instanceof CommonGroupChatMessage) {
                    CommonGroupChatMessage commonGroupChatMessage = (CommonGroupChatMessage) this.cWm;
                    LinkedList linkedList = new LinkedList();
                    linkedList.add(new CommonMsgPojo(commonGroupChatMessage));
                    if (!commonGroupChatMessage.getGroupId().equals(String.valueOf(com.baidu.tieba.im.c.a.cVO))) {
                        t.b(new a(this, commonGroupChatMessage, linkedList), new b(this));
                        return;
                    } else {
                        t.b(new c(this, commonGroupChatMessage, linkedList), new d(this));
                        return;
                    }
                } else if (this.cWm instanceof PersonalChatMessage) {
                    PersonalChatMessage personalChatMessage = (PersonalChatMessage) this.cWm;
                    LinkedList linkedList2 = new LinkedList();
                    linkedList2.add(new CommonMsgPojo(personalChatMessage));
                    t.b(new e(this, personalChatMessage, linkedList2), new f(this));
                    return;
                } else if (this.cWm instanceof OfficialChatMessage) {
                    OfficialChatMessage officialChatMessage = (OfficialChatMessage) this.cWm;
                    LinkedList linkedList3 = new LinkedList();
                    linkedList3.add(new CommonMsgPojo(officialChatMessage));
                    t.b(new g(this, officialChatMessage, linkedList3), new h(this));
                    return;
                } else {
                    return;
                }
            }
            return;
        }
        arh();
        if (i == 1) {
            if (this.cXO != null) {
                this.cXO.setVisibility(0);
            }
            this.cbl.setVisibility(4);
        } else if (i == 2) {
            if (this.cXO != null) {
                this.cXO.setVisibility(4);
            }
            this.cbl.setVisibility(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        VoiceManager voiceManager;
        if (this.cXS == null || (voiceManager = getVoiceManager()) == null) {
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

    private void A(ChatMessage chatMessage) {
        boolean z = true;
        if (com.baidu.tieba.im.util.h.t(chatMessage)) {
            z = false;
        } else {
            VoiceMsgData w = com.baidu.tieba.im.util.h.w(chatMessage);
            if (w != null && w.getHas_read() == 1) {
                z = false;
            }
        }
        if (z) {
            this.cXR.setVisibility(0);
        } else {
            this.cXR.setVisibility(8);
        }
    }

    public void setData(ChatMessage chatMessage) {
        if (chatMessage != null && chatMessage.getCacheData() != null) {
            this.cXS = chatMessage.getCacheData().getVoice_model();
            if (this.cXS == null) {
                this.cXS = new VoiceData.VoiceModel();
            }
            this.cWm = chatMessage;
            this.cXQ.setText(VoiceManager.formatVoiceTime(this.cXS.duration));
            this.cXQ.setContentDescription(String.format(getContext().getString(u.j.editor_record_format), VoiceManager.formatVoiceTime(this.cXS.duration)));
            setBubbleLength(this.cXS.duration);
            setTag(this.cXS);
            A(chatMessage);
            ln(this.cXS.voice_status.intValue());
        }
    }

    public void reset() {
        this.cXS = null;
        ln(1);
    }

    private void setBubbleLength(int i) {
        int i2;
        int A = k.A(getContext());
        if (i <= 10) {
            int i3 = (int) (A * 0.1875d);
            i2 = (((((int) (A * 0.4125d)) - i3) * (i - 1)) / 10) + i3;
        } else if (i <= 30) {
            int i4 = (int) (A * 0.4125d);
            i2 = (((((int) (A * 0.5375d)) - i4) * (i - 10)) / 20) + i4;
        } else {
            i2 = (int) (A * 0.5375d);
        }
        try {
            if (this.cXT.getParent() != null && (this.cXT.getParent() instanceof RelativeLayout)) {
                this.cXT.setLayoutParams(new RelativeLayout.LayoutParams(i2, -2));
                return;
            }
            this.cXT.setLayoutParams(new LinearLayout.LayoutParams(i2, -2));
        } catch (Exception e) {
        }
    }

    public boolean isPlaying() {
        return this.cXS != null && this.cXS.voice_status.intValue() == 3;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void kM() {
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void b(VoiceData.VoiceModel voiceModel) {
        if (voiceModel != null) {
            ln(voiceModel.voice_status.intValue());
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void aC(int i) {
        lm(i);
        if (this.cXS != null) {
            this.cXS.elapse = i;
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void onShowErr(int i, String str) {
        k.m(getContext(), str);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceData.VoiceModel getVoiceModel() {
        return this.cXS;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceManager.b getRealView() {
        Context context = getContext();
        VoiceManager.b c = context instanceof VoiceManager.c ? ((VoiceManager.c) context).c(this.cXS) : this;
        return c == null ? this : c;
    }
}
