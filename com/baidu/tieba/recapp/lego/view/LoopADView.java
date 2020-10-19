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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.recapp.lego.model.AdCard;
/* loaded from: classes26.dex */
public class LoopADView extends LinearLayout {
    private Context mContext;
    private a mdV;
    private int mdW;
    private int mdX;
    private AdCard.d[] mdY;
    private int mdZ;
    private Resources resources;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes26.dex */
    public enum ItemType {
        WITH_BOTTOM_TITLE,
        WITHOUT_BOTTOM_TITLE
    }

    /* loaded from: classes26.dex */
    public interface a {
        String QK(String str);

        void b(TbImageView tbImageView, AdCard.b bVar);

        void reset();
    }

    public void setBussinessType(int i) {
        this.mdZ = i;
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
        this.mdV = null;
        this.mdW = 0;
        this.mdX = 0;
        this.resources = null;
        this.mdY = null;
        this.mContext = context.getApplicationContext();
        this.resources = this.mContext.getResources();
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        setLayoutParams(layoutParams);
        setOrientation(0);
    }

    public void a(AdCard.d[] dVarArr, int i, int i2, int i3, int i4) {
        if (dVarArr != null && dVarArr.length > 0 && i3 <= i2 && dVarArr != this.mdY) {
            this.mdY = dVarArr;
            if (i2 == 0 || i3 == 0) {
                if (this.mdZ == 2 || this.mdZ == 1) {
                    i2 = (int) this.resources.getDimension(R.dimen.ds570);
                    i3 = (int) this.resources.getDimension(R.dimen.ds302);
                } else if (this.mdZ == 4) {
                    i2 = (int) this.resources.getDimension(R.dimen.ds500);
                    i3 = (int) this.resources.getDimension(R.dimen.ds265);
                }
            }
            c(i2, i3, i4);
            if (this.mdV != null) {
                this.mdV.reset();
            }
            reset();
            a(dVarArr, i);
        }
    }

    private void c(float f, float f2, int i) {
        float f3 = f / f2;
        float f4 = 0.0f;
        if (this.mdZ == 1 || this.mdZ == 2) {
            f4 = this.resources.getDimension(R.dimen.ds40);
        } else if (this.mdZ == 4) {
            f4 = this.resources.getDimension(R.dimen.ds40) + this.resources.getDimension(R.dimen.ds60) + this.resources.getDimension(R.dimen.ds16);
        }
        this.mdW = (int) (((int) ((l.getScreenDimensions(this.mContext)[0] - f4) - ((int) this.resources.getDimension(R.dimen.ds4)))) * 0.75f);
        this.mdX = (int) (this.mdW / f3);
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
            i(tbImageView, this.mdW, this.mdX);
            i(view, this.mdW, -2);
            if (this.mdV != null) {
                this.mdV.b(tbImageView, dVar.mcb);
            }
            tbImageView.startLoad(dVar.pic, i, false);
            if (itemType == ItemType.WITHOUT_BOTTOM_TITLE) {
                textView.setText("");
                textView.setVisibility(8);
            } else if (itemType == ItemType.WITH_BOTTOM_TITLE) {
                textView.setVisibility(0);
                if (this.mdV != null) {
                    textView.setText(this.mdV.QK(dVar.title));
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

    public void changeSkin() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt != null) {
                ap.setViewTextColor((TextView) childAt.findViewById(R.id.loop_text_view), R.color.cp_cont_b, 1);
            }
        }
    }

    public void setOnClickCallbackListener(a aVar) {
        this.mdV = aVar;
    }

    private void reset() {
        removeAllViews();
    }

    private void i(View view, int i, int i2) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = i;
            layoutParams.height = i2;
            return;
        }
        view.setLayoutParams(new LinearLayout.LayoutParams(i, i2));
    }
}
