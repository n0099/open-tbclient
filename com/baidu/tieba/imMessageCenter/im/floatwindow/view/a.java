package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import android.content.Context;
import android.graphics.Point;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.imMessageCenter.im.floatwindow.a.c;
import com.baidu.tieba.imMessageCenter.im.floatwindow.a.e;
import com.baidu.tieba.t;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class a extends com.baidu.tieba.imMessageCenter.im.floatwindow.g {
    private InterfaceC0068a doC;
    private com.baidu.tieba.imMessageCenter.im.floatwindow.e doH;
    private FrameLayout dpg;
    private HeadImageView dph;
    private HeadImageView dpj;
    private HeadImageView dpk;
    private HeadImageView dpl;
    private TextView dpm;
    private Animation dpn;
    private com.baidu.tieba.imMessageCenter.im.floatwindow.a.e dpo;
    private com.baidu.tieba.imMessageCenter.im.floatwindow.a.d dpp;
    private Point dpq;
    private boolean dpr;
    private Runnable dps;
    private c.a dpt;
    private e.a dpu;

    /* renamed from: com.baidu.tieba.imMessageCenter.im.floatwindow.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0068a {
        void axy();
    }

    public a(Context context) {
        super(LayoutInflater.from(context).inflate(t.h.im_chat_float_window, (ViewGroup) null));
        this.dpr = false;
        this.dps = new b(this);
        this.dpt = new c(this);
        this.dpu = new d(this);
        this.doH = new com.baidu.tieba.imMessageCenter.im.floatwindow.e();
        this.dpg = (FrameLayout) this.doO.findViewById(t.g.chat_float_window_wrapper);
        this.dph = (HeadImageView) this.doO.findViewById(t.g.chat_float_window_first);
        this.dpj = (HeadImageView) this.doO.findViewById(t.g.chat_float_window_second);
        this.dpk = (HeadImageView) this.doO.findViewById(t.g.chat_float_window_third);
        this.dpl = (HeadImageView) this.doO.findViewById(t.g.chat_float_window_fourth);
        d(this.dph);
        d(this.dpj);
        d(this.dpk);
        d(this.dpl);
        this.dpm = (TextView) this.doO.findViewById(t.g.chat_float_window_text);
        this.dpq = new Point();
    }

    private void d(HeadImageView headImageView) {
        headImageView.setAutoChangeStyle(false);
        headImageView.setIsRound(true);
        headImageView.setDefaultBgResource(0);
    }

    public boolean axM() {
        return this.dpr;
    }

    public com.baidu.tieba.imMessageCenter.im.floatwindow.e axz() {
        this.doH.aK(this.doO);
        return this.doH;
    }

    public void a(Handler handler, boolean z) {
        if (!axB()) {
            axC();
            if (handler != null && z) {
                handler.post(this.dps);
            }
        }
    }

    public void a(InterfaceC0068a interfaceC0068a) {
        this.doC = interfaceC0068a;
    }

    public void mb(int i) {
        int i2;
        if (i <= 0) {
            this.dpm.setVisibility(8);
            return;
        }
        this.dpm.setVisibility(0);
        if (i < 10) {
            this.dpm.setText(String.valueOf(i));
            i2 = t.f.icon_news_head_prompt_one;
        } else if (i < 100) {
            this.dpm.setText(String.valueOf(i));
            i2 = t.f.icon_news_head_prompt_two;
        } else {
            this.dpm.setText("   ");
            i2 = t.f.icon_news_head_prompt_more;
        }
        this.dpm.setBackgroundResource(i2);
    }

    public void axN() {
        int i;
        int measuredWidth = this.doO.getMeasuredWidth();
        int i2 = this.doQ.x;
        if ((measuredWidth / 2) + i2 > this.doK / 2) {
            i = this.doK - measuredWidth;
        } else {
            i = 0;
        }
        com.baidu.tieba.imMessageCenter.im.floatwindow.a.a.axE().a(ba(i2, i));
    }

    public void b(Point point) {
        this.dpq.x = this.doQ.x;
        this.dpq.y = this.doQ.y;
        this.dpr = true;
        setTouchable(false);
        com.baidu.tieba.imMessageCenter.im.floatwindow.a.a.axE().a(c(point));
    }

    public void axO() {
        int measuredWidth = this.doO.getMeasuredWidth();
        boolean z = this.dpq.x != 0;
        boolean z2 = this.dpq.x != this.doK - measuredWidth;
        if (z && z2) {
            if (this.dpq.x > this.doK / 2) {
                this.dpq.x = this.doK - measuredWidth;
            } else {
                this.dpq.x = 0;
            }
        }
        this.dpr = true;
        setTouchable(false);
        com.baidu.tieba.imMessageCenter.im.floatwindow.a.a.axE().a(c(this.dpq));
    }

    public void W(ArrayList<String> arrayList) {
        if (arrayList != null && !arrayList.isEmpty()) {
            int size = arrayList.size();
            mc(size);
            for (int i = 0; i < size; i++) {
                B(i, arrayList.get(i));
            }
        }
    }

    private void B(int i, String str) {
        switch (i) {
            case 0:
                this.dph.c(str, 12, false);
                return;
            case 1:
                this.dpj.c(str, 12, false);
                return;
            case 2:
                this.dpk.c(str, 12, false);
                return;
            case 3:
                this.dpl.c(str, 12, false);
                return;
            default:
                return;
        }
    }

    private void mc(int i) {
        this.dph.setVisibility(i > 0 ? 0 : 8);
        this.dpj.setVisibility(i > 1 ? 0 : 8);
        this.dpk.setVisibility(i > 2 ? 0 : 8);
        this.dpl.setVisibility(i <= 3 ? 8 : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animation axP() {
        if (this.dpn == null) {
            this.dpn = AnimationUtils.loadAnimation(TbadkCoreApplication.m9getInst(), t.a.float_window_in_anim);
        }
        return this.dpn;
    }

    private com.baidu.tieba.imMessageCenter.im.floatwindow.a.e ba(int i, int i2) {
        if (this.dpo == null) {
            this.dpo = new com.baidu.tieba.imMessageCenter.im.floatwindow.a.e(20);
            this.dpo.a(this.dpu);
        }
        this.dpo.setStart(i);
        this.dpo.ma(i2);
        return this.dpo;
    }

    private com.baidu.tieba.imMessageCenter.im.floatwindow.a.d c(Point point) {
        if (this.dpp == null) {
            this.dpp = new com.baidu.tieba.imMessageCenter.im.floatwindow.a.d(300L);
            this.dpp.a(this.dpt);
        }
        Point point2 = new Point();
        point2.x = this.doQ.x;
        point2.y = this.doQ.y;
        this.dpp.a(point2, point);
        return this.dpp;
    }
}
