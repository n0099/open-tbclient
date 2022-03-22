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
/* loaded from: classes5.dex */
public class SearchSuggestForumViewHolder extends TypeAdapter.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View a;

    /* renamed from: b  reason: collision with root package name */
    public TbImageView f34356b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f34357c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f34358d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f34359e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f34360f;

    /* renamed from: g  reason: collision with root package name */
    public View f34361g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SearchSuggestForumViewHolder(View view) {
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
        this.f34356b = (TbImageView) view.findViewById(R.id.obfuscated_res_0x7f091c27);
        this.f34357c = (TextView) view.findViewById(R.id.obfuscated_res_0x7f091c2a);
        this.f34358d = (TextView) view.findViewById(R.id.obfuscated_res_0x7f091c28);
        this.f34359e = (TextView) view.findViewById(R.id.obfuscated_res_0x7f091c26);
        this.f34360f = (TextView) view.findViewById(R.id.obfuscated_res_0x7f091c29);
        this.f34361g = view.findViewById(R.id.obfuscated_res_0x7f091c49);
    }
}
