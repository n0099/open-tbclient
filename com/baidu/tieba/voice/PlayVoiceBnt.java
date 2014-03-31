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
import com.baidu.location.LocationClientOption;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.core.voice.x;
import com.baidu.tbadk.core.voice.z;
import com.baidu.tbadk.widget.richText.t;
import com.baidu.tieba.a.g;
import com.baidu.tieba.a.h;
import com.baidu.tieba.a.i;
import com.baidu.tieba.a.m;
/* loaded from: classes.dex */
public class PlayVoiceBnt extends RelativeLayout implements View.OnClickListener, x {
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
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, m.Voice_play_type);
        this.a = obtainStyledAttributes.getInteger(0, 0);
        obtainStyledAttributes.recycle();
        a(context);
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int[] definedWH = getDefinedWH();
        int btnWidth = getBtnWidth();
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(mode == 1073741824 ? Math.max(size, btnWidth) : Math.min(size, btnWidth), 1073741824), View.MeasureSpec.makeMeasureSpec(definedWH[1], 1073741824));
    }

    public int[] getDefinedWH() {
        int[] iArr = new int[2];
        if (this.a == 0) {
            iArr[0] = (int) getContext().getResources().getDimension(com.baidu.tieba.a.f.voice_play_bnt_width_0);
            iArr[1] = (int) getContext().getResources().getDimension(com.baidu.tieba.a.f.voice_play_bnt_height_0);
        } else {
            iArr[0] = (int) getContext().getResources().getDimension(com.baidu.tieba.a.f.voice_play_bnt_width_1);
            iArr[1] = (int) getContext().getResources().getDimension(com.baidu.tieba.a.f.voice_play_bnt_height_1);
        }
        return iArr;
    }

    private void a(Context context) {
        LayoutInflater.from(context).inflate(i.play_voice_bnt, (ViewGroup) this, true);
        this.c = (ImageView) findViewById(h.playingImg);
        this.d = (TextView) findViewById(h.playTime);
        this.e = (ProgressBar) findViewById(h.progress);
        if (this.e != null) {
            this.e.setVisibility(4);
        }
        this.f = context;
        c();
        setOnClickListener(this);
    }

    private void c() {
        int l = TbadkApplication.j().l();
        if (this.a == 0) {
            int i = l != 1 ? g.but_thread_voice_selector : g.but_thread_voice_selector_1;
            int i2 = l != 1 ? -13553101 : -6574132;
            int i3 = l != 1 ? com.baidu.tieba.a.b.voice_btn_play_anim : com.baidu.tieba.a.b.voice_btn_play_anim_1;
            setBackgroundResource(i);
            if (this.d != null) {
                this.d.setTextSize(0, this.f.getResources().getDimension(com.baidu.tieba.a.f.voice_play_bnt_text_size_0));
                this.d.setTextColor(i2);
            }
            if (this.c != null) {
                this.c.setImageResource(i3);
            }
            this.c.setPadding(com.baidu.adp.lib.util.i.a(getContext(), 12.0f), 0, 0, 0);
            return;
        }
        int i4 = l != 1 ? g.but_thread_voice_reply_selector : g.but_thread_voice_reply_selector_1;
        int i5 = l != 1 ? -16777216 : -8682095;
        int i6 = l != 1 ? com.baidu.tieba.a.b.voice_btn_play_anim : com.baidu.tieba.a.b.voice_btn_play_anim_1;
        setBackgroundResource(i4);
        if (this.d != null) {
            this.d.setTextSize(0, this.f.getResources().getDimension(com.baidu.tieba.a.f.voice_play_bnt_text_size_1));
            this.d.setTextColor(i5);
        }
        if (this.c != null) {
            this.c.setImageResource(i6);
        }
        this.c.setPadding(com.baidu.adp.lib.util.i.a(getContext(), 8.0f), 0, 0, 0);
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        requestLayout();
        this.b = voiceModel;
        if (this.b != null) {
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null && voiceManager.a(voiceModel)) {
                voiceManager.a(this);
                b(this.b.elapse);
                return;
            }
            c(this.b.voice_status.intValue());
            this.d.setText(VoiceManager.b(voiceModel.duration));
        }
    }

    private void b(int i) {
        String b;
        if (this.b != null && this.d != null) {
            int i2 = i / LocationClientOption.MIN_SCAN_SPAN;
            if (i2 > 0 && i2 < this.b.duration) {
                b = VoiceManager.b(this.b.duration - i2);
            } else {
                b = VoiceManager.b(this.b.duration);
            }
            String str = (String) this.d.getText();
            if (str == null || !str.equals(b)) {
                this.d.setText(b);
            }
        }
    }

    private void c(int i) {
        int i2;
        int i3;
        if (i == 3) {
            if (this.c != null) {
                this.c.setVisibility(0);
            }
            this.e.setVisibility(4);
            if (this.g != null) {
                this.g.stop();
            }
            int l = TbadkApplication.j().l();
            if (this.a == 0) {
                i3 = l != 1 ? com.baidu.tieba.a.b.voice_btn_play_anim : com.baidu.tieba.a.b.voice_btn_play_anim_1;
            } else {
                i3 = l != 1 ? com.baidu.tieba.a.b.voice_btn_play_anim : com.baidu.tieba.a.b.voice_btn_play_anim_1;
            }
            if (this.c != null) {
                this.c.setImageResource(i3);
            }
            this.g = (AnimationDrawable) this.c.getDrawable();
            this.g.start();
            return;
        }
        Drawable drawable = this.c.getDrawable();
        if (drawable instanceof AnimationDrawable) {
            this.g = (AnimationDrawable) drawable;
        }
        if (this.g != null) {
            this.g.stop();
        }
        this.g = null;
        int l2 = TbadkApplication.j().l();
        if (this.a == 0) {
            i2 = l2 != 1 ? g.icon_thread_voice_reply_curve_three : g.icon_thread_voice_reply_curve_three_1;
        } else {
            i2 = l2 != 1 ? g.icon_thread_voice_reply_curve_three : g.icon_thread_voice_reply_curve_three_1;
        }
        if (this.c != null) {
            this.c.setImageResource(i2);
        }
        if (i == 1) {
            if (this.c != null) {
                this.c.setVisibility(0);
            }
            if (this.b != null) {
                this.d.setText(VoiceManager.b(this.b.duration));
            }
            this.e.setVisibility(4);
        } else if (i == 2) {
            if (this.b != null) {
                this.d.setText(VoiceManager.b(this.b.duration));
            }
            this.e.setVisibility(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.b != null) {
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null) {
                voiceManager.a(true);
                voiceManager.b(this);
            }
            com.baidu.tbadk.core.g.a(getContext(), this.b.from);
        }
    }

    public VoiceManager getVoiceManager() {
        Context context = getContext();
        if (context instanceof z) {
            return ((z) context).d();
        }
        return null;
    }

    @Override // android.view.View
    public void setTag(Object obj) {
        if (obj != null && (obj instanceof t)) {
            t tVar = (t) obj;
            VoiceData.VoiceModel voiceModel = (VoiceData.VoiceModel) tVar.d();
            if (voiceModel == null) {
                voiceModel = new VoiceData.VoiceModel();
                if (tVar.c() == 0) {
                    voiceModel.from = "pb_voice_play";
                } else {
                    voiceModel.from = "floor_voice_play";
                }
                voiceModel.voiceId = tVar.a();
                voiceModel.duration = tVar.b();
                tVar.a(voiceModel);
            }
            this.a = tVar.c();
            setVoiceModel(voiceModel);
            c();
            obj = voiceModel;
        }
        super.setTag(obj);
    }

    @Override // com.baidu.tbadk.core.voice.x
    public final void a(VoiceData.VoiceModel voiceModel) {
        if (voiceModel != null) {
            if (this.b != voiceModel) {
                c(1);
            } else {
                c(voiceModel.voice_status.intValue());
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.x
    public final void a(int i) {
        VoiceManager voiceManager;
        boolean z = false;
        if (this.b != null && ((voiceManager = getVoiceManager()) == null || voiceManager.a(this.b))) {
            z = true;
        }
        if (!z) {
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

    @Override // com.baidu.tbadk.core.voice.x
    public final void a(int i, String str) {
        com.baidu.adp.lib.util.i.b(getContext(), str);
    }

    @Override // com.baidu.tbadk.core.voice.x
    public VoiceData.VoiceModel getVoiceModel() {
        return this.b;
    }

    public final void a() {
        c();
    }

    @Override // com.baidu.tbadk.core.voice.x
    public x getRealView() {
        Context context = getContext();
        if (context instanceof z) {
            return ((z) context).a(this.b);
        }
        return this;
    }

    public final void b() {
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
        int b = com.baidu.adp.lib.util.i.b(getContext());
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
