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
import com.baidu.tbadk.util.w;
import com.baidu.tbadk.util.x;
import com.baidu.tieba.e;
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
import java.util.LinkedList;
/* loaded from: classes.dex */
public class ChatVoiceView extends LinearLayout implements View.OnClickListener, VoiceManager.b {
    private ChatMessage eYS;
    private ImageView fat;
    private ImageView fau;
    private TextView fav;
    private ImageView faw;
    private VoiceData.VoiceModel fax;
    private RelativeLayout fay;
    private ProgressBar mProgress;

    public ChatVoiceView(Context context) {
        super(context);
        this.fat = null;
        this.fav = null;
        this.faw = null;
        this.mProgress = null;
        LayoutInflater.from(context).inflate(e.h.widget_left_voice_view, (ViewGroup) this, true);
        init();
    }

    public ChatVoiceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        boolean z;
        this.fat = null;
        this.fav = null;
        this.faw = null;
        this.mProgress = null;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, e.l.ChatVoiceView, 0, 0);
        if (obtainStyledAttributes != null) {
            z = obtainStyledAttributes.getBoolean(e.l.ChatVoiceView_is_left, true);
            obtainStyledAttributes.recycle();
        } else {
            z = true;
        }
        if (z) {
            LayoutInflater.from(context).inflate(e.h.widget_left_voice_view, (ViewGroup) this, true);
        } else {
            LayoutInflater.from(context).inflate(e.h.widget_right_voice_view, (ViewGroup) this, true);
        }
        init();
    }

    private void init() {
        this.fay = (RelativeLayout) findViewById(e.g.lay_bubble);
        this.fat = (ImageView) findViewById(e.g.img_voice_status);
        this.fau = (ImageView) findViewById(e.g.img_voice_status_anim);
        this.fav = (TextView) findViewById(e.g.tex_voice_duration);
        this.faw = (ImageView) findViewById(e.g.img_voice_readed);
        this.mProgress = (ProgressBar) findViewById(e.g.progress);
    }

    private void aUE() {
        this.fat.setVisibility(8);
        this.fau.setVisibility(0);
        ((AnimationDrawable) this.fau.getBackground()).start();
    }

    private void aUF() {
        ((AnimationDrawable) this.fau.getBackground()).stop();
        this.fau.clearAnimation();
        this.fat.setVisibility(0);
        this.fau.setVisibility(8);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        try {
            aUF();
        } catch (Exception e) {
        }
    }

    public void qv(int i) {
    }

    public void qw(int i) {
        if (i == 3) {
            if (this.fat != null) {
                this.fat.setVisibility(0);
            }
            this.mProgress.setVisibility(4);
            aUE();
            VoiceMsgData z = com.baidu.tieba.im.util.e.z(this.eYS);
            if (z != null && z.getHas_read() != 1) {
                z.setHas_read(1);
                this.eYS.setContent("[" + OrmObject.jsonStrWithObject(z) + "]");
                if (this.eYS instanceof CommonGroupChatMessage) {
                    final CommonGroupChatMessage commonGroupChatMessage = (CommonGroupChatMessage) this.eYS;
                    final LinkedList linkedList = new LinkedList();
                    linkedList.add(new CommonMsgPojo(commonGroupChatMessage));
                    if (!commonGroupChatMessage.getGroupId().equals(String.valueOf(a.eYu))) {
                        x.b(new w<Boolean>() { // from class: com.baidu.tieba.im.widget.chatVoiceView.ChatVoiceView.1
                            /* JADX DEBUG: Method merged with bridge method */
                            /* JADX WARN: Can't rename method to resolve collision */
                            @Override // com.baidu.tbadk.util.w
                            public Boolean doInBackground() {
                                return Boolean.valueOf(c.aQo().b(commonGroupChatMessage.getGroupId(), linkedList, false));
                            }
                        }, new h<Boolean>() { // from class: com.baidu.tieba.im.widget.chatVoiceView.ChatVoiceView.2
                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // com.baidu.tbadk.util.h
                            public void onReturnDataInUI(Boolean bool) {
                                ChatVoiceView.this.faw.setVisibility(8);
                            }
                        });
                        return;
                    } else {
                        x.b(new w<Boolean>() { // from class: com.baidu.tieba.im.widget.chatVoiceView.ChatVoiceView.3
                            /* JADX DEBUG: Method merged with bridge method */
                            /* JADX WARN: Can't rename method to resolve collision */
                            @Override // com.baidu.tbadk.util.w
                            public Boolean doInBackground() {
                                return Boolean.valueOf(m.aQG().a(com.baidu.tieba.im.util.e.s(commonGroupChatMessage), linkedList, false));
                            }
                        }, new h<Boolean>() { // from class: com.baidu.tieba.im.widget.chatVoiceView.ChatVoiceView.4
                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // com.baidu.tbadk.util.h
                            public void onReturnDataInUI(Boolean bool) {
                                ChatVoiceView.this.faw.setVisibility(8);
                            }
                        });
                        return;
                    }
                } else if (this.eYS instanceof PersonalChatMessage) {
                    final PersonalChatMessage personalChatMessage = (PersonalChatMessage) this.eYS;
                    final LinkedList linkedList2 = new LinkedList();
                    linkedList2.add(new CommonMsgPojo(personalChatMessage));
                    x.b(new w<Boolean>() { // from class: com.baidu.tieba.im.widget.chatVoiceView.ChatVoiceView.5
                        /* JADX DEBUG: Method merged with bridge method */
                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // com.baidu.tbadk.util.w
                        public Boolean doInBackground() {
                            return Boolean.valueOf(m.aQG().a(com.baidu.tieba.im.util.e.s(personalChatMessage), linkedList2, false));
                        }
                    }, new h<Boolean>() { // from class: com.baidu.tieba.im.widget.chatVoiceView.ChatVoiceView.6
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.tbadk.util.h
                        public void onReturnDataInUI(Boolean bool) {
                            ChatVoiceView.this.faw.setVisibility(8);
                        }
                    });
                    return;
                } else if (this.eYS instanceof OfficialChatMessage) {
                    final OfficialChatMessage officialChatMessage = (OfficialChatMessage) this.eYS;
                    final LinkedList linkedList3 = new LinkedList();
                    linkedList3.add(new CommonMsgPojo(officialChatMessage));
                    x.b(new w<Boolean>() { // from class: com.baidu.tieba.im.widget.chatVoiceView.ChatVoiceView.7
                        /* JADX DEBUG: Method merged with bridge method */
                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // com.baidu.tbadk.util.w
                        public Boolean doInBackground() {
                            return Boolean.valueOf(l.aQE().a(com.baidu.tieba.im.util.e.s(officialChatMessage), linkedList3, false));
                        }
                    }, new h<Boolean>() { // from class: com.baidu.tieba.im.widget.chatVoiceView.ChatVoiceView.8
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.tbadk.util.h
                        public void onReturnDataInUI(Boolean bool) {
                            ChatVoiceView.this.faw.setVisibility(8);
                        }
                    });
                    return;
                } else {
                    return;
                }
            }
            return;
        }
        aUF();
        if (i == 1) {
            if (this.fat != null) {
                this.fat.setVisibility(0);
            }
            this.mProgress.setVisibility(4);
        } else if (i == 2) {
            if (this.fat != null) {
                this.fat.setVisibility(4);
            }
            this.mProgress.setVisibility(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        VoiceManager voiceManager;
        if (this.fax == null || (voiceManager = getVoiceManager()) == null) {
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
        if (com.baidu.tieba.im.util.e.w(chatMessage)) {
            z = false;
        } else {
            VoiceMsgData z2 = com.baidu.tieba.im.util.e.z(chatMessage);
            if (z2 != null && z2.getHas_read() == 1) {
                z = false;
            }
        }
        if (z) {
            this.faw.setVisibility(0);
        } else {
            this.faw.setVisibility(8);
        }
    }

    public void setData(ChatMessage chatMessage) {
        VoiceManager voiceManager;
        if (chatMessage != null && chatMessage.getCacheData() != null) {
            this.fax = chatMessage.getCacheData().getVoice_model();
            if (this.fax == null) {
                this.fax = new VoiceData.VoiceModel();
            }
            this.eYS = chatMessage;
            this.fav.setText(VoiceManager.formatVoiceTime(this.fax.duration));
            this.fav.setContentDescription(String.format(getContext().getString(e.j.editor_record_format), VoiceManager.formatVoiceTime(this.fax.duration)));
            setBubbleLength(this.fax.duration);
            setTag(this.fax);
            E(chatMessage);
            if (this.fax.voice_status.intValue() != 1 && (voiceManager = getVoiceManager()) != null) {
                voiceManager.resetPlayView(this);
            }
            qw(this.fax.voice_status.intValue());
        }
    }

    public void reset() {
        this.fax = null;
        qw(1);
    }

    private void setBubbleLength(int i) {
        int i2;
        int aO = com.baidu.adp.lib.util.l.aO(getContext());
        if (i <= 10) {
            int i3 = (int) (aO * 0.1875d);
            i2 = (((((int) (aO * 0.4125d)) - i3) * (i - 1)) / 10) + i3;
        } else if (i <= 30) {
            int i4 = (int) (aO * 0.4125d);
            i2 = (((((int) (aO * 0.5375d)) - i4) * (i - 10)) / 20) + i4;
        } else {
            i2 = (int) (aO * 0.5375d);
        }
        try {
            if (this.fay.getParent() != null && (this.fay.getParent() instanceof RelativeLayout)) {
                this.fay.setLayoutParams(new RelativeLayout.LayoutParams(i2, -2));
                return;
            }
            this.fay.setLayoutParams(new LinearLayout.LayoutParams(i2, -2));
        } catch (Exception e) {
        }
    }

    public boolean isPlaying() {
        return this.fax != null && this.fax.voice_status.intValue() == 3;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void pZ() {
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void b(VoiceData.VoiceModel voiceModel) {
        if (voiceModel != null) {
            qw(voiceModel.voice_status.intValue());
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void bz(int i) {
        qv(i);
        if (this.fax != null) {
            this.fax.elapse = i;
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void onShowErr(int i, String str) {
        com.baidu.adp.lib.util.l.S(getContext(), str);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceData.VoiceModel getVoiceModel() {
        return this.fax;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceManager.b getRealView() {
        Context context = getContext();
        VoiceManager.b c = context instanceof VoiceManager.c ? ((VoiceManager.c) context).c(this.fax) : this;
        return c == null ? this : c;
    }
}
