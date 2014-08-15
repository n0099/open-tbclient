package com.baidu.tieba.voice;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.i;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.core.voice.aa;
import com.baidu.tbadk.core.voice.y;
import com.baidu.tieba.o;
import com.baidu.tieba.s;
import com.baidu.tieba.t;
import com.baidu.tieba.u;
import com.baidu.tieba.v;
import com.baidu.tieba.z;
/* loaded from: classes.dex */
public class PlayVoiceBnt extends RelativeLayout implements View.OnClickListener, y {
    private int a;
    private VoiceData.VoiceModel b;
    private ImageView c;
    private TextView d;
    private ProgressBar e;
    private Context f;
    private AnimationDrawable g;

    /* loaded from: classes.dex */
    public enum PLAY_TYPE {
        NORMAL,
        REPLY;

        /* JADX DEBUG: Replace access to removed values field (a) with 'values()' method */
        /* renamed from: values  reason: to resolve conflict with enum method */
        public static PLAY_TYPE[] valuesCustom() {
            PLAY_TYPE[] valuesCustom = values();
            int length = valuesCustom.length;
            PLAY_TYPE[] play_typeArr = new PLAY_TYPE[length];
            System.arraycopy(valuesCustom, 0, play_typeArr, 0, length);
            return play_typeArr;
        }
    }

    public PlayVoiceBnt(Context context, PLAY_TYPE play_type) {
        super(context);
        this.a = 0;
        this.a = play_type.ordinal();
        a(context);
    }

