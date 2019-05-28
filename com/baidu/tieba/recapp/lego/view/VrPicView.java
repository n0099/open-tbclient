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
    private View bBg;
    private GLTextureView iDf;
    private View iDg;
    private String iDh;
    private int iDi;
    private int iDj;
    private a.b iDk;
    private CustomMessageListener iDl;
    private g iyK;
    private b<com.baidu.adp.widget.ImageView.a> mCallback;
    private TbPageContext<?> mPageContext;
    private View mPromptView;

    public VrPicView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.iyK = null;
        this.mCallback = new b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.recapp.lego.view.VrPicView.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i2) {
                if (VrPicView.this.iDk == null || aVar == null || aVar.ns() == null) {
                    VrPicView.this.qb(true);
                    return;
                }
                VrPicView.this.qc(false);
                Bitmap ns = aVar.ns();
                VrPicView.this.iyK.l(ns.getWidth(), ns.getHeight());
                try {
                    VrPicView.this.iDk.d(ns);
                } catch (OutOfMemoryError e) {
                    try {
                        int width = ns.getWidth();
                        int height = ns.getHeight();
                        Bitmap resizeBitmap = BitmapHelper.resizeBitmap(ns, width / 2, height / 2, true);
                        VrPicView.this.iyK.l(width / 2, height / 2);
                        VrPicView.this.iDk.d(resizeBitmap);
                    } catch (OutOfMemoryError e2) {
                        VrPicView.this.qb(true);
                    }
                }
            }
        };
        this.iDl = new CustomMessageListener(2016487) { // from class: com.baidu.tieba.recapp.lego.view.VrPicView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    VrPicView.this.qb(true);
                }
            }
        };
        init(context);
    }

    public VrPicView(Context context) {
        super(context);
        this.iyK = null;
        this.mCallback = new b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.recapp.lego.view.VrPicView.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i2) {
                if (VrPicView.this.iDk == null || aVar == null || aVar.ns() == null) {
                    VrPicView.this.qb(true);
                    return;
                }
                VrPicView.this.qc(false);
                Bitmap ns = aVar.ns();
                VrPicView.this.iyK.l(ns.getWidth(), ns.getHeight());
                try {
                    VrPicView.this.iDk.d(ns);
                } catch (OutOfMemoryError e) {
                    try {
                        int width = ns.getWidth();
                        int height = ns.getHeight();
                        Bitmap resizeBitmap = BitmapHelper.resizeBitmap(ns, width / 2, height / 2, true);
                        VrPicView.this.iyK.l(width / 2, height / 2);
                        VrPicView.this.iDk.d(resizeBitmap);
                    } catch (OutOfMemoryError e2) {
                        VrPicView.this.qb(true);
                    }
                }
            }
        };
        this.iDl = new CustomMessageListener(2016487) { // from class: com.baidu.tieba.recapp.lego.view.VrPicView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    VrPicView.this.qb(true);
                }
            }
        };
        init(context);
    }

    public VrPicView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.iyK = null;
        this.mCallback = new b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.recapp.lego.view.VrPicView.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i2) {
                if (VrPicView.this.iDk == null || aVar == null || aVar.ns() == null) {
                    VrPicView.this.qb(true);
                    return;
                }
                VrPicView.this.qc(false);
                Bitmap ns = aVar.ns();
                VrPicView.this.iyK.l(ns.getWidth(), ns.getHeight());
                try {
                    VrPicView.this.iDk.d(ns);
                } catch (OutOfMemoryError e) {
                    try {
                        int width = ns.getWidth();
                        int height = ns.getHeight();
                        Bitmap resizeBitmap = BitmapHelper.resizeBitmap(ns, width / 2, height / 2, true);
                        VrPicView.this.iyK.l(width / 2, height / 2);
                        VrPicView.this.iDk.d(resizeBitmap);
                    } catch (OutOfMemoryError e2) {
                        VrPicView.this.qb(true);
                    }
                }
            }
        };
        this.iDl = new CustomMessageListener(2016487) { // from class: com.baidu.tieba.recapp.lego.view.VrPicView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    VrPicView.this.qb(true);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        if (MessageManager.getInstance().findTask(2016481) != null) {
            this.bBg = LayoutInflater.from(context).inflate(R.layout.card_vr_pic_view, (ViewGroup) this, true);
            this.iDf = this.bBg.findViewById(R.id.lego_gl_view);
            this.iDg = this.bBg.findViewById(R.id.error_tips);
            this.mPromptView = this.bBg.findViewById(R.id.loading_img);
        }
    }

    public void a(TbPageContext<?> tbPageContext, AdvertAppInfo advertAppInfo) {
        if (tbPageContext != null && advertAppInfo != null && advertAppInfo.bEc != null) {
            this.mPageContext = tbPageContext;
            this.iDl.setTag(tbPageContext.getUniqueId());
            tbPageContext.registerListener(this.iDl);
            this.iDh = advertAppInfo.bEc.bEn;
            if (TextUtils.isEmpty(this.iDh)) {
                this.mPageContext.showToast((int) R.string.lego_error_url);
                return;
            }
            this.iDi = advertAppInfo.bEc.width;
            this.iDj = advertAppInfo.bEc.height;
            if (this.iyK == null) {
                this.iyK = g.h(tbPageContext.getPageActivity()).n(101).o(3).a(new g.c() { // from class: com.baidu.tieba.recapp.lego.view.VrPicView.3
                    public void a(a.b bVar) {
                        VrPicView.this.iDk = bVar;
                        VrPicView.this.cfj();
                    }
                }).A(true).b(this.iDf);
                this.iyK.onResume(this.mPageContext.getPageActivity());
                return;
            }
            U(this.iDh);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cfj() {
        if (!StringUtils.isNull(this.iDh) && this.iDk != null) {
            qb(false);
            qc(true);
            c.iv().a(this.iDh, 10, this.mCallback, this.iDi, this.iDj, this.mPageContext.getUniqueId(), new Object[0]);
        }
    }

    public void U(String str) {
        cfj();
    }

    public void onDestroy() {
        if (this.iyK != null) {
            this.iyK.onDestroy();
        }
    }

    public void onResume() {
        if (this.iyK != null) {
            this.iyK.onResume(this.mPageContext.getPageActivity());
        }
    }

    public void onPause() {
        if (this.iyK != null) {
            this.iyK.onPause(this.mPageContext.getPageActivity());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qb(boolean z) {
        if (z) {
            this.iDg.setVisibility(0);
        } else {
            this.iDg.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qc(boolean z) {
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
