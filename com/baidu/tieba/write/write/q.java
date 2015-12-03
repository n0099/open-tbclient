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
import com.baidu.tbadk.coreExtra.view.d;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.effect.ImageOperation;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.n;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class q extends PagerAdapter implements ViewPager.OnPageChangeListener, d.a {
    private int atv;
    private WriteMultiImgsActivity dPE;
    private ImageFileInfo[] dPF;
    private a dPG;
    private b[] dPH;
    private com.baidu.tbadk.coreExtra.view.d[] dPI;
    private int dPJ;
    private int dPK;
    private ViewPager mViewPager;
    private int wH;

    /* loaded from: classes.dex */
    public interface a {
        void a(com.baidu.tbadk.coreExtra.view.d dVar, int i);

        void aJl();

        void aJm();

        void aJn();
    }

    public q(WriteMultiImgsActivity writeMultiImgsActivity, ViewPager viewPager, LinkedList<ImageFileInfo> linkedList, int i, a aVar) {
        int i2 = 0;
        this.dPE = null;
        this.dPF = null;
        this.mViewPager = null;
        this.dPG = null;
        this.wH = 0;
        this.atv = 0;
        this.dPH = null;
        this.dPI = null;
        this.dPJ = SocialAPIErrorCodes.ERROR_INVALID_AUTHORIZED_CODE;
        this.dPK = SocialAPIErrorCodes.ERROR_INVALID_AUTHORIZED_CODE;
        this.dPE = writeMultiImgsActivity;
        this.dPJ = (int) writeMultiImgsActivity.getResources().getDimension(n.d.motu_image_size_width);
        this.dPK = (int) writeMultiImgsActivity.getResources().getDimension(n.d.motu_image_size_height);
        if (linkedList != null) {
            this.wH = linkedList.size();
        }
        this.dPF = new ImageFileInfo[this.wH];
        this.dPH = new b[this.wH];
        this.dPI = new com.baidu.tbadk.coreExtra.view.d[this.wH];
        while (true) {
            int i3 = i2;
            if (i3 < this.wH) {
                a(linkedList.get(i3), i3);
                this.dPF[i3] = linkedList.get(i3).cloneWithoutFilterAction(true);
                this.dPF[i3].addPageAction(com.baidu.tbadk.img.effect.d.K(this.dPJ, this.dPK));
                linkedList.set(i3, this.dPF[i3]);
                i2 = i3 + 1;
            } else {
                this.atv = i;
                this.mViewPager = viewPager;
                this.dPG = aVar;
                this.mViewPager.setOffscreenPageLimit(1);
                this.mViewPager.setOnPageChangeListener(this);
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void nJ(int i) {
        if (this.dPH[this.atv].aJo()) {
            this.dPF[this.atv].addPageAction(com.baidu.tbadk.img.effect.e.eA(i));
            this.dPE.aJX();
            if (this.dPI[this.atv] != null) {
                String selectedFilter = this.dPI[this.atv].getSelectedFilter();
                if (selectedFilter != null && !selectedFilter.equals(WriteImageActivityConfig.FILTER_NAME_NORMAL)) {
                    ImageFileInfo cloneWithoutFilterAction = this.dPF[this.atv].cloneWithoutFilterAction(false);
                    cloneWithoutFilterAction.addPageAction(com.baidu.tbadk.img.effect.a.fG(selectedFilter));
                    this.dPH[this.atv].i(cloneWithoutFilterAction);
                    return;
                }
                this.dPH[this.atv].i(this.dPF[this.atv]);
                return;
            }
            this.dPH[this.atv].i(this.dPF[this.atv]);
        }
    }

    @Override // com.baidu.tbadk.coreExtra.view.d.a
    public void eB(String str) {
        if (str != null && !str.equals(WriteImageActivityConfig.FILTER_NAME_NORMAL)) {
            this.dPE.aJX();
            ImageFileInfo cloneWithoutFilterAction = this.dPF[this.atv].cloneWithoutFilterAction(false);
            cloneWithoutFilterAction.addPageAction(com.baidu.tbadk.img.effect.a.fG(str));
            this.dPH[this.atv].i(cloneWithoutFilterAction);
            return;
        }
        this.dPE.aJY();
        this.dPH[this.atv].i(this.dPF[this.atv]);
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (this.dPH[i] == null) {
            this.dPH[i] = new b(i);
        }
        this.mViewPager.addView(this.dPH[i].getView());
        return this.dPH[i].getView();
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        this.mViewPager.removeView(this.dPH[i].getView());
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        this.atv = i;
        aJj();
        if (this.dPG != null) {
            this.dPG.a(this.dPI[i], i);
        }
    }

    private void aJj() {
        if (this.atv >= 0) {
            if (this.dPH != null) {
                for (int i = 0; i < this.dPH.length; i++) {
                    if (this.dPH[i] != null) {
                        this.dPH[i].aEo();
                    }
                }
                if (this.dPH[this.atv] == null) {
                    this.dPH[this.atv] = new b(this.atv);
                }
            }
            String selectedFilter = this.dPI[this.atv].getSelectedFilter();
            if (selectedFilter != null && !selectedFilter.equals(WriteImageActivityConfig.FILTER_NAME_NORMAL)) {
                ImageFileInfo cloneWithoutFilterAction = this.dPF[this.atv].cloneWithoutFilterAction(false);
                cloneWithoutFilterAction.addPageAction(com.baidu.tbadk.img.effect.a.fG(selectedFilter));
                if (this.dPH != null) {
                    this.dPH[this.atv].i(cloneWithoutFilterAction);
                }
            } else if (this.dPH != null) {
                this.dPH[this.atv].i(this.dPF[this.atv]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getCurrentIndex() {
        return this.atv;
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
        this.dPI[i] = new com.baidu.tbadk.coreExtra.view.d(this.dPE, this, str);
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return this.wH;
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aJk() {
        String selectedFilter;
        for (int i = 0; i < this.dPF.length; i++) {
            this.dPF[i].applayRotatePageActionToPersistAction();
            if (this.dPI[i] != null && (selectedFilter = this.dPI[i].getSelectedFilter()) != null && !selectedFilter.equals(WriteImageActivityConfig.FILTER_NAME_NORMAL)) {
                this.dPF[i].addPersistAction(com.baidu.tbadk.img.effect.a.fG(selectedFilter));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b {
        private TbImageView aEB;
        private ProgressBar cVN;
        private FrameLayout dPL;
        private com.baidu.tbadk.img.b dPM;
        private int index;

        public b(int i) {
            this.cVN = null;
            this.index = -1;
            this.index = i;
            this.dPL = (FrameLayout) LayoutInflater.from(q.this.dPE.getPageContext().getContext()).inflate(n.g.progress_tb_imageview, (ViewGroup) null);
            this.aEB = (TbImageView) this.dPL.findViewById(n.f.progress_tb_imageview);
            this.aEB.setClickable(true);
            this.aEB.setDefaultResource(0);
            this.aEB.setDefaultBgResource(0);
            this.aEB.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            this.dPM = new com.baidu.tbadk.img.b();
            this.aEB.setOnClickListener(new r(this));
            this.cVN = (ProgressBar) this.dPL.findViewById(n.f.progress_tb_imageview_progress);
            this.cVN.setVisibility(8);
        }

        public View getView() {
            return this.dPL;
        }

        public void i(ImageFileInfo imageFileInfo) {
            aEo();
            this.aEB.setDefaultResource(0);
            this.aEB.setDefaultBgResource(0);
            com.baidu.adp.widget.a.a a = this.dPM.a(imageFileInfo, false);
            if (a != null) {
                a.a(this.aEB);
                return;
            }
            hL(false);
            this.dPM.a(imageFileInfo, new s(this), false);
        }

        public void aEo() {
            if (this.dPM != null) {
                this.dPM.Dd();
            }
            if (this.aEB != null) {
                this.aEB.setImageDrawable(null);
            }
        }

        public boolean aJo() {
            return this.cVN.getVisibility() != 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void hL(boolean z) {
            if (z) {
                if (this.cVN.getVisibility() != 8) {
                    if (q.this.dPG != null) {
                        q.this.dPG.aJn();
                    }
                    this.cVN.setVisibility(8);
                    q.this.dPI[this.index].setCanbeClick(true);
                }
            } else if (this.cVN.getVisibility() != 0) {
                if (q.this.dPG != null) {
                    q.this.dPG.aJm();
                }
                this.cVN.setVisibility(0);
                q.this.dPI[this.index].setCanbeClick(false);
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
