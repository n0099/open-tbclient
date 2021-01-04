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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.recapp.lego.model.AdCard;
/* loaded from: classes8.dex */
public class LoopADView extends LinearLayout {
    private Context mContext;
    private a mQc;
    private int mQd;
    private int mQe;
    private AdCard.d[] mQf;
    private int mQg;
    private Resources resources;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public enum ItemType {
        WITH_BOTTOM_TITLE,
        WITHOUT_BOTTOM_TITLE
    }

    /* loaded from: classes8.dex */
    public interface a {
        String RI(String str);

        void b(TbImageView tbImageView, AdCard.b bVar);

        void reset();
    }

    public void setBussinessType(int i) {
        this.mQg = i;
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
        this.mQc = null;
        this.mQd = 0;
        this.mQe = 0;
        this.resources = null;
        this.mQf = null;
        this.mContext = context.getApplicationContext();
        this.resources = this.mContext.getResources();
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        setLayoutParams(layoutParams);
        setOrientation(0);
    }

    public void a(AdCard.d[] dVarArr, int i, int i2, int i3, int i4) {
        if (dVarArr != null && dVarArr.length > 0 && i3 <= i2 && dVarArr != this.mQf) {
            this.mQf = dVarArr;
            if (i2 == 0 || i3 == 0) {
                if (this.mQg == 2 || this.mQg == 1) {
                    i2 = (int) this.resources.getDimension(R.dimen.ds570);
                    i3 = (int) this.resources.getDimension(R.dimen.ds302);
                } else if (this.mQg == 4) {
                    i2 = (int) this.resources.getDimension(R.dimen.ds500);
                    i3 = (int) this.resources.getDimension(R.dimen.ds265);
                }
            }
            c(i2, i3, i4);
            if (this.mQc != null) {
                this.mQc.reset();
            }
            reset();
            a(dVarArr, i);
        }
    }

    private void c(float f, float f2, int i) {
        float f3 = f / f2;
        float f4 = 0.0f;
        if (this.mQg == 1 || this.mQg == 2) {
            f4 = this.resources.getDimension(R.dimen.ds40);
        } else if (this.mQg == 4) {
            f4 = this.resources.getDimension(R.dimen.ds40) + this.resources.getDimension(R.dimen.ds60) + this.resources.getDimension(R.dimen.ds16);
        }
        this.mQd = (int) (((int) ((l.getScreenDimensions(this.mContext)[0] - f4) - ((int) this.resources.getDimension(R.dimen.ds4)))) * 0.75f);
        this.mQe = (int) (this.mQd / f3);
    }

    private void a(AdCard.d[] dVarArr, int i) {
        ItemType itemType;
        if (a(dVarArr)) {
            itemType = ItemType.WITH_BOTTOM_TITLE;
        } else {
            itemType = ItemType.WITHOUT_BOTTOM_TITLE;
        }
        try {
            boolean z = false;
            for (AdCard.d dVar : dVarArr) {
                View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.loop_ad_item, (ViewGroup) null);
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
            TbImageView tbImageView = (TbImageView) view.findViewById(R.id.loop_image_view);
            TextView textView = (TextView) view.findViewById(R.id.loop_text_view);
            o(tbImageView, this.mQd, this.mQe);
            o(view, this.mQd, -2);
            if (this.mQc != null) {
                this.mQc.b(tbImageView, dVar.mOl);
            }
            tbImageView.startLoad(dVar.pic, i, false);
            if (itemType == ItemType.WITHOUT_BOTTOM_TITLE) {
                textView.setText("");
                textView.setVisibility(8);
            } else if (itemType == ItemType.WITH_BOTTOM_TITLE) {
                textView.setVisibility(0);
                if (this.mQc != null) {
                    textView.setText(this.mQc.RI(dVar.title));
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

    public void bxN() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt != null) {
                ao.setViewTextColor((TextView) childAt.findViewById(R.id.loop_text_view), R.color.CAM_X0105, 1);
            }
        }
    }

    public void setOnClickCallbackListener(a aVar) {
        this.mQc = aVar;
    }

    private void reset() {
        removeAllViews();
    }

    private void o(View view, int i, int i2) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = i;
            layoutParams.height = i2;
            return;
        }
        view.setLayoutParams(new LinearLayout.LayoutParams(i, i2));
    }
}
