package com.baidu.tieba.write.editor;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.editortools.editorinfotool.LocationInfoView;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class LocationInfoWithDelView extends LinearLayout implements View.OnClickListener {
    private ImageView eFc;
    private LocationInfoView joV;
    private a joW;
    private int mSkinType;

    /* loaded from: classes3.dex */
    public interface a {
        void cpt();

        void cpu();
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
        this.joV = new LocationInfoView(getContext());
        this.joV.setMaxEms(4);
        this.joV.setPadding(0, 0, 0, 0);
        addView(this.joV, new LinearLayout.LayoutParams(-2, -2));
        this.eFc = new ImageView(getContext());
        this.eFc.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.eFc.setPadding(dimensionPixelSize, 0, dimensionPixelSize, 0);
        addView(this.eFc, new LinearLayout.LayoutParams(dimensionPixelSize * 3, dimensionPixelSize));
        this.eFc.setOnClickListener(this);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        hide();
    }

    public void onChangeSkinType(int i) {
        this.joV.onChangeSkinType(i);
        if (this.mSkinType != i) {
            al.k(this, d.f.state_switch_bg);
            al.c(this.eFc, d.f.icon_edit_close_n);
            this.mSkinType = i;
        }
    }

    public void setState(int i, String str) {
        if (!StringUtils.isNull(str) || (StringUtils.isNull(str) && i == 1)) {
            if (str != null && str.contains("·")) {
                int indexOf = str.indexOf("·");
                str = str.substring(0, indexOf) + str.substring(indexOf + 1, str.length());
            }
            this.joV.setState(i, str);
            setVisibility(0);
            return;
        }
        hide();
    }

    public void hide() {
        setVisibility(8);
    }

    public void setLocationClickListener(a aVar) {
        this.joW = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.joW != null) {
            if (view == this.eFc) {
                this.joW.cpu();
            } else if (view == this) {
                this.joW.cpt();
            }
        }
    }
}
