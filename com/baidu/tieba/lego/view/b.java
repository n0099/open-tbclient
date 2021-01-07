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
/* loaded from: classes9.dex */
public class b {
    private ViewPager.OnPageChangeListener cDO;
    private TextView frf;
    private IndicatorView frg;
    private BdBaseViewPagerAdapter frj;
    private c frk;
    private ListViewPager lcJ;
    private l lcQ;
    private Context mContext;
    private boolean frl = false;
    private boolean frm = true;
    private int frn = 2;
    private List<n> fro = new ArrayList();
    private long frp = 5000;
    private final Handler.Callback mCallback = new Handler.Callback() { // from class: com.baidu.tieba.lego.view.b.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    if (b.this.deO()) {
                        b.this.byU();
                        return false;
                    }
                    return false;
                default:
                    return false;
            }
        }
    };
    private final Handler mHandler = new Handler(this.mCallback);
    private ViewPager.OnPageChangeListener frq = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.lego.view.b.2
        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            int count;
            if (b.this.cDO != null) {
                b.this.cDO.onPageScrollStateChanged(i);
            }
            if (i == 1) {
                b.this.byW();
            } else if (i == 0 && (count = b.this.frj.getCount()) >= 2) {
                int currentItem = b.this.lcJ.getCurrentItem();
                int i2 = count - 2;
                if (currentItem < 1) {
                    b.this.lcJ.setCurrentItem(i2, false);
                } else if (currentItem > i2) {
                    b.this.lcJ.setCurrentItem(1, false);
                }
                b.this.byV();
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            if (b.this.cDO != null) {
                b.this.cDO.onPageScrolled(i, f, i2);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (b.this.frk != null && b.this.frk.rG(i) == i) {
                if (b.this.frg != null) {
                    b.this.frg.setPosition(b.this.frk.rH(i));
                    if (b.this.lcQ != null) {
                        b.this.frg.setVisibility(8);
                        b.this.lcQ.aP(b.this.frk.rH(i));
                    }
                }
                if (b.this.cDO != null) {
                    b.this.cDO.onPageSelected(b.this.frk.rH(i));
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public boolean deO() {
        if (this.lcJ == null) {
            return false;
        }
        int[] iArr = new int[2];
        this.lcJ.getLocationOnScreen(iArr);
        int measuredHeight = iArr[1] + (this.lcJ.getMeasuredHeight() / 2);
        return measuredHeight > 0 && measuredHeight < com.baidu.adp.lib.util.l.getEquipmentHeight(this.mContext);
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.cDO = onPageChangeListener;
    }

    public b(Context context, ListViewPager listViewPager, IndicatorView indicatorView, TextView textView) {
        a(context, listViewPager, indicatorView, textView);
    }

    private void a(Context context, ListViewPager listViewPager, IndicatorView indicatorView, TextView textView) {
        this.lcJ = listViewPager;
        this.frg = indicatorView;
        this.frf = textView;
        this.mContext = context;
        this.frj = new BdBaseViewPagerAdapter(context);
        if (this.lcJ != null) {
            this.lcJ.setAdapter(this.frj);
            this.lcJ.setOnPageChangeListener(this.frq);
        }
    }

    public void a(l lVar) {
        if (lVar != null) {
            this.frg.setVisibility(8);
        } else {
            this.frg.setVisibility(0);
        }
        this.lcQ = lVar;
    }

    public void setMaxScrollCountLimit(int i) {
        this.frn = i;
        if (this.frk != null) {
            this.frk.rI(i);
        }
    }

    public void a(Context context, com.baidu.tbadk.core.view.viewpager.b<?, ?> bVar) {
        if (this.frj != null) {
            this.frj.a(context, bVar);
        }
    }

    public void setDatas(List<n> list) {
        boolean z = true;
        if (x.getCount(list) != 0) {
            this.fro = list;
            this.frk = new c(this.fro, this.frl, this.frn);
            this.frk.rJ(2);
            this.frk.rK(1);
            this.frj.setDatas(this.frk.bzb());
            this.frj.notifyDataSetChanged();
            this.lcJ.setCurrentItem(this.frk.bza(), false);
            if (this.frk.byZ() > 0) {
                if (this.frk.byZ() > this.frn) {
                    if (this.frf != null) {
                        this.frf.setVisibility(0);
                        this.frf.setOnClickListener(null);
                        if (this.frg != null) {
                            this.frg.setVisibility(8);
                        }
                    }
                    if (this.frg != null && this.frf == null && this.frl) {
                        z = false;
                    }
                    if (!z) {
                        this.frg.setVisibility(8);
                        if (this.frg.getCount() != this.frn) {
                            this.frg.setCount(this.frn);
                        }
                    }
                    byV();
                }
                if (this.frk.byZ() >= 2 && this.frk.byZ() <= this.frn) {
                    if (this.frf != null) {
                        this.frf.setVisibility(8);
                    }
                    if (this.frg != null) {
                        this.frg.setVisibility(0);
                        if (this.frg.getCount() != this.frk.byZ()) {
                            this.frg.setCount(this.frk.byZ());
                            if (this.lcQ != null) {
                                this.lcQ.Fr(this.frk.byZ());
                                this.frg.setVisibility(8);
                            }
                        } else if (this.lcQ != null) {
                            this.lcQ.Fr(this.frk.byZ());
                            this.frg.setVisibility(8);
                        }
                    }
                    byV();
                }
                if (this.frk.byZ() < 2) {
                    if (this.frf != null) {
                        this.frf.setVisibility(8);
                    }
                    if (this.frg != null) {
                        this.frg.setVisibility(8);
                    }
                    byW();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void byU() {
        int count;
        if (this.lcJ != null && this.frj != null) {
            i I = j.I(this.mContext);
            if ((I == null || !I.isScroll()) && (count = this.frj.getCount()) >= 2) {
                int currentItem = this.lcJ.getCurrentItem();
                int i = count - 2;
                if (currentItem < 1) {
                    this.lcJ.setCurrentItem(i, false);
                } else if (currentItem > i) {
                    this.lcJ.setCurrentItem(1, false);
                } else {
                    this.lcJ.setCurrentItem(currentItem + 1);
                }
            }
        }
    }

    public void setAutoScrollIntervalTime(long j) {
        if (j < 0) {
            j = 0;
        }
        this.frp = j;
    }

    public void byV() {
        if (this.frm) {
            this.mHandler.removeMessages(1);
            this.mHandler.sendEmptyMessageDelayed(1, this.frp);
            return;
        }
        this.mHandler.removeMessages(1);
    }

    public void byW() {
        this.mHandler.removeMessages(1);
    }
}
