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
    private View abt;
    private g gmp;
    private GLTextureView gqJ;
    private View gqK;
    private String gqL;
    private int gqM;
    private int gqN;
    private a.b gqO;
    private CustomMessageListener gqP;
    private b<com.baidu.adp.widget.ImageView.a> mCallback;
    private TbPageContext<?> mPageContext;
    private View mPromptView;

    public VrPicView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gmp = null;
        this.mCallback = new b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.recapp.lego.view.VrPicView.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i2) {
                if (VrPicView.this.gqO == null || aVar == null || aVar.mZ() == null) {
                    VrPicView.this.lU(true);
                    return;
                }
                VrPicView.this.lV(false);
                Bitmap mZ = aVar.mZ();
                VrPicView.this.gmp.i(mZ.getWidth(), mZ.getHeight());
                try {
                    VrPicView.this.gqO.c(mZ);
                } catch (OutOfMemoryError e) {
                    try {
                        int width = mZ.getWidth();
                        int height = mZ.getHeight();
                        Bitmap resizeBitmap = BitmapHelper.resizeBitmap(mZ, width / 2, height / 2, true);
                        VrPicView.this.gmp.i(width / 2, height / 2);
                        VrPicView.this.gqO.c(resizeBitmap);
                    } catch (OutOfMemoryError e2) {
                        VrPicView.this.lU(true);
                    }
                }
            }
        };
        this.gqP = new CustomMessageListener(2016487) { // from class: com.baidu.tieba.recapp.lego.view.VrPicView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    VrPicView.this.lU(true);
                }
            }
        };
        init(context);
    }

    public VrPicView(Context context) {
        super(context);
        this.gmp = null;
        this.mCallback = new b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.recapp.lego.view.VrPicView.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i2) {
                if (VrPicView.this.gqO == null || aVar == null || aVar.mZ() == null) {
                    VrPicView.this.lU(true);
                    return;
                }
                VrPicView.this.lV(false);
                Bitmap mZ = aVar.mZ();
                VrPicView.this.gmp.i(mZ.getWidth(), mZ.getHeight());
                try {
                    VrPicView.this.gqO.c(mZ);
                } catch (OutOfMemoryError e) {
                    try {
                        int width = mZ.getWidth();
                        int height = mZ.getHeight();
                        Bitmap resizeBitmap = BitmapHelper.resizeBitmap(mZ, width / 2, height / 2, true);
                        VrPicView.this.gmp.i(width / 2, height / 2);
                        VrPicView.this.gqO.c(resizeBitmap);
                    } catch (OutOfMemoryError e2) {
                        VrPicView.this.lU(true);
                    }
                }
            }
        };
        this.gqP = new CustomMessageListener(2016487) { // from class: com.baidu.tieba.recapp.lego.view.VrPicView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    VrPicView.this.lU(true);
                }
            }
        };
        init(context);
    }

    public VrPicView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gmp = null;
        this.mCallback = new b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.recapp.lego.view.VrPicView.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i2) {
                if (VrPicView.this.gqO == null || aVar == null || aVar.mZ() == null) {
                    VrPicView.this.lU(true);
                    return;
                }
                VrPicView.this.lV(false);
                Bitmap mZ = aVar.mZ();
                VrPicView.this.gmp.i(mZ.getWidth(), mZ.getHeight());
                try {
                    VrPicView.this.gqO.c(mZ);
                } catch (OutOfMemoryError e) {
                    try {
                        int width = mZ.getWidth();
                        int height = mZ.getHeight();
                        Bitmap resizeBitmap = BitmapHelper.resizeBitmap(mZ, width / 2, height / 2, true);
                        VrPicView.this.gmp.i(width / 2, height / 2);
                        VrPicView.this.gqO.c(resizeBitmap);
                    } catch (OutOfMemoryError e2) {
                        VrPicView.this.lU(true);
                    }
                }
            }
        };
        this.gqP = new CustomMessageListener(2016487) { // from class: com.baidu.tieba.recapp.lego.view.VrPicView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    VrPicView.this.lU(true);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        if (MessageManager.getInstance().findTask(2016481) != null) {
            this.abt = LayoutInflater.from(context).inflate(d.i.card_vr_pic_view, (ViewGroup) this, true);
            this.gqJ = this.abt.findViewById(d.g.lego_gl_view);
            this.gqK = this.abt.findViewById(d.g.error_tips);
            this.mPromptView = this.abt.findViewById(d.g.loading_img);
        }
    }

    public void a(TbPageContext<?> tbPageContext, AdvertAppInfo advertAppInfo) {
        if (tbPageContext != null && advertAppInfo != null && advertAppInfo.aem != null) {
            this.mPageContext = tbPageContext;
            this.gqP.setTag(tbPageContext.getUniqueId());
            tbPageContext.registerListener(this.gqP);
            this.gqL = advertAppInfo.aem.aex;
            if (TextUtils.isEmpty(this.gqL)) {
                this.mPageContext.showToast(d.k.lego_error_url);
                return;
            }
            this.gqM = advertAppInfo.aem.width;
            this.gqN = advertAppInfo.aem.height;
            if (this.gmp == null) {
                this.gmp = g.e(tbPageContext.getPageActivity()).n(101).o(3).a(new g.c() { // from class: com.baidu.tieba.recapp.lego.view.VrPicView.3
                    public void a(a.b bVar) {
                        VrPicView.this.gqO = bVar;
                        VrPicView.this.bph();
                    }
                }).m(true).b(this.gqJ);
                this.gmp.onResume(this.mPageContext.getPageActivity());
                return;
            }
            start(this.gqL);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bph() {
        if (!StringUtils.isNull(this.gqL) && this.gqO != null) {
            lU(false);
            lV(true);
            c.ig().a(this.gqL, 10, this.mCallback, this.gqM, this.gqN, this.mPageContext.getUniqueId(), new Object[0]);
        }
    }

    public void start(String str) {
        bph();
    }

    public void onDestroy() {
        if (this.gmp != null) {
            this.gmp.onDestroy();
        }
    }

    public void onResume() {
        if (this.gmp != null) {
            this.gmp.onResume(this.mPageContext.getPageActivity());
        }
    }

    public void onPause() {
        if (this.gmp != null) {
            this.gmp.onPause(this.mPageContext.getPageActivity());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lU(boolean z) {
        if (z) {
            this.gqK.setVisibility(0);
        } else {
            this.gqK.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lV(boolean z) {
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
