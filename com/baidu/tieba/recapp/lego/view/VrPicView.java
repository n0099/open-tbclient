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
import com.baidu.tieba.e;
import com.baidu.tieba.vr.player.framework.GLTextureView;
/* loaded from: classes3.dex */
public class VrPicView extends RelativeLayout {
    private View adA;
    private g guU;
    private GLTextureView gzs;
    private View gzt;
    private String gzu;
    private int gzv;
    private int gzw;
    private a.b gzx;
    private CustomMessageListener gzy;
    private b<com.baidu.adp.widget.ImageView.a> mCallback;
    private TbPageContext<?> mPageContext;
    private View mPromptView;

    public VrPicView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.guU = null;
        this.mCallback = new b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.recapp.lego.view.VrPicView.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i2) {
                if (VrPicView.this.gzx == null || aVar == null || aVar.oh() == null) {
                    VrPicView.this.me(true);
                    return;
                }
                VrPicView.this.mf(false);
                Bitmap oh = aVar.oh();
                VrPicView.this.guU.i(oh.getWidth(), oh.getHeight());
                try {
                    VrPicView.this.gzx.d(oh);
                } catch (OutOfMemoryError e) {
                    try {
                        int width = oh.getWidth();
                        int height = oh.getHeight();
                        Bitmap resizeBitmap = BitmapHelper.resizeBitmap(oh, width / 2, height / 2, true);
                        VrPicView.this.guU.i(width / 2, height / 2);
                        VrPicView.this.gzx.d(resizeBitmap);
                    } catch (OutOfMemoryError e2) {
                        VrPicView.this.me(true);
                    }
                }
            }
        };
        this.gzy = new CustomMessageListener(2016487) { // from class: com.baidu.tieba.recapp.lego.view.VrPicView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    VrPicView.this.me(true);
                }
            }
        };
        init(context);
    }

    public VrPicView(Context context) {
        super(context);
        this.guU = null;
        this.mCallback = new b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.recapp.lego.view.VrPicView.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i2) {
                if (VrPicView.this.gzx == null || aVar == null || aVar.oh() == null) {
                    VrPicView.this.me(true);
                    return;
                }
                VrPicView.this.mf(false);
                Bitmap oh = aVar.oh();
                VrPicView.this.guU.i(oh.getWidth(), oh.getHeight());
                try {
                    VrPicView.this.gzx.d(oh);
                } catch (OutOfMemoryError e) {
                    try {
                        int width = oh.getWidth();
                        int height = oh.getHeight();
                        Bitmap resizeBitmap = BitmapHelper.resizeBitmap(oh, width / 2, height / 2, true);
                        VrPicView.this.guU.i(width / 2, height / 2);
                        VrPicView.this.gzx.d(resizeBitmap);
                    } catch (OutOfMemoryError e2) {
                        VrPicView.this.me(true);
                    }
                }
            }
        };
        this.gzy = new CustomMessageListener(2016487) { // from class: com.baidu.tieba.recapp.lego.view.VrPicView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    VrPicView.this.me(true);
                }
            }
        };
        init(context);
    }

    public VrPicView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.guU = null;
        this.mCallback = new b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.recapp.lego.view.VrPicView.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i2) {
                if (VrPicView.this.gzx == null || aVar == null || aVar.oh() == null) {
                    VrPicView.this.me(true);
                    return;
                }
                VrPicView.this.mf(false);
                Bitmap oh = aVar.oh();
                VrPicView.this.guU.i(oh.getWidth(), oh.getHeight());
                try {
                    VrPicView.this.gzx.d(oh);
                } catch (OutOfMemoryError e) {
                    try {
                        int width = oh.getWidth();
                        int height = oh.getHeight();
                        Bitmap resizeBitmap = BitmapHelper.resizeBitmap(oh, width / 2, height / 2, true);
                        VrPicView.this.guU.i(width / 2, height / 2);
                        VrPicView.this.gzx.d(resizeBitmap);
                    } catch (OutOfMemoryError e2) {
                        VrPicView.this.me(true);
                    }
                }
            }
        };
        this.gzy = new CustomMessageListener(2016487) { // from class: com.baidu.tieba.recapp.lego.view.VrPicView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    VrPicView.this.me(true);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        if (MessageManager.getInstance().findTask(2016481) != null) {
            this.adA = LayoutInflater.from(context).inflate(e.h.card_vr_pic_view, (ViewGroup) this, true);
            this.gzs = this.adA.findViewById(e.g.lego_gl_view);
            this.gzt = this.adA.findViewById(e.g.error_tips);
            this.mPromptView = this.adA.findViewById(e.g.loading_img);
        }
    }

    public void a(TbPageContext<?> tbPageContext, AdvertAppInfo advertAppInfo) {
        if (tbPageContext != null && advertAppInfo != null && advertAppInfo.agr != null) {
            this.mPageContext = tbPageContext;
            this.gzy.setTag(tbPageContext.getUniqueId());
            tbPageContext.registerListener(this.gzy);
            this.gzu = advertAppInfo.agr.agC;
            if (TextUtils.isEmpty(this.gzu)) {
                this.mPageContext.showToast(e.j.lego_error_url);
                return;
            }
            this.gzv = advertAppInfo.agr.width;
            this.gzw = advertAppInfo.agr.height;
            if (this.guU == null) {
                this.guU = g.h(tbPageContext.getPageActivity()).v(101).w(3).a(new g.c() { // from class: com.baidu.tieba.recapp.lego.view.VrPicView.3
                    public void a(a.b bVar) {
                        VrPicView.this.gzx = bVar;
                        VrPicView.this.bqt();
                    }
                }).u(true).b(this.gzs);
                this.guU.onResume(this.mPageContext.getPageActivity());
                return;
            }
            al(this.gzu);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bqt() {
        if (!StringUtils.isNull(this.gzu) && this.gzx != null) {
            me(false);
            mf(true);
            c.jn().a(this.gzu, 10, this.mCallback, this.gzv, this.gzw, this.mPageContext.getUniqueId(), new Object[0]);
        }
    }

    public void al(String str) {
        bqt();
    }

    public void onDestroy() {
        if (this.guU != null) {
            this.guU.onDestroy();
        }
    }

    public void onResume() {
        if (this.guU != null) {
            this.guU.onResume(this.mPageContext.getPageActivity());
        }
    }

    public void onPause() {
        if (this.guU != null) {
            this.guU.onPause(this.mPageContext.getPageActivity());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void me(boolean z) {
        if (z) {
            this.gzt.setVisibility(0);
        } else {
            this.gzt.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mf(boolean z) {
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
