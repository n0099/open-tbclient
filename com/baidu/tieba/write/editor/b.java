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
    private LocationInfoView hhb;
    private ImageView hhc;
    private a hhd;
    private int mSkinType;

    /* loaded from: classes2.dex */
    public interface a {
        void bGK();

        void bGL();
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
        this.hhb = new LocationInfoView(getContext());
        this.hhb.setMaxEms(4);
        this.hhb.setPadding(0, 0, 0, 0);
        addView(this.hhb, new LinearLayout.LayoutParams(-2, -2));
        this.hhc = new ImageView(getContext());
        this.hhc.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.hhc.setPadding(dimensionPixelSize, 0, dimensionPixelSize, 0);
        addView(this.hhc, new LinearLayout.LayoutParams(dimensionPixelSize * 3, dimensionPixelSize));
        this.hhc.setOnClickListener(this);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        hide();
    }

    public void onChangeSkinType(int i) {
        this.hhb.onChangeSkinType(i);
        if (this.mSkinType != i) {
            aj.j(this, d.f.state_switch_bg);
            aj.c(this.hhc, d.f.icon_edit_close_n);
            this.mSkinType = i;
        }
    }

    public void k(int i, String str) {
        if (!StringUtils.isNull(str) || (StringUtils.isNull(str) && i == 1)) {
            if (str != null && str.contains("·")) {
                int indexOf = str.indexOf("·");
                str = str.substring(0, indexOf) + str.substring(indexOf + 1, str.length());
            }
            this.hhb.k(i, str);
            setVisibility(0);
            return;
        }
        hide();
    }

    public void hide() {
        setVisibility(8);
    }

    public void setLocationClickListener(a aVar) {
        this.hhd = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.hhd != null) {
            if (view == this.hhc) {
                this.hhd.bGL();
            } else if (view == this) {
                this.hhd.bGK();
            }
        }
    }
}
