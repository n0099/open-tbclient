package com.baidu.tieba.write.write;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.baidu.tbadk.core.atomData.WriteImageActivityConfig;
import com.baidu.tbadk.coreExtra.view.c;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.effect.ImageOperation;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.w;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class q extends PagerAdapter implements ViewPager.OnPageChangeListener, c.a {
    private int aBT;
    private WriteMultiImgsActivity fTm;
    private ImageFileInfo[] fTn;
    private a fTo;
    private b[] fTp;
    private com.baidu.tbadk.coreExtra.view.c[] fTq;
    private int fTr;
    private int fTs;
    private int mCount;
    private ViewPager mViewPager;

    /* loaded from: classes.dex */
    public interface a {
        void a(com.baidu.tbadk.coreExtra.view.c cVar, int i);

        void bpX();

        void bpY();

        void bpZ();
    }

    public q(WriteMultiImgsActivity writeMultiImgsActivity, ViewPager viewPager, LinkedList<ImageFileInfo> linkedList, int i, a aVar) {
        int i2 = 0;
        this.fTm = null;
        this.fTn = null;
        this.mViewPager = null;
        this.fTo = null;
        this.mCount = 0;
        this.aBT = 0;
        this.fTp = null;
        this.fTq = null;
        this.fTr = 120;
        this.fTs = 120;
        this.fTm = writeMultiImgsActivity;
        this.fTr = (int) writeMultiImgsActivity.getResources().getDimension(w.f.ds720);
        this.fTs = (int) writeMultiImgsActivity.getResources().getDimension(w.f.ds1280);
        if (linkedList != null) {
            this.mCount = linkedList.size();
        }
        this.fTn = new ImageFileInfo[this.mCount];
        this.fTp = new b[this.mCount];
        this.fTq = new com.baidu.tbadk.coreExtra.view.c[this.mCount];
        while (true) {
            int i3 = i2;
            if (i3 < this.mCount) {
                a(linkedList.get(i3), i3);
                this.fTn[i3] = linkedList.get(i3).cloneWithoutFilterAction(true);
                this.fTn[i3].addPageAction(com.baidu.tbadk.img.effect.d.M(this.fTr, this.fTs));
                linkedList.set(i3, this.fTn[i3]);
                i2 = i3 + 1;
            } else {
                this.aBT = i;
                this.mViewPager = viewPager;
                this.fTo = aVar;
                this.mViewPager.setOffscreenPageLimit(1);
                this.mViewPager.setOnPageChangeListener(this);
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void tn(int i) {
        if (this.fTp[this.aBT].bqa()) {
            this.fTn[this.aBT].addPageAction(com.baidu.tbadk.img.effect.e.eU(i));
            this.fTm.bqI();
            if (this.fTq[this.aBT] != null) {
                String selectedFilter = this.fTq[this.aBT].getSelectedFilter();
                if (selectedFilter != null && !selectedFilter.equals(WriteImageActivityConfig.FILTER_NAME_NORMAL)) {
                    ImageFileInfo cloneWithoutFilterAction = this.fTn[this.aBT].cloneWithoutFilterAction(false);
                    cloneWithoutFilterAction.addPageAction(com.baidu.tbadk.img.effect.a.fP(selectedFilter));
                    this.fTp[this.aBT].k(cloneWithoutFilterAction);
                    return;
                }
                this.fTp[this.aBT].k(this.fTn[this.aBT]);
                return;
            }
            this.fTp[this.aBT].k(this.fTn[this.aBT]);
        }
    }

    @Override // com.baidu.tbadk.coreExtra.view.c.a
    public void eF(String str) {
        if (str != null && !str.equals(WriteImageActivityConfig.FILTER_NAME_NORMAL)) {
            this.fTm.bqI();
            ImageFileInfo cloneWithoutFilterAction = this.fTn[this.aBT].cloneWithoutFilterAction(false);
            cloneWithoutFilterAction.addPageAction(com.baidu.tbadk.img.effect.a.fP(str));
            this.fTp[this.aBT].k(cloneWithoutFilterAction);
            return;
        }
        this.fTm.bqJ();
        this.fTp[this.aBT].k(this.fTn[this.aBT]);
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (this.fTp[i] == null) {
            this.fTp[i] = new b(i);
        }
        this.mViewPager.addView(this.fTp[i].getView());
        return this.fTp[i].getView();
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        this.mViewPager.removeView(this.fTp[i].getView());
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        this.aBT = i;
        bpV();
        if (this.fTo != null) {
            this.fTo.a(this.fTq[i], i);
        }
    }

    private void bpV() {
        if (this.aBT >= 0) {
            if (this.fTp != null) {
                for (int i = 0; i < this.fTp.length; i++) {
                    if (this.fTp[i] != null) {
                        this.fTp[i].So();
                    }
                }
                if (this.fTp[this.aBT] == null) {
                    this.fTp[this.aBT] = new b(this.aBT);
                }
            }
            String selectedFilter = this.fTq[this.aBT].getSelectedFilter();
            if (selectedFilter != null && !selectedFilter.equals(WriteImageActivityConfig.FILTER_NAME_NORMAL)) {
                ImageFileInfo cloneWithoutFilterAction = this.fTn[this.aBT].cloneWithoutFilterAction(false);
                cloneWithoutFilterAction.addPageAction(com.baidu.tbadk.img.effect.a.fP(selectedFilter));
                if (this.fTp != null) {
                    this.fTp[this.aBT].k(cloneWithoutFilterAction);
                }
            } else if (this.fTp != null) {
                this.fTp[this.aBT].k(this.fTn[this.aBT]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getCurrentIndex() {
        return this.aBT;
    }

    private void a(ImageFileInfo imageFileInfo, int i) {
        String str;
        if (imageFileInfo.getPersistActionsList() != null) {
            Iterator<ImageOperation> it = imageFileInfo.getPersistActionsList().iterator();
            while (it.hasNext()) {
                ImageOperation next = it.next();
                if ("filter".equals(next.actionName)) {
                    str = next.actionParam;
                    break;
                }
            }
        }
        str = null;
        this.fTq[i] = new com.baidu.tbadk.coreExtra.view.c(this.fTm, this, str);
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return this.mCount;
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bpW() {
        String selectedFilter;
        for (int i = 0; i < this.fTn.length; i++) {
            this.fTn[i].applayRotatePageActionToPersistAction();
            if (this.fTq[i] != null && (selectedFilter = this.fTq[i].getSelectedFilter()) != null && !selectedFilter.equals(WriteImageActivityConfig.FILTER_NAME_NORMAL)) {
                this.fTn[i].addPersistAction(com.baidu.tbadk.img.effect.a.fP(selectedFilter));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b {
        private TbImageView aON;
        private ProgressBar eNa;
        private FrameLayout fTt;
        private com.baidu.tbadk.img.b fTu;
        private int index;

        public b(int i) {
            this.eNa = null;
            this.index = -1;
            this.index = i;
            this.fTt = (FrameLayout) LayoutInflater.from(q.this.fTm.getPageContext().getContext()).inflate(w.j.progress_tb_imageview, (ViewGroup) null);
            this.aON = (TbImageView) this.fTt.findViewById(w.h.progress_tb_imageview);
            this.aON.setClickable(true);
            this.aON.setDefaultResource(0);
            this.aON.setDefaultErrorResource(0);
            this.aON.setDefaultBgResource(0);
            this.aON.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            this.fTu = new com.baidu.tbadk.img.b();
            this.aON.setOnClickListener(new r(this));
            this.eNa = (ProgressBar) this.fTt.findViewById(w.h.progress_tb_imageview_progress);
            this.eNa.setVisibility(8);
        }

        public View getView() {
            return this.fTt;
        }

        public void k(ImageFileInfo imageFileInfo) {
            So();
            this.aON.setDefaultResource(0);
            this.aON.setDefaultBgResource(0);
            com.baidu.adp.widget.a.a a = this.fTu.a(imageFileInfo, false);
            if (a != null) {
                a.e(this.aON);
                return;
            }
            lZ(false);
            this.fTu.a(imageFileInfo, new s(this), false);
        }

        public void So() {
            if (this.fTu != null) {
                this.fTu.EP();
            }
            if (this.aON != null) {
                this.aON.setImageDrawable(null);
            }
        }

        public boolean bqa() {
            return this.eNa.getVisibility() != 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void lZ(boolean z) {
            if (z) {
                if (this.eNa.getVisibility() != 8) {
                    if (q.this.fTo != null) {
                        q.this.fTo.bpZ();
                    }
                    this.eNa.setVisibility(8);
                    q.this.fTq[this.index].setCanbeClick(true);
                }
            } else if (this.eNa.getVisibility() != 0) {
                if (q.this.fTo != null) {
                    q.this.fTo.bpY();
                }
                this.eNa.setVisibility(0);
                q.this.fTq[this.index].setCanbeClick(false);
            }
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }
}
