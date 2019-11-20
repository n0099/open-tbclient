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
    private int apz;
    private WriteMultiImgsActivity jSL;
    private ImageFileInfo[] jSM;
    private a jSN;
    private b[] jSO;
    private int jSP;
    private LinkedList<ImageFileInfo> jSQ = new LinkedList<>();
    private int jSR;
    private int jSS;
    private h jST;
    private com.baidu.tbadk.core.dialog.a jSU;
    private Bitmap mBitmap;
    private int mCount;
    private boolean mIsFromIm;
    private ViewPager mViewPager;

    /* loaded from: classes3.dex */
    public interface a {
        void U(int i, boolean z);

        void czj();

        void czl();

        boolean czm();
    }

    public MultiImagePagerAdapter(WriteMultiImgsActivity writeMultiImgsActivity, ViewPager viewPager, LinkedList<ImageFileInfo> linkedList, int i, a aVar, h hVar, boolean z) {
        this.jSL = null;
        this.jSM = null;
        this.mViewPager = null;
        this.jSN = null;
        this.mCount = 0;
        this.apz = 0;
        this.jSO = null;
        this.jSR = 120;
        this.jSS = 120;
        this.mIsFromIm = z;
        this.jSL = writeMultiImgsActivity;
        this.jST = hVar;
        this.jSR = (int) writeMultiImgsActivity.getResources().getDimension(R.dimen.ds720);
        this.jSS = (int) writeMultiImgsActivity.getResources().getDimension(R.dimen.ds1280);
        this.apz = b(linkedList, i);
        this.mCount = this.jSQ.size();
        this.jSM = new ImageFileInfo[this.mCount];
        this.jSO = new b[this.mCount];
        for (int i2 = 0; i2 < this.mCount; i2++) {
            this.jSM[i2] = this.jSQ.get(i2).cloneWithoutFilterAction(true);
            this.jSM[i2].addPageAction(com.baidu.tbadk.img.effect.d.am(this.jSR, this.jSS));
            linkedList.set(linkedList.indexOf(this.jSQ.get(i2)), this.jSM[i2]);
            this.jSM[i2].mCount = 0;
        }
        this.mViewPager = viewPager;
        this.jSN = aVar;
        this.mViewPager.setOffscreenPageLimit(1);
        this.mViewPager.setOnPageChangeListener(this);
    }

    private int b(LinkedList<ImageFileInfo> linkedList, int i) {
        if (linkedList != null && i >= 0 && i < linkedList.size()) {
            this.jSQ.clear();
            ImageFileInfo imageFileInfo = linkedList.get(i);
            Iterator<ImageFileInfo> it = linkedList.iterator();
            while (it.hasNext()) {
                ImageFileInfo next = it.next();
                if (next != null && next.getImageType() == 0) {
                    this.jSQ.add(next);
                }
            }
            return this.jSQ.indexOf(imageFileInfo);
        }
        return i;
    }

    public int czf() {
        return this.apz;
    }

    private boolean abf() {
        return (this.jSO == null || this.apz >= this.jSO.length || this.jSO[this.apz] == null || this.jSM == null || this.apz >= this.jSM.length || this.jSM[this.apz] == null) ? false : true;
    }

    public boolean czg() {
        if (this.apz >= this.jSM.length || this.jSM[this.apz] == null || !this.jSM[this.apz].isGif() || this.jSM[this.apz].mCount > 0) {
            return false;
        }
        this.jSM[this.apz].mCount++;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void T(int i, boolean z) {
        b bVar;
        ImageFileInfo imageFileInfo;
        if (czg()) {
            if (this.jSN != null) {
                this.jSN.U(i, z);
            }
        } else if (z) {
            BK(i);
        } else if (abf() && (bVar = this.jSO[this.apz]) != null && (imageFileInfo = this.jSM[this.apz]) != null && bVar.czn()) {
            imageFileInfo.addPageAction(com.baidu.tbadk.img.effect.e.jX(i));
            this.jSL.cAk();
            bVar.j(imageFileInfo);
        }
    }

    private void BK(int i) {
        this.jSP = i;
        if (this.jSU == null) {
            this.jSU = new com.baidu.tbadk.core.dialog.a(this.jSL);
            this.jSU.hT(R.string.rorate_tip);
            this.jSU.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (MultiImagePagerAdapter.this.jSU != null) {
                        MultiImagePagerAdapter.this.jSU.dismiss();
                    }
                    MultiImagePagerAdapter.this.jST.jVi.a(new com.baidu.tieba.write.write.sticker.a.c() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.1.1
                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public void czi() {
                        }

                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public void czj() {
                            MultiImagePagerAdapter.this.jSN.czj();
                        }

                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public boolean N(Bitmap bitmap) {
                            return false;
                        }

                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public void czk() {
                        }
                    });
                    MultiImagePagerAdapter.this.T(MultiImagePagerAdapter.this.jSP, false);
                }
            });
            this.jSU.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (MultiImagePagerAdapter.this.jSU != null) {
                        MultiImagePagerAdapter.this.jSU.dismiss();
                    }
                }
            });
            this.jSU.b(this.jSL.getPageContext());
        }
        this.jSU.akM();
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (this.jSO[i] == null) {
            this.jSO[i] = new b(i);
        }
        this.mViewPager.addView(this.jSO[i].getView());
        return this.jSO[i].getView();
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        this.mViewPager.removeView(this.jSO[i].getView());
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        this.apz = i;
        czh();
    }

    private void czh() {
        if (this.apz >= 0 && this.jSO != null && this.apz < this.jSO.length && this.apz < this.jSM.length && this.jSM[this.apz] != null) {
            for (int i = 0; i < this.jSO.length; i++) {
                if (this.jSO[i] != null) {
                    this.jSO[i].cpE();
                }
            }
            if (this.jSO[this.apz] == null) {
                this.jSO[this.apz] = new b(this.apz);
            }
            this.jSO[this.apz].j(this.jSM[this.apz]);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getCurrentIndex() {
        return this.apz;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return this.mCount;
    }

    private boolean b(String str, Bitmap bitmap) {
        try {
            m.a(TbConfig.LOCAL_PIC_DIR, str, bitmap, 90);
            Bitmap resizeBitmap = BitmapHelper.resizeBitmap(bitmap, 100);
            if (resizeBitmap != null) {
                if (m.a(null, TbConfig.IMAGE_RESIZED_FILE_DISPLAY, resizeBitmap, 85) != null) {
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
    public void rU(boolean z) {
        Bitmap bitmap;
        Bitmap a2;
        Bitmap bitmap2 = null;
        if (this.jSM != null) {
            for (int i = 0; i < this.jSM.length; i++) {
                ImageFileInfo imageFileInfo = this.jSM[i];
                if (imageFileInfo != null) {
                    this.jSM[i].applayRotatePageActionToPersistAction(imageFileInfo);
                }
            }
            if (!abf()) {
                if (!z && this.mIsFromIm) {
                    M(this.mBitmap);
                }
            } else if (this.jSN != null && this.jSN.czm() && this.jST != null && this.jST.jVi != null) {
                this.jST.jVi.bOK();
                TbImageView tbImageView = this.jSO[this.apz].Bx;
                try {
                    bitmap = this.jST.jVi.cAN();
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
                        this.jSM[this.apz].setFilePath(m.saveFileAsPNG(m.getCacheDir(), String.valueOf(System.currentTimeMillis() + "_sticker.png"), a2, 100));
                        this.jSM[this.apz].clearAllActions();
                        this.jSM[this.apz].clearPageActions();
                        this.jSM[this.apz].setIsGif(false);
                        if (!z && this.mIsFromIm) {
                            M(a2);
                        }
                    }
                }
            } else if (!z && this.mIsFromIm) {
                M(this.mBitmap);
            }
        }
    }

    private void M(Bitmap bitmap) {
        if (bitmap != null && !bitmap.isRecycled()) {
            String str = "tieba" + String.valueOf(new Date().getTime()) + ".jpg";
            if (b(str, bitmap)) {
                this.jSM[0].extra = str;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class b {
        private TbImageView Bx;
        private int index;
        private FrameLayout jSX;
        private com.baidu.tbadk.img.b jSY;
        private ProgressBar jcY;

        public b(int i) {
            this.jcY = null;
            this.index = -1;
            this.index = i;
            this.jSX = (FrameLayout) LayoutInflater.from(MultiImagePagerAdapter.this.jSL.getPageContext().getContext()).inflate(R.layout.progress_tb_imageview, (ViewGroup) null);
            this.Bx = (TbImageView) this.jSX.findViewById(R.id.progress_tb_imageview);
            this.Bx.setClickable(true);
            this.Bx.setDefaultResource(0);
            this.Bx.setDefaultErrorResource(0);
            this.Bx.setDefaultBgResource(0);
            this.Bx.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.Bx.setPadding(0, 0, 0, 0);
            this.jSY = new com.baidu.tbadk.img.b();
            this.Bx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (MultiImagePagerAdapter.this.jSN != null) {
                        MultiImagePagerAdapter.this.jSN.czl();
                    }
                }
            });
            this.jcY = (ProgressBar) this.jSX.findViewById(R.id.progress_tb_imageview_progress);
            this.jcY.setVisibility(8);
        }

        public View getView() {
            return this.jSX;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(ImageFileInfo imageFileInfo, com.baidu.adp.widget.ImageView.a aVar) {
            if (aVar != null && this.Bx != null) {
                int[] imageResize = l.getImageResize(aVar.getWidth(), aVar.getHeight(), l.getEquipmentWidth(MultiImagePagerAdapter.this.jSL), (l.getEquipmentHeight(MultiImagePagerAdapter.this.jSL) - l.getDimens(MultiImagePagerAdapter.this.jSL, R.dimen.ds418)) - UtilHelper.getStatusBarHeight());
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.Bx.getLayoutParams();
                layoutParams.gravity = 17;
                layoutParams.width = imageResize[0];
                layoutParams.height = imageResize[1];
                this.Bx.setLayoutParams(layoutParams);
                aVar.drawImageTo(this.Bx);
                if (MultiImagePagerAdapter.this.jST != null && MultiImagePagerAdapter.this.jST.jVi != null && imageFileInfo != null) {
                    FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) MultiImagePagerAdapter.this.jST.jVi.getLayoutParams();
                    layoutParams2.gravity = 17;
                    layoutParams2.width = imageResize[0];
                    layoutParams2.height = imageResize[1];
                    MultiImagePagerAdapter.this.jST.jVi.setLayoutParams(layoutParams2);
                }
                if (aVar.getRawBitmap() != null && !aVar.getRawBitmap().isRecycled()) {
                    MultiImagePagerAdapter.this.mBitmap = aVar.getRawBitmap();
                }
            }
        }

        public void j(final ImageFileInfo imageFileInfo) {
            if (imageFileInfo != null) {
                cpE();
                this.jcY.setVisibility(0);
                com.baidu.adp.widget.ImageView.a a = this.jSY.a(imageFileInfo, false);
                if (a != null) {
                    a(imageFileInfo, a);
                    this.jcY.setVisibility(8);
                    return;
                }
                this.jSY.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.b.2
                    @Override // com.baidu.tbadk.imageManager.b
                    public void a(com.baidu.adp.widget.ImageView.a aVar, String str, boolean z) {
                        b.this.a(imageFileInfo, aVar);
                        b.this.jcY.setVisibility(8);
                        if (MultiImagePagerAdapter.this.jST != null) {
                            MultiImagePagerAdapter.this.jST.aLY();
                        }
                    }
                }, false);
            }
        }

        public void cpE() {
            if (this.jSY != null) {
                this.jSY.cancelAllAsyncTask();
            }
            if (this.Bx != null) {
            }
        }

        public boolean czn() {
            return this.jcY.getVisibility() != 0;
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }
}
