package com.baidu.tieba.write.write;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.baidu.cloudsdk.social.core.util.SocialAPIErrorCodes;
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
    private int aBB;
    private WriteMultiImgsActivity fPg;
    private ImageFileInfo[] fPh;
    private a fPi;
    private b[] fPj;
    private com.baidu.tbadk.coreExtra.view.c[] fPk;
    private int fPl;
    private int fPm;
    private int mCount;
    private ViewPager mViewPager;

    /* loaded from: classes.dex */
    public interface a {
        void a(com.baidu.tbadk.coreExtra.view.c cVar, int i);

        void bon();

        void boo();

        void bop();
    }

    public q(WriteMultiImgsActivity writeMultiImgsActivity, ViewPager viewPager, LinkedList<ImageFileInfo> linkedList, int i, a aVar) {
        int i2 = 0;
        this.fPg = null;
        this.fPh = null;
        this.mViewPager = null;
        this.fPi = null;
        this.mCount = 0;
        this.aBB = 0;
        this.fPj = null;
        this.fPk = null;
        this.fPl = SocialAPIErrorCodes.ERROR_INVALID_AUTHORIZED_CODE;
        this.fPm = SocialAPIErrorCodes.ERROR_INVALID_AUTHORIZED_CODE;
        this.fPg = writeMultiImgsActivity;
        this.fPl = (int) writeMultiImgsActivity.getResources().getDimension(w.f.ds720);
        this.fPm = (int) writeMultiImgsActivity.getResources().getDimension(w.f.ds1280);
        if (linkedList != null) {
            this.mCount = linkedList.size();
        }
        this.fPh = new ImageFileInfo[this.mCount];
        this.fPj = new b[this.mCount];
        this.fPk = new com.baidu.tbadk.coreExtra.view.c[this.mCount];
        while (true) {
            int i3 = i2;
            if (i3 < this.mCount) {
                a(linkedList.get(i3), i3);
                this.fPh[i3] = linkedList.get(i3).cloneWithoutFilterAction(true);
                this.fPh[i3].addPageAction(com.baidu.tbadk.img.effect.d.M(this.fPl, this.fPm));
                linkedList.set(i3, this.fPh[i3]);
                i2 = i3 + 1;
            } else {
                this.aBB = i;
                this.mViewPager = viewPager;
                this.fPi = aVar;
                this.mViewPager.setOffscreenPageLimit(1);
                this.mViewPager.setOnPageChangeListener(this);
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void tj(int i) {
        if (this.fPj[this.aBB].boq()) {
            this.fPh[this.aBB].addPageAction(com.baidu.tbadk.img.effect.e.eR(i));
            this.fPg.boZ();
            if (this.fPk[this.aBB] != null) {
                String selectedFilter = this.fPk[this.aBB].getSelectedFilter();
                if (selectedFilter != null && !selectedFilter.equals(WriteImageActivityConfig.FILTER_NAME_NORMAL)) {
                    ImageFileInfo cloneWithoutFilterAction = this.fPh[this.aBB].cloneWithoutFilterAction(false);
                    cloneWithoutFilterAction.addPageAction(com.baidu.tbadk.img.effect.a.fJ(selectedFilter));
                    this.fPj[this.aBB].k(cloneWithoutFilterAction);
                    return;
                }
                this.fPj[this.aBB].k(this.fPh[this.aBB]);
                return;
            }
            this.fPj[this.aBB].k(this.fPh[this.aBB]);
        }
    }

    @Override // com.baidu.tbadk.coreExtra.view.c.a
    public void ez(String str) {
        if (str != null && !str.equals(WriteImageActivityConfig.FILTER_NAME_NORMAL)) {
            this.fPg.boZ();
            ImageFileInfo cloneWithoutFilterAction = this.fPh[this.aBB].cloneWithoutFilterAction(false);
            cloneWithoutFilterAction.addPageAction(com.baidu.tbadk.img.effect.a.fJ(str));
            this.fPj[this.aBB].k(cloneWithoutFilterAction);
            return;
        }
        this.fPg.bpa();
        this.fPj[this.aBB].k(this.fPh[this.aBB]);
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (this.fPj[i] == null) {
            this.fPj[i] = new b(i);
        }
        this.mViewPager.addView(this.fPj[i].getView());
        return this.fPj[i].getView();
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        this.mViewPager.removeView(this.fPj[i].getView());
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        this.aBB = i;
        bol();
        if (this.fPi != null) {
            this.fPi.a(this.fPk[i], i);
        }
    }

    private void bol() {
        if (this.aBB >= 0) {
            if (this.fPj != null) {
                for (int i = 0; i < this.fPj.length; i++) {
                    if (this.fPj[i] != null) {
                        this.fPj[i].QO();
                    }
                }
                if (this.fPj[this.aBB] == null) {
                    this.fPj[this.aBB] = new b(this.aBB);
                }
            }
            String selectedFilter = this.fPk[this.aBB].getSelectedFilter();
            if (selectedFilter != null && !selectedFilter.equals(WriteImageActivityConfig.FILTER_NAME_NORMAL)) {
                ImageFileInfo cloneWithoutFilterAction = this.fPh[this.aBB].cloneWithoutFilterAction(false);
                cloneWithoutFilterAction.addPageAction(com.baidu.tbadk.img.effect.a.fJ(selectedFilter));
                if (this.fPj != null) {
                    this.fPj[this.aBB].k(cloneWithoutFilterAction);
                }
            } else if (this.fPj != null) {
                this.fPj[this.aBB].k(this.fPh[this.aBB]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getCurrentIndex() {
        return this.aBB;
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
        this.fPk[i] = new com.baidu.tbadk.coreExtra.view.c(this.fPg, this, str);
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
    public void bom() {
        String selectedFilter;
        for (int i = 0; i < this.fPh.length; i++) {
            this.fPh[i].applayRotatePageActionToPersistAction();
            if (this.fPk[i] != null && (selectedFilter = this.fPk[i].getSelectedFilter()) != null && !selectedFilter.equals(WriteImageActivityConfig.FILTER_NAME_NORMAL)) {
                this.fPh[i].addPersistAction(com.baidu.tbadk.img.effect.a.fJ(selectedFilter));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b {
        private TbImageView aOv;
        private ProgressBar eMP;
        private FrameLayout fPn;
        private com.baidu.tbadk.img.b fPo;
        private int index;

        public b(int i) {
            this.eMP = null;
            this.index = -1;
            this.index = i;
            this.fPn = (FrameLayout) LayoutInflater.from(q.this.fPg.getPageContext().getContext()).inflate(w.j.progress_tb_imageview, (ViewGroup) null);
            this.aOv = (TbImageView) this.fPn.findViewById(w.h.progress_tb_imageview);
            this.aOv.setClickable(true);
            this.aOv.setDefaultResource(0);
            this.aOv.setDefaultErrorResource(0);
            this.aOv.setDefaultBgResource(0);
            this.aOv.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            this.fPo = new com.baidu.tbadk.img.b();
            this.aOv.setOnClickListener(new r(this));
            this.eMP = (ProgressBar) this.fPn.findViewById(w.h.progress_tb_imageview_progress);
            this.eMP.setVisibility(8);
        }

        public View getView() {
            return this.fPn;
        }

        public void k(ImageFileInfo imageFileInfo) {
            QO();
            this.aOv.setDefaultResource(0);
            this.aOv.setDefaultBgResource(0);
            com.baidu.adp.widget.a.a a = this.fPo.a(imageFileInfo, false);
            if (a != null) {
                a.e(this.aOv);
                return;
            }
            lM(false);
            this.fPo.a(imageFileInfo, new s(this), false);
        }

        public void QO() {
            if (this.fPo != null) {
                this.fPo.Er();
            }
            if (this.aOv != null) {
                this.aOv.setImageDrawable(null);
            }
        }

        public boolean boq() {
            return this.eMP.getVisibility() != 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void lM(boolean z) {
            if (z) {
                if (this.eMP.getVisibility() != 8) {
                    if (q.this.fPi != null) {
                        q.this.fPi.bop();
                    }
                    this.eMP.setVisibility(8);
                    q.this.fPk[this.index].setCanbeClick(true);
                }
            } else if (this.eMP.getVisibility() != 0) {
                if (q.this.fPi != null) {
                    q.this.fPi.boo();
                }
                this.eMP.setVisibility(0);
                q.this.fPk[this.index].setCanbeClick(false);
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
