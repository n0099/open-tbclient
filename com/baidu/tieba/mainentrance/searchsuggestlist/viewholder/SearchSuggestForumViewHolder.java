package com.baidu.tieba.mainentrance.searchsuggestlist.viewholder;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
public class SearchSuggestForumViewHolder extends TypeAdapter.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View mRootView;
    public TextView mSearchForumAttentionContent;
    public TbImageView mSearchForumBarIcon;
    public TextView mSearchForumIntroduce;
    public TextView mSearchForumPbContent;
    public TextView mSearchForumTitle;
    public View mSearchSuggetLine;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SearchSuggestForumViewHolder(View view) {
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
        this.mRootView = view.findViewById(R.id.rootview);
        this.mSearchForumBarIcon = (TbImageView) view.findViewById(R.id.search_forum_bar_icon);
        this.mSearchForumTitle = (TextView) view.findViewById(R.id.search_forum_title);
        this.mSearchForumIntroduce = (TextView) view.findViewById(R.id.search_forum_introduce);
        this.mSearchForumAttentionContent = (TextView) view.findViewById(R.id.search_forum_attention_content);
        this.mSearchForumPbContent = (TextView) view.findViewById(R.id.search_forum_pb_content);
        this.mSearchSuggetLine = view.findViewById(R.id.search_sugget_line);
    }
}
