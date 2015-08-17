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
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.WriteImageActivityConfig;
import com.baidu.tbadk.coreExtra.view.d;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.effect.ImageOperation;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.i;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class q extends PagerAdapter implements ViewPager.OnPageChangeListener, d.a {
    private int apO;
    private BaseActivity arT;
    private com.baidu.tbadk.coreExtra.view.d[] cTA;
    private int cTB;
    private int cTC;
    private ImageFileInfo[] cTx;
    private a cTy;
    private b[] cTz;
    private ViewPager mViewPager;
    private int wC;

    /* loaded from: classes.dex */
    public interface a {
        void a(com.baidu.tbadk.coreExtra.view.d dVar, int i);

        void auM();

        void auN();

        void auO();
    }

    public q(BaseActivity baseActivity, ViewPager viewPager, LinkedList<ImageFileInfo> linkedList, int i, a aVar) {
        int i2 = 0;
        this.arT = null;
        this.cTx = null;
        this.mViewPager = null;
        this.cTy = null;
        this.wC = 0;
        this.apO = 0;
        this.cTz = null;
        this.cTA = null;
        this.cTB = SocialAPIErrorCodes.ERROR_INVALID_AUTHORIZED_CODE;
        this.cTC = SocialAPIErrorCodes.ERROR_INVALID_AUTHORIZED_CODE;
        this.arT = baseActivity;
        this.cTB = (int) baseActivity.getResources().getDimension(i.d.motu_image_size_width);
        this.cTC = (int) baseActivity.getResources().getDimension(i.d.motu_image_size_height);
        if (linkedList != null) {
            this.wC = linkedList.size();
        }
        this.cTx = new ImageFileInfo[this.wC];
        this.cTz = new b[this.wC];
        this.cTA = new com.baidu.tbadk.coreExtra.view.d[this.wC];
        while (true) {
            int i3 = i2;
            if (i3 < this.wC) {
                a(linkedList.get(i3), i3);
                this.cTx[i3] = linkedList.get(i3).cloneWithoutFilterAction(true);
                this.cTx[i3].addPageAction(com.baidu.tbadk.img.effect.d.J(this.cTB, this.cTC));
                linkedList.set(i3, this.cTx[i3]);
                i2 = i3 + 1;
            } else {
                this.apO = i;
                this.mViewPager = viewPager;
                this.cTy = aVar;
                this.mViewPager.setOffscreenPageLimit(1);
                this.mViewPager.setOnPageChangeListener(this);
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void kx(int i) {
        if (this.cTz[this.apO].auP()) {
            this.cTx[this.apO].addPageAction(com.baidu.tbadk.img.effect.e.ef(i));
            if (this.cTA[this.apO] != null) {
                String selectedFilter = this.cTA[this.apO].getSelectedFilter();
                if (selectedFilter != null && !selectedFilter.equals(WriteImageActivityConfig.FILTER_NAME_NORMAL)) {
                    ImageFileInfo cloneWithoutFilterAction = this.cTx[this.apO].cloneWithoutFilterAction(false);
                    cloneWithoutFilterAction.addPageAction(com.baidu.tbadk.img.effect.a.fd(selectedFilter));
                    this.cTz[this.apO].i(cloneWithoutFilterAction);
                    return;
                }
                this.cTz[this.apO].i(this.cTx[this.apO]);
                return;
            }
            this.cTz[this.apO].i(this.cTx[this.apO]);
        }
    }

    @Override // com.baidu.tbadk.coreExtra.view.d.a
    public void ei(String str) {
        if (str != null && !str.equals(WriteImageActivityConfig.FILTER_NAME_NORMAL)) {
            ImageFileInfo cloneWithoutFilterAction = this.cTx[this.apO].cloneWithoutFilterAction(false);
            cloneWithoutFilterAction.addPageAction(com.baidu.tbadk.img.effect.a.fd(str));
            this.cTz[this.apO].i(cloneWithoutFilterAction);
            return;
        }
        this.cTz[this.apO].i(this.cTx[this.apO]);
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (this.cTz[i] == null) {
            this.cTz[i] = new b(i);
        }
        this.mViewPager.addView(this.cTz[i].getView());
        return this.cTz[i].getView();
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        this.mViewPager.removeView(this.cTz[i].getView());
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        this.apO = i;
        auK();
        if (this.cTy != null) {
            this.cTy.a(this.cTA[i], i);
        }
    }

    private void auK() {
        if (this.apO >= 0) {
            if (this.cTz != null) {
                for (int i = 0; i < this.cTz.length; i++) {
                    if (this.cTz[i] != null) {
                        this.cTz[i].arf();
                    }
                }
                if (this.cTz[this.apO] == null) {
                    this.cTz[this.apO] = new b(this.apO);
                }
            }
            String selectedFilter = this.cTA[this.apO].getSelectedFilter();
            if (selectedFilter != null && !selectedFilter.equals(WriteImageActivityConfig.FILTER_NAME_NORMAL)) {
                ImageFileInfo cloneWithoutFilterAction = this.cTx[this.apO].cloneWithoutFilterAction(false);
                cloneWithoutFilterAction.addPageAction(com.baidu.tbadk.img.effect.a.fd(selectedFilter));
                if (this.cTz != null) {
                    this.cTz[this.apO].i(cloneWithoutFilterAction);
                }
            } else if (this.cTz != null) {
                this.cTz[this.apO].i(this.cTx[this.apO]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getCurrentIndex() {
        return this.apO;
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
        this.cTA[i] = new com.baidu.tbadk.coreExtra.view.d(this.arT, this, str);
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return this.wC;
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void auL() {
        String selectedFilter;
        for (int i = 0; i < this.cTx.length; i++) {
            this.cTx[i].applayRotatePageActionToPersistAction();
            if (this.cTA[i] != null && (selectedFilter = this.cTA[i].getSelectedFilter()) != null && !selectedFilter.equals(WriteImageActivityConfig.FILTER_NAME_NORMAL)) {
                this.cTx[i].addPersistAction(com.baidu.tbadk.img.effect.a.fd(selectedFilter));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b {
        private TbImageView bZj;
        private ProgressBar cEw;
        private FrameLayout cTD;
        private com.baidu.tbadk.img.b cTE;
        private int index;

        public b(int i) {
            this.cEw = null;
            this.index = -1;
            this.index = i;
            this.cTD = (FrameLayout) LayoutInflater.from(q.this.arT.getPageContext().getContext()).inflate(i.g.progress_tb_imageview, (ViewGroup) null);
            this.bZj = (TbImageView) this.cTD.findViewById(i.f.progress_tb_imageview);
            this.bZj.setClickable(true);
            this.bZj.setDefaultResource(0);
            this.bZj.setDefaultBgResource(0);
            this.bZj.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            this.cTE = new com.baidu.tbadk.img.b();
            this.bZj.setOnClickListener(new r(this));
            this.cEw = (ProgressBar) this.cTD.findViewById(i.f.progress_tb_imageview_progress);
            this.cEw.setVisibility(8);
        }

        public View getView() {
            return this.cTD;
        }

        public void i(ImageFileInfo imageFileInfo) {
            arf();
            this.bZj.setDefaultResource(0);
            this.bZj.setDefaultBgResource(0);
            com.baidu.adp.widget.a.a a = this.cTE.a(imageFileInfo, false);
            if (a != null) {
                a.a(this.bZj);
                return;
            }
            fY(false);
            this.cTE.a(imageFileInfo, new s(this), false);
        }

        public void arf() {
            if (this.cTE != null) {
                this.cTE.Cl();
            }
            if (this.bZj != null) {
                this.bZj.setImageDrawable(null);
            }
        }

        public boolean auP() {
            return this.cEw.getVisibility() != 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void fY(boolean z) {
            if (z) {
                if (this.cEw.getVisibility() != 8) {
                    if (q.this.cTy != null) {
                        q.this.cTy.auO();
                    }
                    this.cEw.setVisibility(8);
                    q.this.cTA[this.index].setCanbeClick(true);
                }
            } else if (this.cEw.getVisibility() != 0) {
                if (q.this.cTy != null) {
                    q.this.cTy.auN();
                }
                this.cEw.setVisibility(0);
                q.this.cTA[this.index].setCanbeClick(false);
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
