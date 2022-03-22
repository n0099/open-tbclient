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
/* loaded from: classes5.dex */
public class SearchSuggestRankingViewHolder extends TypeAdapter.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f34374b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f34375c;

    /* renamed from: d  reason: collision with root package name */
    public View f34376d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SearchSuggestRankingViewHolder(View view) {
        super(view);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((View) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = view.findViewById(R.id.obfuscated_res_0x7f091aef);
        this.f34374b = (TextView) view.findViewById(R.id.obfuscated_res_0x7f091c43);
        this.f34375c = (ImageView) view.findViewById(R.id.obfuscated_res_0x7f091c42);
        this.f34376d = view.findViewById(R.id.obfuscated_res_0x7f091c49);
    }
}
