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
import com.baidu.tbadk.util.h;
import com.baidu.tbadk.util.u;
import com.baidu.tbadk.util.v;
import com.baidu.tieba.d;
import com.baidu.tieba.im.data.VoiceMsgData;
import com.baidu.tieba.im.db.c;
import com.baidu.tieba.im.db.k;
import com.baidu.tieba.im.db.l;
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
    private ChatMessage dLM;
    private ImageView dNs;
    private ImageView dNt;
    private TextView dNu;
    private ImageView dNv;
    private VoiceData.VoiceModel dNw;
    private RelativeLayout dNx;
    private ProgressBar mProgress;

    public ChatVoiceView(Context context) {
        super(context);
        this.dNs = null;
        this.dNu = null;
        this.dNv = null;
        this.mProgress = null;
        LayoutInflater.from(context).inflate(d.h.widget_left_voice_view, (ViewGroup) this, true);
        init();
    }

    public ChatVoiceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        boolean z;
        this.dNs = null;
        this.dNu = null;
        this.dNv = null;
        this.mProgress = null;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.l.ChatVoiceView, 0, 0);
        if (obtainStyledAttributes != null) {
            z = obtainStyledAttributes.getBoolean(d.l.ChatVoiceView_is_left, true);
            obtainStyledAttributes.recycle();
        } else {
            z = true;
        }
        if (z) {
            LayoutInflater.from(context).inflate(d.h.widget_left_voice_view, (ViewGroup) this, true);
        } else {
            LayoutInflater.from(context).inflate(d.h.widget_right_voice_view, (ViewGroup) this, true);
        }
        init();
    }

    private void init() {
        this.dNx = (RelativeLayout) findViewById(d.g.lay_bubble);
        this.dNs = (ImageView) findViewById(d.g.img_voice_status);
        this.dNt = (ImageView) findViewById(d.g.img_voice_status_anim);
        this.dNu = (TextView) findViewById(d.g.tex_voice_duration);
        this.dNv = (ImageView) findViewById(d.g.img_voice_readed);
        this.mProgress = (ProgressBar) findViewById(d.g.progress);
    }

    private void aBV() {
        this.dNs.setVisibility(8);
        this.dNt.setVisibility(0);
        ((AnimationDrawable) this.dNt.getBackground()).start();
    }

    private void aBW() {
        ((AnimationDrawable) this.dNt.getBackground()).stop();
        this.dNt.clearAnimation();
        this.dNs.setVisibility(0);
        this.dNt.setVisibility(8);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        try {
            aBW();
        } catch (Exception e) {
        }
    }

    public void nx(int i) {
    }

    public void ny(int i) {
        if (i == 3) {
            if (this.dNs != null) {
                this.dNs.setVisibility(0);
            }
            this.mProgress.setVisibility(4);
            aBV();
            VoiceMsgData y = e.y(this.dLM);
            if (y != null && y.getHas_read() != 1) {
                y.setHas_read(1);
                this.dLM.setContent("[" + OrmObject.jsonStrWithObject(y) + "]");
                if (this.dLM instanceof CommonGroupChatMessage) {
                    final CommonGroupChatMessage commonGroupChatMessage = (CommonGroupChatMessage) this.dLM;
                    final LinkedList linkedList = new LinkedList();
                    linkedList.add(new CommonMsgPojo(commonGroupChatMessage));
                    if (!commonGroupChatMessage.getGroupId().equals(String.valueOf(a.dLo))) {
                        v.b(new u<Boolean>() { // from class: com.baidu.tieba.im.widget.chatVoiceView.ChatVoiceView.1
                            /* JADX DEBUG: Method merged with bridge method */
                            /* JADX WARN: Can't rename method to resolve collision */
                            @Override // com.baidu.tbadk.util.u
                            public Boolean doInBackground() {
                                return Boolean.valueOf(c.axI().b(commonGroupChatMessage.getGroupId(), linkedList, false));
                            }
                        }, new h<Boolean>() { // from class: com.baidu.tieba.im.widget.chatVoiceView.ChatVoiceView.2
                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // com.baidu.tbadk.util.h
                            public void onReturnDataInUI(Boolean bool) {
                                ChatVoiceView.this.dNv.setVisibility(8);
                            }
                        });
                        return;
                    } else {
                        v.b(new u<Boolean>() { // from class: com.baidu.tieba.im.widget.chatVoiceView.ChatVoiceView.3
                            /* JADX DEBUG: Method merged with bridge method */
                            /* JADX WARN: Can't rename method to resolve collision */
                            @Override // com.baidu.tbadk.util.u
                            public Boolean doInBackground() {
                                return Boolean.valueOf(l.axX().a(e.r(commonGroupChatMessage), linkedList, false));
                            }
                        }, new h<Boolean>() { // from class: com.baidu.tieba.im.widget.chatVoiceView.ChatVoiceView.4
                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // com.baidu.tbadk.util.h
                            public void onReturnDataInUI(Boolean bool) {
                                ChatVoiceView.this.dNv.setVisibility(8);
                            }
                        });
                        return;
                    }
                } else if (this.dLM instanceof PersonalChatMessage) {
                    final PersonalChatMessage personalChatMessage = (PersonalChatMessage) this.dLM;
                    final LinkedList linkedList2 = new LinkedList();
                    linkedList2.add(new CommonMsgPojo(personalChatMessage));
                    v.b(new u<Boolean>() { // from class: com.baidu.tieba.im.widget.chatVoiceView.ChatVoiceView.5
                        /* JADX DEBUG: Method merged with bridge method */
                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // com.baidu.tbadk.util.u
                        public Boolean doInBackground() {
                            return Boolean.valueOf(l.axX().a(e.r(personalChatMessage), linkedList2, false));
                        }
                    }, new h<Boolean>() { // from class: com.baidu.tieba.im.widget.chatVoiceView.ChatVoiceView.6
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.tbadk.util.h
                        public void onReturnDataInUI(Boolean bool) {
                            ChatVoiceView.this.dNv.setVisibility(8);
                        }
                    });
                    return;
                } else if (this.dLM instanceof OfficialChatMessage) {
                    final OfficialChatMessage officialChatMessage = (OfficialChatMessage) this.dLM;
                    final LinkedList linkedList3 = new LinkedList();
                    linkedList3.add(new CommonMsgPojo(officialChatMessage));
                    v.b(new u<Boolean>() { // from class: com.baidu.tieba.im.widget.chatVoiceView.ChatVoiceView.7
                        /* JADX DEBUG: Method merged with bridge method */
                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // com.baidu.tbadk.util.u
                        public Boolean doInBackground() {
                            return Boolean.valueOf(k.axW().a(e.r(officialChatMessage), linkedList3, false));
                        }
                    }, new h<Boolean>() { // from class: com.baidu.tieba.im.widget.chatVoiceView.ChatVoiceView.8
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.tbadk.util.h
                        public void onReturnDataInUI(Boolean bool) {
                            ChatVoiceView.this.dNv.setVisibility(8);
                        }
                    });
                    return;
                } else {
                    return;
                }
            }
            return;
        }
        aBW();
        if (i == 1) {
            if (this.dNs != null) {
                this.dNs.setVisibility(0);
            }
            this.mProgress.setVisibility(4);
        } else if (i == 2) {
            if (this.dNs != null) {
                this.dNs.setVisibility(4);
            }
            this.mProgress.setVisibility(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        VoiceManager voiceManager;
        if (this.dNw == null || (voiceManager = getVoiceManager()) == null) {
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

    private void D(ChatMessage chatMessage) {
        boolean z = true;
        if (e.v(chatMessage)) {
            z = false;
        } else {
            VoiceMsgData y = e.y(chatMessage);
            if (y != null && y.getHas_read() == 1) {
                z = false;
            }
        }
        if (z) {
            this.dNv.setVisibility(0);
        } else {
            this.dNv.setVisibility(8);
        }
    }

    public void setData(ChatMessage chatMessage) {
        VoiceManager voiceManager;
        if (chatMessage != null && chatMessage.getCacheData() != null) {
            this.dNw = chatMessage.getCacheData().getVoice_model();
            if (this.dNw == null) {
                this.dNw = new VoiceData.VoiceModel();
            }
            this.dLM = chatMessage;
            this.dNu.setText(VoiceManager.formatVoiceTime(this.dNw.duration));
            this.dNu.setContentDescription(String.format(getContext().getString(d.j.editor_record_format), VoiceManager.formatVoiceTime(this.dNw.duration)));
            setBubbleLength(this.dNw.duration);
            setTag(this.dNw);
            D(chatMessage);
            if (this.dNw.voice_status.intValue() != 1 && (voiceManager = getVoiceManager()) != null) {
                voiceManager.resetPlayView(this);
            }
            ny(this.dNw.voice_status.intValue());
        }
    }

    public void reset() {
        this.dNw = null;
        ny(1);
    }

    private void setBubbleLength(int i) {
        int i2;
        int ac = com.baidu.adp.lib.util.l.ac(getContext());
        if (i <= 10) {
            int i3 = (int) (ac * 0.1875d);
            i2 = (((((int) (ac * 0.4125d)) - i3) * (i - 1)) / 10) + i3;
        } else if (i <= 30) {
            int i4 = (int) (ac * 0.4125d);
            i2 = (((((int) (ac * 0.5375d)) - i4) * (i - 10)) / 20) + i4;
        } else {
            i2 = (int) (ac * 0.5375d);
        }
        try {
            if (this.dNx.getParent() != null && (this.dNx.getParent() instanceof RelativeLayout)) {
                this.dNx.setLayoutParams(new RelativeLayout.LayoutParams(i2, -2));
                return;
            }
            this.dNx.setLayoutParams(new LinearLayout.LayoutParams(i2, -2));
        } catch (Exception e) {
        }
    }

    public boolean isPlaying() {
        return this.dNw != null && this.dNw.voice_status.intValue() == 3;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void lN() {
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void b(VoiceData.VoiceModel voiceModel) {
        if (voiceModel != null) {
            ny(voiceModel.voice_status.intValue());
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void aR(int i) {
        nx(i);
        if (this.dNw != null) {
            this.dNw.elapse = i;
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void onShowErr(int i, String str) {
        com.baidu.adp.lib.util.l.F(getContext(), str);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceData.VoiceModel getVoiceModel() {
        return this.dNw;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceManager.b getRealView() {
        Context context = getContext();
        VoiceManager.b c = context instanceof VoiceManager.c ? ((VoiceManager.c) context).c(this.dNw) : this;
        return c == null ? this : c;
    }
}
