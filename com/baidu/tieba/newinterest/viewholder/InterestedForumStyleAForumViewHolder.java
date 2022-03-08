package com.baidu.tieba.newinterest.viewholder;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class InterestedForumStyleAForumViewHolder extends TypeAdapter.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView mInterestedForumAttentionContent;
    public View mInterestedForumDivide;
    public BarImageView mInterestedForumIcon;
    public TextView mInterestedForumIntroduce;
    public TextView mInterestedForumPbContent;
    public LinearLayout mInterestedForumRootview;
    public ImageView mInterestedForumSelect;
    public TextView mInterestedForumTitle;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InterestedForumStyleAForumViewHolder(View view) {
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
        this.mInterestedForumRootview = (LinearLayout) view.findViewById(R.id.interested_forum_rootview);
        this.mInterestedForumIcon = (BarImageView) view.findViewById(R.id.interested_forum_icon);
        this.mInterestedForumTitle = (TextView) view.findViewById(R.id.interested_forum_title);
        this.mInterestedForumIntroduce = (TextView) view.findViewById(R.id.interested_forum_introduce);
        this.mInterestedForumAttentionContent = (TextView) view.findViewById(R.id.interested_forum_attention_content);
        this.mInterestedForumPbContent = (TextView) view.findViewById(R.id.interested_forum_pb_content);
        this.mInterestedForumDivide = view.findViewById(R.id.interested_forum_divide);
        this.mInterestedForumSelect = (ImageView) view.findViewById(R.id.interested_forum_select);
    }
}
