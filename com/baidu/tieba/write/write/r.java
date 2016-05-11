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
public class r extends PagerAdapter implements ViewPager.OnPageChangeListener, c.a {
    private ViewPager asg;
    private int asz;
    private WriteMultiImgsActivity fcD;
    private ImageFileInfo[] fcE;
    private a fcF;
    private b[] fcG;
    private com.baidu.tbadk.coreExtra.view.c[] fcH;
    private int fcI;
    private int fcJ;
    private int ni;

    /* loaded from: classes.dex */
    public interface a {
        void a(com.baidu.tbadk.coreExtra.view.c cVar, int i);

        void bdq();

        void bdr();

        void bds();
    }

    public r(WriteMultiImgsActivity writeMultiImgsActivity, ViewPager viewPager, LinkedList<ImageFileInfo> linkedList, int i, a aVar) {
        int i2 = 0;
        this.fcD = null;
        this.fcE = null;
        this.asg = null;
        this.fcF = null;
        this.ni = 0;
        this.asz = 0;
        this.fcG = null;
        this.fcH = null;
        this.fcI = SocialAPIErrorCodes.ERROR_INVALID_AUTHORIZED_CODE;
        this.fcJ = SocialAPIErrorCodes.ERROR_INVALID_AUTHORIZED_CODE;
        this.fcD = writeMultiImgsActivity;
        this.fcI = (int) writeMultiImgsActivity.getResources().getDimension(t.e.motu_image_size_width);
        this.fcJ = (int) writeMultiImgsActivity.getResources().getDimension(t.e.motu_image_size_height);
        if (linkedList != null) {
            this.ni = linkedList.size();
        }
        this.fcE = new ImageFileInfo[this.ni];
        this.fcG = new b[this.ni];
        this.fcH = new com.baidu.tbadk.coreExtra.view.c[this.ni];
        while (true) {
            int i3 = i2;
            if (i3 < this.ni) {
                a(linkedList.get(i3), i3);
                this.fcE[i3] = linkedList.get(i3).cloneWithoutFilterAction(true);
                this.fcE[i3].addPageAction(com.baidu.tbadk.img.effect.d.D(this.fcI, this.fcJ));
                linkedList.set(i3, this.fcE[i3]);
                i2 = i3 + 1;
            } else {
                this.asz = i;
                this.asg = viewPager;
                this.fcF = aVar;
                this.asg.setOffscreenPageLimit(1);
                this.asg.setOnPageChangeListener(this);
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void rl(int i) {
        if (this.fcG[this.asz].bdt()) {
            this.fcE[this.asz].addPageAction(com.baidu.tbadk.img.effect.e.eA(i));
            this.fcD.bee();
            if (this.fcH[this.asz] != null) {
                String selectedFilter = this.fcH[this.asz].getSelectedFilter();
                if (selectedFilter != null && !selectedFilter.equals(WriteImageActivityConfig.FILTER_NAME_NORMAL)) {
                    ImageFileInfo cloneWithoutFilterAction = this.fcE[this.asz].cloneWithoutFilterAction(false);
                    cloneWithoutFilterAction.addPageAction(com.baidu.tbadk.img.effect.a.fN(selectedFilter));
                    this.fcG[this.asz].k(cloneWithoutFilterAction);
                    return;
                }
                this.fcG[this.asz].k(this.fcE[this.asz]);
                return;
            }
            this.fcG[this.asz].k(this.fcE[this.asz]);
        }
    }

    @Override // com.baidu.tbadk.coreExtra.view.c.a
    public void eH(String str) {
        if (str != null && !str.equals(WriteImageActivityConfig.FILTER_NAME_NORMAL)) {
            this.fcD.bee();
            ImageFileInfo cloneWithoutFilterAction = this.fcE[this.asz].cloneWithoutFilterAction(false);
            cloneWithoutFilterAction.addPageAction(com.baidu.tbadk.img.effect.a.fN(str));
            this.fcG[this.asz].k(cloneWithoutFilterAction);
            return;
        }
        this.fcD.bef();
        this.fcG[this.asz].k(this.fcE[this.asz]);
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (this.fcG[i] == null) {
            this.fcG[i] = new b(i);
        }
        this.asg.addView(this.fcG[i].getView());
        return this.fcG[i].getView();
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        this.asg.removeView(this.fcG[i].getView());
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        this.asz = i;
        bdo();
        if (this.fcF != null) {
            this.fcF.a(this.fcH[i], i);
        }
    }

    private void bdo() {
        if (this.asz >= 0) {
            if (this.fcG != null) {
                for (int i = 0; i < this.fcG.length; i++) {
                    if (this.fcG[i] != null) {
                        this.fcG[i].aVd();
                    }
                }
                if (this.fcG[this.asz] == null) {
                    this.fcG[this.asz] = new b(this.asz);
                }
            }
            String selectedFilter = this.fcH[this.asz].getSelectedFilter();
            if (selectedFilter != null && !selectedFilter.equals(WriteImageActivityConfig.FILTER_NAME_NORMAL)) {
                ImageFileInfo cloneWithoutFilterAction = this.fcE[this.asz].cloneWithoutFilterAction(false);
                cloneWithoutFilterAction.addPageAction(com.baidu.tbadk.img.effect.a.fN(selectedFilter));
                if (this.fcG != null) {
                    this.fcG[this.asz].k(cloneWithoutFilterAction);
                }
            } else if (this.fcG != null) {
                this.fcG[this.asz].k(this.fcE[this.asz]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getCurrentIndex() {
        return this.asz;
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
        this.fcH[i] = new com.baidu.tbadk.coreExtra.view.c(this.fcD, this, str);
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return this.ni;
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bdp() {
        String selectedFilter;
        for (int i = 0; i < this.fcE.length; i++) {
            this.fcE[i].applayRotatePageActionToPersistAction();
            if (this.fcH[i] != null && (selectedFilter = this.fcH[i].getSelectedFilter()) != null && !selectedFilter.equals(WriteImageActivityConfig.FILTER_NAME_NORMAL)) {
                this.fcE[i].addPersistAction(com.baidu.tbadk.img.effect.a.fN(selectedFilter));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b {
        private TbImageView aFZ;
        private ProgressBar dLr;
        private FrameLayout fcK;
        private com.baidu.tbadk.img.b fcL;
        private int index;

        public b(int i) {
            this.dLr = null;
            this.index = -1;
            this.index = i;
            this.fcK = (FrameLayout) LayoutInflater.from(r.this.fcD.getPageContext().getContext()).inflate(t.h.progress_tb_imageview, (ViewGroup) null);
            this.aFZ = (TbImageView) this.fcK.findViewById(t.g.progress_tb_imageview);
            this.aFZ.setClickable(true);
            this.aFZ.setDefaultResource(0);
            this.aFZ.setDefaultErrorResource(0);
            this.aFZ.setDefaultBgResource(0);
            this.aFZ.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            this.fcL = new com.baidu.tbadk.img.b();
            this.aFZ.setOnClickListener(new s(this));
            this.dLr = (ProgressBar) this.fcK.findViewById(t.g.progress_tb_imageview_progress);
            this.dLr.setVisibility(8);
        }

        public View getView() {
            return this.fcK;
        }

        public void k(ImageFileInfo imageFileInfo) {
            aVd();
            this.aFZ.setDefaultResource(0);
            this.aFZ.setDefaultBgResource(0);
            com.baidu.adp.widget.a.a a = this.fcL.a(imageFileInfo, false);
            if (a != null) {
                a.a(this.aFZ);
                return;
            }
            kA(false);
            this.fcL.a(imageFileInfo, new t(this), false);
        }

        public void aVd() {
            if (this.fcL != null) {
                this.fcL.CN();
            }
            if (this.aFZ != null) {
                this.aFZ.setImageDrawable(null);
            }
        }

        public boolean bdt() {
            return this.dLr.getVisibility() != 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void kA(boolean z) {
            if (z) {
                if (this.dLr.getVisibility() != 8) {
                    if (r.this.fcF != null) {
                        r.this.fcF.bds();
                    }
                    this.dLr.setVisibility(8);
                    r.this.fcH[this.index].setCanbeClick(true);
                }
            } else if (this.dLr.getVisibility() != 0) {
                if (r.this.fcF != null) {
                    r.this.fcF.bdr();
                }
                this.dLr.setVisibility(0);
                r.this.fcH[this.index].setCanbeClick(false);
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
