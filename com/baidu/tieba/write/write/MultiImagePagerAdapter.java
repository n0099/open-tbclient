package com.baidu.tieba.write.write;

import android.graphics.Bitmap;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.m;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes3.dex */
public class MultiImagePagerAdapter extends PagerAdapter implements ViewPager.OnPageChangeListener {
    private int bqk;
    private WriteMultiImgsActivity jVD;
    private ImageFileInfo[] jVE;
    private a jVF;
    private b[] jVG;
    private int jVH;
    private LinkedList<ImageFileInfo> jVI = new LinkedList<>();
    private int jVJ;
    private int jVK;
    private h jVL;
    private com.baidu.tbadk.core.dialog.a jVM;
    private Bitmap mBitmap;
    private int mCount;
    private boolean mIsFromIm;
    private ViewPager mViewPager;

    /* loaded from: classes3.dex */
    public interface a {
        void X(int i, boolean z);

        void cCB();

        void cCD();

        boolean cCE();
    }

    public MultiImagePagerAdapter(WriteMultiImgsActivity writeMultiImgsActivity, ViewPager viewPager, LinkedList<ImageFileInfo> linkedList, int i, a aVar, h hVar, boolean z) {
        this.jVD = null;
        this.jVE = null;
        this.mViewPager = null;
        this.jVF = null;
        this.mCount = 0;
        this.bqk = 0;
        this.jVG = null;
        this.jVJ = 120;
        this.jVK = 120;
        this.mIsFromIm = z;
        this.jVD = writeMultiImgsActivity;
        this.jVL = hVar;
        this.jVJ = (int) writeMultiImgsActivity.getResources().getDimension(R.dimen.ds720);
        this.jVK = (int) writeMultiImgsActivity.getResources().getDimension(R.dimen.ds1280);
        this.bqk = e(linkedList, i);
        this.mCount = this.jVI.size();
        this.jVE = new ImageFileInfo[this.mCount];
        this.jVG = new b[this.mCount];
        for (int i2 = 0; i2 < this.mCount; i2++) {
            this.jVE[i2] = this.jVI.get(i2).cloneWithoutFilterAction(true);
            this.jVE[i2].addPageAction(com.baidu.tbadk.img.effect.d.al(this.jVJ, this.jVK));
            linkedList.set(linkedList.indexOf(this.jVI.get(i2)), this.jVE[i2]);
            this.jVE[i2].mCount = 0;
        }
        this.mViewPager = viewPager;
        this.jVF = aVar;
        this.mViewPager.setOffscreenPageLimit(1);
        this.mViewPager.setOnPageChangeListener(this);
    }

    private int e(LinkedList<ImageFileInfo> linkedList, int i) {
        if (linkedList != null && i >= 0 && i < linkedList.size()) {
            this.jVI.clear();
            ImageFileInfo imageFileInfo = linkedList.get(i);
            Iterator<ImageFileInfo> it = linkedList.iterator();
            while (it.hasNext()) {
                ImageFileInfo next = it.next();
                if (next != null && next.getImageType() == 0) {
                    this.jVI.add(next);
                }
            }
            return this.jVI.indexOf(imageFileInfo);
        }
        return i;
    }

    public int cCx() {
        return this.bqk;
    }

    private boolean Ws() {
        return (this.jVG == null || this.bqk >= this.jVG.length || this.jVG[this.bqk] == null || this.jVE == null || this.bqk >= this.jVE.length || this.jVE[this.bqk] == null) ? false : true;
    }

