package com.baidu.tieba.voice;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.baidu.location.LocationClientOption;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.UtilHelper;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class PlayVoiceBnt extends RelativeLayout implements View.OnClickListener, ac {

    /* renamed from: a  reason: collision with root package name */
    private int f2013a;
    private ai b;
    private ImageView c;
    private TextView d;
    private ProgressBar e;
    private int f;
    private FrameLayout g;
    private AnimationDrawable h;
    private Runnable i;

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
        this.f2013a = 0;
        this.f = 300;
        this.i = new j(this);
        this.f2013a = play_type.ordinal();
        a(context);
    }

    public PlayVoiceBnt(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2013a = 0;
        this.f = 300;
        this.i = new j(this);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.baidu.tieba.ag.Voice_play_type);
        this.f2013a = obtainStyledAttributes.getInteger(0, 0);
        obtainStyledAttributes.recycle();
        a(context);
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(getDefinedWH()[1], 1073741824));
    }

    public int[] getDefinedWH() {
        int[] iArr = new int[2];
        if (this.f2013a == 0) {
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

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.i);
        a();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        removeCallbacks(this.i);
        postDelayed(this.i, this.f);
    }

    public void b(Context context) {
        LayoutInflater.from(context).inflate(R.layout.play_voice_bnt, (ViewGroup) this, true);
        this.c = (ImageView) findViewById(R.id.playingImg);
        this.d = (TextView) findViewById(R.id.playTime);
        this.e = (ProgressBar) findViewById(R.id.progress);
        if (this.e != null) {
            this.e.setVisibility(4);
        }
        this.g = (FrameLayout) findViewById(R.id.play_container);
        d();
    }

    private void d() {
        int i;
        int ap = TiebaApplication.g().ap();
        if (this.f2013a == 0) {
            int i2 = ap != 1 ? R.drawable.but_thread_voice_selector : R.drawable.but_thread_voice_selector_1;
            i = ap != 1 ? -16777216 : -8682095;
            int i3 = ap != 1 ? R.anim.voice_btn_play_anim : R.anim.voice_btn_play_anim_1;
            setBackgroundResource(i2);
            if (this.d != null) {
                this.d.setTextSize(getContext().getResources().getDimensionPixelSize(R.dimen.voice_play_bnt_text_size_0));
                this.d.setTextColor(i);
            }
            if (this.c != null) {
                this.c.setBackgroundResource(i3);
            }
            int a2 = UtilHelper.a(getContext(), 12.0f);
            this.g.setPadding(a2, 0, a2, 0);
            return;
        }
        int i4 = ap != 1 ? R.drawable.but_thread_voice_reply_selector : R.drawable.but_thread_voice_reply_selector_1;
        i = ap != 1 ? -16777216 : -8682095;
        int i5 = ap != 1 ? R.anim.voice_btn_play_reply_anim : R.anim.voice_btn_play_reply_anim_1;
        setBackgroundResource(i4);
        if (this.d != null) {
            this.d.setTextSize(getContext().getResources().getDimensionPixelSize(R.dimen.voice_play_bnt_text_size_1));
            this.d.setTextColor(i);
        }
        if (this.c != null) {
            this.c.setBackgroundResource(i5);
        }
        int a3 = UtilHelper.a(getContext(), 8.0f);
        this.g.setPadding(a3, 0, a3, 0);
    }

    public void setVoiceModel(ai aiVar) {
        this.b = aiVar;
        if (this.b != null) {
            r voiceManager = getVoiceManager();
            if (voiceManager != null && voiceManager.a(aiVar)) {
                voiceManager.a(this);
                a(this.b.f);
                return;
            }
            this.d.setText(r.c(aiVar.d));
        }
    }

    public void a(int i) {
        String c;
        if (this.b != null && this.d != null) {
            int i2 = i / LocationClientOption.MIN_SCAN_SPAN;
            if (i2 > 0 && i2 < this.b.d) {
                c = r.c(this.b.d - i2);
            } else {
                c = r.c(this.b.d);
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
            g();
            return;
        }
        a();
        if (i == 1) {
            if (this.c != null) {
                this.c.setVisibility(0);
            }
            if (this.b != null) {
                this.d.setText(r.c(this.b.d));
            }
            this.e.setVisibility(4);
        } else if (i == 2) {
            if (this.c != null) {
                this.c.setVisibility(4);
            }
            this.e.setVisibility(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.b != null) {
            r voiceManager = getVoiceManager();
            if (voiceManager != null) {
                voiceManager.b(true);
                voiceManager.b(this);
            }
            com.baidu.tieba.ad.a(getContext(), this.b.f2028a);
        }
    }

    private void e() {
        int i;
        int ap = TiebaApplication.g().ap();
        if (this.f2013a == 0) {
            i = ap != 1 ? R.anim.voice_btn_play_anim : R.anim.voice_btn_play_anim_1;
        } else {
            i = ap != 1 ? R.anim.voice_btn_play_reply_anim : R.anim.voice_btn_play_reply_anim_1;
        }
        if (this.c != null) {
            this.c.setBackgroundResource(i);
        }
    }

    private void f() {
        int i;
        int ap = TiebaApplication.g().ap();
        if (this.f2013a == 0) {
            i = ap != 1 ? R.drawable.icon_thread_voice_reply_curve_three : R.drawable.icon_thread_voice_reply_curve_three_1;
        } else {
            i = ap != 1 ? R.drawable.icon_thread_voice_reply_three : R.drawable.icon_thread_voice_reply_three_1;
        }
        if (this.c != null) {
            this.c.setBackgroundResource(i);
        }
    }

    private void g() {
        if (this.h != null) {
            this.h.stop();
        }
        e();
        this.h = (AnimationDrawable) this.c.getBackground();
        this.h.start();
    }

    public void a() {
        Drawable background = this.c.getBackground();
        if (background instanceof AnimationDrawable) {
            this.h = (AnimationDrawable) background;
        }
        if (this.h != null) {
            this.h.stop();
        }
        f();
    }

    public r getVoiceManager() {
        Context context = getContext();
        if (context instanceof ae) {
            return ((ae) context).c_();
        }
        return null;
    }

    @Override // android.view.View
    public void setTag(Object obj) {
        if (obj != null && (obj instanceof com.baidu.tbadk.widget.richText.o)) {
            com.baidu.tbadk.widget.richText.o oVar = (com.baidu.tbadk.widget.richText.o) obj;
            ai aiVar = (ai) oVar.d();
            if (aiVar == null) {
                aiVar = new ai();
                if (oVar.c() == 0) {
                    aiVar.f2028a = "pb_voice_play";
                } else {
                    aiVar.f2028a = "floor_voice_play";
                }
                aiVar.b = oVar.a();
                aiVar.d = oVar.b();
                oVar.a(aiVar);
            }
            this.f2013a = oVar.c();
            setVoiceModel(aiVar);
            d();
            requestLayout();
            obj = aiVar;
        }
        super.setTag(obj);
    }

    @Override // com.baidu.tieba.voice.ac
    public void a(ai aiVar) {
        if (aiVar != null) {
            if (this.b != aiVar) {
                b(1);
            } else {
                b(aiVar.h.intValue());
            }
        }
    }

    @Override // com.baidu.tieba.voice.ac
    public void c(int i) {
        if (h()) {
            a(i);
            if (this.b != null) {
                this.b.f = i;
            }
        }
    }

    private boolean h() {
        if (this.b == null) {
            return false;
        }
        r voiceManager = getVoiceManager();
        return voiceManager == null || voiceManager.a(this.b);
    }

    @Override // com.baidu.tieba.voice.ac
    public void a(int i, String str) {
        if (!com.baidu.adp.lib.f.h.a(str)) {
            Toast.makeText(getContext(), str, 1).show();
        }
    }

    @Override // com.baidu.tieba.voice.ac
    public ai getVoiceModel() {
        return this.b;
    }

    public void b() {
        d();
    }

    @Override // com.baidu.tieba.voice.ac
    public ac getRealView() {
        Context context = getContext();
        if (context instanceof ae) {
            return ((ae) context).a(this.b);
        }
        return this;
    }

    @Override // com.baidu.tieba.voice.ac
    public void c() {
    }
}
