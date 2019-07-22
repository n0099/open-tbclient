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
import com.baidu.tbadk.util.aa;
import com.baidu.tbadk.util.k;
import com.baidu.tbadk.util.z;
import com.baidu.tieba.R;
import com.baidu.tieba.c;
import com.baidu.tieba.im.data.VoiceMsgData;
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
    private ChatMessage gPQ;
    private ImageView gRs;
    private ImageView gRt;
    private TextView gRu;
    private ImageView gRv;
    private VoiceData.VoiceModel gRw;
    private RelativeLayout gRx;
    private ProgressBar mProgress;

    public ChatVoiceView(Context context) {
        super(context);
        this.gRs = null;
        this.gRu = null;
        this.gRv = null;
        this.mProgress = null;
        LayoutInflater.from(context).inflate(R.layout.widget_left_voice_view, (ViewGroup) this, true);
        init();
    }

    public ChatVoiceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        boolean z;
        this.gRs = null;
        this.gRu = null;
        this.gRv = null;
        this.mProgress = null;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, c.a.ChatVoiceView, 0, 0);
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
        this.gRx = (RelativeLayout) findViewById(R.id.lay_bubble);
        this.gRs = (ImageView) findViewById(R.id.img_voice_status);
        this.gRt = (ImageView) findViewById(R.id.img_voice_status_anim);
        this.gRu = (TextView) findViewById(R.id.tex_voice_duration);
        this.gRv = (ImageView) findViewById(R.id.img_voice_readed);
        this.mProgress = (ProgressBar) findViewById(R.id.progress);
    }

    private void bGN() {
        this.gRs.setVisibility(8);
        this.gRt.setVisibility(0);
        ((AnimationDrawable) this.gRt.getBackground()).start();
    }

    private void bGO() {
        ((AnimationDrawable) this.gRt.getBackground()).stop();
        this.gRt.clearAnimation();
        this.gRs.setVisibility(0);
        this.gRt.setVisibility(8);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        try {
            bGO();
        } catch (Exception e) {
        }
    }

    public void vX(int i) {
    }

    public void vY(int i) {
        if (i == 3) {
            if (this.gRs != null) {
                this.gRs.setVisibility(0);
            }
            this.mProgress.setVisibility(4);
            bGN();
            VoiceMsgData z = e.z(this.gPQ);
            if (z != null && z.getHas_read() != 1) {
                z.setHas_read(1);
                this.gPQ.setContent("[" + OrmObject.jsonStrWithObject(z) + "]");
                if (this.gPQ instanceof CommonGroupChatMessage) {
                    final CommonGroupChatMessage commonGroupChatMessage = (CommonGroupChatMessage) this.gPQ;
                    final LinkedList linkedList = new LinkedList();
                    linkedList.add(new CommonMsgPojo(commonGroupChatMessage));
                    if (!commonGroupChatMessage.getGroupId().equals(String.valueOf(a.gPt))) {
                        aa.b(new z<Boolean>() { // from class: com.baidu.tieba.im.widget.chatVoiceView.ChatVoiceView.1
                            /* JADX DEBUG: Method merged with bridge method */
                            /* JADX WARN: Can't rename method to resolve collision */
                            @Override // com.baidu.tbadk.util.z
                            public Boolean doInBackground() {
                                return Boolean.valueOf(com.baidu.tieba.im.db.c.bCz().b(commonGroupChatMessage.getGroupId(), linkedList, false));
                            }
                        }, new k<Boolean>() { // from class: com.baidu.tieba.im.widget.chatVoiceView.ChatVoiceView.2
                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // com.baidu.tbadk.util.k
                            public void onReturnDataInUI(Boolean bool) {
                                ChatVoiceView.this.gRv.setVisibility(8);
                            }
                        });
                        return;
                    } else {
                        aa.b(new z<Boolean>() { // from class: com.baidu.tieba.im.widget.chatVoiceView.ChatVoiceView.3
                            /* JADX DEBUG: Method merged with bridge method */
                            /* JADX WARN: Can't rename method to resolve collision */
                            @Override // com.baidu.tbadk.util.z
                            public Boolean doInBackground() {
                                return Boolean.valueOf(m.bCS().a(e.s(commonGroupChatMessage), linkedList, false));
                            }
                        }, new k<Boolean>() { // from class: com.baidu.tieba.im.widget.chatVoiceView.ChatVoiceView.4
                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // com.baidu.tbadk.util.k
                            public void onReturnDataInUI(Boolean bool) {
                                ChatVoiceView.this.gRv.setVisibility(8);
                            }
                        });
                        return;
                    }
                } else if (this.gPQ instanceof PersonalChatMessage) {
                    final PersonalChatMessage personalChatMessage = (PersonalChatMessage) this.gPQ;
                    final LinkedList linkedList2 = new LinkedList();
                    linkedList2.add(new CommonMsgPojo(personalChatMessage));
                    aa.b(new z<Boolean>() { // from class: com.baidu.tieba.im.widget.chatVoiceView.ChatVoiceView.5
                        /* JADX DEBUG: Method merged with bridge method */
                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // com.baidu.tbadk.util.z
                        public Boolean doInBackground() {
                            return Boolean.valueOf(m.bCS().a(e.s(personalChatMessage), linkedList2, false));
                        }
                    }, new k<Boolean>() { // from class: com.baidu.tieba.im.widget.chatVoiceView.ChatVoiceView.6
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.tbadk.util.k
                        public void onReturnDataInUI(Boolean bool) {
                            ChatVoiceView.this.gRv.setVisibility(8);
                        }
                    });
                    return;
                } else if (this.gPQ instanceof OfficialChatMessage) {
                    final OfficialChatMessage officialChatMessage = (OfficialChatMessage) this.gPQ;
                    final LinkedList linkedList3 = new LinkedList();
                    linkedList3.add(new CommonMsgPojo(officialChatMessage));
                    aa.b(new z<Boolean>() { // from class: com.baidu.tieba.im.widget.chatVoiceView.ChatVoiceView.7
                        /* JADX DEBUG: Method merged with bridge method */
                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // com.baidu.tbadk.util.z
                        public Boolean doInBackground() {
                            return Boolean.valueOf(l.bCQ().a(e.s(officialChatMessage), linkedList3, false));
                        }
                    }, new k<Boolean>() { // from class: com.baidu.tieba.im.widget.chatVoiceView.ChatVoiceView.8
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.tbadk.util.k
                        public void onReturnDataInUI(Boolean bool) {
                            ChatVoiceView.this.gRv.setVisibility(8);
                        }
                    });
                    return;
                } else {
                    return;
                }
            }
            return;
        }
        bGO();
        if (i == 1) {
            if (this.gRs != null) {
                this.gRs.setVisibility(0);
            }
            this.mProgress.setVisibility(4);
        } else if (i == 2) {
            if (this.gRs != null) {
                this.gRs.setVisibility(4);
            }
            this.mProgress.setVisibility(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        VoiceManager voiceManager;
        if (this.gRw == null || (voiceManager = getVoiceManager()) == null) {
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
            this.gRv.setVisibility(0);
        } else {
            this.gRv.setVisibility(8);
        }
    }

    public void setData(ChatMessage chatMessage) {
        VoiceManager voiceManager;
        if (chatMessage != null && chatMessage.getCacheData() != null) {
            this.gRw = chatMessage.getCacheData().getVoice_model();
            if (this.gRw == null) {
                this.gRw = new VoiceData.VoiceModel();
            }
            this.gPQ = chatMessage;
            this.gRu.setText(VoiceManager.formatVoiceTime(this.gRw.duration));
            this.gRu.setContentDescription(String.format(getContext().getString(R.string.editor_record_format), VoiceManager.formatVoiceTime(this.gRw.duration)));
            setBubbleLength(this.gRw.duration);
            setTag(this.gRw);
            E(chatMessage);
            if (this.gRw.voice_status.intValue() != 1 && (voiceManager = getVoiceManager()) != null) {
                voiceManager.resetPlayView(this);
            }
            vY(this.gRw.voice_status.intValue());
        }
    }

    public void reset() {
        this.gRw = null;
        vY(1);
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
            if (this.gRx.getParent() != null && (this.gRx.getParent() instanceof RelativeLayout)) {
                this.gRx.setLayoutParams(new RelativeLayout.LayoutParams(i2, -2));
                return;
            }
            this.gRx.setLayoutParams(new LinearLayout.LayoutParams(i2, -2));
        } catch (Exception e) {
        }
    }

    public boolean isPlaying() {
        return this.gRw != null && this.gRw.voice_status.intValue() == 3;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void qx() {
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void b(VoiceData.VoiceModel voiceModel) {
        if (voiceModel != null) {
            vY(voiceModel.voice_status.intValue());
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void bl(int i) {
        vX(i);
        if (this.gRw != null) {
            this.gRw.elapse = i;
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void onShowErr(int i, String str) {
        com.baidu.adp.lib.util.l.E(getContext(), str);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceData.VoiceModel getVoiceModel() {
        return this.gRw;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceManager.b getRealView() {
        Context context = getContext();
        VoiceManager.b c = context instanceof VoiceManager.c ? ((VoiceManager.c) context).c(this.gRw) : this;
        return c == null ? this : c;
    }
}
