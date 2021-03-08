package com.baidu.tieba.write.write;

import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.o;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes7.dex */
public class MultiImagePagerAdapter extends PagerAdapter implements ViewPager.OnPageChangeListener {
    private ViewPager aaw;
    private int bMV;
    private Bitmap mBitmap;
    private int mCount;
    private boolean mIsFromIm;
    private WriteMultiImgsActivity olH;
    private ImageFileInfo[] olI;
    private a olJ;
    private b[] olK;
    private int olL;
    private LinkedList<ImageFileInfo> olM = new LinkedList<>();
    private int olN;
    private int olO;
    private j olP;
    private com.baidu.tbadk.core.dialog.a olQ;

    /* loaded from: classes7.dex */
    public interface a {
        void ak(int i, boolean z);

        void dYj();

        void dYl();

        boolean dYm();
    }

    public MultiImagePagerAdapter(WriteMultiImgsActivity writeMultiImgsActivity, ViewPager viewPager, LinkedList<ImageFileInfo> linkedList, int i, a aVar, j jVar, boolean z) {
        this.olH = null;
        this.olI = null;
        this.aaw = null;
        this.olJ = null;
        this.mCount = 0;
        this.bMV = 0;
        this.olK = null;
        this.olN = 120;
        this.olO = 120;
        this.mIsFromIm = z;
        this.olH = writeMultiImgsActivity;
        this.olP = jVar;
        this.olN = (int) writeMultiImgsActivity.getResources().getDimension(R.dimen.ds720);
        this.olO = (int) writeMultiImgsActivity.getResources().getDimension(R.dimen.ds1280);
        this.bMV = b(linkedList, i);
        this.mCount = this.olM.size();
        this.olI = new ImageFileInfo[this.mCount];
        this.olK = new b[this.mCount];
        for (int i2 = 0; i2 < this.mCount; i2++) {
            this.olI[i2] = this.olM.get(i2).cloneWithoutFilterAction(true);
            this.olI[i2].addPageAction(com.baidu.tbadk.img.effect.d.bd(this.olN, this.olO));
            linkedList.set(linkedList.indexOf(this.olM.get(i2)), this.olI[i2]);
            this.olI[i2].mCount = 0;
        }
        this.aaw = viewPager;
        this.olJ = aVar;
        this.aaw.setOffscreenPageLimit(1);
        this.aaw.setOnPageChangeListener(this);
    }

    private int b(LinkedList<ImageFileInfo> linkedList, int i) {
        if (linkedList != null && i >= 0 && i < linkedList.size()) {
            this.olM.clear();
            ImageFileInfo imageFileInfo = linkedList.get(i);
            Iterator<ImageFileInfo> it = linkedList.iterator();
            while (it.hasNext()) {
                ImageFileInfo next = it.next();
                if (next != null && next.getImageType() == 0) {
                    this.olM.add(next);
                }
            }
            return this.olM.indexOf(imageFileInfo);
        }
        return i;
    }

    public int dYf() {
        return this.bMV;
    }

    private boolean arC() {
        return (this.olK == null || this.bMV >= this.olK.length || this.olK[this.bMV] == null || this.olI == null || this.bMV >= this.olI.length || this.olI[this.bMV] == null) ? false : true;
    }

