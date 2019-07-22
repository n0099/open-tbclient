package com.baidu.tieba.recapp.lego.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.a.a.d.a;
import com.a.a.g;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.f.b;
import com.baidu.adp.lib.f.c;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.vr.player.framework.GLTextureView;
/* loaded from: classes3.dex */
public class VrPicView extends RelativeLayout {
    private g iFd;
    private String iJA;
    private int iJB;
    private int iJC;
    private a.b iJD;
    private CustomMessageListener iJE;
    private GLTextureView iJy;
    private View iJz;
    private b<com.baidu.adp.widget.ImageView.a> mCallback;
    private TbPageContext<?> mPageContext;
    private View mPromptView;
    private View mRoot;

    public VrPicView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.iFd = null;
        this.mCallback = new b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.recapp.lego.view.VrPicView.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i2) {
                if (VrPicView.this.iJD == null || aVar == null || aVar.nK() == null) {
                    VrPicView.this.qr(true);
                    return;
                }
                VrPicView.this.qs(false);
                Bitmap nK = aVar.nK();
                VrPicView.this.iFd.l(nK.getWidth(), nK.getHeight());
                try {
                    VrPicView.this.iJD.d(nK);
                } catch (OutOfMemoryError e) {
                    try {
                        int width = nK.getWidth();
                        int height = nK.getHeight();
                        Bitmap resizeBitmap = BitmapHelper.resizeBitmap(nK, width / 2, height / 2, true);
                        VrPicView.this.iFd.l(width / 2, height / 2);
                        VrPicView.this.iJD.d(resizeBitmap);
                    } catch (OutOfMemoryError e2) {
                        VrPicView.this.qr(true);
                    }
                }
            }
        };
        this.iJE = new CustomMessageListener(2016487) { // from class: com.baidu.tieba.recapp.lego.view.VrPicView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    VrPicView.this.qr(true);
                }
            }
        };
        init(context);
    }

    public VrPicView(Context context) {
        super(context);
        this.iFd = null;
        this.mCallback = new b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.recapp.lego.view.VrPicView.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i2) {
                if (VrPicView.this.iJD == null || aVar == null || aVar.nK() == null) {
                    VrPicView.this.qr(true);
                    return;
                }
                VrPicView.this.qs(false);
                Bitmap nK = aVar.nK();
                VrPicView.this.iFd.l(nK.getWidth(), nK.getHeight());
                try {
                    VrPicView.this.iJD.d(nK);
                } catch (OutOfMemoryError e) {
                    try {
                        int width = nK.getWidth();
                        int height = nK.getHeight();
                        Bitmap resizeBitmap = BitmapHelper.resizeBitmap(nK, width / 2, height / 2, true);
                        VrPicView.this.iFd.l(width / 2, height / 2);
                        VrPicView.this.iJD.d(resizeBitmap);
                    } catch (OutOfMemoryError e2) {
                        VrPicView.this.qr(true);
                    }
                }
            }
        };
        this.iJE = new CustomMessageListener(2016487) { // from class: com.baidu.tieba.recapp.lego.view.VrPicView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    VrPicView.this.qr(true);
                }
            }
        };
        init(context);
    }

    public VrPicView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.iFd = null;
        this.mCallback = new b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.recapp.lego.view.VrPicView.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i2) {
                if (VrPicView.this.iJD == null || aVar == null || aVar.nK() == null) {
                    VrPicView.this.qr(true);
                    return;
                }
                VrPicView.this.qs(false);
                Bitmap nK = aVar.nK();
                VrPicView.this.iFd.l(nK.getWidth(), nK.getHeight());
                try {
                    VrPicView.this.iJD.d(nK);
                } catch (OutOfMemoryError e) {
                    try {
                        int width = nK.getWidth();
                        int height = nK.getHeight();
                        Bitmap resizeBitmap = BitmapHelper.resizeBitmap(nK, width / 2, height / 2, true);
                        VrPicView.this.iFd.l(width / 2, height / 2);
                        VrPicView.this.iJD.d(resizeBitmap);
                    } catch (OutOfMemoryError e2) {
                        VrPicView.this.qr(true);
                    }
                }
            }
        };
        this.iJE = new CustomMessageListener(2016487) { // from class: com.baidu.tieba.recapp.lego.view.VrPicView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    VrPicView.this.qr(true);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        if (MessageManager.getInstance().findTask(2016481) != null) {
            this.mRoot = LayoutInflater.from(context).inflate(R.layout.card_vr_pic_view, (ViewGroup) this, true);
            this.iJy = this.mRoot.findViewById(R.id.lego_gl_view);
            this.iJz = this.mRoot.findViewById(R.id.error_tips);
            this.mPromptView = this.mRoot.findViewById(R.id.loading_img);
        }
    }

    public void a(TbPageContext<?> tbPageContext, AdvertAppInfo advertAppInfo) {
        if (tbPageContext != null && advertAppInfo != null && advertAppInfo.bFd != null) {
            this.mPageContext = tbPageContext;
            this.iJE.setTag(tbPageContext.getUniqueId());
            tbPageContext.registerListener(this.iJE);
            this.iJA = advertAppInfo.bFd.bFo;
            if (TextUtils.isEmpty(this.iJA)) {
                this.mPageContext.showToast((int) R.string.lego_error_url);
                return;
            }
            this.iJB = advertAppInfo.bFd.width;
            this.iJC = advertAppInfo.bFd.height;
            if (this.iFd == null) {
                this.iFd = g.k(tbPageContext.getPageActivity()).n(101).o(3).a(new g.c() { // from class: com.baidu.tieba.recapp.lego.view.VrPicView.3
                    public void a(a.b bVar) {
                        VrPicView.this.iJD = bVar;
                        VrPicView.this.cib();
                    }
                }).A(true).b(this.iJy);
                this.iFd.onResume(this.mPageContext.getPageActivity());
                return;
            }
            U(this.iJA);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cib() {
        if (!StringUtils.isNull(this.iJA) && this.iJD != null) {
            qr(false);
            qs(true);
            c.iE().a(this.iJA, 10, this.mCallback, this.iJB, this.iJC, this.mPageContext.getUniqueId(), new Object[0]);
        }
    }

    public void U(String str) {
        cib();
    }

    public void onDestroy() {
        if (this.iFd != null) {
            this.iFd.onDestroy();
        }
    }

    public void onResume() {
        if (this.iFd != null) {
            this.iFd.onResume(this.mPageContext.getPageActivity());
        }
    }

    public void onPause() {
        if (this.iFd != null) {
            this.iFd.onPause(this.mPageContext.getPageActivity());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qr(boolean z) {
        if (z) {
            this.iJz.setVisibility(0);
        } else {
            this.iJz.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qs(boolean z) {
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
