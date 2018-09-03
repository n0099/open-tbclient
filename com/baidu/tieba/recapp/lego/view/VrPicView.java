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
import com.baidu.tieba.f;
import com.baidu.tieba.vr.player.framework.GLTextureView;
/* loaded from: classes3.dex */
public class VrPicView extends RelativeLayout {
    private View aaW;
    private g gnC;
    private GLTextureView grY;
    private View grZ;
    private String gsa;
    private int gsb;
    private int gsc;
    private a.b gsd;
    private CustomMessageListener gse;
    private b<com.baidu.adp.widget.ImageView.a> mCallback;
    private TbPageContext<?> mPageContext;
    private View mPromptView;

    public VrPicView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gnC = null;
        this.mCallback = new b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.recapp.lego.view.VrPicView.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i2) {
                if (VrPicView.this.gsd == null || aVar == null || aVar.nb() == null) {
                    VrPicView.this.lF(true);
                    return;
                }
                VrPicView.this.lG(false);
                Bitmap nb = aVar.nb();
                VrPicView.this.gnC.i(nb.getWidth(), nb.getHeight());
                try {
                    VrPicView.this.gsd.c(nb);
                } catch (OutOfMemoryError e) {
                    try {
                        int width = nb.getWidth();
                        int height = nb.getHeight();
                        Bitmap resizeBitmap = BitmapHelper.resizeBitmap(nb, width / 2, height / 2, true);
                        VrPicView.this.gnC.i(width / 2, height / 2);
                        VrPicView.this.gsd.c(resizeBitmap);
                    } catch (OutOfMemoryError e2) {
                        VrPicView.this.lF(true);
                    }
                }
            }
        };
        this.gse = new CustomMessageListener(2016487) { // from class: com.baidu.tieba.recapp.lego.view.VrPicView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    VrPicView.this.lF(true);
                }
            }
        };
        init(context);
    }

    public VrPicView(Context context) {
        super(context);
        this.gnC = null;
        this.mCallback = new b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.recapp.lego.view.VrPicView.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i2) {
                if (VrPicView.this.gsd == null || aVar == null || aVar.nb() == null) {
                    VrPicView.this.lF(true);
                    return;
                }
                VrPicView.this.lG(false);
                Bitmap nb = aVar.nb();
                VrPicView.this.gnC.i(nb.getWidth(), nb.getHeight());
                try {
                    VrPicView.this.gsd.c(nb);
                } catch (OutOfMemoryError e) {
                    try {
                        int width = nb.getWidth();
                        int height = nb.getHeight();
                        Bitmap resizeBitmap = BitmapHelper.resizeBitmap(nb, width / 2, height / 2, true);
                        VrPicView.this.gnC.i(width / 2, height / 2);
                        VrPicView.this.gsd.c(resizeBitmap);
                    } catch (OutOfMemoryError e2) {
                        VrPicView.this.lF(true);
                    }
                }
            }
        };
        this.gse = new CustomMessageListener(2016487) { // from class: com.baidu.tieba.recapp.lego.view.VrPicView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    VrPicView.this.lF(true);
                }
            }
        };
        init(context);
    }

    public VrPicView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gnC = null;
        this.mCallback = new b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.recapp.lego.view.VrPicView.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i2) {
                if (VrPicView.this.gsd == null || aVar == null || aVar.nb() == null) {
                    VrPicView.this.lF(true);
                    return;
                }
                VrPicView.this.lG(false);
                Bitmap nb = aVar.nb();
                VrPicView.this.gnC.i(nb.getWidth(), nb.getHeight());
                try {
                    VrPicView.this.gsd.c(nb);
                } catch (OutOfMemoryError e) {
                    try {
                        int width = nb.getWidth();
                        int height = nb.getHeight();
                        Bitmap resizeBitmap = BitmapHelper.resizeBitmap(nb, width / 2, height / 2, true);
                        VrPicView.this.gnC.i(width / 2, height / 2);
                        VrPicView.this.gsd.c(resizeBitmap);
                    } catch (OutOfMemoryError e2) {
                        VrPicView.this.lF(true);
                    }
                }
            }
        };
        this.gse = new CustomMessageListener(2016487) { // from class: com.baidu.tieba.recapp.lego.view.VrPicView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    VrPicView.this.lF(true);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        if (MessageManager.getInstance().findTask(2016481) != null) {
            this.aaW = LayoutInflater.from(context).inflate(f.h.card_vr_pic_view, (ViewGroup) this, true);
            this.grY = this.aaW.findViewById(f.g.lego_gl_view);
            this.grZ = this.aaW.findViewById(f.g.error_tips);
            this.mPromptView = this.aaW.findViewById(f.g.loading_img);
        }
    }

    public void a(TbPageContext<?> tbPageContext, AdvertAppInfo advertAppInfo) {
        if (tbPageContext != null && advertAppInfo != null && advertAppInfo.adQ != null) {
            this.mPageContext = tbPageContext;
            this.gse.setTag(tbPageContext.getUniqueId());
            tbPageContext.registerListener(this.gse);
            this.gsa = advertAppInfo.adQ.aeb;
            if (TextUtils.isEmpty(this.gsa)) {
                this.mPageContext.showToast(f.j.lego_error_url);
                return;
            }
            this.gsb = advertAppInfo.adQ.width;
            this.gsc = advertAppInfo.adQ.height;
            if (this.gnC == null) {
                this.gnC = g.d(tbPageContext.getPageActivity()).n(101).o(3).a(new g.c() { // from class: com.baidu.tieba.recapp.lego.view.VrPicView.3
                    public void a(a.b bVar) {
                        VrPicView.this.gsd = bVar;
                        VrPicView.this.bnM();
                    }
                }).k(true).b(this.grY);
                this.gnC.onResume(this.mPageContext.getPageActivity());
                return;
            }
            U(this.gsa);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bnM() {
        if (!StringUtils.isNull(this.gsa) && this.gsd != null) {
            lF(false);
            lG(true);
            c.ih().a(this.gsa, 10, this.mCallback, this.gsb, this.gsc, this.mPageContext.getUniqueId(), new Object[0]);
        }
    }

    public void U(String str) {
        bnM();
    }

    public void onDestroy() {
        if (this.gnC != null) {
            this.gnC.onDestroy();
        }
    }

    public void onResume() {
        if (this.gnC != null) {
            this.gnC.onResume(this.mPageContext.getPageActivity());
        }
    }

    public void onPause() {
        if (this.gnC != null) {
            this.gnC.onPause(this.mPageContext.getPageActivity());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lF(boolean z) {
        if (z) {
            this.grZ.setVisibility(0);
        } else {
            this.grZ.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lG(boolean z) {
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
