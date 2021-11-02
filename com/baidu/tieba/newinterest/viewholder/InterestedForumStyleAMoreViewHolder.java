package com.baidu.tieba.newinterest.viewholder;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class InterestedForumStyleAMoreViewHolder extends TypeAdapter.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View mInterestedMoreDivide;
    public LinearLayout mInterestedMoreRootview;
    public TextView mInterestedMoreTitle;
    public View mInterestedMoreTitleInstead;
    public LinearLayout mInterestedMoreTitleLl;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InterestedForumStyleAMoreViewHolder(View view) {
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
        this.mInterestedMoreRootview = (LinearLayout) view.findViewById(R.id.interested_more_rootview);
        this.mInterestedMoreTitleLl = (LinearLayout) view.findViewById(R.id.interested_more_title_ll);
        this.mInterestedMoreTitle = (TextView) view.findViewById(R.id.interested_more_title);
        this.mInterestedMoreDivide = view.findViewById(R.id.interested_more_divide);
        this.mInterestedMoreTitleInstead = view.findViewById(R.id.interested_more_title_instead);
    }
}
