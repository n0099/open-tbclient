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
    private LocationInfoView hdp;
    private ImageView hdq;
    private a hdr;
    private int mSkinType;

    /* loaded from: classes3.dex */
    public interface a {
        void bCd();

        void bCe();
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
        this.hdp = new LocationInfoView(getContext());
        this.hdp.setMaxEms(4);
        this.hdp.setPadding(0, 0, 0, 0);
        addView(this.hdp, new LinearLayout.LayoutParams(-2, -2));
        this.hdq = new ImageView(getContext());
        this.hdq.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.hdq.setPadding(dimensionPixelSize, 0, dimensionPixelSize, 0);
        addView(this.hdq, new LinearLayout.LayoutParams(dimensionPixelSize * 3, dimensionPixelSize));
        this.hdq.setOnClickListener(this);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        hide();
    }

    public void onChangeSkinType(int i) {
        this.hdp.onChangeSkinType(i);
        if (this.mSkinType != i) {
            ak.i(this, d.f.state_switch_bg);
            ak.c(this.hdq, d.f.icon_edit_close_n);
            this.mSkinType = i;
        }
    }

    public void setState(int i, String str) {
        if (!StringUtils.isNull(str) || (StringUtils.isNull(str) && i == 1)) {
            if (str != null && str.contains("·")) {
                int indexOf = str.indexOf("·");
                str = str.substring(0, indexOf) + str.substring(indexOf + 1, str.length());
            }
            this.hdp.setState(i, str);
            setVisibility(0);
            return;
        }
        hide();
    }

    public void hide() {
        setVisibility(8);
    }

    public void setLocationClickListener(a aVar) {
        this.hdr = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        if (this.hdr != null) {
            if (view2 == this.hdq) {
                this.hdr.bCe();
            } else if (view2 == this) {
                this.hdr.bCd();
            }
        }
    }
}
