package com.baidu.tieba.mainentrance.searchsuggestlist.viewholder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes13.dex */
public class SearchSuggestRankingViewHolder extends TypeAdapter.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View mRootView;
    public ImageView mSearchBarIcon;
    public View mSearchSuggetLine;
    public TextView mSuggest;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SearchSuggestRankingViewHolder(View view) {
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
        this.mSuggest = (TextView) view.findViewById(R.id.search_ranking_title);
        this.mSearchBarIcon = (ImageView) view.findViewById(R.id.search_ranking_bar_icon);
        this.mSearchSuggetLine = view.findViewById(R.id.search_sugget_line);
    }
}
