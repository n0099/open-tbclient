package com.baidu.tieba.write.editor;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.editortools.editorinfotool.LocationInfoView;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class LocationInfoWithDelView extends LinearLayout implements View.OnClickListener {
    private LocationInfoView het;
    private ImageView heu;
    private a hev;
    private int mSkinType;

    /* loaded from: classes3.dex */
    public interface a {
        void bCb();

        void bCc();
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
        this.het = new LocationInfoView(getContext());
        this.het.setMaxEms(4);
        this.het.setPadding(0, 0, 0, 0);
        addView(this.het, new LinearLayout.LayoutParams(-2, -2));
        this.heu = new ImageView(getContext());
        this.heu.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.heu.setPadding(dimensionPixelSize, 0, dimensionPixelSize, 0);
        addView(this.heu, new LinearLayout.LayoutParams(dimensionPixelSize * 3, dimensionPixelSize));
        this.heu.setOnClickListener(this);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        hide();
    }

    public void onChangeSkinType(int i) {
        this.het.onChangeSkinType(i);
        if (this.mSkinType != i) {
            ak.i(this, d.f.state_switch_bg);
            ak.c(this.heu, d.f.icon_edit_close_n);
            this.mSkinType = i;
        }
    }

    public void setState(int i, String str) {
        if (!StringUtils.isNull(str) || (StringUtils.isNull(str) && i == 1)) {
            if (str != null && str.contains("·")) {
                int indexOf = str.indexOf("·");
                str = str.substring(0, indexOf) + str.substring(indexOf + 1, str.length());
            }
            this.het.setState(i, str);
            setVisibility(0);
            return;
        }
        hide();
    }

    public void hide() {
        setVisibility(8);
    }

    public void setLocationClickListener(a aVar) {
        this.hev = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        if (this.hev != null) {
            if (view2 == this.heu) {
                this.hev.bCc();
            } else if (view2 == this) {
                this.hev.bCb();
            }
        }
    }
}
