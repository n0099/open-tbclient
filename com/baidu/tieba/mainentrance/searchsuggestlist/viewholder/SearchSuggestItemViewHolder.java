package com.baidu.tieba.mainentrance.searchsuggestlist.viewholder;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.widget.RankStarView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes13.dex */
public class SearchSuggestItemViewHolder extends TypeAdapter.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View mRootView;
    public TbImageView mSearchItemcardBarIcon;
    public TextView mSearchItemcardScore;
    public TextView mSearchItemcardTags;
    public TextView mSearchItemcardTitle;
    public View mSearchSuggetLine;
    public RankStarView mStarView;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SearchSuggestItemViewHolder(View view) {
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
        this.mSearchItemcardBarIcon = (TbImageView) view.findViewById(R.id.search_itemcard_bar_icon);
        this.mSearchItemcardTitle = (TextView) view.findViewById(R.id.search_itemcard_title);
        this.mSearchItemcardScore = (TextView) view.findViewById(R.id.search_itemcard_score);
        this.mSearchItemcardTags = (TextView) view.findViewById(R.id.search_itemcard_tags);
        this.mStarView = (RankStarView) view.findViewById(R.id.search_itemcard_score_star);
        this.mSearchSuggetLine = view.findViewById(R.id.search_sugget_line);
    }
}
