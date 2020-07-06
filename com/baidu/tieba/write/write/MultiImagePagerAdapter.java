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
import com.baidu.tbadk.core.util.n;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes2.dex */
public class MultiImagePagerAdapter extends PagerAdapter implements ViewPager.OnPageChangeListener {
    private Bitmap mBitmap;
    private int mCount;
    private int mCurrentIndex;
    private boolean mIsFromIm;
    private ViewPager mViewPager;
    private WriteMultiImgsActivity msQ;
    private ImageFileInfo[] msR;
    private a msS;
    private b[] msT;
    private int msU;
    private LinkedList<ImageFileInfo> msV = new LinkedList<>();
    private int msW;
    private int msX;
    private h msY;
    private com.baidu.tbadk.core.dialog.a msZ;

    /* loaded from: classes2.dex */
    public interface a {
        void ai(int i, boolean z);

        void dsG();

        void dsI();

        boolean dsJ();
    }

    public MultiImagePagerAdapter(WriteMultiImgsActivity writeMultiImgsActivity, ViewPager viewPager, LinkedList<ImageFileInfo> linkedList, int i, a aVar, h hVar, boolean z) {
        this.msQ = null;
        this.msR = null;
        this.mViewPager = null;
        this.msS = null;
        this.mCount = 0;
        this.mCurrentIndex = 0;
        this.msT = null;
        this.msW = 120;
        this.msX = 120;
        this.mIsFromIm = z;
        this.msQ = writeMultiImgsActivity;
        this.msY = hVar;
        this.msW = (int) writeMultiImgsActivity.getResources().getDimension(R.dimen.ds720);
        this.msX = (int) writeMultiImgsActivity.getResources().getDimension(R.dimen.ds1280);
        this.mCurrentIndex = b(linkedList, i);
        this.mCount = this.msV.size();
        this.msR = new ImageFileInfo[this.mCount];
        this.msT = new b[this.mCount];
        for (int i2 = 0; i2 < this.mCount; i2++) {
            this.msR[i2] = this.msV.get(i2).cloneWithoutFilterAction(true);
            this.msR[i2].addPageAction(com.baidu.tbadk.img.effect.d.aW(this.msW, this.msX));
            linkedList.set(linkedList.indexOf(this.msV.get(i2)), this.msR[i2]);
            this.msR[i2].mCount = 0;
        }
        this.mViewPager = viewPager;
        this.msS = aVar;
        this.mViewPager.setOffscreenPageLimit(1);
        this.mViewPager.setOnPageChangeListener(this);
    }

    private int b(LinkedList<ImageFileInfo> linkedList, int i) {
        if (linkedList != null && i >= 0 && i < linkedList.size()) {
            this.msV.clear();
            ImageFileInfo imageFileInfo = linkedList.get(i);
            Iterator<ImageFileInfo> it = linkedList.iterator();
            while (it.hasNext()) {
                ImageFileInfo next = it.next();
                if (next != null && next.getImageType() == 0) {
                    this.msV.add(next);
                }
            }
            return this.msV.indexOf(imageFileInfo);
        }
        return i;
    }

    public int dsC() {
        return this.mCurrentIndex;
    }

    private boolean abL() {
        return (this.msT == null || this.mCurrentIndex >= this.msT.length || this.msT[this.mCurrentIndex] == null || this.msR == null || this.mCurrentIndex >= this.msR.length || this.msR[this.mCurrentIndex] == null) ? false : true;
    }

