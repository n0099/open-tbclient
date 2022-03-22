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
/* loaded from: classes5.dex */
public class SearchSuggestItemViewHolder extends TypeAdapter.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View a;

    /* renamed from: b  reason: collision with root package name */
    public TbImageView f34362b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f34363c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f34364d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f34365e;

    /* renamed from: f  reason: collision with root package name */
    public RankStarView f34366f;

    /* renamed from: g  reason: collision with root package name */
    public View f34367g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SearchSuggestItemViewHolder(View view) {
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
        this.f34362b = (TbImageView) view.findViewById(R.id.obfuscated_res_0x7f091c36);
        this.f34363c = (TextView) view.findViewById(R.id.obfuscated_res_0x7f091c3a);
        this.f34364d = (TextView) view.findViewById(R.id.obfuscated_res_0x7f091c37);
        this.f34365e = (TextView) view.findViewById(R.id.obfuscated_res_0x7f091c39);
        this.f34366f = (RankStarView) view.findViewById(R.id.obfuscated_res_0x7f091c38);
        this.f34367g = view.findViewById(R.id.obfuscated_res_0x7f091c49);
    }
}
