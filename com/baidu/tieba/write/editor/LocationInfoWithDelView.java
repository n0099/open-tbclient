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
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class LocationInfoWithDelView extends LinearLayout implements View.OnClickListener {
    private ImageView eUE;
    private LocationInfoView jHF;
    private a jHG;
    private int mSkinType;

    /* loaded from: classes3.dex */
    public interface a {
        void cxA();

        void cxz();
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
        this.jHF = new LocationInfoView(getContext());
        this.jHF.setMaxEms(4);
        this.jHF.setPadding(0, 0, 0, 0);
        addView(this.jHF, new LinearLayout.LayoutParams(-2, -2));
        this.eUE = new ImageView(getContext());
        this.eUE.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.eUE.setPadding(dimensionPixelSize, 0, dimensionPixelSize, 0);
        addView(this.eUE, new LinearLayout.LayoutParams(dimensionPixelSize * 3, dimensionPixelSize));
        this.eUE.setOnClickListener(this);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        hide();
    }

    public void onChangeSkinType(int i) {
        this.jHF.onChangeSkinType(i);
        if (this.mSkinType != i) {
            al.k(this, R.drawable.state_switch_bg);
            al.c(this.eUE, (int) R.drawable.icon_edit_close_n);
            this.mSkinType = i;
        }
    }

    public void setState(int i, String str) {
        if (!StringUtils.isNull(str) || (StringUtils.isNull(str) && i == 1)) {
            if (str != null && str.contains("·")) {
                int indexOf = str.indexOf("·");
                str = str.substring(0, indexOf) + str.substring(indexOf + 1, str.length());
            }
            this.jHF.setState(i, str);
            setVisibility(0);
            return;
        }
        hide();
    }

    public void hide() {
        setVisibility(8);
    }

    public void setLocationClickListener(a aVar) {
        this.jHG = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.jHG != null) {
            if (view == this.eUE) {
                this.jHG.cxA();
            } else if (view == this) {
                this.jHG.cxz();
            }
        }
    }
}
