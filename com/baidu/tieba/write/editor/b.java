package com.baidu.tieba.write.editor;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.editortools.editorinfotool.LocationInfoView;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class b extends LinearLayout implements View.OnClickListener {
    private LocationInfoView hGp;
    private ImageView hGq;
    private a hGr;
    private int mSkinType;

    /* loaded from: classes2.dex */
    public interface a {
        void bGM();

        void bGN();
    }

    public b(Context context) {
        this(context, null);
    }

    public b(Context context, AttributeSet attributeSet) {
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
        this.hGp = new LocationInfoView(getContext());
        this.hGp.setMaxEms(4);
        this.hGp.setPadding(0, 0, 0, 0);
        addView(this.hGp, new LinearLayout.LayoutParams(-2, -2));
        this.hGq = new ImageView(getContext());
        this.hGq.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.hGq.setPadding(dimensionPixelSize, 0, dimensionPixelSize, 0);
        addView(this.hGq, new LinearLayout.LayoutParams(dimensionPixelSize * 3, dimensionPixelSize));
        this.hGq.setOnClickListener(this);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        hide();
    }

    public void onChangeSkinType(int i) {
        this.hGp.onChangeSkinType(i);
        if (this.mSkinType != i) {
            aj.s(this, d.f.state_switch_bg);
            aj.c(this.hGq, d.f.icon_edit_close_n);
            this.mSkinType = i;
        }
    }

    public void j(int i, String str) {
        if (!StringUtils.isNull(str) || (StringUtils.isNull(str) && i == 1)) {
            if (str != null && str.contains("·")) {
                int indexOf = str.indexOf("·");
                str = str.substring(0, indexOf) + str.substring(indexOf + 1, str.length());
            }
            this.hGp.j(i, str);
            setVisibility(0);
            return;
        }
        hide();
    }

    public void hide() {
        setVisibility(8);
    }

    public void setLocationClickListener(a aVar) {
        this.hGr = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.hGr != null) {
            if (view == this.hGq) {
                this.hGr.bGN();
            } else if (view == this) {
                this.hGr.bGM();
            }
        }
    }
}
