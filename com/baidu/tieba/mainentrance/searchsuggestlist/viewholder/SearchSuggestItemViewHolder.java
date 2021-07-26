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
/* loaded from: classes4.dex */
public class SearchSuggestItemViewHolder extends TypeAdapter.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public View f18511a;

    /* renamed from: b  reason: collision with root package name */
    public TbImageView f18512b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f18513c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f18514d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f18515e;

    /* renamed from: f  reason: collision with root package name */
    public RankStarView f18516f;

    /* renamed from: g  reason: collision with root package name */
    public View f18517g;

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
        this.f18511a = view.findViewById(R.id.rootview);
        this.f18512b = (TbImageView) view.findViewById(R.id.search_itemcard_bar_icon);
        this.f18513c = (TextView) view.findViewById(R.id.search_itemcard_title);
        this.f18514d = (TextView) view.findViewById(R.id.search_itemcard_score);
        this.f18515e = (TextView) view.findViewById(R.id.search_itemcard_tags);
        this.f18516f = (RankStarView) view.findViewById(R.id.search_itemcard_score_star);
        this.f18517g = view.findViewById(R.id.search_sugget_line);
    }
}
