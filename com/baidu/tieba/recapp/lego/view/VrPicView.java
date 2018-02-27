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
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tieba.d;
import com.baidu.tieba.vr.player.framework.GLTextureView;
/* loaded from: classes3.dex */
public class VrPicView extends RelativeLayout {
    private View Qr;
    private View aHS;
    private com.a.a.g gAZ;
    private GLTextureView gFi;
    private View gFj;
    private String gFk;
    private int gFl;
    private int gFm;
    private a.b gFn;
    private CustomMessageListener gFo;
    private com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a> mCallback;
    private TbPageContext<?> mPageContext;

    public VrPicView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gAZ = null;
        this.mCallback = new com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a>() { // from class: com.baidu.tieba.recapp.lego.view.VrPicView.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onLoaded(com.baidu.adp.widget.a.a aVar, String str, int i2) {
                if (VrPicView.this.gFn == null || aVar == null || aVar.sh() == null) {
                    VrPicView.this.lY(true);
                    return;
                }
                VrPicView.this.lZ(false);
                Bitmap sh = aVar.sh();
                VrPicView.this.gAZ.i(sh.getWidth(), sh.getHeight());
                try {
                    VrPicView.this.gFn.g(sh);
                } catch (OutOfMemoryError e) {
                    try {
                        int width = sh.getWidth();
                        int height = sh.getHeight();
                        Bitmap resizeBitmap = BitmapHelper.resizeBitmap(sh, width / 2, height / 2, true);
                        VrPicView.this.gAZ.i(width / 2, height / 2);
                        VrPicView.this.gFn.g(resizeBitmap);
                    } catch (OutOfMemoryError e2) {
                        VrPicView.this.lY(true);
                    }
                }
            }
        };
        this.gFo = new CustomMessageListener(2016487) { // from class: com.baidu.tieba.recapp.lego.view.VrPicView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    VrPicView.this.lY(true);
                }
            }
        };
        init(context);
    }

    public VrPicView(Context context) {
        super(context);
        this.gAZ = null;
        this.mCallback = new com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a>() { // from class: com.baidu.tieba.recapp.lego.view.VrPicView.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onLoaded(com.baidu.adp.widget.a.a aVar, String str, int i2) {
                if (VrPicView.this.gFn == null || aVar == null || aVar.sh() == null) {
                    VrPicView.this.lY(true);
                    return;
                }
                VrPicView.this.lZ(false);
                Bitmap sh = aVar.sh();
                VrPicView.this.gAZ.i(sh.getWidth(), sh.getHeight());
                try {
                    VrPicView.this.gFn.g(sh);
                } catch (OutOfMemoryError e) {
                    try {
                        int width = sh.getWidth();
                        int height = sh.getHeight();
                        Bitmap resizeBitmap = BitmapHelper.resizeBitmap(sh, width / 2, height / 2, true);
                        VrPicView.this.gAZ.i(width / 2, height / 2);
                        VrPicView.this.gFn.g(resizeBitmap);
                    } catch (OutOfMemoryError e2) {
                        VrPicView.this.lY(true);
                    }
                }
            }
        };
        this.gFo = new CustomMessageListener(2016487) { // from class: com.baidu.tieba.recapp.lego.view.VrPicView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    VrPicView.this.lY(true);
                }
            }
        };
        init(context);
    }

    public VrPicView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gAZ = null;
        this.mCallback = new com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a>() { // from class: com.baidu.tieba.recapp.lego.view.VrPicView.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onLoaded(com.baidu.adp.widget.a.a aVar, String str, int i2) {
                if (VrPicView.this.gFn == null || aVar == null || aVar.sh() == null) {
                    VrPicView.this.lY(true);
                    return;
                }
                VrPicView.this.lZ(false);
                Bitmap sh = aVar.sh();
                VrPicView.this.gAZ.i(sh.getWidth(), sh.getHeight());
                try {
                    VrPicView.this.gFn.g(sh);
                } catch (OutOfMemoryError e) {
                    try {
                        int width = sh.getWidth();
                        int height = sh.getHeight();
                        Bitmap resizeBitmap = BitmapHelper.resizeBitmap(sh, width / 2, height / 2, true);
                        VrPicView.this.gAZ.i(width / 2, height / 2);
                        VrPicView.this.gFn.g(resizeBitmap);
                    } catch (OutOfMemoryError e2) {
                        VrPicView.this.lY(true);
                    }
                }
            }
        };
        this.gFo = new CustomMessageListener(2016487) { // from class: com.baidu.tieba.recapp.lego.view.VrPicView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    VrPicView.this.lY(true);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        if (MessageManager.getInstance().findTask(2016481) != null) {
            this.aHS = LayoutInflater.from(context).inflate(d.h.card_vr_pic_view, (ViewGroup) this, true);
            this.gFi = this.aHS.findViewById(d.g.lego_gl_view);
            this.gFj = this.aHS.findViewById(d.g.error_tips);
            this.Qr = this.aHS.findViewById(d.g.loading_img);
        }
    }

    public void a(TbPageContext<?> tbPageContext, AdvertAppInfo advertAppInfo) {
        if (tbPageContext != null && advertAppInfo != null && advertAppInfo.aKG != null) {
            this.mPageContext = tbPageContext;
            this.gFo.setTag(tbPageContext.getUniqueId());
            tbPageContext.registerListener(this.gFo);
            this.gFk = advertAppInfo.aKG.aKQ;
            if (TextUtils.isEmpty(this.gFk)) {
                this.mPageContext.showToast(d.j.lego_error_url);
                return;
            }
            this.gFl = advertAppInfo.aKG.width;
            this.gFm = advertAppInfo.aKG.height;
            if (this.gAZ == null) {
                this.gAZ = com.a.a.g.f(tbPageContext.getPageActivity()).cl(101).cm(3).a(new g.c() { // from class: com.baidu.tieba.recapp.lego.view.VrPicView.3
                    public void a(a.b bVar) {
                        VrPicView.this.gFn = bVar;
                        VrPicView.this.boB();
                    }
                }).S(true).b(this.gFi);
                this.gAZ.onResume(this.mPageContext.getPageActivity());
                return;
            }
            start(this.gFk);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void boB() {
        if (!StringUtils.isNull(this.gFk) && this.gFn != null) {
            lY(false);
            lZ(true);
            com.baidu.adp.lib.f.c.nm().a(this.gFk, 10, this.mCallback, this.gFl, this.gFm, this.mPageContext.getUniqueId(), new Object[0]);
        }
    }

    public void start(String str) {
        boB();
    }

    public void onDestroy() {
        if (this.gAZ != null) {
            this.gAZ.onDestroy();
        }
    }

    public void onResume() {
        if (this.gAZ != null) {
            this.gAZ.onResume(this.mPageContext.getPageActivity());
        }
    }

    public void onPause() {
        if (this.gAZ != null) {
            this.gAZ.onPause(this.mPageContext.getPageActivity());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lY(boolean z) {
        if (z) {
            this.gFj.setVisibility(0);
        } else {
            this.gFj.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lZ(boolean z) {
        if (z) {
            this.Qr.setVisibility(0);
        } else {
            this.Qr.setVisibility(8);
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
