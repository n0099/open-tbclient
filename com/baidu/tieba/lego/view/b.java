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
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.viewpager.BdBaseViewPagerAdapter;
import com.baidu.tbadk.core.view.viewpager.c;
import com.baidu.tbadk.widget.viewpager.ListViewPager;
import com.baidu.tieba.lego.card.view.l;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class b {
    private ViewPager.OnPageChangeListener cBy;
    private TextView foN;
    private IndicatorView foO;
    private BdBaseViewPagerAdapter foR;
    private c foS;
    private ListViewPager lgg;
    private l lgn;
    private Context mContext;
    private boolean foT = false;
    private boolean foU = true;
    private int foV = 2;
    private List<n> foW = new ArrayList();
    private long foX = 5000;
    private final Handler.Callback mCallback = new Handler.Callback() { // from class: com.baidu.tieba.lego.view.b.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    if (b.this.dcU()) {
                        b.this.bvu();
                        return false;
                    }
                    return false;
                default:
                    return false;
            }
        }
    };
    private final Handler mHandler = new Handler(this.mCallback);
    private ViewPager.OnPageChangeListener foY = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.lego.view.b.2
        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            int count;
            if (b.this.cBy != null) {
                b.this.cBy.onPageScrollStateChanged(i);
            }
            if (i == 1) {
                b.this.bvw();
            } else if (i == 0 && (count = b.this.foR.getCount()) >= 2) {
                int currentItem = b.this.lgg.getCurrentItem();
                int i2 = count - 2;
                if (currentItem < 1) {
                    b.this.lgg.setCurrentItem(i2, false);
                } else if (currentItem > i2) {
                    b.this.lgg.setCurrentItem(1, false);
                }
                b.this.bvv();
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            if (b.this.cBy != null) {
                b.this.cBy.onPageScrolled(i, f, i2);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (b.this.foS != null && b.this.foS.qf(i) == i) {
                if (b.this.foO != null) {
                    b.this.foO.setPosition(b.this.foS.qg(i));
                    if (b.this.lgn != null) {
                        b.this.foO.setVisibility(8);
                        b.this.lgn.aS(b.this.foS.qg(i));
                    }
                }
                if (b.this.cBy != null) {
                    b.this.cBy.onPageSelected(b.this.foS.qg(i));
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dcU() {
        if (this.lgg == null) {
            return false;
        }
        int[] iArr = new int[2];
        this.lgg.getLocationOnScreen(iArr);
        int measuredHeight = iArr[1] + (this.lgg.getMeasuredHeight() / 2);
        return measuredHeight > 0 && measuredHeight < com.baidu.adp.lib.util.l.getEquipmentHeight(this.mContext);
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.cBy = onPageChangeListener;
    }

    public b(Context context, ListViewPager listViewPager, IndicatorView indicatorView, TextView textView) {
        a(context, listViewPager, indicatorView, textView);
    }

    private void a(Context context, ListViewPager listViewPager, IndicatorView indicatorView, TextView textView) {
        this.lgg = listViewPager;
        this.foO = indicatorView;
        this.foN = textView;
        this.mContext = context;
        this.foR = new BdBaseViewPagerAdapter(context);
        if (this.lgg != null) {
            this.lgg.setAdapter(this.foR);
            this.lgg.setOnPageChangeListener(this.foY);
        }
    }

    public void a(l lVar) {
        if (lVar != null) {
            this.foO.setVisibility(8);
        } else {
            this.foO.setVisibility(0);
        }
        this.lgn = lVar;
    }

    public void setMaxScrollCountLimit(int i) {
        this.foV = i;
        if (this.foS != null) {
            this.foS.qh(i);
        }
    }

    public void a(Context context, com.baidu.tbadk.core.view.viewpager.b<?, ?> bVar) {
        if (this.foR != null) {
            this.foR.a(context, bVar);
        }
    }

    public void setDatas(List<n> list) {
        boolean z = true;
        if (y.getCount(list) != 0) {
            this.foW = list;
            this.foS = new c(this.foW, this.foT, this.foV);
            this.foS.qi(2);
            this.foS.qj(1);
            this.foR.setDatas(this.foS.bvB());
            this.foR.notifyDataSetChanged();
            this.lgg.setCurrentItem(this.foS.bvA(), false);
            if (this.foS.bvz() > 0) {
                if (this.foS.bvz() > this.foV) {
                    if (this.foN != null) {
                        this.foN.setVisibility(0);
                        this.foN.setOnClickListener(null);
                        if (this.foO != null) {
                            this.foO.setVisibility(8);
                        }
                    }
                    if (this.foO != null && this.foN == null && this.foT) {
                        z = false;
                    }
                    if (!z) {
                        this.foO.setVisibility(8);
                        if (this.foO.getCount() != this.foV) {
                            this.foO.setCount(this.foV);
                        }
                    }
                    bvv();
                }
                if (this.foS.bvz() >= 2 && this.foS.bvz() <= this.foV) {
                    if (this.foN != null) {
                        this.foN.setVisibility(8);
                    }
                    if (this.foO != null) {
                        this.foO.setVisibility(0);
                        if (this.foO.getCount() != this.foS.bvz()) {
                            this.foO.setCount(this.foS.bvz());
                            if (this.lgn != null) {
                                this.lgn.Ed(this.foS.bvz());
                                this.foO.setVisibility(8);
                            }
                        } else if (this.lgn != null) {
                            this.lgn.Ed(this.foS.bvz());
                            this.foO.setVisibility(8);
                        }
                    }
                    bvv();
                }
                if (this.foS.bvz() < 2) {
                    if (this.foN != null) {
                        this.foN.setVisibility(8);
                    }
                    if (this.foO != null) {
                        this.foO.setVisibility(8);
                    }
                    bvw();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bvu() {
        int count;
        if (this.lgg != null && this.foR != null) {
            i I = j.I(this.mContext);
            if ((I == null || !I.isScroll()) && (count = this.foR.getCount()) >= 2) {
                int currentItem = this.lgg.getCurrentItem();
                int i = count - 2;
                if (currentItem < 1) {
                    this.lgg.setCurrentItem(i, false);
                } else if (currentItem > i) {
                    this.lgg.setCurrentItem(1, false);
                } else {
                    this.lgg.setCurrentItem(currentItem + 1);
                }
            }
        }
    }

    public void setAutoScrollIntervalTime(long j) {
        if (j < 0) {
            j = 0;
        }
        this.foX = j;
    }

    public void bvv() {
        if (this.foU) {
            this.mHandler.removeMessages(1);
            this.mHandler.sendEmptyMessageDelayed(1, this.foX);
            return;
        }
        this.mHandler.removeMessages(1);
    }

    public void bvw() {
        this.mHandler.removeMessages(1);
    }
}
