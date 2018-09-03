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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.f;
import com.baidu.tieba.recapp.lego.model.AdCard;
/* loaded from: classes3.dex */
public class LoopADView extends LinearLayout {
    private a grD;
    private int grE;
    private int grF;
    private Resources grG;
    private AdCard.d[] grH;
    private int grI;
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

        void reset();

        String sR(String str);
    }

    public void setBussinessType(int i) {
        this.grI = i;
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
        this.grD = null;
        this.grE = 0;
        this.grF = 0;
        this.grG = null;
        this.grH = null;
        this.mContext = context.getApplicationContext();
        this.grG = this.mContext.getResources();
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        setLayoutParams(layoutParams);
        setOrientation(0);
    }

    public void a(AdCard.d[] dVarArr, int i, int i2, int i3, int i4) {
        if (dVarArr != null && dVarArr.length > 0 && i3 <= i2 && dVarArr != this.grH) {
            this.grH = dVarArr;
            if (i2 == 0 || i3 == 0) {
                if (this.grI == 2 || this.grI == 1) {
                    i2 = (int) this.grG.getDimension(f.e.ds570);
                    i3 = (int) this.grG.getDimension(f.e.ds302);
                } else if (this.grI == 4) {
                    i2 = (int) this.grG.getDimension(f.e.ds500);
                    i3 = (int) this.grG.getDimension(f.e.ds265);
                }
            }
            b(i2, i3, i4);
            if (this.grD != null) {
                this.grD.reset();
            }
            reset();
            a(dVarArr, i);
        }
    }

    private void b(float f, float f2, int i) {
        float f3 = f / f2;
        float f4 = 0.0f;
        if (this.grI == 1 || this.grI == 2) {
            f4 = this.grG.getDimension(f.e.ds40);
        } else if (this.grI == 4) {
            f4 = this.grG.getDimension(f.e.ds40) + this.grG.getDimension(f.e.ds60) + this.grG.getDimension(f.e.ds16);
        }
        this.grE = (int) (((int) ((l.al(this.mContext)[0] - f4) - ((int) this.grG.getDimension(f.e.ds4)))) * 0.75f);
        this.grF = (int) (this.grE / f3);
    }

    private void a(AdCard.d[] dVarArr, int i) {
        ItemType itemType;
        boolean z = false;
        if (a(dVarArr)) {
            itemType = ItemType.WITH_BOTTOM_TITLE;
        } else {
            itemType = ItemType.WITHOUT_BOTTOM_TITLE;
        }
        try {
            for (AdCard.d dVar : dVarArr) {
                View inflate = LayoutInflater.from(this.mContext).inflate(f.h.loop_ad_item, (ViewGroup) null);
                if (inflate != null) {
                    if (!z) {
                        inflate.setPadding(0, 0, 0, 0);
                        z = true;
                    }
                    a(inflate, dVar, i, itemType);
                    addView(inflate);
                } else {
                    return;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void a(View view, AdCard.d dVar, int i, ItemType itemType) {
        if (view != null && dVar != null) {
            TbImageView tbImageView = (TbImageView) view.findViewById(f.g.loop_image_view);
            TextView textView = (TextView) view.findViewById(f.g.loop_text_view);
            h(tbImageView, this.grE, this.grF);
            h(view, this.grE, -2);
            if (this.grD != null) {
                this.grD.b(tbImageView, dVar.gpA);
            }
            tbImageView.startLoad(dVar.pic, i, false);
            if (itemType == ItemType.WITHOUT_BOTTOM_TITLE) {
                textView.setText("");
                textView.setVisibility(8);
            } else if (itemType == ItemType.WITH_BOTTOM_TITLE) {
                textView.setVisibility(0);
                if (this.grD != null) {
                    textView.setText(this.grD.sR(dVar.title));
                }
            }
        }
    }

    private boolean a(AdCard.d[] dVarArr) {
        for (AdCard.d dVar : dVarArr) {
            if (TextUtils.isEmpty(dVar.title)) {
                return false;
            }
        }
        return true;
    }

    public void aPq() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt != null) {
                am.c((TextView) childAt.findViewById(f.g.loop_text_view), f.d.cp_cont_b, 1);
            }
        }
    }

    public void setOnClickCallbackListener(a aVar) {
        this.grD = aVar;
    }

    private void reset() {
        removeAllViews();
    }

    private void h(View view, int i, int i2) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = i;
            layoutParams.height = i2;
            return;
        }
        view.setLayoutParams(new LinearLayout.LayoutParams(i, i2));
    }
}