    public PlayVoiceBnt(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, z.Voice_play_type);
        this.a = obtainStyledAttributes.getInteger(0, 0);
        obtainStyledAttributes.recycle();
        a(context);
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(a(i, getBtnWidth()), 1073741824), View.MeasureSpec.makeMeasureSpec(getDefinedWH()[1], 1073741824));
    }

    private int a(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        if (mode == 1073741824) {
            return Math.max(size, i2);
        }
        return Math.min(size, i2);
    }

    public int[] getDefinedWH() {
        int[] iArr = new int[2];
        if (this.a == 0) {
            iArr[0] = (int) getContext().getResources().getDimension(s.voice_play_bnt_width_0);
            iArr[1] = (int) getContext().getResources().getDimension(s.voice_play_bnt_height_0);
        } else {
            iArr[0] = (int) getContext().getResources().getDimension(s.voice_play_bnt_width_1);
            iArr[1] = (int) getContext().getResources().getDimension(s.voice_play_bnt_height_1);
        }
        return iArr;
    }

    public void a(Context context) {
        b(context);
        setOnClickListener(this);
    }

    public void b(Context context) {
        LayoutInflater.from(context).inflate(v.play_voice_bnt, (ViewGroup) this, true);
        this.c = (ImageView) findViewById(u.playingImg);
        this.d = (TextView) findViewById(u.playTime);
        this.e = (ProgressBar) findViewById(u.progress);
        if (this.e != null) {
            this.e.setVisibility(4);
        }
        this.f = context;
        e();
    }

    private void e() {
        int skinType = TbadkApplication.m252getInst().getSkinType();
        if (this.a == 0) {
            int i = skinType != 1 ? t.but_thread_voice_selector : t.but_thread_voice_selector_1;
            int i2 = skinType != 1 ? -13553101 : -6574132;
            int i3 = skinType != 1 ? o.voice_btn_play_anim : o.voice_btn_play_anim_1;
            setBackgroundResource(i);
            if (this.d != null) {
                this.d.setTextSize(0, this.f.getResources().getDimension(s.voice_play_bnt_text_size_0));
                this.d.setTextColor(i2);
            }
            if (this.c != null) {
                this.c.setImageResource(i3);
            }
            this.c.setPadding(j.a(getContext(), 12.0f), 0, 0, 0);
        } else {
            int i4 = skinType != 1 ? t.but_thread_voice_reply_selector : t.but_thread_voice_reply_selector_1;
            int i5 = skinType != 1 ? -16777216 : -8682095;
            int i6 = skinType != 1 ? o.voice_btn_play_anim : o.voice_btn_play_anim_1;
            setBackgroundResource(i4);
            if (this.d != null) {
                this.d.setTextSize(0, this.f.getResources().getDimension(s.voice_play_bnt_text_size_1));
                this.d.setTextColor(i5);
            }
            if (this.c != null) {
                this.c.setImageResource(i6);
            }
            this.c.setPadding(j.a(getContext(), 8.0f), 0, 0, 0);
        }
        ((AnimationDrawable) this.c.getDrawable()).stop();
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        requestLayout();
        this.b = voiceModel;
        if (this.b != null) {
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null && voiceManager.isPlayDoing(voiceModel)) {
                voiceManager.resetPlayView(this);
                b(this.b.elapse);
                return;
            }
            c(this.b.voice_status.intValue());
            this.d.setText(VoiceManager.formatVoiceTime(voiceModel.duration));
        }
    }

    public void b(int i) {
        String formatVoiceTime;
        if (this.b != null && this.d != null) {
            int i2 = i / 1000;
            if (i2 > 0 && i2 < this.b.duration) {
                formatVoiceTime = VoiceManager.formatVoiceTime(this.b.duration - i2);
            } else {
                formatVoiceTime = VoiceManager.formatVoiceTime(this.b.duration);
            }
            String a = i.a(this.d.getText(), (String) null);
            if (a == null || !a.equals(formatVoiceTime)) {
                this.d.setText(formatVoiceTime);
            }
        }
    }

    public void c(int i) {
        if (i == 3) {
            if (this.c != null) {
                this.c.setVisibility(0);
            }
            this.e.setVisibility(4);
            h();
            return;
        }
        b();
        if (i == 1) {
            if (this.c != null) {
                this.c.setVisibility(0);
            }
            if (this.b != null) {
                this.d.setText(VoiceManager.formatVoiceTime(this.b.duration));
            }
            this.e.setVisibility(4);
        } else if (i == 2) {
            if (this.b != null) {
                this.d.setText(VoiceManager.formatVoiceTime(this.b.duration));
            }
            this.e.setVisibility(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.b != null) {
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null) {
                voiceManager.setAllowChangeVoiceMode(true);
                voiceManager.startPlay(this);
            }
            com.baidu.tbadk.core.f.a(getContext(), this.b.from);
        }
    }

    private void f() {
        int i;
        int skinType = TbadkApplication.m252getInst().getSkinType();
        if (this.a == 0) {
            i = skinType != 1 ? o.voice_btn_play_anim : o.voice_btn_play_anim_1;
        } else {
            i = skinType != 1 ? o.voice_btn_play_anim : o.voice_btn_play_anim_1;
        }
        if (this.c != null) {
            this.c.setImageResource(i);
        }
    }

    private void g() {
        int i;
        int skinType = TbadkApplication.m252getInst().getSkinType();
        if (this.a == 0) {
            i = skinType != 1 ? t.icon_thread_voice_reply_curve_three : t.icon_thread_voice_reply_curve_three_1;
        } else {
            i = skinType != 1 ? t.icon_thread_voice_reply_curve_three : t.icon_thread_voice_reply_curve_three_1;
        }
        if (this.c != null) {
            this.c.setImageResource(i);
        }
    }

    private void h() {
        if (this.g != null) {
            this.g.stop();
        }
        f();
        this.g = (AnimationDrawable) this.c.getDrawable();
        this.g.start();
    }

    public void b() {
        Drawable drawable = this.c.getDrawable();
        if (drawable instanceof AnimationDrawable) {
            this.g = (AnimationDrawable) drawable;
        }
        if (this.g != null) {
            this.g.stop();
        }
        this.g = null;
        g();
    }

    public VoiceManager getVoiceManager() {
        Context context = getContext();
        if (context instanceof aa) {
            return ((aa) context).d();
        }
        return null;
    }

    @Override // android.view.View
    public void setTag(Object obj) {
        if (obj != null && (obj instanceof com.baidu.tbadk.widget.richText.u)) {
            com.baidu.tbadk.widget.richText.u uVar = (com.baidu.tbadk.widget.richText.u) obj;
            VoiceData.VoiceModel voiceModel = (VoiceData.VoiceModel) uVar.d();
            if (voiceModel == null) {
                voiceModel = new VoiceData.VoiceModel();
                if (uVar.c() == 0) {
                    voiceModel.from = "pb_voice_play";
                } else {
                    voiceModel.from = "floor_voice_play";
                }
                voiceModel.voiceId = uVar.a();
                voiceModel.duration = uVar.b();
                uVar.a(voiceModel);
            }
            this.a = uVar.c();
            setVoiceModel(voiceModel);
            e();
            obj = voiceModel;
        }
        super.setTag(obj);
    }

    @Override // com.baidu.tbadk.core.voice.y
    public void a(VoiceData.VoiceModel voiceModel) {
        if (voiceModel != null) {
            if (this.b != voiceModel) {
                c(1);
            } else {
                c(voiceModel.voice_status.intValue());
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.y
    public void a(int i) {
        if (!i()) {
            c(1);
            return;
        }
        if (this.g == null) {
            c(this.b.voice_status.intValue());
        }
        b(i);
        if (this.b != null) {
            this.b.elapse = i;
        }
    }

    private boolean i() {
        if (this.b == null) {
            return false;
        }
        VoiceManager voiceManager = getVoiceManager();
        return voiceManager == null || voiceManager.isPlayDoing(this.b);
    }

    @Override // com.baidu.tbadk.core.voice.y
    public void a(int i, String str) {
        j.b(getContext(), str);
    }

    @Override // com.baidu.tbadk.core.voice.y
    public VoiceData.VoiceModel getVoiceModel() {
        return this.b;
    }

    public void c() {
        e();
    }

    @Override // com.baidu.tbadk.core.voice.y
    public y getRealView() {
        Context context = getContext();
        if (context instanceof aa) {
            return ((aa) context).a(this.b);
        }
        return this;
    }

    @Override // com.baidu.tbadk.core.voice.y
    public void a() {
    }

    public void d() {
        this.b = null;
        setTag(null);
        c(1);
    }

    private int getBtnWidth() {
        VoiceData.VoiceModel voiceModel = getVoiceModel();
        if (voiceModel == null) {
            return -1;
        }
        int i = voiceModel.duration;
        int b = j.b(getContext());
        if (i > 10) {
            if (i <= 30) {
                int i2 = (int) (b * 0.3f);
                return (((i - 10) * (((int) (b * 0.45f)) - i2)) / 20) + i2;
            }
            return (int) (b * 0.45f);
        }
        int i3 = (int) (b * 0.18f);
        int i4 = (int) (b * 0.3f);
        if (i < 5) {
            i = 4;
        }
        return (((i - 1) * (i4 - i3)) / 10) + i3;
    }
}
