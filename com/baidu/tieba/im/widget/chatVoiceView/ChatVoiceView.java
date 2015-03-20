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
import com.baidu.tieba.aa;
import com.baidu.tieba.im.data.VoiceMsgData;
import com.baidu.tieba.im.db.pojo.CommonMsgPojo;
import com.baidu.tieba.im.l;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.message.chat.CommonGroupChatMessage;
import com.baidu.tieba.im.message.chat.OfficialChatMessage;
import com.baidu.tieba.im.message.chat.PersonalChatMessage;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class ChatVoiceView extends LinearLayout implements View.OnClickListener, i {
    private ChatMessage bmQ;
    private ImageView bop;
    private ImageView boq;
    private TextView bor;
    private ImageView bos;
    private VoiceData.VoiceModel bot;
    private RelativeLayout bou;
    private ProgressBar mProgress;

    public ChatVoiceView(Context context) {
        super(context);
        this.bop = null;
        this.bor = null;
        this.bos = null;
        this.mProgress = null;
        com.baidu.adp.lib.g.b.hH().a(context, w.widget_left_voice_view, this, true);
        init();
    }

    public ChatVoiceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        boolean z;
        this.bop = null;
        this.bor = null;
        this.bos = null;
        this.mProgress = null;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, aa.ChatVoiceView, 0, 0);
        if (obtainStyledAttributes != null) {
            z = obtainStyledAttributes.getBoolean(0, true);
            obtainStyledAttributes.recycle();
        } else {
            z = true;
        }
        if (z) {
            com.baidu.adp.lib.g.b.hH().a(context, w.widget_left_voice_view, this, true);
        } else {
            com.baidu.adp.lib.g.b.hH().a(context, w.widget_right_voice_view, this, true);
        }
        init();
    }

    private void init() {
        this.bou = (RelativeLayout) findViewById(v.lay_bubble);
        this.bop = (ImageView) findViewById(v.img_voice_status);
        this.boq = (ImageView) findViewById(v.img_voice_status_anim);
        this.bor = (TextView) findViewById(v.tex_voice_duration);
        this.bos = (ImageView) findViewById(v.img_voice_readed);
        this.mProgress = (ProgressBar) findViewById(v.progress);
    }

    private void TJ() {
        this.bop.setVisibility(8);
        this.boq.setVisibility(0);
        ((AnimationDrawable) this.boq.getBackground()).start();
    }

    private void TK() {
        ((AnimationDrawable) this.boq.getBackground()).stop();
        this.boq.clearAnimation();
        this.bop.setVisibility(0);
        this.boq.setVisibility(8);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        try {
            TK();
        } catch (Exception e) {
        }
    }

    public void gq(int i) {
    }

    public void gr(int i) {
        if (i == 3) {
            if (this.bop != null) {
                this.bop.setVisibility(0);
            }
            this.mProgress.setVisibility(4);
            TJ();
            VoiceMsgData v = com.baidu.tieba.im.util.i.v(this.bmQ);
            if (v != null && v.getHas_read() != 1) {
                v.setHas_read(1);
                this.bmQ.setContent("[" + com.baidu.adp.lib.a.b.a.a.i.jsonStrWithObject(v) + "]");
                if (this.bmQ instanceof CommonGroupChatMessage) {
                    CommonGroupChatMessage commonGroupChatMessage = (CommonGroupChatMessage) this.bmQ;
                    LinkedList linkedList = new LinkedList();
                    linkedList.add(new CommonMsgPojo(commonGroupChatMessage));
                    if (!commonGroupChatMessage.getGroupId().equals(String.valueOf(com.baidu.tieba.im.c.a.bmu))) {
                        l.a(new a(this, commonGroupChatMessage, linkedList), new b(this));
                        return;
                    } else {
                        l.a(new c(this, commonGroupChatMessage, linkedList), new d(this));
                        return;
                    }
                } else if (this.bmQ instanceof PersonalChatMessage) {
                    PersonalChatMessage personalChatMessage = (PersonalChatMessage) this.bmQ;
                    LinkedList linkedList2 = new LinkedList();
                    linkedList2.add(new CommonMsgPojo(personalChatMessage));
                    l.a(new e(this, personalChatMessage, linkedList2), new f(this));
                    return;
                } else if (this.bmQ instanceof OfficialChatMessage) {
                    OfficialChatMessage officialChatMessage = (OfficialChatMessage) this.bmQ;
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
        TK();
        if (i == 1) {
            if (this.bop != null) {
                this.bop.setVisibility(0);
            }
            this.mProgress.setVisibility(4);
        } else if (i == 2) {
            if (this.bop != null) {
                this.bop.setVisibility(4);
            }
            this.mProgress.setVisibility(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        VoiceManager voiceManager;
        if (this.bot == null || (voiceManager = getVoiceManager()) == null) {
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
            this.bos.setVisibility(0);
        } else {
            this.bos.setVisibility(8);
        }
    }

    public void setData(ChatMessage chatMessage) {
        if (chatMessage != null && chatMessage.getCacheData() != null) {
            this.bot = chatMessage.getCacheData().getVoice_model();
            if (this.bot == null) {
                this.bot = new VoiceData.VoiceModel();
            }
            this.bmQ = chatMessage;
            this.bor.setText(VoiceManager.formatVoiceTime(this.bot.duration));
            setBubbleLength(this.bot.duration);
            setTag(this.bot);
            z(chatMessage);
            gr(this.bot.voice_status.intValue());
        }
    }

    public void reset() {
        this.bot = null;
        gr(1);
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
            if (this.bou.getParent() != null && (this.bou.getParent() instanceof RelativeLayout)) {
                this.bou.setLayoutParams(new RelativeLayout.LayoutParams(i2, -2));
                return;
            }
            this.bou.setLayoutParams(new LinearLayout.LayoutParams(i2, -2));
        } catch (Exception e) {
        }
    }

    public boolean isPlaying() {
        return this.bot != null && this.bot.voice_status.intValue() == 3;
    }

    @Override // com.baidu.tbadk.core.voice.i
    public void og() {
    }

    @Override // com.baidu.tbadk.core.voice.i
    public void b(VoiceData.VoiceModel voiceModel) {
        if (voiceModel != null) {
            gr(voiceModel.voice_status.intValue());
        }
    }

    @Override // com.baidu.tbadk.core.voice.i
    public void aI(int i) {
        gq(i);
        if (this.bot != null) {
            this.bot.elapse = i;
        }
    }

    @Override // com.baidu.tbadk.core.voice.i
    public void onShowErr(int i, String str) {
        n.t(getContext(), str);
    }

    @Override // com.baidu.tbadk.core.voice.i
    public VoiceData.VoiceModel getVoiceModel() {
        return this.bot;
    }

    @Override // com.baidu.tbadk.core.voice.i
    public i getRealView() {
        Context context = getContext();
        i realView = context instanceof j ? ((j) context).getRealView(this.bot) : this;
        return realView == null ? this : realView;
    }
}
