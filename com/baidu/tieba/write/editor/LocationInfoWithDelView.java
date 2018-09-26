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
    private LocationInfoView hDB;
    private ImageView hDC;
    private a hDD;
    private int mSkinType;

    /* loaded from: classes3.dex */
    public interface a {
        void bJn();

        void bJo();
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
        int dimensionPixelSize = getResources().getDimensionPixelSize(e.C0141e.ds24);
        setOrientation(0);
        setPadding(dimensionPixelSize, 0, 0, 0);
        setGravity(16);
        setOnClickListener(this);
        this.hDB = new LocationInfoView(getContext());
        this.hDB.setMaxEms(4);
        this.hDB.setPadding(0, 0, 0, 0);
        addView(this.hDB, new LinearLayout.LayoutParams(-2, -2));
        this.hDC = new ImageView(getContext());
        this.hDC.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.hDC.setPadding(dimensionPixelSize, 0, dimensionPixelSize, 0);
        addView(this.hDC, new LinearLayout.LayoutParams(dimensionPixelSize * 3, dimensionPixelSize));
        this.hDC.setOnClickListener(this);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        hide();
    }

    public void onChangeSkinType(int i) {
        this.hDB.onChangeSkinType(i);
        if (this.mSkinType != i) {
            al.i(this, e.f.state_switch_bg);
            al.c(this.hDC, e.f.icon_edit_close_n);
            this.mSkinType = i;
        }
    }

    public void setState(int i, String str) {
        if (!StringUtils.isNull(str) || (StringUtils.isNull(str) && i == 1)) {
            if (str != null && str.contains("·")) {
                int indexOf = str.indexOf("·");
                str = str.substring(0, indexOf) + str.substring(indexOf + 1, str.length());
            }
            this.hDB.setState(i, str);
            setVisibility(0);
            return;
        }
        hide();
    }

    public void hide() {
        setVisibility(8);
    }

    public void setLocationClickListener(a aVar) {
        this.hDD = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.hDD != null) {
            if (view == this.hDC) {
                this.hDD.bJo();
            } else if (view == this) {
                this.hDD.bJn();
            }
        }
    }
}
