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
    private int aBS;
    private WriteMultiImgsActivity fRq;
    private ImageFileInfo[] fRr;
    private a fRs;
    private b[] fRt;
    private com.baidu.tbadk.coreExtra.view.c[] fRu;
    private int fRv;
    private int fRw;
    private int mCount;
    private ViewPager mViewPager;

    /* loaded from: classes.dex */
    public interface a {
        void a(com.baidu.tbadk.coreExtra.view.c cVar, int i);

        void bnZ();

        void boa();

        void bob();
    }

    public q(WriteMultiImgsActivity writeMultiImgsActivity, ViewPager viewPager, LinkedList<ImageFileInfo> linkedList, int i, a aVar) {
        int i2 = 0;
        this.fRq = null;
        this.fRr = null;
        this.mViewPager = null;
        this.fRs = null;
        this.mCount = 0;
        this.aBS = 0;
        this.fRt = null;
        this.fRu = null;
        this.fRv = 120;
        this.fRw = 120;
        this.fRq = writeMultiImgsActivity;
        this.fRv = (int) writeMultiImgsActivity.getResources().getDimension(w.f.ds720);
        this.fRw = (int) writeMultiImgsActivity.getResources().getDimension(w.f.ds1280);
        if (linkedList != null) {
            this.mCount = linkedList.size();
        }
        this.fRr = new ImageFileInfo[this.mCount];
        this.fRt = new b[this.mCount];
        this.fRu = new com.baidu.tbadk.coreExtra.view.c[this.mCount];
        while (true) {
            int i3 = i2;
            if (i3 < this.mCount) {
                a(linkedList.get(i3), i3);
                this.fRr[i3] = linkedList.get(i3).cloneWithoutFilterAction(true);
                this.fRr[i3].addPageAction(com.baidu.tbadk.img.effect.d.M(this.fRv, this.fRw));
                linkedList.set(i3, this.fRr[i3]);
                i2 = i3 + 1;
            } else {
                this.aBS = i;
                this.mViewPager = viewPager;
                this.fRs = aVar;
                this.mViewPager.setOffscreenPageLimit(1);
                this.mViewPager.setOnPageChangeListener(this);
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void tk(int i) {
        if (this.fRt[this.aBS].boc()) {
            this.fRr[this.aBS].addPageAction(com.baidu.tbadk.img.effect.e.eQ(i));
            this.fRq.boM();
            if (this.fRu[this.aBS] != null) {
                String selectedFilter = this.fRu[this.aBS].getSelectedFilter();
                if (selectedFilter != null && !selectedFilter.equals(WriteImageActivityConfig.FILTER_NAME_NORMAL)) {
                    ImageFileInfo cloneWithoutFilterAction = this.fRr[this.aBS].cloneWithoutFilterAction(false);
                    cloneWithoutFilterAction.addPageAction(com.baidu.tbadk.img.effect.a.fM(selectedFilter));
                    this.fRt[this.aBS].i(cloneWithoutFilterAction);
                    return;
                }
                this.fRt[this.aBS].i(this.fRr[this.aBS]);
                return;
            }
            this.fRt[this.aBS].i(this.fRr[this.aBS]);
        }
    }

    @Override // com.baidu.tbadk.coreExtra.view.c.a
    public void eE(String str) {
        if (str != null && !str.equals(WriteImageActivityConfig.FILTER_NAME_NORMAL)) {
            this.fRq.boM();
            ImageFileInfo cloneWithoutFilterAction = this.fRr[this.aBS].cloneWithoutFilterAction(false);
            cloneWithoutFilterAction.addPageAction(com.baidu.tbadk.img.effect.a.fM(str));
            this.fRt[this.aBS].i(cloneWithoutFilterAction);
            return;
        }
        this.fRq.boN();
        this.fRt[this.aBS].i(this.fRr[this.aBS]);
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (this.fRt[i] == null) {
            this.fRt[i] = new b(i);
        }
        this.mViewPager.addView(this.fRt[i].getView());
        return this.fRt[i].getView();
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        this.mViewPager.removeView(this.fRt[i].getView());
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        this.aBS = i;
        bnX();
        if (this.fRs != null) {
            this.fRs.a(this.fRu[i], i);
        }
    }

    private void bnX() {
        if (this.aBS >= 0) {
            if (this.fRt != null) {
                for (int i = 0; i < this.fRt.length; i++) {
                    if (this.fRt[i] != null) {
                        this.fRt[i].RJ();
                    }
                }
                if (this.fRt[this.aBS] == null) {
                    this.fRt[this.aBS] = new b(this.aBS);
                }
            }
            String selectedFilter = this.fRu[this.aBS].getSelectedFilter();
            if (selectedFilter != null && !selectedFilter.equals(WriteImageActivityConfig.FILTER_NAME_NORMAL)) {
                ImageFileInfo cloneWithoutFilterAction = this.fRr[this.aBS].cloneWithoutFilterAction(false);
                cloneWithoutFilterAction.addPageAction(com.baidu.tbadk.img.effect.a.fM(selectedFilter));
                if (this.fRt != null) {
                    this.fRt[this.aBS].i(cloneWithoutFilterAction);
                }
            } else if (this.fRt != null) {
                this.fRt[this.aBS].i(this.fRr[this.aBS]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getCurrentIndex() {
        return this.aBS;
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
        this.fRu[i] = new com.baidu.tbadk.coreExtra.view.c(this.fRq, this, str);
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
    public void bnY() {
        String selectedFilter;
        for (int i = 0; i < this.fRr.length; i++) {
            this.fRr[i].applayRotatePageActionToPersistAction();
            if (this.fRu[i] != null && (selectedFilter = this.fRu[i].getSelectedFilter()) != null && !selectedFilter.equals(WriteImageActivityConfig.FILTER_NAME_NORMAL)) {
                this.fRr[i].addPersistAction(com.baidu.tbadk.img.effect.a.fM(selectedFilter));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b {
        private TbImageView aPg;
        private ProgressBar eIZ;
        private FrameLayout fRx;
        private com.baidu.tbadk.img.b fRy;
        private int index;

        public b(int i) {
            this.eIZ = null;
            this.index = -1;
            this.index = i;
            this.fRx = (FrameLayout) LayoutInflater.from(q.this.fRq.getPageContext().getContext()).inflate(w.j.progress_tb_imageview, (ViewGroup) null);
            this.aPg = (TbImageView) this.fRx.findViewById(w.h.progress_tb_imageview);
            this.aPg.setClickable(true);
            this.aPg.setDefaultResource(0);
            this.aPg.setDefaultErrorResource(0);
            this.aPg.setDefaultBgResource(0);
            this.aPg.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            this.fRy = new com.baidu.tbadk.img.b();
            this.aPg.setOnClickListener(new r(this));
            this.eIZ = (ProgressBar) this.fRx.findViewById(w.h.progress_tb_imageview_progress);
            this.eIZ.setVisibility(8);
        }

        public View getView() {
            return this.fRx;
        }

        public void i(ImageFileInfo imageFileInfo) {
            RJ();
            this.aPg.setDefaultResource(0);
            this.aPg.setDefaultBgResource(0);
            com.baidu.adp.widget.a.a a = this.fRy.a(imageFileInfo, false);
            if (a != null) {
                a.e(this.aPg);
                return;
            }
            lI(false);
            this.fRy.a(imageFileInfo, new s(this), false);
        }

        public void RJ() {
            if (this.fRy != null) {
                this.fRy.DT();
            }
            if (this.aPg != null) {
                this.aPg.setImageDrawable(null);
            }
        }

        public boolean boc() {
            return this.eIZ.getVisibility() != 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void lI(boolean z) {
            if (z) {
                if (this.eIZ.getVisibility() != 8) {
                    if (q.this.fRs != null) {
                        q.this.fRs.bob();
                    }
                    this.eIZ.setVisibility(8);
                    q.this.fRu[this.index].setCanbeClick(true);
                }
            } else if (this.eIZ.getVisibility() != 0) {
                if (q.this.fRs != null) {
                    q.this.fRs.boa();
                }
                this.eIZ.setVisibility(0);
                q.this.fRu[this.index].setCanbeClick(false);
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
