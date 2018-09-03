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
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.util.g;
import com.baidu.tbadk.util.u;
import com.baidu.tbadk.util.v;
import com.baidu.tieba.f;
import com.baidu.tieba.im.data.VoiceMsgData;
import com.baidu.tieba.im.db.c;
import com.baidu.tieba.im.db.l;
import com.baidu.tieba.im.db.m;
import com.baidu.tieba.im.db.pojo.CommonMsgPojo;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.message.chat.CommonGroupChatMessage;
import com.baidu.tieba.im.message.chat.OfficialChatMessage;
import com.baidu.tieba.im.message.chat.PersonalChatMessage;
import com.baidu.tieba.im.sendmessage.a;
import com.baidu.tieba.im.util.e;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class ChatVoiceView extends LinearLayout implements View.OnClickListener, VoiceManager.b {
    private ChatMessage eBK;
    private ImageView eDm;
    private ImageView eDn;
    private TextView eDo;
    private ImageView eDp;
    private VoiceData.VoiceModel eDq;
    private RelativeLayout eDr;
    private ProgressBar mProgress;

    public ChatVoiceView(Context context) {
        super(context);
        this.eDm = null;
        this.eDo = null;
        this.eDp = null;
        this.mProgress = null;
        LayoutInflater.from(context).inflate(f.h.widget_left_voice_view, (ViewGroup) this, true);
        init();
    }

    public ChatVoiceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        boolean z;
        this.eDm = null;
        this.eDo = null;
        this.eDp = null;
        this.mProgress = null;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f.l.ChatVoiceView, 0, 0);
        if (obtainStyledAttributes != null) {
            z = obtainStyledAttributes.getBoolean(f.l.ChatVoiceView_is_left, true);
            obtainStyledAttributes.recycle();
        } else {
            z = true;
        }
        if (z) {
            LayoutInflater.from(context).inflate(f.h.widget_left_voice_view, (ViewGroup) this, true);
        } else {
            LayoutInflater.from(context).inflate(f.h.widget_right_voice_view, (ViewGroup) this, true);
        }
        init();
    }

    private void init() {
        this.eDr = (RelativeLayout) findViewById(f.g.lay_bubble);
        this.eDm = (ImageView) findViewById(f.g.img_voice_status);
        this.eDn = (ImageView) findViewById(f.g.img_voice_status_anim);
        this.eDo = (TextView) findViewById(f.g.tex_voice_duration);
        this.eDp = (ImageView) findViewById(f.g.img_voice_readed);
        this.mProgress = (ProgressBar) findViewById(f.g.progress);
    }

    private void aNN() {
        this.eDm.setVisibility(8);
        this.eDn.setVisibility(0);
        ((AnimationDrawable) this.eDn.getBackground()).start();
    }

    private void aNO() {
        ((AnimationDrawable) this.eDn.getBackground()).stop();
        this.eDn.clearAnimation();
        this.eDm.setVisibility(0);
        this.eDn.setVisibility(8);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        try {
            aNO();
        } catch (Exception e) {
        }
    }

    public void oG(int i) {
    }

    public void oH(int i) {
        if (i == 3) {
            if (this.eDm != null) {
                this.eDm.setVisibility(0);
            }
            this.mProgress.setVisibility(4);
            aNN();
            VoiceMsgData z = e.z(this.eBK);
            if (z != null && z.getHas_read() != 1) {
                z.setHas_read(1);
                this.eBK.setContent("[" + OrmObject.jsonStrWithObject(z) + "]");
                if (this.eBK instanceof CommonGroupChatMessage) {
                    final CommonGroupChatMessage commonGroupChatMessage = (CommonGroupChatMessage) this.eBK;
                    final LinkedList linkedList = new LinkedList();
                    linkedList.add(new CommonMsgPojo(commonGroupChatMessage));
                    if (!commonGroupChatMessage.getGroupId().equals(String.valueOf(a.eBm))) {
                        v.b(new u<Boolean>() { // from class: com.baidu.tieba.im.widget.chatVoiceView.ChatVoiceView.1
                            /* JADX DEBUG: Method merged with bridge method */
                            /* JADX WARN: Can't rename method to resolve collision */
                            @Override // com.baidu.tbadk.util.u
                            public Boolean doInBackground() {
                                return Boolean.valueOf(c.aJw().a(commonGroupChatMessage.getGroupId(), linkedList, false));
                            }
                        }, new g<Boolean>() { // from class: com.baidu.tieba.im.widget.chatVoiceView.ChatVoiceView.2
                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // com.baidu.tbadk.util.g
                            public void onReturnDataInUI(Boolean bool) {
                                ChatVoiceView.this.eDp.setVisibility(8);
                            }
                        });
                        return;
                    } else {
                        v.b(new u<Boolean>() { // from class: com.baidu.tieba.im.widget.chatVoiceView.ChatVoiceView.3
                            /* JADX DEBUG: Method merged with bridge method */
                            /* JADX WARN: Can't rename method to resolve collision */
                            @Override // com.baidu.tbadk.util.u
                            public Boolean doInBackground() {
                                return Boolean.valueOf(m.aJO().a(e.s(commonGroupChatMessage), linkedList, false));
                            }
                        }, new g<Boolean>() { // from class: com.baidu.tieba.im.widget.chatVoiceView.ChatVoiceView.4
                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // com.baidu.tbadk.util.g
                            public void onReturnDataInUI(Boolean bool) {
                                ChatVoiceView.this.eDp.setVisibility(8);
                            }
                        });
                        return;
                    }
                } else if (this.eBK instanceof PersonalChatMessage) {
                    final PersonalChatMessage personalChatMessage = (PersonalChatMessage) this.eBK;
                    final LinkedList linkedList2 = new LinkedList();
                    linkedList2.add(new CommonMsgPojo(personalChatMessage));
                    v.b(new u<Boolean>() { // from class: com.baidu.tieba.im.widget.chatVoiceView.ChatVoiceView.5
                        /* JADX DEBUG: Method merged with bridge method */
                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // com.baidu.tbadk.util.u
                        public Boolean doInBackground() {
                            return Boolean.valueOf(m.aJO().a(e.s(personalChatMessage), linkedList2, false));
                        }
                    }, new g<Boolean>() { // from class: com.baidu.tieba.im.widget.chatVoiceView.ChatVoiceView.6
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.tbadk.util.g
                        public void onReturnDataInUI(Boolean bool) {
                            ChatVoiceView.this.eDp.setVisibility(8);
                        }
                    });
                    return;
                } else if (this.eBK instanceof OfficialChatMessage) {
                    final OfficialChatMessage officialChatMessage = (OfficialChatMessage) this.eBK;
                    final LinkedList linkedList3 = new LinkedList();
                    linkedList3.add(new CommonMsgPojo(officialChatMessage));
                    v.b(new u<Boolean>() { // from class: com.baidu.tieba.im.widget.chatVoiceView.ChatVoiceView.7
                        /* JADX DEBUG: Method merged with bridge method */
                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // com.baidu.tbadk.util.u
                        public Boolean doInBackground() {
                            return Boolean.valueOf(l.aJM().a(e.s(officialChatMessage), linkedList3, false));
                        }
                    }, new g<Boolean>() { // from class: com.baidu.tieba.im.widget.chatVoiceView.ChatVoiceView.8
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.tbadk.util.g
                        public void onReturnDataInUI(Boolean bool) {
                            ChatVoiceView.this.eDp.setVisibility(8);
                        }
                    });
                    return;
                } else {
                    return;
                }
            }
            return;
        }
        aNO();
        if (i == 1) {
            if (this.eDm != null) {
                this.eDm.setVisibility(0);
            }
            this.mProgress.setVisibility(4);
        } else if (i == 2) {
            if (this.eDm != null) {
                this.eDm.setVisibility(4);
            }
            this.mProgress.setVisibility(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        VoiceManager voiceManager;
        if (this.eDq == null || (voiceManager = getVoiceManager()) == null) {
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

    private void E(ChatMessage chatMessage) {
        boolean z = true;
        if (e.w(chatMessage)) {
            z = false;
        } else {
            VoiceMsgData z2 = e.z(chatMessage);
            if (z2 != null && z2.getHas_read() == 1) {
                z = false;
            }
        }
        if (z) {
            this.eDp.setVisibility(0);
        } else {
            this.eDp.setVisibility(8);
        }
    }

    public void setData(ChatMessage chatMessage) {
        VoiceManager voiceManager;
        if (chatMessage != null && chatMessage.getCacheData() != null) {
            this.eDq = chatMessage.getCacheData().getVoice_model();
            if (this.eDq == null) {
                this.eDq = new VoiceData.VoiceModel();
            }
            this.eBK = chatMessage;
            this.eDo.setText(VoiceManager.formatVoiceTime(this.eDq.duration));
            this.eDo.setContentDescription(String.format(getContext().getString(f.j.editor_record_format), VoiceManager.formatVoiceTime(this.eDq.duration)));
            setBubbleLength(this.eDq.duration);
            setTag(this.eDq);
            E(chatMessage);
            if (this.eDq.voice_status.intValue() != 1 && (voiceManager = getVoiceManager()) != null) {
                voiceManager.resetPlayView(this);
            }
            oH(this.eDq.voice_status.intValue());
        }
    }

    public void reset() {
        this.eDq = null;
        oH(1);
    }

    private void setBubbleLength(int i) {
        int i2;
        int ah = com.baidu.adp.lib.util.l.ah(getContext());
        if (i <= 10) {
            int i3 = (int) (ah * 0.1875d);
            i2 = (((((int) (ah * 0.4125d)) - i3) * (i - 1)) / 10) + i3;
        } else if (i <= 30) {
            int i4 = (int) (ah * 0.4125d);
            i2 = (((((int) (ah * 0.5375d)) - i4) * (i - 10)) / 20) + i4;
        } else {
            i2 = (int) (ah * 0.5375d);
        }
        try {
            if (this.eDr.getParent() != null && (this.eDr.getParent() instanceof RelativeLayout)) {
                this.eDr.setLayoutParams(new RelativeLayout.LayoutParams(i2, -2));
                return;
            }
            this.eDr.setLayoutParams(new LinearLayout.LayoutParams(i2, -2));
        } catch (Exception e) {
        }
    }

    public boolean isPlaying() {
        return this.eDq != null && this.eDq.voice_status.intValue() == 3;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void oP() {
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void b(VoiceData.VoiceModel voiceModel) {
        if (voiceModel != null) {
            oH(voiceModel.voice_status.intValue());
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void ba(int i) {
        oG(i);
        if (this.eDq != null) {
            this.eDq.elapse = i;
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void onShowErr(int i, String str) {
        com.baidu.adp.lib.util.l.F(getContext(), str);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceData.VoiceModel getVoiceModel() {
        return this.eDq;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceManager.b getRealView() {
        Context context = getContext();
        VoiceManager.b c = context instanceof VoiceManager.c ? ((VoiceManager.c) context).c(this.eDq) : this;
        return c == null ? this : c;
    }
}
