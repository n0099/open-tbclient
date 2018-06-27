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
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class LocationInfoWithDelView extends LinearLayout implements View.OnClickListener {
    private a huA;
    private LocationInfoView huy;
    private ImageView huz;
    private int mSkinType;

    /* loaded from: classes3.dex */
    public interface a {
        void bHI();

        void bHJ();
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
        this.huy = new LocationInfoView(getContext());
        this.huy.setMaxEms(4);
        this.huy.setPadding(0, 0, 0, 0);
        addView(this.huy, new LinearLayout.LayoutParams(-2, -2));
        this.huz = new ImageView(getContext());
        this.huz.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.huz.setPadding(dimensionPixelSize, 0, dimensionPixelSize, 0);
        addView(this.huz, new LinearLayout.LayoutParams(dimensionPixelSize * 3, dimensionPixelSize));
        this.huz.setOnClickListener(this);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        hide();
    }

    public void onChangeSkinType(int i) {
        this.huy.onChangeSkinType(i);
        if (this.mSkinType != i) {
            am.i(this, d.f.state_switch_bg);
            am.c(this.huz, d.f.icon_edit_close_n);
            this.mSkinType = i;
        }
    }

    public void setState(int i, String str) {
        if (!StringUtils.isNull(str) || (StringUtils.isNull(str) && i == 1)) {
            if (str != null && str.contains("·")) {
                int indexOf = str.indexOf("·");
                str = str.substring(0, indexOf) + str.substring(indexOf + 1, str.length());
            }
            this.huy.setState(i, str);
            setVisibility(0);
            return;
        }
        hide();
    }

    public void hide() {
        setVisibility(8);
    }

    public void setLocationClickListener(a aVar) {
        this.huA = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.huA != null) {
            if (view == this.huz) {
                this.huA.bHJ();
            } else if (view == this) {
                this.huA.bHI();
            }
        }
    }
}
