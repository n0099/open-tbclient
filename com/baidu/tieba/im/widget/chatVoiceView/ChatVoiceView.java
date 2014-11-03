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
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.core.voice.m;
import com.baidu.tbadk.core.voice.o;
import com.baidu.tieba.aa;
import com.baidu.tieba.im.data.VoiceMsgData;
import com.baidu.tieba.im.db.pojo.CommonMsgPojo;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.message.chat.CommonGroupChatMessage;
import com.baidu.tieba.im.message.chat.OfficialChatMessage;
import com.baidu.tieba.im.message.chat.PersonalChatMessage;
import com.baidu.tieba.im.util.i;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class ChatVoiceView extends LinearLayout implements View.OnClickListener, m {
    private ImageView bke;
    private ImageView bkf;
    private TextView bkg;
    private ImageView bkh;
    private VoiceData.VoiceModel bki;
    private RelativeLayout bkj;
    private ChatMessage mChatMessage;
    private ProgressBar mProgress;

    public ChatVoiceView(Context context) {
        super(context);
        this.bke = null;
        this.bkg = null;
        this.bkh = null;
        this.mProgress = null;
        com.baidu.adp.lib.g.b.ek().a(context, w.widget_left_voice_view, this, true);
        init();
    }

    public ChatVoiceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        boolean z;
        this.bke = null;
        this.bkg = null;
        this.bkh = null;
        this.mProgress = null;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, aa.ChatVoiceView, 0, 0);
        if (obtainStyledAttributes != null) {
            z = obtainStyledAttributes.getBoolean(0, true);
            obtainStyledAttributes.recycle();
        } else {
            z = true;
        }
        if (z) {
            com.baidu.adp.lib.g.b.ek().a(context, w.widget_left_voice_view, this, true);
        } else {
            com.baidu.adp.lib.g.b.ek().a(context, w.widget_right_voice_view, this, true);
        }
        init();
    }

    private void init() {
        this.bkj = (RelativeLayout) findViewById(v.lay_bubble);
        this.bke = (ImageView) findViewById(v.img_voice_status);
        this.bkf = (ImageView) findViewById(v.img_voice_status_anim);
        this.bkg = (TextView) findViewById(v.tex_voice_duration);
        this.bkh = (ImageView) findViewById(v.img_voice_readed);
        this.mProgress = (ProgressBar) findViewById(v.progress);
    }

    private void Sa() {
        this.bke.setVisibility(8);
        this.bkf.setVisibility(0);
        ((AnimationDrawable) this.bkf.getBackground()).start();
    }

    private void Sb() {
        ((AnimationDrawable) this.bkf.getBackground()).stop();
        this.bkf.clearAnimation();
        this.bke.setVisibility(0);
        this.bkf.setVisibility(8);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        try {
            Sb();
        } catch (Exception e) {
        }
    }

    public void gn(int i) {
    }

    public void go(int i) {
        if (i == 3) {
            if (this.bke != null) {
                this.bke.setVisibility(0);
            }
            this.mProgress.setVisibility(4);
            Sa();
            VoiceMsgData v = i.v(this.mChatMessage);
            if (v != null && v.getHas_read() != 1) {
                v.setHas_read(1);
                this.mChatMessage.setContent("[" + com.baidu.adp.lib.a.b.a.a.i.jsonStrWithObject(v) + "]");
                if (this.mChatMessage instanceof CommonGroupChatMessage) {
                    CommonGroupChatMessage commonGroupChatMessage = (CommonGroupChatMessage) this.mChatMessage;
                    LinkedList linkedList = new LinkedList();
                    linkedList.add(new CommonMsgPojo(commonGroupChatMessage));
                    if (!commonGroupChatMessage.getGroupId().equals(String.valueOf(com.baidu.tieba.im.chat.w.aNT))) {
                        com.baidu.tieba.im.e.a(new a(this, commonGroupChatMessage, linkedList), new b(this));
                        return;
                    } else {
                        com.baidu.tieba.im.e.a(new c(this, commonGroupChatMessage, linkedList), new d(this));
                        return;
                    }
                } else if (this.mChatMessage instanceof PersonalChatMessage) {
                    PersonalChatMessage personalChatMessage = (PersonalChatMessage) this.mChatMessage;
                    LinkedList linkedList2 = new LinkedList();
                    linkedList2.add(new CommonMsgPojo(personalChatMessage));
                    com.baidu.tieba.im.e.a(new e(this, personalChatMessage, linkedList2), new f(this));
                    return;
                } else if (this.mChatMessage instanceof OfficialChatMessage) {
                    OfficialChatMessage officialChatMessage = (OfficialChatMessage) this.mChatMessage;
                    LinkedList linkedList3 = new LinkedList();
                    linkedList3.add(new CommonMsgPojo(officialChatMessage));
                    com.baidu.tieba.im.e.a(new g(this, officialChatMessage, linkedList3), new h(this));
                    return;
                } else {
                    return;
                }
            }
            return;
        }
        Sb();
        if (i == 1) {
            if (this.bke != null) {
                this.bke.setVisibility(0);
            }
            this.mProgress.setVisibility(4);
        } else if (i == 2) {
            if (this.bke != null) {
                this.bke.setVisibility(4);
            }
            this.mProgress.setVisibility(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        VoiceManager voiceManager;
        if (this.bki == null || (voiceManager = getVoiceManager()) == null) {
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

    private void z(ChatMessage chatMessage) {
        boolean z = true;
        if (i.s(chatMessage)) {
            z = false;
        } else {
            VoiceMsgData v = i.v(chatMessage);
            if (v != null && v.getHas_read() == 1) {
                z = false;
            }
        }
        if (z) {
            this.bkh.setVisibility(0);
        } else {
            this.bkh.setVisibility(8);
        }
    }

    public void setData(ChatMessage chatMessage) {
        if (chatMessage != null && chatMessage.getCacheData() != null) {
            this.bki = chatMessage.getCacheData().getVoice_model();
            if (this.bki == null) {
                this.bki = new VoiceData.VoiceModel();
            }
            this.mChatMessage = chatMessage;
            this.bkg.setText(VoiceManager.formatVoiceTime(this.bki.duration));
            setBubbleLength(this.bki.duration);
            setTag(this.bki);
            z(chatMessage);
            go(this.bki.voice_status.intValue());
        }
    }

    public void reset() {
        this.bki = null;
        go(1);
    }

    private void setBubbleLength(int i) {
        int i2;
        int n = com.baidu.adp.lib.util.m.n(getContext());
        if (i <= 10) {
            int i3 = (int) (n * 0.1875d);
            i2 = (((((int) (n * 0.4125d)) - i3) * (i - 1)) / 10) + i3;
        } else if (i <= 30) {
            int i4 = (int) (n * 0.4125d);
            i2 = (((((int) (n * 0.5375d)) - i4) * (i - 10)) / 20) + i4;
        } else {
            i2 = (int) (n * 0.5375d);
        }
        try {
            if (this.bkj.getParent() != null && (this.bkj.getParent() instanceof RelativeLayout)) {
                this.bkj.setLayoutParams(new RelativeLayout.LayoutParams(i2, -2));
                return;
            }
            this.bkj.setLayoutParams(new LinearLayout.LayoutParams(i2, -2));
        } catch (Exception e) {
        }
    }

    public boolean isPlaying() {
        return this.bki != null && this.bki.voice_status.intValue() == 3;
    }

    @Override // com.baidu.tbadk.core.voice.m
    public void nH() {
    }

    @Override // com.baidu.tbadk.core.voice.m
    public void a(VoiceData.VoiceModel voiceModel) {
        if (voiceModel != null) {
            go(voiceModel.voice_status.intValue());
        }
    }

    @Override // com.baidu.tbadk.core.voice.m
    public void bP(int i) {
        gn(i);
        if (this.bki != null) {
            this.bki.elapse = i;
        }
    }

    @Override // com.baidu.tbadk.core.voice.m
    public void onShowErr(int i, String str) {
        com.baidu.adp.lib.util.m.g(getContext(), str);
    }

    @Override // com.baidu.tbadk.core.voice.m
    public VoiceData.VoiceModel getVoiceModel() {
        return this.bki;
    }

    @Override // com.baidu.tbadk.core.voice.m
    public m getRealView() {
        Context context = getContext();
        m b = context instanceof o ? ((o) context).b(this.bki) : this;
        return b == null ? this : b;
    }
}
