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
    private WriteMultiImgsActivity fcC;
    private ImageFileInfo[] fcD;
    private a fcE;
    private b[] fcF;
    private com.baidu.tbadk.coreExtra.view.c[] fcG;
    private int fcH;
    private int fcI;
    private int ni;

    /* loaded from: classes.dex */
    public interface a {
        void a(com.baidu.tbadk.coreExtra.view.c cVar, int i);

        void bdx();

        void bdy();

        void bdz();
    }

    public r(WriteMultiImgsActivity writeMultiImgsActivity, ViewPager viewPager, LinkedList<ImageFileInfo> linkedList, int i, a aVar) {
        int i2 = 0;
        this.fcC = null;
        this.fcD = null;
        this.asg = null;
        this.fcE = null;
        this.ni = 0;
        this.asz = 0;
        this.fcF = null;
        this.fcG = null;
        this.fcH = SocialAPIErrorCodes.ERROR_INVALID_AUTHORIZED_CODE;
        this.fcI = SocialAPIErrorCodes.ERROR_INVALID_AUTHORIZED_CODE;
        this.fcC = writeMultiImgsActivity;
        this.fcH = (int) writeMultiImgsActivity.getResources().getDimension(t.e.motu_image_size_width);
        this.fcI = (int) writeMultiImgsActivity.getResources().getDimension(t.e.motu_image_size_height);
        if (linkedList != null) {
            this.ni = linkedList.size();
        }
        this.fcD = new ImageFileInfo[this.ni];
        this.fcF = new b[this.ni];
        this.fcG = new com.baidu.tbadk.coreExtra.view.c[this.ni];
        while (true) {
            int i3 = i2;
            if (i3 < this.ni) {
                a(linkedList.get(i3), i3);
                this.fcD[i3] = linkedList.get(i3).cloneWithoutFilterAction(true);
                this.fcD[i3].addPageAction(com.baidu.tbadk.img.effect.d.D(this.fcH, this.fcI));
                linkedList.set(i3, this.fcD[i3]);
                i2 = i3 + 1;
            } else {
                this.asz = i;
                this.asg = viewPager;
                this.fcE = aVar;
                this.asg.setOffscreenPageLimit(1);
                this.asg.setOnPageChangeListener(this);
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void rk(int i) {
        if (this.fcF[this.asz].bdA()) {
            this.fcD[this.asz].addPageAction(com.baidu.tbadk.img.effect.e.ez(i));
            this.fcC.bel();
            if (this.fcG[this.asz] != null) {
                String selectedFilter = this.fcG[this.asz].getSelectedFilter();
                if (selectedFilter != null && !selectedFilter.equals(WriteImageActivityConfig.FILTER_NAME_NORMAL)) {
                    ImageFileInfo cloneWithoutFilterAction = this.fcD[this.asz].cloneWithoutFilterAction(false);
                    cloneWithoutFilterAction.addPageAction(com.baidu.tbadk.img.effect.a.fN(selectedFilter));
                    this.fcF[this.asz].k(cloneWithoutFilterAction);
                    return;
                }
                this.fcF[this.asz].k(this.fcD[this.asz]);
                return;
            }
            this.fcF[this.asz].k(this.fcD[this.asz]);
        }
    }

    @Override // com.baidu.tbadk.coreExtra.view.c.a
    public void eH(String str) {
        if (str != null && !str.equals(WriteImageActivityConfig.FILTER_NAME_NORMAL)) {
            this.fcC.bel();
            ImageFileInfo cloneWithoutFilterAction = this.fcD[this.asz].cloneWithoutFilterAction(false);
            cloneWithoutFilterAction.addPageAction(com.baidu.tbadk.img.effect.a.fN(str));
            this.fcF[this.asz].k(cloneWithoutFilterAction);
            return;
        }
        this.fcC.bem();
        this.fcF[this.asz].k(this.fcD[this.asz]);
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (this.fcF[i] == null) {
            this.fcF[i] = new b(i);
        }
        this.asg.addView(this.fcF[i].getView());
        return this.fcF[i].getView();
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        this.asg.removeView(this.fcF[i].getView());
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        this.asz = i;
        bdv();
        if (this.fcE != null) {
            this.fcE.a(this.fcG[i], i);
        }
    }

    private void bdv() {
        if (this.asz >= 0) {
            if (this.fcF != null) {
                for (int i = 0; i < this.fcF.length; i++) {
                    if (this.fcF[i] != null) {
                        this.fcF[i].aVj();
                    }
                }
                if (this.fcF[this.asz] == null) {
                    this.fcF[this.asz] = new b(this.asz);
                }
            }
            String selectedFilter = this.fcG[this.asz].getSelectedFilter();
            if (selectedFilter != null && !selectedFilter.equals(WriteImageActivityConfig.FILTER_NAME_NORMAL)) {
                ImageFileInfo cloneWithoutFilterAction = this.fcD[this.asz].cloneWithoutFilterAction(false);
                cloneWithoutFilterAction.addPageAction(com.baidu.tbadk.img.effect.a.fN(selectedFilter));
                if (this.fcF != null) {
                    this.fcF[this.asz].k(cloneWithoutFilterAction);
                }
            } else if (this.fcF != null) {
                this.fcF[this.asz].k(this.fcD[this.asz]);
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
        this.fcG[i] = new com.baidu.tbadk.coreExtra.view.c(this.fcC, this, str);
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
    public void bdw() {
        String selectedFilter;
        for (int i = 0; i < this.fcD.length; i++) {
            this.fcD[i].applayRotatePageActionToPersistAction();
            if (this.fcG[i] != null && (selectedFilter = this.fcG[i].getSelectedFilter()) != null && !selectedFilter.equals(WriteImageActivityConfig.FILTER_NAME_NORMAL)) {
                this.fcD[i].addPersistAction(com.baidu.tbadk.img.effect.a.fN(selectedFilter));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b {
        private TbImageView aFZ;
        private ProgressBar dLr;
        private FrameLayout fcJ;
        private com.baidu.tbadk.img.b fcK;
        private int index;

        public b(int i) {
            this.dLr = null;
            this.index = -1;
            this.index = i;
            this.fcJ = (FrameLayout) LayoutInflater.from(r.this.fcC.getPageContext().getContext()).inflate(t.h.progress_tb_imageview, (ViewGroup) null);
            this.aFZ = (TbImageView) this.fcJ.findViewById(t.g.progress_tb_imageview);
            this.aFZ.setClickable(true);
            this.aFZ.setDefaultResource(0);
            this.aFZ.setDefaultErrorResource(0);
            this.aFZ.setDefaultBgResource(0);
            this.aFZ.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            this.fcK = new com.baidu.tbadk.img.b();
            this.aFZ.setOnClickListener(new s(this));
            this.dLr = (ProgressBar) this.fcJ.findViewById(t.g.progress_tb_imageview_progress);
            this.dLr.setVisibility(8);
        }

        public View getView() {
            return this.fcJ;
        }

        public void k(ImageFileInfo imageFileInfo) {
            aVj();
            this.aFZ.setDefaultResource(0);
            this.aFZ.setDefaultBgResource(0);
            com.baidu.adp.widget.a.a a = this.fcK.a(imageFileInfo, false);
            if (a != null) {
                a.a(this.aFZ);
                return;
            }
            kA(false);
            this.fcK.a(imageFileInfo, new t(this), false);
        }

        public void aVj() {
            if (this.fcK != null) {
                this.fcK.CO();
            }
            if (this.aFZ != null) {
                this.aFZ.setImageDrawable(null);
            }
        }

        public boolean bdA() {
            return this.dLr.getVisibility() != 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void kA(boolean z) {
            if (z) {
                if (this.dLr.getVisibility() != 8) {
                    if (r.this.fcE != null) {
                        r.this.fcE.bdz();
                    }
                    this.dLr.setVisibility(8);
                    r.this.fcG[this.index].setCanbeClick(true);
                }
            } else if (this.dLr.getVisibility() != 0) {
                if (r.this.fcE != null) {
                    r.this.fcE.bdy();
                }
                this.dLr.setVisibility(0);
                r.this.fcG[this.index].setCanbeClick(false);
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
