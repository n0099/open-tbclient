package com.baidu.tieba.memberCenter.tail.management;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class b {
    private ImageView lsK;
    private TextView lsL;
    private Context mContext;
    private View mRootView;

    public void EG(int i) {
        this.lsL.setText(String.format(this.mContext.getString(R.string.tail_management_available), Integer.valueOf(i)));
    }

    public void I(View.OnClickListener onClickListener) {
        this.lsK.setOnClickListener(onClickListener);
    }

    public View gB(Context context) {
        this.mContext = context;
        this.mRootView = LayoutInflater.from(context).inflate(R.layout.tail_management_add_item, (ViewGroup) null);
        this.mRootView.setTag(this);
        this.lsL = (TextView) this.mRootView.findViewById(R.id.tail_management_new_text);
        this.lsK = (ImageView) this.mRootView.findViewById(R.id.tail_management_new_button);
        return this.mRootView;
    }

    public void D(TbPageContext<?> tbPageContext) {
        tbPageContext.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        tbPageContext.getLayoutMode().onModeChanged(this.mRootView);
    }
}
