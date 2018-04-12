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
    private a gae;
    private int gaf;
    private int gag;
    private Resources gah;
    private AdCard.d[] gai;
    private int gaj;
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
        this.gaj = i;
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
        this.gae = null;
        this.gaf = 0;
        this.gag = 0;
        this.gah = null;
        this.gai = null;
        this.mContext = context.getApplicationContext();
        this.gah = this.mContext.getResources();
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        setLayoutParams(layoutParams);
        setOrientation(0);
    }

    public void a(AdCard.d[] dVarArr, int i, int i2, int i3, int i4) {
        if (dVarArr != null && dVarArr.length > 0 && i3 <= i2 && dVarArr != this.gai) {
            this.gai = dVarArr;
            if (i2 == 0 || i3 == 0) {
                if (this.gaj == 2 || this.gaj == 1) {
                    i2 = (int) this.gah.getDimension(d.e.ds570);
                    i3 = (int) this.gah.getDimension(d.e.ds302);
                } else if (this.gaj == 4) {
                    i2 = (int) this.gah.getDimension(d.e.ds500);
                    i3 = (int) this.gah.getDimension(d.e.ds265);
                }
            }
            b(i2, i3, i4);
            if (this.gae != null) {
                this.gae.reset();
            }
            reset();
            a(dVarArr, i);
        }
    }

    private void b(float f, float f2, int i) {
        float f3 = f / f2;
        float f4 = 0.0f;
        if (this.gaj == 1 || this.gaj == 2) {
            f4 = this.gah.getDimension(d.e.ds40);
        } else if (this.gaj == 4) {
            f4 = this.gah.getDimension(d.e.ds40) + this.gah.getDimension(d.e.ds60) + this.gah.getDimension(d.e.ds16);
        }
        this.gaf = (int) (((int) ((l.aj(this.mContext)[0] - f4) - ((int) this.gah.getDimension(d.e.ds4)))) * 0.75f);
        this.gag = (int) (this.gaf / f3);
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
            h(tbImageView, this.gaf, this.gag);
            h(view2, this.gaf, -2);
            if (this.gae != null) {
                this.gae.b(tbImageView, dVar.fYc);
            }
            tbImageView.startLoad(dVar.pic, i, false);
            if (itemType == ItemType.WITHOUT_BOTTOM_TITLE) {
                textView.setText("");
                textView.setVisibility(8);
            } else if (itemType == ItemType.WITH_BOTTOM_TITLE) {
                textView.setVisibility(0);
                if (this.gae != null) {
                    textView.setText(this.gae.rX(dVar.title));
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
        this.gae = aVar;
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
