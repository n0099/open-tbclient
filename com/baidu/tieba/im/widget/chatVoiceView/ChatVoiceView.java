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
import com.baidu.tieba.w;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class ChatVoiceView extends LinearLayout implements View.OnClickListener, VoiceManager.b {
    private ProgressBar bqO;
    private ChatMessage dgv;
    private ImageView dhZ;
    private ImageView dia;
    private TextView dib;
    private ImageView dic;
    private VoiceData.VoiceModel did;
    private RelativeLayout die;

    public ChatVoiceView(Context context) {
        super(context);
        this.dhZ = null;
        this.dib = null;
        this.dic = null;
        this.bqO = null;
        LayoutInflater.from(context).inflate(w.j.widget_left_voice_view, (ViewGroup) this, true);
        init();
    }

    public ChatVoiceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        boolean z;
        this.dhZ = null;
        this.dib = null;
        this.dic = null;
        this.bqO = null;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, w.n.ChatVoiceView, 0, 0);
        if (obtainStyledAttributes != null) {
            z = obtainStyledAttributes.getBoolean(0, true);
            obtainStyledAttributes.recycle();
        } else {
            z = true;
        }
        if (z) {
            LayoutInflater.from(context).inflate(w.j.widget_left_voice_view, (ViewGroup) this, true);
        } else {
            LayoutInflater.from(context).inflate(w.j.widget_right_voice_view, (ViewGroup) this, true);
        }
        init();
    }

    private void init() {
        this.die = (RelativeLayout) findViewById(w.h.lay_bubble);
        this.dhZ = (ImageView) findViewById(w.h.img_voice_status);
        this.dia = (ImageView) findViewById(w.h.img_voice_status_anim);
        this.dib = (TextView) findViewById(w.h.tex_voice_duration);
        this.dic = (ImageView) findViewById(w.h.img_voice_readed);
        this.bqO = (ProgressBar) findViewById(w.h.progress);
    }

    private void auc() {
        this.dhZ.setVisibility(8);
        this.dia.setVisibility(0);
        ((AnimationDrawable) this.dia.getBackground()).start();
    }

    private void aud() {
        ((AnimationDrawable) this.dia.getBackground()).stop();
        this.dia.clearAnimation();
        this.dhZ.setVisibility(0);
        this.dia.setVisibility(8);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        try {
            aud();
        } catch (Exception e) {
        }
    }

    public void lY(int i) {
    }

    public void lZ(int i) {
        if (i == 3) {
            if (this.dhZ != null) {
                this.dhZ.setVisibility(0);
            }
            this.bqO.setVisibility(4);
            auc();
            VoiceMsgData u = com.baidu.tieba.im.util.h.u(this.dgv);
            if (u != null && u.getHas_read() != 1) {
                u.setHas_read(1);
                this.dgv.setContent("[" + OrmObject.jsonStrWithObject(u) + "]");
                if (this.dgv instanceof CommonGroupChatMessage) {
                    CommonGroupChatMessage commonGroupChatMessage = (CommonGroupChatMessage) this.dgv;
                    LinkedList linkedList = new LinkedList();
                    linkedList.add(new CommonMsgPojo(commonGroupChatMessage));
                    if (!commonGroupChatMessage.getGroupId().equals(String.valueOf(com.baidu.tieba.im.sendmessage.a.dfX))) {
                        t.b(new a(this, commonGroupChatMessage, linkedList), new b(this));
                        return;
                    } else {
                        t.b(new c(this, commonGroupChatMessage, linkedList), new d(this));
                        return;
                    }
                } else if (this.dgv instanceof PersonalChatMessage) {
                    PersonalChatMessage personalChatMessage = (PersonalChatMessage) this.dgv;
                    LinkedList linkedList2 = new LinkedList();
                    linkedList2.add(new CommonMsgPojo(personalChatMessage));
                    t.b(new e(this, personalChatMessage, linkedList2), new f(this));
                    return;
                } else if (this.dgv instanceof OfficialChatMessage) {
                    OfficialChatMessage officialChatMessage = (OfficialChatMessage) this.dgv;
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
        aud();
        if (i == 1) {
            if (this.dhZ != null) {
                this.dhZ.setVisibility(0);
            }
            this.bqO.setVisibility(4);
        } else if (i == 2) {
            if (this.dhZ != null) {
                this.dhZ.setVisibility(4);
            }
            this.bqO.setVisibility(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        VoiceManager voiceManager;
        if (this.did == null || (voiceManager = getVoiceManager()) == null) {
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
        if (com.baidu.tieba.im.util.h.r(chatMessage)) {
            z = false;
        } else {
            VoiceMsgData u = com.baidu.tieba.im.util.h.u(chatMessage);
            if (u != null && u.getHas_read() == 1) {
                z = false;
            }
        }
        if (z) {
            this.dic.setVisibility(0);
        } else {
            this.dic.setVisibility(8);
        }
    }

    public void setData(ChatMessage chatMessage) {
        VoiceManager voiceManager;
        if (chatMessage != null && chatMessage.getCacheData() != null) {
            this.did = chatMessage.getCacheData().getVoice_model();
            if (this.did == null) {
                this.did = new VoiceData.VoiceModel();
            }
            this.dgv = chatMessage;
            this.dib.setText(VoiceManager.formatVoiceTime(this.did.duration));
            this.dib.setContentDescription(String.format(getContext().getString(w.l.editor_record_format), VoiceManager.formatVoiceTime(this.did.duration)));
            setBubbleLength(this.did.duration);
            setTag(this.did);
            z(chatMessage);
            if (this.did.voice_status.intValue() != 1 && (voiceManager = getVoiceManager()) != null) {
                voiceManager.resetPlayView(this);
            }
            lZ(this.did.voice_status.intValue());
        }
    }

    public void reset() {
        this.did = null;
        lZ(1);
    }

    private void setBubbleLength(int i) {
        int i2;
        int ag = k.ag(getContext());
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
            if (this.die.getParent() != null && (this.die.getParent() instanceof RelativeLayout)) {
                this.die.setLayoutParams(new RelativeLayout.LayoutParams(i2, -2));
                return;
            }
            this.die.setLayoutParams(new LinearLayout.LayoutParams(i2, -2));
        } catch (Exception e) {
        }
    }

    public boolean isPlaying() {
        return this.did != null && this.did.voice_status.intValue() == 3;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void ms() {
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void b(VoiceData.VoiceModel voiceModel) {
        if (voiceModel != null) {
            lZ(voiceModel.voice_status.intValue());
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void aS(int i) {
        lY(i);
        if (this.did != null) {
            this.did.elapse = i;
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void onShowErr(int i, String str) {
        k.G(getContext(), str);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceData.VoiceModel getVoiceModel() {
        return this.did;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceManager.b getRealView() {
        Context context = getContext();
        VoiceManager.b c = context instanceof VoiceManager.c ? ((VoiceManager.c) context).c(this.did) : this;
        return c == null ? this : c;
    }
}
