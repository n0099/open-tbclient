package com.baidu.tieba.lego.view;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import com.baidu.adp.base.i;
import com.baidu.adp.base.j;
import com.baidu.adp.widget.IndicatorView;
import com.baidu.adp.widget.ListView.n;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.viewpager.BdBaseViewPagerAdapter;
import com.baidu.tbadk.core.view.viewpager.c;
import com.baidu.tbadk.widget.viewpager.ListViewPager;
import com.baidu.tieba.lego.card.view.l;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class b {
    private ViewPager.OnPageChangeListener czc;
    private c fmA;
    private TextView fmv;
    private IndicatorView fmw;
    private BdBaseViewPagerAdapter fmz;
    private ListViewPager kYc;
    private l kYj;
    private Context mContext;
    private boolean fmB = false;
    private boolean fmC = true;
    private int fmD = 2;
    private List<n> fmE = new ArrayList();
    private long fmF = 5000;
    private final Handler.Callback mCallback = new Handler.Callback() { // from class: com.baidu.tieba.lego.view.b.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    if (b.this.daW()) {
                        b.this.bva();
                        return false;
                    }
                    return false;
                default:
                    return false;
            }
        }
    };
    private final Handler mHandler = new Handler(this.mCallback);
    private ViewPager.OnPageChangeListener fmG = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.lego.view.b.2
        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            int count;
            if (b.this.czc != null) {
                b.this.czc.onPageScrollStateChanged(i);
            }
            if (i == 1) {
                b.this.bvc();
            } else if (i == 0 && (count = b.this.fmz.getCount()) >= 2) {
                int currentItem = b.this.kYc.getCurrentItem();
                int i2 = count - 2;
                if (currentItem < 1) {
                    b.this.kYc.setCurrentItem(i2, false);
                } else if (currentItem > i2) {
                    b.this.kYc.setCurrentItem(1, false);
                }
                b.this.bvb();
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            if (b.this.czc != null) {
                b.this.czc.onPageScrolled(i, f, i2);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (b.this.fmA != null && b.this.fmA.qa(i) == i) {
                if (b.this.fmw != null) {
                    b.this.fmw.setPosition(b.this.fmA.qb(i));
                    if (b.this.kYj != null) {
                        b.this.fmw.setVisibility(8);
                        b.this.kYj.aP(b.this.fmA.qb(i));
                    }
                }
                if (b.this.czc != null) {
                    b.this.czc.onPageSelected(b.this.fmA.qb(i));
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public boolean daW() {
        if (this.kYc == null) {
            return false;
        }
        int[] iArr = new int[2];
        this.kYc.getLocationOnScreen(iArr);
        int measuredHeight = iArr[1] + (this.kYc.getMeasuredHeight() / 2);
        return measuredHeight > 0 && measuredHeight < com.baidu.adp.lib.util.l.getEquipmentHeight(this.mContext);
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.czc = onPageChangeListener;
    }

    public b(Context context, ListViewPager listViewPager, IndicatorView indicatorView, TextView textView) {
        a(context, listViewPager, indicatorView, textView);
    }

    private void a(Context context, ListViewPager listViewPager, IndicatorView indicatorView, TextView textView) {
        this.kYc = listViewPager;
        this.fmw = indicatorView;
        this.fmv = textView;
        this.mContext = context;
        this.fmz = new BdBaseViewPagerAdapter(context);
        if (this.kYc != null) {
            this.kYc.setAdapter(this.fmz);
            this.kYc.setOnPageChangeListener(this.fmG);
        }
    }

    public void a(l lVar) {
        if (lVar != null) {
            this.fmw.setVisibility(8);
        } else {
            this.fmw.setVisibility(0);
        }
        this.kYj = lVar;
    }

    public void setMaxScrollCountLimit(int i) {
        this.fmD = i;
        if (this.fmA != null) {
            this.fmA.qc(i);
        }
    }

    public void a(Context context, com.baidu.tbadk.core.view.viewpager.b<?, ?> bVar) {
        if (this.fmz != null) {
            this.fmz.a(context, bVar);
        }
    }

    public void setDatas(List<n> list) {
        boolean z = true;
        if (x.getCount(list) != 0) {
            this.fmE = list;
            this.fmA = new c(this.fmE, this.fmB, this.fmD);
            this.fmA.qd(2);
            this.fmA.qe(1);
            this.fmz.setDatas(this.fmA.bvh());
            this.fmz.notifyDataSetChanged();
            this.kYc.setCurrentItem(this.fmA.bvg(), false);
            if (this.fmA.bvf() > 0) {
                if (this.fmA.bvf() > this.fmD) {
                    if (this.fmv != null) {
                        this.fmv.setVisibility(0);
                        this.fmv.setOnClickListener(null);
                        if (this.fmw != null) {
                            this.fmw.setVisibility(8);
                        }
                    }
                    if (this.fmw != null && this.fmv == null && this.fmB) {
                        z = false;
                    }
                    if (!z) {
                        this.fmw.setVisibility(8);
                        if (this.fmw.getCount() != this.fmD) {
                            this.fmw.setCount(this.fmD);
                        }
                    }
                    bvb();
                }
                if (this.fmA.bvf() >= 2 && this.fmA.bvf() <= this.fmD) {
                    if (this.fmv != null) {
                        this.fmv.setVisibility(8);
                    }
                    if (this.fmw != null) {
                        this.fmw.setVisibility(0);
                        if (this.fmw.getCount() != this.fmA.bvf()) {
                            this.fmw.setCount(this.fmA.bvf());
                            if (this.kYj != null) {
                                this.kYj.DL(this.fmA.bvf());
                                this.fmw.setVisibility(8);
                            }
                        } else if (this.kYj != null) {
                            this.kYj.DL(this.fmA.bvf());
                            this.fmw.setVisibility(8);
                        }
                    }
                    bvb();
                }
                if (this.fmA.bvf() < 2) {
                    if (this.fmv != null) {
                        this.fmv.setVisibility(8);
                    }
                    if (this.fmw != null) {
                        this.fmw.setVisibility(8);
                    }
                    bvc();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bva() {
        int count;
        if (this.kYc != null && this.fmz != null) {
            i I = j.I(this.mContext);
            if ((I == null || !I.isScroll()) && (count = this.fmz.getCount()) >= 2) {
                int currentItem = this.kYc.getCurrentItem();
                int i = count - 2;
                if (currentItem < 1) {
                    this.kYc.setCurrentItem(i, false);
                } else if (currentItem > i) {
                    this.kYc.setCurrentItem(1, false);
                } else {
                    this.kYc.setCurrentItem(currentItem + 1);
                }
            }
        }
    }

    public void setAutoScrollIntervalTime(long j) {
        if (j < 0) {
            j = 0;
        }
        this.fmF = j;
    }

    public void bvb() {
        if (this.fmC) {
            this.mHandler.removeMessages(1);
            this.mHandler.sendEmptyMessageDelayed(1, this.fmF);
            return;
        }
        this.mHandler.removeMessages(1);
    }

    public void bvc() {
        this.mHandler.removeMessages(1);
    }
}
