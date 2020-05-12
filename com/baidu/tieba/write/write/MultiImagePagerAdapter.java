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
/* loaded from: classes2.dex */
public class MultiImagePagerAdapter extends PagerAdapter implements ViewPager.OnPageChangeListener {
    private WriteMultiImgsActivity lDG;
    private ImageFileInfo[] lDH;
    private a lDI;
    private b[] lDJ;
    private int lDK;
    private LinkedList<ImageFileInfo> lDL = new LinkedList<>();
    private int lDM;
    private int lDN;
    private h lDO;
    private com.baidu.tbadk.core.dialog.a lDP;
    private Bitmap mBitmap;
    private int mCount;
    private int mCurrentIndex;
    private boolean mIsFromIm;
    private ViewPager mViewPager;

    /* loaded from: classes2.dex */
    public interface a {
        void ab(int i, boolean z);

        void dgI();

        void dgK();

        boolean dgL();
    }

    public MultiImagePagerAdapter(WriteMultiImgsActivity writeMultiImgsActivity, ViewPager viewPager, LinkedList<ImageFileInfo> linkedList, int i, a aVar, h hVar, boolean z) {
        this.lDG = null;
        this.lDH = null;
        this.mViewPager = null;
        this.lDI = null;
        this.mCount = 0;
        this.mCurrentIndex = 0;
        this.lDJ = null;
        this.lDM = 120;
        this.lDN = 120;
        this.mIsFromIm = z;
        this.lDG = writeMultiImgsActivity;
        this.lDO = hVar;
        this.lDM = (int) writeMultiImgsActivity.getResources().getDimension(R.dimen.ds720);
        this.lDN = (int) writeMultiImgsActivity.getResources().getDimension(R.dimen.ds1280);
        this.mCurrentIndex = b(linkedList, i);
        this.mCount = this.lDL.size();
        this.lDH = new ImageFileInfo[this.mCount];
        this.lDJ = new b[this.mCount];
        for (int i2 = 0; i2 < this.mCount; i2++) {
            this.lDH[i2] = this.lDL.get(i2).cloneWithoutFilterAction(true);
            this.lDH[i2].addPageAction(com.baidu.tbadk.img.effect.d.aO(this.lDM, this.lDN));
            linkedList.set(linkedList.indexOf(this.lDL.get(i2)), this.lDH[i2]);
            this.lDH[i2].mCount = 0;
        }
        this.mViewPager = viewPager;
        this.lDI = aVar;
        this.mViewPager.setOffscreenPageLimit(1);
        this.mViewPager.setOnPageChangeListener(this);
    }

    private int b(LinkedList<ImageFileInfo> linkedList, int i) {
        if (linkedList != null && i >= 0 && i < linkedList.size()) {
            this.lDL.clear();
            ImageFileInfo imageFileInfo = linkedList.get(i);
            Iterator<ImageFileInfo> it = linkedList.iterator();
            while (it.hasNext()) {
                ImageFileInfo next = it.next();
                if (next != null && next.getImageType() == 0) {
                    this.lDL.add(next);
                }
            }
            return this.lDL.indexOf(imageFileInfo);
        }
        return i;
    }

    public int dgE() {
        return this.mCurrentIndex;
    }

    private boolean XL() {
        return (this.lDJ == null || this.mCurrentIndex >= this.lDJ.length || this.lDJ[this.mCurrentIndex] == null || this.lDH == null || this.mCurrentIndex >= this.lDH.length || this.lDH[this.mCurrentIndex] == null) ? false : true;
    }

