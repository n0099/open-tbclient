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
    private ChatMessage dgH;
    private ImageView din;
    private ImageView dio;
    private TextView dip;
    private ImageView diq;
    private VoiceData.VoiceModel dir;
    private RelativeLayout dis;
    private ProgressBar mProgress;

    public ChatVoiceView(Context context) {
        super(context);
        this.din = null;
        this.dip = null;
        this.diq = null;
        this.mProgress = null;
        LayoutInflater.from(context).inflate(w.j.widget_left_voice_view, (ViewGroup) this, true);
        init();
    }

    public ChatVoiceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        boolean z;
        this.din = null;
        this.dip = null;
        this.diq = null;
        this.mProgress = null;
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
        this.dis = (RelativeLayout) findViewById(w.h.lay_bubble);
        this.din = (ImageView) findViewById(w.h.img_voice_status);
        this.dio = (ImageView) findViewById(w.h.img_voice_status_anim);
        this.dip = (TextView) findViewById(w.h.tex_voice_duration);
        this.diq = (ImageView) findViewById(w.h.img_voice_readed);
        this.mProgress = (ProgressBar) findViewById(w.h.progress);
    }

    private void asP() {
        this.din.setVisibility(8);
        this.dio.setVisibility(0);
        ((AnimationDrawable) this.dio.getBackground()).start();
    }

    private void asQ() {
        ((AnimationDrawable) this.dio.getBackground()).stop();
        this.dio.clearAnimation();
        this.din.setVisibility(0);
        this.dio.setVisibility(8);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        try {
            asQ();
        } catch (Exception e) {
        }
    }

    public void mm(int i) {
    }

    public void mn(int i) {
        if (i == 3) {
            if (this.din != null) {
                this.din.setVisibility(0);
            }
            this.mProgress.setVisibility(4);
            asP();
            VoiceMsgData w = com.baidu.tieba.im.util.h.w(this.dgH);
            if (w != null && w.getHas_read() != 1) {
                w.setHas_read(1);
                this.dgH.setContent("[" + OrmObject.jsonStrWithObject(w) + "]");
                if (this.dgH instanceof CommonGroupChatMessage) {
                    CommonGroupChatMessage commonGroupChatMessage = (CommonGroupChatMessage) this.dgH;
                    LinkedList linkedList = new LinkedList();
                    linkedList.add(new CommonMsgPojo(commonGroupChatMessage));
                    if (!commonGroupChatMessage.getGroupId().equals(String.valueOf(com.baidu.tieba.im.sendmessage.a.dgj))) {
                        com.baidu.tbadk.util.w.b(new a(this, commonGroupChatMessage, linkedList), new b(this));
                        return;
                    } else {
                        com.baidu.tbadk.util.w.b(new c(this, commonGroupChatMessage, linkedList), new d(this));
                        return;
                    }
                } else if (this.dgH instanceof PersonalChatMessage) {
                    PersonalChatMessage personalChatMessage = (PersonalChatMessage) this.dgH;
                    LinkedList linkedList2 = new LinkedList();
                    linkedList2.add(new CommonMsgPojo(personalChatMessage));
                    com.baidu.tbadk.util.w.b(new e(this, personalChatMessage, linkedList2), new f(this));
                    return;
                } else if (this.dgH instanceof OfficialChatMessage) {
                    OfficialChatMessage officialChatMessage = (OfficialChatMessage) this.dgH;
                    LinkedList linkedList3 = new LinkedList();
                    linkedList3.add(new CommonMsgPojo(officialChatMessage));
                    com.baidu.tbadk.util.w.b(new g(this, officialChatMessage, linkedList3), new h(this));
                    return;
                } else {
                    return;
                }
            }
            return;
        }
        asQ();
        if (i == 1) {
            if (this.din != null) {
                this.din.setVisibility(0);
            }
            this.mProgress.setVisibility(4);
        } else if (i == 2) {
            if (this.din != null) {
                this.din.setVisibility(4);
            }
            this.mProgress.setVisibility(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        VoiceManager voiceManager;
        if (this.dir == null || (voiceManager = getVoiceManager()) == null) {
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

    private void B(ChatMessage chatMessage) {
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
            this.diq.setVisibility(0);
        } else {
            this.diq.setVisibility(8);
        }
    }

    public void setData(ChatMessage chatMessage) {
        VoiceManager voiceManager;
        if (chatMessage != null && chatMessage.getCacheData() != null) {
            this.dir = chatMessage.getCacheData().getVoice_model();
            if (this.dir == null) {
                this.dir = new VoiceData.VoiceModel();
            }
            this.dgH = chatMessage;
            this.dip.setText(VoiceManager.formatVoiceTime(this.dir.duration));
            this.dip.setContentDescription(String.format(getContext().getString(w.l.editor_record_format), VoiceManager.formatVoiceTime(this.dir.duration)));
            setBubbleLength(this.dir.duration);
            setTag(this.dir);
            B(chatMessage);
            if (this.dir.voice_status.intValue() != 1 && (voiceManager = getVoiceManager()) != null) {
                voiceManager.resetPlayView(this);
            }
            mn(this.dir.voice_status.intValue());
        }
    }

    public void reset() {
        this.dir = null;
        mn(1);
    }

    private void setBubbleLength(int i) {
        int i2;
        int af = k.af(getContext());
        if (i <= 10) {
            int i3 = (int) (af * 0.1875d);
            i2 = (((((int) (af * 0.4125d)) - i3) * (i - 1)) / 10) + i3;
        } else if (i <= 30) {
            int i4 = (int) (af * 0.4125d);
            i2 = (((((int) (af * 0.5375d)) - i4) * (i - 10)) / 20) + i4;
        } else {
            i2 = (int) (af * 0.5375d);
        }
        try {
            if (this.dis.getParent() != null && (this.dis.getParent() instanceof RelativeLayout)) {
                this.dis.setLayoutParams(new RelativeLayout.LayoutParams(i2, -2));
                return;
            }
            this.dis.setLayoutParams(new LinearLayout.LayoutParams(i2, -2));
        } catch (Exception e) {
        }
    }

    public boolean isPlaying() {
        return this.dir != null && this.dir.voice_status.intValue() == 3;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void lV() {
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void b(VoiceData.VoiceModel voiceModel) {
        if (voiceModel != null) {
            mn(voiceModel.voice_status.intValue());
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void aP(int i) {
        mm(i);
        if (this.dir != null) {
            this.dir.elapse = i;
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void onShowErr(int i, String str) {
        k.E(getContext(), str);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceData.VoiceModel getVoiceModel() {
        return this.dir;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceManager.b getRealView() {
        Context context = getContext();
        VoiceManager.b c = context instanceof VoiceManager.c ? ((VoiceManager.c) context).c(this.dir) : this;
        return c == null ? this : c;
    }
}
