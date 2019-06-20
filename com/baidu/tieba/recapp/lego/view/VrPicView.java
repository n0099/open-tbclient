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
    private GLTextureView iDg;
    private View iDh;
    private String iDi;
    private int iDj;
    private int iDk;
    private a.b iDl;
    private CustomMessageListener iDm;
    private g iyL;
    private b<com.baidu.adp.widget.ImageView.a> mCallback;
    private TbPageContext<?> mPageContext;
    private View mPromptView;

    public VrPicView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.iyL = null;
        this.mCallback = new b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.recapp.lego.view.VrPicView.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i2) {
                if (VrPicView.this.iDl == null || aVar == null || aVar.ns() == null) {
                    VrPicView.this.qc(true);
                    return;
                }
                VrPicView.this.qd(false);
                Bitmap ns = aVar.ns();
                VrPicView.this.iyL.l(ns.getWidth(), ns.getHeight());
                try {
                    VrPicView.this.iDl.d(ns);
                } catch (OutOfMemoryError e) {
                    try {
                        int width = ns.getWidth();
                        int height = ns.getHeight();
                        Bitmap resizeBitmap = BitmapHelper.resizeBitmap(ns, width / 2, height / 2, true);
                        VrPicView.this.iyL.l(width / 2, height / 2);
                        VrPicView.this.iDl.d(resizeBitmap);
                    } catch (OutOfMemoryError e2) {
                        VrPicView.this.qc(true);
                    }
                }
            }
        };
        this.iDm = new CustomMessageListener(2016487) { // from class: com.baidu.tieba.recapp.lego.view.VrPicView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    VrPicView.this.qc(true);
                }
            }
        };
        init(context);
    }

    public VrPicView(Context context) {
        super(context);
        this.iyL = null;
        this.mCallback = new b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.recapp.lego.view.VrPicView.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i2) {
                if (VrPicView.this.iDl == null || aVar == null || aVar.ns() == null) {
                    VrPicView.this.qc(true);
                    return;
                }
                VrPicView.this.qd(false);
                Bitmap ns = aVar.ns();
                VrPicView.this.iyL.l(ns.getWidth(), ns.getHeight());
                try {
                    VrPicView.this.iDl.d(ns);
                } catch (OutOfMemoryError e) {
                    try {
                        int width = ns.getWidth();
                        int height = ns.getHeight();
                        Bitmap resizeBitmap = BitmapHelper.resizeBitmap(ns, width / 2, height / 2, true);
                        VrPicView.this.iyL.l(width / 2, height / 2);
                        VrPicView.this.iDl.d(resizeBitmap);
                    } catch (OutOfMemoryError e2) {
                        VrPicView.this.qc(true);
                    }
                }
            }
        };
        this.iDm = new CustomMessageListener(2016487) { // from class: com.baidu.tieba.recapp.lego.view.VrPicView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    VrPicView.this.qc(true);
                }
            }
        };
        init(context);
    }

    public VrPicView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.iyL = null;
        this.mCallback = new b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.recapp.lego.view.VrPicView.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i2) {
                if (VrPicView.this.iDl == null || aVar == null || aVar.ns() == null) {
                    VrPicView.this.qc(true);
                    return;
                }
                VrPicView.this.qd(false);
                Bitmap ns = aVar.ns();
                VrPicView.this.iyL.l(ns.getWidth(), ns.getHeight());
                try {
                    VrPicView.this.iDl.d(ns);
                } catch (OutOfMemoryError e) {
                    try {
                        int width = ns.getWidth();
                        int height = ns.getHeight();
                        Bitmap resizeBitmap = BitmapHelper.resizeBitmap(ns, width / 2, height / 2, true);
                        VrPicView.this.iyL.l(width / 2, height / 2);
                        VrPicView.this.iDl.d(resizeBitmap);
                    } catch (OutOfMemoryError e2) {
                        VrPicView.this.qc(true);
                    }
                }
            }
        };
        this.iDm = new CustomMessageListener(2016487) { // from class: com.baidu.tieba.recapp.lego.view.VrPicView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    VrPicView.this.qc(true);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        if (MessageManager.getInstance().findTask(2016481) != null) {
            this.bBg = LayoutInflater.from(context).inflate(R.layout.card_vr_pic_view, (ViewGroup) this, true);
            this.iDg = this.bBg.findViewById(R.id.lego_gl_view);
            this.iDh = this.bBg.findViewById(R.id.error_tips);
            this.mPromptView = this.bBg.findViewById(R.id.loading_img);
        }
    }

    public void a(TbPageContext<?> tbPageContext, AdvertAppInfo advertAppInfo) {
        if (tbPageContext != null && advertAppInfo != null && advertAppInfo.bEd != null) {
            this.mPageContext = tbPageContext;
            this.iDm.setTag(tbPageContext.getUniqueId());
            tbPageContext.registerListener(this.iDm);
            this.iDi = advertAppInfo.bEd.bEo;
            if (TextUtils.isEmpty(this.iDi)) {
                this.mPageContext.showToast((int) R.string.lego_error_url);
                return;
            }
            this.iDj = advertAppInfo.bEd.width;
            this.iDk = advertAppInfo.bEd.height;
            if (this.iyL == null) {
                this.iyL = g.h(tbPageContext.getPageActivity()).n(101).o(3).a(new g.c() { // from class: com.baidu.tieba.recapp.lego.view.VrPicView.3
                    public void a(a.b bVar) {
                        VrPicView.this.iDl = bVar;
                        VrPicView.this.cfk();
                    }
                }).A(true).b(this.iDg);
                this.iyL.onResume(this.mPageContext.getPageActivity());
                return;
            }
            U(this.iDi);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cfk() {
        if (!StringUtils.isNull(this.iDi) && this.iDl != null) {
            qc(false);
            qd(true);
            c.iv().a(this.iDi, 10, this.mCallback, this.iDj, this.iDk, this.mPageContext.getUniqueId(), new Object[0]);
        }
    }

    public void U(String str) {
        cfk();
    }

    public void onDestroy() {
        if (this.iyL != null) {
            this.iyL.onDestroy();
        }
    }

    public void onResume() {
        if (this.iyL != null) {
            this.iyL.onResume(this.mPageContext.getPageActivity());
        }
    }

    public void onPause() {
        if (this.iyL != null) {
            this.iyL.onPause(this.mPageContext.getPageActivity());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qc(boolean z) {
        if (z) {
            this.iDh.setVisibility(0);
        } else {
            this.iDh.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qd(boolean z) {
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
