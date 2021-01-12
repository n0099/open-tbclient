package com.baidu.tieba.newfaceshop.nativemotionmanager.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class e {
    private View mHeaderView;
    private View rootView;
    private TextView title;

    public e(TbPageContext tbPageContext) {
        this.rootView = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.emotion_simple_header, (ViewGroup) null);
        this.mHeaderView = this.rootView.findViewById(R.id.emotion_manage_item_header);
        this.mHeaderView.setVisibility(8);
        this.title = (TextView) this.rootView.findViewById(R.id.emotion_manage_total_title);
    }

    public View getView() {
        return this.rootView;
    }

    public void onChangeSkinType(int i) {
        if (this.rootView != null) {
            ao.setBackgroundColor(this.rootView, R.color.cp_bg_line_d_alpha90, i);
        }
        if (this.mHeaderView != null) {
            ao.setBackgroundColor(this.mHeaderView, R.color.CAM_X0204, i);
        }
        if (this.title != null) {
            ao.setViewTextColor(this.title, R.color.CAM_X0107, i);
        }
    }

    public void s(final Integer num) {
        com.baidu.adp.lib.f.e.mB().post(new Runnable() { // from class: com.baidu.tieba.newfaceshop.nativemotionmanager.view.e.1
            @Override // java.lang.Runnable
            public void run() {
                if (num != null && num.intValue() != 0) {
                    e.this.mHeaderView.setVisibility(0);
                }
            }
        });
    }
}
