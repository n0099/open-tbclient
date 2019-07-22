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
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class LocationInfoWithDelView extends LinearLayout implements View.OnClickListener {
    private ImageView eZG;
    private LocationInfoView jOL;
    private a jOM;
    private int mSkinType;

    /* loaded from: classes3.dex */
    public interface a {
        void cAA();

        void cAz();
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
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.ds24);
        setOrientation(0);
        setPadding(dimensionPixelSize, 0, 0, 0);
        setGravity(16);
        setOnClickListener(this);
        this.jOL = new LocationInfoView(getContext());
        this.jOL.setMaxEms(4);
        this.jOL.setPadding(0, 0, 0, 0);
        addView(this.jOL, new LinearLayout.LayoutParams(-2, -2));
        this.eZG = new ImageView(getContext());
        this.eZG.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.eZG.setPadding(dimensionPixelSize, 0, dimensionPixelSize, 0);
        addView(this.eZG, new LinearLayout.LayoutParams(dimensionPixelSize * 3, dimensionPixelSize));
        this.eZG.setOnClickListener(this);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        hide();
    }

    public void onChangeSkinType(int i) {
        this.jOL.onChangeSkinType(i);
        if (this.mSkinType != i) {
            am.k(this, R.drawable.state_switch_bg);
            am.c(this.eZG, (int) R.drawable.icon_edit_close_n);
            this.mSkinType = i;
        }
    }

    public void setState(int i, String str) {
        if (!StringUtils.isNull(str) || (StringUtils.isNull(str) && i == 1)) {
            if (str != null && str.contains("·")) {
                int indexOf = str.indexOf("·");
                str = str.substring(0, indexOf) + str.substring(indexOf + 1, str.length());
            }
            this.jOL.setState(i, str);
            setVisibility(0);
            return;
        }
        hide();
    }

    public void hide() {
        setVisibility(8);
    }

    public void setLocationClickListener(a aVar) {
        this.jOM = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.jOM != null) {
            if (view == this.eZG) {
                this.jOM.cAA();
            } else if (view == this) {
                this.jOM.cAz();
            }
        }
    }
}
