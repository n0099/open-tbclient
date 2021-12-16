package com.baidu.tieba.mainentrance.searchsuggestlist.viewholder;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes12.dex */
public class SearchSuggestLiveViewHolder extends TypeAdapter.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView mLivingText;
    public View mRootView;
    public View mSearchSuggetLine;
    public TextView mSuggest;
    public ImageView searchBarIcon;
    public FrameLayout searchLiveLayout;
    public TBLottieAnimationView searchLiveLottieView;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SearchSuggestLiveViewHolder(View view) {
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
        this.mSuggest = (TextView) view.findViewById(R.id.search_suggest_title);
        this.searchBarIcon = (ImageView) view.findViewById(R.id.search_bar_icon);
        this.searchLiveLottieView = (TBLottieAnimationView) view.findViewById(R.id.search_live_lottie);
        this.searchLiveLayout = (FrameLayout) view.findViewById(R.id.search_live_layout);
        this.mLivingText = (TextView) view.findViewById(R.id.living_text);
        this.mSearchSuggetLine = view.findViewById(R.id.search_sugget_line);
    }
}
