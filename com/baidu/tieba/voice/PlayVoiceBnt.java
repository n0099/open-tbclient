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
import android.widget.Toast;
import com.baidu.location.LocationClientOption;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.al;
import com.baidu.tieba.aq;
import com.baidu.tieba.util.UtilHelper;
import com.baidu.tieba.voice.VoiceManager;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class PlayVoiceBnt extends RelativeLayout implements View.OnClickListener, ad {

    /* renamed from: a  reason: collision with root package name */
    private int f2586a;
    private VoiceManager.VoiceModel b;
    private ImageView c;
    private TextView d;
    private ProgressBar e;
    private Context f;
    private AnimationDrawable g;

    /* loaded from: classes.dex */
    public enum PLAY_TYPE {
        NORMAL,
        REPLY
    }

    public PlayVoiceBnt(Context context, PLAY_TYPE play_type) {
        super(context);
        this.f2586a = 0;
        this.f2586a = play_type.ordinal();
        a(context);
    }

    public PlayVoiceBnt(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2586a = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, aq.Voice_play_type);
        this.f2586a = obtainStyledAttributes.getInteger(0, 0);
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
        return i2;
    }

    public int[] getDefinedWH() {
        int[] iArr = {0, 0};
        if (this.f2586a == 0) {
            iArr[0] = (int) getContext().getResources().getDimension(R.dimen.voice_play_bnt_width_0);
            iArr[1] = (int) getContext().getResources().getDimension(R.dimen.voice_play_bnt_height_0);
        } else {
            iArr[0] = (int) getContext().getResources().getDimension(R.dimen.voice_play_bnt_width_1);
            iArr[1] = (int) getContext().getResources().getDimension(R.dimen.voice_play_bnt_height_1);
        }
        return iArr;
    }

    public void a(Context context) {
        b(context);
        setOnClickListener(this);
    }

    public void b(Context context) {
        LayoutInflater.from(context).inflate(R.layout.play_voice_bnt, (ViewGroup) this, true);
        this.c = (ImageView) findViewById(R.id.playingImg);
        this.d = (TextView) findViewById(R.id.playTime);
        this.e = (ProgressBar) findViewById(R.id.progress);
        if (this.e != null) {
            this.e.setVisibility(4);
        }
        this.f = context;
        e();
    }

    private void e() {
        int i;
        int i2 = R.anim.voice_btn_play_anim;
        int ap = TiebaApplication.g().ap();
        if (this.f2586a == 0) {
            int i3 = ap != 1 ? R.drawable.but_thread_voice_selector : R.drawable.but_thread_voice_selector_1;
            i = ap == 1 ? -8682095 : -16777216;
            if (ap == 1) {
                i2 = R.anim.voice_btn_play_anim_1;
            }
            setBackgroundResource(i3);
            if (this.d != null) {
                this.d.setTextSize(0, this.f.getResources().getDimension(R.dimen.voice_play_bnt_text_size_0));
                this.d.setTextColor(i);
            }
            if (this.c != null) {
                this.c.setImageResource(i2);
            }
            this.c.setPadding(UtilHelper.a(getContext(), 12.0f), 0, 0, 0);
            return;
        }
        int i4 = ap != 1 ? R.drawable.but_thread_voice_reply_selector : R.drawable.but_thread_voice_reply_selector_1;
        i = ap == 1 ? -8682095 : -16777216;
        if (ap == 1) {
            i2 = R.anim.voice_btn_play_anim_1;
        }
        setBackgroundResource(i4);
        if (this.d != null) {
            this.d.setTextSize(0, this.f.getResources().getDimension(R.dimen.voice_play_bnt_text_size_1));
            this.d.setTextColor(i);
        }
        if (this.c != null) {
            this.c.setImageResource(i2);
        }
        this.c.setPadding(UtilHelper.a(getContext(), 8.0f), 0, 0, 0);
    }

    public void setVoiceModel(VoiceManager.VoiceModel voiceModel) {
        requestLayout();
        this.b = voiceModel;
        if (this.b != null) {
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null && voiceManager.a(voiceModel)) {
                voiceManager.a(this);
                a(this.b.elapse);
                return;
            }
            b(this.b.voice_status.intValue());
            this.d.setText(VoiceManager.c(voiceModel.duration));
        }
    }

    public void a(int i) {
        String c;
        if (this.b != null && this.d != null) {
            int i2 = i / LocationClientOption.MIN_SCAN_SPAN;
            if (i2 > 0 && i2 < this.b.duration) {
                c = VoiceManager.c(this.b.duration - i2);
            } else {
                c = VoiceManager.c(this.b.duration);
            }
            String str = (String) this.d.getText();
            if (str == null || !str.equals(c)) {
                this.d.setText(c);
            }
        }
    }

    public void b(int i) {
        if (i == 3) {
            if (this.c != null) {
                this.c.setVisibility(0);
            }
            this.e.setVisibility(4);
            h();
            return;
        }
        a();
        if (i == 1) {
            if (this.c != null) {
                this.c.setVisibility(0);
            }
            if (this.b != null) {
                this.d.setText(VoiceManager.c(this.b.duration));
            }
            this.e.setVisibility(4);
        } else if (i == 2) {
            if (this.b != null) {
                this.d.setText(VoiceManager.c(this.b.duration));
            }
            this.e.setVisibility(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.b != null) {
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null) {
                voiceManager.b(true);
                voiceManager.b(this);
            }
            al.a(getContext(), this.b.from);
        }
    }

    private void f() {
        int i = R.anim.voice_btn_play_anim;
        int ap = TiebaApplication.g().ap();
        if (this.f2586a == 0) {
            if (ap == 1) {
                i = R.anim.voice_btn_play_anim_1;
            }
        } else if (ap == 1) {
            i = R.anim.voice_btn_play_anim_1;
        }
        if (this.c != null) {
            this.c.setImageResource(i);
        }
    }

    private void g() {
        int i = R.drawable.icon_thread_voice_reply_curve_three;
        int ap = TiebaApplication.g().ap();
        if (this.f2586a == 0) {
            if (ap == 1) {
                i = R.drawable.icon_thread_voice_reply_curve_three_1;
            }
        } else if (ap == 1) {
            i = R.drawable.icon_thread_voice_reply_curve_three_1;
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

    public void a() {
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
        if (context instanceof af) {
            return ((af) context).g();
        }
        return null;
    }

    @Override // android.view.View
    public void setTag(Object obj) {
        if (obj != null && (obj instanceof com.baidu.tbadk.widget.richText.p)) {
            com.baidu.tbadk.widget.richText.p pVar = (com.baidu.tbadk.widget.richText.p) obj;
            VoiceManager.VoiceModel voiceModel = (VoiceManager.VoiceModel) pVar.d();
            if (voiceModel == null) {
                voiceModel = new VoiceManager.VoiceModel();
                if (pVar.c() == 0) {
                    voiceModel.from = "pb_voice_play";
                } else {
                    voiceModel.from = "floor_voice_play";
                }
                voiceModel.voiceId = pVar.a();
                voiceModel.duration = pVar.b();
                pVar.a(voiceModel);
            }
            this.f2586a = pVar.c();
            setVoiceModel(voiceModel);
            e();
            obj = voiceModel;
        }
        super.setTag(obj);
    }

    @Override // com.baidu.tieba.voice.ad
    public void a(VoiceManager.VoiceModel voiceModel) {
        if (voiceModel != null) {
            if (this.b != voiceModel) {
                b(1);
            } else {
                b(voiceModel.voice_status.intValue());
            }
        }
    }

    @Override // com.baidu.tieba.voice.ad
    public void c(int i) {
        if (!i()) {
            b(1);
            return;
        }
        if (this.g == null) {
            b(this.b.voice_status.intValue());
        }
        a(i);
        if (this.b != null) {
            this.b.elapse = i;
        }
    }

    private boolean i() {
        if (this.b == null) {
            return false;
        }
        VoiceManager voiceManager = getVoiceManager();
        return voiceManager == null || voiceManager.a(this.b);
    }

    @Override // com.baidu.tieba.voice.ad
    public void b(int i, String str) {
        if (!com.baidu.adp.lib.h.h.a(str)) {
            Toast.makeText(getContext(), str, 1).show();
        }
    }

    @Override // com.baidu.tieba.voice.ad
    public VoiceManager.VoiceModel getVoiceModel() {
        return this.b;
    }

    public void c() {
        e();
    }

    @Override // com.baidu.tieba.voice.ad
    public ad getRealView() {
        Context context = getContext();
        if (context instanceof af) {
            return ((af) context).a(this.b);
        }
        return this;
    }

    @Override // com.baidu.tieba.voice.ad
    public void b() {
    }

    public void d() {
        this.b = null;
        setTag(null);
        b(1);
    }

    private int getBtnWidth() {
        VoiceManager.VoiceModel voiceModel = getVoiceModel();
        if (voiceModel == null) {
            return -1;
        }
        int i = voiceModel.duration;
        int a2 = UtilHelper.a(getContext());
        if (i > 10) {
            if (i <= 30) {
                int i2 = (int) (a2 * 0.3f);
                return (((i - 10) * (((int) (a2 * 0.45f)) - i2)) / 20) + i2;
            }
            return (int) (a2 * 0.45f);
        }
        int i3 = (int) (a2 * 0.18f);
        int i4 = (int) (a2 * 0.3f);
        if (i < 5) {
            i = 4;
        }
        return (((i - 1) * (i4 - i3)) / 10) + i3;
    }
}
