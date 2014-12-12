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
    private ChatMessage bnw;
    private ImageView bpt;
    private ImageView bpu;
    private TextView bpv;
    private ImageView bpw;
    private VoiceData.VoiceModel bpx;
    private RelativeLayout bpy;
    private ProgressBar mProgress;

    public ChatVoiceView(Context context) {
        super(context);
        this.bpt = null;
        this.bpv = null;
        this.bpw = null;
        this.mProgress = null;
        com.baidu.adp.lib.g.b.ek().a(context, x.widget_left_voice_view, this, true);
        init();
    }

    public ChatVoiceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        boolean z;
        this.bpt = null;
        this.bpv = null;
        this.bpw = null;
        this.mProgress = null;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ab.ChatVoiceView, 0, 0);
        if (obtainStyledAttributes != null) {
            z = obtainStyledAttributes.getBoolean(0, true);
            obtainStyledAttributes.recycle();
        } else {
            z = true;
        }
        if (z) {
            com.baidu.adp.lib.g.b.ek().a(context, x.widget_left_voice_view, this, true);
        } else {
            com.baidu.adp.lib.g.b.ek().a(context, x.widget_right_voice_view, this, true);
        }
        init();
    }

    private void init() {
        this.bpy = (RelativeLayout) findViewById(w.lay_bubble);
        this.bpt = (ImageView) findViewById(w.img_voice_status);
        this.bpu = (ImageView) findViewById(w.img_voice_status_anim);
        this.bpv = (TextView) findViewById(w.tex_voice_duration);
        this.bpw = (ImageView) findViewById(w.img_voice_readed);
        this.mProgress = (ProgressBar) findViewById(w.progress);
    }

    private void Ts() {
        this.bpt.setVisibility(8);
        this.bpu.setVisibility(0);
        ((AnimationDrawable) this.bpu.getBackground()).start();
    }

    private void Tt() {
        ((AnimationDrawable) this.bpu.getBackground()).stop();
        this.bpu.clearAnimation();
        this.bpt.setVisibility(0);
        this.bpu.setVisibility(8);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        try {
            Tt();
        } catch (Exception e) {
        }
    }

    public void gA(int i) {
    }

    public void gB(int i) {
        if (i == 3) {
            if (this.bpt != null) {
                this.bpt.setVisibility(0);
            }
            this.mProgress.setVisibility(4);
            Ts();
            VoiceMsgData u = i.u(this.bnw);
            if (u != null && u.getHas_read() != 1) {
                u.setHas_read(1);
                this.bnw.setContent("[" + com.baidu.adp.lib.a.b.a.a.i.jsonStrWithObject(u) + "]");
                if (this.bnw instanceof CommonGroupChatMessage) {
                    CommonGroupChatMessage commonGroupChatMessage = (CommonGroupChatMessage) this.bnw;
                    LinkedList linkedList = new LinkedList();
                    linkedList.add(new CommonMsgPojo(commonGroupChatMessage));
                    if (!commonGroupChatMessage.getGroupId().equals(String.valueOf(com.baidu.tieba.im.c.a.bnb))) {
                        com.baidu.tieba.im.i.a(new a(this, commonGroupChatMessage, linkedList), new b(this));
                        return;
                    } else {
                        com.baidu.tieba.im.i.a(new c(this, commonGroupChatMessage, linkedList), new d(this));
                        return;
                    }
                } else if (this.bnw instanceof PersonalChatMessage) {
                    PersonalChatMessage personalChatMessage = (PersonalChatMessage) this.bnw;
                    LinkedList linkedList2 = new LinkedList();
                    linkedList2.add(new CommonMsgPojo(personalChatMessage));
                    com.baidu.tieba.im.i.a(new e(this, personalChatMessage, linkedList2), new f(this));
                    return;
                } else if (this.bnw instanceof OfficialChatMessage) {
                    OfficialChatMessage officialChatMessage = (OfficialChatMessage) this.bnw;
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
        Tt();
        if (i == 1) {
            if (this.bpt != null) {
                this.bpt.setVisibility(0);
            }
            this.mProgress.setVisibility(4);
        } else if (i == 2) {
            if (this.bpt != null) {
                this.bpt.setVisibility(4);
            }
            this.mProgress.setVisibility(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        VoiceManager voiceManager;
        if (this.bpx == null || (voiceManager = getVoiceManager()) == null) {
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
            this.bpw.setVisibility(0);
        } else {
            this.bpw.setVisibility(8);
        }
    }

    public void setData(ChatMessage chatMessage) {
        if (chatMessage != null && chatMessage.getCacheData() != null) {
            this.bpx = chatMessage.getCacheData().getVoice_model();
            if (this.bpx == null) {
                this.bpx = new VoiceData.VoiceModel();
            }
            this.bnw = chatMessage;
            this.bpv.setText(VoiceManager.formatVoiceTime(this.bpx.duration));
            setBubbleLength(this.bpx.duration);
            setTag(this.bpx);
            y(chatMessage);
            gB(this.bpx.voice_status.intValue());
        }
    }

    public void reset() {
        this.bpx = null;
        gB(1);
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
            if (this.bpy.getParent() != null && (this.bpy.getParent() instanceof RelativeLayout)) {
                this.bpy.setLayoutParams(new RelativeLayout.LayoutParams(i2, -2));
                return;
            }
            this.bpy.setLayoutParams(new LinearLayout.LayoutParams(i2, -2));
        } catch (Exception e) {
        }
    }

    public boolean isPlaying() {
        return this.bpx != null && this.bpx.voice_status.intValue() == 3;
    }

    @Override // com.baidu.tbadk.core.voice.m
    public void qI() {
    }

    @Override // com.baidu.tbadk.core.voice.m
    public void a(VoiceData.VoiceModel voiceModel) {
        if (voiceModel != null) {
            gB(voiceModel.voice_status.intValue());
        }
    }

    @Override // com.baidu.tbadk.core.voice.m
    public void cn(int i) {
        gA(i);
        if (this.bpx != null) {
            this.bpx.elapse = i;
        }
    }

    @Override // com.baidu.tbadk.core.voice.m
    public void onShowErr(int i, String str) {
        l.t(getContext(), str);
    }

    @Override // com.baidu.tbadk.core.voice.m
    public VoiceData.VoiceModel getVoiceModel() {
        return this.bpx;
    }

    @Override // com.baidu.tbadk.core.voice.m
    public m getRealView() {
        Context context = getContext();
        m realView = context instanceof o ? ((o) context).getRealView(this.bpx) : this;
        return realView == null ? this : realView;
    }
}
