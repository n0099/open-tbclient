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
/* loaded from: classes7.dex */
public class SearchSuggestItemViewHolder extends TypeAdapter.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View a;
    public TbImageView b;
    public TextView c;
    public TextView d;
    public TextView e;
    public RankStarView f;
    public View g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SearchSuggestItemViewHolder(View view2) {
        super(view2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view2};
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
        this.a = view2.findViewById(R.id.obfuscated_res_0x7f092082);
        this.b = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f0921ff);
        this.c = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092203);
        this.d = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092200);
        this.e = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092202);
        this.f = (RankStarView) view2.findViewById(R.id.obfuscated_res_0x7f092201);
        this.g = view2.findViewById(R.id.obfuscated_res_0x7f092215);
    }
}
