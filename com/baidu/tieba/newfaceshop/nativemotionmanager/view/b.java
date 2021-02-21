package com.baidu.tieba.newfaceshop.nativemotionmanager.view;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class b extends com.baidu.tieba.newfaceshop.nativemotionmanager.view.a.a {
    private TextView eHx;
    private ImageView lDO;
    private View rootView;

    public b(View view, String str) {
        this.rootView = view;
        this.eHx = (TextView) view.findViewById(R.id.emotion_empty_content);
        this.eHx.setText(str);
        this.lDO = (ImageView) view.findViewById(R.id.emotion_empty_icon);
        djl();
    }

    private void djl() {
        int i;
        int equipmentHeight = l.getEquipmentHeight(TbadkCoreApplication.getInst());
        if (equipmentHeight <= 0) {
            i = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds200);
        } else {
            i = (int) (equipmentHeight * 0.11d);
        }
        ViewGroup.LayoutParams layoutParams = this.lDO.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.topMargin = i;
            this.lDO.setLayoutParams(marginLayoutParams);
        }
    }

    @Override // com.baidu.tieba.newfaceshop.nativemotionmanager.view.a.a
    public View getView() {
        return this.rootView;
    }

    @Override // com.baidu.tieba.newfaceshop.nativemotionmanager.view.a.a
    public void onChangeSkinType(int i) {
        if (this.eHx != null) {
            ap.setViewTextColor(this.eHx, R.color.CAM_X0107, i);
        }
        if (this.lDO != null) {
            ap.setImageResource(this.lDO, R.drawable.new_pic_emotion_02, i);
        }
        if (this.rootView != null) {
            ap.setBackgroundColor(this.rootView, R.color.CAM_X0201, i);
        }
    }
}
