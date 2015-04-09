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
    private ChatMessage bng;
    private ImageView boF;
    private ImageView boG;
    private TextView boH;
    private ImageView boI;
    private VoiceData.VoiceModel boJ;
    private RelativeLayout boK;
    private ProgressBar mProgress;

    public ChatVoiceView(Context context) {
        super(context);
        this.boF = null;
        this.boH = null;
        this.boI = null;
        this.mProgress = null;
        com.baidu.adp.lib.g.b.hH().a(context, w.widget_left_voice_view, this, true);
        init();
    }

    public ChatVoiceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        boolean z;
        this.boF = null;
        this.boH = null;
        this.boI = null;
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
        this.boK = (RelativeLayout) findViewById(v.lay_bubble);
        this.boF = (ImageView) findViewById(v.img_voice_status);
        this.boG = (ImageView) findViewById(v.img_voice_status_anim);
        this.boH = (TextView) findViewById(v.tex_voice_duration);
        this.boI = (ImageView) findViewById(v.img_voice_readed);
        this.mProgress = (ProgressBar) findViewById(v.progress);
    }

    private void TW() {
        this.boF.setVisibility(8);
        this.boG.setVisibility(0);
        ((AnimationDrawable) this.boG.getBackground()).start();
    }

    private void TX() {
        ((AnimationDrawable) this.boG.getBackground()).stop();
        this.boG.clearAnimation();
        this.boF.setVisibility(0);
        this.boG.setVisibility(8);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        try {
            TX();
        } catch (Exception e) {
        }
    }

    public void gs(int i) {
    }

    public void gt(int i) {
        if (i == 3) {
            if (this.boF != null) {
                this.boF.setVisibility(0);
            }
            this.mProgress.setVisibility(4);
            TW();
            VoiceMsgData v = com.baidu.tieba.im.util.i.v(this.bng);
            if (v != null && v.getHas_read() != 1) {
                v.setHas_read(1);
                this.bng.setContent("[" + com.baidu.adp.lib.a.b.a.a.i.jsonStrWithObject(v) + "]");
                if (this.bng instanceof CommonGroupChatMessage) {
                    CommonGroupChatMessage commonGroupChatMessage = (CommonGroupChatMessage) this.bng;
                    LinkedList linkedList = new LinkedList();
                    linkedList.add(new CommonMsgPojo(commonGroupChatMessage));
                    if (!commonGroupChatMessage.getGroupId().equals(String.valueOf(com.baidu.tieba.im.c.a.bmK))) {
                        l.a(new a(this, commonGroupChatMessage, linkedList), new b(this));
                        return;
                    } else {
                        l.a(new c(this, commonGroupChatMessage, linkedList), new d(this));
                        return;
                    }
                } else if (this.bng instanceof PersonalChatMessage) {
                    PersonalChatMessage personalChatMessage = (PersonalChatMessage) this.bng;
                    LinkedList linkedList2 = new LinkedList();
                    linkedList2.add(new CommonMsgPojo(personalChatMessage));
                    l.a(new e(this, personalChatMessage, linkedList2), new f(this));
                    return;
                } else if (this.bng instanceof OfficialChatMessage) {
                    OfficialChatMessage officialChatMessage = (OfficialChatMessage) this.bng;
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
        TX();
        if (i == 1) {
            if (this.boF != null) {
                this.boF.setVisibility(0);
            }
            this.mProgress.setVisibility(4);
        } else if (i == 2) {
            if (this.boF != null) {
                this.boF.setVisibility(4);
            }
            this.mProgress.setVisibility(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        VoiceManager voiceManager;
        if (this.boJ == null || (voiceManager = getVoiceManager()) == null) {
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
            this.boI.setVisibility(0);
        } else {
            this.boI.setVisibility(8);
        }
    }

    public void setData(ChatMessage chatMessage) {
        if (chatMessage != null && chatMessage.getCacheData() != null) {
            this.boJ = chatMessage.getCacheData().getVoice_model();
            if (this.boJ == null) {
                this.boJ = new VoiceData.VoiceModel();
            }
            this.bng = chatMessage;
            this.boH.setText(VoiceManager.formatVoiceTime(this.boJ.duration));
            setBubbleLength(this.boJ.duration);
            setTag(this.boJ);
            z(chatMessage);
            gt(this.boJ.voice_status.intValue());
        }
    }

    public void reset() {
        this.boJ = null;
        gt(1);
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
            if (this.boK.getParent() != null && (this.boK.getParent() instanceof RelativeLayout)) {
                this.boK.setLayoutParams(new RelativeLayout.LayoutParams(i2, -2));
                return;
            }
            this.boK.setLayoutParams(new LinearLayout.LayoutParams(i2, -2));
        } catch (Exception e) {
        }
    }

    public boolean isPlaying() {
        return this.boJ != null && this.boJ.voice_status.intValue() == 3;
    }

    @Override // com.baidu.tbadk.core.voice.i
    public void og() {
    }

    @Override // com.baidu.tbadk.core.voice.i
    public void b(VoiceData.VoiceModel voiceModel) {
        if (voiceModel != null) {
            gt(voiceModel.voice_status.intValue());
        }
    }

    @Override // com.baidu.tbadk.core.voice.i
    public void aI(int i) {
        gs(i);
        if (this.boJ != null) {
            this.boJ.elapse = i;
        }
    }

    @Override // com.baidu.tbadk.core.voice.i
    public void onShowErr(int i, String str) {
        n.t(getContext(), str);
    }

    @Override // com.baidu.tbadk.core.voice.i
    public VoiceData.VoiceModel getVoiceModel() {
        return this.boJ;
    }

    @Override // com.baidu.tbadk.core.voice.i
    public i getRealView() {
        Context context = getContext();
        i realView = context instanceof j ? ((j) context).getRealView(this.boJ) : this;
        return realView == null ? this : realView;
    }
}
