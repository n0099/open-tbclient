package com.baidu.tieba.lego.view;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.widget.TextView;
import com.baidu.adp.base.h;
import com.baidu.adp.base.i;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.IndicatorView;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.viewpager.BdBaseViewPagerAdapter;
import com.baidu.tbadk.core.view.viewpager.c;
import com.baidu.tbadk.core.view.viewpager.d;
import com.baidu.tbadk.widget.viewpager.ListViewPager;
import com.baidu.tieba.lego.card.view.j;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class b {
    private TextView bUO;
    private IndicatorView bUP;
    private BdBaseViewPagerAdapter bUS;
    private d bUT;
    private ViewPager.OnPageChangeListener bUY;
    private j gLG;
    private ListViewPager gLz;
    private Context mContext;
    private boolean bUU = false;
    private boolean bUV = true;
    private int bUW = 2;
    private List<m> bUX = new ArrayList();
    private long bUZ = TbConfig.NOTIFY_SOUND_INTERVAL;
    private final Handler.Callback mCallback = new Handler.Callback() { // from class: com.baidu.tieba.lego.view.b.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    if (b.this.bBn()) {
                        b.this.afk();
                        return false;
                    }
                    return false;
                default:
                    return false;
            }
        }
    };
    private final Handler mHandler = new Handler(this.mCallback);
    private ViewPager.OnPageChangeListener bVa = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.lego.view.b.2
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            int count;
            if (b.this.bUY != null) {
                b.this.bUY.onPageScrollStateChanged(i);
            }
            if (i == 1) {
                b.this.afm();
            } else if (i == 0 && (count = b.this.bUS.getCount()) >= 2) {
                int currentItem = b.this.gLz.getCurrentItem();
                int i2 = count - 2;
                if (currentItem < 1) {
                    b.this.gLz.setCurrentItem(i2, false);
                } else if (currentItem > i2) {
                    b.this.gLz.setCurrentItem(1, false);
                }
                b.this.afl();
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            if (b.this.bUY != null) {
                b.this.bUY.onPageScrolled(i, f, i2);
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (b.this.bUT != null && b.this.bUT.ip(i) == i) {
                if (b.this.bUP != null) {
                    b.this.bUP.setPosition(b.this.bUT.iq(i));
                    if (b.this.gLG != null) {
                        b.this.bUP.setVisibility(8);
                        b.this.gLG.aI(b.this.bUT.iq(i));
                    }
                }
                if (b.this.bUY != null) {
                    b.this.bUY.onPageSelected(b.this.bUT.iq(i));
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bBn() {
        if (this.gLz == null) {
            return false;
        }
        int[] iArr = new int[2];
        this.gLz.getLocationOnScreen(iArr);
        int measuredHeight = iArr[1] + (this.gLz.getMeasuredHeight() / 2);
        return measuredHeight > 0 && measuredHeight < l.aQ(this.mContext);
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.bUY = onPageChangeListener;
    }

    public b(Context context, ListViewPager listViewPager, IndicatorView indicatorView, TextView textView) {
        a(context, listViewPager, indicatorView, textView);
    }

    private void a(Context context, ListViewPager listViewPager, IndicatorView indicatorView, TextView textView) {
        this.gLz = listViewPager;
        this.bUP = indicatorView;
        this.bUO = textView;
        this.mContext = context;
        this.bUS = new BdBaseViewPagerAdapter(context);
        if (this.gLz != null) {
            this.gLz.setAdapter(this.bUS);
            this.gLz.setOnPageChangeListener(this.bVa);
        }
    }

    public void a(j jVar) {
        if (jVar != null) {
            this.bUP.setVisibility(8);
        } else {
            this.bUP.setVisibility(0);
        }
        this.gLG = jVar;
    }

    public void setMaxScrollCountLimit(int i) {
        this.bUW = i;
        if (this.bUT != null) {
            this.bUT.ir(i);
        }
    }

    public void a(Context context, c<?, ?> cVar) {
        if (this.bUS != null) {
            this.bUS.a(context, cVar);
        }
    }

    public void setDatas(List<m> list) {
        boolean z = true;
        if (v.S(list) != 0) {
            this.bUX = list;
            this.bUT = new d(this.bUX, this.bUU, this.bUW);
            this.bUT.is(2);
            this.bUT.it(1);
            this.bUS.setDatas(this.bUT.afr());
            this.bUS.notifyDataSetChanged();
            this.gLz.setCurrentItem(this.bUT.afq(), false);
            if (this.bUT.afp() > 0) {
                if (this.bUT.afp() > this.bUW) {
                    if (this.bUO != null) {
                        this.bUO.setVisibility(0);
                        this.bUO.setOnClickListener(null);
                        if (this.bUP != null) {
                            this.bUP.setVisibility(8);
                        }
                    }
                    if (this.bUP != null && this.bUO == null && this.bUU) {
                        z = false;
                    }
                    if (!z) {
                        this.bUP.setVisibility(8);
                        if (this.bUP.getCount() != this.bUW) {
                            this.bUP.setCount(this.bUW);
                        }
                    }
                    afl();
                }
                if (this.bUT.afp() >= 2 && this.bUT.afp() <= this.bUW) {
                    if (this.bUO != null) {
                        this.bUO.setVisibility(8);
                    }
                    if (this.bUP != null) {
                        this.bUP.setVisibility(0);
                        if (this.bUP.getCount() != this.bUT.afp()) {
                            this.bUP.setCount(this.bUT.afp());
                            if (this.gLG != null) {
                                this.gLG.uY(this.bUT.afp());
                                this.bUP.setVisibility(8);
                            }
                        } else if (this.gLG != null) {
                            this.gLG.uY(this.bUT.afp());
                            this.bUP.setVisibility(8);
                        }
                    }
                    afl();
                }
                if (this.bUT.afp() < 2) {
                    if (this.bUO != null) {
                        this.bUO.setVisibility(8);
                    }
                    if (this.bUP != null) {
                        this.bUP.setVisibility(8);
                    }
                    afm();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void afk() {
        int count;
        if (this.gLz != null && this.bUS != null) {
            h aI = i.aI(this.mContext);
            if ((aI == null || !aI.isScroll()) && (count = this.bUS.getCount()) >= 2) {
                int currentItem = this.gLz.getCurrentItem();
                int i = count - 2;
                if (currentItem < 1) {
                    this.gLz.setCurrentItem(i, false);
                } else if (currentItem > i) {
                    this.gLz.setCurrentItem(1, false);
                } else {
                    this.gLz.setCurrentItem(currentItem + 1);
                }
            }
        }
    }

    public void setAutoScrollIntervalTime(long j) {
        if (j < 0) {
            j = 0;
        }
        this.bUZ = j;
    }

    public void afl() {
        if (this.bUV) {
            this.mHandler.removeMessages(1);
            this.mHandler.sendEmptyMessageDelayed(1, this.bUZ);
            return;
        }
        this.mHandler.removeMessages(1);
    }

    public void afm() {
        this.mHandler.removeMessages(1);
    }
}
