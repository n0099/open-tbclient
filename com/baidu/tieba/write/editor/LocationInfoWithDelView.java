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
/* loaded from: classes3.dex */
public class LocationInfoWithDelView extends LinearLayout implements View.OnClickListener {
    private ImageView fdu;
    private LocationInfoView jPi;
    private a jPj;
    private int mSkinType;

    /* loaded from: classes3.dex */
    public interface a {
        void cyq();

        void cyr();
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
        this.jPi = new LocationInfoView(getContext());
        this.jPi.setMaxEms(4);
        this.jPi.setPadding(0, 0, 0, 0);
        addView(this.jPi, new LinearLayout.LayoutParams(-2, -2));
        this.fdu = new ImageView(getContext());
        this.fdu.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.fdu.setPadding(dimensionPixelSize, 0, dimensionPixelSize, 0);
        addView(this.fdu, new LinearLayout.LayoutParams(dimensionPixelSize * 3, dimensionPixelSize));
        this.fdu.setOnClickListener(this);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        hide();
    }

    public void onChangeSkinType(int i) {
        this.jPi.onChangeSkinType(i);
        if (this.mSkinType != i) {
            am.e(this, l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds26), R.color.cp_bg_line_j, R.color.cp_bg_line_j_alpha50);
            SvgManager.amL().a(this.fdu, R.drawable.icon_pure_close12_n_svg, R.color.cp_cont_f, null);
            this.mSkinType = i;
        }
    }

    public void setState(int i, String str) {
        if (!StringUtils.isNull(str) || (StringUtils.isNull(str) && i == 1)) {
            if (str != null && str.contains("·")) {
                int indexOf = str.indexOf("·");
                str = str.substring(0, indexOf) + str.substring(indexOf + 1, str.length());
            }
            this.jPi.setState(i, str);
            setVisibility(0);
            return;
        }
        hide();
    }

    public void hide() {
        setVisibility(8);
    }

    public void setLocationClickListener(a aVar) {
        this.jPj = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.jPj != null) {
            if (view == this.fdu) {
                this.jPj.cyr();
            } else if (view == this) {
                this.jPj.cyq();
            }
        }
    }
}
