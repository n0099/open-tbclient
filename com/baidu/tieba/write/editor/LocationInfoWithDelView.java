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
    private LocationInfoView hKO;
    private ImageView hKP;
    private a hKQ;
    private int mSkinType;

    /* loaded from: classes3.dex */
    public interface a {
        void bMA();

        void bMz();
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
        int dimensionPixelSize = getResources().getDimensionPixelSize(e.C0175e.ds24);
        setOrientation(0);
        setPadding(dimensionPixelSize, 0, 0, 0);
        setGravity(16);
        setOnClickListener(this);
        this.hKO = new LocationInfoView(getContext());
        this.hKO.setMaxEms(4);
        this.hKO.setPadding(0, 0, 0, 0);
        addView(this.hKO, new LinearLayout.LayoutParams(-2, -2));
        this.hKP = new ImageView(getContext());
        this.hKP.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.hKP.setPadding(dimensionPixelSize, 0, dimensionPixelSize, 0);
        addView(this.hKP, new LinearLayout.LayoutParams(dimensionPixelSize * 3, dimensionPixelSize));
        this.hKP.setOnClickListener(this);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        hide();
    }

    public void onChangeSkinType(int i) {
        this.hKO.onChangeSkinType(i);
        if (this.mSkinType != i) {
            al.i(this, e.f.state_switch_bg);
            al.c(this.hKP, e.f.icon_edit_close_n);
            this.mSkinType = i;
        }
    }

    public void setState(int i, String str) {
        if (!StringUtils.isNull(str) || (StringUtils.isNull(str) && i == 1)) {
            if (str != null && str.contains("·")) {
                int indexOf = str.indexOf("·");
                str = str.substring(0, indexOf) + str.substring(indexOf + 1, str.length());
            }
            this.hKO.setState(i, str);
            setVisibility(0);
            return;
        }
        hide();
    }

    public void hide() {
        setVisibility(8);
    }

    public void setLocationClickListener(a aVar) {
        this.hKQ = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.hKQ != null) {
            if (view == this.hKP) {
                this.hKQ.bMA();
            } else if (view == this) {
                this.hKQ.bMz();
            }
        }
    }
}
