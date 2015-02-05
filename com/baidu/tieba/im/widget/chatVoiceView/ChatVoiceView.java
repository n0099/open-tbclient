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
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.core.voice.m;
import com.baidu.tbadk.core.voice.o;
import com.baidu.tieba.ab;
import com.baidu.tieba.im.data.VoiceMsgData;
import com.baidu.tieba.im.db.pojo.CommonMsgPojo;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.message.chat.CommonGroupChatMessage;
import com.baidu.tieba.im.message.chat.OfficialChatMessage;
import com.baidu.tieba.im.message.chat.PersonalChatMessage;
import com.baidu.tieba.im.util.i;
import com.baidu.tieba.w;
import com.baidu.tieba.x;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class ChatVoiceView extends LinearLayout implements View.OnClickListener, m {
    private ChatMessage boS;
    private ImageView bqQ;
    private ImageView bqR;
    private TextView bqS;
    private ImageView bqT;
    private VoiceData.VoiceModel bqU;
    private RelativeLayout bqV;
    private ProgressBar mProgress;

    public ChatVoiceView(Context context) {
        super(context);
        this.bqQ = null;
        this.bqS = null;
        this.bqT = null;
        this.mProgress = null;
        com.baidu.adp.lib.g.b.ei().a(context, x.widget_left_voice_view, this, true);
        init();
    }

    public ChatVoiceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        boolean z;
        this.bqQ = null;
        this.bqS = null;
        this.bqT = null;
        this.mProgress = null;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ab.ChatVoiceView, 0, 0);
        if (obtainStyledAttributes != null) {
            z = obtainStyledAttributes.getBoolean(0, true);
            obtainStyledAttributes.recycle();
        } else {
            z = true;
        }
        if (z) {
            com.baidu.adp.lib.g.b.ei().a(context, x.widget_left_voice_view, this, true);
        } else {
            com.baidu.adp.lib.g.b.ei().a(context, x.widget_right_voice_view, this, true);
        }
        init();
    }

    private void init() {
        this.bqV = (RelativeLayout) findViewById(w.lay_bubble);
        this.bqQ = (ImageView) findViewById(w.img_voice_status);
        this.bqR = (ImageView) findViewById(w.img_voice_status_anim);
        this.bqS = (TextView) findViewById(w.tex_voice_duration);
        this.bqT = (ImageView) findViewById(w.img_voice_readed);
        this.mProgress = (ProgressBar) findViewById(w.progress);
    }

    private void TJ() {
        this.bqQ.setVisibility(8);
        this.bqR.setVisibility(0);
        ((AnimationDrawable) this.bqR.getBackground()).start();
    }

    private void TK() {
        ((AnimationDrawable) this.bqR.getBackground()).stop();
        this.bqR.clearAnimation();
        this.bqQ.setVisibility(0);
        this.bqR.setVisibility(8);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        try {
            TK();
        } catch (Exception e) {
        }
    }

    public void gJ(int i) {
    }

    public void gK(int i) {
        if (i == 3) {
            if (this.bqQ != null) {
                this.bqQ.setVisibility(0);
            }
            this.mProgress.setVisibility(4);
            TJ();
            VoiceMsgData u = i.u(this.boS);
            if (u != null && u.getHas_read() != 1) {
                u.setHas_read(1);
                this.boS.setContent("[" + com.baidu.adp.lib.a.b.a.a.i.jsonStrWithObject(u) + "]");
                if (this.boS instanceof CommonGroupChatMessage) {
                    CommonGroupChatMessage commonGroupChatMessage = (CommonGroupChatMessage) this.boS;
                    LinkedList linkedList = new LinkedList();
                    linkedList.add(new CommonMsgPojo(commonGroupChatMessage));
                    if (!commonGroupChatMessage.getGroupId().equals(String.valueOf(com.baidu.tieba.im.c.a.box))) {
                        com.baidu.tieba.im.i.a(new a(this, commonGroupChatMessage, linkedList), new b(this));
                        return;
                    } else {
                        com.baidu.tieba.im.i.a(new c(this, commonGroupChatMessage, linkedList), new d(this));
                        return;
                    }
                } else if (this.boS instanceof PersonalChatMessage) {
                    PersonalChatMessage personalChatMessage = (PersonalChatMessage) this.boS;
                    LinkedList linkedList2 = new LinkedList();
                    linkedList2.add(new CommonMsgPojo(personalChatMessage));
                    com.baidu.tieba.im.i.a(new e(this, personalChatMessage, linkedList2), new f(this));
                    return;
                } else if (this.boS instanceof OfficialChatMessage) {
                    OfficialChatMessage officialChatMessage = (OfficialChatMessage) this.boS;
                    LinkedList linkedList3 = new LinkedList();
                    linkedList3.add(new CommonMsgPojo(officialChatMessage));
                    com.baidu.tieba.im.i.a(new g(this, officialChatMessage, linkedList3), new h(this));
                    return;
                } else {
                    return;
                }
            }
            return;
        }
        TK();
        if (i == 1) {
            if (this.bqQ != null) {
                this.bqQ.setVisibility(0);
            }
            this.mProgress.setVisibility(4);
        } else if (i == 2) {
            if (this.bqQ != null) {
                this.bqQ.setVisibility(4);
            }
            this.mProgress.setVisibility(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        VoiceManager voiceManager;
        if (this.bqU == null || (voiceManager = getVoiceManager()) == null) {
            return;
        }
        voiceManager.startPlay(this);
    }

    public VoiceManager getVoiceManager() {
        Context context = getContext();
        if (context instanceof o) {
            return ((o) context).getVoiceManager();
        }
        return null;
    }

    private void y(ChatMessage chatMessage) {
        boolean z = true;
        if (i.r(chatMessage)) {
            z = false;
        } else {
            VoiceMsgData u = i.u(chatMessage);
            if (u != null && u.getHas_read() == 1) {
                z = false;
            }
        }
        if (z) {
            this.bqT.setVisibility(0);
        } else {
            this.bqT.setVisibility(8);
        }
    }

    public void setData(ChatMessage chatMessage) {
        if (chatMessage != null && chatMessage.getCacheData() != null) {
            this.bqU = chatMessage.getCacheData().getVoice_model();
            if (this.bqU == null) {
                this.bqU = new VoiceData.VoiceModel();
            }
            this.boS = chatMessage;
            this.bqS.setText(VoiceManager.formatVoiceTime(this.bqU.duration));
            setBubbleLength(this.bqU.duration);
            setTag(this.bqU);
            y(chatMessage);
            gK(this.bqU.voice_status.intValue());
        }
    }

    public void reset() {
        this.bqU = null;
        gK(1);
    }

    private void setBubbleLength(int i) {
        int i2;
        int M = l.M(getContext());
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
            if (this.bqV.getParent() != null && (this.bqV.getParent() instanceof RelativeLayout)) {
                this.bqV.setLayoutParams(new RelativeLayout.LayoutParams(i2, -2));
                return;
            }
            this.bqV.setLayoutParams(new LinearLayout.LayoutParams(i2, -2));
        } catch (Exception e) {
        }
    }

    public boolean isPlaying() {
        return this.bqU != null && this.bqU.voice_status.intValue() == 3;
    }

    @Override // com.baidu.tbadk.core.voice.m
    public void qN() {
    }

    @Override // com.baidu.tbadk.core.voice.m
    public void a(VoiceData.VoiceModel voiceModel) {
        if (voiceModel != null) {
            gK(voiceModel.voice_status.intValue());
        }
    }

    @Override // com.baidu.tbadk.core.voice.m
    public void cu(int i) {
        gJ(i);
        if (this.bqU != null) {
            this.bqU.elapse = i;
        }
    }

    @Override // com.baidu.tbadk.core.voice.m
    public void onShowErr(int i, String str) {
        l.t(getContext(), str);
    }

    @Override // com.baidu.tbadk.core.voice.m
    public VoiceData.VoiceModel getVoiceModel() {
        return this.bqU;
    }

    @Override // com.baidu.tbadk.core.voice.m
    public m getRealView() {
        Context context = getContext();
        m realView = context instanceof o ? ((o) context).getRealView(this.bqU) : this;
        return realView == null ? this : realView;
    }
}
