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
    private int apZ;
    private WriteMultiImgsActivity doL;
    private ImageFileInfo[] doM;
    private a doN;
    private b[] doO;
    private com.baidu.tbadk.coreExtra.view.d[] doP;
    private int doQ;
    private int doR;
    private ViewPager mViewPager;
    private int wB;

    /* loaded from: classes.dex */
    public interface a {
        void a(com.baidu.tbadk.coreExtra.view.d dVar, int i);

        void aCW();

        void aCX();

        void aCY();
    }

    public q(WriteMultiImgsActivity writeMultiImgsActivity, ViewPager viewPager, LinkedList<ImageFileInfo> linkedList, int i, a aVar) {
        int i2 = 0;
        this.doL = null;
        this.doM = null;
        this.mViewPager = null;
        this.doN = null;
        this.wB = 0;
        this.apZ = 0;
        this.doO = null;
        this.doP = null;
        this.doQ = SocialAPIErrorCodes.ERROR_INVALID_AUTHORIZED_CODE;
        this.doR = SocialAPIErrorCodes.ERROR_INVALID_AUTHORIZED_CODE;
        this.doL = writeMultiImgsActivity;
        this.doQ = (int) writeMultiImgsActivity.getResources().getDimension(i.d.motu_image_size_width);
        this.doR = (int) writeMultiImgsActivity.getResources().getDimension(i.d.motu_image_size_height);
        if (linkedList != null) {
            this.wB = linkedList.size();
        }
        this.doM = new ImageFileInfo[this.wB];
        this.doO = new b[this.wB];
        this.doP = new com.baidu.tbadk.coreExtra.view.d[this.wB];
        while (true) {
            int i3 = i2;
            if (i3 < this.wB) {
                a(linkedList.get(i3), i3);
                this.doM[i3] = linkedList.get(i3).cloneWithoutFilterAction(true);
                this.doM[i3].addPageAction(com.baidu.tbadk.img.effect.d.J(this.doQ, this.doR));
                linkedList.set(i3, this.doM[i3]);
                i2 = i3 + 1;
            } else {
                this.apZ = i;
                this.mViewPager = viewPager;
                this.doN = aVar;
                this.mViewPager.setOffscreenPageLimit(1);
                this.mViewPager.setOnPageChangeListener(this);
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void mj(int i) {
        if (this.doO[this.apZ].aCZ()) {
            this.doM[this.apZ].addPageAction(com.baidu.tbadk.img.effect.e.eo(i));
            this.doL.aDG();
            if (this.doP[this.apZ] != null) {
                String selectedFilter = this.doP[this.apZ].getSelectedFilter();
                if (selectedFilter != null && !selectedFilter.equals(WriteImageActivityConfig.FILTER_NAME_NORMAL)) {
                    ImageFileInfo cloneWithoutFilterAction = this.doM[this.apZ].cloneWithoutFilterAction(false);
                    cloneWithoutFilterAction.addPageAction(com.baidu.tbadk.img.effect.a.fq(selectedFilter));
                    this.doO[this.apZ].j(cloneWithoutFilterAction);
                    return;
                }
                this.doO[this.apZ].j(this.doM[this.apZ]);
                return;
            }
            this.doO[this.apZ].j(this.doM[this.apZ]);
        }
    }

    @Override // com.baidu.tbadk.coreExtra.view.d.a
    public void er(String str) {
        if (str != null && !str.equals(WriteImageActivityConfig.FILTER_NAME_NORMAL)) {
            this.doL.aDG();
            ImageFileInfo cloneWithoutFilterAction = this.doM[this.apZ].cloneWithoutFilterAction(false);
            cloneWithoutFilterAction.addPageAction(com.baidu.tbadk.img.effect.a.fq(str));
            this.doO[this.apZ].j(cloneWithoutFilterAction);
            return;
        }
        this.doL.aDH();
        this.doO[this.apZ].j(this.doM[this.apZ]);
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (this.doO[i] == null) {
            this.doO[i] = new b(i);
        }
        this.mViewPager.addView(this.doO[i].getView());
        return this.doO[i].getView();
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        this.mViewPager.removeView(this.doO[i].getView());
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        this.apZ = i;
        aCU();
        if (this.doN != null) {
            this.doN.a(this.doP[i], i);
        }
    }

    private void aCU() {
        if (this.apZ >= 0) {
            if (this.doO != null) {
                for (int i = 0; i < this.doO.length; i++) {
                    if (this.doO[i] != null) {
                        this.doO[i].axN();
                    }
                }
                if (this.doO[this.apZ] == null) {
                    this.doO[this.apZ] = new b(this.apZ);
                }
            }
            String selectedFilter = this.doP[this.apZ].getSelectedFilter();
            if (selectedFilter != null && !selectedFilter.equals(WriteImageActivityConfig.FILTER_NAME_NORMAL)) {
                ImageFileInfo cloneWithoutFilterAction = this.doM[this.apZ].cloneWithoutFilterAction(false);
                cloneWithoutFilterAction.addPageAction(com.baidu.tbadk.img.effect.a.fq(selectedFilter));
                if (this.doO != null) {
                    this.doO[this.apZ].j(cloneWithoutFilterAction);
                }
            } else if (this.doO != null) {
                this.doO[this.apZ].j(this.doM[this.apZ]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getCurrentIndex() {
        return this.apZ;
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
        this.doP[i] = new com.baidu.tbadk.coreExtra.view.d(this.doL, this, str);
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
    public void aCV() {
        String selectedFilter;
        for (int i = 0; i < this.doM.length; i++) {
            this.doM[i].applayRotatePageActionToPersistAction();
            if (this.doP[i] != null && (selectedFilter = this.doP[i].getSelectedFilter()) != null && !selectedFilter.equals(WriteImageActivityConfig.FILTER_NAME_NORMAL)) {
                this.doM[i].addPersistAction(com.baidu.tbadk.img.effect.a.fq(selectedFilter));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b {
        private TbImageView aCV;
        private ProgressBar cwJ;
        private FrameLayout doS;
        private com.baidu.tbadk.img.b doT;
        private int index;

        public b(int i) {
            this.cwJ = null;
            this.index = -1;
            this.index = i;
            this.doS = (FrameLayout) LayoutInflater.from(q.this.doL.getPageContext().getContext()).inflate(i.g.progress_tb_imageview, (ViewGroup) null);
            this.aCV = (TbImageView) this.doS.findViewById(i.f.progress_tb_imageview);
            this.aCV.setClickable(true);
            this.aCV.setDefaultResource(0);
            this.aCV.setDefaultBgResource(0);
            this.aCV.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            this.doT = new com.baidu.tbadk.img.b();
            this.aCV.setOnClickListener(new r(this));
            this.cwJ = (ProgressBar) this.doS.findViewById(i.f.progress_tb_imageview_progress);
            this.cwJ.setVisibility(8);
        }

        public View getView() {
            return this.doS;
        }

        public void j(ImageFileInfo imageFileInfo) {
            axN();
            this.aCV.setDefaultResource(0);
            this.aCV.setDefaultBgResource(0);
            com.baidu.adp.widget.a.a a = this.doT.a(imageFileInfo, false);
            if (a != null) {
                a.a(this.aCV);
                return;
            }
            ha(false);
            this.doT.a(imageFileInfo, new s(this), false);
        }

        public void axN() {
            if (this.doT != null) {
                this.doT.Cj();
            }
            if (this.aCV != null) {
                this.aCV.setImageDrawable(null);
            }
        }

        public boolean aCZ() {
            return this.cwJ.getVisibility() != 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void ha(boolean z) {
            if (z) {
                if (this.cwJ.getVisibility() != 8) {
                    if (q.this.doN != null) {
                        q.this.doN.aCY();
                    }
                    this.cwJ.setVisibility(8);
                    q.this.doP[this.index].setCanbeClick(true);
                }
            } else if (this.cwJ.getVisibility() != 0) {
                if (q.this.doN != null) {
                    q.this.doN.aCX();
                }
                this.cwJ.setVisibility(0);
                q.this.doP[this.index].setCanbeClick(false);
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
