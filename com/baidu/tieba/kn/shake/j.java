package com.baidu.tieba.kn.shake;

import android.content.Context;
import android.media.MediaPlayer;
import android.media.SoundPool;
import com.baidu.tieba.util.aj;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class j {
    private Context c;
    private boolean i;

    /* renamed from: a  reason: collision with root package name */
    private MediaPlayer f1253a = null;
    private SoundPool b = null;
    private int d = 0;
    private int e = 0;
    private ArrayList f = null;
    private int g = 0;
    private boolean h = false;

    public j(Context context) {
        this.c = null;
        this.i = false;
        this.c = context;
        this.i = a();
    }

    public boolean a() {
        try {
            this.b = new SoundPool(7, 3, 0);
            this.d = this.b.load(this.c, R.raw.start, 1);
            this.e = this.b.load(this.c, R.raw.finish, 1);
            this.f = new ArrayList();
            for (int i = 0; i < 5; i++) {
                this.f.add(Integer.valueOf(this.b.load(this.c, R.raw.shake, 1)));
            }
            this.f1253a = MediaPlayer.create(this.c, (int) R.raw.background);
            return true;
        } catch (Exception e) {
            aj.b(getClass().getName(), "init", e.toString());
            b();
            return false;
        }
    }

    public void b() {
        if (this.i) {
            try {
                this.b.unload(this.d);
                this.b.unload(this.e);
                Iterator it = this.f.iterator();
                while (it.hasNext()) {
                    this.b.unload(((Integer) it.next()).intValue());
                }
                this.b.release();
                this.b = null;
                this.f1253a.stop();
                this.f1253a.release();
            } catch (Exception e) {
                aj.b(getClass().getName(), "release", e.toString());
            }
        }
    }

    public void c() {
        if (this.i) {
            this.b.play(this.d, 1.0f, 1.0f, 1, 0, 1.0f);
        }
    }

    public void d() {
        if (this.i) {
            this.b.stop(this.d);
        }
    }

    public void e() {
        if (this.i) {
            this.h = true;
            try {
                this.f1253a.start();
            } catch (Exception e) {
                aj.b(getClass().getName(), "playBackground", e.toString());
            }
        }
    }

    public void f() {
        if (this.i) {
            this.g++;
            this.g %= 5;
            this.b.play(((Integer) this.f.get(this.g)).intValue(), 1.0f, 1.0f, 0, 0, 1.0f);
        }
    }

    public void g() {
        if (this.i) {
            this.b.play(this.e, 1.0f, 1.0f, 1, 0, 1.0f);
        }
    }

    public void h() {
        if (this.i && this.f1253a.isPlaying()) {
            try {
                this.f1253a.pause();
            } catch (Exception e) {
                aj.b(getClass().getName(), "pause", e.toString());
            }
        }
    }

    public void a(int i) {
        if (this.i) {
            try {
                int duration = this.f1253a.getDuration() - i;
                if (duration < 0) {
                    duration = 0;
                }
                this.f1253a.seekTo(duration);
                if (this.h && !this.f1253a.isPlaying()) {
                    this.f1253a.start();
                }
            } catch (Exception e) {
                aj.b(getClass().getName(), "resume", e.toString());
            }
        }
    }
}
