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
    private ChatMessage boT;
    private ImageView bqR;
    private ImageView bqS;
    private TextView bqT;
    private ImageView bqU;
    private VoiceData.VoiceModel bqV;
    private RelativeLayout bqW;
    private ProgressBar mProgress;

    public ChatVoiceView(Context context) {
        super(context);
        this.bqR = null;
        this.bqT = null;
        this.bqU = null;
        this.mProgress = null;
        com.baidu.adp.lib.g.b.ei().a(context, x.widget_left_voice_view, this, true);
        init();
    }

    public ChatVoiceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        boolean z;
        this.bqR = null;
        this.bqT = null;
        this.bqU = null;
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
        this.bqW = (RelativeLayout) findViewById(w.lay_bubble);
        this.bqR = (ImageView) findViewById(w.img_voice_status);
        this.bqS = (ImageView) findViewById(w.img_voice_status_anim);
        this.bqT = (TextView) findViewById(w.tex_voice_duration);
        this.bqU = (ImageView) findViewById(w.img_voice_readed);
        this.mProgress = (ProgressBar) findViewById(w.progress);
    }

    private void TO() {
        this.bqR.setVisibility(8);
        this.bqS.setVisibility(0);
        ((AnimationDrawable) this.bqS.getBackground()).start();
    }

    private void TP() {
        ((AnimationDrawable) this.bqS.getBackground()).stop();
        this.bqS.clearAnimation();
        this.bqR.setVisibility(0);
        this.bqS.setVisibility(8);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        try {
            TP();
        } catch (Exception e) {
        }
    }

    public void gJ(int i) {
    }

    public void gK(int i) {
        if (i == 3) {
            if (this.bqR != null) {
                this.bqR.setVisibility(0);
            }
            this.mProgress.setVisibility(4);
            TO();
            VoiceMsgData u = i.u(this.boT);
            if (u != null && u.getHas_read() != 1) {
                u.setHas_read(1);
                this.boT.setContent("[" + com.baidu.adp.lib.a.b.a.a.i.jsonStrWithObject(u) + "]");
                if (this.boT instanceof CommonGroupChatMessage) {
                    CommonGroupChatMessage commonGroupChatMessage = (CommonGroupChatMessage) this.boT;
                    LinkedList linkedList = new LinkedList();
                    linkedList.add(new CommonMsgPojo(commonGroupChatMessage));
                    if (!commonGroupChatMessage.getGroupId().equals(String.valueOf(com.baidu.tieba.im.c.a.boy))) {
                        com.baidu.tieba.im.i.a(new a(this, commonGroupChatMessage, linkedList), new b(this));
                        return;
                    } else {
                        com.baidu.tieba.im.i.a(new c(this, commonGroupChatMessage, linkedList), new d(this));
                        return;
                    }
                } else if (this.boT instanceof PersonalChatMessage) {
                    PersonalChatMessage personalChatMessage = (PersonalChatMessage) this.boT;
                    LinkedList linkedList2 = new LinkedList();
                    linkedList2.add(new CommonMsgPojo(personalChatMessage));
                    com.baidu.tieba.im.i.a(new e(this, personalChatMessage, linkedList2), new f(this));
                    return;
                } else if (this.boT instanceof OfficialChatMessage) {
                    OfficialChatMessage officialChatMessage = (OfficialChatMessage) this.boT;
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
        TP();
        if (i == 1) {
            if (this.bqR != null) {
                this.bqR.setVisibility(0);
            }
            this.mProgress.setVisibility(4);
        } else if (i == 2) {
            if (this.bqR != null) {
                this.bqR.setVisibility(4);
            }
            this.mProgress.setVisibility(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        VoiceManager voiceManager;
        if (this.bqV == null || (voiceManager = getVoiceManager()) == null) {
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
            this.bqU.setVisibility(0);
        } else {
            this.bqU.setVisibility(8);
        }
    }

    public void setData(ChatMessage chatMessage) {
        if (chatMessage != null && chatMessage.getCacheData() != null) {
            this.bqV = chatMessage.getCacheData().getVoice_model();
            if (this.bqV == null) {
                this.bqV = new VoiceData.VoiceModel();
            }
            this.boT = chatMessage;
            this.bqT.setText(VoiceManager.formatVoiceTime(this.bqV.duration));
            setBubbleLength(this.bqV.duration);
            setTag(this.bqV);
            y(chatMessage);
            gK(this.bqV.voice_status.intValue());
        }
    }

    public void reset() {
        this.bqV = null;
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
            if (this.bqW.getParent() != null && (this.bqW.getParent() instanceof RelativeLayout)) {
                this.bqW.setLayoutParams(new RelativeLayout.LayoutParams(i2, -2));
                return;
            }
            this.bqW.setLayoutParams(new LinearLayout.LayoutParams(i2, -2));
        } catch (Exception e) {
        }
    }

    public boolean isPlaying() {
        return this.bqV != null && this.bqV.voice_status.intValue() == 3;
    }

    @Override // com.baidu.tbadk.core.voice.m
    public void qT() {
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
        if (this.bqV != null) {
            this.bqV.elapse = i;
        }
    }

    @Override // com.baidu.tbadk.core.voice.m
    public void onShowErr(int i, String str) {
        l.t(getContext(), str);
    }

    @Override // com.baidu.tbadk.core.voice.m
    public VoiceData.VoiceModel getVoiceModel() {
        return this.bqV;
    }

    @Override // com.baidu.tbadk.core.voice.m
    public m getRealView() {
        Context context = getContext();
        m realView = context instanceof o ? ((o) context).getRealView(this.bqV) : this;
        return realView == null ? this : realView;
    }
}
