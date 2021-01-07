package com.baidu.tieba.newfaceshop.nativemotionmanager.view;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class b extends com.baidu.tieba.newfaceshop.nativemotionmanager.view.a.a {
    private TextView eKc;
    private ImageView lAc;
    private View rootView;

    public b(View view, String str) {
        this.rootView = view;
        this.eKc = (TextView) view.findViewById(R.id.emotion_empty_content);
        this.eKc.setText(str);
        this.lAc = (ImageView) view.findViewById(R.id.emotion_empty_icon);
        dkV();
    }

    private void dkV() {
        int i;
        int equipmentHeight = l.getEquipmentHeight(TbadkCoreApplication.getInst());
        if (equipmentHeight <= 0) {
            i = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds200);
        } else {
            i = (int) (equipmentHeight * 0.11d);
        }
        ViewGroup.LayoutParams layoutParams = this.lAc.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.topMargin = i;
            this.lAc.setLayoutParams(marginLayoutParams);
        }
    }

    @Override // com.baidu.tieba.newfaceshop.nativemotionmanager.view.a.a
    public View getView() {
        return this.rootView;
    }

    @Override // com.baidu.tieba.newfaceshop.nativemotionmanager.view.a.a
    public void onChangeSkinType(int i) {
        if (this.eKc != null) {
            ao.setViewTextColor(this.eKc, R.color.CAM_X0107, i);
        }
        if (this.lAc != null) {
            ao.setImageResource(this.lAc, R.drawable.new_pic_emotion_02, i);
        }
        if (this.rootView != null) {
            ao.setBackgroundColor(this.rootView, R.color.CAM_X0201, i);
        }
    }
}