    public boolean dsD() {
        if (this.mCurrentIndex >= this.msR.length || this.msR[this.mCurrentIndex] == null || !this.msR[this.mCurrentIndex].isGif() || this.msR[this.mCurrentIndex].mCount > 0) {
            return false;
        }
        this.msR[this.mCurrentIndex].mCount++;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ah(int i, boolean z) {
        b bVar;
        ImageFileInfo imageFileInfo;
        if (dsD()) {
            if (this.msS != null) {
                this.msS.ai(i, z);
            }
        } else if (z) {
            GT(i);
        } else if (abL() && (bVar = this.msT[this.mCurrentIndex]) != null && (imageFileInfo = this.msR[this.mCurrentIndex]) != null && bVar.dsK()) {
            imageFileInfo.addPageAction(com.baidu.tbadk.img.effect.e.nO(i));
            this.msQ.dtP();
            bVar.l(imageFileInfo);
        }
    }

    private void GT(int i) {
        this.msU = i;
        if (this.msZ == null) {
            this.msZ = new com.baidu.tbadk.core.dialog.a(this.msQ);
            this.msZ.kT(R.string.rorate_tip);
            this.msZ.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (MultiImagePagerAdapter.this.msZ != null) {
                        MultiImagePagerAdapter.this.msZ.dismiss();
                    }
                    MultiImagePagerAdapter.this.msY.mvw.a(new com.baidu.tieba.write.write.sticker.a.c() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.1.1
                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public void dsF() {
                        }

                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public void dsG() {
                            MultiImagePagerAdapter.this.msS.dsG();
                        }

                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public boolean S(Bitmap bitmap) {
                            return false;
                        }

                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public void dsH() {
                        }
                    });
                    MultiImagePagerAdapter.this.ah(MultiImagePagerAdapter.this.msU, false);
                }
            });
            this.msZ.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (MultiImagePagerAdapter.this.msZ != null) {
                        MultiImagePagerAdapter.this.msZ.dismiss();
                    }
                }
            });
            this.msZ.b(this.msQ.getPageContext());
        }
        this.msZ.aUN();
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (this.msT[i] == null) {
            this.msT[i] = new b(i);
        }
        this.mViewPager.addView(this.msT[i].getView());
        return this.msT[i].getView();
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        this.mViewPager.removeView(this.msT[i].getView());
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        this.mCurrentIndex = i;
        dsE();
    }

    private void dsE() {
        if (this.mCurrentIndex >= 0 && this.msT != null && this.mCurrentIndex < this.msT.length && this.mCurrentIndex < this.msR.length && this.msR[this.mCurrentIndex] != null) {
            for (int i = 0; i < this.msT.length; i++) {
                if (this.msT[i] != null) {
                    this.msT[i].djq();
                }
            }
            if (this.msT[this.mCurrentIndex] == null) {
                this.msT[this.mCurrentIndex] = new b(this.mCurrentIndex);
            }
            this.msT[this.mCurrentIndex].l(this.msR[this.mCurrentIndex]);
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
            n.a(TbConfig.LOCAL_PIC_DIR, str, bitmap, 90);
            Bitmap resizeBitmap = BitmapHelper.resizeBitmap(bitmap, 100);
            if (resizeBitmap != null) {
                if (n.a(null, TbConfig.IMAGE_RESIZED_FILE_DISPLAY, resizeBitmap, 85) != null) {
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
    public void vT(boolean z) {
        Bitmap bitmap;
        Bitmap bitmap2;
        Bitmap bitmap3;
        Bitmap a2;
        if (this.msR != null) {
            for (int i = 0; i < this.msR.length; i++) {
                ImageFileInfo imageFileInfo = this.msR[i];
                if (imageFileInfo != null) {
                    this.msR[i].applayRotatePageActionToPersistAction(imageFileInfo);
                }
            }
            if (!abL()) {
                if (!z && this.mIsFromIm) {
                    R(this.mBitmap);
                }
            } else if (this.msS != null && this.msS.dsJ() && this.msY != null && this.msY.mvw != null) {
                this.msY.mvw.cES();
                TbImageView tbImageView = this.msT[this.mCurrentIndex].YP;
                try {
                    bitmap = this.msY.mvw.dus();
                } catch (OutOfMemoryError e) {
                    bitmap = null;
                }
                if (bitmap != null) {
                    try {
                        Bitmap bl = com.baidu.tbadk.util.g.bl(tbImageView);
                        bitmap2 = bitmap;
                        bitmap3 = bl;
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
                        this.msR[this.mCurrentIndex].setFilePath(n.saveFileAsPNG(n.getCacheDir(), String.valueOf(System.currentTimeMillis() + "_sticker.png"), a2, 100));
                        this.msR[this.mCurrentIndex].setContentUriStr(null);
                        this.msR[this.mCurrentIndex].clearAllActions();
                        this.msR[this.mCurrentIndex].clearPageActions();
                        this.msR[this.mCurrentIndex].setIsGif(false);
                        if (!z && this.mIsFromIm) {
                            R(a2);
                        }
                    }
                }
            } else if (!z && this.mIsFromIm) {
                R(this.mBitmap);
            }
        }
    }

    private void R(Bitmap bitmap) {
        if (bitmap != null && !bitmap.isRecycled()) {
            String str = "tieba" + String.valueOf(new Date().getTime()) + ".jpg";
            if (c(str, bitmap)) {
                this.msR[0].extra = str;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class b {
        private TbImageView YP;
        private int index;
        private ProgressBar lBd;
        private FrameLayout mtc;
        private com.baidu.tbadk.img.b mtd;

        public b(int i) {
            this.lBd = null;
            this.index = -1;
            this.index = i;
            this.mtc = (FrameLayout) LayoutInflater.from(MultiImagePagerAdapter.this.msQ.getPageContext().getContext()).inflate(R.layout.progress_tb_imageview, (ViewGroup) null);
            this.YP = (TbImageView) this.mtc.findViewById(R.id.progress_tb_imageview);
            this.YP.setClickable(true);
            this.YP.setDefaultResource(0);
            this.YP.setDefaultErrorResource(0);
            this.YP.setDefaultBgResource(0);
            this.YP.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.YP.setPadding(0, 0, 0, 0);
            this.mtd = new com.baidu.tbadk.img.b();
            this.YP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (MultiImagePagerAdapter.this.msS != null) {
                        MultiImagePagerAdapter.this.msS.dsI();
                    }
                }
            });
            this.lBd = (ProgressBar) this.mtc.findViewById(R.id.progress_tb_imageview_progress);
            this.lBd.setVisibility(8);
        }

        public View getView() {
            return this.mtc;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(ImageFileInfo imageFileInfo, com.baidu.adp.widget.ImageView.a aVar) {
            if (aVar != null && this.YP != null) {
                int[] imageResize = l.getImageResize(aVar.getWidth(), aVar.getHeight(), l.getEquipmentWidth(MultiImagePagerAdapter.this.msQ), (l.getEquipmentHeight(MultiImagePagerAdapter.this.msQ) - l.getDimens(MultiImagePagerAdapter.this.msQ, R.dimen.ds418)) - UtilHelper.getStatusBarHeight());
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.YP.getLayoutParams();
                layoutParams.gravity = 17;
                layoutParams.width = imageResize[0];
                layoutParams.height = imageResize[1];
                this.YP.setLayoutParams(layoutParams);
                aVar.drawImageTo(this.YP);
                if (MultiImagePagerAdapter.this.msY != null && MultiImagePagerAdapter.this.msY.mvw != null && imageFileInfo != null) {
                    FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) MultiImagePagerAdapter.this.msY.mvw.getLayoutParams();
                    layoutParams2.gravity = 17;
                    layoutParams2.width = imageResize[0];
                    layoutParams2.height = imageResize[1];
                    MultiImagePagerAdapter.this.msY.mvw.setLayoutParams(layoutParams2);
                }
                if (aVar.getRawBitmap() != null && !aVar.getRawBitmap().isRecycled()) {
                    MultiImagePagerAdapter.this.mBitmap = aVar.getRawBitmap();
                }
            }
        }

        public void l(final ImageFileInfo imageFileInfo) {
            if (imageFileInfo != null) {
                djq();
                this.lBd.setVisibility(0);
                com.baidu.adp.widget.ImageView.a a = this.mtd.a(imageFileInfo, false);
                if (a != null) {
                    a(imageFileInfo, a);
                    this.lBd.setVisibility(8);
                    return;
                }
                this.mtd.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.b.2
                    @Override // com.baidu.tbadk.imageManager.b
                    public void a(com.baidu.adp.widget.ImageView.a aVar, String str, boolean z) {
                        b.this.a(imageFileInfo, aVar);
                        b.this.lBd.setVisibility(8);
                        if (MultiImagePagerAdapter.this.msY != null) {
                            MultiImagePagerAdapter.this.msY.bxW();
                        }
                    }
                }, false);
            }
        }

        public void djq() {
            if (this.mtd != null) {
                this.mtd.cancelAllAsyncTask();
            }
            if (this.YP != null) {
            }
        }

        public boolean dsK() {
            return this.lBd.getVisibility() != 0;
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }
}
