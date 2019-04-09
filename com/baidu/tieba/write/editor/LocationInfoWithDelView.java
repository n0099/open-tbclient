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
    private ImageView eEK;
    private LocationInfoView joD;
    private a joE;
    private int mSkinType;

    /* loaded from: classes3.dex */
    public interface a {
        void cpu();

        void cpv();
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
        this.joD = new LocationInfoView(getContext());
        this.joD.setMaxEms(4);
        this.joD.setPadding(0, 0, 0, 0);
        addView(this.joD, new LinearLayout.LayoutParams(-2, -2));
        this.eEK = new ImageView(getContext());
        this.eEK.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.eEK.setPadding(dimensionPixelSize, 0, dimensionPixelSize, 0);
        addView(this.eEK, new LinearLayout.LayoutParams(dimensionPixelSize * 3, dimensionPixelSize));
        this.eEK.setOnClickListener(this);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        hide();
    }

    public void onChangeSkinType(int i) {
        this.joD.onChangeSkinType(i);
        if (this.mSkinType != i) {
            al.k(this, d.f.state_switch_bg);
            al.c(this.eEK, d.f.icon_edit_close_n);
            this.mSkinType = i;
        }
    }

    public void setState(int i, String str) {
        if (!StringUtils.isNull(str) || (StringUtils.isNull(str) && i == 1)) {
            if (str != null && str.contains("·")) {
                int indexOf = str.indexOf("·");
                str = str.substring(0, indexOf) + str.substring(indexOf + 1, str.length());
            }
            this.joD.setState(i, str);
            setVisibility(0);
            return;
        }
        hide();
    }

    public void hide() {
        setVisibility(8);
    }

    public void setLocationClickListener(a aVar) {
        this.joE = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.joE != null) {
            if (view == this.eEK) {
                this.joE.cpv();
            } else if (view == this) {
                this.joE.cpu();
            }
        }
    }
}
