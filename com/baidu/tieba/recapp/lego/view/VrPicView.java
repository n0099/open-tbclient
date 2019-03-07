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
    private View btW;
    private g igo;
    private GLTextureView ikK;
    private View ikL;
    private String ikM;
    private int ikN;
    private int ikO;
    private a.b ikP;
    private CustomMessageListener ikQ;
    private b<com.baidu.adp.widget.ImageView.a> mCallback;
    private TbPageContext<?> mPageContext;
    private View mPromptView;

    public VrPicView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.igo = null;
        this.mCallback = new b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.recapp.lego.view.VrPicView.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i2) {
                if (VrPicView.this.ikP == null || aVar == null || aVar.oy() == null) {
                    VrPicView.this.pn(true);
                    return;
                }
                VrPicView.this.po(false);
                Bitmap oy = aVar.oy();
                VrPicView.this.igo.l(oy.getWidth(), oy.getHeight());
                try {
                    VrPicView.this.ikP.d(oy);
                } catch (OutOfMemoryError e) {
                    try {
                        int width = oy.getWidth();
                        int height = oy.getHeight();
                        Bitmap resizeBitmap = BitmapHelper.resizeBitmap(oy, width / 2, height / 2, true);
                        VrPicView.this.igo.l(width / 2, height / 2);
                        VrPicView.this.ikP.d(resizeBitmap);
                    } catch (OutOfMemoryError e2) {
                        VrPicView.this.pn(true);
                    }
                }
            }
        };
        this.ikQ = new CustomMessageListener(2016487) { // from class: com.baidu.tieba.recapp.lego.view.VrPicView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    VrPicView.this.pn(true);
                }
            }
        };
        init(context);
    }

    public VrPicView(Context context) {
        super(context);
        this.igo = null;
        this.mCallback = new b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.recapp.lego.view.VrPicView.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i2) {
                if (VrPicView.this.ikP == null || aVar == null || aVar.oy() == null) {
                    VrPicView.this.pn(true);
                    return;
                }
                VrPicView.this.po(false);
                Bitmap oy = aVar.oy();
                VrPicView.this.igo.l(oy.getWidth(), oy.getHeight());
                try {
                    VrPicView.this.ikP.d(oy);
                } catch (OutOfMemoryError e) {
                    try {
                        int width = oy.getWidth();
                        int height = oy.getHeight();
                        Bitmap resizeBitmap = BitmapHelper.resizeBitmap(oy, width / 2, height / 2, true);
                        VrPicView.this.igo.l(width / 2, height / 2);
                        VrPicView.this.ikP.d(resizeBitmap);
                    } catch (OutOfMemoryError e2) {
                        VrPicView.this.pn(true);
                    }
                }
            }
        };
        this.ikQ = new CustomMessageListener(2016487) { // from class: com.baidu.tieba.recapp.lego.view.VrPicView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    VrPicView.this.pn(true);
                }
            }
        };
        init(context);
    }

    public VrPicView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.igo = null;
        this.mCallback = new b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.recapp.lego.view.VrPicView.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i2) {
                if (VrPicView.this.ikP == null || aVar == null || aVar.oy() == null) {
                    VrPicView.this.pn(true);
                    return;
                }
                VrPicView.this.po(false);
                Bitmap oy = aVar.oy();
                VrPicView.this.igo.l(oy.getWidth(), oy.getHeight());
                try {
                    VrPicView.this.ikP.d(oy);
                } catch (OutOfMemoryError e) {
                    try {
                        int width = oy.getWidth();
                        int height = oy.getHeight();
                        Bitmap resizeBitmap = BitmapHelper.resizeBitmap(oy, width / 2, height / 2, true);
                        VrPicView.this.igo.l(width / 2, height / 2);
                        VrPicView.this.ikP.d(resizeBitmap);
                    } catch (OutOfMemoryError e2) {
                        VrPicView.this.pn(true);
                    }
                }
            }
        };
        this.ikQ = new CustomMessageListener(2016487) { // from class: com.baidu.tieba.recapp.lego.view.VrPicView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    VrPicView.this.pn(true);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        if (MessageManager.getInstance().findTask(2016481) != null) {
            this.btW = LayoutInflater.from(context).inflate(d.h.card_vr_pic_view, (ViewGroup) this, true);
            this.ikK = this.btW.findViewById(d.g.lego_gl_view);
            this.ikL = this.btW.findViewById(d.g.error_tips);
            this.mPromptView = this.btW.findViewById(d.g.loading_img);
        }
    }

    public void a(TbPageContext<?> tbPageContext, AdvertAppInfo advertAppInfo) {
        if (tbPageContext != null && advertAppInfo != null && advertAppInfo.bwL != null) {
            this.mPageContext = tbPageContext;
            this.ikQ.setTag(tbPageContext.getUniqueId());
            tbPageContext.registerListener(this.ikQ);
            this.ikM = advertAppInfo.bwL.bwW;
            if (TextUtils.isEmpty(this.ikM)) {
                this.mPageContext.showToast(d.j.lego_error_url);
                return;
            }
            this.ikN = advertAppInfo.bwL.width;
            this.ikO = advertAppInfo.bwL.height;
            if (this.igo == null) {
                this.igo = g.h(tbPageContext.getPageActivity()).v(101).w(3).a(new g.c() { // from class: com.baidu.tieba.recapp.lego.view.VrPicView.3
                    public void a(a.b bVar) {
                        VrPicView.this.ikP = bVar;
                        VrPicView.this.bXe();
                    }
                }).I(true).b(this.ikK);
                this.igo.onResume(this.mPageContext.getPageActivity());
                return;
            }
            al(this.ikM);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bXe() {
        if (!StringUtils.isNull(this.ikM) && this.ikP != null) {
            pn(false);
            po(true);
            c.jB().a(this.ikM, 10, this.mCallback, this.ikN, this.ikO, this.mPageContext.getUniqueId(), new Object[0]);
        }
    }

    public void al(String str) {
        bXe();
    }

    public void onDestroy() {
        if (this.igo != null) {
            this.igo.onDestroy();
        }
    }

    public void onResume() {
        if (this.igo != null) {
            this.igo.onResume(this.mPageContext.getPageActivity());
        }
    }

    public void onPause() {
        if (this.igo != null) {
            this.igo.onPause(this.mPageContext.getPageActivity());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pn(boolean z) {
        if (z) {
            this.ikL.setVisibility(0);
        } else {
            this.ikL.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void po(boolean z) {
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
