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
import com.baidu.tieba.n;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class a extends com.baidu.tieba.imMessageCenter.im.floatwindow.g {
    private InterfaceC0065a ceF;
    private com.baidu.tieba.imMessageCenter.im.floatwindow.e ceK;
    private FrameLayout cfj;
    private HeadImageView cfk;
    private HeadImageView cfl;
    private HeadImageView cfm;
    private HeadImageView cfn;
    private TextView cfo;
    private Animation cfp;
    private com.baidu.tieba.imMessageCenter.im.floatwindow.a.e cfq;
    private com.baidu.tieba.imMessageCenter.im.floatwindow.a.d cfr;
    private Point cfs;
    private boolean cft;
    private Runnable cfu;
    private c.a cfv;
    private e.a cfw;

    /* renamed from: com.baidu.tieba.imMessageCenter.im.floatwindow.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0065a {
        void acZ();
    }

    public a(Context context) {
        super(LayoutInflater.from(context).inflate(n.h.im_chat_float_window, (ViewGroup) null));
        this.cft = false;
        this.cfu = new b(this);
        this.cfv = new c(this);
        this.cfw = new d(this);
        this.ceK = new com.baidu.tieba.imMessageCenter.im.floatwindow.e();
        this.cfj = (FrameLayout) this.ceR.findViewById(n.g.chat_float_window_wrapper);
        this.cfk = (HeadImageView) this.ceR.findViewById(n.g.chat_float_window_first);
        this.cfl = (HeadImageView) this.ceR.findViewById(n.g.chat_float_window_second);
        this.cfm = (HeadImageView) this.ceR.findViewById(n.g.chat_float_window_third);
        this.cfn = (HeadImageView) this.ceR.findViewById(n.g.chat_float_window_fourth);
        d(this.cfk);
        d(this.cfl);
        d(this.cfm);
        d(this.cfn);
        this.cfo = (TextView) this.ceR.findViewById(n.g.chat_float_window_text);
        this.cfs = new Point();
    }

    private void d(HeadImageView headImageView) {
        headImageView.setAutoChangeStyle(false);
        headImageView.setIsRound(true);
        headImageView.setDefaultBgResource(0);
    }

    public boolean adn() {
        return this.cft;
    }

    public com.baidu.tieba.imMessageCenter.im.floatwindow.e ada() {
        this.ceK.ab(this.ceR);
        return this.ceK;
    }

    public void a(Handler handler, boolean z) {
        if (!adc()) {
            add();
            if (handler != null && z) {
                handler.post(this.cfu);
            }
        }
    }

    public void a(InterfaceC0065a interfaceC0065a) {
        this.ceF = interfaceC0065a;
    }

    public void ji(int i) {
        int i2;
        if (i <= 0) {
            this.cfo.setVisibility(8);
            return;
        }
        this.cfo.setVisibility(0);
        if (i < 10) {
            this.cfo.setText(String.valueOf(i));
            i2 = n.f.icon_news_head_prompt_one;
        } else if (i < 100) {
            this.cfo.setText(String.valueOf(i));
            i2 = n.f.icon_news_head_prompt_two;
        } else {
            this.cfo.setText("   ");
            i2 = n.f.icon_news_head_prompt_more;
        }
        this.cfo.setBackgroundResource(i2);
    }

    public void ado() {
        int i;
        int measuredWidth = this.ceR.getMeasuredWidth();
        int i2 = this.ceT.x;
        if ((measuredWidth / 2) + i2 > this.ceN / 2) {
            i = this.ceN - measuredWidth;
        } else {
            i = 0;
        }
        com.baidu.tieba.imMessageCenter.im.floatwindow.a.a.adf().a(aF(i2, i));
    }

    public void b(Point point) {
        this.cfs.x = this.ceT.x;
        this.cfs.y = this.ceT.y;
        this.cft = true;
        setTouchable(false);
        com.baidu.tieba.imMessageCenter.im.floatwindow.a.a.adf().a(c(point));
    }

    public void adp() {
        int measuredWidth = this.ceR.getMeasuredWidth();
        boolean z = this.cfs.x != 0;
        boolean z2 = this.cfs.x != this.ceN - measuredWidth;
        if (z && z2) {
            if (this.cfs.x > this.ceN / 2) {
                this.cfs.x = this.ceN - measuredWidth;
            } else {
                this.cfs.x = 0;
            }
        }
        this.cft = true;
        setTouchable(false);
        com.baidu.tieba.imMessageCenter.im.floatwindow.a.a.adf().a(c(this.cfs));
    }

    public void J(ArrayList<String> arrayList) {
        if (arrayList != null && !arrayList.isEmpty()) {
            int size = arrayList.size();
            jj(size);
            for (int i = 0; i < size; i++) {
                F(i, arrayList.get(i));
            }
        }
    }

    private void F(int i, String str) {
        switch (i) {
            case 0:
                this.cfk.d(str, 12, false);
                return;
            case 1:
                this.cfl.d(str, 12, false);
                return;
            case 2:
                this.cfm.d(str, 12, false);
                return;
            case 3:
                this.cfn.d(str, 12, false);
                return;
            default:
                return;
        }
    }

    private void jj(int i) {
        this.cfk.setVisibility(i > 0 ? 0 : 8);
        this.cfl.setVisibility(i > 1 ? 0 : 8);
        this.cfm.setVisibility(i > 2 ? 0 : 8);
        this.cfn.setVisibility(i <= 3 ? 8 : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animation adq() {
        if (this.cfp == null) {
            this.cfp = AnimationUtils.loadAnimation(TbadkCoreApplication.m411getInst(), n.a.float_window_in_anim);
        }
        return this.cfp;
    }

    private com.baidu.tieba.imMessageCenter.im.floatwindow.a.e aF(int i, int i2) {
        if (this.cfq == null) {
            this.cfq = new com.baidu.tieba.imMessageCenter.im.floatwindow.a.e(20);
            this.cfq.a(this.cfw);
        }
        this.cfq.setStart(i);
        this.cfq.jh(i2);
        return this.cfq;
    }

    private com.baidu.tieba.imMessageCenter.im.floatwindow.a.d c(Point point) {
        if (this.cfr == null) {
            this.cfr = new com.baidu.tieba.imMessageCenter.im.floatwindow.a.d(300L);
            this.cfr.a(this.cfv);
        }
        Point point2 = new Point();
        point2.x = this.ceT.x;
        point2.y = this.ceT.y;
        this.cfr.a(point2, point);
        return this.cfr;
    }
}
