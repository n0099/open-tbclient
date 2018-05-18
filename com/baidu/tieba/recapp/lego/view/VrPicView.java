package com.baidu.tieba.recapp.lego.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.b.a.d.a;
import com.b.a.g;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.f.b;
import com.baidu.adp.lib.f.c;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tieba.d;
import com.baidu.tieba.vr.player.framework.GLTextureView;
/* loaded from: classes3.dex */
public class VrPicView extends RelativeLayout {
    private View Th;
    private g fXf;
    private GLTextureView gbA;
    private View gbB;
    private String gbC;
    private int gbD;
    private int gbE;
    private a.b gbF;
    private CustomMessageListener gbG;
    private b<com.baidu.adp.widget.ImageView.a> mCallback;
    private TbPageContext<?> mPageContext;
    private View mPromptView;

    public VrPicView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fXf = null;
        this.mCallback = new b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.recapp.lego.view.VrPicView.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i2) {
                if (VrPicView.this.gbF == null || aVar == null || aVar.kl() == null) {
                    VrPicView.this.lE(true);
                    return;
                }
                VrPicView.this.lF(false);
                Bitmap kl = aVar.kl();
                VrPicView.this.fXf.b(kl.getWidth(), kl.getHeight());
                try {
                    VrPicView.this.gbF.d(kl);
                } catch (OutOfMemoryError e) {
                    try {
                        int width = kl.getWidth();
                        int height = kl.getHeight();
                        Bitmap resizeBitmap = BitmapHelper.resizeBitmap(kl, width / 2, height / 2, true);
                        VrPicView.this.fXf.b(width / 2, height / 2);
                        VrPicView.this.gbF.d(resizeBitmap);
                    } catch (OutOfMemoryError e2) {
                        VrPicView.this.lE(true);
                    }
                }
            }
        };
        this.gbG = new CustomMessageListener(2016487) { // from class: com.baidu.tieba.recapp.lego.view.VrPicView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    VrPicView.this.lE(true);
                }
            }
        };
        init(context);
    }

    public VrPicView(Context context) {
        super(context);
        this.fXf = null;
        this.mCallback = new b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.recapp.lego.view.VrPicView.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i2) {
                if (VrPicView.this.gbF == null || aVar == null || aVar.kl() == null) {
                    VrPicView.this.lE(true);
                    return;
                }
                VrPicView.this.lF(false);
                Bitmap kl = aVar.kl();
                VrPicView.this.fXf.b(kl.getWidth(), kl.getHeight());
                try {
                    VrPicView.this.gbF.d(kl);
                } catch (OutOfMemoryError e) {
                    try {
                        int width = kl.getWidth();
                        int height = kl.getHeight();
                        Bitmap resizeBitmap = BitmapHelper.resizeBitmap(kl, width / 2, height / 2, true);
                        VrPicView.this.fXf.b(width / 2, height / 2);
                        VrPicView.this.gbF.d(resizeBitmap);
                    } catch (OutOfMemoryError e2) {
                        VrPicView.this.lE(true);
                    }
                }
            }
        };
        this.gbG = new CustomMessageListener(2016487) { // from class: com.baidu.tieba.recapp.lego.view.VrPicView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    VrPicView.this.lE(true);
                }
            }
        };
        init(context);
    }

    public VrPicView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fXf = null;
        this.mCallback = new b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.recapp.lego.view.VrPicView.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i2) {
                if (VrPicView.this.gbF == null || aVar == null || aVar.kl() == null) {
                    VrPicView.this.lE(true);
                    return;
                }
                VrPicView.this.lF(false);
                Bitmap kl = aVar.kl();
                VrPicView.this.fXf.b(kl.getWidth(), kl.getHeight());
                try {
                    VrPicView.this.gbF.d(kl);
                } catch (OutOfMemoryError e) {
                    try {
                        int width = kl.getWidth();
                        int height = kl.getHeight();
                        Bitmap resizeBitmap = BitmapHelper.resizeBitmap(kl, width / 2, height / 2, true);
                        VrPicView.this.fXf.b(width / 2, height / 2);
                        VrPicView.this.gbF.d(resizeBitmap);
                    } catch (OutOfMemoryError e2) {
                        VrPicView.this.lE(true);
                    }
                }
            }
        };
        this.gbG = new CustomMessageListener(2016487) { // from class: com.baidu.tieba.recapp.lego.view.VrPicView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    VrPicView.this.lE(true);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        if (MessageManager.getInstance().findTask(2016481) != null) {
            this.Th = LayoutInflater.from(context).inflate(d.i.card_vr_pic_view, (ViewGroup) this, true);
            this.gbA = this.Th.findViewById(d.g.lego_gl_view);
            this.gbB = this.Th.findViewById(d.g.error_tips);
            this.mPromptView = this.Th.findViewById(d.g.loading_img);
        }
    }

    public void a(TbPageContext<?> tbPageContext, AdvertAppInfo advertAppInfo) {
        if (tbPageContext != null && advertAppInfo != null && advertAppInfo.VX != null) {
            this.mPageContext = tbPageContext;
            this.gbG.setTag(tbPageContext.getUniqueId());
            tbPageContext.registerListener(this.gbG);
            this.gbC = advertAppInfo.VX.Wh;
            if (TextUtils.isEmpty(this.gbC)) {
                this.mPageContext.showToast(d.k.lego_error_url);
                return;
            }
            this.gbD = advertAppInfo.VX.width;
            this.gbE = advertAppInfo.VX.height;
            if (this.fXf == null) {
                this.fXf = g.f(tbPageContext.getPageActivity()).l(101).m(3).a(new g.c() { // from class: com.baidu.tieba.recapp.lego.view.VrPicView.3
                    public void a(a.b bVar) {
                        VrPicView.this.gbF = bVar;
                        VrPicView.this.bjH();
                    }
                }).k(true).b(this.gbA);
                this.fXf.onResume(this.mPageContext.getPageActivity());
                return;
            }
            start(this.gbC);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bjH() {
        if (!StringUtils.isNull(this.gbC) && this.gbF != null) {
            lE(false);
            lF(true);
            c.fp().a(this.gbC, 10, this.mCallback, this.gbD, this.gbE, this.mPageContext.getUniqueId(), new Object[0]);
        }
    }

    public void start(String str) {
        bjH();
    }

    public void onDestroy() {
        if (this.fXf != null) {
            this.fXf.onDestroy();
        }
    }

    public void onResume() {
        if (this.fXf != null) {
            this.fXf.onResume(this.mPageContext.getPageActivity());
        }
    }

    public void onPause() {
        if (this.fXf != null) {
            this.fXf.onPause(this.mPageContext.getPageActivity());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lE(boolean z) {
        if (z) {
            this.gbB.setVisibility(0);
        } else {
            this.gbB.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lF(boolean z) {
        if (z) {
            this.mPromptView.setVisibility(0);
        } else {
            this.mPromptView.setVisibility(8);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        onDestroy();
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (i == 4 || i == 8) {
            onPause();
        } else if (i == 0) {
            onResume();
        }
    }
}
