package com.baidu.tieba.im.widget.chatVoiceView;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.AnimationDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.n;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.core.voice.i;
import com.baidu.tbadk.core.voice.j;
import com.baidu.tieba.im.data.VoiceMsgData;
import com.baidu.tieba.im.db.pojo.CommonMsgPojo;
import com.baidu.tieba.im.l;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.message.chat.CommonGroupChatMessage;
import com.baidu.tieba.im.message.chat.OfficialChatMessage;
import com.baidu.tieba.im.message.chat.PersonalChatMessage;
import com.baidu.tieba.q;
import com.baidu.tieba.r;
import com.baidu.tieba.v;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class ChatVoiceView extends LinearLayout implements View.OnClickListener, i {
    private ChatMessage bpM;
    private ImageView brm;
    private ImageView brn;
    private TextView bro;
    private ImageView brp;
    private VoiceData.VoiceModel brq;
    private RelativeLayout brr;
    private ProgressBar mProgress;

    public ChatVoiceView(Context context) {
        super(context);
        this.brm = null;
        this.bro = null;
        this.brp = null;
        this.mProgress = null;
        com.baidu.adp.lib.g.b.hr().a(context, r.widget_left_voice_view, this, true);
        init();
    }

    public ChatVoiceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        boolean z;
        this.brm = null;
        this.bro = null;
        this.brp = null;
        this.mProgress = null;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, v.ChatVoiceView, 0, 0);
        if (obtainStyledAttributes != null) {
            z = obtainStyledAttributes.getBoolean(0, true);
            obtainStyledAttributes.recycle();
        } else {
            z = true;
        }
        if (z) {
            com.baidu.adp.lib.g.b.hr().a(context, r.widget_left_voice_view, this, true);
        } else {
            com.baidu.adp.lib.g.b.hr().a(context, r.widget_right_voice_view, this, true);
        }
        init();
    }

    private void init() {
        this.brr = (RelativeLayout) findViewById(q.lay_bubble);
        this.brm = (ImageView) findViewById(q.img_voice_status);
        this.brn = (ImageView) findViewById(q.img_voice_status_anim);
        this.bro = (TextView) findViewById(q.tex_voice_duration);
        this.brp = (ImageView) findViewById(q.img_voice_readed);
        this.mProgress = (ProgressBar) findViewById(q.progress);
    }

    private void Vl() {
        this.brm.setVisibility(8);
        this.brn.setVisibility(0);
        ((AnimationDrawable) this.brn.getBackground()).start();
    }

    private void Vm() {
        ((AnimationDrawable) this.brn.getBackground()).stop();
        this.brn.clearAnimation();
        this.brm.setVisibility(0);
        this.brn.setVisibility(8);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        try {
            Vm();
        } catch (Exception e) {
        }
    }

    public void gJ(int i) {
    }

    public void gK(int i) {
        if (i == 3) {
            if (this.brm != null) {
                this.brm.setVisibility(0);
            }
            this.mProgress.setVisibility(4);
            Vl();
            VoiceMsgData v = com.baidu.tieba.im.util.i.v(this.bpM);
            if (v != null && v.getHas_read() != 1) {
                v.setHas_read(1);
                this.bpM.setContent("[" + com.baidu.adp.lib.a.b.a.a.i.jsonStrWithObject(v) + "]");
                if (this.bpM instanceof CommonGroupChatMessage) {
                    CommonGroupChatMessage commonGroupChatMessage = (CommonGroupChatMessage) this.bpM;
                    LinkedList linkedList = new LinkedList();
                    linkedList.add(new CommonMsgPojo(commonGroupChatMessage));
                    if (!commonGroupChatMessage.getGroupId().equals(String.valueOf(com.baidu.tieba.im.c.a.bpq))) {
                        l.a(new a(this, commonGroupChatMessage, linkedList), new b(this));
                        return;
                    } else {
                        l.a(new c(this, commonGroupChatMessage, linkedList), new d(this));
                        return;
                    }
                } else if (this.bpM instanceof PersonalChatMessage) {
                    PersonalChatMessage personalChatMessage = (PersonalChatMessage) this.bpM;
                    LinkedList linkedList2 = new LinkedList();
                    linkedList2.add(new CommonMsgPojo(personalChatMessage));
                    l.a(new e(this, personalChatMessage, linkedList2), new f(this));
                    return;
                } else if (this.bpM instanceof OfficialChatMessage) {
                    OfficialChatMessage officialChatMessage = (OfficialChatMessage) this.bpM;
                    LinkedList linkedList3 = new LinkedList();
                    linkedList3.add(new CommonMsgPojo(officialChatMessage));
                    l.a(new g(this, officialChatMessage, linkedList3), new h(this));
                    return;
                } else {
                    return;
                }
            }
            return;
        }
        Vm();
        if (i == 1) {
            if (this.brm != null) {
                this.brm.setVisibility(0);
            }
            this.mProgress.setVisibility(4);
        } else if (i == 2) {
            if (this.brm != null) {
                this.brm.setVisibility(4);
            }
            this.mProgress.setVisibility(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        VoiceManager voiceManager;
        if (this.brq == null || (voiceManager = getVoiceManager()) == null) {
            return;
        }
        voiceManager.startPlay(this);
    }

    public VoiceManager getVoiceManager() {
        Context context = getContext();
        if (context instanceof j) {
            return ((j) context).getVoiceManager();
        }
        return null;
    }

    private void z(ChatMessage chatMessage) {
        boolean z = true;
        if (com.baidu.tieba.im.util.i.s(chatMessage)) {
            z = false;
        } else {
            VoiceMsgData v = com.baidu.tieba.im.util.i.v(chatMessage);
            if (v != null && v.getHas_read() == 1) {
                z = false;
            }
        }
        if (z) {
            this.brp.setVisibility(0);
        } else {
            this.brp.setVisibility(8);
        }
    }

    public void setData(ChatMessage chatMessage) {
        if (chatMessage != null && chatMessage.getCacheData() != null) {
            this.brq = chatMessage.getCacheData().getVoice_model();
            if (this.brq == null) {
                this.brq = new VoiceData.VoiceModel();
            }
            this.bpM = chatMessage;
            this.bro.setText(VoiceManager.formatVoiceTime(this.brq.duration));
            setBubbleLength(this.brq.duration);
            setTag(this.brq);
            z(chatMessage);
            gK(this.brq.voice_status.intValue());
        }
    }

    public void reset() {
        this.brq = null;
        gK(1);
    }

    private void setBubbleLength(int i) {
        int i2;
        int M = n.M(getContext());
        if (i <= 10) {
            int i3 = (int) (M * 0.1875d);
            i2 = (((((int) (M * 0.4125d)) - i3) * (i - 1)) / 10) + i3;
        } else if (i <= 30) {
            int i4 = (int) (M * 0.4125d);
            i2 = (((((int) (M * 0.5375d)) - i4) * (i - 10)) / 20) + i4;
        } else {
            i2 = (int) (M * 0.5375d);
        }
        try {
            if (this.brr.getParent() != null && (this.brr.getParent() instanceof RelativeLayout)) {
                this.brr.setLayoutParams(new RelativeLayout.LayoutParams(i2, -2));
                return;
            }
            this.brr.setLayoutParams(new LinearLayout.LayoutParams(i2, -2));
        } catch (Exception e) {
        }
    }

    public boolean isPlaying() {
        return this.brq != null && this.brq.voice_status.intValue() == 3;
    }

    @Override // com.baidu.tbadk.core.voice.i
    public void ow() {
    }

    @Override // com.baidu.tbadk.core.voice.i
    public void b(VoiceData.VoiceModel voiceModel) {
        if (voiceModel != null) {
            gK(voiceModel.voice_status.intValue());
        }
    }

    @Override // com.baidu.tbadk.core.voice.i
    public void aG(int i) {
        gJ(i);
        if (this.brq != null) {
            this.brq.elapse = i;
        }
    }

    @Override // com.baidu.tbadk.core.voice.i
    public void onShowErr(int i, String str) {
        n.t(getContext(), str);
    }

    @Override // com.baidu.tbadk.core.voice.i
    public VoiceData.VoiceModel getVoiceModel() {
        return this.brq;
    }

    @Override // com.baidu.tbadk.core.voice.i
    public i getRealView() {
        Context context = getContext();
        i realView = context instanceof j ? ((j) context).getRealView(this.brq) : this;
        return realView == null ? this : realView;
    }
}
