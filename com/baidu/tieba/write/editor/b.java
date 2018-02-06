package com.baidu.tieba.write.editor;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.editortools.editorinfotool.LocationInfoView;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class b extends LinearLayout implements View.OnClickListener {
    private LocationInfoView hGC;
    private ImageView hGD;
    private a hGE;
    private int mSkinType;

    /* loaded from: classes2.dex */
    public interface a {
        void bGN();

        void bGO();
    }

    public b(Context context) {
        this(context, null);
    }

    public b(Context context, AttributeSet attributeSet) {
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
        this.hGC = new LocationInfoView(getContext());
        this.hGC.setMaxEms(4);
        this.hGC.setPadding(0, 0, 0, 0);
        addView(this.hGC, new LinearLayout.LayoutParams(-2, -2));
        this.hGD = new ImageView(getContext());
        this.hGD.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.hGD.setPadding(dimensionPixelSize, 0, dimensionPixelSize, 0);
        addView(this.hGD, new LinearLayout.LayoutParams(dimensionPixelSize * 3, dimensionPixelSize));
        this.hGD.setOnClickListener(this);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        hide();
    }

    public void onChangeSkinType(int i) {
        this.hGC.onChangeSkinType(i);
        if (this.mSkinType != i) {
            aj.s(this, d.f.state_switch_bg);
            aj.c(this.hGD, d.f.icon_edit_close_n);
            this.mSkinType = i;
        }
    }

    public void j(int i, String str) {
        if (!StringUtils.isNull(str) || (StringUtils.isNull(str) && i == 1)) {
            if (str != null && str.contains("·")) {
                int indexOf = str.indexOf("·");
                str = str.substring(0, indexOf) + str.substring(indexOf + 1, str.length());
            }
            this.hGC.j(i, str);
            setVisibility(0);
            return;
        }
        hide();
    }

    public void hide() {
        setVisibility(8);
    }

    public void setLocationClickListener(a aVar) {
        this.hGE = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.hGE != null) {
            if (view == this.hGD) {
                this.hGE.bGO();
            } else if (view == this) {
                this.hGE.bGN();
            }
        }
    }
}
