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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.recapp.lego.model.AdCard;
/* loaded from: classes3.dex */
public class LoopADView extends LinearLayout {
    private a ijR;
    private int ijS;
    private int ijT;
    private Resources ijU;
    private AdCard.d[] ijV;
    private int ijW;
    private Context mContext;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public enum ItemType {
        WITH_BOTTOM_TITLE,
        WITHOUT_BOTTOM_TITLE
    }

    /* loaded from: classes3.dex */
    public interface a {
        String BB(String str);

        void b(TbImageView tbImageView, AdCard.b bVar);

        void reset();
    }

    public void setBussinessType(int i) {
        this.ijW = i;
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
        this.ijR = null;
        this.ijS = 0;
        this.ijT = 0;
        this.ijU = null;
        this.ijV = null;
        this.mContext = context.getApplicationContext();
        this.ijU = this.mContext.getResources();
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        setLayoutParams(layoutParams);
        setOrientation(0);
    }

    public void a(AdCard.d[] dVarArr, int i, int i2, int i3, int i4) {
        if (dVarArr != null && dVarArr.length > 0 && i3 <= i2 && dVarArr != this.ijV) {
            this.ijV = dVarArr;
            if (i2 == 0 || i3 == 0) {
                if (this.ijW == 2 || this.ijW == 1) {
                    i2 = (int) this.ijU.getDimension(d.e.ds570);
                    i3 = (int) this.ijU.getDimension(d.e.ds302);
                } else if (this.ijW == 4) {
                    i2 = (int) this.ijU.getDimension(d.e.ds500);
                    i3 = (int) this.ijU.getDimension(d.e.ds265);
                }
            }
            c(i2, i3, i4);
            if (this.ijR != null) {
                this.ijR.reset();
            }
            reset();
            a(dVarArr, i);
        }
    }

    private void c(float f, float f2, int i) {
        float f3 = f / f2;
        float f4 = 0.0f;
        if (this.ijW == 1 || this.ijW == 2) {
            f4 = this.ijU.getDimension(d.e.ds40);
        } else if (this.ijW == 4) {
            f4 = this.ijU.getDimension(d.e.ds40) + this.ijU.getDimension(d.e.ds60) + this.ijU.getDimension(d.e.ds16);
        }
        this.ijS = (int) (((int) ((l.aS(this.mContext)[0] - f4) - ((int) this.ijU.getDimension(d.e.ds4)))) * 0.75f);
        this.ijT = (int) (this.ijS / f3);
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
                View inflate = LayoutInflater.from(this.mContext).inflate(d.h.loop_ad_item, (ViewGroup) null);
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
            TbImageView tbImageView = (TbImageView) view.findViewById(d.g.loop_image_view);
            TextView textView = (TextView) view.findViewById(d.g.loop_text_view);
            j(tbImageView, this.ijS, this.ijT);
            j(view, this.ijS, -2);
            if (this.ijR != null) {
                this.ijR.b(tbImageView, dVar.ihR);
            }
            tbImageView.startLoad(dVar.pic, i, false);
            if (itemType == ItemType.WITHOUT_BOTTOM_TITLE) {
                textView.setText("");
                textView.setVisibility(8);
            } else if (itemType == ItemType.WITH_BOTTOM_TITLE) {
                textView.setVisibility(0);
                if (this.ijR != null) {
                    textView.setText(this.ijR.BB(dVar.title));
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

    public void bxS() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt != null) {
                al.d((TextView) childAt.findViewById(d.g.loop_text_view), d.C0277d.cp_cont_b, 1);
            }
        }
    }

    public void setOnClickCallbackListener(a aVar) {
        this.ijR = aVar;
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
