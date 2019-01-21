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
    private LocationInfoView hYd;
    private ImageView hYe;
    private a hYf;
    private int mSkinType;

    /* loaded from: classes3.dex */
    public interface a {
        void bPC();

        void bPD();
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
        this.hYd = new LocationInfoView(getContext());
        this.hYd.setMaxEms(4);
        this.hYd.setPadding(0, 0, 0, 0);
        addView(this.hYd, new LinearLayout.LayoutParams(-2, -2));
        this.hYe = new ImageView(getContext());
        this.hYe.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.hYe.setPadding(dimensionPixelSize, 0, dimensionPixelSize, 0);
        addView(this.hYe, new LinearLayout.LayoutParams(dimensionPixelSize * 3, dimensionPixelSize));
        this.hYe.setOnClickListener(this);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        hide();
    }

    public void onChangeSkinType(int i) {
        this.hYd.onChangeSkinType(i);
        if (this.mSkinType != i) {
            al.i(this, e.f.state_switch_bg);
            al.c(this.hYe, e.f.icon_edit_close_n);
            this.mSkinType = i;
        }
    }

    public void setState(int i, String str) {
        if (!StringUtils.isNull(str) || (StringUtils.isNull(str) && i == 1)) {
            if (str != null && str.contains("·")) {
                int indexOf = str.indexOf("·");
                str = str.substring(0, indexOf) + str.substring(indexOf + 1, str.length());
            }
            this.hYd.setState(i, str);
            setVisibility(0);
            return;
        }
        hide();
    }

    public void hide() {
        setVisibility(8);
    }

    public void setLocationClickListener(a aVar) {
        this.hYf = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.hYf != null) {
            if (view == this.hYe) {
                this.hYf.bPD();
            } else if (view == this) {
                this.hYf.bPC();
            }
        }
    }
}
