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
    private WriteMultiImgsActivity msN;
    private ImageFileInfo[] msO;
    private a msP;
    private b[] msQ;
    private int msR;
    private LinkedList<ImageFileInfo> msS = new LinkedList<>();
    private int msT;
    private int msU;
    private h msV;
    private com.baidu.tbadk.core.dialog.a msW;

    /* loaded from: classes2.dex */
    public interface a {
        void ai(int i, boolean z);

        void dsC();

        void dsE();

        boolean dsF();
    }

    public MultiImagePagerAdapter(WriteMultiImgsActivity writeMultiImgsActivity, ViewPager viewPager, LinkedList<ImageFileInfo> linkedList, int i, a aVar, h hVar, boolean z) {
        this.msN = null;
        this.msO = null;
        this.mViewPager = null;
        this.msP = null;
        this.mCount = 0;
        this.mCurrentIndex = 0;
        this.msQ = null;
        this.msT = 120;
        this.msU = 120;
        this.mIsFromIm = z;
        this.msN = writeMultiImgsActivity;
        this.msV = hVar;
        this.msT = (int) writeMultiImgsActivity.getResources().getDimension(R.dimen.ds720);
        this.msU = (int) writeMultiImgsActivity.getResources().getDimension(R.dimen.ds1280);
        this.mCurrentIndex = b(linkedList, i);
        this.mCount = this.msS.size();
        this.msO = new ImageFileInfo[this.mCount];
        this.msQ = new b[this.mCount];
        for (int i2 = 0; i2 < this.mCount; i2++) {
            this.msO[i2] = this.msS.get(i2).cloneWithoutFilterAction(true);
            this.msO[i2].addPageAction(com.baidu.tbadk.img.effect.d.aW(this.msT, this.msU));
            linkedList.set(linkedList.indexOf(this.msS.get(i2)), this.msO[i2]);
            this.msO[i2].mCount = 0;
        }
        this.mViewPager = viewPager;
        this.msP = aVar;
        this.mViewPager.setOffscreenPageLimit(1);
        this.mViewPager.setOnPageChangeListener(this);
    }

    private int b(LinkedList<ImageFileInfo> linkedList, int i) {
        if (linkedList != null && i >= 0 && i < linkedList.size()) {
            this.msS.clear();
            ImageFileInfo imageFileInfo = linkedList.get(i);
            Iterator<ImageFileInfo> it = linkedList.iterator();
            while (it.hasNext()) {
                ImageFileInfo next = it.next();
                if (next != null && next.getImageType() == 0) {
                    this.msS.add(next);
                }
            }
            return this.msS.indexOf(imageFileInfo);
        }
        return i;
    }

    public int dsy() {
        return this.mCurrentIndex;
    }

    private boolean abL() {
        return (this.msQ == null || this.mCurrentIndex >= this.msQ.length || this.msQ[this.mCurrentIndex] == null || this.msO == null || this.mCurrentIndex >= this.msO.length || this.msO[this.mCurrentIndex] == null) ? false : true;
    }

    public boolean dsz() {
        if (this.mCurrentIndex >= this.msO.length || this.msO[this.mCurrentIndex] == null || !this.msO[this.mCurrentIndex].isGif() || this.msO[this.mCurrentIndex].mCount > 0) {
            return false;
        }
        this.msO[this.mCurrentIndex].mCount++;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ah(int i, boolean z) {
        b bVar;
        ImageFileInfo imageFileInfo;
        if (dsz()) {
            if (this.msP != null) {
                this.msP.ai(i, z);
            }
        } else if (z) {
            GT(i);
        } else if (abL() && (bVar = this.msQ[this.mCurrentIndex]) != null && (imageFileInfo = this.msO[this.mCurrentIndex]) != null && bVar.dsG()) {
            imageFileInfo.addPageAction(com.baidu.tbadk.img.effect.e.nO(i));
            this.msN.dtL();
            bVar.l(imageFileInfo);
        }
    }

    private void GT(int i) {
        this.msR = i;
        if (this.msW == null) {
            this.msW = new com.baidu.tbadk.core.dialog.a(this.msN);
            this.msW.kT(R.string.rorate_tip);
            this.msW.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (MultiImagePagerAdapter.this.msW != null) {
                        MultiImagePagerAdapter.this.msW.dismiss();
                    }
                    MultiImagePagerAdapter.this.msV.mvt.a(new com.baidu.tieba.write.write.sticker.a.c() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.1.1
                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public void dsB() {
                        }

                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public void dsC() {
                            MultiImagePagerAdapter.this.msP.dsC();
                        }

                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public boolean S(Bitmap bitmap) {
                            return false;
                        }

                        @Override // com.baidu.tieba.write.write.sticker.a.c
                        public void dsD() {
                        }
                    });
                    MultiImagePagerAdapter.this.ah(MultiImagePagerAdapter.this.msR, false);
                }
            });
            this.msW.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (MultiImagePagerAdapter.this.msW != null) {
                        MultiImagePagerAdapter.this.msW.dismiss();
                    }
                }
            });
            this.msW.b(this.msN.getPageContext());
        }
        this.msW.aUN();
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (this.msQ[i] == null) {
            this.msQ[i] = new b(i);
        }
        this.mViewPager.addView(this.msQ[i].getView());
        return this.msQ[i].getView();
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        this.mViewPager.removeView(this.msQ[i].getView());
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        this.mCurrentIndex = i;
        dsA();
    }

    private void dsA() {
        if (this.mCurrentIndex >= 0 && this.msQ != null && this.mCurrentIndex < this.msQ.length && this.mCurrentIndex < this.msO.length && this.msO[this.mCurrentIndex] != null) {
            for (int i = 0; i < this.msQ.length; i++) {
                if (this.msQ[i] != null) {
                    this.msQ[i].djp();
                }
            }
            if (this.msQ[this.mCurrentIndex] == null) {
                this.msQ[this.mCurrentIndex] = new b(this.mCurrentIndex);
            }
            this.msQ[this.mCurrentIndex].l(this.msO[this.mCurrentIndex]);
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
        if (this.msO != null) {
            for (int i = 0; i < this.msO.length; i++) {
                ImageFileInfo imageFileInfo = this.msO[i];
                if (imageFileInfo != null) {
                    this.msO[i].applayRotatePageActionToPersistAction(imageFileInfo);
                }
            }
            if (!abL()) {
                if (!z && this.mIsFromIm) {
                    R(this.mBitmap);
                }
            } else if (this.msP != null && this.msP.dsF() && this.msV != null && this.msV.mvt != null) {
                this.msV.mvt.cER();
                TbImageView tbImageView = this.msQ[this.mCurrentIndex].YP;
                try {
                    bitmap = this.msV.mvt.duo();
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
                        this.msO[this.mCurrentIndex].setFilePath(n.saveFileAsPNG(n.getCacheDir(), String.valueOf(System.currentTimeMillis() + "_sticker.png"), a2, 100));
                        this.msO[this.mCurrentIndex].setContentUriStr(null);
                        this.msO[this.mCurrentIndex].clearAllActions();
                        this.msO[this.mCurrentIndex].clearPageActions();
                        this.msO[this.mCurrentIndex].setIsGif(false);
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
                this.msO[0].extra = str;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class b {
        private TbImageView YP;
        private int index;
        private ProgressBar lBd;
        private FrameLayout msZ;
        private com.baidu.tbadk.img.b mta;

        public b(int i) {
            this.lBd = null;
            this.index = -1;
            this.index = i;
            this.msZ = (FrameLayout) LayoutInflater.from(MultiImagePagerAdapter.this.msN.getPageContext().getContext()).inflate(R.layout.progress_tb_imageview, (ViewGroup) null);
            this.YP = (TbImageView) this.msZ.findViewById(R.id.progress_tb_imageview);
            this.YP.setClickable(true);
            this.YP.setDefaultResource(0);
            this.YP.setDefaultErrorResource(0);
            this.YP.setDefaultBgResource(0);
            this.YP.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.YP.setPadding(0, 0, 0, 0);
            this.mta = new com.baidu.tbadk.img.b();
            this.YP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (MultiImagePagerAdapter.this.msP != null) {
                        MultiImagePagerAdapter.this.msP.dsE();
                    }
                }
            });
            this.lBd = (ProgressBar) this.msZ.findViewById(R.id.progress_tb_imageview_progress);
            this.lBd.setVisibility(8);
        }

        public View getView() {
            return this.msZ;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(ImageFileInfo imageFileInfo, com.baidu.adp.widget.ImageView.a aVar) {
            if (aVar != null && this.YP != null) {
                int[] imageResize = l.getImageResize(aVar.getWidth(), aVar.getHeight(), l.getEquipmentWidth(MultiImagePagerAdapter.this.msN), (l.getEquipmentHeight(MultiImagePagerAdapter.this.msN) - l.getDimens(MultiImagePagerAdapter.this.msN, R.dimen.ds418)) - UtilHelper.getStatusBarHeight());
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.YP.getLayoutParams();
                layoutParams.gravity = 17;
                layoutParams.width = imageResize[0];
                layoutParams.height = imageResize[1];
                this.YP.setLayoutParams(layoutParams);
                aVar.drawImageTo(this.YP);
                if (MultiImagePagerAdapter.this.msV != null && MultiImagePagerAdapter.this.msV.mvt != null && imageFileInfo != null) {
                    FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) MultiImagePagerAdapter.this.msV.mvt.getLayoutParams();
                    layoutParams2.gravity = 17;
                    layoutParams2.width = imageResize[0];
                    layoutParams2.height = imageResize[1];
                    MultiImagePagerAdapter.this.msV.mvt.setLayoutParams(layoutParams2);
                }
                if (aVar.getRawBitmap() != null && !aVar.getRawBitmap().isRecycled()) {
                    MultiImagePagerAdapter.this.mBitmap = aVar.getRawBitmap();
                }
            }
        }

        public void l(final ImageFileInfo imageFileInfo) {
            if (imageFileInfo != null) {
                djp();
                this.lBd.setVisibility(0);
                com.baidu.adp.widget.ImageView.a a = this.mta.a(imageFileInfo, false);
                if (a != null) {
                    a(imageFileInfo, a);
                    this.lBd.setVisibility(8);
                    return;
                }
                this.mta.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tieba.write.write.MultiImagePagerAdapter.b.2
                    @Override // com.baidu.tbadk.imageManager.b
                    public void a(com.baidu.adp.widget.ImageView.a aVar, String str, boolean z) {
                        b.this.a(imageFileInfo, aVar);
                        b.this.lBd.setVisibility(8);
                        if (MultiImagePagerAdapter.this.msV != null) {
                            MultiImagePagerAdapter.this.msV.bxV();
                        }
                    }
                }, false);
            }
        }

        public void djp() {
            if (this.mta != null) {
                this.mta.cancelAllAsyncTask();
            }
            if (this.YP != null) {
            }
        }

        public boolean dsG() {
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