    public boolean dgF() {
        if (this.mCurrentIndex >= this.lDH.length || this.lDH[this.mCurrentIndex] == null || !this.lDH[this.mCurrentIndex].isGif() || this.lDH[this.mCurrentIndex].mCount > 0) {
            return false;
        }
        this.lDH[this.mCurrentIndex].mCount++;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aa(int i, boolean z) {
        b bVar;
        ImageFileInfo imageFileInfo;
        if (dgF()) {
            if (this.lDI != null) {
                this.lDI.ab(i, z);
            }
        } else if (z) {
            EZ(i);
        } else if (XL() && (bVar = this.lDJ[this.mCurrentIndex]) != null && (imageFileInfo = this.lDH[this.mCurrentIndex]) != null && bVar.dgM()) {
            imageFileInfo.addPageAction(com.baidu.tbadk.img.effect.e.mP(i));
            this.lDG.dhL();
            bVar.l(imageFileInfo);
        }
    }

    private void EZ(int i) {
        this.lDK = i;
        if (this.lDP == null) {
            this.lDP = new com.baidu.tbadk.core.dialog.a(this.lDG);
            this.lDP.kd(R.string.rorate_tip);
            this.lDP.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (MultiImagePagerAdapter.this.lDP != null) {
                        MultiImagePagerAdapter.this.lDP.dismiss();
                    }
                    MultiImagePagerAdapter.this.lDO.lGd.a(new com.baidu.tieba.write.write.sticker.a.c() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.1.1
                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public void dgH() {
                        }

                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public void dgI() {
                            MultiImagePagerAdapter.this.lDI.dgI();
                        }

                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public boolean Q(Bitmap bitmap) {
                            return false;
                        }

                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public void dgJ() {
                        }
                    });
                    MultiImagePagerAdapter.this.aa(MultiImagePagerAdapter.this.lDK, false);
                }
            });
            this.lDP.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (MultiImagePagerAdapter.this.lDP != null) {
                        MultiImagePagerAdapter.this.lDP.dismiss();
                    }
                }
            });
            this.lDP.b(this.lDG.getPageContext());
        }
        this.lDP.aMS();
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (this.lDJ[i] == null) {
            this.lDJ[i] = new b(i);
        }
        this.mViewPager.addView(this.lDJ[i].getView());
        return this.lDJ[i].getView();
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        this.mViewPager.removeView(this.lDJ[i].getView());
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        this.mCurrentIndex = i;
        dgG();
    }

    private void dgG() {
        if (this.mCurrentIndex >= 0 && this.lDJ != null && this.mCurrentIndex < this.lDJ.length && this.mCurrentIndex < this.lDH.length && this.lDH[this.mCurrentIndex] != null) {
            for (int i = 0; i < this.lDJ.length; i++) {
                if (this.lDJ[i] != null) {
                    this.lDJ[i].cXB();
                }
            }
            if (this.lDJ[this.mCurrentIndex] == null) {
                this.lDJ[this.mCurrentIndex] = new b(this.mCurrentIndex);
            }
            this.lDJ[this.mCurrentIndex].l(this.lDH[this.mCurrentIndex]);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getCurrentIndex() {
        return this.mCurrentIndex;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return this.mCount;
    }

    private boolean c(String str, Bitmap bitmap) {
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
    public void va(boolean z) {
        Bitmap bitmap;
        Bitmap bitmap2;
        Bitmap bitmap3;
        Bitmap a2;
        if (this.lDH != null) {
            for (int i = 0; i < this.lDH.length; i++) {
                ImageFileInfo imageFileInfo = this.lDH[i];
                if (imageFileInfo != null) {
                    this.lDH[i].applayRotatePageActionToPersistAction(imageFileInfo);
                }
            }
            if (!XL()) {
                if (!z && this.mIsFromIm) {
                    P(this.mBitmap);
                }
            } else if (this.lDI != null && this.lDI.dgL() && this.lDO != null && this.lDO.lGd != null) {
                this.lDO.lGd.ctI();
                TbImageView tbImageView = this.lDJ[this.mCurrentIndex].XV;
                try {
                    bitmap = this.lDO.lGd.dio();
                } catch (OutOfMemoryError e) {
                    bitmap = null;
                }
                if (bitmap != null) {
                    try {
                        Bitmap bj = com.baidu.tbadk.util.g.bj(tbImageView);
                        bitmap2 = bitmap;
                        bitmap3 = bj;
                    } catch (OutOfMemoryError e2) {
                        TbadkCoreApplication.getInst().onAppMemoryLow();
                        bitmap2 = bitmap;
                        bitmap3 = null;
                        if (bitmap2 == null) {
                            return;
                        }
                        return;
                    }
                    if (bitmap2 == null && bitmap3 != null && (a2 = com.baidu.tbadk.util.g.a(bitmap3, bitmap2, bitmap3.getWidth(), bitmap3.getHeight())) != null) {
                        this.lDH[this.mCurrentIndex].setFilePath(m.saveFileAsPNG(m.getCacheDir(), String.valueOf(System.currentTimeMillis() + "_sticker.png"), a2, 100));
                        this.lDH[this.mCurrentIndex].setContentUriStr(null);
                        this.lDH[this.mCurrentIndex].clearAllActions();
                        this.lDH[this.mCurrentIndex].clearPageActions();
                        this.lDH[this.mCurrentIndex].setIsGif(false);
                        if (!z && this.mIsFromIm) {
                            P(a2);
                        }
                    }
                }
            } else if (!z && this.mIsFromIm) {
                P(this.mBitmap);
            }
        }
    }

    private void P(Bitmap bitmap) {
        if (bitmap != null && !bitmap.isRecycled()) {
            String str = "tieba" + String.valueOf(new Date().getTime()) + ".jpg";
            if (c(str, bitmap)) {
                this.lDH[0].extra = str;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class b {
        private TbImageView XV;
        private int index;
        private ProgressBar kNG;
        private FrameLayout lDS;
        private com.baidu.tbadk.img.b lDT;

        public b(int i) {
            this.kNG = null;
            this.index = -1;
            this.index = i;
            this.lDS = (FrameLayout) LayoutInflater.from(MultiImagePagerAdapter.this.lDG.getPageContext().getContext()).inflate(R.layout.progress_tb_imageview, (ViewGroup) null);
            this.XV = (TbImageView) this.lDS.findViewById(R.id.progress_tb_imageview);
            this.XV.setClickable(true);
            this.XV.setDefaultResource(0);
            this.XV.setDefaultErrorResource(0);
            this.XV.setDefaultBgResource(0);
            this.XV.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.XV.setPadding(0, 0, 0, 0);
            this.lDT = new com.baidu.tbadk.img.b();
            this.XV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (MultiImagePagerAdapter.this.lDI != null) {
                        MultiImagePagerAdapter.this.lDI.dgK();
                    }
                }
            });
            this.kNG = (ProgressBar) this.lDS.findViewById(R.id.progress_tb_imageview_progress);
            this.kNG.setVisibility(8);
        }

        public View getView() {
            return this.lDS;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(ImageFileInfo imageFileInfo, com.baidu.adp.widget.ImageView.a aVar) {
            if (aVar != null && this.XV != null) {
                int[] imageResize = l.getImageResize(aVar.getWidth(), aVar.getHeight(), l.getEquipmentWidth(MultiImagePagerAdapter.this.lDG), (l.getEquipmentHeight(MultiImagePagerAdapter.this.lDG) - l.getDimens(MultiImagePagerAdapter.this.lDG, R.dimen.ds418)) - UtilHelper.getStatusBarHeight());
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.XV.getLayoutParams();
                layoutParams.gravity = 17;
                layoutParams.width = imageResize[0];
                layoutParams.height = imageResize[1];
                this.XV.setLayoutParams(layoutParams);
                aVar.drawImageTo(this.XV);
                if (MultiImagePagerAdapter.this.lDO != null && MultiImagePagerAdapter.this.lDO.lGd != null && imageFileInfo != null) {
                    FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) MultiImagePagerAdapter.this.lDO.lGd.getLayoutParams();
                    layoutParams2.gravity = 17;
                    layoutParams2.width = imageResize[0];
                    layoutParams2.height = imageResize[1];
                    MultiImagePagerAdapter.this.lDO.lGd.setLayoutParams(layoutParams2);
                }
                if (aVar.getRawBitmap() != null && !aVar.getRawBitmap().isRecycled()) {
                    MultiImagePagerAdapter.this.mBitmap = aVar.getRawBitmap();
                }
            }
        }

        public void l(final ImageFileInfo imageFileInfo) {
            if (imageFileInfo != null) {
                cXB();
                this.kNG.setVisibility(0);
                com.baidu.adp.widget.ImageView.a a = this.lDT.a(imageFileInfo, false);
                if (a != null) {
                    a(imageFileInfo, a);
                    this.kNG.setVisibility(8);
                    return;
                }
                this.lDT.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.b.2
                    @Override // com.baidu.tbadk.imageManager.b
                    public void a(com.baidu.adp.widget.ImageView.a aVar, String str, boolean z) {
                        b.this.a(imageFileInfo, aVar);
                        b.this.kNG.setVisibility(8);
                        if (MultiImagePagerAdapter.this.lDO != null) {
                            MultiImagePagerAdapter.this.lDO.bph();
                        }
                    }
                }, false);
            }
        }

        public void cXB() {
            if (this.lDT != null) {
                this.lDT.cancelAllAsyncTask();
            }
            if (this.XV != null) {
            }
        }

        public boolean dgM() {
            return this.kNG.getVisibility() != 0;
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }
}
