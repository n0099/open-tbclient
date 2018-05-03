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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.recapp.lego.model.AdCard;
/* loaded from: classes3.dex */
public class LoopADView extends LinearLayout {
    private a gab;
    private int gac;
    private int gad;
    private Resources gae;
    private AdCard.d[] gaf;
    private int gag;
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

        String rX(String str);

        void reset();
    }

    public void setBussinessType(int i) {
        this.gag = i;
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
        this.gab = null;
        this.gac = 0;
        this.gad = 0;
        this.gae = null;
        this.gaf = null;
        this.mContext = context.getApplicationContext();
        this.gae = this.mContext.getResources();
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        setLayoutParams(layoutParams);
        setOrientation(0);
    }

    public void a(AdCard.d[] dVarArr, int i, int i2, int i3, int i4) {
        if (dVarArr != null && dVarArr.length > 0 && i3 <= i2 && dVarArr != this.gaf) {
            this.gaf = dVarArr;
            if (i2 == 0 || i3 == 0) {
                if (this.gag == 2 || this.gag == 1) {
                    i2 = (int) this.gae.getDimension(d.e.ds570);
                    i3 = (int) this.gae.getDimension(d.e.ds302);
                } else if (this.gag == 4) {
                    i2 = (int) this.gae.getDimension(d.e.ds500);
                    i3 = (int) this.gae.getDimension(d.e.ds265);
                }
            }
            b(i2, i3, i4);
            if (this.gab != null) {
                this.gab.reset();
            }
            reset();
            a(dVarArr, i);
        }
    }

    private void b(float f, float f2, int i) {
        float f3 = f / f2;
        float f4 = 0.0f;
        if (this.gag == 1 || this.gag == 2) {
            f4 = this.gae.getDimension(d.e.ds40);
        } else if (this.gag == 4) {
            f4 = this.gae.getDimension(d.e.ds40) + this.gae.getDimension(d.e.ds60) + this.gae.getDimension(d.e.ds16);
        }
        this.gac = (int) (((int) ((l.aj(this.mContext)[0] - f4) - ((int) this.gae.getDimension(d.e.ds4)))) * 0.75f);
        this.gad = (int) (this.gac / f3);
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
                View inflate = LayoutInflater.from(this.mContext).inflate(d.i.loop_ad_item, (ViewGroup) null);
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

    private void a(View view2, AdCard.d dVar, int i, ItemType itemType) {
        if (view2 != null && dVar != null) {
            TbImageView tbImageView = (TbImageView) view2.findViewById(d.g.loop_image_view);
            TextView textView = (TextView) view2.findViewById(d.g.loop_text_view);
            h(tbImageView, this.gac, this.gad);
            h(view2, this.gac, -2);
            if (this.gab != null) {
                this.gab.b(tbImageView, dVar.fXZ);
            }
            tbImageView.startLoad(dVar.pic, i, false);
            if (itemType == ItemType.WITHOUT_BOTTOM_TITLE) {
                textView.setText("");
                textView.setVisibility(8);
            } else if (itemType == ItemType.WITH_BOTTOM_TITLE) {
                textView.setVisibility(0);
                if (this.gab != null) {
                    textView.setText(this.gab.rX(dVar.title));
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

    public void aIT() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt != null) {
                ak.c((TextView) childAt.findViewById(d.g.loop_text_view), d.C0126d.cp_cont_b, 1);
            }
        }
    }

    public void setOnClickCallbackListener(a aVar) {
        this.gab = aVar;
    }

    private void reset() {
        removeAllViews();
    }

    private void h(View view2, int i, int i2) {
        ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = i;
            layoutParams.height = i2;
            return;
        }
        view2.setLayoutParams(new LinearLayout.LayoutParams(i, i2));
    }
}
