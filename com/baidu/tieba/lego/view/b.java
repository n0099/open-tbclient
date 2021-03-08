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
/* loaded from: classes8.dex */
public class b {
    private ViewPager.OnPageChangeListener cCY;
    private TextView fqn;
    private IndicatorView fqo;
    private BdBaseViewPagerAdapter fqr;
    private c fqs;
    private l liD;
    private ListViewPager liw;
    private Context mContext;
    private boolean fqt = false;
    private boolean fqu = true;
    private int fqv = 2;
    private List<n> fqw = new ArrayList();
    private long fqx = 5000;
    private final Handler.Callback mCallback = new Handler.Callback() { // from class: com.baidu.tieba.lego.view.b.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    if (b.this.ddk()) {
                        b.this.bvx();
                        return false;
                    }
                    return false;
                default:
                    return false;
            }
        }
    };
    private final Handler mHandler = new Handler(this.mCallback);
    private ViewPager.OnPageChangeListener fqy = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.lego.view.b.2
        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            int count;
            if (b.this.cCY != null) {
                b.this.cCY.onPageScrollStateChanged(i);
            }
            if (i == 1) {
                b.this.bvz();
            } else if (i == 0 && (count = b.this.fqr.getCount()) >= 2) {
                int currentItem = b.this.liw.getCurrentItem();
                int i2 = count - 2;
                if (currentItem < 1) {
                    b.this.liw.setCurrentItem(i2, false);
                } else if (currentItem > i2) {
                    b.this.liw.setCurrentItem(1, false);
                }
                b.this.bvy();
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            if (b.this.cCY != null) {
                b.this.cCY.onPageScrolled(i, f, i2);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (b.this.fqs != null && b.this.fqs.qg(i) == i) {
                if (b.this.fqo != null) {
                    b.this.fqo.setPosition(b.this.fqs.qh(i));
                    if (b.this.liD != null) {
                        b.this.fqo.setVisibility(8);
                        b.this.liD.aW(b.this.fqs.qh(i));
                    }
                }
                if (b.this.cCY != null) {
                    b.this.cCY.onPageSelected(b.this.fqs.qh(i));
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ddk() {
        if (this.liw == null) {
            return false;
        }
        int[] iArr = new int[2];
        this.liw.getLocationOnScreen(iArr);
        int measuredHeight = iArr[1] + (this.liw.getMeasuredHeight() / 2);
        return measuredHeight > 0 && measuredHeight < com.baidu.adp.lib.util.l.getEquipmentHeight(this.mContext);
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.cCY = onPageChangeListener;
    }

    public b(Context context, ListViewPager listViewPager, IndicatorView indicatorView, TextView textView) {
        a(context, listViewPager, indicatorView, textView);
    }

    private void a(Context context, ListViewPager listViewPager, IndicatorView indicatorView, TextView textView) {
        this.liw = listViewPager;
        this.fqo = indicatorView;
        this.fqn = textView;
        this.mContext = context;
        this.fqr = new BdBaseViewPagerAdapter(context);
        if (this.liw != null) {
            this.liw.setAdapter(this.fqr);
            this.liw.setOnPageChangeListener(this.fqy);
        }
    }

    public void a(l lVar) {
        if (lVar != null) {
            this.fqo.setVisibility(8);
        } else {
            this.fqo.setVisibility(0);
        }
        this.liD = lVar;
    }

    public void setMaxScrollCountLimit(int i) {
        this.fqv = i;
        if (this.fqs != null) {
            this.fqs.qi(i);
        }
    }

    public void a(Context context, com.baidu.tbadk.core.view.viewpager.b<?, ?> bVar) {
        if (this.fqr != null) {
            this.fqr.a(context, bVar);
        }
    }

    public void setDatas(List<n> list) {
        boolean z = true;
        if (y.getCount(list) != 0) {
            this.fqw = list;
            this.fqs = new c(this.fqw, this.fqt, this.fqv);
            this.fqs.qj(2);
            this.fqs.qk(1);
            this.fqr.setDatas(this.fqs.bvE());
            this.fqr.notifyDataSetChanged();
            this.liw.setCurrentItem(this.fqs.bvD(), false);
            if (this.fqs.bvC() > 0) {
                if (this.fqs.bvC() > this.fqv) {
                    if (this.fqn != null) {
                        this.fqn.setVisibility(0);
                        this.fqn.setOnClickListener(null);
                        if (this.fqo != null) {
                            this.fqo.setVisibility(8);
                        }
                    }
                    if (this.fqo != null && this.fqn == null && this.fqt) {
                        z = false;
                    }
                    if (!z) {
                        this.fqo.setVisibility(8);
                        if (this.fqo.getCount() != this.fqv) {
                            this.fqo.setCount(this.fqv);
                        }
                    }
                    bvy();
                }
                if (this.fqs.bvC() >= 2 && this.fqs.bvC() <= this.fqv) {
                    if (this.fqn != null) {
                        this.fqn.setVisibility(8);
                    }
                    if (this.fqo != null) {
                        this.fqo.setVisibility(0);
                        if (this.fqo.getCount() != this.fqs.bvC()) {
                            this.fqo.setCount(this.fqs.bvC());
                            if (this.liD != null) {
                                this.liD.Eg(this.fqs.bvC());
                                this.fqo.setVisibility(8);
                            }
                        } else if (this.liD != null) {
                            this.liD.Eg(this.fqs.bvC());
                            this.fqo.setVisibility(8);
                        }
                    }
                    bvy();
                }
                if (this.fqs.bvC() < 2) {
                    if (this.fqn != null) {
                        this.fqn.setVisibility(8);
                    }
                    if (this.fqo != null) {
                        this.fqo.setVisibility(8);
                    }
                    bvz();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bvx() {
        int count;
        if (this.liw != null && this.fqr != null) {
            i H = j.H(this.mContext);
            if ((H == null || !H.isScroll()) && (count = this.fqr.getCount()) >= 2) {
                int currentItem = this.liw.getCurrentItem();
                int i = count - 2;
                if (currentItem < 1) {
                    this.liw.setCurrentItem(i, false);
                } else if (currentItem > i) {
                    this.liw.setCurrentItem(1, false);
                } else {
                    this.liw.setCurrentItem(currentItem + 1);
                }
            }
        }
    }

    public void setAutoScrollIntervalTime(long j) {
        if (j < 0) {
            j = 0;
        }
        this.fqx = j;
    }

    public void bvy() {
        if (this.fqu) {
            this.mHandler.removeMessages(1);
            this.mHandler.sendEmptyMessageDelayed(1, this.fqx);
            return;
        }
        this.mHandler.removeMessages(1);
    }

    public void bvz() {
        this.mHandler.removeMessages(1);
    }
}
