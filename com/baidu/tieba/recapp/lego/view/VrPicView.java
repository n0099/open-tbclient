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
import com.baidu.tieba.d;
import com.baidu.tieba.vr.player.framework.GLTextureView;
/* loaded from: classes3.dex */
public class VrPicView extends RelativeLayout {
    private View aaV;
    private g gnz;
    private GLTextureView grV;
    private View grW;
    private String grX;
    private int grY;
    private int grZ;
    private a.b gsa;
    private CustomMessageListener gsb;
    private b<com.baidu.adp.widget.ImageView.a> mCallback;
    private TbPageContext<?> mPageContext;
    private View mPromptView;

    public VrPicView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gnz = null;
        this.mCallback = new b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.recapp.lego.view.VrPicView.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i2) {
                if (VrPicView.this.gsa == null || aVar == null || aVar.nb() == null) {
                    VrPicView.this.lF(true);
                    return;
                }
                VrPicView.this.lG(false);
                Bitmap nb = aVar.nb();
                VrPicView.this.gnz.i(nb.getWidth(), nb.getHeight());
                try {
                    VrPicView.this.gsa.c(nb);
                } catch (OutOfMemoryError e) {
                    try {
                        int width = nb.getWidth();
                        int height = nb.getHeight();
                        Bitmap resizeBitmap = BitmapHelper.resizeBitmap(nb, width / 2, height / 2, true);
                        VrPicView.this.gnz.i(width / 2, height / 2);
                        VrPicView.this.gsa.c(resizeBitmap);
                    } catch (OutOfMemoryError e2) {
                        VrPicView.this.lF(true);
                    }
                }
            }
        };
        this.gsb = new CustomMessageListener(2016487) { // from class: com.baidu.tieba.recapp.lego.view.VrPicView.2
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
        this.gnz = null;
        this.mCallback = new b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.recapp.lego.view.VrPicView.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i2) {
                if (VrPicView.this.gsa == null || aVar == null || aVar.nb() == null) {
                    VrPicView.this.lF(true);
                    return;
                }
                VrPicView.this.lG(false);
                Bitmap nb = aVar.nb();
                VrPicView.this.gnz.i(nb.getWidth(), nb.getHeight());
                try {
                    VrPicView.this.gsa.c(nb);
                } catch (OutOfMemoryError e) {
                    try {
                        int width = nb.getWidth();
                        int height = nb.getHeight();
                        Bitmap resizeBitmap = BitmapHelper.resizeBitmap(nb, width / 2, height / 2, true);
                        VrPicView.this.gnz.i(width / 2, height / 2);
                        VrPicView.this.gsa.c(resizeBitmap);
                    } catch (OutOfMemoryError e2) {
                        VrPicView.this.lF(true);
                    }
                }
            }
        };
        this.gsb = new CustomMessageListener(2016487) { // from class: com.baidu.tieba.recapp.lego.view.VrPicView.2
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
        this.gnz = null;
        this.mCallback = new b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.recapp.lego.view.VrPicView.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i2) {
                if (VrPicView.this.gsa == null || aVar == null || aVar.nb() == null) {
                    VrPicView.this.lF(true);
                    return;
                }
                VrPicView.this.lG(false);
                Bitmap nb = aVar.nb();
                VrPicView.this.gnz.i(nb.getWidth(), nb.getHeight());
                try {
                    VrPicView.this.gsa.c(nb);
                } catch (OutOfMemoryError e) {
                    try {
                        int width = nb.getWidth();
                        int height = nb.getHeight();
                        Bitmap resizeBitmap = BitmapHelper.resizeBitmap(nb, width / 2, height / 2, true);
                        VrPicView.this.gnz.i(width / 2, height / 2);
                        VrPicView.this.gsa.c(resizeBitmap);
                    } catch (OutOfMemoryError e2) {
                        VrPicView.this.lF(true);
                    }
                }
            }
        };
        this.gsb = new CustomMessageListener(2016487) { // from class: com.baidu.tieba.recapp.lego.view.VrPicView.2
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
            this.aaV = LayoutInflater.from(context).inflate(d.h.card_vr_pic_view, (ViewGroup) this, true);
            this.grV = this.aaV.findViewById(d.g.lego_gl_view);
            this.grW = this.aaV.findViewById(d.g.error_tips);
            this.mPromptView = this.aaV.findViewById(d.g.loading_img);
        }
    }

    public void a(TbPageContext<?> tbPageContext, AdvertAppInfo advertAppInfo) {
        if (tbPageContext != null && advertAppInfo != null && advertAppInfo.adQ != null) {
            this.mPageContext = tbPageContext;
            this.gsb.setTag(tbPageContext.getUniqueId());
            tbPageContext.registerListener(this.gsb);
            this.grX = advertAppInfo.adQ.aeb;
            if (TextUtils.isEmpty(this.grX)) {
                this.mPageContext.showToast(d.j.lego_error_url);
                return;
            }
            this.grY = advertAppInfo.adQ.width;
            this.grZ = advertAppInfo.adQ.height;
            if (this.gnz == null) {
                this.gnz = g.e(tbPageContext.getPageActivity()).n(101).o(3).a(new g.c() { // from class: com.baidu.tieba.recapp.lego.view.VrPicView.3
                    public void a(a.b bVar) {
                        VrPicView.this.gsa = bVar;
                        VrPicView.this.bnL();
                    }
                }).k(true).b(this.grV);
                this.gnz.onResume(this.mPageContext.getPageActivity());
                return;
            }
            U(this.grX);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bnL() {
        if (!StringUtils.isNull(this.grX) && this.gsa != null) {
            lF(false);
            lG(true);
            c.ih().a(this.grX, 10, this.mCallback, this.grY, this.grZ, this.mPageContext.getUniqueId(), new Object[0]);
        }
    }

    public void U(String str) {
        bnL();
    }

    public void onDestroy() {
        if (this.gnz != null) {
            this.gnz.onDestroy();
        }
    }

    public void onResume() {
        if (this.gnz != null) {
            this.gnz.onResume(this.mPageContext.getPageActivity());
        }
    }

    public void onPause() {
        if (this.gnz != null) {
            this.gnz.onPause(this.mPageContext.getPageActivity());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lF(boolean z) {
        if (z) {
            this.grW.setVisibility(0);
        } else {
            this.grW.setVisibility(8);
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
