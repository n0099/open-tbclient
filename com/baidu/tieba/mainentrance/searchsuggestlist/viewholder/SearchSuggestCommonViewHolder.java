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
/* loaded from: classes4.dex */
public class SearchSuggestCommonViewHolder extends TypeAdapter.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public View f18500a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f18501b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f18502c;

    /* renamed from: d  reason: collision with root package name */
    public View f18503d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SearchSuggestCommonViewHolder(View view) {
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
        this.f18500a = view.findViewById(R.id.rootview);
        this.f18501b = (TextView) view.findViewById(R.id.search_suggest_title);
        this.f18502c = (ImageView) view.findViewById(R.id.search_bar_icon);
        this.f18503d = view.findViewById(R.id.search_sugget_line);
    }
}