    public boolean cCy() {
        if (this.bqk >= this.jVE.length || this.jVE[this.bqk] == null || !this.jVE[this.bqk].isGif() || this.jVE[this.bqk].mCount > 0) {
            return false;
        }
        this.jVE[this.bqk].mCount++;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void W(int i, boolean z) {
        b bVar;
        ImageFileInfo imageFileInfo;
        if (cCy()) {
            if (this.jVF != null) {
                this.jVF.X(i, z);
            }
        } else if (z) {
            Dp(i);
        } else if (Ws() && (bVar = this.jVG[this.bqk]) != null && (imageFileInfo = this.jVE[this.bqk]) != null && bVar.cCF()) {
            imageFileInfo.addPageAction(com.baidu.tbadk.img.effect.e.kK(i));
            this.jVD.cDC();
            bVar.j(imageFileInfo);
        }
    }

    private void Dp(int i) {
        this.jVH = i;
        if (this.jVM == null) {
            this.jVM = new com.baidu.tbadk.core.dialog.a(this.jVD);
            this.jVM.hv(R.string.rorate_tip);
            this.jVM.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (MultiImagePagerAdapter.this.jVM != null) {
                        MultiImagePagerAdapter.this.jVM.dismiss();
                    }
                    MultiImagePagerAdapter.this.jVL.jYa.a(new com.baidu.tieba.write.write.sticker.a.c() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.1.1
                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public void cCA() {
                        }

                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public void cCB() {
                            MultiImagePagerAdapter.this.jVF.cCB();
                        }

                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public boolean P(Bitmap bitmap) {
                            return false;
                        }

                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public void cCC() {
                        }
                    });
                    MultiImagePagerAdapter.this.W(MultiImagePagerAdapter.this.jVH, false);
                }
            });
            this.jVM.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (MultiImagePagerAdapter.this.jVM != null) {
                        MultiImagePagerAdapter.this.jVM.dismiss();
                    }
                }
            });
            this.jVM.b(this.jVD.getPageContext());
        }
        this.jVM.agO();
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (this.jVG[i] == null) {
            this.jVG[i] = new b(i);
        }
        this.mViewPager.addView(this.jVG[i].getView());
        return this.jVG[i].getView();
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        this.mViewPager.removeView(this.jVG[i].getView());
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        this.bqk = i;
        cCz();
    }

    private void cCz() {
        if (this.bqk >= 0 && this.jVG != null && this.bqk < this.jVG.length && this.bqk < this.jVE.length && this.jVE[this.bqk] != null) {
            for (int i = 0; i < this.jVG.length; i++) {
                if (this.jVG[i] != null) {
                    this.jVG[i].aYF();
                }
            }
            if (this.jVG[this.bqk] == null) {
                this.jVG[this.bqk] = new b(this.bqk);
            }
            this.jVG[this.bqk].j(this.jVE[this.bqk]);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getCurrentIndex() {
        return this.bqk;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return this.mCount;
    }

    private boolean f(String str, Bitmap bitmap) {
        try {
            m.a(TbConfig.LOCAL_PIC_DIR, str, bitmap, 90);
            Bitmap resizeBitmap = BitmapHelper.resizeBitmap(bitmap, 100);
            if (resizeBitmap != null) {
                if (m.a((String) null, TbConfig.IMAGE_RESIZED_FILE_DISPLAY, resizeBitmap, 85) != null) {
                    return true;
                }
            }
        } catch (Exception e) {
            BdLog.e(e.toString());
        }
        return false;
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void sp(boolean z) {
        Bitmap bitmap;
        Bitmap a2;
        Bitmap bitmap2 = null;
        if (this.jVE != null) {
            for (int i = 0; i < this.jVE.length; i++) {
                ImageFileInfo imageFileInfo = this.jVE[i];
                if (imageFileInfo != null) {
                    this.jVE[i].applayRotatePageActionToPersistAction(imageFileInfo);
                }
            }
            if (!Ws()) {
                if (!z && this.mIsFromIm) {
                    O(this.mBitmap);
                }
            } else if (this.jVF != null && this.jVF.cCE() && this.jVL != null && this.jVL.jYa != null) {
                this.jVL.jYa.bRN();
                TbImageView tbImageView = this.jVG[this.bqk].SC;
                try {
                    bitmap = this.jVL.jYa.cEf();
                } catch (OutOfMemoryError e) {
                    bitmap = null;
                }
                if (bitmap != null) {
                    try {
                        bitmap2 = com.baidu.tbadk.util.f.bh(tbImageView);
                    } catch (OutOfMemoryError e2) {
                        TbadkCoreApplication.getInst().onAppMemoryLow();
                        if (bitmap == null) {
                            return;
                        }
                        return;
                    }
                    if (bitmap == null && bitmap2 != null && (a2 = com.baidu.tbadk.util.f.a(bitmap2, bitmap, bitmap2.getWidth(), bitmap2.getHeight())) != null) {
                        this.jVE[this.bqk].setFilePath(m.b(m.aij(), String.valueOf(System.currentTimeMillis() + "_sticker.png"), a2, 100));
                        this.jVE[this.bqk].clearAllActions();
                        this.jVE[this.bqk].clearPageActions();
                        this.jVE[this.bqk].setIsGif(false);
                        if (!z && this.mIsFromIm) {
                            O(a2);
                        }
                    }
                }
            } else if (!z && this.mIsFromIm) {
                O(this.mBitmap);
            }
        }
    }

    private void O(Bitmap bitmap) {
        if (bitmap != null && !bitmap.isRecycled()) {
            String str = "tieba" + String.valueOf(new Date().getTime()) + ".jpg";
            if (f(str, bitmap)) {
                this.jVE[0].extra = str;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class b {
        private TbImageView SC;
        private int index;
        private FrameLayout jVP;
        private com.baidu.tbadk.img.b jVQ;
        private ProgressBar jdY;

        public b(int i) {
            this.jdY = null;
            this.index = -1;
            this.index = i;
            this.jVP = (FrameLayout) LayoutInflater.from(MultiImagePagerAdapter.this.jVD.getPageContext().getContext()).inflate(R.layout.progress_tb_imageview, (ViewGroup) null);
            this.SC = (TbImageView) this.jVP.findViewById(R.id.progress_tb_imageview);
            this.SC.setClickable(true);
            this.SC.setDefaultResource(0);
            this.SC.setDefaultErrorResource(0);
            this.SC.setDefaultBgResource(0);
            this.SC.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.SC.setPadding(0, 0, 0, 0);
            this.jVQ = new com.baidu.tbadk.img.b();
            this.SC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (MultiImagePagerAdapter.this.jVF != null) {
                        MultiImagePagerAdapter.this.jVF.cCD();
                    }
                }
            });
            this.jdY = (ProgressBar) this.jVP.findViewById(R.id.progress_tb_imageview_progress);
            this.jdY.setVisibility(8);
        }

        public View getView() {
            return this.jVP;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(ImageFileInfo imageFileInfo, com.baidu.adp.widget.ImageView.a aVar) {
            if (aVar != null && this.SC != null) {
                int[] e = l.e(aVar.getWidth(), aVar.getHeight(), l.af(MultiImagePagerAdapter.this.jVD), (l.ah(MultiImagePagerAdapter.this.jVD) - l.g(MultiImagePagerAdapter.this.jVD, R.dimen.ds418)) - UtilHelper.getStatusBarHeight());
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.SC.getLayoutParams();
                layoutParams.gravity = 17;
                layoutParams.width = e[0];
                layoutParams.height = e[1];
                this.SC.setLayoutParams(layoutParams);
                aVar.a(this.SC);
                if (MultiImagePagerAdapter.this.jVL != null && MultiImagePagerAdapter.this.jVL.jYa != null && imageFileInfo != null) {
                    FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) MultiImagePagerAdapter.this.jVL.jYa.getLayoutParams();
                    layoutParams2.gravity = 17;
                    layoutParams2.width = e[0];
                    layoutParams2.height = e[1];
                    MultiImagePagerAdapter.this.jVL.jYa.setLayoutParams(layoutParams2);
                }
                if (aVar.nK() != null && !aVar.nK().isRecycled()) {
                    MultiImagePagerAdapter.this.mBitmap = aVar.nK();
                }
            }
        }

        public void j(final ImageFileInfo imageFileInfo) {
            if (imageFileInfo != null) {
                aYF();
                this.jdY.setVisibility(0);
                com.baidu.adp.widget.ImageView.a a = this.jVQ.a(imageFileInfo, false);
                if (a != null) {
                    a(imageFileInfo, a);
                    this.jdY.setVisibility(8);
                    return;
                }
                this.jVQ.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.b.2
                    @Override // com.baidu.tbadk.imageManager.b
                    public void a(com.baidu.adp.widget.ImageView.a aVar, String str, boolean z) {
                        b.this.a(imageFileInfo, aVar);
                        b.this.jdY.setVisibility(8);
                        if (MultiImagePagerAdapter.this.jVL != null) {
                            MultiImagePagerAdapter.this.jVL.cCs();
                        }
                    }
                }, false);
            }
        }

        public void aYF() {
            if (this.jVQ != null) {
                this.jVQ.atU();
            }
            if (this.SC != null) {
            }
        }

        public boolean cCF() {
            return this.jdY.getVisibility() != 0;
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }
}
