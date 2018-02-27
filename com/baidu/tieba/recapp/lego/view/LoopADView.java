package com.baidu.tieba.recapp.lego.view;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.recapp.lego.model.AdCard;
/* loaded from: classes3.dex */
public class LoopADView extends LinearLayout {
    private a gFb;
    private int gFc;
    private int gFd;
    private Resources gFe;
    private AdCard.c[] gFf;
    private int gFg;
    private Context mContext;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public enum ItemType {
        WITH_BOTTOM_TITLE,
        WITHOUT_BOTTOM_TITLE
    }

    /* loaded from: classes3.dex */
    public interface a {
        void b(TbImageView tbImageView, AdCard.b bVar);

        String rR(String str);

        void reset();
    }

    public void setBussinessType(int i) {
        this.gFg = i;
    }

    public LoopADView(Context context) {
        this(context, null);
    }

    public LoopADView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LoopADView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = null;
        this.gFb = null;
        this.gFc = 0;
        this.gFd = 0;
        this.gFe = null;
        this.gFf = null;
        this.mContext = context.getApplicationContext();
        this.gFe = this.mContext.getResources();
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        setLayoutParams(layoutParams);
        setOrientation(0);
    }

    public void a(AdCard.c[] cVarArr, int i, int i2, int i3, int i4) {
        if (cVarArr != null && cVarArr.length > 0 && i3 <= i2 && cVarArr != this.gFf) {
            this.gFf = cVarArr;
            if (i2 == 0 || i3 == 0) {
                if (this.gFg == 2 || this.gFg == 1) {
                    i2 = (int) this.gFe.getDimension(d.e.ds570);
                    i3 = (int) this.gFe.getDimension(d.e.ds302);
                } else if (this.gFg == 4) {
                    i2 = (int) this.gFe.getDimension(d.e.ds500);
                    i3 = (int) this.gFe.getDimension(d.e.ds265);
                }
            }
            b(i2, i3, i4);
            if (this.gFb != null) {
                this.gFb.reset();
            }
            reset();
            a(cVarArr, i);
        }
    }

    private void b(float f, float f2, int i) {
        float f3 = f / f2;
        float f4 = 0.0f;
        if (this.gFg == 1 || this.gFg == 2) {
            f4 = this.gFe.getDimension(d.e.ds40);
        } else if (this.gFg == 4) {
            f4 = this.gFe.getDimension(d.e.ds40) + this.gFe.getDimension(d.e.ds60) + this.gFe.getDimension(d.e.ds16);
        }
        this.gFc = (int) (((int) ((l.as(this.mContext)[0] - f4) - ((int) this.gFe.getDimension(d.e.ds4)))) * 0.75f);
        this.gFd = (int) (this.gFc / f3);
    }

    private void a(AdCard.c[] cVarArr, int i) {
        ItemType itemType;
        boolean z = false;
        if (a(cVarArr)) {
            itemType = ItemType.WITH_BOTTOM_TITLE;
        } else {
            itemType = ItemType.WITHOUT_BOTTOM_TITLE;
        }
        try {
            for (AdCard.c cVar : cVarArr) {
                View inflate = LayoutInflater.from(this.mContext).inflate(d.h.loop_ad_item, (ViewGroup) null);
                if (inflate != null) {
                    if (!z) {
                        inflate.setPadding(0, 0, 0, 0);
                        z = true;
                    }
                    a(inflate, cVar, i, itemType);
                    addView(inflate);
                } else {
                    return;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void a(View view, AdCard.c cVar, int i, ItemType itemType) {
        if (view != null && cVar != null) {
            TbImageView tbImageView = (TbImageView) view.findViewById(d.g.loop_image_view);
            TextView textView = (TextView) view.findViewById(d.g.loop_text_view);
            j(tbImageView, this.gFc, this.gFd);
            j(view, this.gFc, -2);
            if (this.gFb != null) {
                this.gFb.b(tbImageView, cVar.gCX);
            }
            tbImageView.startLoad(cVar.pic, i, false);
            if (itemType == ItemType.WITHOUT_BOTTOM_TITLE) {
                textView.setText("");
                textView.setVisibility(8);
            } else if (itemType == ItemType.WITH_BOTTOM_TITLE) {
                textView.setVisibility(0);
                if (this.gFb != null) {
                    textView.setText(this.gFb.rR(cVar.title));
                }
            }
        }
    }

    private boolean a(AdCard.c[] cVarArr) {
        for (AdCard.c cVar : cVarArr) {
            if (TextUtils.isEmpty(cVar.title)) {
                return false;
            }
        }
        return true;
    }

    public void aNQ() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt != null) {
                aj.e((TextView) childAt.findViewById(d.g.loop_text_view), d.C0141d.cp_cont_b, 1);
            }
        }
    }

    public void setOnClickCallbackListener(a aVar) {
        this.gFb = aVar;
    }

    private void reset() {
        removeAllViews();
    }

    private void j(View view, int i, int i2) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = i;
            layoutParams.height = i2;
            return;
        }
        view.setLayoutParams(new LinearLayout.LayoutParams(i, i2));
    }
}
