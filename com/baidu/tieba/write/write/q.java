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
import com.baidu.tieba.i;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class q extends PagerAdapter implements ViewPager.OnPageChangeListener, d.a {
    private int aru;
    private WriteMultiImgsActivity dqA;
    private ImageFileInfo[] dqB;
    private a dqC;
    private b[] dqD;
    private com.baidu.tbadk.coreExtra.view.d[] dqE;
    private int dqF;
    private int dqG;
    private ViewPager mViewPager;
    private int wB;

    /* loaded from: classes.dex */
    public interface a {
        void a(com.baidu.tbadk.coreExtra.view.d dVar, int i);

        void aDO();

        void aDP();

        void aDQ();
    }

    public q(WriteMultiImgsActivity writeMultiImgsActivity, ViewPager viewPager, LinkedList<ImageFileInfo> linkedList, int i, a aVar) {
        int i2 = 0;
        this.dqA = null;
        this.dqB = null;
        this.mViewPager = null;
        this.dqC = null;
        this.wB = 0;
        this.aru = 0;
        this.dqD = null;
        this.dqE = null;
        this.dqF = SocialAPIErrorCodes.ERROR_INVALID_AUTHORIZED_CODE;
        this.dqG = SocialAPIErrorCodes.ERROR_INVALID_AUTHORIZED_CODE;
        this.dqA = writeMultiImgsActivity;
        this.dqF = (int) writeMultiImgsActivity.getResources().getDimension(i.d.motu_image_size_width);
        this.dqG = (int) writeMultiImgsActivity.getResources().getDimension(i.d.motu_image_size_height);
        if (linkedList != null) {
            this.wB = linkedList.size();
        }
        this.dqB = new ImageFileInfo[this.wB];
        this.dqD = new b[this.wB];
        this.dqE = new com.baidu.tbadk.coreExtra.view.d[this.wB];
        while (true) {
            int i3 = i2;
            if (i3 < this.wB) {
                a(linkedList.get(i3), i3);
                this.dqB[i3] = linkedList.get(i3).cloneWithoutFilterAction(true);
                this.dqB[i3].addPageAction(com.baidu.tbadk.img.effect.d.J(this.dqF, this.dqG));
                linkedList.set(i3, this.dqB[i3]);
                i2 = i3 + 1;
            } else {
                this.aru = i;
                this.mViewPager = viewPager;
                this.dqC = aVar;
                this.mViewPager.setOffscreenPageLimit(1);
                this.mViewPager.setOnPageChangeListener(this);
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void mx(int i) {
        if (this.dqD[this.aru].aDR()) {
            this.dqB[this.aru].addPageAction(com.baidu.tbadk.img.effect.e.em(i));
            this.dqA.aEA();
            if (this.dqE[this.aru] != null) {
                String selectedFilter = this.dqE[this.aru].getSelectedFilter();
                if (selectedFilter != null && !selectedFilter.equals(WriteImageActivityConfig.FILTER_NAME_NORMAL)) {
                    ImageFileInfo cloneWithoutFilterAction = this.dqB[this.aru].cloneWithoutFilterAction(false);
                    cloneWithoutFilterAction.addPageAction(com.baidu.tbadk.img.effect.a.fs(selectedFilter));
                    this.dqD[this.aru].k(cloneWithoutFilterAction);
                    return;
                }
                this.dqD[this.aru].k(this.dqB[this.aru]);
                return;
            }
            this.dqD[this.aru].k(this.dqB[this.aru]);
        }
    }

    @Override // com.baidu.tbadk.coreExtra.view.d.a
    public void er(String str) {
        if (str != null && !str.equals(WriteImageActivityConfig.FILTER_NAME_NORMAL)) {
            this.dqA.aEA();
            ImageFileInfo cloneWithoutFilterAction = this.dqB[this.aru].cloneWithoutFilterAction(false);
            cloneWithoutFilterAction.addPageAction(com.baidu.tbadk.img.effect.a.fs(str));
            this.dqD[this.aru].k(cloneWithoutFilterAction);
            return;
        }
        this.dqA.aEB();
        this.dqD[this.aru].k(this.dqB[this.aru]);
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (this.dqD[i] == null) {
            this.dqD[i] = new b(i);
        }
        this.mViewPager.addView(this.dqD[i].getView());
        return this.dqD[i].getView();
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        this.mViewPager.removeView(this.dqD[i].getView());
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        this.aru = i;
        aDM();
        if (this.dqC != null) {
            this.dqC.a(this.dqE[i], i);
        }
    }

    private void aDM() {
        if (this.aru >= 0) {
            if (this.dqD != null) {
                for (int i = 0; i < this.dqD.length; i++) {
                    if (this.dqD[i] != null) {
                        this.dqD[i].ayW();
                    }
                }
                if (this.dqD[this.aru] == null) {
                    this.dqD[this.aru] = new b(this.aru);
                }
            }
            String selectedFilter = this.dqE[this.aru].getSelectedFilter();
            if (selectedFilter != null && !selectedFilter.equals(WriteImageActivityConfig.FILTER_NAME_NORMAL)) {
                ImageFileInfo cloneWithoutFilterAction = this.dqB[this.aru].cloneWithoutFilterAction(false);
                cloneWithoutFilterAction.addPageAction(com.baidu.tbadk.img.effect.a.fs(selectedFilter));
                if (this.dqD != null) {
                    this.dqD[this.aru].k(cloneWithoutFilterAction);
                }
            } else if (this.dqD != null) {
                this.dqD[this.aru].k(this.dqB[this.aru]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getCurrentIndex() {
        return this.aru;
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
        this.dqE[i] = new com.baidu.tbadk.coreExtra.view.d(this.dqA, this, str);
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return this.wB;
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aDN() {
        String selectedFilter;
        for (int i = 0; i < this.dqB.length; i++) {
            this.dqB[i].applayRotatePageActionToPersistAction();
            if (this.dqE[i] != null && (selectedFilter = this.dqE[i].getSelectedFilter()) != null && !selectedFilter.equals(WriteImageActivityConfig.FILTER_NAME_NORMAL)) {
                this.dqB[i].addPersistAction(com.baidu.tbadk.img.effect.a.fs(selectedFilter));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b {
        private TbImageView aBP;
        private ProgressBar cyf;
        private FrameLayout dqH;
        private com.baidu.tbadk.img.b dqI;
        private int index;

        public b(int i) {
            this.cyf = null;
            this.index = -1;
            this.index = i;
            this.dqH = (FrameLayout) LayoutInflater.from(q.this.dqA.getPageContext().getContext()).inflate(i.g.progress_tb_imageview, (ViewGroup) null);
            this.aBP = (TbImageView) this.dqH.findViewById(i.f.progress_tb_imageview);
            this.aBP.setClickable(true);
            this.aBP.setDefaultResource(0);
            this.aBP.setDefaultBgResource(0);
            this.aBP.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            this.dqI = new com.baidu.tbadk.img.b();
            this.aBP.setOnClickListener(new r(this));
            this.cyf = (ProgressBar) this.dqH.findViewById(i.f.progress_tb_imageview_progress);
            this.cyf.setVisibility(8);
        }

        public View getView() {
            return this.dqH;
        }

        public void k(ImageFileInfo imageFileInfo) {
            ayW();
            this.aBP.setDefaultResource(0);
            this.aBP.setDefaultBgResource(0);
            com.baidu.adp.widget.a.a a = this.dqI.a(imageFileInfo, false);
            if (a != null) {
                a.a(this.aBP);
                return;
            }
            hd(false);
            this.dqI.a(imageFileInfo, new s(this), false);
        }

        public void ayW() {
            if (this.dqI != null) {
                this.dqI.Cc();
            }
            if (this.aBP != null) {
                this.aBP.setImageDrawable(null);
            }
        }

        public boolean aDR() {
            return this.cyf.getVisibility() != 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void hd(boolean z) {
            if (z) {
                if (this.cyf.getVisibility() != 8) {
                    if (q.this.dqC != null) {
                        q.this.dqC.aDQ();
                    }
                    this.cyf.setVisibility(8);
                    q.this.dqE[this.index].setCanbeClick(true);
                }
            } else if (this.cyf.getVisibility() != 0) {
                if (q.this.dqC != null) {
                    q.this.dqC.aDP();
                }
                this.cyf.setVisibility(0);
                q.this.dqE[this.index].setCanbeClick(false);
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
