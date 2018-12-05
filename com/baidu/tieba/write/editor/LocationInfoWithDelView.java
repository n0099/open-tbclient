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
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class LocationInfoWithDelView extends LinearLayout implements View.OnClickListener {
    private LocationInfoView hTK;
    private ImageView hTL;
    private a hTM;
    private int mSkinType;

    /* loaded from: classes3.dex */
    public interface a {
        void bOe();

        void bOf();
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
        int dimensionPixelSize = getResources().getDimensionPixelSize(e.C0210e.ds24);
        setOrientation(0);
        setPadding(dimensionPixelSize, 0, 0, 0);
        setGravity(16);
        setOnClickListener(this);
        this.hTK = new LocationInfoView(getContext());
        this.hTK.setMaxEms(4);
        this.hTK.setPadding(0, 0, 0, 0);
        addView(this.hTK, new LinearLayout.LayoutParams(-2, -2));
        this.hTL = new ImageView(getContext());
        this.hTL.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.hTL.setPadding(dimensionPixelSize, 0, dimensionPixelSize, 0);
        addView(this.hTL, new LinearLayout.LayoutParams(dimensionPixelSize * 3, dimensionPixelSize));
        this.hTL.setOnClickListener(this);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        hide();
    }

    public void onChangeSkinType(int i) {
        this.hTK.onChangeSkinType(i);
        if (this.mSkinType != i) {
            al.i(this, e.f.state_switch_bg);
            al.c(this.hTL, e.f.icon_edit_close_n);
            this.mSkinType = i;
        }
    }

    public void setState(int i, String str) {
        if (!StringUtils.isNull(str) || (StringUtils.isNull(str) && i == 1)) {
            if (str != null && str.contains("·")) {
                int indexOf = str.indexOf("·");
                str = str.substring(0, indexOf) + str.substring(indexOf + 1, str.length());
            }
            this.hTK.setState(i, str);
            setVisibility(0);
            return;
        }
        hide();
    }

    public void hide() {
        setVisibility(8);
    }

    public void setLocationClickListener(a aVar) {
        this.hTM = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.hTM != null) {
            if (view == this.hTL) {
                this.hTM.bOf();
            } else if (view == this) {
                this.hTM.bOe();
            }
        }
    }
}
