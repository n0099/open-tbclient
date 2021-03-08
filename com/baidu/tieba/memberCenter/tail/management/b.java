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
/* loaded from: classes8.dex */
public class b {
    private ImageView lvb;
    private TextView lvc;
    private Context mContext;
    private View mRootView;

    public void EJ(int i) {
        this.lvc.setText(String.format(this.mContext.getString(R.string.tail_management_available), Integer.valueOf(i)));
    }

    public void J(View.OnClickListener onClickListener) {
        this.lvb.setOnClickListener(onClickListener);
    }

    public View gA(Context context) {
        this.mContext = context;
        this.mRootView = LayoutInflater.from(context).inflate(R.layout.tail_management_add_item, (ViewGroup) null);
        this.mRootView.setTag(this);
        this.lvc = (TextView) this.mRootView.findViewById(R.id.tail_management_new_text);
        this.lvb = (ImageView) this.mRootView.findViewById(R.id.tail_management_new_button);
        return this.mRootView;
    }

    public void D(TbPageContext<?> tbPageContext) {
        tbPageContext.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        tbPageContext.getLayoutMode().onModeChanged(this.mRootView);
    }
}
