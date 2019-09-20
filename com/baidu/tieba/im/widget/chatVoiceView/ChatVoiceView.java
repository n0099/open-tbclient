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
import com.baidu.tbadk.util.j;
import com.baidu.tbadk.util.y;
import com.baidu.tbadk.util.z;
import com.baidu.tieba.R;
import com.baidu.tieba.d;
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
    private ChatMessage gSC;
    private ImageView gUd;
    private ImageView gUe;
    private TextView gUf;
    private ImageView gUg;
    private VoiceData.VoiceModel gUh;
    private RelativeLayout gUi;
    private ProgressBar mProgress;

    public ChatVoiceView(Context context) {
        super(context);
        this.gUd = null;
        this.gUf = null;
        this.gUg = null;
        this.mProgress = null;
        LayoutInflater.from(context).inflate(R.layout.widget_left_voice_view, (ViewGroup) this, true);
        init();
    }

    public ChatVoiceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        boolean z;
        this.gUd = null;
        this.gUf = null;
        this.gUg = null;
        this.mProgress = null;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.a.ChatVoiceView, 0, 0);
        if (obtainStyledAttributes != null) {
            z = obtainStyledAttributes.getBoolean(0, true);
            obtainStyledAttributes.recycle();
        } else {
            z = true;
        }
        if (z) {
            LayoutInflater.from(context).inflate(R.layout.widget_left_voice_view, (ViewGroup) this, true);
        } else {
            LayoutInflater.from(context).inflate(R.layout.widget_right_voice_view, (ViewGroup) this, true);
        }
        init();
    }

    private void init() {
        this.gUi = (RelativeLayout) findViewById(R.id.lay_bubble);
        this.gUd = (ImageView) findViewById(R.id.img_voice_status);
        this.gUe = (ImageView) findViewById(R.id.img_voice_status_anim);
        this.gUf = (TextView) findViewById(R.id.tex_voice_duration);
        this.gUg = (ImageView) findViewById(R.id.img_voice_readed);
        this.mProgress = (ProgressBar) findViewById(R.id.progress);
    }

    private void bHP() {
        this.gUd.setVisibility(8);
        this.gUe.setVisibility(0);
        ((AnimationDrawable) this.gUe.getBackground()).start();
    }

    private void bHQ() {
        ((AnimationDrawable) this.gUe.getBackground()).stop();
        this.gUe.clearAnimation();
        this.gUd.setVisibility(0);
        this.gUe.setVisibility(8);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        try {
            bHQ();
        } catch (Exception e) {
        }
    }

    public void wd(int i) {
    }

    public void we(int i) {
        if (i == 3) {
            if (this.gUd != null) {
                this.gUd.setVisibility(0);
            }
            this.mProgress.setVisibility(4);
            bHP();
            VoiceMsgData z = e.z(this.gSC);
            if (z != null && z.getHas_read() != 1) {
                z.setHas_read(1);
                this.gSC.setContent("[" + OrmObject.jsonStrWithObject(z) + "]");
                if (this.gSC instanceof CommonGroupChatMessage) {
                    final CommonGroupChatMessage commonGroupChatMessage = (CommonGroupChatMessage) this.gSC;
                    final LinkedList linkedList = new LinkedList();
                    linkedList.add(new CommonMsgPojo(commonGroupChatMessage));
                    if (!commonGroupChatMessage.getGroupId().equals(String.valueOf(a.gSf))) {
                        z.b(new y<Boolean>() { // from class: com.baidu.tieba.im.widget.chatVoiceView.ChatVoiceView.1
                            /* JADX DEBUG: Method merged with bridge method */
                            /* JADX WARN: Can't rename method to resolve collision */
                            @Override // com.baidu.tbadk.util.y
                            public Boolean doInBackground() {
                                return Boolean.valueOf(c.bDB().b(commonGroupChatMessage.getGroupId(), linkedList, false));
                            }
                        }, new j<Boolean>() { // from class: com.baidu.tieba.im.widget.chatVoiceView.ChatVoiceView.2
                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // com.baidu.tbadk.util.j
                            public void onReturnDataInUI(Boolean bool) {
                                ChatVoiceView.this.gUg.setVisibility(8);
                            }
                        });
                        return;
                    } else {
                        z.b(new y<Boolean>() { // from class: com.baidu.tieba.im.widget.chatVoiceView.ChatVoiceView.3
                            /* JADX DEBUG: Method merged with bridge method */
                            /* JADX WARN: Can't rename method to resolve collision */
                            @Override // com.baidu.tbadk.util.y
                            public Boolean doInBackground() {
                                return Boolean.valueOf(m.bDU().a(e.s(commonGroupChatMessage), linkedList, false));
                            }
                        }, new j<Boolean>() { // from class: com.baidu.tieba.im.widget.chatVoiceView.ChatVoiceView.4
                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // com.baidu.tbadk.util.j
                            public void onReturnDataInUI(Boolean bool) {
                                ChatVoiceView.this.gUg.setVisibility(8);
                            }
                        });
                        return;
                    }
                } else if (this.gSC instanceof PersonalChatMessage) {
                    final PersonalChatMessage personalChatMessage = (PersonalChatMessage) this.gSC;
                    final LinkedList linkedList2 = new LinkedList();
                    linkedList2.add(new CommonMsgPojo(personalChatMessage));
                    z.b(new y<Boolean>() { // from class: com.baidu.tieba.im.widget.chatVoiceView.ChatVoiceView.5
                        /* JADX DEBUG: Method merged with bridge method */
                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // com.baidu.tbadk.util.y
                        public Boolean doInBackground() {
                            return Boolean.valueOf(m.bDU().a(e.s(personalChatMessage), linkedList2, false));
                        }
                    }, new j<Boolean>() { // from class: com.baidu.tieba.im.widget.chatVoiceView.ChatVoiceView.6
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.tbadk.util.j
                        public void onReturnDataInUI(Boolean bool) {
                            ChatVoiceView.this.gUg.setVisibility(8);
                        }
                    });
                    return;
                } else if (this.gSC instanceof OfficialChatMessage) {
                    final OfficialChatMessage officialChatMessage = (OfficialChatMessage) this.gSC;
                    final LinkedList linkedList3 = new LinkedList();
                    linkedList3.add(new CommonMsgPojo(officialChatMessage));
                    z.b(new y<Boolean>() { // from class: com.baidu.tieba.im.widget.chatVoiceView.ChatVoiceView.7
                        /* JADX DEBUG: Method merged with bridge method */
                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // com.baidu.tbadk.util.y
                        public Boolean doInBackground() {
                            return Boolean.valueOf(l.bDS().a(e.s(officialChatMessage), linkedList3, false));
                        }
                    }, new j<Boolean>() { // from class: com.baidu.tieba.im.widget.chatVoiceView.ChatVoiceView.8
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.tbadk.util.j
                        public void onReturnDataInUI(Boolean bool) {
                            ChatVoiceView.this.gUg.setVisibility(8);
                        }
                    });
                    return;
                } else {
                    return;
                }
            }
            return;
        }
        bHQ();
        if (i == 1) {
            if (this.gUd != null) {
                this.gUd.setVisibility(0);
            }
            this.mProgress.setVisibility(4);
        } else if (i == 2) {
            if (this.gUd != null) {
                this.gUd.setVisibility(4);
            }
            this.mProgress.setVisibility(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        VoiceManager voiceManager;
        if (this.gUh == null || (voiceManager = getVoiceManager()) == null) {
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
            this.gUg.setVisibility(0);
        } else {
            this.gUg.setVisibility(8);
        }
    }

    public void setData(ChatMessage chatMessage) {
        VoiceManager voiceManager;
        if (chatMessage != null && chatMessage.getCacheData() != null) {
            this.gUh = chatMessage.getCacheData().getVoice_model();
            if (this.gUh == null) {
                this.gUh = new VoiceData.VoiceModel();
            }
            this.gSC = chatMessage;
            this.gUf.setText(VoiceManager.formatVoiceTime(this.gUh.duration));
            this.gUf.setContentDescription(String.format(getContext().getString(R.string.editor_record_format), VoiceManager.formatVoiceTime(this.gUh.duration)));
            setBubbleLength(this.gUh.duration);
            setTag(this.gUh);
            E(chatMessage);
            if (this.gUh.voice_status.intValue() != 1 && (voiceManager = getVoiceManager()) != null) {
                voiceManager.resetPlayView(this);
            }
            we(this.gUh.voice_status.intValue());
        }
    }

    public void reset() {
        this.gUh = null;
        we(1);
    }

    private void setBubbleLength(int i) {
        int i2;
        int af = com.baidu.adp.lib.util.l.af(getContext());
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
            if (this.gUi.getParent() != null && (this.gUi.getParent() instanceof RelativeLayout)) {
                this.gUi.setLayoutParams(new RelativeLayout.LayoutParams(i2, -2));
                return;
            }
            this.gUi.setLayoutParams(new LinearLayout.LayoutParams(i2, -2));
        } catch (Exception e) {
        }
    }

    public boolean isPlaying() {
        return this.gUh != null && this.gUh.voice_status.intValue() == 3;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void qy() {
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void b(VoiceData.VoiceModel voiceModel) {
        if (voiceModel != null) {
            we(voiceModel.voice_status.intValue());
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void bl(int i) {
        wd(i);
        if (this.gUh != null) {
            this.gUh.elapse = i;
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void onShowErr(int i, String str) {
        com.baidu.adp.lib.util.l.E(getContext(), str);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceData.VoiceModel getVoiceModel() {
        return this.gUh;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceManager.b getRealView() {
        Context context = getContext();
        VoiceManager.b c = context instanceof VoiceManager.c ? ((VoiceManager.c) context).c(this.gUh) : this;
        return c == null ? this : c;
    }
}
