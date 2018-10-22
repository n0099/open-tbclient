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
import com.baidu.tieba.e;
import com.baidu.tieba.vr.player.framework.GLTextureView;
/* loaded from: classes3.dex */
public class VrPicView extends RelativeLayout {
    private View aix;
    private g gCw;
    private GLTextureView gGT;
    private View gGU;
    private String gGV;
    private int gGW;
    private int gGX;
    private a.b gGY;
    private CustomMessageListener gGZ;
    private b<com.baidu.adp.widget.ImageView.a> mCallback;
    private TbPageContext<?> mPageContext;
    private View mPromptView;

    public VrPicView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gCw = null;
        this.mCallback = new b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.recapp.lego.view.VrPicView.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i2) {
                if (VrPicView.this.gGY == null || aVar == null || aVar.os() == null) {
                    VrPicView.this.mw(true);
                    return;
                }
                VrPicView.this.mx(false);
                Bitmap os = aVar.os();
                VrPicView.this.gCw.i(os.getWidth(), os.getHeight());
                try {
                    VrPicView.this.gGY.d(os);
                } catch (OutOfMemoryError e) {
                    try {
                        int width = os.getWidth();
                        int height = os.getHeight();
                        Bitmap resizeBitmap = BitmapHelper.resizeBitmap(os, width / 2, height / 2, true);
                        VrPicView.this.gCw.i(width / 2, height / 2);
                        VrPicView.this.gGY.d(resizeBitmap);
                    } catch (OutOfMemoryError e2) {
                        VrPicView.this.mw(true);
                    }
                }
            }
        };
        this.gGZ = new CustomMessageListener(2016487) { // from class: com.baidu.tieba.recapp.lego.view.VrPicView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    VrPicView.this.mw(true);
                }
            }
        };
        init(context);
    }

    public VrPicView(Context context) {
        super(context);
        this.gCw = null;
        this.mCallback = new b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.recapp.lego.view.VrPicView.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i2) {
                if (VrPicView.this.gGY == null || aVar == null || aVar.os() == null) {
                    VrPicView.this.mw(true);
                    return;
                }
                VrPicView.this.mx(false);
                Bitmap os = aVar.os();
                VrPicView.this.gCw.i(os.getWidth(), os.getHeight());
                try {
                    VrPicView.this.gGY.d(os);
                } catch (OutOfMemoryError e) {
                    try {
                        int width = os.getWidth();
                        int height = os.getHeight();
                        Bitmap resizeBitmap = BitmapHelper.resizeBitmap(os, width / 2, height / 2, true);
                        VrPicView.this.gCw.i(width / 2, height / 2);
                        VrPicView.this.gGY.d(resizeBitmap);
                    } catch (OutOfMemoryError e2) {
                        VrPicView.this.mw(true);
                    }
                }
            }
        };
        this.gGZ = new CustomMessageListener(2016487) { // from class: com.baidu.tieba.recapp.lego.view.VrPicView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    VrPicView.this.mw(true);
                }
            }
        };
        init(context);
    }

    public VrPicView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gCw = null;
        this.mCallback = new b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.recapp.lego.view.VrPicView.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i2) {
                if (VrPicView.this.gGY == null || aVar == null || aVar.os() == null) {
                    VrPicView.this.mw(true);
                    return;
                }
                VrPicView.this.mx(false);
                Bitmap os = aVar.os();
                VrPicView.this.gCw.i(os.getWidth(), os.getHeight());
                try {
                    VrPicView.this.gGY.d(os);
                } catch (OutOfMemoryError e) {
                    try {
                        int width = os.getWidth();
                        int height = os.getHeight();
                        Bitmap resizeBitmap = BitmapHelper.resizeBitmap(os, width / 2, height / 2, true);
                        VrPicView.this.gCw.i(width / 2, height / 2);
                        VrPicView.this.gGY.d(resizeBitmap);
                    } catch (OutOfMemoryError e2) {
                        VrPicView.this.mw(true);
                    }
                }
            }
        };
        this.gGZ = new CustomMessageListener(2016487) { // from class: com.baidu.tieba.recapp.lego.view.VrPicView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    VrPicView.this.mw(true);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        if (MessageManager.getInstance().findTask(2016481) != null) {
            this.aix = LayoutInflater.from(context).inflate(e.h.card_vr_pic_view, (ViewGroup) this, true);
            this.gGT = this.aix.findViewById(e.g.lego_gl_view);
            this.gGU = this.aix.findViewById(e.g.error_tips);
            this.mPromptView = this.aix.findViewById(e.g.loading_img);
        }
    }

    public void a(TbPageContext<?> tbPageContext, AdvertAppInfo advertAppInfo) {
        if (tbPageContext != null && advertAppInfo != null && advertAppInfo.aln != null) {
            this.mPageContext = tbPageContext;
            this.gGZ.setTag(tbPageContext.getUniqueId());
            tbPageContext.registerListener(this.gGZ);
            this.gGV = advertAppInfo.aln.aly;
            if (TextUtils.isEmpty(this.gGV)) {
                this.mPageContext.showToast(e.j.lego_error_url);
                return;
            }
            this.gGW = advertAppInfo.aln.width;
            this.gGX = advertAppInfo.aln.height;
            if (this.gCw == null) {
                this.gCw = g.h(tbPageContext.getPageActivity()).v(101).w(3).a(new g.c() { // from class: com.baidu.tieba.recapp.lego.view.VrPicView.3
                    public void a(a.b bVar) {
                        VrPicView.this.gGY = bVar;
                        VrPicView.this.btI();
                    }
                }).u(true).b(this.gGT);
                this.gCw.onResume(this.mPageContext.getPageActivity());
                return;
            }
            al(this.gGV);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btI() {
        if (!StringUtils.isNull(this.gGV) && this.gGY != null) {
            mw(false);
            mx(true);
            c.jC().a(this.gGV, 10, this.mCallback, this.gGW, this.gGX, this.mPageContext.getUniqueId(), new Object[0]);
        }
    }

    public void al(String str) {
        btI();
    }

    public void onDestroy() {
        if (this.gCw != null) {
            this.gCw.onDestroy();
        }
    }

    public void onResume() {
        if (this.gCw != null) {
            this.gCw.onResume(this.mPageContext.getPageActivity());
        }
    }

    public void onPause() {
        if (this.gCw != null) {
            this.gCw.onPause(this.mPageContext.getPageActivity());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mw(boolean z) {
        if (z) {
            this.gGU.setVisibility(0);
        } else {
            this.gGU.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mx(boolean z) {
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
