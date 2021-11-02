package com.baidu.tieba.newinterest.viewholder;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class InterestedForumStyleATitleViewHolder extends TypeAdapter.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView mInterestedTitleContent;
    public TbImageView mInterestedTitleIcon;
    public LinearLayout mInterestedTitleRootview;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InterestedForumStyleATitleViewHolder(View view) {
        super(view);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((View) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mInterestedTitleRootview = (LinearLayout) view.findViewById(R.id.interested_title_rootview);
        this.mInterestedTitleIcon = (TbImageView) view.findViewById(R.id.interested_title_icon);
        this.mInterestedTitleContent = (TextView) view.findViewById(R.id.interested_title_content);
    }
}
