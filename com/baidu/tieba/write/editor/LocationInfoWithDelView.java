package com.baidu.tieba.write.editor;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.editortools.editorinfotool.LocationInfoView;
import com.baidu.tieba.R;
/* loaded from: classes13.dex */
public class LocationInfoWithDelView extends LinearLayout implements View.OnClickListener {
    private ImageView fXx;
    private LocationInfoView kOv;
    private a kOw;
    private int mSkinType;

    /* loaded from: classes13.dex */
    public interface a {
        void cUO();

        void cUP();
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
        this.kOv = new LocationInfoView(getContext());
        this.kOv.setMaxEms(4);
        this.kOv.setPadding(0, 0, 0, 0);
        addView(this.kOv, new LinearLayout.LayoutParams(-2, -2));
        this.fXx = new ImageView(getContext());
        this.fXx.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.fXx.setPadding(dimensionPixelSize, 0, dimensionPixelSize, 0);
        addView(this.fXx, new LinearLayout.LayoutParams(dimensionPixelSize * 3, dimensionPixelSize));
        this.fXx.setOnClickListener(this);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        hide();
    }

    public void onChangeSkinType(int i) {
        this.kOv.onChangeSkinType(i);
        if (this.mSkinType != i) {
            am.c(this, l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds26), R.color.cp_bg_line_j, R.color.cp_bg_line_j_alpha50);
            SvgManager.aGC().a(this.fXx, R.drawable.icon_pure_close12_svg, R.color.cp_cont_d, (SvgManager.SvgResourceStateType) null);
            this.mSkinType = i;
        }
    }

    public void setState(int i, String str) {
        if (!StringUtils.isNull(str) || (StringUtils.isNull(str) && i == 1)) {
            if (str != null && str.contains("·")) {
                int indexOf = str.indexOf("·");
                str = str.substring(0, indexOf) + str.substring(indexOf + 1, str.length());
            }
            this.kOv.setState(i, str);
            setVisibility(0);
            return;
        }
        hide();
    }

    public void hide() {
        setVisibility(8);
    }

    public void setLocationClickListener(a aVar) {
        this.kOw = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.kOw != null) {
            if (view == this.fXx) {
                this.kOw.cUP();
            } else if (view == this) {
                this.kOw.cUO();
            }
        }
    }
}