    public boolean dYg() {
        if (this.bMV >= this.olI.length || this.olI[this.bMV] == null || !this.olI[this.bMV].isGif() || this.olI[this.bMV].mCount > 0) {
            return false;
        }
        this.olI[this.bMV].mCount++;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aj(int i, boolean z) {
        b bVar;
        ImageFileInfo imageFileInfo;
        if (dYg()) {
            if (this.olJ != null) {
                this.olJ.ak(i, z);
            }
        } else if (z) {
            LD(i);
        } else if (arC() && (bVar = this.olK[this.bMV]) != null && (imageFileInfo = this.olI[this.bMV]) != null && bVar.dYn()) {
            imageFileInfo.addPageAction(com.baidu.tbadk.img.effect.e.rm(i));
            this.olH.dZK();
            bVar.k(imageFileInfo);
        }
    }

    private void LD(int i) {
        this.olL = i;
        if (this.olQ == null) {
            this.olQ = new com.baidu.tbadk.core.dialog.a(this.olH);
            this.olQ.ny(R.string.rorate_tip);
            this.olQ.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (MultiImagePagerAdapter.this.olQ != null) {
                        MultiImagePagerAdapter.this.olQ.dismiss();
                    }
                    MultiImagePagerAdapter.this.olP.ooV.a(new com.baidu.tieba.write.write.sticker.a.c() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.1.1
                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public void dYi() {
                        }

                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public void dYj() {
                            MultiImagePagerAdapter.this.olJ.dYj();
                        }

                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public boolean T(Bitmap bitmap) {
                            return false;
                        }

                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public void dYk() {
                        }
                    });
                    MultiImagePagerAdapter.this.aj(MultiImagePagerAdapter.this.olL, false);
                }
            });
            this.olQ.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (MultiImagePagerAdapter.this.olQ != null) {
                        MultiImagePagerAdapter.this.olQ.dismiss();
                    }
                }
            });
            this.olQ.b(this.olH.getPageContext());
        }
        this.olQ.bqz();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (this.olK[i] == null) {
            this.olK[i] = new b(i);
        }
        this.aaw.addView(this.olK[i].getView());
        return this.olK[i].getView();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        this.aaw.removeView(this.olK[i].getView());
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        this.bMV = i;
        dYh();
    }

    private void dYh() {
        if (this.bMV >= 0 && this.olK != null && this.bMV < this.olK.length && this.bMV < this.olI.length && this.olI[this.bMV] != null) {
            for (int i = 0; i < this.olK.length; i++) {
                if (this.olK[i] != null) {
                    this.olK[i].dPC();
                }
            }
            if (this.olK[this.bMV] == null) {
                this.olK[this.bMV] = new b(this.bMV);
            }
            this.olK[this.bMV].k(this.olI[this.bMV]);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getCurrentIndex() {
        return this.bMV;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return this.mCount;
    }

    private boolean c(String str, Bitmap bitmap) {
        try {
            o.a(TbConfig.LOCAL_PIC_DIR, str, bitmap, 90);
            Bitmap resizeBitmap = BitmapHelper.resizeBitmap(bitmap, 100);
            if (resizeBitmap != null) {
                if (o.a(null, TbConfig.IMAGE_RESIZED_FILE_DISPLAY, resizeBitmap, 85) != null) {
                    return true;
                }
            }
        } catch (Exception e) {
            BdLog.e(e.toString());
        }
        return false;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void zF(boolean z) {
        Bitmap bitmap;
        Bitmap bitmap2;
        Bitmap a2;
        if (this.olI != null) {
            for (int i = 0; i < this.olI.length; i++) {
                ImageFileInfo imageFileInfo = this.olI[i];
                if (imageFileInfo != null) {
                    this.olI[i].applayRotatePageActionToPersistAction(imageFileInfo);
                }
            }
            if (!arC()) {
                if (!z && this.mIsFromIm) {
                    S(this.mBitmap);
                }
            } else if (this.olJ != null && this.olJ.dYm() && this.olP != null && this.olP.ooV != null) {
                this.olP.ooV.djj();
                TbImageView tbImageView = this.olK[this.bMV].acX;
                try {
                    bitmap = this.olP.ooV.ead();
                } catch (OutOfMemoryError e) {
                    bitmap = null;
                }
                if (bitmap != null) {
                    try {
                        bitmap2 = com.baidu.tbadk.util.h.bV(tbImageView);
                    } catch (OutOfMemoryError e2) {
                        TbadkCoreApplication.getInst().onAppMemoryLow();
                        bitmap2 = null;
                        if (bitmap == null) {
                            return;
                        }
                        return;
                    }
                    if (bitmap == null && bitmap2 != null && (a2 = com.baidu.tbadk.util.h.a(bitmap2, bitmap, bitmap2.getWidth(), bitmap2.getHeight())) != null) {
                        this.olI[this.bMV].setFilePath(o.saveFileAsPNG(o.getCacheDir(), String.valueOf(System.currentTimeMillis() + "_sticker.png"), a2, 100));
                        this.olI[this.bMV].setContentUriStr(null);
                        this.olI[this.bMV].clearAllActions();
                        this.olI[this.bMV].clearPageActions();
                        this.olI[this.bMV].setIsGif(false);
                        if (!z && this.mIsFromIm) {
                            S(a2);
                        }
                    }
                }
            } else if (!z && this.mIsFromIm) {
                S(this.mBitmap);
            }
        }
    }

    private void S(Bitmap bitmap) {
        if (bitmap != null && !bitmap.isRecycled()) {
            String str = "tieba" + String.valueOf(new Date().getTime()) + ".jpg";
            if (c(str, bitmap)) {
                this.olI[0].extra = str;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public class b {
        private TbImageView acX;
        private int index;
        private ProgressBar nup;
        private FrameLayout olT;
        private com.baidu.tbadk.img.b olU;

        public b(int i) {
            this.nup = null;
            this.index = -1;
            this.index = i;
            this.olT = (FrameLayout) LayoutInflater.from(MultiImagePagerAdapter.this.olH.getPageContext().getContext()).inflate(R.layout.progress_tb_imageview, (ViewGroup) null);
            this.acX = (TbImageView) this.olT.findViewById(R.id.progress_tb_imageview);
            this.acX.setClickable(true);
            this.acX.setDefaultResource(0);
            this.acX.setDefaultBgResource(0);
            this.acX.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.acX.setPadding(0, 0, 0, 0);
            this.olU = new com.baidu.tbadk.img.b();
            this.acX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (MultiImagePagerAdapter.this.olJ != null) {
                        MultiImagePagerAdapter.this.olJ.dYl();
                    }
                }
            });
            this.nup = (ProgressBar) this.olT.findViewById(R.id.progress_tb_imageview_progress);
            this.nup.setVisibility(8);
        }

        public View getView() {
            return this.olT;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(ImageFileInfo imageFileInfo, com.baidu.adp.widget.ImageView.a aVar) {
            if (aVar != null && this.acX != null) {
                int[] imageResize = l.getImageResize(aVar.getWidth(), aVar.getHeight(), l.getEquipmentWidth(MultiImagePagerAdapter.this.olH), (l.getEquipmentHeight(MultiImagePagerAdapter.this.olH) - l.getDimens(MultiImagePagerAdapter.this.olH, R.dimen.ds418)) - UtilHelper.getStatusBarHeight());
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.acX.getLayoutParams();
                layoutParams.gravity = 17;
                layoutParams.width = imageResize[0];
                layoutParams.height = imageResize[1];
                this.acX.setLayoutParams(layoutParams);
                aVar.drawImageTo(this.acX);
                if (MultiImagePagerAdapter.this.olP != null && MultiImagePagerAdapter.this.olP.ooV != null && imageFileInfo != null) {
                    FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) MultiImagePagerAdapter.this.olP.ooV.getLayoutParams();
                    layoutParams2.gravity = 17;
                    layoutParams2.width = imageResize[0];
                    layoutParams2.height = imageResize[1];
                    MultiImagePagerAdapter.this.olP.ooV.setLayoutParams(layoutParams2);
                }
                if (aVar.getRawBitmap() != null && !aVar.getRawBitmap().isRecycled()) {
                    MultiImagePagerAdapter.this.mBitmap = aVar.getRawBitmap();
                }
            }
        }

        public void k(final ImageFileInfo imageFileInfo) {
            if (imageFileInfo != null) {
                dPC();
                this.nup.setVisibility(0);
                com.baidu.adp.widget.ImageView.a a2 = this.olU.a(imageFileInfo, false);
                if (a2 != null) {
                    a(imageFileInfo, a2);
                    this.nup.setVisibility(8);
                    return;
                }
                this.olU.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.b.2
                    @Override // com.baidu.tbadk.imageManager.b
                    public void a(com.baidu.adp.widget.ImageView.a aVar, String str, boolean z) {
                        b.this.a(imageFileInfo, aVar);
                        b.this.nup.setVisibility(8);
                        if (MultiImagePagerAdapter.this.olP != null) {
                            MultiImagePagerAdapter.this.olP.bWn();
                        }
                    }
                }, false);
            }
        }

        public void dPC() {
            if (this.olU != null) {
                this.olU.cancelAllAsyncTask();
            }
            if (this.acX != null) {
            }
        }

        public boolean dYn() {
            return this.nup.getVisibility() != 0;
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }
}
