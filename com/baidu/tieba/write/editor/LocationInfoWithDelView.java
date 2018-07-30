package com.baidu.tieba.write.editor;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.editortools.editorinfotool.LocationInfoView;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class LocationInfoWithDelView extends LinearLayout implements View.OnClickListener {
    private LocationInfoView hvE;
    private ImageView hvF;
    private a hvG;
    private int mSkinType;

    /* loaded from: classes3.dex */
    public interface a {
        void bGt();

        void bGu();
    }

    public LocationInfoWithDelView(Context context) {
        this(context, null);
    }

    public LocationInfoWithDelView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        initUI();
    }

    private void initUI() {
        int dimensionPixelSize = getResources().getDimensionPixelSize(d.e.ds24);
        setOrientation(0);
        setPadding(dimensionPixelSize, 0, 0, 0);
        setGravity(16);
        setOnClickListener(this);
        this.hvE = new LocationInfoView(getContext());
        this.hvE.setMaxEms(4);
        this.hvE.setPadding(0, 0, 0, 0);
        addView(this.hvE, new LinearLayout.LayoutParams(-2, -2));
        this.hvF = new ImageView(getContext());
        this.hvF.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.hvF.setPadding(dimensionPixelSize, 0, dimensionPixelSize, 0);
        addView(this.hvF, new LinearLayout.LayoutParams(dimensionPixelSize * 3, dimensionPixelSize));
        this.hvF.setOnClickListener(this);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        hide();
    }

    public void onChangeSkinType(int i) {
        this.hvE.onChangeSkinType(i);
        if (this.mSkinType != i) {
            am.i(this, d.f.state_switch_bg);
            am.c(this.hvF, d.f.icon_edit_close_n);
            this.mSkinType = i;
        }
    }

    public void setState(int i, String str) {
        if (!StringUtils.isNull(str) || (StringUtils.isNull(str) && i == 1)) {
            if (str != null && str.contains("·")) {
                int indexOf = str.indexOf("·");
                str = str.substring(0, indexOf) + str.substring(indexOf + 1, str.length());
            }
            this.hvE.setState(i, str);
            setVisibility(0);
            return;
        }
        hide();
    }

    public void hide() {
        setVisibility(8);
    }

    public void setLocationClickListener(a aVar) {
        this.hvG = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.hvG != null) {
            if (view == this.hvF) {
                this.hvG.bGu();
            } else if (view == this) {
                this.hvG.bGt();
            }
        }
    }
}
