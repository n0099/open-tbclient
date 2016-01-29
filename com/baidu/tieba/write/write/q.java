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
import com.baidu.tieba.t;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class q extends PagerAdapter implements ViewPager.OnPageChangeListener, c.a {
    private ViewPager ahW;
    private int avR;
    private WriteMultiImgsActivity erV;
    private ImageFileInfo[] erW;
    private a erX;
    private b[] erY;
    private com.baidu.tbadk.coreExtra.view.c[] erZ;
    private int esa;
    private int esb;
    private int wS;

    /* loaded from: classes.dex */
    public interface a {
        void a(com.baidu.tbadk.coreExtra.view.c cVar, int i);

        void aUB();

        void aUC();

        void aUD();
    }

    public q(WriteMultiImgsActivity writeMultiImgsActivity, ViewPager viewPager, LinkedList<ImageFileInfo> linkedList, int i, a aVar) {
        int i2 = 0;
        this.erV = null;
        this.erW = null;
        this.ahW = null;
        this.erX = null;
        this.wS = 0;
        this.avR = 0;
        this.erY = null;
        this.erZ = null;
        this.esa = SocialAPIErrorCodes.ERROR_INVALID_AUTHORIZED_CODE;
        this.esb = SocialAPIErrorCodes.ERROR_INVALID_AUTHORIZED_CODE;
        this.erV = writeMultiImgsActivity;
        this.esa = (int) writeMultiImgsActivity.getResources().getDimension(t.e.motu_image_size_width);
        this.esb = (int) writeMultiImgsActivity.getResources().getDimension(t.e.motu_image_size_height);
        if (linkedList != null) {
            this.wS = linkedList.size();
        }
        this.erW = new ImageFileInfo[this.wS];
        this.erY = new b[this.wS];
        this.erZ = new com.baidu.tbadk.coreExtra.view.c[this.wS];
        while (true) {
            int i3 = i2;
            if (i3 < this.wS) {
                a(linkedList.get(i3), i3);
                this.erW[i3] = linkedList.get(i3).cloneWithoutFilterAction(true);
                this.erW[i3].addPageAction(com.baidu.tbadk.img.effect.d.G(this.esa, this.esb));
                linkedList.set(i3, this.erW[i3]);
                i2 = i3 + 1;
            } else {
                this.avR = i;
                this.ahW = viewPager;
                this.erX = aVar;
                this.ahW.setOffscreenPageLimit(1);
                this.ahW.setOnPageChangeListener(this);
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void pW(int i) {
        if (this.erY[this.avR].aUE()) {
            this.erW[this.avR].addPageAction(com.baidu.tbadk.img.effect.e.eO(i));
            this.erV.aVm();
            if (this.erZ[this.avR] != null) {
                String selectedFilter = this.erZ[this.avR].getSelectedFilter();
                if (selectedFilter != null && !selectedFilter.equals(WriteImageActivityConfig.FILTER_NAME_NORMAL)) {
                    ImageFileInfo cloneWithoutFilterAction = this.erW[this.avR].cloneWithoutFilterAction(false);
                    cloneWithoutFilterAction.addPageAction(com.baidu.tbadk.img.effect.a.fI(selectedFilter));
                    this.erY[this.avR].i(cloneWithoutFilterAction);
                    return;
                }
                this.erY[this.avR].i(this.erW[this.avR]);
                return;
            }
            this.erY[this.avR].i(this.erW[this.avR]);
        }
    }

    @Override // com.baidu.tbadk.coreExtra.view.c.a
    public void eD(String str) {
        if (str != null && !str.equals(WriteImageActivityConfig.FILTER_NAME_NORMAL)) {
            this.erV.aVm();
            ImageFileInfo cloneWithoutFilterAction = this.erW[this.avR].cloneWithoutFilterAction(false);
            cloneWithoutFilterAction.addPageAction(com.baidu.tbadk.img.effect.a.fI(str));
            this.erY[this.avR].i(cloneWithoutFilterAction);
            return;
        }
        this.erV.aVn();
        this.erY[this.avR].i(this.erW[this.avR]);
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (this.erY[i] == null) {
            this.erY[i] = new b(i);
        }
        this.ahW.addView(this.erY[i].getView());
        return this.erY[i].getView();
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        this.ahW.removeView(this.erY[i].getView());
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        this.avR = i;
        aUz();
        if (this.erX != null) {
            this.erX.a(this.erZ[i], i);
        }
    }

    private void aUz() {
        if (this.avR >= 0) {
            if (this.erY != null) {
                for (int i = 0; i < this.erY.length; i++) {
                    if (this.erY[i] != null) {
                        this.erY[i].aNG();
                    }
                }
                if (this.erY[this.avR] == null) {
                    this.erY[this.avR] = new b(this.avR);
                }
            }
            String selectedFilter = this.erZ[this.avR].getSelectedFilter();
            if (selectedFilter != null && !selectedFilter.equals(WriteImageActivityConfig.FILTER_NAME_NORMAL)) {
                ImageFileInfo cloneWithoutFilterAction = this.erW[this.avR].cloneWithoutFilterAction(false);
                cloneWithoutFilterAction.addPageAction(com.baidu.tbadk.img.effect.a.fI(selectedFilter));
                if (this.erY != null) {
                    this.erY[this.avR].i(cloneWithoutFilterAction);
                }
            } else if (this.erY != null) {
                this.erY[this.avR].i(this.erW[this.avR]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getCurrentIndex() {
        return this.avR;
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
        this.erZ[i] = new com.baidu.tbadk.coreExtra.view.c(this.erV, this, str);
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return this.wS;
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aUA() {
        String selectedFilter;
        for (int i = 0; i < this.erW.length; i++) {
            this.erW[i].applayRotatePageActionToPersistAction();
            if (this.erZ[i] != null && (selectedFilter = this.erZ[i].getSelectedFilter()) != null && !selectedFilter.equals(WriteImageActivityConfig.FILTER_NAME_NORMAL)) {
                this.erW[i].addPersistAction(com.baidu.tbadk.img.effect.a.fI(selectedFilter));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b {
        private TbImageView aGU;
        private ProgressBar dnB;
        private FrameLayout esc;
        private com.baidu.tbadk.img.b esd;
        private int index;

        public b(int i) {
            this.dnB = null;
            this.index = -1;
            this.index = i;
            this.esc = (FrameLayout) LayoutInflater.from(q.this.erV.getPageContext().getContext()).inflate(t.h.progress_tb_imageview, (ViewGroup) null);
            this.aGU = (TbImageView) this.esc.findViewById(t.g.progress_tb_imageview);
            this.aGU.setClickable(true);
            this.aGU.setDefaultResource(0);
            this.aGU.setDefaultBgResource(0);
            this.aGU.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            this.esd = new com.baidu.tbadk.img.b();
            this.aGU.setOnClickListener(new r(this));
            this.dnB = (ProgressBar) this.esc.findViewById(t.g.progress_tb_imageview_progress);
            this.dnB.setVisibility(8);
        }

        public View getView() {
            return this.esc;
        }

        public void i(ImageFileInfo imageFileInfo) {
            aNG();
            this.aGU.setDefaultResource(0);
            this.aGU.setDefaultBgResource(0);
            com.baidu.adp.widget.a.a a = this.esd.a(imageFileInfo, false);
            if (a != null) {
                a.a(this.aGU);
                return;
            }
            iF(false);
            this.esd.a(imageFileInfo, new s(this), false);
        }

        public void aNG() {
            if (this.esd != null) {
                this.esd.Ej();
            }
            if (this.aGU != null) {
                this.aGU.setImageDrawable(null);
            }
        }

        public boolean aUE() {
            return this.dnB.getVisibility() != 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void iF(boolean z) {
            if (z) {
                if (this.dnB.getVisibility() != 8) {
                    if (q.this.erX != null) {
                        q.this.erX.aUD();
                    }
                    this.dnB.setVisibility(8);
                    q.this.erZ[this.index].setCanbeClick(true);
                }
            } else if (this.dnB.getVisibility() != 0) {
                if (q.this.erX != null) {
                    q.this.erX.aUC();
                }
                this.dnB.setVisibility(0);
                q.this.erZ[this.index].setCanbeClick(false);
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
