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
    private View aHT;
    private com.a.a.g gBp;
    private String gFA;
    private int gFB;
    private int gFC;
    private a.b gFD;
    private CustomMessageListener gFE;
    private GLTextureView gFy;
    private View gFz;
    private com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a> mCallback;
    private TbPageContext<?> mPageContext;

    public VrPicView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gBp = null;
        this.mCallback = new com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a>() { // from class: com.baidu.tieba.recapp.lego.view.VrPicView.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onLoaded(com.baidu.adp.widget.a.a aVar, String str, int i2) {
                if (VrPicView.this.gFD == null || aVar == null || aVar.sh() == null) {
                    VrPicView.this.md(true);
                    return;
                }
                VrPicView.this.me(false);
                Bitmap sh = aVar.sh();
                VrPicView.this.gBp.i(sh.getWidth(), sh.getHeight());
                try {
                    VrPicView.this.gFD.g(sh);
                } catch (OutOfMemoryError e) {
                    try {
                        int width = sh.getWidth();
                        int height = sh.getHeight();
                        Bitmap resizeBitmap = BitmapHelper.resizeBitmap(sh, width / 2, height / 2, true);
                        VrPicView.this.gBp.i(width / 2, height / 2);
                        VrPicView.this.gFD.g(resizeBitmap);
                    } catch (OutOfMemoryError e2) {
                        VrPicView.this.md(true);
                    }
                }
            }
        };
        this.gFE = new CustomMessageListener(2016487) { // from class: com.baidu.tieba.recapp.lego.view.VrPicView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    VrPicView.this.md(true);
                }
            }
        };
        init(context);
    }

    public VrPicView(Context context) {
        super(context);
        this.gBp = null;
        this.mCallback = new com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a>() { // from class: com.baidu.tieba.recapp.lego.view.VrPicView.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onLoaded(com.baidu.adp.widget.a.a aVar, String str, int i2) {
                if (VrPicView.this.gFD == null || aVar == null || aVar.sh() == null) {
                    VrPicView.this.md(true);
                    return;
                }
                VrPicView.this.me(false);
                Bitmap sh = aVar.sh();
                VrPicView.this.gBp.i(sh.getWidth(), sh.getHeight());
                try {
                    VrPicView.this.gFD.g(sh);
                } catch (OutOfMemoryError e) {
                    try {
                        int width = sh.getWidth();
                        int height = sh.getHeight();
                        Bitmap resizeBitmap = BitmapHelper.resizeBitmap(sh, width / 2, height / 2, true);
                        VrPicView.this.gBp.i(width / 2, height / 2);
                        VrPicView.this.gFD.g(resizeBitmap);
                    } catch (OutOfMemoryError e2) {
                        VrPicView.this.md(true);
                    }
                }
            }
        };
        this.gFE = new CustomMessageListener(2016487) { // from class: com.baidu.tieba.recapp.lego.view.VrPicView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    VrPicView.this.md(true);
                }
            }
        };
        init(context);
    }

    public VrPicView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gBp = null;
        this.mCallback = new com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a>() { // from class: com.baidu.tieba.recapp.lego.view.VrPicView.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onLoaded(com.baidu.adp.widget.a.a aVar, String str, int i2) {
                if (VrPicView.this.gFD == null || aVar == null || aVar.sh() == null) {
                    VrPicView.this.md(true);
                    return;
                }
                VrPicView.this.me(false);
                Bitmap sh = aVar.sh();
                VrPicView.this.gBp.i(sh.getWidth(), sh.getHeight());
                try {
                    VrPicView.this.gFD.g(sh);
                } catch (OutOfMemoryError e) {
                    try {
                        int width = sh.getWidth();
                        int height = sh.getHeight();
                        Bitmap resizeBitmap = BitmapHelper.resizeBitmap(sh, width / 2, height / 2, true);
                        VrPicView.this.gBp.i(width / 2, height / 2);
                        VrPicView.this.gFD.g(resizeBitmap);
                    } catch (OutOfMemoryError e2) {
                        VrPicView.this.md(true);
                    }
                }
            }
        };
        this.gFE = new CustomMessageListener(2016487) { // from class: com.baidu.tieba.recapp.lego.view.VrPicView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    VrPicView.this.md(true);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        if (MessageManager.getInstance().findTask(2016481) != null) {
            this.aHT = LayoutInflater.from(context).inflate(d.h.card_vr_pic_view, (ViewGroup) this, true);
            this.gFy = this.aHT.findViewById(d.g.lego_gl_view);
            this.gFz = this.aHT.findViewById(d.g.error_tips);
            this.Qr = this.aHT.findViewById(d.g.loading_img);
        }
    }

    public void a(TbPageContext<?> tbPageContext, AdvertAppInfo advertAppInfo) {
        if (tbPageContext != null && advertAppInfo != null && advertAppInfo.aKH != null) {
            this.mPageContext = tbPageContext;
            this.gFE.setTag(tbPageContext.getUniqueId());
            tbPageContext.registerListener(this.gFE);
            this.gFA = advertAppInfo.aKH.aKR;
            if (TextUtils.isEmpty(this.gFA)) {
                this.mPageContext.showToast(d.j.lego_error_url);
                return;
            }
            this.gFB = advertAppInfo.aKH.width;
            this.gFC = advertAppInfo.aKH.height;
            if (this.gBp == null) {
                this.gBp = com.a.a.g.f(tbPageContext.getPageActivity()).cl(101).cm(3).a(new g.c() { // from class: com.baidu.tieba.recapp.lego.view.VrPicView.3
                    public void a(a.b bVar) {
                        VrPicView.this.gFD = bVar;
                        VrPicView.this.boC();
                    }
                }).S(true).b(this.gFy);
                this.gBp.onResume(this.mPageContext.getPageActivity());
                return;
            }
            start(this.gFA);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void boC() {
        if (!StringUtils.isNull(this.gFA) && this.gFD != null) {
            md(false);
            me(true);
            com.baidu.adp.lib.f.c.nm().a(this.gFA, 10, this.mCallback, this.gFB, this.gFC, this.mPageContext.getUniqueId(), new Object[0]);
        }
    }

    public void start(String str) {
        boC();
    }

    public void onDestroy() {
        if (this.gBp != null) {
            this.gBp.onDestroy();
        }
    }

    public void onResume() {
        if (this.gBp != null) {
            this.gBp.onResume(this.mPageContext.getPageActivity());
        }
    }

    public void onPause() {
        if (this.gBp != null) {
            this.gBp.onPause(this.mPageContext.getPageActivity());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void md(boolean z) {
        if (z) {
            this.gFz.setVisibility(0);
        } else {
            this.gFz.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void me(boolean z) {
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
