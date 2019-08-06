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
    private ImageView eZU;
    private LocationInfoView jPS;
    private a jPT;
    private int mSkinType;

    /* loaded from: classes3.dex */
    public interface a {
        void cAU();

        void cAV();
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
        this.jPS = new LocationInfoView(getContext());
        this.jPS.setMaxEms(4);
        this.jPS.setPadding(0, 0, 0, 0);
        addView(this.jPS, new LinearLayout.LayoutParams(-2, -2));
        this.eZU = new ImageView(getContext());
        this.eZU.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.eZU.setPadding(dimensionPixelSize, 0, dimensionPixelSize, 0);
        addView(this.eZU, new LinearLayout.LayoutParams(dimensionPixelSize * 3, dimensionPixelSize));
        this.eZU.setOnClickListener(this);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        hide();
    }

    public void onChangeSkinType(int i) {
        this.jPS.onChangeSkinType(i);
        if (this.mSkinType != i) {
            am.k(this, R.drawable.state_switch_bg);
            am.c(this.eZU, (int) R.drawable.icon_edit_close_n);
            this.mSkinType = i;
        }
    }

    public void setState(int i, String str) {
        if (!StringUtils.isNull(str) || (StringUtils.isNull(str) && i == 1)) {
            if (str != null && str.contains("·")) {
                int indexOf = str.indexOf("·");
                str = str.substring(0, indexOf) + str.substring(indexOf + 1, str.length());
            }
            this.jPS.setState(i, str);
            setVisibility(0);
            return;
        }
        hide();
    }

    public void hide() {
        setVisibility(8);
    }

    public void setLocationClickListener(a aVar) {
        this.jPT = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.jPT != null) {
            if (view == this.eZU) {
                this.jPT.cAV();
            } else if (view == this) {
                this.jPT.cAU();
            }
        }
    }
}
