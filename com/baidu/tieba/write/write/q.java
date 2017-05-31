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
    private int aBF;
    private WriteMultiImgsActivity fZm;
    private ImageFileInfo[] fZn;
    private a fZo;
    private b[] fZp;
    private com.baidu.tbadk.coreExtra.view.c[] fZq;
    private int fZr;
    private int fZs;
    private int mCount;
    private ViewPager mViewPager;

    /* loaded from: classes.dex */
    public interface a {
        void a(com.baidu.tbadk.coreExtra.view.c cVar, int i);

        void bpA();

        void bpy();

        void bpz();
    }

    public q(WriteMultiImgsActivity writeMultiImgsActivity, ViewPager viewPager, LinkedList<ImageFileInfo> linkedList, int i, a aVar) {
        int i2 = 0;
        this.fZm = null;
        this.fZn = null;
        this.mViewPager = null;
        this.fZo = null;
        this.mCount = 0;
        this.aBF = 0;
        this.fZp = null;
        this.fZq = null;
        this.fZr = 120;
        this.fZs = 120;
        this.fZm = writeMultiImgsActivity;
        this.fZr = (int) writeMultiImgsActivity.getResources().getDimension(w.f.ds720);
        this.fZs = (int) writeMultiImgsActivity.getResources().getDimension(w.f.ds1280);
        if (linkedList != null) {
            this.mCount = linkedList.size();
        }
        this.fZn = new ImageFileInfo[this.mCount];
        this.fZp = new b[this.mCount];
        this.fZq = new com.baidu.tbadk.coreExtra.view.c[this.mCount];
        while (true) {
            int i3 = i2;
            if (i3 < this.mCount) {
                a(linkedList.get(i3), i3);
                this.fZn[i3] = linkedList.get(i3).cloneWithoutFilterAction(true);
                this.fZn[i3].addPageAction(com.baidu.tbadk.img.effect.d.L(this.fZr, this.fZs));
                linkedList.set(i3, this.fZn[i3]);
                i2 = i3 + 1;
            } else {
                this.aBF = i;
                this.mViewPager = viewPager;
                this.fZo = aVar;
                this.mViewPager.setOffscreenPageLimit(1);
                this.mViewPager.setOnPageChangeListener(this);
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void tF(int i) {
        if (this.fZp[this.aBF].bpB()) {
            this.fZn[this.aBF].addPageAction(com.baidu.tbadk.img.effect.e.eR(i));
            this.fZm.bql();
            if (this.fZq[this.aBF] != null) {
                String selectedFilter = this.fZq[this.aBF].getSelectedFilter();
                if (selectedFilter != null && !selectedFilter.equals(WriteImageActivityConfig.FILTER_NAME_NORMAL)) {
                    ImageFileInfo cloneWithoutFilterAction = this.fZn[this.aBF].cloneWithoutFilterAction(false);
                    cloneWithoutFilterAction.addPageAction(com.baidu.tbadk.img.effect.a.fL(selectedFilter));
                    this.fZp[this.aBF].i(cloneWithoutFilterAction);
                    return;
                }
                this.fZp[this.aBF].i(this.fZn[this.aBF]);
                return;
            }
            this.fZp[this.aBF].i(this.fZn[this.aBF]);
        }
    }

    @Override // com.baidu.tbadk.coreExtra.view.c.a
    public void eC(String str) {
        if (str != null && !str.equals(WriteImageActivityConfig.FILTER_NAME_NORMAL)) {
            this.fZm.bql();
            ImageFileInfo cloneWithoutFilterAction = this.fZn[this.aBF].cloneWithoutFilterAction(false);
            cloneWithoutFilterAction.addPageAction(com.baidu.tbadk.img.effect.a.fL(str));
            this.fZp[this.aBF].i(cloneWithoutFilterAction);
            return;
        }
        this.fZm.bqm();
        this.fZp[this.aBF].i(this.fZn[this.aBF]);
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (this.fZp[i] == null) {
            this.fZp[i] = new b(i);
        }
        this.mViewPager.addView(this.fZp[i].getView());
        return this.fZp[i].getView();
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        this.mViewPager.removeView(this.fZp[i].getView());
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        this.aBF = i;
        bpw();
        if (this.fZo != null) {
            this.fZo.a(this.fZq[i], i);
        }
    }

    private void bpw() {
        if (this.aBF >= 0) {
            if (this.fZp != null) {
                for (int i = 0; i < this.fZp.length; i++) {
                    if (this.fZp[i] != null) {
                        this.fZp[i].RV();
                    }
                }
                if (this.fZp[this.aBF] == null) {
                    this.fZp[this.aBF] = new b(this.aBF);
                }
            }
            String selectedFilter = this.fZq[this.aBF].getSelectedFilter();
            if (selectedFilter != null && !selectedFilter.equals(WriteImageActivityConfig.FILTER_NAME_NORMAL)) {
                ImageFileInfo cloneWithoutFilterAction = this.fZn[this.aBF].cloneWithoutFilterAction(false);
                cloneWithoutFilterAction.addPageAction(com.baidu.tbadk.img.effect.a.fL(selectedFilter));
                if (this.fZp != null) {
                    this.fZp[this.aBF].i(cloneWithoutFilterAction);
                }
            } else if (this.fZp != null) {
                this.fZp[this.aBF].i(this.fZn[this.aBF]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getCurrentIndex() {
        return this.aBF;
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
        this.fZq[i] = new com.baidu.tbadk.coreExtra.view.c(this.fZm, this, str);
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
    public void bpx() {
        String selectedFilter;
        for (int i = 0; i < this.fZn.length; i++) {
            this.fZn[i].applayRotatePageActionToPersistAction();
            if (this.fZq[i] != null && (selectedFilter = this.fZq[i].getSelectedFilter()) != null && !selectedFilter.equals(WriteImageActivityConfig.FILTER_NAME_NORMAL)) {
                this.fZn[i].addPersistAction(com.baidu.tbadk.img.effect.a.fL(selectedFilter));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b {
        private TbImageView aPf;
        private ProgressBar eRK;
        private FrameLayout fZt;
        private com.baidu.tbadk.img.b fZu;
        private int index;

        public b(int i) {
            this.eRK = null;
            this.index = -1;
            this.index = i;
            this.fZt = (FrameLayout) LayoutInflater.from(q.this.fZm.getPageContext().getContext()).inflate(w.j.progress_tb_imageview, (ViewGroup) null);
            this.aPf = (TbImageView) this.fZt.findViewById(w.h.progress_tb_imageview);
            this.aPf.setClickable(true);
            this.aPf.setDefaultResource(0);
            this.aPf.setDefaultErrorResource(0);
            this.aPf.setDefaultBgResource(0);
            this.aPf.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            this.fZu = new com.baidu.tbadk.img.b();
            this.aPf.setOnClickListener(new r(this));
            this.eRK = (ProgressBar) this.fZt.findViewById(w.h.progress_tb_imageview_progress);
            this.eRK.setVisibility(8);
        }

        public View getView() {
            return this.fZt;
        }

        public void i(ImageFileInfo imageFileInfo) {
            RV();
            this.aPf.setDefaultResource(0);
            this.aPf.setDefaultBgResource(0);
            com.baidu.adp.widget.a.a a = this.fZu.a(imageFileInfo, false);
            if (a != null) {
                a.e(this.aPf);
                return;
            }
            mb(false);
            this.fZu.a(imageFileInfo, new s(this), false);
        }

        public void RV() {
            if (this.fZu != null) {
                this.fZu.DN();
            }
            if (this.aPf != null) {
                this.aPf.setImageDrawable(null);
            }
        }

        public boolean bpB() {
            return this.eRK.getVisibility() != 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mb(boolean z) {
            if (z) {
                if (this.eRK.getVisibility() != 8) {
                    if (q.this.fZo != null) {
                        q.this.fZo.bpA();
                    }
                    this.eRK.setVisibility(8);
                    q.this.fZq[this.index].setCanbeClick(true);
                }
            } else if (this.eRK.getVisibility() != 0) {
                if (q.this.fZo != null) {
                    q.this.fZo.bpz();
                }
                this.eRK.setVisibility(0);
                q.this.fZq[this.index].setCanbeClick(false);
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
